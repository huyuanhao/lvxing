package com.p620ut.mini.p622b.p623a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.alibaba.mtl.log.p077d.TaskExecutor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* renamed from: com.ut.mini.b.a.b */
public class UTMCAppStatusMonitor implements ActivityLifecycleCallbacks {
    /* renamed from: g */
    private static UTMCAppStatusMonitor f26013g;
    /* renamed from: a */
    private int f26014a = 0;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f26015b = false;
    /* renamed from: c */
    private ScheduledFuture<?> f26016c = null;
    /* renamed from: d */
    private Object f26017d = new Object();
    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<UTMCAppStatusCallbacks> f26018e = new LinkedList();
    /* access modifiers changed from: private */
    /* renamed from: f */
    public Object f26019f = new Object();

    /* compiled from: UTMCAppStatusMonitor */
    /* renamed from: com.ut.mini.b.a.b$a */
    private class C7711a implements Runnable {
        private C7711a() {
        }

        public void run() {
            UTMCAppStatusMonitor.this.f26015b = false;
            synchronized (UTMCAppStatusMonitor.this.f26019f) {
                for (UTMCAppStatusCallbacks a : UTMCAppStatusMonitor.this.f26018e) {
                    a.mo37404a();
                }
            }
        }
    }

    private UTMCAppStatusMonitor() {
    }

    /* renamed from: a */
    public static synchronized UTMCAppStatusMonitor m33134a() {
        UTMCAppStatusMonitor bVar;
        synchronized (UTMCAppStatusMonitor.class) {
            if (f26013g == null) {
                f26013g = new UTMCAppStatusMonitor();
            }
            bVar = f26013g;
        }
        return bVar;
    }

    /* renamed from: a */
    public void mo37411a(UTMCAppStatusCallbacks aVar) {
        if (aVar != null) {
            synchronized (this.f26019f) {
                this.f26018e.add(aVar);
            }
        }
    }

    /* renamed from: b */
    private void m33138b() {
        synchronized (this.f26017d) {
            TaskExecutor.m3867a().mo11809a(11);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f26019f) {
            for (UTMCAppStatusCallbacks a : this.f26018e) {
                a.mo37406a(activity, bundle);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        synchronized (this.f26019f) {
            for (UTMCAppStatusCallbacks a : this.f26018e) {
                a.mo37405a(activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        synchronized (this.f26019f) {
            for (UTMCAppStatusCallbacks b : this.f26018e) {
                b.mo37408b(activity);
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        synchronized (this.f26019f) {
            for (UTMCAppStatusCallbacks c : this.f26018e) {
                c.mo37410c(activity);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f26019f) {
            for (UTMCAppStatusCallbacks b : this.f26018e) {
                b.mo37409b(activity, bundle);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        m33138b();
        this.f26014a++;
        if (!this.f26015b) {
            synchronized (this.f26019f) {
                for (UTMCAppStatusCallbacks b : this.f26018e) {
                    b.mo37407b();
                }
            }
        }
        this.f26015b = true;
    }

    public void onActivityStopped(Activity activity) {
        this.f26014a--;
        if (this.f26014a == 0) {
            m33138b();
            TaskExecutor.m3867a().mo11810a(11, new C7711a(), 1000);
        }
    }
}
