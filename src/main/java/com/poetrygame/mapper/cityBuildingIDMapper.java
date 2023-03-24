package com.poetrygame.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/1
 * @Time: 9:53
 * @Description:
 */
@Mapper
public interface cityBuildingIDMapper {

    List<Integer> cityBuildingID(Integer cityId);
}
