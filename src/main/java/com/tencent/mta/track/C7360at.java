package com.tencent.mta.track;

import android.util.LruCache;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.at */
class C7360at extends LruCache {
    public C7360at(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String create(Class cls) {
        return cls.getCanonicalName();
    }
}
