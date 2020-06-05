package com.p522qq.p523e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.p522qq.p523e.ads.cfg.BrowserType;
import com.p522qq.p523e.ads.cfg.DownAPPConfirmPolicy;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.ADI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.AdError;
import com.p522qq.p523e.comm.util.GDTLogger;
import java.util.concurrent.ExecutorService;

/* renamed from: com.qq.e.ads.AbstractAD */
public abstract class AbstractAD<T extends ADI> {
    /* access modifiers changed from: private|volatile */
    /* renamed from: a */
    public volatile boolean f19908a = false;
    /* renamed from: b */
    private volatile boolean f19909b = false;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public T f19910c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public BrowserType f19911d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public DownAPPConfirmPolicy f19912e;

    /* renamed from: com.qq.e.ads.AbstractAD$BasicADListener */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final T mo29633a() {
        return this.f19910c;
    }

    /* renamed from: a */
    public abstract T mo29634a(Context context, POFactory pOFactory, String str, String str2);

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29635a(Context context, String str, String str2, BasicADListener basicADListener) {
        if (!C6411a.m25176a(context)) {
            GDTLogger.m25260e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
            mo29636a(basicADListener, 4002);
            return;
        }
        this.f19909b = true;
        ExecutorService executorService = GDTADManager.INIT_EXECUTOR;
        final Context context2 = context;
        final String str3 = str;
        final String str4 = str2;
        final BasicADListener basicADListener2 = basicADListener;
        C63801 r1 = new Runnable() {
            public void run() {
                AbstractAD abstractAD;
                BasicADListener basicADListener;
                int i;
                if (GDTADManager.getInstance().initWith(context2, str3)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        AbstractAD.this.f19910c = AbstractAD.this.mo29634a(context2, pOFactory, str3, str4);
                                        AbstractAD.this.f19908a = true;
                                        if (AbstractAD.this.f19911d != null) {
                                            AbstractAD.this.setBrowserType(AbstractAD.this.f19911d);
                                        }
                                        if (AbstractAD.this.f19912e != null) {
                                            AbstractAD.this.setDownAPPConfirmPolicy(AbstractAD.this.f19912e);
                                        }
                                        AbstractAD.this.mo29637a(AbstractAD.this.f19910c);
                                        return;
                                    }
                                    AbstractAD.this.f19908a = true;
                                    AbstractAD.this.mo29636a(basicADListener2, 200102);
                                } catch (Throwable th) {
                                    GDTLogger.m25261e("Exception while init Core", th);
                                    AbstractAD.this.f19908a = true;
                                    AbstractAD.this.mo29636a(basicADListener2, 2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.m25261e("Exception while init plugin", th);
                        abstractAD = AbstractAD.this;
                        basicADListener = basicADListener2;
                        i = 200102;
                    }
                } else {
                    GDTLogger.m25260e("Fail to init ADManager");
                    abstractAD = AbstractAD.this;
                    basicADListener = basicADListener2;
                    i = 200101;
                    abstractAD.mo29636a(basicADListener, i);
                }
            }
        };
        executorService.execute(r1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29636a(BasicADListener basicADListener, int i) {
        if (basicADListener != null) {
            basicADListener.onNoAD(C6411a.m25175a(i));
        }
    }

    /* renamed from: a */
    public abstract void mo29637a(T t);

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final boolean mo29638b() {
        return this.f19908a;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final boolean mo29639c() {
        return this.f19909b;
    }

    public void setBrowserType(BrowserType browserType) {
        this.f19911d = browserType;
        T t = this.f19910c;
        if (t != null && browserType != null) {
            t.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f19912e = downAPPConfirmPolicy;
        T t = this.f19910c;
        if (t != null && downAPPConfirmPolicy != null) {
            t.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
