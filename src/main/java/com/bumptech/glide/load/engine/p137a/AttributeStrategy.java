package com.bumptech.glide.load.engine.p137a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.C1772j;

/* renamed from: com.bumptech.glide.load.engine.a.c */
class AttributeStrategy implements LruPoolStrategy {
    /* renamed from: a */
    private final C1639b f4448a = new C1639b();
    /* renamed from: b */
    private final GroupedLinkedMap<C1638a, Bitmap> f4449b = new GroupedLinkedMap<>();

    /* compiled from: AttributeStrategy */
    /* renamed from: com.bumptech.glide.load.engine.a.c$a */
    static class C1638a implements Poolable {
        /* renamed from: a */
        private final C1639b f4450a;
        /* renamed from: b */
        private int f4451b;
        /* renamed from: c */
        private int f4452c;
        /* renamed from: d */
        private Config f4453d;

        public C1638a(C1639b bVar) {
            this.f4450a = bVar;
        }

        /* renamed from: a */
        public void mo12715a(int i, int i2, Config config) {
            this.f4451b = i;
            this.f4452c = i2;
            this.f4453d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1638a)) {
                return false;
            }
            C1638a aVar = (C1638a) obj;
            if (this.f4451b == aVar.f4451b && this.f4452c == aVar.f4452c && this.f4453d == aVar.f4453d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f4451b * 31) + this.f4452c) * 31;
            Config config = this.f4453d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.m5408c(this.f4451b, this.f4452c, this.f4453d);
        }

        /* renamed from: a */
        public void mo12714a() {
            this.f4450a.mo12722a(this);
        }
    }

    /* compiled from: AttributeStrategy */
    /* renamed from: com.bumptech.glide.load.engine.a.c$b */
    static class C1639b extends BaseKeyPool<C1638a> {
        C1639b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1638a mo12720a(int i, int i2, Config config) {
            C1638a aVar = (C1638a) mo12723c();
            aVar.mo12715a(i, i2, config);
            return aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C1638a mo12721b() {
            return new C1638a(this);
        }
    }

    AttributeStrategy() {
    }

    /* renamed from: a */
    public void mo12709a(Bitmap bitmap) {
        this.f4449b.mo12735a(this.f4448a.mo12720a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    /* renamed from: a */
    public Bitmap mo12708a(int i, int i2, Config config) {
        return (Bitmap) this.f4449b.mo12734a(this.f4448a.mo12720a(i, i2, config));
    }

    /* renamed from: a */
    public Bitmap mo12707a() {
        return (Bitmap) this.f4449b.mo12733a();
    }

    /* renamed from: b */
    public String mo12711b(Bitmap bitmap) {
        return m5409d(bitmap);
    }

    /* renamed from: b */
    public String mo12710b(int i, int i2, Config config) {
        return m5408c(i, i2, config);
    }

    /* renamed from: c */
    public int mo12712c(Bitmap bitmap) {
        return C1772j.m6147a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeStrategy:\n  ");
        sb.append(this.f4449b);
        return sb.toString();
    }

    /* renamed from: d */
    private static String m5409d(Bitmap bitmap) {
        return m5408c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    /* renamed from: c */
    static String m5408c(int i, int i2, Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append("], ");
        sb.append(config);
        return sb.toString();
    }
}
