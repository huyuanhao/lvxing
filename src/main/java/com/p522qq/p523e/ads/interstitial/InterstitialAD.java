package com.p522qq.p523e.ads.interstitial;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.IADI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qq.e.ads.interstitial.InterstitialAD */
public class InterstitialAD {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public IADI f20016a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public InterstitialADListener f20017b;
    /* renamed from: c */
    private boolean f20018c = false;
    /* renamed from: d */
    private boolean f20019d = false;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f20020e = false;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AtomicInteger f20021f = new AtomicInteger(0);

    /* renamed from: com.qq.e.ads.interstitial.InterstitialAD$ADListenerAdapter */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(InterstitialAD interstitialAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (InterstitialAD.this.f20017b == null) {
                GDTLogger.m25262i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        StringBuilder sb = new StringBuilder("AdEvent.Paras error for InterstitialAD(");
                        sb.append(aDEvent);
                        sb.append(")");
                        GDTLogger.m25260e(sb.toString());
                        break;
                    } else {
                        InterstitialAD.this.f20017b.onNoAD(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                case 2:
                    InterstitialAD.this.f20017b.onADReceive();
                    return;
                case 3:
                    InterstitialAD.this.f20017b.onADExposure();
                    return;
                case 4:
                    InterstitialAD.this.f20017b.onADOpened();
                    return;
                case 5:
                    InterstitialAD.this.f20017b.onADClicked();
                    return;
                case 6:
                    InterstitialAD.this.f20017b.onADLeftApplication();
                    return;
                case 7:
                    InterstitialAD.this.f20017b.onADClosed();
                    break;
            }
        }
    }

    public InterstitialAD(final Activity activity, final String str, final String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m25260e(String.format("Interstitial Constructor paras error, appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            return;
        }
        this.f20018c = true;
        if (!C6411a.m25176a((Context) activity)) {
            GDTLogger.m25260e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f20019d = true;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
            public void run() {
                if (GDTADManager.getInstance().initWith(activity, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        InterstitialAD.this.f20016a = pOFactory.getIADView(activity, str, str2);
                                        InterstitialAD.this.f20016a.setAdListener(new ADListenerAdapter(InterstitialAD.this, 0));
                                        InterstitialAD.this.f20020e = true;
                                        while (InterstitialAD.this.f20021f.getAndDecrement() > 0) {
                                            InterstitialAD.this.loadAD();
                                        }
                                    }
                                } catch (Throwable th) {
                                    InterstitialAD.this.f20020e = true;
                                    throw th;
                                }
                                InterstitialAD.this.f20020e = true;
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.m25261e("Exception while init IAD plugin", th);
                    }
                } else {
                    GDTLogger.m25260e("Fail to init ADManager");
                }
            }
        });
    }

    public void closePopupWindow() {
        IADI iadi = this.f20016a;
        if (iadi != null) {
            iadi.closePopupWindow();
        }
    }

    public void destroy() {
        IADI iadi = this.f20016a;
        if (iadi != null) {
            iadi.destory();
        }
    }

    public void loadAD() {
        if (!this.f20018c || !this.f20019d) {
            GDTLogger.m25260e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.f20020e) {
            this.f20021f.incrementAndGet();
        } else {
            IADI iadi = this.f20016a;
            if (iadi != null) {
                iadi.loadAd();
            } else {
                GDTLogger.m25260e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    public void setADListener(InterstitialADListener interstitialADListener) {
        this.f20017b = interstitialADListener;
    }

    public synchronized void show() {
        if (this.f20016a != null) {
            this.f20016a.show();
        }
    }

    public synchronized void show(Activity activity) {
        if (this.f20016a != null) {
            this.f20016a.show(activity);
        }
    }

    public synchronized void showAsPopupWindow() {
        if (this.f20016a != null) {
            this.f20016a.showAsPopupWindown();
        }
    }

    public synchronized void showAsPopupWindow(Activity activity) {
        if (this.f20016a != null) {
            this.f20016a.showAsPopupWindown(activity);
        }
    }
}
