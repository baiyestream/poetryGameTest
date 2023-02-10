package com.poetrygame.mapper;

import com.poetrygame.pojo.PictureInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/7
 * @Time: 22:49
 * @Description:
 */
@Mapper
public interface PictureInformationMapper {

    PictureInformation getPhoto();
}
