package com.poetrygame.service;

import com.poetrygame.pojo.cityMap;
import com.poetrygame.vo.BuildingVO;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 14:59
 * @Description:
 */
public interface BuildingVoService {

    // 查找图片在云服务器上的位置
    String getPictureLocation();
    // 查找城市地图上有建筑的坐标点,横轴坐标，纵轴坐标，建筑ID
    List<BuildingVO> getBuildingPoint(Integer cityId);
    // 查找城市地图上的6个坐标
    cityMap getPoint(Integer cityId);
}
