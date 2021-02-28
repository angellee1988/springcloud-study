package org.lee.springcloud.seata.service;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.lee.springcloud.seata.dao.OrderDAO;
import org.lee.springcloud.seata.feign.AccountFeignClient;
import org.lee.springcloud.seata.feign.StorageFeignClient;
import org.lee.springcloud.seata.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private StorageFeignClient storageFeignClient;
    @Autowired
    private AccountFeignClient accountFeignClient;

    /**
     * 创建订单
     * <p>
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     *
     * @param order
     * @return
     */
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->交易开始");
        //本地方法
        orderDAO.create(order);

        //远程方法 扣减库存
        storageFeignClient.decrease(order.getProductId(), order.getCount());

        //远程方法 扣减账户余额
        log.info("------->扣减账户开始order中");
        accountFeignClient.decrease(order.getUserId(), order.getMoney());
        log.info("------->扣减账户结束order中");

        log.info("------->交易结束");
    }

    /**
     * 修改订单状态
     */
    public void update(Long userId, BigDecimal money, Integer status) {
        log.info("修改订单状态，入参为：userId={},money={},status={}", userId, money, status);
        orderDAO.update(userId, money, status);
    }
}
