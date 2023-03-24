package com.poetrygame.topicService.impl;

import com.poetrygame.dto.buildingTopic;
import com.poetrygame.mapper.dtoMapper.buildingTopicMapper;
import com.poetrygame.topicService.buildingTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/3/17
 * @Time: 8:59
 * @Description:
 */

@Service
public class buildingTopicServiceImpl implements buildingTopicService {

    @Autowired
    private buildingTopicMapper buildingTopicMapper;

    @Override
    public buildingTopic getBuildingTopic(Long playerTopicId) {
        return buildingTopicMapper.buildingTopic(playerTopicId);
    }
}
