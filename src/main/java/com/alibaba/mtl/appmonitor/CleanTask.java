package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.p068a.EventRepo;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.TaskExecutor;

/* renamed from: com.alibaba.mtl.appmonitor.h */
class CleanTask implements Runnable {
    /* renamed from: a */
    private static boolean f3237a = false;
    /* renamed from: b */
    private static long f3238b = 300000;
    /* renamed from: c */
    private static CleanTask f3239c;

    private CleanTask() {
    }

    /* renamed from: a */
    static void m3597a() {
        if (!f3237a) {
            Logger.m3833a("CleanTask", "init TimeoutEventManager");
            f3239c = new CleanTask();
            TaskExecutor.m3867a().mo11810a(5, f3239c, f3238b);
            f3237a = true;
        }
    }

    /* renamed from: b */
    static void m3598b() {
        TaskExecutor.m3867a().mo11809a(5);
        f3237a = false;
        f3239c = null;
    }

    public void run() {
        Logger.m3833a("CleanTask", "clean TimeoutEvent");
        EventRepo.m3324a().mo11565b();
        TaskExecutor.m3867a().mo11810a(5, f3239c, f3238b);
    }
}
