package com.qiyukf.basesdk.p412c.p413a;

import java.util.Locale;

/* renamed from: com.qiyukf.basesdk.c.a.b */
public final class C5363b {

    /* renamed from: com.qiyukf.basesdk.c.a.b$1 */
    static /* synthetic */ class C53641 {
        /* renamed from: a */
        static final /* synthetic */ int[] f17305a = new int[C5365a.m22025a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        static {
            /*
            int[] r0 = com.qiyukf.basesdk.p412c.p413a.C5363b.C5365a.m22025a()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f17305a = r0
            r0 = 1
            int[] r1 = f17305a     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = com.qiyukf.basesdk.p412c.p413a.C5363b.C5365a.f17307b     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = r2 - r0
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            int[] r1 = f17305a     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r2 = com.qiyukf.basesdk.p412c.p413a.C5363b.C5365a.f17308c     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r2 = r2 - r0
            r3 = 2
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            int[] r1 = f17305a     // Catch:{ NoSuchFieldError -> 0x0021 }
            int r2 = com.qiyukf.basesdk.p412c.p413a.C5363b.C5365a.f17309d     // Catch:{ NoSuchFieldError -> 0x0021 }
            int r2 = r2 - r0
            r3 = 3
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
        L_0x0021:
            int[] r1 = f17305a     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r2 = com.qiyukf.basesdk.p412c.p413a.C5363b.C5365a.f17310e     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r2 = r2 - r0
            r3 = 4
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            int[] r1 = f17305a     // Catch:{ NoSuchFieldError -> 0x0031 }
            int r2 = com.qiyukf.basesdk.p412c.p413a.C5363b.C5365a.f17306a     // Catch:{ NoSuchFieldError -> 0x0031 }
            int r2 = r2 - r0
            r0 = 5
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0031 }
        L_0x0031:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.p413a.C5363b.C53641.m49488clinit():void");
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.a.b$a */
    public enum C5365a {
        ;
        
        /* renamed from: a */
        public static final int f17306a = 1;
        /* renamed from: b */
        public static final int f17307b = 2;
        /* renamed from: c */
        public static final int f17308c = 3;
        /* renamed from: d */
        public static final int f17309d = 4;
        /* renamed from: e */
        public static final int f17310e = 5;
        /* renamed from: f */
        public static final int f17311f = 6;

        static {
            f17312g = new int[]{f17306a, f17307b, f17308c, f17309d, f17310e, f17311f};
        }

        /* renamed from: a */
        public static int[] m22025a() {
            return (int[]) f17312g.clone();
        }
    }

    /* renamed from: a */
    public static String m22022a(long j) {
        int i = C5365a.f17311f;
        if (i == C5365a.f17311f) {
            double d = (double) j;
            i = d < 1024.0d ? C5365a.f17306a : d < 1048576.0d ? C5365a.f17307b : d < 1.073741824E9d ? C5365a.f17308c : d < 1.099511627776E12d ? C5365a.f17309d : C5365a.f17310e;
        }
        int i2 = C53641.f17305a[i - 1];
        if (i2 == 1) {
            return String.format(Locale.US, "%d KB", new Object[]{Integer.valueOf((int) (((double) j) / 1024.0d))});
        } else if (i2 == 2) {
            return String.format(Locale.US, "%.1f MB", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
        } else if (i2 == 3) {
            return String.format(Locale.US, "%.1f GB", new Object[]{Double.valueOf(((double) j) / 1.073741824E9d)});
        } else if (i2 != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append(" B");
            return sb.toString();
        } else {
            return String.format(Locale.US, "%.1f PB", new Object[]{Double.valueOf(((double) j) / 1.099511627776E12d)});
        }
    }

    /* renamed from: a */
    public static String m22023a(String str) {
        if (str != null && str.length() > 0) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m22024b(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(47);
        return (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) ? str : str.substring(lastIndexOf + 1);
    }
}
