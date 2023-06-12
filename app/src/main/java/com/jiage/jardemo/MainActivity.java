/**
 * gradle 引入jackjson：
 *      参考: https://stackoverflow.com/questions/69707268/jackson-not-being-imported-with-gradle
 *      implementation 'com.fasterxml.jackson.core:jackson-databind:2.0.1'
 */
package com.jiage.jardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jiage.clib.CUtils;
//import com.jiage.jarlib.JarUtils;

//import com.jiage.alib.AUtils;
//import com.jiage.blib.BUtils;
//import com.jiage.clib.CUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_to_json:

                String jsonStr;
//                String jsonStr = AUtils.getInstance().bean2Json(p);
//                Log.i(TAG, "jsonStr: " + jsonStr);
//
//
//                p.name = "李四";
//                jsonStr = BUtils.getInstance().bean2Json(p);
//                Log.i(TAG, "jsonStr: " + jsonStr);
//

                testClib();

//                p.name = "王6";
//                jsonStr = JarUtils.getInstance().bean2Json(p);
//                Log.i(TAG, "jsonStr: " + jsonStr);
//
//                p.name = "王7";
//                jsonStr = JarUtils.getInstance().bean2Gson(p);
//                Log.i(TAG, "jsonStr: " + jsonStr);
                break;
        }
    }

    private void testClib() {
        Person p = new Person("张三", 22);
        String jsonStr = CUtils.getInstance().bean2Json(p);
        Log.i(TAG, "jsonStr: " + jsonStr);

        p.name = "李四";
        jsonStr = CUtils.getInstance().bean2Gson(p);
        Log.i(TAG, "jsonStr: " + jsonStr);

        p.name = "王五";
        jsonStr = CUtils.getInstance().bean2Jasckjson(p);
        Log.i(TAG, "jsonStr: " + jsonStr);
    }
}