package com.poetrygame.service.impl;

import com.poetrygame.mapper.CountryMapMapper;
import com.poetrygame.service.CountryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/20
 * @Time: 10:06
 * @Description:
 */
@Service
public class CountryMapServiceImpl implements CountryMapService {

    @Autowired
    private CountryMapMapper countryMapMapper;

    // 根据国家id获取国家名称
    @Override
    public String getCountryName(Integer countryId) {
        return countryMapMapper.countryName(countryId);
    }
}
