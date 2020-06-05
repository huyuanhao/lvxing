package com.qiyukf.basesdk.p394b.p406b.p407a;

import android.util.SparseArray;
import com.qiyukf.basesdk.p394b.p406b.p409c.C5352f;
import com.qiyukf.basesdk.p394b.p406b.p410d.C5357a;
import com.qiyukf.basesdk.p394b.p406b.p411e.C5360a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;

/* renamed from: com.qiyukf.basesdk.b.b.a.k */
public final class C5339k implements C5321a {
    /* renamed from: a */
    private volatile SelectionKey f17268a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C5330g f17269b;
    /* renamed from: c */
    private C5357a f17270c = new C5357a(this);
    /* renamed from: d */
    private C5323c f17271d = new C5323c(this);

    public C5339k(C5352f fVar) {
        this.f17269b = new C5330g(this, fVar);
    }

    /* renamed from: a */
    public final C5323c mo27225a(Object obj) {
        return this.f17269b.mo27255a(obj);
    }

    /* renamed from: a */
    public final C5330g mo27226a() {
        return this.f17269b;
    }

    /* renamed from: a */
    public final void mo27227a(SparseArray<Object> sparseArray) {
        this.f17270c.mo27306a(sparseArray);
        boolean z = false;
        while (true) {
            try {
                this.f17268a = this.f17270c.mo27305a(this.f17269b.mo27262d().mo27288a(), (C5321a) this);
                return;
            } catch (CancelledKeyException e) {
                if (!z) {
                    this.f17269b.mo27262d().mo27292d();
                    z = true;
                } else {
                    throw e;
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo27279a(SelectionKey selectionKey) {
        this.f17268a = selectionKey;
    }

    /* renamed from: b */
    public final C5357a mo27228b() {
        return this.f17270c;
    }

    /* renamed from: c */
    public final C5352f mo27229c() {
        return this.f17269b.mo27262d();
    }

    /* renamed from: d */
    public final boolean mo27230d() {
        return this.f17270c.mo27308a();
    }

    /* renamed from: e */
    public final void mo27231e() {
        this.f17269b.mo27261c();
    }

    /* renamed from: f */
    public final SelectionKey mo27232f() {
        return this.f17268a;
    }

    /* renamed from: g */
    public final void mo27233g() {
        if (this.f17270c.mo27313e()) {
            this.f17269b.mo27262d().execute(new Runnable() {
                public final void run() {
                    C5339k.this.mo27231e();
                }
            });
        } else if (!this.f17271d.mo27239c()) {
            boolean b = this.f17270c.mo27310b();
            try {
                this.f17270c.mo27311c();
                this.f17271d.mo27237b();
                if (b && !this.f17270c.mo27310b()) {
                    C5360a.m22012a(this.f17269b.mo27262d(), new Runnable() {
                        public final void run() {
                            C5339k.this.f17269b.mo27264f();
                        }
                    });
                }
                this.f17268a.cancel();
            } catch (Throwable th) {
                if (b && !this.f17270c.mo27310b()) {
                    C5360a.m22012a(this.f17269b.mo27262d(), new Runnable() {
                        public final void run() {
                            C5339k.this.f17269b.mo27264f();
                        }
                    });
                }
                this.f17268a.cancel();
                throw th;
            }
        }
    }

    /* renamed from: h */
    public final void mo27280h() {
        boolean z = false;
        int i = 0;
        while (true) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(1024);
                int a = this.f17270c.mo27304a(allocate);
                if (a > 0) {
                    this.f17269b.mo27259a(allocate);
                    if (a < 1024) {
                        break;
                    }
                    i++;
                    if (i >= 16) {
                        break;
                    }
                } else if (a < 0) {
                    z = true;
                }
            } catch (Throwable th) {
                this.f17269b.mo27263e();
                this.f17269b.mo27258a(th);
                if (this.f17270c.mo27308a() && (0 != 0 || (th instanceof IOException))) {
                    this.f17269b.mo27261c();
                }
                return;
            }
        }
        this.f17269b.mo27263e();
        if (z && this.f17270c.mo27308a()) {
            this.f17269b.mo27261c();
        }
    }
}
