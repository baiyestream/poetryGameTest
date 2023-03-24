package com.poetrygame.service.impl;

import com.poetrygame.mapper.topicDetailVoMapper;
import com.poetrygame.service.topicDetailVoService;
import com.poetrygame.vo.topicDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/23
 * @Time: 16:31
 * @Description:
 */
@Service
public class topicDetailVoServiceImpl implements topicDetailVoService {

    @Autowired
    private topicDetailVoMapper topicDetailVoMapper;

    // 根据玩家题目表的玩家题目ID来查询玩家游历建筑表的城市建筑ID，分配题目数量，完成题目数量
    @Override
    public topicDetailVo getTopicDetailVo(Long playerTopicId) {
        return topicDetailVoMapper.topicDetailVo(playerTopicId);
    }
}
