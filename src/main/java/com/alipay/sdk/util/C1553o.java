package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.alipay.sdk.app.C1502i;
import com.alipay.sdk.app.C1503j;
import com.alipay.sdk.app.C1504k;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.p120a.C1489a;
import com.alipay.sdk.p121b.C1508a.C1509a;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.android.tpush.common.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import org.slf4j.Marker;

/* renamed from: com.alipay.sdk.util.o */
public class C1553o {
    /* renamed from: a */
    private static final String[] f3965a = {"10.1.5.1013151", "10.1.5.1013148"};

    /* renamed from: com.alipay.sdk.util.o$a */
    public static final class C1554a {
        /* renamed from: a */
        public final PackageInfo f3966a;
        /* renamed from: b */
        public final int f3967b;
        /* renamed from: c */
        public final String f3968c;

        public C1554a(PackageInfo packageInfo, int i, String str) {
            this.f3966a = packageInfo;
            this.f3967b = i;
            this.f3968c = str;
        }

        /* renamed from: a */
        public boolean mo12220a() {
            Signature[] signatureArr = this.f3966a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            int length = signatureArr.length;
            int i = 0;
            while (i < length) {
                String a = C1553o.m4679b(signatureArr[i].toByteArray());
                if (a == null || TextUtils.equals(a, this.f3968c)) {
                    i++;
                } else {
                    C1505a.m4452a(KEYS.BIZ, "PublicKeyUnmatch", String.format("Got %s, expected %s", new Object[]{a, this.f3968c}));
                    return true;
                }
            }
            return false;
        }

        /* renamed from: b */
        public boolean mo12221b() {
            return this.f3966a.versionCode < this.f3967b;
        }
    }

    /* renamed from: g */
    public static String m4695g(Context context) {
        return "-1;-1";
    }

    /* renamed from: a */
    static String m4668a() {
        if (EnvUtils.m4395a()) {
            return "com.eg.android.AlipayGphoneRC";
        }
        try {
            return ((C1509a) C1502i.f3836a.get(0)).f3873a;
        } catch (Throwable unused) {
            return "com.eg.android.AlipayGphone";
        }
    }

    /* renamed from: a */
    static String m4671a(String str) {
        return (!EnvUtils.m4395a() || !TextUtils.equals(str, "com.eg.android.AlipayGphoneRC")) ? "com.eg.android.AlipayGphone.IAlixPay" : "com.eg.android.AlipayGphoneRC.IAlixPay";
    }

