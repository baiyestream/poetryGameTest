package com.poetrygame.topicService.impl;

import com.poetrygame.dto.topicMapDone;
import com.poetrygame.mapper.dtoMapper.topicMapDoneMapper;
import com.poetrygame.topicService.topicMapDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/3/7
 * @Time: 8:32
 * @Description:
 */
@Service
public class topicMapDoneServiceImpl implements topicMapDoneService {

    @Autowired
    private topicMapDoneMapper topicMapDoneMapper;

    @Override
    public topicMapDone getTopicMapDone(Long playerId, Integer cityId, Integer buildingId) {
        return topicMapDoneMapper.topicMapDone(playerId, cityId, buildingId);
    }
}
