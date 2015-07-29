package com.shuhuan.zufeng.app.tasks;

/**
 * Created with Intellij IDEA.
 * Project:ZuFeng
 * user:MIKE Shu
 * Email:578076417@qq.com
 * Created on 2015/7/28.
 */

/**
 * TaskCallback 异步任务执行成功之后由 onPostExecute 来回调
 */
public interface TaskCallback {

    //接口中不能有普通数据成员，只能够有静态的不能被修改的数据成员,
    // static表示全局，final表示不可修改，可以不用static final 修饰，会隐式的声明为static和final
    //接口中的方法一定是抽象方法，所以不用abstract修饰
    /**
     * 当异步任务执行成功，会回调
     * @param result
     */
    void onTaskFinished(TaskResult result);
}
