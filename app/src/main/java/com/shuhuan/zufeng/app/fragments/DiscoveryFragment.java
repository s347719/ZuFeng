package com.shuhuan.zufeng.app.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuhuan.zufeng.app.Constants;
import com.shuhuan.zufeng.app.R;
import com.shuhuan.zufeng.app.adapters.CommonFragmentPagerAdapter;
import com.shuhuan.zufeng.app.fragments.discover.*;
import com.shuhuan.zufeng.app.model.DiscoveryTab;
import com.shuhuan.zufeng.app.parsers.DataParser;
import com.shuhuan.zufeng.app.tasks.TaskCallback;
import com.shuhuan.zufeng.app.tasks.TaskResult;
import com.shuhuan.zufeng.app.tasks.impl.DiscoveryTabTask;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment implements View.OnClickListener, TabLayout.OnTabSelectedListener, TaskCallback {

    /**
     *放子栏目的
     */
    private ViewPager pager;
    /**
     * 子栏目的tab指示器，使用了design support 包
     */
    private TabLayout tabBar;

    private List<DiscoveryTab> tabTitles;

    private List<Fragment> subFragments;

    public DiscoveryFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabTitles = new LinkedList<DiscoveryTab>();
        subFragments = new LinkedList<Fragment>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret =  inflater.inflate(R.layout.fragment_discovery, container, false);

        View btnSearch = ret.findViewById(R.id.discovery_title_search);
        if (btnSearch != null) {
            btnSearch.setOnClickListener(this);
        }

        tabBar = (TabLayout) ret.findViewById(R.id.discover_tab_bar);

        tabBar.setOnTabSelectedListener(this);
        ///////////////////////////////////////////////////


        pager = (ViewPager) ret.findViewById(R.id.discovery_tab_pager);

        //设置 Adapter

        //TODO 由于Tab 动态设置的，所以 ViewPager Adapter 也需要动态设置

        // ViewPager  在切换滑动页面的时候 ，添加监听
        //  监听 有TabLayoutOnPagerChangeListener 来完成
        // 从而实现 ViewPager  滚动，上面的TableLayout 跟随滚动Tab
        pager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabBar)
        );
        /////////////////////////

        DiscoveryTabTask task = new DiscoveryTabTask(this);
        task.execute();

        return ret;
    }


    @Override
    public void onClick(View v) {


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position  = tab.getPosition();
        pager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    /////////////////////////////////
    @Override
    public void onTaskFinished(TaskResult result) {

        if (result != null) {
            int taskId = result.taskId;
            Object data = result.data;
            if (taskId == Constants.TASK_DISCOVERY_TABS)
            {
                if (data!=null)
                {
                    if (data instanceof JSONObject)
                    {
                        JSONObject jsonObject = (JSONObject) data;

                        tabTitles=  DataParser.parseDiscoveryTabs(jsonObject);
                        Log.i("---------------","1111111111111111");
                        updataTabs();
                    }

                }
                else
                {
                    //TODO  处理数据
                }
            }
        }

    }



    private void updataTabs()
    {
        if (tabTitles!=null)
        {
            for (DiscoveryTab tabTitle : tabTitles) {
                Log.i("---------------","1111111111111111" + tabTitle.getTitle());
                TabLayout.Tab tab = tabBar.newTab();
                tab.setText(tabTitle.getTitle());

                tabBar.addTab(tab);

                // 根据内容类型来加载设置制定的Fragment
                String type = tabTitle.getContentType();
                    if ("recommend".equals(type))
                {
                    subFragments.add(new DiscoveryRecommendFragment());
                }
                else if ("category".equals(type))
                {
                    subFragments.add(new DiscoveryCategoryFragment());
                }
                else if ("live".equals(type))
                {
                    subFragments.add(new DiscoveryLiveFragment());
                }
                else if ("ranking".equals(type))
                {
                    subFragments.add(new DiscoveryRankingFragment());
                }

                else if ("anchor".equals(type))
                {
                    subFragments.add(new DiscoveryAnchorFragment());
                }

            }
            CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(
                    getChildFragmentManager(),subFragments
            );
            pager.setAdapter(adapter);

            }
        }
    }

