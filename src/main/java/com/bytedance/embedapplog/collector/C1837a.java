package com.bytedance.embedapplog.collector;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.IPicker;
import com.bytedance.embedapplog.p141a.C1805e;
import com.bytedance.embedapplog.p144d.C1838a;
import com.bytedance.embedapplog.p144d.C1846h;
import com.bytedance.embedapplog.util.C1856h;
import java.util.HashSet;

/* renamed from: com.bytedance.embedapplog.collector.a */
public class C1837a implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private static int f5142a = 0;
    /* renamed from: b */
    private static C1846h f5143b = null;
    /* renamed from: c */
    private static C1846h f5144c = null;
    /* renamed from: d */
    private static long f5145d = 0;
    /* renamed from: e */
    private static String f5146e = null;
    /* renamed from: f */
    private static long f5147f = 0;
    /* renamed from: g */
    private static String f5148g = null;
    /* renamed from: h */
    private static int f5149h = -1;
    /* renamed from: i */
    private static Object f5150i;
    /* renamed from: j */
    private static Object f5151j;
    /* renamed from: l */
    private static final HashSet<Integer> f5152l = new HashSet<>(8);
    /* renamed from: k */
    private final IPicker f5153k;

    /* renamed from: a */
    public static void m6446a(Object obj) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public C1837a(IPicker iPicker) {
        this.f5153k = iPicker;
    }

    public void onActivityResumed(Activity activity) {
        String str = "";
        f5143b = m6445a(activity.getClass().getName(), str, System.currentTimeMillis(), f5146e);
        f5143b.f5199k = !f5152l.remove(Integer.valueOf(activity.hashCode()));
        if (!activity.isChild()) {
            try {
                f5149h = activity.getWindow().getDecorView().hashCode();
                f5150i = activity;
            } catch (Exception e) {
                C1856h.m6582a(e);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        if (f5144c != null) {
            m6446a(f5151j);
        }
        C1846h hVar = f5143b;
        if (hVar != null) {
            f5146e = hVar.f5198j;
            f5145d = System.currentTimeMillis();
            m6444a(f5143b, f5145d);
            f5143b = null;
            if (!activity.isChild()) {
                f5149h = -1;
                f5150i = null;
            }
        }
    }

    /* renamed from: a */
    public static C1846h m6445a(String str, String str2, long j, String str3) {
        C1846h hVar = new C1846h();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            hVar.f5198j = sb.toString();
        } else {
            hVar.f5198j = str;
        }
        hVar.f5155a = j;
        hVar.f5196h = -1;
        if (str3 == null) {
            str3 = "";
        }
        hVar.f5197i = str3;
        C1805e.m6273a((C1838a) hVar);
        return hVar;
    }

    /* renamed from: a */
    public static C1846h m6444a(C1846h hVar, long j) {
        C1846h hVar2 = (C1846h) hVar.clone();
        hVar2.f5155a = j;
        long j2 = j - hVar.f5155a;
        if (j2 >= 0) {
            hVar2.f5196h = j2;
        } else {
            C1856h.m6582a(null);
        }
        C1805e.m6273a((C1838a) hVar2);
        return hVar2;
    }

    public void onActivityStarted(Activity activity) {
        f5142a++;
        if (f5142a == 1) {
            IPicker iPicker = this.f5153k;
            if (iPicker != null) {
                iPicker.show(true);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        if (f5146e != null) {
            f5142a--;
            if (f5142a <= 0) {
                f5146e = null;
                f5148g = null;
                f5147f = 0;
                f5145d = 0;
                IPicker iPicker = this.f5153k;
                if (iPicker != null) {
                    iPicker.show(false);
                }
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        f5152l.remove(Integer.valueOf(activity.hashCode()));
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        f5152l.add(Integer.valueOf(activity.hashCode()));
    }
}
