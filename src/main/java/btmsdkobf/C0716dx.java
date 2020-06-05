package btmsdkobf;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import btmsdkobf.C0846fe.C0847a;

/* renamed from: btmsdkobf.dx */
public class C0716dx {
    /* renamed from: gZ */
    private static C0695dl f582gZ = null;
    /* renamed from: iM */
    public static boolean f583iM = false;
    /* renamed from: iN */
    public static boolean f584iN = false;
    /* renamed from: iO */
    private static Looper f585iO = null;
    /* renamed from: iP */
    private static Looper f586iP = null;
    /* renamed from: iQ */
    private static boolean f587iQ = false;
    /* renamed from: iR */
    private static String f588iR = null;
    /* renamed from: iS */
    private static boolean f589iS = false;
    /* renamed from: iT */
    private static boolean f590iT = false;
    /* renamed from: iU */
    private static boolean f591iU = false;
    /* renamed from: iV */
    private static boolean f592iV = false;
    /* renamed from: iW */
    private static C0778ec f593iW;

    /* renamed from: a */
    public static void m427a(C0778ec ecVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("[shark_init]initSharkQueueInstance(), sharkQueue: ");
        sb.append(ecVar);
        C0849fg.m911d("SharkHelper", sb.toString());
        f593iW = ecVar;
    }

    /* renamed from: ar */
    public static boolean m428ar() {
        return f589iS;
    }

    /* renamed from: as */
    public static boolean m429as() {
        return f590iT;
    }

    /* renamed from: at */
    public static boolean m430at() {
        return f591iU;
    }

    /* renamed from: bu */
    public static boolean m431bu() {
        return f587iQ;
    }

    /* renamed from: bv */
    public static String m432bv() {
        return f588iR;
    }

    /* renamed from: bw */
    public static boolean m433bw() {
        return f592iV;
    }

    /* renamed from: bx */
    public static C0778ec m434bx() {
        if (f593iW == null) {
            synchronized (C0779ed.class) {
                if (f593iW == null) {
                    f593iW = new C0779ed(m435by());
                }
            }
        }
        return f593iW;
    }

    /* renamed from: by */
    private static long m435by() {
        return C0667cu.m142a(3, 4294967296L);
    }

    /* renamed from: bz */
    public static C0695dl m436bz() {
        return f582gZ;
    }

    public static Looper getLooper() {
        if (f585iO == null) {
            synchronized (C0716dx.class) {
                if (f585iO == null) {
                    HandlerThread newFreeHandlerThread = C0845fd.m898cN().newFreeHandlerThread("Shark-Looper");
                    newFreeHandlerThread.start();
                    f585iO = newFreeHandlerThread.getLooper();
                }
            }
        }
        return f585iO;
    }

    /* renamed from: l */
    public static boolean m437l(byte[] bArr) {
        return bArr != null && bArr.length == 1;
    }

