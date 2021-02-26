package org.lee.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.springcloud.mapper.StorageMapper;
import org.lee.springcloud.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StorgeMapperTest {
    @Resource
    StorageMapper storageMapper;

    @Test
    public void testInsert() {
        Storage storage = new Storage();
        storage.setId(100000);
        storage.setCommodityCode("Java");
        storage.setCount(100);
        storageMapper.insert(storage);
    }

    @Test
    public void testDecrease() {
        storageMapper.decrease(6, 2);
    }

}
