package mtopsdk.p682a.p686c;

import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.RequestPool;
import com.taobao.tao.remotebusiness.p577b.MtopListenerProxyFactory;
import mtopsdk.mtop.common.MtopCallback.C8333b;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: FilterUtils */
/* renamed from: mtopsdk.a.c.b */
final class C8329b implements Runnable {
    /* renamed from: a */
    private /* synthetic */ MtopListenerProxyFactory f27826a;
    /* renamed from: b */
    private /* synthetic */ MtopResponse f27827b;
    /* renamed from: c */
    private /* synthetic */ MtopFinishEvent f27828c;

    C8329b(MtopListenerProxyFactory eVar, MtopResponse mtopResponse, MtopFinishEvent eVar2) {
        this.f27826a = eVar;
        this.f27827b = mtopResponse;
        this.f27828c = eVar2;
    }

    public final void run() {
        try {
            this.f27826a.f22581g.f27947S = RequestPool.m29160a(this.f27827b.getHeaderFields(), "x-s-traceid");
            this.f27826a.f22581g.f27948T = RequestPool.m29160a(this.f27827b.getHeaderFields(), "eagleeye-traceid");
            this.f27826a.f22581g.f27998t = this.f27827b.getResponseCode();
            this.f27826a.f22581g.f27999u = this.f27827b.getRetCode();
            this.f27826a.f22581g.f28001w = this.f27827b.getMappingCode();
            if (this.f27827b.isApiSuccess() && 3 == this.f27826a.f22581g.f27994p) {
                this.f27826a.f22581g.f27998t = 304;
            }
            boolean z = !(this.f27826a.f22583i instanceof MtopBusiness);
            if (z) {
                this.f27826a.f22581g.f27939K = System.currentTimeMillis();
            }
            ((C8333b) this.f27826a.f22579e).mo32725a(this.f27828c, this.f27826a.f22578d.reqContext);
            this.f27826a.f22581g.mo39837b();
            if (z) {
                this.f27826a.f22581g.f27940L = System.currentTimeMillis();
                this.f27826a.f22581g.mo39843g();
            }
        } catch (Exception unused) {
        }
    }
}
