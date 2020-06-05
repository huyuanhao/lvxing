package mtopsdk.mtop.p690b;

import com.taobao.tao.remotebusiness.p577b.MtopListenerProxyFactory;
import mtopsdk.p682a.p685b.FilterManager;
import mtopsdk.p682a.p686c.FilterUtils;

/* compiled from: MtopBuilder */
/* renamed from: mtopsdk.mtop.b.c */
final class C8331c implements Runnable {
    /* renamed from: a */
    private /* synthetic */ MtopListenerProxyFactory f27905a;
    /* renamed from: b */
    private /* synthetic */ MtopBuilder f27906b;

    C8331c(MtopBuilder bVar, MtopListenerProxyFactory eVar) {
        this.f27906b = bVar;
        this.f27905a = eVar;
    }

    public final void run() {
        this.f27905a.f22581g.f27936H = System.currentTimeMillis();
        this.f27905a.f22581g.f28004z = this.f27906b.f27902n.mo39835a();
        this.f27906b.f27903o.mo39750b();
        FilterManager aVar = this.f27906b.f27903o.mo39749a().f27881b;
        if (aVar != null) {
            aVar.mo39736a(null, this.f27905a);
        }
        FilterUtils.m35496a(aVar, this.f27905a);
    }
}
