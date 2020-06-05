package com.p530ss.android.socialbase.downloader.p556a;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.tencent.android.tpush.common.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.a.a */
public class AppStatusManager {
    /* renamed from: a */
    private Application f21667a;
    /* renamed from: b */
    private final List<C6638a> f21668b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public WeakReference<Activity> f21669c;
    /* renamed from: d */
    private volatile int f21670d;
    /* renamed from: e */
    private final ActivityLifecycleCallbacks f21671e;

    /* compiled from: AppStatusManager */
    /* renamed from: com.ss.android.socialbase.downloader.a.a$a */
    public interface C6638a {
        /* renamed from: b */
        void mo31235b();

        /* renamed from: c */
        void mo31237c();
    }

    /* compiled from: AppStatusManager */
    /* renamed from: com.ss.android.socialbase.downloader.a.a$b */
    private static class C6639b {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final AppStatusManager f21673a = new AppStatusManager();
    }

    /* renamed from: a */
    public static AppStatusManager m26964a() {
        return C6639b.f21673a;
    }

    private AppStatusManager() {
        this.f21668b = new ArrayList();
        this.f21670d = -1;
        this.f21671e = new ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                WeakReference a = AppStatusManager.this.f21669c;
                AppStatusManager.this.f21669c = new WeakReference(activity);
                if (a == null || a.get() == null) {
                    AppStatusManager.this.m26970e();
                }
            }

            public void onActivityResumed(Activity activity) {
                Activity activity2;
                WeakReference a = AppStatusManager.this.f21669c;
                if (a == null) {
                    activity2 = null;
                } else {
                    activity2 = (Activity) a.get();
                }
                if (activity2 != activity) {
                    AppStatusManager.this.f21669c = new WeakReference(activity);
                }
                if (activity2 == null) {
                    AppStatusManager.this.m26970e();
                }
            }

            public void onActivityStopped(Activity activity) {
                WeakReference a = AppStatusManager.this.f21669c;
                if (a == null || a.get() == activity) {
                    AppStatusManager.this.f21669c = null;
                    AppStatusManager.this.m26971f();
                }
            }
        };
        mo31646b();
    }

    /* renamed from: b */
    public void mo31646b() {
        if (this.f21667a == null) {
            Context B = C6694b.m27342B();
            if (B instanceof Application) {
                synchronized (AppStatusManager.class) {
                    if (this.f21667a == null) {
                        this.f21667a = (Application) B;
                        this.f21667a.registerActivityLifecycleCallbacks(this.f21671e);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public boolean mo31648c() {
        int i = this.f21670d;
        if (i == -1) {
            m26972g();
            i = this.f21670d;
        }
        return i == 1;
    }

    /* renamed from: a */
    public void mo31645a(C6638a aVar) {
        if (aVar != null) {
            synchronized (this.f21668b) {
                if (!this.f21668b.contains(aVar)) {
                    this.f21668b.add(aVar);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo31647b(C6638a aVar) {
        synchronized (this.f21668b) {
            this.f21668b.remove(aVar);
        }
    }

    /* renamed from: d */
    private Object[] m26969d() {
        Object[] array;
        synchronized (this.f21668b) {
            array = this.f21668b.size() > 0 ? this.f21668b.toArray() : null;
        }
        return array;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m26970e() {
        C6704a.m27760c("AppStatusManager", "dispatchAppForeground");
        this.f21670d = 1;
        Object[] d = m26969d();
        if (d != null) {
            for (Object obj : d) {
                ((C6638a) obj).mo31235b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m26971f() {
        C6704a.m27760c("AppStatusManager", "dispatchAppBackground");
        this.f21670d = 0;
        Object[] d = m26969d();
        if (d != null) {
            for (Object obj : d) {
                ((C6638a) obj).mo31237c();
            }
        }
    }

    /* renamed from: g */
    private void m26972g() {
        Activity h = m26973h();
        if (this.f21670d != -1) {
            return;
        }
        if (h != null) {
            this.f21669c = new WeakReference<>(h);
            this.f21670d = 1;
            return;
        }
        this.f21670d = 0;
    }

    /* renamed from: h */
    private Activity m26973h() {
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map != null) {
                if (map.size() != 0) {
                    Class cls2 = null;
                    Field field = null;
                    for (Object next : map.values()) {
                        if (cls2 == null) {
                            cls2 = next.getClass();
                        }
                        if (field == null) {
                            field = cls2.getDeclaredField("paused");
                        }
                        field.setAccessible(true);
                        if (!field.getBoolean(next)) {
                            Field declaredField2 = cls2.getDeclaredField(Constants.FLAG_ACTIVITY_NAME);
                            declaredField2.setAccessible(true);
                            return (Activity) declaredField2.get(next);
                        }
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
