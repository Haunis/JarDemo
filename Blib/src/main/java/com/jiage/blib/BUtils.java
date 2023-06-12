package com.jiage.blib;

import com.alibaba.fastjson.JSON;

public class BUtils {
    private volatile static BUtils sInstance;//禁止指令重排

    public static BUtils getInstance() {
        if (sInstance == null) {
            synchronized (BUtils.class) {
                if (sInstance == null) {
                    sInstance = new BUtils();
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
