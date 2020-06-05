package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aa */
public final class C7206aa extends C7267m implements Cloneable {
    /* renamed from: c */
    static C7253bk f24282c;
    /* renamed from: d */
    static C7282y f24283d;
    /* renamed from: e */
    static final /* synthetic */ boolean f24284e = (!C7206aa.class.desiredAssertionStatus());
    /* renamed from: a */
    public C7253bk f24285a = null;
    /* renamed from: b */
    public C7282y f24286b = null;

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7206aa aaVar = (C7206aa) obj;
        if (C7268n.m31403a((Object) this.f24285a, (Object) aaVar.f24285a) && C7268n.m31403a((Object) this.f24286b, (Object) aaVar.f24286b)) {
            z = true;
        }
        return z;
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
            if (f24284e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        C7253bk bkVar = this.f24285a;
        if (bkVar != null) {
            lVar.mo34932a((C7267m) bkVar, 0);
        }
        C7282y yVar = this.f24286b;
        if (yVar != null) {
            lVar.mo34932a((C7267m) yVar, 1);
        }
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        if (f24282c == null) {
            f24282c = new C7253bk();
        }
        this.f24285a = (C7253bk) kVar.mo34905a((C7267m) f24282c, 0, false);
        if (f24283d == null) {
            f24283d = new C7282y();
        }
        this.f24286b = (C7282y) kVar.mo34905a((C7267m) f24283d, 1, false);
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        C7262i iVar = new C7262i(sb, i);
        iVar.mo34885a((C7267m) this.f24285a, "baseStrategy");
        iVar.mo34885a((C7267m) this.f24286b, "grayStrategy");
    }
}
