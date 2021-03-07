package com.cloud.keymaker.feign;

import com.cloud.keymaker.config.FeignConfig;
import com.cloud.keymaker.hystrix.ApiFallbackService;
import com.cloud.keymaker.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @PackageName: com.cloud.keymaker.feign
 * @ClassName: ParameterFeignService
 * @Description: This is ParameterFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-07 21:48
 */
@Component
@FeignClient(value = "cloud-keymaker-service-parameter", fallback = ApiFallbackService.class, configuration = FeignConfig.class)
public interface ParameterFeignService {
    @RequestMapping("/v1/api/parameter/discovery")
    public Result discovery();

    @RequestMapping("/v1/api/parameter/getServiceInfo")
    public Result getServiceInfo();

    @RequestMapping("/v1/api/parameter/listApiParameter")
    public Result listApiParameter(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sortName") String sortName, @RequestParam("sortType") String sortType,  @RequestParam("aid") Long aid,@RequestParam("type") int type, @RequestParam("state") int state);
}
