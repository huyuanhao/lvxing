package com.kwad.sdk.core.videocache;

/* renamed from: com.kwad.sdk.core.videocache.n */
public class C4368n {
    /* renamed from: a */
    public final String f14308a;
    /* renamed from: b */
    public final long f14309b;
    /* renamed from: c */
    public final String f14310c;

    public C4368n(String str, long j, String str2) {
        this.f14308a = str;
        this.f14309b = j;
        this.f14310c = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SourceInfo{url='");
        sb.append(this.f14308a);
        sb.append('\'');
        sb.append(", length=");
        sb.append(this.f14309b);
        sb.append(", mime='");
        sb.append(this.f14310c);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
