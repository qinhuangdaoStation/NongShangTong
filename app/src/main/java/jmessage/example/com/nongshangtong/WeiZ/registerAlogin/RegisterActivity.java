package jmessage.example.com.nongshangtong.WeiZ.registerAlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;
import jmessage.example.com.nongshangtong.R;

/**
 * Created by ii on 2016/4/13.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText phone_num;
    private EditText password;
    private EditText password_re;
    private Button register;
    private ImageView back;
    private EditText user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        initview();
    }

    private void initview() {
        password = (EditText) findViewById(R.id.register_password);
        password_re = (EditText) findViewById(R.id.register_password_re);
        user_email = (EditText) findViewById(R.id.register_email);
        phone_num = (EditText) findViewById(R.id.register_num);
        register = (Button) findViewById(R.id.register_btn_register);
        back = (ImageView) findViewById(R.id.iv_register_back);
        register.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_register_back:
                finish();
                break;
            case R.id.register_btn_register:
                String num = phone_num.getText().toString();
                String pass = password.getText().toString();
                String email = user_email.getText().toString() ;
                //判断手机号的长度以及密码长度是否正确
                if (num.length() == 11) {
                    if ((pass.length() >= 6) && (pass.length() <= 20)) {

                        if(pass.equals(password_re.getText().toString()))
                            register(num,pass,email);
                        else showToast(getString(R.string.login_error_3));
                    } else {
                        showToast(getString(R.string.login_error_2));
                    }
                } else {
                    showToast(getString(R.string.Login_error_1));
                }
                break;
        }
    }

    private void register(String num,String passw,String email) {
        //注册账号

        MyUser user =new MyUser();
        user.setUsername(num);
        user.setPassword(passw);
        user.setEmail(email);

        user.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                showToast(getString(R.string.success_register));
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                showToast(s);
            }
        });

    }
    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
