package com.qiyukf.unicorn.p516j;

import android.content.Context;
import android.util.Log;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.analytics.C5973a;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.qiyukf.unicorn.j.d */
public final class C6216d {
    /* renamed from: a */
    public static void m24649a(final Context context) {
        final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public final void uncaughtException(Thread thread, Throwable th) {
                try {
                    if (Log.getStackTraceString(th).contains("com.qiyukf")) {
                        StringBuilder sb = new StringBuilder("************* crash *************\n** Thread: ");
                        sb.append(context.getPackageName());
                        sb.append("/");
                        sb.append(thread.getName());
                        sb.append(" **");
                        C5264a.m21621b("APP", sb.toString(), th);
                        C5973a.m23888b(th);
                    }
                } catch (Throwable unused) {
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }
        });
    }
}
