package com.poetrygame.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zzw
 * @Date: 2023/2/8
 * @Time: 14:01
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_country_and_city")
public class countryAndCity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "国家城市ID")
    private Integer countryCityId;
    @ApiModelProperty(value = "国家ID")
    private Integer countryId;
    @ApiModelProperty(value = "城市ID")
    private Integer cityId;
    @ApiModelProperty(value = "摆放位置X")
    private Integer positionX;
    @ApiModelProperty(value = "摆放位置Y")
    private Integer positionY;
}
