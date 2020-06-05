package mtopsdk.xstate.p692a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import java.util.Locale;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.TBSdkLog.LogEnable;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.NetworkClassEnum;
import mtopsdk.xstate.XState;

/* renamed from: mtopsdk.xstate.a.a */
public final class NetworkStateReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static ConnectivityManager f28059a = null;
    /* renamed from: b */
    private static WifiManager f28060b = null;
    /* renamed from: c */
    private static volatile String f28061c = "";
    /* renamed from: d */
    private static volatile String f28062d = "";
    /* renamed from: e */
    private static volatile String f28063e = "unknown";

    public final void onReceive(Context context, Intent intent) {
        if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
            TBSdkLog.m35506b("mtopsdk.NetworkStateReceiver", "[onReceive] networkStateReceiver onReceive");
        }
        MtopSDKThreadPoolExecutorFactory.m35583a(new C8345b(this, context));
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo39881a(Context context) {
        NetworkInfo networkInfo;
        NetworkClassEnum networkClassEnum;
        String str;
        String str2 = "mtopsdk.NetworkStateReceiver";
        if (context != null) {
            WifiInfo wifiInfo = null;
            try {
                if (f28059a == null) {
                    f28059a = (ConnectivityManager) context.getSystemService("connectivity");
                }
                networkInfo = f28059a.getActiveNetworkInfo();
            } catch (Throwable th) {
                TBSdkLog.m35504a(str2, "getNetworkInfo error.", th);
                networkInfo = null;
            }
            String str3 = "netType";
            String str4 = "nq";
            if (networkInfo == null || !networkInfo.isConnected()) {
                if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                    TBSdkLog.m35506b(str2, "[updateNetworkStatus]no network");
                }
                XState.m35599b(str4, NetworkClassEnum.NET_NO.getNetClass());
                XState.m35599b(str3, NetworkClassEnum.NET_NO.getNetClass());
                return;
            }
            int type = networkInfo.getType();
            if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                StringBuilder sb = new StringBuilder("[updateNetworkStatus] NetworkInfo isConnected=");
                sb.append(networkInfo.isConnected());
                sb.append(", isAvailable=");
                sb.append(networkInfo.isAvailable());
                sb.append(", type=");
                sb.append(m35601a(type));
                TBSdkLog.m35506b(str2, sb.toString());
            }
            if (type == 0) {
                int subtype = networkInfo.getSubtype();
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        networkClassEnum = NetworkClassEnum.NET_2G;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        networkClassEnum = NetworkClassEnum.NET_3G;
                        break;
                    case 13:
                        networkClassEnum = NetworkClassEnum.NET_4G;
                        break;
                    default:
                        networkClassEnum = NetworkClassEnum.NET_UNKONWN;
                        break;
                }
                if (TBSdkLog.m35509b(LogEnable.DebugEnable)) {
                    StringBuilder sb2 = new StringBuilder("[updateNetworkStatus]Mobile network,");
                    sb2.append(networkClassEnum.getNetClass());
                    TBSdkLog.m35501a(str2, sb2.toString());
                }
                String extraInfo = networkInfo.getExtraInfo();
                boolean isEmpty = TextUtils.isEmpty(extraInfo);
                String str5 = "ctnet";
                String str6 = "3gnet";
                String str7 = "uninet";
                String str8 = "cmnet";
                String str9 = "ctwap";
                String str10 = "3gwap";
                String str11 = "uniwap";
                String str12 = "cmwap";
                String str13 = EnvironmentCompat.MEDIA_UNKNOWN;
                if (!isEmpty) {
                    String lowerCase = extraInfo.toLowerCase(Locale.US);
                    if (lowerCase.contains(str12)) {
                        str13 = str12;
                    } else if (lowerCase.contains(str11)) {
                        str13 = str11;
                    } else if (lowerCase.contains(str10)) {
                        str13 = str10;
                    } else if (lowerCase.contains(str9)) {
                        str13 = str9;
                    } else if (lowerCase.contains(str8)) {
                        str13 = str8;
                    } else if (lowerCase.contains(str7)) {
                        str13 = str7;
                    } else if (lowerCase.contains(str6)) {
                        str13 = str6;
                    } else if (lowerCase.contains(str5)) {
                        str13 = str5;
                    }
                }
                f28063e = str13;
                XState.m35599b(str4, networkClassEnum.getNetClass());
                switch (subtype) {
                    case 1:
                        str = "GPRS";
                        break;
                    case 2:
                        str = "EDGE";
                        break;
                    case 3:
                        str = "UMTS";
                        break;
                    case 4:
                        str = "CDMA";
                        break;
                    case 5:
                        str = "CDMA - EvDo rev. 0";
                        break;
                    case 6:
                        str = "CDMA - EvDo rev. A";
                        break;
                    case 7:
                        str = "CDMA - 1xRTT";
                        break;
                    case 8:
                        str = "HSDPA";
                        break;
                    case 9:
                        str = "HSUPA";
                        break;
                    case 10:
                        str = "HSPA";
                        break;
                    case 11:
                        str = "iDEN";
                        break;
                    case 12:
                        str = "CDMA - EvDo rev. B";
                        break;
                    case 13:
                        str = "LTE";
                        break;
                    case 14:
                        str = "CDMA - eHRPD";
                        break;
                    case 15:
                        str = "HSPA+";
                        break;
                    default:
                        str = "UNKNOWN";
                        break;
                }
                XState.m35599b(str3, str);
            } else if (type == 1) {
                try {
                    if (f28060b == null) {
                        f28060b = (WifiManager) context.getSystemService("wifi");
                    }
                    wifiInfo = f28060b.getConnectionInfo();
                } catch (Throwable th2) {
                    TBSdkLog.m35504a(str2, "[updateNetworkStatus]getWifiInfo error.", th2);
                }
                if (wifiInfo != null) {
                    f28062d = wifiInfo.getBSSID();
                    f28061c = wifiInfo.getSSID();
                }
                if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                    StringBuilder sb3 = new StringBuilder("[updateNetworkStatus]WIFI network.ssid= ");
                    sb3.append(f28061c);
                    sb3.append(", bssid=");
                    sb3.append(f28062d);
                    TBSdkLog.m35506b(str2, sb3.toString());
                }
                XState.m35599b(str4, NetworkClassEnum.NET_WIFI.getNetClass());
                XState.m35599b(str3, NetworkClassEnum.NET_WIFI.getNetClass());
            } else if (type != 9) {
                String a = m35601a(type);
                XState.m35599b(str4, a);
                XState.m35599b(str3, a);
            } else {
                XState.m35599b(str4, NetworkClassEnum.NET_ETHERNET.getNetClass());
                XState.m35599b(str3, NetworkClassEnum.NET_ETHERNET.getNetClass());
            }
        }
    }

    /* renamed from: a */
    private static String m35601a(int i) {
        switch (i) {
            case 0:
                return "MOBILE";
            case 1:
                return "WIFI";
            case 2:
                return "MOBILE_MMS";
            case 3:
                return "MOBILE_SUPL";
            case 4:
                return "MOBILE_DUN";
            case 5:
                return "MOBILE_HIPRI";
            case 6:
                return "WIMAX";
            case 7:
                return "BLUETOOTH";
            case 8:
                return "DUMMY";
            case 9:
                return "ETHERNET";
            case 10:
                return "MOBILE_FOTA";
            case 11:
                return "MOBILE_IMS";
            case 12:
                return "MOBILE_CBS";
            case 13:
                return "WIFI_P2P";
            case 14:
                return "MOBILE_IA";
            case 15:
                return "MOBILE_EMERGENCY";
            case 16:
                return "PROXY";
            case 17:
                return "VPN";
            default:
                return Integer.toString(i);
        }
    }
}
