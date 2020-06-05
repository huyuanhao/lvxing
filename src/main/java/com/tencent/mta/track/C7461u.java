package com.tencent.mta.track;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.u */
public class C7461u {
    /* renamed from: a */
    public final String f24998a;
    /* renamed from: b */
    public final String f24999b;
    /* renamed from: c */
    public final String f25000c;
    /* renamed from: d */
    public final int f25001d;
    /* renamed from: e */
    public final boolean f25002e;
    /* renamed from: f */
    public final String f25003f;
    /* renamed from: g */
    public final String f25004g;

    public C7461u(String str, String str2, String str3, String str4, int i, String str5, boolean z) {
        this.f24999b = str;
        this.f24998a = str2;
        this.f25000c = str3;
        this.f25001d = i;
        this.f25003f = str5;
        this.f25002e = z;
        this.f25004g = str4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EventInfo { EventName: ");
        sb.append(this.f24999b);
        sb.append(", EventType: ");
        sb.append(this.f24998a);
        sb.append(", Path: ");
        sb.append(this.f25000c);
        sb.append(", TriggerId: ");
        sb.append(this.f25001d);
        sb.append(", IsDeployed:");
        sb.append(this.f25002e);
        sb.append("}");
        return sb.toString();
    }
}
