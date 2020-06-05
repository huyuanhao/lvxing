package com.tencent.android.tpush.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.f */
public class C7059f {
    /* renamed from: a */
    private static final String f23448a = C7059f.class.getSimpleName();
    /* renamed from: c */
    private static volatile C7059f f23449c = null;
    /* renamed from: b */
    private Context f23450b = null;
    /* renamed from: d */
    private boolean f23451d = true;
    /* renamed from: e */
    private Handler f23452e = null;
    /* renamed from: f */
    private volatile boolean f23453f = false;
    /* renamed from: g */
    private long f23454g = 0;

    /* renamed from: a */
    public void mo34155a() {
    }

    private C7059f(Context context) {
        this.f23450b = context.getApplicationContext();
        this.f23451d = m30233c();
        HandlerThread handlerThread = new HandlerThread(C7059f.class.getName());
        handlerThread.start();
        this.f23452e = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static C7059f m30231a(Context context) {
        if (f23449c == null) {
            synchronized (C7059f.class) {
                if (f23449c == null) {
                    f23449c = new C7059f(context);
                }
            }
        }
        return f23449c;
    }

    /* renamed from: b */
    private String m30232b() {
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) this.f23450b.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: c */
    private boolean m30233c() {
        String b = m30232b();
        if (TextUtils.isEmpty(b) || !b.contains("xg_service")) {
            C6864a.m29303e(f23448a, "not xg_service");
            return false;
        }
        C6864a.m29303e(f23448a, "is xg_service");
        return true;
    }
}
