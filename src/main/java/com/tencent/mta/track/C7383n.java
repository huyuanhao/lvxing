package com.tencent.mta.track;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.n */
public class C7383n extends C7348ah {
    /* renamed from: a */
    private final Handler f24966a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    private final Map f24967b = new HashMap();
    /* renamed from: c */
    private final Map f24968c = new HashMap();

    /* renamed from: a */
    public void mo35864b(Activity activity) {
        super.mo35864b(activity);
        m31802c(activity);
    }

    /* renamed from: b */
    public void mo35863a(Activity activity) {
        super.mo35863a(activity);
        m31804d(activity);
    }

    /* renamed from: a */
    public void mo35922a(Map map) {
        synchronized (this.f24968c) {
            for (Entry value : this.f24968c.entrySet()) {
                for (C7385p a : (Set) value.getValue()) {
                    a.mo35925a();
                }
            }
            this.f24968c.clear();
        }
        synchronized (this.f24967b) {
            this.f24967b.clear();
            this.f24967b.putAll(map);
        }
        m31801c();
    }

    /* renamed from: c */
    private void m31801c() {
        if (Thread.currentThread() == this.f24966a.getLooper().getThread()) {
            m31803d();
        } else {
            this.f24966a.post(new C7384o(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m31803d() {
        for (Activity c : mo35862a()) {
            m31802c(c);
        }
    }

    /* renamed from: c */
    private void m31802c(Activity activity) {
        List list;
        List list2;
        String canonicalName = activity.getClass().getCanonicalName();
        View rootView = activity.getWindow().getDecorView().getRootView();
        synchronized (this.f24967b) {
            list = (List) this.f24967b.get(canonicalName);
            list2 = (List) this.f24967b.get(null);
        }
        if (list != null) {
            m31799a(activity, rootView, list);
        }
        if (list2 != null) {
            m31799a(activity, rootView, list2);
        }
    }

    /* renamed from: a */
    private void m31799a(Activity activity, View view, List list) {
        synchronized (this.f24968c) {
            if (!this.f24968c.containsKey(activity)) {
                this.f24968c.put(activity, new HashSet());
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((Set) this.f24968c.get(activity)).add(new C7385p(view, (C7363aw) list.get(i), this.f24966a));
            }
        }
    }

    /* renamed from: d */
    private void m31804d(Activity activity) {
        synchronized (this.f24968c) {
            Set<C7385p> set = (Set) this.f24968c.get(activity);
            if (set != null) {
                for (C7385p a : set) {
                    a.mo35925a();
                }
                this.f24968c.remove(activity);
            }
        }
    }
}
