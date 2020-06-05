package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/* renamed from: com.alipay.android.phone.mrpc.core.l */
public final class C1421l implements C1405ab {
    /* renamed from: b */
    private static C1421l f3636b;
    /* renamed from: i */
    private static final ThreadFactory f3637i = new C1423n();
    /* renamed from: a */
    Context f3638a;
    /* renamed from: c */
    private ThreadPoolExecutor f3639c;
    /* renamed from: d */
    private C1408b f3640d = C1408b.m4079a("android");
    /* renamed from: e */
    private long f3641e;
    /* renamed from: f */
    private long f3642f;
    /* renamed from: g */
    private long f3643g;
    /* renamed from: h */
    private int f3644h;

    private C1421l(Context context) {
        this.f3638a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f3637i, new CallerRunsPolicy());
        this.f3639c = threadPoolExecutor;
        try {
            this.f3639c.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f3638a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    /* renamed from: a */
    public static final C1421l m4107a(Context context) {
        C1421l lVar = f3636b;
        return lVar != null ? lVar : m4108b(context);
    }

    /* renamed from: b */
    private static final synchronized C1421l m4108b(Context context) {
        synchronized (C1421l.class) {
            if (f3636b != null) {
                C1421l lVar = f3636b;
                return lVar;
            }
            C1421l lVar2 = new C1421l(context);
            f3636b = lVar2;
            return lVar2;
        }
    }

    /* renamed from: a */
    public final C1408b mo11968a() {
        return this.f3640d;
    }

    /* renamed from: a */
    public final Future<C1430u> mo11941a(C1429t tVar) {
        if (C1428s.m4145a(this.f3638a)) {
            StringBuilder sb = new StringBuilder("HttpManager");
            sb.append(hashCode());
            sb.append(": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times");
            String sb2 = sb.toString();
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.f3639c.getActiveCount());
            objArr[1] = Long.valueOf(this.f3639c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.f3639c.getTaskCount());
            long j = this.f3643g;
            long j2 = 0;
            objArr[3] = Long.valueOf(j == 0 ? 0 : ((this.f3641e * 1000) / j) >> 10);
            int i = this.f3644h;
            if (i != 0) {
                j2 = this.f3642f / ((long) i);
            }
            objArr[4] = Long.valueOf(j2);
            objArr[5] = Long.valueOf(this.f3641e);
            objArr[6] = Long.valueOf(this.f3642f);
            objArr[7] = Long.valueOf(this.f3643g);
            objArr[8] = Integer.valueOf(this.f3644h);
            String.format(sb2, objArr);
        }
        C1426q qVar = new C1426q(this, (C1424o) tVar);
        C1422m mVar = new C1422m(this, qVar, qVar);
        this.f3639c.execute(mVar);
        return mVar;
    }

    /* renamed from: a */
    public final void mo11969a(long j) {
        this.f3641e += j;
    }

    /* renamed from: b */
    public final void mo11970b(long j) {
        this.f3642f += j;
        this.f3644h++;
    }

    /* renamed from: c */
    public final void mo11971c(long j) {
        this.f3643g += j;
    }
}
