package com.kwai.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.filedownloader.C4583a.C4585b;
import com.kwai.filedownloader.download.C4629b;
import com.kwai.filedownloader.event.C4647c;
import com.kwai.filedownloader.p358f.C4654c;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import com.kwai.filedownloader.services.C4731c.C4732a;
import java.io.File;
import java.util.List;

/* renamed from: com.kwai.filedownloader.q */
public class C4723q {
    /* renamed from: a */
    private static final Object f15259a = new Object();
    /* renamed from: c */
    private static final Object f15260c = new Object();
    /* renamed from: b */
    private C4742v f15261b;
    /* renamed from: d */
    private C4741u f15262d;

    /* renamed from: com.kwai.filedownloader.q$a */
    private static final class C4724a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C4723q f15263a = new C4723q();
    }

    /* renamed from: a */
    public static C4723q m19348a() {
        return C4724a.f15263a;
    }

    /* renamed from: a */
    public static void m19349a(Context context, C4732a aVar) {
        if (C4660d.f15179a) {
            C4660d.m19123c(C4723q.class, "init Downloader with params: %s %s", context, aVar);
        }
        if (context != null) {
            C4654c.m19106a(context.getApplicationContext());
            C4629b.m18995a().mo25142a(aVar);
            return;
        }
        throw new IllegalArgumentException("the provided context must not be null!");
    }

    /* renamed from: a */
    public int mo25312a(int i) {
        List<C4585b> c = C4666h.m19171a().mo25232c(i);
        if (c == null || c.isEmpty()) {
            C4660d.m19124d(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        for (C4585b F : c) {
            F.mo24935F().mo24913f();
        }
        return c.size();
    }

    /* renamed from: a */
    public C4583a mo25313a(String str) {
        return new C4607c(str);
    }

    /* renamed from: a */
    public void mo25314a(C4640e eVar) {
        C4648f.m19095a().mo25203a("event.service.connect.changed", (C4647c) eVar);
    }

    /* renamed from: a */
    public boolean mo25315a(int i, String str) {
        mo25312a(i);
        if (!C4677m.m19228a().mo25266c(i)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(C4664f.m19153d(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        return true;
    }

    /* renamed from: b */
    public void mo25316b() {
        if (!mo25317c()) {
            C4677m.m19228a().mo25261a(C4654c.m19105a());
        }
    }

    /* renamed from: c */
    public boolean mo25317c() {
        return C4677m.m19228a().mo25265c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C4742v mo25318d() {
        if (this.f15261b == null) {
            synchronized (f15259a) {
                if (this.f15261b == null) {
                    this.f15261b = new C4594aa();
                }
            }
        }
        return this.f15261b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C4741u mo25319e() {
        if (this.f15262d == null) {
            synchronized (f15260c) {
                if (this.f15262d == null) {
                    this.f15262d = new C4747y();
                    mo25314a((C4640e) this.f15262d);
                }
            }
        }
        return this.f15262d;
    }
}
