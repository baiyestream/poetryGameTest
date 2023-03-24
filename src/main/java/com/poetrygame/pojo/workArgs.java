package com.poetrygame.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/20
 * @Time: 13:33
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class workArgs {

    private Integer argId;

    private String argName;

    private String argValue;

    private String description;
}
