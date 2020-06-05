package com.tencent.qqpim.discovery;

import android.os.Bundle;
import android.view.View;
import discoveryAD.C7852Aa;
import discoveryAD.C7855C.C7856a;
import discoveryAD.C7867L;
import discoveryAD.C7867L.C7868a;
import discoveryAD.C7903ha;
import discoveryAD.C7906ia;
import discoveryAD.C7918na;
import discoveryAD.C7931ta;
import java.io.File;
import java.util.List;

public class NativeAd implements C7479Ad, Interaction {
    /* access modifiers changed from: private */
    /* renamed from: jc */
    public List<AdDisplayModel> f25053jc;
    /* renamed from: kc */
    private AdRequestData f25054kc;
    /* access modifiers changed from: private */
    /* renamed from: lc */
    public AdListener f25055lc;
    /* access modifiers changed from: private|final */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    /* renamed from: mc */
    public C7867L f25056mc;

    public NativeAd(AdRequestData adRequestData) {
        this.f25054kc = adRequestData;
        this.f25056mc = new C7867L();
        this.f25056mc.mo38139a((C7868a) new C7868a() {
            public void onClick(AdDisplayModel adDisplayModel, Bundle bundle) {
                NativeAd.this.m32366b(adDisplayModel, bundle);
                if (NativeAd.this.f25055lc != null) {
                    NativeAd.this.f25055lc.onAdClicked(adDisplayModel);
                }
            }

            public void onDisPlay(AdDisplayModel adDisplayModel) {
                NativeAd.this.m32368d(adDisplayModel);
                if (NativeAd.this.f25055lc != null) {
                    NativeAd.this.f25055lc.onAdShow(adDisplayModel);
                }
            }
        });
    }

