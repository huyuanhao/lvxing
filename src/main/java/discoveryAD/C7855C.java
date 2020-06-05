package discoveryAD;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.ADReporter.OuterReportMetaData;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdJumpInfo;
import com.tencent.qqpim.discovery.AdListener;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.DiscoverySdk;
import com.tencent.qqpim.discovery.internal.model.C7486a;
import com.tencent.qqpim.discovery.internal.model.C7487b;
import com.tencent.qqpim.discovery.internal.model.C7488c;
import com.tencent.qqpim.discovery.internal.model.C7489d;
import com.tencent.qqpim.discovery.internal.model.C7491f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* renamed from: discoveryAD.C */
public class C7855C {
    private String TAG = "CacheMgr";
    /* renamed from: dd */
    private C7892d f26730dd;
    /* access modifiers changed from: private */
    /* renamed from: ed */
    public C7888b f26731ed;
    /* access modifiers changed from: private|final */
    /* renamed from: gd */
    public final SparseArray<List<C7491f>> f26732gd;
    /* access modifiers changed from: private */
    /* renamed from: hd */
    public C7877T f26733hd;
    /* renamed from: jd */
    private final List<String> f26734jd = new ArrayList();
    /* renamed from: kd */
    private SparseBooleanArray f26735kd = new SparseBooleanArray();
    /* renamed from: ld */
    private AdListener f26736ld;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* renamed from: md */
    private Map<String, C7858c> f26737md = new HashMap(3);

    /* renamed from: discoveryAD.C$a */
    public interface C7856a {
        void onCallbacWithbundle(Bundle bundle);

        void onCallback(int i, List<AdDisplayModel> list);
    }

    /* renamed from: discoveryAD.C$b */
    public interface C7857b {
        /* renamed from: a */
        void mo38122a(List<AdRequestData> list);
    }

    /* renamed from: discoveryAD.C$c */
    class C7858c {
        /* renamed from: Wc */
        int f26738Wc;
        /* renamed from: Xc */
        long f26739Xc = 0;
        /* renamed from: Yc */
        String f26740Yc = null;
        /* renamed from: Zc */
        List<Integer> f26741Zc = new ArrayList();
        /* renamed from: _c */
        int f26742_c;
        /* renamed from: ad */
        SparseIntArray f26743ad = new SparseIntArray();
        /* renamed from: bd */
        List<C7856a> f26744bd = new ArrayList(2);
        /* renamed from: cd */
        C7857b f26745cd;

        public C7858c() {
        }
    }

