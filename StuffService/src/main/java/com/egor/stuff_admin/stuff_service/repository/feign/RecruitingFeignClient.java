package com.egor.stuff_admin.stuff_service.repository.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("recruiting-service")
public interface RecruitingFeignClient {

    @GetMapping(value = "stuff-admin/api/v1/recruit/requirement",
                consumes = "application/json")
    public ResponseEntity<Object> getCandidates(@RequestParam String department);
}
