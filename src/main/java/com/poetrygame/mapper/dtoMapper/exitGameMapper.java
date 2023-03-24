package com.poetrygame.mapper.dtoMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/3/21
 * @Time: 9:48
 * @Description:
 */
@Mapper
public interface exitGameMapper {

    Integer updateLimit(String exitTime,Integer lifeCount,String weixinId);
}
