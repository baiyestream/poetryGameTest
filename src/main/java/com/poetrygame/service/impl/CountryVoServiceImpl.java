package com.poetrygame.service.impl;


import com.poetrygame.mapper.CountryVoMapper;
import com.poetrygame.pojo.countryMap;
import com.poetrygame.service.CountryVoService;
import com.poetrygame.vo.CountryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 8:31
 * @Description:
 */
@Service
public class CountryVoServiceImpl implements CountryVoService {

    @Autowired
    private CountryVoMapper countryVoMapper;

    // 查找国家地图上有城市的坐标点
    @Override
    public List<CountryVO> getCityPoint() {
        return countryVoMapper.cityPoint();
    }
    // 查找图片在云服务器上的位置
    @Override
    public String getPictureLocation() {
        return countryVoMapper.pictureLocation();
    }
    // 查找国家地图上的6个坐标
    @Override
    public countryMap getPoint() {
        return countryVoMapper.point();
    }


}
