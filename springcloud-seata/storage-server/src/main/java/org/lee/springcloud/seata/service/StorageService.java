package org.lee.springcloud.seata.service;

import lombok.extern.slf4j.Slf4j;
import org.lee.springcloud.seata.dao.StorageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageService {

    @Autowired
    private StorageDAO storageDAO;

    public void decrease(Long productId, Integer count) {
        storageDAO.decrease(productId, count);
    }
}
