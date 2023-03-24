package com.poetrygame.service;

import com.poetrygame.vo.cityCountryVo;

/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 9:01
 * @Description:
 */
public interface cityCountryVoService {

    //根据城市ID查出国家ID,国家名称
    cityCountryVo getCityAndCountry(Integer cityId);
}
