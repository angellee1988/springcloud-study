package org.lee.springcloud.controller;

import org.lee.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("storage/decrease")
    public String decrease(@RequestParam Integer productId,
                           @RequestParam Integer count) {
        storageService.decrease(productId, count);
        return "ok";
    }

}
