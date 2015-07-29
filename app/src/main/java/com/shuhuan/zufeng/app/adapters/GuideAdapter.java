package com.shuhuan.zufeng.app.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.shuhuan.zufeng.app.R;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */

/**
 *
 * 教程页的   Viewpager  的适配器
 */
public class GuideAdapter extends PagerAdapter {



    private List<Integer> images;

    private Context context;
    private View.OnClickListener goOnClickListener;

    public GuideAdapter(Context context,List<Integer> images) {
        this.context = context;
        this.images = images;
    }

    public void setGuideGoOnClickListener(View.OnClickListener goOnClickListener) {
        this.goOnClickListener = goOnClickListener;
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (images!= null) {
            ret = images.size();
        }
        return ret;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        // 对于FragmentPagerAdapter ，o 是Fragment
        // view 与 o 的判断就不能够直接 view ==  o
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View ret = null;

        int retId = images.get(position);
        if (position == images.size()-1)
        {
            // TODO 设置布局添加按钮
            FrameLayout frameLayout = new FrameLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(retId);

            ViewGroup.LayoutParams lp1 =
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                              ViewGroup.LayoutParams.MATCH_PARENT);

            imageView.setLayoutParams(lp1);

            frameLayout.addView(imageView);
            Button btnGo = new Button(context);


            btnGo.setText(R.string.guide_start_main);

            //第三个参数指定控件在FragmenLayout 的哪个位置
            FrameLayout.LayoutParams lp2 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM);

            // TODO 需要进行 机型适配
            lp2.bottomMargin =80;

            btnGo.setLayoutParams(lp2);

            btnGo.setOnClickListener(goOnClickListener);
            btnGo.setTag("go");
            frameLayout.addView(btnGo);

            ret = frameLayout;
        }

        else
        {
            // TODO 直接添加图片
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(retId);
            ret = imageView;
        }

        container.addView(ret);
        return ret;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        if (object instanceof View)
        {
            container.removeView((View)object);
        }
    }
}
