package com.p530ss.android.socialbase.downloader.p564i.p565a;

import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.i.a.a */
public class DownloadConnectionPool {
    /* renamed from: a */
    protected int f22124a;
    /* renamed from: b */
    private final Map<String, FakeDownloadHeadHttpConnection> f22125b;
    /* renamed from: c */
    private final Map<String, FakeDownloadHttpConnection> f22126c;

    /* compiled from: DownloadConnectionPool */
    /* renamed from: com.ss.android.socialbase.downloader.i.a.a$a */
    private static final class C6716a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final DownloadConnectionPool f22127a = new DownloadConnectionPool();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo32454a(int i) {
        this.f22124a = i;
    }

    /* renamed from: a */
    public FakeDownloadHeadHttpConnection mo32453a(String str, List<HttpHeader> list) {
        FakeDownloadHeadHttpConnection cVar;
        synchronized (this.f22125b) {
            cVar = (FakeDownloadHeadHttpConnection) this.f22125b.remove(str);
        }
        if (cVar != null) {
            if (DownloadUtils.m28781a(cVar.mo32460f(), list)) {
                try {
                    cVar.mo32457a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (cVar.mo32459e() && cVar.mo32458d()) {
                    return cVar;
                }
            }
            try {
                cVar.mo16502c();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public FakeDownloadHttpConnection mo32455b(String str, List<HttpHeader> list) {
        FakeDownloadHttpConnection dVar;
        synchronized (this.f22126c) {
            dVar = (FakeDownloadHttpConnection) this.f22126c.remove(str);
        }
        if (dVar != null) {
            if (DownloadUtils.m28781a(dVar.mo32463f(), list)) {
                try {
                    dVar.mo32462e();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (dVar.mo32465h() && dVar.mo32464g()) {
                    return dVar;
                }
            }
            try {
                dVar.mo16503d();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static DownloadConnectionPool m28187a() {
        return C6716a.f22127a;
    }

    private DownloadConnectionPool() {
        this.f22125b = new HashMap();
        this.f22126c = new LinkedHashMap(3);
        this.f22124a = 3;
    }
}
