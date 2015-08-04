package com.shuhuan.zufeng.app.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.shuhuan.zufeng.app.R;
import com.shuhuan.zufeng.app.model.discoveryrecommend.horecommendclickshow.HotRecommendClickShow;
import com.shuhuan.zufeng.app.model.discoveryrecommend.horecommendclickshow.ShowTrack;
import com.shuhuan.zufeng.app.model.discoveryrecommend.horecommendclickshow.ShowTracksListPlayer;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/8/2.
 */
public class HotRecommendAlbumAdapter extends BaseAdapter {


    private Context context;


    public HotRecommendAlbumAdapter(Context context) {
        this.context = context;
    }

    private HotRecommendClickShow clickShow;

    public void setClickShow(HotRecommendClickShow clickShow)
    {
        this.clickShow = clickShow;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        int ret = 0;
        if (clickShow != null) {
            ShowTrack showTrack = clickShow.getShowTrack();
            if (showTrack != null) {
                List<ShowTracksListPlayer> list = showTrack.getList();
                if (list != null) {
                    ret = list.size();
                }
            }
        }

        return ret;
    }

    @Override
    public Object getItem(int position) {

        return clickShow.getShowTrack().getList().get(position);

    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View ret = null;

        if (convertView != null) {
            ret = convertView;
        }
        else
        {
            ret = LayoutInflater.from(context).inflate(R.layout.hot_recommend_album,parent,false);
        }

        HotRecommendViewHolder holder = (HotRecommendViewHolder)ret.getTag();

        if (holder==null)
        {
            holder = new HotRecommendViewHolder();
            holder.textView1 = (TextView)ret.findViewById(R.id.hot_recommend_adapter_text1);
            holder.textView2 = (TextView)ret.findViewById(R.id.hot_recommend_adapter_text2);
            ret.setTag(holder);
        }
        ShowTracksListPlayer listPlayer = clickShow.getShowTrack().getList().get(position);

        String title = listPlayer.getTitle();
        int timeState = listPlayer.getProcessState();
        listPlayer.getTrackId();

        Log.i("-------","--适配器--"+title);
        Log.i("-------","--适配器--"+timeState);


        holder.textView1.setText(title);
        holder.textView2.setText(timeState+"");





        return ret;
    }


    private static class HotRecommendViewHolder{


        public TextView textView1;
        public TextView textView2;

    }
}
