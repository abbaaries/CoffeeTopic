package com.topic.coffeetopic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class AddressLocation extends AppCompatActivity {

    private Context context;
    private Button back;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresslocation);

        context = this;
        Intent intent = getIntent();
        intent.setClass(this,MainActivity.class);
        findView();

    }

    void findView(){
        back = (Button) findViewById(R.id.back_firstpage4);
        listView = (ListView) findViewById(R.id.show_store_locatoin);
    }
    View.OnClickListener backcliclistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}