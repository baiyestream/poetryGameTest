package com.poetrygame.controller;

import com.poetrygame.common.R;
import com.poetrygame.pojo.countryMap;
import com.poetrygame.service.CountryVoService;
import com.poetrygame.vo.CountryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 8:34
 * @Description: 城市在国家地图上的坐标
 */

@Api(tags = "国家-城市地图")
@RestController
@RequestMapping("/CountryVo")
@CrossOrigin
public class CountryVoController {

    @Autowired
    private CountryVoService countryVoService;

    @ApiOperation(value = "城市在国家地图上的坐标",notes = "savedAddr:图片url,cityId:城市id,positionX:横轴坐标,positionY:纵轴坐标")
    @PostMapping("/getCityPoint")
    public R<Map<String, Object>> getCityPoint(){

        List<CountryVO> cityPoint = countryVoService.getCityPoint();
        Map<String,Object> map = new LinkedHashMap<>();

        // 图片地址
        String pictureLocation = countryVoService.getPictureLocation();

        // 获取坐标相关信息
        countryMap point = countryVoService.getPoint();
        Integer gridStartX = point.getGridStartX();
        Integer gridStartY = point.getGridStartY();
        Integer gridWidth = point.getGridWidth();
        Integer girdHeight = point.getGridHeight();
        Integer girdRows = point.getGridRows();
        Integer girdColumns = point.getGridColumns();

        map.put("savedAddr",pictureLocation);
        map.put("gridStartX",gridStartX);
        map.put("gridStartY",gridStartY);
        map.put("gridWidth",gridWidth);
        map.put("girdHeight",girdHeight);
        map.put("girdRows",girdRows);
        map.put("girdColumns",girdColumns);
        map.put("city",cityPoint);

        return R.success(map,"城市在国家地图上的坐标");
    }


}
