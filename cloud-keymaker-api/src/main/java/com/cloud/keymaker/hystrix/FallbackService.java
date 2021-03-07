package com.cloud.keymaker.hystrix;

import com.cloud.keymaker.feign.IpFeignService;
import com.cloud.keymaker.feign.StatisticFeignService;
import com.cloud.keymaker.feign.UuidFeignService;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;

/**
 * @PackageName: com.cloud.keymaker.hystrix
 * @ClassName: FallbackService
 * @Description: This is FallbackService class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-07 0:17
 */
public class FallbackService implements IpFeignService, StatisticFeignService, UuidFeignService {
    @Override
    public Result addCount(Long aid) {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result create(int num) {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result discovery() {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result getServiceInfo() {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result select(String ip) {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }
}
