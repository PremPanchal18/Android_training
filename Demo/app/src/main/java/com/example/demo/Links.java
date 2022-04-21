package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Links extends AppCompatActivity {
    TextView txtClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);
        txtClick=findViewById(R.id.txtClick);

//        txtClick.setText("https://www.netflix.com");
//        txtClick.setText("+91 8849851083");
//        txtClick.setText("prempanchal3595@gmail.com");

        txtClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String url="https://www.netflix.com";
//                Intent i=new Intent(Intent.ACTION_VIEW);
//                Intent i=new Intent(Intent.ACTION_DIAL);
                Intent i = new Intent(Intent.ACTION_SENDTO);
//                i.setData(Uri.parse(url));
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL  , new String[] { "prempanchal@gmail.com" });
                i.putExtra(Intent.EXTRA_SUBJECT, "Ayo Wussup");
                startActivity(Intent.createChooser(i, "Email via..."));
            }
        });
    }
}