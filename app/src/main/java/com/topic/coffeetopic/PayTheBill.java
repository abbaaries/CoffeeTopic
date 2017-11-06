package com.topic.coffeetopic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PayTheBill extends AppCompatActivity {
    Button btnFinishTheBill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paythebill);
        findView();
        setClickListener();
    }

    void findView(){
        btnFinishTheBill = (Button)findViewById(R.id.btn_finish_the_bill);
    }

    void setClickListener(){
        btnFinishTheBill.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(PayTheBill.this,MainActivity.class);
            startActivity(it);
            finish();
        }
    };
}
