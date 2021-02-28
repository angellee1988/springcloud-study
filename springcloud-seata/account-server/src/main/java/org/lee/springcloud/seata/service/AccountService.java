package org.lee.springcloud.seata.service;

import lombok.extern.slf4j.Slf4j;
import org.lee.springcloud.seata.dao.AccountDAO;
import org.lee.springcloud.seata.feign.OrderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private OrderFeignClient orderFeignClient;

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->扣减账户开始account中");
        //模拟超时异常，全局事务回滚
//        try {
//            Thread.sleep(30*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDAO.decrease(userId, money);
        log.info("------->扣减账户结束account中");

        //修改订单状态，此调用会导致调用成环
        log.info("修改订单状态开始");
        String mes = orderFeignClient.update(userId, money.multiply(new BigDecimal("0.09")), 0);
        log.info("修改订单状态结束：{}", mes);
    }
}
