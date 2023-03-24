package com.poetrygame.mapper.dtoMapper;

import com.poetrygame.dto.cityBuilding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/1
 * @Time: 15:22
 * @Description:
 */
@Mapper
public interface cityBuildingMapper {

    List<cityBuilding> cityBuildingTest();
}
