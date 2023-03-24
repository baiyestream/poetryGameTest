package com.poetrygame.service.impl;

import com.poetrygame.mapper.countryCityIdVoMapper;
import com.poetrygame.service.countryCityIdVoService;
import com.poetrygame.vo.countryCityIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/23
 * @Time: 10:10
 * @Description:
 */
@Service
public class countryCityIdVoServiceImpl implements countryCityIdVoService {

    @Autowired
    private countryCityIdVoMapper countryCityIdVoMapper;

    // 根据城市建筑关联表的城市建筑ID查出国家ID,国家名称
    @Override
    public countryCityIdVo getCountryCityId(Integer countryCityId) {
        return countryCityIdVoMapper.countryCityId(countryCityId);
    }
}
