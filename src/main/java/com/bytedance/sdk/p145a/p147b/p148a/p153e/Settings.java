package com.bytedance.sdk.p145a.p147b.p148a.p153e;

import java.util.Arrays;

/* renamed from: com.bytedance.sdk.a.b.a.e.n */
public final class Settings {
    /* renamed from: a */
    private int f5650a;
    /* renamed from: b */
    private final int[] f5651b = new int[10];

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13856a() {
        this.f5650a = 0;
        Arrays.fill(this.f5651b, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Settings mo13855a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f5651b;
            if (i < iArr.length) {
                this.f5650a = (1 << i) | this.f5650a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13858a(int i) {
        return ((1 << i) & this.f5650a) != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo13860b(int i) {
        return this.f5651b[i];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo13859b() {
        return Integer.bitCount(this.f5650a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo13861c() {
        if ((this.f5650a & 2) != 0) {
            return this.f5651b[1];
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo13862c(int i) {
        return (this.f5650a & 16) != 0 ? this.f5651b[4] : i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo13864d(int i) {
        return (this.f5650a & 32) != 0 ? this.f5651b[5] : i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo13863d() {
        if ((this.f5650a & 128) != 0) {
            return this.f5651b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13857a(Settings nVar) {
        for (int i = 0; i < 10; i++) {
            if (nVar.mo13858a(i)) {
                mo13855a(i, nVar.mo13860b(i));
            }
        }
    }
}
