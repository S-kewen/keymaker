package com.cloud.keymaker.service.impl;

import com.cloud.keymaker.dao.ApiDao;
import com.cloud.keymaker.entity.Api;
import com.cloud.keymaker.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.service.impl
 * @ClassName: ApiServiceImpl
 * @Description: This is ApiServiceImpl class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 18:23
 */
@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private ApiDao dao;
    @Override
    public List<Map<String, Object>> getList(Api api) {
        return dao.getList(api);
    }

    @Override
    public int insertOne(Api api) {
        return dao.insertOne(api);
    }

    @Override
    public int deleteOne(Api api) {
        return dao.deleteOne(api);
    }

    @Override
    public int updateOne(Api api) {
        return dao.updateOne(api);
    }

    @Override
    public int getCount(Api api) {
        return dao.getCount(api);
    }

    @Override
    public Api getById(Long id) {
        return dao.getById(id);
    }
}
