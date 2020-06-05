package com.p368pw.inner.p369a.p370a.p373c.p375b;

import android.content.Context;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5204n;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.p369a.p379e.C4932d;
import com.tencent.p605ep.shanhuad.adpublic.models.AdMetaInfo;
import com.tmsdk.module.coin.CoinTask;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.a.c.b.a */
public class C4842a {
    /* renamed from: a */
    private static volatile C4842a f15606a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ConcurrentMap<String, ConcurrentLinkedQueue<C4932d>> f15607b = new ConcurrentHashMap();
    /* renamed from: c */
    private ConcurrentMap<String, CoinTask> f15608c = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Context f15609d;
    /* renamed from: e */
    private SortedSet<String> f15610e;

    private C4842a(Context context) {
        this.f15609d = context.getApplicationContext();
        m19882a();
    }

    /* renamed from: a */
    public static C4842a m19880a(Context context) {
        if (f15606a == null) {
            synchronized (C4842a.class) {
                if (f15606a == null) {
                    f15606a = new C4842a(context);
                }
            }
        }
        return f15606a;
    }

    /* renamed from: a */
    private void m19882a() {
        this.f15610e = new TreeSet(C5207q.m21475a(C5237f.m21596h(this.f15609d)));
        if (!C5188f.m21377a((Collection) this.f15610e)) {
            for (String a : this.f15610e) {
                m19884a(a);
            }
        }
    }

    /* renamed from: a */
    private void m19883a(final C4932d dVar, final CoinTask coinTask) {
        if (dVar != null && coinTask != null) {
            C5208r.m21482b(new Runnable() {
                public void run() {
                    C5237f.m21575a(C4842a.this.f15609d, dVar, coinTask);
                }
            });
        }
    }

    /* renamed from: a */
    private void m19884a(String str) {
        String j = C5237f.m21601j(this.f15609d, str);
        if (!C5207q.m21476a((CharSequence) j)) {
            try {
                JSONArray jSONArray = new JSONArray(j);
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            if (jSONObject != null) {
                                C4932d dVar = (C4932d) C5204n.m21459a(jSONObject.toString(), C4932d.class);
                                if (!C5207q.m21476a((CharSequence) dVar.mo26132b()) && !C5207q.m21476a((CharSequence) dVar.mo26128a())) {
                                    if (!C5207q.m21476a((CharSequence) dVar.mo26134c())) {
                                        String a = C5237f.m21570a(this.f15609d, dVar);
                                        if (!C5207q.m21476a((CharSequence) a)) {
                                            CoinTask coinTask = (CoinTask) C5204n.m21459a(a, CoinTask.class);
                                            if (coinTask == null) {
                                                C5237f.m21580b(this.f15609d, dVar);
                                            } else {
                                                m19885a(str, dVar);
                                                this.f15608c.put(dVar.mo26136d(), coinTask);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            C5205o.m21464a(th);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private void m19885a(String str, C4932d dVar) {
        if (!C5207q.m21476a((CharSequence) str) && dVar != null) {
            if (this.f15607b.get(str) == null) {
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                concurrentLinkedQueue.add(dVar);
                this.f15607b.put(str, concurrentLinkedQueue);
                return;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue2 = (ConcurrentLinkedQueue) this.f15607b.get(str);
            if (!concurrentLinkedQueue2.contains(dVar)) {
                concurrentLinkedQueue2.add(dVar);
            }
        }
    }

    /* renamed from: b */
    private void m19887b() {
        if (C5188f.m21377a((Collection) this.f15610e)) {
            m19882a();
        }
    }

    /* renamed from: b */
    private void m19888b(final String str) {
        if (!C5207q.m21476a((CharSequence) str) && this.f15607b.get(str) != null) {
            C5208r.m21482b(new Runnable() {
                public void run() {
                    ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) C4842a.this.f15607b.get(str);
                    if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            JSONObject e = ((C4932d) it.next()).mo26138e();
                            if (e != null) {
                                jSONArray.put(e);
                            }
                        }
                        C5237f.m21586c(C4842a.this.f15609d, str, jSONArray.toString());
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo25849a(String str, Map<AdMetaInfo, CoinTask> map) {
        m19887b();
        if (!C5207q.m21476a((CharSequence) str) && map != null && map.size() != 0) {
            for (Entry entry : map.entrySet()) {
                AdMetaInfo adMetaInfo = (AdMetaInfo) entry.getKey();
                CoinTask coinTask = (CoinTask) entry.getValue();
                if (adMetaInfo != null) {
                    if (coinTask != null) {
                        if (adMetaInfo.getAdDisplayModel() == null || !C5207q.m21478b((CharSequence) adMetaInfo.getAdDisplayModel().jumpUrl)) {
                            C4932d a = C4932d.m20457a((AdMetaInfo) entry.getKey());
                            m19885a(str, a);
                            m19883a(a, coinTask);
                            this.f15608c.put(a.mo26136d(), entry.getValue());
                        }
                    }
                }
            }
            m19888b(str);
        }
    }
}
