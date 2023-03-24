package com.poetrygame.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/2/23
 * @Time: 9:51
 * @Description:  根据国家城市ID在国家地图表和国家城市关联表中查询国家ID和国家名称
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class countryCityIdVo {

    private Integer countryCityId;

    private Integer countryId;

    private String countryName;
}
