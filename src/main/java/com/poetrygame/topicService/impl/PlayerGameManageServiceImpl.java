package com.poetrygame.topicService.impl;


import com.poetrygame.dto.cityDto.topicBuildingNode;
import com.poetrygame.dto.cityDto.topicCityMapNode;
import com.poetrygame.dto.cityDto.topicCountryMapNode;
import com.poetrygame.mapper.dtoMapper.PlayerGameManageDao;
import com.poetrygame.topicService.playerGameManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerGameManageServiceImpl implements playerGameManageService {
    @Autowired
    @Lazy

    private PlayerGameManageDao playerGameManageDao;

    @Override
    public List<topicCountryMapNode> getCountryMapListService(){
        return playerGameManageDao.getCountryMapList();
    }

    @Override
    public topicCountryMapNode getOneCountryMapNodeService(Integer countryID){
        return playerGameManageDao.getOneCountryMapNode(countryID);
    }

    @Override
    public List<topicCityMapNode> getCityMapListBelongToCountryService(Integer countryID){
        return playerGameManageDao.getCityMapListBelongToCountry(countryID);
    }

    @Override
    public topicCityMapNode getOneCityMapInCountryService(Integer cityID){
        return playerGameManageDao.getOneCityMapInCountry(cityID);
    }

    @Override
    public List<topicBuildingNode> getBuildingListBelongToCityService(Integer cityID){
        return playerGameManageDao.getBuildingListBelongToCity(cityID);
    }
}
