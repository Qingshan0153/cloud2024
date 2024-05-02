package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 李京霖
 * @version 2024/5/2 2:00 1.0
 */


@SpringBootApplication
@MapperScan("com.study.cloud.mapper")
public class PayMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMain8001.class, args);
    }
}
