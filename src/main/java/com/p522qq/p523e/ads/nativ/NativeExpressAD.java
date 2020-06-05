package com.p522qq.p523e.ads.nativ;

import android.content.Context;
import com.p522qq.p523e.ads.AbstractAD;
import com.p522qq.p523e.ads.AbstractAD.BasicADListener;
import com.p522qq.p523e.ads.cfg.VideoOption;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.constants.LoadAdParams;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.ADI;
import com.p522qq.p523e.comm.p525pi.NEADI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.nativ.NativeExpressAD */
public class NativeExpressAD extends AbstractAD<NEADI> {
    public static final int EVENT_TYPE_AD_WILL_OPEN_OVERLAY = 20;
    public static final int EVENT_TYPE_ON_AD_CLICKED = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSED = 7;
    public static final int EVENT_TYPE_ON_AD_CLOSE_OVERLAY = 10;
    public static final int EVENT_TYPE_ON_AD_EXPOSURE = 5;
    public static final int EVENT_TYPE_ON_AD_LEFT_APPLICATION = 8;
    public static final int EVENT_TYPE_ON_AD_LOADED = 2;
    public static final int EVENT_TYPE_ON_AD_OPEN_OVERLAY = 9;
    public static final int EVENT_TYPE_ON_NO_AD = 1;
    public static final int EVENT_TYPE_ON_RENDER_FAILED = 3;
    public static final int EVENT_TYPE_ON_RENDER_SUCCESS = 4;
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 21;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 16;
    public static final int EVENT_TYPE_ON_VIDEO_ERROR = 17;
    public static final int EVENT_TYPE_ON_VIDEO_INIT = 11;
    public static final int EVENT_TYPE_ON_VIDEO_LOADING = 12;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_CLOSE = 19;
    public static final int EVENT_TYPE_ON_VIDEO_PAGE_OPEN = 18;
    public static final int EVENT_TYPE_ON_VIDEO_PAUSE = 15;
    public static final int EVENT_TYPE_ON_VIDEO_READY = 13;
    public static final int EVENT_TYPE_ON_VIDEO_START = 14;
    /* renamed from: a */
    private volatile int f20057a;
    /* renamed from: b */
    private volatile int f20058b;
    /* renamed from: c */
    private volatile int f20059c;
    /* renamed from: d */
    private List<Integer> f20060d = Collections.synchronizedList(new ArrayList());
    /* renamed from: e */
    private VideoOption f20061e;
    /* renamed from: f */
    private ADSize f20062f;
    /* renamed from: g */
    private NativeExpressADListener f20063g;
    /* renamed from: h */
    private String f20064h;
    /* renamed from: i */
    private LoadAdParams f20065i;

    /* renamed from: com.qq.e.ads.nativ.NativeExpressAD$ADListenerAdapter */
    public static class ADListenerAdapter implements ADListener {
        /* renamed from: a */
        private NativeExpressADListener f20066a;
        /* renamed from: b */
        private NativeExpressMediaListener f20067b;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f20066a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f20067b = nativeExpressMediaListener;
        }

        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    NativeExpressAD.m25126a(this.f20066a, aDEvent);
                    return;
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                    NativeExpressAD.m25127a(this.f20067b, aDEvent);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.qq.e.ads.nativ.NativeExpressAD$NativeExpressADListener */
    public interface NativeExpressADListener extends BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADCloseOverlay(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onADOpenOverlay(NativeExpressADView nativeExpressADView);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            m25125a(context, aDSize, GDTADManager.getInstance().getAppStatus().getAPPID(), str, nativeExpressADListener);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        mo29636a((BasicADListener) nativeExpressADListener, 2003);
    }

    @Deprecated
    public NativeExpressAD(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25125a(context, aDSize, str, str2, nativeExpressADListener);
    }

