package com.shuhuan.zufeng.app.client;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/28.
 */



import android.util.Log;

import java.io.UnsupportedEncodingException;

/**
 * 发现部分的API接口
 */
public class ClientDiscoveryAPI {
    public static final String SERVER_MOBILE = "http://mobile.ximalaya.com";

    private ClientDiscoveryAPI() {

    }
    //////////////////////////////////



    /**
     * 获取 发现 －》 推荐的内容<br/>
     * 调用接口: http://mobile.ximalaya.com/mobile/discovery/v1/recommends
     * 参数: <br/>
     * <ul>
     * <li>channel=and-f6</li>
     * <li>device=android</li>
     * <li>includeActivity=true</li>
     * <li>includeSpecial=true</li>
     * <li>scale=2</li>
     * <li>version=4.1.7.1</li>
     * </ul>
     *
     * @return
     */
    public static String getDiscoveryRecommend() {
        String ret = null;

        String url = SERVER_MOBILE+"/mobile/discovery/v1/recommends"
                +"?channel=and-f6"
                +"&device=android"
                +"&includeActivity=true"
                +"&includeSpecial=true"
                +"&scale=2"
                +"&version=4.1.7.1";

        byte[] bytes = HttpUtil.doGet(url);

        if (bytes != null) {
            try {

                ret = new String(bytes,"UTF-8");
//                Log.i("------经过UTF-8---------",ret);
            } catch (UnsupportedEncodingException e) {
                ret = new String(bytes);
            }
        }


        return ret;

    }

    /**
     *   http://mobile.ximalaya.com/mobile/discovery/v1/tabs?device=android
     * @return
     */

    public static String getDiscoveryTasbs()
    {

        String ret = null;
        String url = SERVER_MOBILE +"/mobile/discovery/v1/tabs?device=android";

//        Log.i("---------","url="+url);

        byte[] bytes = HttpUtil.doGet(url);
        if (bytes != null) {
            try {
                ret = new String(bytes,"UTF-8");

            } catch (UnsupportedEncodingException e) {
                ret = new String (bytes);
            }
        }
//        Log.i("------------","ret=" + ret);
        return ret;
    }


    //////////////////////////////

    /**
     *  获取分类Tag菜单<br/>
     *  调用接口是哪个 ：http://mobile.ximalaya.com/m/category_tag_menu
     *  请求方法：GET<br/>
     *@param type  可选  默认是user
     *@return
     */
    public static String getCategoryTagMenu(String type) {
        String ret = null;
        String url = null;
        StringBuilder sb = new StringBuilder();
        sb.append(SERVER_MOBILE);
        sb.append("/m/CategoryTagMenu");
        if (type != null) {
            sb.append("?type=").append(type);
            sb.append("&device=android");
        }
        url = sb.toString();
        sb= null;
        byte[] data = HttpUtil.doGet(url);
        if (data != null) {
            try {
                ret = new String(data,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                ret = new String(data);
            }
        }
        return ret;

    }


    /**
     *
     * 获取发现的分类<br/>
     * 调用的接口：http://mobile.ximalaya.com/mobile/discovery/v1/categories?device=android&picVersion=10&scale=2<br/>
     *
     * @return
     */
    public static String getDiscoveryCategories() {
        String ret =null;
        String url = SERVER_MOBILE +"/mobile/discovery/v1/categories"
                +"?device=android"
                +"&picVersion=10"
                +"scale=2";

        byte[] bytes = HttpUtil.doGet(url);
        if (bytes != null) {
            try {
                ret = new String(bytes,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                ret = new String(bytes);
            }
        }
        return ret;
    }


}
