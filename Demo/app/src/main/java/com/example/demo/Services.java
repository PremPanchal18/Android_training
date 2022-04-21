package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity implements View.OnClickListener {
    Button btnPlay, btnPause,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnNext =  findViewById(R.id.btnNext);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.btnPlay:
                startService(new Intent(this, Services.class));
                break;
            case R.id.btnPause:
                stopService(new Intent(this, Services.class));
                break;
            case R.id.btnNext:
                Intent intent=new Intent(this,datepicker.class);
                startActivity(intent);
                break;
        }
    }
}