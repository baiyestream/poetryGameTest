package com.poetrygame.mapper.dtoMapper;

import com.poetrygame.dto.getTopic.buildingLimit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/24
 * @Time: 14:39
 * @Description:
 */
@Mapper
public interface buildingLimitMapper {

    List<buildingLimit> buildingLimitOne();

    Integer buildingLimitTwo();

    Integer buildingLimitThree();

    Integer buildingLimitFour();
}
