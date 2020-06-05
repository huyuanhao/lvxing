package com.tencent.p605ep.common.adapt.iservice;

import android.os.HandlerThread;
import android.os.Looper;

/* renamed from: com.tencent.ep.common.adapt.iservice.IThreadPoolService */
public interface IThreadPoolService {
    void addCostTimeTask(Runnable runnable, String str);

    void addTask(Runnable runnable, String str);

    void addUrgentTask(Runnable runnable, String str);

    void addUrgentWeakTask(Runnable runnable, String str, Object obj);

    void addWeakTask(Runnable runnable, String str, Object obj);

    Looper getHandlerThreadLooper(String str);

    HandlerThread newFreeHandlerThread(String str);

    HandlerThread newFreeHandlerThread(String str, int i);

    Thread newFreeThread(Runnable runnable, String str);
}
