package com.poetrygame.mapper.dtoMapper;

import com.poetrygame.dto.topicMapDone;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/3/7
 * @Time: 8:31
 * @Description:
 */
@Mapper
public interface topicMapDoneMapper {

    topicMapDone topicMapDone(Long playerId,Integer cityId,Integer buildingId);
}
