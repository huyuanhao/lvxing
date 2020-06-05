package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.info.C7175b;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.crash.C7190b;
import com.tencent.bugly.crashreport.crash.C7192c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7228ap;
import com.tencent.bugly.proguard.C7232aq;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.jni.a */
public class C7203a implements NativeExceptionHandler {
    /* renamed from: a */
    private final Context f24277a;
    /* renamed from: b */
    private final C7190b f24278b;
    /* renamed from: c */
    private final C7174a f24279c;
    /* renamed from: d */
    private final C7177a f24280d;

    public C7203a(Context context, C7174a aVar, C7190b bVar, C7177a aVar2) {
        this.f24277a = context;
        this.f24278b = bVar;
        this.f24279c = aVar;
        this.f24280d = aVar2;
    }

    public CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        String str12 = str;
        String str13 = str8;
        byte[] bArr2 = bArr;
        boolean l = C7192c.m30937a().mo34702l();
        if (l) {
            C7226an.m31149e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f24117b = 1;
        crashDetailBean.f24120e = this.f24279c.mo34595h();
        crashDetailBean.f24121f = this.f24279c.f24035p;
        crashDetailBean.f24122g = this.f24279c.mo34610w();
        crashDetailBean.f24128m = this.f24279c.mo34593g();
        crashDetailBean.f24129n = str3;
        String str14 = "";
        crashDetailBean.f24130o = l ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : str14;
        crashDetailBean.f24131p = str4;
        if (str5 != null) {
            str14 = str5;
        }
        crashDetailBean.f24132q = str14;
        crashDetailBean.f24133r = j;
        crashDetailBean.f24136u = C7232aq.m31207b(crashDetailBean.f24132q.getBytes());
        crashDetailBean.f24093A = str12;
        crashDetailBean.f24094B = str2;
        crashDetailBean.f24101I = this.f24279c.mo34612y();
        crashDetailBean.f24123h = this.f24279c.mo34609v();
        crashDetailBean.f24124i = this.f24279c.mo34564J();
        crashDetailBean.f24137v = str13;
        NativeCrashHandler instance = NativeCrashHandler.getInstance();
        String dumpFilePath = instance != null ? instance.getDumpFilePath() : null;
        String a = C7204b.m31007a(dumpFilePath, str13);
        if (!C7232aq.m31196a(a)) {
            crashDetailBean.f24114V = a;
        }
        crashDetailBean.f24115W = C7204b.m31012c(dumpFilePath);
        crashDetailBean.f24138w = C7204b.m31006a(str9, C7192c.f24191e, C7192c.f24194h, C7192c.f24199m);
        crashDetailBean.f24139x = C7204b.m31006a(str10, C7192c.f24191e, null, true);
        crashDetailBean.f24103K = str7;
        crashDetailBean.f24104L = str6;
        crashDetailBean.f24105M = str11;
        crashDetailBean.f24098F = this.f24279c.mo34603p();
        crashDetailBean.f24099G = this.f24279c.mo34602o();
        crashDetailBean.f24100H = this.f24279c.mo34604q();
        if (z) {
            crashDetailBean.f24095C = C7175b.m30833i();
            crashDetailBean.f24096D = C7175b.m30829g();
            crashDetailBean.f24097E = C7175b.m30837k();
            if (crashDetailBean.f24138w == null) {
                crashDetailBean.f24138w = C7232aq.m31180a(this.f24277a, C7192c.f24191e, C7192c.f24194h);
            }
            crashDetailBean.f24140y = C7228ap.m31160a();
            crashDetailBean.f24106N = this.f24279c.f23989a;
            crashDetailBean.f24107O = this.f24279c.mo34579a();
            crashDetailBean.f24109Q = this.f24279c.mo34562H();
            crashDetailBean.f24110R = this.f24279c.mo34563I();
            crashDetailBean.f24111S = this.f24279c.mo34556B();
            crashDetailBean.f24112T = this.f24279c.mo34561G();
            crashDetailBean.f24141z = C7232aq.m31188a(C7192c.f24192f, false);
            int indexOf = crashDetailBean.f24132q.indexOf("java:\n");
            if (indexOf > 0) {
                int i = indexOf + 6;
                if (i < crashDetailBean.f24132q.length()) {
                    String substring = crashDetailBean.f24132q.substring(i, crashDetailBean.f24132q.length() - 1);
                    if (substring.length() > 0 && crashDetailBean.f24141z.containsKey(crashDetailBean.f24094B)) {
                        String str15 = (String) crashDetailBean.f24141z.get(crashDetailBean.f24094B);
                        int indexOf2 = str15.indexOf(substring);
                        if (indexOf2 > 0) {
                            String substring2 = str15.substring(indexOf2);
                            crashDetailBean.f24141z.put(crashDetailBean.f24094B, substring2);
                            crashDetailBean.f24132q = crashDetailBean.f24132q.substring(0, i);
                            StringBuilder sb = new StringBuilder();
                            sb.append(crashDetailBean.f24132q);
                            sb.append(substring2);
                            crashDetailBean.f24132q = sb.toString();
                        }
                    }
                }
            }
            if (str12 == null) {
                crashDetailBean.f24093A = this.f24279c.f24024e;
            }
            this.f24278b.mo34682c(crashDetailBean);
        } else {
            crashDetailBean.f24095C = -1;
            crashDetailBean.f24096D = -1;
            crashDetailBean.f24097E = -1;
            if (crashDetailBean.f24138w == null) {
                crashDetailBean.f24138w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f24106N = -1;
            crashDetailBean.f24109Q = -1;
            crashDetailBean.f24110R = -1;
            crashDetailBean.f24111S = map;
            crashDetailBean.f24112T = this.f24279c.mo34561G();
            crashDetailBean.f24141z = null;
            if (str12 == null) {
                crashDetailBean.f24093A = "unknown(record)";
            }
            if (bArr2 != null) {
                crashDetailBean.f24140y = bArr2;
            }
        }
        return crashDetailBean;
    }

    public void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        int i7 = i;
        int i8 = i2;
        long j3 = j;
        long j4 = j2;
        String str8 = str;
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        int i9 = i3;
        String str12 = str5;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        String str13 = str6;
        String str14 = str7;
        C7226an.m31141a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i8, j3, j4, str8, str9, str10, str11, i9, str12, i10, i11, i12, str13, str14, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0101 A[Catch:{ all -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b6 A[Catch:{ all -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01c9 A[SYNTHETIC, Splitter:B:64:0x01c9] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0231 A[Catch:{ all -> 0x029b }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x023a A[Catch:{ all -> 0x029b }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02a7  */
    public void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
        r27 = this;
        r14 = r27
        r0 = r35
        r13 = r38
        r1 = r40
        r2 = r45
        r12 = 0
        java.lang.Object[] r3 = new java.lang.Object[r12]
        java.lang.String r4 = "Native Crash Happen v2"
        com.tencent.bugly.proguard.C7226an.m31141a(r4, r3)
        java.lang.String r11 = com.tencent.bugly.crashreport.crash.jni.C7204b.m31010b(r36)     // Catch:{ all -> 0x029f }
        java.lang.String r3 = "UNKNOWN"
        java.lang.String r4 = ")"
        java.lang.String r5 = "("
        if (r13 <= 0) goto L_0x003e
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
        r1.<init>()     // Catch:{ all -> 0x029f }
        r6 = r34
        r1.append(r6)     // Catch:{ all -> 0x029f }
        r1.append(r5)     // Catch:{ all -> 0x029f }
        r7 = r39
        r1.append(r7)     // Catch:{ all -> 0x029f }
        r1.append(r4)     // Catch:{ all -> 0x029f }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x029f }
        java.lang.String r6 = "KERNEL"
        r10 = r1
        r18 = r3
        r9 = r6
        goto L_0x0070
    L_0x003e:
        r6 = r34
        r7 = r39
        if (r1 <= 0) goto L_0x004a
        android.content.Context r3 = r14.f24277a     // Catch:{ all -> 0x029f }
        java.lang.String r3 = com.tencent.bugly.crashreport.common.info.AppInfo.m30739a(r3, r1)     // Catch:{ all -> 0x029f }
    L_0x004a:
        java.lang.String r8 = java.lang.String.valueOf(r40)     // Catch:{ all -> 0x029f }
        boolean r8 = r3.equals(r8)     // Catch:{ all -> 0x029f }
        if (r8 != 0) goto L_0x006c
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
        r8.<init>()     // Catch:{ all -> 0x029f }
        r8.append(r3)     // Catch:{ all -> 0x029f }
        r8.append(r5)     // Catch:{ all -> 0x029f }
        r8.append(r1)     // Catch:{ all -> 0x029f }
        r8.append(r4)     // Catch:{ all -> 0x029f }
        java.lang.String r1 = r8.toString()     // Catch:{ all -> 0x029f }
        r18 = r1
        goto L_0x006e
    L_0x006c:
        r18 = r3
    L_0x006e:
        r10 = r6
        r9 = r7
    L_0x0070:
        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x029f }
        r1.<init>()     // Catch:{ all -> 0x029f }
        if (r2 == 0) goto L_0x00b0
        r3 = 0
    L_0x0078:
        int r6 = r2.length     // Catch:{ all -> 0x029f }
        if (r3 >= r6) goto L_0x00b7
        r6 = r2[r3]     // Catch:{ all -> 0x029f }
        if (r6 == 0) goto L_0x00ad
        java.lang.String r7 = "Extra message[%d]: %s"
        r15 = 2
        java.lang.Object[] r8 = new java.lang.Object[r15]     // Catch:{ all -> 0x029f }
        java.lang.Integer r16 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x029f }
        r8[r12] = r16     // Catch:{ all -> 0x029f }
        r16 = 1
        r8[r16] = r6     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7226an.m31141a(r7, r8)     // Catch:{ all -> 0x029f }
        java.lang.String r7 = "="
        java.lang.String[] r7 = r6.split(r7)     // Catch:{ all -> 0x029f }
        int r8 = r7.length     // Catch:{ all -> 0x029f }
        if (r8 != r15) goto L_0x00a3
        r6 = r7[r12]     // Catch:{ all -> 0x029f }
        r8 = 1
        r7 = r7[r8]     // Catch:{ all -> 0x029f }
        r1.put(r6, r7)     // Catch:{ all -> 0x029f }
        goto L_0x00ad
    L_0x00a3:
        java.lang.String r7 = "bad extraMsg %s"
        r8 = 1
        java.lang.Object[] r15 = new java.lang.Object[r8]     // Catch:{ all -> 0x029f }
        r15[r12] = r6     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7226an.m31148d(r7, r15)     // Catch:{ all -> 0x029f }
    L_0x00ad:
        int r3 = r3 + 1
        goto L_0x0078
    L_0x00b0:
        java.lang.String r2 = "not found extraMsg"
        java.lang.Object[] r3 = new java.lang.Object[r12]     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7226an.m31147c(r2, r3)     // Catch:{ all -> 0x029f }
    L_0x00b7:
        java.lang.String r2 = "HasPendingException"
        java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x029f }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x029f }
        if (r2 == 0) goto L_0x00d3
        java.lang.String r3 = "true"
        boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x029f }
        if (r2 == 0) goto L_0x00d3
        java.lang.String r2 = "Native crash happened with a Java pending exception."
        java.lang.Object[] r3 = new java.lang.Object[r12]     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7226an.m31141a(r2, r3)     // Catch:{ all -> 0x029f }
        r19 = 1
        goto L_0x00d5
    L_0x00d3:
        r19 = 0
    L_0x00d5:
        java.lang.String r2 = "ExceptionProcessName"
        java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x029f }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x029f }
        if (r2 == 0) goto L_0x00f1
        int r3 = r2.length()     // Catch:{ all -> 0x029f }
        if (r3 != 0) goto L_0x00e6
        goto L_0x00f1
    L_0x00e6:
        java.lang.String r3 = "Name of crash process: %s"
        r6 = 1
        java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x029f }
        r7[r12] = r2     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7226an.m31147c(r3, r7)     // Catch:{ all -> 0x029f }
        goto L_0x00f5
    L_0x00f1:
        com.tencent.bugly.crashreport.common.info.a r2 = r14.f24279c     // Catch:{ all -> 0x029f }
        java.lang.String r2 = r2.f24024e     // Catch:{ all -> 0x029f }
    L_0x00f5:
        r20 = r2
        java.lang.String r2 = "ExceptionThreadName"
        java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x029f }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x029f }
        if (r2 == 0) goto L_0x016f
        int r3 = r2.length()     // Catch:{ all -> 0x029f }
        if (r3 != 0) goto L_0x0108
        goto L_0x016f
    L_0x0108:
        java.lang.String r3 = "Name of crash thread: %s"
        r8 = 1
        java.lang.Object[] r6 = new java.lang.Object[r8]     // Catch:{ all -> 0x029f }
        r6[r12] = r2     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7226an.m31147c(r3, r6)     // Catch:{ all -> 0x029f }
        java.util.Map r3 = java.lang.Thread.getAllStackTraces()     // Catch:{ all -> 0x029f }
        java.util.Set r3 = r3.keySet()     // Catch:{ all -> 0x029f }
        java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x029f }
    L_0x011e:
        boolean r6 = r3.hasNext()     // Catch:{ all -> 0x029f }
        if (r6 == 0) goto L_0x0150
        java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x029f }
        java.lang.Thread r6 = (java.lang.Thread) r6     // Catch:{ all -> 0x029f }
        java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x029f }
        boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x029f }
        if (r7 == 0) goto L_0x011e
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
        r3.<init>()     // Catch:{ all -> 0x029f }
        r3.append(r2)     // Catch:{ all -> 0x029f }
        r3.append(r5)     // Catch:{ all -> 0x029f }
        long r6 = r6.getId()     // Catch:{ all -> 0x029f }
        r3.append(r6)     // Catch:{ all -> 0x029f }
        r3.append(r4)     // Catch:{ all -> 0x029f }
        java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x029f }
        r3 = r2
        r2 = 1
        goto L_0x0152
    L_0x0150:
        r3 = r2
        r2 = 0
    L_0x0152:
        if (r2 != 0) goto L_0x016c
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
        r2.<init>()     // Catch:{ all -> 0x029f }
        r2.append(r3)     // Catch:{ all -> 0x029f }
        r2.append(r5)     // Catch:{ all -> 0x029f }
        r3 = r29
        r2.append(r3)     // Catch:{ all -> 0x029f }
        r2.append(r4)     // Catch:{ all -> 0x029f }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x029f }
        goto L_0x0191
    L_0x016c:
        r21 = r3
        goto L_0x0193
    L_0x016f:
        r8 = 1
        java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x029f }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
        r3.<init>()     // Catch:{ all -> 0x029f }
        java.lang.String r6 = r2.getName()     // Catch:{ all -> 0x029f }
        r3.append(r6)     // Catch:{ all -> 0x029f }
        r3.append(r5)     // Catch:{ all -> 0x029f }
        long r5 = r2.getId()     // Catch:{ all -> 0x029f }
        r3.append(r5)     // Catch:{ all -> 0x029f }
        r3.append(r4)     // Catch:{ all -> 0x029f }
        java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x029f }
    L_0x0191:
        r21 = r2
    L_0x0193:
        r2 = 1000(0x3e8, double:4.94E-321)
        long r4 = r30 * r2
        long r2 = r32 / r2
        long r4 = r4 + r2
        java.lang.String r2 = "SysLogPath"
        java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x029f }
        r22 = r2
        java.lang.String r22 = (java.lang.String) r22     // Catch:{ all -> 0x029f }
        java.lang.String r2 = "JniLogPath"
        java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x029f }
        r23 = r1
        java.lang.String r23 = (java.lang.String) r23     // Catch:{ all -> 0x029f }
        com.tencent.bugly.crashreport.common.strategy.a r1 = r14.f24280d     // Catch:{ all -> 0x029f }
        boolean r1 = r1.mo34623b()     // Catch:{ all -> 0x029f }
        if (r1 != 0) goto L_0x01bd
        java.lang.String r1 = "no remote but still store!"
        java.lang.Object[] r2 = new java.lang.Object[r12]     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7226an.m31148d(r1, r2)     // Catch:{ all -> 0x029f }
    L_0x01bd:
        com.tencent.bugly.crashreport.common.strategy.a r1 = r14.f24280d     // Catch:{ all -> 0x029f }
        com.tencent.bugly.crashreport.common.strategy.StrategyBean r1 = r1.mo34624c()     // Catch:{ all -> 0x029f }
        boolean r1 = r1.f24057g     // Catch:{ all -> 0x029f }
        java.lang.String r7 = "\n"
        if (r1 != 0) goto L_0x020a
        com.tencent.bugly.crashreport.common.strategy.a r1 = r14.f24280d     // Catch:{ all -> 0x029f }
        boolean r1 = r1.mo34623b()     // Catch:{ all -> 0x029f }
        if (r1 == 0) goto L_0x020a
        java.lang.String r1 = "crash report was closed by remote , will not upload to Bugly , print local for helpful!"
        java.lang.Object[] r2 = new java.lang.Object[r12]     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7226an.m31149e(r1, r2)     // Catch:{ all -> 0x029f }
        java.lang.String r1 = "NATIVE_CRASH"
        java.lang.String r2 = com.tencent.bugly.proguard.C7232aq.m31178a()     // Catch:{ all -> 0x029f }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
        r3.<init>()     // Catch:{ all -> 0x029f }
        r3.append(r10)     // Catch:{ all -> 0x029f }
        r3.append(r7)     // Catch:{ all -> 0x029f }
        r3.append(r0)     // Catch:{ all -> 0x029f }
        r3.append(r7)     // Catch:{ all -> 0x029f }
        r3.append(r11)     // Catch:{ all -> 0x029f }
        java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x029f }
        r3 = 0
        r29 = r1
        r30 = r2
        r31 = r20
        r32 = r21
        r33 = r0
        r34 = r3
        com.tencent.bugly.crashreport.crash.C7190b.m30914a(r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x029f }
        com.tencent.bugly.proguard.C7232aq.m31211b(r37)     // Catch:{ all -> 0x029f }
        return
    L_0x020a:
        r15 = 0
        r16 = 0
        r17 = 1
        r1 = r27
        r2 = r20
        r3 = r21
        r6 = r10
        r24 = r7
        r7 = r35
        r8 = r11
        r25 = r10
        r10 = r18
        r26 = r11
        r11 = r37
        r12 = r22
        r13 = r23
        r14 = r44
        r18 = r19
        com.tencent.bugly.crashreport.crash.CrashDetailBean r1 = r1.packageCrashDatas(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x029b }
        if (r1 != 0) goto L_0x023a
        java.lang.String r0 = "pkg crash datas fail!"
        r2 = 0
        java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x029b }
        com.tencent.bugly.proguard.C7226an.m31149e(r0, r1)     // Catch:{ all -> 0x029b }
        return
    L_0x023a:
        r2 = 0
        java.lang.String r3 = "NATIVE_CRASH"
        java.lang.String r4 = com.tencent.bugly.proguard.C7232aq.m31178a()     // Catch:{ all -> 0x029b }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x029b }
        r5.<init>()     // Catch:{ all -> 0x029b }
        r6 = r25
        r5.append(r6)     // Catch:{ all -> 0x029b }
        r6 = r24
        r5.append(r6)     // Catch:{ all -> 0x029b }
        r5.append(r0)     // Catch:{ all -> 0x029b }
        r5.append(r6)     // Catch:{ all -> 0x029b }
        r0 = r26
        r5.append(r0)     // Catch:{ all -> 0x029b }
        java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x029b }
        r29 = r3
        r30 = r4
        r31 = r20
        r32 = r21
        r33 = r0
        r34 = r1
        com.tencent.bugly.crashreport.crash.C7190b.m30914a(r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x029b }
        r3 = r27
        com.tencent.bugly.crashreport.crash.b r0 = r3.f24278b     // Catch:{ all -> 0x0299 }
        r4 = r38
        boolean r0 = r0.mo34677a(r1, r4)     // Catch:{ all -> 0x0299 }
        if (r0 != 0) goto L_0x027b
        r2 = 1
    L_0x027b:
        r0 = 0
        com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r4 = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getInstance()     // Catch:{ all -> 0x0299 }
        if (r4 == 0) goto L_0x0286
        java.lang.String r0 = r4.getDumpFilePath()     // Catch:{ all -> 0x0299 }
    L_0x0286:
        r4 = 1
        com.tencent.bugly.crashreport.crash.jni.C7204b.m31009a(r4, r0)     // Catch:{ all -> 0x0299 }
        if (r2 == 0) goto L_0x0293
        com.tencent.bugly.crashreport.crash.b r0 = r3.f24278b     // Catch:{ all -> 0x0299 }
        r5 = 3000(0xbb8, double:1.482E-320)
        r0.mo34673a(r1, r5, r4)     // Catch:{ all -> 0x0299 }
    L_0x0293:
        com.tencent.bugly.crashreport.crash.b r0 = r3.f24278b     // Catch:{ all -> 0x0299 }
        r0.mo34681b(r1)     // Catch:{ all -> 0x0299 }
        goto L_0x02aa
    L_0x0299:
        r0 = move-exception
        goto L_0x02a1
    L_0x029b:
        r0 = move-exception
        r3 = r27
        goto L_0x02a1
    L_0x029f:
        r0 = move-exception
        r3 = r14
    L_0x02a1:
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)
        if (r1 != 0) goto L_0x02aa
        r0.printStackTrace()
    L_0x02aa:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.C7203a.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }
}
