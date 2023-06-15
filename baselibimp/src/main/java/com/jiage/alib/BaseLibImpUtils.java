package com.jiage.alib;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

public class BaseLibImpUtils {
    private volatile static BaseLibImpUtils sInstance;//禁止指令重排

    public static BaseLibImpUtils getInstance() {
        if (sInstance == null) {
            synchronized (BaseLibImpUtils.class) {
                if (sInstance == null) {
                    sInstance = new BaseLibImpUtils();
                }
            }
        }
        return sInstance;
    }

    public String bean2Json(Object o) {
        String jsonStr = JSON.toJSONString(o);//不能直接使用依赖库中compileOnly引用的库，本工程需再次引入
        return jsonStr;
    }

    public String bean2Gson(Object o) {
        Gson gson = new Gson();//google Gson; 不能直接使用依赖库中implementation引用的库，本工程需再次引入
        String jsonStr = gson.toJson(o);
        return jsonStr;
    }

    public String bean2Jasckjson(Object o) {
        String jsonStr = null;
        try {
            jsonStr = new ObjectMapper().writeValueAsString(o);//可以直接使用依赖库中api引用的库
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
