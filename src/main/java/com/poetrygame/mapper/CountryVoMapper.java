package com.poetrygame.mapper;

import com.poetrygame.pojo.countryMap;
import com.poetrygame.vo.CountryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 8:18
 * @Description:
 */
@Mapper
public interface CountryVoMapper {

    // 查找国家地图上有城市的坐标点,横轴坐标，纵轴坐标，城市ID
    List<CountryVO> cityPoint();
    // 查找图片在云服务器上的位置
    String pictureLocation();
    // 查找国家地图上的6个坐标
    countryMap point();

}
