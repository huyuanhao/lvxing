package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.x */
public final class C7281x extends C7267m implements Cloneable {
    /* renamed from: b */
    static ArrayList<C7280w> f24645b;
    /* renamed from: c */
    static final /* synthetic */ boolean f24646c = (!C7281x.class.desiredAssertionStatus());
    /* renamed from: a */
    public ArrayList<C7280w> f24647a = null;

    public C7281x() {
    }

    public C7281x(ArrayList<C7280w> arrayList) {
        this.f24647a = arrayList;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C7268n.m31403a((Object) this.f24647a, (Object) ((C7281x) obj).f24647a);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f24646c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34935a((Collection<T>) this.f24647a, 0);
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        if (f24645b == null) {
            f24645b = new ArrayList<>();
            f24645b.add(new C7280w());
        }
        this.f24647a = (ArrayList) kVar.mo34906a(f24645b, 0, true);
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        new C7262i(sb, i).mo34888a((Collection<T>) this.f24647a, "events");
    }
}
