package com.qiyukf.nim.uikit.session.module.input.p428a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.qiyukf.nim.uikit.common.p419a.C5436c;
import com.qiyukf.nim.uikit.common.p419a.C5437d;
import com.qiyukf.nimlib.p453d.p454a.p457c.C5754a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p502e.C6051i;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6124f.C6125a;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6149e;
import com.qiyukf.unicorn.p514h.C6185c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.module.input.a.a */
public final class C5594a {
    /* renamed from: a */
    private ListView f18010a;
    /* renamed from: b */
    private List<C6125a> f18011b = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5437d<C6125a> f18012c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public String f18013d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public String f18014e;
    /* renamed from: f */
    private String f18015f;
    /* renamed from: g */
    private Handler f18016g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public long f18017h = 0;
    /* renamed from: i */
    private Runnable f18018i = new Runnable() {
        public final void run() {
            if (!TextUtils.isEmpty(C5594a.this.f18014e) && C5594a.this.f18014e.length() <= 10) {
                C5594a aVar = C5594a.this;
                C5594a.m22687b(aVar, aVar.f18014e);
                C5594a aVar2 = C5594a.this;
                aVar2.f18013d = aVar2.f18014e;
                C5594a.this.f18017h = System.currentTimeMillis();
            }
        }
    };

    /* renamed from: com.qiyukf.nim.uikit.session.module.input.a.a$a */
    public interface C5597a {
        /* renamed from: a */
        void mo27755a(C6125a aVar);
    }

    /* renamed from: b */
    static /* synthetic */ void m22687b(C5594a aVar, String str) {
        C6149e eVar = new C6149e();
        eVar.mo29198a(C6029d.m24047g().mo29299e(aVar.f18015f));
        eVar.mo29199a(str);
        C6185c.m24532a(eVar, aVar.f18015f, false);
    }

    /* renamed from: b */
    private void m22688b(String str) {
        ListView listView;
        int i;
        if (TextUtils.isEmpty(str)) {
            this.f18011b.clear();
        } else {
            Iterator it = this.f18011b.iterator();
            while (it.hasNext()) {
                C6125a aVar = (C6125a) it.next();
                if (!aVar.mo29111a().contains(str) || aVar.mo29111a().equals(str)) {
                    it.remove();
                }
            }
        }
        this.f18012c.notifyDataSetChanged();
        if (this.f18011b.size() == 0) {
            listView = this.f18010a;
            i = 8;
        } else {
            listView = this.f18010a;
            i = 0;
        }
        listView.setVisibility(i);
    }

    /* renamed from: a */
    public final void mo27750a(Context context, View view, String str, final C5597a aVar) {
        this.f18015f = str;
        this.f18010a = (ListView) view.findViewById(C5961R.C5963id.ysf_quick_reply_list_view);
        this.f18012c = new C5437d<>(context, this.f18011b, new C5436c(C5598b.class));
        this.f18010a.setAdapter(this.f18012c);
        this.f18010a.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (aVar != null) {
                    C6125a aVar = (C6125a) C5594a.this.f18012c.getItem(i);
                    if (aVar != null) {
                        aVar.mo27755a(aVar);
                        C5594a.this.f18013d = aVar.mo29111a();
                    }
                }
            }
        });
        this.f18016g = C5754a.m23152b(context);
    }

    /* renamed from: a */
    public final void mo27751a(String str) {
        C6051i l = C6029d.m24047g().mo29310l(this.f18015f);
        if (l == null || !l.mo28905a()) {
            List<C6125a> list = this.f18011b;
            if (list != null && list.size() > 0) {
                this.f18011b.clear();
                this.f18012c.notifyDataSetChanged();
            }
            return;
        }
        if (TextUtils.isEmpty(str) || str.length() > 10) {
            str = "";
        }
        if (!str.equals(this.f18013d) || this.f18011b.size() == 0) {
            this.f18016g.removeCallbacks(this.f18018i);
            long b = (long) (l.mo28906b() * 1000.0f);
            this.f18016g.postDelayed(this.f18018i, Math.max(Math.min(b - (System.currentTimeMillis() - this.f18017h), b), 50));
        }
        this.f18014e = str;
        this.f18012c.mo27383a((Object) this.f18014e);
        m22688b(this.f18014e);
    }

    /* renamed from: a */
    public final void mo27752a(List<C6125a> list) {
        this.f18011b.clear();
        this.f18011b.addAll(list);
        m22688b(this.f18014e);
    }
}
