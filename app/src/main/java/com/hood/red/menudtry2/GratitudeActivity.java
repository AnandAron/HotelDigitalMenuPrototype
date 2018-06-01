package com.hood.red.menudtry2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GratitudeActivity extends AppCompatActivity {
    Context context;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context=getApplicationContext();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gratitude);
        DatabaseReference ref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://hotelprototype.firebaseio.com/Tables/1");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                count++;
                if(count>1){

                Intent i= new Intent(context,MainActivity.class);
                count=0;
                startActivity(i);
                finish();}

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
