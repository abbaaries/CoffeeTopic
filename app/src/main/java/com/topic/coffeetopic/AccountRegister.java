package com.topic.coffeetopic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountRegister extends AppCompatActivity {
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountregister);
        findView();
        setClickListener();
    }
    void findView(){
        btnRegister = (Button) findViewById(R.id.btn_register);
    }
    void setClickListener(){
        btnRegister.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(AccountRegister.this,MemberInfo.class);
            startActivity(it);
        }
    };
}
