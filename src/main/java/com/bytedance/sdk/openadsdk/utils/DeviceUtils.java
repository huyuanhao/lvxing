package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.tencent.mid.api.MidEntity;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.utils.i */
public class DeviceUtils {
    /* renamed from: a */
    public static String m12161a() {
        String a = m12162a("wlan0");
        if (TextUtils.isEmpty(a)) {
            a = m12162a("eth0");
        }
        return TextUtils.isEmpty(a) ? "DU:MM:YA:DD:RE:SS" : a;
    }

    /* renamed from: a */
    private static String m12162a(String str) {
        String str2 = "";
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return str2;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte valueOf : hardwareAddress) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(valueOf)}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    /* renamed from: a */
    public static String m12163a(boolean z) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            boolean z2 = inetAddress instanceof Inet4Address;
                            String upperCase = inetAddress.getHostAddress().toUpperCase();
                            if (z) {
                                if (z2) {
                                    return upperCase;
                                }
                            } else if (!z2) {
                                int indexOf = upperCase.indexOf(37);
                                if (indexOf >= 0) {
                                    upperCase = upperCase.substring(0, indexOf);
                                }
                                return upperCase;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: a */
    public static boolean m12164a(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m12165b(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static int m12166c(Context context) {
        if (m12165b(context)) {
            return 3;
        }
        return m12164a(context) ? 2 : 1;
    }

    /* renamed from: d */
    public static JSONObject m12167d(Context context) {
        String str = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MidEntity.TAG_IMEI, IdUtils.m9866d(context));
            jSONObject.put("android_id", IdUtils.m9865c(context));
            jSONObject.put("uuid", IdUtils.m9867e(context));
            jSONObject.put("ssid", IdUtils.m9869g(context));
            jSONObject.put("wifi_mac", IdUtils.m9870h(context));
            jSONObject.put("imsi", IdUtils.m9868f(context));
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            sb.append(str);
            jSONObject.put("power_on_time", sb.toString());
            jSONObject.put("rom_version", RomUtils.m11943a());
            jSONObject.put("sys_compiling_time", IdUtils.m9864b(context));
            jSONObject.put("type", m12166c(context));
            jSONObject.put("os", 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(VERSION.RELEASE);
            sb2.append(str);
            jSONObject.put("os_version", sb2.toString());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", C2566w.m12243b(context));
            jSONObject.put(MidEntity.TAG_MAC, m12161a());
            jSONObject.put("screen_width", UIUtils.m12078c(context));
            jSONObject.put("screen_height", UIUtils.m12084d(context));
            jSONObject.put("oaid", OAIDHelper.m12248a());
            jSONObject.put("free_space", FreeSpaceHelper.f9175a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
