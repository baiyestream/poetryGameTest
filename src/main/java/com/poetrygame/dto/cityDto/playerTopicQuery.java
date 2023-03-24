package com.poetrygame.dto.cityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class playerTopicQuery {
    private String openID;
    private Integer countryID;
    private Integer cityID;
    private Integer buildingID;
}
