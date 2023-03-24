package com.poetrygame.service.impl;

import com.poetrygame.mapper.CityMapMapper;
import com.poetrygame.service.cityMapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 9:32
 * @Description:
 */
@Service
public class cityMapServiceImpl implements cityMapService {

    @Resource
    private CityMapMapper cityMapMapper;

    //  根据城市ID查出城市名称
    @Override
    public String getCityName(Integer cityId) {
        return cityMapMapper.cityName(cityId);
    }
}
