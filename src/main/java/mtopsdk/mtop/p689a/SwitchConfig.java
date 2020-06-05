package mtopsdk.mtop.p689a;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.p687a.MtopConfigListener;
import mtopsdk.common.util.LocalConfig;
import mtopsdk.common.util.RemoteConfig;

/* renamed from: mtopsdk.mtop.a.b */
public class SwitchConfig {
    /* renamed from: c */
    public static final Map<String, String> f27883c = new ConcurrentHashMap(8);
    /* renamed from: d */
    public static final HashSet<String> f27884d = new HashSet<>(8);
    /* renamed from: e */
    private static final SwitchConfig f27885e = new SwitchConfig();
    /* renamed from: f */
    private static final RemoteConfig f27886f = RemoteConfig.m35521a();
    /* renamed from: g */
    private static final LocalConfig f27887g = LocalConfig.m35526a();
    /* renamed from: h */
    private static MtopConfigListener f27888h = null;
    /* renamed from: i */
    private static volatile Map<String, String> f27889i = new ConcurrentHashMap(8);
    /* renamed from: a */
    public volatile Set<String> f27890a = null;
    /* renamed from: b */
    public volatile Set<String> f27891b = null;

    static {
        f27883c.put("NETWORK_ERROR_MAPPING", "网络竟然崩溃了");
        f27883c.put("FLOW_LIMIT_ERROR_MAPPING", "前方拥挤，亲稍等再试试");
        f27883c.put("SERVICE_ERROR_MAPPING", "服务竟然出错了");
        f27884d.add("FAIL_SYS_ACCESS_TOKEN_EXPIRED");
        f27884d.add("FAIL_SYS_ILLEGAL_ACCESS_TOKEN");
    }

    private SwitchConfig() {
    }

    /* renamed from: a */
    public static SwitchConfig m35527a() {
        return f27885e;
    }

    /* renamed from: b */
    public boolean mo39744b() {
        return f27887g.f27874a && f27886f.f27848a;
    }

    /* renamed from: c */
    public boolean mo39745c() {
        return f27887g.f27875b && f27886f.f27849b;
    }

    /* renamed from: d */
    public boolean mo39746d() {
        return f27887g.f27878e && f27886f.f27853f;
    }

    /* renamed from: e */
    public long mo39747e() {
        return f27886f.f27850c;
    }

    /* renamed from: f */
    public int mo39748f() {
        return f27886f.f27865r;
    }
}
