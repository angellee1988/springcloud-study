package org.lee.springcloud.seata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.springcloud.seata.model.Order;
import org.lee.springcloud.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServerApplicationTests {

	@Autowired
	OrderService orderService;

	@Test
	public void contextLoads() {

		Order order = new Order();
		order.setUserId(1L);
		order.setProductId(1L);
		order.setMoney(BigDecimal.valueOf(200));
		order.setStatus(0);
		order.setCount(10);
		orderService.create(order);
	}

}
