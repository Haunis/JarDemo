package com.jiage.baselib;

//import com.alibaba.fastjson.JSON;

//import com.jiage.alib.AUtils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

public class BaseLibUtils {
    private volatile static BaseLibUtils sInstance;//禁止指令重排

    public static BaseLibUtils getInstance() {
        if (sInstance == null) {
            synchronized (BaseLibUtils.class) {
                if (sInstance == null) {
                    sInstance = new BaseLibUtils();
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
