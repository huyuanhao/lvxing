package mtopsdk.mtop.p690b;

import android.text.TextUtils;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.tao.remotebusiness.p577b.MtopListenerProxyFactory;
import java.util.Map;
import mtopsdk.common.util.C8330d;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.p682a.p685b.FilterManager;
import mtopsdk.p682a.p686c.FilterUtils;
import mtopsdk.xstate.XState;

/* renamed from: mtopsdk.mtop.b.b */
public class MtopBuilder {
    /* renamed from: j */
    public MtopRequest f27898j;
    /* renamed from: k */
    public final MtopNetworkProp f27899k = new MtopNetworkProp();
    /* renamed from: l */
    public MtopListener f27900l = null;
    @Deprecated
    /* renamed from: m */
    public Object f27901m = null;
    /* renamed from: n */
    protected MtopStatistics f27902n = null;
    /* renamed from: o */
    protected Mtop f27903o;
    /* renamed from: p */
    protected MtopListenerProxyFactory f27904p;

    public MtopBuilder(Mtop aVar, MtopRequest mtopRequest, String str) {
        this.f27903o = aVar;
        this.f27898j = mtopRequest;
        MtopNetworkProp mtopNetworkProp = this.f27899k;
        mtopNetworkProp.ttid = str;
        mtopNetworkProp.pageName = XState.m35595a("PageName");
        this.f27899k.pageUrl = XState.m35595a("PageUrl");
        this.f27899k.backGround = XState.m35598a();
        this.f27902n = new MtopStatistics(aVar.mo39749a().f27880a, aVar.mo39749a().f27882c, this.f27899k);
    }

    /* renamed from: b */
    public MtopBuilder mo32740b(Object obj) {
        this.f27899k.reqContext = obj;
        return this;
    }

    /* renamed from: h */
    public Object mo39756h() {
        return this.f27899k.reqContext;
    }

    /* renamed from: b */
    public MtopBuilder mo32741b(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            if (this.f27899k.requestHeaders != null) {
                this.f27899k.requestHeaders.putAll(map);
            } else {
                this.f27899k.requestHeaders = map;
            }
        }
        return this;
    }

    /* renamed from: b */
    public MtopBuilder mo32742b(MtopListener gVar) {
        this.f27900l = gVar;
        return this;
    }

    /* renamed from: g */
    public MtopBuilder mo32753g() {
        return mo32752f(4);
    }

    @Deprecated
    /* renamed from: f */
    public MtopBuilder mo32752f(int i) {
        this.f27899k.wuaFlag = i;
        return this;
    }

    /* renamed from: b */
    public MtopBuilder mo32743b(MethodEnum methodEnum) {
        if (methodEnum != null) {
            this.f27899k.method = methodEnum;
        }
        return this;
    }

    /* renamed from: e */
    public MtopBuilder mo32749e(int i) {
        if (i > 0) {
            this.f27899k.connTimeout = i;
        }
        return this;
    }

    /* renamed from: d */
    public MtopBuilder mo32748d(int i) {
        if (i > 0) {
            this.f27899k.socketTimeout = i;
        }
        return this;
    }

    /* renamed from: a */
    public MtopBuilder mo39753a(String str) {
        if (str != null) {
            this.f27899k.openBiz = str;
        }
        return this;
    }

    /* renamed from: a */
    private ApiID mo32734a(MtopListener gVar) {
        MtopStatistics mtopStatistics = this.f27902n;
        mtopStatistics.f28003y = mtopStatistics.mo39835a();
        MtopListenerProxyFactory c = mo39755c(gVar);
        c.f22581g.f27935G = System.currentTimeMillis();
        this.f27904p = c;
        c.f22580f = new ApiID(null, c);
        try {
            if (Mtop.f27892a) {
                String createRequest = FullTraceAnalysis.getInstance().createRequest("mtop");
                if (!TextUtils.isEmpty(createRequest)) {
                    c.f22581g.f27953Y = createRequest;
                    if (!TextUtils.isEmpty(this.f27899k.bizIdStr)) {
                        c.f22581g.f27957ab = this.f27899k.bizIdStr;
                    } else {
                        c.f22581g.f27956aa = this.f27899k.bizId;
                    }
                    c.f22581g.f27959ad = MtopUtils.m35519b();
                    c.f22581g.mo39841e();
                }
            }
            if (!MtopUtils.m35519b()) {
                if (this.f27903o.mo39751c()) {
                    c.f22581g.f28004z = this.f27902n.mo39835a();
                    c.f22581g.f27936H = System.currentTimeMillis();
                    FilterManager aVar = this.f27903o.mo39749a().f27881b;
                    if (aVar != null) {
                        aVar.mo39736a(null, c);
                    }
                    FilterUtils.m35496a(aVar, c);
                    return c.f22580f;
                }
            }
            MtopSDKThreadPoolExecutorFactory.m35586b().submit(new C8331c(this, c));
            return c.f22580f;
        } catch (Throwable unused) {
            return c.f22580f;
        }
    }

    /* renamed from: c */
    public ApiID mo32746c() {
        this.f27902n.f27958ac = false;
        return mo32734a(this.f27900l);
    }

    /* renamed from: c */
    public MtopListenerProxyFactory mo39755c(MtopListener gVar) {
        MtopListenerProxyFactory eVar = new MtopListenerProxyFactory();
        eVar.f22575a = this.f27903o;
        MtopStatistics mtopStatistics = this.f27902n;
        eVar.f22581g = mtopStatistics;
        eVar.f22582h = mtopStatistics.f27943O;
        MtopRequest mtopRequest = this.f27898j;
        eVar.f22576b = mtopRequest;
        eVar.f22578d = this.f27899k;
        eVar.f22579e = gVar;
        eVar.f22583i = this;
        if (mtopRequest != null) {
            this.f27902n.f27942N = mtopRequest.getKey();
            this.f27902n.f27945Q = this.f27899k.reqSource;
        }
        if (C8330d.m35525b(eVar.f22578d.ttid)) {
            eVar.f22578d.ttid = this.f27903o.mo39752d();
        }
        Object obj = this.f27901m;
        if (obj != null) {
            mo32740b(obj);
        }
        return eVar;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo39754a(boolean z) {
        this.f27902n.f27955a = false;
    }
}
