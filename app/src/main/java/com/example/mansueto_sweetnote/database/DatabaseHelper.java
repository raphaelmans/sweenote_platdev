package com.example.mansueto_sweetnote.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    //Student s = new Student();

    //define database and table name
    public static final String DATABASE_NAME = "sweetnote.db";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NotebookDB.createTable());
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +NotebookDB.tableName );
        onCreate(db);
    }

//    public boolean createStudent() {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(col_studid, 5);
//        contentValues.put(col_lname, "lname");
//        contentValues.put(col_fname, "fname");
//        contentValues.put(col_course, "course");
//        contentValues.put(col_year, 2001);
//
//        long result = db.insert(table_name, null, contentValues);
//        db.close();
//        //if date as inserted incorrectly it will return -1
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}
