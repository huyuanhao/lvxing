package com.kwai.filedownloader.services;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Process;
import android.webkit.WebView;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwai.filedownloader.p358f.C4654c;
import com.kwai.filedownloader.p358f.C4661e;
import com.kwai.filedownloader.p358f.C4664f;
import com.tencent.android.tpush.common.Constants;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class FileDownloadService extends Service {
    /* renamed from: a */
    private C4739i f15264a;

    /* renamed from: com.kwai.filedownloader.services.FileDownloadService$SeparateProcessService */
    public static class SeparateProcessService extends FileDownloadService {
        /* renamed from: a */
        private String m19379a(Context context) {
            String str = "ksad";
            if (context == null) {
                return str;
            }
            try {
                Iterator it = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        public void onCreate() {
            FileDownloadService.super.onCreate();
            if (VERSION.SDK_INT >= 28) {
                try {
                    WebView.setDataDirectorySuffix(m19379a(getApplicationContext()));
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("WebView has already been initialized ");
                    sb.append(e.getMessage());
                    C4065b.m16863a("filedownloader", sb.toString());
                }
            }
        }
    }

    /* renamed from: com.kwai.filedownloader.services.FileDownloadService$SharedMainProcessService */
    public static class SharedMainProcessService extends FileDownloadService {
    }

    public IBinder onBind(Intent intent) {
        return this.f15264a.mo25337a(intent);
    }

    public void onCreate() {
        super.onCreate();
        C4654c.m19106a(this);
        try {
            C4664f.m19136a(C4661e.m19127a().f15180a);
            C4664f.m19137a(C4661e.m19127a().f15181b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        C4737g gVar = new C4737g();
        this.f15264a = C4661e.m19127a().f15183d ? new C4734e(new WeakReference(this), gVar) : new C4733d(new WeakReference(this), gVar);
    }

    public void onDestroy() {
        this.f15264a.mo25339d();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f15264a.mo25338a(intent, i, i2);
        return 1;
    }
}
