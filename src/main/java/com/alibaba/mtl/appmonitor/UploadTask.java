package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.p068a.EventRepo;
import com.alibaba.mtl.appmonitor.p068a.EventType;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.TaskExecutor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.alibaba.mtl.appmonitor.i */
class UploadTask implements Runnable {
    /* renamed from: a */
    private static boolean f3240a = false;
    /* renamed from: e */
    private static Map<Integer, UploadTask> f3241e;
    /* renamed from: b */
    private int f3242b = 180000;
    /* renamed from: c */
    private int f3243c;
    /* renamed from: d */
    private long f3244d;

    /* renamed from: a */
    private static int m3599a(int i) {
        if (i == 65133) {
            return 11;
        }
        switch (i) {
            case 65501:
                return 6;
            case 65502:
                return 9;
            case 65503:
                return 10;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    static void m3600a() {
        EventType[] values;
        if (!f3240a) {
            Logger.m3833a("CommitTask", "init StatisticsAlarmEvent");
            f3241e = new ConcurrentHashMap();
            for (EventType fVar : EventType.values()) {
                if (fVar.isOpen()) {
                    int a = fVar.mo11568a();
                    UploadTask iVar = new UploadTask(a, fVar.mo11572c() * 1000);
                    f3241e.put(Integer.valueOf(a), iVar);
                    TaskExecutor.m3867a().mo11810a(m3599a(a), iVar, (long) iVar.f3242b);
                }
            }
            f3240a = true;
        }
    }

    /* renamed from: b */
    static void m3602b() {
        for (EventType a : EventType.values()) {
            TaskExecutor.m3867a().mo11809a(m3599a(a.mo11568a()));
        }
        f3240a = false;
        f3241e = null;
    }

    /* renamed from: a */
    static void m3601a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[setStatisticsInterval] eventId");
        sb.append(i);
        sb.append(" statisticsInterval:");
        sb.append(i2);
        Logger.m3833a("CommitTask", sb.toString());
        synchronized (f3241e) {
            UploadTask iVar = (UploadTask) f3241e.get(Integer.valueOf(i));
            if (iVar == null) {
                if (i2 > 0) {
                    UploadTask iVar2 = new UploadTask(i, i2 * 1000);
                    f3241e.put(Integer.valueOf(i), iVar2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("post next eventId");
                    sb2.append(i);
                    sb2.append(": uploadTask.interval ");
                    sb2.append(iVar2.f3242b);
                    Logger.m3833a("CommitTask", sb2.toString());
                    TaskExecutor.m3867a().mo11810a(m3599a(i), iVar2, (long) iVar2.f3242b);
                }
            } else if (i2 > 0) {
                int i3 = i2 * 1000;
                if (iVar.f3242b != i3) {
                    TaskExecutor.m3867a().mo11809a(m3599a(i));
                    iVar.f3242b = i3;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = ((long) iVar.f3242b) - (currentTimeMillis - iVar.f3244d);
                    if (j < 0) {
                        j = 0;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(iVar);
                    sb3.append("post next eventId");
                    sb3.append(i);
                    sb3.append(" next:");
                    sb3.append(j);
                    sb3.append("  uploadTask.interval: ");
                    sb3.append(iVar.f3242b);
                    Logger.m3833a("CommitTask", sb3.toString());
                    TaskExecutor.m3867a().mo11810a(m3599a(i), iVar, j);
                    iVar.f3244d = currentTimeMillis;
                }
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("uploadTasks.size:");
                sb4.append(f3241e.size());
                Logger.m3833a("CommitTask", sb4.toString());
                f3241e.remove(Integer.valueOf(i));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("uploadTasks.size:");
                sb5.append(f3241e.size());
                Logger.m3833a("CommitTask", sb5.toString());
            }
        }
    }

    private UploadTask(int i, int i2) {
        this.f3243c = i;
        this.f3242b = i2;
        this.f3244d = System.currentTimeMillis();
    }

    public void run() {
        String str = "CommitTask";
        Logger.m3833a(str, "check&commit event:", Integer.valueOf(this.f3243c));
        EventRepo.m3324a().mo11566b(this.f3243c);
        if (f3241e.containsValue(this)) {
            this.f3244d = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("next:");
            sb.append(this.f3243c);
            Logger.m3833a(str, sb.toString());
            TaskExecutor.m3867a().mo11810a(m3599a(this.f3243c), this, (long) this.f3242b);
        }
    }

    /* renamed from: c */
    static void m3603c() {
        for (EventType a : EventType.values()) {
            EventRepo.m3324a().mo11566b(a.mo11568a());
        }
    }
}
