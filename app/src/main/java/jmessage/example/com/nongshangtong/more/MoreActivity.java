package jmessage.example.com.nongshangtong.more;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jmessage.example.com.nongshangtong.R;
import jmessage.example.com.nongshangtong.homepage.MainActivity;
import jmessage.example.com.nongshangtong.utils.BottomUtil;
import jmessage.example.com.nongshangtong.utils.TitleUtil;

/**
 * Created by ii on 2016/4/8.
 */
public class MoreActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private ImageView imageView;
    private List<Map<String, Object>> list ;

    //标题栏和底边栏
    private TitleUtil titleUtil;
    private BottomUtil bottomUtil;
    //title
    private TextView txt_center;
    private ImageView imageLeft;
    private ImageView imageRight;
    //bottom
    private RadioGroup radioGroup;
    private RadioButton radbtn_homepage;
    private RadioButton radbtn_farmProduce;
    private RadioButton radbtn_IndustryInfo;
    private RadioButton radbtn_more;


    private int imageIds[] = {
            R.mipmap.aboutus,R.mipmap.feedback,R.mipmap.zhaoshangjiameng,
            R.mipmap.yijiandaohang,R.mipmap.yijianyoujian,R.mipmap.yijianboda,
            R.mipmap.yijianfenxiang,R.mipmap.yijiansaomiao,R.mipmap.yijiansousuo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_more);

        list = new ArrayList<>();
        gridView = (GridView) findViewById(R.id.gridView_more);
        gridView.setOnItemClickListener(this);

        //初始化
        init();

        load();
    }

    /**
     * 加载布局
     */
    private void init() {

        //标题栏
        txt_center = (TextView) findViewById(R.id.txt_title_center);
        imageLeft = (ImageView) findViewById(R.id.image_title_left);
        imageRight = (ImageView) findViewById(R.id.image_title_right);
        titleUtil = new TitleUtil(this);
        titleUtil.init(txt_center, imageLeft, imageRight);
        titleUtil.setTitleCenter("更 多");

        //底边栏
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup_bottom);
        radbtn_farmProduce = (RadioButton) findViewById(R.id.radbtn_bottom_farmProduce);
        radbtn_homepage = (RadioButton) findViewById(R.id.radbtn_bottom_homepage);
        radbtn_IndustryInfo = (RadioButton) findViewById(R.id.radbtn_bottom_industryInfo);
        radbtn_more = (RadioButton) findViewById(R.id.radbtn_bottom_more);
        bottomUtil = new BottomUtil(this);
        bottomUtil.init(radioGroup, radbtn_farmProduce,
                radbtn_homepage, radbtn_IndustryInfo, radbtn_more);
    }

    /**
     * 加载内容
     */
    private void load() {

        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageIds[i]);
            list.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,
                R.layout.layout_more_item,
                new String[]{"image"},
                new int[]{R.id.image_more_item}
        );
        gridView.setAdapter(simpleAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(MoreActivity.this,"您点击的是："+ (position + 1),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bottomUtil.isFinish) {
            MoreActivity.this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bottomUtil.isFinish) {
            MoreActivity.this.finish();
        }
    }
}
