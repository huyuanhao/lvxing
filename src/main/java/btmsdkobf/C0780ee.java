package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import com.kwad.sdk.core.response.model.AdConfigData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: btmsdkobf.ee */
public class C0780ee {
    /* renamed from: gZ */
    private C0695dl f817gZ;
    /* renamed from: iv */
    private PowerManager f818iv;
    /* access modifiers changed from: private */
    /* renamed from: lS */
    public C0784a f819lS;
    /* renamed from: lT */
    private C0785b f820lT;
    /* renamed from: lU */
    private C0620bi f821lU;
    /* renamed from: lV */
    private AtomicInteger f822lV = new AtomicInteger(0);
    /* access modifiers changed from: private */
    /* renamed from: lW */
    public boolean f823lW = false;
    /* renamed from: lX */
    private Runnable f824lX = new Runnable() {
        public void run() {
            synchronized (C0780ee.this) {
                if (C0780ee.this.f823lW) {
                    C0849fg.m911d("SharkTcpControler", "[tcp_control][shark_conf][shark_alarm] keep after send timeout, tryCloseConnectionAsyn()");
                    C0780ee.this.mo9449cc();
                    C0780ee.this.f823lW = false;
                }
            }
            C0849fg.m911d("SharkTcpControler", "[tcp_control][shark_conf][shark_alarm] keep after send timeout(by alarm), delay 5s by handler");
        }
    };
    /* renamed from: lY */
    private boolean f825lY = false;
    private Context mContext = C0652cl.m85D();
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(C0716dx.getLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            String str = "SharkTcpControler";
            if (i == 0) {
                C0849fg.m914i(str, "[tcp_control][shark_conf] MSG_EXE_RULE_OPEN");
                C0780ee.this.m686cd();
                C0780ee.this.f819lS.mo9456cj();
            } else if (i == 1) {
                C0849fg.m914i(str, "[tcp_control][shark_conf] MSG_EXE_RULE_CLOSE");
                C0780ee.this.mo9449cc();
            } else if (i == 3) {
                C0849fg.m914i(str, "[tcp_control][shark_conf] MSG_EXE_RULE_CYCLE");
                C0780ee.this.m688cf();
            }
        }
    };

    /* renamed from: btmsdkobf.ee$a */
    public interface C0784a {
        /* renamed from: cj */
        void mo9456cj();

        void onClose();
    }

    /* renamed from: btmsdkobf.ee$b */
    private class C0785b extends BroadcastReceiver {
        private C0785b() {
        }

        public void onReceive(Context context, Intent intent) {
            Handler e;
            int i;
            String str = "SharkTcpControler";
            C0849fg.m911d(str, "[tcp_control][shark_conf]doOnRecv()");
            String action = intent.getAction();
            String str2 = intent.getPackage();
            if (action == null || str2 == null || !str2.equals(C0652cl.m85D().getPackageName())) {
                C0849fg.m911d(str, "[tcp_control][shark_conf]TcpControlReceiver.onReceive(), null action or from other pkg, ignore");
                return;
            }
            if (action.equals("action_keep_alive_cycle")) {
                e = C0780ee.this.mHandler;
                i = 3;
            } else {
                if (action.equals("action_keep_alive_close")) {
                    e = C0780ee.this.mHandler;
                    i = 1;
                }
            }
            e.sendEmptyMessage(i);
        }
    }

    public C0780ee(C0695dl dlVar, C0784a aVar) {
        this.f817gZ = dlVar;
        this.f819lS = aVar;
        try {
            this.f818iv = (PowerManager) this.mContext.getSystemService("power");
        } catch (Throwable unused) {
        }
    }

    /* renamed from: C */
    private static final int m679C(int i) {
        return i * 60;
    }

    /* renamed from: D */
    private static final int m680D(int i) {
        return m679C(i * 60);
    }

    /* renamed from: b */
    private static void m684b(List<C0618bg> list) {
        if (list != null && list.size() != 0) {
            if (((C0618bg) list.get(0)).f197cD > 0) {
                C0618bg bgVar = (C0618bg) list.get(list.size() - 1);
                C0618bg bgVar2 = new C0618bg();
                bgVar2.f197cD = m680D(0);
                bgVar2.f198cE = bgVar.f198cE;
                bgVar2.f199cF = bgVar.f199cF;
                list.add(0, bgVar2);
            }
            try {
                Collections.sort(list, new Comparator<C0618bg>() {
                    /* renamed from: a */
                    public int compare(C0618bg bgVar, C0618bg bgVar2) {
                        return bgVar.f197cD - bgVar2.f197cD;
                    }
                });
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("[tcp_control][shark_conf]checkAndSort() exception: ");
                sb.append(th);
                C0849fg.m913e("SharkTcpControler", sb.toString(), th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cd */
    public void m686cd() {
        if (this.f822lV.get() < 0) {
            this.f822lV.set(0);
        }
        int incrementAndGet = this.f822lV.incrementAndGet();
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control][shark_conf]markKeepAlive(), refCount: ");
        sb.append(incrementAndGet);
        C0849fg.m914i("SharkTcpControler", sb.toString());
    }

    /* renamed from: ce */
    private static ArrayList<C0618bg> m687ce() {
        ArrayList<C0618bg> arrayList = new ArrayList<>();
        C0618bg bgVar = new C0618bg();
        bgVar.f197cD = m680D(0);
        bgVar.f198cE = m679C(10);
        bgVar.f199cF = m679C(60);
        arrayList.add(bgVar);
        C0618bg bgVar2 = new C0618bg();
        bgVar2.f197cD = m680D(8);
        bgVar2.f198cE = m679C(15);
        bgVar2.f199cF = m679C(15);
        arrayList.add(bgVar2);
        C0618bg bgVar3 = new C0618bg();
        bgVar3.f197cD = m680D(15);
        bgVar3.f198cE = m679C(10);
        bgVar3.f199cF = m679C(20);
        arrayList.add(bgVar3);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: cf */
    public void m688cf() {
        C0618bg ch = m690ch();
        String str = "SharkTcpControler";
        if (ch == null) {
            C0849fg.m916w(str, "[tcp_control][shark_conf]no KeepAlivePolicy for current time!");
            return;
        }
        m689cg();
        if (mo9451u("execRule")) {
            this.mHandler.sendEmptyMessage(0);
            C0807em.m809a(this.mContext, "action_keep_alive_close", (long) (ch.f198cE * 1000));
            StringBuilder sb = new StringBuilder();
            sb.append("[tcp_control][shark_conf]now open connection, after ");
            sb.append(ch.f198cE);
            sb.append("s close connection");
            C0849fg.m915v(str, sb.toString());
        } else {
            C0849fg.m916w(str, "[tcp_control][f_p][h_b][shark_conf]execRule(), scSharkConf: donnot keepAlive!");
        }
        C0807em.m809a(this.mContext, "action_keep_alive_cycle", (long) ((ch.f198cE + ch.f199cF) * 1000));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[tcp_control][shark_conf]execRule(), next cycle in ");
        sb2.append(ch.f198cE + ch.f199cF);
        sb2.append("s");
        C0849fg.m915v(str, sb2.toString());
    }

    /* renamed from: cg */
    private void m689cg() {
        C0849fg.m911d("SharkTcpControler", "[tcp_control][shark_conf]cancelOldAction()");
        C0807em.m810a(this.mContext, "action_keep_alive_close");
        C0807em.m810a(this.mContext, "action_keep_alive_cycle");
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
            return null;
     */
    /* renamed from: ch */
    private btmsdkobf.C0618bg m690ch() {
        /*
        r5 = this;
        monitor-enter(r5)
        btmsdkobf.bi r0 = r5.mo9443ak()     // Catch:{ all -> 0x006d }
        if (r0 == 0) goto L_0x006a
        java.util.ArrayList<btmsdkobf.bg> r1 = r0.f213cP     // Catch:{ all -> 0x006d }
        if (r1 == 0) goto L_0x006a
        java.util.ArrayList<btmsdkobf.bg> r1 = r0.f213cP     // Catch:{ all -> 0x006d }
        int r1 = r1.size()     // Catch:{ all -> 0x006d }
        if (r1 <= 0) goto L_0x006a
        int r1 = r5.m691ci()     // Catch:{ all -> 0x006d }
        java.util.ArrayList<btmsdkobf.bg> r2 = r0.f213cP     // Catch:{ all -> 0x006d }
        int r2 = r2.size()     // Catch:{ all -> 0x006d }
        int r2 = r2 + -1
    L_0x001f:
        if (r2 < 0) goto L_0x006a
        java.util.ArrayList<btmsdkobf.bg> r3 = r0.f213cP     // Catch:{ all -> 0x006d }
        java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x006d }
        btmsdkobf.bg r3 = (btmsdkobf.C0618bg) r3     // Catch:{ all -> 0x006d }
        int r4 = r3.f197cD     // Catch:{ all -> 0x006d }
        if (r4 > r1) goto L_0x0067
        java.lang.String r0 = "SharkTcpControler"
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
        r1.<init>()     // Catch:{ all -> 0x006d }
        java.lang.String r2 = "[tcp_control][shark_conf]getRuleAtNow(), fixed policy: start hour: "
        r1.append(r2)     // Catch:{ all -> 0x006d }
        int r2 = r3.f197cD     // Catch:{ all -> 0x006d }
        int r2 = r2 / 3600
        r1.append(r2)     // Catch:{ all -> 0x006d }
        java.lang.String r2 = " start: "
        r1.append(r2)     // Catch:{ all -> 0x006d }
        int r2 = r3.f197cD     // Catch:{ all -> 0x006d }
        r1.append(r2)     // Catch:{ all -> 0x006d }
        java.lang.String r2 = " keep: "
        r1.append(r2)     // Catch:{ all -> 0x006d }
        int r2 = r3.f198cE     // Catch:{ all -> 0x006d }
        r1.append(r2)     // Catch:{ all -> 0x006d }
        java.lang.String r2 = " close: "
        r1.append(r2)     // Catch:{ all -> 0x006d }
        int r2 = r3.f199cF     // Catch:{ all -> 0x006d }
        r1.append(r2)     // Catch:{ all -> 0x006d }
        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006d }
        btmsdkobf.C0849fg.m914i(r0, r1)     // Catch:{ all -> 0x006d }
        monitor-exit(r5)     // Catch:{ all -> 0x006d }
        return r3
    L_0x0067:
        int r2 = r2 + -1
        goto L_0x001f
    L_0x006a:
        monitor-exit(r5)     // Catch:{ all -> 0x006d }
        r0 = 0
        return r0
    L_0x006d:
        r0 = move-exception
        monitor-exit(r5)     // Catch:{ all -> 0x006d }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0780ee.m690ch():btmsdkobf.bg");
    }

    /* renamed from: ci */
    private int m691ci() {
        Calendar instance = Calendar.getInstance();
        if (instance == null) {
            return 0;
        }
        return (instance.get(11) * AdConfigData.DEFAULT_REQUEST_INTERVAL) + (instance.get(12) * 60) + instance.get(13);
    }

    /* renamed from: d */
    private static void m692d(C0620bi biVar) {
        if (biVar != null) {
            if (biVar.f213cP == null || biVar.f213cP.size() <= 0) {
                biVar.f213cP = m687ce();
            } else {
                m684b((List<C0618bg>) biVar.f213cP);
            }
            if (biVar.f211cN <= 30) {
                biVar.f211cN = 30;
            }
            if (biVar.f214cQ <= 0) {
                biVar.f214cQ = 300;
            }
            if (biVar.f217cT <= 0) {
                biVar.f217cT = 120;
            }
            if (biVar.f218cU <= 0) {
                biVar.f218cU = 2;
            }
            String str = "SharkTcpControler";
            C0849fg.m911d(str, "[shark_push][shark_conf]------------- ensureValid() ---------------------");
            StringBuilder sb = new StringBuilder();
            sb.append("[shark_push][shark_conf] hash : ");
            sb.append(biVar.f219cy);
            C0849fg.m914i(str, sb.toString());
            if (biVar.f220cz != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[shark_push][shark_conf] info.taskNo: ");
                sb2.append(biVar.f220cz.f195cB);
                sb2.append(" info.seqNo: ");
                sb2.append(biVar.f220cz.f196cC);
                C0849fg.m914i(str, sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[shark_push][shark_conf] hb interval: ");
            sb3.append(biVar.f211cN);
            C0849fg.m914i(str, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[shark_push][shark_conf] KeepAliveAfterSendInSeconds: ");
            sb4.append(biVar.f214cQ);
            C0849fg.m914i(str, sb4.toString());
            if (biVar.f213cP != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[shark_push][shark_conf]scSharkConf.policy.size(): ");
                sb5.append(biVar.f213cP.size());
                C0849fg.m914i(str, sb5.toString());
                Iterator it = biVar.f213cP.iterator();
                while (it.hasNext()) {
                    C0618bg bgVar = (C0618bg) it.next();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("[shark_push][shark_conf]start: ");
                    sb6.append(bgVar.f197cD);
                    sb6.append(" keepAlive: ");
                    sb6.append(bgVar.f198cE);
                    sb6.append(" connPan: ");
                    sb6.append(bgVar.f199cF);
                    C0849fg.m914i(str, sb6.toString());
                }
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append("[shark_push][shark_conf] scSharkConf.connIfNotWifi: ");
            sb7.append(biVar.f215cR);
            C0849fg.m914i(str, sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("[shark_push][shark_conf] scSharkConf.connIfScreenOff: ");
            sb8.append(biVar.f216cS);
            C0849fg.m914i(str, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("[shark_push][shark_conf] scSharkConf.reconnectInterval: ");
            sb9.append(biVar.f217cT);
            C0849fg.m914i(str, sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append("[shark_push][shark_conf] scSharkConf.delayOnNetworkChanging: ");
            sb10.append(biVar.f218cU);
            C0849fg.m914i(str, sb10.toString());
            C0849fg.m911d(str, "[shark_push][shark_conf]-----------------------------------------------------------");
        }
    }

    /* renamed from: ak */
    public C0620bi mo9443ak() {
        synchronized (this) {
            if (this.f821lU == null) {
                this.f821lU = this.f817gZ.mo9231aF();
                if (this.f821lU != null) {
                    m692d(this.f821lU);
                } else {
                    this.f821lU = new C0620bi();
                    if (C0716dx.m431bu()) {
                        this.f821lU.f211cN = 30;
                        this.f821lU.f214cQ = 60;
                    } else {
                        this.f821lU.f211cN = 270;
                        this.f821lU.f214cQ = 300;
                    }
                    this.f821lU.f212cO = new ArrayList<>();
                    this.f821lU.f213cP = m687ce();
                    this.f821lU.f215cR = true;
                    this.f821lU.f216cS = true;
                    this.f821lU.f217cT = 120;
                    this.f821lU.f218cU = 2;
                }
            }
        }
        return this.f821lU;
    }

    /* renamed from: bW */
    public synchronized void mo9444bW() {
        if (!this.f825lY) {
            C0849fg.m911d("SharkTcpControler", "[tcp_control][shark_conf]startTcpControl()");
            if (this.f820lT == null) {
                this.f820lT = new C0785b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("action_keep_alive_close");
                intentFilter.addAction("action_keep_alive_cycle");
                try {
                    this.mContext.registerReceiver(this.f820lT, intentFilter);
                } catch (Throwable th) {
                    String str = "SharkTcpControler";
                    StringBuilder sb = new StringBuilder();
                    sb.append("[tcp_control][shark_conf]registerReceiver exception: ");
                    sb.append(th);
                    C0849fg.m916w(str, sb.toString());
                }
            }
            this.mHandler.sendEmptyMessage(3);
            this.f825lY = true;
        }
    }

    /* renamed from: bX */
    public synchronized void mo9445bX() {
        if (this.f825lY) {
            C0849fg.m911d("SharkTcpControler", "[tcp_control][shark_conf]stopTcpControl()");
            m689cg();
            if (this.f820lT != null) {
                try {
                    this.mContext.unregisterReceiver(this.f820lT);
                    this.f820lT = null;
                } catch (Throwable th) {
                    String str = "SharkTcpControler";
                    StringBuilder sb = new StringBuilder();
                    sb.append("[tcp_control][shark_conf]unregisterReceiver exception: ");
                    sb.append(th);
                    C0849fg.m916w(str, sb.toString());
                }
            }
            mo9449cc();
            this.f825lY = false;
        }
    }

    /* renamed from: c */
    public void mo9446c(C0620bi biVar) {
        if (biVar == null) {
            C0849fg.m916w("SharkTcpControler", "[tcp_control][shark_conf]onSharkConfPush(), scSharkConf == null");
            return;
        }
        synchronized (this) {
            this.f821lU = biVar;
            this.f817gZ.mo9244b(this.f821lU);
            m692d(this.f821lU);
        }
    }

    /* renamed from: ca */
    public int mo9447ca() {
        return this.f822lV.get();
    }

    /* renamed from: cb */
    public void mo9448cb() {
        this.f822lV.set(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cc */
    public void mo9449cc() {
        int decrementAndGet = this.f822lV.decrementAndGet();
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control][shark_conf]tryCloseConnectionAsyn, refCount: ");
        sb.append(decrementAndGet);
        C0849fg.m914i("SharkTcpControler", sb.toString());
        if (decrementAndGet <= 0) {
            this.f822lV.set(0);
            this.f819lS.onClose();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo9450f(long j) {
        long j2 = ((long) mo9443ak().f214cQ) * 1000;
        long j3 = j2 < j ? j : j2;
        synchronized (this) {
            if (!this.f823lW) {
                C0849fg.m914i("SharkTcpControler", "[tcp_control][shark_conf] extendConnectOnSend(), markKeepConnection()");
                m686cd();
                this.f823lW = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control][shark_conf] ");
        sb.append(j3 / 1000);
        C0849fg.m914i("SharkTcpControler", sb.toString());
        C0825eu.m861cK().mo9529w("action_keep_alive_after_send_end");
        C0825eu.m861cK().mo9528a("action_keep_alive_after_send_end", j3, this.f824lX, 0);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* renamed from: u */
    public boolean mo9451u(java.lang.String r7) {
        /*
        r6 = this;
        btmsdkobf.bi r0 = r6.mo9443ak()
        r1 = 1
        if (r0 != 0) goto L_0x0008
        return r1
    L_0x0008:
        boolean r2 = r0.f215cR
        java.lang.String r3 = "SharkTcpControler"
        r4 = 0
        if (r2 != 0) goto L_0x002d
        btmsdkobf.ck r2 = btmsdkobf.C0651ck.f411fW
        btmsdkobf.ck r5 = btmsdkobf.C0871h.m967j()
        if (r2 == r5) goto L_0x002d
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r5 = "[tcp_control][shark_conf] shouldKeepAlive(), not allow in none wifi! timing: "
        r2.append(r5)
        r2.append(r7)
        java.lang.String r2 = r2.toString()
        btmsdkobf.C0849fg.m915v(r3, r2)
        r2 = 0
        goto L_0x002e
    L_0x002d:
        r2 = 1
    L_0x002e:
        if (r2 == 0) goto L_0x0056
        boolean r0 = r0.f216cS
        if (r0 != 0) goto L_0x0056
        android.os.PowerManager r0 = r6.f818iv
        if (r0 == 0) goto L_0x003e
        boolean r0 = r0.isScreenOn()     // Catch:{ all -> 0x003e }
        r0 = r0 ^ r1
        goto L_0x003f
    L_0x003e:
        r0 = 0
    L_0x003f:
        if (r0 == 0) goto L_0x0056
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "[tcp_control][shark_conf] shouldKeepAlive(), not allow on screen off! timing: "
        r0.append(r1)
        r0.append(r7)
        java.lang.String r7 = r0.toString()
        btmsdkobf.C0849fg.m915v(r3, r7)
        r2 = 0
    L_0x0056:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0780ee.mo9451u(java.lang.String):boolean");
    }
}
