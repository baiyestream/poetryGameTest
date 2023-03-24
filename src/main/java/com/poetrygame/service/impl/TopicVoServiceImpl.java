package com.poetrygame.service.impl;

import com.poetrygame.mapper.TopicVoMapper;
import com.poetrygame.service.TopicVoService;
import com.poetrygame.vo.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 13:36
 * @Description:
 */
@Service
public class TopicVoServiceImpl implements TopicVoService {

    @Autowired
    private TopicVoMapper topicVoMapper;

    @Override
    public TopicVo getTopicVoContent(Long playerId) {
        return topicVoMapper.TopicVoContent(playerId);
    }
}
