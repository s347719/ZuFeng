package com.shuhuan.zufeng.app.util;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/28.
 */

import java.io.*;
import java.net.HttpURLConnection;

/**
 * IO操作的工具类
 */
public class StreamUtil {
        private StreamUtil(){}

    public static void close(Object stream)
    {
        if (stream != null) {
            try{
                if (stream instanceof InputStream)
                {
                    ((InputStream)stream).close();
                }
                else if (stream instanceof OutputStream)
                {
                    ((OutputStream)stream).close();
                }
                else if (stream instanceof Writer)
                {
                    ((Writer)stream).close();
                }
                else if (stream instanceof HttpURLConnection)
                {
                    ((HttpURLConnection)stream).disconnect();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * 将输入流中的数据独取出来存放在自己的数组中
     *
     * @param in
     *
     * @return
     */
    public static byte[] readStream(InputStream in) throws IOException {
        byte[] ret = null;

        if (in != null) {
            byte[] buf = new byte[128];
            int len = 0;
            ByteArrayOutputStream bout = null;
            bout = new ByteArrayOutputStream();

            while ((len = in.read(buf)) != -1) {
                bout.write(buf, 0, len);
            }
            buf = null;
            ret = bout.toByteArray();
            bout.close();
        }

        return ret;

    }

    }
