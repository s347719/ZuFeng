package com.shuhuan.zufeng.app.fragments.discover;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shuhuan.zufeng.app.Constants;
import com.shuhuan.zufeng.app.HotRecommendActivity;
import com.shuhuan.zufeng.app.R;
import com.shuhuan.zufeng.app.adapters.DiscoveryRecommendAdapter;
import com.shuhuan.zufeng.app.model.DiscoveryRecommend;
import com.shuhuan.zufeng.app.parsers.DataParser;
import com.shuhuan.zufeng.app.tasks.TaskCallback;
import com.shuhuan.zufeng.app.tasks.TaskResult;
import com.shuhuan.zufeng.app.tasks.impl.DiscoveryRecommendTask;
import com.shuhuan.zufeng.app.util.UncaughtExceptionHandlerimpl;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */
public class DiscoveryRecommendFragment extends Fragment implements AdapterView.OnItemClickListener, TaskCallback, View.OnClickListener {

    private DiscoveryRecommendAdapter adapter;
    public DiscoveryRecommendFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ret =  inflater.inflate(R.layout.fragment_discovery_recommend, container, false);
//        Thread.UncaughtExceptionHandler handler =
//                new UncaughtExceptionHandlerimpl(getActivity().getApplicationContext());
//        Thread.setDefaultUncaughtExceptionHandler(handler);

        PullToRefreshListView pullToRefreshListView =
                (PullToRefreshListView)ret.findViewById(R.id.discovery_recommend_list);

        if (pullToRefreshListView != null) {
            adapter = new DiscoveryRecommendAdapter(getActivity());

            adapter.setOnClickListener(this);

            pullToRefreshListView.setAdapter(adapter);
            pullToRefreshListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

            ListView listView = pullToRefreshListView.getRefreshableView();
            listView.setDivider(new ColorDrawable(0xff999999));
            listView.setDividerHeight(5);

        }


//        ListView listView = (ListView) ret.findViewById(R.id.discovery_recommend_list);
//        if (listView != null) {
//            //TODO  设置实际数据的  Adapter
//        ////////////////////////////////
//
//            adapter = new DiscoveryRecommendAdapter(getActivity());
//            adapter.setOnClickListener(this);
//            listView.setAdapter(adapter);
//
//        }
//


        return ret;
    }

    @Override
    public void onResume() {
        super.onResume();

        DiscoveryRecommendTask task =
                new DiscoveryRecommendTask(this);
        task.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        FragmentActivity activity = getActivity();
        if (parent instanceof ListView)
        {
            ListView listView = (ListView) parent;

            int headerViewsCount = listView.getHeaderViewsCount();

            //调整因为 HeaderView 导致的偏移
            position-=headerViewsCount;
            int footerViewsCount = listView.getFooterViewsCount();
            if (footerViewsCount>0) {
                //数据的个数
                    if (position >= 30) {
                        //点的不是数据

                    }
                    else {

                    }

            }
            else {
                // 点到数据上了

            }
        }
        Toast.makeText(activity,"点击了"+position,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onTaskFinished(TaskResult result) {

        if (result != null) {
            int taskId = result.taskId;
            Object data = result.data;


            if (taskId == Constants.TASK_DISCOVERY_RECOMMEND)
            {
                if (data!=null)
                {
                    if (data instanceof JSONObject)
                    {
                        JSONObject json = (JSONObject) data;
                        DiscoveryRecommend discoveryRecommend = DataParser.parseDiscoveryRecommend(json);

                        adapter.setRecommend(discoveryRecommend);
                    }
                }
            }

        }



    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        Object tag = v.getTag();

        if (id == R.id.item_recommend_album_more)
        {
            //进入更多页面
             String s = (String) tag;
            if (Constants.TAG_DISCOVERY_EDITOR.equals(tag))
            {
                Toast.makeText(getActivity(), "点了小编推荐", Toast.LENGTH_SHORT).show();
            } else if (s.startsWith(Constants.TAG_DISCOVERY_RECOMMEND_HOT))
            {

                int index = s.indexOf(':');
                s = s.substring(index + 1);
                int cid = Integer.parseInt(s);
            }
        }

        else if (v instanceof ImageView)
        {
            // TODO  如果是图片，相当于点击了专辑，跳转专辑列表
            if (tag != null){
                if (tag instanceof String[]){
                    String[] ss = (String[]) tag;
                    if (ss.length > 2){
                        String albumId = ss[1];
                        String trackId = ss[2];
                        //TODO 调用接口20
                        Log.i("---------","albumId"+albumId);
                        Log.i("---------", "trackId" + trackId);

                        Intent intent = new Intent(getActivity(), HotRecommendActivity.class);
                        intent.putExtra("trackId",trackId);
                        intent.putExtra("albumId",albumId);
                        startActivity(intent);
                    }
                }
            }

        }
    }
}
