package com.p530ss.android.socialbase.downloader.p564i;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.ss.android.socialbase.downloader.i.g */
public class NetTrafficManager {
    /* renamed from: a */
    private static final String f22151a = NetTrafficManager.class.getSimpleName();
    /* renamed from: b */
    private final ExponentialGeometricAverage f22152b;
    /* renamed from: c */
    private volatile boolean f22153c;
    /* renamed from: d */
    private final AtomicReference<NetworkQuality> f22154d;
    /* renamed from: e */
    private AtomicReference<NetworkQuality> f22155e;
    /* renamed from: f */
    private final ArrayList<C6720b> f22156f;
    /* renamed from: g */
    private int f22157g;

    /* compiled from: NetTrafficManager */
    /* renamed from: com.ss.android.socialbase.downloader.i.g$1 */
    static /* synthetic */ class C67181 {
        /* renamed from: a */
        static final /* synthetic */ int[] f22158a = new int[NetworkQuality.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            com.ss.android.socialbase.downloader.i.h[] r0 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f22158a = r0
            int[] r0 = f22158a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.POOR     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f22158a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.MODERATE     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f22158a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.GOOD     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f22158a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.EXCELLENT     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p564i.NetTrafficManager.C67181.m51593clinit():void");
        }
    }

    /* compiled from: NetTrafficManager */
    /* renamed from: com.ss.android.socialbase.downloader.i.g$a */
    private static class C6719a {
        /* renamed from: a */
        public static final NetTrafficManager f22159a = new NetTrafficManager(null);
    }

    /* compiled from: NetTrafficManager */
    /* renamed from: com.ss.android.socialbase.downloader.i.g$b */
    public interface C6720b {
        /* renamed from: a */
        void mo32471a(NetworkQuality hVar);
    }

    /* synthetic */ NetTrafficManager(C67181 r1) {
        this();
    }

    /* renamed from: a */
    public static NetTrafficManager m28219a() {
        return C6719a.f22159a;
    }

    private NetTrafficManager() {
        this.f22152b = new ExponentialGeometricAverage(0.05d);
        this.f22153c = false;
        this.f22154d = new AtomicReference<>(NetworkQuality.UNKNOWN);
        this.f22156f = new ArrayList<>();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
            return;
     */
    /* renamed from: a */
    public synchronized void mo32469a(long r4, long r6) {
        /*
        r3 = this;
        monitor-enter(r3)
        double r4 = (double) r4
        r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        double r4 = r4 * r0
        double r0 = (double) r6
        double r4 = r4 / r0
        r0 = 4620693217682128896(0x4020000000000000, double:8.0)
        double r4 = r4 * r0
        r0 = 0
        int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
        if (r2 == 0) goto L_0x006f
        r6 = 4613937818241073152(0x4008000000000000, double:3.0)
        int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r0 >= 0) goto L_0x0019
        goto L_0x006f
    L_0x0019:
        com.ss.android.socialbase.downloader.i.b r6 = r3.f22152b     // Catch:{ all -> 0x006d }
        r6.mo32467a(r4)     // Catch:{ all -> 0x006d }
        com.ss.android.socialbase.downloader.i.h r4 = r3.mo32470b()     // Catch:{ all -> 0x006d }
        boolean r5 = r3.f22153c     // Catch:{ all -> 0x006d }
        r6 = 1
        if (r5 == 0) goto L_0x005c
        int r5 = r3.f22157g     // Catch:{ all -> 0x006d }
        int r5 = r5 + r6
        r3.f22157g = r5     // Catch:{ all -> 0x006d }
        java.util.concurrent.atomic.AtomicReference<com.ss.android.socialbase.downloader.i.h> r5 = r3.f22155e     // Catch:{ all -> 0x006d }
        java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x006d }
        r7 = 0
        if (r4 == r5) goto L_0x0039
        r3.f22153c = r7     // Catch:{ all -> 0x006d }
        r3.f22157g = r6     // Catch:{ all -> 0x006d }
    L_0x0039:
        int r4 = r3.f22157g     // Catch:{ all -> 0x006d }
        double r4 = (double) r4     // Catch:{ all -> 0x006d }
        r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
        if (r2 < 0) goto L_0x005a
        boolean r4 = r3.m28221c()     // Catch:{ all -> 0x006d }
        if (r4 == 0) goto L_0x005a
        r3.f22153c = r7     // Catch:{ all -> 0x006d }
        r3.f22157g = r6     // Catch:{ all -> 0x006d }
        java.util.concurrent.atomic.AtomicReference<com.ss.android.socialbase.downloader.i.h> r4 = r3.f22154d     // Catch:{ all -> 0x006d }
        java.util.concurrent.atomic.AtomicReference<com.ss.android.socialbase.downloader.i.h> r5 = r3.f22155e     // Catch:{ all -> 0x006d }
        java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x006d }
        r4.set(r5)     // Catch:{ all -> 0x006d }
        r3.m28222d()     // Catch:{ all -> 0x006d }
    L_0x005a:
        monitor-exit(r3)
        return
    L_0x005c:
        java.util.concurrent.atomic.AtomicReference<com.ss.android.socialbase.downloader.i.h> r5 = r3.f22154d     // Catch:{ all -> 0x006d }
        java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x006d }
        if (r5 == r4) goto L_0x006d
        r3.f22153c = r6     // Catch:{ all -> 0x006d }
        java.util.concurrent.atomic.AtomicReference r5 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ all -> 0x006d }
        r5.<init>(r4)     // Catch:{ all -> 0x006d }
        r3.f22155e = r5     // Catch:{ all -> 0x006d }
    L_0x006d:
        monitor-exit(r3)
        return
    L_0x006f:
        monitor-exit(r3)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p564i.NetTrafficManager.mo32469a(long, long):void");
    }

    /* renamed from: c */
    private boolean m28221c() {
        if (this.f22152b == null) {
            return false;
        }
        try {
            int i = C67181.f22158a[((NetworkQuality) this.f22154d.get()).ordinal()];
            double d = 2000.0d;
            double d2 = 550.0d;
            if (i == 1) {
                d = 0.0d;
                d2 = 150.0d;
            } else if (i == 2) {
                d = 150.0d;
            } else if (i == 3) {
                d = 550.0d;
                d2 = 2000.0d;
            } else if (i != 4) {
                return true;
            } else {
                d2 = 3.4028234663852886E38d;
            }
            double a = this.f22152b.mo32466a();
            if (a > d2) {
                if (a > d2 * 1.25d) {
                    return true;
                }
            } else if (a < d * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public synchronized NetworkQuality mo32470b() {
        if (this.f22152b == null) {
            return NetworkQuality.UNKNOWN;
        }
        try {
            return m28220a(this.f22152b.mo32466a());
        } catch (Throwable th) {
            th.printStackTrace();
            return NetworkQuality.UNKNOWN;
        }
    }

    /* renamed from: a */
    private NetworkQuality m28220a(double d) {
        if (d < 0.0d) {
            return NetworkQuality.UNKNOWN;
        }
        if (d < 150.0d) {
            return NetworkQuality.POOR;
        }
        if (d < 550.0d) {
            return NetworkQuality.MODERATE;
        }
        if (d < 2000.0d) {
            return NetworkQuality.GOOD;
        }
        return NetworkQuality.EXCELLENT;
    }

    /* renamed from: d */
    private void m28222d() {
        try {
            int size = this.f22156f.size();
            for (int i = 0; i < size; i++) {
                ((C6720b) this.f22156f.get(i)).mo32471a((NetworkQuality) this.f22154d.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
