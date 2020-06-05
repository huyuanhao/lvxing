package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DataFetcherGenerator.C1668a;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.c */
class DataCacheGenerator implements C1623a<Object>, DataFetcherGenerator {
    /* renamed from: a */
    private final List<Key> f4506a;
    /* renamed from: b */
    private final DecodeHelper<?> f4507b;
    /* renamed from: c */
    private final C1668a f4508c;
    /* renamed from: d */
    private int f4509d;
    /* renamed from: e */
    private Key f4510e;
    /* renamed from: f */
    private List<ModelLoader<File, ?>> f4511f;
    /* renamed from: g */
    private int f4512g;
    /* renamed from: h */
    private volatile C1725a<?> f4513h;
    /* renamed from: i */
    private File f4514i;

    DataCacheGenerator(DecodeHelper<?> gVar, C1668a aVar) {
        this(gVar.mo12832o(), gVar, aVar);
    }

    DataCacheGenerator(List<Key> list, DecodeHelper<?> gVar, C1668a aVar) {
        this.f4509d = -1;
        this.f4506a = list;
        this.f4507b = gVar;
        this.f4508c = aVar;
    }

    /* renamed from: a */
    public boolean mo12776a() {
        while (true) {
            boolean z = false;
            if (this.f4511f == null || !m5520c()) {
                this.f4509d++;
                if (this.f4509d >= this.f4506a.size()) {
                    return false;
                }
                Key cVar = (Key) this.f4506a.get(this.f4509d);
                this.f4514i = this.f4507b.mo12816b().mo12785a(new DataCacheKey(cVar, this.f4507b.mo12823f()));
                File file = this.f4514i;
                if (file != null) {
                    this.f4510e = cVar;
                    this.f4511f = this.f4507b.mo12810a(file);
                    this.f4512g = 0;
                }
            } else {
                this.f4513h = null;
                while (!z && m5520c()) {
                    List<ModelLoader<File, ?>> list = this.f4511f;
                    int i = this.f4512g;
                    this.f4512g = i + 1;
                    this.f4513h = ((ModelLoader) list.get(i)).mo12926a(this.f4514i, this.f4507b.mo12824g(), this.f4507b.mo12825h(), this.f4507b.mo12822e());
                    if (this.f4513h != null && this.f4507b.mo12815a(this.f4513h.f4798c.mo12619a())) {
                        this.f4513h.f4798c.mo12626a(this.f4507b.mo12821d(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    /* renamed from: c */
    private boolean m5520c() {
        return this.f4512g < this.f4511f.size();
    }

    /* renamed from: b */
    public void mo12777b() {
        C1725a<?> aVar = this.f4513h;
        if (aVar != null) {
            aVar.f4798c.mo12628c();
        }
    }

    /* renamed from: a */
    public void mo12641a(Object obj) {
        this.f4508c.mo12807a(this.f4510e, obj, this.f4513h.f4798c, DataSource.DATA_DISK_CACHE, this.f4510e);
    }

    /* renamed from: a */
    public void mo12640a(Exception exc) {
        this.f4508c.mo12806a(this.f4510e, exc, this.f4513h.f4798c, DataSource.DATA_DISK_CACHE);
    }
}
