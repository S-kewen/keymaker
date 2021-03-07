package com.cloud.keymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.keymaker
 * @ClassName: ConsoleServiceMain9001
 * @Description: This is ConsoleServiceMain9001 class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 18:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiServiceMain9001 {
     public static void main(String[] args) {
        SpringApplication.run(ApiServiceMain9001.class, args);
        System.out.println("ApiServiceMain9001-启动完毕!");
    }
}
