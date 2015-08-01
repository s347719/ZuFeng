package com.shuhuan.zufeng.app.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.shuhuan.zufeng.app.cache.FileCache;
import com.shuhuan.zufeng.app.cache.MemoryCache;
import com.shuhuan.zufeng.app.client.HttpUtil;
import com.shuhuan.zufeng.app.util.ImageUtil;
import com.shuhuan.zufeng.app.util.MyLog;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/31.
 */


/**
 *
 * 下载图片
 */
public class ImageLoadTask extends AsyncTask<String ,Integer,Bitmap>
{

    public static final String TAG = "ImageLoadTask";
    /**
     * 当前任务要设置的目标
     */
    private ImageView imageView;



    public ImageLoadTask(ImageView imageView) {
        this.imageView = imageView;
    }

private String url;
    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap ret = null;

        if (params!=null && params.length>0)
        {
            url = params[0];

            ret = MemoryCache.getInstance().getBitmap(url);
            // 获取到，返回，没有获取到直接进入到文件缓存步骤
            if (ret == null) {
                byte[] data = FileCache.getInstance().loadFile(url);
                if (data == null) {
                    data = HttpUtil.doGet(url);
                    // 文件缓存
                    FileCache.getInstance().saveFile(url, data);
                }
                // 1, 文件缓存
                // 2  图片二次采样
                // 3，图片的内存缓存
                if (data != null) {
                    // 1,TODO 进行二次采样
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    ret = BitmapFactory.decodeByteArray(data, 0, data.length, options);

                    MyLog.d(TAG,"First ret = " + ret);
                    MyLog.d(TAG,"outHeight = "+options.outHeight);
                    MyLog.d(TAG,"outHeight = "+options.outWidth);
                    MyLog.d(TAG,"outHeight = "+options.outMimeType);

                    // 2,计算原始尺寸与目标尺寸的采样比例  看API
                    //   Develop Loading Large Bitmaps Efficiently
                    //   查看 Util 工具类中的 ImageUtil.class


                    //3,  设置Options 为实际解析图片，并且设置采样比例
                    //  设置的参数一般都是2的倍数，缩放的比例是每条边上的

                    options.inJustDecodeBounds=false;
                    //可以被消除的
                    options.inPurgeable = true;

                    // 设置解码器，可以使用的解码像素颜色的配置
                    //注意透明度与颜色的关系
                    // 如果图片不能够使用这个配置，那么就自动使用 ARGB_8888


                    options.inPreferredConfig =Bitmap.Config.RGB_565;
                    options.inSampleSize = ImageUtil.calculateInSampleSize(options,imageView.getWidth(),imageView.getHeight());

                    ret = BitmapFactory.decodeByteArray(data, 0, data.length,options);
                    data = null;
                    MemoryCache.getInstance().putBitmap(url,ret);

                }
            }
        }

        return ret;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            if (imageView != null) {
                Object tag = imageView.getTag();

                if (tag != null) {

                    String str = null;
                    if (tag instanceof String )
                    {
                        str = (String)tag;

                    }

                    else if (tag instanceof String [])
                    {
                        String [] ss = (String[])tag;
                        str = ss[0];
                    }
                 if (url.equals(str))
                 {
                     imageView.setImageBitmap(bitmap);
                 }

                }
            }
        }


    }
}
