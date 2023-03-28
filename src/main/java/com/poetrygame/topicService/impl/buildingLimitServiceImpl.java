package com.poetrygame.topicService.impl;

import com.poetrygame.dto.getTopic.buildingLimit;
import com.poetrygame.mapper.dtoMapper.buildingLimitMapper;
import com.poetrygame.topicService.buildingLimitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/24
 * @Time: 14:40
 * @Description:
 */
@Service
public class buildingLimitServiceImpl implements buildingLimitService {

    @Resource
    private buildingLimitMapper buildingLimitMapper;

    @Override
    public List<buildingLimit> getBuildingLimitOne() {
        return buildingLimitMapper.buildingLimitOne();
    }

    @Override
    public Integer getBuildingLimitTwo() {
        return buildingLimitMapper.buildingLimitTwo();
    }

    @Override
    public Integer getBuildingLimitThree() {
        return buildingLimitMapper.buildingLimitThree();
    }

    @Override
    public Integer getBuildingLimitFour() {
        return buildingLimitMapper.buildingLimitFour();
    }


}
