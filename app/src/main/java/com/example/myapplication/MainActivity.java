package com.example.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mobileArray = new ArrayList<String>() ;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobileArray.add("subham");
        mobileArray.add("subham1");
        mobileArray.add("subham2");
        mobileArray.add("subham3");

        final ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);
        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

         thread = new Thread(new Runnable() {
            @Override
            public void run() {
                mobileArray.add("subham4");
                adapter.notifyDataSetChanged();
            }
        });



    }
    //commented
    public void add(View view) {
        thread.start();
    }
}
