package com.example.w6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "mycontactslist";
    public static final String COL_1 = "Name";
    public static final String Col_2 = "PhoneNumber";

    public DBHelper(Context context){
        super(context, "mycontactslist.db",null,1);
    }
  
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"("+COL_1+","+Col_2+")");
    }
  
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
  
    public void insertdata(String name, String phone){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();
        cValues.put(COL_1, name);
        cValues.put(Col_2, phone);
        myDB.insert(TABLE_NAME,null,cValues);
    }
  
    public Cursor getAllData(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor res = myDB.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }
}
