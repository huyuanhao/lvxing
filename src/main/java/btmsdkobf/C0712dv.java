package btmsdkobf;

import android.os.PowerManager;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: btmsdkobf.dv */
public class C0712dv {
    /* renamed from: iu */
    private static C0712dv f560iu;
    /* renamed from: gZ */
    private C0695dl f561gZ = null;
    /* access modifiers changed from: private */
    /* renamed from: it */
    public C0682dc<Integer, C0714a> f562it = new C0682dc<>(200);
    /* renamed from: iv */
    private PowerManager f563iv = null;
    /* renamed from: iw */
    public Map<Byte, Integer> f564iw = new HashMap();

    /* renamed from: btmsdkobf.dv$a */
    public static class C0714a {
        /* renamed from: dO */
        public int f566dO = 0;
        /* renamed from: fq */
        public int f567fq;
        /* renamed from: iA */
        public int f568iA;
        /* renamed from: iB */
        public boolean f569iB;
        /* renamed from: iC */
        public boolean f570iC;
        /* renamed from: iD */
        public long f571iD;
        /* renamed from: iE */
        public int f572iE;
        /* renamed from: iF */
        public int f573iF;
        /* renamed from: iG */
        public long f574iG;
        /* renamed from: iH */
        public long f575iH;
        /* renamed from: iI */
        public String f576iI;
        /* renamed from: iJ */
        public String f577iJ;
        /* renamed from: iy */
        public BitSet f578iy = new BitSet();
        /* renamed from: iz */
        public String f579iz;

        public C0714a() {
            String str = "";
            this.f579iz = str;
            this.f568iA = 0;
            this.f569iB = false;
            this.f570iC = false;
            this.f571iD = 0;
            this.f572iE = 0;
            this.f573iF = 0;
            this.f567fq = 0;
            this.f574iG = System.currentTimeMillis();
            this.f575iH = System.currentTimeMillis();
            this.f576iI = str;
            this.f577iJ = str;
        }
    }

    /* renamed from: br */
    public static C0712dv m412br() {
        synchronized (C0712dv.class) {
            if (f560iu == null) {
                f560iu = new C0712dv();
            }
        }
        return f560iu;
    }

    /* renamed from: a */
    public void mo9313a(byte b) {
        synchronized (this.f564iw) {
            this.f564iw.remove(Byte.valueOf(b));
        }
    }

