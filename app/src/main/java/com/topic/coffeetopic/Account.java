package com.topic.coffeetopic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Account extends AppCompatActivity {
    Button btnAccountSign,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        findView();
        setClickListener();
    }
    void findView(){
        btnAccountSign = (Button)findViewById(R.id.btn_account_sign);
        btnRegister = (Button)findViewById(R.id.btn_register);
    }
    void setClickListener(){
        btnAccountSign.setOnClickListener(listener);
        btnRegister.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            switch (v.getId()){
                case R.id.btn_account_sign:
                    it.setClass(Account.this,MemberInfo.class);
                    startActivity(it);
                    break;
                case R.id.btn_register:
                    it.setClass(Account.this,AccountRegister.class);
                    startActivity(it);
                    break;
            }
        }
    };
}
