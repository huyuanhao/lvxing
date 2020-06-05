package com.qiyukf.nimlib.p453d.p465e.p466a;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import com.qiyukf.nimlib.p453d.p465e.p466a.C5786b.C5787a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.qiyukf.nimlib.d.e.a.a */
final class C5784a implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private static C5784a f18416a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f18417b = true;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f18418c = false;
    /* renamed from: d */
    private Handler f18419d = new Handler();
    /* renamed from: e */
    private Runnable f18420e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public List<C5787a> f18421f = new CopyOnWriteArrayList();

    C5784a() {
    }

    /* renamed from: a */
    static void m23233a(Context context) {
        String sb;
        if (VERSION.SDK_INT < 14 || context == null || !(context instanceof Application) || f18416a != null) {
            StringBuilder sb2 = new StringBuilder("app can not register activity lifecycle callbacks, sdk version=");
            sb2.append(VERSION.SDK_INT);
            sb = sb2.toString();
        } else {
            f18416a = new C5784a();
            ((Application) context).registerActivityLifecycleCallbacks(f18416a);
            sb = "app register activity lifecycle callbacks success";
        }
        C5753a.m23144a(sb);
    }

    /* renamed from: a */
    static void m23234a(C5787a aVar) {
        if (!m23235a() && aVar != null && !f18416a.f18421f.contains(aVar)) {
            f18416a.f18421f.add(aVar);
            C5753a.m23144a("add AppForegroundObserver");
        }
    }

    /* renamed from: a */
    private static boolean m23235a() {
        return f18416a == null;
    }

    /* renamed from: b */
    static void m23237b(Context context) {
        if (context != null && (context instanceof Application)) {
            C5784a aVar = f18416a;
            if (aVar != null) {
                ((Application) context).unregisterActivityLifecycleCallbacks(aVar);
                f18416a.f18421f.clear();
                f18416a = null;
            }
        }
    }

    /* renamed from: b */
    static void m23238b(C5787a aVar) {
        if (!m23235a() && aVar != null) {
            f18416a.f18421f.remove(aVar);
            C5753a.m23144a("remove AppForegroundObserver");
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        this.f18418c = true;
        Runnable runnable = this.f18420e;
        if (runnable != null) {
            this.f18419d.removeCallbacks(runnable);
        } else {
            this.f18420e = new Runnable() {
                public final void run() {
                    if (C5784a.this.f18417b && C5784a.this.f18418c) {
                        C5784a.this.f18417b = false;
                        C5753a.m23144a("app in background");
                        for (C5787a b : C5784a.this.f18421f) {
                            try {
                                b.mo28072b();
                            } catch (Exception e) {
                                StringBuilder sb = new StringBuilder("AppForegroundObserver threw exception! e=");
                                sb.append(e.getMessage());
                                C5753a.m23144a(sb.toString());
                            }
                        }
                    }
                }
            };
        }
        this.f18419d.postDelayed(this.f18420e, 500);
    }

    public final void onActivityResumed(Activity activity) {
        this.f18418c = false;
        boolean z = !this.f18417b;
        this.f18417b = true;
        Runnable runnable = this.f18420e;
        if (runnable != null) {
            this.f18419d.removeCallbacks(runnable);
        }
        if (z) {
            C5753a.m23144a("app on foreground");
            for (C5787a a : this.f18421f) {
                try {
                    a.mo28071a();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("AppForegroundObserver threw exception! e=");
                    sb.append(e.getMessage());
                    C5753a.m23144a(sb.toString());
                }
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
