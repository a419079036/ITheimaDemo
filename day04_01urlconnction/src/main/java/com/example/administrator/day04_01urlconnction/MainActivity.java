package com.example.administrator.day04_01urlconnction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
{

    EditText input;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input= (EditText) findViewById(R.id.input);
        result= (TextView) findViewById(R.id.textview_result);
    }

    //按钮点击事件
    public  void  OnClick(View view)
    { Log.e("自定义标签", "类名==MainActivity" + "方法名==OnClick=====:" + "");
       switch (view.getId())
        {
          case   R.id.bt1:
              //获取源码路径
              String path = input.getText().toString().trim();
              if (!path.equals(null))
              {

                  try
                  {
                      //创建URL对象,指定访问网址
                      URL url=new URL("https://www.baidu.com/");
                      //拿到
                      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                      connection.setConnectTimeout(5000);//设置请求超时时间
                      connection.setReadTimeout(5000);
                      connection.setRequestMethod("GET");//默认就是get请求
                     
                      int code = connection.getResponseCode();

                      if (code==200)//获取服务器返回的数据
                      {
                          InputStream inputStream = connection.getInputStream();

                          //把流的数据返回到textview
                          String content = Stringutils.readStream(inputStream);
                          result.setText(content);

                      }

                  }
                  catch (MalformedURLException e)
                  {
                      e.printStackTrace();
                  }
                  catch (IOException e)
                  {
                      e.printStackTrace();
                  }
              }
              break;

       }


    }

}
