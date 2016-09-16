package com.example.administrator.day09_01database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/5.
 */
public class MyopenDataHelper extends SQLiteOpenHelper
{
    public MyopenDataHelper(Context context)
    {
        super(context, "Account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table info (_id integer primary key autoincrement,name varchar(20),money varchar(20))");
        sqLiteDatabase.execSQL("insert into info(name,money) values(?,?)",new String[]{"张三","5000"});
        sqLiteDatabase.execSQL("insert into info(name,money) values(?,?)",new String[]{"李四","3000"});

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
