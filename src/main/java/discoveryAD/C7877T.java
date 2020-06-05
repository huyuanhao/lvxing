package discoveryAD;

import com.tencent.qqpim.discovery.IProRequestCallback;
import com.tencent.qqpim.discovery.internal.model.C7486a;
import com.tencent.qqpim.discovery.internal.model.C7489d;
import com.tencent.qqpim.discovery.internal.model.C7491f;
import com.tencent.qqpim.discovery.internal.protocol.C7501a;
import discoveryAD.C7897f.C7898a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: discoveryAD.T */
public class C7877T implements C7898a {
    private static final String TAG = "LogReportService";
    /* renamed from: Pd */
    private int f26777Pd = 0;
    /* renamed from: Qd */
    private boolean f26778Qd = false;
    /* renamed from: Rd */
    private Object f26779Rd = new Object();
    /* renamed from: Sd */
    private boolean f26780Sd = false;

    /* renamed from: a */
    private ArrayList<C7489d> m34239a(List<C7491f> list, int i, int i2) {
        ArrayList<C7489d> arrayList = new ArrayList<>();
        for (C7491f fVar : list) {
            C7501a aVar = new C7501a();
            C7486a aVar2 = new C7486a();
            aVar2.f25062W = i;
            aVar2.f25065te = fVar;
            aVar.context = fVar.context;
            aVar.f25133W = i;
            aVar.positionId = aVar2.f25065te.positionId;
            aVar.timeStamp = System.currentTimeMillis() / 1000;
            arrayList.add(new C7489d(aVar, aVar2, i2));
        }
        return arrayList;
    }

