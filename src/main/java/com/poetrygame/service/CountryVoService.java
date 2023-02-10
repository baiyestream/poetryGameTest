package com.poetrygame.service;

import com.poetrygame.pojo.countryMap;
import com.poetrygame.vo.CountryVO;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 8:31
 * @Description:
 */
public interface CountryVoService {

    // 查找国家地图上有城市的坐标点,带有云服务器保存图片的地址
    List<CountryVO> getCityPoint();
    // 查找图片在云服务器上的位置
    String getPictureLocation();
    // 查找国家地图上的6个坐标
    countryMap getPoint();
}
