package com.tencent.android.tpush.stat.p597b;

import android.content.Context;
import android.net.LocalServerSocket;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import java.io.IOException;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.c */
public class C7074c {
    /* renamed from: a */
    static LocalServerSocket f23519a;
    /* renamed from: b */
    private static String f23520b;
    /* renamed from: c */
    private static long f23521c;
    /* renamed from: d */
    private static String f23522d;

    /* renamed from: a */
    public static boolean m30318a() {
        String str = Constants.LogTag;
        String str2 = "com.tencent.teg.mid.sock.lock";
        try {
            f23519a = new LocalServerSocket(str2);
            return true;
        } catch (IOException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("socket Name:");
            sb.append(str2);
            sb.append(" is in use.");
            C6864a.m29298c(str, sb.toString());
            return false;
        } catch (Throwable unused2) {
            C6864a.m29298c(str, "something wrong while create LocalServerSocket.");
            return false;
        }
    }

    /* renamed from: b */
    public static void m30321b() {
        LocalServerSocket localServerSocket = f23519a;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
                String str = Constants.LogTag;
                StringBuilder sb = new StringBuilder();
                sb.append("close socket  mLocalServerSocket:");
                sb.append(f23519a);
                C6864a.m29298c(str, sb.toString());
                f23519a = null;
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static long m30315a(Context context) {
        long j = f23521c;
        if (j == 0 || j < 0) {
            synchronized (C7074c.class) {
                if (f23521c == 0 || f23521c < 0) {
                    f23521c = C7080i.m30362a(context).mo34207b().mo34181a();
                }
            }
        }
        return f23521c;
    }

    /* renamed from: b */
    public static String m30320b(Context context) {
        if (!m30319a(f23520b)) {
            synchronized (C7074c.class) {
                if (!m30319a(f23520b)) {
                    f23520b = C7080i.m30362a(context).mo34207b().mo34190e();
                }
            }
        }
        return f23520b;
    }

    /* renamed from: a */
    public static void m30317a(Context context, String str) {
        if (m30319a(str)) {
            f23520b = str;
            StringBuilder sb = new StringBuilder();
            sb.append("updateLocalMid:");
            sb.append(str);
            C6864a.m29298c(Constants.LogTag, sb.toString());
            C7075d dVar = new C7075d();
            dVar.mo34186c(CustomDeviceInfos.getDeviceId(context));
            dVar.mo34191e(CustomDeviceInfos.getMacAddress(context));
            dVar.mo34185b(str);
            dVar.mo34184b(System.currentTimeMillis());
            C7080i.m30362a(context).mo34213d(dVar);
        }
    }

    /* renamed from: a */
    public static void m30316a(Context context, long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateLocalGuid:");
        sb.append(j);
        C6864a.m29298c(Constants.LogTag, sb.toString());
        if (m30319a(str)) {
            f23520b = str;
            f23521c = j;
            C7075d dVar = new C7075d();
            dVar.mo34186c(CustomDeviceInfos.getDeviceId(context));
            dVar.mo34191e(CustomDeviceInfos.getMacAddress(context));
            dVar.mo34185b(str);
            dVar.mo34182a(j);
            dVar.mo34184b(System.currentTimeMillis());
            C7080i.m30362a(context).mo34213d(dVar);
        }
    }

    /* renamed from: a */
    public static boolean m30319a(String str) {
        return str != null && str.trim().length() == 40;
    }
}
