package com.poetrygame.dto.cityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicCityMapNode {
    private Integer countryAndCityID;
    private Integer countryID;
    private Integer cityID;
    private Integer pictureID;
    private String  cityName;
    private String  topicTypeName;
    private Integer gridStartX;
    private Integer gridStartY;
    private Integer gridWidth;
    private Integer gridHeight;
    private Integer gridRows;
    private Integer gridColumns;
    private Integer pictureWidth;
    private Integer pictureHeight;
    private Integer positionX;
    private Integer positionY;
    private String  pictureSavedAddr;

    public Integer getCountryAndCityID() {
        return countryAndCityID;
    }

    public void setCountryAndCityID(Integer countryAndCityID) {
        this.countryAndCityID = countryAndCityID;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getPictureID() {
        return pictureID;
    }

    public void setPictureID(Integer pictureID) {
        this.pictureID = pictureID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTopicTypeName() {
        return topicTypeName;
    }

    public void setTopicTypeName(String topicTypeName) {
        this.topicTypeName = topicTypeName;
    }

    public Integer getGridStartX() {
        return gridStartX;
    }

    public void setGridStartX(Integer gridStartX) {
        this.gridStartX = gridStartX;
    }

    public Integer getGridStartY() {
        return gridStartY;
    }

    public void setGridStartY(Integer gridStartY) {
        this.gridStartY = gridStartY;
    }

    public Integer getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(Integer gridWidth) {
        this.gridWidth = gridWidth;
    }

    public Integer getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(Integer gridHeight) {
        this.gridHeight = gridHeight;
    }

    public Integer getGridRows() {
        return gridRows;
    }

    public void setGridRows(Integer gridRows) {
        this.gridRows = gridRows;
    }

    public Integer getGridColumns() {
        return gridColumns;
    }

    public void setGridColumns(Integer gridColumns) {
        this.gridColumns = gridColumns;
    }

    public Integer getPictureWidth() {
        return pictureWidth;
    }

    public void setPictureWidth(Integer pictureWidth) {
        this.pictureWidth = pictureWidth;
    }

    public Integer getPictureHeight() {
        return pictureHeight;
    }

    public void setPictureHeight(Integer pictureHeight) {
        this.pictureHeight = pictureHeight;
    }

    public String getPictureSavedAddr() {
        return pictureSavedAddr;
    }

    public void setPictureSavedAddr(String pictureSavedAddr) {
        this.pictureSavedAddr = pictureSavedAddr;
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
}
