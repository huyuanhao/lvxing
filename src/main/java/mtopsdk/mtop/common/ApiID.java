package mtopsdk.mtop.common;

import com.taobao.tao.remotebusiness.p577b.MtopListenerProxyFactory;
import mtopsdk.network.C8341a;

/* renamed from: mtopsdk.mtop.common.a */
public class ApiID {
    /* renamed from: a */
    private MtopListenerProxyFactory f27909a;
    /* renamed from: b */
    private volatile C8341a f27910b;
    /* renamed from: c */
    private volatile boolean f27911c = false;

    public ApiID(C8341a aVar, MtopListenerProxyFactory eVar) {
        this.f27910b = aVar;
        this.f27909a = eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("ApiID [call=");
        sb.append(this.f27910b);
        sb.append(", mtopContext=");
        sb.append(this.f27909a);
        sb.append("]");
        return sb.toString();
    }
}
