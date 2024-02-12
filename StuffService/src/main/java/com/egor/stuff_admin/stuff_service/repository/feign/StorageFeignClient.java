package com.egor.stuff_admin.stuff_service.repository.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("cloud-storage-service")
public interface StorageFeignClient {

    @PostMapping(value = "stuff-admin/api/v1/cloud/storage/upload",
                 consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadPhoto (@RequestPart("file") MultipartFile file,
                                                 @RequestParam("id") String id);

}
