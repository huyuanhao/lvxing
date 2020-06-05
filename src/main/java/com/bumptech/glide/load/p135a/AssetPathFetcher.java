package com.bumptech.glide.load.p135a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.p135a.DataFetcher.C1623a;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.a.b */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    /* renamed from: a */
    private final String f4398a;
    /* renamed from: b */
    private final AssetManager f4399b;
    /* renamed from: c */
    private T f4400c;

    /* renamed from: a */
    public abstract T mo12633a(AssetManager assetManager, String str) throws IOException;

    /* renamed from: a */
    public abstract void mo12634a(T t) throws IOException;

    /* renamed from: c */
    public void mo12628c() {
    }

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f4399b = assetManager;
        this.f4398a = str;
    }

    /* renamed from: a */
    public void mo12626a(Priority priority, C1623a<? super T> aVar) {
        try {
            this.f4400c = mo12633a(this.f4399b, this.f4398a);
            aVar.mo12641a(this.f4400c);
        } catch (IOException e) {
            String str = "AssetPathFetcher";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to load data from asset manager", e);
            }
            aVar.mo12640a((Exception) e);
        }
    }

    /* renamed from: b */
    public void mo12627b() {
        T t = this.f4400c;
        if (t != null) {
            try {
                mo12634a(t);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: d */
    public DataSource mo12629d() {
        return DataSource.LOCAL;
    }
}
