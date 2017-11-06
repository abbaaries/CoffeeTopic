package com.topic.coffeetopic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSendout,btnTakeMeal,btnList,btnNearLocation,btnAccount,btnOrderInfo;
    private boolean btncheck = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setClickListener();
    }
    void findView(){
        btnSendout = (Button) findViewById(R.id.btn_send_out);
        btnTakeMeal = (Button) findViewById(R.id.btn_take_meal);
        btnList = (Button) findViewById(R.id.btn_list);
        btnNearLocation =(Button) findViewById(R.id.btn_near_location);
        btnAccount = (Button)findViewById(R.id.btn_account);
        btnOrderInfo = (Button) findViewById(R.id.btn_order_info);

    }
    void setClickListener(){
        btnSendout.setOnClickListener(setlistener);
        btnTakeMeal.setOnClickListener(setlistener);
        btnList.setOnClickListener(setlistener);
        btnNearLocation.setOnClickListener(setlistener);
        btnAccount.setOnClickListener(setlistener);
        btnOrderInfo.setOnClickListener(setlistener);
    }

    View.OnClickListener setlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();

            switch (view.getId()){
                case R.id.btn_send_out:
                    Toast.makeText(MainActivity.this,"send out",Toast.LENGTH_SHORT).show();
                    intent.setClass(MainActivity.this,ChoseMealList.class);
                    startActivity(intent);
                    break;
                case R.id.btn_take_meal:
                    Toast.makeText(MainActivity.this,"take meal",Toast.LENGTH_SHORT).show();
                    intent.setClass(MainActivity.this,ChoseMealList.class);
                    startActivity(intent);
                    break;
                case R.id.btn_list:
                    Toast.makeText(MainActivity.this,"list",Toast.LENGTH_SHORT).show();
                    intent.setClass(MainActivity.this,MealList.class);
                    startActivity(intent);
                    break;
                case R.id.btn_near_location:
                    Toast.makeText(MainActivity.this,"near location",Toast.LENGTH_SHORT).show();
                    intent.setClass(MainActivity.this,NearLocation.class);
                    startActivity(intent);
                    break;
                case R.id.btn_account:
                    Toast.makeText(MainActivity.this,"account ",Toast.LENGTH_SHORT).show();
                    intent.setClass(MainActivity.this,Account.class);
                    startActivity(intent);
                    break;
                case R.id.btn_order_info:
                    Toast.makeText(MainActivity.this,"order Info",Toast.LENGTH_SHORT).show();
                    intent.setClass(MainActivity.this,OrderInfo.class);
                    startActivity(intent);
                    break;
            }

        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

}
