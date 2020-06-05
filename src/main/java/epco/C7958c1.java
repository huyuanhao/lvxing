package epco;

import java.io.Writer;

/* renamed from: epco.c1 */
class C7958c1 extends C8013z0 {
    /* renamed from: a */
    private final int f27045a;
    /* renamed from: b */
    private final int f27046b;
    /* renamed from: c */
    private final boolean f27047c;

    public C7958c1() {
        this(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true);
    }

    private C7958c1(int i, int i2, boolean z) {
        this.f27045a = i;
        this.f27046b = i2;
        this.f27047c = z;
    }

    /* renamed from: a */
    public static C7958c1 m34423a(int i, int i2) {
        return new C7958c1(i, i2, true);
    }

    /* renamed from: b */
    public static C7958c1 m34424b(int i) {
        return m34425b(0, i);
    }

    /* renamed from: b */
    public static C7958c1 m34425b(int i, int i2) {
        return new C7958c1(i, i2, false);
    }

    /* renamed from: c */
    public static C7958c1 m34426c(int i) {
        return m34425b(i, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* renamed from: a */
    public boolean mo38291a(int i, Writer writer) {
        if (this.f27047c) {
            if (i < this.f27045a || i > this.f27046b) {
                return false;
            }
        } else if (i >= this.f27045a && i <= this.f27046b) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }
}
