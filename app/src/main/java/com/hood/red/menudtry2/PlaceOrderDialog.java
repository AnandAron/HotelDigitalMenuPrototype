package com.hood.red.menudtry2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malyf on 29/5/18.
 */

public class PlaceOrderDialog extends Dialog  {

    public Activity activity;
    public Dialog dialog;
    private String dishName;
    private String rate;
    private String id;
    private String TAG="PlaceOrderDialog";
    private int plates;


    List<Order> orderList;
    StatusListAdapter statusListAdapter;

    public PlaceOrderDialog(Activity a,String dishName,String rate,String id) {
        super(a);
        this.activity=a;
        this.dishName=dishName;
        this.rate=rate;
        this.id=id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.confirm_order);
        TextView tv1= findViewById(R.id.sample);
        final TextView tv_rate= findViewById(R.id.dialog_rate);
        final TextView tv_count= findViewById(R.id.dishCount);
        Button cancel= findViewById(R.id.dialog_cancel);
        tv1.setText(dishName);
        tv_rate.setText(rate);
        Button plus= findViewById(R.id.btn_plus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c=Integer.parseInt(tv_count.getText().toString());
                Log.e(TAG, "onClick: "+c);
                c++;
                tv_count.setText(""+c);
                long r= Integer.parseInt(tv_rate.getText().toString());
                r=r+Integer.parseInt(rate);
                tv_rate.setText(""+r);
            }
        });
        Button minus= findViewById(R.id.btn_minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c=Integer.parseInt(tv_count.getText().toString());
                if(c>=2) {
                    c--;
                    tv_count.setText("" + c);
                    long r= Integer.parseInt(tv_rate.getText().toString());
                    r=r-Integer.parseInt(rate);
                    tv_rate.setText(""+r);
                }
                else {
                    Toast.makeText(activity,"Invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        final Button place=findViewById(R.id.dialog_done);
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plates=Integer.parseInt(tv_count.getText().toString());
                try {

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://hotelprototype.firebaseio.com/");
                    ref.child("Tables").child(MainActivity.tableId).child("" + System.currentTimeMillis()).setValue(new Order(dishName, id, plates, "placed",Integer.parseInt(tv_rate.getText().toString())));
                }
                catch (Exception e){
                    Log.e(TAG, "onClick: "+e.getMessage() );
                }
                finally {
                    Toast.makeText(activity,"Order Placed",Toast.LENGTH_SHORT).show();
                    dismiss();
                    MenuActivity.status.setVisibility(View.VISIBLE);


                    DatabaseReference ref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://hotelprototype.firebaseio.com/");

                    orderList=new ArrayList<>();
                    // Read from the database
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                           // String value = dataSnapshot.getValue(String.class);
                            long total=0;
                            orderList.clear();
                            for(DataSnapshot itemSnapshot:dataSnapshot.child("Tables").child(MainActivity.tableId).getChildren()){
                                orderList.add(new Order(
                                        itemSnapshot.child("dishName").getValue().toString(),
                                        itemSnapshot.child("id").getValue().toString(),
                                        Integer.parseInt(itemSnapshot.child("plates").getValue().toString()),
                                        itemSnapshot.child("status").getValue().toString(),
                                        Integer.parseInt(itemSnapshot.child("rate").getValue().toString()))
                                );
                                Log.d(TAG, "Value is:"+ itemSnapshot.child("dishName").getValue().toString()+
                                        itemSnapshot.child("id").getValue().toString()+
                                        Integer.parseInt(itemSnapshot.child("plates").getValue().toString()) );
                                total=total+Integer.parseInt(itemSnapshot.child("rate").getValue().toString());

                            }
                            statusListAdapter= new StatusListAdapter(activity,getContext(),orderList);
                            Log.e(TAG, "onDataChange: #############################");
                            MenuActivity.orderListView.setAdapter(statusListAdapter);
                            MenuActivity.tv_totalStatus.setText(""+total);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            Log.w(TAG, "Failed to read value.", error.toException());
                        }
                    });





                }

            }
        });

    }


}
