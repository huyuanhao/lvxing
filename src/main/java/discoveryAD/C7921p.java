package discoveryAD;

import android.util.SparseArray;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.internal.model.C7486a;
import com.tencent.qqpim.discovery.internal.model.C7491f;
import discoveryAD.C7855C.C7857b;
import discoveryAD.C7892d.C7893a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: discoveryAD.p */
class C7921p implements C7893a {
    /* renamed from: Ac */
    final /* synthetic */ List f26940Ac;
    /* renamed from: Fc */
    final /* synthetic */ C7858c f26941Fc;
    final /* synthetic */ C7855C this$0;

    /* renamed from: discoveryAD.p$a */
    class C7922a {
        /* renamed from: Mc */
        List<C7491f> f26943Mc;
        /* renamed from: Nc */
        List<C7486a> f26944Nc;

        C7922a() {
        }
    }

    C7921p(C7855C c, List list, C7858c cVar) {
        this.this$0 = c;
        this.f26940Ac = list;
        this.f26941Fc = cVar;
    }

    /* renamed from: b */
    private C7922a m34332b(SparseArray<List<C7486a>> sparseArray) {
        ArrayList arrayList = null;
        List<C7491f> list = null;
        for (AdRequestData adRequestData : this.f26940Ac) {
            List<C7486a> list2 = (List) sparseArray.get(adRequestData.positionId);
            synchronized (this.this$0.f26732gd) {
                List<C7491f> list3 = (List) this.this$0.f26732gd.get(adRequestData.positionId);
                if (!C7931ta.m34347g(list3)) {
                    boolean z = true;
                    for (C7491f fVar : list3) {
                        if (!fVar.sdkADRequest && adRequestData.positionFormatTypes != null && !adRequestData.positionFormatTypes.isEmpty() && adRequestData.positionFormatTypes.contains(Integer.valueOf(fVar.templateType))) {
                            if (!C7931ta.m34347g(list2)) {
                                Iterator it = list2.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (((C7486a) it.next()).f25065te.uniqueKey.equals(fVar.uniqueKey)) {
                                            z = false;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            if (z) {
                                this.this$0.f26731ed.mo38195g(fVar);
                                if (list == null) {
                                    list = new ArrayList<>(5);
                                }
                                list.add(fVar);
                            }
                        }
                    }
                }
            }
            if (!C7931ta.m34347g(list2)) {
                C7852Aa.m34156i("更新本地缓存");
                for (C7486a aVar : list2) {
                    this.this$0.m34187k(aVar.f25065te);
                    this.this$0.f26731ed.mo38189b(aVar);
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(list2);
            }
        }
        C7922a aVar2 = new C7922a();
        aVar2.f26943Mc = list;
        aVar2.f26944Nc = arrayList;
        return aVar2;
    }

    /* renamed from: a */
    public void mo38200a(SparseArray<List<C7486a>> sparseArray) {
        C7852Aa.m34153d("网络拉取  onDataCallback() begin");
        C7852Aa.m34156i("本地广告过期设置  begin");
        C7922a b = m34332b(sparseArray);
        List<C7491f> list = b.f26943Mc;
        List<C7486a> list2 = b.f26944Nc;
        if (!C7931ta.m34347g(list) || !C7931ta.m34347g(list2)) {
            this.this$0.mHandler.post(new C7919o(this, list, list2));
            C7852Aa.m34153d("网络拉取  onDataCallback() end");
        }
    }

    /* renamed from: a */
    public void mo38201a(SparseArray<List<C7486a>> sparseArray, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onRequestFinished() errorcode=");
        sb.append(i);
        C7852Aa.m34153d(sb.toString());
        List list = null;
        for (AdRequestData adRequestData : this.f26940Ac) {
            if (sparseArray != null) {
                list = (List) sparseArray.get(adRequestData.positionId);
            }
            if (i != 0 || !C7931ta.m34347g(list)) {
                this.f26941Fc.f26743ad.put(adRequestData.positionId, i);
            } else {
                this.f26941Fc.f26743ad.put(adRequestData.positionId, 5);
            }
        }
        C7858c cVar = this.f26941Fc;
        if (cVar.f26738Wc == 3) {
            this.this$0.m34171a(this.f26940Ac, cVar, sparseArray);
            return;
        }
        C7857b bVar = cVar.f26745cd;
        if (bVar != null) {
            bVar.mo38122a(this.f26940Ac);
        }
    }
}
