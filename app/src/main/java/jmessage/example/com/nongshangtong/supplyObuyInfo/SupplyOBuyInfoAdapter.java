package jmessage.example.com.nongshangtong.supplyObuyInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jmessage.example.com.nongshangtong.R;

/**
 * Created by ii on 2016/4/8.
 */
public class SupplyOBuyInfoAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<SupplyOBuyBean> list = new ArrayList<>();

    public SupplyOBuyInfoAdapter(Context context,List<SupplyOBuyBean> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.layout_supply_buy_info_item, null);

            viewHolder.produce = (TextView) convertView.findViewById(R.id.txt_produce);
            viewHolder.produceImage = (ImageView) convertView.findViewById(R.id.image_icon);
            viewHolder.publishDateTime = (TextView) convertView.findViewById(R.id.txt_publish_dateTime);
            viewHolder.publishHuman = (TextView) convertView.findViewById(R.id.txt_publish_human);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SupplyOBuyBean bean = list.get(position);

        viewHolder.publishHuman.setText(bean.getPublishHuman());
        viewHolder.publishDateTime.setText(bean.getDateTime());
        viewHolder.produceImage.setImageResource(bean.getProduceImage());
        viewHolder.produce.setText(bean.getProduce());

        return convertView;
    }

    class ViewHolder{
        ImageView produceImage;
        TextView produce;
        TextView publishHuman;
        TextView publishDateTime;
    }
}
