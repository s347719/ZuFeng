package com.shuhuan.zufeng.app.client;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/28.
 */

import android.os.Build;
import android.util.Log;
import com.shuhuan.zufeng.app.util.StreamUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * 网络工具类，用于  Http 请求 get ， post 请求
 */
public final class HttpUtil {

    public static final int TIMEOUT_CONNECT = 5000;
    public static final int TIMEOUT_READ = 5000;

    private HttpUtil()
    {

    }

    ////////////////////////////////

    /**
     * 获取get请求 返回字节数组
     * @param url  String url
     * @return  byte[]
     */
    public static byte[] doGet(String url)
    {
        Log.d("======",url);
        byte[] ret = null;
        if (url != null) {
            // 注意释放连接
            HttpURLConnection conn = null;
            InputStream in =null;


            try {
                URL u = new URL(url);
                conn= (HttpURLConnection) u.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept-Encoding", "gzip");//设置http 请求头
                conn.setRequestProperty("User-Agent","ting_4.1.7(MI2,"+ Build.VERSION.SDK_INT+")");

                // 设置联网超时，只能够用于短时间的联网操作
                //长时间的另外写一套

                //Socket打开连接的时间
                conn.setConnectTimeout(TIMEOUT_CONNECT);
                conn.setReadTimeout(TIMEOUT_READ);

                ///////////////////
                //连接的属性
                //设置自动处理  302/307 跳转，通常会返回 200
                conn.setInstanceFollowRedirects(true);
//                conn.setChunkedStreamingMode();通常在播放视频的时候
                //连接
                conn.connect();
                //取出状态码
                int code = conn.getResponseCode();

                Log.i("---------","code=" + code);

                if (code ==200)
                {
                    in = conn.getInputStream();
                    //获取服务器的头信息，内容是否压缩
                    String contentEncoding = conn.getHeaderField("Content-Encoding");
                    if (contentEncoding == null) {
                        contentEncoding= conn.getHeaderField("content-Encoding");
                    }
                    if (contentEncoding!=null&&contentEncoding.equals("gzip"))
                    {
                        //代表数据经过压缩
                        in = new GZIPInputStream(in);
                    }
                    //读流  利用工具类
                    ret = StreamUtil.readStream(in);

                }
                else
                {
                    //TODO  其他情况
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                StreamUtil.close(in);
                StreamUtil.close(conn);
            }
        }
        Log.i("----------","ret="+ ret);
        return  ret ;
    }


}