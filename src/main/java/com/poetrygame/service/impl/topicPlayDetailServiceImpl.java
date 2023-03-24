package com.poetrygame.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poetrygame.mapper.topicPlayDetailMapper;
import com.poetrygame.pojo.topicPlayDetail;
import com.poetrygame.service.topicPlayDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 10:56
 * @Description:
 */
@Service
public class topicPlayDetailServiceImpl extends ServiceImpl<topicPlayDetailMapper,topicPlayDetail> implements topicPlayDetailService {

    @Autowired
    private topicPlayDetailMapper topicPlayDetailMapper;

    // 批量插入:将playerBuildingId,topicId,topicStatus插入到玩家题目明细表,长度为对应建筑物的题目容量
    @Override
    public Integer getInsertBatch(List<topicPlayDetail> list) {
        return topicPlayDetailMapper.insertBatch(list);
    }

    // 根据玩家题目明细表的玩家建筑id，题目id,玩家id来查出唯一玩家题目id
    @Override
    public Long getSelectPlayTopicId(Long playerId, Long playerBuildingId, Long topicId) {
        return topicPlayDetailMapper.selectPlayTopicId(playerId,playerBuildingId,topicId);
    }

    @Override
    public Integer updateTopicToMysql(Integer topicStatus, String startTime, Long usedTime, Long playerTopicId) {
        return topicPlayDetailMapper.updateTopic(topicStatus,startTime,usedTime,playerTopicId);
    }

    @Override
    public Integer getIsExist(Long playId) {
        return topicPlayDetailMapper.isExist(playId);
    }

    // 查询玩家是否完成所有题目
    @Override
    public Integer getUndoneCount(Long playerId) {
        return topicPlayDetailMapper.undoneCount(playerId);
    }


}