    /* renamed from: a */
    private void m32362a(AdRequestData adRequestData, int i) {
        DiscoverySdk.getInstance().getCacheMgr().mo38112a(adRequestData, i, (C7856a) new AbsAdCallback() {
            public void onCallback(int i, List<AdDisplayModel> list) {
                NativeAd.this.f25056mc.reset();
                synchronized (NativeAd.this.lock) {
                    NativeAd.this.f25053jc = list;
                }
                if (NativeAd.this.f25055lc == null) {
                    return;
                }
                if (C7931ta.m34347g(list)) {
                    NativeAd.this.f25055lc.onError(NativeAd.this, i);
                } else if (NativeAd.this.f25055lc instanceof ExAdListener) {
                    ((ExAdListener) NativeAd.this.f25055lc).onAdLoaded(NativeAd.this, list);
                } else {
                    NativeAd.this.f25055lc.onAdLoaded(NativeAd.this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32366b(AdDisplayModel adDisplayModel, Bundle bundle) {
        DiscoverySdk.getInstance().getCacheMgr().mo38111a(adDisplayModel, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m32368d(AdDisplayModel adDisplayModel) {
        DiscoverySdk.getInstance().getCacheMgr().mo38118c(adDisplayModel);
    }

    public static void reportAppPhase(AdDisplayModel adDisplayModel, int i, int i2) {
        DiscoverySdk.getInstance().getCacheMgr().reportAppPhase(adDisplayModel, i, i2);
    }

    public void close(boolean z, AdDisplayModel adDisplayModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("close() negativefeedback=");
        sb.append(z);
        sb.append(" model=");
        sb.append(adDisplayModel.uniqueKey);
        C7852Aa.m34153d(sb.toString());
        if (adDisplayModel != null) {
            synchronized (this.lock) {
                if (this.f25053jc != null) {
                    this.f25053jc.remove(adDisplayModel);
                }
            }
            DiscoverySdk.getInstance().getCacheMgr().mo38116a(z, adDisplayModel);
        }
        AdListener adListener = this.f25055lc;
        if (adListener != null) {
            adListener.onAdClose(adDisplayModel);
        }
    }

    public List<AdDisplayModel> getAds() {
        for (AdDisplayModel adDisplayModel : this.f25053jc) {
            DiscoverySdk.getInstance().getCacheMgr().mo38108a(adDisplayModel, DiscoverySdk.getInstance().getCacheMgr().mo38109a(adDisplayModel));
        }
        return this.f25053jc;
    }

    public String getFileSdcardPath(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C7918na.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append(C7903ha.f26900je);
        sb.append(File.separator);
        sb.append(C7906ia.m34320G(str));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getFileSdcardPath()");
        sb2.append(sb.toString());
        C7852Aa.m34153d(sb2.toString());
        return sb.toString();
    }

    public void loadAd() {
        C7852Aa.m34153d("loadAd()");
        AdRequestData adRequestData = this.f25054kc;
        try {
            adRequestData = adRequestData.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32362a(adRequestData, 0);
    }

    public void loadAd(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadAd() adnum=");
        sb.append(i);
        C7852Aa.m34153d(sb.toString());
        AdRequestData adRequestData = this.f25054kc;
        try {
            adRequestData = adRequestData.clone();
            if (i > 0) {
                adRequestData.advNum = i;
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32362a(adRequestData, 0);
    }

    public void loadAdCacheOrNormal() {
        C7852Aa.m34153d("loadAdCacheOrNormal()");
        AdRequestData adRequestData = this.f25054kc;
        try {
            adRequestData = adRequestData.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32362a(adRequestData, 4);
    }

    public void loadAdCachefirst() {
        C7852Aa.m34153d("loadAdCachefirst()");
        AdRequestData adRequestData = this.f25054kc;
        try {
            adRequestData = adRequestData.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32362a(adRequestData, 1);
    }

    public void loadRealtimeAd() {
        C7852Aa.m34153d("loadRealtimeAd()");
        AdRequestData adRequestData = this.f25054kc;
        try {
            adRequestData = adRequestData.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32362a(adRequestData, 3);
    }

    public void loadRealtimeAd(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadRealtimeAd() num=");
        sb.append(i);
        C7852Aa.m34153d(sb.toString());
        AdRequestData adRequestData = this.f25054kc;
        try {
            adRequestData = adRequestData.clone();
            if (i > 0) {
                adRequestData.advNum = i;
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32362a(adRequestData, 3);
    }

    public void loadcachedAd() {
        C7852Aa.m34153d("loadcachedAd()");
        AdRequestData adRequestData = this.f25054kc;
        try {
            adRequestData = adRequestData.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32362a(adRequestData, 2);
    }

    public void loadcachedAd(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadcachedAd() num=");
        sb.append(i);
        C7852Aa.m34153d(sb.toString());
        AdRequestData adRequestData = this.f25054kc;
        try {
            adRequestData = adRequestData.clone();
            if (i > 0) {
                adRequestData.advNum = i;
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32362a(adRequestData, 2);
    }

    public void notifyClose(boolean z, AdDisplayModel adDisplayModel) {
        close(z, adDisplayModel);
    }

    public void onSpecificScenesAdClick(AdDisplayModel adDisplayModel) {
        onSpecificScenesAdClick(adDisplayModel, null);
    }

    public void onSpecificScenesAdClick(AdDisplayModel adDisplayModel, Bundle bundle) {
        m32366b(adDisplayModel, bundle);
        AdListener adListener = this.f25055lc;
        if (adListener != null) {
            adListener.onAdClicked(adDisplayModel);
        }
    }

    public void onSpecificScenesAdDisplay(AdDisplayModel adDisplayModel) {
        onSpecificScenesAdDisplay(adDisplayModel, 0);
    }

    public void onSpecificScenesAdDisplay(AdDisplayModel adDisplayModel, long j) {
        DiscoverySdk.getInstance().getCacheMgr().mo38110a(adDisplayModel, j);
        AdListener adListener = this.f25055lc;
        if (adListener != null) {
            adListener.onAdShow(adDisplayModel);
        }
    }

    public void registerViewForInteraction(View view, AdDisplayModel adDisplayModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("registerViewForInteraction() model=");
        sb.append(adDisplayModel.uniqueKey);
        C7852Aa.m34153d(sb.toString());
        this.f25056mc.registerViewForInteraction(view, adDisplayModel, null);
    }

    public void registerViewForInteraction(View view, AdDisplayModel adDisplayModel, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append("registerViewForInteraction() has bundle! model=");
        sb.append(adDisplayModel.uniqueKey);
        C7852Aa.m34153d(sb.toString());
        this.f25056mc.registerViewForInteraction(view, adDisplayModel, bundle);
    }

    public void setAdListener(AdListener adListener) {
        this.f25055lc = adListener;
    }

    public void unregisterViewForInteraction(View view) {
        this.f25056mc.unregisterViewForInteraction(view);
    }
}
