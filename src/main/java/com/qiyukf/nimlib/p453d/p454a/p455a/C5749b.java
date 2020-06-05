package com.qiyukf.nimlib.p453d.p454a.p455a;

import android.content.Context;
import android.os.Handler;
import com.qiyukf.nimlib.p453d.p454a.p457c.C5755b;
import com.qiyukf.nimlib.p453d.p454a.p457c.C5755b.C5757a;
import java.util.Map;

/* renamed from: com.qiyukf.nimlib.d.a.a.b */
public final class C5749b {
    /* renamed from: a */
    private static C5749b f18326a;
    /* renamed from: b */
    private boolean f18327b = false;
    /* renamed from: c */
    private C5755b f18328c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Handler f18329d;

    /* renamed from: com.qiyukf.nimlib.d.a.a.b$a */
    public interface C5750a {
        /* renamed from: a */
        void mo28027a(String str, int i, Throwable th);
    }

    /* renamed from: com.qiyukf.nimlib.d.a.a.b$b */
    public class C5751b implements Runnable {
        /* renamed from: b */
        private String f18331b;
        /* renamed from: c */
        private Map<String, String> f18332c;
        /* renamed from: d */
        private String f18333d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public C5750a f18334e;
        /* renamed from: f */
        private boolean f18335f;

        public C5751b(String str, Map<String, String> map, String str2, C5750a aVar, boolean z) {
            this.f18331b = str;
            this.f18332c = map;
            this.f18333d = str2;
            this.f18334e = aVar;
            this.f18335f = z;
        }

        public final void run() {
            final C5748a a = this.f18335f ? C5747a.m23132a(this.f18331b, this.f18332c, this.f18333d) : C5747a.m23131a(this.f18331b, this.f18332c);
            C5749b.this.f18329d.post(new Runnable() {
                public final void run() {
                    if (C5751b.this.f18334e != null) {
                        C5751b.this.f18334e.mo28027a((String) a.f18325c, a.f18323a, a.f18324b);
                    }
                }
            });
        }
    }

    private C5749b() {
    }

    /* renamed from: a */
    public static synchronized C5749b m23138a() {
        C5749b bVar;
        synchronized (C5749b.class) {
            if (f18326a == null) {
                f18326a = new C5749b();
            }
            bVar = f18326a;
        }
        return bVar;
    }

    /* renamed from: a */
    public final void mo28024a(Context context) {
        if (!this.f18327b) {
            this.f18328c = new C5755b("NIM_HTTP_TASK_EXECUTOR", new C5757a());
            this.f18329d = new Handler(context.getMainLooper());
            this.f18327b = true;
        }
    }

    /* renamed from: a */
    public final void mo28025a(String str, Map<String, String> map, String str2, C5750a aVar) {
        mo28026a(str, map, str2, true, aVar);
    }

    /* renamed from: a */
    public final void mo28026a(String str, Map<String, String> map, String str2, boolean z, C5750a aVar) {
        if (this.f18327b) {
            C5755b bVar = this.f18328c;
            C5751b bVar2 = new C5751b(str, map, str2, aVar, z);
            bVar.execute(bVar2);
        }
    }
}
