package com.example.mansueto_sweetnote.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mansueto_sweetnote.models.Notebook;

import java.util.ArrayList;

public class NotebookDB extends DatabaseHelper {

    public static final String tableName ="notebook";
    public static final String COL_ID = "id";
    public static final String COL_NOTEBOOK_NAME = "notebook_name";
    public static final String COL_COURSE_TITLE = "course_title";
    public static final String COL_COURSE_CODE = "course_code";
    public static final String COL_INSTRUCTOR = "instructor";
    public static final String COL_PRIORITY = "priority";
    public static final String COL_SCHEDULE = "id";
    public static final String COL_SCHOOL_SEM_YEAR = "schedule";

    public NotebookDB(Context context) {
        super(context);
    }

    public static String createTable(){
        return  "CREATE TABLE notebook(id INTEGER, notebook_name TEXT NOT NULL,course_title	TEXT,course_code TEXT, instructor TEXT, priority INTEGER, schedule TEXT, school_sem_year TEXT, PRIMARY KEY(id AUTOINCREMENT));";
    }


    public boolean createNotebook(Notebook nb) {
        SQLiteDatabase db = super.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NOTEBOOK_NAME, nb.getNotebookName());
        contentValues.put(COL_COURSE_CODE, nb.getCourseCode());
        contentValues.put(COL_COURSE_TITLE, nb.getCourseTitle());
        long result = db.insert(tableName, null, contentValues);
        db.close();
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Notebook> readNotebooks(){
        SQLiteDatabase db = this.getReadableDatabase();
        Notebook nb=null;
        Cursor cursor =db.query(NotebookDB.tableName, null, "1", null, null, null, null);

        ArrayList notebookArray = new ArrayList<Notebook>();
        while(cursor.moveToNext()){
            nb = new Notebook();
            nb.setNotebookName(cursor.getString(1));
            nb.setCourseTitle(cursor.getString(2));
            nb.setCourseCode(cursor.getString(3));
            notebookArray.add(nb);
        }
        db.close();
        return notebookArray;
    }
}
