package com.example.administrator.day09_01database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/9/5.
 */
public class AccountProviers extends ContentProvider
{
    //定义一个常量
    private  static  final int QUERYSUCESS=0;

    //[1]定义一个路径匹配器
    private  static  final UriMatcher sURIMatcher=new UriMatcher(UriMatcher.NO_MATCH);
    //常量UriMatcher.NO_MATCH表示不匹配任何路径的返回码

    //静态代码块,添加匹配规则,在类加载时就加载,而且只加载一次
    static
    {
        sURIMatcher.addURI("com.lrrh.liu","query",QUERYSUCESS);//修改
       //1233432432432
    }

    private MyopenDataHelper myopenDataHelper;

    @Override
    public boolean onCreate()
    {
        myopenDataHelper = new MyopenDataHelper(getContext());


        return  false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1)
    {
        int code=sURIMatcher.match(uri);
        if (code==QUERYSUCESS)
        {
            //说明路径匹配成功
            SQLiteDatabase database = myopenDataHelper.getReadableDatabase();
            Cursor cursor = database.query("info", strings, s, null, null, null, s1);
            return cursor;

        }
        else
        {
            throw new IllegalArgumentException("路径错误");
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri)
    {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues)
    {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings)
    {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings)
    {
        return 0;
    }
}
