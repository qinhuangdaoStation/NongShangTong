package jmessage.example.com.nongshangtong.WeiZ.registerAlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;
import jmessage.example.com.nongshangtong.R;
import jmessage.example.com.nongshangtong.homepage.MainActivity;

/**
 * Created by ii on 2016/4/12.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user_num;
    private EditText user_password;
    private Button btn_login;
    private Button btn_register;
    private CheckBox cb_repassword;
    private TextView tv_forgot;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        initview();
    }

    private void initview() {
        user_num = (EditText) findViewById(R.id.login_num);
        user_password = (EditText) findViewById(R.id.login_password);
        btn_login = (Button) findViewById(R.id.login_btn_enter);
        btn_register = (Button) findViewById(R.id.login_btn_register);
        cb_repassword = (CheckBox) findViewById(R.id.login_re_password);
        tv_forgot = (TextView) findViewById(R.id.login_forgot_password);
        iv_back = (ImageView) findViewById(R.id.iv_login_back);

        //监听事件
        iv_back.setOnClickListener(this);
        tv_forgot.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_login_back:
                //返回上一级界面
                finish();
                break;
            case R.id.login_forgot_password:
                //跳转找回密码界面 //
                Intent intent = new Intent(this,ForgotActivity.class);
                startActivity(intent);
                break;
            case R.id.login_btn_enter:
                //登录操作
                login();
                break;
            case R.id.login_btn_register:
                //跳转注册界面
                Intent i = new Intent(this,RegisterActivity.class);
                startActivity(i);
                break;
        }
    }

    private void login() {
        String num = user_num.getText().toString();
        String password = user_password.getText().toString();

        if (num.length() == 11) {
            if ((password.length() >= 6) && (password.length() <= 20)) {
                post_user(user_num.getText().toString(), user_password.getText().toString());
            } else {
                showToast(getString(R.string.login_error_2));
            }
        } else {
            showToast(getString(R.string.Login_error_1));
        }
    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void post_user(String num, String passw) {
        //向后端传输 // TODO: 2016/4/12
        MyUser user = new MyUser();
        user.setUsername(num);
        user.setPassword(passw);

        user.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
                //成功登录 跳转主页面？————会员界面？
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                showToast(s);
            }
        });

    }
}
