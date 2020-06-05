package com.p570ta.utdid2.p572b.p573a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* compiled from: NetworkUtils */
/* renamed from: com.ta.utdid2.b.a.f */
public class C6802f {
    /* renamed from: a */
    private static ConnectivityManager f22505a;
    /* renamed from: d */
    private static final int[] f22506d = {4, 7, 2, 1};

    /* renamed from: a */
    public static boolean m29027a(Context context) {
        ConnectivityManager a = m29026a(context);
        String str = "NetworkUtils";
        if (a != null) {
            try {
                NetworkInfo activeNetworkInfo = a.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            } catch (Exception e) {
                Log.e(str, e.toString());
            }
        } else {
            Log.e(str, "connManager is null!");
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m29028b(Context context) {
        ConnectivityManager a = m29026a(context);
        String str = "NetworkUtils";
        if (a != null) {
            try {
                NetworkInfo activeNetworkInfo = a.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (DebugUtils.f22504e) {
                        StringBuilder sb = new StringBuilder("subType:");
                        sb.append(subtype);
                        sb.append(": name:");
                        sb.append(activeNetworkInfo.getSubtypeName());
                        Log.d(str, sb.toString());
                    }
                    for (int i : f22506d) {
                        if (i == subtype) {
                            return true;
                        }
                    }
                } else {
                    Log.e(str, "networkInfo is null!");
                }
            } catch (Exception e) {
                Log.e(str, e.toString());
            }
        } else {
            Log.e(str, "connManager is null!");
        }
        return false;
    }

    /* renamed from: a */
    public static ConnectivityManager m29026a(Context context) {
        if (context == null) {
            Log.e("NetworkUtils", "context is null!");
            return null;
        }
        if (f22505a == null) {
            f22505a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f22505a;
    }
}
