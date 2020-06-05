package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.stat.b */
public class C7585b {
    /* renamed from: b */
    private static volatile C7585b f25602b;
    /* renamed from: a */
    private Timer f25603a = null;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Context f25604c = null;

    private C7585b(Context context) {
        if (context != null) {
            if (context.getApplicationContext() != null) {
                this.f25604c = context.getApplicationContext();
            } else {
                this.f25604c = context;
            }
        }
        this.f25603a = new Timer(false);
    }

    /* renamed from: a */
    public void mo37090a() {
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.PERIOD) {
            long sendPeriodMinutes = (long) (StatConfig.getSendPeriodMinutes() * 60 * 1000);
            if (StatConfig.isDebugEnable()) {
                StatLogger logger = StatCommonHelper.getLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("setupPeriodTimer delay:");
                sb.append(sendPeriodMinutes);
                logger.mo37108i(sb.toString());
            }
            mo37091a(new TimerTask() {
                public void run() {
                    if (StatConfig.isDebugEnable()) {
                        StatCommonHelper.getLogger().mo37108i("TimerTask run");
                    }
                    StatServiceImpl.m32657e(C7585b.this.f25604c);
                    cancel();
                    C7585b.this.mo37090a();
                }
            }, sendPeriodMinutes);
        }
    }

    /* renamed from: a */
    public static C7585b m32710a(Context context) {
        if (f25602b == null) {
            synchronized (C7585b.class) {
                if (f25602b == null) {
                    f25602b = new C7585b(context);
                }
            }
        }
        return f25602b;
    }

    /* renamed from: a */
    public void mo37091a(TimerTask timerTask, long j) {
        if (this.f25603a != null) {
            if (StatConfig.isDebugEnable()) {
                StatLogger logger = StatCommonHelper.getLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("setupPeriodTimer schedule delay:");
                sb.append(j);
                logger.mo37108i(sb.toString());
            }
            this.f25603a.schedule(timerTask, j);
        } else if (StatConfig.isDebugEnable()) {
            StatCommonHelper.getLogger().mo37116w("setupPeriodTimer schedule timer == null");
        }
    }
}
