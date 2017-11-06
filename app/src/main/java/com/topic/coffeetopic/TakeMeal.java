package com.topic.coffeetopic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TakeMeal extends AppCompatActivity {
    private Context context;
    private TextView showUsualStore,warningInfo,orderInfo;
    private EditText addAddr,choseDate,choseTime;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takemeal);

        context = this;
        Intent intent = getIntent();
        intent.setClass(this,MainActivity.class);
        findView();
    }

    void findView(){
        showUsualStore = (TextView) findViewById(R.id.show_usual_store);
        addAddr =(EditText) findViewById(R.id.warning_info);
        choseDate = (EditText) findViewById(R.id.chose_date);
        choseTime = (EditText) findViewById(R.id.chose_date);
        warningInfo = (TextView) findViewById(R.id.warning_info2);
        orderInfo = (TextView) findViewById(R.id.order_info2);
        back = (Button) findViewById(R.id.back_firstpage2);
        back.setOnClickListener(backcliclistener);
    }
    View.OnClickListener backcliclistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
