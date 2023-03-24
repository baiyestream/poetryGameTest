package com.poetrygame.service;

import com.poetrygame.dto.gisInformation;

/**
 * @Author: zzw
 * @Date: 2023/3/3
 * @Time: 13:47
 * @Description:
 */
public interface gisInformationService {

    gisInformation getGisInformation(Long playerBuildingId);
    gisInformation getGisInformationForMap(Long playerBuildingId,Integer buildingId,Integer cityId,Integer countryId);
}
