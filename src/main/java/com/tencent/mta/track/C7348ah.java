package com.tencent.mta.track;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.ah */
public class C7348ah {
    /* renamed from: a */
    private Set f24876a = new HashSet();

    /* renamed from: b */
    public void mo35864b(Object obj) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f24876a.add(obj);
            return;
        }
        throw new RuntimeException("Can't add an activity when not on the UI thread");
    }

    /* renamed from: a */
    public void mo35863a(Object obj) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f24876a.remove(obj);
            return;
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }

    /* renamed from: a */
    public Set mo35862a() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return Collections.unmodifiableSet(this.f24876a);
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }

    /* renamed from: b */
    public boolean mo35865b() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return this.f24876a.isEmpty();
        }
        throw new RuntimeException("Can't check isEmpty() when not on the UI thread");
    }
}
