package com.fulihui.redisdubbo.demo.weixin.common.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.fulihui.redisdubbo.demo.weixin.common.config.OSSConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * @Description:
 * @Author: xiaoming
 * @version: v 0.1 2018/7/31 0031 13:33
 */
@Component
public class AliyunOSSClientUtil {

    private static Logger logger = LoggerFactory.getLogger(AliyunOSSClientUtil.class);
	/*//阿里云API的内或外网域名
	private static String ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";
	//阿里云API的密钥Access Key ID
	private static String ACCESS_KEY_ID ="LTAIfKdC0KkJP9y3";
	//阿里云API的密钥Access Key Secret
	private static String ACCESS_KEY_SECRET ="lOXNNqdTRrP6pOUteRDvjzdGtV4z6Q";
	//阿里云API的bucket名称
	private static String BACKET_NAME ="redisdubbo.demo.producer";
	//阿里云API的文件夹名称
	private static String FOLDER ="redisdubbo.demo.producer/";

	private static String key ="http://redisdubbo.demo.producer.oss-cn-hangzhou.aliyuncs.com/";*/

    //阿里云API的内或外网域名
    private static String ENDPOINT;
    //阿里云API的密钥Access Key ID
    private static String ACCESS_KEY_ID;
    //阿里云API的密钥Access Key Secret
    private static String ACCESS_KEY_SECRET;
    //阿里云API的bucket名称
    private static String BACKET_NAME;
    //阿里云API的文件夹名称
    private static String FOLDER;

    private static String key;
    //初始化属性

    @Autowired
    private OSSConfig oSSConfig;


    @PostConstruct
    public void init() {

        ENDPOINT = oSSConfig.getEndpoint();
        ACCESS_KEY_ID = oSSConfig.getAccessKeyId();
        ACCESS_KEY_SECRET = oSSConfig.getAccessKeySecret();
        BACKET_NAME = oSSConfig.getBucketName();
        FOLDER = oSSConfig.getFloder();
        key = oSSConfig.getKey();
    }

    /**
     * 获取阿里云OSS客户端对象
     *
     * @return ossClient
     */
    public static OSSClient getOSSClient() {
        return new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }

    /**
     * 创建存储空间
     *
     * @param ossClient  OSS连接
     * @param bucketName 存储空间
     * @return
     */
    public static String createBucketName(OSSClient ossClient, String bucketName) {
        //存储空间
        final String bucketNames = bucketName;
        if (!ossClient.doesBucketExist(bucketName)) {
            //创建存储空间
            Bucket bucket = ossClient.createBucket(bucketName);
            logger.info("创建存储空间成功");
            return bucket.getName();
        }
        return bucketNames;
    }

    /**
     * 删除存储空间buckName
     *
     * @param ossClient  oss对象
     * @param bucketName 存储空间
     */
    public static void deleteBucket(OSSClient ossClient, String bucketName) {
        ossClient.deleteBucket(bucketName);
        logger.info("删除" + bucketName + "Bucket成功");
    }

    /**
     * 创建文件夹
     *
     * @param ossClient  oss连接
     * @param bucketName 存储空间
     * @param folder     文件夹名
     * @return 文件夹名
     */
    public static String createFolder(OSSClient ossClient, String bucketName, String folder) {
        //文件夹名
        final String keySuffixWithSlash = folder;
        //判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
            //创建文件夹
            ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            logger.info("创建文件夹成功");
            //得到文件夹名
            OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
            String fileDir = object.getKey();
            return fileDir;
        }
        return keySuffixWithSlash;
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param ossClient  oss连接
     * @param bucketName 存储空间
     * @param folder     模拟文件夹
     * @param key        Bucket下的文件的路径名+文件名
     */
    public static void deleteFile(OSSClient ossClient, String bucketName, String folder, String key) {
        ossClient.deleteObject(bucketName, folder + key);
        logger.info("删除" + bucketName + "下的文件" + folder + key + "成功");
    }

    /**
     * 上传图片至OSS
     *
     * @param ossClient  oss连接
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名 如"qj_nanjing/"
     * @return String 返回的唯一MD5数字签名
     */
    public static String uploadObject2OSS(OSSClient ossClient, InputStream is, String fileName, String bucketName, String folder) {
        String resultStr = null;
        try {
            //上传文件   (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName, is);
            //解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return resultStr;
    }

    /**
     * 上传图片
     *
     * @param fileName
     * @param inputStream
     * @return
     */
    public String uploadImageToOSS(String fileName, InputStream inputStream) {
        try {
            OSSClient ossClient = getOSSClient();
            String genKey = genKey(fileName);
            if (!ossClient.doesObjectExist(BACKET_NAME, genKey)) {
                PutObjectResult result = ossClient.putObject(new PutObjectRequest(BACKET_NAME, genKey, inputStream));
                if (Objects.nonNull(result)) {
                    logger.info("upload result :" + result.getETag());
                }
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.YEAR, 50);
                Date expiration = cal.getTime();
                if (ossClient.doesObjectExist(BACKET_NAME, genKey)) {
                    URL url = ossClient.generatePresignedUrl(BACKET_NAME, genKey, expiration);
                    if (Objects.nonNull(url)) {
                        String fileNameSuffix = fileName.substring(fileName.lastIndexOf("."));
                        String urlStr = url.toString().substring(0, url.toString().indexOf(fileNameSuffix) + fileNameSuffix.length());
                        return urlStr;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("文件上传错误 ： {}", e);
        }
        return null;
    }


    /**
     * 多图上传
     */
    public List<String> uploadImageToOSS(String[] fileNames, InputStream[] inputStreams) {
        /**
         * 创建OSS客户端
         */
        OSSClient ossClient = getOSSClient();
        List<String> list = new ArrayList<>();
        try {
            if (fileNames.length > 0 && inputStreams.length > 0) {
                for (int i = 0; i < fileNames.length; i++) {
                    ossClient.putObject(new PutObjectRequest(BACKET_NAME, FOLDER + fileNames[i], inputStreams[i]));
                    list.add(key + FOLDER + fileNames[i]);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        } finally {
            ossClient.shutdown();
        }
        return list;
    }

    private String genKey(String fileName) {
        String fileNamePrefix = fileName.substring(0, fileName.lastIndexOf("."));
        String fileNameSuffix = fileName.substring(fileName.lastIndexOf("."));
        String md5Str = UUID.randomUUID().toString();
        return BACKET_NAME + md5Str + fileNameSuffix;
    }


}