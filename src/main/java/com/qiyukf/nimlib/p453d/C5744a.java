package com.qiyukf.nimlib.p453d;

import android.content.Context;
import com.qiyukf.nimlib.p453d.p454a.p455a.C5749b;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import com.qiyukf.nimlib.p453d.p454a.p457c.C5754a;
import com.qiyukf.nimlib.p453d.p454a.p458d.C5760b;
import com.qiyukf.nimlib.p453d.p454a.p458d.C5761c;
import com.qiyukf.nimlib.p453d.p463d.p464a.C5779b;
import com.qiyukf.nimlib.p453d.p463d.p464a.C5780c;
import com.qiyukf.nimlib.p453d.p465e.C5781a;
import com.tencent.mid.core.Constants;

/* renamed from: com.qiyukf.nimlib.d.a */
public final class C5744a {
    /* renamed from: a */
    private Context f18316a;
    /* renamed from: b */
    private C5779b f18317b;
    /* renamed from: c */
    private C5780c f18318c;

    /* renamed from: com.qiyukf.nimlib.d.a$a */
    private static class C5746a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C5744a f18321a = new C5744a();
    }

    /* renamed from: d */
    public static C5744a m23125d() {
        return C5746a.f18321a;
    }

    /* renamed from: a */
    public final Context mo28019a() {
        return this.f18316a;
    }

    /* renamed from: a */
    public final void mo28020a(final Context context, C5779b bVar, C5780c cVar) {
        if (context == null || !bVar.mo28059d()) {
            throw new IllegalArgumentException("invalid product info");
        } else if (C5761c.m23159a(context)) {
            this.f18316a = context.getApplicationContext();
            this.f18317b = bVar;
            this.f18318c = cVar;
            C5753a.f18338a = this.f18318c.f18412d;
            if (C5760b.m23157a(context, Constants.PERMISSION_INTERNET)) {
                C5749b.m23138a().mo28024a(context);
                C5754a.m23150a(context).postDelayed(new Runnable() {
                    public final void run() {
                        C5781a.m23217a().mo28061a(context);
                    }
                }, 2000);
                return;
            }
            C5753a.m23148e("unable to request http as without INTERNET permission!");
        }
    }

    /* renamed from: b */
    public final C5779b mo28021b() {
        return this.f18317b;
    }

    /* renamed from: c */
    public final C5780c mo28022c() {
        return this.f18318c;
    }
}
