package com.poetrygame.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 9:18
 * @Description:
 */
@Mapper
public interface CityMapMapper {

    //  根据城市ID查出城市名称
    String cityName(Integer cityId);
}
