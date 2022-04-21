package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //    Button btnSubmit;
//    ArrayList<String> ArrayList1=new ArrayList<>();
    DatabaseHandler db;
    Button btnSubmit;
    EditText edtEmail, edtPassword, edtMob, edtFirstName, edtUsername;
//    SharedPreferences sharedPreferences;
//    public static final String MyPREFERENCES = "MyPrefs" ;
//    public static final String FirstName = "FirstName";
//    public static final String LastName = "LastName";
//    public static final String Phone = "phone";
//    public static final String Email = "email";
//    public static final String password = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
//        SharedPreferences.Editor myEdit = sharedPreferences.edit();
//        myEdit.putString("FirstName", edtFirstName.getText().toString());
//        myEdit.putString("LastName", edtID.getText().toString());
//        myEdit.putString("email", edtEmail.getText().toString());
//        myEdit.putString("password", edtPassword.getText().toString());
//        myEdit.apply();


//        btnSubmit=findViewById(R.id.btnSave);
        btnSubmit = findViewById(R.id.btnSubmit);

//        btnSubmit.setOnClickListener(this);
//        btnSubmit.setOnClickListener(this);

        edtFirstName = findViewById(R.id.edtFirstName);
        edtUsername=findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtMob = findViewById(R.id.edtMob);
        edtPassword = findViewById(R.id.edtPassword);

        db = new DatabaseHandler(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(checkValidation(edtEmail.getText().toString(),edtPassword.getText().toString(),
                        edtMob.getText().toString(),edtFirstName.getText().toString(),edtUsername.getText().toString()))
                {
                    db.addContact(edtEmail.getText().toString(), edtPassword.getText().toString(),edtMob.getText().toString(),
                            edtUsername.getText().toString());
//                Al.add(edtFirstName.getText().toString());
//                Al.add(edtLastName.getText().toString());
//                ArrayList1.add(edtEmail.getText().toString());
//                ArrayList1.add(edtPassword.getText().toString());
//                Al.add(edtMob.getText().toString());

//                    SharedPreferences sharedPreferences = getSharedPreferences("MyPref",MODE_PRIVATE);
//                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
//                    myEdit.putString("FirstName", edtFirstName.getText().toString());
//                    myEdit.putString("LastName", edtID.getText().toString());
//                    myEdit.putString("email", edtEmail.getText().toString());
//                    myEdit.putString("phone", edtMob.getText().toString());
//                    myEdit.putString("password", edtPassword.getText().toString());
//                    myEdit.apply();
                    Intent i = new Intent(MainActivity.this, Homepage.class);
                    startActivity(i);

                }
            }
        });
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }
//
//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id=item.getItemId();
//        switch (id)
//        {
//            case R.id.item1:
//                Toast.makeText(this,"item1 is selected",Toast.LENGTH_LONG);
//                return true;
//
//            case R.id.item2:
//                Toast.makeText(this,"item2 is selected",Toast.LENGTH_LONG);
//                return true;
//            case R.id.item3:
//                Toast.makeText(this,"item3 is selected",Toast.LENGTH_LONG);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//
//    }
//
//    @Override



//
//
//
//
//
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public static boolean isValidName(CharSequence target) {
        return (!TextUtils.isEmpty(target) );
    }

    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean isValidMobileNo(String str)
    {
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }

    public boolean checkValidation(String strEmail, String strPassword,String strMobileNo,String strFirstName,String strLastName)
        {
            if (strFirstName.matches("")) {
                edtFirstName.setError("Enter First Name");
                return false;
            } else if (strLastName.matches("")) {
                edtUsername.setError("Enter Last Name");
                return false;
            } else if (strEmail.matches("")) {
                edtEmail.setError("Enter Email ID");
                return false;
            } else if (!isValidEmail(strEmail)) {
                edtEmail.setError("Enter Valid Email");
                return false;
            } else if (strMobileNo.matches("")) {
                edtMob.setError("Enter Mobile Number");
                return false;
            } else if (!isValidMobileNo(strMobileNo)) {
                edtMob.setError("Enter Valid Mobile Number");
                return false;
            } else if (strPassword.matches("")) {
                edtPassword.setError("Enter Password");
                return false;
            } else if (!isValidPassword(strPassword)) {
                edtPassword.setError("Enter Valid Password");
                return false;
            } else {
                return true;
            }
        }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i("onResume", "onResume: ");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.i("onResume", "onResume: ");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.i("onPause", "onPause: ");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.i("onStop", "onStop: ");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.i("onDestroy", "onDestroy: ");
//    }

    }

