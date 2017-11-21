package com.mindnotix.recyclerviewcheckboxspinneredittextdelete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<ModelClass>modelClasses;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<String> spinnerDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview();
        modelClasses=new ArrayList<>();
        spinnerDataList=new ArrayList<>();

        Button button=(Button)findViewById(R.id.addview);
        Button getvalue=(Button)findViewById(R.id.getvalue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addlayout("1");
            }
        });

        for(int i=0;i<5;i++){
            spinnerDataList .add(" "+i);
        }

    }

    private void recyclerview() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

    }





    private void addlayout(String item) {

        ModelClass modelClass=new ModelClass(item);
        modelClasses.add(modelClass);
        recyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this,modelClasses,spinnerDataList);
        recyclerview.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
