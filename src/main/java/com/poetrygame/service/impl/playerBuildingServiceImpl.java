package com.poetrygame.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poetrygame.mapper.playerBuildingMapper;
import com.poetrygame.pojo.playerBuilding;
import com.poetrygame.service.playerBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 10:26
 * @Description:
 */
@Service
public class playerBuildingServiceImpl extends ServiceImpl<playerBuildingMapper,playerBuilding> implements playerBuildingService {

    @Autowired
    private playerBuildingMapper playerBuildingMapper;

    // 将cityBuildingId,playerId,topicLimit,doneTopic插入到玩家游历建筑表
    @Override
    public Integer getInsert(playerBuilding playerBuilding) {
        return playerBuildingMapper.insert(playerBuilding);
    }
    // 当数据插入到玩家遍历建筑表后，根据player_id查询player_building_id
    @Override
    public Integer getPlayerBuildingId(Long playerId) {
        return playerBuildingMapper.playerBuildingId(playerId);
    }

    @Override
    public Integer getInsertBatch(List<playerBuilding> list) {
        return playerBuildingMapper.insertBatch(list);
    }

    @Override
    public List<playerBuilding> getPlayerBuildingTest(Long playerId) {
        return playerBuildingMapper.playerBuildingTest(playerId);
    }

    @Override
    public Integer getTopicCount(Long playerId) {
        return playerBuildingMapper.topicCount(playerId);
    }

    @Override
    public Integer getTopicNumber(Long playerId) {
        return playerBuildingMapper.topicNumber(playerId);
    }
}
