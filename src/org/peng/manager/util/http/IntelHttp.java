package org.peng.manager.util.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author sp
 * @Description
 * @create 2020-11-30 18:30
 * @Modified By:
 */
public class IntelHttp {

    //超时时间
    private static final int ConnectionRequestTimeout = 5000;//从连接池中获取连接的超时时间
    private static final int ConnectTimeout = 180000;//与服务器连接超时时间：httpclient会创建一个异步线程用以创建socket连接，此处设置该socket的连接超时时间
    private static final int SocketTimeout = 60000;//socket读数据超时时间：从服务器获取响应数据的超时时间
    /*
     * 获取当前时间
     */
    public static String getNowDate() {
        String temp_str = "";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        temp_str = sdf.format(dt);
        return temp_str;
    }

    /*
     *@Description:获取默认的请求客户段
     *@Param: []
     *@return: org.apache.http.client.HttpClient
     *@Author: sp
     *@Date: 2020/11/30
     */


    public static HttpClient initHttpClient() {
        HttpClient httpClient = new HttpClient();
        return httpClient;

    }
    /*
     *@Description: post 请求上传文件
     *@Param: [httpClient, file, url]
     *@return:
     *@Author: sp
     *@Date: 2020/11/30
     */
    public static void sendPostFile(HttpClient httpClient, File file, String url){
        PostMethod postMethod = new PostMethod(url);
        try {
            FilePart fp = new FilePart("filedata",file);
            Part[] parts = {fp};
            MultipartRequestEntity mre = new MultipartRequestEntity(parts,postMethod.getParams());

            //设置 MultipartRequestEntity mre请求参数（类似html页面中name属性）
            postMethod.setRequestEntity(mre);
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(ConnectTimeout);
            int status = httpClient.executeMethod(postMethod);
            if(status == HttpStatus.SC_OK){
//                log.info(postMethod.getResponseBodyAsString());
            }else {
//                log.info("失败，请求url" + url);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            postMethod.releaseConnection();
        }

    }

}
