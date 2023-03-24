package com.poetrygame.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class commonSupport {

    private static String accessAddr;
    @Value("${pictureFile.accessDir}")
    public void setAccessAddr(String URLBaseAddr) {
        this.accessAddr = URLBaseAddr;
    }

    public static String savedAddr2URL(String savedAddr) throws UnsupportedEncodingException {

        String URLAddr = new String();

        String baseFileName = savedAddr.substring(savedAddr.lastIndexOf(File.separator) + 1, savedAddr.length());

        System.out.println(accessAddr);

        try {
            URLAddr = accessAddr + URLEncoder.encode(baseFileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return URLAddr;
    }
}
