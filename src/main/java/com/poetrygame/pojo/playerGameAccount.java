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
 * @Time: 8:45
 * @Description:  玩家游戏流水账
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class playerGameAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "流水账ID")
    private Long accountId;
    @ApiModelProperty(value = "玩家ID")
    private Long playerId;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "持续时长")
    private Integer duration;
    @ApiModelProperty(value = "完成题目数")
    private Integer titleCount;
    @ApiModelProperty(value = "晋级记录")
    private Integer elevatedRecord;
    @ApiModelProperty(value = "获得积分")
    private Integer integration;
    @ApiModelProperty(value = "发起人")
    private Integer promoterId;
    @ApiModelProperty(value = "发起流水账ID")
    private Integer startAccountId;

}
