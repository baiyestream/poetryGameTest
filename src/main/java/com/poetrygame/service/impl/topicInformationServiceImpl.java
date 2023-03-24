package com.poetrygame.service.impl;

import com.poetrygame.mapper.topicInformationMapper;
import com.poetrygame.service.topicInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 10:22
 * @Description:
 */
@Service
public class topicInformationServiceImpl implements topicInformationService {

    @Autowired
    private topicInformationMapper topicInformationMapper;

    // 第一次取:随机取出题目信息表里对应建筑容纳量的题目id
    @Override
    public List<Integer> getTopicId(Integer topicLimit) {
        return topicInformationMapper.topicId(topicLimit);
    }

    // 根据玩家题目明细表的topic_id查出题目信息表的content
    @Override
    public String getTopicContent(Long topicId) {
        return topicInformationMapper.topicContent(topicId);
    }

    @Override
    public Integer getTopicSum() {
        return topicInformationMapper.topicSum();
    }
}
