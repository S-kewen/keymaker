package com.cloud.keymaker.feign;

import com.cloud.keymaker.config.FeignConfig;
import com.cloud.keymaker.hystrix.FallbackService;
import com.cloud.keymaker.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @PackageName: com.cloud.keymaker.feign
 * @ClassName: StatisticFeignService
 * @Description: This is StatisticFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 21:45
 */
@Component
@FeignClient(value = "cloud-keymaker-service-statistic",fallback=FallbackService.class,configuration = FeignConfig.class)
public interface StatisticFeignService {
    @RequestMapping("/v1/api/statistic/discovery")
    public Result discovery();

    @RequestMapping("/v1/api/statistic/getServiceInfo")
    public Result getServiceInfo();

    @RequestMapping("/v1/api/statistic/addCount")
    public Result addCount(@RequestParam("aid") Long aid);
}
