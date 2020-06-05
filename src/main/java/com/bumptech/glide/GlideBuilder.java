package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.cache.DiskCache.C1660a;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.engine.p137a.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.p137a.LruArrayPool;
import com.bumptech.glide.load.engine.p137a.LruBitmapPool;
import com.bumptech.glide.load.engine.p138b.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerRetriever.C1758a;
import com.bumptech.glide.p131c.RequestListener;
import com.bumptech.glide.p131c.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.f */
public final class GlideBuilder {
    /* renamed from: a */
    private final Map<Class<?>, TransitionOptions<?, ?>> f4275a = new ArrayMap();
    /* renamed from: b */
    private Engine f4276b;
    /* renamed from: c */
    private BitmapPool f4277c;
    /* renamed from: d */
    private ArrayPool f4278d;
    /* renamed from: e */
    private MemoryCache f4279e;
    /* renamed from: f */
    private GlideExecutor f4280f;
    /* renamed from: g */
    private GlideExecutor f4281g;
    /* renamed from: h */
    private C1660a f4282h;
    /* renamed from: i */
    private MemorySizeCalculator f4283i;
    /* renamed from: j */
    private ConnectivityMonitorFactory f4284j;
    /* renamed from: k */
    private int f4285k = 4;
    /* renamed from: l */
    private RequestOptions f4286l = new RequestOptions();
    /* renamed from: m */
    private C1758a f4287m;
    /* renamed from: n */
    private GlideExecutor f4288n;
    /* renamed from: o */
    private boolean f4289o;
    /* renamed from: p */
    private List<RequestListener<Object>> f4290p;
    /* renamed from: q */
    private boolean f4291q;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12544a(C1758a aVar) {
        this.f4287m = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Glide mo12543a(Context context) {
        if (this.f4280f == null) {
            this.f4280f = GlideExecutor.m5509b();
        }
        if (this.f4281g == null) {
            this.f4281g = GlideExecutor.m5506a();
        }
        if (this.f4288n == null) {
            this.f4288n = GlideExecutor.m5512d();
        }
        if (this.f4283i == null) {
            this.f4283i = new Builder(context).mo12782a();
        }
        if (this.f4284j == null) {
            this.f4284j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f4277c == null) {
            int b = this.f4283i.mo12780b();
            if (b > 0) {
                this.f4277c = new LruBitmapPool((long) b);
            } else {
                this.f4277c = new BitmapPoolAdapter();
            }
        }
        if (this.f4278d == null) {
            this.f4278d = new LruArrayPool(this.f4283i.mo12781c());
        }
        if (this.f4279e == null) {
            this.f4279e = new LruResourceCache((long) this.f4283i.mo12779a());
        }
        if (this.f4282h == null) {
            this.f4282h = new InternalCacheDiskCacheFactory(context);
        }
        if (this.f4276b == null) {
            Engine kVar = new Engine(this.f4279e, this.f4282h, this.f4281g, this.f4280f, GlideExecutor.m5511c(), GlideExecutor.m5512d(), this.f4289o);
            this.f4276b = kVar;
        }
        List<RequestListener<Object>> list = this.f4290p;
        if (list == null) {
            this.f4290p = Collections.emptyList();
        } else {
            this.f4290p = Collections.unmodifiableList(list);
        }
        Context context2 = context;
        Glide eVar = new Glide(context2, this.f4276b, this.f4279e, this.f4277c, this.f4278d, new RequestManagerRetriever(this.f4287m), this.f4284j, this.f4285k, (RequestOptions) this.f4286l.mo12447i(), this.f4275a, this.f4290p, this.f4291q);
        return eVar;
    }
}
