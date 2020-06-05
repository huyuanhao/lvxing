package com.p368pw.inner.appwall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.p368pw.inner.base.p385b.C5131a.C5134a;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.HashMap;

/* renamed from: com.pw.inner.appwall.n */
public class C5035n {
    /* renamed from: a */
    private Context f16424a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public HashMap<String, C5034m> f16425b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5038a f16426c;
    /* renamed from: d */
    private BroadcastReceiver f16427d = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                    C5034m mVar = (C5034m) C5035n.this.f16425b.get(intent.getData().getSchemeSpecificPart());
                    if (mVar != null) {
                        C5205o.m21462a("aw bd ins");
                        C5138c a = mVar.mo26466a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("aw bd ins id = ");
                        sb.append(a.f16795x);
                        C5205o.m21462a(sb.toString());
                        C4970aa.m20784a().mo26313a(7, a);
                        a.f16781j = 2;
                        C5005h.m20951a().mo26404a(a, mVar.mo26467b(), mVar.mo26468c(), (C5134a) new C5134a() {
                            /* renamed from: a */
                            public void mo26382a() {
                                if (C5035n.this.f16426c != null) {
                                    C5035n.this.f16426c.onRefresh();
                                }
                            }
                        });
                        C5005h.m20951a().mo26401a(context, 1, mVar.mo26467b(), mVar.mo26468c(), "");
                        if (C5035n.this.f16426c != null) {
                            C5035n.this.f16426c.onInstalled(mVar);
                        }
                    }
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    };

    /* renamed from: com.pw.inner.appwall.n$a */
    public interface C5038a {
        void onInstalled(C5034m mVar);

        void onRefresh();
    }

    /* renamed from: com.pw.inner.appwall.n$b */
    private static class C5039b {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5035n f16430a = new C5035n();
    }

    /* renamed from: a */
    public static C5035n m21025a() {
        return C5039b.f16430a;
    }

    /* renamed from: a */
    public void mo26470a(Context context) {
        this.f16424a = context.getApplicationContext();
        if (this.f16425b == null) {
            this.f16425b = new HashMap<>();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.f16424a.registerReceiver(this.f16427d, intentFilter);
    }

    /* renamed from: a */
    public void mo26471a(Context context, C5038a aVar) {
        mo26470a(context);
        this.f16426c = aVar;
    }

    /* renamed from: a */
    public void mo26472a(C5034m mVar) {
        if (this.f16425b == null) {
            this.f16425b = new HashMap<>();
        }
        if (mVar != null) {
            this.f16425b.put(mVar.mo26466a().mo26743a(), mVar);
        }
    }

    /* renamed from: b */
    public void mo26473b() {
        try {
            if (this.f16427d != null) {
                this.f16424a.unregisterReceiver(this.f16427d);
            }
            this.f16426c = null;
            if (this.f16425b != null) {
                this.f16425b.clear();
                this.f16425b = null;
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
