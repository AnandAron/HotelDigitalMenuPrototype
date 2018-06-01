package com.hood.red.menudtry2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String tableId="1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView table= findViewById(R.id.table_id);
        table.setText(tableId);
    }



    public void goToMenuActivity(View view) {
        Intent i= new Intent(this,MenuActivity.class);
        startActivity(i);
    }
}
