package mtopsdk.mtop.util;

import android.text.TextUtils;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.mid.sotrage.StorageInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.C8330d;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.TBSdkLog.LogEnable;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.common.MtopStatsListener;
import mtopsdk.mtop.p689a.SwitchConfig;
import mtopsdk.mtop.p690b.Mtop;
import mtopsdk.mtop.p691c.IUploadStats;
import mtopsdk.network.domain.NetworkStats;

public class MtopStatistics implements Cloneable {
    /* renamed from: aw */
    private static volatile AtomicBoolean f27928aw = new AtomicBoolean(false);
    /* renamed from: A */
    public long f27929A;
    /* renamed from: B */
    public long f27930B;
    /* renamed from: C */
    public long f27931C;
    /* renamed from: D */
    public long f27932D;
    /* renamed from: E */
    public long f27933E;
    /* renamed from: F */
    public long f27934F;
    /* renamed from: G */
    public long f27935G;
    /* renamed from: H */
    public long f27936H;
    /* renamed from: I */
    public long f27937I;
    /* renamed from: J */
    public long f27938J;
    /* renamed from: K */
    public long f27939K;
    /* renamed from: L */
    public long f27940L;
    /* renamed from: M */
    public NetworkStats f27941M;
    /* renamed from: N */
    public String f27942N;
    /* renamed from: O */
    public final String f27943O;
    /* renamed from: P */
    public int f27944P;
    /* renamed from: Q */
    public int f27945Q;
    /* renamed from: R */
    public String f27946R;
    /* renamed from: S */
    public String f27947S;
    /* renamed from: T */
    public String f27948T;
    /* renamed from: U */
    public String f27949U;
    /* renamed from: V */
    public String f27950V;
    /* renamed from: W */
    public boolean f27951W;
    /* renamed from: X */
    public boolean f27952X;
    /* renamed from: Y */
    public String f27953Y;
    /* renamed from: Z */
    public String f27954Z;
    /* renamed from: a */
    public boolean f27955a;
    @Deprecated
    /* renamed from: aa */
    public int f27956aa;
    /* renamed from: ab */
    public String f27957ab;
    /* renamed from: ac */
    public boolean f27958ac;
    /* renamed from: ad */
    public boolean f27959ad;
    /* renamed from: ae */
    public String f27960ae;
    /* renamed from: af */
    public boolean f27961af;
    /* renamed from: ag */
    public int f27962ag;
    /* renamed from: ah */
    public long f27963ah;
    /* renamed from: ai */
    public int f27964ai;
    /* renamed from: aj */
    public long f27965aj;
    /* renamed from: ak */
    public long f27966ak;
    /* renamed from: al */
    public long f27967al;
    /* renamed from: am */
    public long f27968am;
    /* renamed from: an */
    public long f27969an;
    /* renamed from: ao */
    public boolean f27970ao;
    /* renamed from: ap */
    public boolean f27971ap;
    /* renamed from: aq */
    public long f27972aq;
    /* renamed from: ar */
    public long f27973ar;
    /* renamed from: as */
    public long f27974as;
    /* renamed from: at */
    private long f27975at;
    /* renamed from: au */
    private String f27976au;
    /* renamed from: av */
    private C8336a f27977av;
    /* renamed from: ax */
    private IUploadStats f27978ax;
    /* renamed from: ay */
    private MtopStatsListener f27979ay;
    /* renamed from: b */
    public boolean f27980b;
    /* renamed from: c */
    public long f27981c;
    /* renamed from: d */
    public long f27982d;
    /* renamed from: e */
    public long f27983e;
    /* renamed from: f */
    public long f27984f;
    /* renamed from: g */
    public long f27985g;
    /* renamed from: h */
    public long f27986h;
    /* renamed from: i */
    public long f27987i;
    /* renamed from: j */
    public long f27988j;
    /* renamed from: k */
    public long f27989k;
    /* renamed from: l */
    public long f27990l;
    /* renamed from: m */
    public long f27991m;
    /* renamed from: n */
    public long f27992n;
    /* renamed from: o */
    public long f27993o;
    /* renamed from: p */
    public int f27994p;
    /* renamed from: q */
    public long f27995q;
    /* renamed from: r */
    public int f27996r;
    /* renamed from: s */
    public long f27997s;
    /* renamed from: t */
    public int f27998t;
    /* renamed from: u */
    public String f27999u;
    /* renamed from: v */
    public int f28000v;
    /* renamed from: w */
    public String f28001w;
    /* renamed from: x */
    public String f28002x;
    /* renamed from: y */
    public long f28003y;
    /* renamed from: z */
    public long f28004z;

    /* renamed from: mtopsdk.mtop.util.MtopStatistics$RetType */
    public interface RetType {

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: mtopsdk.mtop.util.MtopStatistics$RetType$Definition */
        public @interface Definition {
        }
    }

    /* renamed from: mtopsdk.mtop.util.MtopStatistics$a */
    public class C8336a implements Cloneable {
        /* renamed from: a */
        public long f28005a;
        /* renamed from: b */
        public long f28006b;
        /* renamed from: c */
        public long f28007c;
        /* renamed from: d */
        public long f28008d;
        @Deprecated
        /* renamed from: e */
        public long f28009e;
        /* renamed from: f */
        public long f28010f;
        @Deprecated
        /* renamed from: g */
        public long f28011g;
        /* renamed from: h */
        public long f28012h;
        /* renamed from: i */
        public long f28013i;
        /* renamed from: j */
        public long f28014j;
        /* renamed from: k */
        public long f28015k;
        /* renamed from: l */
        public int f28016l;

        /* synthetic */ C8336a(MtopStatistics mtopStatistics, byte b) {
            this(mtopStatistics);
        }

