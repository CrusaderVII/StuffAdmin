package com.egor.stuffadmin.storage.controller;

import com.egor.stuffadmin.storage.service.StorageService;
import jakarta.ws.rs.HeaderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("stuff-admin/api/v1/cloud/storage")
public class MainController {

    @Autowired
    StorageService storageService;

    @PostMapping("/upload")
    @HeaderParam("Content-Type: multipart/form-data")
    public ResponseEntity<String> uploadPhoto (@RequestPart("file") MultipartFile file,
                                               @RequestParam("id") String id) {
        storageService.uploadFile(file, id);
        return new ResponseEntity<>("Uploaded successful", HttpStatus.OK);
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadPhoto (@RequestParam("id") String id) {
        return new ResponseEntity<>(storageService.downloadFile(id), HttpStatus.OK) ;
    }
}
