package com.hood.red.menudtry2;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by malyf on 29/5/18.
 */

public class MenuAdapter extends BaseAdapter {

    Context context;
    List<MenuItem> menuItemList;
    Activity activity;
    public MenuAdapter(Activity activity,Context context, List<MenuItem> menuItemList) {
        this.context =context;
        this.activity=activity;
        this.menuItemList = menuItemList;
    }

    @Override
    public int getCount() {
        return menuItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view= View.inflate(context,R.layout.menu_item,null);
        view.setTag("VIEW"+menuItemList.get(position).getId());
        final TextView dishName=(TextView)view.findViewById(R.id.dish_name);
        TextView rate=(TextView) view.findViewById(R.id.rate);

        dishName.setText(menuItemList.get(position).getDishName());
        dishName.setTag("DISHNAME"+menuItemList.get(position).getId());
        rate.setText(menuItemList.get(position).getRate());
        rate.setTag("RATE"+menuItemList.get(position).getId());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlaceOrderDialog dialog= new PlaceOrderDialog(activity,menuItemList.get(position).getDishName(),menuItemList.get(position).getRate(),menuItemList.get(position).getId());
                dialog.show();

                //Toast.makeText(context,dishName.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
       return view;
    }
}
