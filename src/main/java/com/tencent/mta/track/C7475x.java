package com.tencent.mta.track;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.x */
class C7475x {
    /* renamed from: a */
    private final int[] f25033a = new int[256];
    /* renamed from: b */
    private int f25034b = 0;

    /* renamed from: a */
    public boolean mo36428a() {
        return this.f25033a.length == this.f25034b;
    }

    /* renamed from: b */
    public int mo36429b() {
        int i = this.f25034b;
        this.f25034b = i + 1;
        if (i >= 0) {
            int[] iArr = this.f25033a;
            if (i < iArr.length) {
                iArr[i] = 0;
            }
        }
        return i;
    }

    /* renamed from: a */
    public int mo36427a(int i) {
        if (i >= 0) {
            int[] iArr = this.f25033a;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return 0;
    }

    /* renamed from: b */
    public void mo36430b(int i) {
        if (i >= 0) {
            int[] iArr = this.f25033a;
            if (i < iArr.length) {
                iArr[i] = iArr[i] + 1;
            }
        }
    }

    /* renamed from: c */
    public void mo36431c() {
        this.f25034b--;
        int i = this.f25034b;
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }
}
