package com.poetrygame.service;

import com.poetrygame.vo.topicVoOne;

/**
 * @Author: zzw
 * @Date: 2023/2/24
 * @Time: 13:50
 * @Description:
 */
public interface topicVoOneService {

    // 根据玩家题目信息表的topic_static以及player_building_id查出题目信息表的content
    topicVoOne getTopicVoOne(Long playerBuildingId);
}
