package com.qiyukf.nimlib.p486j.p487a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.qiyukf.basesdk.p393a.C5264a;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mid.core.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.j.a.a */
public final class C5930a {

    /* renamed from: com.qiyukf.nimlib.j.a.a$a */
    public static class C5932a extends C5933b {
        /* renamed from: a */
        public String f18738a;
        /* renamed from: b */
        public String f18739b;
        /* renamed from: c */
        public String f18740c;
        /* renamed from: d */
        public String f18741d;

        public C5932a(String str, String str2) {
            super(str, str2);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("NIMConnectedWifiInfo{bssid='");
            sb.append(this.f18742e);
            sb.append('\'');
            sb.append(",ssid='");
            sb.append(this.f18743f);
            sb.append('\'');
            sb.append(",frequency=");
            sb.append(this.f18744g);
            sb.append(",speed=");
            sb.append(this.f18745h);
            sb.append(",rssi=");
            sb.append(this.f18746i);
            sb.append(",ip='");
            sb.append(this.f18747j);
            sb.append('\'');
            sb.append(",dns1='");
            sb.append(this.f18738a);
            sb.append('\'');
            sb.append(",dns2='");
            sb.append(this.f18739b);
            sb.append('\'');
            sb.append(",gateway='");
            sb.append(this.f18740c);
            sb.append('\'');
            sb.append(",netmask='");
            sb.append(this.f18741d);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: com.qiyukf.nimlib.j.a.a$b */
    public static class C5933b {
        /* renamed from: e */
        public String f18742e;
        /* renamed from: f */
        public String f18743f;
        /* renamed from: g */
        public int f18744g;
        /* renamed from: h */
        public int f18745h;
        /* renamed from: i */
        public int f18746i;
        /* renamed from: j */
        public String f18747j;

        public C5933b(String str, String str2) {
            this.f18742e = str;
            this.f18743f = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NIMWifiInfo{bssid='");
            sb.append(this.f18742e);
            sb.append('\'');
            sb.append(",ssid='");
            sb.append(this.f18743f);
            sb.append('\'');
            sb.append(",frequency=");
            sb.append(this.f18744g);
            sb.append(",speed=");
            sb.append(this.f18745h);
            sb.append(",rssi=");
            sb.append(this.f18746i);
            sb.append(",ip='");
            sb.append(this.f18747j);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static C5932a m23787a(Context context) {
        String str = ".";
        WifiManager c = m23790c(context);
        if (c == null) {
            return null;
        }
        String str2 = "stat";
        C5264a.m21620b(str2, "begin to get connected wifi info...");
        if (!m23791d(context)) {
            C5264a.m21620b(str2, "unable to get connected wifi info, as permission is not granted");
            return null;
        }
        try {
            if (c.isWifiEnabled()) {
                WifiInfo connectionInfo = c.getConnectionInfo();
                if (connectionInfo != null) {
                    DetailedState detailedStateOf = WifiInfo.getDetailedStateOf(connectionInfo.getSupplicantState());
                    if (detailedStateOf == DetailedState.CONNECTED || detailedStateOf == DetailedState.OBTAINING_IPADDR) {
                        if ("00:00:00:00:00:00".equals(connectionInfo.getBSSID())) {
                            return null;
                        }
                        C5932a aVar = new C5932a(connectionInfo.getBSSID(), connectionInfo.getSSID());
                        if (VERSION.SDK_INT >= 21) {
                            aVar.f18744g = connectionInfo.getFrequency();
                        }
                        aVar.f18745h = connectionInfo.getLinkSpeed();
                        aVar.f18746i = connectionInfo.getRssi();
                        int ipAddress = connectionInfo.getIpAddress();
                        StringBuilder sb = new StringBuilder();
                        sb.append(ipAddress & 255);
                        sb.append(str);
                        sb.append((ipAddress >> 8) & 255);
                        sb.append(str);
                        sb.append((ipAddress >> 16) & 255);
                        sb.append(str);
                        sb.append(ipAddress >>> 24);
                        aVar.f18747j = sb.toString();
                        DhcpInfo dhcpInfo = c.getDhcpInfo();
                        aVar.f18738a = m23788a(dhcpInfo.dns1);
                        aVar.f18739b = m23788a(dhcpInfo.dns2);
                        aVar.f18740c = m23788a(dhcpInfo.gateway);
                        aVar.f18741d = m23788a(dhcpInfo.netmask);
                        StringBuilder sb2 = new StringBuilder("find connected wifi: ");
                        sb2.append(aVar.toString());
                        C5264a.m21620b(str2, sb2.toString());
                        return aVar;
                    }
                }
            } else {
                C5264a.m21620b(str2, "wifi is disable");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder sb3 = new StringBuilder("get connected wifi info failed, e=");
            sb3.append(th.getMessage());
            C5264a.m21620b(str2, sb3.toString());
        }
        return null;
    }

    /* renamed from: a */
    private static String m23788a(int i) {
        int i2;
        byte[] bArr = new byte[4];
        int i3 = 0;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            bArr[i3] = (byte) (i >>> ((3 - i3) << 3));
            i3++;
        }
        String str = "";
        for (i2 = 3; i2 >= 0; i2--) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(bArr[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            str = sb.toString();
            if (i2 > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(".");
                str = sb2.toString();
            }
        }
        return str;
    }

    /* renamed from: b */
    public static List<C5933b> m23789b(Context context) {
        WifiManager c = m23790c(context);
        if (c == null) {
            return null;
        }
        String str = "stat";
        C5264a.m21620b(str, "begin to scan wifi list...");
        if (!m23791d(context)) {
            C5264a.m21620b(str, "unable to scan wifi list, as permission is not granted");
            return null;
        }
        try {
            if (c.isWifiEnabled()) {
                List<ScanResult> scanResults = c.getScanResults();
                if (scanResults != null) {
                    if (!scanResults.isEmpty()) {
                        Collections.sort(scanResults, new Comparator<ScanResult>() {
                            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                            }
                        });
                        ArrayList arrayList = new ArrayList(scanResults.size());
                        for (ScanResult scanResult : scanResults) {
                            if (!"00:00:00:00:00:00".equals(scanResult.BSSID)) {
                                C5933b bVar = new C5933b(scanResult.BSSID, scanResult.SSID);
                                bVar.f18744g = scanResult.frequency;
                                bVar.f18746i = scanResult.level;
                                arrayList.add(bVar);
                                StringBuilder sb = new StringBuilder("find wifi: ");
                                sb.append(bVar.toString());
                                C5264a.m21620b(str, sb.toString());
                            }
                        }
                        return arrayList;
                    }
                }
                C5264a.m21620b(str, "find empty wifi node");
                return null;
            }
            C5264a.m21620b(str, "wifi is disable");
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder sb2 = new StringBuilder("scan wifi list failed, e=");
            sb2.append(th.getMessage());
            C5264a.m21620b(str, sb2.toString());
        }
    }

    /* renamed from: c */
    private static WifiManager m23790c(Context context) {
        try {
            return (WifiManager) context.getApplicationContext().getSystemService("wifi");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("get system service WifiManager failed, e=");
            sb.append(th.getMessage());
            C5264a.m21620b("stat", sb.toString());
            return null;
        }
    }

    /* renamed from: d */
    private static boolean m23791d(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        String packageName = context.getApplicationContext().getPackageName();
        boolean z = packageManager.checkPermission(Constants.PERMISSION_ACCESS_WIFI_STATE, packageName) == 0;
        boolean z2 = packageManager.checkPermission(Constants.PERMISSION_ACCESS_NETWORK_STATE, packageName) == 0;
        StringBuilder sb = new StringBuilder("check permission ACCESS_WIFI_STATE ");
        sb.append(z);
        sb.append(", check ACCESS_NETWORK_STATE ");
        sb.append(z2);
        C5264a.m21620b("stat", sb.toString());
        return z && z2;
    }
}
