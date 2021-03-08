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
 * @ClassName: IPFeignService
 * @Description: This is IPFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 21:45
 */
@Component
@FeignClient(value = "cloud-keymaker-service-encrypt",fallback=FallbackService.class,configuration = FeignConfig.class)
public interface EncryptFeignService {
    @RequestMapping("/v1/api/open/encrypt/discovery")
    public Result discovery();

    @RequestMapping("/v1/api/open/encrypt/getServiceInfo")
    public Result getServiceInfo();

    @RequestMapping("/v1/api/open/encrypt/createRsaKey")
    public Result createRsaKey();
}
