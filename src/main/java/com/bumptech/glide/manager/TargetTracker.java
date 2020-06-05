package com.bumptech.glide.manager;

import com.bumptech.glide.p131c.p132a.Target;
import com.bumptech.glide.util.C1772j;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.o */
public final class TargetTracker implements LifecycleListener {
    /* renamed from: a */
    private final Set<Target<?>> f4891a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a */
    public void mo13192a(Target<?> hVar) {
        this.f4891a.add(hVar);
    }

    /* renamed from: b */
    public void mo13194b(Target<?> hVar) {
        this.f4891a.remove(hVar);
    }

    public void onStart() {
        for (Target onStart : C1772j.m6152a((Collection<T>) this.f4891a)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (Target onStop : C1772j.m6152a((Collection<T>) this.f4891a)) {
            onStop.onStop();
        }
    }

    public void onDestroy() {
        for (Target onDestroy : C1772j.m6152a((Collection<T>) this.f4891a)) {
            onDestroy.onDestroy();
        }
    }

    /* renamed from: a */
    public List<Target<?>> mo13191a() {
        return C1772j.m6152a((Collection<T>) this.f4891a);
    }

    /* renamed from: b */
    public void mo13193b() {
        this.f4891a.clear();
    }
}
