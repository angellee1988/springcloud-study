package org.lee.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.lee.springcloud.model.Storage;

public interface StorageMapper extends BaseMapper<Storage> {

    @Update("update storage_tbl set count=count-#{count} where id=#{id}")
    Integer decrease(@Param("id") Integer id, @Param("count") Integer count);
}
