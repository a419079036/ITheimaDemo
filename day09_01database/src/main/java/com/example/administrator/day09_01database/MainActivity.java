package com.example.administrator.day09_01database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyopenDataHelper myopenDataHelper=new MyopenDataHelper(getApplicationContext());
        SQLiteDatabase database = myopenDataHelper.getReadableDatabase();
        Cursor cursor = database.query("info", null, null, null, null, null, null);
        if (cursor!=null&&cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                String name = cursor.getString(1);
                String monny = cursor.getString(2);

                Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + name+monny);

            }

        }
    }
}
