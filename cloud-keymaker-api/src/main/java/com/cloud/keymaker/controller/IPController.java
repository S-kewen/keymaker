package com.cloud.keymaker.controller;


import cn.hutool.extra.servlet.ServletUtil;
import com.cloud.keymaker.feign.IpFeignService;
import com.cloud.keymaker.feign.StatisticFeignService;
import com.cloud.keymaker.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: IPController
 * @Description: This is IPController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 23:32
 */
@RestController
@RequestMapping("/v1/api/open/ip")
public class IPController {
    private final Long aid = 2L;

    @Autowired
    private StatisticFeignService statisticFeignService;

    @Autowired
    private IpFeignService ipFeignService;

    @Autowired
    private HttpServletRequest httpServletRequest;
    @RequestMapping("discovery")
    public Result discovery() {
        //服务发现
        return ipFeignService.discovery();
    }

    @RequestMapping("getServiceInfo")
    public Result getServiceInfo() {
        return ipFeignService.getServiceInfo();
    }

    @RequestMapping("select")
    public Result select(String ip) {
        if (ip==null || ip==""){
            ip= ServletUtil.getClientIP(httpServletRequest);
        }
        addCount();
        return ipFeignService.select(ip);
    }

    private Result addCount() {
        return statisticFeignService.addCount(aid);
    }
}
