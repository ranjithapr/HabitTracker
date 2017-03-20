package com.udacity.ranjitha.habittracker.data;

import android.provider.BaseColumns;


public final class HabitPojo {


    public static final class HabitInfo implements BaseColumns{

        public static final String TABLE_NAME = "my_habit";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PERSON_NAME = "name";
        public static final String COLUMN_PERSON_AGE = "age";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DAY = "day";
        public static final String COLUMN_HABIT = "habit_type";

    }

    private HabitPojo(){}
}
