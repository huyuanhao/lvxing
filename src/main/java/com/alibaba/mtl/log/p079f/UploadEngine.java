package com.alibaba.mtl.log.p079f;

import com.alibaba.mtl.log.UTDC;
import com.alibaba.mtl.log.p074a.Config;
import com.alibaba.mtl.log.p075b.CoreStatics;
import com.alibaba.mtl.log.p077d.AppInfoUtil;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.TaskExecutor;
import java.util.Random;

/* renamed from: com.alibaba.mtl.log.f.a */
public class UploadEngine {
    /* renamed from: a */
    static UploadEngine f3448a = new UploadEngine();
    /* renamed from: b */
    protected long f3449b = Config.m3712d();
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f3450c = false;
    /* renamed from: d */
    private int f3451d;

    /* renamed from: a */
    public static UploadEngine m3889a() {
        return f3448a;
    }

    /* renamed from: b */
    public synchronized void mo11829b() {
        this.f3450c = true;
        if (TaskExecutor.m3867a().mo11812b(2)) {
            TaskExecutor.m3867a().mo11809a(2);
        }
        m3892e();
        Random random = new Random();
        if (!C1333b.m3904c()) {
            TaskExecutor.m3867a().mo11810a(2, new C1333b() {
                /* renamed from: a */
                public void mo11832a() {
                    if (UploadEngine.this.f3450c) {
                        CoreStatics.m3753k();
                        UploadEngine.this.m3892e();
                        Logger.m3833a("UploadTask", "mPeriod:", Long.valueOf(UploadEngine.this.f3449b));
                        if (TaskExecutor.m3867a().mo11812b(2)) {
                            TaskExecutor.m3867a().mo11809a(2);
                        }
                        if (!C1333b.m3904c()) {
                            TaskExecutor.m3867a().mo11810a(2, this, UploadEngine.this.f3449b);
                        }
                    }
                }

                /* renamed from: b */
                public void mo11833b() {
                    UploadEngine.this.mo11830c();
                }
            }, (long) random.nextInt((int) this.f3449b));
        }
    }

    /* renamed from: c */
    public void mo11830c() {
        if (this.f3451d == 0) {
            this.f3451d = 7000;
        } else {
            this.f3451d = 0;
        }
    }

    /* renamed from: d */
    public synchronized void mo11831d() {
        this.f3450c = false;
        TaskExecutor.m3867a().mo11809a(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public long m3892e() {
        int i;
        long j;
        Logger.m3833a("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(UTDC.f3270a), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(AppInfoUtil.m3792a(UTDC.m3697c())));
        UTDC.f3270a = !AppInfoUtil.m3792a(UTDC.m3697c());
        boolean z = UTDC.f3270a;
        Config.m3712d();
        if (z) {
            j = Config.m3714e();
            i = this.f3451d;
        } else {
            j = Config.m3712d();
            i = this.f3451d;
        }
        this.f3449b = j + ((long) i);
        if (Config.m3709b()) {
            this.f3449b = 3000;
        }
        return this.f3449b;
    }
}
