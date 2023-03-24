package com.poetrygame.service;

/**
 * @Author: zzw
 * @Date: 2023/2/20
 * @Time: 10:04
 * @Description:
 */
public interface CountryMapService {

    // 根据国家id获取国家名称
    String getCountryName(Integer countryId);
}
