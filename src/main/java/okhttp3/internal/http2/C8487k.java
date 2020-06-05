package okhttp3.internal.http2;

import java.util.Arrays;

/* compiled from: Settings */
/* renamed from: okhttp3.internal.http2.k */
public final class C8487k {
    /* renamed from: a */
    private int f28818a;
    /* renamed from: b */
    private final int[] f28819b = new int[10];

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40450a() {
        this.f28818a = 0;
        Arrays.fill(this.f28819b, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C8487k mo40449a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f28819b;
            if (i < iArr.length) {
                this.f28818a = (1 << i) | this.f28818a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo40452a(int i) {
        return ((1 << i) & this.f28818a) != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo40454b(int i) {
        return this.f28819b[i];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo40453b() {
        return Integer.bitCount(this.f28818a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo40455c() {
        if ((this.f28818a & 2) != 0) {
            return this.f28819b[1];
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo40456c(int i) {
        return (this.f28818a & 16) != 0 ? this.f28819b[4] : i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo40458d(int i) {
        return (this.f28818a & 32) != 0 ? this.f28819b[5] : i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo40457d() {
        if ((this.f28818a & 128) != 0) {
            return this.f28819b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo40451a(C8487k kVar) {
        for (int i = 0; i < 10; i++) {
            if (kVar.mo40452a(i)) {
                mo40449a(i, kVar.mo40454b(i));
            }
        }
    }
}
