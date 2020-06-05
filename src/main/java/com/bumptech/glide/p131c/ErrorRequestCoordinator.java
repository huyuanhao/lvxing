package com.bumptech.glide.p131c;

/* renamed from: com.bumptech.glide.c.b */
public final class ErrorRequestCoordinator implements Request, RequestCoordinator {
    /* renamed from: a */
    private final RequestCoordinator f4202a;
    /* renamed from: b */
    private Request f4203b;
    /* renamed from: c */
    private Request f4204c;

    public ErrorRequestCoordinator(RequestCoordinator dVar) {
        this.f4202a = dVar;
    }

    /* renamed from: a */
    public void mo12491a(Request cVar, Request cVar2) {
        this.f4203b = cVar;
        this.f4204c = cVar2;
    }

    /* renamed from: a */
    public void mo12490a() {
        if (!this.f4203b.mo12495c()) {
            this.f4203b.mo12490a();
        }
    }

    /* renamed from: b */
    public void mo12493b() {
        this.f4203b.mo12493b();
        if (this.f4204c.mo12495c()) {
            this.f4204c.mo12493b();
        }
    }

    /* renamed from: c */
    public boolean mo12495c() {
        return (this.f4203b.mo12502g() ? this.f4204c : this.f4203b).mo12495c();
    }

    /* renamed from: h_ */
    public boolean mo12504h_() {
        return (this.f4203b.mo12502g() ? this.f4204c : this.f4203b).mo12504h_();
    }

    /* renamed from: e */
    public boolean mo12499e() {
        return (this.f4203b.mo12502g() ? this.f4204c : this.f4203b).mo12499e();
    }

    /* renamed from: f */
    public boolean mo12501f() {
        return (this.f4203b.mo12502g() ? this.f4204c : this.f4203b).mo12501f();
    }

    /* renamed from: g */
    public boolean mo12502g() {
        return this.f4203b.mo12502g() && this.f4204c.mo12502g();
    }

    /* renamed from: h */
    public void mo12503h() {
        this.f4203b.mo12503h();
        this.f4204c.mo12503h();
    }

    /* renamed from: a */
    public boolean mo12492a(Request cVar) {
        if (!(cVar instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator bVar = (ErrorRequestCoordinator) cVar;
        if (!this.f4203b.mo12492a(bVar.f4203b) || !this.f4204c.mo12492a(bVar.f4204c)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo12494b(Request cVar) {
        return m5040j() && m5039g(cVar);
    }

    /* renamed from: j */
    private boolean m5040j() {
        RequestCoordinator dVar = this.f4202a;
        return dVar == null || dVar.mo12494b(this);
    }

    /* renamed from: c */
    public boolean mo12496c(Request cVar) {
        return m5042l() && m5039g(cVar);
    }

    /* renamed from: d */
    public boolean mo12497d(Request cVar) {
        return m5041k() && m5039g(cVar);
    }

    /* renamed from: k */
    private boolean m5041k() {
        RequestCoordinator dVar = this.f4202a;
        return dVar == null || dVar.mo12497d(this);
    }

    /* renamed from: l */
    private boolean m5042l() {
        RequestCoordinator dVar = this.f4202a;
        return dVar == null || dVar.mo12496c(this);
    }

    /* renamed from: g */
    private boolean m5039g(Request cVar) {
        return cVar.equals(this.f4203b) || (this.f4203b.mo12502g() && cVar.equals(this.f4204c));
    }

    /* renamed from: i */
    public boolean mo12505i() {
        return m5043m() || mo12499e();
    }

    /* renamed from: m */
    private boolean m5043m() {
        RequestCoordinator dVar = this.f4202a;
        return dVar != null && dVar.mo12505i();
    }

    /* renamed from: e */
    public void mo12498e(Request cVar) {
        RequestCoordinator dVar = this.f4202a;
        if (dVar != null) {
            dVar.mo12498e(this);
        }
    }

    /* renamed from: f */
    public void mo12500f(Request cVar) {
        if (!cVar.equals(this.f4204c)) {
            if (!this.f4204c.mo12495c()) {
                this.f4204c.mo12490a();
            }
            return;
        }
        RequestCoordinator dVar = this.f4202a;
        if (dVar != null) {
            dVar.mo12500f(this);
        }
    }
}
