package com.poetrygame.service;

import com.poetrygame.pojo.cityAndBuilding;

/**
 * @Author: zzw
 * @Date: 2023/2/14
 * @Time: 13:30
 * @Description:
 */
public interface cityAndBuildingService {

    // 在城市建筑关联表中取出城市建筑ID，建筑ID
    cityAndBuilding getCityAndBuilding();
    // 用户第一次玩游戏,从地图进入,根据城市ID和建筑ID查出城市建筑ID
    Integer getCityBuildingId(Integer cityId,Integer buildingId);
    // 根据city_building_id去城市建筑关联表里找到city_id
    Integer getCityId(Integer cityBuildingId);
}
