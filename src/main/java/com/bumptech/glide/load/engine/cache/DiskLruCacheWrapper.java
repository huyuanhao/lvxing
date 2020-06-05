package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache.C1661b;
import com.bumptech.glide.p129a.DiskLruCache;
import com.bumptech.glide.p129a.DiskLruCache.C1599b;
import com.bumptech.glide.p129a.DiskLruCache.C1601d;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.engine.cache.e */
public class DiskLruCacheWrapper implements DiskCache {
    /* renamed from: a */
    private final SafeKeyGenerator f4546a;
    /* renamed from: b */
    private final File f4547b;
    /* renamed from: c */
    private final long f4548c;
    /* renamed from: d */
    private final DiskCacheWriteLocker f4549d = new DiskCacheWriteLocker();
    /* renamed from: e */
    private DiskLruCache f4550e;

    /* renamed from: a */
    public static DiskCache m5553a(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j) {
        this.f4547b = file;
        this.f4548c = j;
        this.f4546a = new SafeKeyGenerator();
    }

    /* renamed from: a */
    private synchronized DiskLruCache m5552a() throws IOException {
        if (this.f4550e == null) {
            this.f4550e = DiskLruCache.m4879a(this.f4547b, 1, 1, this.f4548c);
        }
        return this.f4550e;
    }

    /* renamed from: a */
    public File mo12785a(Key cVar) {
        String a = this.f4546a.mo12803a(cVar);
        String str = "DiskLruCacheWrapper";
        if (Log.isLoggable(str, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Get: Obtained: ");
            sb.append(a);
            sb.append(" for for Key: ");
            sb.append(cVar);
            Log.v(str, sb.toString());
        }
        try {
            C1601d a2 = m5552a().mo12362a(a);
            if (a2 != null) {
                return a2.mo12377a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable(str, 5)) {
                return null;
            }
            Log.w(str, "Unable to get from disk cache", e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo12786a(Key cVar, C1661b bVar) {
        C1599b b;
        String str = "DiskLruCacheWrapper";
        String a = this.f4546a.mo12803a(cVar);
        this.f4549d.mo12789a(a);
        try {
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Put: Obtained: ");
                sb.append(a);
                sb.append(" for for Key: ");
                sb.append(cVar);
                Log.v(str, sb.toString());
            }
            try {
                DiskLruCache a2 = m5552a();
                if (a2.mo12362a(a) == null) {
                    b = a2.mo12364b(a);
                    if (b != null) {
                        if (bVar.mo12788a(b.mo12370a(0))) {
                            b.mo12371a();
                        }
                        b.mo12373c();
                        this.f4549d.mo12790b(a);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Had two simultaneous puts for: ");
                    sb2.append(a);
                    throw new IllegalStateException(sb2.toString());
                }
            } catch (IOException e) {
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Unable to put to disk cache", e);
                }
            } catch (Throwable th) {
                b.mo12373c();
                throw th;
            }
        } finally {
            this.f4549d.mo12790b(a);
        }
    }
}
