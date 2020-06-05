package com.bytedance.tea.crash.upload;

import android.content.Context;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p218e.CrashFileCollector;
import com.bytedance.tea.crash.p218e.NpthHandlerThread;
import com.bytedance.tea.crash.p220f.ScheduleTaskManager;
import com.bytedance.tea.crash.p221g.Net;

/* renamed from: com.bytedance.tea.crash.upload.d */
public final class LaunchScanner implements Runnable {
    /* renamed from: a */
    private Context f9408a;

    private LaunchScanner(Context context) {
        this.f9408a = context;
    }

    /* renamed from: a */
    public static void m12622a(Context context, int i) {
        try {
            if (!NpthBus.m12591a().mo17022d().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        NpthHandlerThread.m12474b().postDelayed(new LaunchScanner(context), (long) i);
    }

    /* renamed from: a */
    public static void m12621a(Context context) {
        m12622a(context, 0);
    }

    public void run() {
        try {
            new CrashFileCollector(this.f9408a).mo17046a(Net.m12546b(this.f9408a));
        } catch (Throwable th) {
            ScheduleTaskManager.m12488a(NpthHandlerThread.m12474b(), this.f9408a).mo17066a();
            throw th;
        }
        ScheduleTaskManager.m12488a(NpthHandlerThread.m12474b(), this.f9408a).mo17066a();
    }
}
