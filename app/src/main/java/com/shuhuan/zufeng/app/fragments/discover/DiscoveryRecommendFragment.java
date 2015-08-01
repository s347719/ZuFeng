package com.shuhuan.zufeng.app.fragments.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.shuhuan.zufeng.app.Constants;
import com.shuhuan.zufeng.app.R;
import com.shuhuan.zufeng.app.adapters.DiscoveryRecommendAdapter;
import com.shuhuan.zufeng.app.model.DiscoveryRecommend;
import com.shuhuan.zufeng.app.parsers.DataParser;
import com.shuhuan.zufeng.app.tasks.TaskCallback;
import com.shuhuan.zufeng.app.tasks.TaskResult;
import com.shuhuan.zufeng.app.tasks.impl.DiscoveryRecommendTask;
import org.json.JSONObject;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */
public class DiscoveryRecommendFragment extends Fragment implements AdapterView.OnItemClickListener, TaskCallback {

    private DiscoveryRecommendAdapter adapter;
    public DiscoveryRecommendFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ret =  inflater.inflate(R.layout.fragment_discovery_recommend, container, false);
        ListView listView = (ListView) ret.findViewById(R.id.discovery_recommend_list);

        if (listView != null) {
            //TODO  设置实际数据的  Adapter
        ////////////////////////////////

            adapter = new DiscoveryRecommendAdapter(getActivity());
            listView.setAdapter(adapter);

        }



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
                        Log.i("----00--------", "000000000000");
                        DiscoveryRecommend discoveryRecommend = DataParser.parseDiscoveryRecommend(json);
                        Log.i("TAGonTask--------", discoveryRecommend.getEditorRecommendAlbums().toString());

                        adapter.setRecommend(discoveryRecommend);
//   Log的结果是 getHotRecommends 的数据没解析完
                    }
                }
            }

        }



    }
}
