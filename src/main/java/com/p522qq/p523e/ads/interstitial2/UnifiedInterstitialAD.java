package com.p522qq.p523e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.p522qq.p523e.ads.cfg.VideoOption;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.p525pi.UIADI;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.interstitial2.UnifiedInterstitialAD */
public class UnifiedInterstitialAD {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public UIADI f20029a;
    /* renamed from: b */
    private boolean f20030b;
    /* renamed from: c */
    private boolean f20031c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean f20032d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public AtomicInteger f20033e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public AtomicInteger f20034f;
    /* access modifiers changed from: private|volatile */
    /* renamed from: g */
    public volatile UnifiedInterstitialMediaListener f20035g;
    /* access modifiers changed from: private|volatile */
    /* renamed from: h */
    public volatile VideoOption f20036h;
    /* access modifiers changed from: private|volatile */
    /* renamed from: i */
    public volatile int f20037i;
    /* access modifiers changed from: private|volatile */
    /* renamed from: j */
    public volatile int f20038j;
    /* access modifiers changed from: private|volatile */
    /* renamed from: k */
    public volatile int f20039k;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, (Map) null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f20030b = false;
        this.f20031c = false;
        this.f20032d = false;
        this.f20033e = new AtomicInteger(0);
        this.f20034f = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            m25113a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedInterstitialADListener, map);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedInterstitialADListener.onNoAD(C6411a.m25175a(2003));
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, null);
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f20030b = false;
        this.f20031c = false;
        this.f20032d = false;
        this.f20033e = new AtomicInteger(0);
        this.f20034f = new AtomicInteger(0);
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25113a(activity, str, str2, unifiedInterstitialADListener, map);
    }

    /* renamed from: a */
    private void m25113a(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedInterstitialADListener == null) {
            GDTLogger.m25260e(String.format("UnifiedInterstitialAD Constructor paras error, appid=%s,posId=%s,context=%s,listener=%s", new Object[]{str, str2, activity, unifiedInterstitialADListener}));
            return;
        }
        this.f20030b = true;
        if (!C6411a.m25176a((Context) activity)) {
            GDTLogger.m25260e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f20031c = true;
        ExecutorService executorService = GDTADManager.INIT_EXECUTOR;
        final Activity activity2 = activity;
        final String str3 = str;
        final String str4 = str2;
        final UnifiedInterstitialADListener unifiedInterstitialADListener2 = unifiedInterstitialADListener;
        final Map map2 = map;
        C63961 r1 = new Runnable() {
            public void run() {
                if (GDTADManager.getInstance().initWith(activity2, str3)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        UnifiedInterstitialAD.this.f20029a = pOFactory.getUnifiedInterstitialADDelegate(activity2, str3, str4, unifiedInterstitialADListener2);
                                        UnifiedInterstitialAD.this.f20032d = true;
                                        UnifiedInterstitialAD.m25114a(UnifiedInterstitialAD.this, map2, str4);
                                        UnifiedInterstitialAD.this.setVideoOption(UnifiedInterstitialAD.this.f20036h);
                                        UnifiedInterstitialAD.this.setMediaListener(UnifiedInterstitialAD.this.f20035g);
                                        UnifiedInterstitialAD.this.setMinVideoDuration(UnifiedInterstitialAD.this.f20038j);
                                        UnifiedInterstitialAD.this.setMaxVideoDuration(UnifiedInterstitialAD.this.f20039k);
                                        UnifiedInterstitialAD.this.setVideoPlayPolicy(UnifiedInterstitialAD.this.f20037i);
                                        while (UnifiedInterstitialAD.this.f20033e.getAndDecrement() > 0) {
                                            UnifiedInterstitialAD.this.loadAD();
                                        }
                                        while (UnifiedInterstitialAD.this.f20034f.getAndDecrement() > 0) {
                                            UnifiedInterstitialAD.this.loadFullScreenAD();
                                        }
                                    }
                                } catch (Throwable th) {
                                    UnifiedInterstitialAD.this.f20032d = true;
                                    throw th;
                                }
                                UnifiedInterstitialAD.this.f20032d = true;
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.m25261e("Exception while init UnifiedInterstitialAD plugin", th);
                    }
                } else {
                    GDTLogger.m25260e("Fail to init ADManager");
                }
            }
        };
        executorService.execute(r1);
    }

    /* renamed from: a */
    static /* synthetic */ void m25114a(UnifiedInterstitialAD unifiedInterstitialAD, Map map, String str) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(KEYS.AD_TAGS, new JSONObject(map), str);
            } catch (Exception e) {
                GDTLogger.m25260e("UnifiedInterstitialAD#setTag Exception");
                e.printStackTrace();
            }
        }
    }

    public void close() {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.close();
        }
    }

    public void destroy() {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.destory();
        }
    }

    public String getAdNetWorkName() {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            return uiadi.getAdNetWorkName();
        }
        GDTLogger.m25260e("InterstitialAD init failed or not inited, can't call getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            return uiadi.getAdPatternType();
        }
        GDTLogger.m25260e("InterstitialAD init failed or not inited, can't call getAdPatternType");
        return 0;
    }

    public int getECPM() {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            return uiadi.getECPM();
        }
        GDTLogger.m25260e("InterstitialAD init failed or not inited, can't call getECPM");
        return -1;
    }

    public String getECPMLevel() {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            return uiadi.getECPMLevel();
        }
        GDTLogger.m25260e("InterstitialAD init failed or not inited, can't call getECPMLevel");
        return null;
    }

    public Map getExt() {
        try {
            if (this.f20029a != null) {
                return UIADI.ext;
            }
        } catch (Exception unused) {
            GDTLogger.m25260e("interstitial2 can not get ext");
        }
        return null;
    }

    public void loadAD() {
        if (!this.f20030b || !this.f20031c) {
            GDTLogger.m25260e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.f20032d) {
            this.f20033e.incrementAndGet();
        } else {
            UIADI uiadi = this.f20029a;
            if (uiadi != null) {
                uiadi.loadAd();
            } else {
                GDTLogger.m25260e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    public void loadFullScreenAD() {
        if (!this.f20030b || !this.f20031c) {
            GDTLogger.m25260e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.f20032d) {
            this.f20034f.incrementAndGet();
        } else {
            UIADI uiadi = this.f20029a;
            if (uiadi != null) {
                uiadi.loadFullScreenAD();
            } else {
                GDTLogger.m25260e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f20039k = i;
        if (this.f20039k > 0 && this.f20038j > this.f20039k) {
            GDTLogger.m25260e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.setMaxVideoDuration(i);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f20035g = unifiedInterstitialMediaListener;
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.setMediaListener(unifiedInterstitialMediaListener);
        }
    }

    public void setMinVideoDuration(int i) {
        this.f20038j = i;
        if (this.f20039k > 0 && this.f20038j > this.f20039k) {
            GDTLogger.m25260e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.setMinVideoDuration(i);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f20036h = videoOption;
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.setVideoOption(videoOption);
        }
    }

    public void setVideoPlayPolicy(int i) {
        this.f20037i = i;
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.setVideoPlayPolicy(i);
        }
    }

    public void show() {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.show();
        }
    }

    public void show(Activity activity) {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.show(activity);
        }
    }

    public void showAsPopupWindow() {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow();
        }
    }

    public void showAsPopupWindow(Activity activity) {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow(activity);
        }
    }

    public void showFullScreenAD(Activity activity) {
        UIADI uiadi = this.f20029a;
        if (uiadi != null) {
            uiadi.showFullScreenAD(activity);
        }
    }
}
