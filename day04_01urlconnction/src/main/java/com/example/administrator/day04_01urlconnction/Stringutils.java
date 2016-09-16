package com.example.administrator.day04_01urlconnction;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/11.
 */
public class Stringutils
{
    private static String content;
    //把Inputstream

    public static String readStream(InputStream inputStream)
    {

        try
        {
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            int len=-1;
            byte[] buff=new byte[1024];
            while ((len= inputStream.read(buff))!=-1)
            {
                byteArrayOutputStream.write(buff,0,len);


            }
            content = new String(byteArrayOutputStream.toByteArray());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

         return content;
    }


}