    public C7855C(Context context) {
        C7852Aa.m34156i("CacheMgr()");
        this.mContext = context.getApplicationContext();
        this.f26730dd = new C7892d();
        this.f26731ed = new C7888b();
        this.f26733hd = new C7877T();
        this.f26732gd = new SparseArray<>();
        HandlerThread handlerThread = new HandlerThread(C7855C.class.getName());
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34162a(AdRequestData adRequestData) {
        StringBuilder sb = new StringBuilder();
        sb.append("readDbAds() begin");
        sb.append(adRequestData.positionId);
        C7852Aa.m34153d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("查数据库|广告位=");
        sb2.append(adRequestData.positionId);
        C7852Aa.m34156i(sb2.toString());
        List<C7486a> a = C7862G.getInstance().mo38132eb().mo38170a(adRequestData.positionId, (List<Integer>) adRequestData.positionFormatTypes);
        ArrayList arrayList = new ArrayList();
        ArrayList<C7486a> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = null;
        for (C7486a aVar : a) {
            if (!aVar.isExpired()) {
                if (aVar.mo36515kb()) {
                    arrayList.add(aVar.f25065te);
                    arrayList2.add(aVar);
                } else if (arrayList3 == null) {
                    arrayList3 = new ArrayList(5);
                }
            } else if (arrayList3 == null) {
                arrayList3 = new ArrayList(5);
            }
            arrayList3.add(aVar.f25065te);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Add data to mAdData:");
        sb3.append(adRequestData.positionId);
        C7852Aa.m34156i(sb3.toString());
        synchronized (this.f26732gd) {
            List list = (List) this.f26732gd.get(adRequestData.positionId);
            if (list == null) {
                this.f26732gd.put(adRequestData.positionId, arrayList);
            } else {
                list.addAll(arrayList);
            }
        }
        for (C7486a a2 : arrayList2) {
            this.f26731ed.mo38187a(a2);
        }
        C7852Aa.m34156i("查找广告数据库  End");
        if (!C7931ta.m34347g(arrayList3)) {
            C7862G.getInstance().mo38132eb().mo38176e((List<C7491f>) arrayList3);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("readDbAds() end");
        sb4.append(adRequestData.positionId);
        C7852Aa.m34153d(sb4.toString());
    }

    /* renamed from: a */
    private void m34163a(AdRequestData adRequestData, int i, int i2, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        StringBuilder sb = new StringBuilder();
        sb.append("featureReport() src.positionId");
        sb.append(adRequestData.positionId);
        sb.append(" src.advNum=");
        sb.append(adRequestData.advNum);
        sb.append(" detnum=");
        sb.append(i);
        sb.append(" errorcode=");
        sb.append(i2);
        sb.append(" duration=");
        sb.append(currentTimeMillis);
        C7852Aa.m34153d(sb.toString());
        C7873O instance = C7873O.getInstance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(adRequestData.positionId);
        String str = "_";
        sb2.append(str);
        sb2.append(adRequestData.advNum);
        sb2.append(str);
        sb2.append(i);
        sb2.append(str);
        sb2.append(i2);
        sb2.append(str);
        sb2.append(currentTimeMillis);
        instance.reportString(C7879V.f26795Zg, sb2.toString(), 1);
    }

    /* renamed from: a */
    private void m34164a(C7491f fVar, AdDisplayModel adDisplayModel, Bundle bundle) {
        String str = fVar.jumpUrl;
        if (str == null || !C7931ta.m34345I(str)) {
            try {
                if (new C7487b(fVar.f25083Le).mo36517lb()) {
                    DiscoverySdk.getInstance().getIH5Manager().openAppDetailPage(adDisplayModel);
                } else {
                    DiscoverySdk.getInstance().getIH5Manager().openH5(fVar.f25087Oa, false, -1, fVar.isDeepLink, bundle);
                }
            } catch (JSONException unused) {
            }
            return;
        }
        mo38113a(fVar, 10);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34170a(List<AdRequestData> list, C7858c cVar) {
        for (AdRequestData adRequestData : list) {
            if (!this.f26735kd.get(adRequestData.positionId, false)) {
                m34162a(adRequestData);
                this.f26735kd.append(adRequestData.positionId, true);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("forceUpateFlow() begin AdRequestData:");
            sb.append(adRequestData.positionId);
            C7852Aa.m34153d(sb.toString());
        }
        this.f26730dd.mo38199a(list, new C7921p(this, list, cVar));
        C7873O instance = C7873O.getInstance();
        for (AdRequestData adRequestData2 : list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(adRequestData2.positionId);
            sb2.append("_");
            sb2.append(adRequestData2.advNum);
            instance.reportString(C7879V.f26796_g, sb2.toString(), 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34171a(List<AdRequestData> list, C7858c cVar, SparseArray<List<C7486a>> sparseArray) {
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        int i2;
        int i3;
        C7858c cVar2 = cVar;
        SparseArray<List<C7486a>> sparseArray2 = sparseArray;
        C7852Aa.m34153d("retAssignedAData() begin");
        C7852Aa.m34156i("填充广告数据  Begin");
        Bundle bundle = new Bundle();
        if (sparseArray2 != null) {
            ArrayList arrayList5 = null;
            i = 2;
            arrayList = null;
            for (AdRequestData adRequestData : list) {
                List<C7486a> list2 = (List) sparseArray2.get(adRequestData.positionId);
                if (!C7931ta.m34347g(list2)) {
                    ArrayList arrayList6 = new ArrayList();
                    for (C7486a aVar : list2) {
                        if (adRequestData.mustMaterialPrepared) {
                            cVar2.f26743ad.put(adRequestData.positionId, 6);
                            if (!m34186j(aVar.f25065te)) {
                                if (arrayList5 == null) {
                                    arrayList5 = new ArrayList(5);
                                }
                                arrayList5.add(aVar.f25065te);
                            }
                        }
                        if (adRequestData.includePrepullAd || ((long) aVar.f25065te.effectiveTime) <= System.currentTimeMillis() / 1000) {
                            DiscoverySdk.getInstance();
                            if (!DiscoverySdk.isVipMode() || aVar.f25065te.f25081Je) {
                                AdDisplayModel i4 = m34184i(aVar.f25065te);
                                StringBuilder sb = new StringBuilder();
                                sb.append("填充-");
                                sb.append(aVar.f25065te.f25078Ge);
                                C7852Aa.m34156i(sb.toString());
                                arrayList6.add(i4);
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("处于VIP模式，并且数据不可在VIP下展示 data=");
                                sb2.append(aVar.toString());
                                C7852Aa.m34156i(sb2.toString());
                            }
                        }
                    }
                    arrayList3 = arrayList5;
                    arrayList4 = arrayList6;
                } else {
                    arrayList3 = arrayList5;
                    arrayList4 = null;
                }
                int i5 = cVar2.f26743ad.get(adRequestData.positionId);
                if (!C7931ta.m34347g(arrayList4)) {
                    i2 = i5;
                    i3 = 0;
                } else if (i5 == 3 || i5 == 4) {
                    i3 = i5;
                    i2 = 1;
                } else {
                    i3 = i5;
                    i2 = 2;
                }
                bundle.putParcelableArrayList(String.valueOf(adRequestData.positionId), arrayList4);
                m34163a(adRequestData, arrayList4 == null ? 0 : arrayList4.size(), i3, cVar2.f26739Xc);
                arrayList = arrayList4;
                arrayList5 = arrayList3;
                i = i2;
            }
            C7852Aa.m34156i("填充广告数据   End");
        } else {
            arrayList2 = null;
            i = 2;
            arrayList = null;
        }
        synchronized (this.f26734jd) {
            this.f26734jd.remove(cVar2.f26740Yc);
            this.f26737md.remove(cVar2.f26740Yc);
        }
        for (C7856a aVar2 : cVar2.f26744bd) {
            int size = list.size();
            aVar2.onCallbacWithbundle(bundle);
            if (size == 1) {
                aVar2.onCallback(i, arrayList);
            }
        }
        if (!C7931ta.m34347g(arrayList2)) {
            m34183h(arrayList2);
        }
        C7852Aa.m34153d("retAssignedAData() End");
        if (C7931ta.isNetworkConnected(this.mContext)) {
            this.f26733hd.mo38157gb();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34172a(List<AdRequestData> list, C7858c cVar, boolean z) {
        for (AdRequestData adRequestData : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("readCachFlow() begin AdRequestData:");
            sb.append(adRequestData.positionId);
            sb.append(" forceupdate=");
            sb.append(z);
            C7852Aa.m34153d(sb.toString());
            if (!this.f26735kd.get(adRequestData.positionId, false)) {
                m34162a(adRequestData);
                this.f26735kd.append(adRequestData.positionId, true);
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdRequestData adRequestData2 : list) {
            if (C7931ta.m34347g(this.f26731ed.mo38185I(adRequestData2.positionId)) && z) {
                if (C7895e.m34312K(adRequestData2.positionId)) {
                    arrayList.add(adRequestData2);
                } else {
                    cVar.f26743ad.put(adRequestData2.positionId, 2);
                }
            }
            arrayList2.add(adRequestData2);
        }
        if (!arrayList2.isEmpty()) {
            cVar.f26745cd.mo38122a(arrayList2);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (!C7931ta.isNetworkConnected(this.mContext)) {
            this.mHandler.postDelayed(new C7917n(this, arrayList, cVar), 1000);
        } else {
            m34170a((List<AdRequestData>) arrayList, cVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<AdRequestData> m34175b(List<AdRequestData> list, C7858c cVar) {
        for (AdRequestData adRequestData : list) {
            if (!this.f26735kd.get(adRequestData.positionId, false)) {
                m34162a(adRequestData);
                this.f26735kd.append(adRequestData.positionId, true);
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AdRequestData adRequestData2 : list) {
            if (C7931ta.m34347g(this.f26731ed.mo38185I(adRequestData2.positionId))) {
                arrayList2.add(adRequestData2);
            } else {
                arrayList.add(adRequestData2);
            }
        }
        if (!arrayList.isEmpty()) {
            cVar.f26745cd.mo38122a(arrayList);
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
            if (android.text.TextUtils.isEmpty(r9.f25087Oa) == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
            if (android.text.TextUtils.isEmpty(r9.f25087Oa) == false) goto L_0x0027;
     */
    /* renamed from: b */
    public void m34176b(com.tencent.qqpim.discovery.internal.model.C7491f r9, com.tencent.qqpim.discovery.AdDisplayModel r10, android.os.Bundle r11) {
        /*
        r8 = this;
        boolean r0 = r10.isJumpUrlEnable()
        if (r0 != 0) goto L_0x0007
        return
    L_0x0007:
        com.tencent.qqpim.discovery.AdDisplayModel r10 = r8.mo38108a(r10, r9)
        int r0 = r9.contentType
        r1 = 2
        r2 = 10
        if (r0 != r1) goto L_0x0069
        java.lang.String r0 = r9.jumpUrl
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        r1 = 1
        if (r0 == 0) goto L_0x004a
        int r0 = r9.f25084Ma
        if (r0 != r1) goto L_0x003d
        java.lang.String r0 = r9.f25087Oa
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 != 0) goto L_0x003d
    L_0x0027:
        com.tencent.qqpim.discovery.DiscoverySdk r10 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()
        com.tencent.qqpim.discovery.IH5Browser r0 = r10.getIH5Manager()
        java.lang.String r1 = discoveryAD.C7854Ba.m34160h(r9)
    L_0x0033:
        boolean r4 = r9.isDeepLink
        r2 = 0
        r3 = -1
        r5 = r11
        r0.openH5(r1, r2, r3, r4, r5)
        goto L_0x0147
    L_0x003d:
        com.tencent.qqpim.discovery.DiscoverySdk r9 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()
        com.tencent.qqpim.discovery.IH5Browser r9 = r9.getIH5Manager()
        r9.openAppDetailPage(r10)
        goto L_0x0147
    L_0x004a:
        java.lang.String r0 = r9.packageName
        boolean r0 = discoveryAD.C7931ta.m34344H(r0)
        if (r0 == 0) goto L_0x005c
        java.lang.String r10 = r9.jumpUrl
        discoveryAD.C7931ta.m34345I(r10)
    L_0x0057:
        r8.mo38113a(r9, r2)
        goto L_0x0147
    L_0x005c:
        int r0 = r9.f25084Ma
        if (r0 != r1) goto L_0x003d
        java.lang.String r0 = r9.f25087Oa
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 != 0) goto L_0x003d
        goto L_0x0027
    L_0x0069:
        r1 = 7
        if (r0 != r1) goto L_0x007d
        com.tencent.qqpim.discovery.DiscoverySdk r10 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()
        com.tencent.qqpim.discovery.IH5Browser r10 = r10.getIH5Manager()
        java.lang.String r11 = r9.packageName
        java.lang.String r9 = r9.channelId
        r10.openMiniProgram(r11, r9)
        goto L_0x0147
    L_0x007d:
        if (r0 != r2) goto L_0x010a
        java.lang.String r0 = r9.f25083Le
        java.lang.String r1 = "clickerror"
        if (r0 == 0) goto L_0x0104
        int r0 = r0.length()
        if (r0 != 0) goto L_0x008d
        goto L_0x0104
    L_0x008d:
        com.tencent.qqpim.discovery.internal.model.c r0 = new com.tencent.qqpim.discovery.internal.model.c     // Catch:{ JSONException -> 0x00ea }
        java.lang.String r3 = r9.f25083Le     // Catch:{ JSONException -> 0x00ea }
        r0.m53408init(r3)     // Catch:{ JSONException -> 0x00ea }
        boolean r3 = r0.f25067ve     // Catch:{ JSONException -> 0x00ea }
        if (r3 == 0) goto L_0x00ce
        java.lang.String r3 = r9.appDownloadUrl     // Catch:{ JSONException -> 0x00ea }
        boolean r3 = discoveryAD.C7931ta.m34345I(r3)     // Catch:{ JSONException -> 0x00ea }
        if (r3 != 0) goto L_0x00c9
        boolean r0 = r0.isApp     // Catch:{ JSONException -> 0x00ea }
        if (r0 == 0) goto L_0x00b5
        java.lang.String r9 = r9.f25087Oa     // Catch:{ JSONException -> 0x00ea }
        r10.appDownloadUrl = r9     // Catch:{ JSONException -> 0x00ea }
        com.tencent.qqpim.discovery.DiscoverySdk r9 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()     // Catch:{ JSONException -> 0x00ea }
        com.tencent.qqpim.discovery.IH5Browser r9 = r9.getIH5Manager()     // Catch:{ JSONException -> 0x00ea }
    L_0x00b0:
        r9.openAppDetailPage(r10)     // Catch:{ JSONException -> 0x00ea }
        goto L_0x0147
    L_0x00b5:
        com.tencent.qqpim.discovery.DiscoverySdk r10 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()     // Catch:{ JSONException -> 0x00ea }
        com.tencent.qqpim.discovery.IH5Browser r2 = r10.getIH5Manager()     // Catch:{ JSONException -> 0x00ea }
        java.lang.String r3 = r9.f25087Oa     // Catch:{ JSONException -> 0x00ea }
        r4 = 0
        r5 = -1
        boolean r6 = r9.isDeepLink     // Catch:{ JSONException -> 0x00ea }
    L_0x00c3:
        r7 = r11
        r2.openH5(r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x00ea }
        goto L_0x0147
    L_0x00c9:
        r8.mo38113a(r9, r2)     // Catch:{ JSONException -> 0x00ea }
        goto L_0x0147
    L_0x00ce:
        boolean r0 = r0.isApp     // Catch:{ JSONException -> 0x00ea }
        if (r0 == 0) goto L_0x00db
        com.tencent.qqpim.discovery.DiscoverySdk r9 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()     // Catch:{ JSONException -> 0x00ea }
        com.tencent.qqpim.discovery.IH5Browser r9 = r9.getIH5Manager()     // Catch:{ JSONException -> 0x00ea }
        goto L_0x00b0
    L_0x00db:
        com.tencent.qqpim.discovery.DiscoverySdk r10 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()     // Catch:{ JSONException -> 0x00ea }
        com.tencent.qqpim.discovery.IH5Browser r2 = r10.getIH5Manager()     // Catch:{ JSONException -> 0x00ea }
        java.lang.String r3 = r9.f25087Oa     // Catch:{ JSONException -> 0x00ea }
        r4 = 0
        r5 = -1
        boolean r6 = r9.isDeepLink     // Catch:{ JSONException -> 0x00ea }
        goto L_0x00c3
    L_0x00ea:
        r9 = move-exception
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        r10.<init>()
        java.lang.String r11 = "inmobi extra data json error : "
        r10.append(r11)
        java.lang.String r9 = r9.getMessage()
        r10.append(r9)
        java.lang.String r9 = r10.toString()
        com.tencent.p605ep.commonbase.api.Log.m31479e(r1, r9)
        goto L_0x0147
    L_0x0104:
        java.lang.String r9 = "inmobi extra data is empty"
        com.tencent.p605ep.commonbase.api.Log.m31479e(r1, r9)
        return
    L_0x010a:
        r1 = 11
        if (r0 != r1) goto L_0x012b
        java.lang.String r10 = r9.jumpUrl
        boolean r10 = android.text.TextUtils.isEmpty(r10)
        if (r10 == 0) goto L_0x0122
    L_0x0116:
        com.tencent.qqpim.discovery.DiscoverySdk r10 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()
        com.tencent.qqpim.discovery.IH5Browser r0 = r10.getIH5Manager()
        java.lang.String r1 = r9.f25087Oa
        goto L_0x0033
    L_0x0122:
        java.lang.String r10 = r9.jumpUrl
        boolean r10 = discoveryAD.C7931ta.m34345I(r10)
        if (r10 != 0) goto L_0x0057
        goto L_0x0116
    L_0x012b:
        r1 = 12
        if (r0 != r1) goto L_0x0133
        r8.m34164a(r9, r10, r11)
        goto L_0x0147
    L_0x0133:
        java.lang.String r10 = r9.jumpUrl
        boolean r10 = android.text.TextUtils.isEmpty(r10)
        if (r10 != 0) goto L_0x0147
        com.tencent.qqpim.discovery.DiscoverySdk r10 = com.tencent.qqpim.discovery.DiscoverySdk.getInstance()
        com.tencent.qqpim.discovery.IH5Browser r0 = r10.getIH5Manager()
        java.lang.String r1 = r9.jumpUrl
        goto L_0x0033
    L_0x0147:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7855C.m34176b(com.tencent.qqpim.discovery.internal.model.f, com.tencent.qqpim.discovery.AdDisplayModel, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c4, code lost:
            r1 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r1.append("处于VIP模式，并且数据不可在VIP下展示 data=");
            r1.append(r14.toString());
            discoveryAD.C7852Aa.m34156i(r1.toString());
     */
    /* renamed from: c */
    public void m34180c(java.util.List<com.tencent.qqpim.discovery.AdRequestData> r22, discoveryAD.C7855C.C7858c r23) {
        /*
        r21 = this;
        r7 = r21
        r0 = r23
        java.lang.String r1 = "retValideAData() (listrequest) begin"
        discoveryAD.C7852Aa.m34153d(r1)
        java.lang.String r1 = "填充广告数据  Begin"
        discoveryAD.C7852Aa.m34156i(r1)
        android.os.Bundle r8 = new android.os.Bundle
        r8.<init>()
        java.util.Iterator r9 = r22.iterator()
        r1 = 0
        r2 = r1
        r3 = 2
    L_0x001a:
        boolean r4 = r9.hasNext()
        if (r4 == 0) goto L_0x0162
        java.lang.Object r1 = r9.next()
        r3 = r1
        com.tencent.qqpim.discovery.AdRequestData r3 = (com.tencent.qqpim.discovery.AdRequestData) r3
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r4 = "填充  广告位:"
        r1.append(r4)
        int r4 = r3.positionId
        r1.append(r4)
        java.lang.String r1 = r1.toString()
        discoveryAD.C7852Aa.m34156i(r1)
        discoveryAD.b r1 = r7.f26731ed
        int r4 = r3.positionId
        java.util.List r1 = r1.mo38185I(r4)
        android.util.SparseArray<java.util.List<com.tencent.qqpim.discovery.internal.model.f>> r4 = r7.f26732gd
        monitor-enter(r4)
        android.util.SparseArray<java.util.List<com.tencent.qqpim.discovery.internal.model.f>> r6 = r7.f26732gd     // Catch:{ all -> 0x015f }
        int r11 = r3.positionId     // Catch:{ all -> 0x015f }
        java.lang.Object r6 = r6.get(r11)     // Catch:{ all -> 0x015f }
        java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x015f }
        java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x015f }
        r11.<init>()     // Catch:{ all -> 0x015f }
        java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x015f }
        r12 = r2
    L_0x005c:
        boolean r2 = r1.hasNext()     // Catch:{ all -> 0x015f }
        if (r2 == 0) goto L_0x0120
        java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x015f }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x015f }
        java.util.Iterator r13 = r6.iterator()     // Catch:{ all -> 0x015f }
    L_0x006c:
        boolean r14 = r13.hasNext()     // Catch:{ all -> 0x015f }
        if (r14 == 0) goto L_0x011c
        java.lang.Object r14 = r13.next()     // Catch:{ all -> 0x015f }
        com.tencent.qqpim.discovery.internal.model.f r14 = (com.tencent.qqpim.discovery.internal.model.C7491f) r14     // Catch:{ all -> 0x015f }
        java.lang.String r15 = r14.f25078Ge     // Catch:{ all -> 0x015f }
        boolean r15 = r15.equals(r2)     // Catch:{ all -> 0x015f }
        if (r15 == 0) goto L_0x006c
        boolean r15 = r3.mustMaterialPrepared     // Catch:{ all -> 0x015f }
        if (r15 == 0) goto L_0x009e
        android.util.SparseIntArray r15 = r0.f26743ad     // Catch:{ all -> 0x015f }
        int r10 = r3.positionId     // Catch:{ all -> 0x015f }
        r5 = 6
        r15.put(r10, r5)     // Catch:{ all -> 0x015f }
        boolean r5 = r7.m34186j(r14)     // Catch:{ all -> 0x015f }
        if (r5 != 0) goto L_0x009e
        if (r12 != 0) goto L_0x009a
        java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x015f }
        r2 = 5
        r12.<init>(r2)     // Catch:{ all -> 0x015f }
    L_0x009a:
        r12.add(r14)     // Catch:{ all -> 0x015f }
        goto L_0x005c
    L_0x009e:
        boolean r5 = r3.includePrepullAd     // Catch:{ all -> 0x015f }
        if (r5 != 0) goto L_0x00b5
        int r5 = r14.effectiveTime     // Catch:{ all -> 0x015f }
        r10 = r1
        r15 = r2
        long r1 = (long) r5     // Catch:{ all -> 0x015f }
        long r17 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015f }
        r19 = 1000(0x3e8, double:4.94E-321)
        long r17 = r17 / r19
        int r5 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
        if (r5 <= 0) goto L_0x00b7
        goto L_0x011d
    L_0x00b5:
        r10 = r1
        r15 = r2
    L_0x00b7:
        com.tencent.qqpim.discovery.DiscoverySdk.getInstance()     // Catch:{ all -> 0x015f }
        boolean r1 = com.tencent.qqpim.discovery.DiscoverySdk.isVipMode()     // Catch:{ all -> 0x015f }
        if (r1 == 0) goto L_0x00dd
        boolean r1 = r14.f25081Je     // Catch:{ all -> 0x015f }
        if (r1 != 0) goto L_0x00dd
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x015f }
        r1.<init>()     // Catch:{ all -> 0x015f }
        java.lang.String r2 = "处于VIP模式，并且数据不可在VIP下展示 data="
        r1.append(r2)     // Catch:{ all -> 0x015f }
        java.lang.String r2 = r14.toString()     // Catch:{ all -> 0x015f }
        r1.append(r2)     // Catch:{ all -> 0x015f }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x015f }
        discoveryAD.C7852Aa.m34156i(r1)     // Catch:{ all -> 0x015f }
        goto L_0x011d
    L_0x00dd:
        java.util.ArrayList<java.lang.Integer> r1 = r3.positionFormatTypes     // Catch:{ all -> 0x015f }
        if (r1 == 0) goto L_0x00fc
        java.util.ArrayList<java.lang.Integer> r1 = r3.positionFormatTypes     // Catch:{ all -> 0x015f }
        boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x015f }
        if (r1 != 0) goto L_0x00fc
        java.util.ArrayList<java.lang.Integer> r1 = r3.positionFormatTypes     // Catch:{ all -> 0x015f }
        int r2 = r14.templateType     // Catch:{ all -> 0x015f }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x015f }
        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x015f }
        if (r1 == 0) goto L_0x00f8
        goto L_0x00fc
    L_0x00f8:
        r1 = r10
        r2 = r15
        goto L_0x006c
    L_0x00fc:
        com.tencent.qqpim.discovery.AdDisplayModel r1 = r7.m34184i(r14)     // Catch:{ all -> 0x015f }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015f }
        r2.<init>()     // Catch:{ all -> 0x015f }
        java.lang.String r5 = "填充-"
        r2.append(r5)     // Catch:{ all -> 0x015f }
        java.lang.String r5 = r14.f25078Ge     // Catch:{ all -> 0x015f }
        r2.append(r5)     // Catch:{ all -> 0x015f }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x015f }
        discoveryAD.C7852Aa.m34156i(r2)     // Catch:{ all -> 0x015f }
        if (r1 == 0) goto L_0x00f8
        r11.add(r1)     // Catch:{ all -> 0x015f }
        goto L_0x011d
    L_0x011c:
        r10 = r1
    L_0x011d:
        r1 = r10
        goto L_0x005c
    L_0x0120:
        monitor-exit(r4)     // Catch:{ all -> 0x015f }
        android.util.SparseIntArray r1 = r0.f26743ad
        int r2 = r3.positionId
        int r1 = r1.get(r2)
        boolean r2 = discoveryAD.C7931ta.m34347g(r11)
        if (r2 == 0) goto L_0x013e
        r2 = 3
        if (r1 == r2) goto L_0x013a
        r2 = 4
        if (r1 != r2) goto L_0x0136
        goto L_0x013a
    L_0x0136:
        r4 = r1
        r16 = 2
        goto L_0x0142
    L_0x013a:
        r4 = r1
        r16 = 1
        goto L_0x0142
    L_0x013e:
        r2 = 0
        r16 = r1
        r4 = 0
    L_0x0142:
        int r1 = r3.positionId
        java.lang.String r1 = java.lang.String.valueOf(r1)
        r8.putParcelableArrayList(r1, r11)
        int r5 = r11.size()
        long r13 = r0.f26739Xc
        r1 = r21
        r2 = r3
        r3 = r5
        r5 = r13
        r1.m34163a(r2, r3, r4, r5)
        r1 = r11
        r2 = r12
        r3 = r16
        goto L_0x001a
    L_0x015f:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x015f }
        throw r0
    L_0x0162:
        java.util.List<java.lang.String> r4 = r7.f26734jd
        monitor-enter(r4)
        java.util.List<java.lang.String> r5 = r7.f26734jd     // Catch:{ all -> 0x01b0 }
        java.lang.String r6 = r0.f26740Yc     // Catch:{ all -> 0x01b0 }
        r5.remove(r6)     // Catch:{ all -> 0x01b0 }
        java.util.Map<java.lang.String, discoveryAD.C$c> r5 = r7.f26737md     // Catch:{ all -> 0x01b0 }
        java.lang.String r6 = r0.f26740Yc     // Catch:{ all -> 0x01b0 }
        r5.remove(r6)     // Catch:{ all -> 0x01b0 }
        monitor-exit(r4)     // Catch:{ all -> 0x01b0 }
        java.util.List<discoveryAD.C$a> r0 = r0.f26744bd
        java.util.Iterator r0 = r0.iterator()
    L_0x017a:
        boolean r4 = r0.hasNext()
        if (r4 == 0) goto L_0x0194
        java.lang.Object r4 = r0.next()
        discoveryAD.C$a r4 = (discoveryAD.C7855C.C7856a) r4
        int r5 = r22.size()
        r6 = 1
        r4.onCallbacWithbundle(r8)
        if (r5 != r6) goto L_0x017a
        r4.onCallback(r3, r1)
        goto L_0x017a
    L_0x0194:
        boolean r0 = discoveryAD.C7931ta.m34347g(r2)
        if (r0 != 0) goto L_0x019d
        r7.m34183h(r2)
    L_0x019d:
        android.content.Context r0 = r7.mContext
        boolean r0 = discoveryAD.C7931ta.isNetworkConnected(r0)
        if (r0 == 0) goto L_0x01aa
        discoveryAD.T r0 = r7.f26733hd
        r0.mo38157gb()
    L_0x01aa:
        java.lang.String r0 = "retValideAData() (listrequest) End"
        discoveryAD.C7852Aa.m34153d(r0)
        return
    L_0x01b0:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x01b0 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7855C.m34180c(java.util.List, discoveryAD.C$c):void");
    }

    /* renamed from: h */
    private void m34183h(List<C7491f> list) {
        String str;
        if (!C7931ta.m34347g(list)) {
            StringBuilder sb = new StringBuilder();
            sb.append(C7918na.getExternalStorageDirectory().getAbsolutePath());
            sb.append(File.separator);
            sb.append(C7903ha.f26900je);
            for (C7491f fVar : list) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("autoloadPic() model=");
                sb2.append(fVar.uniqueKey);
                C7852Aa.m34156i(sb2.toString());
                String str2 = fVar.imageUrl1;
                String str3 = "ck=";
                if (str2 != null && !str2.isEmpty()) {
                    C7903ha instance = C7903ha.getInstance();
                    String sb3 = sb.toString();
                    String G = C7906ia.m34320G(fVar.imageUrl1);
                    String str4 = fVar.imageUrl1;
                    instance.mo38214b(sb3, G, str4, C7931ta.m34346g(str4, str3), false, null);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("imageUrl1_md5=");
                    sb4.append(C7931ta.m34346g(fVar.imageUrl1, str3));
                    C7852Aa.m34156i(sb4.toString());
                }
                String str5 = fVar.imageUrl2;
                if (str5 != null && !str5.isEmpty()) {
                    C7903ha instance2 = C7903ha.getInstance();
                    String sb5 = sb.toString();
                    String G2 = C7906ia.m34320G(fVar.imageUrl2);
                    String str6 = fVar.imageUrl2;
                    instance2.mo38214b(sb5, G2, str6, C7931ta.m34346g(str6, str3), false, null);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("imageUrl2_md5=");
                    sb6.append(C7931ta.m34346g(fVar.imageUrl2, str3));
                    C7852Aa.m34156i(sb6.toString());
                }
                String str7 = fVar.imageUrl3;
                if (str7 != null && !str7.isEmpty()) {
                    C7903ha instance3 = C7903ha.getInstance();
                    String sb7 = sb.toString();
                    String G3 = C7906ia.m34320G(fVar.imageUrl3);
                    String str8 = fVar.imageUrl3;
                    instance3.mo38214b(sb7, G3, str8, C7931ta.m34346g(str8, str3), false, null);
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("imageUrl3_md5=");
                    sb8.append(C7931ta.m34346g(fVar.imageUrl3, str3));
                    C7852Aa.m34156i(sb8.toString());
                }
                if (C7914la.isWifiActive()) {
                    String str9 = fVar.videoUrl;
                    if (str9 != null && !str9.isEmpty()) {
                        C7903ha instance4 = C7903ha.getInstance();
                        String sb9 = sb.toString();
                        String G4 = C7906ia.m34320G(fVar.videoUrl);
                        String str10 = fVar.videoUrl;
                        instance4.mo38214b(sb9, G4, str10, C7931ta.m34346g(str10, str3), false, null);
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("videoUrl_md5=");
                        sb10.append(C7931ta.m34346g(fVar.videoUrl, str3));
                        C7852Aa.m34156i(sb10.toString());
                    }
                    String str11 = fVar.zipUrl;
                    if (str11 != null && !str11.isEmpty()) {
                        C7903ha instance5 = C7903ha.getInstance();
                        String sb11 = sb.toString();
                        String G5 = C7906ia.m34320G(fVar.zipUrl);
                        String str12 = fVar.zipUrl;
                        instance5.mo38214b(sb11, G5, str12, C7931ta.m34346g(str12, str3), false, null);
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append("zipUrl_md5=");
                        sb12.append(C7931ta.m34346g(fVar.zipUrl, str3));
                        str = sb12.toString();
                    }
                } else {
                    str = "无可用WiFi!!";
                }
                C7852Aa.m34156i(str);
            }
        }
    }

    /* renamed from: i */
    private AdDisplayModel m34184i(C7491f fVar) {
        AdDisplayModel adDisplayModel = new AdDisplayModel();
        adDisplayModel.sdkADRequest = fVar.sdkADRequest;
        adDisplayModel.sdkType = fVar.sdkType;
        adDisplayModel.sdkParamappid = fVar.sdkParamappid;
        adDisplayModel.sdkPosId = fVar.sdkPosId;
        adDisplayModel.sdkgdtPosAmount = fVar.sdkgdtPosAmount;
        adDisplayModel.sdkgdtrequestTimeout = fVar.sdkgdtrequestTimeout;
        adDisplayModel.uniqueKey = fVar.uniqueKey;
        adDisplayModel.positionId = fVar.positionId;
        adDisplayModel.isneedGuide = fVar.isneedGuide;
        adDisplayModel.percentSpent = fVar.percentSpent;
        adDisplayModel.notifyInterval = fVar.notifyInterval;
        adDisplayModel.notifyContent = fVar.notifyContent;
        adDisplayModel.templateType = fVar.templateType;
        adDisplayModel.text1 = fVar.text1;
        adDisplayModel.text2 = fVar.text2;
        adDisplayModel.text3 = fVar.text3;
        if (fVar.contentType == 2 && !TextUtils.isEmpty(fVar.packageName) && C7931ta.m34344H(fVar.packageName)) {
            adDisplayModel.text3 = "打开";
        }
        adDisplayModel.text4 = fVar.text4;
        String str = fVar.imageUrl1;
        adDisplayModel.imageUrl1 = str;
        adDisplayModel.imageUrl2 = fVar.imageUrl2;
        adDisplayModel.imageUrl3 = fVar.imageUrl3;
        adDisplayModel.videoUrl = fVar.videoUrl;
        adDisplayModel.zipUrl = fVar.zipUrl;
        adDisplayModel.effectiveTime = fVar.effectiveTime;
        adDisplayModel.continuousExposureTime = fVar.continuousExposureTime;
        adDisplayModel.exposureInterval = fVar.exposureInterval;
        adDisplayModel.scenes = fVar.scenes;
        adDisplayModel.predisplaytime = fVar.predisplaytime;
        String str2 = "ck=";
        if (str != null && !str.isEmpty()) {
            adDisplayModel.imgMd5 = C7931ta.m34346g(fVar.imageUrl1, str2);
        }
        String str3 = fVar.videoUrl;
        if (str3 != null && !str3.isEmpty()) {
            adDisplayModel.videoMd5 = C7931ta.m34346g(fVar.videoUrl, str2);
        }
        String str4 = fVar.zipUrl;
        if (str4 != null && !str4.isEmpty()) {
            adDisplayModel.zipMd5 = C7931ta.m34346g(fVar.zipUrl, str2);
        }
        adDisplayModel.packageName = fVar.packageName;
        adDisplayModel.jumpUrl = fVar.jumpUrl;
        adDisplayModel.isAutoAppDownload = fVar.isAutoAppDownload;
        adDisplayModel.appDownloadUrl = fVar.appDownloadUrl;
        adDisplayModel.isDeepLink = fVar.isDeepLink;
        adDisplayModel.channelId = fVar.channelId;
        adDisplayModel.imgList = fVar.imgList;
        return adDisplayModel;
    }

    /* renamed from: i */
    private String m34185i(List<AdRequestData> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AdRequestData adRequestData = (AdRequestData) list.get(i);
            C7852Aa.m34153d(adRequestData.toString());
            sb.append(adRequestData.positionId);
            if (i != size - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }

    /* renamed from: j */
    private boolean m34186j(C7491f fVar) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append(C7918na.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append(C7903ha.f26900je);
        String str = fVar.imageUrl1;
        String str2 = "prepared";
        String str3 = "preparing";
        String str4 = " is ";
        if (str == null || str.isEmpty()) {
            z = true;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(sb.toString());
            sb2.append(File.separator);
            sb2.append(C7906ia.m34320G(fVar.imageUrl1).toString());
            z = new File(sb2.toString()).exists();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("imageUrl1:");
            sb3.append(C7906ia.m34320G(fVar.imageUrl1));
            sb3.append(str4);
            sb3.append(z ? str2 : str3);
            C7852Aa.m34156i(sb3.toString());
        }
        String str5 = fVar.imageUrl2;
        if (str5 != null && !str5.isEmpty()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb.toString());
            sb4.append(File.separator);
            sb4.append(C7906ia.m34320G(fVar.imageUrl2).toString());
            if (!new File(sb4.toString()).exists()) {
                z = false;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("imageUrl2:");
            sb5.append(C7906ia.m34320G(fVar.imageUrl2));
            sb5.append(str4);
            sb5.append(z ? str2 : str3);
            C7852Aa.m34156i(sb5.toString());
        }
        String str6 = fVar.imageUrl3;
        if (str6 != null && !str6.isEmpty()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(sb.toString());
            sb6.append(File.separator);
            sb6.append(C7906ia.m34320G(fVar.imageUrl3).toString());
            if (!new File(sb6.toString()).exists()) {
                z = false;
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append("imageUrl3:");
            sb7.append(C7906ia.m34320G(fVar.imageUrl3));
            sb7.append(str4);
            sb7.append(z ? str2 : str3);
            C7852Aa.m34156i(sb7.toString());
        }
        String str7 = fVar.videoUrl;
        if (str7 != null && !str7.isEmpty()) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(sb.toString());
            sb8.append(File.separator);
            sb8.append(C7906ia.m34320G(fVar.videoUrl).toString());
            if (!new File(sb8.toString()).exists()) {
                z = false;
            }
            StringBuilder sb9 = new StringBuilder();
            sb9.append("videoUrl:");
            sb9.append(C7906ia.m34320G(fVar.videoUrl));
            sb9.append(str4);
            sb9.append(z ? str2 : str3);
            C7852Aa.m34156i(sb9.toString());
        }
        String str8 = fVar.zipUrl;
        if (str8 != null && !str8.isEmpty()) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(sb.toString());
            sb10.append(File.separator);
            sb10.append(C7906ia.m34320G(fVar.zipUrl).toString());
            if (!new File(sb10.toString()).exists()) {
                z = false;
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append("zipUrl:");
            sb11.append(C7906ia.m34320G(fVar.zipUrl));
            sb11.append(str4);
            if (!z) {
                str2 = str3;
            }
            sb11.append(str2);
            C7852Aa.m34156i(sb11.toString());
        }
        StringBuilder sb12 = new StringBuilder();
        sb12.append("isMaterialPrepared() model=");
        sb12.append(fVar.uniqueKey);
        sb12.append(str4);
        sb12.append(z);
        C7852Aa.m34156i(sb12.toString());
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m34187k(C7491f fVar) {
        int i = 0;
        if (fVar.sdkADRequest) {
            return false;
        }
        if (fVar.f25098rc < ((int) (System.currentTimeMillis() / 1000))) {
            StringBuilder sb = new StringBuilder();
            sb.append(fVar.f25078Ge);
            sb.append(" 广告时间过期,请调整手机本地时间为北京时间！！！");
            C7852Aa.m34152N(sb.toString());
            return false;
        }
        synchronized (this.f26732gd) {
            List list = (List) this.f26732gd.get(fVar.positionId);
            if (list == null) {
                list = new ArrayList(2);
                this.f26732gd.put(fVar.positionId, list);
            }
            while (i < list.size()) {
                if (fVar.uniqueKey.equals(((C7491f) list.get(i)).uniqueKey)) {
                    list.remove(i);
                } else {
                    i++;
                }
            }
            list.add(fVar);
        }
        return true;
    }

    /* renamed from: a */
    public AdDisplayModel mo38108a(AdDisplayModel adDisplayModel, C7491f fVar) {
        String str;
        AdJumpInfo adJumpInfo;
        String str2;
        if (fVar == null) {
            return adDisplayModel;
        }
        OuterReportMetaData outerReportMetaData = adDisplayModel.reportMetaData;
        outerReportMetaData.context = fVar.context;
        outerReportMetaData.positionId = adDisplayModel.positionId;
        outerReportMetaData.uniqueKey = adDisplayModel.uniqueKey;
        outerReportMetaData.finishDownLoadtrackurls = C7489d.m32383n(fVar.f25089Pe);
        adDisplayModel.reportMetaData.startDownLoadtrackurls = C7489d.m32382m(fVar.f25088Oe);
        adDisplayModel.reportMetaData.installtrackurls = C7489d.m32384o(fVar.f25096We);
        adDisplayModel.reportMetaData.clicktrackurls = fVar.f25086Ne;
        int i = fVar.contentType;
        if (i == 2) {
            if (!TextUtils.isEmpty(fVar.jumpUrl)) {
                AdJumpInfo adJumpInfo2 = adDisplayModel.mAdJumpInfo;
                adJumpInfo2.deeplink = true;
                adJumpInfo2.deeplinkSchame = fVar.jumpUrl;
            }
            if (fVar.f25084Ma != 1 || TextUtils.isEmpty(fVar.f25087Oa)) {
                if (!TextUtils.isEmpty(fVar.appDownloadUrl)) {
                    adDisplayModel.mAdJumpInfo.isApp = true;
                }
                adJumpInfo = adDisplayModel.mAdJumpInfo;
                adJumpInfo.downloadUrl = adDisplayModel.appDownloadUrl;
                str = fVar.f25087Oa;
            } else {
                adJumpInfo = adDisplayModel.mAdJumpInfo;
                str = C7854Ba.m34160h(fVar);
            }
        } else {
            if (i == 10) {
                String str3 = fVar.f25083Le;
                String str4 = "clickerror";
                if (str3 == null || str3.length() == 0) {
                    str2 = "inmobi extra data is empty";
                } else {
                    try {
                        C7488c cVar = new C7488c(fVar.f25083Le);
                        adDisplayModel.mAdJumpInfo.deeplink = cVar.f25067ve;
                        adDisplayModel.mAdJumpInfo.isApp = cVar.isApp;
                        if (cVar.f25067ve) {
                            adDisplayModel.mAdJumpInfo.deeplinkSchame = fVar.appDownloadUrl;
                        }
                        if (cVar.isApp) {
                            adDisplayModel.mAdJumpInfo.downloadUrl = fVar.f25087Oa;
                        }
                        adDisplayModel.mAdJumpInfo.h5Url = fVar.f25087Oa;
                    } catch (JSONException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("inmobi extra data json error : ");
                        sb.append(e.getMessage());
                        str2 = sb.toString();
                    }
                }
                Log.m31479e(str4, str2);
            } else if (i == 11) {
                adDisplayModel.mAdJumpInfo.h5Url = fVar.f25087Oa;
                if (!TextUtils.isEmpty(fVar.jumpUrl)) {
                    AdJumpInfo adJumpInfo3 = adDisplayModel.mAdJumpInfo;
                    adJumpInfo3.deeplink = true;
                    adJumpInfo3.deeplinkSchame = fVar.jumpUrl;
                }
            } else if (i == 12) {
                if (!TextUtils.isEmpty(fVar.jumpUrl)) {
                    AdJumpInfo adJumpInfo4 = adDisplayModel.mAdJumpInfo;
                    adJumpInfo4.deeplink = true;
                    adJumpInfo4.deeplinkSchame = fVar.jumpUrl;
                }
                try {
                    if (new C7487b(fVar.f25083Le).mo36517lb()) {
                        adDisplayModel.mAdJumpInfo.downloadUrl = adDisplayModel.appDownloadUrl;
                        adDisplayModel.mAdJumpInfo.isApp = true;
                    }
                    adDisplayModel.mAdJumpInfo.h5Url = fVar.f25087Oa;
                } catch (JSONException unused) {
                }
            } else {
                adJumpInfo = adDisplayModel.mAdJumpInfo;
                str = fVar.jumpUrl;
            }
            return adDisplayModel;
        }
        adJumpInfo.h5Url = str;
        return adDisplayModel;
    }

    /* renamed from: a */
    public C7491f mo38109a(AdDisplayModel adDisplayModel) {
        C7491f fVar;
        String str = null;
        if (adDisplayModel == null) {
            return null;
        }
        List list = (List) this.f26732gd.get(adDisplayModel.positionId);
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                fVar = (C7491f) it.next();
                if (fVar.uniqueKey.equals(adDisplayModel.uniqueKey)) {
                    break;
                }
            }
        }
        fVar = null;
        StringBuilder sb = new StringBuilder();
        sb.append("findUnifiedAdData() ");
        if (fVar != null) {
            str = fVar.f25078Ge;
        }
        sb.append(str);
        C7852Aa.m34153d(sb.toString());
        if (fVar != null) {
            fVar.f25097Xe = adDisplayModel.cModel;
        }
        return fVar;
    }

    /* renamed from: a */
    public void mo38110a(AdDisplayModel adDisplayModel, long j) {
        C7491f a = mo38109a(adDisplayModel);
        if (a == null) {
            if (!this.f26735kd.get(adDisplayModel.positionId, false)) {
                this.mHandler.post(new C7926r(this, adDisplayModel, j));
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onShowAd() UnifiedAdData:");
        sb.append(a);
        C7852Aa.m34153d(sb.toString());
        C7885a c = this.f26731ed.mo38190c(a);
        a.predisplaytime = c.f26821xc;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onShowAd() UnifiedAdData PreDisplaytime:");
        sb2.append(a.predisplaytime);
        C7852Aa.m34153d(sb2.toString());
        Handler handler = this.mHandler;
        C7932u uVar = new C7932u(this, c, a, j);
        handler.post(uVar);
        AdListener adListener = this.f26736ld;
        if (adListener != null) {
            adListener.onAdShow(adDisplayModel);
        }
    }

    /* renamed from: a */
    public void mo38111a(AdDisplayModel adDisplayModel, Bundle bundle) {
        C7491f a = mo38109a(adDisplayModel);
        if (a == null) {
            if (!this.f26735kd.get(adDisplayModel.positionId, false)) {
                this.mHandler.post(new C7938x(this, adDisplayModel, bundle));
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onClickAd() UnifiedAdData:");
        sb.append(a);
        C7852Aa.m34153d(sb.toString());
        C7885a b = this.f26731ed.mo38188b(a);
        Handler handler = this.mHandler;
        C7940y yVar = new C7940y(this, a, adDisplayModel, bundle, b);
        handler.post(yVar);
        AdListener adListener = this.f26736ld;
        if (adListener != null) {
            adListener.onAdClicked(adDisplayModel);
        }
    }

    /* renamed from: a */
    public void mo38112a(AdRequestData adRequestData, int i, C7856a aVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(adRequestData);
        mo38114a((List<AdRequestData>) arrayList, i, aVar);
    }

    /* renamed from: a */
    public void mo38113a(C7491f fVar, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("reportAppPhase() UnifiedAdData:");
        sb.append(fVar);
        sb.append(" phase=");
        sb.append(i);
        C7852Aa.m34153d(sb.toString());
        C7885a aVar = i == 5 ? this.f26731ed.mo38194f(fVar) : i == 6 ? this.f26731ed.mo38192d(fVar) : i == 10 ? this.f26731ed.mo38186a(fVar) : null;
        this.mHandler.post(new C7930t(this, aVar, fVar, i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
            r11 = (discoveryAD.C7855C.C7858c) r8.f26737md.get(r0);
            r11.f26739Xc = r3;
            r11.f26738Wc = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
            if (r10 != 2) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
            r10 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
            if (r10.hasNext() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
            r0 = (com.tencent.qqpim.discovery.AdRequestData) r10.next();
            r11.f26743ad.put(r0.positionId, 1);
            r11.f26741Zc.add(java.lang.Integer.valueOf(r0.positionId));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
            r11.f26745cd = new discoveryAD.C7942z(r8, r11, r9);
            r8.mHandler.post(new discoveryAD.C7851A(r8, r9, r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ac, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b1, code lost:
            if (r10 != 3) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b3, code lost:
            r10 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bb, code lost:
            if (r10.hasNext() == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
            r11.f26743ad.put(((com.tencent.qqpim.discovery.AdRequestData) r10.next()).positionId, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d1, code lost:
            if (discoveryAD.C7931ta.isNetworkConnected(r8.mContext) != false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d3, code lost:
            r8.mHandler.postDelayed(new discoveryAD.C7853B(r8, r9, r11), 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00de, code lost:
            r8.mHandler.post(new discoveryAD.C7900g(r8, r9, r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e8, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e9, code lost:
            if (r10 != 0) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00eb, code lost:
            r10 = new java.util.ArrayList();
            r0 = new java.util.ArrayList();
            r2 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fd, code lost:
            if (r2.hasNext() == false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ff, code lost:
            r5 = (com.tencent.qqpim.discovery.AdRequestData) r2.next();
            r11.f26743ad.put(r5.positionId, 0);
            r11.f26741Zc.add(java.lang.Integer.valueOf(r5.positionId));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011d, code lost:
            if (discoveryAD.C7895e.m34311J(r5.positionId) == false) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011f, code lost:
            r10.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0123, code lost:
            r0.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0127, code lost:
            r11.f26745cd = new discoveryAD.C7902h(r8, r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0132, code lost:
            if (r10.isEmpty() != false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013a, code lost:
            if (discoveryAD.C7931ta.isNetworkConnected(r8.mContext) != false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x013c, code lost:
            r8.mHandler.postDelayed(new discoveryAD.C7905i(r8, r10, r11), 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0147, code lost:
            r8.mHandler.post(new discoveryAD.C7907j(r8, r10, r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0155, code lost:
            if (r0.isEmpty() != false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0157, code lost:
            r8.mHandler.post(new discoveryAD.C7910k(r8, r0, r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0161, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0162, code lost:
            if (r10 == 1) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0165, code lost:
            if (r10 != 4) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0167, code lost:
            r0 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016f, code lost:
            if (r0.hasNext() == false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0171, code lost:
            r2 = (com.tencent.qqpim.discovery.AdRequestData) r0.next();
            r11.f26743ad.put(r2.positionId, 0);
            r11.f26741Zc.add(java.lang.Integer.valueOf(r2.positionId));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x018a, code lost:
            r11.f26745cd = new discoveryAD.C7913l(r8, r11, r9);
            r8.mHandler.post(new discoveryAD.C7915m(r8, r9, r11, r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x019b, code lost:
            return;
     */
    /* renamed from: a */
    public void mo38114a(java.util.List<com.tencent.qqpim.discovery.AdRequestData> r9, int r10, discoveryAD.C7855C.C7856a r11) {
        /*
        r8 = this;
        boolean r0 = com.tencent.qqpim.discovery.DiscoverySdk.sForbidAd
        r1 = 2
        r2 = 1
        if (r0 == 0) goto L_0x001b
        if (r11 == 0) goto L_0x001a
        android.os.Bundle r10 = new android.os.Bundle
        r10.<init>()
        int r9 = r9.size()
        r11.onCallbacWithbundle(r10)
        if (r9 != r2) goto L_0x001a
        r9 = 0
        r11.onCallback(r1, r9)
    L_0x001a:
        return
    L_0x001b:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r3 = "getAds() begin reqmode="
        r0.append(r3)
        r0.append(r10)
        java.lang.String r0 = r0.toString()
        discoveryAD.C7852Aa.m34153d(r0)
        long r3 = java.lang.System.currentTimeMillis()
        java.lang.String r0 = r8.m34185i(r9)
        java.util.List<java.lang.String> r5 = r8.f26734jd
        monitor-enter(r5)
        java.util.List<java.lang.String> r6 = r8.f26734jd     // Catch:{ all -> 0x019c }
        boolean r6 = r6.contains(r0)     // Catch:{ all -> 0x019c }
        if (r6 == 0) goto L_0x0053
        java.util.Map<java.lang.String, discoveryAD.C$c> r9 = r8.f26737md     // Catch:{ all -> 0x019c }
        java.lang.Object r9 = r9.get(r0)     // Catch:{ all -> 0x019c }
        discoveryAD.C$c r9 = (discoveryAD.C7855C.C7858c) r9     // Catch:{ all -> 0x019c }
        if (r9 == 0) goto L_0x0051
        java.util.List<discoveryAD.C$a> r9 = r9.f26744bd     // Catch:{ all -> 0x019c }
        r9.add(r11)     // Catch:{ all -> 0x019c }
    L_0x0051:
        monitor-exit(r5)     // Catch:{ all -> 0x019c }
        return
    L_0x0053:
        discoveryAD.C$c r6 = new discoveryAD.C$c     // Catch:{ all -> 0x019c }
        r6.m54299init()     // Catch:{ all -> 0x019c }
        r6.f26740Yc = r0     // Catch:{ all -> 0x019c }
        java.util.List<discoveryAD.C$a> r7 = r6.f26744bd     // Catch:{ all -> 0x019c }
        r7.add(r11)     // Catch:{ all -> 0x019c }
        java.util.Map<java.lang.String, discoveryAD.C$c> r11 = r8.f26737md     // Catch:{ all -> 0x019c }
        r11.put(r0, r6)     // Catch:{ all -> 0x019c }
        java.util.List<java.lang.String> r11 = r8.f26734jd     // Catch:{ all -> 0x019c }
        r11.add(r0)     // Catch:{ all -> 0x019c }
        monitor-exit(r5)     // Catch:{ all -> 0x019c }
        java.util.Map<java.lang.String, discoveryAD.C$c> r11 = r8.f26737md
        java.lang.Object r11 = r11.get(r0)
        discoveryAD.C$c r11 = (discoveryAD.C7855C.C7858c) r11
        r11.f26739Xc = r3
        r11.f26738Wc = r10
        if (r10 != r1) goto L_0x00ad
        java.util.Iterator r10 = r9.iterator()
    L_0x007c:
        boolean r0 = r10.hasNext()
        if (r0 == 0) goto L_0x009b
        java.lang.Object r0 = r10.next()
        com.tencent.qqpim.discovery.AdRequestData r0 = (com.tencent.qqpim.discovery.AdRequestData) r0
        android.util.SparseIntArray r1 = r11.f26743ad
        int r3 = r0.positionId
        r1.put(r3, r2)
        java.util.List<java.lang.Integer> r1 = r11.f26741Zc
        int r0 = r0.positionId
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        r1.add(r0)
        goto L_0x007c
    L_0x009b:
        discoveryAD.z r10 = new discoveryAD.z
        r10.m54373init(r8, r11, r9)
        r11.f26745cd = r10
        android.os.Handler r10 = r8.mHandler
        discoveryAD.A r0 = new discoveryAD.A
        r0.m54294init(r8, r9, r11)
        r10.post(r0)
        return
    L_0x00ad:
        r0 = 3
        r3 = 1000(0x3e8, double:4.94E-321)
        r1 = 0
        if (r10 != r0) goto L_0x00e9
        java.util.Iterator r10 = r9.iterator()
    L_0x00b7:
        boolean r0 = r10.hasNext()
        if (r0 == 0) goto L_0x00cb
        java.lang.Object r0 = r10.next()
        com.tencent.qqpim.discovery.AdRequestData r0 = (com.tencent.qqpim.discovery.AdRequestData) r0
        android.util.SparseIntArray r2 = r11.f26743ad
        int r0 = r0.positionId
        r2.put(r0, r1)
        goto L_0x00b7
    L_0x00cb:
        android.content.Context r10 = r8.mContext
        boolean r10 = discoveryAD.C7931ta.isNetworkConnected(r10)
        if (r10 != 0) goto L_0x00de
        android.os.Handler r10 = r8.mHandler
        discoveryAD.B r0 = new discoveryAD.B
        r0.m54296init(r8, r9, r11)
        r10.postDelayed(r0, r3)
        goto L_0x00e8
    L_0x00de:
        android.os.Handler r10 = r8.mHandler
        discoveryAD.g r0 = new discoveryAD.g
        r0.m54332init(r8, r9, r11)
        r10.post(r0)
    L_0x00e8:
        return
    L_0x00e9:
        if (r10 != 0) goto L_0x0162
        java.util.ArrayList r10 = new java.util.ArrayList
        r10.<init>()
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        java.util.Iterator r2 = r9.iterator()
    L_0x00f9:
        boolean r5 = r2.hasNext()
        if (r5 == 0) goto L_0x0127
        java.lang.Object r5 = r2.next()
        com.tencent.qqpim.discovery.AdRequestData r5 = (com.tencent.qqpim.discovery.AdRequestData) r5
        android.util.SparseIntArray r6 = r11.f26743ad
        int r7 = r5.positionId
        r6.put(r7, r1)
        java.util.List<java.lang.Integer> r6 = r11.f26741Zc
        int r7 = r5.positionId
        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
        r6.add(r7)
        int r6 = r5.positionId
        boolean r6 = discoveryAD.C7895e.m34311J(r6)
        if (r6 == 0) goto L_0x0123
        r10.add(r5)
        goto L_0x00f9
    L_0x0123:
        r0.add(r5)
        goto L_0x00f9
    L_0x0127:
        discoveryAD.h r1 = new discoveryAD.h
        r1.m54334init(r8, r11, r9)
        r11.f26745cd = r1
        boolean r9 = r10.isEmpty()
        if (r9 != 0) goto L_0x0151
        android.content.Context r9 = r8.mContext
        boolean r9 = discoveryAD.C7931ta.isNetworkConnected(r9)
        if (r9 != 0) goto L_0x0147
        android.os.Handler r9 = r8.mHandler
        discoveryAD.i r1 = new discoveryAD.i
        r1.m54336init(r8, r10, r11)
        r9.postDelayed(r1, r3)
        goto L_0x0151
    L_0x0147:
        android.os.Handler r9 = r8.mHandler
        discoveryAD.j r1 = new discoveryAD.j
        r1.m54339init(r8, r10, r11)
        r9.post(r1)
    L_0x0151:
        boolean r9 = r0.isEmpty()
        if (r9 != 0) goto L_0x0161
        android.os.Handler r9 = r8.mHandler
        discoveryAD.k r10 = new discoveryAD.k
        r10.m54341init(r8, r0, r11)
        r9.post(r10)
    L_0x0161:
        return
    L_0x0162:
        if (r10 == r2) goto L_0x0167
        r0 = 4
        if (r10 != r0) goto L_0x019b
    L_0x0167:
        java.util.Iterator r0 = r9.iterator()
    L_0x016b:
        boolean r2 = r0.hasNext()
        if (r2 == 0) goto L_0x018a
        java.lang.Object r2 = r0.next()
        com.tencent.qqpim.discovery.AdRequestData r2 = (com.tencent.qqpim.discovery.AdRequestData) r2
        android.util.SparseIntArray r3 = r11.f26743ad
        int r4 = r2.positionId
        r3.put(r4, r1)
        java.util.List<java.lang.Integer> r3 = r11.f26741Zc
        int r2 = r2.positionId
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        r3.add(r2)
        goto L_0x016b
    L_0x018a:
        discoveryAD.l r0 = new discoveryAD.l
        r0.m54343init(r8, r11, r9)
        r11.f26745cd = r0
        android.os.Handler r0 = r8.mHandler
        discoveryAD.m r1 = new discoveryAD.m
        r1.m54345init(r8, r9, r11, r10)
        r0.post(r1)
    L_0x019b:
        return
    L_0x019c:
        r9 = move-exception
        monitor-exit(r5)     // Catch:{ all -> 0x019c }
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7855C.mo38114a(java.util.List, int, discoveryAD.C$a):void");
    }

    /* renamed from: a */
    public void mo38115a(List<AdRequestData> list, C7856a aVar) {
        mo38114a(list, 0, aVar);
    }

    /* renamed from: a */
    public void mo38116a(boolean z, AdDisplayModel adDisplayModel) {
        C7491f a = mo38109a(adDisplayModel);
        if (a == null) {
            if (!this.f26735kd.get(adDisplayModel.positionId, false)) {
                this.mHandler.post(new C7934v(this, adDisplayModel, z));
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onNagetiveFeedbackAd() UnifiedAdData:");
        sb.append(a);
        C7852Aa.m34153d(sb.toString());
        if (z) {
            this.f26731ed.mo38193e(a);
        }
        this.mHandler.post(new C7936w(this, z, a));
    }

    /* renamed from: b */
    public void mo38117b(AdDisplayModel adDisplayModel) {
        mo38111a(adDisplayModel, (Bundle) null);
    }

    /* renamed from: c */
    public void mo38118c(AdDisplayModel adDisplayModel) {
        mo38110a(adDisplayModel, 0);
    }

    /* renamed from: cb */
    public void mo38119cb() {
        this.f26736ld = null;
    }

    public void reportAppPhase(AdDisplayModel adDisplayModel, int i, int i2) {
        C7491f a = mo38109a(adDisplayModel);
        if (a == null) {
            if (!this.f26735kd.get(adDisplayModel.positionId, false)) {
                this.mHandler.post(new C7924q(this, adDisplayModel, i, i2));
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("reportAppPhase() UnifiedAdData:");
        sb.append(a);
        sb.append(" phase=");
        sb.append(i);
        C7852Aa.m34153d(sb.toString());
        C7885a aVar = null;
        if (i == 5) {
            aVar = this.f26731ed.mo38194f(a);
        } else if (i == 6) {
            aVar = this.f26731ed.mo38192d(a);
        } else if (i == 10) {
            aVar = this.f26731ed.mo38186a(a);
        }
        C7885a aVar2 = aVar;
        Handler handler = this.mHandler;
        C7928s sVar = new C7928s(this, aVar2, a, i, i2);
        handler.post(sVar);
    }

    public void setAdListener(AdListener adListener) {
        this.f26736ld = adListener;
    }
}
