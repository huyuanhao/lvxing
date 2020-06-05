package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.p135a.StreamAssetPathFetcher;
import com.bumptech.glide.p134d.ObjectKey;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.a */
public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {
    /* renamed from: a */
    private static final int f4751a = 22;
    /* renamed from: b */
    private final AssetManager f4752b;
    /* renamed from: c */
    private final C1698a<Data> f4753c;

    /* compiled from: AssetUriLoader */
    /* renamed from: com.bumptech.glide.load.model.a$a */
    public interface C1698a<Data> {
        /* renamed from: a */
        DataFetcher<Data> mo12933a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader */
    /* renamed from: com.bumptech.glide.load.model.a$b */
    public static class C1699b implements C1698a<ParcelFileDescriptor>, ModelLoaderFactory<Uri, ParcelFileDescriptor> {
        /* renamed from: a */
        private final AssetManager f4754a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1699b(AssetManager assetManager) {
            this.f4754a = assetManager;
        }

        /* renamed from: a */
        public ModelLoader<Uri, ParcelFileDescriptor> mo12929a(MultiModelLoaderFactory qVar) {
            return new AssetUriLoader(this.f4754a, this);
        }

        /* renamed from: a */
        public DataFetcher<ParcelFileDescriptor> mo12933a(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }
    }

    /* compiled from: AssetUriLoader */
    /* renamed from: com.bumptech.glide.load.model.a$c */
    public static class C1700c implements C1698a<InputStream>, ModelLoaderFactory<Uri, InputStream> {
        /* renamed from: a */
        private final AssetManager f4755a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1700c(AssetManager assetManager) {
            this.f4755a = assetManager;
        }

        /* renamed from: a */
        public ModelLoader<Uri, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new AssetUriLoader(this.f4755a, this);
        }

        /* renamed from: a */
        public DataFetcher<InputStream> mo12933a(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }
    }

    public AssetUriLoader(AssetManager assetManager, C1698a<Data> aVar) {
        this.f4752b = assetManager;
        this.f4753c = aVar;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(Uri uri, int i, int i2, Options fVar) {
        return new C1725a<>(new ObjectKey(uri), this.f4753c.mo12933a(this.f4752b, uri.toString().substring(f4751a)));
    }

    /* renamed from: a */
    public boolean mo12928a(Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty()) {
            return false;
        }
        if ("android_asset".equals(uri.getPathSegments().get(0))) {
            return true;
        }
        return false;
    }
}
