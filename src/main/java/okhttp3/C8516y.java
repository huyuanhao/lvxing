package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.C8402b;
import okhttp3.internal.connection.C8428a;
import okhttp3.internal.p697a.C8389a;
import okhttp3.internal.p698b.C8403a;
import okhttp3.internal.p698b.C8404b;
import okhttp3.internal.p698b.C8411g;
import okhttp3.internal.p698b.C8414j;
import okhttp3.internal.p701e.C8447f;

/* compiled from: RealCall */
/* renamed from: okhttp3.y */
final class C8516y implements C8379e {
    /* renamed from: a */
    final C8513x f28985a;
    /* renamed from: b */
    final C8414j f28986b;
    /* renamed from: c */
    final C8518z f28987c;
    /* renamed from: d */
    final boolean f28988d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C8498p f28989e;
    /* renamed from: f */
    private boolean f28990f;

    /* compiled from: RealCall */
    /* renamed from: okhttp3.y$a */
    final class C8517a extends C8402b {
        /* renamed from: c */
        private final C8381f f28992c;

        C8517a(C8381f fVar) {
            super("OkHttp %s", C8516y.this.mo40640f());
            this.f28992c = fVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo40642a() {
            return C8516y.this.f28987c.mo40645a().mo40556f();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C8516y mo40643b() {
            return C8516y.this;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x003d A[SYNTHETIC, Splitter:B:13:0x003d] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005d A[Catch:{ all -> 0x0036 }] */
        /* renamed from: c */
        public void mo40233c() {
            /*
            r5 = this;
            r0 = 1
            r1 = 0
            okhttp3.y r2 = okhttp3.C8516y.this     // Catch:{ IOException -> 0x0038 }
            okhttp3.ab r2 = r2.mo40641g()     // Catch:{ IOException -> 0x0038 }
            okhttp3.y r3 = okhttp3.C8516y.this     // Catch:{ IOException -> 0x0038 }
            okhttp3.internal.b.j r3 = r3.f28986b     // Catch:{ IOException -> 0x0038 }
            boolean r1 = r3.mo40257b()     // Catch:{ IOException -> 0x0038 }
            if (r1 == 0) goto L_0x0021
            okhttp3.f r1 = r5.f28992c     // Catch:{ IOException -> 0x0034 }
            okhttp3.y r2 = okhttp3.C8516y.this     // Catch:{ IOException -> 0x0034 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0034 }
            java.lang.String r4 = "Canceled"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0034 }
            r1.mo20008a(r2, r3)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0028
        L_0x0021:
            okhttp3.f r1 = r5.f28992c     // Catch:{ IOException -> 0x0034 }
            okhttp3.y r3 = okhttp3.C8516y.this     // Catch:{ IOException -> 0x0034 }
            r1.mo20009a(r3, r2)     // Catch:{ IOException -> 0x0034 }
        L_0x0028:
            okhttp3.y r0 = okhttp3.C8516y.this
            okhttp3.x r0 = r0.f28985a
            okhttp3.n r0 = r0.mo40616t()
            r0.mo40493b(r5)
            goto L_0x0070
        L_0x0034:
            r1 = move-exception
            goto L_0x003b
        L_0x0036:
            r0 = move-exception
            goto L_0x0071
        L_0x0038:
            r0 = move-exception
            r1 = r0
            r0 = 0
        L_0x003b:
            if (r0 == 0) goto L_0x005d
            okhttp3.internal.e.f r0 = okhttp3.internal.p701e.C8447f.m36198c()     // Catch:{ all -> 0x0036 }
            r2 = 4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r3.<init>()     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = "Callback failure for "
            r3.append(r4)     // Catch:{ all -> 0x0036 }
            okhttp3.y r4 = okhttp3.C8516y.this     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = r4.mo40639e()     // Catch:{ all -> 0x0036 }
            r3.append(r4)     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0036 }
            r0.mo40323a(r2, r3, r1)     // Catch:{ all -> 0x0036 }
            goto L_0x0028
        L_0x005d:
            okhttp3.y r0 = okhttp3.C8516y.this     // Catch:{ all -> 0x0036 }
            okhttp3.p r0 = r0.f28989e     // Catch:{ all -> 0x0036 }
            okhttp3.y r2 = okhttp3.C8516y.this     // Catch:{ all -> 0x0036 }
            r0.mo40498a(r2, r1)     // Catch:{ all -> 0x0036 }
            okhttp3.f r0 = r5.f28992c     // Catch:{ all -> 0x0036 }
            okhttp3.y r2 = okhttp3.C8516y.this     // Catch:{ all -> 0x0036 }
            r0.mo20008a(r2, r1)     // Catch:{ all -> 0x0036 }
            goto L_0x0028
        L_0x0070:
            return
        L_0x0071:
            okhttp3.y r1 = okhttp3.C8516y.this
            okhttp3.x r1 = r1.f28985a
            okhttp3.n r1 = r1.mo40616t()
            r1.mo40493b(r5)
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.C8516y.C8517a.mo40233c():void");
        }
    }

    private C8516y(C8513x xVar, C8518z zVar, boolean z) {
        this.f28985a = xVar;
        this.f28987c = zVar;
        this.f28988d = z;
        this.f28986b = new C8414j(xVar, z);
    }

    /* renamed from: a */
    static C8516y m36664a(C8513x xVar, C8518z zVar, boolean z) {
        C8516y yVar = new C8516y(xVar, zVar, z);
        yVar.f28989e = xVar.mo40621y().mo40516a(yVar);
        return yVar;
    }

    /* renamed from: a */
    public C8362ab mo40173a() throws IOException {
        synchronized (this) {
            if (!this.f28990f) {
                this.f28990f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m36665h();
        this.f28989e.mo40496a((C8379e) this);
        try {
            this.f28985a.mo40616t().mo40491a(this);
            C8362ab g = mo40641g();
            if (g != null) {
                this.f28985a.mo40616t().mo40494b(this);
                return g;
            }
            throw new IOException("Canceled");
        } catch (IOException e) {
            this.f28989e.mo40498a((C8379e) this, e);
            throw e;
        } catch (Throwable th) {
            this.f28985a.mo40616t().mo40494b(this);
            throw th;
        }
    }

    /* renamed from: h */
    private void m36665h() {
        this.f28986b.mo40256a(C8447f.m36198c().mo40320a("response.body().close()"));
    }

    /* renamed from: a */
    public void mo40174a(C8381f fVar) {
        synchronized (this) {
            if (!this.f28990f) {
                this.f28990f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        m36665h();
        this.f28989e.mo40496a((C8379e) this);
        this.f28985a.mo40616t().mo40490a(new C8517a(fVar));
    }

    /* renamed from: b */
    public void mo40175b() {
        this.f28986b.mo40255a();
    }

    /* renamed from: c */
    public boolean mo40176c() {
        return this.f28986b.mo40257b();
    }

    /* renamed from: d */
    public C8516y clone() {
        return m36664a(this.f28985a, this.f28987c, this.f28988d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo40639e() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo40176c() ? "canceled " : "");
        sb.append(this.f28988d ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(mo40640f());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public String mo40640f() {
        return this.f28987c.mo40645a().mo40567p();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public C8362ab mo40641g() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f28985a.mo40619w());
        arrayList.add(this.f28986b);
        arrayList.add(new C8403a(this.f28985a.mo40603g()));
        arrayList.add(new C8389a(this.f28985a.mo40604h()));
        arrayList.add(new C8428a(this.f28985a));
        if (!this.f28988d) {
            arrayList.addAll(this.f28985a.mo40620x());
        }
        arrayList.add(new C8404b(this.f28988d));
        C8411g gVar = new C8411g(arrayList, null, null, null, 0, this.f28987c, this, this.f28989e, this.f28985a.mo40597a(), this.f28985a.mo40598b(), this.f28985a.mo40599c());
        return gVar.mo40244a(this.f28987c);
    }
}
