package com.alan.test.config;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class HttpClientUtils {


    private static String getStringByStream(InputStream inputStream){
        Reader reader;
        try {
            reader=new InputStreamReader(inputStream,"UTF-8");
            char[] rawBuffer=new char[512];
            StringBuffer buffer=new StringBuffer();
            int length;
            while ((length=reader.read(rawBuffer))!=-1){
                buffer.append(rawBuffer,0,length);
            }
            return buffer.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        boolean b = HttpClientUtils.submitDataByPost("http://www.baidu.com", null);
        System.out.println(b);
    }

    /**
     * Get方式发请求
     * @param path
     * @param map
     * @return
     * @throws Exception
     */
    public static boolean submitDataByGet(String path, Map<String, String> map) throws Exception{//注意参数的设定
        //请求地址的格式  http://localhost:7777/AndroidWeb/AndroidAction?username=xxxx&age=18
        //拼接请求地址
        if(map != null){
            StringBuilder builder=new StringBuilder(path);
            builder.append("?");
            for (Map.Entry<String, String> e :map.entrySet() ) {
                builder.append(e.getKey()).append("=").append(e.getValue());
                builder.append("&");
            }
            builder.deleteCharAt(builder.length()-1);
            path=builder.toString();//更新后的路径
        }

        //网络的连接
        URL url=new URL(path);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setReadTimeout(5*1000);
        if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
            return true;
        }
        return false;

    }
    //Post方式的提交
    public static boolean submitDataByPost(String path,Map<String, String> map) throws Exception{//注意参数的设定
        //请求地址的格式  http://localhost:7777/AndroidWeb/AndroidAction?username=xxxx&age=18
        //拼接请求地址
        if(map != null){
            StringBuilder builder=new StringBuilder(path);
            builder.append("?");
            for (Map.Entry<String, String> e :map.entrySet() ) {
                builder.append(e.getKey()).append("=").append(e.getValue());
                builder.append("&");
            }
            builder.deleteCharAt(builder.length()-1);
            path=builder.toString();//更新后的路径
        }

        //网络的连接
        URL url=new URL(path);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setReadTimeout(5*1000);

        //专门的为Post提交设置请求参数
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        //设置发送的内容的长度
        conn.setRequestProperty("Content-Length",String.valueOf(path.getBytes().length));//post的请求时2进制的发送
        OutputStream outputStream=conn.getOutputStream();
        outputStream.write(path.getBytes());

        if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
            String str = getStringByStream(conn.getInputStream());
            return true;
        }
        return false;

    }
}
