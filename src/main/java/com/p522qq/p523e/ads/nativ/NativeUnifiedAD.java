package com.p522qq.p523e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p522qq.p523e.ads.AbstractAD;
import com.p522qq.p523e.ads.AbstractAD.BasicADListener;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.constants.LoadAdParams;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.ADI;
import com.p522qq.p523e.comm.p525pi.NUADI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedAD */
public class NativeUnifiedAD extends AbstractAD<NUADI> {
    /* renamed from: a */
    private AdListenerAdapter f20091a;
    /* renamed from: b */
    private List<Integer> f20092b = new ArrayList();
    /* renamed from: c */
    private List<String> f20093c;
    /* renamed from: d */
    private String f20094d;
    /* renamed from: e */
    private volatile int f20095e;
    /* renamed from: f */
    private volatile int f20096f;
    /* renamed from: g */
    private int f20097g = 0;
    /* renamed from: h */
    private int f20098h = 0;
    /* renamed from: i */
    private String f20099i;
    /* renamed from: j */
    private LoadAdParams f20100j;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedAD$AdListenerAdapter */
    private static class AdListenerAdapter implements ADListener {
        /* renamed from: a */
        private NativeADUnifiedListener f20104a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f20104a = nativeADUnifiedListener;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.f20104a != null) {
                Object[] paras = aDEvent.getParas();
                int type = aDEvent.getType();
                if (type != 1) {
                    if (type == 2 && paras.length > 0 && (paras[0] instanceof Integer)) {
                        this.f20104a.onNoAD(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
                    }
                } else if (paras.length == 1 && (paras[0] instanceof List)) {
                    List<NativeUnifiedADData> list = (List) paras[0];
                    ArrayList arrayList = new ArrayList();
                    if (list != null && list.size() > 0) {
                        for (NativeUnifiedADData nativeUnifiedADDataAdapter : list) {
                            arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADDataAdapter));
                        }
                    }
                    this.f20104a.onADLoaded(arrayList);
                }
                return;
            }
            GDTLogger.m25262i("not bind NativeADUnifiedListener");
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            m25142a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, nativeADUnifiedListener);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        mo29636a((BasicADListener) nativeADUnifiedListener, 2003);
    }

    @Deprecated
    public NativeUnifiedAD(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25142a(context, str, str2, nativeADUnifiedListener);
    }

    /* renamed from: a */
    private void m25141a(int i, boolean z) {
        if (!mo29639c()) {
            GDTLogger.m25260e("Parameters or context error, details in init NativeUnifiedAD log");
            return;
        }
        if (mo29638b()) {
            NUADI nuadi = (NUADI) mo29633a();
            if (nuadi != null) {
                LoadAdParams loadAdParams = this.f20100j;
                if (loadAdParams != null) {
                    nuadi.loadData(i, loadAdParams);
                } else {
                    nuadi.loadData(i);
                }
            }
        } else if (z) {
            this.f20092b.add(Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    private void m25142a(Context context, String str, String str2, NativeADUnifiedListener nativeADUnifiedListener) {
        if (context == null || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            GDTLogger.m25260e(String.format("NativeUnifiedAD constructor parameters error, appId=%s, posId=%s, context=%s", new Object[]{str, str2, context}));
            mo29636a((BasicADListener) nativeADUnifiedListener, 4002);
            return;
        }
        this.f20091a = new AdListenerAdapter(nativeADUnifiedListener);
        this.f20094d = str2;
        mo29635a(context, str, str2, (BasicADListener) nativeADUnifiedListener);
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ ADI mo29634a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, this.f20091a);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29636a(final BasicADListener basicADListener, final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                NativeUnifiedAD.super.mo29636a(basicADListener, i);
            }
        });
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29637a(ADI adi) {
        NUADI nuadi = (NUADI) adi;
        nuadi.setMinVideoDuration(this.f20095e);
        nuadi.setMaxVideoDuration(this.f20096f);
        nuadi.setVideoPlayPolicy(this.f20097g);
        nuadi.setVideoADContainerRender(this.f20098h);
        nuadi.setVastClassName(this.f20099i);
        List<String> list = this.f20093c;
        if (list != null) {
            setCategories(list);
        }
        for (Integer intValue : this.f20092b) {
            m25141a(intValue.intValue(), false);
        }
    }

    public String getAdNetWorkName() {
        NUADI nuadi = (NUADI) mo29633a();
        if (nuadi != null) {
            return nuadi.getAdNetWorkName();
        }
        GDTLogger.m25260e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onADLoaded\"");
        return null;
    }

    public void loadData(int i) {
        loadData(i, null);
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        if (loadAdParams != null) {
            this.f20100j = loadAdParams;
            if (this.f20100j.getPassThroughInfoJsonString().getBytes().length >= 512) {
                StringBuilder sb = new StringBuilder("NativeUnifiedAD setAdParams too large ,current size: ");
                sb.append(this.f20100j.toString().getBytes().length);
                GDTLogger.m25260e(sb.toString());
            }
        }
        m25141a(i, true);
        if (this.f20097g == 0) {
            GDTLogger.m25262i("请调用setVideoPlayPolicy()接口，设置“用户感知的视频广告播放策略”，有助于提高视频广告的eCPM值；如果广告位不支持视频广告，请忽略本提示。");
        }
        if (this.f20098h == 0) {
            GDTLogger.m25262i("请调用setVideoADContainerRender()接口，设置“用户首次看到的视频广告容器”渲染策略，有助于提高视频广告的eCPM值；如果广告位不支持视频广告，请忽略本提示。");
        }
    }

    public void setCategories(List<String> list) {
        this.f20093c = list;
        NUADI nuadi = (NUADI) mo29633a();
        if (nuadi != null && list != null) {
            nuadi.setCategories(list);
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f20096f = i;
        if (this.f20096f > 0 && this.f20095e > this.f20096f) {
            GDTLogger.m25260e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        NUADI nuadi = (NUADI) mo29633a();
        if (nuadi != null) {
            nuadi.setMaxVideoDuration(this.f20096f);
        }
    }

    public void setMinVideoDuration(int i) {
        this.f20095e = i;
        if (this.f20096f > 0 && this.f20095e > this.f20096f) {
            GDTLogger.m25260e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        NUADI nuadi = (NUADI) mo29633a();
        if (nuadi != null) {
            nuadi.setMinVideoDuration(this.f20095e);
        }
    }

    public void setTag(Map map) {
        if (map != null && map.size() > 0) {
            try {
                GDTADManager.getInstance().getSM().setDEVCodeSetting(KEYS.AD_TAGS, new JSONObject(map), this.f20094d);
            } catch (Exception e) {
                GDTLogger.m25260e("NativeUnifiedAD#setTag Exception");
                e.printStackTrace();
            }
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.m25260e("Vast class name can't be null");
            return;
        }
        this.f20099i = str;
        NUADI nuadi = (NUADI) mo29633a();
        if (nuadi != null) {
            nuadi.setVastClassName(str);
        }
    }

    public void setVideoADContainerRender(int i) {
        if (i == 1 || i == 2) {
            this.f20098h = i;
            NUADI nuadi = (NUADI) mo29633a();
            if (nuadi != null) {
                nuadi.setVideoADContainerRender(i);
            }
            return;
        }
        GDTLogger.m25260e("videoADContainerRender参数有误，只能是VideoADContainerRender.SDK 或 VideoADContainerRender.DEV");
    }

    public void setVideoPlayPolicy(int i) {
        if (i == 1 || i == 2) {
            this.f20097g = i;
            NUADI nuadi = (NUADI) mo29633a();
            if (nuadi != null) {
                nuadi.setVideoPlayPolicy(i);
            }
            return;
        }
        GDTLogger.m25260e("videoPlayPolicy参数有误，只能是VideoPlayPolicy.AUTO 或 VideoPlayPolicy.MANUAL");
    }
}
