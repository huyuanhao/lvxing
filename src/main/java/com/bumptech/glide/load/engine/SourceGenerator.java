package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DataFetcherGenerator.C1668a;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.y */
class SourceGenerator implements C1623a<Object>, DataFetcherGenerator, C1668a {
    /* renamed from: a */
    private final DecodeHelper<?> f4738a;
    /* renamed from: b */
    private final C1668a f4739b;
    /* renamed from: c */
    private int f4740c;
    /* renamed from: d */
    private DataCacheGenerator f4741d;
    /* renamed from: e */
    private Object f4742e;
    /* renamed from: f */
    private volatile C1725a<?> f4743f;
    /* renamed from: g */
    private DataCacheKey f4744g;

    SourceGenerator(DecodeHelper<?> gVar, C1668a aVar) {
        this.f4738a = gVar;
        this.f4739b = aVar;
    }

    /* renamed from: a */
    public boolean mo12776a() {
        Object obj = this.f4742e;
        if (obj != null) {
            this.f4742e = null;
            m5751b(obj);
        }
        DataCacheGenerator cVar = this.f4741d;
        if (cVar != null && cVar.mo12776a()) {
            return true;
        }
        this.f4741d = null;
        this.f4743f = null;
        boolean z = false;
        while (!z && m5752d()) {
            List n = this.f4738a.mo12831n();
            int i = this.f4740c;
            this.f4740c = i + 1;
            this.f4743f = (C1725a) n.get(i);
            if (this.f4743f != null && (this.f4738a.mo12819c().mo12857a(this.f4743f.f4798c.mo12629d()) || this.f4738a.mo12815a(this.f4743f.f4798c.mo12619a()))) {
                this.f4743f.f4798c.mo12626a(this.f4738a.mo12821d(), this);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: d */
    private boolean m5752d() {
        return this.f4740c < this.f4738a.mo12831n().size();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    private void m5751b(Object obj) {
        String str = "SourceGenerator";
        long a = LogTime.m6125a();
        try {
            Encoder a2 = this.f4738a.mo12809a(obj);
            DataCacheWriter eVar = new DataCacheWriter(a2, obj, this.f4738a.mo12822e());
            this.f4744g = new DataCacheKey(this.f4743f.f4796a, this.f4738a.mo12823f());
            this.f4738a.mo12816b().mo12786a(this.f4744g, eVar);
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Finished encoding source to cache, key: ");
                sb.append(this.f4744g);
                sb.append(", data: ");
                sb.append(obj);
                sb.append(", encoder: ");
                sb.append(a2);
                sb.append(", duration: ");
                sb.append(LogTime.m6124a(a));
                Log.v(str, sb.toString());
            }
            this.f4743f.f4798c.mo12627b();
            this.f4741d = new DataCacheGenerator(Collections.singletonList(this.f4743f.f4796a), this.f4738a, this);
        } catch (Throwable th) {
            this.f4743f.f4798c.mo12627b();
            throw th;
        }
    }

    /* renamed from: b */
    public void mo12777b() {
        C1725a<?> aVar = this.f4743f;
        if (aVar != null) {
            aVar.f4798c.mo12628c();
        }
    }

    /* renamed from: a */
    public void mo12641a(Object obj) {
        DiskCacheStrategy c = this.f4738a.mo12819c();
        if (obj == null || !c.mo12857a(this.f4743f.f4798c.mo12629d())) {
            this.f4739b.mo12807a(this.f4743f.f4796a, obj, this.f4743f.f4798c, this.f4743f.f4798c.mo12629d(), this.f4744g);
            return;
        }
        this.f4742e = obj;
        this.f4739b.mo12808c();
    }

    /* renamed from: a */
    public void mo12640a(Exception exc) {
        this.f4739b.mo12806a(this.f4744g, exc, this.f4743f.f4798c, this.f4743f.f4798c.mo12629d());
    }

    /* renamed from: c */
    public void mo12808c() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo12807a(Key cVar, Object obj, DataFetcher<?> dVar, DataSource dataSource, Key cVar2) {
        this.f4739b.mo12807a(cVar, obj, dVar, this.f4743f.f4798c.mo12629d(), cVar);
    }

    /* renamed from: a */
    public void mo12806a(Key cVar, Exception exc, DataFetcher<?> dVar, DataSource dataSource) {
        this.f4739b.mo12806a(cVar, exc, dVar, this.f4743f.f4798c.mo12629d());
    }
}
