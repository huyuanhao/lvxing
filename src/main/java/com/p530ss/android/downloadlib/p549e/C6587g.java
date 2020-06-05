package com.p530ss.android.downloadlib.p549e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.DownloadInstallInfo;
import com.p530ss.android.p531a.p532a.p533a.IDownloadCustomChecker;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ToolUtils */
/* renamed from: com.ss.android.downloadlib.e.g */
public class C6587g {
    /* renamed from: a */
    static final char[] f21430a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: b */
    private static Object[] f21431b = new Object[0];
    /* renamed from: c */
    private static Object[] f21432c = new Object[73];
    /* renamed from: d */
    private static String f21433d = null;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC, Splitter:B:22:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0042 A[SYNTHETIC, Splitter:B:31:0x0042] */
    /* renamed from: a */
    public static java.lang.String m26512a(java.io.File r5) {
        /*
        r0 = 0
        java.lang.String r1 = "MD5"
        java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x003f, all -> 0x0032 }
        if (r1 != 0) goto L_0x000a
        return r0
    L_0x000a:
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003f, all -> 0x0032 }
        r2.<init>(r5)     // Catch:{ Exception -> 0x003f, all -> 0x0032 }
        r5 = 8192(0x2000, float:1.14794E-41)
        byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
    L_0x0013:
        int r3 = r5.length     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        r4 = 0
        int r3 = r2.read(r5, r4, r3)     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        if (r3 <= 0) goto L_0x001f
        r1.update(r5, r4, r3)     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        goto L_0x0013
    L_0x001f:
        byte[] r5 = r1.digest()     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        java.lang.String r5 = m26514a(r5)     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
        r2.close()     // Catch:{ IOException -> 0x002b }
        goto L_0x002f
    L_0x002b:
        r0 = move-exception
        r0.printStackTrace()
    L_0x002f:
        return r5
    L_0x0030:
        r5 = move-exception
        goto L_0x0034
    L_0x0032:
        r5 = move-exception
        r2 = r0
    L_0x0034:
        if (r2 == 0) goto L_0x003e
        r2.close()     // Catch:{ IOException -> 0x003a }
        goto L_0x003e
    L_0x003a:
        r0 = move-exception
        r0.printStackTrace()
    L_0x003e:
        throw r5
    L_0x003f:
        r2 = r0
    L_0x0040:
        if (r2 == 0) goto L_0x004a
        r2.close()     // Catch:{ IOException -> 0x0046 }
        goto L_0x004a
    L_0x0046:
        r5 = move-exception
        r5.printStackTrace()
    L_0x004a:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p549e.C6587g.m26512a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    public static String m26514a(byte[] bArr) {
        if (bArr != null) {
            return m26515a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: a */
    public static String m26515a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        } else if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                byte b = bArr[i5 + i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                int i6 = i4 + 1;
                char[] cArr2 = f21430a;
                cArr[i4] = cArr2[b >> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr, 0, i3);
        }
    }

    /* renamed from: a */
    public static boolean m26528a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return new File(str).exists();
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m26534b(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static long m26508a(JSONObject jSONObject, String str) {
        long j = 0;
        if (jSONObject == null) {
            return 0;
        }
        try {
            j = Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (Exception unused) {
        }
        return j;
    }

    /* renamed from: a */
    public static JSONObject m26517a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (!(jSONObject == null || jSONObject2 == null)) {
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    jSONObject2.put(str, jSONObject.get(str));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    /* renamed from: a */
    public static JSONObject m26518a(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (!(jSONObjectArr == null || jSONObjectArr.length == 0)) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    m26517a(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static boolean m26523a(Context context, Intent intent) {
        try {
            List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static Drawable m26509a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo != null) {
                ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                applicationInfo.sourceDir = str;
                applicationInfo.publicSourceDir = str;
                try {
                    return applicationInfo.loadIcon(packageManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static Drawable m26530b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (NameNotFoundException unused) {
            }
        }
        return null;
    }

    /* renamed from: c */
    public static boolean m26535c(Context context, String str) {
        if (context == null) {
            context = C6565j.m26357a();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static DownloadInstallInfo m26510a(String str, int i, String str2) {
        DownloadInstallInfo bVar = new DownloadInstallInfo();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            PackageInfo packageInfo = C6565j.m26357a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                bVar.mo31260a(DownloadInstallInfo.f21305b);
                IDownloadCustomChecker h = C6565j.m26374h();
                if (h != null && h.mo31038a() && !m26522a(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    bVar.mo31260a(DownloadInstallInfo.f21306c);
                }
            }
        } catch (Exception unused) {
        }
        return bVar;
    }

    /* renamed from: a */
    private static boolean m26522a(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        if ((i2 <= 0 || i < i2) && m26507a(str, str2) < 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m26526a(NativeDownloadModel aVar) {
        if (aVar == null) {
            return false;
        }
        return m26510a(aVar.mo31210d(), aVar.mo31219i(), aVar.mo31220j()).mo31261a();
    }

    /* renamed from: a */
    public static boolean m26525a(C6507c cVar) {
        if (cVar == null) {
            return false;
        }
        return m26510a(cVar.mo31080t(), cVar.mo31076p(), cVar.mo31077q()).mo31261a();
    }

    /* renamed from: b */
    public static boolean m26533b(Context context, Intent intent) {
        boolean z = false;
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = C6565j.m26357a();
        }
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m26524a(Context context, String str, String str2) {
        PackageInfo packageInfo;
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0);
                    if (packageArchiveInfo == null || !packageArchiveInfo.packageName.equals(str2)) {
                        return false;
                    }
                    int i = packageArchiveInfo.versionCode;
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                    } catch (NameNotFoundException unused) {
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        if (i == packageInfo.versionCode) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m26537d(Context context, String str) {
        PackageInfo packageInfo;
        boolean z = false;
        if (!(context == null || str == null || TextUtils.isEmpty(str))) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0);
                    if (packageArchiveInfo == null) {
                        return false;
                    }
                    String str2 = packageArchiveInfo.packageName;
                    int i = packageArchiveInfo.versionCode;
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                    } catch (NameNotFoundException unused) {
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        if (i <= packageInfo.versionCode) {
                            z = true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* renamed from: e */
    public static Intent m26539e(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        String str2 = "android.intent.category.LAUNCHER";
        if (!launchIntentForPackage.hasCategory(str2)) {
            launchIntentForPackage.addCategory(str2);
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    /* renamed from: a */
    public static int m26506a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i).applicationInfo.targetSdkVersion;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: a */
    public static byte[] m26529a(byte[] bArr, byte[] bArr2, String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, str);
        Mac instance = Mac.getInstance(str);
        instance.init(secretKeySpec);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    public static String m26513a(String str, int i) {
        if (i == 0) {
            return "";
        }
        if (!TextUtils.isEmpty(str) && str.length() > i) {
            str = str.substring(0, i);
        }
        return str;
    }

    /* renamed from: a */
    public static boolean m26527a(BaseException aVar) {
        if (aVar == null) {
            return false;
        }
        int a = aVar.mo32073a();
        String message = aVar.getMessage();
        if (a == 1006 || a == 1052 || ((a == 1023 || a == 1039 || a == 1040 || a == 1036) && !TextUtils.isEmpty(message) && message.contains("ENOSPC (No space left on device)"))) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m26536c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://ad.toutiao.com/advertiser_package/") && !str.startsWith("https://ad.toutiao.com/advertiser_package/")) {
            return m26538d(str);
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m26538d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://lf3-ttcdn-tos.pstatp.com/") && !str.startsWith("https://lf3-ttcdn-tos.pstatp.com/")) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static int m26507a(String str, String str2) {
        String str3 = "\\.";
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    if (str.equals(str2)) {
                        return 0;
                    }
                    String[] split = str.split(str3);
                    String[] split2 = str2.split(str3);
                    int min = Math.min(split.length, split2.length);
                    int i = 0;
                    int i2 = 0;
                    while (i < min) {
                        i2 = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                        if (i2 != 0) {
                            break;
                        }
                        i++;
                    }
                    int i3 = -1;
                    if (i2 == 0) {
                        for (int i4 = i; i4 < split.length; i4++) {
                            if (Integer.parseInt(split[i4]) > 0) {
                                return 1;
                            }
                        }
                        while (i < split2.length) {
                            if (Integer.parseInt(split2[i]) > 0) {
                                return -1;
                            }
                            i++;
                        }
                        return 0;
                    }
                    if (i2 > 0) {
                        i3 = 1;
                    }
                    return i3;
                }
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    /* renamed from: a */
    public static String m26516a(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "ERROR";
    }

    /* renamed from: a */
    public static void m26519a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static <T> T m26511a(T... tArr) {
        String str = "args is null";
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException(str);
        }
        throw new IllegalArgumentException(str);
    }

    /* renamed from: a */
    public static boolean m26521a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: b */
    public static void m26532b() {
        m26520a(new Throwable());
    }

    /* renamed from: a */
    public static void m26520a(Throwable th) {
        C6565j.m26373g().mo31357a(null, new BaseException(1, m26531b(th)), 1);
    }

    /* renamed from: b */
    public static String m26531b(Throwable th) {
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
