package com.example.currierbrother.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class tuling{
    public static void main(String[] args) throws IOException {
        String APIKEY = "a680592ba5fa49c98ce32bde12430ed9";
        String question = "你好";//这是上传给云机器人的问题
        String INFO = URLEncoder.encode(question, "utf-8");
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO; 
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect(); 

        // 取得输入流，并使用Reader读取 
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer(); 
        String line = ""; 
        while ((line = reader.readLine()) != null) { 
            sb.append(line); 
        } 
        reader.close(); 
        // 断开连接 
        connection.disconnect(); 
        System.out.println(sb); 

    }
}