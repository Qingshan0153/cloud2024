package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 李京霖
 * @version 2024/5/2 23:57 1.0
 */


@SpringBootApplication
@EnableDiscoveryClient
public class PayMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMain9001.class,args);
    }
}
