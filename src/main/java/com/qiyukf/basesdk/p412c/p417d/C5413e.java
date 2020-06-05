package com.qiyukf.basesdk.p412c.p417d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.tencent.android.tpush.common.Constants;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qiyukf.basesdk.c.d.e */
public final class C5413e {
    /* renamed from: a */
    public static String m22152a(Context context) {
        return m22156c(context);
    }

    /* renamed from: a */
    public static void m22153a(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("start service: ");
            sb.append(intent.getComponent());
            sb.append("error: ");
            sb.append(th);
            C5264a.m21617a(NotificationCompat.CATEGORY_SERVICE, sb.toString());
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static <Params, Progress, Result> void m22154a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (VERSION.SDK_INT <= 10) {
            asyncTask.execute(paramsArr);
        } else {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
        }
    }

    /* renamed from: b */
    public static boolean m22155b(Context context) {
        return TextUtils.equals(context.getApplicationInfo().processName, m22156c(context));
    }

    /* renamed from: c */
    private static String m22156c(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
        String str = null;
        for (int i = 0; i < 2; i++) {
            List runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