    /* renamed from: r */
    public static boolean m438r(String str) {
        if (C0651ck.f411fW != C0871h.m967j()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[detect_conn]needWifiApprove(), from: ");
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = "SharkHelper";
        C0849fg.m914i(str2, sb2);
        String str3 = null;
        try {
            str3 = C0846fe.m899a((C0847a) new C0847a() {
                /* renamed from: c */
                public void mo9305c(boolean z, boolean z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[detect_conn]needWifiApprove() callback,  need: ");
                    sb.append(z);
                    sb.append(" receivedError: ");
                    sb.append(z2);
                    C0849fg.m914i("SharkHelper", sb.toString());
                }
            });
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[detect_conn]needWifiApprove(), exception: ");
            sb3.append(th.toString());
            C0849fg.m912e(str2, sb3.toString());
        }
        boolean z = !TextUtils.isEmpty(str3);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("[detect_conn]needWifiApprove(),  need approve: ");
        sb4.append(z);
        sb4.append(" approve url: ");
        sb4.append(str3);
        C0849fg.m914i(str2, sb4.toString());
        return z;
    }

    /* renamed from: s */
    public static void m439s(boolean z) {
        f587iQ = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073 A[SYNTHETIC, Splitter:B:20:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098 A[SYNTHETIC, Splitter:B:28:0x0098] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0059=Splitter:B:17:0x0059, B:25:0x007e=Splitter:B:25:0x007e} */
    /* renamed from: s */
    public static boolean m440s(java.lang.String r8) {
        /*
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "[detect_conn]detectConnection, host: "
        r0.append(r1)
        java.lang.String r1 = "www.qq.com"
        r0.append(r1)
        java.lang.String r2 = " from: "
        r0.append(r2)
        r0.append(r8)
        java.lang.String r8 = r0.toString()
        java.lang.String r0 = "SharkHelper"
        btmsdkobf.C0849fg.m914i(r0, r8)
        long r2 = java.lang.System.currentTimeMillis()
        r8 = 0
        r4 = 0
        java.net.InetAddress r1 = java.net.InetAddress.getByName(r1)     // Catch:{ IOException -> 0x007d, all -> 0x0058 }
        java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch:{ IOException -> 0x007d, all -> 0x0058 }
        r6 = 80
        r5.<init>(r1, r6)     // Catch:{ IOException -> 0x007d, all -> 0x0058 }
        java.net.Socket r1 = new java.net.Socket     // Catch:{ IOException -> 0x007d, all -> 0x0058 }
        r1.<init>()     // Catch:{ IOException -> 0x007d, all -> 0x0058 }
        r1.setSoLinger(r8, r8)     // Catch:{ IOException -> 0x0053, all -> 0x004e }
        r4 = 5000(0x1388, float:7.006E-42)
        r1.connect(r5, r4)     // Catch:{ IOException -> 0x0053, all -> 0x004e }
        r8 = 1
        boolean r4 = r1.isConnected()     // Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x00a1
        r1.close()     // Catch:{ all -> 0x0049 }
        goto L_0x00a1
    L_0x0049:
        r1 = move-exception
        r1.printStackTrace()
        goto L_0x00a1
    L_0x004e:
        r4 = move-exception
        r7 = r4
        r4 = r1
        r1 = r7
        goto L_0x0059
    L_0x0053:
        r4 = move-exception
        r7 = r4
        r4 = r1
        r1 = r7
        goto L_0x007e
    L_0x0058:
        r1 = move-exception
    L_0x0059:
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
        r5.<init>()     // Catch:{ all -> 0x00c3 }
        java.lang.String r6 = "[detect_conn]detectConnection, Throwable: "
        r5.append(r6)     // Catch:{ all -> 0x00c3 }
        java.lang.String r6 = r1.getMessage()     // Catch:{ all -> 0x00c3 }
        r5.append(r6)     // Catch:{ all -> 0x00c3 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00c3 }
        btmsdkobf.C0849fg.m913e(r0, r5, r1)     // Catch:{ all -> 0x00c3 }
        if (r4 == 0) goto L_0x00a1
        boolean r1 = r4.isConnected()     // Catch:{ all -> 0x0049 }
        if (r1 == 0) goto L_0x00a1
        r4.close()     // Catch:{ all -> 0x0049 }
        goto L_0x00a1
    L_0x007d:
        r1 = move-exception
    L_0x007e:
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
        r5.<init>()     // Catch:{ all -> 0x00c3 }
        java.lang.String r6 = "[detect_conn]detectConnection, exception: "
        r5.append(r6)     // Catch:{ all -> 0x00c3 }
        java.lang.String r6 = r1.getMessage()     // Catch:{ all -> 0x00c3 }
        r5.append(r6)     // Catch:{ all -> 0x00c3 }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00c3 }
        btmsdkobf.C0849fg.m913e(r0, r5, r1)     // Catch:{ all -> 0x00c3 }
        if (r4 == 0) goto L_0x00a1
        boolean r1 = r4.isConnected()     // Catch:{ all -> 0x0049 }
        if (r1 == 0) goto L_0x00a1
        r4.close()     // Catch:{ all -> 0x0049 }
    L_0x00a1:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r4 = "[detect_conn]detectConnection end, isConnect: "
        r1.append(r4)
        r1.append(r8)
        java.lang.String r4 = " time cost: "
        r1.append(r4)
        long r4 = java.lang.System.currentTimeMillis()
        long r4 = r4 - r2
        r1.append(r4)
        java.lang.String r1 = r1.toString()
        btmsdkobf.C0849fg.m914i(r0, r1)
        return r8
    L_0x00c3:
        r8 = move-exception
        if (r4 == 0) goto L_0x00d4
        boolean r0 = r4.isConnected()     // Catch:{ all -> 0x00d0 }
        if (r0 == 0) goto L_0x00d4
        r4.close()     // Catch:{ all -> 0x00d0 }
        goto L_0x00d4
    L_0x00d0:
        r0 = move-exception
        r0.printStackTrace()
    L_0x00d4:
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0716dx.m440s(java.lang.String):boolean");
    }

    /* renamed from: t */
    public static void m441t(String str) {
        f588iR = str;
    }

    /* renamed from: t */
    public static void m442t(boolean z) {
        f589iS = z;
    }

    /* renamed from: u */
    public static void m443u(boolean z) {
        f590iT = z;
    }

    /* renamed from: u */
    public static boolean m444u(int i) {
        return i == 152 || i == 1;
    }

    /* renamed from: v */
    public static void m445v(boolean z) {
        f591iU = z;
    }

    /* renamed from: v */
    public static boolean m446v(int i) {
        return i == 997 || i == 999;
    }

    /* renamed from: w */
    public static void m447w(boolean z) {
        f592iV = z;
    }
}
