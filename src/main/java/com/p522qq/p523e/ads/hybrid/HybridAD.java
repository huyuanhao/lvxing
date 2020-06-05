package com.p522qq.p523e.ads.hybrid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.HADI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.qq.e.ads.hybrid.HybridAD */
public class HybridAD implements HADI {
    /* access modifiers changed from: private|volatile */
    /* renamed from: a */
    public volatile boolean f19989a;
    /* renamed from: b */
    private volatile boolean f19990b;
    /* renamed from: c */
    private volatile boolean f19991c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public HADI f19992d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public HybridADListener f19993e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public CountDownLatch f19994f = new CountDownLatch(1);

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            m25100a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), hybridADSetting, hybridADListener);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        hybridADListener.onError(C6411a.m25175a(2003));
    }

    @Deprecated
    public HybridAD(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25100a(context, str, hybridADSetting, hybridADListener);
    }

    /* renamed from: a */
    private void m25100a(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        if (context == null || TextUtils.isEmpty(str) || hybridADListener == null) {
            GDTLogger.m25260e(String.format("HybridAD Constructor params error, context=%s, appID=%s,HybridADListener=%s", new Object[]{context, str, hybridADListener}));
            return;
        }
        this.f19993e = hybridADListener;
        this.f19990b = true;
        if (!C6411a.m25176a(context)) {
            GDTLogger.m25260e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f19991c = true;
        ExecutorService executorService = GDTADManager.INIT_EXECUTOR;
        final Context context2 = context;
        final String str2 = str;
        final HybridADSetting hybridADSetting2 = hybridADSetting;
        final HybridADListener hybridADListener2 = hybridADListener;
        C63891 r1 = new Runnable() {
            public void run() {
                if (GDTADManager.getInstance().initWith(context2, str2)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (pOFactory != null) {
                                    HybridAD.this.f19992d = pOFactory.getHybridAD(hybridADSetting2, hybridADListener2);
                                    HybridAD.this.f19989a = true;
                                } else {
                                    GDTLogger.m25260e("poFactory is null");
                                    new Handler(Looper.getMainLooper()).post(new Runnable(2001) {
                                        public void run() {
                                            if (HybridAD.this.f19993e != null) {
                                                HybridAD.this.f19993e.onError(C6411a.m25175a(2001));
                                            }
                                        }
                                    });
                                }
                                HybridAD.this.f19994f.countDown();
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.m25261e("Exception while init HybridAD plugin", th);
                    }
                } else {
                    GDTLogger.m25260e("Fail to init ADManager");
                    new Handler(Looper.getMainLooper()).post(new Runnable(2001) {
                        public void run() {
                            if (HybridAD.this.f19993e != null) {
                                HybridAD.this.f19993e.onError(C6411a.m25175a(2001));
                            }
                        }
                    });
                    HybridAD.this.f19994f.countDown();
                }
            }
        };
        executorService.execute(r1);
    }

    public void loadUrl(final String str) {
        boolean z;
        if (!this.f19990b || !this.f19991c) {
            GDTLogger.m25260e("AD init Params OR Context error, details in logs produced while init HybridAD");
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            GDTLogger.m25260e("HybridAD loadUrl error");
        } else if (this.f19989a) {
            this.f19992d.loadUrl(str);
        } else {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        HybridAD.this.f19994f.await(30, TimeUnit.SECONDS);
                        if (HybridAD.this.f19989a) {
                            HybridAD.this.f19992d.loadUrl(str);
                            return;
                        }
                        GDTLogger.m25260e("delegate init failed ");
                        new Handler(Looper.getMainLooper()).post(new Runnable(2001) {
                            public void run() {
                                if (HybridAD.this.f19993e != null) {
                                    HybridAD.this.f19993e.onError(C6411a.m25175a(2001));
                                }
                            }
                        });
                    } catch (InterruptedException unused) {
                        GDTLogger.m25260e("buffered loadUrl action timeout");
                        new Handler(Looper.getMainLooper()).post(new Runnable(2001) {
                            public void run() {
                                if (HybridAD.this.f19993e != null) {
                                    HybridAD.this.f19993e.onError(C6411a.m25175a(2001));
                                }
                            }
                        });
                    }
                }
            }).start();
        }
    }
}
