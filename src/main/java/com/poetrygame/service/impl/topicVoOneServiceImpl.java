package com.poetrygame.service.impl;

import com.poetrygame.mapper.topicVoOneMapper;
import com.poetrygame.service.topicVoOneService;
import com.poetrygame.vo.topicVoOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/24
 * @Time: 13:51
 * @Description:
 */
@Service
public class topicVoOneServiceImpl implements topicVoOneService {

    @Autowired
    private topicVoOneMapper topicVoOneMapper;

    // 根据玩家题目信息表的topic_static以及player_building_id查出题目信息表的content
    @Override
    public topicVoOne getTopicVoOne(Long playerBuildingId) {
        return topicVoOneMapper.topicVoOne(playerBuildingId);
    }
}
