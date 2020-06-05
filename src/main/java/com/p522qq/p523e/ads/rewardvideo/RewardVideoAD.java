package com.p522qq.p523e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.constants.LoadAdParams;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.p525pi.RVADI;
import com.p522qq.p523e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD */
public class RewardVideoAD {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public RewardVideoADListener f20113a;
    /* access modifiers changed from: private|volatile */
    /* renamed from: b */
    public volatile boolean f20114b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public RVADI f20115c;
    /* renamed from: d */
    private volatile boolean f20116d;
    /* renamed from: e */
    private volatile boolean f20117e;
    /* access modifiers changed from: private|volatile */
    /* renamed from: f */
    public volatile boolean f20118f;
    /* renamed from: g */
    private String f20119g;
    /* renamed from: h */
    private Map<String, String> f20120h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public LoadAdParams f20121i;

    /* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD$ADListenerAdapter */
    public static class ADListenerAdapter implements ADListener {
        public static final int EVENT_TYPE_ON_AD_CLICK = 6;
        public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
        public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
        public static final int EVENT_TYPE_ON_AD_LOADED = 1;
        public static final int EVENT_TYPE_ON_AD_SHOW = 3;
        public static final int EVENT_TYPE_ON_ERROR = 9;
        public static final int EVENT_TYPE_ON_REWARD = 5;
        public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
        public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;
        /* renamed from: a */
        private WeakReference<RewardVideoAD> f20132a;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                    this.adListener.onADLoad();
                    break;
                case 2:
                    this.adListener.onVideoCached();
                    return;
                case 3:
                    this.adListener.onADShow();
                    return;
                case 4:
                    this.adListener.onADExpose();
                    return;
                case 5:
                    this.adListener.onReward();
                    return;
                case 6:
                    if (this.f20132a != null && aDEvent.getParas().length == 1) {
                        Object obj = aDEvent.getParas()[0];
                        if ((obj instanceof String) && this.f20132a.get() != null) {
                            ((RewardVideoAD) this.f20132a.get()).setExt((String) obj);
                        }
                    }
                    this.adListener.onADClick();
                    return;
                case 7:
                    this.adListener.onVideoComplete();
                    return;
                case 8:
                    this.adListener.onADClose();
                    return;
                case 9:
                    if (aDEvent.getParas().length > 0 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.adListener.onError(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
                        break;
                    }
            }
        }

