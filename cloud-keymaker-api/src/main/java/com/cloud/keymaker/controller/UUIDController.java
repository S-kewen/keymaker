package com.cloud.keymaker.controller;

import com.cloud.keymaker.feign.StatisticFeignService;
import com.cloud.keymaker.feign.UuidFeignService;
import com.cloud.keymaker.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: UUIDController
 * @Description: This is UUIDController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 21:43
 */
@RestController
@RequestMapping("/v1/api/open/uuid")
public class UUIDController {
    private final Long aid = 1L;

    @Autowired
    private StatisticFeignService statisticFeignService;

    @Autowired
    private UuidFeignService uuidFeignService;

    @RequestMapping("discovery")
    public Result discovery() {
        //服务发现
        return uuidFeignService.discovery();
    }

    @RequestMapping("getServiceInfo")
    public Result getServiceInfo() {
        return uuidFeignService.getServiceInfo();
    }

    @RequestMapping("create")
    public Result create(@RequestParam(required = false, defaultValue = "1") int num) {
        addCount();
        return uuidFeignService.create(num);
    }

    private Result addCount() {
        return statisticFeignService.addCount(aid);
    }
}
