package org.lee.springcloud.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("storage_tbl")
public class Storage {
    private Integer id;
    private String commodityCode;
    private Integer count;
}
