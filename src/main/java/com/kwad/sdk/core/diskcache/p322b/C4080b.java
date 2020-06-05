package com.kwad.sdk.core.diskcache.p322b;

import android.content.Context;
import java.io.File;

/* renamed from: com.kwad.sdk.core.diskcache.b.b */
public class C4080b {
    /* renamed from: a */
    Context f13723a;
    /* renamed from: b */
    int f13724b;
    /* renamed from: c */
    long f13725c;
    /* renamed from: d */
    File f13726d;

    /* renamed from: com.kwad.sdk.core.diskcache.b.b$a */
    public static class C4082a {
        /* renamed from: a */
        private Context f13727a;
        /* renamed from: b */
        private int f13728b = 1;
        /* renamed from: c */
        private long f13729c = 100;
        /* renamed from: d */
        private File f13730d;

        public C4082a(Context context) {
            this.f13727a = context.getApplicationContext();
        }

        /* renamed from: a */
        public C4082a mo23764a(int i) {
            if (i > 0) {
                this.f13728b = i;
                return this;
            }
            throw new IllegalArgumentException("appVersion <= 0");
        }

        /* renamed from: a */
        public C4082a mo23765a(long j) {
            if (j > 0) {
                this.f13729c = j;
                return this;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }

        /* renamed from: a */
        public C4082a mo23766a(File file) {
            C4085d.m16966a(file, "directory is not allow null");
            this.f13730d = file;
            return this;
        }

        /* renamed from: a */
        public C4080b mo23767a() {
            C4080b bVar = new C4080b();
            bVar.f13723a = this.f13727a;
            bVar.f13724b = this.f13728b;
            bVar.f13725c = this.f13729c;
            bVar.f13726d = this.f13730d;
            return bVar;
        }
    }

    private C4080b() {
    }
}
