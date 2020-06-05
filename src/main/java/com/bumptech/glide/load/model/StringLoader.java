package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.t */
public class StringLoader<Data> implements ModelLoader<String, Data> {
    /* renamed from: a */
    private final ModelLoader<Uri, Data> f4838a;

    /* compiled from: StringLoader */
    /* renamed from: com.bumptech.glide.load.model.t$a */
    public static final class C1739a implements ModelLoaderFactory<String, AssetFileDescriptor> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<String, AssetFileDescriptor> mo12929a(MultiModelLoaderFactory qVar) {
            return new StringLoader(qVar.mo12989b(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader */
    /* renamed from: com.bumptech.glide.load.model.t$b */
    public static class C1740b implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<String, ParcelFileDescriptor> mo12929a(MultiModelLoaderFactory qVar) {
            return new StringLoader(qVar.mo12989b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader */
    /* renamed from: com.bumptech.glide.load.model.t$c */
    public static class C1741c implements ModelLoaderFactory<String, InputStream> {
        /* renamed from: a */
        public void mo12930a() {
        }

        /* renamed from: a */
        public ModelLoader<String, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new StringLoader(qVar.mo12989b(Uri.class, InputStream.class));
        }
    }

    /* renamed from: a */
    public boolean mo12928a(String str) {
        return true;
    }

    public StringLoader(ModelLoader<Uri, Data> mVar) {
        this.f4838a = mVar;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(String str, int i, int i2, Options fVar) {
        Uri b = m5968b(str);
        if (b == null || !this.f4838a.mo12928a(b)) {
            return null;
        }
        return this.f4838a.mo12926a(b, i, i2, fVar);
    }

    /* renamed from: b */
    private static Uri m5968b(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            uri = m5969c(str);
        } else {
            Uri parse = Uri.parse(str);
            uri = parse.getScheme() == null ? m5969c(str) : parse;
        }
        return uri;
    }

    /* renamed from: c */
    private static Uri m5969c(String str) {
        return Uri.fromFile(new File(str));
    }
}
