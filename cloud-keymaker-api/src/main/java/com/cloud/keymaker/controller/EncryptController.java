package com.cloud.keymaker.controller;

import com.cloud.keymaker.feign.EncryptFeignService;
import com.cloud.keymaker.feign.StatisticFeignService;
import com.cloud.keymaker.feign.UuidFeignService;
import com.cloud.keymaker.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: EncryptController
 * @Description: This is EncryptController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-08 23:52
 */
@RestController
@RequestMapping("/v1/api/open/encrypt")
public class EncryptController {
    private final Long aid = 3L;

    @Autowired
    private StatisticFeignService statisticFeignService;

    @Autowired
    private EncryptFeignService encryptFeignService;

    @RequestMapping("discovery")
    public Result discovery() {
        //服务发现
        return encryptFeignService.discovery();
    }

    @RequestMapping("getServiceInfo")
    public Result getServiceInfo() {
        return encryptFeignService.getServiceInfo();
    }

    @RequestMapping("createRsaKey")
    public Result createRsaKey() {
        addCount();
        return encryptFeignService.createRsaKey();
    }

    private Result addCount() {
        return statisticFeignService.addCount(aid);
    }
}
