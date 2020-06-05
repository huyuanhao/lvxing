package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* renamed from: com.alipay.sdk.util.b */
public class C1539b {
    /* renamed from: d */
    private static C1539b f3930d;
    /* renamed from: a */
    private String f3931a;
    /* renamed from: b */
    private String f3932b;
    /* renamed from: c */
    private String f3933c;

    /* renamed from: a */
    public static C1539b m4617a(Context context) {
        if (f3930d == null) {
            f3930d = new C1539b(context);
        }
        return f3930d;
    }

    private C1539b(Context context) {
        String str = "00:00:00:00:00:00";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            mo12211b(telephonyManager.getDeviceId());
            mo12209a(telephonyManager.getSubscriberId());
            this.f3933c = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (!TextUtils.isEmpty(this.f3933c)) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (!TextUtils.isEmpty(this.f3933c)) {
                return;
            }
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.f3933c)) {
                this.f3933c = str;
            }
            throw th;
        }
        this.f3933c = str;
    }

    /* renamed from: a */
    public String mo12208a() {
        if (TextUtils.isEmpty(this.f3931a)) {
            this.f3931a = "000000000000000";
        }
        return this.f3931a;
    }

    /* renamed from: b */
    public String mo12210b() {
        if (TextUtils.isEmpty(this.f3932b)) {
            this.f3932b = "000000000000000";
        }
        return this.f3932b;
    }

    /* renamed from: a */
    public void mo12209a(String str) {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("000000000000000");
            str = sb.toString().substring(0, 15);
        }
        this.f3931a = str;
    }

    /* renamed from: b */
    public void mo12211b(String str) {
        if (str != null) {
            byte[] bytes = str.getBytes();
            int i = 0;
            while (i < bytes.length) {
                if (bytes[i] < 48 || bytes[i] > 57) {
                    bytes[i] = 48;
                }
                i++;
            }
            String str2 = new String(bytes);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("000000000000000");
            str = sb.toString().substring(0, 15);
        }
        this.f3932b = str;
    }

    /* renamed from: c */
    public String mo12212c() {
        String b = mo12210b();
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        sb.append("|");
        String sb2 = sb.toString();
        String a = mo12208a();
        if (TextUtils.isEmpty(a)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("000000000000000");
            return sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb2);
        sb4.append(a);
        return sb4.toString();
    }

    /* renamed from: d */
    public String mo12213d() {
        return this.f3933c;
    }

    /* renamed from: b */
    public static C1541d m4618b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                return C1541d.m4628a(activeNetworkInfo.getSubtype());
            }
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                return C1541d.NONE;
            }
            return C1541d.f3934a;
        } catch (Exception unused) {
            return C1541d.NONE;
        }
    }

    /* renamed from: c */
    public static String m4619c(Context context) {
        return m4617a(context).mo12212c().substring(0, 8);
    }

    /* renamed from: d */
    public static String m4620d(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
