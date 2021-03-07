package com.cloud.keymaker.hystrix;

import com.cloud.keymaker.feign.ApiFeignService;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;


/**
 * @PackageName: com.cloud.keymaker.hystrix
 * @ClassName: ConsoleFallbackService
 * @Description: This is ConsoleFallbackService class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 19:06
 */
public class ApiFallbackService implements ApiFeignService {
    @Override
    public Result discovery() {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result getServiceInfo() {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result listApi(int page, int size, String sortName, String sortType, int type, int state,String search) {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result getById(Long id) {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result getCount() {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }
}
