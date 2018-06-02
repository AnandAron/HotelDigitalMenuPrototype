package com.hood.red.menudtry2;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by malyf on 29/5/18.
 */

public class StatusListAdapter extends BaseAdapter {
    Context context;
    List<Order> orderList;
    Activity activity;
    public StatusListAdapter(Activity activity,Context context, List<Order> orderList) {
        this.context = context;
        this.activity=activity;
        this.orderList = orderList;
    }



    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= View.inflate(context,R.layout.status_item,null);
        TextView tv_dishname_status=view.findViewById(R.id.status_dish_name);
        TextView tv_plates_status= view.findViewById(R.id.status_plates);
        TextView tv_status_status=view.findViewById(R.id.status_dish_status);

        tv_dishname_status.setText(orderList.get(position).getDishName());
        tv_plates_status.setText(""+orderList.get(position).getPlates());
        tv_status_status.setText(orderList.get(position).getStatus());
        return view;
    }
}
