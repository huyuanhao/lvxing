package com.alibaba.mtl.log.p077d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.mtl.log.UTDC;
import com.tencent.mid.core.Constants;

/* renamed from: com.alibaba.mtl.log.d.l */
public class NetworkUtil {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static String[] f3411a;
    /* renamed from: b */
    private static C1325b f3412b = new C1325b();
    /* access modifiers changed from: private|static */
    /* renamed from: c */
    public static C1324a f3413c = new C1324a();

    /* compiled from: NetworkUtil */
    /* renamed from: com.alibaba.mtl.log.d.l$a */
    private static class C1324a implements Runnable {
        /* renamed from: a */
        private Context f3414a;

        private C1324a() {
        }

        /* renamed from: a */
        public C1324a mo11806a(Context context) {
            this.f3414a = context;
            return this;
        }

        public void run() {
            Context context = this.f3414a;
            if (context != null) {
                try {
                    String str = "Unknown";
                    if (context.getPackageManager().checkPermission(Constants.PERMISSION_ACCESS_NETWORK_STATE, this.f3414a.getPackageName()) != 0) {
                        NetworkUtil.f3411a[0] = str;
                        return;
                    }
                    ConnectivityManager connectivityManager = (ConnectivityManager) this.f3414a.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        NetworkUtil.f3411a[0] = str;
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        if (1 == activeNetworkInfo.getType()) {
                            NetworkUtil.f3411a[0] = "Wi-Fi";
                        } else if (activeNetworkInfo.getType() == 0) {
                            NetworkUtil.f3411a[0] = "2G/3G";
                            NetworkUtil.f3411a[1] = activeNetworkInfo.getSubtypeName();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: NetworkUtil */
    /* renamed from: com.alibaba.mtl.log.d.l$b */
    private static class C1325b extends BroadcastReceiver {
        private C1325b() {
        }

        public void onReceive(Context context, Intent intent) {
            TaskExecutor.m3867a().mo11811a((Runnable) NetworkUtil.f3413c.mo11806a(context));
        }
    }

    /* renamed from: a */
    private static String m3844a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    static {
        String str = "Unknown";
        f3411a = new String[]{str, str};
    }

    /* renamed from: a */
    public static String m3843a() {
        Context c = UTDC.m3697c();
        String str = "Unknown";
        if (c == null) {
            return str;
        }
        try {
            if (c.getPackageManager().checkPermission(Constants.PERMISSION_ACCESS_NETWORK_STATE, c.getPackageName()) != 0) {
                return str;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) c.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    return m3844a(activeNetworkInfo.getSubtype());
                }
            }
            return str;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static boolean m3847b() {
        Context c = UTDC.m3697c();
        if (c != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) c.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String[] m3845a(Context context) {
        return f3411a;
    }

    /* renamed from: b */
    public static void m3846b(Context context) {
        if (context != null) {
            context.registerReceiver(f3412b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* renamed from: c */
    public static void m3849c(Context context) {
        if (context != null) {
            C1325b bVar = f3412b;
            if (bVar != null) {
                context.unregisterReceiver(bVar);
            }
        }
    }
}
