package com.poetrygame.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 13:25
 * @Description:  根据题目信息表以及玩家题目明细表选出其中没有答过的题目发给前端
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "题目内容")
    private String content;
    @ApiModelProperty(value = "玩家题目信息表主键ID,玩家题目ID")
    private Long playerTopicId;
    @ApiModelProperty(value = "题目ID")
    private Long topicId;
    @ApiModelProperty(value = "题目状态")
    private Integer topicStatus;
    @ApiModelProperty(value = "玩家ID")
    private Long playerId;
}
