package com.p522qq.p523e.comm.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.tencent.android.tpush.common.Constants;

/* renamed from: com.qq.e.comm.util.SystemUtil */
public final class SystemUtil {
    public static String buildNewPathByProcessName(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        String processName = GDTADManager.getInstance().getProcessName();
        if (!StringUtil.isEmpty(processName)) {
            String str2 = "_";
            boolean endsWith = processName.endsWith(str2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (endsWith) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(Md5Util.encode(processName));
            str = sb.toString();
        }
        return str;
    }

    public static String getProcessName(Context context) {
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
            try {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
