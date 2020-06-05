package discoveryAD;

import android.util.SparseArray;
import com.tencent.qqpim.discovery.internal.model.C7486a;
import com.tencent.qqpim.discovery.internal.model.C7491f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: discoveryAD.b */
public class C7888b {
    /* renamed from: zc */
    private final SparseArray<Map<String, C7885a>> f26875zc = new SparseArray<>();

    public C7888b() {
        C7852Aa.m34156i("AdLifecycleMgr()");
    }

    /* renamed from: H */
    public int mo38184H(int i) {
        int i2;
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(i);
            int i3 = 0;
            if (map != null) {
                for (String str : map.keySet()) {
                    if (((C7885a) map.get(str)).mo38179Wa()) {
                        i3++;
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: I */
    public List<String> mo38185I(int i) {
        ArrayList arrayList;
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(i);
            arrayList = new ArrayList();
            if (map != null) {
                Set<String> keySet = map.keySet();
                ArrayList<C7885a> arrayList2 = new ArrayList<>();
                for (String str : keySet) {
                    C7885a aVar = (C7885a) map.get(str);
                    if (aVar.mo38179Wa()) {
                        arrayList2.add(aVar);
                    }
                }
                Collections.sort(arrayList2);
                for (C7885a aVar2 : arrayList2) {
                    if (!arrayList.contains(aVar2.f26816sc)) {
                        arrayList.add(aVar2.f26816sc);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getReachableSortedAId() posId:");
            sb.append(i);
            sb.append(" return:");
            sb.append(arrayList.size());
            C7852Aa.m34156i(sb.toString());
        }
        return arrayList;
    }

    /* renamed from: a */
    public C7885a mo38186a(C7491f fVar) {
        C7885a aVar;
        StringBuilder sb = new StringBuilder();
        sb.append("onAppOpen():");
        sb.append(fVar.toString());
        C7852Aa.m34156i(sb.toString());
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(fVar.positionId);
            if (map != null) {
                aVar = (C7885a) map.get(fVar.uniqueKey);
                if (aVar != null) {
                    aVar.mo38124Xa();
                }
            } else {
                aVar = null;
            }
        }
        return aVar;
    }

    /* renamed from: a */
    public void mo38187a(C7486a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onCreateAd():");
        sb.append(aVar.toString());
        C7852Aa.m34156i(sb.toString());
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(aVar.f25065te.positionId);
            if (map == null) {
                map = new LinkedHashMap();
                this.f26875zc.put(aVar.f25065te.positionId, map);
            }
            C7885a aVar2 = (C7885a) map.get(aVar.f25065te.uniqueKey);
            if (aVar2 == null) {
                aVar2 = new C7859D();
                map.put(aVar.f25065te.uniqueKey, aVar2);
            }
            aVar2.f26816sc = aVar.f25065te.f25078Ge;
            aVar2.f26819vc = aVar.f25062W;
            aVar2.f26820wc = aVar.weight;
            aVar2.f26815rc = aVar.f25065te.f25098rc;
            aVar2.f26818uc = aVar.f25064Xb;
            aVar2.f26817tc = aVar.f25063Wb;
            aVar2.f26822yc = aVar.f25065te.rotation;
            aVar2.f26821xc = aVar.f25065te.predisplaytime;
        }
    }

    /* renamed from: b */
    public C7885a mo38188b(C7491f fVar) {
        C7885a aVar;
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(fVar.positionId);
            if (map != null) {
                aVar = (C7885a) map.get(fVar.uniqueKey);
                if (aVar != null) {
                    aVar.onClick();
                }
            } else {
                aVar = null;
            }
        }
        return aVar;
    }

    /* renamed from: b */
    public void mo38189b(C7486a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("onReceiveAd():");
        sb.append(aVar.toString());
        C7852Aa.m34156i(sb.toString());
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(aVar.f25065te.positionId);
            if (map == null) {
                map = new LinkedHashMap();
                this.f26875zc.put(aVar.f25065te.positionId, map);
            }
            C7885a aVar2 = (C7885a) map.get(aVar.f25065te.uniqueKey);
            if (aVar2 == null) {
                aVar2 = new C7859D();
                aVar2.f26816sc = aVar.f25065te.f25078Ge;
                aVar2.f26815rc = aVar.f25065te.f25098rc;
                aVar2.f26818uc = aVar.f25064Xb;
                aVar2.f26817tc = aVar.f25063Wb;
                aVar2.f26822yc = aVar.f25065te.rotation;
                map.put(aVar.f25065te.uniqueKey, aVar2);
            } else {
                aVar2.f26816sc = aVar.f25065te.f25078Ge;
                aVar2.f26815rc = aVar.f25065te.f25098rc;
                aVar2.f26818uc = aVar.f25064Xb;
                aVar2.f26817tc = aVar.f25063Wb;
                aVar2.f26822yc = aVar.f25065te.rotation;
                aVar.f25065te.predisplaytime = aVar2.f26821xc;
            }
            aVar2.mo38127_a();
        }
    }

    /* renamed from: c */
    public C7885a mo38190c(C7491f fVar) {
        C7885a aVar;
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(fVar.positionId);
            if (map != null) {
                int i = 0;
                if (!map.isEmpty()) {
                    for (C7885a aVar2 : map.values()) {
                        i = Math.max(i, aVar2.f26820wc);
                    }
                }
                aVar = (C7885a) map.get(fVar.uniqueKey);
                if (aVar != null) {
                    aVar.mo38123G(i);
                }
            } else {
                aVar = null;
            }
        }
        return aVar;
    }

    /* renamed from: c */
    public C7885a mo38191c(String str, int i) {
        C7885a aVar;
        synchronized (this.f26875zc) {
            aVar = (C7885a) ((Map) this.f26875zc.get(i)).get(str);
        }
        return aVar;
    }

    /* renamed from: d */
    public C7885a mo38192d(C7491f fVar) {
        C7885a aVar;
        StringBuilder sb = new StringBuilder();
        sb.append("onDownloadCompleted():");
        sb.append(fVar.toString());
        C7852Aa.m34156i(sb.toString());
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(fVar.positionId);
            if (map != null) {
                aVar = (C7885a) map.get(fVar.uniqueKey);
                if (aVar != null) {
                    aVar.mo38125Ya();
                }
            } else {
                aVar = null;
            }
        }
        return aVar;
    }

