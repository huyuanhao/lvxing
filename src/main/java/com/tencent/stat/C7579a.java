package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.tencent.stat.a */
public final class C7579a implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static StatLogger f25588a = StatCommonHelper.getLogger();
    /* renamed from: c */
    private static volatile C7579a f25589c = null;
    /* renamed from: d */
    private static UncaughtExceptionHandler f25590d = null;
    /* renamed from: b */
    private Context f25591b = null;
    /* renamed from: e */
    private boolean f25592e = false;

    private C7579a(Context context) {
        this.f25591b = context;
    }

    /* renamed from: a */
    public static C7579a m32689a(Context context) {
        if (f25589c == null) {
            synchronized (C7579a.class) {
                if (f25589c == null) {
                    f25589c = new C7579a(context);
                }
            }
        }
        return f25589c;
    }

    /* renamed from: a */
    public void mo37078a() {
        if (f25590d == null) {
            f25590d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(f25589c);
            StatLogger statLogger = f25588a;
            StringBuilder sb = new StringBuilder();
            sb.append("set up java crash handler:");
            sb.append(f25589c);
            statLogger.mo37101d(sb.toString());
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f25592e) {
            StatLogger statLogger = f25588a;
            StringBuilder sb = new StringBuilder();
            sb.append("already handle the uncaugth exception:");
            sb.append(th);
            statLogger.mo37103e((Object) sb.toString());
            return;
        }
        this.f25592e = true;
        f25588a.mo37101d("catch app crash");
        StatServiceImpl.m32644b(thread, th);
        if (f25590d != null) {
            f25588a.mo37101d("Call the original uncaught exception handler.");
            UncaughtExceptionHandler uncaughtExceptionHandler = f25590d;
            if (!(uncaughtExceptionHandler instanceof C7579a)) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
