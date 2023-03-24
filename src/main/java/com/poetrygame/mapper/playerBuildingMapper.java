package com.poetrygame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poetrygame.pojo.playerBuilding;
import com.poetrygame.pojo.topicPlayDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 10:28
 * @Description:
 */
@Mapper
public interface playerBuildingMapper extends BaseMapper<playerBuilding> {

    // 将cityBuildingId,playerId,topicLimit,doneTopic插入到玩家游历建筑表
    int insert(playerBuilding playerBuilding);
    // 当数据插入到玩家遍历建筑表后，根据player_id查询player_building_id
    Integer playerBuildingId(Long playerId);

    Integer insertBatch(List<playerBuilding> list);

    List<playerBuilding> playerBuildingTest(Long playerId);

    Integer topicCount(Long playerId);

    Integer topicNumber(Long playerId);
}
