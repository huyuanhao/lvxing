package com.tencent.stat;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class StatCrashReporter {
    /* renamed from: a */
    private static volatile StatCrashReporter f25392a;
    /* renamed from: b */
    private Context f25393b = null;
    /* renamed from: c */
    private List<StatCrashCallback> f25394c = null;
    /* renamed from: d */
    private boolean f25395d = true;
    /* renamed from: e */
    private int f25396e = 3;
    /* renamed from: f */
    private int f25397f = 3;

    public int getMaxNumOfRetries() {
        return this.f25397f;
    }

    public void setMaxNumOfRetries(int i) {
        if (i > 0 && i <= 100) {
            this.f25397f = i;
        }
    }

    public int getReportDelaySecOnStart() {
        return this.f25396e;
    }

    public void setReportDelaySecOnStart(int i) {
        if (i >= 0 && i <= 600) {
            this.f25396e = i;
        }
    }

    public boolean isEnableInstantReporting() {
        return this.f25395d;
    }

    public void setEnableInstantReporting(boolean z) {
        this.f25395d = z;
    }

    private StatCrashReporter(Context context) {
        if (context != null) {
            if (context.getApplicationContext() != null) {
                this.f25393b = context.getApplicationContext();
            } else {
                this.f25393b = context;
            }
        }
        if (StatServiceImpl.getContext(null) == null) {
            StatServiceImpl.setContext(context);
        }
        this.f25394c = new ArrayList(1);
    }

    public static StatCrashReporter getStatCrashReporter(Context context) {
        if (f25392a == null) {
            synchronized (StatCrashReporter.class) {
                if (f25392a == null) {
                    f25392a = new StatCrashReporter(context);
                }
            }
        }
        return f25392a;
    }

    public void setJavaCrashHandlerStatus(boolean z) {
        StatConfig.setAutoExceptionCaught(z);
        if (z) {
            C7579a.m32689a(this.f25393b).mo37078a();
        }
    }

    public boolean getJavaCrashHandlerStatus() {
        return StatConfig.isAutoExceptionCaught();
    }

    public void setJniNativeCrashStatus(boolean z) {
        StatNativeCrashReport.setNativeCrashEnable(z);
        if (z) {
            StatNativeCrashReport.initNativeCrash(this.f25393b, null);
        }
    }

    public boolean getJniNativeCrashStatus() {
        return StatNativeCrashReport.isNativeCrashEnable();
    }

    public void setJniNativeCrashLogcatOutputStatus(boolean z) {
        StatNativeCrashReport.setNativeCrashDebugEnable(z);
    }

    public boolean isJniNativeCrashLogcatOutputEnable() {
        return StatNativeCrashReport.isNativeCrashDebugEnable();
    }

    public void addCrashCallback(StatCrashCallback statCrashCallback) {
        if (statCrashCallback != null && !this.f25394c.contains(statCrashCallback)) {
            this.f25394c.add(statCrashCallback);
        }
    }

    public void removeCrashCallback(StatCrashCallback statCrashCallback) {
        if (statCrashCallback != null) {
            this.f25394c.remove(statCrashCallback);
        }
    }

    public void clearCrashCallback() {
        this.f25394c.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36963a(Thread thread, Throwable th) {
        List<StatCrashCallback> list = this.f25394c;
        if (list != null && list.size() > 0) {
            for (StatCrashCallback onJavaCrash : this.f25394c) {
                onJavaCrash.onJavaCrash(thread, th);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36962a(String str) {
        List<StatCrashCallback> list = this.f25394c;
        if (list != null && list.size() > 0) {
            for (StatCrashCallback onJniNativeCrash : this.f25394c) {
                onJniNativeCrash.onJniNativeCrash(str);
            }
        }
    }
}
