package com.poetrygame.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/3/20
 * @Time: 13:35
 * @Description:
 */
@Mapper
public interface WorkArgsMapper {

    Integer lifeLimit();
    Integer lifeResumeOnline();
    Integer lifeResumeOffline();
}
