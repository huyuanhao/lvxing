package com.alipay.sdk.p121b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.app.C1502i;
import com.alipay.sdk.app.statistic.C1505a;
import com.alipay.sdk.p120a.C1489a;
import com.alipay.sdk.p126f.C1531b;
import com.alipay.sdk.sys.C1536b;
import com.alipay.sdk.util.C1539b;
import com.alipay.sdk.util.C1542e;
import com.alipay.sdk.util.C1553o;
import com.tencent.mid.core.Constants.ERROR;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* renamed from: com.alipay.sdk.b.c */
public class C1511c {
    /* renamed from: a */
    private static C1511c f3878a;
    /* renamed from: b */
    private String f3879b;
    /* renamed from: c */
    private String f3880c = "sdk-and-lite";
    /* renamed from: d */
    private String f3881d;

    /* renamed from: d */
    private String m4495d() {
        return "1";
    }

    /* renamed from: e */
    private String m4497e() {
        return "-1;-1";
    }

    private C1511c() {
        String a = C1502i.m4434a();
        if (!C1502i.m4436b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3880c);
            sb.append('_');
            sb.append(a);
            this.f3880c = sb.toString();
        }
    }

    /* renamed from: a */
    public static synchronized C1511c m4489a() {
        C1511c cVar;
        synchronized (C1511c.class) {
            if (f3878a == null) {
                f3878a = new C1511c();
            }
            cVar = f3878a;
        }
        return cVar;
    }

    /* renamed from: a */
    public synchronized void mo12164a(String str) {
        if (!TextUtils.isEmpty(str)) {
            PreferenceManager.getDefaultSharedPreferences(C1536b.m4608a().mo12202b()).edit().putString("trideskey", str).commit();
            C1489a.f3787b = str;
        }
    }

    /* renamed from: b */
    private String m4492b(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    /* renamed from: a */
    public String mo12163a(C1531b bVar) {
        Context b = C1536b.m4608a().mo12202b();
        C1539b a = C1539b.m4617a(b);
        String str = ";";
        if (TextUtils.isEmpty(this.f3879b)) {
            String b2 = C1553o.m4678b();
            String c = C1553o.m4684c();
            String d = C1553o.m4689d(b);
            String f = C1553o.m4693f(b);
            String e = C1553o.m4691e(b);
            String b3 = m4492b(b);
            StringBuilder sb = new StringBuilder();
            sb.append("Msp/15.6.5");
            sb.append(" (");
            sb.append(b2);
            sb.append(str);
            sb.append(c);
            sb.append(str);
            sb.append(d);
            sb.append(str);
            sb.append(f);
            sb.append(str);
            sb.append(e);
            sb.append(str);
            sb.append(b3);
            this.f3879b = sb.toString();
        }
        String b4 = C1539b.m4618b(b).mo12215b();
        String g = C1553o.m4695g(b);
        String d2 = m4495d();
        String a2 = a.mo12208a();
        String b5 = a.mo12210b();
        String c2 = mo12166c();
        String b6 = mo12165b();
        if (bVar != null) {
            this.f3881d = bVar.mo12195b();
        }
        String str2 = " ";
        String replace = Build.MANUFACTURER.replace(str, str2);
        String replace2 = Build.MODEL.replace(str, str2);
        boolean d3 = C1536b.m4609d();
        String d4 = a.mo12213d();
        String c3 = m4494c(b);
        String d5 = m4496d(b);
        Context context = b;
        StringBuilder sb2 = new StringBuilder();
        String str3 = d5;
        sb2.append(this.f3879b);
        sb2.append(str);
        sb2.append(b4);
        sb2.append(str);
        sb2.append(g);
        sb2.append(str);
        sb2.append(d2);
        sb2.append(str);
        sb2.append(a2);
        sb2.append(str);
        sb2.append(b5);
        sb2.append(str);
        sb2.append(this.f3881d);
        sb2.append(str);
        sb2.append(replace);
        sb2.append(str);
        sb2.append(replace2);
        sb2.append(str);
        sb2.append(d3);
        sb2.append(str);
        sb2.append(d4);
        sb2.append(str);
        sb2.append(m4497e());
        sb2.append(str);
        sb2.append(this.f3880c);
        sb2.append(str);
        sb2.append(c2);
        sb2.append(str);
        sb2.append(b6);
        sb2.append(str);
        sb2.append(c3);
        sb2.append(str);
        sb2.append(str3);
        if (bVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", C1531b.m4573a(context).mo12193a());
            hashMap.put("utdid", C1536b.m4608a().mo12204e());
            String b7 = m4493b(context, hashMap);
            if (!TextUtils.isEmpty(b7)) {
                sb2.append(str);
                sb2.append(b7);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: b */
    public String mo12165b() {
        String str;
        Context b = C1536b.m4608a().mo12202b();
        SharedPreferences sharedPreferences = b.getSharedPreferences("virtualImeiAndImsi", 0);
        String str2 = "virtual_imei";
        String string = sharedPreferences.getString(str2, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(C1531b.m4573a(b).mo12193a())) {
            str = m4498f();
        } else {
            str = C1539b.m4617a(b).mo12210b();
        }
        String str3 = str;
        sharedPreferences.edit().putString(str2, str3).commit();
        return str3;
    }

    /* renamed from: c */
    public String mo12166c() {
        String str;
        Context b = C1536b.m4608a().mo12202b();
        SharedPreferences sharedPreferences = b.getSharedPreferences("virtualImeiAndImsi", 0);
        String str2 = "virtual_imsi";
        String string = sharedPreferences.getString(str2, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(C1531b.m4573a(b).mo12193a())) {
            String e = C1536b.m4608a().mo12204e();
            if (TextUtils.isEmpty(e)) {
                str = m4498f();
            } else {
                str = e.substring(3, 18);
            }
        } else {
            str = C1539b.m4617a(b).mo12208a();
        }
        String str3 = str;
        sharedPreferences.edit().putString(str2, str3).commit();
        return str3;
    }

    /* renamed from: f */
    private String m4498f() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(hexString);
        sb.append(random.nextInt(9000) + 1000);
        return sb.toString();
    }

    /* renamed from: c */
    private String m4494c(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : ERROR.CMD_FORMAT_ERROR;
    }

    /* renamed from: d */
    private String m4496d(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m4490a(Context context, HashMap<String, String> hashMap) {
        String str;
        String str2 = "third";
        try {
            str = SecurityClientMobile.GetApdid(context, hashMap);
        } catch (Throwable th) {
            C1542e.m4633a(th);
            C1505a.m4453a(str2, "GetApdidEx", th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            C1505a.m4452a(str2, "GetApdidNull", "apdid == null");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("apdid:");
        sb.append(str);
        C1542e.m4635c("msp", sb.toString());
        return str;
    }

    /* renamed from: b */
    private String m4493b(Context context, HashMap<String, String> hashMap) {
        try {
            return (String) Executors.newFixedThreadPool(2).submit(new C1512d(this, context, hashMap)).get(3000, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            C1505a.m4453a("third", "GetApdidTimeout", th);
            return "";
        }
    }

    /* renamed from: a */
    public String mo12162a(Context context) {
        if (context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                sb.append("(");
                sb.append(packageName);
                sb.append(";");
                sb.append(packageInfo.versionCode);
                sb.append(")");
                return sb.toString();
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
