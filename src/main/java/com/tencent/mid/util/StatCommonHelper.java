package com.tencent.mid.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Process;
import android.webkit.WebSettings;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class StatCommonHelper {
    private static String curAppMd5Signature;
    private static String curAppSHA1Signature;
    private static String curProcessName = null;
    private static Logger logger = Util.getLogger();

    public static String getPackageName(Context context) {
        if (Util.checkPermission(context, "android.permission.GET_TASKS")) {
            List runningTasks = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                return ((RunningTaskInfo) runningTasks.get(0)).topActivity.getPackageName();
            }
        } else {
            logger.mo35696e((Object) "Could not get permission of android.permission.GET_TASKS");
        }
        return null;
    }

    public static String getCurAppVersion(Context context) {
        String str;
        String str2 = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str == null) {
                return str2;
            }
            return str;
        } catch (Throwable th) {
            logger.mo35696e(th);
            str = str2;
        }
    }

    public static String getAppVersion(Context context) {
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str == null || str.length() == 0) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
        } catch (Throwable th) {
            logger.mo35696e(th);
        }
        return str;
    }

    static {
        String str = "";
        curAppMd5Signature = str;
        curAppSHA1Signature = str;
    }

    static String getCurProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean isStringValid(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static String getCurAppMd5Signature(Context context) {
        if (isStringValid(curAppMd5Signature)) {
            return curAppMd5Signature;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            String str = "";
            if (packageInfo == null) {
                logger.mo35696e((Object) "packageInfo is null ");
                return str;
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null) {
                if (signatureArr.length != 0) {
                    curAppMd5Signature = Util.md5sum(signatureArr[0].toCharsString());
                    return curAppMd5Signature;
                }
            }
            logger.mo35696e((Object) "signatures is null");
            return str;
        } catch (Throwable th) {
            logger.mo35696e(th);
        }
    }

    public static String getCurAppSHA1Signature(Context context) {
        if (isStringValid(curAppSHA1Signature)) {
            return curAppSHA1Signature;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            String str = "";
            if (packageInfo == null) {
                logger.mo35696e((Object) "packageInfo is null ");
                return str;
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null) {
                if (signatureArr.length != 0) {
                    byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = digest.length;
                    for (int i = 0; i < length; i++) {
                        String upperCase = Integer.toHexString(digest[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED).toUpperCase(Locale.US);
                        if (upperCase.length() == 1) {
                            stringBuffer.append("0");
                        }
                        stringBuffer.append(upperCase);
                        if (i != length - 1) {
                            stringBuffer.append(":");
                        }
                    }
                    curAppSHA1Signature = stringBuffer.toString();
                    return curAppSHA1Signature;
                }
            }
            logger.mo35696e((Object) "signatures is null");
            return str;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static long getTomorrowStartMilliseconds() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            logger.mo35696e(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static String getDateString(int i) {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static boolean isMainProcess(Context context) {
        return context.getPackageName().equals(getCurProcessName(context));
    }

    public static String getUserAgent(Context context) {
        String str;
        String str2 = "http.agent";
        if (VERSION.SDK_INT >= 17) {
            try {
                str = WebSettings.getDefaultUserAgent(context);
            } catch (Exception unused) {
                str = System.getProperty(str2);
            }
        } else {
            str = System.getProperty(str2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }
}
