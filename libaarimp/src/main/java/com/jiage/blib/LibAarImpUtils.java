package com.jiage.blib;


import com.jiage.libaar.AarUtils;

public class LibAarImpUtils {
    private volatile static LibAarImpUtils sInstance;//禁止指令重排

    public static LibAarImpUtils getInstance() {
        if (sInstance == null) {
            synchronized (LibAarImpUtils.class) {
                if (sInstance == null) {
                    sInstance = new LibAarImpUtils();
                }
            }
        }
        return sInstance;
    }

    public String bean2Json(Object o) {
        String jsonStr = AarUtils.getInstance().bean2Json(o);
        return jsonStr;
    }

    public String bean2Gson(Object o) {
//        Gson gson = new Gson();//google Gson; 不能直接使用依赖库中implementation引用的库，本工程需再次引入
//        String jsonStr = gson.toJson(o);
        String jsonStr = AarUtils.getInstance().bean2Gson(o);
        return jsonStr;
    }

    public String bean2Jasckjson(Object o) {
        String jsonStr = null;
        try {
//            jsonStr = new ObjectMapper().writeValueAsString(o);//可以直接使用依赖库中api引用的库
            jsonStr = AarUtils.getInstance().bean2Jasckjson(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
