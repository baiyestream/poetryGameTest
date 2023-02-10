package com.poetrygame.mapper;

import com.poetrygame.pojo.cityMap;
import com.poetrygame.vo.BuildingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 14:17
 * @Description:
 */
@Mapper
public interface BuildingVoMapper {

    // 查找图片在云服务器上的位置
    String pictureLocation();
    // 查找城市地图上有建筑的坐标点,横轴坐标，纵轴坐标，建筑ID
    List<BuildingVO> buildingPoint(Integer cityId);
    // 查找城市地图上的6个坐标
    cityMap point(Integer cityId);
}
