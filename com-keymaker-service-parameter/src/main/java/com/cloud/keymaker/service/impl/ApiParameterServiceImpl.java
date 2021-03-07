package com.cloud.keymaker.service.impl;

import com.cloud.keymaker.dao.ApiParameterDao;
import com.cloud.keymaker.entity.ApiParameter;
import com.cloud.keymaker.service.ApiParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.service.impl
 * @ClassName: ApiParameterServiceImpl
 * @Description: This is ApiParameterServiceImpl class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-07 21:35
 */
@Service
public class ApiParameterServiceImpl implements ApiParameterService {
    @Autowired
    private ApiParameterDao dao;
    @Override
    public List<Map<String, Object>> getList(ApiParameter apiParameter) {
        return dao.getList(apiParameter);
    }

    @Override
    public int insertOne(ApiParameter apiParameter) {
        return dao.insertOne(apiParameter);
    }

    @Override
    public int deleteOne(ApiParameter apiParameter) {
        return dao.deleteOne(apiParameter);
    }

    @Override
    public int updateOne(ApiParameter apiParameter) {
        return dao.updateOne(apiParameter);
    }

    @Override
    public int getCount(ApiParameter apiParameter) {
        return dao.getCount(apiParameter);
    }
}
