package com.poetrygame.dto.cityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicCountryMapNode {
    private Integer countryID;
    private Integer pictureID;
    private String  countryName;
    private Integer gridStartX;
    private Integer gridStartY;
    private Integer gridWidth;
    private Integer gridHeight;
    private Integer gridRows;
    private Integer gridColumns;
    private Integer pictureWidth;
    private Integer pictureHeight;
    private String  pictureSavedAddr;
    private String  pictureURLAddr;

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Integer getPictureID() {
        return pictureID;
    }

    public void setPictureID(Integer pictureID) {
        this.pictureID = pictureID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public void setPictureURLAddr(String pictureURLAddr) {
        this.pictureURLAddr = pictureURLAddr;
    }
}
