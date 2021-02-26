package org.lee.springcloud.service;

import org.lee.springcloud.client.StorageFeignClient;
import org.lee.springcloud.mapper.OrderMapper;
import org.lee.springcloud.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private StorageFeignClient storageFeignClient;
    @Resource
    private OrderMapper orderMapper;

    public void saveOrder(Integer userId, Integer productId,
                          Integer price, Integer count) {
        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setMoney(price);
        order.setCount(3);
        orderMapper.insert(order);
    }

    //    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public void createOrder(Integer userId, Integer productId,
                            Integer price, Integer count) {

        saveOrder(userId, productId, price, count);
        String res = storageFeignClient.decrease(productId, count);
        System.out.println(res);
    }
}
