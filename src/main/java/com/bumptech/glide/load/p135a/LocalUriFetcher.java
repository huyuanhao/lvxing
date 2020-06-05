package com.bumptech.glide.load.p135a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.l */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    /* renamed from: a */
    private final Uri f4422a;
    /* renamed from: b */
    private final ContentResolver f4423b;
    /* renamed from: c */
    private T f4424c;

    /* renamed from: a */
    public abstract void mo12621a(T t) throws IOException;

    /* renamed from: b */
    public abstract T mo12622b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    /* renamed from: c */
    public void mo12628c() {
    }

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f4423b = contentResolver;
        this.f4422a = uri;
    }

    /* renamed from: a */
    public final void mo12626a(Priority priority, C1623a<? super T> aVar) {
        try {
            this.f4424c = mo12622b(this.f4422a, this.f4423b);
            aVar.mo12641a(this.f4424c);
        } catch (FileNotFoundException e) {
            String str = "LocalUriFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to open Uri", e);
            }
            aVar.mo12640a((Exception) e);
        }
    }

    /* renamed from: b */
    public void mo12627b() {
        T t = this.f4424c;
        if (t != null) {
            try {
                mo12621a(t);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: d */
    public DataSource mo12629d() {
        return DataSource.LOCAL;
    }
}
