package com.poetrygame.service.impl;

import com.poetrygame.mapper.cityCountryVoMapper;
import com.poetrygame.service.cityCountryVoService;
import com.poetrygame.vo.cityCountryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 9:02
 * @Description:
 */
@Service
public class cityCountryVoServiceImpl implements cityCountryVoService {

    @Autowired
    private cityCountryVoMapper countryVoMapper;
    //根据城市ID查出国家ID,国家名称

    @Override
    public cityCountryVo getCityAndCountry(Integer cityId) {
        return countryVoMapper.cityAndCountry(cityId);
    }
}
