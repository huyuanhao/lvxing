package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.p134d.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.e */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
    /* renamed from: a */
    private final C1709a<Data> f4762a;

    /* compiled from: DataUrlLoader */
    /* renamed from: com.bumptech.glide.load.model.e$a */
    public interface C1709a<Data> {
        /* renamed from: a */
        Class<Data> mo12943a();

        /* renamed from: a */
        Data mo12944a(String str) throws IllegalArgumentException;

        /* renamed from: a */
        void mo12945a(Data data) throws IOException;
    }

    /* compiled from: DataUrlLoader */
    /* renamed from: com.bumptech.glide.load.model.e$b */
    private static final class C1710b<Data> implements DataFetcher<Data> {
        /* renamed from: a */
        private final String f4763a;
        /* renamed from: b */
        private final C1709a<Data> f4764b;
        /* renamed from: c */
        private Data f4765c;

        /* renamed from: c */
        public void mo12628c() {
        }

        C1710b(String str, C1709a<Data> aVar) {
            this.f4763a = str;
            this.f4764b = aVar;
        }

        /* renamed from: a */
        public void mo12626a(Priority priority, C1623a<? super Data> aVar) {
            try {
                this.f4765c = this.f4764b.mo12944a(this.f4763a);
                aVar.mo12641a(this.f4765c);
            } catch (IllegalArgumentException e) {
                aVar.mo12640a((Exception) e);
            }
        }

        /* renamed from: b */
        public void mo12627b() {
            try {
                this.f4764b.mo12945a(this.f4765c);
            } catch (IOException unused) {
            }
        }

        /* renamed from: a */
        public Class<Data> mo12619a() {
            return this.f4764b.mo12943a();
        }

        /* renamed from: d */
        public DataSource mo12629d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: DataUrlLoader */
    /* renamed from: com.bumptech.glide.load.model.e$c */
    public static final class C1711c<Model> implements ModelLoaderFactory<Model, InputStream> {
        /* renamed from: a */
        private final C1709a<InputStream> f4766a = new C1709a<InputStream>() {
            /* renamed from: b */
            public InputStream mo12944a(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }

            /* renamed from: a */
            public void mo12945a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: a */
            public Class<InputStream> mo12943a() {
                return InputStream.class;
            }
        };

        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<Model, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new DataUrlLoader(this.f4766a);
        }
    }

    public DataUrlLoader(C1709a<Data> aVar) {
        this.f4762a = aVar;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(Model model, int i, int i2, Options fVar) {
        return new C1725a<>(new ObjectKey(model), new C1710b(model.toString(), this.f4762a));
    }

    /* renamed from: a */
    public boolean mo12928a(Model model) {
        return model.toString().startsWith("data:image");
    }
}