    /* renamed from: a */
    private ArrayList<C7883Y> m34240a(List<C7491f> list, int i, long j) {
        ArrayList<C7883Y> arrayList = new ArrayList<>();
        for (C7491f fVar : list) {
            C7883Y y = new C7883Y();
            y.context = fVar.context;
            y.f26807W = i;
            y.positionId = fVar.positionId;
            y.timeStamp = System.currentTimeMillis() / 1000;
            y.f26809Xd = j;
            StringBuilder sb = new StringBuilder();
            sb.append("钱途广告平台数据上报：positionID=");
            sb.append(y.positionId);
            sb.append(",phase=");
            sb.append(y.f26807W);
            C7852Aa.m34154d(TAG, sb.toString());
            arrayList.add(y);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m34241a(List<C7883Y> list, ArrayList<C7489d> arrayList) {
        C7852Aa.m34154d(TAG, "asyncReportQiantuData,run");
        C7929sa.m34339a(arrayList, (IProRequestCallback) new C7897f(list, this));
    }

    /* renamed from: j */
    private ArrayList<C7501a> m34242j(List<C7883Y> list) {
        ArrayList<C7501a> arrayList = new ArrayList<>();
        for (C7883Y y : list) {
            C7501a aVar = new C7501a();
            aVar.context = y.context;
            aVar.f25133W = y.f26807W;
            aVar.positionId = y.positionId;
            aVar.timeStamp = y.timeStamp;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* renamed from: k */
    private ArrayList<C7501a> m34243k(List<C7883Y> list) {
        ArrayList<C7501a> arrayList = new ArrayList<>();
        for (C7883Y y : list) {
            C7501a aVar = new C7501a();
            aVar.context = y.context;
            aVar.f25133W = y.f26807W;
            aVar.positionId = y.positionId;
            aVar.timeStamp = y.timeStamp;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* renamed from: l */
    private ArrayList<C7489d> m34244l(List<C7486a> list) {
        ArrayList<C7489d> arrayList = new ArrayList<>();
        for (C7486a aVar : list) {
            C7501a aVar2 = new C7501a();
            C7491f fVar = aVar.f25065te;
            aVar2.context = fVar.context;
            aVar2.f25133W = aVar.f25062W;
            aVar2.positionId = fVar.positionId;
            aVar2.timeStamp = System.currentTimeMillis() / 1000;
            arrayList.add(new C7489d(aVar2, aVar, 0));
        }
        return arrayList;
    }

    /* renamed from: m */
    private ArrayList<C7883Y> m34245m(List<C7486a> list) {
        ArrayList<C7883Y> arrayList = new ArrayList<>();
        for (C7486a aVar : list) {
            C7883Y y = new C7883Y();
            C7491f fVar = aVar.f25065te;
            y.context = fVar.context;
            y.f26807W = aVar.f25062W;
            y.positionId = fVar.positionId;
            y.timeStamp = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("钱途广告平台数据上报：positionID=");
            sb.append(y.positionId);
            sb.append(",phase=");
            sb.append(y.f26807W);
            C7852Aa.m34154d(TAG, sb.toString());
            arrayList.add(y);
        }
        return arrayList;
    }

    /* renamed from: n */
    private void m34246n(List<C7883Y> list) {
        C7852Aa.m34154d(TAG, "准备上报数据库里钱途的数据...");
        m34243k(list);
    }

    /* renamed from: a */
    public void mo38153a(C7491f fVar, int i, long j, int i2) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(fVar);
        ArrayList a = m34240a((List<C7491f>) arrayList, i, j);
        ArrayList a2 = m34239a((List<C7491f>) arrayList, i, i2);
        if (System.currentTimeMillis() >= j) {
            m34241a((List<C7883Y>) a, a2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("直接写入数据库：");
        sb.append(a.toString());
        C7852Aa.m34154d(TAG, sb.toString());
        C7862G.getInstance().mo38131db().mo38165d(a);
        this.f26777Pd += a.size();
    }

    /* renamed from: a */
    public void mo38154a(List<C7883Y> list, boolean z) {
        if (z) {
            mo38157gb();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("钱途上报失败，以下数据将写入数据库：");
        sb.append(list.toString());
        C7852Aa.m34154d(TAG, sb.toString());
        C7862G.getInstance().mo38131db().mo38165d(list);
        this.f26777Pd += list.size();
    }

    /* renamed from: b */
    public void mo38155b(C7491f fVar, int i) {
        mo38153a(fVar, i, 0, 0);
    }

    /* renamed from: b */
    public void mo38156b(List<C7486a> list) {
        if (!C7931ta.m34347g(list)) {
            C7929sa.m34339a(m34244l(list), (IProRequestCallback) new C7897f(m34245m(list), this));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
            r0 = null;
            r2 = r9.f26777Pd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
            if (r9.f26778Qd == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
            if (r2 > 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
            discoveryAD.C7852Aa.m34154d(TAG, "数据库里没有钱途的数据，停止上报");
            r2 = r9.f26779Rd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r9.f26780Sd = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            if (r9.f26778Qd != false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0033, code lost:
            r9.f26778Qd = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0035, code lost:
            r1 = discoveryAD.C7862G.getInstance().mo38131db().getActions();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
            if (r1 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0043, code lost:
            r9.f26777Pd = r1.size();
            r2 = java.lang.System.currentTimeMillis();
            r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
            if (r1.hasNext() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0057, code lost:
            r5 = (discoveryAD.C7883Y) r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0061, code lost:
            if (r5.f26809Xd > r2) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0063, code lost:
            if (r0 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0065, code lost:
            r0 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
            r0.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006e, code lost:
            if (r0 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0074, code lost:
            if (r0.isEmpty() == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0077, code lost:
            m34246n(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007a, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007b, code lost:
            discoveryAD.C7852Aa.m34154d(TAG, "数据库里没有钱途的数据，停止上报");
            r1 = r9.f26779Rd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
            monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            r9.f26780Sd = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0087, code lost:
            monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0088, code lost:
            return;
     */
    /* renamed from: gb */
    public void mo38157gb() {
        /*
        r9 = this;
        java.lang.Object r0 = r9.f26779Rd
        monitor-enter(r0)
        boolean r1 = r9.f26780Sd     // Catch:{ all -> 0x008c }
        if (r1 == 0) goto L_0x0010
        java.lang.String r1 = "LogReportService"
        java.lang.String r2 = "正在上报数据库里的数据，当前不能上报"
        discoveryAD.C7852Aa.m34157w(r1, r2)     // Catch:{ all -> 0x008c }
        monitor-exit(r0)     // Catch:{ all -> 0x008c }
        return
    L_0x0010:
        r1 = 1
        r9.f26780Sd = r1     // Catch:{ all -> 0x008c }
        monitor-exit(r0)     // Catch:{ all -> 0x008c }
        r0 = 0
        int r2 = r9.f26777Pd
        boolean r3 = r9.f26778Qd
        r4 = 0
        if (r3 == 0) goto L_0x002f
        if (r2 > 0) goto L_0x002f
        java.lang.String r0 = "LogReportService"
        java.lang.String r1 = "数据库里没有钱途的数据，停止上报"
        discoveryAD.C7852Aa.m34154d(r0, r1)
        java.lang.Object r2 = r9.f26779Rd
        monitor-enter(r2)
        r9.f26780Sd = r4     // Catch:{ all -> 0x002c }
        monitor-exit(r2)     // Catch:{ all -> 0x002c }
        return
    L_0x002c:
        r0 = move-exception
        monitor-exit(r2)     // Catch:{ all -> 0x002c }
        throw r0
    L_0x002f:
        boolean r2 = r9.f26778Qd
        if (r2 != 0) goto L_0x0035
        r9.f26778Qd = r1
    L_0x0035:
        discoveryAD.G r1 = discoveryAD.C7862G.getInstance()
        discoveryAD.X r1 = r1.mo38131db()
        java.util.List r1 = r1.getActions()
        if (r1 == 0) goto L_0x006e
        int r2 = r1.size()
        r9.f26777Pd = r2
        long r2 = java.lang.System.currentTimeMillis()
        java.util.Iterator r1 = r1.iterator()
    L_0x0051:
        boolean r5 = r1.hasNext()
        if (r5 == 0) goto L_0x006e
        java.lang.Object r5 = r1.next()
        discoveryAD.Y r5 = (discoveryAD.C7883Y) r5
        long r6 = r5.f26809Xd
        int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
        if (r8 > 0) goto L_0x0051
        if (r0 != 0) goto L_0x006a
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
    L_0x006a:
        r0.add(r5)
        goto L_0x0051
    L_0x006e:
        if (r0 == 0) goto L_0x007b
        boolean r1 = r0.isEmpty()
        if (r1 == 0) goto L_0x0077
        goto L_0x007b
    L_0x0077:
        r9.m34246n(r0)
        return
    L_0x007b:
        java.lang.String r0 = "LogReportService"
        java.lang.String r1 = "数据库里没有钱途的数据，停止上报"
        discoveryAD.C7852Aa.m34154d(r0, r1)
        java.lang.Object r1 = r9.f26779Rd
        monitor-enter(r1)
        r9.f26780Sd = r4     // Catch:{ all -> 0x0089 }
        monitor-exit(r1)     // Catch:{ all -> 0x0089 }
        return
    L_0x0089:
        r0 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x0089 }
        throw r0
    L_0x008c:
        r1 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x008c }
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7877T.mo38157gb():void");
    }
}
