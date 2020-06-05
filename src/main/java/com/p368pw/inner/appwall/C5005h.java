package com.p368pw.inner.appwall;

import android.content.Context;
import android.text.TextUtils;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.appwall.C5041p.C5042a;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5131a;
import com.p368pw.inner.base.p385b.C5131a.C5134a;
import com.p368pw.inner.base.p385b.C5131a.C5135b;
import com.p368pw.inner.base.p385b.C5137b;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5204n;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.stat.C5227f;
import com.p368pw.inner.p369a.p370a.p371a.C4821a;
import com.p368pw.inner.p369a.p370a.p371a.C4822b;
import com.p368pw.inner.p369a.p370a.p371a.C4828f;
import com.p368pw.inner.p369a.p370a.p371a.C4830h;
import com.p368pw.inner.p369a.p370a.p373c.C4845c;
import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tmsdk.module.coin.Coin;
import com.tmsdk.module.coin.CoinManager;
import com.tmsdk.module.coin.CoinRequestInfo;
import com.tmsdk.module.coin.CoinTask;
import com.tmsdk.module.coin.ManagerCreator;
import com.tmsdk.module.coin.SubmitResultItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.appwall.h */
public class C5005h {
    /* renamed from: a */
    private CoinManager f16288a;

    /* renamed from: com.pw.inner.appwall.h$a */
    private static class C5013a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5005h f16325a = new C5005h();
    }

    /* renamed from: a */
    public static C5005h m20951a() {
        return C5013a.f16325a;
    }

    /* renamed from: a */
    public List<C4828f> mo26399a(String str) {
        String str2 = AppEntity.KEY_SIZE_LONG;
        String str3 = "type";
        C5123d d = C5125f.m21216a().mo26727d();
        C5030k e = C5125f.m21216a().mo26728e();
        int d2 = d != null ? d.mo26700d() : 5;
        int q = e.mo26450q() > 0 ? e.mo26450q() : 10;
        int r = e.mo26451r() > 0 ? e.mo26451r() : 20;
        int s = e.mo26452s() > 0 ? e.mo26452s() : 6;
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str3, 1);
            jSONObject.put(str2, q);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str3, 2);
            jSONObject2.put(str2, r);
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str3, 3);
            jSONObject3.put(str2, s);
            jSONArray.put(jSONObject3);
            C4821a aVar = new C4821a(q + r + s, 0, 0, 2, 8, str);
            aVar.mo25764a(d2);
            aVar.mo25767c(2);
            aVar.mo25760a(jSONArray);
            C4830h hVar = (C4830h) aVar.mo26659b();
            C5205o.m21462a("z aw native load net data");
            if (hVar.mo25836a() == 200) {
                C5205o.m21462a("z aw native ok");
                return C4822b.m19717e(hVar);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return null;
    }

    /* renamed from: a */
    public void mo26400a(Context context, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, AdMetaInfo adMetaInfo, CoinTask coinTask) {
        String str8;
        String str9 = "";
        if (adMetaInfo != null) {
            try {
                str8 = C5204n.m21460a(adMetaInfo);
            } catch (Throwable th) {
                C5205o.m21464a(th);
                return;
            }
        } else {
            str8 = str9;
        }
        if (coinTask != null) {
            str9 = C5204n.m21460a(coinTask);
        }
        int i3 = i;
        int i4 = i2;
        new C5227f().mo26912a(i, i2).mo26914a(str, str2, str3, str4, str5, str6, str7).mo26913a(str8, str9).mo26660c();
        Context context2 = context;
        C5237f.m21584c(context, System.currentTimeMillis());
    }

    /* renamed from: a */
    public void mo26401a(Context context, int i, AdMetaInfo adMetaInfo, CoinTask coinTask, String str) {
        String sb;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("am sh sm, ty = ");
            sb2.append(i);
            C5205o.m21462a(sb2.toString());
            if (adMetaInfo != null) {
                if (adMetaInfo.getAdDisplayModel() != null) {
                    if (this.f16288a == null) {
                        this.f16288a = (CoinManager) ManagerCreator.getManager(CoinManager.class);
                    }
                    if (i == 1) {
                        C5205o.m21462a("am sh install");
                        C4845c.m19893c(adMetaInfo);
                    }
                    if (i == 2) {
                        C5205o.m21462a("am sh active");
                        C4845c.m19894d(adMetaInfo);
                        if (coinTask != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(coinTask);
                            CoinRequestInfo coinRequestInfo = new CoinRequestInfo();
                            coinRequestInfo.accountId = C5191i.m21387a(context);
                            coinRequestInfo.loginKey = C5238g.m21604a(context);
                            ArrayList arrayList2 = new ArrayList();
                            int SubmitBatchTask = this.f16288a.SubmitBatchTask(coinRequestInfo, arrayList, new Coin(), arrayList2);
                            String str2 = "am sm code: ";
                            if (SubmitBatchTask == 0) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str2);
                                sb3.append(((SubmitResultItem) arrayList2.get(0)).errorCode);
                                sb = sb3.toString();
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(str2);
                                sb4.append(SubmitBatchTask);
                                sb = sb4.toString();
                            }
                            C5205o.m21462a(sb);
                        }
                    }
                    if (i == 3) {
                        C5205o.m21462a("am sh display");
                    }
                    if (i == 4) {
                        C5205o.m21462a("am sh click");
                    }
                    if (i == 5) {
                        C5205o.m21462a("am sh dw ld start");
                        C4845c.m19890a(adMetaInfo);
                    }
                    if (i == 6) {
                        C5205o.m21462a("am sh dw ld succ");
                        boolean isEmpty = TextUtils.isEmpty(str);
                        C4845c.m19892b(adMetaInfo);
                    }
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26402a(Context context, int i, String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    mo26401a(context, i, (AdMetaInfo) C5204n.m21459a(str, AdMetaInfo.class), (CoinTask) C5204n.m21459a(str2, CoinTask.class), str3);
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26403a(Context context, List<C5034m> list, List<C5034m> list2, List<C5034m> list3, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            if (!C5188f.m21377a((Collection) list)) {
                for (int i = 0; i < list.size(); i++) {
                    arrayList.add(((C5034m) list.get(i)).mo26466a().mo26743a());
                }
            }
            if (!C5188f.m21377a((Collection) list2)) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    arrayList.add(((C5034m) list2.get(i2)).mo26466a().mo26743a());
                }
            }
            if (!C5188f.m21377a((Collection) list3)) {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    arrayList.add(((C5034m) list3.get(i3)).mo26466a().mo26743a());
                }
            }
            if (!C5188f.m21377a((Collection) arrayList)) {
                C5041p pVar = (C5041p) new C5044r(context, str, arrayList, C4970aa.m20784a().mo26332d().getRewardType()).mo26659b();
                C5205o.m21462a("sg rq cfs");
                if (!C5188f.m21377a((Collection) list)) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        C5034m mVar = (C5034m) it.next();
                        C5042a aVar = (C5042a) pVar.mo26478a().get(mVar.mo26466a().mo26743a());
                        if (aVar != null) {
                            mVar.mo26462a(aVar);
                            mVar.mo26466a().f16784m = aVar.mo26480a();
                        } else {
                            it.remove();
                        }
                    }
                }
                if (!C5188f.m21377a((Collection) list2)) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        C5034m mVar2 = (C5034m) it2.next();
                        C5042a aVar2 = (C5042a) pVar.mo26478a().get(mVar2.mo26466a().mo26743a());
                        if (aVar2 != null) {
                            mVar2.mo26462a(aVar2);
                            mVar2.mo26466a().f16784m = aVar2.mo26480a();
                        } else {
                            it2.remove();
                        }
                    }
                }
                if (!C5188f.m21377a((Collection) list3)) {
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        C5034m mVar3 = (C5034m) it3.next();
                        C5042a aVar3 = (C5042a) pVar.mo26478a().get(mVar3.mo26466a().mo26743a());
                        if (aVar3 != null) {
                            mVar3.mo26462a(aVar3);
                            mVar3.mo26466a().f16784m = aVar3.mo26480a();
                        } else {
                            it3.remove();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26404a(C5138c cVar, AdMetaInfo adMetaInfo, CoinTask coinTask, C5134a aVar) {
        if (cVar != null) {
            final C5138c cVar2 = cVar;
            final AdMetaInfo adMetaInfo2 = adMetaInfo;
            final CoinTask coinTask2 = coinTask;
            final C5134a aVar2 = aVar;
            C50072 r0 = new Runnable() {
                public void run() {
                    try {
                        String str = "";
                        C5131a.m21242a().mo26738a(C5204n.m21460a(cVar2), adMetaInfo2 != null ? C5204n.m21460a(adMetaInfo2) : str, coinTask2 != null ? C5204n.m21460a(coinTask2) : str, cVar2.f16781j, String.valueOf(System.currentTimeMillis()), cVar2.mo26743a(), cVar2.f16782k);
                        C5208r.m21479a(new Runnable() {
                            public void run() {
                                if (aVar2 != null) {
                                    aVar2.mo26382a();
                                }
                            }
                        });
                    } catch (Throwable th) {
                        C5205o.m21464a(th);
                    }
                }
            };
            C5208r.m21482b(r0);
        }
    }

    /* renamed from: a */
    public void mo26405a(AdMetaInfo adMetaInfo, CoinTask coinTask, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6, String str7, String str8, int i4, String str9, String str10, int i5, C5134a aVar) {
        final AdMetaInfo adMetaInfo2 = adMetaInfo;
        final CoinTask coinTask2 = coinTask;
        final String str11 = str;
        final String str12 = str2;
        final String str13 = str3;
        final String str14 = str4;
        final String str15 = str5;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final String str16 = str6;
        final String str17 = str7;
        final String str18 = str8;
        final int i9 = i4;
        final String str19 = str9;
        final String str20 = str10;
        final int i10 = i5;
        final C5134a aVar2 = aVar;
        C50061 r0 = new Runnable(this) {
            /* renamed from: s */
            final /* synthetic */ C5005h f16307s;

            {
                this.f16307s = r3;
            }

            public void run() {
                try {
                    String str = str11;
                    String str2 = str12;
                    String str3 = str13;
                    String str4 = str14;
                    String str5 = str15;
                    int i = i6;
                    int i2 = i7;
                    int i3 = i8;
                    String str6 = str16;
                    String str7 = str17;
                    String str8 = str18;
                    int i4 = i9;
                    String str9 = str19;
                    String str10 = str9;
                    C5138c cVar = new C5138c(str, str2, str3, str4, str5, i, i2, i3, str6, str7, str8, i4, str10, i10, str20);
                    cVar.mo26744a(System.identityHashCode(adMetaInfo2));
                    this.f16307s.mo26404a(cVar, adMetaInfo2, coinTask2, aVar2);
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                }
            }
        };
        C5208r.m21482b(r0);
    }

    /* renamed from: a */
    public void mo26406a(String str, int i, int i2, C5134a aVar) {
        try {
            final String str2 = str;
            final int i3 = i;
            final int i4 = i2;
            final C5134a aVar2 = aVar;
            C50093 r0 = new Runnable() {
                public void run() {
                    C5131a.m21242a().mo26736a(str2, i3, i4, aVar2);
                }
            };
            C5208r.m21482b(r0);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26407a(final String str, final C5135b bVar) {
        try {
            C5208r.m21482b(new Runnable() {
                public void run() {
                    C5131a.m21242a().mo26733a(str, (C5135b) new C5135b() {
                        /* renamed from: a */
                        public void mo25840a(final int i) {
                            C5208r.m21479a(new Runnable() {
                                public void run() {
                                    if (bVar != null) {
                                        bVar.mo25840a(i);
                                    }
                                }
                            });
                        }
                    });
                }
            });
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26408a(List<C5034m> list, List<C5034m> list2, List<C5138c> list3, String str) {
        boolean z;
        List<C5034m> list4 = list;
        List<C5034m> list5 = list2;
        List<C5138c> list6 = list3;
        try {
            List a = C5131a.m21242a().mo26734a((C5134a) null);
            int i = 0;
            while (a != null && i < a.size()) {
                C4990b.m20867a().mo26380a(((C5137b) a.get(i)).f16764f);
                i++;
            }
            try {
                List a2 = mo26399a(str);
                if (a2 != null && !a2.isEmpty()) {
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        C4828f fVar = (C4828f) a2.get(i2);
                        int i3 = 0;
                        while (true) {
                            if (a == null || i3 >= a.size()) {
                                z = false;
                            } else {
                                C5137b bVar = (C5137b) a.get(i3);
                                if (bVar.f16764f.equals(fVar.mo25814g())) {
                                    C5034m mVar = new C5034m();
                                    C5138c cVar = (C5138c) C5204n.m21459a(bVar.f16759a, C5138c.class);
                                    cVar.f16773b = fVar.mo25811d();
                                    cVar.f16772a = fVar.mo25810c();
                                    cVar.f16777f = fVar.mo25813f();
                                    cVar.f16774c = fVar.mo25808a();
                                    cVar.f16785n = 8;
                                    if (fVar.mo25826s() == 1) {
                                        cVar.f16783l = 1;
                                    } else if (fVar.mo25826s() == 2) {
                                        cVar.f16783l = 3;
                                    }
                                    cVar.f16791t = fVar.mo25832y();
                                    cVar.f16781j = bVar.f16762d;
                                    cVar.f16782k = bVar.f16765g;
                                    mVar.mo26463a(cVar);
                                    mVar.mo26464a((AdMetaInfo) C5204n.m21459a(bVar.f16760b, AdMetaInfo.class));
                                    mVar.mo26465a((CoinTask) C5204n.m21459a(bVar.f16761c, CoinTask.class));
                                    if (fVar.mo25826s() == 1) {
                                        list5.add(mVar);
                                    } else if (fVar.mo25826s() == 2) {
                                        list4.add(mVar);
                                    } else if (fVar.mo25826s() == 3) {
                                        cVar.f16775d = fVar.mo25827t();
                                        cVar.f16783l = 6;
                                        cVar.f16778g = fVar.mo25809b();
                                        cVar.f16779h = fVar.mo25815h();
                                        cVar.f16780i = fVar.mo25828u();
                                        if (!TextUtils.isEmpty(fVar.mo25809b()) && !TextUtils.isEmpty(fVar.mo25815h())) {
                                            list6.add(cVar);
                                        }
                                    }
                                    a.remove(i3);
                                    z = true;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            C5034m mVar2 = new C5034m();
                            C5138c cVar2 = new C5138c(fVar.mo25810c(), fVar.mo25811d(), fVar.mo25808a(), fVar.mo25814g(), "", 0, 0, 8, "", "", String.valueOf(fVar.mo25824q()), 0, "", fVar.mo25824q(), fVar.mo25832y());
                            cVar2.f16782k = fVar.mo25825r() == 3 ? 1 : 0;
                            cVar2.f16777f = fVar.mo25813f();
                            if (fVar.mo25826s() == 1) {
                                cVar2.f16783l = 1;
                            } else if (fVar.mo25826s() == 2) {
                                cVar2.f16783l = 3;
                            }
                            mVar2.mo26463a(cVar2);
                            mVar2.mo26464a((AdMetaInfo) C5204n.m21459a(fVar.mo25829v(), AdMetaInfo.class));
                            mVar2.mo26465a((CoinTask) C5204n.m21459a(fVar.mo25830w(), CoinTask.class));
                            if (fVar.mo25826s() == 1) {
                                list5.add(mVar2);
                            } else if (fVar.mo25826s() == 2) {
                                list4.add(mVar2);
                            } else if (fVar.mo25826s() == 3) {
                                cVar2.f16775d = fVar.mo25827t();
                                cVar2.f16783l = 6;
                                cVar2.f16778g = fVar.mo25809b();
                                cVar2.f16779h = fVar.mo25815h();
                                cVar2.f16780i = fVar.mo25828u();
                                if (!TextUtils.isEmpty(fVar.mo25809b()) && !TextUtils.isEmpty(fVar.mo25815h())) {
                                    list6.add(cVar2);
                                }
                            }
                        }
                    }
                }
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    C4990b.m20867a().mo26380a(((C5034m) list5.get(i4)).mo26466a().mo26743a());
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    C4990b.m20867a().mo26380a(((C5034m) list4.get(i5)).mo26466a().mo26743a());
                }
            } catch (Throwable th) {
                th = th;
                C5205o.m21464a(th);
            }
        } catch (Throwable th2) {
            th = th2;
            C5205o.m21464a(th);
        }
    }
}
