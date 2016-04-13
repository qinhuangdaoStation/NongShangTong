package jmessage.example.com.nongshangtong.aboutUs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import jmessage.example.com.nongshangtong.R;
import jmessage.example.com.nongshangtong.utils.TitleUtil;

/**
 * Created by ii on 2016/4/9.
 */
public class AboutUs extends AppCompatActivity {

    private TitleUtil titleUtil;
    private TextView txt_title_center;
    private ImageView imageLeft;
    private ImageView imageRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_about_us);

        titleUtil = new TitleUtil(this);

        txt_title_center = (TextView) findViewById(R.id.txt_title_center);
        imageLeft = (ImageView) findViewById(R.id.image_title_left);
        imageRight = (ImageView) findViewById(R.id.image_title_right);

        titleUtil.init(txt_title_center,imageLeft,imageRight);
        titleUtil.setTitleCenter("关于我们");
        titleUtil.setImageLeft(R.mipmap.back);
    }
}
