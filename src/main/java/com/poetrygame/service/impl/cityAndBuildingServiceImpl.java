package com.poetrygame.service.impl;

import com.poetrygame.mapper.cityAndBuildingMapper;
import com.poetrygame.pojo.cityAndBuilding;
import com.poetrygame.service.cityAndBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/14
 * @Time: 13:32
 * @Description:
 */
@Service
public class cityAndBuildingServiceImpl implements cityAndBuildingService {

    @Autowired
    private cityAndBuildingMapper cityAndBuildingMapper;

    // 在城市建筑关联表中取出城市建筑ID，建筑ID
    @Override
    public cityAndBuilding getCityAndBuilding() {
        return cityAndBuildingMapper.cityAndBuilding();
    }
    // 用户第一次玩游戏,从地图进入,根据城市ID和建筑ID查出城市建筑ID
    @Override
    public Integer getCityBuildingId(Integer cityId,Integer buildingId) {
        return cityAndBuildingMapper.cityBuildingId(cityId,buildingId);
    }
    // 根据city_building_id去城市建筑关联表里找到city_id
    @Override
    public Integer getCityId(Integer cityBuildingId) {
        return cityAndBuildingMapper.cityId(cityBuildingId);
    }
}
