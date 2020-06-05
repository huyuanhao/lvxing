package com.taobao.tao.remotebusiness;

import com.taobao.tao.remotebusiness.p577b.MtopListenerProxyFactory;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.TBSdkLog.LogEnable;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.p690b.Mtop;
import mtopsdk.mtop.p690b.MtopBuilder;

/* renamed from: com.taobao.tao.remotebusiness.f */
public class MtopBusiness extends MtopBuilder {
    /* renamed from: A */
    private static AtomicInteger f22584A = new AtomicInteger(0);
    /* renamed from: a */
    public MtopListener f22585a;
    /* renamed from: b */
    public Class<?> f22586b;
    @Deprecated
    /* renamed from: c */
    public Object f22587c = null;
    /* renamed from: d */
    public String f22588d = null;
    /* renamed from: e */
    public boolean f22589e = true;
    /* renamed from: f */
    public boolean f22590f = false;
    /* renamed from: g */
    public long f22591g = 0;
    /* renamed from: h */
    public long f22592h = 0;
    /* renamed from: i */
    public long f22593i = 0;
    /* renamed from: q */
    private boolean f22594q = false;
    /* renamed from: r */
    private ApiID f22595r;
    /* renamed from: s */
    private int f22596s = 0;
    /* renamed from: t */
    private int f22597t = 0;
    /* renamed from: u */
    private boolean f22598u = true;
    /* renamed from: v */
    private boolean f22599v = false;
    /* renamed from: w */
    private boolean f22600w = false;
    /* renamed from: x */
    private MtopResponse f22601x = null;
    /* renamed from: y */
    private boolean f22602y = false;
    /* renamed from: z */
    private final String f22603z = m29134i();

    protected MtopBusiness(Mtop aVar, MtopRequest mtopRequest, String str) {
        super(aVar, mtopRequest, str);
    }

