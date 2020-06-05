package com.qiyukf.basesdk.p394b.p395a.p397b.p402e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p399b.C5297b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5300b;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5301c;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5304f;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.json.JSONException;

/* renamed from: com.qiyukf.basesdk.b.a.b.e.c */
public class C5309c {
    /* renamed from: a */
    private static final String f17211a = m21831a(C5309c.class);

    /* renamed from: a */
    public static C5307a m21827a(File file, String str) {
        if (file == null) {
            return null;
        }
        try {
            return new C5307a(file, str);
        } catch (IOException e) {
            if (file != null) {
                file.delete();
            }
            throw e;
        }
    }

    /* renamed from: a */
    public static String m21828a() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException unused) {
            C5264a.m21622c(f17211a, "get ip address socket exception");
        }
        return "";
    }

    /* renamed from: a */
    public static String m21829a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase("WIFI")) {
                return "wifi";
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                boolean z = true;
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    default:
                        z = false;
                        break;
                }
                return z ? "3g/4g" : "2g";
            }
        }
        return "";
    }

    /* renamed from: a */
    public static String m21830a(C5301c cVar, String str) {
        if (!(cVar == null || cVar.mo27176b() == null || !cVar.mo27176b().has(str))) {
            try {
                return cVar.mo27176b().getString(str);
            } catch (JSONException e) {
                C5264a.m21621b(f17211a, "get result string parse json failed", e);
            }
        }
        return "";
    }

    /* renamed from: a */
    public static String m21831a(Class cls) {
        StringBuilder sb = new StringBuilder("NOS_");
        sb.append(cls.getSimpleName());
        return sb.toString();
    }

    /* renamed from: a */
    public static void m21832a(Context context, File file, Object obj, C5304f fVar, C5300b bVar) {
        String d = fVar.mo27205d();
        String e = fVar.mo27206e();
        String f = fVar.mo27207f();
        if (context == null || file == null || obj == null || fVar == null || bVar == null || d == null || e == null || f == null) {
            throw new C5297b("parameters could not be null");
        }
    }
}
