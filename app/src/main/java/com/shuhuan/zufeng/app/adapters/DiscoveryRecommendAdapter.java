package com.shuhuan.zufeng.app.adapters;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.shuhuan.zufeng.app.R;
import com.shuhuan.zufeng.app.model.DiscoveryRecommend;
import com.shuhuan.zufeng.app.model.discoveryrecommend.*;
import com.shuhuan.zufeng.app.tasks.ImageLoadTask;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/30.
 */

/**
 *
 * 发现部分->  推荐列表 Aadapter ，需要支持多布局的处理
 */

public class DiscoveryRecommendAdapter extends BaseAdapter {



    /**
     * 从接口获取的discover recomend内容，完整的推荐
     */
    private Context context;


    private View.OnClickListener onClickListener;




    public DiscoveryRecommendAdapter(Context context) {
        this.context = context;
    }
    /**
     * 从接口获取的  discover recommend 内容，完整的推荐
     */
    private DiscoveryRecommend recommend;

    /**
     * 设置的数数据<br/>
     * 这个方法在主线程调用更新
     * @param recommend
     */
    public void setRecommend(DiscoveryRecommend recommend) {
        this.recommend = recommend;
        notifyDataSetChanged();
    }
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    @Override
    public int getCount() {
        int ret = 0;
        if (recommend != null) {
            // 3  是 小编推荐  精品听单  发现新奇
            int hotCount = 0;
            HotRecommends hotRecommends = recommend.getHotRecommends();
            if (hotRecommends != null) {
                // 热门推荐 子分类
                List<HotRecommend> list = hotRecommends.getList();
                if (list != null) {

                    hotCount = list.size();
                }
            }

            ret = 3 +hotCount;
        }
        Log.d("--------", "ret = " + ret);
        return ret;
    }

    @Override
    public Object getItem(int position) {

        Object ret = null;
        switch (position)
        {
            case 0:
                ret = recommend.getEditorRecommendAlbums();
                break;
            case 1:
                ret = recommend.getSpecialColumn();
                break;
            case 2:
                ret = recommend.getDiscoverColumns();
                break;
            default:
                HotRecommends hotRecommends=recommend.getHotRecommends();
                if (hotRecommends != null) {
                    ret = hotRecommends.getList().get(position-3);
                }
                break;

        }
        return ret;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    public int getItemViewType(int position) {
        int ret = 0;
        Object item = getItem(position);
        if (item instanceof EditorRecommendAlbums){
            ret = 0;
        }else if (item instanceof SpecialColumn){
            ret = 1;
        }else if (item instanceof DiscoverColumns){
            ret = 2;
        }else if(item instanceof HotRecommends){
            ret = 3;
        }

        return ret;
    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;
        Object item = getItem(position);

        int itemViewType = getItemViewType(position);
        Log.i("------","itemViewType = " + itemViewType);
        switch (itemViewType)
        {
            case 0:
                ret = bindEditorRecommendView(item, convertView, parent);
                break;

            case 1:
                ret=bindSpecialColumn(item, convertView, parent);
                break;

            case 2:
                ret = bindDiscoveryColumns(item, convertView, parent);
                break;

            case 3:
                ret = bindHotRecommends(item, convertView, parent);
                break;
        }


        return ret;
    }





    /**
     *
     * 精品听单
     *
     *
     * 热门推荐
     * @param item
     * @param convertView
     * @param parent
     * @return
     */
    private View bindSpecialColumn(Object item, View convertView, ViewGroup parent) {

        View ret= null;


        return ret;

    }
    /**
     * 发现新奇
     * @param item
     * @param convertView
     * @param parent
     * @return
     */

    private View bindDiscoveryColumns(Object item, View convertView, ViewGroup parent) {
        View ret = null;
        return ret;

    }




    /**
     *
     *     热门推荐
     *
     *
     *
     * @param item
     * @param convertView
     * @param parent
     * @return
     */
    private View bindHotRecommends(Object item, View convertView, ViewGroup parent) {


        View ret = null;

        if (convertView != null) {
            ret=convertView;
        }
        else {

            ret =  LayoutInflater.from(context).inflate(R.layout.item_recommend_album,parent,false);
        }

        HotRecommendViewHolder holder = (HotRecommendViewHolder) ret.getTag();

        if (holder == null) {
            holder = new HotRecommendViewHolder();
            holder.txtTitle = (TextView) ret.findViewById(R.id.item_recommend_album_title);
            holder.txtMore = (TextView) ret.findViewById(R.id.item_recommend_album_more);

            holder.txtMore.setOnClickListener(onClickListener);

            holder.blocks = new ViewGroup[3];
            holder.blocks[0] = (ViewGroup) ret.findViewById(R.id.item_recommend_album_block0);
            holder.blocks[1] = (ViewGroup) ret.findViewById(R.id.item_recommend_album_block1);
            holder.blocks[2] = (ViewGroup) ret.findViewById(R.id.item_recommend_album_block2);

            ret.setTag(holder);
        }

        /////////////////////////////////

        HotRecommend hot = (HotRecommend) item;

        String title = hot.getTitle();
        holder.txtTitle.setText(title);

        boolean hasMore = hot.isHasMore();

        if (hasMore) {
            holder.txtMore.setVisibility(View.VISIBLE);
        } else {
            holder.txtMore.setVisibility(View.INVISIBLE);
        }

        ///////////////////////////
        // 水平的图片

        List<AlbumRecommend> list = hot.getList();

        if (list != null) {

            int size = list.size();

            if (size > 3) {
                size = 3;
            }

            for (int i = 0; i < size; i++) {
                ViewGroup block = holder.blocks[i];

                ImageButton img = (ImageButton) block.getChildAt(0);

                AlbumRecommend recommend = list.get(i);

                // 网址
                String coverLarge = recommend.getCoverLarge();

                boolean needLoad = true;
                Object tag = img.getTag();
                if (tag != null) {
                    if(tag instanceof String){
                        String s = (String) tag;
                        if(s.equals(coverLarge)){
                            needLoad = false;
                        }
                    }
                }
                if(needLoad) {
                    // 设置“图片加载中”显示
                    img.setImageResource(R.mipmap.ic_launcher);
                }

                img.setOnClickListener(onClickListener);

                TextView blockTitle = (TextView) block.getChildAt(1);

                // TODO 加载图片
                blockTitle.setText(recommend.getTrackTitle());

                // 用于在异步任务中，进行图片下载地址的识别，避免错位
                img.setTag(coverLarge);

                if (coverLarge != null && needLoad) {

                    ImageLoadTask task = new ImageLoadTask(img);

                    // 手机版本的适配
                    if (Build.VERSION.SDK_INT >= 11) {
                        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, coverLarge);
                    } else {
                        task.execute(coverLarge);
                    }
                }


            }
        }



        return ret;
    }





