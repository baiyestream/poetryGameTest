package com.poetrygame.service.impl;

import com.poetrygame.mapper.WorkArgsMapper;
import com.poetrygame.service.workArgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/3/20
 * @Time: 13:36
 * @Description:
 */
@Service
public class workArgsServiceImpl implements workArgsService {

    @Autowired
    private WorkArgsMapper workArgsMapper;

    @Override
    public Integer getLifeLimit() {
        return workArgsMapper.lifeLimit();
    }

    @Override
    public Integer getLifeResumeOnline() {
        return workArgsMapper.lifeResumeOnline();
    }

    @Override
    public Integer getLifeResumeOffline() {
        return workArgsMapper.lifeResumeOffline();
    }
}
