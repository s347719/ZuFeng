package com.shuhuan.zufeng.app.cache;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/8/1.
 */


import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.util.LruCache;
import com.shuhuan.zufeng.app.util.MyLog;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * 内存缓存
 */
public class MemoryCache {
    private static MemoryCache ourInstance;

    public static MemoryCache getInstance() {
        if (ourInstance == null) {
            ourInstance = new MemoryCache();
        }

        return ourInstance;
    }

    /**
     *
     * 使用了  LruCache  算法的、可以指定内存最大现在只的 图片缓存<br/>
     * 相当于一个 HashMap
     *
     */
    private LruCache<String ,Bitmap> lruCache;

    /**
     * 软引用
     */
    private HashMap<String,SoftReference<Bitmap>> softCache;

    private MemoryCache() {
        // 设置内存的尺寸，通常都是最大内存数
        int memorySize = (int) (Runtime.getRuntime().maxMemory()/8);

        //使用内存字节数的情况，需要重写   sizeOf 方法
        lruCache = new LruCache<String, Bitmap>(memorySize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                int ret = 0;
                if (Build.VERSION.SDK_INT >=19)
                {
                    ret = value.getAllocationByteCount();
                }
                else if (Build.VERSION.SDK_INT>=12)
                {
                    ret = value.getByteCount();
                }
                else {

                    //TODO
                    //对于低于 12 的版本 需要计算  width*height*颜色字节数
                    // 一行像素占用的字节数
                     int rawBytes = value.getRowBytes();

                    //高度也就是行数
                    int bitmapHeight = value.getHeight();

                    ret = rawBytes*bitmapHeight;//  4 是 4个字节，颜色是四个字节组成

                }

                return ret;
            }
        };

        softCache = new LinkedHashMap<String, SoftReference<Bitmap>>();

    }

    /**
     * 获取缓存的图片
     * @param url
     * @return
     */
    public Bitmap getBitmap(String url)
    {

        Bitmap ret = null;
        if (url != null) {
            ret = lruCache.get(url);
            if (ret ==null)
            {
                SoftReference<Bitmap> reference = softCache.get(url);
                if (reference != null) {
                    // 获取软引用指向的数据
                    ret = reference.get();
                    if (ret != null) {
                        // 因为在异步任务的时候调用没有判断为空的状态
                        lruCache.put(url,ret);
                    }
                }
            }
        }
        return ret;
    }

    public void putBitmap(String url,Bitmap bitmap) {

        if (url != null && bitmap != null) {
            // 更新  lruCache
            lruCache.put(url, bitmap);
            // 更新软引用缓存
            softCache.put(url,new SoftReference<Bitmap>(bitmap));
            MyLog.d("MemoryCache","lru Size" + lruCache.size());
        }
    }


}
