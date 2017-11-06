package com.topic.coffeetopic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ChoseMealList extends AppCompatActivity {
    String[] arraylist ;
    ListView listView;
    GridView gridView;
    Context context;
    Spinner spinnerType,spinnerHotCold,spinnerSize,spinnerSuger,spinnerIce;
    ArrayAdapter adapter;
    Button btnReduce,btnAdd,btnPlus;
    TextView tvNumber,tvShowOrder;
    String number,order,type,hot_Cold,size,suger;
    int i =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosemeallist);
        findView();
        setClicker();

        arrayAdapter();
        setText();
    }

    void findView(){
        gridView = (GridView)findViewById(R.id.grid_view);
        spinnerType = (Spinner) findViewById(R.id.spinner_type);
        spinnerHotCold = (Spinner) findViewById(R.id.spinner_hot_cold);
        spinnerSize = (Spinner) findViewById(R.id.spinner_size);
        spinnerSuger = (Spinner) findViewById(R.id.spinner_suger);
        spinnerIce = (Spinner) findViewById(R.id.spinner_ice);
        btnReduce = (Button)findViewById(R.id.btn_reduce);
        btnAdd = (Button)findViewById(R.id.btn_add);
        btnPlus = (Button)findViewById(R.id.btn_plus);
        tvNumber = (TextView) findViewById(R.id.textView_number);
        tvShowOrder = (TextView) findViewById(R.id.textView_show_order);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = new Intent();
        it.setClass(ChoseMealList.this,SendOut.class);
        startActivity(it);
        return super.onOptionsItemSelected(item);
    }
    void setOnItemClickListener(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.setClass(ChoseMealList.this,MealList.class);
                startActivity(it);
//                Toast.makeText(ChoseMealList.this,"點選的是:"+((CheckedTextView)view).getText().toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(ChoseMealList.this,"點選的是:"+parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    void setSpinnerListener(){
        spinnerType.setOnItemSelectedListener(itemSelectedListener1);
        spinnerHotCold.setOnItemSelectedListener(itemSelectedListener2);
        spinnerSize.setOnItemSelectedListener(itemSelectedListener3);
        spinnerSuger.setOnItemSelectedListener(itemSelectedListener4);
        spinnerIce.setOnItemSelectedListener(itemSelectedListener5);
    }
    void setClicker(){
        setOnItemClickListener();
        setSpinnerListener();
        btnReduce.setOnClickListener(clickListener);
        btnAdd.setOnClickListener(clickListener);
        btnPlus.setOnClickListener(clickListener);
    }
    void arrayAdapter(){
        arraylist= getResources().getStringArray(R.array.meal_list);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arraylist);
        gridView.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this,R.array.meal_list,android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this,R.array.hot_cold,android.R.layout.simple_dropdown_item_1line);
        spinnerHotCold.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this,R.array.meal_size,android.R.layout.simple_dropdown_item_1line);
        spinnerSize.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this,R.array.meal_suger,android.R.layout.simple_dropdown_item_1line);
        spinnerSuger.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this,R.array.chose_hot,android.R.layout.simple_dropdown_item_1line);
        spinnerIce.setAdapter(adapter);
    }


    AdapterView.OnItemSelectedListener itemSelectedListener1 = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                order = spinnerType.get;+spinnerHotCold+spinnerSize+number+"杯";
                type=parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    AdapterView.OnItemSelectedListener itemSelectedListener2 = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hot_Cold=parent.getItemAtPosition(position).toString();
//                if(spinnerHotCold.getSelectedItemPosition()==1){
//                    adapter = ArrayAdapter.createFromResource(context,R.array.chose_clod,android.R.layout.simple_dropdown_item_1line);
//                    spinnerIce.setAdapter(adapter);
//                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    AdapterView.OnItemSelectedListener itemSelectedListener3 = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                size=parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
    AdapterView.OnItemSelectedListener itemSelectedListener4 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            suger = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    AdapterView.OnItemSelectedListener itemSelectedListener5 = new AdapterView.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };
    ////////////////////// 咖啡 加總計算////////
    View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String kind="";
            if(v.getId()==R.id.btn_add)
                i+=1;
            else if(v.getId()==R.id.btn_reduce){
                if(i>1)
                    i-=1;
            }
            tvNumber.setText(String.valueOf(i));
            number=String.valueOf(i);
            if(v.getId()==R.id.btn_plus){
                kind =size+" "+suger+" "+hot_Cold+type;

//                if(kind.equals(order) ){
//                    int k=Integer.valueOf(number)+i;
//                    number = String.valueOf(k);
//                    tvShowOrder.setText(number+" "+order+"\n");
//                }else {

                    tvShowOrder.append(number+" "+kind + "\n");
//                }
            Toast.makeText(ChoseMealList.this,number+kind,Toast.LENGTH_SHORT).show();
            }
            order = kind;
            number = String.valueOf(i);

        }
    };
    //////////////////////////////////////////////////
    void setText(){
        tvNumber.setText(String.valueOf(i));
//        tvShowOrder.setText(number+" "+order);
    }
}
