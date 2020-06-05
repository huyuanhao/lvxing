package com.p522qq.p523e.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.p522qq.p523e.comm.constants.LoadAdParams;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.managers.plugin.C6422c;
import com.p522qq.p523e.comm.p525pi.NSPVI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.splash.SplashAD */
public final class SplashAD {
    /* access modifiers changed from: private|volatile */
    /* renamed from: a */
    public volatile NSPVI f20133a;
    /* access modifiers changed from: private|volatile */
    /* renamed from: b */
    public volatile ViewGroup f20134b;
    /* access modifiers changed from: private|volatile */
    /* renamed from: c */
    public volatile SplashADListener f20135c;
    /* access modifiers changed from: private|volatile */
    /* renamed from: d */
    public volatile LoadAdParams f20136d;
    /* access modifiers changed from: private|volatile */
    /* renamed from: e */
    public volatile boolean f20137e;
    /* access modifiers changed from: private|volatile */
    /* renamed from: f */
    public volatile boolean f20138f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public int f20139g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public int f20140h;
    /* access modifiers changed from: private|volatile */
    /* renamed from: i */
    public volatile View f20141i;

    /* renamed from: com.qq.e.ads.splash.SplashAD$ADListenerAdapter */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(SplashAD splashAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (SplashAD.this.f20135c == null) {
                GDTLogger.m25260e("SplashADListener == null");
                return;
            }
            Object[] paras = aDEvent.getParas();
            switch (aDEvent.getType()) {
                case 1:
                    SplashAD.this.f20135c.onADDismissed();
                    break;
                case 2:
                    if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                        GDTLogger.m25260e("Splash onNoAD event get params error.");
                        return;
                    } else {
                        SplashAD.this.f20135c.onNoAD(C6411a.m25175a(((Integer) paras[0]).intValue()));
                        return;
                    }
                case 3:
                    SplashAD.this.f20135c.onADPresent();
                    return;
                case 4:
                    SplashAD.this.f20135c.onADClicked();
                    return;
                case 5:
                    if (paras.length != 1 || !(paras[0] instanceof Long)) {
                        GDTLogger.m25260e("Splash onADTick event get param error.");
                        return;
                    } else {
                        SplashAD.this.f20135c.onADTick(((Long) paras[0]).longValue());
                        return;
                    }
                case 6:
                    SplashAD.this.f20135c.onADExposure();
                    return;
                case 7:
                    if (paras.length != 1 || !(paras[0] instanceof Long)) {
                        GDTLogger.m25260e("Splash onADLoaded event get param error.");
                        break;
                    } else {
                        SplashAD.this.f20135c.onADLoaded(((Long) paras[0]).longValue());
                        return;
                    }
            }
        }
    }

    public SplashAD(Activity activity, View view, String str, SplashADListener splashADListener, int i) {
        this(activity, view, str, splashADListener, i, (View) null);
    }

    public SplashAD(Activity activity, View view, String str, SplashADListener splashADListener, int i, View view2) {
        this(activity, view, str, splashADListener, i, (Map) null, view2);
    }

    public SplashAD(Activity activity, View view, String str, SplashADListener splashADListener, int i, Map map, View view2) {
        this.f20137e = false;
        if (GDTADManager.getInstance().isInitialized()) {
            m25160a(activity, view, GDTADManager.getInstance().getAppStatus().getAPPID(), str, splashADListener, i, map, view2);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        SplashADListener splashADListener2 = splashADListener;
        m25163a(splashADListener, 2003);
    }

    @Deprecated
    public SplashAD(Activity activity, View view, String str, String str2, SplashADListener splashADListener, int i) {
        this(activity, view, str, str2, splashADListener, i, (View) null);
    }

    @Deprecated
    public SplashAD(Activity activity, View view, String str, String str2, SplashADListener splashADListener, int i, View view2) {
        this(activity, view, str, str2, splashADListener, i, null, view2);
    }

    @Deprecated
    public SplashAD(Activity activity, View view, String str, String str2, SplashADListener splashADListener, int i, Map map, View view2) {
        this.f20137e = false;
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25160a(activity, view, str, str2, splashADListener, i, map, view2);
    }

    public SplashAD(Activity activity, String str, SplashADListener splashADListener) {
        this(activity, str, splashADListener, 0);
    }

    public SplashAD(Activity activity, String str, SplashADListener splashADListener, int i) {
        this(activity, (View) null, str, splashADListener, i);
    }

    @Deprecated
    public SplashAD(Activity activity, String str, String str2, SplashADListener splashADListener) {
        this(activity, str, str2, splashADListener, 0);
    }

    @Deprecated
    public SplashAD(Activity activity, String str, String str2, SplashADListener splashADListener, int i) {
        this(activity, (View) null, str, str2, splashADListener, i);
    }

    /* renamed from: a */
    private void m25160a(Activity activity, View view, String str, String str2, SplashADListener splashADListener, int i, Map map, View view2) {
        SplashADListener splashADListener2 = splashADListener;
        this.f20135c = splashADListener2;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m25260e(String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            m25163a(splashADListener2, 2001);
        } else if (!C6411a.m25176a((Context) activity)) {
            GDTLogger.m25260e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            m25163a(splashADListener2, 4002);
        } else {
            ExecutorService executorService = GDTADManager.INIT_EXECUTOR;
            final Activity activity2 = activity;
            final String str3 = str;
            final String str4 = str2;
            final Map map2 = map;
            final int i2 = i;
            final View view3 = view;
            final View view4 = view2;
            final SplashADListener splashADListener3 = splashADListener;
            C64081 r0 = new Runnable() {
                public void run() {
                    if (GDTADManager.getInstance().initWith(activity2, str3)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            SplashAD.this.f20133a = pOFactory.getNativeSplashAdView(activity2, str3, str4);
                                            if (SplashAD.this.f20133a != null) {
                                                if (SplashAD.this.f20136d != null) {
                                                    SplashAD.this.f20133a.setLoadAdParams(SplashAD.this.f20136d);
                                                }
                                                SplashAD.m25162a(SplashAD.this, map2, str4);
                                                SplashAD.this.f20133a.setFetchDelay(i2);
                                                SplashAD.this.f20133a.setAdListener(new ADListenerAdapter(SplashAD.this, 0));
                                                SplashAD.this.f20133a.setSkipView(view3);
                                                SplashAD.this.f20133a.setFloatView(view4);
                                                SplashAD.this.f20133a.setAdLogoMargin(SplashAD.this.f20139g, SplashAD.this.f20140h);
                                                SplashAD.this.f20133a.setPreloadView(SplashAD.this.f20141i);
                                                if (SplashAD.this.f20134b != null) {
                                                    SplashAD.this.fetchAndShowIn(SplashAD.this.f20134b);
                                                }
                                                if (SplashAD.this.f20137e) {
                                                    SplashAD.this.f20133a.preload();
                                                    SplashAD.this.f20137e = false;
                                                }
                                                if (SplashAD.this.f20138f) {
                                                    SplashAD.this.f20133a.fetchAdOnly();
                                                    SplashAD.this.f20138f = false;
                                                }
                                            } else {
                                                GDTLogger.m25260e("SplashAdView created by factory return null");
                                                SplashAD.this.m25163a(splashADListener3, 200103);
                                            }
                                            return;
                                        }
                                        GDTLogger.m25260e("factory return null");
                                        SplashAD.this.m25163a(splashADListener3, 200103);
                                    } catch (Throwable th) {
                                        GDTLogger.m25261e("Unknown Exception", th);
                                        SplashAD.this.m25163a(splashADListener3, (int) OtherError.UNKNOWN_ERROR);
                                    }
                                }
                            });
                        } catch (C6422c e) {
                            GDTLogger.m25261e("Fail to init splash plugin", e);
                            SplashAD.this.m25163a(splashADListener3, 200102);
                        } catch (Throwable th) {
                            GDTLogger.m25261e("Unknown Exception", th);
                            SplashAD.this.m25163a(splashADListener3, (int) OtherError.UNKNOWN_ERROR);
                        }
                    }
                }
            };
            executorService.execute(r0);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m25162a(SplashAD splashAD, Map map, String str) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(KEYS.AD_TAGS, new JSONObject(map), str);
            } catch (Exception e) {
                GDTLogger.m25260e("SplashAD#setTag Exception");
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25163a(final SplashADListener splashADListener, final int i) {
        if (splashADListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    splashADListener.onNoAD(C6411a.m25175a(i));
                }
            });
        }
    }

    public final void fetchAdOnly() {
        if (this.f20133a != null) {
            GDTLogger.m25260e("splashAD fetchAdOnly");
            this.f20133a.fetchAdOnly();
            return;
        }
        this.f20138f = true;
    }

    public final void fetchAndShowIn(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.m25260e("SplashAD fetchAndShowIn params null ");
            m25163a(this.f20135c, 2001);
        } else if (this.f20133a != null) {
            this.f20133a.fetchAndShowIn(viewGroup);
        } else {
            this.f20134b = viewGroup;
        }
    }

    public final String getAdNetWorkName() {
        if (this.f20133a != null) {
            return this.f20133a.getAdNetWorkName();
        }
        GDTLogger.m25260e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onAdPresent\"");
        return null;
    }

    public final Map getExt() {
        try {
            NSPVI nspvi = this.f20133a;
            return NSPVI.ext;
        } catch (Exception e) {
            GDTLogger.m25260e("splash ad can not get extra");
            e.printStackTrace();
            return null;
        }
    }

    public final void preLoad() {
        if (this.f20133a != null) {
            this.f20133a.preload();
        } else {
            this.f20137e = true;
        }
    }

    public final void setAdLogoMargin(int i, int i2) {
        this.f20139g = i;
        this.f20140h = i2;
    }

    public final void setLoadAdParams(LoadAdParams loadAdParams) {
        if (this.f20133a != null) {
            this.f20133a.setLoadAdParams(loadAdParams);
        } else {
            this.f20136d = loadAdParams;
        }
    }

    public final void setPreloadView(View view) {
        if (this.f20133a != null) {
            this.f20133a.setPreloadView(view);
        } else {
            this.f20141i = view;
        }
    }

    public final void showAd(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.m25260e("SplashAD showAd params null ");
            m25163a(this.f20135c, 2001);
        } else if (this.f20133a != null) {
            this.f20133a.showAd(viewGroup);
        } else {
            this.f20134b = viewGroup;
        }
    }
}
