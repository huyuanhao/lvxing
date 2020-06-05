package com.qiyukf.basesdk.p394b.p406b.p407a;

/* renamed from: com.qiyukf.basesdk.b.b.a.i */
public abstract class C5337i implements Comparable<C5337i>, Runnable {
    /* renamed from: a */
    private long f17266a;
    /* renamed from: b */
    private boolean f17267b;

    public C5337i(long j) {
        this.f17266a = j;
    }

    /* renamed from: a */
    public final long mo27270a() {
        return this.f17266a;
    }

    /* renamed from: b */
    public final void mo27271b() {
        this.f17267b = true;
    }

    /* renamed from: c */
    public final boolean mo27272c() {
        return this.f17267b;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C5337i iVar = (C5337i) obj;
        long j = this.f17266a;
        long j2 = iVar.f17266a;
        if (j == j2) {
            return 0;
        }
        return j > j2 ? 1 : -1;
    }
}
