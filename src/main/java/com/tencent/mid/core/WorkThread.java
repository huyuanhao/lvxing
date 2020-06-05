package com.tencent.mid.core;

import android.os.Handler;
import android.os.HandlerThread;

public class WorkThread {
    private static volatile WorkThread instance;
    private Handler handler = null;

    private WorkThread() {
        HandlerThread handlerThread = new HandlerThread("MidWorkThread");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper());
    }

    public static WorkThread getInstance() {
        if (instance == null) {
            synchronized (WorkThread.class) {
                if (instance == null) {
                    instance = new WorkThread();
                }
            }
        }
        return instance;
    }

    public void doWork(Runnable runnable) {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.post(runnable);
        }
    }
}
