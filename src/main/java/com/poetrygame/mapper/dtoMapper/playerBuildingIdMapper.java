package com.poetrygame.mapper.dtoMapper;

import com.poetrygame.dto.playerBuildingId;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/3/3
 * @Time: 9:42
 * @Description:
 */
@Mapper
public interface playerBuildingIdMapper {

    playerBuildingId playerBuildingId(Long playerId);
}
