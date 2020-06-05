package com.p522qq.p523e.ads.contentad;

import android.content.Context;
import com.p522qq.p523e.ads.AbstractAD;
import com.p522qq.p523e.ads.AbstractAD.BasicADListener;
import com.p522qq.p523e.ads.nativ.NativeMediaADData;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.ADI;
import com.p522qq.p523e.comm.p525pi.CAI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.AdError;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import com.tencent.stat.apkreader.ChannelReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.qq.e.ads.contentad.ContentAD */
public class ContentAD extends AbstractAD<CAI> {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public ContentADListener f19984a;
    /* renamed from: b */
    private List<Map<String, Object>> f19985b = new ArrayList();

    /* renamed from: com.qq.e.ads.contentad.ContentAD$ADListenerAdapter */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(ContentAD contentAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (ContentAD.this.f19984a == null) {
                GDTLogger.m25262i("No DevADListener Binded");
                return;
            }
            int type = aDEvent.getType();
            String str = ")";
            if (type != 1) {
                String str2 = "ADEvent.Paras error for ContentAD(";
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            if (type == 5) {
                                if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                                    StringBuilder sb = new StringBuilder(str2);
                                    sb.append(aDEvent);
                                    sb.append(str);
                                    GDTLogger.m25260e(sb.toString());
                                } else {
                                    ContentAD.this.f19984a.onADVideoLoaded((NativeMediaADData) aDEvent.getParas()[0]);
                                }
                            }
                        } else if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof ContentAdData) || !(aDEvent.getParas()[1] instanceof Integer)) {
                            StringBuilder sb2 = new StringBuilder(str2);
                            sb2.append(aDEvent);
                            sb2.append(str);
                            GDTLogger.m25260e(sb2.toString());
                        } else {
                            ContentAD.this.f19984a.onContentADError((ContentAdData) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                        }
                    } else if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        StringBuilder sb3 = new StringBuilder(str2);
                        sb3.append(aDEvent);
                        sb3.append(str);
                        GDTLogger.m25260e(sb3.toString());
                    } else {
                        ContentAD.this.f19984a.onContentADStatusChanged((NativeMediaADData) aDEvent.getParas()[0]);
                    }
                } else if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof List)) {
                    StringBuilder sb4 = new StringBuilder(str2);
                    sb4.append(aDEvent);
                    sb4.append(str);
                    GDTLogger.m25260e(sb4.toString());
                } else {
                    ContentAD.this.f19984a.onContentADLoaded((List) aDEvent.getParas()[0]);
                }
            } else if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                StringBuilder sb5 = new StringBuilder("AdEvent.Paras error for ContentAD(");
                sb5.append(aDEvent);
                sb5.append(str);
                GDTLogger.m25260e(sb5.toString());
            } else {
                ContentAD.this.f19984a.onNoContentAD(((Integer) aDEvent.getParas()[0]).intValue());
            }
        }
    }

    /* renamed from: com.qq.e.ads.contentad.ContentAD$BasicADListenerAdapter */
    private static final class BasicADListenerAdapter implements BasicADListener {
        /* renamed from: a */
        private ContentADListener f19987a;

        public BasicADListenerAdapter(ContentADListener contentADListener) {
            this.f19987a = contentADListener;
        }

        public final void onNoAD(AdError adError) {
            this.f19987a.onNoContentAD(adError.getErrorCode());
        }
    }

    /* renamed from: com.qq.e.ads.contentad.ContentAD$ContentADListener */
    public interface ContentADListener {
        void onADVideoLoaded(ContentAdData contentAdData);

        void onContentADError(ContentAdData contentAdData, int i);

        void onContentADLoaded(List<ContentAdData> list);

        void onContentADStatusChanged(ContentAdData contentAdData);

        void onNoContentAD(int i);
    }

    public ContentAD(Context context, String str, ContentADListener contentADListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            m25095a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, contentADListener);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        contentADListener.onNoContentAD(2003);
    }

    @Deprecated
    public ContentAD(Context context, String str, String str2, ContentADListener contentADListener) {
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25095a(context, str, str2, contentADListener);
    }

    /* renamed from: a */
    private void m25095a(Context context, String str, String str2, ContentADListener contentADListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.m25260e(String.format("GDTContentAd Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, context}));
            mo29636a((BasicADListener) new BasicADListenerAdapter(contentADListener), 2001);
            return;
        }
        this.f19984a = contentADListener;
        mo29635a(context, str, str2, (BasicADListener) new BasicADListenerAdapter(contentADListener));
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ ADI mo29634a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getContentAdDelegate(context, str, str2, new ADListenerAdapter(this, 0));
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29637a(ADI adi) {
        for (Map map : this.f19985b) {
            loadAD(((Integer) map.get("page_number")).intValue(), ((Integer) map.get(ChannelReader.CHANNEL_KEY)).intValue(), ((Boolean) map.get("is_manual_operation")).booleanValue());
        }
    }

    public void loadAD(int i, int i2, boolean z) {
        if (!mo29639c()) {
            GDTLogger.m25260e("AD init Paras OR Context error,details in logs produced while init ContentAD");
        } else if (!mo29638b()) {
            HashMap hashMap = new HashMap();
            hashMap.put("page_number", Integer.valueOf(i));
            hashMap.put(ChannelReader.CHANNEL_KEY, Integer.valueOf(i2));
            hashMap.put("is_manual_operation", Boolean.valueOf(z));
            this.f19985b.add(hashMap);
        } else {
            CAI cai = (CAI) mo29633a();
            if (cai != null) {
                cai.loadAd(i, i2, z);
            } else {
                GDTLogger.m25260e("ContentAD Init error,See More Logs");
            }
        }
    }
}
