package com.example.administrator.day09_readdemo;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //需求 读取第一个应用的私有的数据库
/** path:路径
 * factor;游标工厂
 * flags:访问模式
 *
 */
 /*       SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.example.administrator.itheimademo/databases/Account.db", null, SQLiteDatabase.OPEN_READWRITE);

        Cursor info = db.query("info", null, null, null, null, null, null);
        if (info!=null&&info.getCount()>0)
        {
            while (info.moveToNext())
            {
                String name = info.getString(1);
                String monny = info.getString(2);

                Log.e("第二个自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + name+monny);

            }

        }*/

        //方法2:
        Uri uri = Uri.parse("content://com.lrrh.liu/query");//路径和你定义的路径一样
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0)
        {
            while (cursor.moveToNext())
            {
                String name = cursor.getString(1);
                String monny = cursor.getString(2);

                Log.e("第二个自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + name + monny);

            }

        }
    }
}
