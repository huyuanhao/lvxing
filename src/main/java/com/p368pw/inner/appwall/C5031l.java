package com.p368pw.inner.appwall;

import android.os.Handler;
import android.os.HandlerThread;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5213t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.pw.inner.appwall.l */
public class C5031l {
    /* renamed from: b */
    private static C5031l f16410b;
    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean f16411a = false;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Handler f16412c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final List<C5014i> f16413d = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: e */
    public Runnable f16414e = new Runnable() {
        public void run() {
            String A = C5191i.m21381A(C5233e.m21559b());
            Iterator it = C5031l.this.f16413d.iterator();
            while (it.hasNext()) {
                C5014i iVar = (C5014i) it.next();
                C5034m mVar = iVar.f16326a;
                if (!C5213t.m21487a(mVar.mo26466a().mo26743a(), A)) {
                    iVar.f16327b = 0;
                } else if (iVar.f16327b == 0) {
                    iVar.f16327b = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - iVar.f16327b > ((long) (mVar.mo26469d().mo26481b() * 1000))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(mVar.mo26466a().mo26743a());
                    sb.append(" is real activate");
                    C5205o.m21462a(sb.toString());
                    it.remove();
                    C4970aa.m20784a().mo26319a(mVar, iVar.f16328c);
                }
            }
            if (!C5188f.m21377a((Collection) C5031l.this.f16413d)) {
                C5031l.this.f16411a = true;
                C5031l.this.f16412c.postDelayed(this, 500);
                return;
            }
            C5031l.this.f16411a = false;
        }
    };
    /* renamed from: f */
    private final String[] f16415f = {"com.lbe.security.miui"};

    private C5031l() {
        HandlerThread handlerThread = new HandlerThread("activate watcher");
        handlerThread.start();
        this.f16412c = new Handler(handlerThread.getLooper());
    }

    /* renamed from: a */
    public static C5031l m21010a() {
        if (f16410b == null) {
            synchronized (C5031l.class) {
                if (f16410b == null) {
                    f16410b = new C5031l();
                }
            }
        }
        return f16410b;
    }

    /* renamed from: a */
    public void mo26459a(final C5034m mVar, final int i) {
        if (mVar != null && mVar.mo26466a() != null && mVar.mo26469d() != null) {
            this.f16412c.post(new Runnable() {
                public void run() {
                    int i = 0;
                    while (true) {
                        if (i >= C5031l.this.f16413d.size()) {
                            break;
                        } else if (C5213t.m21487a(mVar.mo26466a().mo26743a(), ((C5014i) C5031l.this.f16413d.get(i)).f16326a.mo26466a().mo26743a())) {
                            C5031l.this.f16413d.remove(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                    C5031l.this.f16413d.add(new C5014i(mVar, 0, i));
                    if (!C5031l.this.f16411a) {
                        C5031l.this.f16411a = true;
                        C5031l.this.f16412c.postDelayed(C5031l.this.f16414e, 500);
                    }
                }
            });
        }
    }
}
