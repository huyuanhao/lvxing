package com.p522qq.p523e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.p522qq.p523e.ads.cfg.DownAPPConfirmPolicy;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.constants.LoadAdParams;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.p525pi.UBVI;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.banner2.UnifiedBannerView */
public class UnifiedBannerView extends FrameLayout {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public UBVI f19942a;
    /* renamed from: b */
    private boolean f19943b;
    /* renamed from: c */
    private boolean f19944c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean f19945d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public DownAPPConfirmPolicy f19946e;
    /* access modifiers changed from: private|volatile */
    /* renamed from: f */
    public volatile int f19947f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public int f19948g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public LoadAdParams f19949h;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, (Map) null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f19943b = false;
        this.f19944c = false;
        this.f19945d = false;
        this.f19947f = 0;
        this.f19948g = 30;
        this.f19949h = null;
        if (GDTADManager.getInstance().isInitialized()) {
            m25079a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedBannerADListener, map);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedBannerADListener.onNoAD(C6411a.m25175a(2003));
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, str2, unifiedBannerADListener, null);
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f19943b = false;
        this.f19944c = false;
        this.f19945d = false;
        this.f19947f = 0;
        this.f19948g = 30;
        this.f19949h = null;
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25079a(activity, str, str2, unifiedBannerADListener, map);
    }

    /* renamed from: a */
    private void m25079a(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedBannerADListener == null) {
            GDTLogger.m25260e(String.format("UnifiedBannerView Constructor params error, appid=%s,posId=%s,context=%s,listener=%s", new Object[]{str, str2, activity, unifiedBannerADListener}));
            return;
        }
        this.f19943b = true;
        if (!C6411a.m25176a((Context) activity)) {
            GDTLogger.m25260e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f19944c = true;
        setLayoutParams(new LayoutParams(-1, -2));
        ExecutorService executorService = GDTADManager.INIT_EXECUTOR;
        final Activity activity2 = activity;
        final String str3 = str;
        final String str4 = str2;
        final UnifiedBannerADListener unifiedBannerADListener2 = unifiedBannerADListener;
        final Map map2 = map;
        C63841 r1 = new Runnable() {
            public void run() {
                if (GDTADManager.getInstance().initWith(activity2, str3)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        UnifiedBannerView.this.f19942a = pOFactory.getUnifiedBannerViewDelegate(UnifiedBannerView.this, activity2, str3, str4, unifiedBannerADListener2);
                                        UnifiedBannerView.this.f19945d = true;
                                        UnifiedBannerView.m25080a(UnifiedBannerView.this, map2, str4);
                                        if (UnifiedBannerView.this.f19946e != null) {
                                            UnifiedBannerView.this.setDownConfirmPolicy(UnifiedBannerView.this.f19946e);
                                        }
                                        UnifiedBannerView.this.setRefresh(UnifiedBannerView.this.f19948g);
                                        UnifiedBannerView.this.setLoadAdParams(UnifiedBannerView.this.f19949h);
                                        while (UnifiedBannerView.this.f19947f = UnifiedBannerView.this.f19947f - 1 > 0) {
                                            UnifiedBannerView.this.loadAD();
                                        }
                                    }
                                } catch (Throwable th) {
                                    UnifiedBannerView.this.f19945d = true;
                                    throw th;
                                }
                                UnifiedBannerView.this.f19945d = true;
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.m25261e("Exception while init UnifiedBannerView plugin", th);
                    }
                } else {
                    GDTLogger.m25260e("Fail to init ADManager");
                }
            }
        };
        executorService.execute(r1);
    }

    /* renamed from: a */
    static /* synthetic */ void m25080a(UnifiedBannerView unifiedBannerView, Map map, String str) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(KEYS.AD_TAGS, new JSONObject(map), str);
            } catch (Exception e) {
                GDTLogger.m25260e("UnifiedBanner#setTag Exception");
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
        UBVI ubvi = this.f19942a;
        if (ubvi != null) {
            ubvi.destroy();
        }
    }

    public Map getExt() {
        try {
            if (this.f19942a != null) {
                return UBVI.ext;
            }
        } catch (Exception unused) {
            GDTLogger.m25260e("banner2 can not get ext");
        }
        return null;
    }

    public void loadAD() {
        if (!this.f19943b || !this.f19944c) {
            GDTLogger.m25260e("UnifiedBannerView init Paras OR Context error,See More logs while new BannerView");
        } else if (!this.f19945d) {
            this.f19947f++;
        } else {
            UBVI ubvi = this.f19942a;
            if (ubvi != null) {
                ubvi.fetchAd();
            } else {
                GDTLogger.m25260e("UnifiedBannerView Init error,See More Logs");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        UBVI ubvi = this.f19942a;
        if (ubvi != null) {
            ubvi.onWindowFocusChanged(z);
        }
    }

    public void setDownConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f19946e = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy != null) {
            UBVI ubvi = this.f19942a;
            if (ubvi != null) {
                ubvi.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f19949h = loadAdParams;
        UBVI ubvi = this.f19942a;
        if (ubvi != null) {
            ubvi.setLoadAdParams(this.f19949h);
        }
    }

    public void setRefresh(int i) {
        this.f19948g = i;
        UBVI ubvi = this.f19942a;
        if (ubvi != null) {
            ubvi.setRefresh(i);
        }
    }
}
