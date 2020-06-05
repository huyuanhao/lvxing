package com.p522qq.p523e.ads.nativ;

import android.content.Context;
import com.p522qq.p523e.ads.AbstractAD;
import com.p522qq.p523e.ads.AbstractAD.BasicADListener;
import com.p522qq.p523e.comm.C6411a;
import com.p522qq.p523e.comm.adevent.ADEvent;
import com.p522qq.p523e.comm.adevent.ADListener;
import com.p522qq.p523e.comm.p525pi.ADI;
import com.p522qq.p523e.comm.p525pi.NADI;
import com.p522qq.p523e.comm.p525pi.POFactory;
import com.p522qq.p523e.comm.util.AdError;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeAD */
public class NativeAD extends AbstractAD<NADI> {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public NativeAdListener f20053a;
    /* renamed from: b */
    private List<Integer> f20054b = new ArrayList();
    /* renamed from: c */
    private List<String> f20055c;

    /* renamed from: com.qq.e.ads.nativ.NativeAD$ADListenerAdapter */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(NativeAD nativeAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (NativeAD.this.f20053a == null) {
                GDTLogger.m25262i("No DevADListener Binded");
                return;
            }
            int type = aDEvent.getType();
            String str = ")";
            if (type != 1) {
                String str2 = "ADEvent.Paras error for NativeAD(";
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeADDataRef) || !(aDEvent.getParas()[1] instanceof Integer)) {
                                StringBuilder sb = new StringBuilder(str2);
                                sb.append(aDEvent);
                                sb.append(str);
                                GDTLogger.m25260e(sb.toString());
                            } else {
                                NativeAD.this.f20053a.onADError((NativeADDataRef) aDEvent.getParas()[0], C6411a.m25175a(((Integer) aDEvent.getParas()[1]).intValue()));
                            }
                        }
                    } else if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeADDataRef)) {
                        StringBuilder sb2 = new StringBuilder(str2);
                        sb2.append(aDEvent);
                        sb2.append(str);
                        GDTLogger.m25260e(sb2.toString());
                    } else {
                        NativeAD.this.f20053a.onADStatusChanged((NativeADDataRef) aDEvent.getParas()[0]);
                    }
                } else if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof List)) {
                    StringBuilder sb3 = new StringBuilder(str2);
                    sb3.append(aDEvent);
                    sb3.append(str);
                    GDTLogger.m25260e(sb3.toString());
                } else {
                    NativeAD.this.f20053a.onADLoaded((List) aDEvent.getParas()[0]);
                }
            } else if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                StringBuilder sb4 = new StringBuilder("AdEvent.Paras error for NativeAD(");
                sb4.append(aDEvent);
                sb4.append(str);
                GDTLogger.m25260e(sb4.toString());
            } else {
                NativeAD.this.f20053a.onNoAD(C6411a.m25175a(((Integer) aDEvent.getParas()[0]).intValue()));
            }
        }
    }

    /* renamed from: com.qq.e.ads.nativ.NativeAD$NativeAdListener */
    public interface NativeAdListener extends BasicADListener {
        void onADError(NativeADDataRef nativeADDataRef, AdError adError);

        void onADLoaded(List<NativeADDataRef> list);

        void onADStatusChanged(NativeADDataRef nativeADDataRef);
    }

    public NativeAD(Context context, String str, String str2, NativeAdListener nativeAdListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.m25260e(String.format("GDTNativeAd Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, context}));
            mo29636a((BasicADListener) nativeAdListener, 2001);
            return;
        }
        this.f20053a = nativeAdListener;
        mo29635a(context, str, str2, (BasicADListener) nativeAdListener);
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ ADI mo29634a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getNativeADDelegate(context, str, str2, new ADListenerAdapter(this, 0));
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29637a(ADI adi) {
        List<String> list = this.f20055c;
        if (list != null) {
            setCategories(list);
        }
        for (Integer intValue : this.f20054b) {
            loadAD(intValue.intValue());
        }
    }

    public void loadAD(int i) {
        if (!mo29639c()) {
            GDTLogger.m25260e("AD init Paras OR Context error,details in logs produced while init NativeAD");
        } else if (!mo29638b()) {
            this.f20054b.add(Integer.valueOf(i));
        } else {
            NADI nadi = (NADI) mo29633a();
            if (nadi != null) {
                nadi.loadAd(i);
            } else {
                GDTLogger.m25260e("NativeAD Init error,See More Logs");
            }
        }
    }

    public void setCategories(List<String> list) {
        this.f20055c = list;
        NADI nadi = (NADI) mo29633a();
        if (nadi != null && list != null) {
            nadi.setCategories(list);
        }
    }
}
