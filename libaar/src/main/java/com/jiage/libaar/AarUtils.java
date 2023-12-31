package com.jiage.libaar;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

public class AarUtils {
    private volatile static AarUtils sInstance;//禁止指令重排

    public static AarUtils getInstance() {
        if (sInstance == null) {
            synchronized (AarUtils.class) {
                if (sInstance == null) {
                    sInstance = new AarUtils();
                }
            }
        }
        return sInstance;
    }

    public String bean2Json(Object o) {
        String jsonStr = JSON.toJSONString(o);
        return jsonStr;
    }

    public String bean2Gson(Object o) {
        Gson gson = new Gson();//google Gson
        String jsonStr = gson.toJson(o);
        return jsonStr;
    }

    public String bean2Jasckjson(Object o) {
        String jsonStr = null;
        try {
            jsonStr = new ObjectMapper().writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
