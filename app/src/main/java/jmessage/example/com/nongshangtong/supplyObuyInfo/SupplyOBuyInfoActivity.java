package jmessage.example.com.nongshangtong.supplyObuyInfo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jmessage.example.com.nongshangtong.R;


/**
 * Created by ii on 2016/4/7.
 */
public class SupplyOBuyInfoActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private TextView txt_title_center;
    private TextView txt_supply_info;
    private TextView txt_buy_info;

    //判断是否是在那个栏目，默认是在供应栏
    private Boolean isSupply = true;

    //供求信息列表
    private List<SupplyOBuyBean> listSupply = new ArrayList<SupplyOBuyBean>();
    private List<SupplyOBuyBean> listBuy = new ArrayList<SupplyOBuyBean>();

    private SupplyOBuyInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_supply_buy_info);

        //初始化布局控件
        init();

        //初始化供求信息
        addBuyBeans();
        addSupplyBeans();

        //默认加载供应信息栏
        loadInfo(listSupply);
    }

    private void init() {
        txt_buy_info = (TextView) findViewById(R.id.txt_buy_info);
        txt_supply_info = (TextView) findViewById(R.id.txt_supply_info);
        txt_title_center = (TextView) findViewById(R.id.txt_title_center);

        txt_title_center.setText("供 求 信 息");
        //默认显示供应信息栏
        txt_supply_info.setBackgroundColor(Color.GRAY);

        //监听供应和求购栏的转换
        txt_supply_info.setOnClickListener(this);
        txt_buy_info.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

    }

    /**
     * listView Item 监听
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(SupplyOBuyInfoActivity.this,"您点击的是：" + position + 1,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_buy_info:

                isSupply = false;
                loadInfo(listBuy);
                txt_buy_info.setBackgroundColor(Color.GRAY);
                txt_supply_info.setBackgroundColor(Color.WHITE);

                break;
            case R.id.txt_supply_info:

                isSupply = true;
                loadInfo(listSupply);
                txt_supply_info.setBackgroundColor(Color.GRAY);
                txt_buy_info.setBackgroundColor(Color.WHITE);

                break;
        }
    }

    /**
     * 加载供求信息
     * @param list
     */
    public void loadInfo(List<SupplyOBuyBean> list) {
        adapter = new SupplyOBuyInfoAdapter(SupplyOBuyInfoActivity.this, list);
        listView.setAdapter(adapter);
    }

    /**
     * 供应信息
     */
    public void addSupplyBeans() {
        SupplyOBuyBean bean01 = new SupplyOBuyBean();
        bean01.setDateTime("2016-04-08 15:07");
        bean01.setProduce("秦皇岛大苹果");
        bean01.setProduceImage(R.mipmap.apple);
        bean01.setPublishHuman("吴先生");
        listSupply.add(bean01);

        SupplyOBuyBean bean02 = new SupplyOBuyBean();
        bean02.setDateTime("2016-04-05 10:36");
        bean02.setProduce("杉树庙");
        bean02.setProduceImage(R.mipmap.shanshumiao);
        bean02.setPublishHuman("陈先生");
        listSupply.add(bean02);

        SupplyOBuyBean bean03 = new SupplyOBuyBean();
        bean03.setDateTime("2016-03-20 16:26");
        bean03.setProduce("供应杨梅水果");
        bean03.setProduceImage(R.mipmap.yangmei);
        bean03.setPublishHuman("梁女士");
        listSupply.add(bean03);

        SupplyOBuyBean bean04 = new SupplyOBuyBean();
        bean04.setDateTime("2016-03-20 20:56");
        bean04.setProduce("供应大量冬瓜，南瓜");
        bean04.setProduceImage(R.mipmap.nangua);
        bean04.setPublishHuman("孙先生");
        listSupply.add(bean04);

        SupplyOBuyBean bean05 = new SupplyOBuyBean();
        bean05.setDateTime("2016-03-08 15:07");
        bean05.setProduce("供应牛奶，纯正无添加");
        bean05.setProduceImage(R.mipmap.niunai);
        bean05.setPublishHuman("吴先生");
        listSupply.add(bean05);

        SupplyOBuyBean bean06 = new SupplyOBuyBean();
        bean06.setDateTime("2016-02-08 15:07");
        bean06.setProduce("提供蔬菜农产品配送");
        bean06.setProduceImage(R.mipmap.peisong);
        bean06.setPublishHuman("农蔬配送公司");
        listSupply.add(bean06);
    }

    /**
     * 求购信息
     */
    public void addBuyBeans() {
        SupplyOBuyBean bean01 = new SupplyOBuyBean();
        bean01.setDateTime("2016-04-08 15:07");
        bean01.setProduce("大苹果");
        bean01.setProduceImage(R.mipmap.apple);
        bean01.setPublishHuman("闻先生");
        listBuy.add(bean01);

        SupplyOBuyBean bean02 = new SupplyOBuyBean();
        bean02.setDateTime("2016-04-05 10:36");
        bean02.setProduce("新鲜百合花");
        bean02.setProduceImage(R.mipmap.baihehua);
        bean02.setPublishHuman("广女士");
        listBuy.add(bean02);

        SupplyOBuyBean bean03 = new SupplyOBuyBean();
        bean03.setDateTime("2016-03-20 16:26");
        bean03.setProduce("夏日杨梅水果");
        bean03.setProduceImage(R.mipmap.yangmei);
        bean03.setPublishHuman("谷女士");
        listBuy.add(bean03);

        SupplyOBuyBean bean04 = new SupplyOBuyBean();
        bean04.setDateTime("2016-03-20 20:56");
        bean04.setProduce("海南椰子");
        bean04.setProduceImage(R.mipmap.hainanyezi);
        bean04.setPublishHuman("祖先生");
        listBuy.add(bean04);

        SupplyOBuyBean bean05 = new SupplyOBuyBean();
        bean05.setDateTime("2016-03-08 15:07");
        bean05.setProduce("红玉米");
        bean05.setProduceImage(R.mipmap.hongyumi);
        bean05.setPublishHuman("项女士");
        listBuy.add(bean05);
    }
}
