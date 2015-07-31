package com.shuhuan.zufeng.app.fragments.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shuhuan.zufeng.app.Constants;
import com.shuhuan.zufeng.app.R;
import com.shuhuan.zufeng.app.data.DataStore;
import com.shuhuan.zufeng.app.model.DiscoveryCategory;
import com.shuhuan.zufeng.app.parsers.DataParser;
import com.shuhuan.zufeng.app.tasks.TaskCallback;
import com.shuhuan.zufeng.app.tasks.TaskResult;
import com.shuhuan.zufeng.app.tasks.impl.DiscoveryCategoryTask;
import com.shuhuan.zufeng.app.util.MyLog;
import org.json.JSONObject;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/29.
 */
public class DiscoveryCategoryFragment extends Fragment implements TaskCallback {

    private static final String TAG ="dcf";
    public DiscoveryCategoryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 判断有没有分类
        List<DiscoveryCategory> categories =
        DataStore.getInstance().getDiscoveryCategories();

        if (categories!=null &&! categories.isEmpty())
        {
            //TODO  有分类
            MyLog.d(TAG,"Discovery category has.");

        }

        else {
            //TODO   无分类
            MyLog.d(TAG,"No  Discovery category has.");
            DiscoveryCategoryTask task = new DiscoveryCategoryTask(this);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_discovery_category, container, false);
    }


    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int taskId = result.taskId;
            Object data = result.data;

            if (taskId == Constants.TASK_DISCOVERY_CATEGORIES)
            {
                if (data != null) {
                    if (data instanceof JSONObject)
                    {

                        List<DiscoveryCategory> categories = DataParser.parseDiscoveryCategory((JSONObject) data);
                        if (categories != null) {
                            DataStore.getInstance().setDiscoveryCategories(categories);
                        }
                    }
                }
            }
        }

    }
}
