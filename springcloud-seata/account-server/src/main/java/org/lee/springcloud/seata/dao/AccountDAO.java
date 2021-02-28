package org.lee.springcloud.seata.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface AccountDAO {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
