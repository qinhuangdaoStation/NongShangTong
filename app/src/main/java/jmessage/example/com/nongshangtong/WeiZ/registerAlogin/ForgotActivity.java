package jmessage.example.com.nongshangtong.WeiZ.registerAlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.ResetPasswordByEmailListener;
import jmessage.example.com.nongshangtong.R;

/**
 * Created by ii on 2016/4/13.
 */
public class ForgotActivity extends AppCompatActivity{

    private EditText email;
    private TextView tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pass_forgot);

        email = (EditText) findViewById(R.id.fogot_email);
        tips = (TextView) findViewById(R.id.forgot_tv_tips);
        findViewById(R.id.forgot_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser.resetPasswordByEmail(ForgotActivity.this, email.getText().toString(), new ResetPasswordByEmailListener() {
                    @Override
                    public void onSuccess() {
                        tips.setText("重置密码请求成功!\n请到" + email.getText().toString() + "邮箱进行密码重置操作");
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        tips.setText("重置密码失败:\n" + s);
                    }
                });
            }
        });
        findViewById(R.id.iv_forgot_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
