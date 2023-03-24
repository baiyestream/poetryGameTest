package com.poetrygame.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poetrygame.pojo.playerBuilding;
import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/14
 * @Time: 14:57
 * @Description:
 */
public interface playerBuildingService extends IService<playerBuilding> {

    // 将cityBuildingId,playerId,topicLimit,doneTopic插入到玩家游历建筑表
    Integer getInsert(playerBuilding playerBuilding);

    // 当数据插入到玩家遍历建筑表后，根据player_id查询player_building_id
    Integer getPlayerBuildingId(Long playerId);

    Integer getInsertBatch(List<playerBuilding> list);

    List<playerBuilding> getPlayerBuildingTest(Long playerId);

    Integer getTopicCount(Long playerId);

    Integer getTopicNumber(Long playerId);
}
