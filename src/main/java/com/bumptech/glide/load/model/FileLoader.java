package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.p134d.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.f */
public class FileLoader<Data> implements ModelLoader<File, Data> {
    /* renamed from: a */
    private final C1717d<Data> f4768a;

    /* compiled from: FileLoader */
    /* renamed from: com.bumptech.glide.load.model.f$a */
    public static class C1713a<Data> implements ModelLoaderFactory<File, Data> {
        /* renamed from: a */
        private final C1717d<Data> f4769a;

        /* renamed from: a */
        public final void mo12930a() {
        }

        public C1713a(C1717d<Data> dVar) {
            this.f4769a = dVar;
        }

        /* renamed from: a */
        public final ModelLoader<File, Data> mo12929a(MultiModelLoaderFactory qVar) {
            return new FileLoader(this.f4769a);
        }
    }

    /* compiled from: FileLoader */
    /* renamed from: com.bumptech.glide.load.model.f$b */
    public static class C1714b extends C1713a<ParcelFileDescriptor> {
        public C1714b() {
            super(new C1717d<ParcelFileDescriptor>() {
                /* renamed from: a */
                public ParcelFileDescriptor mo12954b(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }

                /* renamed from: a */
                public void mo12953a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                /* renamed from: a */
                public Class<ParcelFileDescriptor> mo12951a() {
                    return ParcelFileDescriptor.class;
                }
            });
        }
    }

    /* compiled from: FileLoader */
    /* renamed from: com.bumptech.glide.load.model.f$c */
    private static final class C1716c<Data> implements DataFetcher<Data> {
        /* renamed from: a */
        private final File f4770a;
        /* renamed from: b */
        private final C1717d<Data> f4771b;
        /* renamed from: c */
        private Data f4772c;

        /* renamed from: c */
        public void mo12628c() {
        }

        C1716c(File file, C1717d<Data> dVar) {
            this.f4770a = file;
            this.f4771b = dVar;
        }

        /* renamed from: a */
        public void mo12626a(Priority priority, C1623a<? super Data> aVar) {
            try {
                this.f4772c = this.f4771b.mo12954b(this.f4770a);
                aVar.mo12641a(this.f4772c);
            } catch (FileNotFoundException e) {
                String str = "FileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to open file", e);
                }
                aVar.mo12640a((Exception) e);
            }
        }

        /* renamed from: b */
        public void mo12627b() {
            Data data = this.f4772c;
            if (data != null) {
                try {
                    this.f4771b.mo12953a(data);
                } catch (IOException unused) {
                }
            }
        }

        /* renamed from: a */
        public Class<Data> mo12619a() {
            return this.f4771b.mo12951a();
        }

        /* renamed from: d */
        public DataSource mo12629d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: FileLoader */
    /* renamed from: com.bumptech.glide.load.model.f$d */
    public interface C1717d<Data> {
        /* renamed from: a */
        Class<Data> mo12951a();

        /* renamed from: a */
        void mo12953a(Data data) throws IOException;

        /* renamed from: b */
        Data mo12954b(File file) throws FileNotFoundException;
    }

    /* compiled from: FileLoader */
    /* renamed from: com.bumptech.glide.load.model.f$e */
    public static class C1718e extends C1713a<InputStream> {
        public C1718e() {
            super(new C1717d<InputStream>() {
                /* renamed from: a */
                public InputStream mo12954b(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }

                /* renamed from: a */
                public void mo12953a(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                /* renamed from: a */
                public Class<InputStream> mo12951a() {
                    return InputStream.class;
                }
            });
        }
    }

    /* renamed from: a */
    public boolean mo12928a(File file) {
        return true;
    }

    public FileLoader(C1717d<Data> dVar) {
        this.f4768a = dVar;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(File file, int i, int i2, Options fVar) {
        return new C1725a<>(new ObjectKey(file), new C1716c(file, this.f4768a));
    }
}
