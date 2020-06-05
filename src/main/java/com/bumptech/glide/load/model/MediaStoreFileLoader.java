package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.C1725a;
import com.bumptech.glide.load.p135a.DataFetcher;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import com.bumptech.glide.load.p135a.p136a.MediaStoreUtil;
import com.bumptech.glide.p134d.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    /* renamed from: a */
    private final Context f4746a;

    /* renamed from: com.bumptech.glide.load.model.MediaStoreFileLoader$Factory */
    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        /* renamed from: a */
        private final Context f4747a;

        /* renamed from: a */
        public void mo12930a() {
        }

        public Factory(Context context) {
            this.f4747a = context;
        }

        /* renamed from: a */
        public ModelLoader<Uri, File> mo12929a(MultiModelLoaderFactory qVar) {
            return new MediaStoreFileLoader(this.f4747a);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.MediaStoreFileLoader$a */
    private static class C1697a implements DataFetcher<File> {
        /* renamed from: a */
        private static final String[] f4748a = {"_data"};
        /* renamed from: b */
        private final Context f4749b;
        /* renamed from: c */
        private final Uri f4750c;

        /* renamed from: b */
        public void mo12627b() {
        }

        /* renamed from: c */
        public void mo12628c() {
        }

        C1697a(Context context, Uri uri) {
            this.f4749b = context;
            this.f4750c = uri;
        }

        /* renamed from: a */
        public void mo12626a(Priority priority, C1623a<? super File> aVar) {
            Cursor query = this.f4749b.getContentResolver().query(this.f4750c, f4748a, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to find file path for: ");
                sb.append(this.f4750c);
                aVar.mo12640a((Exception) new FileNotFoundException(sb.toString()));
                return;
            }
            aVar.mo12641a(new File(str));
        }

        /* renamed from: a */
        public Class<File> mo12619a() {
            return File.class;
        }

        /* renamed from: d */
        public DataSource mo12629d() {
            return DataSource.LOCAL;
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f4746a = context;
    }

    /* renamed from: a */
    public C1725a<File> mo12926a(Uri uri, int i, int i2, Options fVar) {
        return new C1725a<>(new ObjectKey(uri), new C1697a(this.f4746a, uri));
    }

    /* renamed from: a */
    public boolean mo12928a(Uri uri) {
        return MediaStoreUtil.m5301a(uri);
    }
}
