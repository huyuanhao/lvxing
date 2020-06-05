package com.bytedance.tea.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.tea.crash.p212a.CrashANRHandler;
import com.bytedance.tea.crash.p213b.NpthDataManager;
import com.bytedance.tea.crash.p217d.CrashCatchDispatcher;
import com.bytedance.tea.crash.p217d.ICrashDisposer;
import com.bytedance.tea.crash.p217d.JavaCrash;
import com.bytedance.tea.crash.p218e.NpthHandlerThread;
import com.bytedance.tea.crash.p218e.p219a.CrashContextAssembly;
import com.bytedance.tea.crash.p221g.App;
import com.bytedance.tea.crash.upload.LaunchScanner;

/* renamed from: com.bytedance.tea.crash.g */
public final class Npth {
    /* renamed from: a */
    private static boolean f9359a = false;
    /* renamed from: b */
    private static boolean f9360b = false;
    /* renamed from: c */
    private static boolean f9361c = false;
    /* renamed from: d */
    private static boolean f9362d = false;

    /* renamed from: a */
    public static synchronized void m12490a(Context context, ICommonParams dVar, boolean z, boolean z2) {
        synchronized (Npth.class) {
            m12491a(context, dVar, z, false, z2);
        }
    }

    /* renamed from: a */
    public static synchronized void m12491a(Context context, ICommonParams dVar, boolean z, boolean z2, boolean z3) {
        synchronized (Npth.class) {
            m12492a(context, dVar, z, z, z2, z3);
        }
    }

    /* renamed from: a */
    public static synchronized void m12492a(final Context context, ICommonParams dVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        synchronized (Npth.class) {
            if (!f9359a) {
                if (context == null) {
                    throw new IllegalArgumentException("context must be not null.");
                } else if (dVar != null) {
                    if (!(context instanceof Application)) {
                        context = context.getApplicationContext();
                    }
                    if (!App.m12503c(context)) {
                        NpthBus.m12592a(context, dVar);
                        CrashContextAssembly.m12443a(context);
                        if (z || z2) {
                            CrashCatchDispatcher a = CrashCatchDispatcher.m12387a();
                            if (z) {
                                a.mo17013a((ICrashDisposer) new JavaCrash(context));
                            }
                            f9360b = true;
                        }
                        f9362d = z3;
                        f9359a = true;
                        f9361c = z4;
                        NpthHandlerThread.m12474b().post(new Runnable() {
                            public void run() {
                                NpthDataManager.m12329a().mo16976a(context);
                                LaunchScanner.m12621a(context);
                                if (z4) {
                                    CrashANRHandler.m12285a(context).mo16965a();
                                }
                            }
                        });
                    }
                } else {
                    throw new IllegalArgumentException("params must be not null.");
                }
            }
        }
    }

    /* renamed from: a */
    public static void m12493a(ICrashFilter fVar) {
        NpthBus.m12593b().mo16972a(fVar);
    }
}
