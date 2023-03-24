package com.poetrygame.service.impl;

import com.poetrygame.mapper.buildingMapper;
import com.poetrygame.service.buildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/14
 * @Time: 13:50
 * @Description:
 */
@Service
public class buildingServiceImpl implements buildingService {

    @Autowired
    private buildingMapper buildingMapper;

    // 根据buildingId在建筑表中取出容纳的题目数
    @Override
    public Integer getTopicLimit(Integer buildingId) {
        return buildingMapper.topicLimit(buildingId);
    }
    // 根据buildingId取出建筑名称
    @Override
    public String getBuildingName(Integer buildingId) {
        return buildingMapper.buildingName(buildingId);
    }
}
