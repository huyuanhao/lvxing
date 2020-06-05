package com.tencent.bigdata.dataacquisition;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.util.Log;
import com.tencent.bigdata.reflecttools.Reflect;
import com.tencent.bigdata.reflecttools.ReflectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CustomDeviceInfos {
    private static final String DEVICEINFOS_REAL_CLASSNAME = "com.tencent.bigdata.customdataacquisition.intf.CustomDeviceInfos";
    private static boolean isWarned = false;
    private static Boolean ismportImplClassFlag;

    public static String getAndroidId(Context context) {
        try {
            return (String) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getAndroidId", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getDeviceId(Context context) {
        try {
            return (String) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getDeviceId", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getImsi(Context context) {
        try {
            return (String) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getImsi", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static List<PackageInfo> getInstalledPackages(Context context) {
        try {
            return (List) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getInstalledPackages", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return new ArrayList();
        }
    }

    public static String getIp(Context context) {
        try {
            return (String) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getIp", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getMacAddress(Context context) {
        try {
            return (String) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getMacAddress", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static Map<String, Integer> getRecentTasks(Context context) {
        try {
            return (Map) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getRecentTasks", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return new HashMap();
        }
    }

    public static JSONObject getReportLocationJson(Context context) {
        try {
            return (JSONObject) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getReportLocationJson", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return null;
        }
    }

    public static Map<String, RunningAppProcessInfo> getRunningAppProces(Context context) {
        try {
            return (Map) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getRunningAppProces", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return new HashMap();
        }
    }

    public static Map<String, Integer> getRunningProcess(Context context) {
        try {
            return (Map) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getRunningProcess", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return new HashMap();
        }
    }

    public static String getSimOperator(Context context) {
        try {
            return (String) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getSimOperator", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getWiFiBBSID(Context context) {
        try {
            return (String) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getWiFiBBSID", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static String getWiFiSSID(Context context) {
        try {
            return (String) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getWiFiSSID", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return "";
        }
    }

    public static WifiInfo getWifiInfo(Context context) {
        try {
            return (WifiInfo) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getWifiInfo", context).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return null;
        }
    }

    public static JSONArray getWifiTopN(Context context, int i) {
        try {
            return (JSONArray) Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME).call("getWifiTopN", context, Integer.valueOf(i)).get();
        } catch (ReflectException e) {
            showWarnMessage(e);
            return null;
        }
    }

    public static boolean isImportImplClass() {
        Boolean bool = ismportImplClassFlag;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Reflect.m30521on(DEVICEINFOS_REAL_CLASSNAME);
            ismportImplClassFlag = Boolean.valueOf(true);
        } catch (ReflectException unused) {
            Log.w("DataAcq", "isImportImplClass false");
            ismportImplClassFlag = Boolean.valueOf(false);
        }
        return ismportImplClassFlag.booleanValue();
    }

    private static void showWarnMessage(ReflectException reflectException) {
        if (!isWarned) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not allow get DeviceInfos ? ReflectException:");
            sb.append(reflectException.getMessage());
            Log.w("DataAcq", sb.toString());
            isWarned = true;
        }
    }
}
