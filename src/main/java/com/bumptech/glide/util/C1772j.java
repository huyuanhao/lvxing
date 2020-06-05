package com.bumptech.glide.util;

import android.graphics.Bitmap.Config;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util */
/* renamed from: com.bumptech.glide.util.j */
public final class C1772j {
    /* renamed from: a */
    private static final char[] f4922a = "0123456789abcdef".toCharArray();
    /* renamed from: b */
    private static final char[] f4923b = new char[64];

    /* compiled from: Util */
    /* renamed from: com.bumptech.glide.util.j$1 */
    static /* synthetic */ class C17731 {
        /* renamed from: a */
        static final /* synthetic */ int[] f4924a = new int[Config.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f4924a = r0
            int[] r0 = f4924a     // Catch:{ NoSuchFieldError -> 0x0014 }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f4924a     // Catch:{ NoSuchFieldError -> 0x001f }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f4924a     // Catch:{ NoSuchFieldError -> 0x002a }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f4924a     // Catch:{ NoSuchFieldError -> 0x0035 }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGBA_F16     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f4924a     // Catch:{ NoSuchFieldError -> 0x0040 }
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.C1772j.C17731.m42780clinit():void");
        }
    }

    /* renamed from: b */
    public static int m6158b(int i, int i2) {
        return (i2 * 31) + i;
    }

    /* renamed from: c */
    private static boolean m6162c(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    /* renamed from: a */
    public static String m6150a(byte[] bArr) {
        String a;
        synchronized (f4923b) {
            a = m6151a(bArr, f4923b);
        }
        return a;
    }

    /* renamed from: a */
    private static String m6151a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i2 = i * 2;
            char[] cArr2 = f4922a;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v3, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6, types: [int] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=android.graphics.Bitmap, code=null, for r3v0, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v5
  assigns: []
  uses: []
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    public static int m6147a(? r3) {
        /*
        boolean r0 = r3.isRecycled()
        if (r0 != 0) goto L_0x001c
        int r0 = android.os.Build.VERSION.SDK_INT
        r1 = 19
        if (r0 < r1) goto L_0x0011
        int r3 = r3.getAllocationByteCount()     // Catch:{ NullPointerException -> 0x0011 }
        return r3
    L_0x0011:
        int r0 = r3.getHeight()
        int r3 = r3.getRowBytes()
        int r0 = r0 * r3
        return r0
    L_0x001c:
        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "Cannot obtain size for recycled Bitmap: "
        r1.append(r2)
        r1.append(r3)
        java.lang.String r2 = "["
        r1.append(r2)
        int r2 = r3.getWidth()
        r1.append(r2)
        java.lang.String r2 = "x"
        r1.append(r2)
        int r2 = r3.getHeight()
        r1.append(r2)
        java.lang.String r2 = "] "
        r1.append(r2)
        android.graphics.Bitmap$Config r3 = r3.getConfig()
        r1.append(r3)
        java.lang.String r3 = r1.toString()
        r0.<init>(r3)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.C1772j.m6147a(android.graphics.Bitmap):int");
    }

    /* renamed from: a */
    public static int m6145a(int i, int i2, Config config) {
        return i * i2 * m6146a(config);
    }

    /* renamed from: a */
    private static int m6146a(Config config) {
        if (config == null) {
            config = Config.ARGB_8888;
        }
        int i = C17731.f4924a[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    /* renamed from: a */
    public static boolean m6155a(int i, int i2) {
        return m6162c(i) && m6162c(i2);
    }

    /* renamed from: a */
    public static void m6154a() {
        if (!m6159b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* renamed from: b */
    public static boolean m6159b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: c */
    public static boolean m6161c() {
        return !m6159b();
    }

    /* renamed from: a */
    public static <T> Queue<T> m6153a(int i) {
        return new ArrayDeque(i);
    }

    /* renamed from: a */
    public static <T> List<T> m6152a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m6156a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: b */
    public static boolean m6160b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof Model) {
            return ((Model) obj).mo12971a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    /* renamed from: b */
    public static int m6157b(int i) {
        return m6158b(i, 17);
    }

    /* renamed from: a */
    public static int m6143a(float f) {
        return m6144a(f, 17);
    }

    /* renamed from: a */
    public static int m6144a(float f, int i) {
        return m6158b(Float.floatToIntBits(f), i);
    }

    /* renamed from: a */
    public static int m6148a(Object obj, int i) {
        return m6158b(obj == null ? 0 : obj.hashCode(), i);
    }

    /* renamed from: a */
    public static int m6149a(boolean z, int i) {
        return m6158b((int) z, i);
    }
}
