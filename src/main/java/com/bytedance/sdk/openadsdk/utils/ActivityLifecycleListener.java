package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.sdk.openadsdk.utils.a */
public class ActivityLifecycleListener implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private AtomicInteger f9104a = new AtomicInteger(0);
    /* renamed from: b */
    private AtomicBoolean f9105b = new AtomicBoolean(false);
    /* renamed from: c */
    private HashSet<Integer> f9106c = new HashSet<>();

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.f9104a.incrementAndGet() > 0) {
            this.f9105b.set(false);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.f9106c.add(Integer.valueOf(activity.hashCode()));
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.f9104a.decrementAndGet() == 0) {
            this.f9105b.set(true);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            this.f9106c.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    /* renamed from: a */
    public boolean mo16896a() {
        return this.f9105b.get();
    }

    /* renamed from: a */
    public boolean mo16897a(Activity activity) {
        return activity != null && this.f9106c.contains(Integer.valueOf(activity.hashCode()));
    }
}
