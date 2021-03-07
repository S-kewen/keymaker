package com.cloud.keymaker.controller;

import cn.hutool.core.date.DateUtil;
import com.cloud.keymaker.feign.ApiFeignService;
import com.cloud.keymaker.feign.ParameterFeignService;
import com.cloud.keymaker.feign.StatisticFeignService;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: ConsoleController
 * @Description: This is ConsoleController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 17:45
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/api/consumer/console")
public class ConsoleController {
    @Autowired
    private ApiFeignService apiFeignService;
    @Autowired
    private StatisticFeignService statisticFeignService;
    @Autowired
    private ParameterFeignService parameterFeignService;

    @RequestMapping("discovery")
    public Result discovery() {
        //服务发现
        return apiFeignService.discovery();
    }

    @RequestMapping("getServiceInfo")
    public Result getServiceInfo() throws UnknownHostException {
        return apiFeignService.getServiceInfo();
    }

    @RequestMapping("listApi")
    public Result listApi(String search) {
        return apiFeignService.listApi(1, 10000, "", "", 1, 1,search);
    }

    @RequestMapping("getApiInfo")
    public Result getById(Long id) {
        return apiFeignService.getById(id);
    }

    @RequestMapping("getStatistic")
    public Result getStatistic() {
        Map<String, Object> map = new HashMap<>();
        map.put("apiCount", apiFeignService.getCount());
        map.put("todayUse", statisticFeignService.getSum(null, DateUtil.today()));
        map.put("useCount", statisticFeignService.getSum(null, null));
        return new Result(StatusCode.OK, StatusMsg.OK, map);
    }

    @RequestMapping("getParameter")
    public Result getParameter(@RequestParam(required = true)Long aid) {
        if (aid<=0){
            return new Result(StatusCode.PARAMERROR, StatusMsg.PARAMERROR);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("request", parameterFeignService.listApiParameter(1, 10000, null, null, aid, 1, 1));
        map.put("response", parameterFeignService.listApiParameter(1, 10000, null, null, aid, 2, 1));
        return new Result(StatusCode.OK, StatusMsg.OK, map);
    }
}
