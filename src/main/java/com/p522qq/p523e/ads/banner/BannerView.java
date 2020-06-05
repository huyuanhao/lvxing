package com.p522qq.p523e.ads.banner;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.p522qq.p523e.ads.cfg.BannerRollAnimation;
import com.p522qq.p523e.ads.cfg.DownAPPConfirmPolicy;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.BVI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.concurrent.ExecutorService;

/* renamed from: com.qq.e.ads.banner.BannerView */
public class BannerView extends FrameLayout {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public BVI f19924a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public BannerADListener f19925b;
    /* renamed from: c */
    private boolean f19926c = false;
    /* renamed from: d */
    private boolean f19927d = false;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f19928e = false;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public Integer f19929f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public BannerRollAnimation f19930g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public DownAPPConfirmPolicy f19931h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public Boolean f19932i;
    /* access modifiers changed from: private|volatile */
    /* renamed from: j */
    public volatile int f19933j = 0;

    /* renamed from: com.qq.e.ads.banner.BannerView$ADListenerAdapter */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(BannerView bannerView, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (BannerView.this.f19925b == null) {
                GDTLogger.m25262i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        StringBuilder sb = new StringBuilder("AdEvent.Paras error for Banner(");
                        sb.append(aDEvent);
                        sb.append(")");
                        GDTLogger.m25260e(sb.toString());
                        break;
                    } else {
                        BannerView.this.f19925b.onNoAD(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    break;
                case 2:
                    BannerView.this.f19925b.onADReceiv();
                    return;
                case 3:
                    BannerView.this.f19925b.onADExposure();
                    return;
                case 4:
                    BannerView.this.f19925b.onADClosed();
                    return;
                case 5:
                    BannerView.this.f19925b.onADClicked();
                    return;
                case 6:
                    BannerView.this.f19925b.onADLeftApplication();
                    return;
                case 7:
                    BannerView.this.f19925b.onADOpenOverlay();
                    return;
                case 8:
                    BannerView.this.f19925b.onADCloseOverlay();
                    break;
            }
        }
    }

    public BannerView(Activity activity, ADSize aDSize, String str, String str2) {
        super(activity);
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m25260e(String.format("Banner ADView Constructor params error, appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            return;
        }
        this.f19926c = true;
        if (!C6411a.m25176a((Context) activity)) {
            GDTLogger.m25260e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f19927d = true;
        setLayoutParams(new LayoutParams(-1, -2));
        ExecutorService executorService = GDTADManager.INIT_EXECUTOR;
        final Activity activity2 = activity;
        final String str3 = str;
        final ADSize aDSize2 = aDSize;
        final String str4 = str2;
        C63821 r1 = new Runnable() {
            public void run() {
                if (GDTADManager.getInstance().initWith(activity2, str3)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        BannerView.this.f19924a = pOFactory.getBannerView(activity2, aDSize2, str3, str4);
                                        BannerView.this.f19924a.setAdListener(new ADListenerAdapter(BannerView.this, 0));
                                        BannerView.this.addView(BannerView.this.f19924a.getView());
                                        BannerView.this.f19928e = true;
                                        if (BannerView.this.f19931h != null) {
                                            BannerView.this.setDownConfirmPilicy(BannerView.this.f19931h);
                                        }
                                        if (BannerView.this.f19929f != null) {
                                            BannerView.this.setRefresh(BannerView.this.f19929f.intValue());
                                        }
                                        if (BannerView.this.f19930g != null) {
                                            BannerView.this.setRollAnimation(BannerView.this.f19930g);
                                        }
                                        if (BannerView.this.f19932i != null) {
                                            BannerView.this.setShowClose(BannerView.this.f19932i.booleanValue());
                                        }
                                        while (BannerView.this.f19933j = BannerView.this.f19933j - 1 > 0) {
                                            BannerView.this.loadAD();
                                        }
                                    }
                                } catch (Throwable th) {
                                    BannerView.this.f19928e = true;
                                    throw th;
                                }
                                BannerView.this.f19928e = true;
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.m25261e("Exception while init Banner plugin", th);
                    }
                } else {
                    GDTLogger.m25260e("Fail to init ADManager");
                }
            }
        };
        executorService.execute(r1);
    }

    public void destroy() {
        BVI bvi = this.f19924a;
        if (bvi != null) {
            bvi.destroy();
        }
    }

    public void loadAD() {
        if (!this.f19926c || !this.f19927d) {
            GDTLogger.m25260e("Banner init Paras OR Context error,See More logs while new BannerView");
        } else if (!this.f19928e) {
            this.f19933j++;
        } else {
            BVI bvi = this.f19924a;
            if (bvi != null) {
                bvi.fetchAd();
            } else {
                GDTLogger.m25260e("Banner Init error,See More Logs");
            }
        }
    }

    public void setADListener(BannerADListener bannerADListener) {
        this.f19925b = bannerADListener;
    }

    public void setDownConfirmPilicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f19931h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy != null) {
            BVI bvi = this.f19924a;
            if (bvi != null) {
                bvi.setDownAPPConfirmPolicy(downAPPConfirmPolicy.value());
            }
        }
    }

    public void setRefresh(int i) {
        this.f19929f = Integer.valueOf(i);
        if (i < 30 && i != 0) {
            i = 30;
        } else if (i > 120) {
            i = 120;
        }
        BVI bvi = this.f19924a;
        if (bvi != null) {
            bvi.setRefresh(i);
        }
    }

    public void setRollAnimation(BannerRollAnimation bannerRollAnimation) {
        this.f19930g = bannerRollAnimation;
        if (bannerRollAnimation != null) {
            BVI bvi = this.f19924a;
            if (bvi != null) {
                bvi.setRollAnimation(bannerRollAnimation.value());
            }
        }
    }

    public void setShowClose(boolean z) {
        this.f19932i = Boolean.valueOf(z);
        BVI bvi = this.f19924a;
        if (bvi != null) {
            bvi.setShowCloseButton(z);
        }
    }
}
