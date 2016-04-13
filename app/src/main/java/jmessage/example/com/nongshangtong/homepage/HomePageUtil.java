package jmessage.example.com.nongshangtong.homepage;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import jmessage.example.com.nongshangtong.aboutUs.AboutUs;
import jmessage.example.com.nongshangtong.agriculturalTradeMall.AgriTradeMallActivity;
import jmessage.example.com.nongshangtong.more.MoreActivity;
import jmessage.example.com.nongshangtong.search.SearchActivity;
import jmessage.example.com.nongshangtong.supplyObuyInfo.SupplyOBuyInfoActivity;

/**
 * Created by ii on 2016/4/7.
 */
public class HomePageUtil {

    private Context context;
    private int screenWidth;
    private int screenHeight;

    public HomePageUtil(Context context) {
        this.context = context;
    }

    public HomePageUtil(Context context, int screenWidth, int screenHeight) {
        this.context = context;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    /**
     * 跳转到相应的界面
     *
     * @param numActivity
     */
    public void NumActivityStart(int numActivity) {
        switch (numActivity) {
            case 1:                                           //联系我们
                activityStart(AboutUs.class);
                break;
            case 2:                                           //一键搜索
                activityStart(SearchActivity.class);
                break;
            case 3:                                           //供求信息
                activityStart(SupplyOBuyInfoActivity.class);
                break;
            case 4:                                           //农产品
                break;
            case 5:                                           //行业资讯
                break;
            case 6:                                           //农贸商城
                activityStart(AgriTradeMallActivity.class);
                break;
            case 7:                                           //名企推荐
                break;
            case 8:                                           //会员中心

                break;
            default:
                break;
        }
    }

    /**
     * activity跳转
     *
     * @param to
     */
    public void activityStart(Class<?> to) {
        Intent intent = new Intent();
        intent.setClass(context, to);
        context.startActivity(intent);
    }

    /**
     * 根据坐标范围，获得点击界面的序号
     *
     * @param x
     * @param y
     * @return
     */
    public int returnAcitivityNum(float x, float y) {

        int num = 0;

        /**
         * 前后加减0.05*screenWidth 以及 0.05*screenHeight
         */
        if (x > screenWidth * 0.24 && x < screenWidth * 0.34 && y > screenHeight * 0.51 && y < screenHeight * 0.61) {
            Toast.makeText(context, "联系我们", Toast.LENGTH_SHORT).show();
            num = 1;
        } else if (x > screenWidth * 0.31 && x < screenWidth * 0.41 && y > screenHeight * 0.42 && y < screenHeight * 0.52) {
            Toast.makeText(context, "正在开发中~", Toast.LENGTH_SHORT).show();
            num = 2;
        } else if (x > screenWidth * 0.49 && x < screenWidth * 0.59 && y > screenHeight * 0.40 && y < screenHeight * 0.50) {
            Toast.makeText(context, "供求信息", Toast.LENGTH_SHORT).show();
            num = 3;
        } else if (x > screenWidth * 0.62 && x < screenWidth * 0.72 && y > screenHeight * 0.42 && y < screenHeight * 0.52) {
            Toast.makeText(context, "正在开发中~", Toast.LENGTH_SHORT).show();
            num = 4;
        } else if (x > screenWidth * 0.68 && x < screenWidth * 0.78 && y > screenHeight * 0.50 && y < screenHeight * 0.60) {
            Toast.makeText(context, "正在开发中~", Toast.LENGTH_SHORT).show();
            num = 5;
        } else if (x > screenWidth * 0.59 && x < screenWidth * 0.69 && y > screenHeight * 0.60 && y < screenHeight * 0.70) {
            Toast.makeText(context, "农贸商城", Toast.LENGTH_SHORT).show();
            num = 6;
        } else if (x > screenWidth * 0.47 && x < screenWidth * 0.57 && y > screenHeight * 0.63 && y < screenHeight * 0.73) {
            Toast.makeText(context, "正在开发中~", Toast.LENGTH_SHORT).show();
            num = 7;
        } else if (x > screenWidth * 0.31 && x < screenWidth * 0.41 && y > screenHeight * 0.58 && y < screenHeight * 0.68) {
            Toast.makeText(context, "正在开发中~", Toast.LENGTH_SHORT).show();
            num = 8;
        }

        return num;
    }
}
