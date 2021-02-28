package org.lee.springcloud.seata.dao;

import org.apache.ibatis.annotations.Param;
import org.lee.springcloud.seata.model.Order;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OrderDAO {

    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单金额
     * @param userId
     * @param money
     */
    void update(@Param("userId") Long userId, @Param("money") BigDecimal money, @Param("status") Integer status);
}
