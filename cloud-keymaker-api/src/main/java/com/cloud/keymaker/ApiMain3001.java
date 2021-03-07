package com.cloud.keymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PackageName: com.cloud.keymaker
 * @ClassName: ApiMain3001
 * @Description: This is ApiMain3001 class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 21:49
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ApiMain3001 {
    public static void main(String[] args) {
        SpringApplication.run(ApiMain3001.class, args);
        System.out.println("ApiMain3001-启动完毕!");
    }
}
