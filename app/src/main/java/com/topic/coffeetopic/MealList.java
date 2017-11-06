package com.topic.coffeetopic;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MealList extends AppCompatActivity {
    ImageView imgMeal;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meallist);
        findView();
        setListener();
    }
    void findView(){
        imgMeal = (ImageView)findViewById(R.id.image_meal);
        btnBack = (Button) findViewById(R.id.btn_back);

    }

    void setListener(){
        btnBack.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_back:
                    finish();
                    break;
            }

        }
    };
}
