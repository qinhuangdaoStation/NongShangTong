package jmessage.example.com.nongshangtong.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import jmessage.example.com.nongshangtong.R;
import jmessage.example.com.nongshangtong.homepage.HomePageUtil;
import jmessage.example.com.nongshangtong.homepage.MainActivity;
import jmessage.example.com.nongshangtong.more.MoreActivity;

/**           todo                  待完善！！！！！！！！！！！！！！！
 * Created by ii on 2016/4/8.
 */
public class BottomUtil {

    //这里，主要是借助它的activity跳转方法
    private HomePageUtil util;
    private Context context;

    private RadioGroup radioGroup;
    private RadioButton radbtn_homepage;
    private RadioButton radbtn_farmProduce;
    private RadioButton radbtn_IndustryInfo;
    private RadioButton radbtn_more;

    private LinearLayout layout_bottom;

    public boolean isFinish = false;        //默认不关闭当前activity

    public BottomUtil(Context context) {
        this.context = context;
        util = new HomePageUtil(context);
    }

    /**
     * 初始化布局
     */
    public void init(RadioGroup radioGroup,RadioButton radbtn_farmProduce,
                     RadioButton radbtn_homepage, RadioButton radbtn_IndustryInfo,
                     RadioButton radbtn_more) {

        this.radioGroup = radioGroup;
        this.radbtn_more = radbtn_more;
        this.radbtn_IndustryInfo = radbtn_IndustryInfo;
        this.radbtn_homepage = radbtn_homepage;
        this.radbtn_farmProduce = radbtn_farmProduce;

        //设置为“更多”的选择界面
        colorChange(4);
        isFinish = false;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radbtn_bottom_homepage:               //首页
                        colorChange(1);
                        isFinish = true;
                        util.activityStart(MainActivity.class);
                        break;
                    case R.id.radbtn_bottom_farmProduce:            //农产品
                        colorChange(2);
                        isFinish = true;
                        Toast.makeText(context, "农产品界面还在开发中~", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radbtn_bottom_industryInfo:           //农贸商城
                        colorChange(3);
                        isFinish = true;
                        Toast.makeText(context,"农贸商城界面还在开发中~",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radbtn_bottom_more:                   //更多
                        colorChange(4);
                        isFinish = true;
                        util.activityStart(MoreActivity.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * 背景颜色变化
     * @param num
     */
    public void colorChange(int num) {
        switch (num) {
            case 1:                                                   //首页
                radbtn_homepage.setBackgroundColor(Color.GREEN);
                radbtn_farmProduce.setBackgroundColor(Color.GRAY);
                radbtn_IndustryInfo.setBackgroundColor(Color.GRAY);
                radbtn_more.setBackgroundColor(Color.GRAY);
                break;
            case 2:                                                   //农产品
                radbtn_homepage.setBackgroundColor(Color.GRAY);
                radbtn_farmProduce.setBackgroundColor(Color.GREEN);
                radbtn_IndustryInfo.setBackgroundColor(Color.GRAY);
                radbtn_more.setBackgroundColor(Color.GRAY);
                break;
            case 3:                                                   //农贸商城
                radbtn_homepage.setBackgroundColor(Color.GRAY);
                radbtn_farmProduce.setBackgroundColor(Color.GRAY);
                radbtn_IndustryInfo.setBackgroundColor(Color.GREEN);
                radbtn_more.setBackgroundColor(Color.GRAY);
                break;
            case 4:                                                   //更多
                radbtn_homepage.setBackgroundColor(Color.GRAY);
                radbtn_farmProduce.setBackgroundColor(Color.GRAY);
                radbtn_IndustryInfo.setBackgroundColor(Color.GRAY);
                radbtn_more.setBackgroundColor(Color.GREEN);
                break;
            default:                                                  //默认
                radbtn_homepage.setBackgroundColor(Color.GRAY);
                radbtn_farmProduce.setBackgroundColor(Color.GRAY);
                radbtn_IndustryInfo.setBackgroundColor(Color.GRAY);
                radbtn_more.setBackgroundColor(Color.GRAY);
                break;
        }
    }
}
