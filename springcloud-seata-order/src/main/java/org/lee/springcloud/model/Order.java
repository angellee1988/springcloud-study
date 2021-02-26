package org.lee.springcloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_tbl")
public class Order {
    private Integer userId;
    private Integer productId;
    private Integer count;
    private Integer money;

}
