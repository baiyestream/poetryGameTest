package com.poetrygame.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 13:34
 * @Description: 建筑表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class building implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "建筑ID")
    private Integer buildingId;
    @ApiModelProperty(value = "建筑名称")
    private String buildingName;
    @ApiModelProperty(value = "概述")
    private String profile;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "容纳题目数")
    private Integer topicLimit;
    @ApiModelProperty(value = "图片ID")
    private Integer pictureId;
    @ApiModelProperty(value = "创建人")
    private Integer creatorId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "审批人")
    private Integer approvorId;
    @ApiModelProperty(value = "审批时间")
    private Date approveTime;
    @ApiModelProperty(value = "变更人")
    private Integer operatorId;
    @ApiModelProperty(value = "变更原因")
    private String changeReason;
    @ApiModelProperty(value = "变更时间")
    private Date changeTime;
    @ApiModelProperty(value = "关联次数")
    private Integer connTimes;
}