    /* renamed from: i */
    private String m29134i() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("MB");
        sb.append(f22584A.incrementAndGet());
        sb.append('.');
        sb.append(this.f27902n.f27943O);
        return sb.toString();
    }

    /* renamed from: a */
    public static MtopBusiness m29133a(Mtop aVar, MtopRequest mtopRequest, String str) {
        return new MtopBusiness(aVar, mtopRequest, str);
    }

    @Deprecated
    /* renamed from: a */
    public MtopBusiness mo32742b(MtopListener gVar) {
        this.f22585a = gVar;
        return this;
    }

    /* renamed from: a */
    public MtopBusiness mo32730a(IRemoteListener cVar) {
        this.f22585a = cVar;
        return this;
    }

    /* renamed from: a */
    public String mo32736a() {
        return this.f22603z;
    }

    /* renamed from: b */
    public void mo32744b() {
        mo32737a(0, null);
    }

    /* renamed from: a */
    public void mo32737a(int i, Class<?> cls) {
        String str = "mtopsdk.MtopBusiness";
        if (this.f27898j == null) {
            TBSdkLog.m35513d(str, this.f22603z, "MtopRequest is null!");
            return;
        }
        if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
            String str2 = this.f22603z;
            StringBuilder sb = new StringBuilder("startRequest ");
            sb.append(this.f27898j);
            TBSdkLog.m35507b(str, str2, sb.toString());
        }
        this.f22591g = System.currentTimeMillis();
        this.f22594q = false;
        this.f22590f = false;
        this.f22586b = cls;
        this.f22597t = i;
        Object obj = this.f22587c;
        if (obj != null) {
            mo32740b(obj);
        }
        MtopListener gVar = this.f22585a;
        if (gVar != null && !this.f22594q) {
            super.mo32742b(MtopListenerProxyFactory.m29127a(this, gVar));
        }
        mo39754a(false);
        this.f22593i = System.currentTimeMillis();
        this.f22595r = super.mo32746c();
    }

    @Deprecated
    /* renamed from: c */
    public ApiID mo32746c() {
        mo32744b();
        return this.f22595r;
    }

    /* renamed from: d */
    public int mo32747d() {
        return this.f22597t;
    }

    /* renamed from: e */
    public boolean mo32750e() {
        return this.f22594q;
    }

    /* renamed from: a */
    public MtopBusiness mo32732a(String str, boolean z) {
        this.f22588d = str;
        this.f22589e = z;
        this.f22600w = true;
        if (TBSdkLog.m35509b(LogEnable.DebugEnable)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[setNeedAuth] authParam=");
            sb.append(str);
            sb.append(", showAuthUI=");
            sb.append(z);
            sb.append(", needAuth=");
            sb.append(this.f22600w);
            TBSdkLog.m35502a("mtopsdk.MtopBusiness", this.f22603z, sb.toString());
        }
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b1 A[Catch:{ all -> 0x01c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01da  */
    /* renamed from: a */
    public void mo32738a(mtopsdk.mtop.domain.MtopResponse r9, mtopsdk.mtop.domain.BaseOutDo r10) {
        /*
        r8 = this;
        boolean r0 = r8.f22602y
        if (r0 == 0) goto L_0x0034
        r8.f22601x = r9
        mtopsdk.mtop.common.g r0 = r8.f22585a
        monitor-enter(r0)
        mtopsdk.mtop.common.g r1 = r8.f22585a     // Catch:{ Exception -> 0x0011 }
        r1.notify()     // Catch:{ Exception -> 0x0011 }
        goto L_0x0030
    L_0x000f:
        r9 = move-exception
        goto L_0x0032
    L_0x0011:
        r1 = move-exception
        java.lang.String r2 = "mtopsdk.MtopBusiness"
        java.lang.String r3 = r8.f22603z     // Catch:{ all -> 0x000f }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x000f }
        java.lang.String r5 = "[doFinish]syncRequest do notify Exception. apiKey="
        r4.<init>(r5)     // Catch:{ all -> 0x000f }
        if (r9 == 0) goto L_0x0024
        java.lang.String r5 = r9.getFullKey()     // Catch:{ all -> 0x000f }
        goto L_0x0026
    L_0x0024:
        java.lang.String r5 = ""
    L_0x0026:
        r4.append(r5)     // Catch:{ all -> 0x000f }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x000f }
        mtopsdk.common.util.TBSdkLog.m35508b(r2, r3, r4, r1)     // Catch:{ all -> 0x000f }
    L_0x0030:
        monitor-exit(r0)     // Catch:{ all -> 0x000f }
        goto L_0x0034
    L_0x0032:
        monitor-exit(r0)     // Catch:{ all -> 0x000f }
        throw r9
    L_0x0034:
        mtopsdk.common.util.TBSdkLog$LogEnable r0 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r0 = mtopsdk.common.util.TBSdkLog.m35509b(r0)
        if (r0 == 0) goto L_0x0066
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r1 = 32
        r0.<init>(r1)
        java.lang.String r1 = "doFinish request="
        r0.append(r1)
        mtopsdk.mtop.domain.MtopRequest r1 = r8.f27898j
        r0.append(r1)
        if (r9 == 0) goto L_0x005b
        java.lang.String r1 = ", retCode="
        r0.append(r1)
        java.lang.String r1 = r9.getRetCode()
        r0.append(r1)
    L_0x005b:
        java.lang.String r1 = r8.f22603z
        java.lang.String r0 = r0.toString()
        java.lang.String r2 = "mtopsdk.MtopBusiness"
        mtopsdk.common.util.TBSdkLog.m35507b(r2, r1, r0)
    L_0x0066:
        boolean r0 = r8.f22594q
        if (r0 == 0) goto L_0x0074
        java.lang.String r9 = r8.f22603z
        java.lang.String r10 = "mtopsdk.MtopBusiness"
        java.lang.String r0 = "request is cancelled,don't callback listener."
        mtopsdk.common.util.TBSdkLog.m35511c(r10, r9, r0)
        return
    L_0x0074:
        mtopsdk.mtop.common.g r0 = r8.f22585a
        boolean r1 = r0 instanceof com.taobao.tao.remotebusiness.IRemoteListener
        if (r1 != 0) goto L_0x0099
        java.lang.String r10 = r8.f22603z
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        java.lang.String r1 = "listener did't implement IRemoteBaseListener.apiKey="
        r0.<init>(r1)
        if (r9 == 0) goto L_0x008a
        java.lang.String r9 = r9.getFullKey()
        goto L_0x008c
    L_0x008a:
        java.lang.String r9 = ""
    L_0x008c:
        r0.append(r9)
        java.lang.String r9 = r0.toString()
        java.lang.String r0 = "mtopsdk.MtopBusiness"
        mtopsdk.common.util.TBSdkLog.m35513d(r0, r10, r9)
        return
    L_0x0099:
        com.taobao.tao.remotebusiness.c r0 = (com.taobao.tao.remotebusiness.IRemoteListener) r0
        r1 = 0
        r2 = 1
        if (r9 == 0) goto L_0x0108
        boolean r3 = r9.isApiSuccess()
        if (r3 == 0) goto L_0x0108
        mtopsdk.mtop.util.MtopStatistics r3 = r8.f27902n
        long r3 = r3.mo39835a()
        mtopsdk.mtop.util.MtopStatistics r5 = r8.f27902n
        mtopsdk.mtop.util.MtopStatistics r6 = r8.f27902n
        long r6 = r6.f27933E
        long r6 = r3 - r6
        r5.f27973ar = r6
        mtopsdk.mtop.util.MtopStatistics r5 = r8.f27902n
        mtopsdk.mtop.util.MtopStatistics r6 = r8.f27902n
        long r6 = r6.f28003y
        long r3 = r3 - r6
        r5.f27974as = r3
        mtopsdk.mtop.util.MtopStatistics r3 = r8.f27902n
        com.taobao.tao.remotebusiness.b.e r4 = r8.f27904p
        mtopsdk.mtop.common.MtopNetworkProp r4 = r4.f22578d
        android.os.Handler r4 = r4.handler
        if (r4 == 0) goto L_0x00c9
        r1 = 1
    L_0x00c9:
        r3.f27971ap = r1
        int r1 = r8.f22597t     // Catch:{ all -> 0x00ec }
        java.lang.Object r2 = r8.mo39756h()     // Catch:{ all -> 0x00ec }
        r0.mo10878a(r1, r9, r10, r2)     // Catch:{ all -> 0x00ec }
        mtopsdk.mtop.common.i r10 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()     // Catch:{ all -> 0x00ec }
        if (r10 == 0) goto L_0x00f6
        java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x00ec }
        r10.<init>()     // Catch:{ all -> 0x00ec }
        java.lang.String r0 = "key_data_response"
        java.lang.String r9 = r9.getApi()     // Catch:{ all -> 0x00ec }
        r10.put(r0, r9)     // Catch:{ all -> 0x00ec }
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()     // Catch:{ all -> 0x00ec }
        goto L_0x00f6
    L_0x00ec:
        r9 = move-exception
        java.lang.String r10 = r8.f22603z
        java.lang.String r0 = "mtopsdk.MtopBusiness"
        java.lang.String r1 = "listener onSuccess callback error"
        mtopsdk.common.util.TBSdkLog.m35508b(r0, r10, r1, r9)
    L_0x00f6:
        mtopsdk.common.util.TBSdkLog$LogEnable r9 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r9 = mtopsdk.common.util.TBSdkLog.m35509b(r9)
        if (r9 == 0) goto L_0x0107
        java.lang.String r9 = r8.f22603z
        java.lang.String r10 = "mtopsdk.MtopBusiness"
        java.lang.String r0 = "listener onSuccess callback."
        mtopsdk.common.util.TBSdkLog.m35507b(r10, r9, r0)
    L_0x0107:
        return
    L_0x0108:
        boolean r10 = r8.f22590f
        if (r10 == 0) goto L_0x011a
        boolean r10 = r8.f22599v
        if (r10 != 0) goto L_0x011a
        java.lang.String r9 = r8.f22603z
        java.lang.String r10 = "mtopsdk.MtopBusiness"
        java.lang.String r0 = "listener onCached callback,doNothing in doFinish()"
        mtopsdk.common.util.TBSdkLog.m35507b(r10, r9, r0)
        return
    L_0x011a:
        if (r9 != 0) goto L_0x013c
        mtopsdk.common.util.TBSdkLog$LogEnable r10 = mtopsdk.common.util.TBSdkLog.LogEnable.ErrorEnable
        boolean r10 = mtopsdk.common.util.TBSdkLog.m35509b(r10)
        if (r10 == 0) goto L_0x0190
        java.lang.String r10 = r8.f22603z
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r3 = "mtopResponse is null."
        r1.<init>(r3)
        mtopsdk.mtop.domain.MtopRequest r3 = r8.f27898j
        r1.append(r3)
        java.lang.String r1 = r1.toString()
        java.lang.String r3 = "mtopsdk.MtopBusiness"
        mtopsdk.common.util.TBSdkLog.m35507b(r3, r10, r1)
        goto L_0x0190
    L_0x013c:
        boolean r10 = r9.isSessionInvalid()
        if (r10 == 0) goto L_0x0162
        mtopsdk.common.util.TBSdkLog$LogEnable r10 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r10 = mtopsdk.common.util.TBSdkLog.m35509b(r10)
        if (r10 == 0) goto L_0x0190
        java.lang.String r10 = r8.f22603z
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r3 = "session invalid error."
        r1.<init>(r3)
        mtopsdk.mtop.domain.MtopRequest r3 = r8.f27898j
        r1.append(r3)
        java.lang.String r1 = r1.toString()
        java.lang.String r3 = "mtopsdk.MtopBusiness"
        mtopsdk.common.util.TBSdkLog.m35507b(r3, r10, r1)
        goto L_0x0190
    L_0x0162:
        boolean r10 = r9.isMtopServerError()
        if (r10 != 0) goto L_0x0171
        boolean r10 = r9.isMtopSdkError()
        if (r10 == 0) goto L_0x016f
        goto L_0x0171
    L_0x016f:
        r2 = 0
        goto L_0x0190
    L_0x0171:
        mtopsdk.common.util.TBSdkLog$LogEnable r10 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r10 = mtopsdk.common.util.TBSdkLog.m35509b(r10)
        if (r10 == 0) goto L_0x0190
        java.lang.String r10 = r8.f22603z
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        java.lang.String r3 = "mtopServerError or mtopSdkError."
        r1.<init>(r3)
        mtopsdk.mtop.domain.MtopRequest r3 = r8.f27898j
        r1.append(r3)
        java.lang.String r1 = r1.toString()
        java.lang.String r3 = "mtopsdk.MtopBusiness"
        mtopsdk.common.util.TBSdkLog.m35507b(r3, r10, r1)
    L_0x0190:
        if (r2 == 0) goto L_0x01a2
        boolean r10 = r0 instanceof com.taobao.tao.remotebusiness.IRemoteBaseListener     // Catch:{ all -> 0x01c8 }
        if (r10 == 0) goto L_0x01a2
        com.taobao.tao.remotebusiness.a r0 = (com.taobao.tao.remotebusiness.IRemoteBaseListener) r0     // Catch:{ all -> 0x01c8 }
        int r10 = r8.f22597t     // Catch:{ all -> 0x01c8 }
        java.lang.Object r1 = r8.mo39756h()     // Catch:{ all -> 0x01c8 }
        r0.mo10877a(r10, r9, r1)     // Catch:{ all -> 0x01c8 }
        goto L_0x01ab
    L_0x01a2:
        int r10 = r8.f22597t     // Catch:{ all -> 0x01c8 }
        java.lang.Object r1 = r8.mo39756h()     // Catch:{ all -> 0x01c8 }
        r0.mo10879b(r10, r9, r1)     // Catch:{ all -> 0x01c8 }
    L_0x01ab:
        mtopsdk.mtop.common.i r10 = mtopsdk.mtop.p691c.MtopMonitor.m35554a()     // Catch:{ all -> 0x01c8 }
        if (r10 == 0) goto L_0x01d2
        java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x01c8 }
        r10.<init>()     // Catch:{ all -> 0x01c8 }
        java.lang.String r0 = "key_data_response"
        if (r9 == 0) goto L_0x01bf
        java.lang.String r9 = r9.getApi()     // Catch:{ all -> 0x01c8 }
        goto L_0x01c1
    L_0x01bf:
        java.lang.String r9 = "response null"
    L_0x01c1:
        r10.put(r0, r9)     // Catch:{ all -> 0x01c8 }
        mtopsdk.mtop.p691c.MtopMonitor.m35554a()     // Catch:{ all -> 0x01c8 }
        goto L_0x01d2
    L_0x01c8:
        r9 = move-exception
        java.lang.String r10 = r8.f22603z
        java.lang.String r0 = "mtopsdk.MtopBusiness"
        java.lang.String r1 = "listener onError callback error"
        mtopsdk.common.util.TBSdkLog.m35508b(r0, r10, r1, r9)
    L_0x01d2:
        mtopsdk.common.util.TBSdkLog$LogEnable r9 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
        boolean r9 = mtopsdk.common.util.TBSdkLog.m35509b(r9)
        if (r9 == 0) goto L_0x01f6
        java.lang.String r9 = r8.f22603z
        java.lang.StringBuilder r10 = new java.lang.StringBuilder
        java.lang.String r0 = "listener onError callback, "
        r10.<init>(r0)
        if (r2 == 0) goto L_0x01e8
        java.lang.String r0 = "sys error"
        goto L_0x01ea
    L_0x01e8:
        java.lang.String r0 = "biz error"
    L_0x01ea:
        r10.append(r0)
        java.lang.String r10 = r10.toString()
        java.lang.String r0 = "mtopsdk.MtopBusiness"
        mtopsdk.common.util.TBSdkLog.m35507b(r0, r9, r10)
    L_0x01f6:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.MtopBusiness.mo32738a(mtopsdk.mtop.domain.MtopResponse, mtopsdk.mtop.domain.a):void");
    }

    /* renamed from: f */
    public MtopBusiness mo32753g() {
        return (MtopBusiness) super.mo32753g();
    }

    @Deprecated
    /* renamed from: a */
    public MtopBusiness mo32752f(int i) {
        return (MtopBusiness) super.mo32752f(i);
    }

    /* renamed from: a */
    public MtopBusiness mo32741b(Map<String, String> map) {
        return (MtopBusiness) super.mo32741b(map);
    }

    /* renamed from: a */
    public MtopBusiness mo32740b(Object obj) {
        return (MtopBusiness) super.mo32740b(obj);
    }

    /* renamed from: a */
    public MtopBusiness mo32743b(MethodEnum methodEnum) {
        return (MtopBusiness) super.mo32743b(methodEnum);
    }

    /* renamed from: b */
    public MtopBusiness mo32749e(int i) {
        return (MtopBusiness) super.mo32749e(i);
    }

    /* renamed from: c */
    public MtopBusiness mo32748d(int i) {
        return (MtopBusiness) super.mo32748d(i);
    }
}