        private C8336a(MtopStatistics mtopStatistics) {
            this.f28016l = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("rbReqTime=");
            sb.append(this.f28008d);
            sb.append(",mtopReqTime=");
            sb.append(this.f28005a);
            sb.append(",mtopJsonParseTime=");
            sb.append(this.f28010f);
            sb.append(",toMainThTime=");
            sb.append(this.f28013i);
            sb.append(",mtopDispatchTime=");
            sb.append(this.f28014j);
            sb.append(",bizCallbackTime=");
            sb.append(this.f28015k);
            sb.append(",isCache=");
            sb.append(this.f28016l);
            sb.append(",beforeReqTime=");
            sb.append(this.f28006b);
            sb.append(",afterReqTime=");
            sb.append(this.f28007c);
            sb.append(",parseTime=");
            sb.append(this.f28012h);
            return sb.toString();
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public MtopStatistics(IUploadStats aVar, MtopStatsListener iVar) {
        this.f27955a = true;
        this.f27994p = 0;
        this.f28000v = 0;
        String str = "";
        this.f27976au = str;
        this.f27942N = str;
        this.f27952X = true;
        this.f27960ae = str;
        this.f27961af = false;
        this.f27964ai = 0;
        this.f27965aj = -1;
        this.f27970ao = false;
        this.f27978ax = aVar;
        this.f27979ay = iVar;
        this.f27944P = MtopUtils.m35516a();
        StringBuilder sb = new StringBuilder("MTOP");
        sb.append(this.f27944P);
        this.f27943O = sb.toString();
    }

    public MtopStatistics(IUploadStats aVar, MtopStatsListener iVar, MtopNetworkProp mtopNetworkProp) {
        this(aVar, iVar);
        if (mtopNetworkProp != null) {
            this.f27950V = mtopNetworkProp.pageName;
            this.f27949U = MtopUtils.m35517a(mtopNetworkProp.pageUrl);
            this.f27951W = mtopNetworkProp.backGround;
        }
    }

    /* renamed from: a */
    public long mo39835a() {
        return System.nanoTime() / 1000000;
    }

    /* renamed from: b */
    public void mo39837b() {
        this.f27975at = mo39835a();
        long j = this.f27975at;
        long j2 = this.f28003y;
        this.f27981c = j - j2;
        long j3 = this.f28004z;
        long j4 = 0;
        this.f27983e = j3 > j2 ? j3 - j2 : 0;
        long j5 = this.f27929A;
        this.f27995q = j5 > 0 ? j5 - this.f28003y : 0;
        this.f27997s = this.f27931C - this.f27930B;
        if (this.f27933E == 0) {
            this.f27933E = mo39835a();
        }
        long j6 = this.f27933E;
        this.f27982d = j6 - this.f27932D;
        long j7 = this.f27934F;
        if (j7 > j6) {
            j4 = j7 - j6;
        }
        this.f27987i = j4;
        this.f27984f = this.f27989k - this.f28004z;
        long j8 = this.f27932D;
        this.f27985g = j8 - this.f27990l;
        this.f27986h = this.f27975at - this.f27934F;
        this.f27972aq = j8 - this.f28003y;
        StringBuilder sb = new StringBuilder(128);
        sb.append("apiKey=");
        sb.append(this.f27942N);
        sb.append(",httpResponseStatus=");
        sb.append(this.f27998t);
        sb.append(",retCode=");
        sb.append(this.f27999u);
        sb.append(",retType=");
        sb.append(this.f28000v);
        sb.append(",reqSource=");
        sb.append(this.f27945Q);
        sb.append(",mappingCode=");
        sb.append(this.f28001w);
        sb.append(",isCbMain=");
        sb.append(this.f27952X);
        sb.append(",isReqMain=");
        sb.append(this.f27959ad);
        sb.append(",isReqSync=");
        sb.append(this.f27958ac);
        sb.append(",mtopTotalTime=");
        sb.append(this.f27981c);
        sb.append(",waitExecuteTime=");
        sb.append(this.f27983e);
        sb.append(",waitExecute2BuildParamTime=");
        sb.append(this.f27984f);
        sb.append(",buildParamsTime=");
        sb.append(this.f27988j);
        sb.append(",buildParams2NetworkTime=");
        sb.append(this.f27985g);
        sb.append(",networkTotalTime=");
        sb.append(this.f27982d);
        sb.append(",waitCallbackTime=");
        sb.append(this.f27987i);
        sb.append(",startCallBack2EndTime=");
        sb.append(this.f27986h);
        sb.append(",computeSignTime=");
        sb.append(this.f27991m);
        sb.append(",computeMiniWuaTime=");
        sb.append(this.f27993o);
        sb.append(",computeWuaTime=");
        sb.append(this.f27992n);
        sb.append(",cacheSwitch=");
        sb.append(this.f27996r);
        sb.append(",cacheHitType=");
        sb.append(this.f27994p);
        sb.append(",cacheCostTime=");
        sb.append(this.f27995q);
        sb.append(",cacheResponseParseTime=");
        sb.append(this.f27997s);
        sb.append(",useSecurityAdapter=");
        sb.append(SwitchConfig.m35527a().mo39748f());
        sb.append(",isPrefetch=");
        sb.append(this.f27970ao);
        if (this.f27941M != null) {
            sb.append(StorageInterface.KEY_SPLITER);
            if (C8330d.m35525b(this.f27941M.netStatSum)) {
                sb.append(this.f27941M.sumNetStat());
            } else {
                sb.append(this.f27941M.netStatSum);
            }
        }
        this.f27976au = sb.toString();
        if (this.f27955a && !this.f27980b) {
            if (MtopUtils.m35519b()) {
                MtopSDKThreadPoolExecutorFactory.m35583a(new C8339d(this));
            } else {
                m35571h();
            }
        }
        TBSdkLog.m35512d(this.f27946R, this.f27947S);
        if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
            TBSdkLog.m35507b("mtopsdk.MtopStatistics", this.f27943O, toString());
        }
    }

