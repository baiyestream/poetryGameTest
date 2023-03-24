package com.poetrygame.commonTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class pictureFileSupport {

    static Logger logger = Logger.getLogger("pictureFileSupport");

//    // 图片文件存储目标地址
//    private static String pictureTargetDir;
//    @Value("${pictureFile.imageDir}")
//    public void setTargetPictureDir(String targetPathName) {
//        pictureTargetDir = targetPathName;
//    }
//
//    public static String getPictureTargetDir(){
//        return pictureTargetDir;
//    }
//
//    // 上传的图片文件会上传到临时目录下
//    private static String tempPictureDir;
//    @Value("${pictureFile.upload.tempDir}")
//    public void setTempPictureDir(String tempPathName){
//        tempPictureDir = tempPathName;
//    }
//
//    public static String getTempPictureDir(){
//        return tempPictureDir;
//    }
//    public static boolean isPictureFile(String fileName) {
//        String fileTypeExt = fileName.substring(fileName.lastIndexOf("."));
//
//        if (fileTypeExt.toLowerCase().equals(".jpg") ||
//                fileTypeExt.toLowerCase().equals(".jpeg") ||
//                fileTypeExt.toLowerCase().equals(".png") ||
//                fileTypeExt.toLowerCase().equals(".img") ||
//                fileTypeExt.toLowerCase().equals(".bmp")) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public enum procPictureResult {
//        NOT_PICTURE_FILE,
//        SOURCE_FILE_NOT_EXIST,
//        SUCCESS,
//        TARGET_FILE_EXIST
//    };
//
//    public static boolean isTargetPictureFileExist(String fileName, String typeName) {
//        String baseFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length());
//        String targetFilePath = pictureTargetDir + File.separator + typeName + "-" + baseFileName;
//
//        System.out.println("check targert file:" + targetFilePath + " exist");
//
//        File targetPictureFile = new File(targetFilePath);
//
//        //判断文件是否存在
//        return targetPictureFile.exists();
//    }
//
//    public static void deleteTargetPictureFile(String fileName, String typeName) {
//        String baseFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length());
//        String targetFilePath = pictureTargetDir + File.separator + typeName + "-" + baseFileName;
//
//        File targetPictureFile = new File(targetFilePath);
//
//        targetPictureFile.delete();
//    }
//
//    public static String getTargetPictureFileName(String fileName, String typeName) {
//        String baseFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length());
//        return pictureTargetDir + File.separator + typeName + "-" + baseFileName;
//    }
//
//    public static void deleteUploadedTempPictureFile(String fileName) {
//
//        String baseFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length());
//        String FilePath = tempPictureDir + File.separator + baseFileName;
//
//        File pictureFile = new File(FilePath);
//
//        pictureFile.delete();
//    }
//
//    // 处理新图片的统一接口，主要是完成图片从临时目录转移到正式目录
//    public static procPictureResult moveTempPictureToTarget(String fileName, String typeName) {
//        // 处理图片文件
//        System.out.println("original file name:" + fileName);
//
//        // 1、拼接出临时与目标图片的存储地址
//        String baseFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.length());
//        String tempFilePath = tempPictureDir + File.separator + baseFileName;
//        String targetFilePath = pictureTargetDir + File.separator + typeName + "-" + baseFileName;
//
//        System.out.println("temp file path:" + tempFilePath);
//        System.out.println("target file path:" + targetFilePath);
//
//        // 2、判断在临时目录下是否存在图片文件，如果存在，则表示已上传
//        File tempPictureFile = new File(tempFilePath);
//        logger.log(Level.INFO, "full file path name:" + tempFilePath);
//        if (!tempPictureFile.exists()) {
//            logger.log(Level.WARNING, "picture file:" + tempFilePath + " not uploaded");
//            return procPictureResult.SOURCE_FILE_NOT_EXIST;
//        }
//
//        // 3、检查是否为图片文件，如果不是，则删除文件并返回
//        if (!pictureFileSupport.isPictureFile(baseFileName)) {
//            return procPictureResult.NOT_PICTURE_FILE;
//        }
//
//        // 4、将临时图片文件移到目标目录下
//        File targetPictureFile = new File(targetFilePath);
//
//        //判断文件保存的目录是否存在
//        if (!targetPictureFile.getParentFile().exists()) {
//            try {
//                targetPictureFile.getParentFile().mkdir();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        // 5、移动之前要先判断目标文件是否存在：正常情况下，不会出现这种情况，出现这种情况，意味着图片上传成功，但没有写入数据库，
//        // 或者原有图片文件被新文件替换，但没有清除原有文件。
//        // 正常情况下，可修改的图片文件是未经审核的文件，也就是说这个图片不会被其它应用所引用，因此，在被替换或确认无效时，要及时清理
//        if (targetPictureFile.exists()) {
//            return procPictureResult.TARGET_FILE_EXIST;
//        } else {
//            try {
//                tempPictureFile.renameTo(targetPictureFile);
//            } catch (Exception e) {
//                logger.log(Level.INFO, "failed to move target file:" + targetFilePath);
//                e.printStackTrace();
//            }
//        }
//
//        return procPictureResult.SUCCESS;
//    }
//
//    public static BufferedImage getPictureInfomation(String fileName, String typeName) throws Exception{
//        // 获取图片大小
//        BufferedImage bufferedImage = null;
//        String targetFileName = getTargetPictureFileName(fileName, typeName);
//        try
//        {
//            FileInputStream is = new FileInputStream(new File(targetFileName));
//            bufferedImage = ImageIO.read(is);
//            is.close();
//        } catch(IOException e){
//            e.printStackTrace();
//        }
//
//        return bufferedImage;
//    }

//    public void setAccessAddr(String CaccessAddr) {
//        accessAddr = CaccessAddr;
//    }

    private static String accessAddr;
    @Value("${pictureFile.accessDir}")
    public void setAccessAddr(String URLBaseAddr) {
        this.accessAddr = URLBaseAddr;
    }

    public static String savedAddr2URL(String savedAddr) throws UnsupportedEncodingException {

        String URLAddr = new String();

        String baseFileName = savedAddr.substring(savedAddr.lastIndexOf(File.separator) + 1, savedAddr.length());

//        System.out.println(accessAddr);

        try {
            URLAddr = accessAddr + URLEncoder.encode(baseFileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return URLAddr;
    }
}
