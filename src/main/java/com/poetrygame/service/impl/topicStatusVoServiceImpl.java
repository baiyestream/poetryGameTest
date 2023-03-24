package com.poetrygame.service.impl;

import com.poetrygame.mapper.topicStatusVoMapper;
import com.poetrygame.service.topicStatusVoService;
import com.poetrygame.vo.topicStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/22
 * @Time: 13:57
 * @Description:
 */
@Service
public class topicStatusVoServiceImpl implements topicStatusVoService {

    @Autowired
    private topicStatusVoMapper topicStatusVoMapper;

    // 根据playerId获取topic_id和topic_status
    @Override
    public topicStatusVo getTopicStatus(Long playerId) {
        return topicStatusVoMapper.topicStatus(playerId);
    }
}
