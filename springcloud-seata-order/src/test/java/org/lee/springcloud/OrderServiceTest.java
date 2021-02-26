package org.lee.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @Test
    public void testCreateOrder() {

        orderService.createOrder(1, 6, 50, 3);
    }

}
