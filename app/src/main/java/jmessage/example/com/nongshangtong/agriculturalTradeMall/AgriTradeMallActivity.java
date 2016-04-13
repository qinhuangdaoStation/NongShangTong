package jmessage.example.com.nongshangtong.agriculturalTradeMall;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import jmessage.example.com.nongshangtong.R;
import jmessage.example.com.nongshangtong.db.MallBeanData;

/**
 * Created by ii on 2016/4/9.
 */
public class AgriTradeMallActivity extends AppCompatActivity {

    private TabLayout tableLayout_mall;
    private ListView listView_mall;
    private AgrTraMallAdapter adapter;

    private MallBeanData data;

    private List<MallBean> beans01 = new ArrayList<>();
    private List<MallBean> beans02 = new ArrayList<>();
    private List<MallBean> beans03 = new ArrayList<>();
    private List<MallBean> beans04 = new ArrayList<>();
    private List<MallBean> beans05 = new ArrayList<>();
    private List<MallBean> beans06 = new ArrayList<>();
    private List<MallBean> beans07 = new ArrayList<>();
    private List<MallBean> beans08 = new ArrayList<>();
    private List<MallBean> beans09 = new ArrayList<>();

    //tabTitles
    private String[] tabTitles = {
            "鲜果直供","新鲜蔬菜","鲜肉禽蛋","休闲零食",
            "南北干货","茶饮冲调","滋补养生","粮油调味","美酒佳酿"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_agrtra_mall);

        tableLayout_mall = (TabLayout) findViewById(R.id.tabLayout_mall);
        listView_mall = (ListView) findViewById(R.id.listView_mall);

        //初始化tablayout
        initTabLayout();

        //初始化listview,默认显示第一个
        initListView(1);

    }

    /**
     * 初始化listview
     */
    private void initListView(int count) {
        //获取内容数据
        data = new MallBeanData();
        //临时变量
        List<MallBean> beans = new ArrayList<>();

        switch (count) {
            case 1:                         //鲜果直供
                beans = data.mallBeanContent01();
                break;
            case 2:                         //新鲜蔬菜
                beans = data.mallBeanContent02();
                break;
            case 3:                         //鲜肉禽蛋
                beans = data.mallBeanContent03();
                break;
            case 4:                         //休闲零食
                beans = data.mallBeanContent04();
                break;
            case 5:                         //南北干货
                beans = data.mallBeanContent05();
                break;
            case 6:                         //茶饮冲调
                beans = data.mallBeanContent06();
                break;
            case 7:                         //滋补养生
                beans = data.mallBeanContent07();
                break;
            case 8:                         //粮油调味
                beans = data.mallBeanContent08();
                break;
            case 9:                         //美酒佳酿
                beans = data.mallBeanContent09();
                break;
            default:
                break;
        }
        adapter = new AgrTraMallAdapter(this, beans);
        listView_mall.setAdapter(adapter);
    }

    /**
     * 初始化tablayout
     */
    private void initTabLayout() {
        //设置TabLayout的模式,这里主要是用来显示tab展示的情况的
        //TabLayout.MODE_FIXED          各tab平分整个工具栏,如果不设置，则默认就是这个值
        //TabLayout.MODE_SCROLLABLE     适用于多tab的，也就是有滚动条的，一行显示不下这些tab可以用这个
        //                              当然了，你要是想做点特别的，像知乎里就使用的这种效果
        tableLayout_mall.setTabMode(TabLayout.MODE_SCROLLABLE);
        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);

        //为TabLayout添加tab名称
        for (int i = 0; i < tabTitles.length; i++) {
            tableLayout_mall.addTab(tableLayout_mall.newTab().setText(tabTitles[i]));
        }

        //设置tablayout的选项卡监听
        tableLayout_mall.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int count = tab.getPosition() + 1;
                initListView(count);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
