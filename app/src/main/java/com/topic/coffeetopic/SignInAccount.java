package com.topic.coffeetopic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInAccount extends AppCompatActivity {

    private Button btnMemberSign,btnFBSign,btnCustomerSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinaccount);
        findView();
        setClickListener();
    }
    void findView(){
        btnMemberSign = (Button)findViewById(R.id.btn_member_sign);
        btnFBSign = (Button)findViewById(R.id.btn_FB_sign);
        btnCustomerSign = (Button)findViewById(R.id.btn_customer_sign);
    }
    void setClickListener(){
        btnMemberSign.setOnClickListener(listener);
        btnFBSign.setOnClickListener(listener);
        btnCustomerSign.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            switch(v.getId()){
                case R.id.btn_member_sign:
                    it.setClass(SignInAccount.this,PayTheBill.class);
                    startActivity(it);
                    break;
                case R.id.btn_FB_sign:
                    it.setClass(SignInAccount.this,PayTheBill.class);
                    startActivity(it);
                    break;
                case R.id.btn_customer_sign:
                    it.setClass(SignInAccount.this,CustomerRegister.class);
                    startActivity(it);
                    break;
            }
            finish();
        }
    };
}
