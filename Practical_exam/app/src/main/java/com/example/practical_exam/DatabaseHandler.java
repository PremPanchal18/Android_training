package com.example.practical_exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper  {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "alarmManager";
    private static final String TABLE_DATEANDTIME = "date";

    private static final String DATEANDTIME = "dateandtime";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DATEANDTIME_TABLE = "CREATE TABLE "
                + TABLE_DATEANDTIME + "("
                + DATEANDTIME + " TEXT"
                + ")";
        db.execSQL(CREATE_DATEANDTIME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATEANDTIME);
    }

    void addDate(String dateandtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATEANDTIME,dateandtime);

        db.insert(TABLE_DATEANDTIME, null, values);

        db.close();
    }

    public ArrayList<UseModel> getAllContacts() {
        ArrayList<UseModel> contactList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_DATEANDTIME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                UseModel m = new UseModel();
                m.setDateTime(cursor.getString(0));

                contactList.add(m);
            } while (cursor.moveToNext());
        }
        return contactList;
    }
}
