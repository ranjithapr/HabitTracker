package com.udacity.ranjitha.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.udacity.ranjitha.habittracker.R;
import com.udacity.ranjitha.habittracker.data.DbHelper;
import com.udacity.ranjitha.habittracker.data.HabitPojo;

public class MainActivity extends AppCompatActivity {

    private DbHelper habitTrackerHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        habitTrackerHelper = new DbHelper(this);
        insertDataIntoDB();
        Cursor resultSet = readDataFromDb();
    }

    private void insertDataIntoDB() {

        db = habitTrackerHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitPojo.HabitInfo.COLUMN_PERSON_NAME,"Ranjitha");
        values.put(HabitPojo.HabitInfo.COLUMN_PERSON_AGE,34);
        values.put(HabitPojo.HabitInfo.COLUMN_DAY,"MONDAY");
        values.put(HabitPojo.HabitInfo.COLUMN_DATE,"3/2/2017");
        values.put(HabitPojo.HabitInfo.COLUMN_TIME,"5:00PM-6:00 PM");
        values.put(HabitPojo.HabitInfo.COLUMN_HABIT,"WALKING");

        db.insert(HabitPojo.HabitInfo.TABLE_NAME,null,values);

        ContentValues values1 = new ContentValues();
        values1.put(HabitPojo.HabitInfo.COLUMN_PERSON_NAME,"Ranjitha");
        values1.put(HabitPojo.HabitInfo.COLUMN_PERSON_AGE,34);
        values1.put(HabitPojo.HabitInfo.COLUMN_DAY,"MONDAY");
        values1.put(HabitPojo.HabitInfo.COLUMN_DATE,"3/5/2017");
        values1.put(HabitPojo.HabitInfo.COLUMN_TIME,"5:00AM-6:00 AM");
        values1.put(HabitPojo.HabitInfo.COLUMN_HABIT,"Exercise");

        db.insert(HabitPojo.HabitInfo.TABLE_NAME,null,values1);

    }

    private Cursor readDataFromDb() {

        String[] info= {
                HabitPojo.HabitInfo._ID,
                HabitPojo.HabitInfo.COLUMN_PERSON_NAME,
                HabitPojo.HabitInfo.COLUMN_PERSON_AGE,
                HabitPojo.HabitInfo.COLUMN_DAY,
                HabitPojo.HabitInfo.COLUMN_DATE,
                HabitPojo.HabitInfo.COLUMN_TIME,
                HabitPojo.HabitInfo.COLUMN_HABIT
        };
        Cursor cursor = db.query(
                HabitPojo.HabitInfo.TABLE_NAME,
                info,
                null,
                null,
                null,
                null,
                null);

        //figure out index of each column

        int idIndex = cursor.getColumnIndex(HabitPojo.HabitInfo._ID);
        int nameIndex = cursor.getColumnIndex(HabitPojo.HabitInfo.COLUMN_PERSON_NAME);
        int ageIndex = cursor.getColumnIndex(HabitPojo.HabitInfo.COLUMN_PERSON_AGE);
        int dayIndex = cursor.getColumnIndex(HabitPojo.HabitInfo.COLUMN_DAY);
        int dateIndex = cursor.getColumnIndex(HabitPojo.HabitInfo.COLUMN_DATE);
        int timeIndex = cursor.getColumnIndex(HabitPojo.HabitInfo.COLUMN_TIME);
        int habitIndex = cursor.getColumnIndex(HabitPojo.HabitInfo.COLUMN_HABIT);

        while (cursor.moveToNext()){
            int currentId = cursor.getInt(idIndex);
            String personName = cursor.getString(nameIndex);
            int age = cursor.getInt(ageIndex);
            String day = cursor.getString(dayIndex);
            String date = cursor.getString(dateIndex);
            String time = cursor.getString(timeIndex);
            String habit = cursor.getString(habitIndex);

            //For the data display purpose only
            Toast.makeText(this,"Id: " + currentId,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Name: " + personName,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Age: " + age,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Day: " + day,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Date: " + date,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Time: " + time,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Habit: " + habit,Toast.LENGTH_SHORT).show();
        }

        return cursor;
    }
}
