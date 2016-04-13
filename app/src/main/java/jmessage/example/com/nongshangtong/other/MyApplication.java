package jmessage.example.com.nongshangtong.other;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by ii on 2016/4/12.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Bmob.initialize(this, "f3ec138a4f9efcc8683224d8dd110be4");
    }
}