    /* renamed from: b */
    public static Map<String, String> m4680b(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=", 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    public static Map<String, String> m4687c(String str) {
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            String[] split = str.substring(indexOf + 1).split("&");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                String str2 = split[i];
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), m4692e(str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    public static JSONObject m4690d(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    /* renamed from: e */
    public static String m4692e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C1505a.m4453a(KEYS.BIZ, "H5PayDataAnalysisError", (Throwable) e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m4672a(String str, String str2, String str3) {
        String str4 = "";
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return str4;
            }
            int i = 0;
            if (!TextUtils.isEmpty(str2)) {
                i = str3.indexOf(str2, indexOf);
            }
            if (i < 1) {
                return str3.substring(indexOf);
            }
            return str3.substring(indexOf, i);
        } catch (Throwable unused) {
            return str4;
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static String m4679b(byte[] bArr) {
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (publicKey instanceof RSAPublicKey) {
                BigInteger modulus = ((RSAPublicKey) publicKey).getModulus();
                if (modulus != null) {
                    return modulus.toString(16);
                }
            }
        } catch (Exception e) {
            C1505a.m4453a("auth", "GetPublicKeyFromSignEx", (Throwable) e);
        }
        return null;
    }

    /* renamed from: a */
    public static C1554a m4666a(Context context, List<C1509a> list) {
        if (list == null) {
            return null;
        }
        for (C1509a aVar : list) {
            if (aVar != null) {
                C1554a a = m4665a(context, aVar.f3873a, aVar.f3874b, aVar.f3875c);
                if (a != null && !a.mo12220a() && !a.mo12221b()) {
                    return a;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static C1554a m4665a(Context context, String str, int i, String str2) {
        PackageInfo packageInfo;
        if (EnvUtils.m4395a() && "com.eg.android.AlipayGphone".equals(str)) {
            str = "com.eg.android.AlipayGphoneRC";
        }
        try {
            packageInfo = m4677b(context, str);
        } catch (Throwable th) {
            C1505a.m4453a("auth", "GetPackageInfoEx", th);
            packageInfo = null;
        }
        if (!m4683b(packageInfo)) {
            return null;
        }
        return m4667a(packageInfo, i, str2);
    }

    /* renamed from: b */
    private static boolean m4683b(PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("info == null");
            str = sb.toString();
        } else if (packageInfo.signatures == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("info.signatures == null");
            str = sb2.toString();
        } else if (packageInfo.signatures.length <= 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("info.signatures.length <= 0");
            str = sb3.toString();
        } else {
            z = true;
        }
        if (!z) {
            C1505a.m4452a("auth", "NotIncludeSignatures", str);
        }
        return z;
    }

    /* renamed from: b */
    private static PackageInfo m4677b(Context context, String str) throws NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    /* renamed from: a */
    private static C1554a m4667a(PackageInfo packageInfo, int i, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new C1554a(packageInfo, i, str);
    }

    /* renamed from: a */
    public static boolean m4674a(Context context) {
        try {
            if (context.getPackageManager().getPackageInfo("com.alipay.android.app", 128) == null) {
                return false;
            }
            return true;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m4682b(Context context, List<C1509a> list) {
        try {
            for (C1509a aVar : list) {
                if (aVar != null) {
                    String str = aVar.f3873a;
                    if (EnvUtils.m4395a() && "com.eg.android.AlipayGphone".equals(str)) {
                        str = "com.eg.android.AlipayGphoneRC";
                    }
                    try {
                        if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                            return true;
                        }
                    } catch (NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            C1505a.m4453a(KEYS.BIZ, "CheckLaunchAppExistEx", th);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m4675a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            if (TextUtils.equals(str, f3965a[0]) || TextUtils.equals(str, f3965a[1])) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m4681b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m4668a(), 128);
            if (packageInfo != null && packageInfo.versionCode < 99) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            C1542e.m4633a(th);
            return false;
        }
    }

    /* renamed from: c */
    public static String m4685c(Context context) {
        String b = m4678b();
        String c = m4684c();
        String d = m4689d(context);
        String e = m4691e(context);
        StringBuilder sb = new StringBuilder();
        sb.append(" (");
        sb.append(b);
        String str = ";";
        sb.append(str);
        sb.append(c);
        sb.append(str);
        sb.append(d);
        sb.append(str);
        sb.append(str);
        sb.append(e);
        sb.append(")");
        sb.append("(sdk android)");
        return sb.toString();
    }

    /* renamed from: b */
    public static String m4678b() {
        StringBuilder sb = new StringBuilder();
        sb.append("Android ");
        sb.append(VERSION.RELEASE);
        return sb.toString();
    }

    /* renamed from: c */
    public static String m4684c() {
        String d = m4688d();
        int indexOf = d.indexOf("-");
        if (indexOf != -1) {
            d = d.substring(0, indexOf);
        }
        int indexOf2 = d.indexOf("\n");
        if (indexOf2 != -1) {
            d = d.substring(0, indexOf2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Linux ");
        sb.append(d);
        return sb.toString();
    }

    /* renamed from: d */
    private static String m4688d() {
        BufferedReader bufferedReader;
        String str = "\n";
        String str2 = "Unavailable";
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            if (!matcher.matches() || matcher.groupCount() < 4) {
                return str2;
            }
            StringBuilder sb = new StringBuilder(matcher.group(1));
            sb.append(str);
            sb.append(matcher.group(2));
            sb.append(" ");
            sb.append(matcher.group(3));
            sb.append(str);
            sb.append(matcher.group(4));
            return sb.toString();
        } catch (IOException unused) {
            return str2;
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
    }

    /* renamed from: d */
    public static String m4689d(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    /* renamed from: e */
    public static String m4691e(Context context) {
        DisplayMetrics i = m4697i(context);
        StringBuilder sb = new StringBuilder();
        sb.append(i.widthPixels);
        sb.append(Marker.ANY_MARKER);
        sb.append(i.heightPixels);
        return sb.toString();
    }

    /* renamed from: i */
    private static DisplayMetrics m4697i(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: f */
    public static String m4693f(Context context) {
        String a = C1552n.m4664a(context);
        return a.substring(0, a.indexOf("://"));
    }

    /* renamed from: a */
    public static String m4669a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 65.0d))));
            } else if (nextInt == 1) {
                sb.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 97.0d))));
            } else if (nextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    /* renamed from: f */
    public static boolean m4694f(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    /* renamed from: a */
    static String m4670a(Context context, String str) {
        String str2 = ":";
        String str3 = "";
        try {
            String str4 = str3;
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append("#M");
                    str4 = sb.toString();
                } else {
                    String str5 = runningAppProcessInfo.processName;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(str2);
                    if (str5.startsWith(sb2.toString())) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str4);
                        sb3.append("#");
                        String str6 = runningAppProcessInfo.processName;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str);
                        sb4.append(str2);
                        sb3.append(str6.replace(sb4.toString(), str3));
                        str4 = sb3.toString();
                    }
                }
            }
            str3 = str4;
        } catch (Throwable unused) {
        }
        if (str3.length() > 0) {
            str3 = str3.substring(1);
        }
        return str3.length() == 0 ? "N" : str3;
    }

