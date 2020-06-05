package mtopsdk.p682a.p686c;

import android.os.Handler;
import com.taobao.tao.remotebusiness.p577b.MtopListenerProxyFactory;
import mtopsdk.mtop.common.MtopCallback.C8333b;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.p682a.p683a.p684a.ErrorCodeMappingAfterFilter;
import mtopsdk.p682a.p685b.FilterManager;

/* renamed from: mtopsdk.a.c.a */
public final class FilterUtils {
    /* renamed from: a */
    public static final ErrorCodeMappingAfterFilter f27825a = new ErrorCodeMappingAfterFilter();

    /* renamed from: a */
    public static void m35495a(MtopListenerProxyFactory eVar) {
        MtopResponse mtopResponse = eVar.f22577c;
        if (mtopResponse != null && (eVar.f22579e instanceof C8333b)) {
            mtopResponse.setMtopStat(eVar.f22581g);
            MtopFinishEvent eVar2 = new MtopFinishEvent(mtopResponse);
            eVar2.f27913b = eVar.f22582h;
            eVar.f22581g.f27938J = System.currentTimeMillis();
            f27825a.mo39735a(eVar);
            m35494a(eVar.f22578d.handler, new C8329b(eVar, mtopResponse, eVar2), eVar.f22582h.hashCode());
        }
    }

    /* renamed from: a */
    public static void m35494a(Handler handler, Runnable runnable, int i) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            MtopSDKThreadPoolExecutorFactory.m35582a(i, runnable);
        }
    }

    /* renamed from: a */
    public static void m35496a(FilterManager aVar, MtopListenerProxyFactory eVar) {
        if (aVar == null) {
            MtopResponse mtopResponse = new MtopResponse("ANDROID_SYS_MTOPSDK_INIT_ERROR", "MTOPSDK初始化失败");
            if (eVar.f22576b != null) {
                mtopResponse.setApi(eVar.f22576b.getApiName());
                mtopResponse.setV(eVar.f22576b.getVersion());
            }
            eVar.f22577c = mtopResponse;
            m35495a(eVar);
        }
    }
}
