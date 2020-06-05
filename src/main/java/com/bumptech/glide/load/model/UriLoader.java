package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.p135a.StreamLocalUriFetcher;
import com.bumptech.glide.p134d.ObjectKey;
import com.tencent.android.tpush.common.MessageKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.model.v */
public class UriLoader<Data> implements ModelLoader<Uri, Data> {
    /* renamed from: a */
    private static final Set<String> f4842a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", MessageKey.MSG_CONTENT})));
    /* renamed from: b */
    private final C1746c<Data> f4843b;

    /* compiled from: UriLoader */
    /* renamed from: com.bumptech.glide.load.model.v$a */
    public static final class C1744a implements ModelLoaderFactory<Uri, AssetFileDescriptor>, C1746c<AssetFileDescriptor> {
        /* renamed from: a */
        private final ContentResolver f4844a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1744a(ContentResolver contentResolver) {
            this.f4844a = contentResolver;
        }

        /* renamed from: a */
        public ModelLoader<Uri, AssetFileDescriptor> mo12929a(MultiModelLoaderFactory qVar) {
            return new UriLoader(this);
        }

        /* renamed from: a */
        public DataFetcher<AssetFileDescriptor> mo13012a(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.f4844a, uri);
        }
    }

    /* compiled from: UriLoader */
    /* renamed from: com.bumptech.glide.load.model.v$b */
    public static class C1745b implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, C1746c<ParcelFileDescriptor> {
        /* renamed from: a */
        private final ContentResolver f4845a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1745b(ContentResolver contentResolver) {
            this.f4845a = contentResolver;
        }

        /* renamed from: a */
        public DataFetcher<ParcelFileDescriptor> mo13012a(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.f4845a, uri);
        }

        /* renamed from: a */
        public ModelLoader<Uri, ParcelFileDescriptor> mo12929a(MultiModelLoaderFactory qVar) {
            return new UriLoader(this);
        }
    }

    /* compiled from: UriLoader */
    /* renamed from: com.bumptech.glide.load.model.v$c */
    public interface C1746c<Data> {
        /* renamed from: a */
        DataFetcher<Data> mo13012a(Uri uri);
    }

    /* compiled from: UriLoader */
    /* renamed from: com.bumptech.glide.load.model.v$d */
    public static class C1747d implements ModelLoaderFactory<Uri, InputStream>, C1746c<InputStream> {
        /* renamed from: a */
        private final ContentResolver f4846a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1747d(ContentResolver contentResolver) {
            this.f4846a = contentResolver;
        }

        /* renamed from: a */
        public DataFetcher<InputStream> mo13012a(Uri uri) {
            return new StreamLocalUriFetcher(this.f4846a, uri);
        }

        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new UriLoader(this);
        }
    }

    public UriLoader(C1746c<Data> cVar) {
        this.f4843b = cVar;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(Uri uri, int i, int i2, Options fVar) {
        return new C1725a<>(new ObjectKey(uri), this.f4843b.mo13012a(uri));
    }

    /* renamed from: a */
    public boolean mo12928a(Uri uri) {
        return f4842a.contains(uri.getScheme());
    }
}
