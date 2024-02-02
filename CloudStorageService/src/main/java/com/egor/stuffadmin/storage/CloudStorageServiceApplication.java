package com.egor.stuffadmin.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudStorageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStorageServiceApplication.class, args);
    }
}
