package com.poetrygame.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/20
 * @Time: 9:57
 * @Description:
 */
@Mapper
public interface CountryMapMapper {

    // 根据国家id获取国家名称
    String countryName(Integer countryId);
}
