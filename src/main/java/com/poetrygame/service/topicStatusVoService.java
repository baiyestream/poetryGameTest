package com.poetrygame.service;

import com.poetrygame.vo.topicStatusVo;

/**
 * @Author: zzw
 * @Date: 2023/2/22
 * @Time: 13:56
 * @Description:
 */
public interface topicStatusVoService {

    // 根据playerId获取topic_id和topic_status
    topicStatusVo getTopicStatus(Long playerId);
}