    /**
     *
     *   小编推荐
     * @param item
     * @param convertView
     * @param parent
     * @return
     */
    private View bindEditorRecommendView(Object item, View convertView, ViewGroup parent) {

        View ret= null;

        if (convertView !=null) {
            ret = convertView;
        }else
        {
            ret = LayoutInflater.from(context).inflate(R.layout.item_recommend_album,parent,false);
        }

        AlbumRecommendViewHolder holder = (AlbumRecommendViewHolder) ret.getTag();
        if (holder ==null)
        {
            holder = new AlbumRecommendViewHolder();
            //  TODO  加载布局的 View

            holder.txtTitle = (TextView)ret.findViewById(R.id.item_recommend_album_title);
            holder.txtMore = (TextView) ret.findViewById(R.id.item_recommend_album_more);
            holder.block0 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block0);
            holder.block1 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block1);
            holder.block2 = (LinearLayout) ret.findViewById(R.id.item_recommend_album_block2);


            holder.block0ImageButton = (ImageButton) holder.block0.getChildAt(0);
            holder.block0ImageButton.setOnClickListener(onClickListener);
            holder.block0TextView = (TextView) holder.block0.getChildAt(1);

            holder.block1ImageButton = (ImageButton) holder.block1.getChildAt(0);
            holder.block1ImageButton.setOnClickListener(onClickListener);
            holder.block1TextView = (TextView) holder.block1.getChildAt(1);

            holder.block2ImageButton = (ImageButton) holder.block2.getChildAt(0);
            holder.block2ImageButton.setOnClickListener(onClickListener);
            holder.block2TextView = (TextView) holder.block2.getChildAt(1);

            ret.setTag(holder);
        }

        EditorRecommendAlbums albums = (EditorRecommendAlbums) item;

        String title = albums.getTitle();
        holder.txtTitle.setText(title);

        boolean hasMore = albums.isHasMore();

        /////////////////////////////////
        if (hasMore)
        {
            holder.txtMore.setVisibility(View.VISIBLE);
        }
        else {
            holder.txtMore.setVisibility(View.INVISIBLE);
        }

        /////////////////////////////////////////

        List<AlbumRecommend> list = albums.getList();

        if (list != null) {

            int size = list.size();

            if (size>3)
            {
                size=3;
            }
            for (int i = 0; i < size; i++) {
                AlbumRecommend recommend = list.get(i);

                String coverLarge = recommend.getCoverLarge();

                String tit = recommend.getTrackTitle();
                ImageView imageView =null;

                switch (i)
                {
                    case 0:
                        holder.block0TextView.setText(tit);
                        imageView = holder.block0ImageButton;
                        break;
                    case 1:
                        holder.block1TextView.setText(tit);
                        imageView = holder.block1ImageButton;
                        break;
                    case 2:
                        holder.block2TextView.setText(tit);
                        imageView = holder.block2ImageButton;
                        break;
                }
                if (imageView!=null && coverLarge !=null)
                {
                    imageView.setImageResource(R.mipmap.ic_launcher);

                    imageView.setTag(coverLarge);

                    ImageLoadTask task = new ImageLoadTask(imageView);

                    // 手机版本的适配
                    if (Build.VERSION.SDK_INT>=11) {
                        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, coverLarge);
                    }
                    else
                    {
                        task.execute(coverLarge);
                    }
                }
            }
        }


        return ret;
    }


    private static class HotRecommendViewHolder
    {
        public TextView txtTitle;
        public TextView txtMore;
        /**
         * 三块图片文字的布局
         */
        public ViewGroup[] blocks;

    }


    /**
     * 小编推荐，热门推荐，使用的ViewHolder
     */
    private static class AlbumRecommendViewHolder
    {
        public TextView txtTitle;
        public TextView txtMore;
        public LinearLayout block0;
        public LinearLayout block1;
        public LinearLayout block2;

        //////////////////////////
        // 每一个block 的自内容

        public ImageButton block0ImageButton;
        public TextView block0TextView;


        public ImageButton block1ImageButton;
        public TextView block1TextView;

        public ImageButton block2ImageButton;
        public TextView block2TextView;


    }

    /**
     * 精品听单
     */
    private static class SpecialViewHolder
    {

    }

    private static class DiscoverColoumViewHolder
    {

    }
}
