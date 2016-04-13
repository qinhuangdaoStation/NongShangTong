package jmessage.example.com.nongshangtong.other;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import cn.bmob.v3.BmobUser;
import jmessage.example.com.nongshangtong.R;
import jmessage.example.com.nongshangtong.homepage.MainActivity;
import jmessage.example.com.nongshangtong.WeiZ.registerAlogin.LoginActivity;

/**
 * Created by ii on 2016/4/12.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BmobUser user = BmobUser.getCurrentUser(WelcomeActivity.this);
                Intent intent;
                if (user != null) {
                    intent = new Intent(WelcomeActivity.this, MainActivity.class);


                } else {
                    intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();

            }
        }, 2000);
    }
}
