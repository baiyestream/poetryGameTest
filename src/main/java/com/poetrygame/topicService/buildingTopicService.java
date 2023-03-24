package com.poetrygame.topicService;

import com.poetrygame.dto.buildingTopic;

/**
 * @Author: zzw
 * @Date: 2023/3/17
 * @Time: 8:55
 * @Description:
 */
public interface buildingTopicService {
    buildingTopic getBuildingTopic(Long playerTopicId);
}
