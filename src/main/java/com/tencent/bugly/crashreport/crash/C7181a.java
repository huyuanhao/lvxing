package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.a */
public class C7181a implements Comparable<C7181a> {
    /* renamed from: a */
    public long f24142a = -1;
    /* renamed from: b */
    public long f24143b = -1;
    /* renamed from: c */
    public String f24144c = null;
    /* renamed from: d */
    public boolean f24145d = false;
    /* renamed from: e */
    public boolean f24146e = false;
    /* renamed from: f */
    public int f24147f = 0;

    /* renamed from: a */
    public int compareTo(C7181a aVar) {
        if (aVar == null) {
            return 1;
        }
        int i = ((this.f24143b - aVar.f24143b) > 0 ? 1 : ((this.f24143b - aVar.f24143b) == 0 ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}
