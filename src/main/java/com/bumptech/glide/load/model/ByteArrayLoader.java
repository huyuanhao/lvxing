package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.p134d.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.b */
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {
    /* renamed from: a */
    private final C1703b<Data> f4756a;

    /* compiled from: ByteArrayLoader */
    /* renamed from: com.bumptech.glide.load.model.b$a */
    public static class C1701a implements ModelLoaderFactory<byte[], ByteBuffer> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<byte[], ByteBuffer> mo12929a(MultiModelLoaderFactory qVar) {
            return new ByteArrayLoader(new C1703b<ByteBuffer>() {
                /* renamed from: a */
                public ByteBuffer mo12938b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }

                /* renamed from: a */
                public Class<ByteBuffer> mo12936a() {
                    return ByteBuffer.class;
                }
            });
        }
    }

    /* compiled from: ByteArrayLoader */
    /* renamed from: com.bumptech.glide.load.model.b$b */
    public interface C1703b<Data> {
        /* renamed from: a */
        Class<Data> mo12936a();

        /* renamed from: b */
        Data mo12938b(byte[] bArr);
    }

    /* compiled from: ByteArrayLoader */
    /* renamed from: com.bumptech.glide.load.model.b$c */
    private static class C1704c<Data> implements DataFetcher<Data> {
        /* renamed from: a */
        private final byte[] f4758a;
        /* renamed from: b */
        private final C1703b<Data> f4759b;

        /* renamed from: b */
        public void mo12627b() {
        }

        /* renamed from: c */
        public void mo12628c() {
        }

        C1704c(byte[] bArr, C1703b<Data> bVar) {
            this.f4758a = bArr;
            this.f4759b = bVar;
        }

        /* renamed from: a */
        public void mo12626a(Priority priority, C1623a<? super Data> aVar) {
            aVar.mo12641a(this.f4759b.mo12938b(this.f4758a));
        }

        /* renamed from: a */
        public Class<Data> mo12619a() {
            return this.f4759b.mo12936a();
        }

        /* renamed from: d */
        public DataSource mo12629d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: ByteArrayLoader */
    /* renamed from: com.bumptech.glide.load.model.b$d */
    public static class C1705d implements ModelLoaderFactory<byte[], InputStream> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<byte[], InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new ByteArrayLoader(new C1703b<InputStream>() {
                /* renamed from: a */
                public InputStream mo12938b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                /* renamed from: a */
                public Class<InputStream> mo12936a() {
                    return InputStream.class;
                }
            });
        }
    }

    /* renamed from: a */
    public boolean mo12928a(byte[] bArr) {
        return true;
    }

    public ByteArrayLoader(C1703b<Data> bVar) {
        this.f4756a = bVar;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(byte[] bArr, int i, int i2, Options fVar) {
        return new C1725a<>(new ObjectKey(bArr), new C1704c(bArr, this.f4756a));
    }
}
