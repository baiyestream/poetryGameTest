package com.poetrygame.service.impl;

import com.poetrygame.dto.gisInformation;
import com.poetrygame.mapper.dtoMapper.gisInformationMapper;
import com.poetrygame.service.gisInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/3/3
 * @Time: 13:48
 * @Description:
 */
@Service
public class gisInformationServiceImpl implements gisInformationService {

    @Autowired
    private gisInformationMapper gisInformationMapper;

    @Override
    public gisInformation getGisInformation(Long playerBuildingId) {
        return gisInformationMapper.gisInformation(playerBuildingId);
    }

    @Override
    public gisInformation getGisInformationForMap(Long playerBuildingId, Integer buildingId, Integer cityId, Integer countryId) {
        return gisInformationMapper.gisInformationForMap(playerBuildingId,buildingId,cityId,countryId);
    }
}
