package com.poetrygame.service.impl;

import com.poetrygame.mapper.dtoMapper.exitGameMapper;
import com.poetrygame.service.exitGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/3/21
 * @Time: 9:49
 * @Description:
 */
@Service
public class exitGameServiceImpl implements exitGameService {

    @Autowired
    private exitGameMapper exitGameMapper;
    @Override
    public Integer getUpdateLimit(String exitTime, Integer lifeCount, String weixinId) {
        return exitGameMapper.updateLimit(exitTime,lifeCount,weixinId);
    }
}
