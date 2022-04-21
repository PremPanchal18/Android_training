package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class logout extends AppCompatActivity implements View.OnClickListener {
    Button btnLogout;
    TextView txtEmail,txtPassword,txtPhoneNo,txtFirstName,txtLastName;
    String strEmail,strPassword,strFirstName,strLastName,strPhoneNo;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedPreferences;
    public static final String FirstName = "FirstName";
    public static final String LastName = "LastName";
    public static final String Phone = "phone";
    public static final String Email = "email";
    public static final String password = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        setContentView(R.layout.activity_logout);
        btnLogout=findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        txtEmail=findViewById(R.id.txtEmail);
        txtPassword=findViewById(R.id.txtPassword);
        txtFirstName=findViewById(R.id.txtFirstName);
        txtLastName=findViewById(R.id.txtLastName);
        txtPhoneNo=findViewById(R.id.txtPhoneNo);

        strFirstName = sharedPreferences.getString("FirstName",strFirstName);
        strLastName = sharedPreferences.getString("LastName",strLastName);
        strEmail = sharedPreferences.getString("email",strEmail);
        strPhoneNo = sharedPreferences.getString("phone",strPhoneNo);
        strPassword = sharedPreferences.getString("password",strPassword);

        txtFirstName.setText(strFirstName);
        txtLastName.setText(strLastName);
        txtEmail.setText(strEmail);
        txtPhoneNo.setText(strPhoneNo);
        txtPassword.setText(strPassword);


    }

    @Override
    public void onClick(View view) {

        Intent i= new Intent(this, TabActivity.class);
        startActivity(i);

    }
}