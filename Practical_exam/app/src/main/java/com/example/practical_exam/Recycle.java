package com.example.practical_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Recycle extends AppCompatActivity {

    RecyclerView recyclerView;
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

        adapter=new RecyclerAdapter(alModel,Recycle.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Recycle.this));
    }
}