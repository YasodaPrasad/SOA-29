package com.scholarsphere.accessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccessserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessserviceApplication.class, args);
    }
}