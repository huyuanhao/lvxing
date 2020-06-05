package com.alibaba.mtl.log.p076c;

import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.model.Log;
import com.alibaba.mtl.log.p075b.CoreStatics;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.TaskExecutor;
import com.alibaba.mtl.log.p079f.UploadEngine;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.alibaba.mtl.log.c.c */
public class LogStoreMgr {
    /* renamed from: a */
    private static LogStoreMgr f3363a;
    /* renamed from: d */
    private static int f3364d;
    /* renamed from: e */
    private static final Object f3365e = new Object();
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ILogStore f3366b = new LogSqliteStore(UTDC.m3697c());
    /* renamed from: c */
    private List<Log> f3367c = new CopyOnWriteArrayList();
    /* renamed from: f */
    private Runnable f3368f = new Runnable() {
        public void run() {
            LogStoreMgr.this.mo11792b();
        }
    };

    /* compiled from: LogStoreMgr */
    /* renamed from: com.alibaba.mtl.log.c.c$a */
    class C1313a implements Runnable {
        C1313a() {
        }

        public void run() {
            LogStoreMgr.this.m3781d();
            int a = LogStoreMgr.this.f3366b.mo11776a();
            if (a > 9000) {
                LogStoreMgr.this.m3778a(a);
            }
        }
    }

    /* compiled from: LogStoreMgr */
    /* renamed from: com.alibaba.mtl.log.c.c$b */
    class C1314b implements Runnable {
        C1314b() {
        }

        public void run() {
            Logger.m3833a("LogStoreMgr", "CleanLogTask");
            int a = LogStoreMgr.this.f3366b.mo11776a();
            if (a > 9000) {
                LogStoreMgr.this.m3778a(a);
            }
        }
    }

    private LogStoreMgr() {
        UploadEngine.m3889a().mo11829b();
        TaskExecutor.m3867a().mo11811a((Runnable) new C1313a());
    }

    /* renamed from: a */
    public static synchronized LogStoreMgr m3777a() {
        LogStoreMgr cVar;
        synchronized (LogStoreMgr.class) {
            if (f3363a == null) {
                f3363a = new LogStoreMgr();
            }
            cVar = f3363a;
        }
        return cVar;
    }

    /* renamed from: a */
    public void mo11791a(Log aVar) {
        Logger.m3833a("LogStoreMgr", "[add] :", aVar.f3465e);
        CoreStatics.m3743b(aVar.f3462b);
        this.f3367c.add(aVar);
        if (this.f3367c.size() >= 100) {
            TaskExecutor.m3867a().mo11809a(1);
            TaskExecutor.m3867a().mo11810a(1, this.f3368f, 0);
        } else if (!TaskExecutor.m3867a().mo11812b(1)) {
            TaskExecutor.m3867a().mo11810a(1, this.f3368f, 5000);
        }
        synchronized (f3365e) {
            f3364d++;
            if (f3364d > 5000) {
                f3364d = 0;
                TaskExecutor.m3867a().mo11811a((Runnable) new C1314b());
            }
        }
    }

    /* renamed from: a */
    public int mo11789a(List<Log> list) {
        Logger.m3833a("LogStoreMgr", list);
        return this.f3366b.mo11781b(list);
    }

    /* renamed from: a */
    public List<Log> mo11790a(String str, int i) {
        List<Log> a = this.f3366b.mo11777a(str, i);
        Logger.m3833a("LogStoreMgr", "[get]", a);
        return a;
    }

    /* renamed from: b */
    public synchronized void mo11792b() {
        Logger.m3833a("LogStoreMgr", "[store]");
        ArrayList arrayList = null;
        try {
            synchronized (this.f3367c) {
                if (this.f3367c.size() > 0) {
                    arrayList = new ArrayList(this.f3367c);
                    this.f3367c.clear();
                }
            }
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    this.f3366b.mo11780a((List<Log>) arrayList);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public void mo11793c() {
        Logger.m3833a("LogStoreMgr", "[clear]");
        this.f3366b.mo11782b();
        this.f3367c.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m3781d() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -3);
        String str = "time";
        this.f3366b.mo11779a(str, String.valueOf(instance.getTimeInMillis()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3778a(int i) {
        if (i > 9000) {
            this.f3366b.mo11778a((i - 9000) + 1000);
        }
    }
}
