package okio;

import javax.annotation.Nullable;

/* compiled from: Segment */
/* renamed from: okio.n */
final class C8543n {
    /* renamed from: a */
    final byte[] f29046a;
    /* renamed from: b */
    int f29047b;
    /* renamed from: c */
    int f29048c;
    /* renamed from: d */
    boolean f29049d;
    /* renamed from: e */
    boolean f29050e;
    /* renamed from: f */
    C8543n f29051f;
    /* renamed from: g */
    C8543n f29052g;

    C8543n() {
        this.f29046a = new byte[8192];
        this.f29050e = true;
        this.f29049d = false;
    }

    C8543n(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f29046a = bArr;
        this.f29047b = i;
        this.f29048c = i2;
        this.f29049d = z;
        this.f29050e = z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C8543n mo40828a() {
        this.f29049d = true;
        C8543n nVar = new C8543n(this.f29046a, this.f29047b, this.f29048c, true, false);
        return nVar;
    }

    @Nullable
    /* renamed from: b */
    public C8543n mo40832b() {
        C8543n nVar = this.f29051f;
        if (nVar == this) {
            nVar = null;
        }
        C8543n nVar2 = this.f29052g;
        nVar2.f29051f = this.f29051f;
        this.f29051f.f29052g = nVar2;
        this.f29051f = null;
        this.f29052g = null;
        return nVar;
    }

    /* renamed from: a */
    public C8543n mo40830a(C8543n nVar) {
        nVar.f29052g = this;
        nVar.f29051f = this.f29051f;
        this.f29051f.f29052g = nVar;
        this.f29051f = nVar;
        return nVar;
    }

    /* renamed from: a */
    public C8543n mo40829a(int i) {
        C8543n nVar;
        if (i <= 0 || i > this.f29048c - this.f29047b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            nVar = mo40828a();
        } else {
            nVar = C8544o.m36917a();
            System.arraycopy(this.f29046a, this.f29047b, nVar.f29046a, 0, i);
        }
        nVar.f29048c = nVar.f29047b + i;
        this.f29047b += i;
        this.f29052g.mo40830a(nVar);
        return nVar;
    }

    /* renamed from: c */
    public void mo40833c() {
        C8543n nVar = this.f29052g;
        if (nVar == this) {
            throw new IllegalStateException();
        } else if (nVar.f29050e) {
            int i = this.f29048c - this.f29047b;
            if (i <= (8192 - nVar.f29048c) + (nVar.f29049d ? 0 : nVar.f29047b)) {
                mo40831a(this.f29052g, i);
                mo40832b();
                C8544o.m36918a(this);
            }
        }
    }

    /* renamed from: a */
    public void mo40831a(C8543n nVar, int i) {
        if (nVar.f29050e) {
            int i2 = nVar.f29048c;
            if (i2 + i > 8192) {
                if (!nVar.f29049d) {
                    int i3 = i2 + i;
                    int i4 = nVar.f29047b;
                    if (i3 - i4 <= 8192) {
                        byte[] bArr = nVar.f29046a;
                        System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
                        nVar.f29048c -= nVar.f29047b;
                        nVar.f29047b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f29046a, this.f29047b, nVar.f29046a, nVar.f29048c, i);
            nVar.f29048c += i;
            this.f29047b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
