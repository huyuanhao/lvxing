package com.ali.auth.third.core.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.model.C1026g;
import com.ali.auth.third.core.p023b.C0983a;
import com.ali.auth.third.core.p024c.C0989a;
import com.tencent.android.tpush.common.Constants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/* renamed from: com.ali.auth.third.core.util.a */
public class C1034a {
    /* renamed from: a */
    public static String f2078a;
    /* renamed from: b */
    public static String f2079b;
    /* renamed from: c */
    private static String f2080c;

    /* renamed from: a */
    public static String m1976a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString(b & 15));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m1977a() {
        m1980a("com_taobao_tae_sdk_system_exception");
    }

    /* renamed from: a */
    public static void m1978a(final C0983a aVar, final C1026g gVar) {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                C0983a aVar = aVar;
                if (aVar != null) {
                    aVar.mo10305a(gVar.f2046j, gVar.f2047k);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m1979a(LoginAction loginAction) {
        Intent intent = new Intent();
        intent.setAction(loginAction.name());
        intent.setPackage(C0989a.m1887c().getPackageName());
        C0989a.m1887c().sendBroadcast(intent);
    }

    /* renamed from: a */
    public static void m1980a(final String str) {
        C0989a.f1901p.mo10335a(new Runnable() {
            public void run() {
                Toast.makeText(C0989a.m1887c(), C1041f.m2005a(str), 0).show();
            }
        });
    }

    /* renamed from: a */
    public static boolean m1981a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        boolean z = false;
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        int length = allNetworkInfo.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            NetworkInfo networkInfo = allNetworkInfo[i];
            if (networkInfo == null || !(networkInfo.getState() == State.CONNECTED || networkInfo.getState() == State.CONNECTING)) {
                i++;
            }
        }
        z = true;
        return z;
    }

    /* renamed from: b */
    public static boolean m1982b() {
        if (C0989a.f1891f == null) {
            return true;
        }
        return m1981a(C0989a.f1891f);
    }

    /* renamed from: c */
    public static String m1983c() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return inetAddress.getHostAddress().toString();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            Log.e("Error", e.toString());
        }
        return null;
    }

    /* renamed from: d */
    public static String m1984d() {
        if (C0989a.f1891f == null) {
            return null;
        }
        String str = f2080c;
        if (str != null) {
            return str;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) C0989a.f1891f.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    f2080c = runningAppProcessInfo.processName;
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public static String m1985e() {
        if (f2078a == null) {
            try {
                PackageManager packageManager = C0989a.m1887c().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(C0989a.m1887c().getPackageName(), 0);
                if (packageInfo != null) {
                    f2078a = packageInfo.versionName;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(packageManager.getApplicationLabel(packageInfo.applicationInfo));
                    f2079b = sb.toString();
                }
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return f2078a;
    }
}
