package com.cloud.keymaker.service;

import com.cloud.keymaker.entity.ApiParameter;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.service
 * @ClassName: ApiParameterService
 * @Description: This is ApiParameterService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-07 21:36
 */
public interface ApiParameterService {
    List<Map<String, Object>> getList(ApiParameter apiParameter);

    int insertOne(ApiParameter apiParameter);

    int deleteOne(ApiParameter apiParameter);

    int updateOne(ApiParameter apiParameter);

    int getCount(ApiParameter apiParameter);
}
