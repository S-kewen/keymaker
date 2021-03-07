package com.cloud.keymaker.service.impl;

import com.cloud.keymaker.dao.ApiStatisticDao;
import com.cloud.keymaker.entity.ApiStatistic;
import com.cloud.keymaker.service.ApiStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName: com.cloud.keymaker.service.impl
 * @ClassName: ApiStatisticServiceImpl
 * @Description: This is ApiStatisticServiceImpl class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 20:49
 */
@Service
public class ApiStatisticServiceImpl implements ApiStatisticService {
    @Autowired
    private ApiStatisticDao dao;
    @Override
    public int insertOne(ApiStatistic apiStatistic) {
        return dao.insertOne(apiStatistic);
    }

    @Override
    public int getCount(ApiStatistic apiStatistic) {
        return dao.getCount(apiStatistic);
    }

    @Override
    public Long getSum(ApiStatistic apiStatistic) {
        return dao.getSum(apiStatistic);
    }

    @Override
    public ApiStatistic selectOne(ApiStatistic apiStatistic) {
        return dao.selectOne(apiStatistic);
    }

    @Override
    public int addCountById(Long id) {
        return dao.addCountById(id);
    }
}
