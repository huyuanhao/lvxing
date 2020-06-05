package com.tencent.mta.track;

import android.view.View;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.l */
class C7381l {
    /* renamed from: a */
    private final int f24962a;

    public C7381l(View view, C7461u uVar) {
        this.f24962a = (view.hashCode() ^ uVar.f24999b.hashCode()) ^ String.valueOf(uVar.f25001d).hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7381l) || this.f24962a != obj.hashCode()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f24962a;
    }
}