    /* renamed from: a */
    public void mo9314a(byte b, int i) {
        synchronized (this.f564iw) {
            this.f564iw.put(Byte.valueOf(b), Integer.valueOf(i));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0021 */
    /* renamed from: a */
    public synchronized void mo9315a(int r2, long r3, java.lang.String r5) {
        /*
        r1 = this;
        monitor-enter(r1)
        btmsdkobf.dv$a r0 = new btmsdkobf.dv$a     // Catch:{ all -> 0x002c }
        r0.m40653init()     // Catch:{ all -> 0x002c }
        r0.f579iz = r5     // Catch:{ all -> 0x002c }
        r0.f571iD = r3     // Catch:{ all -> 0x002c }
        btmsdkobf.dr r3 = btmsdkobf.C0701dr.m387bj()     // Catch:{ all -> 0x002c }
        r4 = 0
        int r3 = r3.mo9300b(r4, r4)     // Catch:{ all -> 0x002c }
        r0.f568iA = r3     // Catch:{ all -> 0x002c }
        android.os.PowerManager r3 = r1.f563iv     // Catch:{ all -> 0x002c }
        if (r3 == 0) goto L_0x0021
        android.os.PowerManager r3 = r1.f563iv     // Catch:{ all -> 0x0021 }
        boolean r3 = r3.isScreenOn()     // Catch:{ all -> 0x0021 }
        r0.f569iB = r3     // Catch:{ all -> 0x0021 }
    L_0x0021:
        btmsdkobf.dc<java.lang.Integer, btmsdkobf.dv$a> r3 = r1.f562it     // Catch:{ all -> 0x002c }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x002c }
        r3.put(r2, r0)     // Catch:{ all -> 0x002c }
        monitor-exit(r1)
        return
    L_0x002c:
        r2 = move-exception
        monitor-exit(r1)
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0712dv.mo9315a(int, long, java.lang.String):void");
    }

    /* renamed from: a */
    public synchronized void mo9316a(String str, int i, int i2, C0636by byVar, int i3) {
        mo9317a(str, i, i2, byVar, i3, 0, (String) null);
    }

    /* renamed from: a */
    public synchronized void mo9317a(String str, int i, int i2, C0636by byVar, int i3, int i4, String str2) {
        C0714a aVar = (C0714a) this.f562it.get(Integer.valueOf(i2));
        if (aVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[ocean][shark_funnel]|seqNo|seq_");
            sb3.append(i2);
            sb3.append("|step|");
            sb3.append(i3);
            sb3.append("|cmdId|cmd_");
            sb3.append(i);
            sb3.append("|stepTime|");
            sb3.append(System.currentTimeMillis() - aVar.f575iH);
            sb3.append("|retCode|");
            sb3.append(i4);
            sb3.append("|flow|");
            sb3.append(str2);
            C0849fg.m915v(sb2, sb3.toString());
            if (i == 21) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("|step|");
                sb4.append(i3);
                sb4.append("|cmdId|");
                sb4.append(i);
                sb4.append("|retCode|");
                sb4.append(i4);
                C0849fg.m915v("SharkFunnelModel", sb4.toString());
            }
            aVar.f566dO = i;
            aVar.f578iy.set(i3, true);
            if (str2 != null) {
                aVar.f576iI = str2;
            }
            if (!(i3 == 14 || i3 == 9)) {
                if (i3 != 10) {
                    if (i3 == 16) {
                        aVar.f573iF = i4;
                        if (this.f561gZ != null) {
                            this.f561gZ.mo9256h(i, i4);
                        }
                    } else {
                        aVar.f567fq = i4;
                    }
                    aVar.f575iH = System.currentTimeMillis();
                }
            }
            aVar.f572iE = i4;
            if (this.f561gZ != null) {
                this.f561gZ.mo9255g(i, i4);
            }
            aVar.f575iH = System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public synchronized void mo9318a(String str, int i, int i2, C0647cg cgVar, int i3, int i4) {
        mo9319a(str, i, i2, cgVar, i3, i4, (String) null);
    }

    /* renamed from: a */
    public synchronized void mo9319a(String str, int i, int i2, C0647cg cgVar, int i3, int i4, String str2) {
        C0714a aVar = (C0714a) this.f562it.get(Integer.valueOf(i2));
        if (aVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[ocean][shark_funnel]|seqNo|seq_");
            sb3.append(i2);
            sb3.append("|step|");
            sb3.append(i3);
            sb3.append("|cmdId|cmd_");
            sb3.append(i);
            sb3.append("|stepTime|");
            sb3.append(System.currentTimeMillis() - aVar.f575iH);
            sb3.append("|retCode|");
            sb3.append(i4);
            sb3.append("|flow|");
            sb3.append(str2);
            C0849fg.m915v(sb2, sb3.toString());
            if (i == 10021) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("|step|");
                sb4.append(i3);
                sb4.append("|cmdId|");
                sb4.append(i);
                sb4.append("|retCode|");
                sb4.append(i4);
                C0849fg.m915v("SharkFunnelModel", sb4.toString());
            }
            aVar.f566dO = i;
            if (str2 != null) {
                aVar.f577iJ = str2;
            }
            aVar.f578iy.set(i3, true);
            if (i3 == 14) {
                aVar.f572iE = i4;
            } else if (i3 == 16) {
                aVar.f573iF = i4;
            } else {
                aVar.f567fq = i4;
            }
            aVar.f575iH = System.currentTimeMillis();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a0, code lost:
            return r1;
     */
    /* renamed from: a */
    public synchronized boolean mo9320a(int r9, boolean r10) {
        /*
        r8 = this;
        monitor-enter(r8)
        btmsdkobf.dc<java.lang.Integer, btmsdkobf.dv$a> r0 = r8.f562it     // Catch:{ all -> 0x01a1 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x01a1 }
        btmsdkobf.dv$a r0 = (btmsdkobf.C0712dv.C0714a) r0     // Catch:{ all -> 0x01a1 }
        if (r0 != 0) goto L_0x0012
        r9 = 0
        monitor-exit(r8)
        return r9
    L_0x0012:
        btmsdkobf.dc<java.lang.Integer, btmsdkobf.dv$a> r1 = r8.f562it     // Catch:{ all -> 0x01a1 }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x01a1 }
        r1.mo9265a(r2)     // Catch:{ all -> 0x01a1 }
        java.util.BitSet r1 = r0.f578iy     // Catch:{ all -> 0x01a1 }
        r2 = 15
        boolean r1 = r1.get(r2)     // Catch:{ all -> 0x01a1 }
        int r2 = r0.f567fq     // Catch:{ all -> 0x01a1 }
        if (r2 == 0) goto L_0x005b
        int r3 = btmsdkobf.C0673cz.m214k(r2)     // Catch:{ all -> 0x01a1 }
        int r4 = r0.f568iA     // Catch:{ all -> 0x01a1 }
        r5 = -2
        if (r4 != r5) goto L_0x0036
        int r2 = r2 - r3
        r3 = -160000(0xfffffffffffd8f00, float:NaN)
        int r2 = r2 + r3
        goto L_0x005b
    L_0x0036:
        r5 = -50000(0xffffffffffff3cb0, float:NaN)
        if (r3 != r5) goto L_0x005b
        boolean r5 = r0.f570iC     // Catch:{ all -> 0x01a1 }
        if (r5 == 0) goto L_0x0043
        r4 = -550000(0xfffffffffff79b90, float:NaN)
        goto L_0x0059
    L_0x0043:
        r5 = -4
        if (r4 != r5) goto L_0x004a
        r4 = -530000(0xfffffffffff7e9b0, float:NaN)
        goto L_0x0059
    L_0x004a:
        r5 = -1
        if (r4 != r5) goto L_0x0051
        r4 = -220000(0xfffffffffffca4a0, float:NaN)
        goto L_0x0059
    L_0x0051:
        r5 = -3
        if (r4 != r5) goto L_0x0058
        r4 = -540000(0xfffffffffff7c2a0, float:NaN)
        goto L_0x0059
    L_0x0058:
        r4 = r3
    L_0x0059:
        int r2 = r2 - r3
        int r2 = r2 + r4
    L_0x005b:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
        r3.<init>()     // Catch:{ all -> 0x01a1 }
        java.lang.String r4 = "|cmd|cmd_"
        r3.append(r4)     // Catch:{ all -> 0x01a1 }
        int r4 = r0.f566dO     // Catch:{ all -> 0x01a1 }
        r3.append(r4)     // Catch:{ all -> 0x01a1 }
        java.lang.String r4 = "|seqNo|seq_"
        r3.append(r4)     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = r0.f579iz     // Catch:{ all -> 0x01a1 }
        boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x01a1 }
        if (r9 != 0) goto L_0x0084
        java.lang.String r9 = "|reason|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = r0.f579iz     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
    L_0x0084:
        java.lang.String r9 = "|channel|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        if (r1 == 0) goto L_0x008e
        java.lang.String r9 = "http"
        goto L_0x0090
    L_0x008e:
        java.lang.String r9 = "tcp"
    L_0x0090:
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|step|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.util.BitSet r9 = r0.f578iy     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|netState|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        int r9 = r0.f568iA     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = btmsdkobf.C0701dr.m390q(r9)     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|isScreenOn|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        boolean r9 = r0.f569iB     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|isNetworkChanged|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        boolean r9 = r0.f570iC     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|tcpRetCode|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        int r9 = r0.f572iE     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|httpRecCode|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        int r9 = r0.f573iF     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|retCode|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        int r9 = r0.f567fq     // Catch:{ all -> 0x01a1 }
        if (r2 != r9) goto L_0x00e6
        int r9 = r0.f567fq     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        goto L_0x00f3
    L_0x00e6:
        int r9 = r0.f567fq     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "->"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        r3.append(r2)     // Catch:{ all -> 0x01a1 }
    L_0x00f3:
        java.lang.String r9 = "|timeOut|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        long r4 = r0.f571iD     // Catch:{ all -> 0x01a1 }
        r3.append(r4)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|totalTime|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01a1 }
        long r6 = r0.f574iG     // Catch:{ all -> 0x01a1 }
        long r4 = r4 - r6
        r3.append(r4)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|sendFlow|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = r0.f576iI     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = "|recFlow|"
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        java.lang.String r9 = r0.f577iJ     // Catch:{ all -> 0x01a1 }
        r3.append(r9)     // Catch:{ all -> 0x01a1 }
        int r9 = r0.f567fq     // Catch:{ all -> 0x01a1 }
        if (r9 != 0) goto L_0x013f
        java.lang.String r9 = "SharkFunnelModel"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
        r4.<init>()     // Catch:{ all -> 0x01a1 }
        java.lang.String r5 = "[shark_funnel]"
        r4.append(r5)     // Catch:{ all -> 0x01a1 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a1 }
        r4.append(r3)     // Catch:{ all -> 0x01a1 }
        java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x01a1 }
        btmsdkobf.C0849fg.m911d(r9, r3)     // Catch:{ all -> 0x01a1 }
        goto L_0x0172
    L_0x013f:
        java.lang.String r9 = "SharkFunnelModel"
        if (r10 == 0) goto L_0x015c
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
        r4.<init>()     // Catch:{ all -> 0x01a1 }
        java.lang.String r5 = "xxxxxxxxxxxx [shark_funnel]"
        r4.append(r5)     // Catch:{ all -> 0x01a1 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a1 }
        r4.append(r3)     // Catch:{ all -> 0x01a1 }
        java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x01a1 }
    L_0x0158:
        btmsdkobf.C0849fg.m912e(r9, r3)     // Catch:{ all -> 0x01a1 }
        goto L_0x0172
    L_0x015c:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
        r4.<init>()     // Catch:{ all -> 0x01a1 }
        java.lang.String r5 = "tttt [shark_funnel]"
        r4.append(r5)     // Catch:{ all -> 0x01a1 }
        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a1 }
        r4.append(r3)     // Catch:{ all -> 0x01a1 }
        java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x01a1 }
        goto L_0x0158
    L_0x0172:
        btmsdkobf.dl r9 = r8.f561gZ     // Catch:{ all -> 0x01a1 }
        if (r9 == 0) goto L_0x019f
        int r9 = r0.f566dO     // Catch:{ all -> 0x01a1 }
        r3 = 10000(0x2710, float:1.4013E-41)
        if (r9 <= r3) goto L_0x0180
        int r9 = r0.f566dO     // Catch:{ all -> 0x01a1 }
        int r9 = r9 - r3
        goto L_0x0182
    L_0x0180:
        int r9 = r0.f566dO     // Catch:{ all -> 0x01a1 }
    L_0x0182:
        r0 = 999(0x3e7, float:1.4E-42)
        if (r9 == r0) goto L_0x019f
        r0 = 794(0x31a, float:1.113E-42)
        if (r9 == r0) goto L_0x019f
        r0 = 797(0x31d, float:1.117E-42)
        if (r9 == r0) goto L_0x019f
        r0 = 782(0x30e, float:1.096E-42)
        if (r9 == r0) goto L_0x019f
        if (r2 != 0) goto L_0x019a
        btmsdkobf.dl r10 = r8.f561gZ     // Catch:{ all -> 0x01a1 }
    L_0x0196:
        r10.mo9257i(r9, r2)     // Catch:{ all -> 0x01a1 }
        goto L_0x019f
    L_0x019a:
        if (r10 == 0) goto L_0x019f
        btmsdkobf.dl r10 = r8.f561gZ     // Catch:{ all -> 0x01a1 }
        goto L_0x0196
    L_0x019f:
        monitor-exit(r8)
        return r1
    L_0x01a1:
        r9 = move-exception
        monitor-exit(r8)
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0712dv.mo9320a(int, boolean):boolean");
    }

    /* renamed from: b */
    public int mo9321b(byte b) {
        synchronized (this.f564iw) {
            Integer num = (Integer) this.f564iw.get(Byte.valueOf(b));
            if (num == null) {
                return -1;
            }
            int intValue = num.intValue();
            return intValue;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|4|5|6|7) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0011 */
    /* renamed from: b */
    public synchronized void mo9322b(btmsdkobf.C0695dl r2) {
        /*
        r1 = this;
        monitor-enter(r1)
        r1.f561gZ = r2     // Catch:{ all -> 0x001f }
        android.content.Context r2 = btmsdkobf.C0652cl.m85D()     // Catch:{ all -> 0x0011 }
        java.lang.String r0 = "power"
        java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ all -> 0x0011 }
        android.os.PowerManager r2 = (android.os.PowerManager) r2     // Catch:{ all -> 0x0011 }
        r1.f563iv = r2     // Catch:{ all -> 0x0011 }
    L_0x0011:
        btmsdkobf.dz r2 = btmsdkobf.C0739dz.m545bM()     // Catch:{ all -> 0x001f }
        btmsdkobf.dv$1 r0 = new btmsdkobf.dv$1     // Catch:{ all -> 0x001f }
        r0.m40652init()     // Catch:{ all -> 0x001f }
        r2.mo9368a(r0)     // Catch:{ all -> 0x001f }
        monitor-exit(r1)
        return
    L_0x001f:
        r2 = move-exception
        monitor-exit(r1)
        throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0712dv.mo9322b(btmsdkobf.dl):void");
    }

    /* renamed from: s */
    public synchronized void mo9323s(int i) {
        this.f562it.mo9265a(Integer.valueOf(i));
    }

    /* renamed from: t */
    public synchronized boolean mo9324t(int i) {
        return mo9320a(i, true);
    }
}
