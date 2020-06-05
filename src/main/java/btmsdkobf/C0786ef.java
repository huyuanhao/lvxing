package btmsdkobf;

import android.content.Context;
import btmsdkobf.C0675da.C0676a;
import btmsdkobf.C0718dy.C0736d;
import btmsdkobf.C0718dy.C0738f;
import btmsdkobf.C0792ei.C0798d;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;

/* renamed from: btmsdkobf.ef */
public class C0786ef implements C0698do {
    /* renamed from: gR */
    private boolean f829gR = false;
    /* renamed from: gZ */
    private C0695dl f830gZ;
    /* renamed from: hA */
    private C0718dy f831hA;
    /* renamed from: hd */
    private boolean f832hd = false;
    /* access modifiers changed from: private */
    /* renamed from: jp */
    public C0789a f833jp;
    /* renamed from: ma */
    private C0677db f834ma;
    /* renamed from: mb */
    private C0792ei f835mb;
    /* renamed from: mc */
    private C0814ep f836mc;

    /* renamed from: btmsdkobf.ef$a */
    public interface C0789a {
        /* renamed from: a */
        void mo9346a(boolean z, int i, byte[] bArr, C0738f fVar);

        /* renamed from: b */
        void mo9347b(boolean z, int i, C0738f fVar);
    }

    public C0786ef(boolean z, Context context, C0695dl dlVar, boolean z2, C0789a aVar, C0798d dVar, C0736d dVar2, C0718dy dyVar, String str) {
        Context context2 = context;
        C0695dl dlVar2 = dlVar;
        boolean z3 = z2;
        String str2 = str;
        this.f829gR = z;
        this.f833jp = aVar;
        this.f830gZ = dlVar2;
        this.f831hA = dyVar;
        this.f832hd = z3;
        if (this.f829gR) {
            this.f836mc = new C0689dg(context, z2, dlVar, str2);
            this.f834ma = new C0677db(context, dlVar, this.f836mc, this.f832hd);
            C0792ei eiVar = new C0792ei(dlVar, this.f836mc, aVar, dVar, this, dVar2, this.f831hA);
            this.f835mb = eiVar;
        } else if (C0716dx.m429as()) {
            this.f836mc = new C0689dg(context, z2, dlVar, str2);
            this.f834ma = new C0677db(context, dlVar, this.f836mc, this.f832hd);
        }
    }

