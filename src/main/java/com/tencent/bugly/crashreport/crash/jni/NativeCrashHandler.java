package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.C7162a;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.crashreport.common.strategy.C7177a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C7190b;
import com.tencent.bugly.crashreport.crash.C7192c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C7224am;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import java.io.File;

/* compiled from: BUGLY */
public class NativeCrashHandler implements C7162a {
    /* renamed from: a */
    private static NativeCrashHandler f24261a = null;
    /* renamed from: l */
    private static boolean f24262l = false;
    /* renamed from: m */
    private static boolean f24263m = false;
    /* access modifiers changed from: private|static */
    /* renamed from: o */
    public static boolean f24264o = true;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Context f24265b;
    /* renamed from: c */
    private final C7174a f24266c;
    /* renamed from: d */
    private final C7224am f24267d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public NativeExceptionHandler f24268e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public String f24269f;
    /* renamed from: g */
    private final boolean f24270g;
    /* renamed from: h */
    private boolean f24271h = false;
    /* renamed from: i */
    private boolean f24272i = false;
    /* renamed from: j */
    private boolean f24273j = false;
    /* renamed from: k */
    private boolean f24274k = false;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public C7190b f24275n;

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i);

    public native String removeNativeKeyValue(String str);

    public native void setNativeInfo(int i, String str);

    public native void testCrash();

    public native String unregist();

    /* renamed from: a */
    private static void m30990a(String str) {
        C7226an.m31147c("[Native] Check extra jni for Bugly NDK v%s", str);
        String str2 = "";
        String str3 = ".";
        String replace = "2.1.1".replace(str3, str2);
        String replace2 = "2.3.0".replace(str3, str2);
        String replace3 = str.replace(str3, str2);
        if (replace3.length() == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(replace3);
            sb.append("0");
            replace3 = sb.toString();
        } else if (replace3.length() == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(replace3);
            sb2.append("00");
            replace3 = sb2.toString();
        }
        try {
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                f24262l = true;
            }
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                f24263m = true;
            }
        } catch (Throwable unused) {
        }
        if (f24263m) {
            C7226an.m31141a("[Native] Info setting jni can be accessed.", new Object[0]);
        } else {
            C7226an.m31148d("[Native] Info setting jni can not be accessed.", new Object[0]);
        }
        if (f24262l) {
            C7226an.m31141a("[Native] Extra jni can be accessed.", new Object[0]);
            return;
        }
        C7226an.m31148d("[Native] Extra jni can not be accessed.", new Object[0]);
    }

    protected NativeCrashHandler(Context context, C7174a aVar, C7190b bVar, C7177a aVar2, C7224am amVar, boolean z, String str) {
        this.f24265b = C7232aq.m31172a(context);
        try {
            if (C7232aq.m31196a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            String str2 = C7174a.m30753a(context).f24023d;
            StringBuilder sb = new StringBuilder();
            sb.append("/data/data/");
            sb.append(str2);
            sb.append("/app_bugly");
            str = sb.toString();
        }
        this.f24275n = bVar;
        this.f24269f = str;
        this.f24266c = aVar;
        this.f24267d = amVar;
        this.f24270g = z;
        this.f24268e = new C7203a(context, aVar, bVar, C7177a.m30857a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C7174a aVar, C7190b bVar, C7177a aVar2, C7224am amVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f24261a == null) {
                NativeCrashHandler nativeCrashHandler2 = new NativeCrashHandler(context, aVar, bVar, aVar2, amVar, z, str);
                f24261a = nativeCrashHandler2;
            }
            nativeCrashHandler = f24261a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f24261a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f24269f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f24269f = str;
    }

    public static void setShouldHandleInJava(boolean z) {
        f24264o = z;
        NativeCrashHandler nativeCrashHandler = f24261a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(z);
            nativeCrashHandler.m30991a(999, sb.toString());
        }
    }

    public static boolean isShouldHandleInJava() {
        return f24264o;
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|9|(3:11|12|(3:14|15|16))(2:21|(7:23|24|25|(1:27)(1:28)|29|(1:31)|(7:33|(1:35)|36|(1:38)|39|40|41)))|42|43|44|45) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0110 */
    /* renamed from: a */
    public synchronized void mo34725a(boolean r11) {
        /*
        r10 = this;
        monitor-enter(r10)
        boolean r0 = r10.f24273j     // Catch:{ all -> 0x0116 }
        r1 = 0
        if (r0 == 0) goto L_0x000f
        java.lang.String r11 = "[Native] Native crash report has already registered."
        java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0116 }
        com.tencent.bugly.proguard.C7226an.m31148d(r11, r0)     // Catch:{ all -> 0x0116 }
        monitor-exit(r10)
        return
    L_0x000f:
        boolean r0 = r10.f24272i     // Catch:{ all -> 0x0116 }
        r2 = 1
        if (r0 == 0) goto L_0x003c
        java.lang.String r0 = r10.f24269f     // Catch:{ all -> 0x0033 }
        java.lang.String r11 = r10.regist(r0, r11, r2)     // Catch:{ all -> 0x0033 }
        if (r11 == 0) goto L_0x0110
        java.lang.String r0 = "[Native] Native Crash Report enable."
        java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0033 }
        com.tencent.bugly.proguard.C7226an.m31141a(r0, r3)     // Catch:{ all -> 0x0033 }
        m30990a(r11)     // Catch:{ all -> 0x0033 }
        com.tencent.bugly.crashreport.common.info.a r0 = r10.f24266c     // Catch:{ all -> 0x0033 }
        r0.f24039t = r11     // Catch:{ all -> 0x0033 }
        boolean r11 = f24262l     // Catch:{ all -> 0x0033 }
        com.tencent.bugly.proguard.C7228ap.m31159a(r11)     // Catch:{ all -> 0x0033 }
        r10.f24273j = r2     // Catch:{ all -> 0x0033 }
        monitor-exit(r10)
        return
    L_0x0033:
        java.lang.String r11 = "[Native] Failed to load Bugly SO file."
        java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0116 }
        com.tencent.bugly.proguard.C7226an.m31147c(r11, r0)     // Catch:{ all -> 0x0116 }
        goto L_0x0110
    L_0x003c:
        boolean r0 = r10.f24271h     // Catch:{ all -> 0x0116 }
        if (r0 == 0) goto L_0x0110
        java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
        java.lang.String r3 = "registNativeExceptionHandler2"
        r4 = 4
        java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0110 }
        java.lang.Class<java.lang.String> r6 = java.lang.String.class
        r5[r1] = r6     // Catch:{ all -> 0x0110 }
        java.lang.Class<java.lang.String> r6 = java.lang.String.class
        r5[r2] = r6     // Catch:{ all -> 0x0110 }
        java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0110 }
        r7 = 2
        r5[r7] = r6     // Catch:{ all -> 0x0110 }
        java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0110 }
        r8 = 3
        r5[r8] = r6     // Catch:{ all -> 0x0110 }
        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0110 }
        java.lang.String r6 = r10.f24269f     // Catch:{ all -> 0x0110 }
        r4[r1] = r6     // Catch:{ all -> 0x0110 }
        android.content.Context r6 = r10.f24265b     // Catch:{ all -> 0x0110 }
        java.lang.String r6 = com.tencent.bugly.crashreport.common.info.C7175b.m30818a(r6, r1)     // Catch:{ all -> 0x0110 }
        r4[r2] = r6     // Catch:{ all -> 0x0110 }
        r6 = 5
        if (r11 == 0) goto L_0x006c
        r9 = 1
        goto L_0x006d
    L_0x006c:
        r9 = 5
    L_0x006d:
        java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0110 }
        r4[r7] = r9     // Catch:{ all -> 0x0110 }
        java.lang.Integer r9 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0110 }
        r4[r8] = r9     // Catch:{ all -> 0x0110 }
        r9 = 0
        java.lang.Object r0 = com.tencent.bugly.proguard.C7232aq.m31176a(r0, r3, r9, r5, r4)     // Catch:{ all -> 0x0110 }
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0110 }
        if (r0 != 0) goto L_0x00b6
        java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
        java.lang.String r3 = "registNativeExceptionHandler"
        java.lang.Class[] r4 = new java.lang.Class[r8]     // Catch:{ all -> 0x0110 }
        java.lang.Class<java.lang.String> r5 = java.lang.String.class
        r4[r1] = r5     // Catch:{ all -> 0x0110 }
        java.lang.Class<java.lang.String> r5 = java.lang.String.class
        r4[r2] = r5     // Catch:{ all -> 0x0110 }
        java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0110 }
        r4[r7] = r5     // Catch:{ all -> 0x0110 }
        java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0110 }
        java.lang.String r8 = r10.f24269f     // Catch:{ all -> 0x0110 }
        r5[r1] = r8     // Catch:{ all -> 0x0110 }
        android.content.Context r8 = r10.f24265b     // Catch:{ all -> 0x0110 }
        java.lang.String r8 = com.tencent.bugly.crashreport.common.info.C7175b.m30818a(r8, r1)     // Catch:{ all -> 0x0110 }
        r5[r2] = r8     // Catch:{ all -> 0x0110 }
        com.tencent.bugly.crashreport.common.info.a r8 = com.tencent.bugly.crashreport.common.info.C7174a.m30754b()     // Catch:{ all -> 0x0110 }
        int r8 = r8.mo34565K()     // Catch:{ all -> 0x0110 }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0110 }
        r5[r7] = r8     // Catch:{ all -> 0x0110 }
        java.lang.Object r0 = com.tencent.bugly.proguard.C7232aq.m31176a(r0, r3, r9, r4, r5)     // Catch:{ all -> 0x0110 }
        java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0110 }
    L_0x00b6:
        if (r0 == 0) goto L_0x0110
        r10.f24273j = r2     // Catch:{ all -> 0x0110 }
        com.tencent.bugly.crashreport.common.info.a r3 = com.tencent.bugly.crashreport.common.info.C7174a.m30754b()     // Catch:{ all -> 0x0110 }
        r3.f24039t = r0     // Catch:{ all -> 0x0110 }
        java.lang.String r3 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
        java.lang.String r4 = "checkExtraJni"
        java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x0110 }
        java.lang.Class<java.lang.String> r7 = java.lang.String.class
        r5[r1] = r7     // Catch:{ all -> 0x0110 }
        java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0110 }
        r7[r1] = r0     // Catch:{ all -> 0x0110 }
        java.lang.Object r0 = com.tencent.bugly.proguard.C7232aq.m31176a(r3, r4, r9, r5, r7)     // Catch:{ all -> 0x0110 }
        java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0110 }
        if (r0 == 0) goto L_0x00e1
        boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0110 }
        f24262l = r0     // Catch:{ all -> 0x0110 }
        boolean r0 = f24262l     // Catch:{ all -> 0x0110 }
        com.tencent.bugly.proguard.C7228ap.m31159a(r0)     // Catch:{ all -> 0x0110 }
    L_0x00e1:
        java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
        java.lang.String r3 = "enableHandler"
        java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ all -> 0x0110 }
        java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0110 }
        r4[r1] = r5     // Catch:{ all -> 0x0110 }
        java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0110 }
        java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0110 }
        r5[r1] = r7     // Catch:{ all -> 0x0110 }
        com.tencent.bugly.proguard.C7232aq.m31176a(r0, r3, r9, r4, r5)     // Catch:{ all -> 0x0110 }
        if (r11 == 0) goto L_0x00f9
        r6 = 1
    L_0x00f9:
        java.lang.String r11 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
        java.lang.String r0 = "setLogMode"
        java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x0110 }
        java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0110 }
        r3[r1] = r4     // Catch:{ all -> 0x0110 }
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0110 }
        java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0110 }
        r2[r1] = r4     // Catch:{ all -> 0x0110 }
        com.tencent.bugly.proguard.C7232aq.m31176a(r11, r0, r9, r3, r2)     // Catch:{ all -> 0x0110 }
        monitor-exit(r10)
        return
    L_0x0110:
        r10.f24272i = r1     // Catch:{ all -> 0x0116 }
        r10.f24271h = r1     // Catch:{ all -> 0x0116 }
        monitor-exit(r10)
        return
    L_0x0116:
        r11 = move-exception
        monitor-exit(r10)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.mo34725a(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a1, code lost:
            return;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x00a2=Splitter:B:37:0x00a2, B:31:0x0069=Splitter:B:31:0x0069} */
    public synchronized void startNativeMonitor() {
        /*
        r5 = this;
        monitor-enter(r5)
        boolean r0 = r5.f24272i     // Catch:{ all -> 0x00a9 }
        if (r0 != 0) goto L_0x00a2
        boolean r0 = r5.f24271h     // Catch:{ all -> 0x00a9 }
        if (r0 == 0) goto L_0x000b
        goto L_0x00a2
    L_0x000b:
        java.lang.String r0 = "Bugly"
        java.lang.String r1 = "NativeRQD"
        com.tencent.bugly.crashreport.common.info.a r2 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        java.lang.String r2 = r2.f24038s     // Catch:{ all -> 0x00a9 }
        boolean r2 = com.tencent.bugly.proguard.C7232aq.m31196a(r2)     // Catch:{ all -> 0x00a9 }
        r3 = 0
        if (r2 != 0) goto L_0x001c
        r2 = 1
        goto L_0x001d
    L_0x001c:
        r2 = 0
    L_0x001d:
        boolean r4 = com.tencent.bugly.crashreport.crash.C7192c.f24188b     // Catch:{ all -> 0x00a9 }
        if (r4 == 0) goto L_0x004c
        if (r2 == 0) goto L_0x0028
        com.tencent.bugly.crashreport.common.info.a r0 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        java.lang.String r0 = r0.f24038s     // Catch:{ all -> 0x00a9 }
        goto L_0x0039
    L_0x0028:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
        r4.<init>()     // Catch:{ all -> 0x00a9 }
        r4.append(r0)     // Catch:{ all -> 0x00a9 }
        java.lang.String r0 = "-rqd"
        r4.append(r0)     // Catch:{ all -> 0x00a9 }
        java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00a9 }
    L_0x0039:
        boolean r0 = r5.m30993a(r0, r2)     // Catch:{ all -> 0x00a9 }
        r5.f24272i = r0     // Catch:{ all -> 0x00a9 }
        boolean r0 = r5.f24272i     // Catch:{ all -> 0x00a9 }
        if (r0 != 0) goto L_0x005f
        if (r2 != 0) goto L_0x005f
        boolean r0 = r5.m30993a(r1, r3)     // Catch:{ all -> 0x00a9 }
        r5.f24271h = r0     // Catch:{ all -> 0x00a9 }
        goto L_0x005f
    L_0x004c:
        com.tencent.bugly.crashreport.common.info.a r1 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        java.lang.String r1 = r1.f24038s     // Catch:{ all -> 0x00a9 }
        if (r2 != 0) goto L_0x0058
        com.tencent.bugly.crashreport.common.info.a r1 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        r1.getClass()     // Catch:{ all -> 0x00a9 }
        goto L_0x0059
    L_0x0058:
        r0 = r1
    L_0x0059:
        boolean r0 = r5.m30993a(r0, r2)     // Catch:{ all -> 0x00a9 }
        r5.f24272i = r0     // Catch:{ all -> 0x00a9 }
    L_0x005f:
        boolean r0 = r5.f24272i     // Catch:{ all -> 0x00a9 }
        if (r0 != 0) goto L_0x0069
        boolean r0 = r5.f24271h     // Catch:{ all -> 0x00a9 }
        if (r0 != 0) goto L_0x0069
        monitor-exit(r5)
        return
    L_0x0069:
        boolean r0 = r5.f24270g     // Catch:{ all -> 0x00a9 }
        r5.mo34725a(r0)     // Catch:{ all -> 0x00a9 }
        boolean r0 = f24262l     // Catch:{ all -> 0x00a9 }
        if (r0 == 0) goto L_0x00a0
        com.tencent.bugly.crashreport.common.info.a r0 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        java.lang.String r0 = r0.f24035p     // Catch:{ all -> 0x00a9 }
        r5.setNativeAppVersion(r0)     // Catch:{ all -> 0x00a9 }
        com.tencent.bugly.crashreport.common.info.a r0 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        java.lang.String r0 = r0.f24037r     // Catch:{ all -> 0x00a9 }
        r5.setNativeAppChannel(r0)     // Catch:{ all -> 0x00a9 }
        com.tencent.bugly.crashreport.common.info.a r0 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        java.lang.String r0 = r0.f24023d     // Catch:{ all -> 0x00a9 }
        r5.setNativeAppPackage(r0)     // Catch:{ all -> 0x00a9 }
        com.tencent.bugly.crashreport.common.info.a r0 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        java.lang.String r0 = r0.mo34593g()     // Catch:{ all -> 0x00a9 }
        r5.setNativeUserId(r0)     // Catch:{ all -> 0x00a9 }
        com.tencent.bugly.crashreport.common.info.a r0 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        boolean r0 = r0.mo34579a()     // Catch:{ all -> 0x00a9 }
        r5.setNativeIsAppForeground(r0)     // Catch:{ all -> 0x00a9 }
        com.tencent.bugly.crashreport.common.info.a r0 = r5.f24266c     // Catch:{ all -> 0x00a9 }
        long r0 = r0.f23989a     // Catch:{ all -> 0x00a9 }
        r5.setNativeLaunchTime(r0)     // Catch:{ all -> 0x00a9 }
    L_0x00a0:
        monitor-exit(r5)
        return
    L_0x00a2:
        boolean r0 = r5.f24270g     // Catch:{ all -> 0x00a9 }
        r5.mo34725a(r0)     // Catch:{ all -> 0x00a9 }
        monitor-exit(r5)
        return
    L_0x00a9:
        r0 = move-exception
        monitor-exit(r5)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.startNativeMonitor():void");
    }

    public void checkUploadRecordCrash() {
        this.f24267d.mo34832a(new Runnable() {
            public void run() {
                String str = "native_record_lock";
                if (!C7232aq.m31193a(NativeCrashHandler.this.f24265b, str, 10000)) {
                    C7226an.m31141a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.f24264o) {
                    NativeCrashHandler.this.m30991a(999, "false");
                }
                CrashDetailBean a = C7204b.m31003a(NativeCrashHandler.this.f24265b, NativeCrashHandler.this.f24269f, NativeCrashHandler.this.f24268e);
                if (a != null) {
                    C7226an.m31141a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.f24275n.mo34676a(a)) {
                        NativeCrashHandler.this.f24275n.mo34673a(a, 3000, false);
                    }
                    C7204b.m31009a(false, NativeCrashHandler.this.f24269f);
                }
                NativeCrashHandler.this.mo34728b();
                C7232aq.m31220c(NativeCrashHandler.this.f24265b, str);
            }
        });
    }

    /* renamed from: a */
    private boolean m30993a(String str, boolean z) {
        boolean z2;
        try {
            C7226an.m31141a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                C7226an.m31141a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
            C7226an.m31148d(th.getMessage(), new Object[0]);
            C7226an.m31148d("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* renamed from: a */
    public synchronized void mo34724a() {
        if (!this.f24273j) {
            C7226an.m31148d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                C7226an.m31141a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f24273j = false;
                return;
            }
        } catch (Throwable unused) {
            C7226an.m31147c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            C7232aq.m31176a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(false)});
            this.f24273j = false;
            C7226an.m31141a("[Native] Successfully closed native crash report.", new Object[0]);
            return;
        } catch (Throwable unused2) {
            C7226an.m31147c("[Native] Failed to close native crash report.", new Object[0]);
            this.f24272i = false;
            this.f24271h = false;
            return;
        }
    }

    public void testNativeCrash() {
        if (!this.f24272i) {
            C7226an.m31148d("[Native] Bugly SO file has not been load.", new Object[0]);
            return;
        }
        testCrash();
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        sb.append(z);
        m30991a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(z2);
        m30991a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(z3);
        m30991a(18, sb3.toString());
        testNativeCrash();
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f24268e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo34728b() {
        long b = C7232aq.m31204b() - C7192c.f24193g;
        long b2 = C7232aq.m31204b() + 86400000;
        File file = new File(this.f24269f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (listFiles.length != 0) {
                        int i = 0;
                        int i2 = 0;
                        for (File file2 : listFiles) {
                            long lastModified = file2.lastModified();
                            if (lastModified < b || lastModified >= b2) {
                                C7226an.m31141a("[Native] Delete record file: %s", file2.getAbsolutePath());
                                i++;
                                if (file2.delete()) {
                                    i2++;
                                }
                            }
                        }
                        C7226an.m31147c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i), Integer.valueOf(i2));
                    }
                }
            } catch (Throwable th) {
                C7226an.m31142a(th);
            }
        }
    }

    public void removeEmptyNativeRecordFiles() {
        C7204b.m31014d(this.f24269f);
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* renamed from: b */
    public synchronized void mo34729b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            mo34724a();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.f24274k;
    }

    /* renamed from: c */
    private synchronized void m30996c(boolean z) {
        if (this.f24274k != z) {
            C7226an.m31141a("user change native %b", Boolean.valueOf(z));
            this.f24274k = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        m30996c(z);
        boolean isUserOpened = isUserOpened();
        C7177a a = C7177a.m30857a();
        if (a != null) {
            isUserOpened = isUserOpened && a.mo34624c().f24057g;
        }
        if (isUserOpened != this.f24273j) {
            C7226an.m31141a("native changed to %b", Boolean.valueOf(isUserOpened));
            mo34729b(isUserOpened);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f24057g != this.f24273j) {
                C7226an.m31148d("server native changed to %b", Boolean.valueOf(strategyBean.f24057g));
            }
        }
        boolean z = C7177a.m30857a().mo34624c().f24057g && this.f24274k;
        if (z != this.f24273j) {
            C7226an.m31141a("native changed to %b", Boolean.valueOf(z));
            mo34729b(z);
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        boolean z = false;
        if (!((!this.f24271h && !this.f24272i) || !f24262l || str == null || str2 == null || str3 == null)) {
            try {
                if (this.f24272i) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) C7232aq.m31176a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    z = bool.booleanValue();
                }
                return z;
            } catch (UnsatisfiedLinkError unused) {
                f24262l = false;
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public String getLogFromNative() {
        if ((!this.f24271h && !this.f24272i) || !f24262l) {
            return null;
        }
        try {
            if (this.f24272i) {
                return getNativeLog();
            }
            return (String) C7232aq.m31176a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f24262l = false;
            return null;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        boolean z = false;
        if ((this.f24271h || this.f24272i) && f24262l && str != null && str2 != null) {
            try {
                if (this.f24272i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) C7232aq.m31176a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    z = bool.booleanValue();
                }
                return z;
            } catch (UnsatisfiedLinkError unused) {
                f24262l = false;
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m30991a(int i, String str) {
        if (this.f24272i && f24263m) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f24263m = false;
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public boolean filterSigabrtSysLog() {
        return m30991a(998, "true");
    }

    public boolean setNativeAppVersion(String str) {
        return m30991a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return m30991a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return m30991a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return m30991a(11, str);
    }

    public boolean setNativeIsAppForeground(boolean z) {
        return m30991a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return m30991a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (!C7226an.m31142a(e)) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
