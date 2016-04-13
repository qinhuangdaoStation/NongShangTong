package jmessage.example.com.nongshangtong.agriculturalTradeMall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jmessage.example.com.nongshangtong.R;

/**
 * Created by ii on 2016/4/9.
 */
public class AgrTraMallAdapter extends BaseAdapter {

    private List<MallBean> beans;
    private Context context;
    private LayoutInflater inflater;

    public AgrTraMallAdapter(Context context, List<MallBean> beans) {
        this.beans = beans;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_agrtra_mall_item, null);
            viewHolder = new ViewHolder();

            viewHolder.txt_hadBuyNum_mall = (TextView) convertView.findViewById(R.id.txt_hadBuyNum_mall);
            viewHolder.txt_price_mall = (TextView) convertView.findViewById(R.id.txt_price_mall);
            viewHolder.txt_produce_mall = (TextView) convertView.findViewById(R.id.txt_produce_mall);
            viewHolder.image_produceIcon_mall = (ImageView) convertView.findViewById(R.id.image_produceIcon_mall);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MallBean bean = beans.get(position);
        viewHolder.image_produceIcon_mall.setImageResource(bean.getImage_produceImageTest());
        viewHolder.txt_produce_mall.setText(bean.getTxt_produce_mall());
        viewHolder.txt_price_mall.setText(bean.getTxt_price_mall() + "");
        viewHolder.txt_hadBuyNum_mall.setText(bean.getTxt_hadBuyNum_mall() + "");

        return convertView;
    }

    class ViewHolder{
        TextView txt_produce_mall;
        TextView txt_price_mall;
        TextView txt_hadBuyNum_mall;
        ImageView image_produceIcon_mall;
    }
}
