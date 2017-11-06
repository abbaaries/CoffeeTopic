package com.topic.coffeetopic;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SendOut extends AppCompatActivity {

    private Context context;
    private Button btnAddaddr,backFirstpage;
    private TextView orderInfo,tvAddr,changeAddr,warningInfo,choseDate,choseTime,changeDate,changeTime;
    String PREF_ADDRESS;
    GregorianCalendar calendarT = new GregorianCalendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendout);

        context = this;
        findView();
        setListener();
        setTag();
        setText();
        getInfo();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(tvAddr.length()!=0){
            Intent it = new Intent();
            it.setClass(SendOut.this,SignInAccount.class);
            startActivity(it);
        }else {
            Toast.makeText(SendOut.this,"請填寫外送地址",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences settings = getSharedPreferences(PREF_ADDRESS,MODE_PRIVATE);
        tvAddr.setText(settings.getString("ADDRESS",""));
    }

    void findView(){
        changeAddr = (TextView) findViewById(R.id.tv_change_address);
        tvAddr = (TextView) findViewById(R.id.tv_address);
        btnAddaddr =(Button) findViewById(R.id.btn_addaddr);
        changeDate = (TextView) findViewById(R.id.change_date);
        changeTime = (TextView) findViewById(R.id.change_time);
        choseDate = (TextView) findViewById(R.id.chose_date);
        choseTime = (TextView) findViewById(R.id.chose_time);
        warningInfo = (TextView) findViewById(R.id.warning_info);
        orderInfo = (TextView) findViewById(R.id.order_info2);
        backFirstpage = (Button) findViewById(R.id.back_firstpage1);
    }

    void setListener(){
        changeAddr.setOnClickListener(listener);
        btnAddaddr.setOnClickListener(listener);
        changeDate.setOnClickListener(listener);
        changeTime.setOnClickListener(listener);
        backFirstpage.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = (Integer)v.getTag();

            switch (tag){
                case 0:
                    Toast.makeText(SendOut.this,"00",Toast.LENGTH_SHORT).show();
                case 1:
                    Intent it1 = new Intent();
                    it1.setClass(SendOut.this,SendOutAddr.class);
                    startActivity(it1);
                    Toast.makeText(SendOut.this,"11",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    dateCalendar();
                    break;
                case 3:
                    timeCalendar();
                    break;
                case 4:
                    finish();
                    Toast.makeText(SendOut.this,"22",Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(SendOut.this,"33",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    void setTag(){
        changeAddr.setTag(0);
        btnAddaddr.setTag(1);
        changeDate.setTag(2);
        changeTime.setTag(3);
        backFirstpage.setTag(4);
    }

    void setText(){
        SimpleDateFormat formatterDate ,formatterHour ,formatterMinute,formatterPM ;
        String preAmPm,preHour,preMinute="",nextHour="",nextMinute="";
                formatterDate = new SimpleDateFormat("yyyy/MM/dd");
        formatterPM = new SimpleDateFormat("aa ");
        formatterHour = new SimpleDateFormat("HH");
        formatterMinute = new SimpleDateFormat("mm");
        Date curtDate = new Date(System.currentTimeMillis());
        preAmPm = formatterPM.format(curtDate);
        preHour = formatterHour.format(curtDate);
        preHour = (Integer.valueOf(preHour)>12?String.valueOf(Integer.valueOf(preHour)-12):preHour);
        nextHour = String.valueOf(Integer.valueOf(preHour));
        preMinute = formatterMinute.format(curtDate);

        preMinute =String.valueOf( Integer.valueOf(preMinute)/15);
        switch ((int)((Integer.valueOf(preMinute)/15)+1)%4){
            case 0:
                preHour =String.valueOf(Integer.valueOf(preHour)+1);
                nextHour = String.valueOf(Integer.valueOf(preHour)+1);
                preMinute = "00";
                nextMinute = "15";
                break;
            case 1:
                preMinute = "15";
                nextMinute = "30";
                break;
            case 2:

                preMinute = "30";
                nextMinute = "45";
                break;
            case 3:
//                nextHour = String.valueOf(Integer.valueOf(preHour)+1);
                preMinute = "45";
                nextMinute = "00";
        }
        choseDate.setText(formatterDate.format(curtDate));
        choseTime.setText(preAmPm+preHour+":"+preMinute+"~"+nextHour+":"+nextMinute);
    }
    void dateCalendar(){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                SendOut.this,datelistener,
                calendar.get(calendar.YEAR),
                calendar.get(calendar.MONTH),
                calendar.get(calendar.DAY_OF_MONTH));
        datePickerDialog.setTitle("選 擇 外 送 日 期");
        datePickerDialog.show();
    }
    DatePickerDialog.OnDateSetListener datelistener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String date =year+"/"+(month+1)+"/"+(dayOfMonth<10?"0"+dayOfMonth:dayOfMonth) ;
            Toast.makeText(SendOut.this,date,Toast.LENGTH_SHORT).show();
            choseDate.setText(date);
        }
    };

    void timeCalendar(){
//        Calendar calendarT = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                SendOut.this,timelistener,
                calendarT.get(calendarT.AM_PM),
                calendarT.get(calendarT.HOUR),
                false);
        timePickerDialog.setTitle("選 擇 外 送 時 段");
        timePickerDialog.show();
    }

    TimePickerDialog.OnTimeSetListener timelistener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String time =(hourOfDay>12?hourOfDay-12:hourOfDay)+":"+(minute<10?"0"+minute:minute)+
                    " ~ "+(hourOfDay>12?hourOfDay-12:hourOfDay)+":"+(minute<10?"0"+(minute+20):(minute+20));
            choseTime.setText((hourOfDay>12?"PM":"AM")+" "+time);
        }
    };

    void getInfo(){
        Intent intent = getIntent();
        intent.setClass(this,MainActivity.class);
        SharedPreferences settings = getSharedPreferences(PREF_ADDRESS,MODE_PRIVATE);
        tvAddr.setText(settings.getString("ADDRESS",""));
        warningInfo.setText(R.string.warning_info);
        orderInfo.setText(R.string.order_info);
        if(tvAddr.length()!=0){
            btnAddaddr.setVisibility(View.INVISIBLE);
            changeAddr.setVisibility(View.VISIBLE);
        }else {
            changeAddr.setVisibility(View.INVISIBLE);
        }
    }



}
