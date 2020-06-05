package com.bumptech.glide.manager;

import com.bumptech.glide.util.C1772j;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.a */
class ActivityFragmentLifecycle implements Lifecycle {
    /* renamed from: a */
    private final Set<LifecycleListener> f4863a = Collections.newSetFromMap(new WeakHashMap());
    /* renamed from: b */
    private boolean f4864b;
    /* renamed from: c */
    private boolean f4865c;

    ActivityFragmentLifecycle() {
    }

    /* renamed from: a */
    public void mo13156a(LifecycleListener iVar) {
        this.f4863a.add(iVar);
        if (this.f4865c) {
            iVar.onDestroy();
        } else if (this.f4864b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    /* renamed from: b */
    public void mo13158b(LifecycleListener iVar) {
        this.f4863a.remove(iVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13155a() {
        this.f4864b = true;
        for (LifecycleListener onStart : C1772j.m6152a((Collection<T>) this.f4863a)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo13157b() {
        this.f4864b = false;
        for (LifecycleListener onStop : C1772j.m6152a((Collection<T>) this.f4863a)) {
            onStop.onStop();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo13159c() {
        this.f4865c = true;
        for (LifecycleListener onDestroy : C1772j.m6152a((Collection<T>) this.f4863a)) {
            onDestroy.onDestroy();
        }
    }
}
