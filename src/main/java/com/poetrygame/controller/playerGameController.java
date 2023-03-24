package com.poetrygame.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.filter.Filter;
import com.poetrygame.commonTest.pictureFileSupport;
import com.poetrygame.commonTest.responsePackage;
import com.poetrygame.dto.cityDto.topicBuildingNode;
import com.poetrygame.dto.cityDto.topicCityMapNode;
import com.poetrygame.dto.cityDto.topicCountryMapNode;
import com.poetrygame.topicService.playerGameManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*--------------------------------------
 *  玩家游戏管理主控模块
 */

@RestController
@RequestMapping("/gameControl")
@CrossOrigin
@Api(tags = "玩家游戏管理")
public class playerGameController {
    @Autowired
    private playerGameManageService playerGameManager;


    @GetMapping("/countryMapList")
    @ApiOperation("玩家游戏管理：获取国家地图列表")
    public String getGameCountryMapList() {

        String responseResult = new String();

        List<topicCountryMapNode> countryMapList = playerGameManager.getCountryMapListService();

        if(null != countryMapList && countryMapList.size() > 0){
            Integer mapCount = countryMapList.size();

            for(int i = 0; i < mapCount; i++){
                try {
                    countryMapList.get(i).setPictureURLAddr(pictureFileSupport.savedAddr2URL(countryMapList.get(i).getPictureSavedAddr()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
//            return responsePackage.listResponse(JSON.toJSONString(countryMapList, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero), mapCount);
            return responsePackage.listResponse(JSON.toJSONString(countryMapList), mapCount);
        }else{
            return responsePackage.errorResponse((String) "国家地图列表为空", (Integer) 0);
        }
    }

    @GetMapping("/oneCountryMap")
    @ApiOperation("玩家游戏管理：获取指定国家地图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "countryID", value = "国家地图ID", paramType = "query", dataType = "Integer"),
    })
    public String getOneGameCountryMap(@RequestParam("countryID") Integer countryID) {

        if(null == countryID || 0 == countryID){
            return responsePackage.errorResponse((String) "无效国家地图ID", (Integer) 0);
        }

        topicCountryMapNode oneCountryMapNode = playerGameManager.getOneCountryMapNodeService(countryID);

        System.out.println(oneCountryMapNode);

        if(null != oneCountryMapNode ){
            String urlAddr = new String();
            try {
                urlAddr = pictureFileSupport.savedAddr2URL(oneCountryMapNode.getPictureSavedAddr());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // 计算出网格中心点相对于图片的中心点
            Integer verCenterShift = oneCountryMapNode.getPictureHeight()/2 - (oneCountryMapNode.getGridStartY() + oneCountryMapNode.getGridHeight() * oneCountryMapNode.getGridRows()/2);

            String responseString = new String();

            responseString = "{" + "\"countryId\":" + oneCountryMapNode.getCountryID().toString() + ",";
            responseString += "\"gridStartX\":" + oneCountryMapNode.getGridStartX().toString() + ",";
            responseString += "\"gridStartY\":" + oneCountryMapNode.getGridStartY().toString() + ",";
            responseString += "\"gridWidth\":" + oneCountryMapNode.getGridWidth().toString() + ",";
            responseString += "\"girdHeight\":" + oneCountryMapNode.getGridHeight().toString() + ",";
            responseString += "\"girdRows\":" + oneCountryMapNode.getGridRows().toString() + ",";
            responseString += "\"girdColumns\":" + oneCountryMapNode.getGridColumns().toString() + ",";
            responseString += "\"XborderSize\":" + oneCountryMapNode.getGridStartX().toString() + ",";
            responseString += "\"YcenterShift\":" + verCenterShift.toString() + ",";
            responseString += "\"pictureURLAddr\":" + "\"" + urlAddr + "\",";

            // 获取该国家下的城市列表
            List<topicCityMapNode> cityMapList = playerGameManager.getCityMapListBelongToCountryService(countryID);

            System.out.println(JSON.toJSONString(cityMapList));

            if(null != cityMapList && cityMapList.size() > 0 ) {

                Integer mapCount = cityMapList.size();
                List<Map<String, String>> returnCityList = new ArrayList<>();

                for (int i = 0; i < mapCount; i++) {
                    returnCityList.add(new HashMap<>());
//                    returnCityList.get(i).put("countryCityId", cityMapList.get(i).getCountryAndCityID().toString());
                    returnCityList.get(i).put("cityId", cityMapList.get(i).getCityID().toString());
                    returnCityList.get(i).put("positionRow", cityMapList.get(i).getPositionX().toString());
                    returnCityList.get(i).put("positionCol", cityMapList.get(i).getPositionY().toString());
                }

                // 将城市列表拼接到输出结果
                responseString += "\"city\":" + JSON.toJSONString(returnCityList) + "}";
            }else{
                responseString += "\"city\":" + "[]" + "}";
            }

            System.out.println(responseString);

            return responsePackage.normalResponse(responseString, (String) null);
        }else{
            return responsePackage.errorResponse((String) "国家地图不存在", (Integer) 0);
        }
    }

    @GetMapping("/oneCityNode")
    @ApiOperation("玩家游戏管理：获取指定的城市地图信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "cityID", value = "国家关联城市ID", paramType = "query", dataType = "Integer"),
    })
    public String getOneGameCityNode(@RequestParam("cityID") Integer cityID) {
        if(null == cityID || 0 == cityID){
            return responsePackage.errorResponse((String) "无效城市ID", (Integer) 0);
        }

        topicCityMapNode oneCityMapNode = playerGameManager.getOneCityMapInCountryService(cityID);

        String urlAddr = new String();

        if(null != oneCityMapNode ){
            try {
                urlAddr = pictureFileSupport.savedAddr2URL(oneCityMapNode.getPictureSavedAddr());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // 计算出网格中心点相对于图片的中心点
            Integer verCenterShift = oneCityMapNode.getPictureHeight()/2 - (oneCityMapNode.getGridStartY() + oneCityMapNode.getGridHeight() * oneCityMapNode.getGridRows()/2);

            String responseString = new String();

//            responseString = "{" + "\"countryCityID\":" + oneCityMapNode.getCountryID().toString() + ",";
            responseString = "{" + "\"cityId\":" + oneCityMapNode.getCityID().toString() + ",";
            responseString += "\"gridStartX\":" + oneCityMapNode.getGridStartX().toString() + ",";
            responseString += "\"gridStartY\":" + oneCityMapNode.getGridStartY().toString() + ",";
            responseString += "\"gridWidth\":" + oneCityMapNode.getGridWidth().toString() + ",";
            responseString += "\"girdHeight\":" + oneCityMapNode.getGridHeight().toString() + ",";
            responseString += "\"girdRows\":" + oneCityMapNode.getGridRows().toString() + ",";
            responseString += "\"girdColumns\":" + oneCityMapNode.getGridColumns().toString() + ",";
            responseString += "\"XborderSize\":" + oneCityMapNode.getGridStartX().toString() + ",";
            responseString += "\"YcenterShift\":" + verCenterShift.toString() + ",";
            responseString += "\"pictureURLAddr\":" + "\"" + urlAddr + "\",";

            // 要获取城市所属的建筑列表
            List<topicBuildingNode> buildingList = playerGameManager.getBuildingListBelongToCityService(cityID);

            System.out.println(JSON.toJSONString(buildingList));

            if(null != buildingList && buildingList.size() > 0 ) {
                Integer buildCount = buildingList.size();
                List<Map<String, String>> returnBuildingist = new ArrayList<>();

                for (int i = 0; i < buildCount; i++) {
                    returnBuildingist.add(new HashMap<>());
//                    returnBuildingist.get(i).put("cityBuildingId", buildingList.get(i).getCityAndBuildingID().toString());
                    // 与前端保持一致，X为行，Y代表列
                    returnBuildingist.get(i).put("buildingId", buildingList.get(i).getBuildingID().toString());
                    returnBuildingist.get(i).put("positionRow", buildingList.get(i).getPositionX().toString());
                    returnBuildingist.get(i).put("positionCol", buildingList.get(i).getPositionY().toString());
                }

                System.out.println(JSON.toJSONString(returnBuildingist));

                // 将城建筑列表拼接到输出结果
                responseString += "\"building\":" + JSON.toJSONString(returnBuildingist) + "}";
            }else{
                responseString += "\"building\":" + "[]" + "}";
            }

            return responsePackage.normalResponse(responseString, (String) null);
        }else{
            return responsePackage.errorResponse((String) "城市节点不存在", (Integer) 0);
        }
    }
}