    /* renamed from: e */
    public C7885a mo38193e(C7491f fVar) {
        C7885a aVar;
        StringBuilder sb = new StringBuilder();
        sb.append("onFeedBackAd():");
        sb.append(fVar.toString());
        C7852Aa.m34156i(sb.toString());
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(fVar.positionId);
            if (map != null) {
                aVar = (C7885a) map.get(fVar.uniqueKey);
                if (aVar != null) {
                    aVar.mo38126Za();
                }
            } else {
                aVar = null;
            }
        }
        return aVar;
    }

    /* renamed from: f */
    public C7885a mo38194f(C7491f fVar) {
        C7885a aVar;
        StringBuilder sb = new StringBuilder();
        sb.append("onTransAd():");
        sb.append(fVar.toString());
        C7852Aa.m34156i(sb.toString());
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(fVar.positionId);
            if (map != null) {
                aVar = (C7885a) map.get(fVar.uniqueKey);
                if (aVar != null) {
                    aVar.mo38128ab();
                }
            } else {
                aVar = null;
            }
        }
        return aVar;
    }

    /* renamed from: g */
    public void mo38195g(C7491f fVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("setAdExpired():");
        sb.append(fVar.toString());
        C7852Aa.m34156i(sb.toString());
        synchronized (this.f26875zc) {
            Map map = (Map) this.f26875zc.get(fVar.positionId);
            if (map != null) {
                C7885a aVar = (C7885a) map.get(fVar.uniqueKey);
                if (aVar != null) {
                    aVar.mo38181bb();
                }
            }
        }
    }
}
