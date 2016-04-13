package jmessage.example.com.nongshangtong.agriculturalTradeMall;

/**  农贸商城 单例类
 * Created by ii on 2016/4/9.
 */
public class MallBean {

    private String txt_produce_mall;          //商品简介
    private double txt_price_mall;            //商品价格
    private Integer txt_hadBuyNum_mall;        //已购买人数
    private String image_produceIcon;

    private int image_produceIconTest;        //这里做测试用

    public String getTxt_produce_mall() {
        return txt_produce_mall;
    }

    public void setTxt_produce_mall(String txt_produce_mall) {
        this.txt_produce_mall = txt_produce_mall;
    }

    public double getTxt_price_mall() {
        return txt_price_mall;
    }

    public void setTxt_price_mall(double txt_price_mall) {
        this.txt_price_mall = txt_price_mall;
    }

    public Integer getTxt_hadBuyNum_mall() {
        return txt_hadBuyNum_mall;
    }

    public void setTxt_hadBuyNum_mall(Integer txt_hadBuyNum_mall) {
        this.txt_hadBuyNum_mall = txt_hadBuyNum_mall;
    }

    public String getImage_produceIcon() {
        return image_produceIcon;
    }

    public void setImage_produceIcon(String image_produceIcon) {
        this.image_produceIcon = image_produceIcon;
    }

    public int getImage_produceImageTest() {
        return image_produceIconTest;
    }

    public void setImage_produceImageTest(int image_produceImage) {
        this.image_produceIconTest = image_produceImage;
    }
}
