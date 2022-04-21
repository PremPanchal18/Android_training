package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Broadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (checkInternet(context)) {
            Toast.makeText(context, "Network Available Do operations", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "Network not Available", Toast.LENGTH_LONG).show();
        }
    }

    boolean checkInternet(Context context) {
        ServiceManager ser = new ServiceManager(context);
        return ser.isNetworkAvailable();
    }
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        final String action = intent.getAction();
//
//        Toast.makeText(context, "BLUETOOTH CHANGED", Toast.LENGTH_LONG).show();
//
//        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
//            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
//            switch(state) {
//                case BluetoothAdapter.STATE_OFF:
//                    Toast.makeText(context, "BLUETOOTH STATE_OFF", Toast.LENGTH_LONG).show();
//                    break;
//                case BluetoothAdapter.STATE_TURNING_OFF:
//                    Toast.makeText(context, "BLUETOOTH STATE_TURNING_OFF", Toast.LENGTH_LONG).show();
//                    break;
//                case BluetoothAdapter.STATE_ON:
//                    Toast.makeText(context, "BLUETOOTH STATE_ON", Toast.LENGTH_LONG).show();
//                    break;
//                case BluetoothAdapter.STATE_TURNING_ON:
//                    Toast.makeText(context, "BLUETOOTH STATE_TURNING_ON", Toast.LENGTH_LONG).show();
//                    break;
//            }
//
//        }
//    }
}