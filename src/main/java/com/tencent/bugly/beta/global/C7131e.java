package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.C7125b;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.p602ui.UILifecycleListener;
import com.tencent.bugly.beta.upgrade.BetaUploadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.e */
public class C7131e {
    /* renamed from: E */
    public static C7131e f23698E = new C7131e();
    /* renamed from: a */
    public static int f23699a;
    /* renamed from: A */
    public SharedPreferences f23700A;
    /* renamed from: B */
    public DisplayMetrics f23701B;
    /* renamed from: C */
    public boolean f23702C;
    /* renamed from: D */
    public boolean f23703D;
    /* renamed from: F */
    public BetaUploadStrategy f23704F;
    /* renamed from: G */
    public File f23705G;
    /* renamed from: H */
    public File f23706H;
    /* renamed from: I */
    public File f23707I;
    /* renamed from: J */
    public String f23708J;
    /* renamed from: K */
    public String f23709K;
    /* renamed from: L */
    public String f23710L;
    /* renamed from: M */
    public String f23711M;
    /* renamed from: N */
    public boolean f23712N;
    /* renamed from: O */
    public int f23713O;
    /* renamed from: P */
    public String f23714P;
    /* renamed from: Q */
    public boolean f23715Q;
    /* renamed from: R */
    public boolean f23716R;
    /* renamed from: S */
    public boolean f23717S;
    /* renamed from: T */
    public boolean f23718T;
    /* renamed from: U */
    public boolean f23719U;
    /* renamed from: V */
    public boolean f23720V;
    /* renamed from: W */
    public BetaPatchListener f23721W;
    /* renamed from: X */
    public boolean f23722X;
    /* renamed from: Y */
    public boolean f23723Y;
    /* renamed from: Z */
    public boolean f23724Z;
    /* renamed from: aa */
    public final List<String> f23725aa;
    /* renamed from: ab */
    public boolean f23726ab;
    /* renamed from: ac */
    public boolean f23727ac;
    /* renamed from: ad */
    public boolean f23728ad;
    /* renamed from: ae */
    public int f23729ae;
    /* renamed from: b */
    public long f23730b = 3000;
    /* renamed from: c */
    public long f23731c = 0;
    /* renamed from: d */
    public boolean f23732d = true;
    /* renamed from: e */
    public boolean f23733e = true;
    /* renamed from: f */
    public int f23734f;
    /* renamed from: g */
    public int f23735g;
    /* renamed from: h */
    public int f23736h;
    /* renamed from: i */
    public int f23737i;
    /* renamed from: j */
    public int f23738j;
    /* renamed from: k */
    public UILifecycleListener<UpgradeInfo> f23739k;
    /* renamed from: l */
    public File f23740l;
    /* renamed from: m */
    public final List<Class<? extends Activity>> f23741m = new ArrayList();
    /* renamed from: n */
    public final List<Class<? extends Activity>> f23742n = new ArrayList();
    /* renamed from: o */
    public int f23743o;
    /* renamed from: p */
    public C7125b f23744p;
    /* renamed from: q */
    public DownloadListener f23745q;
    /* renamed from: r */
    public File f23746r;
    /* renamed from: s */
    public Context f23747s;
    /* renamed from: t */
    public File f23748t;
    /* renamed from: u */
    public String f23749u;
    /* renamed from: v */
    public String f23750v;
    /* renamed from: w */
    public int f23751w = Integer.MIN_VALUE;
    /* renamed from: x */
    public String f23752x;
    /* renamed from: y */
    public String f23753y;
    /* renamed from: z */
    public PackageInfo f23754z;

