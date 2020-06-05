package com.bytedance.tea.crash.p221g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.tea.crash.upload.CrashUploader.C2601b;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.bytedance.tea.crash.g.i */
public final class Net {

    /* compiled from: Net */
    /* renamed from: com.bytedance.tea.crash.g.i$1 */
    static /* synthetic */ class C25971 {
        /* renamed from: a */
        static final /* synthetic */ int[] f9375a = new int[C2601b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            com.bytedance.tea.crash.upload.b$b[] r0 = com.bytedance.tea.crash.upload.CrashUploader.C2601b.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f9375a = r0
            int[] r0 = f9375a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.bytedance.tea.crash.upload.b$b r1 = com.bytedance.tea.crash.upload.CrashUploader.C2601b.WIFI     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f9375a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.bytedance.tea.crash.upload.b$b r1 = com.bytedance.tea.crash.upload.CrashUploader.C2601b.MOBILE_2G     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f9375a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.bytedance.tea.crash.upload.b$b r1 = com.bytedance.tea.crash.upload.CrashUploader.C2601b.MOBILE_3G     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f9375a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.bytedance.tea.crash.upload.b$b r1 = com.bytedance.tea.crash.upload.CrashUploader.C2601b.MOBILE_4G     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f9375a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.bytedance.tea.crash.upload.b$b r1 = com.bytedance.tea.crash.upload.CrashUploader.C2601b.MOBILE     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.p221g.Net.C25971.m44336clinit():void");
        }
    }

    /* renamed from: a */
    public static String m12544a(Context context) {
        return m12545a(m12547c(context));
    }

    /* renamed from: a */
    public static String m12545a(C2601b bVar) {
        String str;
        String str2 = "";
        try {
            int i = C25971.f9375a[bVar.ordinal()];
            if (i == 1) {
                str = "wifi";
            } else if (i == 2) {
                str = "2g";
            } else if (i == 3) {
                str = "3g";
            } else if (i == 4) {
                str = "4g";
            } else if (i != 5) {
                return str2;
            } else {
                str = ArgKey.KEY_MOBILE;
            }
            return str;
        } catch (Exception unused) {
            return str2;
        }
    }

    /* renamed from: c */
    private static C2601b m12547c(Context context) {
        C2601b bVar;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return C2601b.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        return C2601b.WIFI;
                    }
                    if (type != 0) {
                        return C2601b.MOBILE;
                    }
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            bVar = C2601b.MOBILE_3G;
                            break;
                        case 13:
                            return C2601b.MOBILE_4G;
                        default:
                            bVar = C2601b.MOBILE;
                            break;
                    }
                    return bVar;
                }
            }
            return C2601b.NONE;
        } catch (Throwable unused) {
            return C2601b.MOBILE;
        }
    }

    /* renamed from: b */
    public static boolean m12546b(Context context) {
        boolean z = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
        }
    }
}
