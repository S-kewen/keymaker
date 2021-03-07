package com.cloud.keymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.keymaker
 * @ClassName: ParameterServiceMain9020
 * @Description: This is ParameterServiceMain9020 class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-07 21:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ParameterServiceMain9020 {
    public static void main(String[] args) {
        SpringApplication.run(ParameterServiceMain9020.class, args);
        System.out.println("ParameterServiceMain9020-启动完毕!");
    }
}
