package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: BUGLY */
public class AppInfo {
    /* renamed from: a */
    public static final String[] f23956a;
    /* renamed from: b */
    public static final String[] f23957b;
    /* renamed from: c */
    private static ActivityManager f23958c;

    static {
        String str = StorageInterface.KEY_SPLITER;
        f23956a = "@buglyAllChannel@".split(str);
        f23957b = "@buglyAllChannelPriority@".split(str);
    }

    /* renamed from: a */
    public static String m30738a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    /* renamed from: b */
    public static PackageInfo m30743b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(m30738a(context), 0);
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m30742a(Context context, String str) {
        if (!(context == null || str == null || str.trim().length() <= 0)) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String equals : strArr) {
                        if (str.equals(equals)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[Catch:{ all -> 0x0056, all -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052 A[SYNTHETIC, Splitter:B:26:0x0052] */
    /* renamed from: a */
    public static java.lang.String m30739a(android.content.Context r5, int r6) {
        /*
        r5 = 0
        java.io.FileReader r0 = new java.io.FileReader     // Catch:{ all -> 0x0042 }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
        r1.<init>()     // Catch:{ all -> 0x0042 }
        java.lang.String r2 = "/proc/"
        r1.append(r2)     // Catch:{ all -> 0x0042 }
        r1.append(r6)     // Catch:{ all -> 0x0042 }
        java.lang.String r2 = "/cmdline"
        r1.append(r2)     // Catch:{ all -> 0x0042 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0042 }
        r0.<init>(r1)     // Catch:{ all -> 0x0042 }
        r5 = 512(0x200, float:7.175E-43)
        char[] r5 = new char[r5]     // Catch:{ all -> 0x003d }
        r0.read(r5)     // Catch:{ all -> 0x003d }
        r1 = 0
        r2 = 0
    L_0x0025:
        int r3 = r5.length     // Catch:{ all -> 0x003d }
        if (r2 >= r3) goto L_0x0030
        char r3 = r5[r2]     // Catch:{ all -> 0x003d }
        if (r3 != 0) goto L_0x002d
        goto L_0x0030
    L_0x002d:
        int r2 = r2 + 1
        goto L_0x0025
    L_0x0030:
        java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x003d }
        r3.<init>(r5)     // Catch:{ all -> 0x003d }
        java.lang.String r5 = r3.substring(r1, r2)     // Catch:{ all -> 0x003d }
        r0.close()     // Catch:{ all -> 0x003c }
    L_0x003c:
        return r5
    L_0x003d:
        r5 = move-exception
        r4 = r0
        r0 = r5
        r5 = r4
        goto L_0x0043
    L_0x0042:
        r0 = move-exception
    L_0x0043:
        boolean r1 = com.tencent.bugly.proguard.C7226an.m31142a(r0)     // Catch:{ all -> 0x0056 }
        if (r1 != 0) goto L_0x004c
        r0.printStackTrace()     // Catch:{ all -> 0x0056 }
    L_0x004c:
        java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0056 }
        if (r5 == 0) goto L_0x0055
        r5.close()     // Catch:{ all -> 0x0055 }
    L_0x0055:
        return r6
    L_0x0056:
        r6 = move-exception
        if (r5 == 0) goto L_0x005c
        r5.close()     // Catch:{ all -> 0x005c }
    L_0x005c:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.AppInfo.m30739a(android.content.Context, int):java.lang.String");
    }

    /* renamed from: c */
    public static String m30744c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (!(packageManager == null || applicationInfo == null)) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
                if (applicationLabel != null) {
                    return applicationLabel.toString();
                }
            }
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: d */
    public static Map<String, String> m30745d(Context context) {
        String str = "com.tencent.rdm.uuid";
        String str2 = "BUGLY_ENABLE_DEBUG";
        String str3 = "BUGLY_APP_VERSION";
        String str4 = "BUGLY_APP_CHANNEL";
        String str5 = "BUGLY_APPID";
        String str6 = "BUGLY_DISABLE";
        HashMap hashMap = null;
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                HashMap hashMap2 = new HashMap();
                Object obj = applicationInfo.metaData.get(str6);
                if (obj != null) {
                    hashMap2.put(str6, obj.toString());
                }
                Object obj2 = applicationInfo.metaData.get(str5);
                if (obj2 != null) {
                    hashMap2.put(str5, obj2.toString());
                }
                Object obj3 = applicationInfo.metaData.get(str4);
                if (obj3 != null) {
                    hashMap2.put(str4, obj3.toString());
                }
                Object obj4 = applicationInfo.metaData.get(str3);
                if (obj4 != null) {
                    hashMap2.put(str3, obj4.toString());
                }
                Object obj5 = applicationInfo.metaData.get(str2);
                if (obj5 != null) {
                    hashMap2.put(str2, obj5.toString());
                }
                Object obj6 = applicationInfo.metaData.get(str);
                if (obj6 != null) {
                    hashMap2.put(str, obj6.toString());
                }
                hashMap = hashMap2;
            }
            return hashMap;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static List<String> m30741a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = (String) map.get("BUGLY_DISABLE");
            if (str != null) {
                if (str.length() != 0) {
                    String[] split = str.split(StorageInterface.KEY_SPLITER);
                    for (int i = 0; i < split.length; i++) {
                        split[i] = split[i].trim();
                    }
                    return Arrays.asList(split);
                }
            }
            return null;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m30740a(byte[] bArr) {
        String str = "\n";
        StringBuilder sb = new StringBuilder();
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                if (instance == null) {
                    return null;
                }
                X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(bArr));
                if (x509Certificate == null) {
                    return null;
                }
                sb.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    sb.append(issuerDN.toString());
                } else {
                    sb.append(str2);
                }
                sb.append(str);
                sb.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    sb.append(serialNumber.toString(16));
                } else {
                    sb.append(str2);
                }
                sb.append(str);
                sb.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    sb.append(notBefore.toString());
                } else {
                    sb.append(str2);
                }
                sb.append(str);
                sb.append("NotAfter|");
                Date notAfter = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    sb.append(notAfter.toString());
                } else {
                    sb.append(str2);
                }
                sb.append(str);
                sb.append("SHA1|");
                String a = C7232aq.m31185a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (a == null || a.length() <= 0) {
                    sb.append(str2);
                } else {
                    sb.append(a.toString());
                }
                sb.append(str);
                sb.append("MD5|");
                String a2 = C7232aq.m31185a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (a2 == null || a2.length() <= 0) {
                    sb.append(str2);
                } else {
                    sb.append(a2.toString());
                }
            } catch (CertificateException e) {
                if (!C7226an.m31142a(e)) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                if (!C7226an.m31142a(th)) {
                    th.printStackTrace();
                }
            }
        }
        if (sb.length() == 0) {
            return str2;
        }
        return sb.toString();
    }

    /* renamed from: e */
    public static String m30746e(Context context) {
        String a = m30738a(context);
        if (a == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a, 64);
            if (packageInfo == null) {
                return null;
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (!(signatureArr == null || signatureArr.length == 0)) {
                return m30740a(packageInfo.signatures[0].toByteArray());
            }
            return null;
        } catch (NameNotFoundException unused) {
        }
    }

    /* renamed from: f */
    public static boolean m30747f(Context context) {
        if (context == null) {
            return false;
        }
        if (f23958c == null) {
            f23958c = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
        }
        try {
            MemoryInfo memoryInfo = new MemoryInfo();
            f23958c.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            C7226an.m31147c("Memory is low.", new Object[0]);
            return true;
        } catch (Throwable th) {
            if (!C7226an.m31142a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: h */
    private static String m30749h(Context context) {
        String str = "";
        boolean z = null;
        try {
            String string = C7232aq.m31173a("DENGTA_META", context).getString("key_channelpath", str);
            z = C7232aq.m31196a(string);
            if (z) {
                string = "channel.ini";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[AppInfo] Beacon channel file path: ");
            sb.append(string);
            C7226an.m31141a(sb.toString(), new Object[0]);
            if (!string.equals(str)) {
                z = context.getAssets().open(string);
                Properties properties = new Properties();
                properties.load(z);
                str = properties.getProperty("CHANNEL", str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[AppInfo] Beacon channel read from assert: ");
                sb2.append(str);
                C7226an.m31141a(sb2.toString(), new Object[0]);
                if (!C7232aq.m31196a(str)) {
                    if (z != null) {
                        try {
                            z.close();
                        } catch (IOException e) {
                            C7226an.m31142a(e);
                        }
                    }
                    return str;
                }
            }
            if (z != null) {
                try {
                    z.close();
                } catch (IOException e2) {
                    C7226an.m31142a(e2);
                }
            }
        } catch (Exception unused) {
            C7226an.m31148d("[AppInfo] Failed to get get beacon channel", new Object[0]);
            if (z != null) {
                z.close();
            }
        } finally {
            if (z != null) {
                try {
                    z.close();
                } catch (IOException e3) {
                    C7226an.m31142a(e3);
                }
            }
        }
        return str;
    }

    /* renamed from: i */
    private static String m30750i(Context context) {
        String str = "";
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
            if (obj != null) {
                return obj.toString();
            }
            return str;
        } catch (Throwable th) {
            C7226an.m31148d("[AppInfo] Failed to read beacon channel from manifest.", new Object[0]);
            C7226an.m31142a(th);
            return str;
        }
    }

    /* renamed from: g */
    public static String m30748g(Context context) {
        if (context == null) {
            return "";
        }
        String h = m30749h(context);
        if (!C7232aq.m31196a(h)) {
            return h;
        }
        return m30750i(context);
    }
}
