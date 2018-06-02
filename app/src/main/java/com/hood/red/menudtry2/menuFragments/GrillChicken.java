package com.hood.red.menudtry2.menuFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hood.red.menudtry2.MenuAdapter;
import com.hood.red.menudtry2.MenuItem;
import com.hood.red.menudtry2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malyf on 28/5/18.
 */

public class GrillChicken extends Fragment {
    private static final String TAG="Grill Chicken";
    private ListView listView;
    List<MenuItem> menuItemList;
    MenuAdapter menuAdapter;

    public GrillChicken() {
    }
    public static Fragment newInstance() {
        return new GrillChicken();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grill, container, false);
        listView= (ListView) rootView.findViewById(R.id.grill_chicken_list_view);

        DatabaseReference ref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://hotelprototype.firebaseio.com/");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.child("Menu").child(TAG).getValue().toString();

                Log.d(TAG, "Value is: " + value);

                menuItemList=new ArrayList<>();

                for(DataSnapshot itemSnapshot:dataSnapshot.child("Menu").child(TAG).getChildren()){
                    Log.e(TAG, "onDataChange: "+itemSnapshot.child("id").getValue().toString());
                    menuItemList.add(new MenuItem(itemSnapshot.child("id").getValue().toString(),itemSnapshot.child("dishName").getValue().toString(),itemSnapshot.child("rate").getValue().toString(),itemSnapshot.child("availability").getValue().toString()));

                }


                menuAdapter= new MenuAdapter(getActivity(),getContext(),menuItemList);
                listView.setAdapter(menuAdapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        return rootView;
    }
}