        public void setBase(RewardVideoAD rewardVideoAD) {
            this.f20132a = new WeakReference<>(rewardVideoAD);
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.f20120h = new HashMap();
        this.f20121i = null;
        if (GDTADManager.getInstance().isInitialized()) {
            m25152a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, rewardVideoADListener, z);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        rewardVideoADListener.onError(C6411a.m25175a(2003));
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener) {
        this(context, str, str2, rewardVideoADListener, true);
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.f20120h = new HashMap();
        this.f20121i = null;
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25152a(context, str, str2, rewardVideoADListener, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25151a(final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (RewardVideoAD.this.f20113a != null) {
                    RewardVideoAD.this.f20113a.onError(C6411a.m25175a(i));
                }
            }
        });
    }

    /* renamed from: a */
    private void m25152a(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || rewardVideoADListener == null) {
            GDTLogger.m25260e(String.format("RewardVideoAD Constructor params error, context=%s, appID=%s, posID=%s, rewardVideoADListener=%s", new Object[]{context, str, str2, rewardVideoADListener}));
            return;
        }
        this.f20113a = rewardVideoADListener;
        this.f20116d = true;
        if (!C6411a.m25176a(context)) {
            GDTLogger.m25260e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            m25151a(4002);
            return;
        }
        this.f20117e = true;
        this.f20119g = str2;
        ExecutorService executorService = GDTADManager.INIT_EXECUTOR;
        final Context context2 = context;
        final String str3 = str;
        final RewardVideoADListener rewardVideoADListener2 = rewardVideoADListener;
        final String str4 = str2;
        final boolean z2 = z;
        C64051 r1 = new Runnable() {
            public void run() {
                if (GDTADManager.getInstance().initWith(context2, str3)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        ADListenerAdapter aDListenerAdapter = new ADListenerAdapter(rewardVideoADListener2);
                                        aDListenerAdapter.setBase(RewardVideoAD.this);
                                        RewardVideoAD.this.f20115c = pOFactory.getRewardVideoADDelegate(context2, str3, str4, aDListenerAdapter);
                                        RewardVideoAD.this.f20115c.setVolumeOn(z2);
                                        RewardVideoAD.this.f20115c.setLoadAdParams(RewardVideoAD.this.f20121i);
                                        RewardVideoAD.this.f20114b = true;
                                        if (RewardVideoAD.this.f20118f) {
                                            RewardVideoAD.this.loadAD();
                                        }
                                        return;
                                    }
                                    RewardVideoAD.this.m25151a(2001);
                                } catch (Throwable th) {
                                    GDTLogger.m25261e("Exception while init Core", th);
                                    RewardVideoAD.this.m25151a(2001);
                                }
                            }
                        });
                        return;
                    } catch (Throwable th) {
                        GDTLogger.m25261e("Exception while init Reward Video AD Core", th);
                    }
                }
                RewardVideoAD.this.m25151a(2001);
            }
        };
        executorService.execute(r1);
    }

    public String getAdNetWorkName() {
        RVADI rvadi = this.f20115c;
        if (rvadi != null) {
            return rvadi.getAdNetWorkName();
        }
        GDTLogger.m25260e("please invoke getAdNetWorkName method after callback \"onADLoad\" or the ad does not support \"getAdNetWorkName\" ");
        return null;
    }

    public int getECPM() {
        RVADI rvadi = this.f20115c;
        if (rvadi != null) {
            return rvadi.getECPM();
        }
        GDTLogger.m25260e("please invoke getECPM method after callback \"onADLoad\" ");
        return -1;
    }

    public String getECPMLevel() {
        RVADI rvadi = this.f20115c;
        if (rvadi != null) {
            return rvadi.getECPMLevel();
        }
        GDTLogger.m25260e("please invoke getECPMLevel method after callback \"onADLoad\" ");
        return null;
    }

    public long getExpireTimestamp() {
        RVADI rvadi = this.f20115c;
        if (rvadi != null) {
            return rvadi.getExpireTimestamp();
        }
        GDTLogger.m25260e("please invoke getExpireTimestamp method after callback \"onADLoad\" ");
        return 0;
    }

    public Map<String, String> getExts() {
        return this.f20120h;
    }

    public boolean hasShown() {
        RVADI rvadi = this.f20115c;
        if (rvadi != null) {
            return rvadi.hasShown();
        }
        GDTLogger.m25260e("please invoke hasShown method after callback \"onADLoad\" ");
        return false;
    }

    public void loadAD() {
        if (!this.f20116d || !this.f20117e) {
            GDTLogger.m25260e("AD init Params OR Context error, details in logs produced while init RewardVideoAD");
        } else if (!this.f20114b) {
            this.f20118f = true;
        } else {
            RVADI rvadi = this.f20115c;
            if (rvadi != null) {
                rvadi.loadAD();
            } else {
                GDTLogger.m25260e("RewardVideo AD Init error, see more logs");
            }
        }
    }

    public void setExt(String str) {
        this.f20120h.put(KEYS.EXPOSED_CLICK_URL_KEY, str);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f20121i = loadAdParams;
        RVADI rvadi = this.f20115c;
        if (rvadi != null) {
            rvadi.setLoadAdParams(this.f20121i);
        }
    }

    public void setTag(Map map) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(KEYS.AD_TAGS, new JSONObject(map), this.f20119g);
            } catch (Exception e) {
                GDTLogger.m25260e("NativeUnifiedAD#setTag Exception");
                e.printStackTrace();
            }
        }
    }

    public void showAD() {
        RVADI rvadi = this.f20115c;
        if (rvadi != null) {
            rvadi.showAD();
        } else {
            GDTLogger.m25260e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }

    public void showAD(Activity activity) {
        RVADI rvadi = this.f20115c;
        if (rvadi != null) {
            rvadi.showAD(activity);
        } else {
            GDTLogger.m25260e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }
}
