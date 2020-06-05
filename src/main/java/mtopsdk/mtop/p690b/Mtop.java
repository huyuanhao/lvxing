package mtopsdk.mtop.p690b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.C8330d;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.p689a.MtopConfig;
import mtopsdk.xstate.XState;

/* renamed from: mtopsdk.mtop.b.a */
public class Mtop {
    /* renamed from: a */
    public static boolean f27892a = false;
    /* renamed from: b */
    protected static final Map<String, Mtop> f27893b = new ConcurrentHashMap();
    /* renamed from: c */
    volatile String f27894c;
    /* renamed from: d */
    final MtopConfig f27895d;
    /* renamed from: e */
    volatile boolean f27896e;
    /* renamed from: f */
    final byte[] f27897f;

    /* renamed from: a */
    public static Mtop m35533a(String str) {
        if (!C8330d.m35523a(str)) {
            str = "INNER";
        }
        return (Mtop) f27893b.get(str);
    }

    /* renamed from: a */
    public MtopConfig mo39749a() {
        return this.f27895d;
    }

    /* renamed from: b */
    public boolean mo39750b() {
        if (this.f27896e) {
            return this.f27896e;
        }
        synchronized (this.f27897f) {
            try {
                if (!this.f27896e) {
                    this.f27897f.wait(60000);
                    if (!this.f27896e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.f27894c);
                        sb.append(" [checkMtopSDKInit]Didn't call Mtop.instance(...),please execute global init.");
                        TBSdkLog.m35510c("mtopsdk.Mtop", sb.toString());
                    }
                }
            } catch (Exception e) {
                String str = "mtopsdk.Mtop";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f27894c);
                sb2.append(" [checkMtopSDKInit] wait Mtop initLock failed---");
                sb2.append(e.toString());
                TBSdkLog.m35510c(str, sb2.toString());
            }
        }
        return this.f27896e;
    }

    /* renamed from: c */
    public boolean mo39751c() {
        return this.f27896e;
    }

    /* renamed from: d */
    public String mo39752d() {
        return XState.m35596a(this.f27894c, "ttid");
    }
}
