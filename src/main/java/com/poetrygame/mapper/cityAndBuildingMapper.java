package com.poetrygame.mapper;

import com.poetrygame.pojo.cityAndBuilding;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/14
 * @Time: 12:58
 * @Description:
 */
@Mapper
public interface cityAndBuildingMapper {

    // 在城市建筑关联表中取出城市建筑ID，建筑ID
    cityAndBuilding cityAndBuilding();
    // 用户第一次玩游戏,从地图进入,根据城市ID和建筑ID查出城市建筑ID
    Integer cityBuildingId(Integer cityId,Integer buildingId);
    // 根据city_building_id去城市建筑关联表里找到city_id
    Integer cityId(Integer cityBuildingId);
}
