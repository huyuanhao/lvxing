package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.r */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {
    /* renamed from: a */
    private final ModelLoader<Uri, Data> f4821a;
    /* renamed from: b */
    private final Resources f4822b;

    /* compiled from: ResourceLoader */
    /* renamed from: com.bumptech.glide.load.model.r$a */
    public static final class C1732a implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
        /* renamed from: a */
        private final Resources f4823a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1732a(Resources resources) {
            this.f4823a = resources;
        }

        /* renamed from: a */
        public ModelLoader<Integer, AssetFileDescriptor> mo12929a(MultiModelLoaderFactory qVar) {
            return new ResourceLoader(this.f4823a, qVar.mo12989b(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader */
    /* renamed from: com.bumptech.glide.load.model.r$b */
    public static class C1733b implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        /* renamed from: a */
        private final Resources f4824a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1733b(Resources resources) {
            this.f4824a = resources;
        }

        /* renamed from: a */
        public ModelLoader<Integer, ParcelFileDescriptor> mo12929a(MultiModelLoaderFactory qVar) {
            return new ResourceLoader(this.f4824a, qVar.mo12989b(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader */
    /* renamed from: com.bumptech.glide.load.model.r$c */
    public static class C1734c implements ModelLoaderFactory<Integer, InputStream> {
        /* renamed from: a */
        private final Resources f4825a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1734c(Resources resources) {
            this.f4825a = resources;
        }

        /* renamed from: a */
        public ModelLoader<Integer, InputStream> mo12929a(MultiModelLoaderFactory qVar) {
            return new ResourceLoader(this.f4825a, qVar.mo12989b(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader */
    /* renamed from: com.bumptech.glide.load.model.r$d */
    public static class C1735d implements ModelLoaderFactory<Integer, Uri> {
        /* renamed from: a */
        private final Resources f4826a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public C1735d(Resources resources) {
            this.f4826a = resources;
        }

        /* renamed from: a */
        public ModelLoader<Integer, Uri> mo12929a(MultiModelLoaderFactory qVar) {
            return new ResourceLoader(this.f4826a, UnitModelLoader.m5980a());
        }
    }

    /* renamed from: a */
    public boolean mo12928a(Integer num) {
        return true;
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> mVar) {
        this.f4822b = resources;
        this.f4821a = mVar;
    }

    /* renamed from: a */
    public C1725a<Data> mo12926a(Integer num, int i, int i2, Options fVar) {
        Uri b = m5923b(num);
        if (b == null) {
            return null;
        }
        return this.f4821a.mo12926a(b, i, i2, fVar);
    }

    /* renamed from: b */
    private Uri m5923b(Integer num) {
        try {
            r5 = num;
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.f4822b.getResourcePackageName(num.intValue()));
            sb.append('/');
            sb.append(this.f4822b.getResourceTypeName(num.intValue()));
            sb.append('/');
            sb.append(this.f4822b.getResourceEntryName(num.intValue()));
            r5 = Uri.parse(sb.toString());
            r5 = r5;
            return r5;
        } catch (NotFoundException e) {
            String str = "ResourceLoader";
            if (Log.isLoggable(str, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received invalid resource id: ");
                sb2.append(r5);
                Log.w(str, sb2.toString(), e);
            }
            return null;
        }
    }
}
