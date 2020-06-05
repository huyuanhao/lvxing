package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.p134d.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.d */
public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {

    /* compiled from: ByteBufferFileLoader */
    /* renamed from: com.bumptech.glide.load.model.d$a */
    private static final class C1707a implements DataFetcher<ByteBuffer> {
        /* renamed from: a */
        private final File f4761a;

        /* renamed from: b */
        public void mo12627b() {
        }

        /* renamed from: c */
        public void mo12628c() {
        }

        C1707a(File file) {
            this.f4761a = file;
        }

        /* renamed from: a */
        public void mo12626a(Priority priority, C1623a<? super ByteBuffer> aVar) {
            try {
                aVar.mo12641a(ByteBufferUtil.m6088a(this.f4761a));
            } catch (IOException e) {
                String str = "ByteBufferFileLoader";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Failed to obtain ByteBuffer for file", e);
                }
                aVar.mo12640a((Exception) e);
            }
        }

        /* renamed from: a */
        public Class<ByteBuffer> mo12619a() {
            return ByteBuffer.class;
        }

        /* renamed from: d */
        public DataSource mo12629d() {
            return DataSource.LOCAL;
        }
    }

    /* compiled from: ByteBufferFileLoader */
    /* renamed from: com.bumptech.glide.load.model.d$b */
    public static class C1708b implements ModelLoaderFactory<File, ByteBuffer> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<File, ByteBuffer> mo12929a(MultiModelLoaderFactory qVar) {
            return new ByteBufferFileLoader();
        }
    }

    /* renamed from: a */
    public boolean mo12928a(File file) {
        return true;
    }

    /* renamed from: a */
    public C1725a<ByteBuffer> mo12926a(File file, int i, int i2, Options fVar) {
        return new C1725a<>(new ObjectKey(file), new C1707a(file));
    }
}
