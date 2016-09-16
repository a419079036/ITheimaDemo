package com.example.administrator.itheimademo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyOpenHelper myOpenHelper = new MyOpenHelper(getApplicationContext());
        SQLiteDatabase database = myOpenHelper.getReadableDatabase();

        Cursor info = database.query("info", null, null, null, null, null, null);
        if (info!=null&&info.getCount()>0)
        {
            while (info.moveToNext())
            {
                String name = info.getString(1);
                String monny = info.getString(2);

                Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + name+monny);

            }

        }
    }
}
