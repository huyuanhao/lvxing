package btmsdkobf;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.net.NetworkInterface;

/* renamed from: btmsdkobf.ez */
public class C0836ez {
    /* renamed from: A */
    private static String m878A(String str) {
        try {
            NetworkInterface byName = NetworkInterface.getByName(str);
            byte[] hardwareAddress = byName != null ? byName.getHardwareAddress() : null;
            if (hardwareAddress == null) {
                return null;
            }
            if (hardwareAddress.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (byte valueOf : hardwareAddress) {
                sb.append(String.format("%02x:", new Object[]{Byte.valueOf(valueOf)}));
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: B */
    private static String m879B(String str) {
        try {
            byte[] z = m881z(String.format("/sys/class/net/%s/address", new Object[]{str}));
            if (z == null || z.length <= 0) {
                return null;
            }
            return new String(z).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: r */
    public static String m880r(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
            }
        } catch (Throwable unused) {
        }
        String str2 = "02:00:00:00:00:00";
        if (!TextUtils.isEmpty(str) && !str2.equals(str)) {
            return str;
        }
        String str3 = "wlan0";
        String A = m878A(str3);
        return (TextUtils.isEmpty(A) || str2.equals(A)) ? m879B(str3) : A;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0036, code lost:
            if (r1 == null) goto L_0x0039;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0025 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031 A[SYNTHETIC, Splitter:B:22:0x0031] */
    /* renamed from: z */
    private static byte[] m881z(java.lang.String r5) {
        /*
        r0 = 0
        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x002d }
        r1.<init>(r5)     // Catch:{ all -> 0x002d }
        java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x002b }
        int r2 = r1.available()     // Catch:{ all -> 0x002b }
        r5.<init>(r2)     // Catch:{ all -> 0x002b }
        r2 = 1024(0x400, float:1.435E-42)
        byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0029 }
    L_0x0013:
        int r3 = r1.read(r2)     // Catch:{ all -> 0x0029 }
        if (r3 <= 0) goto L_0x001e
        r4 = 0
        r5.write(r2, r4, r3)     // Catch:{ all -> 0x0029 }
        goto L_0x0013
    L_0x001e:
        byte[] r0 = r5.toByteArray()     // Catch:{ all -> 0x0029 }
        r5.close()     // Catch:{ all -> 0x0025 }
    L_0x0025:
        r1.close()     // Catch:{ all -> 0x0039 }
        goto L_0x0039
        goto L_0x002f
    L_0x002b:
        r5 = r0
        goto L_0x002f
    L_0x002d:
        r5 = r0
        r1 = r5
    L_0x002f:
        if (r5 == 0) goto L_0x0036
        r5.close()     // Catch:{ all -> 0x0035 }
        goto L_0x0036
    L_0x0036:
        if (r1 == 0) goto L_0x0039
        goto L_0x0025
    L_0x0039:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0836ez.m881z(java.lang.String):byte[]");
    }
}
