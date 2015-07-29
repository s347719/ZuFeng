package com.shuhuan.zufeng.app.tasks;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/28.
 */

/**
 * 异步任务的结果的抽象的描述，用于区分结果属于哪一个Task
 */
public class TaskResult {

    /**
     * 异步任务的标识
     */
    public int taskId;


    /**
     * 异步任务内部获取的数据
     */
    public Object data;
}
