package com.tencent.bigdata.customdataacquisition.intf;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import com.tencent.bigdata.customdataacquisition.p598a.C7104a;
import com.tencent.bigdata.customdataacquisition.p598a.C7105b;
import com.tencent.bigdata.customdataacquisition.p598a.C7109c;
import com.tencent.bigdata.customdataacquisition.p598a.C7110d;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CustomDeviceInfos {
    public static String getAndroidId(Context context) {
        return C7109c.m30470d(context);
    }

    public static String getDeviceId(Context context) {
        return C7109c.m30467a(context);
    }

    public static String getImsi(Context context) {
        return C7109c.m30468b(context);
    }

    public static List<PackageInfo> getInstalledPackages(Context context) {
        return C7104a.m30445d(context);
    }

    public static String getIp(Context context) {
        return C7110d.m30473b(context);
    }

    public static String getMacAddress(Context context) {
        return C7110d.m30471a(context);
    }

    public static Map<String, Integer> getRecentTasks(Context context) {
        return C7104a.m30444c(context);
    }

    public static JSONObject getReportLocationJson(Context context) {
        return C7105b.m30453f(context);
    }

    public static Map<String, RunningAppProcessInfo> getRunningAppProces(Context context) {
        return C7104a.m30443b(context);
    }

    public static Map<String, Integer> getRunningProcess(Context context) {
        return C7104a.m30442a(context);
    }

    public static String getSimOperator(Context context) {
        return C7109c.m30469c(context);
    }

    public static String getWiFiBBSID(Context context) {
        return C7110d.m30475d(context);
    }

    public static String getWiFiSSID(Context context) {
        return C7110d.m30476e(context);
    }

    public static WifiInfo getWifiInfo(Context context) {
        return C7110d.m30474c(context);
    }

    public static JSONArray getWifiTopN(Context context, int i) {
        return C7110d.m30472a(context, i);
    }
}
