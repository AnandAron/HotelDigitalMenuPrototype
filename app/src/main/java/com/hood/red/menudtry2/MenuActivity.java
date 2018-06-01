package com.hood.red.menudtry2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hood.red.menudtry2.menuFragments.Breads;
import com.hood.red.menudtry2.menuFragments.ChineseFragment;
import com.hood.red.menudtry2.menuFragments.Desserts;
import com.hood.red.menudtry2.menuFragments.Gravies;
import com.hood.red.menudtry2.menuFragments.GrillChicken;
import com.hood.red.menudtry2.menuFragments.Indian;
import com.hood.red.menudtry2.menuFragments.RiceAndNoodles;
import com.hood.red.menudtry2.menuFragments.Rolls;
import com.hood.red.menudtry2.menuFragments.Soups;
import com.hood.red.menudtry2.menuFragments.SpicyIndianFragment;
import com.hood.red.menudtry2.menuFragments.Tandoor;
import com.hood.red.menudtry2.menuFragments.Veg;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    public static RelativeLayout status;
    public static ListView orderListView;
    public static TextView tv_totalStatus;
    public static ScrollView scrollGrid;
    List<Order> orderList;
    StatusListAdapter statusListAdapter;
    String TAG="MenuActivity";
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    public static ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_design);





        status=findViewById(R.id.status);
        orderListView= findViewById(R.id.status_list_view);
        tv_totalStatus=findViewById(R.id.status_total);
        scrollGrid=findViewById(R.id.scroll_grid);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    public void showSideBar(View view) {
        status.setVisibility(View.VISIBLE);

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
                statusListAdapter= new StatusListAdapter(getParent(),getBaseContext(),orderList);

                MenuActivity.orderListView.setAdapter(statusListAdapter);
                MenuActivity.tv_totalStatus.setText("Total  "+total);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }

    public void showFinalDialog(View view) {
        PayBillDialog payBillDialog = new PayBillDialog(this);
        payBillDialog.show();
        //mViewPager.setCurrentItem(1);
    }

    public void showGratitude(View view) {
        Intent i= new Intent(this,GratitudeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

    }

    public void sendNotification(View view) {
        DatabaseReference ref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://hotelprototype.firebaseio.com/");
        ref.child("Water").child(MainActivity.tableId).setValue(System.currentTimeMillis());
    }

    public void showViewPager(View view) {
        scrollGrid.setVisibility(View.GONE);
        switch(view.getTag().toString()){
            case "grid1":mViewPager.setCurrentItem(0);break;
            case "grid2":mViewPager.setCurrentItem(1);break;
            case "grid3":mViewPager.setCurrentItem(2);break;
            case "grid4":mViewPager.setCurrentItem(3);break;
            case "grid5":mViewPager.setCurrentItem(4);break;
            case "grid6":mViewPager.setCurrentItem(5);break;
            case "grid7":mViewPager.setCurrentItem(6);break;
            case "grid8":mViewPager.setCurrentItem(7);break;
            case "grid9":mViewPager.setCurrentItem(8);break;
            case "grid10":mViewPager.setCurrentItem(9);break;
            case "grid11":mViewPager.setCurrentItem(10);break;
            case "grid12":mViewPager.setCurrentItem(11);break;
        }
        mViewPager.setVisibility(View.VISIBLE);
    }

    public void showCategory(View view) {
        mViewPager.setVisibility(View.GONE);
        scrollGrid.setVisibility(View.VISIBLE);
    }


    /**
     * A placeholder fragment containing a simple view.
      one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return SpicyIndianFragment.newInstance();

                case 1:
                    return ChineseFragment.newInstance();

                case 2:return Breads.newInstance();
                case 3:return Desserts.newInstance();
                case 4:return Gravies.newInstance();
                case 5:return GrillChicken.newInstance();
                case 6:return Indian.newInstance();
                case 7:return RiceAndNoodles.newInstance();
                case 8:return Rolls.newInstance();
                case 9:return Tandoor.newInstance();
                case 10:return Veg.newInstance();
                case 11:return Soups.newInstance();

            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 12 total pages.
            return 12;
        }
    }

}
