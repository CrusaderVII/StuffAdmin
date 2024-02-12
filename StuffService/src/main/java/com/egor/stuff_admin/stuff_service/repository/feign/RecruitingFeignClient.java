package com.egor.stuff_admin.stuff_service.repository.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("recruiting-service")
public interface RecruitingFeignClient {

    @PostMapping(value = "stuff-admin/api/v1/recruit/requirement/save",
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCandidates(@RequestParam String department, @RequestParam int priority);
}
