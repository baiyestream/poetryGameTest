package com.poetrygame.topicService.impl;

import com.poetrygame.dto.cityBuilding;
import com.poetrygame.mapper.dtoMapper.cityBuildingMapper;
import com.poetrygame.topicService.cityBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/1
 * @Time: 15:26
 * @Description:
 */
@Service
public class cityBuildingServiceImpl implements cityBuildingService {

    @Autowired
    private cityBuildingMapper cityBuildingMapper;

    @Override
    public List<cityBuilding> getCityBuilding() {
        return cityBuildingMapper.cityBuildingTest();
    }
}
