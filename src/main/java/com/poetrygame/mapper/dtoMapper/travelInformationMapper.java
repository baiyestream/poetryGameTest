package com.poetrygame.mapper.dtoMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/28
 * @Time: 16:28
 * @Description:
 */
@Mapper
public interface travelInformationMapper {

    Integer travelInformationOne(Long playerId);
    Integer travelInformationTwo(Long playerId);
    Integer travelInformationThree(Long playerId);
    List<Integer> travelInformationFour(Long playerId);
    List<Integer> travelInformationFive(Long playerId);
    List<Integer> travelInformationSix(Long playerId);
    List<Integer> travelInformationSeven(Long playerId);
    Integer travelInformationEight(Long playerId);
}
