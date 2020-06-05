package com.tencent.bigdata.dataacquisition;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.bigdata.dataacquisition.p600a.C7113a;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeviceInfos {
    public static final byte NETWORK_TYPE_2G = 2;
    public static final byte NETWORK_TYPE_3G = 3;
    public static final byte NETWORK_TYPE_4G = 4;
    public static final byte NETWORK_TYPE_UNCONNECTED = -1;
    public static final byte NETWORK_TYPE_UNKNOWN = 0;
    public static final byte NETWORK_TYPE_WIFI = 1;

    public static int checkBluetooth(Context context) {
        return C7113a.m30502k(context);
    }

    public static JSONObject getCpuInfo(Context context) {
        return C7113a.m30504m(context);
    }

    public static String getCpuString() {
        return C7113a.m30487a();
    }

    public static String getCpuType() {
        return C7113a.m30488b();
    }

    public static String getDeviceModel(Context context) {
        return C7113a.m30498g(context);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return C7113a.m30497f(context);
    }

    public static String getExternalStorageInfo(Context context) {
        return C7113a.m30501j(context);
    }

    public static String getLinkedWay(Context context) {
        return C7113a.m30494e(context);
    }

    public static byte getNetworkType(Context context) {
        return C7113a.m30490c(context);
    }

    public static String getRomMemory() {
        return C7113a.m30491c();
    }

    public static JSONArray getSensorsJson(Context context) {
        return C7113a.m30506o(context);
    }

    public static String getSensorsString(Context context) {
        return C7113a.m30505n(context);
    }

    public static String getSystemMemory(Context context) {
        return C7113a.m30503l(context);
    }

    public static Integer getTelephonyNetworkType(Context context) {
        return C7113a.m30486a(context);
    }

    public static long getTotalInternalMemorySize() {
        return C7113a.m30492d();
    }

    public static int hasRootAccess(Context context) {
        return C7113a.m30500i(context);
    }

    public static boolean haveGravity(Context context) {
        return C7113a.m30499h(context);
    }

    public static boolean isNetworkAvailable(Context context) {
        return C7113a.m30489b(context);
    }

    public static boolean isSDCardMounted() {
        return C7113a.m30495e();
    }

    public static boolean isWifiNet(Context context) {
        return C7113a.m30493d(context);
    }
}
