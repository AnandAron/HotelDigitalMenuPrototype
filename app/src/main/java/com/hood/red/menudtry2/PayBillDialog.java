package com.hood.red.menudtry2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by malyf on 30/5/18.
 */

public class PayBillDialog extends Dialog {


    public PayBillDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pay_dialog);
        Button dessertBtn= findViewById(R.id.pay_dialog_dessert);
        Button confirmPaymentBtn=findViewById(R.id.pay_dialog_confirm_payment);
        dessertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuActivity.mViewPager.setCurrentItem(1);
                dismiss();
            }
        });
        /*confirmPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context,GratitudeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                a.startActivity(i);
            }
        });
*/
    }
}
