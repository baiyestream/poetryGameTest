package com.poetrygame.topicService.impl;

import com.poetrygame.mapper.dtoMapper.topicDoneMapper;
import com.poetrygame.topicService.topicDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 13:59
 * @Description:
 */
@Service
public class topicDoneServiceImpl implements topicDoneService {

    @Autowired
    private topicDoneMapper topicDoneMapper;
    @Override
    public Integer getTopicDone(Long playerTopicId,Integer doneTopic) {
        return topicDoneMapper.topicDone(playerTopicId,doneTopic);
    }
}
