package jmessage.example.com.nongshangtong.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ii on 2016/4/8.
 */
public class TitleUtil {

    private Context context;

    //title.xml
    private TextView txt_center;
    private ImageView imageLeft;
    private ImageView imageRight;

    public TitleUtil(Context context) {
        this.context = context;
    }

    /**
     * 初始化布局
     */
    public void init(TextView txt_center,ImageView imageLeft,ImageView imageRight) {

        this.txt_center = txt_center;
        this.imageLeft = imageLeft;
        this.imageRight = imageRight;

        //默认不显示
        imageLeft.setVisibility(View.GONE);
        imageRight.setVisibility(View.GONE);
    }

    /**
     * 设置中间标题
     * @param center
     */
    public void setTitleCenter(String center) {
        txt_center.setText(center);
    }

    /**
     * 设置左边图标
     * @param imageRightId
     */
    public void setImageRight(int imageRightId) {
        imageRight.setImageResource(imageRightId);
        imageRight.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边图标
     * @param imageLeftId
     */
    public void setImageLeft(int imageLeftId) {
        imageLeft.setImageResource(imageLeftId);
        imageLeft.setVisibility(View.VISIBLE);
    }
}
