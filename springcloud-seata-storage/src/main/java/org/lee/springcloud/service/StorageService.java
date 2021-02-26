package org.lee.springcloud.service;

import org.lee.springcloud.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {
    @Autowired
    private StorageMapper storageMapper;

    public Integer decrease(Integer id, Integer count) {
        return storageMapper.decrease(id, count);
    }
}
