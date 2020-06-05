package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bg */
public final class C7249bg extends C7267m implements Cloneable {
    /* renamed from: b */
    static ArrayList<C7248bf> f24482b;
    /* renamed from: a */
    public ArrayList<C7248bf> f24483a = null;

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34935a((Collection<T>) this.f24483a, 0);
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        if (f24482b == null) {
            f24482b = new ArrayList<>();
            f24482b.add(new C7248bf());
        }
        this.f24483a = (ArrayList) kVar.mo34906a(f24482b, 0, true);
    }
}
