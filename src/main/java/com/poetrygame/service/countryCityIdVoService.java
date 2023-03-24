package com.poetrygame.service;

import com.poetrygame.vo.countryCityIdVo;

/**
 * @Author: zzw
 * @Date: 2023/2/23
 * @Time: 10:09
 * @Description:
 */
public interface countryCityIdVoService {

    // 根据城市建筑关联表的城市建筑ID查出国家ID,国家名称
    countryCityIdVo getCountryCityId(Integer countryCityId);
}
