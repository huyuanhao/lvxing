package com.bumptech.glide.load.model;

import androidx.core.util.Pools.Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.load.model.p */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    /* renamed from: a */
    private final List<ModelLoader<Model, Data>> f4803a;
    /* renamed from: b */
    private final Pool<List<Throwable>> f4804b;

    /* compiled from: MultiModelLoader */
    /* renamed from: com.bumptech.glide.load.model.p$a */
    static class C1728a<Data> implements DataFetcher<Data>, C1623a<Data> {
        /* renamed from: a */
        private final List<DataFetcher<Data>> f4805a;
        /* renamed from: b */
        private final Pool<List<Throwable>> f4806b;
        /* renamed from: c */
        private int f4807c = 0;
        /* renamed from: d */
        private Priority f4808d;
        /* renamed from: e */
        private C1623a<? super Data> f4809e;
        /* renamed from: f */
        private List<Throwable> f4810f;
        /* renamed from: g */
        private boolean f4811g;

        C1728a(List<DataFetcher<Data>> list, Pool<List<Throwable>> pool) {
            this.f4806b = pool;
            Preconditions.m6141a(list);
            this.f4805a = list;
        }

        /* renamed from: a */
        public void mo12626a(Priority priority, C1623a<? super Data> aVar) {
            this.f4808d = priority;
            this.f4809e = aVar;
            this.f4810f = (List) this.f4806b.acquire();
            ((DataFetcher) this.f4805a.get(this.f4807c)).mo12626a(priority, this);
            if (this.f4811g) {
                mo12628c();
            }
        }

        /* renamed from: b */
        public void mo12627b() {
            List<Throwable> list = this.f4810f;
            if (list != null) {
                this.f4806b.release(list);
            }
            this.f4810f = null;
            for (DataFetcher b : this.f4805a) {
                b.mo12627b();
            }
        }

        /* renamed from: c */
        public void mo12628c() {
            this.f4811g = true;
            for (DataFetcher c : this.f4805a) {
                c.mo12628c();
            }
        }

        /* renamed from: a */
        public Class<Data> mo12619a() {
            return ((DataFetcher) this.f4805a.get(0)).mo12619a();
        }

        /* renamed from: d */
        public DataSource mo12629d() {
            return ((DataFetcher) this.f4805a.get(0)).mo12629d();
        }

        /* renamed from: a */
        public void mo12641a(Data data) {
            if (data != null) {
                this.f4809e.mo12641a(data);
            } else {
                m5900e();
            }
        }

        /* renamed from: a */
        public void mo12640a(Exception exc) {
            ((List) Preconditions.m6138a(this.f4810f)).add(exc);
            m5900e();
        }

        /* renamed from: e */
        private void m5900e() {
            if (!this.f4811g) {
                if (this.f4807c < this.f4805a.size() - 1) {
                    this.f4807c++;
                    mo12626a(this.f4808d, this.f4809e);
                } else {
                    Preconditions.m6138a(this.f4810f);
                    this.f4809e.mo12640a((Exception) new GlideException("Fetch failed", (List<Throwable>) new ArrayList<Throwable>(this.f4810f)));
                }
            }
        }
    }

    MultiModelLoader(List<ModelLoader<Model, Data>> list, Pool<List<Throwable>> pool) {
        this.f4803a = list;
        this.f4804b = pool;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(Model model, int i, int i2, Options fVar) {
        int size = this.f4803a.size();
        ArrayList arrayList = new ArrayList(size);
        Key cVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader mVar = (ModelLoader) this.f4803a.get(i3);
            if (mVar.mo12928a(model)) {
                C1725a a = mVar.mo12926a(model, i, i2, fVar);
                if (a != null) {
                    cVar = a.f4796a;
                    arrayList.add(a.f4798c);
                }
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new C1725a<>(cVar, new C1728a(arrayList, this.f4804b));
    }

    /* renamed from: a */
    public boolean mo12928a(Model model) {
        for (ModelLoader a : this.f4803a) {
            if (a.mo12928a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiModelLoader{modelLoaders=");
        sb.append(Arrays.toString(this.f4803a.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
