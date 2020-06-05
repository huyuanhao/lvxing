package com.kwai.filedownloader.services;

import com.kwai.filedownloader.p353a.C4588a;
import com.kwai.filedownloader.p353a.C4590c.C4592b;
import com.kwai.filedownloader.p354b.C4596a;
import com.kwai.filedownloader.p354b.C4601c;
import com.kwai.filedownloader.p357e.C4642b.C4643a;
import com.kwai.filedownloader.p358f.C4654c.C4655a;
import com.kwai.filedownloader.p358f.C4654c.C4656b;
import com.kwai.filedownloader.p358f.C4654c.C4657c;
import com.kwai.filedownloader.p358f.C4654c.C4658d;
import com.kwai.filedownloader.p358f.C4654c.C4659e;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4661e;
import com.kwai.filedownloader.p358f.C4664f;

/* renamed from: com.kwai.filedownloader.services.c */
public class C4731c {
    /* renamed from: a */
    private final C4732a f15271a;

    /* renamed from: com.kwai.filedownloader.services.c$a */
    public static class C4732a {
        /* renamed from: a */
        C4657c f15272a;
        /* renamed from: b */
        Integer f15273b;
        /* renamed from: c */
        C4659e f15274c;
        /* renamed from: d */
        C4656b f15275d;
        /* renamed from: e */
        C4655a f15276e;
        /* renamed from: f */
        C4658d f15277f;

        /* renamed from: a */
        public C4732a mo25334a(int i) {
            if (i > 0) {
                this.f15273b = Integer.valueOf(i);
            }
            return this;
        }

        /* renamed from: a */
        public C4732a mo25335a(C4656b bVar) {
            this.f15275d = bVar;
            return this;
        }

        public String toString() {
            return C4664f.m19135a("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.f15272a, this.f15273b, this.f15274c, this.f15275d, this.f15276e);
        }
    }

    public C4731c() {
        this.f15271a = null;
    }

    public C4731c(C4732a aVar) {
        this.f15271a = aVar;
    }

    /* renamed from: g */
    private C4658d m19391g() {
        return new C4730b();
    }

    /* renamed from: h */
    private int m19392h() {
        return C4661e.m19127a().f15184e;
    }

    /* renamed from: i */
    private C4596a m19393i() {
        return new C4601c();
    }

    /* renamed from: j */
    private C4659e m19394j() {
        return new C4643a();
    }

    /* renamed from: k */
    private C4656b m19395k() {
        return new C4592b();
    }

    /* renamed from: l */
    private C4655a m19396l() {
        return new C4588a();
    }

    /* renamed from: a */
    public int mo25328a() {
        C4732a aVar = this.f15271a;
        if (aVar == null) {
            return m19392h();
        }
        Integer num = aVar.f15273b;
        if (num == null) {
            return m19392h();
        }
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
        }
        return C4661e.m19126a(num.intValue());
    }

    /* renamed from: b */
    public C4596a mo25329b() {
        C4732a aVar = this.f15271a;
        if (aVar == null || aVar.f15272a == null) {
            return m19393i();
        }
        C4596a a = this.f15271a.f15272a.mo25217a();
        if (a == null) {
            return m19393i();
        }
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "initial FileDownloader manager with the customize database: %s", a);
        }
        return a;
    }

    /* renamed from: c */
    public C4659e mo25330c() {
        C4732a aVar = this.f15271a;
        if (aVar == null) {
            return m19394j();
        }
        C4659e eVar = aVar.f15274c;
        if (eVar == null) {
            return m19394j();
        }
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "initial FileDownloader manager with the customize output stream: %s", eVar);
        }
        return eVar;
    }

    /* renamed from: d */
    public C4656b mo25331d() {
        C4732a aVar = this.f15271a;
        if (aVar == null) {
            return m19395k();
        }
        C4656b bVar = aVar.f15275d;
        if (bVar == null) {
            return m19395k();
        }
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "initial FileDownloader manager with the customize connection creator: %s", bVar);
        }
        return bVar;
    }

    /* renamed from: e */
    public C4655a mo25332e() {
        C4732a aVar = this.f15271a;
        if (aVar == null) {
            return m19396l();
        }
        C4655a aVar2 = aVar.f15276e;
        if (aVar2 == null) {
            return m19396l();
        }
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "initial FileDownloader manager with the customize connection count adapter: %s", aVar2);
        }
        return aVar2;
    }

    /* renamed from: f */
    public C4658d mo25333f() {
        C4732a aVar = this.f15271a;
        if (aVar == null) {
            return m19391g();
        }
        C4658d dVar = aVar.f15277f;
        if (dVar == null) {
            return m19391g();
        }
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "initial FileDownloader manager with the customize id generator: %s", dVar);
        }
        return dVar;
    }
}
