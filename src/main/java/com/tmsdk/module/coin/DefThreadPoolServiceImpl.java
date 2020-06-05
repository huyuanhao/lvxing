package com.tmsdk.module.coin;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.ep.threadpool.api.ThreadPoolSerivceCreator;
import com.tencent.p605ep.common.adapt.iservice.IThreadPoolService;

public class DefThreadPoolServiceImpl implements IThreadPoolService {
    public void addCostTimeTask(Runnable runnable, String str) {
        ThreadPoolSerivceCreator.getInstance(0, null).addCostTimeTask(runnable, str);
    }

    public void addTask(Runnable runnable, String str) {
        ThreadPoolSerivceCreator.getInstance(0, null).addTask(runnable, str);
    }

    public void addUrgentTask(Runnable runnable, String str) {
        ThreadPoolSerivceCreator.getInstance(0, null).addUrgentTask(runnable, str);
    }

    public void addUrgentWeakTask(Runnable runnable, String str, Object obj) {
        ThreadPoolSerivceCreator.getInstance(0, null).addUrgentWeakTask(runnable, str, null);
    }

    public void addWeakTask(Runnable runnable, String str, Object obj) {
        ThreadPoolSerivceCreator.getInstance(0, null).addWeakTask(runnable, str, null);
    }

    public Looper getHandlerThreadLooper(String str) {
        return ThreadPoolSerivceCreator.getInstance(0, null).getHandlerThreadLooper(str);
    }

    public HandlerThread newFreeHandlerThread(String str) {
        return ThreadPoolSerivceCreator.getInstance(0, null).newFreeHandlerThread(str);
    }

    public HandlerThread newFreeHandlerThread(String str, int i) {
        return ThreadPoolSerivceCreator.getInstance(0, null).newFreeHandlerThread(str, i);
    }

    public Thread newFreeThread(Runnable runnable, String str) {
        return ThreadPoolSerivceCreator.getInstance(0, null).newFreeThread(runnable, str);
    }
}
