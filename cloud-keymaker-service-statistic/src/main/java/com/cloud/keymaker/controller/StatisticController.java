package com.cloud.keymaker.controller;

import cn.hutool.core.date.DateUtil;
import com.cloud.keymaker.entity.ApiStatistic;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;
import com.cloud.keymaker.service.ApiStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: StatisticController
 * @Description: This is StatisticController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 20:33
 */
@RestController
@RequestMapping("/v1/api/statistic")
public class StatisticController {
    @Autowired
    private ApiStatisticService apiStatisticService;
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String application;
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("discovery")
    public Result discovery() {
        //服务发现
        return new Result(StatusCode.OK, StatusMsg.OK, discoveryClient);
    }

    @RequestMapping("getServiceInfo")
    public Result getServiceInfo() throws UnknownHostException {
        Map<String, Object> map = new HashMap<>();
        map.put("application", application);
        map.put("ipv4", InetAddress.getLocalHost().getHostAddress());
        map.put("port", port);
        return new Result(StatusCode.OK, StatusMsg.OK, map);
    }

    @RequestMapping("addCount")
    public Result addCount(Long aid) {
        ApiStatistic apiStatistic = new ApiStatistic();
        apiStatistic.setAid(aid);
        apiStatistic.setStatistic_date(DateUtil.today());
        apiStatistic = apiStatisticService.selectOne(apiStatistic);
        if (apiStatistic != null) {
            int count = apiStatisticService.addCountById(apiStatistic.getId());
            if (count > 0) {
                return new Result(StatusCode.OK, StatusMsg.OK);
            }
            return new Result(StatusCode.UPDATEFAIL, StatusMsg.UPDATEFAIL);
        } else {
            apiStatistic = new ApiStatistic();
            apiStatistic.setAid(aid);
            apiStatistic.setCount(1L);
            apiStatistic.setStatistic_date(DateUtil.today());
            int count = apiStatisticService.insertOne(apiStatistic);
            if (count > 0) {
                return new Result(StatusCode.OK, StatusMsg.OK);
            }
            return new Result(StatusCode.INSERTFAIL, StatusMsg.INSERTFAIL);
        }
    }

    @RequestMapping("getSum")
    public Result getSum(Long aid, String date) {
        ApiStatistic apiStatistic = new ApiStatistic();
        apiStatistic.setAid(aid);
        apiStatistic.setStatistic_date(date);
        Long count = apiStatisticService.getSum(apiStatistic);
        return new Result(StatusCode.OK, StatusMsg.OK, count);
    }

}
