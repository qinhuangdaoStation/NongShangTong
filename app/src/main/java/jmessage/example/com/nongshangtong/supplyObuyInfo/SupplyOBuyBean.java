package jmessage.example.com.nongshangtong.supplyObuyInfo;

import android.widget.ImageView;

/**
 *    供应或求购产品单例类
 *
 * Created by ii on 2016/4/8.
 */
public class SupplyOBuyBean {

    private String produceIcon;           //产品图片
    private int produceImage;       //产品图片
    private String produce;               //产品
    private String publishHuman;          //发布人
    private String dateTime;              //发布日期和时间

    public int getProduceImage() {
        return produceImage;
    }

    public void setProduceImage(int produceImage) {
        this.produceImage = produceImage;
    }

    public String getProduceIcon() {
        return produceIcon;
    }

    public void setProduceIcon(String produceIcon) {
        this.produceIcon = produceIcon;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getPublishHuman() {
        return publishHuman;
    }

    public void setPublishHuman(String publishHuman) {
        this.publishHuman = publishHuman;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
