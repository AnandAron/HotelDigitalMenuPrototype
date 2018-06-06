package com.hood.red.menudtry2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by malyf on 4/6/18.
 */

class BoredDialog extends Dialog {
    Context context;
    public BoredDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bored_dialog);
        Button yes = findViewById(R.id.dialog_bored_btn1);
        Button no= findViewById(R.id.dialog_bored_btn2);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context,Content.class);
                context.startActivity(i);
            }
        });
       no.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dismiss();
           }
       });
    }
}
