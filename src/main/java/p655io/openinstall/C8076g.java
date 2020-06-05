package p655io.openinstall;

import android.content.Context;
import java.util.IdentityHashMap;

/* renamed from: io.openinstall.g */
public class C8076g {
    /* renamed from: n */
    private static final Object f27380n = new Object();
    /* renamed from: a */
    private final Context f27381a;
    /* renamed from: b */
    private final String f27382b;
    /* renamed from: c */
    private final String f27383c;
    /* renamed from: d */
    private final Integer f27384d;
    /* renamed from: e */
    private final String f27385e;
    /* renamed from: f */
    private final String f27386f;
    /* renamed from: g */
    private final String f27387g;
    /* renamed from: h */
    private final String f27388h;
    /* renamed from: i */
    private final String f27389i;
    /* renamed from: j */
    private final String f27390j;
    /* renamed from: k */
    private final String f27391k;
    /* renamed from: l */
    private final String f27392l;
    /* renamed from: m */
    private final IdentityHashMap f27393m = new IdentityHashMap();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004c, code lost:
            if (r0.hasMoreElements() == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
            r2 = ((java.net.NetworkInterface) r0.nextElement()).getInetAddresses();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
            if (r2.hasMoreElements() == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005e, code lost:
            r3 = (java.net.InetAddress) r2.nextElement();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0068, code lost:
            if (r3.isLoopbackAddress() != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
            r6.f27393m.put(new java.lang.String("localIP"), r3.getHostAddress());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
            if (r0 != null) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8 A[SYNTHETIC, Splitter:B:32:0x00a8] */
    public C8076g(android.content.Context r7) {
        /*
        r6 = this;
        r6.<init>()
        java.util.IdentityHashMap r0 = new java.util.IdentityHashMap
        r0.<init>()
        r6.f27393m = r0
        r6.f27381a = r7
        java.lang.String r0 = r7.getPackageName()
        r6.f27382b = r0
        java.lang.String r0 = android.os.Build.VERSION.RELEASE
        r6.f27383c = r0
        android.content.Context r0 = r6.f27381a
        android.content.pm.PackageManager r0 = r0.getPackageManager()
        r1 = 0
        android.content.Context r2 = r6.f27381a     // Catch:{ NameNotFoundException -> 0x002f }
        java.lang.String r2 = r2.getPackageName()     // Catch:{ NameNotFoundException -> 0x002f }
        r3 = 0
        android.content.pm.PackageInfo r0 = r0.getPackageInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x002f }
        int r0 = r0.versionCode     // Catch:{ NameNotFoundException -> 0x002f }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NameNotFoundException -> 0x002f }
        goto L_0x0030
    L_0x002f:
        r0 = r1
    L_0x0030:
        r6.f27384d = r0
        java.lang.String r0 = android.os.Build.MODEL
        r6.f27385e = r0
        java.lang.String r0 = android.os.Build.ID
        r6.f27386f = r0
        java.lang.String r0 = android.os.Build.DISPLAY
        r6.f27387g = r0
        java.lang.String r0 = android.os.Build.BRAND
        r6.f27388h = r0
        java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ SocketException -> 0x007b }
        if (r0 == 0) goto L_0x007b
    L_0x0048:
        boolean r2 = r0.hasMoreElements()     // Catch:{ SocketException -> 0x007b }
        if (r2 == 0) goto L_0x007b
        java.lang.Object r2 = r0.nextElement()     // Catch:{ SocketException -> 0x007b }
        java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2     // Catch:{ SocketException -> 0x007b }
        java.util.Enumeration r2 = r2.getInetAddresses()     // Catch:{ SocketException -> 0x007b }
    L_0x0058:
        boolean r3 = r2.hasMoreElements()     // Catch:{ SocketException -> 0x007b }
        if (r3 == 0) goto L_0x0048
        java.lang.Object r3 = r2.nextElement()     // Catch:{ SocketException -> 0x007b }
        java.net.InetAddress r3 = (java.net.InetAddress) r3     // Catch:{ SocketException -> 0x007b }
        boolean r4 = r3.isLoopbackAddress()     // Catch:{ SocketException -> 0x007b }
        if (r4 != 0) goto L_0x0058
        java.lang.String r4 = new java.lang.String     // Catch:{ SocketException -> 0x007b }
        java.lang.String r5 = "localIP"
        r4.<init>(r5)     // Catch:{ SocketException -> 0x007b }
        java.util.IdentityHashMap r5 = r6.f27393m     // Catch:{ SocketException -> 0x007b }
        java.lang.String r3 = r3.getHostAddress()     // Catch:{ SocketException -> 0x007b }
        r5.put(r4, r3)     // Catch:{ SocketException -> 0x007b }
        goto L_0x0058
    L_0x007b:
        java.lang.String r0 = "phone"
        java.lang.Object r0 = r7.getSystemService(r0)
        android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
        java.lang.String r0 = r0.getDeviceId()     // Catch:{ SecurityException -> 0x0088 }
        goto L_0x0089
    L_0x0088:
        r0 = r1
    L_0x0089:
        r6.f27389i = r0
        java.lang.String r0 = "wifi"
        java.lang.Object r0 = r7.getSystemService(r0)
        android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0
        android.net.wifi.WifiInfo r0 = r0.getConnectionInfo()     // Catch:{ SecurityException -> 0x009c }
        java.lang.String r0 = r0.getMacAddress()     // Catch:{ SecurityException -> 0x009c }
        goto L_0x009d
    L_0x009c:
        r0 = r1
    L_0x009d:
        r6.f27390j = r0
        int r0 = android.os.Build.VERSION.SDK_INT
        r2 = 26
        if (r0 >= r2) goto L_0x00a8
        java.lang.String r1 = android.os.Build.SERIAL
        goto L_0x00ac
    L_0x00a8:
        java.lang.String r1 = android.os.Build.getSerial()     // Catch:{ SecurityException -> 0x00ac }
    L_0x00ac:
        r6.f27391k = r1
        android.content.ContentResolver r7 = r7.getContentResolver()
        java.lang.String r0 = "android_id"
        java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r0)
        r6.f27392l = r7
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: p655io.openinstall.C8076g.m54636init(android.content.Context):void");
    }
}
