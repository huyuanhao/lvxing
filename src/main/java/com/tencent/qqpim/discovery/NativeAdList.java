package com.tencent.qqpim.discovery;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
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
import java.util.ArrayList;
import java.util.List;

public class NativeAdList implements C7479Ad, Interaction {
    /* access modifiers changed from: private */
    /* renamed from: jc */
    public SparseArray<List<AdDisplayModel>> f25057jc;
    /* access modifiers changed from: private */
    /* renamed from: lc */
    public AdListener f25058lc;
    /* access modifiers changed from: private|final */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    /* renamed from: mc */
    public C7867L f25059mc;
    /* renamed from: nc */
    private List<AdRequestData> f25060nc;

    public NativeAdList(List<AdRequestData> list) {
        this.f25060nc = list;
        this.f25059mc = new C7867L();
        this.f25059mc.mo38139a((C7868a) new C7868a() {
            public void onClick(AdDisplayModel adDisplayModel, Bundle bundle) {
                NativeAdList.this.m32375b(adDisplayModel, bundle);
                if (NativeAdList.this.f25058lc != null) {
                    NativeAdList.this.f25058lc.onAdClicked(adDisplayModel);
                }
            }

            public void onDisPlay(AdDisplayModel adDisplayModel) {
                NativeAdList.this.m32378d(adDisplayModel);
                if (NativeAdList.this.f25058lc != null) {
                    NativeAdList.this.f25058lc.onAdShow(adDisplayModel);
                }
            }
        });
    }