    /* renamed from: c */
    public NetworkStats mo39838c() {
        return this.f27941M;
    }

    /* renamed from: a */
    public void mo39836a(boolean z) {
        this.f27955a = z;
        if (this.f27955a && !this.f27980b) {
            if (MtopUtils.m35519b()) {
                MtopSDKThreadPoolExecutorFactory.m35583a(new C8340e(this));
                return;
            }
            m35571h();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x03e8 A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x04b3 A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x050b A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0563 A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0574 A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0636 A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0639 A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x06c7 A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02e6 A[Catch:{ all -> 0x06d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02e8 A[Catch:{ all -> 0x06d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02fa A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02fc A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x031b A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x031d A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x032b A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x032d A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x033b A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0365 A[Catch:{ all -> 0x06d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x036b A[Catch:{ all -> 0x06d4 }] */
    /* renamed from: h */
    public void m35571h() {
        /*
        r31 = this;
        r1 = r31
        mtopsdk.mtop.c.a r2 = r1.f27978ax
        if (r2 != 0) goto L_0x0007
        return
    L_0x0007:
        java.util.concurrent.atomic.AtomicBoolean r2 = f27928aw
        r3 = 1
        r4 = 0
        boolean r2 = r2.compareAndSet(r4, r3)
        java.lang.String r5 = "securityFeature"
        java.lang.String r6 = "backGround"
        java.lang.String r7 = "pageUrl"
        java.lang.String r8 = "pageName"
        java.lang.String r9 = "serverTraceId"
        java.lang.String r10 = "clientTraceId"
        java.lang.String r11 = "reqSource"
        java.lang.String r12 = "retType"
        java.lang.String r13 = "mtopsdk.MtopStatistics"
        java.lang.String r14 = "httpResponseStatus"
        java.lang.String r15 = "domain"
        java.lang.String r4 = "ret"
        java.lang.String r3 = "api"
        if (r2 == 0) goto L_0x027f
        mtopsdk.mtop.c.a r2 = r1.f27978ax     // Catch:{ all -> 0x025d }
        if (r2 != 0) goto L_0x004a
        java.lang.String r2 = r1.f27943O     // Catch:{ all -> 0x0041 }
        java.lang.String r1 = "[registerMtopStats]register MtopStats error, uploadStats=null"
        mtopsdk.common.util.TBSdkLog.m35513d(r13, r2, r1)     // Catch:{ all -> 0x0041 }
        r24 = r5
        r17 = r6
        r18 = r7
        r5 = r13
        r13 = r31
        goto L_0x0287
    L_0x0041:
        r0 = move-exception
        r1 = r0
        r24 = r5
        r5 = r13
        r13 = r31
        goto L_0x0263
    L_0x004a:
        java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0256 }
        r1.<init>()     // Catch:{ all -> 0x0256 }
        r1.add(r3)     // Catch:{ all -> 0x0256 }
        r1.add(r15)     // Catch:{ all -> 0x0256 }
        r1.add(r14)     // Catch:{ all -> 0x0256 }
        r1.add(r4)     // Catch:{ all -> 0x0256 }
        r1.add(r12)     // Catch:{ all -> 0x0256 }
        r1.add(r11)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "cacheSwitch"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "cacheHitType"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        r1.add(r10)     // Catch:{ all -> 0x0256 }
        r1.add(r9)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "connType"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "isSSL"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "retryTimes"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "ip_port"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        r1.add(r8)     // Catch:{ all -> 0x0256 }
        r1.add(r7)     // Catch:{ all -> 0x0256 }
        r1.add(r6)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "isMain"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "isPrefetch"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "handler"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "launchType"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "appLaunchExternal"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "sinceAppLaunchInterval"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "deviceLevel"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "sinceLastLaunchInternal"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        r1.add(r5)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "speedBucket"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.lang.String r2 = "speedBucketId"
        r1.add(r2)     // Catch:{ all -> 0x0256 }
        java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0256 }
        r2.<init>()     // Catch:{ all -> 0x0256 }
        r23 = r13
        java.lang.String r13 = "totalTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "waitExecuteTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "waitExecute2BuildParamTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "buildParamsTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "buildParams2NetworkTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "networkExeTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "waitCallbackTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "startCallBack2EndTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "cacheCostTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "cacheResponseParseTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "signTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "wuaTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "miniWuaTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "requestPocTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "callbackPocTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "allTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "rbReqTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "toMainThTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "mtopDispatchTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "bizCallbackTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "mtopJsonParseTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "mtopReqTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "processTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "firstDataTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "recDataTime"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "revSize"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "dataSpeed"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "oneWayTime_ANet"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        java.lang.String r13 = "serverRT"
        r2.add(r13)     // Catch:{ all -> 0x024e }
        r13 = r31
        r24 = r5
        mtopsdk.mtop.c.a r5 = r13.f27978ax     // Catch:{ all -> 0x024c }
        if (r5 == 0) goto L_0x017b
        mtopsdk.mtop.c.a r5 = r13.f27978ax     // Catch:{ all -> 0x0175 }
        java.lang.String r18 = "mtopsdk"
        java.lang.String r19 = "mtopStats"
        r22 = 0
        r17 = r5
        r20 = r1
        r21 = r2
        r17.mo39759a(r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0175 }
        goto L_0x017b
    L_0x0175:
        r0 = move-exception
        r1 = r0
    L_0x0177:
        r5 = r23
        goto L_0x0263
    L_0x017b:
        java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x024c }
        r1.<init>()     // Catch:{ all -> 0x024c }
        r1.add(r3)     // Catch:{ all -> 0x024c }
        r1.add(r15)     // Catch:{ all -> 0x024c }
        r1.add(r4)     // Catch:{ all -> 0x024c }
        r1.add(r12)     // Catch:{ all -> 0x024c }
        r1.add(r11)     // Catch:{ all -> 0x024c }
        java.lang.String r2 = "mappingCode"
        r1.add(r2)     // Catch:{ all -> 0x024c }
        r1.add(r14)     // Catch:{ all -> 0x024c }
        java.lang.String r2 = "refer"
        r1.add(r2)     // Catch:{ all -> 0x024c }
        r1.add(r10)     // Catch:{ all -> 0x024c }
        r1.add(r9)     // Catch:{ all -> 0x024c }
        r1.add(r8)     // Catch:{ all -> 0x024c }
        r1.add(r7)     // Catch:{ all -> 0x024c }
        r1.add(r6)     // Catch:{ all -> 0x024c }
        r2 = r24
        r1.add(r2)     // Catch:{ all -> 0x0248 }
        mtopsdk.mtop.c.a r5 = r13.f27978ax     // Catch:{ all -> 0x0248 }
        if (r5 == 0) goto L_0x01cb
        mtopsdk.mtop.c.a r5 = r13.f27978ax     // Catch:{ all -> 0x01c6 }
        java.lang.String r26 = "mtopsdk"
        java.lang.String r27 = "mtopExceptions"
        r29 = 0
        r30 = 0
        r25 = r5
        r28 = r1
        r25.mo39759a(r26, r27, r28, r29, r30)     // Catch:{ all -> 0x01c6 }
        goto L_0x01cb
    L_0x01c6:
        r0 = move-exception
        r1 = r0
        r24 = r2
        goto L_0x0177
    L_0x01cb:
        java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0248 }
        r1.<init>()     // Catch:{ all -> 0x0248 }
        java.lang.String r5 = "bizId"
        r1.add(r5)     // Catch:{ all -> 0x0248 }
        r1.add(r3)     // Catch:{ all -> 0x0248 }
        java.lang.String r5 = "version"
        r1.add(r5)     // Catch:{ all -> 0x0248 }
        r1.add(r15)     // Catch:{ all -> 0x0248 }
        r1.add(r14)     // Catch:{ all -> 0x0248 }
        r1.add(r4)     // Catch:{ all -> 0x0248 }
        java.lang.String r5 = "bxSessionId"
        r1.add(r5)     // Catch:{ all -> 0x0248 }
        java.lang.String r5 = "bxUI"
        r1.add(r5)     // Catch:{ all -> 0x0248 }
        java.lang.String r5 = "bxMainAction"
        r1.add(r5)     // Catch:{ all -> 0x0248 }
        java.lang.String r5 = "bxSubAction"
        r1.add(r5)     // Catch:{ all -> 0x0248 }
        java.lang.String r5 = "bxRetry"
        r1.add(r5)     // Catch:{ all -> 0x0248 }
        java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0248 }
        r5.<init>()     // Catch:{ all -> 0x0248 }
        r24 = r2
        java.lang.String r2 = "bxSleep"
        r5.add(r2)     // Catch:{ all -> 0x024c }
        java.lang.String r2 = "checkTime"
        r5.add(r2)     // Catch:{ all -> 0x024c }
        java.lang.String r2 = "processTime"
        r5.add(r2)     // Catch:{ all -> 0x024c }
        mtopsdk.mtop.c.a r2 = r13.f27978ax     // Catch:{ all -> 0x024c }
        if (r2 == 0) goto L_0x022a
        mtopsdk.mtop.c.a r2 = r13.f27978ax     // Catch:{ all -> 0x0175 }
        java.lang.String r18 = "mtopsdk"
        java.lang.String r19 = "baxiaAction"
        r22 = 0
        r17 = r2
        r20 = r1
        r21 = r5
        r17.mo39759a(r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0175 }
    L_0x022a:
        java.lang.String r1 = r13.f27943O     // Catch:{ all -> 0x024c }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
        java.lang.String r5 = "[registerMtopStats]register MtopStats executed.uploadStats="
        r2.<init>(r5)     // Catch:{ all -> 0x024c }
        mtopsdk.mtop.c.a r5 = r13.f27978ax     // Catch:{ all -> 0x024c }
        r2.append(r5)     // Catch:{ all -> 0x024c }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x024c }
        r5 = r23
        mtopsdk.common.util.TBSdkLog.m35507b(r5, r1, r2)     // Catch:{ all -> 0x0246 }
        r17 = r6
        r18 = r7
        goto L_0x0287
    L_0x0246:
        r0 = move-exception
        goto L_0x0262
    L_0x0248:
        r0 = move-exception
        r24 = r2
        goto L_0x0253
    L_0x024c:
        r0 = move-exception
        goto L_0x0253
    L_0x024e:
        r0 = move-exception
        r13 = r31
        r24 = r5
    L_0x0253:
        r5 = r23
        goto L_0x0262
    L_0x0256:
        r0 = move-exception
        r24 = r5
        r5 = r13
        r13 = r31
        goto L_0x0262
    L_0x025d:
        r0 = move-exception
        r24 = r5
        r5 = r13
        r13 = r1
    L_0x0262:
        r1 = r0
    L_0x0263:
        java.lang.String r2 = r13.f27943O
        r17 = r6
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r18 = r7
        java.lang.String r7 = "[registerMtopStats] register MtopStats error ---"
        r6.<init>(r7)
        java.lang.String r1 = r1.toString()
        r6.append(r1)
        java.lang.String r1 = r6.toString()
        mtopsdk.common.util.TBSdkLog.m35513d(r5, r2, r1)
        goto L_0x0287
    L_0x027f:
        r24 = r5
        r17 = r6
        r18 = r7
        r5 = r13
        r13 = r1
    L_0x0287:
        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x06d6 }
        r1.<init>()     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = r13.f27942N     // Catch:{ all -> 0x06d6 }
        r1.put(r3, r2)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = r13.f27999u     // Catch:{ all -> 0x06d6 }
        r1.put(r4, r2)     // Catch:{ all -> 0x06d6 }
        int r2 = r13.f28000v     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d6 }
        r1.put(r12, r2)     // Catch:{ all -> 0x06d6 }
        int r2 = r13.f27998t     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d6 }
        r1.put(r14, r2)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = r13.f28002x     // Catch:{ all -> 0x06d6 }
        r1.put(r15, r2)     // Catch:{ all -> 0x06d6 }
        int r2 = r13.f27945Q     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d6 }
        r1.put(r11, r2)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = "cacheSwitch"
        int r6 = r13.f27996r     // Catch:{ all -> 0x06d6 }
        java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x06d6 }
        r1.put(r2, r6)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = "cacheHitType"
        int r6 = r13.f27994p     // Catch:{ all -> 0x06d6 }
        java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x06d6 }
        r1.put(r2, r6)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = r13.f27946R     // Catch:{ all -> 0x06d6 }
        r1.put(r10, r2)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = r13.f27947S     // Catch:{ all -> 0x06d6 }
        r1.put(r9, r2)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = r13.f27950V     // Catch:{ all -> 0x06d6 }
        r1.put(r8, r2)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = r13.f27949U     // Catch:{ all -> 0x06d6 }
        r6 = r18
        r1.put(r6, r2)     // Catch:{ all -> 0x06d6 }
        boolean r2 = r13.f27951W     // Catch:{ all -> 0x06d6 }
        if (r2 == 0) goto L_0x02e8
        r2 = 1
        goto L_0x02e9
    L_0x02e8:
        r2 = 0
    L_0x02e9:
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d6 }
        r7 = r17
        r1.put(r7, r2)     // Catch:{ all -> 0x06d6 }
        java.lang.String r2 = "isMain"
        r23 = r5
        boolean r5 = r13.f27952X     // Catch:{ all -> 0x06d4 }
        if (r5 == 0) goto L_0x02fc
        r5 = 1
        goto L_0x02fd
    L_0x02fc:
        r5 = 0
    L_0x02fd:
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
        mtopsdk.common.util.c r2 = mtopsdk.common.util.RemoteConfig.m35521a()     // Catch:{ all -> 0x06d4 }
        int r2 = r2.f27865r     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d4 }
        r5 = r24
        r1.put(r5, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "isPrefetch"
        r24 = r5
        boolean r5 = r13.f27970ao     // Catch:{ all -> 0x06d4 }
        if (r5 == 0) goto L_0x031d
        r5 = 1
        goto L_0x031e
    L_0x031d:
        r5 = 0
    L_0x031e:
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "handler"
        boolean r5 = r13.f27971ap     // Catch:{ all -> 0x06d4 }
        if (r5 == 0) goto L_0x032d
        r5 = 1
        goto L_0x032e
    L_0x032d:
        r5 = 0
    L_0x032e:
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
        mtopsdk.network.domain.NetworkStats r2 = r31.mo39838c()     // Catch:{ all -> 0x06d4 }
        if (r2 == 0) goto L_0x0365
        java.lang.String r5 = "connType"
        r17 = r7
        java.lang.String r7 = r2.connectionType     // Catch:{ all -> 0x06d4 }
        r1.put(r5, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = "isSSL"
        boolean r7 = r2.isSSL     // Catch:{ all -> 0x06d4 }
        if (r7 == 0) goto L_0x034d
        java.lang.String r7 = "1"
        goto L_0x034f
    L_0x034d:
        java.lang.String r7 = "0"
    L_0x034f:
        r1.put(r5, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = "retryTimes"
        int r7 = r2.retryTimes     // Catch:{ all -> 0x06d4 }
        java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r1.put(r5, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = "ip_port"
        java.lang.String r7 = r2.ip_port     // Catch:{ all -> 0x06d4 }
        r1.put(r5, r7)     // Catch:{ all -> 0x06d4 }
        goto L_0x0367
    L_0x0365:
        r17 = r7
    L_0x0367:
        boolean r5 = mtopsdk.mtop.p690b.Mtop.f27892a     // Catch:{ all -> 0x06d4 }
        if (r5 == 0) goto L_0x03e8
        java.lang.String r5 = "launchType"
        int r7 = com.taobao.analysis.scene.SceneIdentifier.getStartType()     // Catch:{ all -> 0x06d4 }
        java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r1.put(r5, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = "appLaunchExternal"
        boolean r7 = com.taobao.analysis.scene.SceneIdentifier.isUrlLaunch()     // Catch:{ all -> 0x06d4 }
        if (r7 == 0) goto L_0x0383
        java.lang.String r7 = "1"
        goto L_0x0385
    L_0x0383:
        java.lang.String r7 = "0"
    L_0x0385:
        r1.put(r5, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = "sinceAppLaunchInterval"
        r18 = r6
        long r6 = r13.f27935G     // Catch:{ all -> 0x06d4 }
        long r19 = com.taobao.analysis.scene.SceneIdentifier.getAppLaunchTime()     // Catch:{ all -> 0x06d4 }
        long r6 = r6 - r19
        java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x06d4 }
        r1.put(r5, r6)     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = "deviceLevel"
        int r6 = com.taobao.analysis.scene.SceneIdentifier.getDeviceLevel()     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x06d4 }
        r1.put(r5, r6)     // Catch:{ all -> 0x06d4 }
        int r5 = com.taobao.analysis.scene.SceneIdentifier.getStartType()     // Catch:{ all -> 0x06d4 }
        r6 = 1
        if (r5 == r6) goto L_0x03c3
        long r19 = com.taobao.analysis.scene.SceneIdentifier.getAppLaunchTime()     // Catch:{ all -> 0x06d4 }
        long r21 = com.taobao.analysis.scene.SceneIdentifier.getLastLaunchTime()     // Catch:{ all -> 0x06d4 }
        long r6 = r19 - r21
        int r5 = (int) r6     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "sinceLastLaunchInternal"
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x06d4 }
        r1.put(r6, r5)     // Catch:{ all -> 0x06d4 }
    L_0x03c3:
        java.lang.String r5 = com.taobao.analysis.abtest.ABTestCenter.getTBSpeedBucket()     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "speedBucket"
        boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x06d4 }
        if (r7 == 0) goto L_0x03d1
        java.lang.String r5 = "0"
    L_0x03d1:
        r1.put(r6, r5)     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = "mtopsdk"
        java.lang.String r5 = com.taobao.analysis.abtest.ABTestCenter.getUTABTestBucketId(r5)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "speedBucketId"
        boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x06d4 }
        if (r7 == 0) goto L_0x03e4
        java.lang.String r5 = "0"
    L_0x03e4:
        r1.put(r6, r5)     // Catch:{ all -> 0x06d4 }
        goto L_0x03ea
    L_0x03e8:
        r18 = r6
    L_0x03ea:
        java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x06d4 }
        r5.<init>()     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "totalTime"
        r19 = r8
        long r7 = r13.f27981c     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "networkExeTime"
        long r7 = r13.f27982d     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "cacheCostTime"
        long r7 = r13.f27995q     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "cacheResponseParseTime"
        long r7 = r13.f27997s     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "waitExecuteTime"
        long r7 = r13.f27983e     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "waitCallbackTime"
        long r7 = r13.f27987i     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "waitExecute2BuildParamTime"
        long r7 = r13.f27984f     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "buildParamsTime"
        long r7 = r13.f27988j     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "buildParams2NetworkTime"
        long r7 = r13.f27985g     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "startCallBack2EndTime"
        long r7 = r13.f27986h     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "signTime"
        long r7 = r13.f27991m     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "wuaTime"
        long r7 = r13.f27992n     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "miniWuaTime"
        long r7 = r13.f27993o     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "callbackPocTime"
        long r7 = r13.f27973ar     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "allTime"
        long r7 = r13.f27974as     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "requestPocTime"
        long r7 = r13.f27972aq     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        if (r2 == 0) goto L_0x0507
        java.lang.String r6 = "processTime"
        long r7 = r2.processTime     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "firstDataTime"
        long r7 = r2.firstDataTime     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "recDataTime"
        long r7 = r2.recDataTime     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "oneWayTime_ANet"
        long r7 = r2.oneWayTime_ANet     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "serverRT"
        long r7 = r2.serverRT     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "revSize"
        long r7 = r2.recvSize     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r7)     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "dataSpeed"
        long r7 = r2.dataSpeed     // Catch:{ all -> 0x06d4 }
        double r7 = (double) r7     // Catch:{ all -> 0x06d4 }
        java.lang.Double r2 = java.lang.Double.valueOf(r7)     // Catch:{ all -> 0x06d4 }
        r5.put(r6, r2)     // Catch:{ all -> 0x06d4 }
    L_0x0507:
        mtopsdk.mtop.util.MtopStatistics$a r2 = r13.f27977av     // Catch:{ all -> 0x06d4 }
        if (r2 == 0) goto L_0x055f
        java.lang.String r2 = "rbReqTime"
        mtopsdk.mtop.util.MtopStatistics$a r6 = r13.f27977av     // Catch:{ all -> 0x06d4 }
        long r6 = r6.f28008d     // Catch:{ all -> 0x06d4 }
        double r6 = (double) r6     // Catch:{ all -> 0x06d4 }
        java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x06d4 }
        r5.put(r2, r6)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "toMainThTime"
        mtopsdk.mtop.util.MtopStatistics$a r6 = r13.f27977av     // Catch:{ all -> 0x06d4 }
        long r6 = r6.f28013i     // Catch:{ all -> 0x06d4 }
        double r6 = (double) r6     // Catch:{ all -> 0x06d4 }
        java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x06d4 }
        r5.put(r2, r6)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "mtopDispatchTime"
        mtopsdk.mtop.util.MtopStatistics$a r6 = r13.f27977av     // Catch:{ all -> 0x06d4 }
        long r6 = r6.f28014j     // Catch:{ all -> 0x06d4 }
        double r6 = (double) r6     // Catch:{ all -> 0x06d4 }
        java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x06d4 }
        r5.put(r2, r6)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "bizCallbackTime"
        mtopsdk.mtop.util.MtopStatistics$a r6 = r13.f27977av     // Catch:{ all -> 0x06d4 }
        long r6 = r6.f28015k     // Catch:{ all -> 0x06d4 }
        double r6 = (double) r6     // Catch:{ all -> 0x06d4 }
        java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x06d4 }
        r5.put(r2, r6)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "mtopJsonParseTime"
        mtopsdk.mtop.util.MtopStatistics$a r6 = r13.f27977av     // Catch:{ all -> 0x06d4 }
        long r6 = r6.f28010f     // Catch:{ all -> 0x06d4 }
        double r6 = (double) r6     // Catch:{ all -> 0x06d4 }
        java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x06d4 }
        r5.put(r2, r6)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "mtopReqTime"
        mtopsdk.mtop.util.MtopStatistics$a r6 = r13.f27977av     // Catch:{ all -> 0x06d4 }
        long r6 = r6.f28005a     // Catch:{ all -> 0x06d4 }
        double r6 = (double) r6     // Catch:{ all -> 0x06d4 }
        java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x06d4 }
        r5.put(r2, r6)     // Catch:{ all -> 0x06d4 }
    L_0x055f:
        mtopsdk.mtop.c.a r2 = r13.f27978ax     // Catch:{ all -> 0x06d4 }
        if (r2 == 0) goto L_0x056c
        mtopsdk.mtop.c.a r2 = r13.f27978ax     // Catch:{ all -> 0x06d4 }
        java.lang.String r6 = "mtopsdk"
        java.lang.String r7 = "mtopStats"
        r2.mo39758a(r6, r7, r1, r5)     // Catch:{ all -> 0x06d4 }
    L_0x056c:
        java.lang.String r1 = r13.f27999u     // Catch:{ all -> 0x06d4 }
        boolean r1 = mtopsdk.mtop.util.ErrorConstant.m35565h(r1)     // Catch:{ all -> 0x06d4 }
        if (r1 != 0) goto L_0x0627
        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x06d4 }
        r1.<init>()     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f27942N     // Catch:{ all -> 0x06d4 }
        r1.put(r3, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f27999u     // Catch:{ all -> 0x06d4 }
        r1.put(r4, r2)     // Catch:{ all -> 0x06d4 }
        int r2 = r13.f28000v     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d4 }
        r1.put(r12, r2)     // Catch:{ all -> 0x06d4 }
        int r2 = r13.f27945Q     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d4 }
        r1.put(r11, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "mappingCode"
        java.lang.String r5 = r13.f28001w     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
        int r2 = r13.f27998t     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d4 }
        r1.put(r14, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f28002x     // Catch:{ all -> 0x06d4 }
        r1.put(r15, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "refer"
        java.lang.String r5 = r13.f27949U     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f27946R     // Catch:{ all -> 0x06d4 }
        r1.put(r10, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f27947S     // Catch:{ all -> 0x06d4 }
        r1.put(r9, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f27950V     // Catch:{ all -> 0x06d4 }
        r5 = r19
        r1.put(r5, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f27949U     // Catch:{ all -> 0x06d4 }
        r5 = r18
        r1.put(r5, r2)     // Catch:{ all -> 0x06d4 }
        boolean r2 = r13.f27951W     // Catch:{ all -> 0x06d4 }
        if (r2 == 0) goto L_0x05cf
        r2 = 1
        goto L_0x05d0
    L_0x05cf:
        r2 = 0
    L_0x05d0:
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d4 }
        r5 = r17
        r1.put(r5, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "isMain"
        boolean r5 = r13.f27952X     // Catch:{ all -> 0x06d4 }
        if (r5 == 0) goto L_0x05e1
        r5 = 1
        goto L_0x05e2
    L_0x05e1:
        r5 = 0
    L_0x05e2:
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
        mtopsdk.common.util.c r2 = mtopsdk.common.util.RemoteConfig.m35521a()     // Catch:{ all -> 0x06d4 }
        int r2 = r2.f27865r     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d4 }
        r5 = r24
        r1.put(r5, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "isPrefetch"
        boolean r5 = r13.f27970ao     // Catch:{ all -> 0x06d4 }
        if (r5 == 0) goto L_0x0601
        r16 = 1
        goto L_0x0603
    L_0x0601:
        r16 = 0
    L_0x0603:
        java.lang.String r5 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
        mtopsdk.mtop.c.a r2 = r13.f27978ax     // Catch:{ all -> 0x06d4 }
        if (r2 == 0) goto L_0x0618
        mtopsdk.mtop.c.a r2 = r13.f27978ax     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = "mtopsdk"
        java.lang.String r6 = "mtopExceptions"
        r7 = 0
        r2.mo39758a(r5, r6, r1, r7)     // Catch:{ all -> 0x06d4 }
    L_0x0618:
        int r2 = r13.f28000v     // Catch:{ all -> 0x06d4 }
        if (r2 == 0) goto L_0x0627
        mtopsdk.mtop.common.i r2 = r13.f27979ay     // Catch:{ all -> 0x06d4 }
        if (r2 == 0) goto L_0x0627
        java.lang.String r2 = "seqNo"
        java.lang.String r5 = r13.f27943O     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
    L_0x0627:
        java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x06d4 }
        r1.<init>()     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "bizId"
        java.lang.String r5 = r13.f27957ab     // Catch:{ all -> 0x06d4 }
        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x06d4 }
        if (r5 != 0) goto L_0x0639
        java.lang.String r5 = r13.f27957ab     // Catch:{ all -> 0x06d4 }
        goto L_0x063f
    L_0x0639:
        int r5 = r13.f27956aa     // Catch:{ all -> 0x06d4 }
        java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x06d4 }
    L_0x063f:
        r1.put(r2, r5)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f27942N     // Catch:{ all -> 0x06d4 }
        r1.put(r3, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "version"
        java.lang.String r3 = r13.f27942N     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r3)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f28002x     // Catch:{ all -> 0x06d4 }
        r1.put(r15, r2)     // Catch:{ all -> 0x06d4 }
        int r2 = r13.f27998t     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x06d4 }
        r1.put(r14, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = r13.f27999u     // Catch:{ all -> 0x06d4 }
        r1.put(r4, r2)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "bxSessionId"
        java.lang.String r3 = r13.f27960ae     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r3)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "bxUI"
        boolean r3 = r13.f27961af     // Catch:{ all -> 0x06d4 }
        java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r3)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "bxMainAction"
        int r3 = r13.f27962ag     // Catch:{ all -> 0x06d4 }
        java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r3)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "bxSubAction"
        long r3 = r13.f27963ah     // Catch:{ all -> 0x06d4 }
        java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r3)     // Catch:{ all -> 0x06d4 }
        java.lang.String r2 = "bxRetry"
        int r3 = r13.f27964ai     // Catch:{ all -> 0x06d4 }
        java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x06d4 }
        r1.put(r2, r3)     // Catch:{ all -> 0x06d4 }
        java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x06d4 }
        r2.<init>()     // Catch:{ all -> 0x06d4 }
        java.lang.String r3 = "bxSleep"
        long r4 = r13.f27965aj     // Catch:{ all -> 0x06d4 }
        double r4 = (double) r4     // Catch:{ all -> 0x06d4 }
        java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ all -> 0x06d4 }
        r2.put(r3, r4)     // Catch:{ all -> 0x06d4 }
        java.lang.String r3 = "checkTime"
        long r4 = r13.f27967al     // Catch:{ all -> 0x06d4 }
        long r6 = r13.f27966ak     // Catch:{ all -> 0x06d4 }
        long r4 = r4 - r6
        double r4 = (double) r4     // Catch:{ all -> 0x06d4 }
        java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ all -> 0x06d4 }
        r2.put(r3, r4)     // Catch:{ all -> 0x06d4 }
        java.lang.String r3 = "processTime"
        long r4 = r13.f27969an     // Catch:{ all -> 0x06d4 }
        long r6 = r13.f27968am     // Catch:{ all -> 0x06d4 }
        long r4 = r4 - r6
        double r4 = (double) r4     // Catch:{ all -> 0x06d4 }
        java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ all -> 0x06d4 }
        r2.put(r3, r4)     // Catch:{ all -> 0x06d4 }
        mtopsdk.mtop.c.a r3 = r13.f27978ax     // Catch:{ all -> 0x06d4 }
        if (r3 == 0) goto L_0x06d0
        mtopsdk.mtop.c.a r3 = r13.f27978ax     // Catch:{ all -> 0x06d4 }
        java.lang.String r4 = "mtopsdk"
        java.lang.String r5 = "baxiaAction"
        r3.mo39758a(r4, r5, r1, r2)     // Catch:{ all -> 0x06d4 }
    L_0x06d0:
        r1 = 0
        r13.f27955a = r1
        return
    L_0x06d4:
        r0 = move-exception
        goto L_0x06d9
    L_0x06d6:
        r0 = move-exception
        r23 = r5
    L_0x06d9:
        r1 = r0
        java.lang.String r2 = r13.f27943O     // Catch:{ all -> 0x06f7 }
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x06f7 }
        java.lang.String r4 = "[commitStatData] commit mtopStats error ---"
        r3.<init>(r4)     // Catch:{ all -> 0x06f7 }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x06f7 }
        r3.append(r1)     // Catch:{ all -> 0x06f7 }
        java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x06f7 }
        r3 = r23
        mtopsdk.common.util.TBSdkLog.m35513d(r3, r2, r1)     // Catch:{ all -> 0x06f7 }
        r1 = 0
        r13.f27955a = r1
        return
    L_0x06f7:
        r0 = move-exception
        r1 = r0
        r2 = 0
        r13.f27955a = r2
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.util.MtopStatistics.m35571h():void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopStatistics ");
        sb.append(hashCode());
        sb.append("[SumStat(ms)]:");
        sb.append(this.f27976au);
        if (this.f27977av != null) {
            sb.append(" [rbStatData]:");
            sb.append(this.f27977av);
        }
        return sb.toString();
    }

    /* renamed from: d */
    public synchronized C8336a mo39840d() {
        if (this.f27977av == null) {
            this.f27977av = new C8336a(this, 0);
        }
        return this.f27977av;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* renamed from: e */
    public void mo39841e() {
        if (this.f27943O != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[traceId:");
            sb.append(this.f27953Y);
            sb.append("] |");
            sb.append(MessageKey.MSG_ACCEPT_TIME_START);
            TBSdkLog.m35513d("mtopsdk", this.f27943O, sb.toString());
        }
    }

    /* renamed from: f */
    public void mo39842f() {
        if (this.f27943O != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[traceId:");
            sb.append(this.f27953Y);
            sb.append("] |");
            sb.append("MtopStatistics,");
            sb.append(this.f27976au);
            TBSdkLog.m35513d("mtopsdk", this.f27943O, sb.toString());
        }
    }

    /* renamed from: g */
    public void mo39843g() {
        if (Mtop.f27892a) {
            mo39842f();
            try {
                RequestInfo requestInfo = new RequestInfo();
                requestInfo.url = this.f27954Z;
                int i = this.f27998t == -8 ? 2 : this.f28000v == 0 ? 1 : 0;
                requestInfo.ret = i;
                requestInfo.bizId = !TextUtils.isEmpty(this.f27957ab) ? this.f27957ab : String.valueOf(this.f27956aa);
                requestInfo.bizReqStart = this.f27935G;
                requestInfo.bizReqProcessStart = this.f27936H;
                requestInfo.bizRspProcessStart = this.f27937I;
                requestInfo.bizRspCbDispatch = this.f27938J;
                requestInfo.bizRspCbStart = this.f27939K;
                requestInfo.bizRspCbEnd = this.f27940L;
                requestInfo.serverTraceId = this.f27948T;
                requestInfo.isCbMain = this.f27952X;
                requestInfo.isReqMain = this.f27959ad;
                requestInfo.isReqSync = this.f27958ac;
                if (this.f27994p == 1) {
                    requestInfo.protocolType = "cache";
                }
                if (mo39840d() != null) {
                    requestInfo.deserializeTime = mo39840d().f28010f;
                }
                FullTraceAnalysis.getInstance().commitRequest(this.f27953Y, "mtop", requestInfo);
            } catch (Throwable unused) {
                TBSdkLog.m35513d("mtopsdk", this.f27943O, "FullTrack sdk version not compatible");
            }
        }
    }
}
