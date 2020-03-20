package com.example.demo.utils;/*
 * @author p78o2
 * @date 2019/8/28
 */

import okhttp3.*;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpUtils {
    public static String get(String url, Map<String,Object> params) {
        String requestUrl = url+"?";
        for (String key : params.keySet()) {
            requestUrl+=key+"="+params.get(key)+"&";
        }
        requestUrl = requestUrl.substring(0,requestUrl.length() - 1);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(requestUrl)
                .get()
                .addHeader("cache-control", "no-cache")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String resultStr = response.body().string();
            return resultStr;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
//    json/application post请求方式
    public static String post(String url,String data){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, data);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String resultStr = response.body().string();
            return resultStr;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

//    form表单
    public static String formPost(String url,Map<String,Object> params){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        //post方式提交的数据
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : params.keySet()) {
            builder.add(key,(String)params.get(key));
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
            .url(url)
            .post(formBody)
            .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            String resultStr = response.body().string();
            return resultStr;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