    /* renamed from: a */
    private void m32373a(final List<AdRequestData> list, int i) {
        DiscoverySdk.getInstance().getCacheMgr().mo38114a(list, i, (C7856a) new AbsAdCallback() {
            public void onCallbacWithbundle(Bundle bundle) {
                SparseArray d;
                int i;
                ArrayList arrayList;
                NativeAdList.this.f25059mc.reset();
                if (bundle != null) {
                    synchronized (NativeAdList.this.lock) {
                        if (NativeAdList.this.f25057jc == null) {
                            NativeAdList.this.f25057jc = new SparseArray();
                        } else {
                            NativeAdList.this.f25057jc.clear();
                        }
                        for (AdRequestData adRequestData : list) {
                            ArrayList<Parcelable> parcelableArrayList = bundle.getParcelableArrayList(String.valueOf(adRequestData.positionId));
                            if (!C7931ta.m34347g(parcelableArrayList)) {
                                arrayList = new ArrayList();
                                for (Parcelable parcelable : parcelableArrayList) {
                                    AdDisplayModel adDisplayModel = (AdDisplayModel) parcelable;
                                    arrayList.add(DiscoverySdk.getInstance().getCacheMgr().mo38108a(adDisplayModel, DiscoverySdk.getInstance().getCacheMgr().mo38109a(adDisplayModel)));
                                }
                                d = NativeAdList.this.f25057jc;
                                i = adRequestData.positionId;
                            } else {
                                d = NativeAdList.this.f25057jc;
                                i = adRequestData.positionId;
                                arrayList = null;
                            }
                            d.put(i, arrayList);
                        }
                    }
                }
                if (NativeAdList.this.f25058lc != null) {
                    NativeAdList.this.f25058lc.onAdLoaded(NativeAdList.this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32375b(AdDisplayModel adDisplayModel, Bundle bundle) {
        DiscoverySdk.getInstance().getCacheMgr().mo38111a(adDisplayModel, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m32378d(AdDisplayModel adDisplayModel) {
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
                if (this.f25057jc != null) {
                    List list = (List) this.f25057jc.get(adDisplayModel.positionId);
                    if (!C7931ta.m34347g(list)) {
                        list.remove(adDisplayModel);
                    }
                }
            }
            DiscoverySdk.getInstance().getCacheMgr().mo38116a(z, adDisplayModel);
        }
        AdListener adListener = this.f25058lc;
        if (adListener != null) {
            adListener.onAdClose(adDisplayModel);
        }
    }

    public SparseArray<List<AdDisplayModel>> getAds() {
        return this.f25057jc;
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
        ArrayList arrayList = new ArrayList();
        try {
            for (AdRequestData clone : this.f25060nc) {
                arrayList.add(clone.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32373a((List<AdRequestData>) arrayList, 0);
    }

    public void loadAd(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadAd() adnum=");
        sb.append(i);
        C7852Aa.m34153d(sb.toString());
        ArrayList arrayList = new ArrayList();
        try {
            for (AdRequestData clone : this.f25060nc) {
                arrayList.add(clone.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32373a((List<AdRequestData>) arrayList, 0);
    }

    public void loadAdCacheOrNormal() {
        C7852Aa.m34153d("loadAdCacheOrNormal()");
        ArrayList arrayList = new ArrayList();
        try {
            for (AdRequestData clone : this.f25060nc) {
                arrayList.add(clone.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32373a((List<AdRequestData>) arrayList, 4);
    }

    public void loadAdCachefirst() {
        C7852Aa.m34153d("loadAdCachefirst()");
        ArrayList arrayList = new ArrayList();
        try {
            for (AdRequestData clone : this.f25060nc) {
                arrayList.add(clone.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32373a((List<AdRequestData>) arrayList, 1);
    }

    public void loadRealtimeAd() {
        C7852Aa.m34153d("loadRealtimeAd()");
        ArrayList arrayList = new ArrayList();
        try {
            for (AdRequestData clone : this.f25060nc) {
                arrayList.add(clone.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32373a((List<AdRequestData>) arrayList, 3);
    }

    public void loadcachedAd() {
        C7852Aa.m34153d("loadcachedAd()");
        ArrayList arrayList = new ArrayList();
        try {
            for (AdRequestData clone : this.f25060nc) {
                arrayList.add(clone.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        m32373a((List<AdRequestData>) arrayList, 2);
    }

    public void notifyClose(boolean z, AdDisplayModel adDisplayModel) {
        close(z, adDisplayModel);
    }

    public void onSpecificScenesAdClick(AdDisplayModel adDisplayModel) {
        onSpecificScenesAdClick(adDisplayModel, null);
    }

    public void onSpecificScenesAdClick(AdDisplayModel adDisplayModel, Bundle bundle) {
        m32375b(adDisplayModel, bundle);
        AdListener adListener = this.f25058lc;
        if (adListener != null) {
            adListener.onAdClicked(adDisplayModel);
        }
    }

    public void onSpecificScenesAdDisplay(AdDisplayModel adDisplayModel) {
        onSpecificScenesAdDisplay(adDisplayModel, 0);
    }

    public void onSpecificScenesAdDisplay(AdDisplayModel adDisplayModel, long j) {
        DiscoverySdk.getInstance().getCacheMgr().mo38110a(adDisplayModel, j);
        AdListener adListener = this.f25058lc;
        if (adListener != null) {
            adListener.onAdShow(adDisplayModel);
        }
    }

    public void registerViewForInteraction(View view, AdDisplayModel adDisplayModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("registerViewForInteraction() model=");
        sb.append(adDisplayModel.uniqueKey);
        C7852Aa.m34153d(sb.toString());
        this.f25059mc.registerViewForInteraction(view, adDisplayModel, null);
    }

    public void registerViewForInteraction(View view, AdDisplayModel adDisplayModel, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append("registerViewForInteraction() has bundle! model=");
        sb.append(adDisplayModel.uniqueKey);
        C7852Aa.m34153d(sb.toString());
        this.f25059mc.registerViewForInteraction(view, adDisplayModel, bundle);
    }

    public void setAdListener(AdListener adListener) {
        this.f25058lc = adListener;
    }

    public void unregisterViewForInteraction(View view) {
        this.f25059mc.unregisterViewForInteraction(view);
    }
}
