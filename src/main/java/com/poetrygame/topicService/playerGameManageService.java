package com.poetrygame.topicService;

import com.poetrygame.dto.cityDto.topicBuildingNode;
import com.poetrygame.dto.cityDto.topicCityMapNode;
import com.poetrygame.dto.cityDto.topicCountryMapNode;

import java.util.List;

public interface playerGameManageService {

    List<topicCountryMapNode> getCountryMapListService();
    topicCountryMapNode getOneCountryMapNodeService(Integer countryID);
    List<topicCityMapNode> getCityMapListBelongToCountryService(Integer countryID);
    topicCityMapNode getOneCityMapInCountryService(Integer cityID);
    List<topicBuildingNode> getBuildingListBelongToCityService(Integer cityID);
}
