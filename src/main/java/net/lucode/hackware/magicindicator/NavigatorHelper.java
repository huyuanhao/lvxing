package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* renamed from: net.lucode.hackware.magicindicator.b */
public class NavigatorHelper {
    /* renamed from: a */
    private SparseBooleanArray f28071a = new SparseBooleanArray();
    /* renamed from: b */
    private SparseArray<Float> f28072b = new SparseArray<>();
    /* renamed from: c */
    private int f28073c;
    /* renamed from: d */
    private int f28074d;
    /* renamed from: e */
    private int f28075e;
    /* renamed from: f */
    private float f28076f;
    /* renamed from: g */
    private int f28077g;
    /* renamed from: h */
    private boolean f28078h;
    /* renamed from: i */
    private C8351a f28079i;

    /* compiled from: NavigatorHelper */
    /* renamed from: net.lucode.hackware.magicindicator.b$a */
    public interface C8351a {
        /* renamed from: a */
        void mo39905a(int i, int i2);

        /* renamed from: a */
        void mo39906a(int i, int i2, float f, boolean z);

        /* renamed from: b */
        void mo39907b(int i, int i2);

        /* renamed from: b */
        void mo39908b(int i, int i2, float f, boolean z);
    }

    /* renamed from: a */
    public void mo39898a(int i, float f, int i2) {
        boolean z;
        float f2 = ((float) i) + f;
        boolean z2 = this.f28076f <= f2;
        if (this.f28077g == 0) {
            for (int i3 = 0; i3 < this.f28073c; i3++) {
                if (i3 != this.f28074d) {
                    if (!this.f28071a.get(i3)) {
                        m35625e(i3);
                    }
                    if (((Float) this.f28072b.get(i3, Float.valueOf(0.0f))).floatValue() != 1.0f) {
                        m35623b(i3, 1.0f, false, true);
                    }
                }
            }
            m35622a(this.f28074d, 1.0f, false, true);
            m35624d(this.f28074d);
        } else if (f2 != this.f28076f) {
            int i4 = i + 1;
            if (f != 0.0f || !z2) {
                z = true;
            } else {
                i4 = i - 1;
                z = false;
            }
            int i5 = 0;
            while (i5 < this.f28073c) {
                if (!(i5 == i || i5 == i4 || ((Float) this.f28072b.get(i5, Float.valueOf(0.0f))).floatValue() == 1.0f)) {
                    m35623b(i5, 1.0f, z2, true);
                }
                i5++;
            }
            if (!z) {
                float f3 = 1.0f - f;
                m35623b(i4, f3, true, false);
                m35622a(i, f3, true, false);
            } else if (z2) {
                m35623b(i, f, true, false);
                m35622a(i4, f, true, false);
            } else {
                float f4 = 1.0f - f;
                m35623b(i4, f4, false, false);
                m35622a(i, f4, false, false);
            }
        } else {
            return;
        }
        this.f28076f = f2;
    }

    /* renamed from: a */
    private void m35622a(int i, float f, boolean z, boolean z2) {
        if (this.f28078h || i == this.f28074d || this.f28077g == 1 || z2) {
            C8351a aVar = this.f28079i;
            if (aVar != null) {
                aVar.mo39906a(i, this.f28073c, f, z);
            }
            this.f28072b.put(i, Float.valueOf(1.0f - f));
        }
    }

    /* renamed from: b */
    private void m35623b(int i, float f, boolean z, boolean z2) {
        if (!(this.f28078h || i == this.f28075e || this.f28077g == 1)) {
            int i2 = this.f28074d;
            if ((!(i == i2 - 1 || i == i2 + 1) || ((Float) this.f28072b.get(i, Float.valueOf(0.0f))).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        C8351a aVar = this.f28079i;
        if (aVar != null) {
            aVar.mo39908b(i, this.f28073c, f, z);
        }
        this.f28072b.put(i, Float.valueOf(f));
    }

    /* renamed from: d */
    private void m35624d(int i) {
        C8351a aVar = this.f28079i;
        if (aVar != null) {
            aVar.mo39905a(i, this.f28073c);
        }
        this.f28071a.put(i, false);
    }

    /* renamed from: e */
    private void m35625e(int i) {
        C8351a aVar = this.f28079i;
        if (aVar != null) {
            aVar.mo39907b(i, this.f28073c);
        }
        this.f28071a.put(i, true);
    }

    /* renamed from: a */
    public void mo39897a(int i) {
        this.f28075e = this.f28074d;
        this.f28074d = i;
        m35624d(this.f28074d);
        int i2 = 0;
        while (i2 < this.f28073c) {
            if (i2 != this.f28074d && !this.f28071a.get(i2)) {
                m35625e(i2);
            }
            i2++;
        }
    }

    /* renamed from: b */
    public void mo39902b(int i) {
        this.f28077g = i;
    }

    /* renamed from: a */
    public void mo39899a(C8351a aVar) {
        this.f28079i = aVar;
    }

    /* renamed from: a */
    public void mo39900a(boolean z) {
        this.f28078h = z;
    }

    /* renamed from: a */
    public int mo39896a() {
        return this.f28073c;
    }

    /* renamed from: c */
    public void mo39904c(int i) {
        this.f28073c = i;
        this.f28071a.clear();
        this.f28072b.clear();
    }

    /* renamed from: b */
    public int mo39901b() {
        return this.f28074d;
    }

    /* renamed from: c */
    public int mo39903c() {
        return this.f28077g;
    }
}
