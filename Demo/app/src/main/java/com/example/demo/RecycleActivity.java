package com.example.demo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnNext;
    //    ArrayList<Model> alModel=new ArrayList<>();
    ArrayList<UseModel> alModel=new ArrayList<>();
    RecyclerAdapter adapter;
    DatabaseHandler db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        db = new DatabaseHandler(this);
        alModel= db.getAllContacts();

        recyclerView=findViewById(R.id.recyclerView);
        btnNext=findViewById(R.id.btnNext);

//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(RecycleActivity.this,Homepage.class);
//            }
//        });

        adapter=new RecyclerAdapter(alModel,RecycleActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
    }
}