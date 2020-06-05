package com.tencent.mta.track;

import com.tencent.mid.sotrage.StorageInterface;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.z */
class C7477z {
    /* renamed from: a */
    public final String f25039a;
    /* renamed from: b */
    public final Class f25040b;
    /* renamed from: c */
    public final C7373d f25041c;
    /* renamed from: d */
    private final String f25042d;

    public C7477z(String str, Class cls, C7373d dVar, String str2) {
        this.f25039a = str;
        this.f25040b = cls;
        this.f25041c = dVar;
        this.f25042d = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[PropertyDescription ");
        sb.append(this.f25039a);
        sb.append(StorageInterface.KEY_SPLITER);
        sb.append(this.f25040b);
        sb.append(", ");
        sb.append(this.f25041c);
        sb.append("/");
        sb.append(this.f25042d);
        sb.append("]");
        return sb.toString();
    }
}
