package com.egor.stuffadmin.storage.controller;

import com.egor.stuffadmin.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("stuff-admin/api/v1/cloud/storage")
public class MainController {

    @Autowired
    StorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPhoto (@RequestParam("file") MultipartFile file,
                                               @RequestParam("id") String id) {
        storageService.uploadFile(file, id);
        return new ResponseEntity<>("Uploaded successful", HttpStatus.OK);
    }
}
