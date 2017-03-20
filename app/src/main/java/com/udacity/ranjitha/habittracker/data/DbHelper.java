package com.udacity.ranjitha.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CS on 1/5/2017.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "my_habit.db";
    public static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PERSON_HABIT_ENTRY =
                "CREATE TABLE " + HabitPojo.HabitInfo.TABLE_NAME + " (" +
                        HabitPojo.HabitInfo._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        HabitPojo.HabitInfo.COLUMN_PERSON_NAME + " TEXT, " +
                        HabitPojo.HabitInfo.COLUMN_PERSON_AGE + " INTEGER, " +
                        HabitPojo.HabitInfo.COLUMN_DATE + " TEXT, " +
                        HabitPojo.HabitInfo.COLUMN_DAY + " TEXT, " +
                        HabitPojo.HabitInfo.COLUMN_HABIT + " TEXT, " +
                        HabitPojo.HabitInfo.COLUMN_TIME + " TEXT" + ")";
        db.execSQL(SQL_CREATE_PERSON_HABIT_ENTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_PERSON_HABIT_ENTRY =
                "DELETE FROM " + HabitPojo.HabitInfo.TABLE_NAME;
        db.execSQL(SQL_DELETE_PERSON_HABIT_ENTRY);
    }
}
