package com.shuhuan.zufeng.app;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shuhuan.zufeng.app.adapters.HotRecommendAlbumAdapter;
import com.shuhuan.zufeng.app.model.discoveryrecommend.horecommendclickshow.HotRecommendClickShow;
import com.shuhuan.zufeng.app.model.discoveryrecommend.horecommendclickshow.ShowTracksListPlayer;
import com.shuhuan.zufeng.app.parsers.DataParser;
import com.shuhuan.zufeng.app.tasks.ImageLoadTask;
import com.shuhuan.zufeng.app.tasks.TaskCallback;
import com.shuhuan.zufeng.app.tasks.TaskResult;
import com.shuhuan.zufeng.app.tasks.impl.HotRecommendClickTask;
import com.shuhuan.zufeng.app.util.UncaughtExceptionHandlerimpl;
import org.json.JSONObject;


public class HotRecommendActivity extends BaseActivity implements TaskCallback, AdapterView.OnItemClickListener {

    private String albumId;
    private String trackId;
    private String[] sssId;
    private String[] downloadImage;
    private HotRecommendClickShow hotRecommendClickShow;

    private HotRecommendAlbumAdapter adapter;
    private ListView listView;
    private TextView albumtitle;//title
    private TextView hot_recommend_title_intro;//nickname
    private TextView hot_recommend_title_name;//intro
    private ImageView hot_commend_title_albumimage;// 小图标coverSmall
    private ImageView hot_recommend_title_coverlarge;//大图标coverWebLarge


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_recommend);



        Intent intent = getIntent();
        albumId = intent.getStringExtra("albumId");
        trackId = intent.getStringExtra("trackId");
        sssId = new String[]{albumId,trackId};

        Log.i("---------","albumId =====  "+ albumId);
        Log.i("---------","trackId =====  "+ trackId);


        albumtitle = (TextView)findViewById(R.id.hot_recommend_title_albumtitle);
        hot_recommend_title_intro = (TextView) findViewById(R.id.hot_recommend_title_intro);
        hot_recommend_title_name = (TextView) findViewById(R.id.hot_recommend_title_name);
        hot_commend_title_albumimage = (ImageView) findViewById(R.id.hot_commend_title_albumimage);
        hot_recommend_title_coverlarge = (ImageView) findViewById(R.id.hot_recommend_title_coverlarge);

        PullToRefreshListView pullToRefresh =
                (PullToRefreshListView) findViewById(R.id.item_recommend_album_listview);
        if (pullToRefresh != null) {
            adapter = new HotRecommendAlbumAdapter(this);



            pullToRefresh.setAdapter(adapter);

            pullToRefresh.setMode(PullToRefreshBase.Mode.BOTH);
            ListView refreshableView = pullToRefresh.getRefreshableView();
            refreshableView.setDivider(new ColorDrawable(0xff999999));
            refreshableView.setDividerHeight(2);
            refreshableView.setOnItemClickListener(this);




        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        HotRecommendClickTask task = new HotRecommendClickTask(this);
        task.execute(sssId);

    }

    @Override
    public void onTaskFinished(TaskResult result) {

        //TODO   解析数据

        if (result != null) {
            int taskId = result.taskId;
            Object data = result.data;

            if (taskId == Constants.TASK_DISCOVERY_RECOMMEND_HOTRECOMMEND)
            {
                if (data instanceof JSONObject)
                {
                    JSONObject json = (JSONObject)data;
                    hotRecommendClickShow = DataParser.parseDiscoveryHotRecommend(json);

                    String title = hotRecommendClickShow.getShowAlbum().getTitle();
                    String nickName = hotRecommendClickShow.getShowAlbum().getNickname();
                    String intro = hotRecommendClickShow.getShowAlbum().getIntro();



                    albumtitle.setText(title);
                    hot_recommend_title_name.setText(nickName);
                    hot_recommend_title_intro.setText(intro);


                    String coverSmall = hotRecommendClickShow.getShowAlbum().getCoverSmall();
                    String coverWebLarge = hotRecommendClickShow.getShowAlbum().getCoverWebLarge();

                    downloadImage = new String[]{coverSmall,coverWebLarge};
                    Log.i("======================", "coverSmall" + coverSmall);
                    Log.i("======================", "coverWebLarge" + coverWebLarge);

                    //  TODO  开始下载图片 和缓存图片
                    downloadimage(hot_commend_title_albumimage, coverSmall);
                    downloadimage(hot_recommend_title_coverlarge, coverWebLarge);

                    Log.i("===#####===", "albumId");
                    Log.i("===#####===", "trackId");
                    adapter.setClickShow(hotRecommendClickShow);

                }
            }

        }

    }

    private void downloadimage(ImageView imageView,String url) {
        boolean needLoad = true;
        Object tag = imageView.getTag();
        if (tag != null) {

            if (tag instanceof String)
            {
                String s = (String) tag;
                if (s.equals(url))
                {
                    needLoad= false;
                }

            }
            else if (tag instanceof String[])
            {
                String [] ss = (String [])tag;
                if (ss.length>0)
                {
                    String s = ss[0];
                    if (s.equals(url))
                    {
                        needLoad = false;
                    }
                }
            }

        }

        if(needLoad) {
            // 设置“图片加载中”显示
            imageView.setImageResource(R.mipmap.ic_launcher);
        }

        imageView.setTag(new String[]{
                url, albumId, trackId
        });

        if (url!=null){
            ImageLoadTask task = new ImageLoadTask(imageView);
            if (Build.VERSION.SDK_INT>11)
            {
                task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,url);
            }
            else
            {
                task.execute(url);
            }

        }

    }

    @Override
    protected int getEnterAnimationId() {

        return super.getEnterAnimationId();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("======","=======");
        Log.i("======","position   " + position);

        ShowTracksListPlayer player = hotRecommendClickShow.getShowTrack().getList().get(position);
        Log.i("======","=======1111");
        int albumtrackId = player.getTrackId();
            Log.i("======","======="+albumtrackId);
        Intent intent = new Intent(this,Test1Activity.class);

        intent.putExtra("TrackId",albumtrackId);

        startActivity(intent);



    }
}
