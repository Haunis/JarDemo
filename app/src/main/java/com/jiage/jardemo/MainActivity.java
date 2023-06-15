/*
 * gradle 引入jackjson：
 *      参考: https://stackoverflow.com/questions/69707268/jackson-not-being-imported-with-gradle
 *      implementation 'com.fasterxml.jackson.core:jackson-databind:2.0.1'
 *
 *  compileOnly: 只参与编译，运行时主工程要引入相应的依赖包，否则运行会报错
 *
 *  主工程使用依赖库：
 *      1. 主工程不能直接使用依赖库中 compileOnly和implementation引用的包； 如果要用，主工程需单独引入
 *      2. 主工程使用的依赖库中有compileOnly引入的包时，主工程需要再次引入打包，否则运行会报错
 *      3. 主工程可以使用依赖库中api引用的包
 *
 *  主工程使用aar包：
 *      如果aar包引用了其他包，主工程必须再次引入，否则运行会报错
 */
package com.jiage.jardemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jiage.alib.BaseLibImpUtils;
//import com.jiage.blib.LibAarImpUtils;
//import com.jiage.blib.LibAarImpUtils;
//import com.jiage.baselib.BaseLibUtils;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jiage.alib.AUtils;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jiage.jarlib.JarUtils;
//import com.jiage.libaar.AarUtils;

import com.jiage.jarlib.JarUtils;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTvContent;
    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvContent = findViewById(R.id.tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_to_json:
                try {
                    testBaseLib();//基础库，库里使用了compileOnly,implementation,api三种方式引入其他包

                    testBaseLibImp();//依赖baselib

                    testAar();//aar, 使用了compileOnly,implementation,api三种方式引入其他包
                    testAarImp();
//
                    testJar();//jar,使用了compileOnly,implementation,api三种方式引入其他包

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void testJar() throws IOException {
        Person p = new Person("张三", 22);
        String jsonStr1 = JarUtils.getInstance().bean2Json(p);//依赖包使用compileOnly引入fastjson，编译OK，运行会报错，主工程需引入依赖包

        String jsonStr2 = JarUtils.getInstance().bean2Gson(p);//Gson; 依赖包使用implementation引入GSON，编译OK，运行会报错，主工程需引入依赖包

        String jsonStr3 = JarUtils.getInstance().bean2Jasckjson(p);//api 方式; 主工程必须引入依赖，否则运行报错
//        String str4 = new ObjectMapper().writeValueAsString(p);//可以使用依赖库中api引用的库

        mTvContent.setText("");

        String ret = "str1=" + jsonStr1
                + "\nstr2=" + jsonStr2 + "\nstr3=" + jsonStr3
//                + "\nstr4=" + str4
                ;
        Log.i(TAG, "testJar(), ret=" + ret);
    }

    private void testAar() throws IOException {
//        Person p = new Person("张三", 22);
//        String jsonStr1 = AarUtils.getInstance().bean2Json(p);//依赖包使用compileOnly引入fastjson，编译OK，运行会报错，主工程需引入依赖包
//
//        String jsonStr2 = AarUtils.getInstance().bean2Gson(p);//Gson; 依赖包使用implementation引入GSON，编译OK，运行会报错，主工程需引入依赖包
//
//        String jsonStr3 = AarUtils.getInstance().bean2Jasckjson(p);//api 方式; 主工程必须引入依赖，否则运行报错
////        String str4 = new ObjectMapper().writeValueAsString(p);//可以使用依赖库中api引用的库
//
//        mTvContent.setText("");
//
//        String ret = "testAAR()"
//                + "\nstr1=" + jsonStr1 + "\nstr2=" + jsonStr2 + "\nstr3=" + jsonStr3
////                + "\nstr4=" + str4
//                ;
//        Log.i(TAG, ret);
    }

    private void testAarImp() {
//        Person p = new Person("张三", 22);
//        String jsonStr1 = LibAarImpUtils.getInstance().bean2Json(p);//依赖包使用compileOnly引入fastjson，编译OK，运行会报错，主工程需引入依赖包
//
//        String jsonStr2 = LibAarImpUtils.getInstance().bean2Gson(p);//Gson; 依赖包使用implementation引入GSON，编译OK，运行会报错，主工程需引入依赖包
//
//        String jsonStr3 = LibAarImpUtils.getInstance().bean2Jasckjson(p);//api 方式; 主工程必须引入依赖，否则运行报错
////        String str4 = new ObjectMapper().writeValueAsString(p);//可以使用依赖库中api引用的库
//
//        mTvContent.setText("");
//
//        String ret = "testAarImp()"
//                + "\nstr1=" + jsonStr1 + "\nstr2=" + jsonStr2 + "\nstr3=" + jsonStr3
////                + "\nstr4=" + str4
//                ;
//        Log.i(TAG, ret);
    }

    private void testBaseLibImp() throws IOException {
//        Person p = new Person("张三", 22);
//        String jsonStr1 = BaseLibImpUtils.getInstance().bean2Json(p);//fastjson
//
//        String jsonStr2 = BaseLibImpUtils.getInstance().bean2Gson(p);//json
//
//        String jsonStr3 = BaseLibImpUtils.getInstance().bean2Jasckjson(p);//api 方式
////        String str4 = new ObjectMapper().writeValueAsString(p);//可以使用依赖库中api引用的库
//
//        mTvContent.setText("");
//
//        String ret = "str1=" + jsonStr1
//                + "\nstr2=" + jsonStr2 + "\nstr3=" + jsonStr3
////                + "\nstr4=" + str4
//                ;
//        mHandler.postDelayed(() -> {
//            mTvContent.setText(ret);
//        }, 300);
    }

    private void testBaseLib() throws IOException {
//        Person p = new Person("张三", 22);
//        String jsonStr1 = BaseLibUtils.getInstance().bean2Json(p);//依赖包使用compileOnly引入fastjson，编译OK，运行会报错，主工程需引入依赖包
//
//        String jsonStr2 = BaseLibUtils.getInstance().bean2Gson(p);//ok; implementation
////        Gson gson = new Gson();//google Gson; error，不能使用依赖库中implementation引用的库
//
//        String jsonStr3 = BaseLibUtils.getInstance().bean2Jasckjson(p);//ok; api 方式
////        String str4 = new ObjectMapper().writeValueAsString(p);//可以使用依赖库中api引用的库
//
//        mTvContent.setText("");
//
//        String ret = "str1=" + jsonStr1 + "\nstr2="
//                + jsonStr2 + "\nstr3=" + jsonStr3
////                + "\nstr4=" + str4
//                ;
//        Log.i(TAG, "testBaseLib(), ret=" + ret);
    }
}