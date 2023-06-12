package com.jiage.alib;

import com.alibaba.fastjson.JSON;

public class AUtils {
    private volatile static AUtils sInstance;//禁止指令重排

    public static AUtils getInstance() {
        if (sInstance == null) {
            synchronized (AUtils.class) {
                if (sInstance == null) {
                    sInstance = new AUtils();
                }
            }
        }
        return sInstance;
    }

    public String bean2Json(Object o) {
        String jsonStr = JSON.toJSONString(o);
        return jsonStr;

    }
}
