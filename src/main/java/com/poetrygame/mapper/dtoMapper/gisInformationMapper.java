package com.poetrygame.mapper.dtoMapper;

import com.poetrygame.dto.gisInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/3/3
 * @Time: 13:04
 * @Description:
 */
@Mapper
public interface gisInformationMapper {

    gisInformation gisInformation(Long playerBuildingId);
    gisInformation gisInformationForMap(Long playerBuildingId,Integer buildingId,Integer cityId,Integer countryId);
}
