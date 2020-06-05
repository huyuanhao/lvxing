package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitor.C1754a;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.p131c.BaseRequestOptions;
import com.bumptech.glide.p131c.Request;
import com.bumptech.glide.p131c.RequestListener;
import com.bumptech.glide.p131c.RequestOptions;
import com.bumptech.glide.p131c.p132a.Target;
import com.bumptech.glide.util.C1772j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.bumptech.glide.i */
public class RequestManager implements LifecycleListener {
    /* renamed from: d */
    private static final RequestOptions f4368d = ((RequestOptions) RequestOptions.m5105b(Bitmap.class).mo12447i());
    /* renamed from: e */
    private static final RequestOptions f4369e = ((RequestOptions) RequestOptions.m5105b(GifDrawable.class).mo12447i());
    /* renamed from: f */
    private static final RequestOptions f4370f = ((RequestOptions) ((RequestOptions) RequestOptions.m5104b(DiskCacheStrategy.f4631c).mo12422a(Priority.LOW)).mo12437b(true));
    /* renamed from: a */
    protected final Glide f4371a;
    /* renamed from: b */
    protected final Context f4372b;
    /* renamed from: c */
    final Lifecycle f4373c;
    /* renamed from: g */
    private final RequestTracker f4374g;
    /* renamed from: h */
    private final RequestManagerTreeNode f4375h;
    /* renamed from: i */
    private final TargetTracker f4376i;
    /* renamed from: j */
    private final Runnable f4377j;
    /* renamed from: k */
    private final Handler f4378k;
    /* renamed from: l */
    private final ConnectivityMonitor f4379l;
    /* renamed from: m */
    private final CopyOnWriteArrayList<RequestListener<Object>> f4380m;
    /* renamed from: n */
    private RequestOptions f4381n;

    /* compiled from: RequestManager */
    /* renamed from: com.bumptech.glide.i$a */
    private class C1620a implements C1754a {
        /* renamed from: b */
        private final RequestTracker f4384b;

        C1620a(RequestTracker nVar) {
            this.f4384b = nVar;
        }

        /* renamed from: a */
        public void mo12605a(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.f4384b.mo13189d();
                }
            }
        }
    }

    public RequestManager(Glide eVar, Lifecycle hVar, RequestManagerTreeNode mVar, Context context) {
        this(eVar, hVar, mVar, new RequestTracker(), eVar.mo12535d(), context);
    }

    RequestManager(Glide eVar, Lifecycle hVar, RequestManagerTreeNode mVar, RequestTracker nVar, ConnectivityMonitorFactory dVar, Context context) {
        this.f4376i = new TargetTracker();
        this.f4377j = new Runnable() {
            public void run() {
                RequestManager.this.f4373c.mo13156a(RequestManager.this);
            }
        };
        this.f4378k = new Handler(Looper.getMainLooper());
        this.f4371a = eVar;
        this.f4373c = hVar;
        this.f4375h = mVar;
        this.f4374g = nVar;
        this.f4372b = context;
        this.f4379l = dVar.mo13160a(context.getApplicationContext(), new C1620a(nVar));
        if (C1772j.m6161c()) {
            this.f4378k.post(this.f4377j);
        } else {
            hVar.mo13156a(this);
        }
        hVar.mo13156a(this.f4379l);
        this.f4380m = new CopyOnWriteArrayList<>(eVar.mo12536e().mo12547a());
        mo12595a(eVar.mo12536e().mo12548b());
        eVar.mo12530a(this);
    }

    /* access modifiers changed from: protected|declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12595a(RequestOptions fVar) {
        this.f4381n = (RequestOptions) ((RequestOptions) fVar.clone()).mo12448j();
    }

    /* renamed from: a */
    public synchronized void mo12592a() {
        this.f4374g.mo13184a();
    }

    /* renamed from: b */
    public synchronized void mo12597b() {
        this.f4374g.mo13186b();
    }

    public synchronized void onStart() {
        mo12597b();
        this.f4376i.onStart();
    }

    public synchronized void onStop() {
        mo12592a();
        this.f4376i.onStop();
    }

    public synchronized void onDestroy() {
        this.f4376i.onDestroy();
        for (Target a : this.f4376i.mo13191a()) {
            mo12593a(a);
        }
        this.f4376i.mo13193b();
        this.f4374g.mo13188c();
        this.f4373c.mo13158b(this);
        this.f4373c.mo13158b(this.f4379l);
        this.f4378k.removeCallbacks(this.f4377j);
        this.f4371a.mo12533b(this);
    }

    /* renamed from: c */
    public RequestBuilder<Bitmap> mo12599c() {
        return mo12589a(Bitmap.class).mo12435b((BaseRequestOptions<?>) f4368d);
    }

    /* renamed from: d */
    public RequestBuilder<Drawable> mo12600d() {
        return mo12589a(Drawable.class);
    }

    /* renamed from: a */
    public RequestBuilder<Drawable> mo12591a(String str) {
        return mo12600d().mo12588a(str);
    }

    /* renamed from: a */
    public RequestBuilder<Drawable> mo12590a(Integer num) {
        return mo12600d().mo12586a(num);
    }

    /* renamed from: a */
    public <ResourceType> RequestBuilder<ResourceType> mo12589a(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.f4371a, this, cls, this.f4372b);
    }

    /* renamed from: a */
    public synchronized void mo12593a(Target<?> hVar) {
        if (hVar != null) {
            m5276c(hVar);
        }
    }

    /* renamed from: c */
    private void m5276c(Target<?> hVar) {
        if (!mo12598b(hVar) && !this.f4371a.mo12531a(hVar) && hVar.getRequest() != null) {
            Request request = hVar.getRequest();
            hVar.setRequest(null);
            request.mo12493b();
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: b */
    public synchronized boolean mo12598b(Target<?> hVar) {
        Request request = hVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f4374g.mo13187b(request)) {
            return false;
        }
        this.f4376i.mo13194b(hVar);
        hVar.setRequest(null);
        return true;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo12594a(Target<?> hVar, Request cVar) {
        this.f4376i.mo13192a(hVar);
        this.f4374g.mo13185a(cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public List<RequestListener<Object>> mo12601e() {
        return this.f4380m;
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: f */
    public synchronized RequestOptions mo12602f() {
        return this.f4381n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <T> TransitionOptions<?, T> mo12596b(Class<T> cls) {
        return this.f4371a.mo12536e().mo12546a(cls);
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{tracker=");
        sb.append(this.f4374g);
        sb.append(", treeNode=");
        sb.append(this.f4375h);
        sb.append("}");
        return sb.toString();
    }
}
