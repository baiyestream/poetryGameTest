package com.poetrygame.topicService.impl;

import com.poetrygame.dto.topicSum;
import com.poetrygame.mapper.dtoMapper.topicSumMapper;
import com.poetrygame.topicService.topicSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 13:19
 * @Description:
 */
@Service
public class topicSumServiceImpl implements topicSumService {

    @Autowired
    private topicSumMapper topicSumMapper;

    @Override
    public topicSum getTopicSum(Long playerTopicId) {
        return topicSumMapper.topicSum(playerTopicId);
    }

    @Override
    public topicSum getTopicSumNull(Long playerTocId) {
        return topicSumMapper.topicSumNull(playerTocId);
    }
}
