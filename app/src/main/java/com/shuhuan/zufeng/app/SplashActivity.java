package com.shuhuan.zufeng.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Window;
import com.shuhuan.zufeng.app.impl.CategoryTagMenuTask;
import com.shuhuan.zufeng.app.model.CategoryTagMenu;
import com.shuhuan.zufeng.app.parsers.DataParser;
import com.shuhuan.zufeng.app.tasks.TaskCallback;
import com.shuhuan.zufeng.app.tasks.TaskResult;
import com.shuhuan.zufeng.app.util.PackageUtil;
import org.json.JSONObject;

import java.util.List;


public class SplashActivity extends FragmentActivity implements TaskCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 启动扉页没有标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //启动扉页,进行网络检查
        //下载数据，最终显示主界面

        CategoryTagMenuTask task =
                new CategoryTagMenuTask(this);
        task.execute();
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int taskId = result.taskId;
            Object data = result.data;
            if (taskId== Constants.TASK_CATEGORY_TAG_MENU);
            //TODO 获取category_tag_menu 的数据
            if (data != null) {
                if (data instanceof JSONObject)
                {
                    JSONObject json= (JSONObject)data;
                    List<CategoryTagMenu> categoryTagMenus =
                            DataParser.parseCategoryTagMenu(json);

                    //TODO 存储 CategoryTagMenu


                }
            }
            
            //TODO 处理之后，判断教程的启动

            SharedPreferences sp = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
            //获取上一次版本号
            String lastVer = sp.getString(Constants.SP_KEY_GUIDE_LAST_SHOW_VERSION, null);

            String versionName = PackageUtil.getPackageVersionName(this);

            Intent intent = null;
            if (!versionName.equals(lastVer))
            {
                //TODO  显示教程
                intent = new Intent(this,GuideActivity.class);
            }
            else
            {
                //TODO  显示主界面
                intent  =new Intent(this,MainActivity.class);
            }

            startActivity(intent);

            finish();

            //使用API  11 的CLEAT_TASK  可以实现清空任务栈
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);


        }
    }
}
