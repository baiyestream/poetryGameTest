package com.poetrygame.topicService;

import com.poetrygame.dto.topicMapDone;

/**
 * @Author: zzw
 * @Date: 2023/3/7
 * @Time: 8:32
 * @Description:
 */
public interface topicMapDoneService {

    topicMapDone getTopicMapDone(Long playerId, Integer cityId, Integer buildingId);
}