    /* renamed from: a */
    private void m25125a(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || aDSize == null || context == null) {
            GDTLogger.m25260e(String.format("NativeExpressAD Constructor params error, adSize=%s, appid=%s, posId=%s, context=%s", new Object[]{aDSize, str, str2, context}));
            mo29636a((BasicADListener) nativeExpressADListener, 2001);
            return;
        }
        this.f20062f = aDSize;
        this.f20063g = nativeExpressADListener;
        this.f20064h = str2;
        mo29635a(context, str, str2, (BasicADListener) nativeExpressADListener);
    }

    /* renamed from: a */
    static /* synthetic */ void m25126a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener == null) {
            GDTLogger.m25262i("No DevADListener Bound");
            return;
        }
        String str = "ADEvent.Params error for NativeExpressAD(";
        String str2 = ")";
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                    StringBuilder sb = new StringBuilder("AdEvent.Params error for NativeExpressAD(");
                    sb.append(aDEvent);
                    sb.append(str2);
                    GDTLogger.m25260e(sb.toString());
                    break;
                } else {
                    nativeExpressADListener.onNoAD(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                break;
            case 2:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof List)) {
                    StringBuilder sb2 = new StringBuilder(str);
                    sb2.append(aDEvent);
                    sb2.append(str2);
                    GDTLogger.m25260e(sb2.toString());
                    return;
                }
                nativeExpressADListener.onADLoaded((List) aDEvent.getParas()[0]);
                return;
            case 3:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb3 = new StringBuilder(str);
                    sb3.append(aDEvent);
                    sb3.append(str2);
                    GDTLogger.m25260e(sb3.toString());
                    return;
                }
                nativeExpressADListener.onRenderFail((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 4:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb4 = new StringBuilder(str);
                    sb4.append(aDEvent);
                    sb4.append(str2);
                    GDTLogger.m25260e(sb4.toString());
                    return;
                }
                nativeExpressADListener.onRenderSuccess((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 5:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb5 = new StringBuilder(str);
                    sb5.append(aDEvent);
                    sb5.append(str2);
                    GDTLogger.m25260e(sb5.toString());
                    return;
                }
                nativeExpressADListener.onADExposure((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 6:
                if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb6 = new StringBuilder(str);
                    sb6.append(aDEvent);
                    sb6.append(str2);
                    GDTLogger.m25260e(sb6.toString());
                    return;
                }
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParas()[0];
                nativeExpressADListener.onADClicked(nativeExpressADView);
                if (aDEvent.getParas()[1] instanceof String) {
                    nativeExpressADView.ext.put(KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[1]);
                }
                return;
            case 7:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb7 = new StringBuilder(str);
                    sb7.append(aDEvent);
                    sb7.append(str2);
                    GDTLogger.m25260e(sb7.toString());
                    return;
                }
                nativeExpressADListener.onADClosed((NativeExpressADView) aDEvent.getParas()[0]);
                ((NativeExpressADView) aDEvent.getParas()[0]).negativeFeedback();
                return;
            case 8:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb8 = new StringBuilder(str);
                    sb8.append(aDEvent);
                    sb8.append(str2);
                    GDTLogger.m25260e(sb8.toString());
                    return;
                }
                nativeExpressADListener.onADLeftApplication((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 9:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb9 = new StringBuilder(str);
                    sb9.append(aDEvent);
                    sb9.append(str2);
                    GDTLogger.m25260e(sb9.toString());
                    return;
                }
                nativeExpressADListener.onADOpenOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 10:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb10 = new StringBuilder(str);
                    sb10.append(aDEvent);
                    sb10.append(str2);
                    GDTLogger.m25260e(sb10.toString());
                    break;
                } else {
                    nativeExpressADListener.onADCloseOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m25127a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        if (nativeExpressMediaListener == null) {
            GDTLogger.m25262i("No media listener");
            return;
        }
        String str = ")";
        String str2 = "ADEvent.Params error for NativeExpressAD(";
        switch (aDEvent.getType()) {
            case 11:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb = new StringBuilder(str2);
                    sb.append(aDEvent);
                    sb.append(str);
                    GDTLogger.m25260e(sb.toString());
                    break;
                } else {
                    nativeExpressMediaListener.onVideoInit((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
                break;
            case 12:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb2 = new StringBuilder(str2);
                    sb2.append(aDEvent);
                    sb2.append(str);
                    GDTLogger.m25260e(sb2.toString());
                    return;
                }
                nativeExpressMediaListener.onVideoLoading((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 13:
                if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView) || !(aDEvent.getParas()[1] instanceof Integer)) {
                    GDTLogger.m25260e("NativeMedia ADEvent Paras error!");
                    return;
                } else {
                    nativeExpressMediaListener.onVideoReady((NativeExpressADView) aDEvent.getParas()[0], (long) ((Integer) aDEvent.getParas()[1]).intValue());
                    return;
                }
            case 14:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb3 = new StringBuilder(str2);
                    sb3.append(aDEvent);
                    sb3.append(str);
                    GDTLogger.m25260e(sb3.toString());
                    return;
                }
                nativeExpressMediaListener.onVideoStart((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 15:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb4 = new StringBuilder(str2);
                    sb4.append(aDEvent);
                    sb4.append(str);
                    GDTLogger.m25260e(sb4.toString());
                    return;
                }
                nativeExpressMediaListener.onVideoPause((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 16:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb5 = new StringBuilder(str2);
                    sb5.append(aDEvent);
                    sb5.append(str);
                    GDTLogger.m25260e(sb5.toString());
                    return;
                }
                nativeExpressMediaListener.onVideoComplete((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 17:
                if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView) || !(aDEvent.getParas()[1] instanceof Integer)) {
                    GDTLogger.m25260e("Native express media event paras error!");
                    return;
                } else {
                    nativeExpressMediaListener.onVideoError((NativeExpressADView) aDEvent.getParas()[0], C6411a.m25175a(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                }
            case 18:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb6 = new StringBuilder(str2);
                    sb6.append(aDEvent);
                    sb6.append(str);
                    GDTLogger.m25260e(sb6.toString());
                    return;
                }
                nativeExpressMediaListener.onVideoPageOpen((NativeExpressADView) aDEvent.getParas()[0]);
                return;
            case 19:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb7 = new StringBuilder(str2);
                    sb7.append(aDEvent);
                    sb7.append(str);
                    GDTLogger.m25260e(sb7.toString());
                    break;
                } else {
                    nativeExpressMediaListener.onVideoPageClose((NativeExpressADView) aDEvent.getParas()[0]);
                    return;
                }
            case 21:
                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                    StringBuilder sb8 = new StringBuilder(str2);
                    sb8.append(aDEvent);
                    sb8.append(str);
                    GDTLogger.m25260e(sb8.toString());
                    return;
                }
                nativeExpressMediaListener.onVideoCached((NativeExpressADView) aDEvent.getParas()[0]);
                return;
        }
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ ADI mo29634a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeExpressADDelegate(context, this.f20062f, str, str2, new ADListenerAdapter(this.f20063g));
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29637a(ADI adi) {
        NEADI neadi = (NEADI) adi;
        neadi.setMinVideoDuration(this.f20057a);
        neadi.setMaxVideoDuration(this.f20058b);
        neadi.setVideoPlayPolicy(this.f20059c);
        VideoOption videoOption = this.f20061e;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f20060d) {
            for (Integer intValue : this.f20060d) {
                loadAD(intValue.intValue());
            }
        }
    }

    public void loadAD(int i) {
        loadAD(i, null);
    }

    public void loadAD(int i, LoadAdParams loadAdParams) {
        if (!mo29639c()) {
            GDTLogger.m25260e("AD init Paras OR Context error,details in logs produced while init NativeAD");
            return;
        }
        if (loadAdParams != null) {
            setAdParams(loadAdParams);
        }
        if (this.f20059c == 0) {
            GDTLogger.m25262i("请调用setVideoPlayPolicy()接口，设置“用户感知的视频广告播放策略”，有助于提高视频广告的eCPM值；如果广告位不支持视频广告，请忽略本提示。");
        }
        if (!mo29638b()) {
            this.f20060d.add(Integer.valueOf(i));
            return;
        }
        NEADI neadi = (NEADI) mo29633a();
        if (neadi != null) {
            LoadAdParams loadAdParams2 = this.f20065i;
            if (loadAdParams2 != null) {
                neadi.loadAd(i, loadAdParams2);
            } else {
                neadi.loadAd(i);
            }
        } else {
            GDTLogger.m25260e("Native Express AD Init error, see more logs");
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f20065i = loadAdParams;
        if (loadAdParams != null && loadAdParams.getPassThroughInfoJsonString() != null && loadAdParams.getPassThroughInfoJsonString().getBytes().length >= 512) {
            StringBuilder sb = new StringBuilder("NativeExpressAD setAdParams too large ,current size: ");
            sb.append(loadAdParams.toString().getBytes().length);
            GDTLogger.m25260e(sb.toString());
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f20058b = i;
        if (this.f20058b > 0 && this.f20057a > this.f20058b) {
            GDTLogger.m25260e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        NEADI neadi = (NEADI) mo29633a();
        if (neadi != null) {
            neadi.setMaxVideoDuration(this.f20058b);
        }
    }

    public void setMinVideoDuration(int i) {
        this.f20057a = i;
        if (this.f20058b > 0 && this.f20057a > this.f20058b) {
            GDTLogger.m25260e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        NEADI neadi = (NEADI) mo29633a();
        if (neadi != null) {
            neadi.setMinVideoDuration(this.f20057a);
        }
    }

    public void setTag(Map map) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(KEYS.AD_TAGS, new JSONObject(map), this.f20064h);
            } catch (Exception e) {
                GDTLogger.m25260e("NativeUnifiedAD#setTag Exception");
                e.printStackTrace();
            }
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f20061e = videoOption;
        NEADI neadi = (NEADI) mo29633a();
        if (neadi != null && videoOption != null) {
            neadi.setVideoOption(videoOption);
        }
    }

    public void setVideoPlayPolicy(int i) {
        if (i == 1 || i == 2) {
            this.f20059c = i;
            NEADI neadi = (NEADI) mo29633a();
            if (neadi != null) {
                neadi.setVideoPlayPolicy(this.f20059c);
            }
            return;
        }
        GDTLogger.m25260e("videoPlayPolicy参数有误，只能是VideoPlayPolicy.AUTO 或 VideoPlayPolicy.MANUAL");
    }
}
