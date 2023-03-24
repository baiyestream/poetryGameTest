package com.poetrygame.dto.cityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicBuildingNode {
    private Integer cityAndBuildingID;
    private Integer countryAndCityID;
    private Integer buildingID;
    private Integer cityID;
    private Integer positionX;
    private Integer positionY;
    private Integer topicLimit;
    private String  buildingName;

    public Integer getCityAndBuildingID() {
        return cityAndBuildingID;
    }

    public void setCityAndBuildingID(Integer cityAndBuildingID) {
        this.cityAndBuildingID = cityAndBuildingID;
    }

    public Integer getCountryAndCityID() {
        return countryAndCityID;
    }

    public void setCountryAndCityID(Integer countryAndCityID) {
        this.countryAndCityID = countryAndCityID;
    }

    public Integer getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Integer buildingID) {
        this.buildingID = buildingID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getTopicLimit() {
        return topicLimit;
    }

    public void setTopicLimit(Integer topicLimit) {
        this.topicLimit = topicLimit;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