    /* renamed from: a */
    public static boolean m4676a(WebView webView, String str, Activity activity) {
        String str2;
        String str3 = "&";
        String str4 = "&return_url=";
        String str5 = "&end_code=";
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        String str6 = "alipays://platformapi/startApp?";
        if (str.toLowerCase().startsWith(str6.toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
            try {
                C1554a a = m4666a((Context) activity, C1502i.f3836a);
                if (a != null && !a.mo12221b()) {
                    if (!a.mo12220a()) {
                        if (str.startsWith("intent://platformapi/startapp")) {
                            str = str.replaceFirst("intent://platformapi/startapp\\?", str6);
                        }
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                }
            } catch (Throwable unused) {
            }
            return true;
        } else if (TextUtils.equals(str, "sdklite://h5quit") || TextUtils.equals(str, "http://m.alipay.com/?action=h5quit")) {
            C1503j.m4439a(C1503j.m4442c());
            activity.finish();
            return true;
        } else {
            String str7 = "sdklite://h5quit?result=";
            if (!str.startsWith(str7)) {
                return false;
            }
            try {
                String substring = str.substring(str.indexOf(str7) + 24);
                int parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf(str5) + 10));
                if (parseInt != C1504k.SUCCEEDED.mo12142a()) {
                    if (parseInt != C1504k.PAY_WAITTING.mo12142a()) {
                        C1504k b = C1504k.m4445b(C1504k.FAILED.mo12142a());
                        C1503j.m4439a(C1503j.m4438a(b.mo12142a(), b.mo12145b(), ""));
                        activity.runOnUiThread(new C1555p(activity));
                        return true;
                    }
                }
                if (C1489a.f3788c) {
                    StringBuilder sb = new StringBuilder();
                    String decode = URLDecoder.decode(str);
                    String decode2 = URLDecoder.decode(decode);
                    int indexOf = decode.indexOf(str4) + 12;
                    sb.append(decode2.substring(decode2.indexOf(str7) + 24, decode2.lastIndexOf(str5)).split(str4)[0]);
                    sb.append(str4);
                    sb.append(decode.substring(indexOf, decode.indexOf(str3, indexOf)));
                    sb.append(decode.substring(decode.indexOf(str3, indexOf)));
                    str2 = sb.toString();
                } else {
                    String decode3 = URLDecoder.decode(str);
                    str2 = decode3.substring(decode3.indexOf(str7) + 24, decode3.lastIndexOf(str5));
                }
                C1504k b2 = C1504k.m4445b(parseInt);
                C1503j.m4439a(C1503j.m4438a(b2.mo12142a(), b2.mo12145b(), str2));
            } catch (Exception unused2) {
                C1503j.m4439a(C1503j.m4444e());
            }
            activity.runOnUiThread(new C1555p(activity));
            return true;
        }
    }

    /* renamed from: h */
    public static String m4696h(Context context) {
        return m4686c(context, context.getPackageName());
    }

    /* renamed from: c */
    private static String m4686c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            C1505a.m4453a(KEYS.BIZ, "GetPackageInfoEx", th);
            return "";
        }
    }
}
