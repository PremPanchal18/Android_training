package com.example.practical_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateAndTime extends AppCompatActivity {

    Button btnDate,btnTime,btnSubmit;

    private Calendar calendar;
    private int year, month, day;

    private String format = "";
    int hour ;
    int min ;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        btnDate=findViewById(R.id.btnDate);
        btnTime=findViewById(R.id.btnTime);
        btnSubmit=findViewById(R.id.btnSubmit);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        showDate(year, month+1, day);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });
    }
//    public void OnToggleClicked(View view) {
//        long time;
//        if (((btnTime) view).isChecked()) {
//            Toast.makeText(DateAndTime.this, "ALARM ON", Toast.LENGTH_SHORT).show();
//            Calendar calendar = Calendar.getInstance();
//
//            // calendar is called to get current time in hour and minute
//            calendar.set(Calendar.HOUR_OF_DAY, hour.getCurrentHour());
//            calendar.set(Calendar.MINUTE, min.getCurrentMinute());
//
//            // using intent i have class AlarmReceiver class which inherits
//            // BroadcastReceiver
//            Intent intent = new Intent(this, MyBroadcastReceiver.class);
//
//            // we call broadcast using pendingIntent
//            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
//
//            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
//            if (System.currentTimeMillis() > time) {
//                // setting time as AM and PM
//                if (calendar.AM_PM == 0)
//                    time = time + (1000 * 60 * 60 * 12);
//                else
//                    time = time + (1000 * 60 * 60 * 24);
//            }
//            // Alarm rings continuously until toggle button is turned off
//            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);
//            // alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (time * 1000), pendingIntent);
//        } else {
//            alarmManager.cancel(pendingIntent);
//            Toast.makeText(DateAndTime.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
//        }
    public void startAlert(){
        int i = Integer.parseInt(btnTime.getText().toString());

        Intent intent = new Intent(DateAndTime.this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();
    }


    public void setDate() {
        showDialog(999);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999)
        {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        else {
            return new TimePickerDialog(this,myTimeListner,hour,min,false);
        }
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub

                    showDate(arg1, arg2+1, arg3);
                }
            };

    private TimePickerDialog.OnTimeSetListener myTimeListner =new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            showTime(hourOfDay,minute);
        }
    };

    private void showDate(int year, int month, int day) {

    }

    public void setTime()
    {
        showTime(hour, min);
        showDialog(99);
    }

    public void showTime(int hour, int min)
    {
        if (hour == 0)
        {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

    }

}