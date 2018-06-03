package com.hood.red.menudtry2;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by malyf on 3/6/18.
 */

public class RatingDialog extends Dialog {
    Context context;
    public RatingDialog(Context context) {
        super(context);
        this.context=context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.rating_dialog);
        final Button btn1=findViewById(R.id.r_1);
        final Button btn2=findViewById(R.id.r_2);
        final Button btn3=findViewById(R.id.r_3);
        final Button btn4=findViewById(R.id.r_4);
        final Button btn5=findViewById(R.id.r_5);
        final Button done=findViewById(R.id.rate_done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable star_on=context.getResources().getDrawable(R.drawable.star_on);
                Drawable star_off=context.getResources().getDrawable(R.drawable.star_off);
               btn1.setBackground(star_on);
               btn2.setBackground(star_off);
                btn3.setBackground(star_off);
                btn4.setBackground(star_off);
                btn5.setBackground(star_off);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable star_on=context.getResources().getDrawable(R.drawable.star_on);
                Drawable star_off=context.getResources().getDrawable(R.drawable.star_off);
                btn1.setBackground(star_on);
                btn2.setBackground(star_on);
                btn3.setBackground(star_off);
                btn4.setBackground(star_off);
                btn5.setBackground(star_off);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable star_on=context.getResources().getDrawable(R.drawable.star_on);
                Drawable star_off=context.getResources().getDrawable(R.drawable.star_off);
                btn1.setBackground(star_on);
                btn2.setBackground(star_on);
                btn3.setBackground(star_on);
                btn4.setBackground(star_off);
                btn5.setBackground(star_off);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable star_on=context.getResources().getDrawable(R.drawable.star_on);
                Drawable star_off=context.getResources().getDrawable(R.drawable.star_off);
                btn1.setBackground(star_on);
                btn2.setBackground(star_on);
                btn3.setBackground(star_on);
                btn4.setBackground(star_on);
                btn5.setBackground(star_off);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable star_on=context.getResources().getDrawable(R.drawable.star_on);
                Drawable star_off=context.getResources().getDrawable(R.drawable.star_off);
                btn1.setBackground(star_on);
                btn2.setBackground(star_on);
                btn3.setBackground(star_on);
                btn4.setBackground(star_on);
                btn5.setBackground(star_on);
            }
        });
    }
}
