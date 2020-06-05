package com.p522qq.p523e.ads.nativ;

import android.content.Context;
import com.p522qq.p523e.ads.AbstractAD;
import com.p522qq.p523e.ads.AbstractAD.BasicADListener;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.p525pi.ADI;
import com.p522qq.p523e.comm.p525pi.NVADI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.AdError;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeMediaAD */
public class NativeMediaAD extends AbstractAD<NVADI> {
    /* renamed from: a */
    private volatile int f20086a;
    /* renamed from: b */
    private volatile int f20087b;
    /* renamed from: c */
    private List<Integer> f20088c = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: d */
    public NativeMediaADListener f20089d;

    /* renamed from: com.qq.e.ads.nativ.NativeMediaAD$ADListenerAdapter */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(NativeMediaAD nativeMediaAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (NativeMediaAD.this.f20089d == null) {
                GDTLogger.m25262i("No DevADListener Binded");
                return;
            }
            String str = "ADEvent.Paras error for NativeMediaAD(";
            String str2 = ")";
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        StringBuilder sb = new StringBuilder("AdEvent.Paras error for NativeMediaAD(");
                        sb.append(aDEvent);
                        sb.append(str2);
                        GDTLogger.m25260e(sb.toString());
                        break;
                    } else {
                        NativeMediaAD.this.f20089d.onNoAD(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
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
                    NativeMediaAD.this.f20089d.onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                case 3:
                    if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        StringBuilder sb3 = new StringBuilder(str);
                        sb3.append(aDEvent);
                        sb3.append(str2);
                        GDTLogger.m25260e(sb3.toString());
                        return;
                    }
                    NativeMediaAD.this.f20089d.onADStatusChanged((NativeMediaADData) aDEvent.getParas()[0]);
                    return;
                case 4:
                    if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeADDataRef) || !(aDEvent.getParas()[1] instanceof Integer)) {
                        StringBuilder sb4 = new StringBuilder(str);
                        sb4.append(aDEvent);
                        sb4.append(str2);
                        GDTLogger.m25260e(sb4.toString());
                        return;
                    }
                    NativeMediaAD.this.f20089d.onADError((NativeMediaADData) aDEvent.getParas()[0], C6411a.m25175a(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                case 5:
                    if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        StringBuilder sb5 = new StringBuilder(str);
                        sb5.append(aDEvent);
                        sb5.append(str2);
                        GDTLogger.m25260e(sb5.toString());
                        return;
                    }
                    NativeMediaAD.this.f20089d.onADVideoLoaded((NativeMediaADData) aDEvent.getParas()[0]);
                    return;
                case 6:
                    if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        StringBuilder sb6 = new StringBuilder(str);
                        sb6.append(aDEvent);
                        sb6.append(str2);
                        GDTLogger.m25260e(sb6.toString());
                        return;
                    }
                    NativeMediaAD.this.f20089d.onADExposure((NativeMediaADData) aDEvent.getParas()[0]);
                    return;
                case 7:
                    if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        StringBuilder sb7 = new StringBuilder(str);
                        sb7.append(aDEvent);
                        sb7.append(str2);
                        GDTLogger.m25260e(sb7.toString());
                        break;
                    } else {
                        NativeMediaAD.this.f20089d.onADClicked((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    }
            }
        }
    }

    /* renamed from: com.qq.e.ads.nativ.NativeMediaAD$NativeMediaADListener */
    public interface NativeMediaADListener extends BasicADListener {
        void onADClicked(NativeMediaADData nativeMediaADData);

        void onADError(NativeMediaADData nativeMediaADData, AdError adError);

        void onADExposure(NativeMediaADData nativeMediaADData);

        void onADLoaded(List<NativeMediaADData> list);

        void onADStatusChanged(NativeMediaADData nativeMediaADData);

        void onADVideoLoaded(NativeMediaADData nativeMediaADData);
    }

    public NativeMediaAD(Context context, String str, NativeMediaADListener nativeMediaADListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            m25138a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, nativeMediaADListener);
            return;
        }
        GDTLogger.m25260e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        mo29636a((BasicADListener) nativeMediaADListener, 2003);
    }

    @Deprecated
    public NativeMediaAD(Context context, String str, String str2, NativeMediaADListener nativeMediaADListener) {
        GDTLogger.m25263w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        m25138a(context, str, str2, nativeMediaADListener);
    }

    /* renamed from: a */
    private void m25138a(Context context, String str, String str2, NativeMediaADListener nativeMediaADListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.m25260e(String.format("NativeMediaAD Contructor paras error, appid=%s, posId=%s, context=%s", new Object[]{str, str2, context}));
            mo29636a((BasicADListener) nativeMediaADListener, 2001);
            return;
        }
        this.f20089d = nativeMediaADListener;
        mo29635a(context, str, str2, (BasicADListener) nativeMediaADListener);
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ ADI mo29634a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeVideoADDelegate(context, str, str2, new ADListenerAdapter(this, 0));
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29637a(ADI adi) {
        NVADI nvadi = (NVADI) adi;
        nvadi.setMinVideoDuration(this.f20086a);
        nvadi.setMaxVideoDuration(this.f20087b);
        for (Integer intValue : this.f20088c) {
            loadAD(intValue.intValue());
        }
    }

    public void loadAD(int i) {
        if (!mo29639c()) {
            GDTLogger.m25260e("AD init Paras OR Context error, details in logs produced while init NativeMediaAD");
        } else if (!mo29638b()) {
            this.f20088c.add(Integer.valueOf(i));
        } else {
            NVADI nvadi = (NVADI) mo29633a();
            if (nvadi != null) {
                nvadi.loadAd(i);
            } else {
                GDTLogger.m25260e("NativeMediaAD Init error, See More Logs");
            }
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f20087b = i;
        if (this.f20087b > 0 && this.f20086a > this.f20087b) {
            GDTLogger.m25260e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        if (mo29638b()) {
            NVADI nvadi = (NVADI) mo29633a();
            if (nvadi != null) {
                nvadi.setMaxVideoDuration(i);
                return;
            }
            GDTLogger.m25260e("NativeMediaAD setMaxVideoDuration error, See More Logs");
        }
    }

    public void setMinVideoDuration(int i) {
        this.f20086a = i;
        if (this.f20087b > 0 && this.f20086a > this.f20087b) {
            GDTLogger.m25260e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        if (mo29638b()) {
            NVADI nvadi = (NVADI) mo29633a();
            if (nvadi != null) {
                nvadi.setMinVideoDuration(this.f20086a);
                return;
            }
            GDTLogger.m25260e("NativeMediaAD setMinVideoDuration error, See More Logs");
        }
    }
}
