package com.bumptech.glide.load.engine.p137a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.engine.a.k */
public class LruBitmapPool implements BitmapPool {
    /* renamed from: a */
    private static final Config f4470a = Config.ARGB_8888;
    /* renamed from: b */
    private final LruPoolStrategy f4471b;
    /* renamed from: c */
    private final Set<Config> f4472c;
    /* renamed from: d */
    private final long f4473d;
    /* renamed from: e */
    private final C1643a f4474e;
    /* renamed from: f */
    private long f4475f;
    /* renamed from: g */
    private long f4476g;
    /* renamed from: h */
    private int f4477h;
    /* renamed from: i */
    private int f4478i;
    /* renamed from: j */
    private int f4479j;
    /* renamed from: k */
    private int f4480k;

    /* compiled from: LruBitmapPool */
    /* renamed from: com.bumptech.glide.load.engine.a.k$a */
    private interface C1643a {
        /* renamed from: a */
        void mo12749a(Bitmap bitmap);

        /* renamed from: b */
        void mo12750b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool */
    /* renamed from: com.bumptech.glide.load.engine.a.k$b */
    private static final class C1644b implements C1643a {
        /* renamed from: a */
        public void mo12749a(Bitmap bitmap) {
        }

        /* renamed from: b */
        public void mo12750b(Bitmap bitmap) {
        }

        C1644b() {
        }
    }

    LruBitmapPool(long j, LruPoolStrategy lVar, Set<Config> set) {
        this.f4473d = j;
        this.f4475f = j;
        this.f4471b = lVar;
        this.f4472c = set;
        this.f4474e = new C1644b();
    }

    public LruBitmapPool(long j) {
        this(j, m5476e(), m5477f());
    }

    /* renamed from: a */
    public long mo12748a() {
        return this.f4475f;
    }

    public synchronized void put(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f4471b.mo12712c(bitmap)) <= this.f4475f) {
                        if (this.f4472c.contains(bitmap.getConfig())) {
                            int c = this.f4471b.mo12712c(bitmap);
                            this.f4471b.mo12709a(bitmap);
                            this.f4474e.mo12749a(bitmap);
                            this.f4479j++;
                            this.f4476g += (long) c;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Put bitmap in pool=");
                                sb.append(this.f4471b.mo12711b(bitmap));
                                Log.v("LruBitmapPool", sb.toString());
                            }
                            m5474c();
                            m5472b();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.f4471b.mo12711b(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.f4472c.contains(bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } finally {
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    /* renamed from: b */
    private void m5472b() {
        m5468a(this.f4475f);
    }

    public Bitmap get(int i, int i2, Config config) {
        Bitmap b = m5471b(i, i2, config);
        if (b == null) {
            return m5467a(i, i2, config);
        }
        b.eraseColor(0);
        return b;
    }

    public Bitmap getDirty(int i, int i2, Config config) {
        Bitmap b = m5471b(i, i2, config);
        return b == null ? m5467a(i, i2, config) : b;
    }

    /* renamed from: a */
    private static Bitmap m5467a(int i, int i2, Config config) {
        if (config == null) {
            config = f4470a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    /* renamed from: a */
    private static void m5469a(Config config) {
        if (VERSION.SDK_INT >= 26 && config == Config.HARDWARE) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot create a mutable Bitmap with config: ");
            sb.append(config);
            sb.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: b */
    private synchronized Bitmap m5471b(int i, int i2, Config config) {
        Bitmap a;
        m5469a(config);
        a = this.f4471b.mo12708a(i, i2, config != null ? config : f4470a);
        if (a == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing bitmap=");
                sb.append(this.f4471b.mo12710b(i, i2, config));
                Log.d("LruBitmapPool", sb.toString());
            }
            this.f4478i++;
        } else {
            this.f4477h++;
            this.f4476g -= (long) this.f4471b.mo12712c(a);
            this.f4474e.mo12750b(a);
            m5470a(a);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get bitmap=");
            sb2.append(this.f4471b.mo12710b(i, i2, config));
            Log.v("LruBitmapPool", sb2.toString());
        }
        m5474c();
        return a;
    }

    /* renamed from: a */
    private static void m5470a(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        m5473b(bitmap);
    }

    /* renamed from: b */
    private static void m5473b(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    public void clearMemory() {
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "clearMemory");
        }
        m5468a(0);
    }

    public void trimMemory(int i) {
        String str = "LruBitmapPool";
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(i);
            Log.d(str, sb.toString());
        }
        if (i >= 40) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            m5468a(mo12748a() / 2);
        }
    }

    /* renamed from: a */
    private synchronized void m5468a(long j) {
        while (this.f4476g > j) {
            Bitmap a = this.f4471b.mo12707a();
            if (a == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    m5475d();
                }
                this.f4476g = 0;
                return;
            }
            this.f4474e.mo12750b(a);
            this.f4476g -= (long) this.f4471b.mo12712c(a);
            this.f4480k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Evicting bitmap=");
                sb.append(this.f4471b.mo12711b(a));
                Log.d("LruBitmapPool", sb.toString());
            }
            m5474c();
            a.recycle();
        }
    }

    /* renamed from: c */
    private void m5474c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m5475d();
        }
    }

    /* renamed from: d */
    private void m5475d() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.f4477h);
        sb.append(", misses=");
        sb.append(this.f4478i);
        sb.append(", puts=");
        sb.append(this.f4479j);
        sb.append(", evictions=");
        sb.append(this.f4480k);
        sb.append(", currentSize=");
        sb.append(this.f4476g);
        sb.append(", maxSize=");
        sb.append(this.f4475f);
        sb.append("\nStrategy=");
        sb.append(this.f4471b);
        Log.v("LruBitmapPool", sb.toString());
    }

    /* renamed from: e */
    private static LruPoolStrategy m5476e() {
        if (VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new AttributeStrategy();
    }

    /* renamed from: f */
    private static Set<Config> m5477f() {
        HashSet hashSet = new HashSet(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (VERSION.SDK_INT >= 26) {
            hashSet.remove(Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
