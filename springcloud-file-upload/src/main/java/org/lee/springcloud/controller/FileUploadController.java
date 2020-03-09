package org.lee.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String fileUplaod(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException, InterruptedException {
        byte[] bytes = file.getBytes();
        File file2save = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, file2save);
        return file2save.getAbsolutePath();
    }


}
