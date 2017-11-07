package com.topic.coffeetopic;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MealList extends AppCompatActivity {
    GridView grid ;
    ImageView imgMeal;
    Button btnBack;
    String fun[] = {"招牌拿鐵","栗子拿鐵","招牌咖啡","美式咖啡","摩卡咖啡","焦糖瑪奇朵"};
    int[] icons = {R.drawable.coffee1,
            R.drawable.coffee2,
            R.drawable.coffee3,
            R.drawable.coffee4,
            R.drawable.coffee5,
            R.drawable.coffee6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meallist);
        findView();
        getAdapter();
        setListener();
    }
    void getAdapter() {
        InconAdapter gAdapter = new InconAdapter();
        grid.setAdapter(gAdapter);
    }
    class InconAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return fun.length;
        }

        @Override
        public Object getItem(int position) {

            return fun[position];
        }

        @Override
        public long getItemId(int position) {
            return icons[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if(row ==null){
                row = getLayoutInflater().inflate(R.layout.item_row,null);
                ImageView image = (ImageView) row.findViewById(R.id.item_image);
                TextView text = (TextView) row.findViewById(R.id.item_text);
                image.setImageResource(icons[position]);
                text.setText(fun[position]);
            }
            return row;
        }
    }

    void findView(){
        grid = (GridView)findViewById(R.id.grid_view_list);
        btnBack = (Button) findViewById(R.id.btn_back);
    }


    void setListener(){

        grid.setOnItemClickListener(itemClickListener);
    }
    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch ((int)id){
                case R.drawable.coffee1:
                    break;
                case R.drawable.coffee2:
                    break;
                case R.drawable.coffee3:
                    break;
                case R.drawable.coffee4:
                    break;
                case R.drawable.coffee5:
                    break;
                case R.drawable.coffee6:
                    break;
            }
        }
    };

}
