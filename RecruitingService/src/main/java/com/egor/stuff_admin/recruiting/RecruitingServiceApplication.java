package com.egor.stuff_admin.recruiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RecruitingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecruitingServiceApplication.class, args);
    }
}
