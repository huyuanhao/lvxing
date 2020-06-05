package com.alibaba.wireless.security.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.wireless.security.framework.utils.C1347a;
import com.alibaba.wireless.security.framework.utils.C1348b;
import com.alibaba.wireless.security.framework.utils.C1349c;
import com.alibaba.wireless.security.framework.utils.C1350d;
import com.alibaba.wireless.security.framework.utils.C1352f;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.p084e.C1365e;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.mid.sotrage.StorageInterface;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.alibaba.wireless.security.framework.h */
public class C1343h implements C1338c {
    /* renamed from: n */
    private static String[] f3493n = {"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};
    /* renamed from: o */
    private static String f3494o = null;
    /* renamed from: p */
    private static volatile boolean f3495p = true;
    /* renamed from: a */
    HashMap<Class, Object> f3496a = new HashMap<>();
    /* renamed from: b */
    C1350d f3497b = null;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Context f3498c;
    /* renamed from: d */
    private final HashMap<String, C1342g> f3499d = new HashMap<>();
    /* renamed from: e */
    private C1336a f3500e = null;
    /* renamed from: f */
    private boolean f3501f = true;
    /* renamed from: g */
    private String f3502g = null;
    /* renamed from: h */
    private String f3503h = null;
    /* renamed from: i */
    private C1341f f3504i = null;
    /* renamed from: j */
    private boolean f3505j = false;
    /* renamed from: k */
    private File f3506k = null;
    /* renamed from: l */
    private File f3507l = null;
    /* renamed from: m */
    private File f3508m = null;

    /* renamed from: com.alibaba.wireless.security.framework.h$a */
    private static class C1346a {
        /* renamed from: a */
        File f3515a;
        /* renamed from: b */
        File f3516b;
        /* renamed from: c */
        File f3517c;
        /* renamed from: d */
        boolean f3518d;

        public C1346a(File file, File file2, File file3, boolean z) {
            this.f3515a = file;
            this.f3516b = file2;
            this.f3517c = file3;
            this.f3518d = z;
        }
    }

    /* renamed from: a */
    private int m3933a(String str, String str2) {
        String str3 = "\\.";
        String[] split = str.split(str3);
        String[] split2 = str2.split(str3);
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i = 0; i < length; i++) {
            int parseInt = Integer.parseInt(split[i]);
            int parseInt2 = Integer.parseInt(split2[i]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private PackageInfo m3935a(String str, C1346a aVar, String str2) throws SecException {
        PackageInfo packageInfo;
        String str3 = "";
        try {
            packageInfo = this.f3498c.getPackageManager().getPackageArchiveInfo(aVar.f3515a.getAbsolutePath(), 133);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(th);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(aVar.f3515a.getAbsolutePath());
            sb3.append(str3);
            m3943a(100043, 199, "getPackageArchiveInfo failed", sb2, m3966d(sb3.toString()), aVar.f3517c != null ? m3966d(aVar.f3517c.getAbsolutePath()) : str3, str2);
            if (aVar.f3515a.exists() && !m3955b(aVar.f3515a)) {
                aVar.f3515a.delete();
            }
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append("[");
        sb4.append(str2);
        sb4.append("]");
        String sb5 = sb4.toString();
        String d = m3966d(aVar.f3515a.getAbsolutePath());
        if (aVar.f3517c != null) {
            str3 = m3966d(aVar.f3517c.getAbsolutePath());
        }
        m3943a(100043, 199, "packageInfo == null", sb5, d, str3, m3965d());
        throw new SecException(199);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0503, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0504, code lost:
            r1 = r0;
            r22 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x050b, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x050c, code lost:
            r25 = r8;
            r3 = r10;
            r10 = r5;
            r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0533, code lost:
            r5 = "";
            r6 = r13.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0542, code lost:
            if (r43.length() == 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0545, code lost:
            r1 = new java.lang.StringBuilder();
            r1.append(r12);
            r1.append(r15);
            r1.append(r8);
            r8 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x055a, code lost:
            if (r11.f3517c != null) goto L_0x055c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x055c, code lost:
            r1 = new java.lang.StringBuilder();
            r1.append(r3);
            r1.append(m3966d(r11.f3517c.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0572, code lost:
            r1 = new java.lang.StringBuilder();
            r1.append(r25);
            r1.append(m3966d(r11.f3515a.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0589, code lost:
            r14 = r7;
            m3943a(100043, 103, r5, r6, r8, r1.toString(), m3966d(r7.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x05a4, code lost:
            if (r11.f3518d == false) goto L_0x05a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x05a6, code lost:
            r9.f3497b.mo11862a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x05af, code lost:
            if (r14.exists() != false) goto L_0x05b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x05b1, code lost:
            r14.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x05b6, code lost:
            if (r11.f3518d == false) goto L_0x05b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x05b8, code lost:
            r9.f3497b.mo11863b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x05ca, code lost:
            r14 = r7;
            r5 = r13.toString();
            r1 = new java.lang.StringBuilder();
            r1.append("soName=");
            r1.append(r10);
            r1.append(", authCode=");
            r1.append(r9.f3503h);
            r1.append(", errorCode=");
            r1.append(r13.getErrorCode());
            m3943a(100043, 199, "native exception occurred", r5, r1.toString(), m3966d(r11.f3515a.getAbsolutePath()), m3966d(r14.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0615, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0616, code lost:
            r1 = r0;
            r22 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x061f, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0620, code lost:
            r2 = r29;
            r1 = r0;
            r22 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0503 A[ExcHandler: InstantiationException (r0v7 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:123:0x0428] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x050b A[ExcHandler: SecException (e com.alibaba.wireless.security.open.SecException), Splitter:B:120:0x0422] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0533 A[Catch:{ SecException -> 0x0629, all -> 0x05be, all -> 0x0692 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x05ca A[Catch:{ SecException -> 0x0629, all -> 0x05be, all -> 0x0692 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0615 A[Catch:{ SecException -> 0x0629, all -> 0x05be, all -> 0x0692 }, ExcHandler: IllegalAccessException (r0v3 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:120:0x0422] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bc A[SYNTHETIC, Splitter:B:39:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f3 A[Catch:{ SecException -> 0x0629, all -> 0x05be, all -> 0x0692 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0113 A[Catch:{ SecException -> 0x0629, all -> 0x05be, all -> 0x0692 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ca A[SYNTHETIC, Splitter:B:61:0x01ca] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0252 A[SYNTHETIC, Splitter:B:78:0x0252] */
    /* renamed from: a */
    private com.alibaba.wireless.security.framework.C1342g m3936a(java.lang.String r40, com.alibaba.wireless.security.framework.C1343h.C1346a r41, android.content.Context r42, java.lang.String r43) throws com.alibaba.wireless.security.open.SecException {
        /*
        r39 = this;
        r9 = r39
        r10 = r40
        r11 = r41
        r12 = r43
        java.io.File r1 = r11.f3515a
        java.lang.String r13 = r1.getAbsolutePath()
        java.io.File r1 = r11.f3516b
        java.lang.String r14 = r1.getAbsolutePath()
        r15 = 0
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r15)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r14)
        java.lang.String r3 = java.io.File.separator
        r2.append(r3)
        r2.append(r10)
        java.lang.String r3 = "_"
        r2.append(r3)
        java.io.File r3 = r11.f3515a
        long r3 = r3.lastModified()
        r5 = 1000(0x3e8, double:4.94E-321)
        long r3 = r3 / r5
        r2.append(r3)
        java.lang.String r3 = ".pkgInfo"
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        com.alibaba.wireless.security.framework.e r8 = new com.alibaba.wireless.security.framework.e
        r8.m41948init(r2)
        r16 = 0
        boolean r2 = r8.mo11848a()     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = "thirdpartyso"
        java.lang.String r4 = "pluginclass"
        java.lang.String r5 = "hasso"
        java.lang.String r6 = "dependencies"
        r18 = 1
        r19 = 0
        if (r2 == 0) goto L_0x00b0
        android.content.Context r2 = r9.f3498c     // Catch:{ all -> 0x0692 }
        boolean r2 = com.alibaba.wireless.security.framework.utils.C1352f.m3990a(r2)     // Catch:{ all -> 0x0692 }
        if (r2 != 0) goto L_0x00b0
        org.json.JSONObject r2 = r8.mo11850b()     // Catch:{ JSONException -> 0x00a6, Exception -> 0x009f }
        java.lang.String r7 = "version"
        java.lang.String r7 = r2.getString(r7)     // Catch:{ JSONException -> 0x00a6, Exception -> 0x009f }
        java.lang.String r20 = r2.getString(r6)     // Catch:{ JSONException -> 0x009a, Exception -> 0x0095 }
        java.lang.String r21 = r2.getString(r5)     // Catch:{ JSONException -> 0x0090, Exception -> 0x008d }
        boolean r21 = java.lang.Boolean.parseBoolean(r21)     // Catch:{ JSONException -> 0x0090, Exception -> 0x008d }
        java.lang.Boolean r21 = java.lang.Boolean.valueOf(r21)     // Catch:{ JSONException -> 0x0090, Exception -> 0x008d }
        java.lang.String r22 = r2.getString(r4)     // Catch:{ Exception | JSONException -> 0x0092 }
        boolean r2 = r2.getBoolean(r3)     // Catch:{ Exception | JSONException -> 0x00ae }
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception | JSONException -> 0x00ae }
        r2 = r1
        r1 = 1
        goto L_0x00ba
    L_0x008d:
        r21 = r1
        goto L_0x0092
    L_0x0090:
        r21 = r1
    L_0x0092:
        r22 = r19
        goto L_0x00ae
    L_0x0095:
        r21 = r1
        r20 = r19
        goto L_0x00ac
    L_0x009a:
        r21 = r1
        r20 = r19
        goto L_0x00ac
    L_0x009f:
        r21 = r1
        r7 = r19
        r20 = r7
        goto L_0x00ac
    L_0x00a6:
        r21 = r1
        r7 = r19
        r20 = r7
    L_0x00ac:
        r22 = r20
    L_0x00ae:
        r2 = r1
        goto L_0x00b9
    L_0x00b0:
        r2 = r1
        r21 = r2
        r7 = r19
        r20 = r7
        r22 = r20
    L_0x00b9:
        r1 = 0
    L_0x00ba:
        if (r1 != 0) goto L_0x00f3
        android.content.pm.PackageInfo r1 = r9.m3935a(r10, r11, r12)     // Catch:{ all -> 0x0692 }
        java.lang.String r7 = r1.versionName     // Catch:{ all -> 0x0692 }
        android.content.pm.ApplicationInfo r2 = r1.applicationInfo     // Catch:{ all -> 0x0692 }
        android.os.Bundle r2 = r2.metaData     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = r2.getString(r6)     // Catch:{ all -> 0x0692 }
        android.content.pm.ApplicationInfo r6 = r1.applicationInfo     // Catch:{ all -> 0x0692 }
        android.os.Bundle r6 = r6.metaData     // Catch:{ all -> 0x0692 }
        boolean r5 = r6.getBoolean(r5, r15)     // Catch:{ all -> 0x0692 }
        java.lang.Boolean r21 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0692 }
        android.content.pm.ApplicationInfo r5 = r1.applicationInfo     // Catch:{ all -> 0x0692 }
        android.os.Bundle r5 = r5.metaData     // Catch:{ all -> 0x0692 }
        java.lang.String r22 = r5.getString(r4)     // Catch:{ all -> 0x0692 }
        android.content.pm.ApplicationInfo r4 = r1.applicationInfo     // Catch:{ all -> 0x0692 }
        android.os.Bundle r4 = r4.metaData     // Catch:{ all -> 0x0692 }
        boolean r3 = r4.getBoolean(r3, r15)     // Catch:{ all -> 0x0692 }
        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0692 }
        r8.f3473a = r1     // Catch:{ all -> 0x0692 }
        r8.mo11849a(r1, r10)     // Catch:{ all -> 0x0692 }
        r6 = r2
        r20 = r3
        goto L_0x00f7
    L_0x00f3:
        r6 = r20
        r20 = r2
    L_0x00f7:
        android.content.Context r1 = r9.f3498c     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = "com.eg.android.AlipayGphone"
        boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = "("
        java.lang.String r4 = ""
        if (r1 == 0) goto L_0x0199
        if (r7 == 0) goto L_0x0199
        java.lang.String r1 = "6.4.3448869"
        boolean r1 = r7.contains(r1)     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x0199
        r2 = 100088(0x186f8, float:1.40253E-40)
        java.lang.String r23 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0692 }
        java.io.File r1 = r11.f3517c     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x0125
        java.io.File r1 = r11.f3517c     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        r24 = r1
        goto L_0x0127
    L_0x0125:
        r24 = r4
    L_0x0127:
        java.lang.Class<com.alibaba.wireless.security.framework.h> r1 = com.alibaba.wireless.security.framework.C1343h.class
        java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ all -> 0x0692 }
        java.lang.String r25 = r1.toString()     // Catch:{ all -> 0x0692 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r13)     // Catch:{ all -> 0x0692 }
        r1.append(r5)     // Catch:{ all -> 0x0692 }
        java.io.File r15 = r11.f3515a     // Catch:{ all -> 0x0692 }
        r26 = r4
        long r3 = r15.getTotalSpace()     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = "),"
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        r1.append(r14)     // Catch:{ all -> 0x0692 }
        java.lang.String r15 = r1.toString()     // Catch:{ all -> 0x0692 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        android.content.Context r3 = r9.f3498c     // Catch:{ all -> 0x0692 }
        android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r3.sourceDir     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = ","
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0692 }
        android.content.Context r4 = r9.f3498c     // Catch:{ all -> 0x0692 }
        android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()     // Catch:{ all -> 0x0692 }
        java.lang.String r4 = r4.sourceDir     // Catch:{ all -> 0x0692 }
        r3.<init>(r4)     // Catch:{ all -> 0x0692 }
        long r3 = r3.lastModified()     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        java.lang.String r28 = r1.toString()     // Catch:{ all -> 0x0692 }
        r1 = r39
        r3 = 2
        r29 = r26
        r4 = r23
        r30 = r5
        r5 = r24
        r31 = r6
        r6 = r25
        r32 = r7
        r7 = r15
        r15 = r8
        r8 = r28
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0692 }
        goto L_0x01a2
    L_0x0199:
        r29 = r4
        r30 = r5
        r31 = r6
        r32 = r7
        r15 = r8
    L_0x01a2:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        r2 = r30
        r1.append(r2)     // Catch:{ all -> 0x0692 }
        r8 = r32
        r1.append(r8)     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = ")"
        r1.append(r2)     // Catch:{ all -> 0x0692 }
        java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0692 }
        int r1 = r43.length()     // Catch:{ all -> 0x0692 }
        java.lang.String r6 = "->"
        if (r1 != 0) goto L_0x01ca
        r1 = r7
    L_0x01c6:
        r5 = r31
        r2 = 0
        goto L_0x01dd
    L_0x01ca:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r12)     // Catch:{ all -> 0x0692 }
        r1.append(r6)     // Catch:{ all -> 0x0692 }
        r1.append(r7)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        goto L_0x01c6
    L_0x01dd:
        boolean r1 = r9.m3950a(r5, r1, r2)     // Catch:{ all -> 0x0692 }
        r4 = 199(0xc7, float:2.79E-43)
        java.lang.String r3 = "src:"
        java.lang.String r2 = "zipfile:"
        if (r1 != 0) goto L_0x0252
        r8 = 100043(0x186cb, float:1.4019E-40)
        r10 = 199(0xc7, float:2.79E-43)
        java.lang.String r13 = "loadRequirements failed"
        int r1 = r43.length()     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x01f8
        r6 = r7
        goto L_0x020b
    L_0x01f8:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r12)     // Catch:{ all -> 0x0692 }
        r1.append(r6)     // Catch:{ all -> 0x0692 }
        r1.append(r7)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r6 = r1
    L_0x020b:
        java.io.File r1 = r11.f3517c     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x0225
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        java.io.File r2 = r11.f3517c     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = r9.m3966d(r2)     // Catch:{ all -> 0x0692 }
        r1.append(r2)     // Catch:{ all -> 0x0692 }
        goto L_0x023a
    L_0x0225:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r2)     // Catch:{ all -> 0x0692 }
        java.io.File r2 = r11.f3515a     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = r9.m3966d(r2)     // Catch:{ all -> 0x0692 }
        r1.append(r2)     // Catch:{ all -> 0x0692 }
    L_0x023a:
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r7 = r1
        java.lang.String r11 = ""
        r1 = r39
        r2 = r8
        r3 = r10
        r10 = 199(0xc7, float:2.79E-43)
        r4 = r13
        r8 = r11
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0692 }
        com.alibaba.wireless.security.open.SecException r1 = new com.alibaba.wireless.security.open.SecException     // Catch:{ all -> 0x0692 }
        r1.m41973init(r10)     // Catch:{ all -> 0x0692 }
        throw r1     // Catch:{ all -> 0x0692 }
    L_0x0252:
        r9.m3957b(r10, r8)     // Catch:{ SecException -> 0x0629 }
        boolean r1 = r21.booleanValue()     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x031d
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        java.lang.String r4 = "libsg"
        r1.append(r4)     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.lang.String r4 = "so-"
        r1.append(r4)     // Catch:{ all -> 0x0692 }
        r1.append(r8)     // Catch:{ all -> 0x0692 }
        java.lang.String r4 = ".so"
        r1.append(r4)     // Catch:{ all -> 0x0692 }
        java.lang.String r24 = r1.toString()     // Catch:{ all -> 0x0692 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        java.lang.String r4 = "sg"
        r1.append(r4)     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.lang.String r4 = "so-"
        r1.append(r4)     // Catch:{ all -> 0x0692 }
        r1.append(r8)     // Catch:{ all -> 0x0692 }
        java.lang.String r25 = r1.toString()     // Catch:{ all -> 0x0692 }
        java.io.File r4 = r11.f3517c     // Catch:{ all -> 0x0692 }
        boolean r1 = r11.f3518d     // Catch:{ all -> 0x0692 }
        r26 = r1
        r1 = r39
        r32 = r8
        r8 = r2
        r2 = r13
        r10 = r3
        r3 = r14
        r27 = r15
        r15 = 199(0xc7, float:2.79E-43)
        r23 = r5
        r5 = r24
        r15 = r6
        r6 = r26
        boolean r1 = r1.m3949a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x0318
        r2 = 100043(0x186cb, float:1.4019E-40)
        r3 = 107(0x6b, float:1.5E-43)
        java.lang.String r4 = ""
        int r1 = r43.length()     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x02c0
        r6 = r7
        goto L_0x02d3
    L_0x02c0:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r12)     // Catch:{ all -> 0x0692 }
        r1.append(r15)     // Catch:{ all -> 0x0692 }
        r1.append(r7)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r6 = r1
    L_0x02d3:
        java.io.File r1 = r11.f3517c     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x02ed
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.io.File r5 = r11.f3517c     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = r9.m3966d(r5)     // Catch:{ all -> 0x0692 }
        r1.append(r5)     // Catch:{ all -> 0x0692 }
        goto L_0x0302
    L_0x02ed:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r8)     // Catch:{ all -> 0x0692 }
        java.io.File r5 = r11.f3515a     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = r9.m3966d(r5)     // Catch:{ all -> 0x0692 }
        r1.append(r5)     // Catch:{ all -> 0x0692 }
    L_0x0302:
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r7 = r1
        java.lang.String r8 = ""
        r1 = r39
        r5 = r23
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0692 }
        com.alibaba.wireless.security.open.SecException r1 = new com.alibaba.wireless.security.open.SecException     // Catch:{ all -> 0x0692 }
        r2 = 107(0x6b, float:1.5E-43)
        r1.m41973init(r2)     // Catch:{ all -> 0x0692 }
        throw r1     // Catch:{ all -> 0x0692 }
    L_0x0318:
        r5 = r24
        r6 = r25
        goto L_0x0329
    L_0x031d:
        r10 = r3
        r23 = r5
        r32 = r8
        r27 = r15
        r8 = r2
        r15 = r6
        r5 = r29
        r6 = r5
    L_0x0329:
        if (r22 != 0) goto L_0x0392
        r2 = 100043(0x186cb, float:1.4019E-40)
        r3 = 199(0xc7, float:2.79E-43)
        java.lang.String r4 = "miss pluginclass"
        int r1 = r43.length()     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x033a
        r6 = r7
        goto L_0x034d
    L_0x033a:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r12)     // Catch:{ all -> 0x0692 }
        r1.append(r15)     // Catch:{ all -> 0x0692 }
        r1.append(r7)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r6 = r1
    L_0x034d:
        java.io.File r1 = r11.f3517c     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x0367
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.io.File r5 = r11.f3517c     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = r9.m3966d(r5)     // Catch:{ all -> 0x0692 }
        r1.append(r5)     // Catch:{ all -> 0x0692 }
        goto L_0x037c
    L_0x0367:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r8)     // Catch:{ all -> 0x0692 }
        java.io.File r5 = r11.f3515a     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r5 = r9.m3966d(r5)     // Catch:{ all -> 0x0692 }
        r1.append(r5)     // Catch:{ all -> 0x0692 }
    L_0x037c:
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r7 = r1
        java.lang.String r8 = ""
        r1 = r39
        r5 = r23
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0692 }
        com.alibaba.wireless.security.open.SecException r1 = new com.alibaba.wireless.security.open.SecException     // Catch:{ all -> 0x0692 }
        r2 = 199(0xc7, float:2.79E-43)
        r1.m41973init(r2)     // Catch:{ all -> 0x0692 }
        throw r1     // Catch:{ all -> 0x0692 }
    L_0x0392:
        java.lang.String r4 = r22.trim()     // Catch:{ all -> 0x0692 }
        boolean r1 = r11.f3518d     // Catch:{ all -> 0x0692 }
        java.lang.ClassLoader r3 = r9.m3952b(r13, r14, r1)     // Catch:{ all -> 0x0692 }
        java.lang.Class r1 = r9.m3942a(r3, r4)     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x0422
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = "load "
        r1.append(r2)     // Catch:{ all -> 0x0692 }
        r1.append(r4)     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = " failed from plugin "
        r1.append(r2)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        com.alibaba.wireless.security.framework.utils.C1348b.m3980b(r1)     // Catch:{ all -> 0x0692 }
        r2 = 100043(0x186cb, float:1.4019E-40)
        r3 = 199(0xc7, float:2.79E-43)
        java.lang.String r5 = "clazz == null"
        int r1 = r43.length()     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x03ca
        r6 = r7
        goto L_0x03dd
    L_0x03ca:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r12)     // Catch:{ all -> 0x0692 }
        r1.append(r15)     // Catch:{ all -> 0x0692 }
        r1.append(r7)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r6 = r1
    L_0x03dd:
        java.io.File r1 = r11.f3517c     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x03f7
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.io.File r7 = r11.f3517c     // Catch:{ all -> 0x0692 }
        java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r7 = r9.m3966d(r7)     // Catch:{ all -> 0x0692 }
        r1.append(r7)     // Catch:{ all -> 0x0692 }
        goto L_0x040c
    L_0x03f7:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r8)     // Catch:{ all -> 0x0692 }
        java.io.File r7 = r11.f3515a     // Catch:{ all -> 0x0692 }
        java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r7 = r9.m3966d(r7)     // Catch:{ all -> 0x0692 }
        r1.append(r7)     // Catch:{ all -> 0x0692 }
    L_0x040c:
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r7 = r1
        r1 = r39
        r8 = r4
        r4 = r5
        r5 = r23
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0692 }
        com.alibaba.wireless.security.open.SecException r1 = new com.alibaba.wireless.security.open.SecException     // Catch:{ all -> 0x0692 }
        r2 = 199(0xc7, float:2.79E-43)
        r1.m41973init(r2)     // Catch:{ all -> 0x0692 }
        throw r1     // Catch:{ all -> 0x0692 }
    L_0x0422:
        java.lang.Object r1 = r1.newInstance()     // Catch:{ InstantiationException -> 0x061f, IllegalAccessException -> 0x0615, SecException -> 0x050b }
        r33 = r1
        com.alibaba.wireless.security.open.e.b r33 = (com.alibaba.wireless.security.open.p084e.C1362b) r33     // Catch:{ InstantiationException -> 0x0503, IllegalAccessException -> 0x0615, SecException -> 0x050b }
        com.alibaba.wireless.security.framework.g r22 = new com.alibaba.wireless.security.framework.g     // Catch:{ InstantiationException -> 0x0503, IllegalAccessException -> 0x0615, SecException -> 0x050b }
        r1 = r22
        r2 = r13
        r13 = r3
        r3 = r39
        r4 = r40
        r24 = r10
        r10 = r5
        r5 = r13
        r23 = r6
        r6 = r27
        r25 = r8
        r8 = r7
        r7 = r33
        r1.m41951init(r2, r3, r4, r5, r6, r7)     // Catch:{ InstantiationException -> 0x0503, IllegalAccessException -> 0x0615, SecException -> 0x04ff }
        java.lang.String r1 = r39.mo11858a()     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04ff }
        r2 = r40
        r3 = r24
        boolean r1 = r2.equalsIgnoreCase(r1)     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r4 = 2
        if (r1 == 0) goto L_0x04bd
        boolean r1 = r9.f3501f     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        if (r1 == 0) goto L_0x0459
        r1 = 1
        goto L_0x045a
    L_0x0459:
        r1 = 0
    L_0x045a:
        boolean r5 = r9.f3505j     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        if (r5 == 0) goto L_0x0460
        r1 = r1 | 2
    L_0x0460:
        java.lang.String r5 = r9.f3502g     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        if (r5 == 0) goto L_0x046e
        java.lang.String r5 = r9.f3502g     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        int r5 = r5.length()     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        if (r5 <= 0) goto L_0x046e
        r1 = r1 | 4
    L_0x046e:
        android.content.Context r5 = r9.f3498c     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        boolean r5 = com.alibaba.wireless.security.framework.utils.C1352f.m3990a(r5)     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        if (r5 == 0) goto L_0x0478
        r1 = r1 | 8
    L_0x0478:
        android.content.Context r5 = r9.f3498c     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        boolean r5 = com.alibaba.wireless.security.framework.utils.C1352f.m3993b(r5)     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        if (r5 == 0) goto L_0x0482
        r1 = r1 | 16
    L_0x0482:
        com.alibaba.wireless.security.framework.f r5 = r9.f3504i     // Catch:{ Exception -> 0x0491 }
        if (r5 == 0) goto L_0x0491
        com.alibaba.wireless.security.framework.f r5 = r9.f3504i     // Catch:{ Exception -> 0x0491 }
        org.json.JSONObject r5 = r5.mo11852a()     // Catch:{ Exception -> 0x0491 }
        java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0491 }
        goto L_0x0493
    L_0x0491:
        r5 = r29
    L_0x0493:
        r35 = 0
        r6 = 4
        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r7 = 0
        r6[r7] = r1     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r6[r18] = r5     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        java.io.File r1 = r9.f3507l     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r6[r4] = r1     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r1 = 3
        java.lang.String r5 = r9.f3503h     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r6[r1] = r5     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r34 = r42
        r36 = r22
        r37 = r23
        r38 = r6
        com.alibaba.wireless.security.framework.a r1 = r33.mo11888a(r34, r35, r36, r37, r38)     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r9.f3500e = r1     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        goto L_0x04d1
    L_0x04bd:
        com.alibaba.wireless.security.framework.C1339d.f3472a = r16     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        com.alibaba.wireless.security.framework.a r1 = r9.f3500e     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r5 = 0
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r34 = r42
        r35 = r1
        r36 = r22
        r37 = r23
        r38 = r6
        r33.mo11888a(r34, r35, r36, r37, r38)     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
    L_0x04d1:
        boolean r1 = r21.booleanValue()     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        if (r1 == 0) goto L_0x0626
        boolean r1 = r20.booleanValue()     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        if (r1 != 0) goto L_0x0626
        r1 = r23
        java.lang.String r1 = com.alibaba.wireless.security.framework.utils.C1352f.m3987a(r13, r1)     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        com.alibaba.wireless.security.framework.a r5 = r9.f3500e     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r6 = 10102(0x2776, float:1.4156E-41)
        r7 = 3
        java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r13 = 0
        r7[r13] = r2     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r7[r18] = r32     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r7[r4] = r1     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        r5.mo11842a(r6, r7)     // Catch:{ InstantiationException -> 0x04fc, IllegalAccessException -> 0x04f8, SecException -> 0x04f6 }
        goto L_0x0626
    L_0x04f6:
        r0 = move-exception
        goto L_0x0511
    L_0x04f8:
        r0 = move-exception
        r1 = r0
        goto L_0x0619
    L_0x04fc:
        r0 = move-exception
        r1 = r0
        goto L_0x0507
    L_0x04ff:
        r0 = move-exception
        r3 = r24
        goto L_0x0511
    L_0x0503:
        r0 = move-exception
        r1 = r0
        r22 = r19
    L_0x0507:
        r2 = r29
        goto L_0x061b
    L_0x050b:
        r0 = move-exception
        r25 = r8
        r3 = r10
        r10 = r5
        r8 = r7
    L_0x0511:
        r13 = r0
        java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0692 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r14)     // Catch:{ all -> 0x0692 }
        java.lang.String r2 = java.io.File.separator     // Catch:{ all -> 0x0692 }
        r1.append(r2)     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r7.<init>(r1)     // Catch:{ all -> 0x0692 }
        int r1 = r13.getErrorCode()     // Catch:{ all -> 0x0692 }
        r2 = 103(0x67, float:1.44E-43)
        if (r1 != r2) goto L_0x05ca
        r2 = 100043(0x186cb, float:1.4019E-40)
        r4 = 103(0x67, float:1.44E-43)
        java.lang.String r5 = ""
        java.lang.String r6 = r13.toString()     // Catch:{ all -> 0x0692 }
        int r1 = r43.length()     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x0545
        goto L_0x0558
    L_0x0545:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r12)     // Catch:{ all -> 0x0692 }
        r1.append(r15)     // Catch:{ all -> 0x0692 }
        r1.append(r8)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r8 = r1
    L_0x0558:
        java.io.File r1 = r11.f3517c     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x0572
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        java.io.File r3 = r11.f3517c     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r9.m3966d(r3)     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        goto L_0x0589
    L_0x0572:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r10 = r25
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.io.File r3 = r11.f3515a     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r9.m3966d(r3)     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
    L_0x0589:
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r10 = r1
        java.lang.String r1 = r7.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r12 = r9.m3966d(r1)     // Catch:{ all -> 0x0692 }
        r1 = r39
        r3 = r4
        r4 = r5
        r5 = r6
        r6 = r8
        r14 = r7
        r7 = r10
        r8 = r12
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0692 }
        boolean r1 = r11.f3518d     // Catch:{ all -> 0x05be }
        if (r1 != 0) goto L_0x05ab
        com.alibaba.wireless.security.framework.utils.d r1 = r9.f3497b     // Catch:{ all -> 0x05be }
        r1.mo11862a()     // Catch:{ all -> 0x05be }
    L_0x05ab:
        boolean r1 = r14.exists()     // Catch:{ all -> 0x05be }
        if (r1 == 0) goto L_0x05b4
        r14.delete()     // Catch:{ all -> 0x05be }
    L_0x05b4:
        boolean r1 = r11.f3518d     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x0614
        com.alibaba.wireless.security.framework.utils.d r1 = r9.f3497b     // Catch:{ all -> 0x0692 }
        r1.mo11863b()     // Catch:{ all -> 0x0692 }
        goto L_0x0614
    L_0x05be:
        r0 = move-exception
        r1 = r0
        boolean r2 = r11.f3518d     // Catch:{ all -> 0x0692 }
        if (r2 != 0) goto L_0x05c9
        com.alibaba.wireless.security.framework.utils.d r2 = r9.f3497b     // Catch:{ all -> 0x0692 }
        r2.mo11863b()     // Catch:{ all -> 0x0692 }
    L_0x05c9:
        throw r1     // Catch:{ all -> 0x0692 }
    L_0x05ca:
        r14 = r7
        r2 = 100043(0x186cb, float:1.4019E-40)
        r3 = 199(0xc7, float:2.79E-43)
        java.lang.String r4 = "native exception occurred"
        java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x0692 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        java.lang.String r6 = "soName="
        r1.append(r6)     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.lang.String r6 = ", authCode="
        r1.append(r6)     // Catch:{ all -> 0x0692 }
        java.lang.String r6 = r9.f3503h     // Catch:{ all -> 0x0692 }
        r1.append(r6)     // Catch:{ all -> 0x0692 }
        java.lang.String r6 = ", errorCode="
        r1.append(r6)     // Catch:{ all -> 0x0692 }
        int r6 = r13.getErrorCode()     // Catch:{ all -> 0x0692 }
        r1.append(r6)     // Catch:{ all -> 0x0692 }
        java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0692 }
        java.io.File r1 = r11.f3515a     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r7 = r9.m3966d(r1)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r14.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r8 = r9.m3966d(r1)     // Catch:{ all -> 0x0692 }
        r1 = r39
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0692 }
    L_0x0614:
        throw r13     // Catch:{ all -> 0x0692 }
    L_0x0615:
        r0 = move-exception
        r1 = r0
        r22 = r19
    L_0x0619:
        r2 = r29
    L_0x061b:
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r2, r1)     // Catch:{ all -> 0x0692 }
        goto L_0x0626
    L_0x061f:
        r0 = move-exception
        r2 = r29
        r1 = r0
        r22 = r19
        goto L_0x061b
    L_0x0626:
        com.alibaba.wireless.security.framework.C1339d.f3472a = r16
        return r22
    L_0x0629:
        r0 = move-exception
        r10 = r2
        r23 = r5
        r15 = r6
        r8 = r7
        r13 = r0
        r2 = 100043(0x186cb, float:1.4019E-40)
        r4 = 199(0xc7, float:2.79E-43)
        java.lang.String r5 = "isMeetReverseDependencies failed"
        int r1 = r43.length()     // Catch:{ all -> 0x0692 }
        if (r1 != 0) goto L_0x063f
        r6 = r8
        goto L_0x0652
    L_0x063f:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r12)     // Catch:{ all -> 0x0692 }
        r1.append(r15)     // Catch:{ all -> 0x0692 }
        r1.append(r8)     // Catch:{ all -> 0x0692 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r6 = r1
    L_0x0652:
        java.io.File r1 = r11.f3517c     // Catch:{ all -> 0x0692 }
        if (r1 == 0) goto L_0x066c
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        java.io.File r3 = r11.f3517c     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r9.m3966d(r3)     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
        goto L_0x0681
    L_0x066c:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0692 }
        r1.<init>()     // Catch:{ all -> 0x0692 }
        r1.append(r10)     // Catch:{ all -> 0x0692 }
        java.io.File r3 = r11.f3515a     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0692 }
        java.lang.String r3 = r9.m3966d(r3)     // Catch:{ all -> 0x0692 }
        r1.append(r3)     // Catch:{ all -> 0x0692 }
    L_0x0681:
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0692 }
        r7 = r1
        java.lang.String r8 = ""
        r1 = r39
        r3 = r4
        r4 = r5
        r5 = r23
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0692 }
        throw r13     // Catch:{ all -> 0x0692 }
    L_0x0692:
        r0 = move-exception
        r1 = r0
        com.alibaba.wireless.security.framework.C1339d.f3472a = r16
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1343h.m3936a(java.lang.String, com.alibaba.wireless.security.framework.h$a, android.content.Context, java.lang.String):com.alibaba.wireless.security.framework.g");
    }

    /* renamed from: a */
    private File m3937a(Context context) throws SecException {
        if (context != null) {
            String str = null;
            String str2 = "";
            if (context != null) {
                try {
                    String str3 = context.getApplicationInfo().sourceDir;
                    if (str3 != null) {
                        File file = new File(str3);
                        if (file.exists()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(file.lastModified() / 1000);
                            sb.append(str2);
                            str = sb.toString();
                        }
                    }
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(e);
                    m3943a(100038, 115, "", sb2.toString(), "", "", "");
                    throw new SecException((Throwable) e, 115);
                }
            }
            if (str != null) {
                this.f3507l = context.getDir("SGLib", 0);
                File file2 = this.f3507l;
                if (file2 == null || !file2.exists()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append(this.f3507l);
                    m3943a(100038, 109, "", sb3.toString(), "", "", "");
                    throw new SecException(109);
                }
                String absolutePath = this.f3507l.getAbsolutePath();
                StringBuilder sb4 = new StringBuilder();
                String str4 = "app_";
                sb4.append(str4);
                sb4.append(str);
                File file3 = new File(absolutePath, sb4.toString());
                if (!file3.exists()) {
                    file3.mkdirs();
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                }
                if (f3495p && file3.exists()) {
                    f3495p = false;
                    File file4 = this.f3507l;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str4);
                    sb5.append(str);
                    m3946a(file4, sb5.toString());
                }
                if (file3.exists()) {
                    return file3;
                }
                m3943a(100038, 114, "", "", "", "", "");
                throw new SecException(114);
            }
            throw new SecException(115);
        }
        m3943a(100038, 116, "", "", "", "", "");
        throw new SecException(116);
    }

    /* renamed from: a */
    private File m3938a(Context context, C1341f fVar) {
        if (C1352f.m3990a(context) || fVar == null || fVar.mo11853b() == 0 || fVar.mo11854c() == null || fVar.mo11854c().length() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3506k.getAbsolutePath());
        sb.append(File.separator);
        sb.append("libs");
        sb.append(File.separator);
        sb.append(fVar.mo11853b());
        sb.append(File.separator);
        sb.append(fVar.mo11854c());
        File file = new File(sb.toString());
        if (!file.exists()) {
            return null;
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b A[SYNTHETIC, Splitter:B:30:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0092 A[SYNTHETIC, Splitter:B:36:0x0092] */
    /* renamed from: a */
    private java.io.File m3939a(java.lang.String r13, java.io.File r14) {
        /*
        r12 = this;
        r0 = 0
        android.content.Context r1 = r12.f3498c     // Catch:{ Exception -> 0x000a }
        android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()     // Catch:{ Exception -> 0x000a }
        java.lang.String r1 = r1.sourceDir     // Catch:{ Exception -> 0x000a }
        goto L_0x000b
    L_0x000a:
        r1 = r0
    L_0x000b:
        if (r1 != 0) goto L_0x000e
        return r0
    L_0x000e:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "libsg"
        r2.append(r3)
        r2.append(r13)
        java.lang.String r3 = ".so"
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        java.lang.String r3 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed"
        com.alibaba.wireless.security.framework.utils.C1348b.m3980b(r3)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
        java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x006d, all -> 0x006a }
        r3.<init>(r1)     // Catch:{ IOException -> 0x006d, all -> 0x006a }
        java.lang.String[] r4 = f3493n     // Catch:{ IOException -> 0x0068 }
        int r5 = r4.length     // Catch:{ IOException -> 0x0068 }
        r6 = 0
    L_0x0032:
        if (r6 >= r5) goto L_0x0064
        r7 = r4[r6]     // Catch:{ IOException -> 0x0068 }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0068 }
        r8.<init>()     // Catch:{ IOException -> 0x0068 }
        java.lang.String r9 = "lib"
        r8.append(r9)     // Catch:{ IOException -> 0x0068 }
        java.lang.String r9 = java.io.File.separator     // Catch:{ IOException -> 0x0068 }
        r8.append(r9)     // Catch:{ IOException -> 0x0068 }
        r8.append(r7)     // Catch:{ IOException -> 0x0068 }
        java.lang.String r9 = java.io.File.separator     // Catch:{ IOException -> 0x0068 }
        r8.append(r9)     // Catch:{ IOException -> 0x0068 }
        r8.append(r2)     // Catch:{ IOException -> 0x0068 }
        java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0068 }
        java.util.zip.ZipEntry r9 = r3.getEntry(r8)     // Catch:{ IOException -> 0x0068 }
        if (r9 == 0) goto L_0x0061
        f3494o = r7     // Catch:{ IOException -> 0x0068 }
        java.io.File r0 = r12.m3941a(r13, r14, r3, r8)     // Catch:{ IOException -> 0x0068 }
        goto L_0x0064
    L_0x0061:
        int r6 = r6 + 1
        goto L_0x0032
    L_0x0064:
        r3.close()     // Catch:{ Exception -> 0x0067 }
    L_0x0067:
        return r0
    L_0x0068:
        r14 = move-exception
        goto L_0x006f
    L_0x006a:
        r13 = move-exception
        r3 = r0
        goto L_0x0090
    L_0x006d:
        r14 = move-exception
        r3 = r0
    L_0x006f:
        java.lang.String r2 = "getPluginFile throws exception"
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r2, r14)     // Catch:{ all -> 0x008f }
        r5 = 100047(0x186cf, float:1.40196E-40)
        r6 = 3
        java.lang.String r7 = r14.toString()     // Catch:{ all -> 0x008f }
        java.lang.String r9 = r12.m3966d(r1)     // Catch:{ all -> 0x008f }
        java.lang.String r10 = ""
        java.lang.String r11 = ""
        r4 = r12
        r8 = r13
        r4.m3943a(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x008f }
        if (r3 == 0) goto L_0x008e
        r3.close()     // Catch:{ Exception -> 0x008e }
    L_0x008e:
        return r0
    L_0x008f:
        r13 = move-exception
    L_0x0090:
        if (r3 == 0) goto L_0x0095
        r3.close()     // Catch:{ Exception -> 0x0095 }
    L_0x0095:
        throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1343h.m3939a(java.lang.String, java.io.File):java.io.File");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            if (r1 != null) goto L_0x0014;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    /* renamed from: a */
    private java.io.File m3940a(java.lang.String r11, java.io.File r12, java.lang.String r13, java.lang.String r14) {
        /*
        r10 = this;
        r0 = 0
        if (r13 == 0) goto L_0x0044
        if (r14 != 0) goto L_0x0006
        goto L_0x0044
    L_0x0006:
        java.lang.String r1 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed"
        com.alibaba.wireless.security.framework.utils.C1348b.m3980b(r1)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
        java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x001d, all -> 0x001a }
        r1.<init>(r13)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
        java.io.File r0 = r10.m3941a(r11, r12, r1, r14)     // Catch:{ IOException -> 0x0018 }
    L_0x0014:
        r1.close()     // Catch:{ Exception -> 0x003c }
        goto L_0x003c
    L_0x0018:
        r12 = move-exception
        goto L_0x001f
    L_0x001a:
        r11 = move-exception
        r1 = r0
        goto L_0x003e
    L_0x001d:
        r12 = move-exception
        r1 = r0
    L_0x001f:
        java.lang.String r14 = "getPluginFile throws exception"
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r14, r12)     // Catch:{ all -> 0x003d }
        r3 = 100047(0x186cf, float:1.40196E-40)
        r4 = 3
        java.lang.String r5 = r12.toString()     // Catch:{ all -> 0x003d }
        java.lang.String r7 = r10.m3966d(r13)     // Catch:{ all -> 0x003d }
        java.lang.String r8 = ""
        java.lang.String r9 = ""
        r2 = r10
        r6 = r11
        r2.m3943a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x003d }
        if (r1 == 0) goto L_0x003c
        goto L_0x0014
    L_0x003c:
        return r0
    L_0x003d:
        r11 = move-exception
    L_0x003e:
        if (r1 == 0) goto L_0x0043
        r1.close()     // Catch:{ Exception -> 0x0043 }
    L_0x0043:
        throw r11
    L_0x0044:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1343h.m3940a(java.lang.String, java.io.File, java.lang.String, java.lang.String):java.io.File");
    }

    /* renamed from: a */
    private File m3941a(String str, File file, ZipFile zipFile, String str2) throws IOException {
        if (!(zipFile == null || str2 == null)) {
            ZipEntry entry = zipFile.getEntry(str2);
            if (entry != null && C1349c.m3983a(entry.getName())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Plugin existed  in ");
                sb.append(entry.getName());
                C1348b.m3980b(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("libsg");
                sb2.append(str);
                sb2.append("_inner");
                sb2.append(entry.getTime());
                sb2.append(".zip");
                File file2 = new File(file, sb2.toString());
                if ((!file2.exists() || file2.length() != entry.getSize()) && !C1352f.m3992a(zipFile, entry, file2)) {
                    C1348b.m3980b("Extract failed!!");
                } else {
                    C1348b.m3980b("Extract success");
                    return file2;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r12v1, types: [java.lang.Class<?>] */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r12v4, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    private java.lang.Class<?> m3942a(java.lang.ClassLoader r12, java.lang.String r13) {
        /*
        r11 = this;
        long r0 = java.lang.System.currentTimeMillis()
        r2 = 1
        java.lang.Class r12 = java.lang.Class.forName(r13, r2, r12)     // Catch:{ all -> 0x000a }
        goto L_0x002f
    L_0x000a:
        r2 = move-exception
        r4 = 100042(0x186ca, float:1.40189E-40)
        r5 = 199(0xc7, float:2.79E-43)
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r6 = ""
        r3.append(r6)
        r3.append(r2)
        java.lang.String r7 = r3.toString()
        java.lang.String r9 = r12.toString()
        java.lang.String r6 = "Class.forName failed"
        java.lang.String r10 = ""
        r3 = r11
        r8 = r13
        r3.m3943a(r4, r5, r6, r7, r8, r9, r10)
        r12 = 0
    L_0x002f:
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "    loadClassFromClassLoader( "
        r2.append(r3)
        r2.append(r13)
        java.lang.String r13 = " ) used time: "
        r2.append(r13)
        long r3 = java.lang.System.currentTimeMillis()
        long r3 = r3 - r0
        r2.append(r3)
        java.lang.String r13 = " ms"
        r2.append(r13)
        java.lang.String r13 = r2.toString()
        com.alibaba.wireless.security.framework.utils.C1348b.m3980b(r13)
        return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1343h.m3942a(java.lang.ClassLoader, java.lang.String):java.lang.Class");
    }

    /* renamed from: a */
    private void m3943a(int i, int i2, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int i3 = i;
        sb.append(i);
        C1347a.m3972a(sb.toString(), i2, 0, C1365e.m4022a(), 0, str, str2, str3, str4, str5);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3945a(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String file2 : list) {
                    m3945a(new File(file, file2));
                }
            }
        }
        file.delete();
    }

    /* renamed from: a */
    private void m3946a(final File file, final String str) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (file != null && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length > 0) {
                            int length = listFiles.length;
                            for (int i = 0; i < length; i++) {
                                File file = listFiles[i];
                                if (file.isDirectory() && file.getName().startsWith("app_") && !file.getName().equals(str)) {
                                    C1343h.this.m3945a(file);
                                } else if (file.getName().startsWith("libsg")) {
                                    file.delete();
                                }
                            }
                        }
                    }
                    if (C1343h.this.f3498c != null) {
                        File filesDir = C1343h.this.f3498c.getFilesDir();
                        if (filesDir != null && filesDir.isDirectory()) {
                            File[] listFiles2 = filesDir.listFiles();
                            if (listFiles2 != null && listFiles2.length > 0) {
                                for (File file2 : listFiles2) {
                                    if (file2.getName().startsWith("libsecuritysdk")) {
                                        file2.delete();
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009d, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
            r1 = r0;
            r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a1, code lost:
            r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a2, code lost:
            r3 = r20;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d A[ExcHandler: all (r0v11 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d4 A[SYNTHETIC, Splitter:B:49:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00df A[SYNTHETIC, Splitter:B:54:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f1 A[SYNTHETIC, Splitter:B:63:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fc A[SYNTHETIC, Splitter:B:68:0x00fc] */
    /* renamed from: a */
    private boolean m3948a(java.io.File r20, java.io.File r21) {
        /*
        r19 = this;
        r9 = r19
        r1 = r21
        java.lang.String r10 = ""
        java.io.File r11 = new java.io.File
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r2 = r21.getAbsolutePath()
        r0.append(r2)
        java.lang.String r2 = ".tmp."
        r0.append(r2)
        int r2 = android.os.Process.myPid()
        r0.append(r2)
        java.lang.String r0 = r0.toString()
        r11.<init>(r0)
        r12 = 0
        r2 = 0
        boolean r0 = r11.exists()     // Catch:{ Exception -> 0x00a1, all -> 0x009d }
        if (r0 == 0) goto L_0x0032
        r11.delete()     // Catch:{ Exception -> 0x00a1, all -> 0x009d }
    L_0x0032:
        java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a1, all -> 0x009d }
        r3 = r20
        r0.<init>(r3)     // Catch:{ Exception -> 0x009b, all -> 0x009d }
        java.nio.channels.FileChannel r4 = r0.getChannel()     // Catch:{ Exception -> 0x009b, all -> 0x009d }
        java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
        r0.<init>(r11)     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
        java.nio.channels.FileChannel r5 = r0.getChannel()     // Catch:{ Exception -> 0x0097, all -> 0x0091 }
        r15 = 0
        long r17 = r4.size()     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
        r13 = r5
        r14 = r4
        r13.transferFrom(r14, r15, r17)     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
        r4.close()     // Catch:{ Exception -> 0x008d, all -> 0x0087 }
        r5.close()     // Catch:{ Exception -> 0x0084, all -> 0x0081 }
        long r4 = r11.length()     // Catch:{ Exception -> 0x009b, all -> 0x009d }
        long r6 = r20.length()     // Catch:{ Exception -> 0x009b, all -> 0x009d }
        int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r0 != 0) goto L_0x00e8
        boolean r0 = r21.exists()     // Catch:{ Exception -> 0x009b, all -> 0x009d }
        if (r0 == 0) goto L_0x007b
        long r4 = r21.length()     // Catch:{ Exception -> 0x009b, all -> 0x009d }
        long r6 = r20.length()     // Catch:{ Exception -> 0x009b, all -> 0x009d }
        int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r0 != 0) goto L_0x0078
        r12 = 1
        goto L_0x00e8
    L_0x0078:
        r21.delete()     // Catch:{ Exception -> 0x009b, all -> 0x009d }
    L_0x007b:
        boolean r12 = r11.renameTo(r1)     // Catch:{ Exception -> 0x009b, all -> 0x009d }
        goto L_0x00e8
    L_0x0081:
        r0 = move-exception
        r1 = r0
        goto L_0x008a
    L_0x0084:
        r0 = move-exception
        r13 = r2
        goto L_0x008f
    L_0x0087:
        r0 = move-exception
        r1 = r0
        r2 = r4
    L_0x008a:
        r14 = r5
        goto L_0x00ef
    L_0x008d:
        r0 = move-exception
        r13 = r4
    L_0x008f:
        r14 = r5
        goto L_0x00a6
    L_0x0091:
        r0 = move-exception
        r1 = r0
        r14 = r2
        r2 = r4
        goto L_0x00ef
    L_0x0097:
        r0 = move-exception
        r14 = r2
        r13 = r4
        goto L_0x00a6
    L_0x009b:
        r0 = move-exception
        goto L_0x00a4
    L_0x009d:
        r0 = move-exception
        r1 = r0
        r14 = r2
        goto L_0x00ef
    L_0x00a1:
        r0 = move-exception
        r3 = r20
    L_0x00a4:
        r13 = r2
        r14 = r13
    L_0x00a6:
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r10, r0)     // Catch:{ all -> 0x00ec }
        r2 = 100047(0x186cf, float:1.40196E-40)
        r4 = 2
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ec }
        java.lang.String r3 = r20.getAbsolutePath()     // Catch:{ all -> 0x00ec }
        java.lang.String r5 = r9.m3966d(r3)     // Catch:{ all -> 0x00ec }
        java.lang.String r1 = r21.getAbsolutePath()     // Catch:{ all -> 0x00ec }
        java.lang.String r6 = r9.m3966d(r1)     // Catch:{ all -> 0x00ec }
        java.lang.String r1 = r11.getAbsolutePath()     // Catch:{ all -> 0x00ec }
        java.lang.String r7 = r9.m3966d(r1)     // Catch:{ all -> 0x00ec }
        java.lang.String r8 = ""
        r1 = r19
        r3 = r4
        r4 = r0
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ec }
        if (r13 == 0) goto L_0x00dd
        r13.close()     // Catch:{ Exception -> 0x00d8 }
        goto L_0x00dd
    L_0x00d8:
        r0 = move-exception
        r1 = r0
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r10, r1)
    L_0x00dd:
        if (r14 == 0) goto L_0x00e8
        r14.close()     // Catch:{ Exception -> 0x00e3 }
        goto L_0x00e8
    L_0x00e3:
        r0 = move-exception
        r1 = r0
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r10, r1)
    L_0x00e8:
        r11.delete()
        return r12
    L_0x00ec:
        r0 = move-exception
        r1 = r0
        r2 = r13
    L_0x00ef:
        if (r2 == 0) goto L_0x00fa
        r2.close()     // Catch:{ Exception -> 0x00f5 }
        goto L_0x00fa
    L_0x00f5:
        r0 = move-exception
        r2 = r0
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r10, r2)
    L_0x00fa:
        if (r14 == 0) goto L_0x0105
        r14.close()     // Catch:{ Exception -> 0x0100 }
        goto L_0x0105
    L_0x0100:
        r0 = move-exception
        r2 = r0
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r10, r2)
    L_0x0105:
        r11.delete()
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1343h.m3948a(java.io.File, java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004f, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x005e, code lost:
            return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0075, code lost:
            return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0097 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00a0 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a5 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ae A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00c1 A[SYNTHETIC, Splitter:B:73:0x00c1] */
    /* renamed from: a */
    private synchronized boolean m3949a(java.lang.String r12, java.lang.String r13, java.io.File r14, java.lang.String r15, boolean r16) {
        /*
        r11 = this;
        r9 = r11
        r0 = r15
        monitor-enter(r11)
        android.content.Context r1 = r9.f3498c     // Catch:{ all -> 0x00cf }
        boolean r1 = com.alibaba.wireless.security.framework.utils.C1352f.m3990a(r1)     // Catch:{ all -> 0x00cf }
        r2 = 1
        if (r1 == 0) goto L_0x0014
        int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00cf }
        r3 = 19
        if (r1 <= r3) goto L_0x0014
        monitor-exit(r11)
        return r2
    L_0x0014:
        java.lang.String r1 = r9.f3502g     // Catch:{ all -> 0x00cf }
        if (r1 == 0) goto L_0x001a
        monitor-exit(r11)
        return r2
    L_0x001a:
        if (r14 == 0) goto L_0x0032
        java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00cf }
        java.lang.String r3 = r14.getParent()     // Catch:{ all -> 0x00cf }
        r1.<init>(r3, r15)     // Catch:{ all -> 0x00cf }
        boolean r1 = r1.exists()     // Catch:{ all -> 0x00cf }
        if (r1 == 0) goto L_0x002d
        monitor-exit(r11)
        return r2
    L_0x002d:
        java.lang.String r1 = r14.getAbsolutePath()     // Catch:{ all -> 0x00cf }
        goto L_0x0033
    L_0x0032:
        r1 = r12
    L_0x0033:
        if (r16 != 0) goto L_0x003a
        com.alibaba.wireless.security.framework.utils.d r3 = r9.f3497b     // Catch:{ all -> 0x00cf }
        r3.mo11862a()     // Catch:{ all -> 0x00cf }
    L_0x003a:
        r3 = 0
        java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0082 }
        r5 = r13
        r4.<init>(r13, r15)     // Catch:{ Exception -> 0x0082 }
        boolean r3 = r4.exists()     // Catch:{ Exception -> 0x007e }
        if (r3 == 0) goto L_0x0050
        if (r16 != 0) goto L_0x004e
        com.alibaba.wireless.security.framework.utils.d r0 = r9.f3497b     // Catch:{ all -> 0x00cf }
        r0.mo11863b()     // Catch:{ all -> 0x00cf }
    L_0x004e:
        monitor-exit(r11)
        return r2
    L_0x0050:
        boolean r3 = com.alibaba.wireless.security.framework.utils.C1352f.m3991a(r1, r15, r4)     // Catch:{ Exception -> 0x007e }
        if (r3 == 0) goto L_0x005f
        if (r16 != 0) goto L_0x005d
        com.alibaba.wireless.security.framework.utils.d r0 = r9.f3497b     // Catch:{ all -> 0x00cf }
        r0.mo11863b()     // Catch:{ all -> 0x00cf }
    L_0x005d:
        monitor-exit(r11)
        return r2
    L_0x005f:
        android.content.Context r3 = r9.f3498c     // Catch:{ Exception -> 0x007e }
        android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ Exception -> 0x007e }
        java.lang.String r3 = r3.sourceDir     // Catch:{ Exception -> 0x007e }
        boolean r0 = com.alibaba.wireless.security.framework.utils.C1352f.m3991a(r3, r15, r4)     // Catch:{ Exception -> 0x007e }
        if (r0 == 0) goto L_0x0076
        if (r16 != 0) goto L_0x0074
        com.alibaba.wireless.security.framework.utils.d r0 = r9.f3497b     // Catch:{ all -> 0x00cf }
        r0.mo11863b()     // Catch:{ all -> 0x00cf }
    L_0x0074:
        monitor-exit(r11)
        return r2
    L_0x0076:
        if (r16 != 0) goto L_0x00c4
        com.alibaba.wireless.security.framework.utils.d r0 = r9.f3497b     // Catch:{ all -> 0x00cf }
    L_0x007a:
        r0.mo11863b()     // Catch:{ all -> 0x00cf }
        goto L_0x00c4
    L_0x007e:
        r0 = move-exception
        goto L_0x0084
    L_0x0080:
        r0 = move-exception
        goto L_0x00c7
    L_0x0082:
        r0 = move-exception
        r4 = r3
    L_0x0084:
        r2 = 100039(0x186c7, float:1.40184E-40)
        r3 = 107(0x6b, float:1.5E-43)
        java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x0080 }
        java.lang.String r6 = r11.m3965d()     // Catch:{ all -> 0x0080 }
        java.lang.String r7 = r11.m3966d(r1)     // Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x00a0
        java.lang.String r1 = r4.getAbsolutePath()     // Catch:{ all -> 0x0080 }
        java.lang.String r1 = r11.m3966d(r1)     // Catch:{ all -> 0x0080 }
        goto L_0x00a2
    L_0x00a0:
        java.lang.String r1 = ""
    L_0x00a2:
        r8 = r1
        if (r14 == 0) goto L_0x00ae
        java.lang.String r1 = r14.getAbsolutePath()     // Catch:{ all -> 0x0080 }
        java.lang.String r1 = r11.m3966d(r1)     // Catch:{ all -> 0x0080 }
        goto L_0x00b0
    L_0x00ae:
        java.lang.String r1 = ""
    L_0x00b0:
        r10 = r1
        r1 = r11
        r4 = r5
        r5 = r6
        r6 = r7
        r7 = r8
        r8 = r10
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0080 }
        java.lang.String r1 = ""
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r1, r0)     // Catch:{ all -> 0x0080 }
        if (r16 != 0) goto L_0x00c4
        com.alibaba.wireless.security.framework.utils.d r0 = r9.f3497b     // Catch:{ all -> 0x00cf }
        goto L_0x007a
    L_0x00c4:
        r0 = 0
        monitor-exit(r11)
        return r0
    L_0x00c7:
        if (r16 != 0) goto L_0x00ce
        com.alibaba.wireless.security.framework.utils.d r1 = r9.f3497b     // Catch:{ all -> 0x00cf }
        r1.mo11863b()     // Catch:{ all -> 0x00cf }
    L_0x00ce:
        throw r0     // Catch:{ all -> 0x00cf }
    L_0x00cf:
        r0 = move-exception
        monitor-exit(r11)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1343h.m3949a(java.lang.String, java.lang.String, java.io.File, java.lang.String, boolean):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3950a(String str, String str2, boolean z) throws SecException {
        String str3 = str2;
        boolean z2 = z;
        if (str.trim().length() == 0) {
            return true;
        }
        String[] split = str.split(";");
        char c = 0;
        int i = 0;
        while (i < split.length) {
            String trim = split[i].trim();
            if (trim.length() != 0) {
                String[] split2 = trim.split(":");
                String str4 = "";
                if (split2.length == 2) {
                    int indexOf = str3.indexOf(split2[c]);
                    String str5 = ", depended by: ";
                    String str6 = " is not meet the requirement: ";
                    String str7 = " of ";
                    String str8 = "version ";
                    if (indexOf >= 0) {
                        int indexOf2 = str3.indexOf("(", indexOf);
                        int indexOf3 = str3.indexOf(")", indexOf);
                        if (indexOf2 < 0 || indexOf3 < 0 || indexOf2 > indexOf3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str4);
                            sb.append(indexOf2);
                            String sb2 = sb.toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str4);
                            sb3.append(indexOf3);
                            String sb4 = sb3.toString();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str4);
                            sb5.append(i);
                            m3943a(100040, 199, "indexLeftP < 0 || indexRightP < 0 || indexLeftP > indexRightP", sb2, sb4, "", sb5.toString());
                            throw new SecException(199);
                        }
                        String substring = str3.substring(indexOf2 + 1, indexOf3);
                        if (m3933a(substring, split2[1]) < 0) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str8);
                            sb6.append(substring);
                            sb6.append(str7);
                            sb6.append(split2[0]);
                            sb6.append(str6);
                            sb6.append(split2[1]);
                            String sb7 = sb6.toString();
                            if (str2.length() != 0) {
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append(sb7);
                                sb8.append(str5);
                                sb8.append(str3);
                                sb7 = sb8.toString();
                            }
                            String str9 = sb7;
                            if (!z2) {
                                String str10 = split2[0];
                                String str11 = split2[1];
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append(str4);
                                sb9.append(i);
                                m3943a(100040, 113, "versionCompare(parentPluginVersion, nameVersionPair[1]) < 0", substring, str10, str11, sb9.toString());
                            }
                            throw new SecException(str9, 113);
                        }
                    } else {
                        C1337b bVar = (C1337b) this.f3499d.get(split2[0]);
                        if (bVar == null) {
                            try {
                                bVar = m3963d(split2[0], str3, !z2);
                                th = null;
                            } catch (Throwable th) {
                                th = th;
                            }
                            if (bVar == null) {
                                if (!z2) {
                                    if (th instanceof SecException) {
                                        throw th;
                                    }
                                    StringBuilder sb10 = new StringBuilder();
                                    sb10.append(str4);
                                    sb10.append(th);
                                    String sb11 = sb10.toString();
                                    StringBuilder sb12 = new StringBuilder();
                                    sb12.append(str4);
                                    sb12.append(i);
                                    m3943a(100040, 199, "throwable in loadPluginInner", sb11, str, str2, sb12.toString());
                                    throw new SecException(str3, 199);
                                }
                            }
                        }
                        if (m3933a(bVar.mo11843a(), split2[1]) < 0) {
                            StringBuilder sb13 = new StringBuilder();
                            sb13.append(str8);
                            sb13.append(bVar.mo11843a());
                            sb13.append(str7);
                            sb13.append(split2[0]);
                            sb13.append(str6);
                            sb13.append(split2[1]);
                            String sb14 = sb13.toString();
                            if (str2.length() != 0) {
                                StringBuilder sb15 = new StringBuilder();
                                sb15.append(sb14);
                                sb15.append(str5);
                                sb15.append(str3);
                                sb14 = sb15.toString();
                            }
                            if (!z2) {
                                String a = bVar.mo11843a();
                                String str12 = split2[0];
                                String str13 = split2[1];
                                StringBuilder sb16 = new StringBuilder();
                                sb16.append(str4);
                                sb16.append(i);
                                m3943a(100040, 113, "versionCompare(dependPlugin.getVersion(), nameVersionPair[1]) < 0", a, str12, str13, sb16.toString());
                            }
                            throw new SecException(sb14, 113);
                        }
                    }
                } else {
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append(str4);
                    sb17.append(z2);
                    String sb18 = sb17.toString();
                    StringBuilder sb19 = new StringBuilder();
                    sb19.append(str4);
                    sb19.append(i);
                    m3943a(100040, 199, "nameVersionPair.length != 2", trim, str2, sb18, sb19.toString());
                    throw new SecException(199);
                }
            }
            i++;
            c = 0;
        }
        return true;
    }

    /* renamed from: b */
    private File m3951b(String str) {
        File file = null;
        if (this.f3502g != null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sg");
        sb.append(str);
        String a = C1352f.m3987a(C1343h.class.getClassLoader(), sb.toString());
        if (a != null && a.length() > 0) {
            file = new File(a);
        }
        return file;
    }

    /* renamed from: b */
    private ClassLoader m3952b(String str, String str2, boolean z) {
        Class<C1343h> cls = C1343h.class;
        if (!z) {
            try {
                this.f3497b.mo11862a();
            } catch (Throwable th) {
                if (!z) {
                    this.f3497b.mo11863b();
                }
                throw th;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3498c.getApplicationInfo().nativeLibraryDir);
        sb.append(File.pathSeparator);
        sb.append(str2);
        String sb2 = sb.toString();
        if (this.f3502g != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(File.pathSeparator);
            sb3.append(this.f3502g);
            sb2 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("add path to native classloader ");
            sb4.append(sb2);
            C1348b.m3980b(sb4.toString());
        }
        if (f3494o != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append(File.pathSeparator);
            sb5.append(this.f3498c.getApplicationInfo().sourceDir);
            sb5.append("!/lib/");
            sb5.append(f3494o);
            sb2 = sb5.toString();
        }
        ClassLoader dexClassLoader = (VERSION.SDK_INT < 21 || "6.0.1".equalsIgnoreCase(VERSION.RELEASE)) ? new DexClassLoader(str, str2, sb2, cls.getClassLoader()) : new PathClassLoader(str, sb2, cls.getClassLoader());
        if (!z) {
            this.f3497b.mo11863b();
        }
        return dexClassLoader;
    }

    /* renamed from: b */
    private String m3953b(Class<?> cls) {
        InterfacePluginInfo interfacePluginInfo = (InterfacePluginInfo) cls.getAnnotation(InterfacePluginInfo.class);
        if (interfacePluginInfo == null) {
            return null;
        }
        return interfacePluginInfo.pluginName();
    }

    /* renamed from: b */
    private void m3954b() throws SecException {
        this.f3506k = m3937a(this.f3498c);
        if (this.f3506k != null) {
            Context context = this.f3498c;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3506k);
            sb.append(File.separator);
            sb.append("lock.lock");
            this.f3497b = new C1350d(context, sb.toString());
            this.f3504i = m3958c();
            this.f3508m = m3938a(this.f3498c, this.f3504i);
        }
    }

    /* renamed from: b */
    private boolean m3955b(File file) {
        try {
            return !file.getParentFile().getCanonicalPath().equals(file.getCanonicalFile().getParentFile().getCanonicalPath()) || !file.getName().equals(file.getCanonicalFile().getName());
        } catch (Exception e) {
            C1348b.m3979a("", e);
            m3943a(100047, 0, e.toString(), file.getAbsolutePath(), "", "", "");
            return false;
        }
    }

    /* renamed from: b */
    private boolean m3956b(File file, File file2) {
        Method method;
        try {
            String str = "symlink";
            Object obj = null;
            if (VERSION.SDK_INT >= 21) {
                method = Class.forName("android.system.Os").getDeclaredMethod(str, new Class[]{String.class, String.class});
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                method = obj.getClass().getMethod(str, new Class[]{String.class, String.class});
            }
            method.invoke(obj, new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
            return true;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("create symbolic link( ");
            sb.append(file2.getAbsolutePath());
            sb.append(" -> ");
            sb.append(file.getAbsolutePath());
            sb.append(" ) failed");
            C1348b.m3979a(sb.toString(), e);
            String exc = e.toString();
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = file2.getAbsolutePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(VERSION.SDK_INT);
            m3943a(100047, 1, exc, absolutePath, absolutePath2, sb2.toString(), "");
            return false;
        }
    }

    /* renamed from: b */
    private boolean m3957b(String str, String str2) throws SecException {
        for (Entry entry : this.f3499d.entrySet()) {
            String str3 = (String) entry.getKey();
            C1342g gVar = (C1342g) entry.getValue();
            String a = gVar.mo11856a("reversedependencies");
            if (a != null) {
                String[] split = a.split(";");
                for (int i = 0; i < split.length; i++) {
                    String trim = split[i].trim();
                    if (trim.length() != 0) {
                        String[] split2 = trim.split(":");
                        String str4 = ")";
                        String str5 = "(";
                        if (split2.length != 2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(str5);
                            sb.append(str2);
                            sb.append(str4);
                            String sb2 = sb.toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str3);
                            sb3.append(str5);
                            sb3.append(gVar.mo11843a());
                            sb3.append(str4);
                            m3943a(100041, 199, "nameVersionPair.length != 2", sb2, sb3.toString(), m3966d(gVar.mo11844b()), a);
                            throw new SecException(199);
                        } else if (split2[0].equalsIgnoreCase(str) && m3933a(str2, split2[1]) < 0) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("plugin ");
                            sb4.append(str);
                            sb4.append(str5);
                            sb4.append(str2);
                            sb4.append(") is not meet the reverse dependency of ");
                            sb4.append(str3);
                            sb4.append(str5);
                            sb4.append(gVar.mo11843a());
                            sb4.append("): ");
                            sb4.append(split2[0]);
                            sb4.append(str5);
                            sb4.append(split2[1]);
                            sb4.append(str4);
                            String sb5 = sb4.toString();
                            String obj = C1343h.class.getClassLoader().toString();
                            String d = m3966d(gVar.mo11844b());
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("");
                            sb6.append(i);
                            m3943a(100041, 117, sb5, obj, d, a, sb6.toString());
                            throw new SecException(sb5, 117);
                        }
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* renamed from: c */
    private C1341f m3958c() {
        C1341f fVar;
        File file = new File(this.f3506k, "update.config");
        File file2 = new File(this.f3506k, "init.config");
        if (this.f3505j) {
            fVar = C1341f.m3923a(file);
            if (fVar == null) {
                return C1341f.m3923a(file2);
            }
            try {
                this.f3497b.mo11862a();
                file2.delete();
                file.renameTo(file2);
            } catch (Throwable th) {
                this.f3497b.mo11863b();
                throw th;
            }
        } else {
            try {
                this.f3497b.mo11862a();
                fVar = C1341f.m3923a(file2);
            } catch (Throwable th2) {
                this.f3497b.mo11863b();
                throw th2;
            }
        }
        this.f3497b.mo11863b();
        return fVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[SYNTHETIC, Splitter:B:18:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067 A[Catch:{ all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a A[Catch:{ all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0157 A[Catch:{ all -> 0x0160 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x015b A[Catch:{ all -> 0x0160 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0232  */
    /* renamed from: c */
    private com.alibaba.wireless.security.framework.C1343h.C1346a m3959c(java.lang.String r23, java.lang.String r24, boolean r25) throws com.alibaba.wireless.security.open.SecException {
        /*
        r22 = this;
        r9 = r22
        r0 = r23
        java.lang.String r10 = "!/"
        java.lang.String r11 = ".zip"
        java.io.File r1 = r9.f3508m
        java.lang.String r12 = ".so"
        java.lang.String r14 = "libsg"
        r15 = 0
        if (r1 == 0) goto L_0x003a
        java.io.File r2 = new java.io.File
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r14)
        r3.append(r0)
        r3.append(r12)
        java.lang.String r3 = r3.toString()
        r2.<init>(r1, r3)
        boolean r1 = r2.exists()
        if (r1 == 0) goto L_0x003a
        java.io.File r1 = r9.f3508m
        java.io.File r1 = r9.m3964d(r1)
        java.io.File r3 = r9.f3508m
        if (r1 == r3) goto L_0x003c
        r3 = 1
        goto L_0x003d
    L_0x003a:
        r1 = 0
        r2 = 0
    L_0x003c:
        r3 = 0
    L_0x003d:
        if (r1 != 0) goto L_0x004c
        java.io.File r1 = r9.f3506k
        java.io.File r1 = r9.m3964d(r1)
        java.io.File r3 = r9.f3506k
        if (r1 == r3) goto L_0x004b
        r3 = 1
        goto L_0x004c
    L_0x004b:
        r3 = 0
    L_0x004c:
        r6 = r1
        r7 = r3
        if (r7 != 0) goto L_0x0055
        com.alibaba.wireless.security.framework.utils.d r1 = r9.f3497b
        r1.mo11862a()
    L_0x0055:
        if (r2 != 0) goto L_0x0067
        java.io.File r1 = r22.m3951b(r23)     // Catch:{ all -> 0x0063 }
        boolean r2 = r9.m3961c(r1)     // Catch:{ all -> 0x0063 }
        if (r2 != 0) goto L_0x0068
        r1 = 0
        goto L_0x0068
    L_0x0063:
        r0 = move-exception
        r3 = r7
        goto L_0x0230
    L_0x0067:
        r1 = r2
    L_0x0068:
        if (r1 == 0) goto L_0x0157
        java.lang.String r5 = r1.getAbsolutePath()     // Catch:{ all -> 0x0063 }
        android.content.Context r2 = r9.f3498c     // Catch:{ all -> 0x0063 }
        java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x0063 }
        java.lang.String r3 = "com.eg.android.AlipayGphone"
        boolean r2 = r3.equals(r2)     // Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x00fc
        if (r5 == 0) goto L_0x00fc
        java.lang.String r2 = "app_plugins_lib"
        boolean r2 = r5.contains(r2)     // Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x00fc
        r2 = 100088(0x186f8, float:1.40253E-40)
        java.lang.String r4 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0063 }
        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
        r8.<init>()     // Catch:{ all -> 0x0063 }
        r8.append(r5)     // Catch:{ all -> 0x0063 }
        java.lang.String r13 = "("
        r8.append(r13)     // Catch:{ all -> 0x0063 }
        r16 = r4
        long r3 = r1.getTotalSpace()     // Catch:{ all -> 0x0063 }
        r8.append(r3)     // Catch:{ all -> 0x0063 }
        java.lang.String r1 = ")"
        r8.append(r1)     // Catch:{ all -> 0x0063 }
        java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0063 }
        java.lang.Class<com.alibaba.wireless.security.framework.h> r1 = com.alibaba.wireless.security.framework.C1343h.class
        java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ all -> 0x0063 }
        java.lang.String r17 = r1.toString()     // Catch:{ all -> 0x0063 }
        java.lang.String r18 = r6.getAbsolutePath()     // Catch:{ all -> 0x0063 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
        r1.<init>()     // Catch:{ all -> 0x0063 }
        android.content.Context r3 = r9.f3498c     // Catch:{ all -> 0x0063 }
        android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x0063 }
        java.lang.String r3 = r3.sourceDir     // Catch:{ all -> 0x0063 }
        r1.append(r3)     // Catch:{ all -> 0x0063 }
        java.lang.String r3 = ","
        r1.append(r3)     // Catch:{ all -> 0x0063 }
        java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0063 }
        android.content.Context r4 = r9.f3498c     // Catch:{ all -> 0x0063 }
        android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()     // Catch:{ all -> 0x0063 }
        java.lang.String r4 = r4.sourceDir     // Catch:{ all -> 0x0063 }
        r3.<init>(r4)     // Catch:{ all -> 0x0063 }
        long r3 = r3.lastModified()     // Catch:{ all -> 0x0063 }
        r1.append(r3)     // Catch:{ all -> 0x0063 }
        java.lang.String r19 = r1.toString()     // Catch:{ all -> 0x0063 }
        r1 = r22
        r3 = 1
        r4 = r16
        r13 = r5
        r5 = r8
        r8 = r6
        r6 = r17
        r20 = r7
        r7 = r18
        r21 = r8
        r8 = r19
        r1.m3943a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0160 }
        r1 = 0
        goto L_0x0101
    L_0x00fc:
        r13 = r5
        r21 = r6
        r20 = r7
    L_0x0101:
        if (r1 == 0) goto L_0x0154
        if (r13 == 0) goto L_0x0154
        boolean r2 = r13.contains(r10)     // Catch:{ all -> 0x0160 }
        if (r2 == 0) goto L_0x0154
        r2 = 2
        java.lang.String[] r2 = r13.split(r10, r2)     // Catch:{ all -> 0x0160 }
        r3 = r2[r15]     // Catch:{ all -> 0x0160 }
        r4 = 1
        r2 = r2[r4]     // Catch:{ all -> 0x0160 }
        java.lang.String[] r4 = f3493n     // Catch:{ all -> 0x0160 }
        int r5 = r4.length     // Catch:{ all -> 0x0160 }
    L_0x0118:
        if (r15 >= r5) goto L_0x0154
        r6 = r4[r15]     // Catch:{ all -> 0x0160 }
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
        r7.<init>()     // Catch:{ all -> 0x0160 }
        java.lang.String r8 = "lib"
        r7.append(r8)     // Catch:{ all -> 0x0160 }
        java.lang.String r8 = java.io.File.separator     // Catch:{ all -> 0x0160 }
        r7.append(r8)     // Catch:{ all -> 0x0160 }
        r7.append(r6)     // Catch:{ all -> 0x0160 }
        java.lang.String r8 = java.io.File.separator     // Catch:{ all -> 0x0160 }
        r7.append(r8)     // Catch:{ all -> 0x0160 }
        r7.append(r14)     // Catch:{ all -> 0x0160 }
        r7.append(r0)     // Catch:{ all -> 0x0160 }
        r7.append(r12)     // Catch:{ all -> 0x0160 }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0160 }
        boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x0160 }
        if (r7 == 0) goto L_0x014f
        f3494o = r6     // Catch:{ all -> 0x0160 }
        r6 = r21
        java.io.File r1 = r9.m3940a(r0, r6, r3, r2)     // Catch:{ all -> 0x0160 }
        goto L_0x0159
    L_0x014f:
        r6 = r21
        int r15 = r15 + 1
        goto L_0x0118
    L_0x0154:
        r6 = r21
        goto L_0x0159
    L_0x0157:
        r20 = r7
    L_0x0159:
        if (r1 != 0) goto L_0x0165
        java.io.File r1 = r22.m3960c(r23)     // Catch:{ all -> 0x0160 }
        goto L_0x0165
    L_0x0160:
        r0 = move-exception
        r3 = r20
        goto L_0x0230
    L_0x0165:
        if (r1 != 0) goto L_0x016d
        if (r25 == 0) goto L_0x016d
        java.io.File r1 = r9.m3939a(r0, r6)     // Catch:{ all -> 0x0160 }
    L_0x016d:
        if (r1 != 0) goto L_0x017a
        r3 = r20
        if (r3 != 0) goto L_0x0178
        com.alibaba.wireless.security.framework.utils.d r0 = r9.f3497b
        r0.mo11863b()
    L_0x0178:
        r2 = 0
        return r2
    L_0x017a:
        r3 = r20
        r2 = 0
        java.lang.String r4 = r1.getAbsolutePath()     // Catch:{ all -> 0x022f }
        boolean r4 = r4.endsWith(r11)     // Catch:{ all -> 0x022f }
        if (r4 == 0) goto L_0x018e
        com.alibaba.wireless.security.framework.h$a r8 = new com.alibaba.wireless.security.framework.h$a     // Catch:{ all -> 0x022f }
        r8.m41956init(r1, r6, r2, r3)     // Catch:{ all -> 0x022f }
        goto L_0x0227
    L_0x018e:
        boolean r4 = com.alibaba.wireless.security.framework.utils.C1352f.m3989a()     // Catch:{ all -> 0x022f }
        if (r4 == 0) goto L_0x019b
        com.alibaba.wireless.security.framework.h$a r8 = new com.alibaba.wireless.security.framework.h$a     // Catch:{ all -> 0x022f }
        r8.m41956init(r1, r6, r1, r3)     // Catch:{ all -> 0x022f }
        goto L_0x0227
    L_0x019b:
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x022f }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
        r5.<init>()     // Catch:{ all -> 0x022f }
        r5.append(r14)     // Catch:{ all -> 0x022f }
        r5.append(r0)     // Catch:{ all -> 0x022f }
        java.lang.String r7 = "_"
        r5.append(r7)     // Catch:{ all -> 0x022f }
        long r7 = r1.lastModified()     // Catch:{ all -> 0x022f }
        r5.append(r7)     // Catch:{ all -> 0x022f }
        r5.append(r11)     // Catch:{ all -> 0x022f }
        java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x022f }
        r4.<init>(r6, r5)     // Catch:{ all -> 0x022f }
        boolean r5 = r4.exists()     // Catch:{ all -> 0x022f }
        if (r5 == 0) goto L_0x01d6
        boolean r5 = r9.m3955b(r4)     // Catch:{ all -> 0x022f }
        if (r5 == 0) goto L_0x01d6
        boolean r5 = r9.m3962c(r4, r1)     // Catch:{ all -> 0x022f }
        if (r5 != 0) goto L_0x01d6
        com.alibaba.wireless.security.framework.h$a r8 = new com.alibaba.wireless.security.framework.h$a     // Catch:{ all -> 0x022f }
        r8.m41956init(r4, r6, r1, r3)     // Catch:{ all -> 0x022f }
        goto L_0x0227
    L_0x01d6:
        r4.delete()     // Catch:{ all -> 0x022f }
        boolean r5 = r9.m3956b(r1, r4)     // Catch:{ all -> 0x022f }
        if (r5 == 0) goto L_0x01e5
        com.alibaba.wireless.security.framework.h$a r8 = new com.alibaba.wireless.security.framework.h$a     // Catch:{ all -> 0x022f }
        r8.m41956init(r4, r6, r1, r3)     // Catch:{ all -> 0x022f }
        goto L_0x0227
    L_0x01e5:
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x022f }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x022f }
        r5.<init>()     // Catch:{ all -> 0x022f }
        r5.append(r14)     // Catch:{ all -> 0x022f }
        r5.append(r0)     // Catch:{ all -> 0x022f }
        java.lang.String r0 = "_cp"
        r5.append(r0)     // Catch:{ all -> 0x022f }
        long r7 = r1.lastModified()     // Catch:{ all -> 0x022f }
        r5.append(r7)     // Catch:{ all -> 0x022f }
        r5.append(r11)     // Catch:{ all -> 0x022f }
        java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x022f }
        r4.<init>(r6, r0)     // Catch:{ all -> 0x022f }
        boolean r0 = r4.exists()     // Catch:{ all -> 0x022f }
        if (r0 == 0) goto L_0x021a
        long r7 = r4.length()     // Catch:{ all -> 0x022f }
        long r10 = r1.length()     // Catch:{ all -> 0x022f }
        int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
        if (r0 == 0) goto L_0x0220
    L_0x021a:
        boolean r0 = r9.m3948a(r1, r4)     // Catch:{ all -> 0x022f }
        if (r0 == 0) goto L_0x0226
    L_0x0220:
        com.alibaba.wireless.security.framework.h$a r8 = new com.alibaba.wireless.security.framework.h$a     // Catch:{ all -> 0x022f }
        r8.m41956init(r4, r6, r1, r3)     // Catch:{ all -> 0x022f }
        goto L_0x0227
    L_0x0226:
        r8 = r2
    L_0x0227:
        if (r3 != 0) goto L_0x022e
        com.alibaba.wireless.security.framework.utils.d r0 = r9.f3497b
        r0.mo11863b()
    L_0x022e:
        return r8
    L_0x022f:
        r0 = move-exception
    L_0x0230:
        if (r3 != 0) goto L_0x0237
        com.alibaba.wireless.security.framework.utils.d r1 = r9.f3497b
        r1.mo11863b()
    L_0x0237:
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1343h.m3959c(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.h$a");
    }

    /* renamed from: c */
    private File m3960c(String str) {
        String str2 = this.f3502g;
        if (str2 == null) {
            try {
                str2 = this.f3498c.getApplicationInfo().nativeLibraryDir;
            } catch (Exception unused) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(File.separator);
            sb.append("libsg");
            sb.append(str);
            sb.append(".so");
            File file = new File(sb.toString());
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    /* renamed from: c */
    private boolean m3961c(File file) {
        if (file != null) {
            try {
                String absolutePath = file.getAbsolutePath();
                if (absolutePath != null) {
                    if (absolutePath.length() > 0) {
                        if (C1352f.m3990a(this.f3498c) || !absolutePath.startsWith("/system/")) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r11v1, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    private boolean m3962c(java.io.File r11, java.io.File r12) {
        /*
        r10 = this;
        java.lang.String r0 = r11.getCanonicalPath()     // Catch:{ Exception -> 0x000d }
        java.lang.String r1 = r12.getCanonicalPath()     // Catch:{ Exception -> 0x000d }
        boolean r11 = r0.equals(r1)     // Catch:{ Exception -> 0x000d }
        goto L_0x002c
    L_0x000d:
        r0 = move-exception
        java.lang.String r1 = ""
        com.alibaba.wireless.security.framework.utils.C1348b.m3979a(r1, r0)
        r3 = 100046(0x186ce, float:1.40194E-40)
        r4 = 0
        java.lang.String r5 = r0.toString()
        java.lang.String r6 = r11.getAbsolutePath()
        java.lang.String r7 = r12.getAbsolutePath()
        java.lang.String r8 = ""
        java.lang.String r9 = ""
        r2 = r10
        r2.m3943a(r3, r4, r5, r6, r7, r8, r9)
        r11 = 0
    L_0x002c:
        return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C1343h.m3962c(java.io.File, java.io.File):boolean");
    }

    /* renamed from: d */
    private synchronized C1337b m3963d(String str, String str2, boolean z) throws SecException {
        StringBuilder sb;
        C1342g gVar = (C1342g) this.f3499d.get(str);
        if (gVar != null) {
            return gVar;
        }
        if (this.f3506k == null || !this.f3506k.exists()) {
            m3954b();
        }
        C1346a c = m3959c(str, str2, z);
        if (!(c == null || c.f3515a == null)) {
            if (c.f3515a.exists()) {
                C1342g a = m3936a(str, c, this.f3498c, str2);
                if (a == null) {
                    String str3 = "";
                    if (c.f3517c != null) {
                        sb = new StringBuilder();
                        sb.append("src:");
                        sb.append(m3966d(c.f3517c.getAbsolutePath()));
                    } else {
                        sb = new StringBuilder();
                        sb.append("zipfile:");
                        sb.append(m3966d(c.f3515a.getAbsolutePath()));
                    }
                    m3943a(100044, 110, str3, str, str2, sb.toString(), "");
                    throw new SecException(str, 111);
                }
                this.f3499d.put(str, a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("(");
                sb2.append(a.mo11843a());
                sb2.append(")");
                final String sb3 = sb2.toString();
                final String a2 = a.mo11856a("weakdependencies");
                if (str2.length() != 0) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str2);
                    sb4.append("->");
                    sb4.append(sb3);
                    sb3 = sb4.toString();
                }
                Looper myLooper = Looper.myLooper();
                if (myLooper == null || myLooper == Looper.getMainLooper()) {
                    C1348b.m3978a("looper of current thread is null, try to create a new thread with a looper");
                    HandlerThread handlerThread = new HandlerThread("SGBackgroud");
                    handlerThread.start();
                    myLooper = handlerThread.getLooper();
                }
                new Handler(myLooper).postDelayed(new Runnable() {
                    public void run() {
                        try {
                            C1343h.this.m3950a(a2, sb3, true);
                        } catch (SecException e) {
                            C1348b.m3979a("load weak dependency", e);
                        }
                    }
                }, 60000);
                return a;
            }
        }
        if (!z) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("plugin ");
        sb5.append(str);
        sb5.append(" not existed");
        String sb6 = sb5.toString();
        if (str2.length() != 0) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            sb7.append(", depended by ");
            sb7.append(str2);
            sb6 = sb7.toString();
        }
        m3943a(100044, 110, "", str, str2, "", "");
        throw new SecException(sb6, 110);
    }

    /* renamed from: d */
    private File m3964d(File file) {
        if (!file.exists() || !file.isDirectory() || !this.f3505j) {
            return file;
        }
        File file2 = new File(file, "main");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.exists() ? file2 : file;
    }

    /* renamed from: d */
    private String m3965d() {
        StringBuilder sb = new StringBuilder();
        File file = this.f3506k;
        if (file == null || !file.exists() || !file.isDirectory()) {
            sb.append("not exists!");
        } else {
            try {
                sb.append("[");
                File[] listFiles = file.listFiles();
                int i = 0;
                while (listFiles != null && i < listFiles.length) {
                    File file2 = listFiles[i];
                    if (file2.getName().startsWith("libsg") && (file2.getName().endsWith("zip") || file2.getName().endsWith(".so"))) {
                        sb.append(file2.getName());
                        sb.append("(");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(m3955b(file2));
                        sb2.append(" , ");
                        sb.append(sb2.toString());
                        sb.append(file2.length());
                        sb.append(") , ");
                    }
                    i++;
                }
                sb.append("]");
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    private String m3966d(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (m3955b(file)) {
            sb.append("->");
            try {
                sb.append(file.getCanonicalPath());
            } catch (Exception unused) {
            }
        }
        sb.append('[');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("exists:");
        sb2.append(file.exists());
        String str2 = StorageInterface.KEY_SPLITER;
        sb2.append(str2);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("size:");
        sb3.append(file.length());
        sb3.append(str2);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("canRead:");
        sb4.append(file.canRead());
        sb4.append(str2);
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("canWrite:");
        sb5.append(file.canWrite());
        sb5.append(str2);
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("totalSpace:");
        sb6.append(file.getTotalSpace());
        sb6.append(str2);
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("freeSpace:");
        sb7.append(file.getFreeSpace());
        sb7.append(str2);
        sb.append(sb7.toString());
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: a */
    public C1337b mo11857a(String str) throws SecException {
        return m3963d(str, "", true);
    }

    /* renamed from: a */
    public synchronized <T> T mo11846a(Class<T> cls) throws SecException {
        Object obj = this.f3496a.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        String str = null;
        if (this.f3504i != null) {
            str = this.f3504i.mo11855d();
            if (str == null || str.length() == 0) {
                str = this.f3504i.mo11851a(cls.getName());
            }
        }
        if (str == null || str.length() == 0) {
            str = m3953b(cls);
        }
        if (str == null || str.length() == 0) {
            throw new SecException(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
        }
        C1337b a = mo11857a(str);
        if (a != null) {
            Object a2 = a.mo11845c().mo11889a(cls);
            if (a2 != null) {
                this.f3496a.put(cls, a2);
                return cls.cast(a2);
            }
            String str2 = "";
            String name = cls.getName();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("(");
            sb.append(a.mo11843a());
            sb.append(")");
            m3943a(100045, 112, str2, name, sb.toString(), m3966d(a.mo11844b()), "");
            throw new SecException(112);
        }
        throw new SecException(110);
    }

    /* renamed from: a */
    public String mo11858a() {
        return "main";
    }

    /* renamed from: a */
    public void mo11859a(Context context, String str, String str2, boolean z, Object... objArr) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f3498c = context;
        this.f3503h = str;
        this.f3505j = C1352f.m3994c(this.f3498c);
        this.f3501f = z;
        C1347a.m3975a(this.f3498c);
        if (str2 != null && !str2.isEmpty()) {
            this.f3502g = str2;
        }
        try {
            m3954b();
        } catch (SecException unused) {
        }
    }
}
