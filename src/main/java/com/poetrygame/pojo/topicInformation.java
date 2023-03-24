package com.poetrygame.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 9:08
 * @Description:  题目信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "题目ID")
    private Long topicId;
    @ApiModelProperty(value = "类型ID")
    private Integer gameTypeId;
    @ApiModelProperty(value = "题目内容")
    private String content;
    @ApiModelProperty(value = "难易级别")
    private Integer hardLevel;
    @ApiModelProperty(value = "状态")
    private Integer status;
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
}
