package com.cloud.keymaker.service.impl;

import com.cloud.keymaker.dao.ApiDao;
import com.cloud.keymaker.entity.Api;
import com.cloud.keymaker.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
    @Cacheable(cacheNames = "apiListCache")
    public List<Map<String, Object>> getList(int page, int size, Api api) {
        return dao.getList(api);
    }

    @Override
    @CacheEvict(value = "apiListCache")
    public int insertOne(Api api) {
        return dao.insertOne(api);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "apiCache", key = "'api_'+#api.id"),
                    @CacheEvict(value = "apiListCache")
            }
    )
    public int deleteOne(Api api) {
        return dao.deleteOne(api);
    }

    @Override
    @Caching(
            put = {
                    @CachePut(value = "apiCache", key = "'api_'+#api.id")
            }, evict = {
            @CacheEvict(value = "apiListCache"),
            @CacheEvict(value = "apiCountCache"),
    }
    )
    public int updateOne(Api api) {
        return dao.updateOne(api);
    }

    @Override
    @Cacheable(value = "apiCountCache")
    public int getCount(Api api) {
        return dao.getCount(api);
    }

    @Override
    @Cacheable(value = "apiCache", key = "'api_'+#id")
    public Api getById(Long id) {
        return dao.getById(id);
    }
}
