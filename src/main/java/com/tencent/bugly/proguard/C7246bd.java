package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bd */
public final class C7246bd extends C7267m implements Cloneable {
    /* renamed from: c */
    static ArrayList<String> f24446c;
    /* renamed from: a */
    public String f24447a = "";
    /* renamed from: b */
    public ArrayList<String> f24448b = null;

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34934a(this.f24447a, 0);
        ArrayList<String> arrayList = this.f24448b;
        if (arrayList != null) {
            lVar.mo34935a((Collection<T>) arrayList, 1);
        }
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24447a = kVar.mo34907a(0, true);
        if (f24446c == null) {
            f24446c = new ArrayList<>();
            f24446c.add("");
        }
        this.f24448b = (ArrayList) kVar.mo34906a(f24446c, 1, false);
    }
}
