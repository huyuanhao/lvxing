package com.bumptech.glide.p131c;

/* renamed from: com.bumptech.glide.c.i */
public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
    /* renamed from: a */
    private final RequestCoordinator f4255a;
    /* renamed from: b */
    private Request f4256b;
    /* renamed from: c */
    private Request f4257c;
    /* renamed from: d */
    private boolean f4258d;

    ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(RequestCoordinator dVar) {
        this.f4255a = dVar;
    }

    /* renamed from: a */
    public void mo12522a(Request cVar, Request cVar2) {
        this.f4256b = cVar;
        this.f4257c = cVar2;
    }

    /* renamed from: b */
    public boolean mo12494b(Request cVar) {
        return m5144j() && (cVar.equals(this.f4256b) || !this.f4256b.mo12499e());
    }

    /* renamed from: j */
    private boolean m5144j() {
        RequestCoordinator dVar = this.f4255a;
        return dVar == null || dVar.mo12494b(this);
    }

    /* renamed from: c */
    public boolean mo12496c(Request cVar) {
        return m5146l() && cVar.equals(this.f4256b) && !mo12505i();
    }

    /* renamed from: d */
    public boolean mo12497d(Request cVar) {
        return m5145k() && cVar.equals(this.f4256b);
    }

    /* renamed from: k */
    private boolean m5145k() {
        RequestCoordinator dVar = this.f4255a;
        return dVar == null || dVar.mo12497d(this);
    }

    /* renamed from: l */
    private boolean m5146l() {
        RequestCoordinator dVar = this.f4255a;
        return dVar == null || dVar.mo12496c(this);
    }

    /* renamed from: i */
    public boolean mo12505i() {
        return m5147m() || mo12499e();
    }

    /* renamed from: e */
    public void mo12498e(Request cVar) {
        if (!cVar.equals(this.f4257c)) {
            RequestCoordinator dVar = this.f4255a;
            if (dVar != null) {
                dVar.mo12498e(this);
            }
            if (!this.f4257c.mo12504h_()) {
                this.f4257c.mo12493b();
            }
        }
    }

    /* renamed from: f */
    public void mo12500f(Request cVar) {
        if (cVar.equals(this.f4256b)) {
            RequestCoordinator dVar = this.f4255a;
            if (dVar != null) {
                dVar.mo12500f(this);
            }
        }
    }

    /* renamed from: m */
    private boolean m5147m() {
        RequestCoordinator dVar = this.f4255a;
        return dVar != null && dVar.mo12505i();
    }

    /* renamed from: a */
    public void mo12490a() {
        this.f4258d = true;
        if (!this.f4256b.mo12504h_() && !this.f4257c.mo12495c()) {
            this.f4257c.mo12490a();
        }
        if (this.f4258d && !this.f4256b.mo12495c()) {
            this.f4256b.mo12490a();
        }
    }

    /* renamed from: b */
    public void mo12493b() {
        this.f4258d = false;
        this.f4257c.mo12493b();
        this.f4256b.mo12493b();
    }

    /* renamed from: c */
    public boolean mo12495c() {
        return this.f4256b.mo12495c();
    }

    /* renamed from: h_ */
    public boolean mo12504h_() {
        return this.f4256b.mo12504h_() || this.f4257c.mo12504h_();
    }

    /* renamed from: e */
    public boolean mo12499e() {
        return this.f4256b.mo12499e() || this.f4257c.mo12499e();
    }

    /* renamed from: f */
    public boolean mo12501f() {
        return this.f4256b.mo12501f();
    }

    /* renamed from: g */
    public boolean mo12502g() {
        return this.f4256b.mo12502g();
    }

    /* renamed from: h */
    public void mo12503h() {
        this.f4256b.mo12503h();
        this.f4257c.mo12503h();
    }

    /* renamed from: a */
    public boolean mo12492a(Request cVar) {
        if (!(cVar instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator iVar = (ThumbnailRequestCoordinator) cVar;
        Request cVar2 = this.f4256b;
        if (cVar2 == null) {
            if (iVar.f4256b != null) {
                return false;
            }
        } else if (!cVar2.mo12492a(iVar.f4256b)) {
            return false;
        }
        Request cVar3 = this.f4257c;
        Request cVar4 = iVar.f4257c;
        if (cVar3 == null) {
            if (cVar4 != null) {
                return false;
            }
        } else if (!cVar3.mo12492a(cVar4)) {
            return false;
        }
        return true;
    }
}
