package com.example.practical_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Bidi;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    Button btnAdd,btnView;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.btnAdd);
        btnView=findViewById(R.id.btnView);
        db = new DatabaseHandler(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,DateAndTime.class);
                startActivity(i);
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Recycle.class);
                startActivity(i);

                db.addDate(btnAdd.getText().toString());
            }
        });
    }

}