    /* renamed from: a */
    public static void m707a(C0738f fVar, int i, int i2, int i3) {
        String str;
        if (fVar != null && fVar.f649jN != null) {
            int size = fVar.f649jN.size();
            for (int i4 = 0; i4 < size; i4++) {
                C0636by byVar = (C0636by) fVar.f649jN.get(i4);
                if (byVar != null) {
                    C0712dv br = C0712dv.m412br();
                    int i5 = byVar.f357dO;
                    int i6 = byVar.f358fm;
                    if (i3 > 0) {
                        str = String.format("%d/%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(size)});
                    } else {
                        str = null;
                    }
                    br.mo9317a("SharkWharf", i5, i6, byVar, i, i2, str);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9299a(final C0738f fVar, int i) {
        boolean z = true;
        String str = "SharkWharf";
        if (fVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSendTcpFailed() sharkSend is null? ");
            if (fVar != null) {
                z = false;
            }
            sb.append(z);
            C0849fg.m912e(str, sb.toString());
        } else if (fVar.f637jB == 1024) {
            C0849fg.m912e(str, "onSendTcpFailed(), user set only use tcp, so really fail");
            this.f833jp.mo9347b(true, i, fVar);
        } else if (fVar.mo9365bK()) {
            C0849fg.m911d(str, "onSendTcpFailed(), isTcpVip, so really fail");
            this.f833jp.mo9347b(true, i, fVar);
        } else {
            C0849fg.m914i(str, "onSendTcpFailed(), tcp通道发送失败，转http通道");
            fVar.f643jH = false;
            byte[] a = C0683dd.m255a(fVar, false, this.f831hA.getGuid(), this.f830gZ);
            if (a == null) {
                C0849fg.m916w(str, "[tcp_control][http_control][shark_v4]onSendTcpFailed(), ConverterUtil.createSendBytes() return null!");
                return;
            }
            m707a(fVar, 15, 0, a.length);
            this.f834ma.mo9261a(fVar, a, new C0676a() {
                /* renamed from: a */
                public void mo9260a(int i, byte[] bArr) {
                    if (i != 0) {
                        i += ESharkCode.ERR_LEVEL_HTTP_SEND;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSendTcpFailed(), retry with http, http errCode: ");
                    sb.append(i);
                    C0849fg.m911d("SharkWharf", sb.toString());
                    C0786ef.m707a(fVar, 16, i, 0);
                    C0786ef.this.f833jp.mo9346a(false, i, bArr, fVar);
                }
            });
        }
    }

    /* renamed from: bD */
    public C0792ei mo9459bD() {
        if (this.f829gR) {
            return this.f835mb;
        }
        throw new RuntimeException("getTmsTcpManager(), not in sending process!");
    }

    /* renamed from: ck */
    public C0814ep mo9460ck() {
        return this.f836mc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0188, code lost:
            return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e6  */
    /* renamed from: d */
    public synchronized void mo9461d(final btmsdkobf.C0718dy.C0738f r10) {
        /*
        r9 = this;
        monitor-enter(r9)
        boolean r0 = r9.f829gR     // Catch:{ all -> 0x0189 }
        if (r0 != 0) goto L_0x0014
        boolean r0 = btmsdkobf.C0716dx.m429as()     // Catch:{ all -> 0x0189 }
        if (r0 == 0) goto L_0x000c
        goto L_0x0014
    L_0x000c:
        java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ all -> 0x0189 }
        java.lang.String r0 = "sendData(), not in sending or semiSending process!"
        r10.<init>(r0)     // Catch:{ all -> 0x0189 }
        throw r10     // Catch:{ all -> 0x0189 }
    L_0x0014:
        if (r10 != 0) goto L_0x001f
        java.lang.String r10 = "SharkWharf"
        java.lang.String r0 = "sendData(), sharkSend is null"
        btmsdkobf.C0849fg.m912e(r10, r0)     // Catch:{ all -> 0x0189 }
        monitor-exit(r9)
        return
    L_0x001f:
        java.util.ArrayList<btmsdkobf.by> r0 = r10.f649jN     // Catch:{ all -> 0x0189 }
        r1 = 0
        if (r0 == 0) goto L_0x008f
        java.util.ArrayList<btmsdkobf.by> r0 = r10.f649jN     // Catch:{ all -> 0x0189 }
        int r0 = r0.size()     // Catch:{ all -> 0x0189 }
        if (r0 <= 0) goto L_0x008f
        java.util.ArrayList<btmsdkobf.by> r0 = r10.f649jN     // Catch:{ all -> 0x0189 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0189 }
        r2 = 0
    L_0x0033:
        boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0189 }
        if (r3 == 0) goto L_0x008f
        java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0189 }
        btmsdkobf.by r3 = (btmsdkobf.C0636by) r3     // Catch:{ all -> 0x0189 }
        java.lang.String r4 = "SharkWharf_CMDID"
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0189 }
        r5.<init>()     // Catch:{ all -> 0x0189 }
        java.lang.String r6 = "["
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        r5.append(r2)     // Catch:{ all -> 0x0189 }
        java.lang.String r6 = "]发包：cmd id:["
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        int r6 = r3.f357dO     // Catch:{ all -> 0x0189 }
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        java.lang.String r6 = "]seqNo:["
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        int r6 = r3.f358fm     // Catch:{ all -> 0x0189 }
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        java.lang.String r6 = "]refSeqNo:["
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        int r6 = r3.f359fn     // Catch:{ all -> 0x0189 }
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        java.lang.String r6 = "]retCode:["
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        int r6 = r3.f362fq     // Catch:{ all -> 0x0189 }
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        java.lang.String r6 = "]dataRetCode:["
        r5.append(r6)     // Catch:{ all -> 0x0189 }
        int r3 = r3.f363fr     // Catch:{ all -> 0x0189 }
        r5.append(r3)     // Catch:{ all -> 0x0189 }
        java.lang.String r3 = "]"
        r5.append(r3)     // Catch:{ all -> 0x0189 }
        java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0189 }
        btmsdkobf.C0849fg.m914i(r4, r3)     // Catch:{ all -> 0x0189 }
        int r2 = r2 + 1
        goto L_0x0033
    L_0x008f:
        boolean r0 = r10.mo9365bK()     // Catch:{ all -> 0x0189 }
        r2 = 1
        if (r0 == 0) goto L_0x00ae
        boolean r0 = r10.f644jI     // Catch:{ all -> 0x0189 }
        if (r0 == 0) goto L_0x00ab
        java.lang.String r0 = "SharkWharf"
        java.lang.String r1 = "[tcp_control][http_control]sendData(), cloudcmd not allow tcp and this is tcp vip, failed!"
        btmsdkobf.C0849fg.m916w(r0, r1)     // Catch:{ all -> 0x0189 }
        btmsdkobf.ef$a r0 = r9.f833jp     // Catch:{ all -> 0x0189 }
        r1 = -30000007(0xfffffffffe363c79, float:-6.055837E37)
        r0.mo9347b(r2, r1, r10)     // Catch:{ all -> 0x0189 }
        monitor-exit(r9)
        return
    L_0x00ab:
        r3 = 0
        goto L_0x0130
    L_0x00ae:
        btmsdkobf.ei r0 = r9.f835mb     // Catch:{ all -> 0x0189 }
        if (r0 == 0) goto L_0x00bc
        btmsdkobf.ei r0 = r9.f835mb     // Catch:{ all -> 0x0189 }
        boolean r0 = r0.mo9476co()     // Catch:{ all -> 0x0189 }
        if (r0 != 0) goto L_0x00bc
        r0 = 1
        goto L_0x00bd
    L_0x00bc:
        r0 = 0
    L_0x00bd:
        if (r0 == 0) goto L_0x00c7
        int r0 = r10.f637jB     // Catch:{ all -> 0x0189 }
        r3 = 1024(0x400, float:1.435E-42)
        if (r0 == r3) goto L_0x00c7
        r0 = 1
        goto L_0x00c8
    L_0x00c7:
        r0 = 0
    L_0x00c8:
        boolean r3 = btmsdkobf.C0716dx.m429as()     // Catch:{ all -> 0x0189 }
        r4 = 512(0x200, float:7.175E-43)
        r5 = 2048(0x800, float:2.87E-42)
        if (r3 != 0) goto L_0x00e3
        int r3 = r10.f637jB     // Catch:{ all -> 0x0189 }
        if (r3 == r5) goto L_0x00e3
        int r3 = r10.f637jB     // Catch:{ all -> 0x0189 }
        if (r3 == r4) goto L_0x00e3
        boolean r3 = r10.f644jI     // Catch:{ all -> 0x0189 }
        if (r3 != 0) goto L_0x00e3
        if (r0 == 0) goto L_0x00e1
        goto L_0x00e3
    L_0x00e1:
        r3 = 0
        goto L_0x00e4
    L_0x00e3:
        r3 = 1
    L_0x00e4:
        if (r3 == 0) goto L_0x0130
        java.lang.String r6 = "SharkWharf"
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0189 }
        r7.<init>()     // Catch:{ all -> 0x0189 }
        java.lang.String r8 = "[tcp_control][http_control]sendData(), use http channel, for:  only http enable? false isSemiSendProcess? "
        r7.append(r8)     // Catch:{ all -> 0x0189 }
        boolean r8 = btmsdkobf.C0716dx.m429as()     // Catch:{ all -> 0x0189 }
        r7.append(r8)     // Catch:{ all -> 0x0189 }
        java.lang.String r8 = " user select CHANNEL_LARGE_DATA ? "
        r7.append(r8)     // Catch:{ all -> 0x0189 }
        int r8 = r10.f637jB     // Catch:{ all -> 0x0189 }
        if (r8 != r5) goto L_0x0104
        r5 = 1
        goto L_0x0105
    L_0x0104:
        r5 = 0
    L_0x0105:
        r7.append(r5)     // Catch:{ all -> 0x0189 }
        java.lang.String r5 = " user select ONLY_HTTP ? "
        r7.append(r5)     // Catch:{ all -> 0x0189 }
        int r5 = r10.f637jB     // Catch:{ all -> 0x0189 }
        if (r5 != r4) goto L_0x0113
        r4 = 1
        goto L_0x0114
    L_0x0113:
        r4 = 0
    L_0x0114:
        r7.append(r4)     // Catch:{ all -> 0x0189 }
        java.lang.String r4 = " cloud cmd not allow tcp? "
        r7.append(r4)     // Catch:{ all -> 0x0189 }
        boolean r4 = r10.f644jI     // Catch:{ all -> 0x0189 }
        r7.append(r4)     // Catch:{ all -> 0x0189 }
        java.lang.String r4 = " prefer http? "
        r7.append(r4)     // Catch:{ all -> 0x0189 }
        r7.append(r0)     // Catch:{ all -> 0x0189 }
        java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0189 }
        btmsdkobf.C0849fg.m916w(r6, r0)     // Catch:{ all -> 0x0189 }
    L_0x0130:
        java.lang.String r0 = "SharkWharf"
        if (r3 == 0) goto L_0x0163
        java.lang.String r2 = "[tcp_control][http_control]sendData(), use http channel"
        btmsdkobf.C0849fg.m914i(r0, r2)     // Catch:{ all -> 0x0189 }
        r10.f643jH = r1     // Catch:{ all -> 0x0189 }
        btmsdkobf.dy r0 = r9.f831hA     // Catch:{ all -> 0x0189 }
        java.lang.String r0 = r0.getGuid()     // Catch:{ all -> 0x0189 }
        btmsdkobf.dl r2 = r9.f830gZ     // Catch:{ all -> 0x0189 }
        byte[] r0 = btmsdkobf.C0683dd.m255a(r10, r1, r0, r2)     // Catch:{ all -> 0x0189 }
        if (r0 != 0) goto L_0x0152
        java.lang.String r10 = "SharkWharf"
        java.lang.String r0 = "[tcp_control][http_control][shark_v4]sendData(), ConverterUtil.createSendBytes() return null!"
        btmsdkobf.C0849fg.m916w(r10, r0)     // Catch:{ all -> 0x0189 }
        monitor-exit(r9)
        return
    L_0x0152:
        r2 = 15
        int r3 = r0.length     // Catch:{ all -> 0x0189 }
        m707a(r10, r2, r1, r3)     // Catch:{ all -> 0x0189 }
        btmsdkobf.db r1 = r9.f834ma     // Catch:{ all -> 0x0189 }
        btmsdkobf.ef$1 r2 = new btmsdkobf.ef$1     // Catch:{ all -> 0x0189 }
        r2.m40725init(r10)     // Catch:{ all -> 0x0189 }
        r1.mo9261a(r10, r0, r2)     // Catch:{ all -> 0x0189 }
        goto L_0x0187
    L_0x0163:
        java.lang.String r1 = "[tcp_control][http_control]sendData(), use tcp channel"
        btmsdkobf.C0849fg.m914i(r0, r1)     // Catch:{ all -> 0x0189 }
        r10.f643jH = r2     // Catch:{ all -> 0x0189 }
        boolean r0 = r10.f642jG     // Catch:{ all -> 0x0189 }
        if (r0 == 0) goto L_0x0175
        btmsdkobf.ei r0 = r9.f835mb     // Catch:{ all -> 0x0189 }
        r0.mo9479f(r10)     // Catch:{ all -> 0x0189 }
        monitor-exit(r9)
        return
    L_0x0175:
        boolean r0 = r10.mo9366bL()     // Catch:{ all -> 0x0189 }
        if (r0 == 0) goto L_0x0182
        btmsdkobf.ei r0 = r9.f835mb     // Catch:{ all -> 0x0189 }
        r0.mo9479f(r10)     // Catch:{ all -> 0x0189 }
        monitor-exit(r9)
        return
    L_0x0182:
        btmsdkobf.ei r0 = r9.f835mb     // Catch:{ all -> 0x0189 }
        r0.mo9477e(r10)     // Catch:{ all -> 0x0189 }
    L_0x0187:
        monitor-exit(r9)
        return
    L_0x0189:
        r10 = move-exception
        monitor-exit(r9)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0786ef.mo9461d(btmsdkobf.dy$f):void");
    }
}
