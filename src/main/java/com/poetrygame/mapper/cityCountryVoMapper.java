package com.poetrygame.mapper;

import com.poetrygame.vo.cityCountryVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 8:51
 * @Description:
 */
@Mapper
public interface cityCountryVoMapper {

    //根据城市ID查出国家ID,国家名称
    cityCountryVo cityAndCountry(Integer cityId);
}
