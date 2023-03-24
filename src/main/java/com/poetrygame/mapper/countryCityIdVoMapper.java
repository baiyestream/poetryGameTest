package com.poetrygame.mapper;

import com.poetrygame.vo.countryCityIdVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/23
 * @Time: 9:59
 * @Description:
 */
@Mapper
public interface countryCityIdVoMapper {

    // 根据城市建筑关联表的城市建筑ID查出国家ID,国家名称
    countryCityIdVo countryCityId(Integer countryCityId);
}
