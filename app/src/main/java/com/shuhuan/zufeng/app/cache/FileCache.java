package com.shuhuan.zufeng.app.cache;

import android.content.Context;
import android.os.Environment;
import com.shuhuan.zufeng.app.util.StreamUtil;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/31.
 */
public class FileCache
{

    private static FileCache outInstance;
    public static FileCache createInstance(Context context)
    {
        if (context != null) {


            if (outInstance == null) {
                outInstance = new FileCache(context);
            }
            return outInstance;
        }
        else {
            throw new IllegalArgumentException("Context must be set.");
        }
    }

    public static FileCache getInstance()
    {
        if (outInstance != null) {

            return outInstance;
        }
        else

        {
            throw new IllegalStateException("you must invoke createInstance(Context) before getInstance");
        }
    }

    private Context context;
    private FileCache(Context context)
    {
        this.context = context;
    }

    /**
     * 通过网址加载文件
     * @param url
     * @return
     */
    public byte[] loadFile(String url)
    {
        byte[] ret = null;
        File cacheDir = null;
        String state = Environment.getExternalStorageState();

        if (state.equals(Environment.MEDIA_MOUNTED))
        {
            //外部
            cacheDir = context.getExternalCacheDir();
        }
        else {
            //内部
            cacheDir = context.getCacheDir();
        }
        if (url !=null)
        {
            //TODO  url 的转换
            String name = md5(url);
            File file = new File(cacheDir,name);

            if (file.exists()) {
                FileInputStream fin = null;
                try {
                    fin = new FileInputStream(file);
                    ret = StreamUtil.readStream(fin);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    StreamUtil.close(fin);
                }
            }
        }
        return ret;
    }

    public void saveFile(String url, byte[] data)
    {

        File cacheDir = null;
        String state = Environment.getExternalStorageState();

        if (state.equals(Environment.MEDIA_MOUNTED))
        {
            //外部
            cacheDir = context.getExternalCacheDir();
        }
        else {
            //内部
            cacheDir = context.getCacheDir();
        }
        if (url !=null)
        {
            //TODO  url 的转换
            String name = md5(url);
            File file = new File(cacheDir,name);
            FileOutputStream fout = null;
            try {
                fout = new FileOutputStream(file);
                fout.write(data);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                StreamUtil.close(fout);
            }

        }

    }

    /**
     * 转换网址
     * @param url
     * @return
     */
    public static String md5(String url){
        String ret = null;
        if (url != null) {

            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                //经过MD5的内容字节数组 无法 new String
                byte[] data = digest.digest(url.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : data) {
                    int h = (b>>4) & 0x0f;//0x0f 是16进制，对应2进制就是1111  & 是相同为真 一个字节是8位
                    int l = b&0x0f;
                    sb.append(Integer.toHexString(h)); //toHexString  是转换为16进制
                    sb.append(Integer.toHexString(l));

                }

                ret = sb.toString();
                sb= null;
                data = null;

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
        return  ret ;
    }

}
