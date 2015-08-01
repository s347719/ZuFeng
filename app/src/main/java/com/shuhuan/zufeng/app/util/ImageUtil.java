package com.shuhuan.zufeng.app.util;

import android.graphics.BitmapFactory;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/8/1.
 */

/**
 *
 * 计算采样必烈的工具类
 *
 */
public class ImageUtil {

    private ImageUtil(){

    }

    /**
     *
     * 图片的采样比率计算，通过options 中包含的原始图片尺寸和目标尺寸来计算图片采样比率
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (reqHeight ==0 || reqWidth==0)
        {
             return inSampleSize ;
        }
        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