    public C7131e() {
        String str = "";
        this.f23752x = str;
        this.f23753y = str;
        this.f23702C = true;
        this.f23703D = false;
        this.f23708J = str;
        this.f23709K = str;
        this.f23710L = str;
        this.f23711M = str;
        this.f23712N = false;
        this.f23713O = 0;
        this.f23714P = str;
        this.f23715Q = false;
        this.f23716R = true;
        this.f23717S = false;
        this.f23718T = false;
        this.f23719U = true;
        this.f23720V = true;
        this.f23722X = false;
        this.f23723Y = true;
        this.f23724Z = false;
        this.f23725aa = new ArrayList();
        this.f23726ab = false;
        this.f23727ac = false;
        this.f23729ae = 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012e, code lost:
            if (r8.f23748t.mkdirs() != false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x013e, code lost:
            if (r8.f23746r.mkdirs() != false) goto L_0x018b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01cb A[Catch:{ Exception -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01d6 A[Catch:{ Exception -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ee A[Catch:{ Exception -> 0x0056 }] */
    /* renamed from: a */
    public synchronized void mo34339a(android.content.Context r9) {
        /*
        r8 = this;
        monitor-enter(r8)
        com.tencent.bugly.beta.global.e r0 = f23698E     // Catch:{ all -> 0x01f7 }
        android.content.Context r1 = r9.getApplicationContext()     // Catch:{ all -> 0x01f7 }
        r0.f23747s = r1     // Catch:{ all -> 0x01f7 }
        android.content.Context r0 = r8.f23747s     // Catch:{ all -> 0x01f7 }
        android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x01f7 }
        android.content.Context r1 = r8.f23747s     // Catch:{ Exception -> 0x0056 }
        java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x0056 }
        r2 = 16384(0x4000, float:2.2959E-41)
        android.content.pm.PackageInfo r1 = r0.getPackageInfo(r1, r2)     // Catch:{ Exception -> 0x0056 }
        r8.f23754z = r1     // Catch:{ Exception -> 0x0056 }
        int r1 = r8.f23751w     // Catch:{ Exception -> 0x0056 }
        r2 = -2147483648(0xffffffff80000000, float:-0.0)
        if (r1 != r2) goto L_0x0029
        android.content.pm.PackageInfo r1 = r8.f23754z     // Catch:{ Exception -> 0x0056 }
        int r1 = r1.versionCode     // Catch:{ Exception -> 0x0056 }
        r8.f23751w = r1     // Catch:{ Exception -> 0x0056 }
    L_0x0029:
        java.lang.String r1 = r8.f23752x     // Catch:{ Exception -> 0x0056 }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0056 }
        if (r1 == 0) goto L_0x0037
        android.content.pm.PackageInfo r1 = r8.f23754z     // Catch:{ Exception -> 0x0056 }
        java.lang.String r1 = r1.versionName     // Catch:{ Exception -> 0x0056 }
        r8.f23752x = r1     // Catch:{ Exception -> 0x0056 }
    L_0x0037:
        android.content.pm.PackageInfo r1 = r8.f23754z     // Catch:{ Exception -> 0x0056 }
        android.content.pm.ApplicationInfo r1 = r1.applicationInfo     // Catch:{ Exception -> 0x0056 }
        java.lang.CharSequence r1 = r1.loadLabel(r0)     // Catch:{ Exception -> 0x0056 }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0056 }
        r8.f23753y = r1     // Catch:{ Exception -> 0x0056 }
        java.lang.String r1 = r8.f23714P     // Catch:{ Exception -> 0x0056 }
        boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0056 }
        if (r1 == 0) goto L_0x0060
        android.content.Context r1 = r8.f23747s     // Catch:{ Exception -> 0x0056 }
        java.lang.String r2 = "BUGLY_CHANNEL"
        java.lang.String r1 = com.tencent.bugly.beta.global.C7127a.m30545a(r1, r2)     // Catch:{ Exception -> 0x0056 }
        r8.f23714P = r1     // Catch:{ Exception -> 0x0056 }
        goto L_0x0060
    L_0x0056:
        r1 = move-exception
        boolean r2 = com.tencent.bugly.proguard.C7226an.m31145b(r1)     // Catch:{ all -> 0x01f7 }
        if (r2 != 0) goto L_0x0060
        r1.printStackTrace()     // Catch:{ all -> 0x01f7 }
    L_0x0060:
        java.lang.String r1 = "window"
        java.lang.Object r1 = r9.getSystemService(r1)     // Catch:{ all -> 0x01f7 }
        android.view.WindowManager r1 = (android.view.WindowManager) r1     // Catch:{ all -> 0x01f7 }
        android.util.DisplayMetrics r2 = new android.util.DisplayMetrics     // Catch:{ all -> 0x01f7 }
        r2.<init>()     // Catch:{ all -> 0x01f7 }
        r8.f23701B = r2     // Catch:{ all -> 0x01f7 }
        if (r1 == 0) goto L_0x0080
        android.view.Display r2 = r1.getDefaultDisplay()     // Catch:{ all -> 0x01f7 }
        if (r2 == 0) goto L_0x0080
        android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ all -> 0x01f7 }
        android.util.DisplayMetrics r2 = r8.f23701B     // Catch:{ all -> 0x01f7 }
        r1.getMetrics(r2)     // Catch:{ all -> 0x01f7 }
    L_0x0080:
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f7 }
        r1.<init>()     // Catch:{ all -> 0x01f7 }
        android.content.Context r2 = r8.f23747s     // Catch:{ all -> 0x01f7 }
        java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x01f7 }
        r1.append(r2)     // Catch:{ all -> 0x01f7 }
        java.lang.String r2 = "/.beta/"
        r1.append(r2)     // Catch:{ all -> 0x01f7 }
        java.lang.String r2 = "/apk/"
        java.lang.String r3 = "/res/"
        java.io.File r4 = r8.f23740l     // Catch:{ all -> 0x01f7 }
        if (r4 == 0) goto L_0x00dd
        java.io.File r4 = r8.f23740l     // Catch:{ all -> 0x01f7 }
        boolean r4 = r4.exists()     // Catch:{ all -> 0x01f7 }
        if (r4 != 0) goto L_0x00a4
        goto L_0x00dd
    L_0x00a4:
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x01f7 }
        java.io.File r5 = r8.f23740l     // Catch:{ all -> 0x01f7 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f7 }
        r6.<init>()     // Catch:{ all -> 0x01f7 }
        java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x01f7 }
        r6.append(r7)     // Catch:{ all -> 0x01f7 }
        r6.append(r2)     // Catch:{ all -> 0x01f7 }
        java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x01f7 }
        r4.<init>(r5, r2)     // Catch:{ all -> 0x01f7 }
        r8.f23748t = r4     // Catch:{ all -> 0x01f7 }
        java.io.File r2 = new java.io.File     // Catch:{ all -> 0x01f7 }
        java.io.File r4 = r8.f23740l     // Catch:{ all -> 0x01f7 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f7 }
        r5.<init>()     // Catch:{ all -> 0x01f7 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01f7 }
        r5.append(r1)     // Catch:{ all -> 0x01f7 }
        r5.append(r3)     // Catch:{ all -> 0x01f7 }
        java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01f7 }
        r2.<init>(r4, r1)     // Catch:{ all -> 0x01f7 }
        r8.f23746r = r2     // Catch:{ all -> 0x01f7 }
        goto L_0x0100
    L_0x00dd:
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x01f7 }
        java.lang.String r5 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ all -> 0x01f7 }
        java.io.File r5 = android.os.Environment.getExternalStoragePublicDirectory(r5)     // Catch:{ all -> 0x01f7 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01f7 }
        r4.<init>(r5, r1)     // Catch:{ all -> 0x01f7 }
        r8.f23740l = r4     // Catch:{ all -> 0x01f7 }
        java.io.File r1 = new java.io.File     // Catch:{ all -> 0x01f7 }
        java.io.File r4 = r8.f23740l     // Catch:{ all -> 0x01f7 }
        r1.<init>(r4, r2)     // Catch:{ all -> 0x01f7 }
        r8.f23748t = r1     // Catch:{ all -> 0x01f7 }
        java.io.File r1 = new java.io.File     // Catch:{ all -> 0x01f7 }
        java.io.File r2 = r8.f23740l     // Catch:{ all -> 0x01f7 }
        r1.<init>(r2, r3)     // Catch:{ all -> 0x01f7 }
        r8.f23746r = r1     // Catch:{ all -> 0x01f7 }
    L_0x0100:
        java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
        android.content.pm.PackageInfo r2 = r8.f23754z     // Catch:{ all -> 0x01f7 }
        java.lang.String r2 = r2.packageName     // Catch:{ all -> 0x01f7 }
        int r0 = r0.checkPermission(r1, r2)     // Catch:{ all -> 0x01f7 }
        r1 = 1
        r2 = 0
        if (r0 != 0) goto L_0x0110
        r0 = 1
        goto L_0x0111
    L_0x0110:
        r0 = 0
    L_0x0111:
        r3 = 2
        if (r0 == 0) goto L_0x0140
        java.lang.String r0 = "mounted"
        java.lang.String r4 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0181 }
        boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x0181 }
        if (r0 == 0) goto L_0x0140
        java.io.File r0 = r8.f23748t     // Catch:{ Exception -> 0x0181 }
        boolean r0 = r0.exists()     // Catch:{ Exception -> 0x0181 }
        if (r0 != 0) goto L_0x0130
        java.io.File r0 = r8.f23748t     // Catch:{ Exception -> 0x0181 }
        boolean r0 = r0.mkdirs()     // Catch:{ Exception -> 0x0181 }
        if (r0 == 0) goto L_0x0140
    L_0x0130:
        java.io.File r0 = r8.f23746r     // Catch:{ Exception -> 0x0181 }
        boolean r0 = r0.exists()     // Catch:{ Exception -> 0x0181 }
        if (r0 != 0) goto L_0x018b
        java.io.File r0 = r8.f23746r     // Catch:{ Exception -> 0x0181 }
        boolean r0 = r0.mkdirs()     // Catch:{ Exception -> 0x0181 }
        if (r0 != 0) goto L_0x018b
    L_0x0140:
        android.content.Context r0 = r8.f23747s     // Catch:{ Exception -> 0x0181 }
        java.lang.String r4 = "apk"
        java.io.File r0 = r0.getExternalFilesDir(r4)     // Catch:{ Exception -> 0x0181 }
        r8.f23748t = r0     // Catch:{ Exception -> 0x0181 }
        android.content.Context r0 = r8.f23747s     // Catch:{ Exception -> 0x0181 }
        java.lang.String r4 = "res"
        java.io.File r0 = r0.getExternalFilesDir(r4)     // Catch:{ Exception -> 0x0181 }
        r8.f23746r = r0     // Catch:{ Exception -> 0x0181 }
        java.io.File r0 = r8.f23748t     // Catch:{ Exception -> 0x0181 }
        if (r0 == 0) goto L_0x016c
        java.io.File r0 = r8.f23748t     // Catch:{ Exception -> 0x0181 }
        boolean r0 = r0.exists()     // Catch:{ Exception -> 0x0181 }
        if (r0 == 0) goto L_0x016c
        java.io.File r0 = r8.f23746r     // Catch:{ Exception -> 0x0181 }
        if (r0 == 0) goto L_0x016c
        java.io.File r0 = r8.f23746r     // Catch:{ Exception -> 0x0181 }
        boolean r0 = r0.exists()     // Catch:{ Exception -> 0x0181 }
        if (r0 != 0) goto L_0x018b
    L_0x016c:
        android.content.Context r0 = r8.f23747s     // Catch:{ Exception -> 0x0181 }
        java.lang.String r4 = "apk"
        java.io.File r0 = r0.getDir(r4, r3)     // Catch:{ Exception -> 0x0181 }
        r8.f23748t = r0     // Catch:{ Exception -> 0x0181 }
        android.content.Context r0 = r8.f23747s     // Catch:{ Exception -> 0x0181 }
        java.lang.String r4 = "res"
        java.io.File r0 = r0.getDir(r4, r2)     // Catch:{ Exception -> 0x0181 }
        r8.f23746r = r0     // Catch:{ Exception -> 0x0181 }
        goto L_0x018b
    L_0x0181:
        r0 = move-exception
        boolean r4 = com.tencent.bugly.proguard.C7226an.m31145b(r0)     // Catch:{ all -> 0x01f7 }
        if (r4 != 0) goto L_0x018b
        r0.printStackTrace()     // Catch:{ all -> 0x01f7 }
    L_0x018b:
        java.lang.String r0 = "apkSaveDir: %s, resSaveDir: %s"
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f7 }
        java.io.File r4 = r8.f23748t     // Catch:{ all -> 0x01f7 }
        java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x01f7 }
        r3[r2] = r4     // Catch:{ all -> 0x01f7 }
        java.io.File r4 = r8.f23746r     // Catch:{ all -> 0x01f7 }
        java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x01f7 }
        r3[r1] = r4     // Catch:{ all -> 0x01f7 }
        com.tencent.bugly.proguard.C7226an.m31141a(r0, r3)     // Catch:{ all -> 0x01f7 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f7 }
        r0.<init>()     // Catch:{ all -> 0x01f7 }
        java.lang.String r9 = r9.getPackageName()     // Catch:{ all -> 0x01f7 }
        r0.append(r9)     // Catch:{ all -> 0x01f7 }
        java.lang.String r9 = ".BETA_VALUES"
        r0.append(r9)     // Catch:{ all -> 0x01f7 }
        java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x01f7 }
        android.content.Context r0 = r8.f23747s     // Catch:{ all -> 0x01f7 }
        android.content.SharedPreferences r9 = com.tencent.bugly.proguard.C7232aq.m31173a(r9, r0)     // Catch:{ all -> 0x01f7 }
        r8.f23700A = r9     // Catch:{ all -> 0x01f7 }
        java.lang.String r9 = "isFirstRun"
        boolean r9 = com.tencent.bugly.beta.global.C7127a.m30556b(r9, r1)     // Catch:{ all -> 0x01f7 }
        r8.f23702C = r9     // Catch:{ all -> 0x01f7 }
        boolean r9 = r8.f23702C     // Catch:{ all -> 0x01f7 }
        if (r9 == 0) goto L_0x01d0
        java.lang.String r9 = "isFirstRun"
        com.tencent.bugly.beta.global.C7127a.m30548a(r9, r2)     // Catch:{ all -> 0x01f7 }
    L_0x01d0:
        com.tencent.bugly.crashreport.common.info.a r9 = com.tencent.bugly.crashreport.common.info.C7174a.m30754b()     // Catch:{ all -> 0x01f7 }
        if (r9 == 0) goto L_0x01de
        com.tencent.bugly.crashreport.common.info.a r9 = com.tencent.bugly.crashreport.common.info.C7174a.m30754b()     // Catch:{ all -> 0x01f7 }
        boolean r9 = r9.f23974L     // Catch:{ all -> 0x01f7 }
        r8.f23715Q = r9     // Catch:{ all -> 0x01f7 }
    L_0x01de:
        java.lang.String r9 = "us.bch"
        android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaUploadStrategy> r0 = com.tencent.bugly.beta.upgrade.BetaUploadStrategy.CREATOR     // Catch:{ all -> 0x01f7 }
        android.os.Parcelable r9 = com.tencent.bugly.beta.global.C7127a.m30544a(r9, r0)     // Catch:{ all -> 0x01f7 }
        com.tencent.bugly.beta.upgrade.BetaUploadStrategy r9 = (com.tencent.bugly.beta.upgrade.BetaUploadStrategy) r9     // Catch:{ all -> 0x01f7 }
        r8.f23704F = r9     // Catch:{ all -> 0x01f7 }
        com.tencent.bugly.beta.upgrade.BetaUploadStrategy r9 = r8.f23704F     // Catch:{ all -> 0x01f7 }
        if (r9 != 0) goto L_0x01f5
        com.tencent.bugly.beta.upgrade.BetaUploadStrategy r9 = new com.tencent.bugly.beta.upgrade.BetaUploadStrategy     // Catch:{ all -> 0x01f7 }
        r9.m52438init()     // Catch:{ all -> 0x01f7 }
        r8.f23704F = r9     // Catch:{ all -> 0x01f7 }
    L_0x01f5:
        monitor-exit(r8)
        return
    L_0x01f7:
        r9 = move-exception
        monitor-exit(r8)
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C7131e.mo34339a(android.content.Context):void");
    }
}
