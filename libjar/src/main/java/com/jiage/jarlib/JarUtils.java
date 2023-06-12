package com.jiage.jarlib;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

public class JarUtils {
    private volatile static JarUtils sInstance;//禁止指令重排

    public static JarUtils getInstance() {
        if (sInstance == null) {
            synchronized (JarUtils.class) {
                if (sInstance == null) {
                    sInstance = new JarUtils();
                }
            }
        }
        return sInstance;
    }

    public String bean2Json(Object o) {
        String jsonStr = JSON.toJSONString(o);//fastjson
        return jsonStr;
    }

    public String bean2Gson(Object o) {
        Gson gson = new Gson();//google Gson
        String jsonStr = gson.toJson(o);
        return jsonStr;
    }
}
