package com.poetrygame.mapper;

import com.poetrygame.vo.TopicVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 13:34
 * @Description:
 */
@Mapper
public interface TopicVoMapper {

    // 根据题目信息表以及玩家题目明细表选出其中没有答过的题目发给前端 (传参playerId)
    TopicVo TopicVoContent(Long playerId);
}
