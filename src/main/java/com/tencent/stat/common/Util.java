package com.tencent.stat.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.tencent.mid.api.MidService;
import com.tencent.mid.core.Constants;
import com.tencent.stat.StatConfig;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Util {
    /* renamed from: a */
    private static String f25648a = null;
    /* renamed from: b */
    private static String f25649b = "";

    public static boolean checkPermission(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "checkPermission error", th);
            return false;
        }
    }

    public static String getSimOperator(Context context) {
        String str = StatConstants.LOG_TAG;
        try {
            if (checkPermission(context, Constants.PERMISSION_READ_PHONE_STATE)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getSimOperator();
                }
                return null;
            }
            Log.e(str, "Could not get permission of android.permission.READ_PHONE_STATE");
            return null;
        } catch (Throwable th) {
            Log.e(str, "", th);
            return null;
        }
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static Integer getTelephonyNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getExternalStorageInfo(Context context) {
        String str = StatConstants.LOG_TAG;
        try {
            if (checkPermission(context, Constants.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    String path = Environment.getExternalStorageDirectory().getPath();
                    if (path != null) {
                        StatFs statFs = new StatFs(path);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        long availableBlocks = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000;
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.valueOf(availableBlocks));
                        sb.append("/");
                        sb.append(String.valueOf(blockCount));
                        return sb.toString();
                    }
                }
                return null;
            }
            Log.e(str, "can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            Log.e(str, "", th);
        }
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static Context getContextSelf(Context context) {
        return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
    }

    public static String getLinkedWay(Context context) {
        String str = StatConstants.LOG_TAG;
        try {
            if (!checkPermission(context, Constants.PERMISSION_INTERNET) || !checkPermission(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                Log.e(str, "can not get the permission of android.permission.ACCESS_WIFI_STATE");
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            String str2 = "MOBILE";
            String str3 = "WIFI";
            if (activeNetworkInfo == null) {
                return null;
            }
            if (!activeNetworkInfo.isConnected()) {
                return null;
            }
            String typeName = activeNetworkInfo.getTypeName();
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (typeName == null) {
                return null;
            }
            if (typeName.equalsIgnoreCase(str3)) {
                return str3;
            }
            if (typeName.equalsIgnoreCase(str2)) {
                if (extraInfo == null || extraInfo.trim().length() <= 0) {
                    return str2;
                }
            } else if (extraInfo == null || extraInfo.trim().length() <= 0) {
                return typeName;
            }
            return extraInfo;
        } catch (Throwable th) {
            Log.e(str, "", th);
            return null;
        }
    }

    public static String getDeviceID(Context context) {
        String str = StatConstants.LOG_TAG;
        try {
            if (checkPermission(context, Constants.PERMISSION_READ_PHONE_STATE)) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            } else {
                Log.e(str, "Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            Log.e(str, "get device id error", th);
        }
        return null;
    }

    public static boolean isIMEI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.trim().length();
        if (length == 14 || length == 15) {
            return true;
        }
        return false;
    }

    public static String getNewUi(Context context) {
        if (TextUtils.isEmpty(f25648a)) {
            String deviceID = getDeviceID(context);
            if (isIMEI(deviceID)) {
                f25648a = deviceID;
            }
        }
        return f25648a;
    }

    public static String getWifiMacAddress(Context context) {
        boolean checkPermission = checkPermission(context, Constants.PERMISSION_ACCESS_WIFI_STATE);
        String str = StatConstants.LOG_TAG;
        String str2 = "";
        if (checkPermission) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    return str2;
                }
                return wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                Log.e(str, "get wifi address error", e);
                return str2;
            }
        } else {
            Log.e(str, "Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return str2;
        }
    }

    public static String decode(String str) {
        String str2 = "UTF-8";
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C7598e.m32762b(C7601h.m32774a(str.getBytes(str2), 0)), str2);
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "decode error", th);
            return str;
        }
    }

    public static String encode(String str) {
        String str2 = "UTF-8";
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C7601h.m32776b(C7598e.m32760a(str.getBytes(str2)), 0), str2);
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "encode error", th);
            return str;
        }
    }

    public static void jsonPut(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                Log.e(StatConstants.LOG_TAG, "jsonPut error", th);
            }
        }
    }

    public static void safeJsonPut(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            Log.e(StatConstants.LOG_TAG, "safeJsonPut error", e);
        }
    }

    public static WifiInfo getWifiInfo(Context context) {
        if (checkPermission(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    public static JSONObject getConnecetedWifiInfo(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        if (wifiInfo != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bs", wifiInfo.getBSSID());
                jSONObject.put("ss", wifiInfo.getSSID());
                jSONObject.put("dBm", wifiInfo.getRssi());
                return jSONObject;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String getWiFiBBSID(Context context) {
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                return wifiInfo.getBSSID();
            }
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "encode error", th);
        }
        return null;
    }

    public static String getWiFiSSID(Context context) {
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                return wifiInfo.getSSID();
            }
        } catch (Throwable th) {
            Log.e(StatConstants.LOG_TAG, "encode error", th);
        }
        return null;
    }

    public static boolean isNetworkAvailable(Context context) {
        String str = StatConstants.LOG_TAG;
        try {
            if (!checkPermission(context, Constants.PERMISSION_INTERNET) || !checkPermission(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                Log.e(str, "can not get the permisson of android.permission.INTERNET");
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    return true;
                }
                Log.w(str, "Network error");
                return false;
            }
            return false;
        } catch (Throwable th) {
            Log.e(str, "isNetworkAvailable error", th);
        }
    }

    public static boolean isWifiNet(Context context) {
        String str = StatConstants.LOG_TAG;
        boolean z = false;
        try {
            if (!checkPermission(context, Constants.PERMISSION_INTERNET) || !checkPermission(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                Log.e(str, "can not get the permisson of android.permission.INTERNET");
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    z = true;
                }
                return z;
            }
            return false;
        } catch (Throwable th) {
            Log.e(str, "isWifiNet error", th);
        }
    }

    public static JSONArray getWifiTopN(Context context, int i) {
        String str = StatConstants.LOG_TAG;
        try {
            if (!StatConfig.isEnableReportWifiList()) {
                return null;
            }
            if (!checkPermission(context, Constants.PERMISSION_INTERNET) || !checkPermission(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                Log.e(str, "can not get the permisson of android.permission.INTERNET");
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                List scanResults = wifiManager.getScanResults();
                if (scanResults != null && scanResults.size() > 0) {
                    Collections.sort(scanResults, new Comparator<ScanResult>() {
                        /* renamed from: a */
                        public int compare(ScanResult scanResult, ScanResult scanResult2) {
                            int abs = Math.abs(scanResult.level);
                            int abs2 = Math.abs(scanResult2.level);
                            if (abs > abs2) {
                                return 1;
                            }
                            return abs == abs2 ? 0 : -1;
                        }
                    });
                    JSONArray jSONArray = new JSONArray();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= scanResults.size()) {
                            break;
                        } else if (i2 >= i) {
                            break;
                        } else {
                            ScanResult scanResult = (ScanResult) scanResults.get(i2);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bs", scanResult.BSSID);
                            jSONObject.put("ss", scanResult.SSID);
                            jSONObject.put("dBm", scanResult.level);
                            jSONArray.put(jSONObject);
                            i2++;
                        }
                    }
                    return jSONArray;
                }
            }
            return null;
        } catch (Throwable th) {
            Log.e(str, "isWifiNet error", th);
        }
    }

    public static String getMid(Context context) {
        if (com.tencent.mid.util.Util.isMidValid(f25649b)) {
            return f25649b;
        }
        return MidService.getMid(context);
    }
}
