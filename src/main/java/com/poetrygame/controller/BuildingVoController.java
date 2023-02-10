package com.poetrygame.controller;

import com.poetrygame.common.R;
import com.poetrygame.pojo.cityMap;
import com.poetrygame.service.BuildingVoService;
import com.poetrygame.vo.BuildingVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 15:04
 * @Description: 城市在国家地图上的坐标
 */

@Api(tags = "城市-建筑地图")
@RestController
@RequestMapping("/buildingVo")
@CrossOrigin
public class BuildingVoController {

    @Autowired
    private BuildingVoService buildingVoService;


    @GetMapping("/getBuildingPoint")
    @ApiOperation(value = "建筑在城市地图上的坐标,传参城市id,cityId:城市id")
    public R<Map<String,Object>> getBuildingPoint(Integer cityId){

        List<BuildingVO> buildingPoint = buildingVoService.getBuildingPoint(cityId);
        Map<String,Object> map = new LinkedHashMap<>();

        // 获取图片地址
        String pictureLocation = buildingVoService.getPictureLocation();

        // 获取坐标相关信息
        cityMap point = buildingVoService.getPoint(cityId);
        Integer gridStartX = point.getGridStartX();
        Integer gridStartY = point.getGridStartY();
        Integer gridWidth = point.getGridWidth();
        Integer gridHeight = point.getGridHeight();
        Integer gridRows = point.getGridRows();
        Integer gridColumns = point.getGridColumns();

        map.put("savedAddr",pictureLocation);
        map.put("girdStartX",gridStartX);
        map.put("gridStartY",gridStartY);
        map.put("gridWidth",gridWidth);
        map.put("gridHeight",gridHeight);
        map.put("gridRows",gridRows);
        map.put("gridColumns",gridColumns);
        map.put("building",buildingPoint);

        return R.success(map,"建筑在城市地图上的坐标");
    }

}
