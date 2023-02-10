package com.poetrygame.service.impl;

import com.poetrygame.mapper.BuildingVoMapper;
import com.poetrygame.pojo.cityMap;
import com.poetrygame.service.BuildingVoService;
import com.poetrygame.vo.BuildingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 15:01
 * @Description:
 */
@Service
public class BuildingVoServiceImpl implements BuildingVoService {

    @Autowired
    private BuildingVoMapper buildingVoMapper;

    // 查找图片在云服务器上的位置
    @Override
    public String getPictureLocation() {
        return buildingVoMapper.pictureLocation();
    }
    // 查找城市地图上有建筑的坐标点,横轴坐标，纵轴坐标，建筑ID
    @Override
    public List<BuildingVO> getBuildingPoint(Integer cityId) {
        return buildingVoMapper.buildingPoint(cityId);
    }
    // 查找城市地图上的6个坐标
    @Override
    public cityMap getPoint(Integer cityId) {
        return buildingVoMapper.point(cityId);
    }
}
