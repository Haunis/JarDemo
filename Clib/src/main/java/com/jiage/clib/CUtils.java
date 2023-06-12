package com.jiage.clib;

//import com.alibaba.fastjson.JSON;

//import com.jiage.alib.AUtils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

public class CUtils {
    private volatile static CUtils sInstance;//禁止指令重排

    public static CUtils getInstance() {
        if (sInstance == null) {
            synchronized (CUtils.class) {
                if (sInstance == null) {
                    sInstance = new CUtils();
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
