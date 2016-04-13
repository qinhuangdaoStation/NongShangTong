package jmessage.example.com.nongshangtong.homepage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import jmessage.example.com.nongshangtong.R;
import jmessage.example.com.nongshangtong.homepage.HomePageUtil;
import jmessage.example.com.nongshangtong.more.MoreActivity;

/**
 * Created by ii on 2016/4/9.
 */
public class MainActivity extends AppCompatActivity{
    private int screenWidth;
    private int screenHeight;

    private HomePageUtil util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //从这里跳转到更多界面
                util.activityStart(MoreActivity.class);
                MainActivity.this.finish();
            }
        });
        //以上暂且保留，以下是正常开始

        //获取屏幕长宽，并捕捉外部触摸屏幕的坐标
        getScreenWidthHeight();

    }

    private void getScreenWidthHeight() {

        //方法一
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        Log.i("test", "第一种方法，" + "宽度为：" + screenWidth + ",长度为：" + screenHeight);

        //        //方法二
        //        DisplayMetrics dm2 = new DisplayMetrics();
        //        getWindowManager().getDefaultDisplay().getMetrics(dm2);
        //        screenWidth = dm2.widthPixels;
        //        screenHeight = dm2.heightPixels;
        //        Log.i("test", "第二种方法，" + "宽度为：" + screenWidth + ",长度为：" + screenHeight);

        //工具类
        util = new HomePageUtil(this, screenWidth, screenHeight);

    }

    // 获取整个activity屏幕触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        handleTouch(event);

        return true;    // 注意！！这里一定要返回true！！
    }

    /**
     * 获得触摸事件
     * @param event
     */
    private void handleTouch(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
        Log.i("test", "触摸的位置坐标为：" + x + "," + y);

        int touch = event.getAction();
        switch (touch) {
            case MotionEvent.ACTION_DOWN: // 按下
                break;
            case MotionEvent.ACTION_MOVE: // 移动
                break;
            case MotionEvent.ACTION_UP: // 抬起

                //获取对应界面的序号
                int numActivity = util.returnAcitivityNum(x, y);
                //跳转到相应的界面
                util.NumActivityStart(numActivity);

                break;
            default:
                break;
        }
    }
}

