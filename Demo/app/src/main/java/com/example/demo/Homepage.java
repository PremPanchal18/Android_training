package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {

    RecyclerView recycleView;
    ArrayList<RModel> alModel=new ArrayList<>();
    Radapter Radapter;
    public static TextView txtCount;
    Button btnAdd,btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        recycleView=findViewById(R.id.recycleView);
        txtCount=findViewById(R.id.txtCount);


        for(int i=0;i<20;i++)
        {
            RModel m=new RModel();
            m.setImage(R.drawable.pb);
            m.setName("Prison Break : "+ (i+1));
            m.setCart(0);
            alModel.add(m);

            RModel m1=new RModel();
            m1.setImage(R.drawable.pk);
            m1.setName("Peaky Blinders : "+ (i+1));
            m1.setCart(0);
            alModel.add(m1);

            RModel m2=new RModel();
            m2.setImage(R.drawable.bb);
            m2.setName(" Breaking Bad : "+ (i+1));
            m2.setCart(0);
            alModel.add(m2);

            RModel m3=new RModel();
            m3.setImage(R.drawable.xp);
            m3.setName("Jesse Pinkman : "+ (i+1));
            m3.setCart(0);
            alModel.add(m3);

            RModel m4=new RModel();
            m4.setImage(R.drawable.moneyh);
            m4.setName("Money Heist : "+ (i+1));
            m4.setCart(0);
            alModel.add(m4);

            RModel m5=new RModel();
            m5.setImage(R.drawable.ss2);
            m5.setName("Basketball : "+ (i+1));
            m5.setCart(0);
            alModel.add(m5);
        }

        Radapter=new Radapter(alModel);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(Radapter);
//        recycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

}