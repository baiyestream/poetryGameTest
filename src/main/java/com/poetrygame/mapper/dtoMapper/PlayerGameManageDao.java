package com.poetrygame.mapper.dtoMapper;



import com.poetrygame.dto.cityDto.topicBuildingNode;
import com.poetrygame.dto.cityDto.topicCityMapNode;
import com.poetrygame.dto.cityDto.topicCountryMapNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository  // 将userDao 交由spring容器管理
public interface PlayerGameManageDao {
    List<topicCountryMapNode> getCountryMapList();
    topicCountryMapNode getOneCountryMapNode(Integer countryID);
    List<topicCityMapNode> getCityMapListBelongToCountry(Integer countryID);
    topicCityMapNode getOneCityMapInCountry(Integer cityID);
    List<topicBuildingNode> getBuildingListBelongToCity(Integer cityID);
}
