package com.poetrygame.service.impl;

import com.poetrygame.mapper.cityBuildingIDMapper;
import com.poetrygame.service.cityBuildingIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/1
 * @Time: 9:59
 * @Description:
 */
@Service
public class cityBuildingIDServiceImpl implements cityBuildingIDService {

    @Autowired
    private cityBuildingIDMapper cityBuildingIDMapper;

    @Override
    public List<Integer> getCityBuildingID(Integer cityId) {
        return cityBuildingIDMapper.cityBuildingID(cityId);
    }
}
