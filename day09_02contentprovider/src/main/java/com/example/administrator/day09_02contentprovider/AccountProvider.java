package com.example.administrator.day09_02contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/9/5.
 */
public class AccountProvider extends ContentProvider
{
    //[1]定义一个路径匹配器,urimather
    /**
     * url
     * uri 自己定义的路径
     *
     */
     private  static  final int QUERYSUCESS=0;
    private  static  final UriMatcher sURIMatcher=new UriMatcher(UriMatcher.NO_MATCH);
  //NO_MATCH失败返回码 -1
    //定义静态代码块 添加匹配规则
    static
    {
        /**
         *   authority:注意,这个参数和你在清单文件中定义的要一样
         *   String path;路径
         *   string code:返回码
         */
        sURIMatcher.addURI("com.itheima.provide","query",QUERYSUCESS);
    }
    @Override
    public boolean onCreate()
    {

        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1)
    {
        int code = sURIMatcher.match(uri);
        if (code==QUERYSUCESS)
        {
         //如果匹配成功匹配成功,把query方法实现,数据库查询 对数据库操作
        }

        return null;
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
