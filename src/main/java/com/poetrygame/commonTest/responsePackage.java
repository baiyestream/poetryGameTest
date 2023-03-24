package com.poetrygame.commonTest;

public class responsePackage {
    public static String normalResponse(String origData, String message) {

        String resultString = new String();

        // 以下组合JSON串
        resultString = resultString + "{ " + "\"" + "code" + "\"" + ":" + "1" + ",";
        if (null == message){
            resultString = resultString + "\"" + "message" + "\"" + ":" + "null" + ",";
        }
        else{
            resultString = resultString + "\"" + "message" + "\"" + ":" + "\"" + message + "\",";
        }

        resultString = resultString + "\"" + "data" + "\"" + ":";

//        System.out.println(origData);
        if ( null == origData){
            resultString = resultString + "{},";
        }
        else{
            resultString = resultString + origData + ",";
        }

        resultString = resultString + "\"" + "map" + "\"" + ":" + "{}}";

        System.out.println(resultString);

        return resultString;
    }

    public static String pageControlResponse(String origData, Integer page, Integer pageSize, Integer totalCount) {

        String resultString = new String();

        // 以下组合JSON串
        resultString = resultString + "{ " + "\"" + "code" + "\"" + ":" + "1" + ",";
        resultString = resultString + "\"" + "message" + "\"" + ":" + "null" + ",";
        resultString = resultString + "\"" + "data" + "\"" + ":";

        resultString = resultString + "{ " + "\"" + "totalRecords" + "\"" + ":" + Integer.toString(totalCount.intValue()) + ",";
        resultString = resultString + "\"" + "pageNum" + "\"" + ":" + Integer.toString(page.intValue()) + ",";
        resultString = resultString + "\"" + "pageSize" + "\"" + ":" + Integer.toString(pageSize.intValue()) + ",";
        resultString = resultString + "\"" + "contentList" + "\"" + ":";

        if (null != origData) {
            resultString = resultString + origData;
        } else {
            resultString = resultString + "[]";
        }
        resultString = resultString + "},";
        resultString = resultString + "\"" + "map" + "\"" + ":" + "{}}";

        System.out.println(resultString);

        return resultString;
    }

    public static String listResponse(String origData, Integer totalCount) {

        String resultString = new String();

        // 以下组合JSON串
        resultString = resultString + "{ " + "\"" + "code" + "\"" + ":" + "1" + ",";
        resultString = resultString + "\"" + "message" + "\"" + ":" + "null" + ",";
        resultString = resultString + "\"" + "data" + "\"" + ":";

        resultString = resultString + "{ " + "\"" + "totalRecords" + "\"" + ":" + Integer.toString(totalCount.intValue()) + ",";
        resultString = resultString + "\"" + "contentList" + "\"" + ":";

        if (null != origData) {
            resultString = resultString + origData;
        } else {
            resultString = resultString + "[]";
        }
        resultString = resultString + "},";
        resultString = resultString + "\"" + "map" + "\"" + ":" + "{}}";

        System.out.println(resultString);

        return resultString;
    }

    public static String nullResultResponse(){
        String resultString = new String();

        // 以下组合JSON串
        resultString = resultString + "{ " + "\"" + "code" + "\"" + ":" + 0 + ",";
        resultString = resultString + "\"" + "message" + "\"" + ":" + "\"" + "结果为空" + "\",";
        resultString = resultString + "\"" + "data" + "\"" + ":" + "{},";
        resultString = resultString + "\"" + "map" + "\"" + ":" + "{}}";

        return resultString;
    }

    public static String errorResponse(final String errorMessage, Integer errorCode) {

        String resultString = new String();

        // 以下组合JSON串
        resultString = resultString + "{ " + "\"" + "code" + "\"" + ":" + errorCode.toString() + ",";
        resultString = resultString + "\"" + "message" + "\"" + ":" + "\"" + errorMessage + "\",";
        resultString = resultString + "\"" + "data" + "\"" + ":" + "{},";
        resultString = resultString + "\"" + "map" + "\"" + ":" + "{}}";

        return resultString;
    }
}
