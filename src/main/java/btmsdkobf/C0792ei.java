package btmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import btmsdkobf.C0718dy.C0734b;
import btmsdkobf.C0718dy.C0736d;
import btmsdkobf.C0718dy.C0738f;
import btmsdkobf.C0739dz.C0745a;
import btmsdkobf.C0780ee.C0784a;
import btmsdkobf.C0786ef.C0789a;
import btmsdkobf.C0809eo.C0812b;
import btmsdkobf.C0809eo.C0813c;
import btmsdkobf.C0815eq.C0817b;
import btmsdkobf.C0819es.C0823a;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.common.adapt.iservice.net.ESharkCode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: btmsdkobf.ei */
public class C0792ei implements C0745a, C0784a, C0812b, C0813c, C0823a {
    /* access modifiers changed from: private */
    /* renamed from: gZ */
    public C0695dl f857gZ;
    /* access modifiers changed from: private */
    /* renamed from: hA */
    public C0718dy f858hA;
    /* renamed from: hd */
    private boolean f859hd;
    /* renamed from: jp */
    protected C0789a f860jp;
    /* renamed from: mA */
    private long f861mA;
    /* renamed from: mB */
    private long f862mB;
    /* access modifiers changed from: private */
    /* renamed from: mC */
    public boolean f863mC;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    /* renamed from: mD */
    public LinkedList<C0800f> f864mD;
    /* access modifiers changed from: private|final */
    /* renamed from: mE */
    public final Object f865mE;
    /* access modifiers changed from: private */
    /* renamed from: mF */
    public byte f866mF;
    /* renamed from: mG */
    private HandlerThread f867mG;
    /* renamed from: mH */
    private Handler f868mH;
    /* access modifiers changed from: private */
    /* renamed from: mI */
    public boolean f869mI;
    /* access modifiers changed from: private */
    /* renamed from: mJ */
    public C0818er<C0800f> f870mJ;
    /* access modifiers changed from: private */
    /* renamed from: mt */
    public C0824et f871mt;
    /* renamed from: mu */
    private C0698do f872mu;
    /* renamed from: mv */
    private C0696dm f873mv;
    /* renamed from: mw */
    private C0798d f874mw;
    /* access modifiers changed from: private */
    /* renamed from: mx */
    public C0780ee f875mx;
    /* renamed from: my */
    private C0809eo f876my;
    /* access modifiers changed from: private */
    /* renamed from: mz */
    public int f877mz;

    /* renamed from: btmsdkobf.ei$a */
    private class C0795a extends C0797c {
        /* renamed from: mL */
        private int f881mL = 0;
        /* renamed from: mM */
        private String f882mM = "";

        public C0795a(int i, int i2, String str) {
            super(10997, i);
            this.f881mL = i2;
            this.f882mM = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void mo9482e(C0647cg cgVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("[tcp_control][f_p]fp success, mRetryTimes: ");
            sb.append(this.f881mL);
            C0849fg.m914i("TmsTcpManager", sb.toString());
            C0792ei.this.f869mI = false;
            C0792ei.this.f866mF = 1;
            C0792ei.this.f863mC = false;
            C0712dv.m412br().mo9318a("TmsTcpManager", 997, this.f887fm, cgVar, 30, 0);
            C0712dv.m412br().mo9324t(this.f887fm);
            C0792ei.this.m731a(2, null, 0, 0, true);
        }

        /* access modifiers changed from: protected */
        /* renamed from: k */
        public void mo9483k(int i, int i2) {
            StringBuilder sb;
            int l = C0673cz.m215l(i);
            boolean z = this.f881mL < 1 && C0673cz.m216m(l) && C0792ei.this.f877mz < 3 && C0792ei.this.f875mx.mo9447ca() > 0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[tcp_control][f_p]fp fail, retCode: ");
            sb2.append(l);
            sb2.append(" dataRetCode: ");
            sb2.append(i2);
            sb2.append(" mRetryTimes: ");
            sb2.append(this.f881mL);
            sb2.append(" need retry? ");
            sb2.append(z);
            String str = "TmsTcpManager";
            C0849fg.m916w(str, sb2.toString());
            C0792ei.this.f869mI = true;
            C0792ei.this.f866mF = 0;
            C0792ei.this.f863mC = true;
            C0712dv.m412br().mo9318a("TmsTcpManager", 997, this.f887fm, null, 30, l);
            C0712dv.m412br().mo9320a(this.f887fm, !z);
            C0792ei.this.m731a(3, null, l, 0, true);
            if (z) {
                sb = new StringBuilder();
                sb.append("[tcp_control][f_p]fp fail, ref count: ");
                sb.append(C0792ei.this.f875mx.mo9447ca());
                sb.append(", retry send fp in ");
                sb.append(C0792ei.this.f875mx.mo9443ak().f217cT);
                sb.append("s");
                C0849fg.m914i(str, sb.toString());
                C0792ei.this.f877mz = C0792ei.this.f877mz + 1;
                C0792ei eiVar = C0792ei.this;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("delay_fp_retry:");
                sb3.append(this.f882mM);
                sb3.append(":");
                sb3.append(l);
                String sb4 = sb3.toString();
                int i3 = this.f881mL + 1;
                this.f881mL = i3;
                eiVar.m731a(11, sb4, i3, ((long) C0792ei.this.f875mx.mo9443ak().f217cT) * 1000, true);
                return;
            }
            sb = new StringBuilder();
            sb.append("[tcp_control][f_p]fp fail, should not retry, retCode: ");
            sb.append(l);
            C0849fg.m914i(str, sb.toString());
        }
    }

    /* renamed from: btmsdkobf.ei$b */
    private class C0796b extends C0797c {
        /* renamed from: mL */
        private int f884mL = 0;
        /* renamed from: mM */
        private String f885mM = "";
        /* renamed from: mN */
        private byte f886mN = 0;

        public C0796b(int i, int i2, String str, byte b) {
            super(10999, i);
            this.f884mL = i2;
            this.f885mM = str;
            this.f886mN = b;
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void mo9482e(C0647cg cgVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("[tcp_control][h_b]hb success, helloSeq: ");
            sb.append(this.f886mN);
            sb.append(" mRetryTimes: ");
            sb.append(this.f884mL);
            sb.append(" reason: ");
            sb.append(this.f885mM);
            C0849fg.m914i("TmsTcpManager", sb.toString());
            C0712dv.m412br().mo9318a("TmsTcpManager", 999, this.f887fm, cgVar, 30, 0);
            C0712dv.m412br().mo9324t(this.f887fm);
            C0712dv.m412br().mo9313a(this.f886mN);
        }

        /* access modifiers changed from: protected */
        /* renamed from: k */
        public void mo9483k(int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("[tcp_control][h_b]hb fail, retCode: ");
            sb.append(i);
            sb.append(" dataRetCode: ");
            sb.append(i2);
            sb.append(" helloSeq: ");
            sb.append(this.f886mN);
            sb.append(" mRetryTimes: ");
            sb.append(this.f884mL);
            sb.append(" reason: ");
            sb.append(this.f885mM);
            String sb2 = sb.toString();
            String str = "TmsTcpManager";
            C0849fg.m914i(str, sb2);
            boolean z = false;
            if (this.f884mL >= 1) {
                C0849fg.m915v(str, "[tcp_control][h_b]hb fail again, mark disconnect not handled for reconnect");
                C0792ei.this.f869mI = true;
                C0792ei.this.f866mF = 0;
            }
            if (this.f884mL < 1 && C0673cz.m216m(i) && C0792ei.this.f877mz < 3 && C0792ei.this.f875mx.mo9447ca() > 0) {
                z = true;
            }
            C0712dv.m412br().mo9318a("TmsTcpManager", 999, this.f887fm, null, 30, i);
            C0712dv.m412br().mo9320a(this.f887fm, !z);
            C0712dv.m412br().mo9313a(this.f886mN);
            if (z) {
                C0849fg.m914i(str, "[tcp_control][h_b]hb fail, retry");
                C0792ei eiVar = C0792ei.this;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("hb_retry:");
                sb3.append(this.f885mM);
                sb3.append(":");
                sb3.append(i);
                String sb4 = sb3.toString();
                int i3 = this.f884mL + 1;
                this.f884mL = i3;
                eiVar.m731a(13, sb4, i3, 2000, true);
            }
        }
    }

    /* renamed from: btmsdkobf.ei$c */
    private abstract class C0797c implements C0734b {
        /* renamed from: fm */
        int f887fm = 0;
        /* renamed from: mO */
        int f889mO = 0;

        public C0797c(int i, int i2) {
            this.f889mO = i;
            this.f887fm = i2;
        }

        /* renamed from: a */
        public void mo9278a(boolean z, int i, int i2, ArrayList<C0647cg> arrayList) {
            if (i != 0) {
                mo9483k(i, -1);
            } else if (this.f889mO == 10999 && i == 0) {
                mo9482e(null);
            } else if (arrayList == null || arrayList.size() == 0) {
                mo9483k(-41250000, -1);
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C0647cg cgVar = (C0647cg) it.next();
                    if (cgVar != null && cgVar.f383dO == this.f889mO) {
                        if (cgVar.f388fq == 0 && cgVar.f389fr == 0) {
                            mo9482e(cgVar);
                            return;
                        } else {
                            mo9483k(cgVar.f388fq, cgVar.f389fr);
                            return;
                        }
                    }
                }
                mo9483k(-41250000, -1);
            }
        }

        /* renamed from: e */
        public abstract void mo9482e(C0647cg cgVar);

        /* renamed from: k */
        public abstract void mo9483k(int i, int i2);
    }

    /* renamed from: btmsdkobf.ei$d */
    public interface C0798d {
        /* renamed from: a */
        void mo9330a(C0738f fVar);
    }

    /* renamed from: btmsdkobf.ei$e */
    private class C0799e extends Handler {
        public C0799e(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v2, types: [btmsdkobf.eg] */
        /* JADX WARNING: type inference failed for: r10v3 */
        /* JADX WARNING: type inference failed for: r3v23 */
        /* JADX WARNING: type inference failed for: r10v4 */
        /* JADX WARNING: type inference failed for: r10v5 */
        /* JADX WARNING: type inference failed for: r10v6 */
        /* JADX WARNING: type inference failed for: r10v7 */
        /* JADX WARNING: type inference failed for: r10v8, types: [btmsdkobf.eg] */
        /* JADX WARNING: type inference failed for: r10v9, types: [btmsdkobf.eg] */
        /* JADX WARNING: type inference failed for: r3v38, types: [java.util.LinkedList] */
        /* JADX WARNING: type inference failed for: r3v43, types: [java.util.LinkedList] */
        /* JADX WARNING: type inference failed for: r10v32 */
        /* JADX WARNING: type inference failed for: r10v33 */
        /* JADX WARNING: type inference failed for: r10v34 */
        /* JADX WARNING: type inference failed for: r10v35 */
        /* JADX WARNING: type inference failed for: r3v73 */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x037a, code lost:
            r6 = 0;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0385, code lost:
            if (r0.f892hn.mo9364bJ() == false) goto L_0x0392;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x0387, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][time_out]MSG_SEND_TASK, send time out");
            r2 = -17;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x0398, code lost:
            if (r0.f892hn.mo9366bL() != false) goto L_0x03a2;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x039e, code lost:
            if (r0.f892hn.f642jG != false) goto L_0x03a2;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x03a0, code lost:
            r2 = true;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x03a2, code lost:
            r2 = false;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x03a3, code lost:
            if (r2 == false) goto L_0x047c;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x03ab, code lost:
            if (btmsdkobf.C0792ei.m755f(r1.f890mK) != 1) goto L_0x03fd;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x03b7, code lost:
            if (btmsdkobf.C0792ei.m756g(r1.f890mK).mo9521cC() != false) goto L_0x03f7;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x03bd, code lost:
            if (r0.f892hn.f641jF == false) goto L_0x03c7;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x03bf, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] connection is broken, , ignore heartbeat");
     */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x03c6, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x03c7, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] connection is broken, wait and resend fp");
            btmsdkobf.C0792ei.m736a(r1.f890mK, r0.f892hn);
            r2 = btmsdkobf.C0792ei.m752d(r1.f890mK);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x03db, code lost:
            monitor-enter(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
            btmsdkobf.C0792ei.m760h(r1.f890mK).add(r0);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x03e5, code lost:
            monitor-exit(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x03e6, code lost:
            btmsdkobf.C0792ei.m734a(r1.f890mK, 11, "conn_broken_didnt_monitored", 0, 0, true);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x03f3, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x03f7, code lost:
            r2 = "TmsTcpManager";
            r10 = "[tcp_control][f_p]handleMessage(), [others] connection is ok";
     */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0403, code lost:
            if (btmsdkobf.C0792ei.m755f(r1.f890mK) != 2) goto L_0x0436;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0409, code lost:
            if (r0.f892hn.f641jF == false) goto L_0x0413;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x040b, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] sending fp, ignore heartbeat");
     */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x0412, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x0413, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] sending fp, enqueue this task and wait");
            btmsdkobf.C0792ei.m743b(r1.f890mK, r0.f892hn);
            r2 = btmsdkobf.C0792ei.m752d(r1.f890mK);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x0427, code lost:
            monitor-enter(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
            btmsdkobf.C0792ei.m760h(r1.f890mK).add(r0);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x0431, code lost:
            monitor-exit(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x0432, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x043c, code lost:
            if (btmsdkobf.C0792ei.m755f(r1.f890mK) != 0) goto L_0x04db;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x0442, code lost:
            if (r0.f892hn.f641jF == false) goto L_0x044c;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0444, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p][h_b]handleMessage(), [hb] fp not sent, ignore heartbeat");
     */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x044b, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x044c, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [others] fp not sent, send fp & enqueue this task");
            btmsdkobf.C0792ei.m736a(r1.f890mK, r0.f892hn);
            r2 = btmsdkobf.C0792ei.m752d(r1.f890mK);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0460, code lost:
            monitor-enter(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:191:?, code lost:
            btmsdkobf.C0792ei.m760h(r1.f890mK).add(r0);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x046a, code lost:
            monitor-exit(r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x046b, code lost:
            btmsdkobf.C0792ei.m734a(r1.f890mK, 11, "others_depend_on_fp", 0, 0, true);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0478, code lost:
            return;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x0482, code lost:
            if (btmsdkobf.C0792ei.m763i(r1.f890mK) == false) goto L_0x04ab;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0484, code lost:
            btmsdkobf.C0792ei.m739a(r1.f890mK, false);
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 1: reconnect");
            r2 = btmsdkobf.C0792ei.m728a(r1.f890mK, "disconnected_before_send");
     */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x049c, code lost:
            if (r0.f892hn.f642jG != false) goto L_0x04dc;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:203:0x049e, code lost:
            btmsdkobf.C0792ei.m726a(r1.f890mK, 0);
            r10 = "TmsTcpManager";
            r11 = "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 2: not fp, mark fp_not_send";
     */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x04a7, code lost:
            btmsdkobf.C0849fg.m916w(r10, r11);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x04b5, code lost:
            if (btmsdkobf.C0792ei.m756g(r1.f890mK).mo9521cC() != false) goto L_0x04d4;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x04b7, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p]handleMessage(), [vip] not connected, 1: connect");
            r2 = btmsdkobf.C0792ei.m764j(r1.f890mK);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x04c8, code lost:
            if (r0.f892hn.f642jG != false) goto L_0x04dc;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x04ca, code lost:
            btmsdkobf.C0792ei.m726a(r1.f890mK, 0);
            r10 = "TmsTcpManager";
            r11 = "[tcp_control][f_p]handleMessage(), [vip] not connected, 2: not fp, mark fp_not_send";
     */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x04d4, code lost:
            r2 = "TmsTcpManager";
            r10 = "[tcp_control][f_p]handleMessage(), [vip] connection is ok";
     */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x04d8, code lost:
            btmsdkobf.C0849fg.m914i(r2, r10);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x04db, code lost:
            r2 = 0;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x04dc, code lost:
            if (r2 == 0) goto L_0x04f6;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x04de, code lost:
            r5 = new java.lang.StringBuilder();
            r5.append("[tcp_control][f_p]handleMessage(), connect failed: ");
            r5.append(r2);
            btmsdkobf.C0849fg.m916w("TmsTcpManager", r5.toString());
     */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x04fa, code lost:
            if (r0.f892hn.f649jN == null) goto L_0x0541;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x0504, code lost:
            if (r0.f892hn.f649jN.size() <= 0) goto L_0x0541;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x0506, code lost:
            r2 = r0.f892hn.f649jN.iterator();
            r10 = 0;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x0513, code lost:
            if (r2.hasNext() == false) goto L_0x0542;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x0515, code lost:
            r11 = (btmsdkobf.C0636by) r2.next();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x051b, code lost:
            if (r11 != null) goto L_0x051e;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x051e, code lost:
            btmsdkobf.C0712dv.m412br().mo9316a("TmsTcpManager", r11.f357dO, r11.f358fm, r11, 11);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:226:0x0531, code lost:
            if (r11.f359fn == 0) goto L_0x0534;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x0534, code lost:
            if (r10 != 0) goto L_0x053b;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x0536, code lost:
            r10 = new btmsdkobf.C0790eg
     */
        /* JADX WARNING: Code restructure failed: missing block: B:230:0x053b, code lost:
            r10.mo9462E(r11.f357dO);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x0541, code lost:
            r10 = 0;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:232:0x0542, code lost:
            r2 = btmsdkobf.C0683dd.m255a(r0.f892hn, true, btmsdkobf.C0792ei.m765k(r1.f890mK).getGuid(), btmsdkobf.C0792ei.m766l(r1.f890mK));
     */
        /* JADX WARNING: Code restructure failed: missing block: B:233:0x0558, code lost:
            if (r2 != null) goto L_0x0565;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x055a, code lost:
            btmsdkobf.C0849fg.m916w("TmsTcpManager", "[tcp_control][http_control][shark_v4]handleMessage(), ConverterUtil.createSendBytes() return null!");
            r2 = com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_SHARK_ENCODE;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x0563, code lost:
            r3 = r10;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:236:0x0565, code lost:
            r11 = java.lang.System.currentTimeMillis();
            r13 = r0.f894mP;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:237:0x056b, code lost:
            if (r13 != null) goto L_0x057a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:238:0x056d, code lost:
            r2 = btmsdkobf.C0792ei.m756g(r1.f890mK).mo9520a(r0.f892hn, r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:239:0x057a, code lost:
            r13.setState(1);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x009a, code lost:
            r2 = new java.lang.StringBuilder();
            r2.append("[tcp_control][f_p]fp too frequency, waiting tasks count: ");
            r2.append(r0.size());
            btmsdkobf.C0849fg.m916w("TmsTcpManager", r2.toString());
            r0 = r0.iterator();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x0581, code lost:
            if (r13.mo9326bt() == false) goto L_0x0586;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:241:0x0583, code lost:
            r2 = -11;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:242:0x0586, code lost:
            r2 = btmsdkobf.C0792ei.m756g(r1.f890mK).mo9520a(r0.f892hn, r2);
            r13.setState(2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:243:0x0595, code lost:
            r6 = java.lang.System.currentTimeMillis() - r11;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:244:0x059a, code lost:
            if (r2 != 0) goto L_0x0563;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:246:0x059e, code lost:
            if (r0.f892hn == null) goto L_0x0563;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:247:0x05a0, code lost:
            r0.f892hn.f652jQ = true;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:248:0x05a5, code lost:
            if (r2 == 0) goto L_0x05c3;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:249:0x05a7, code lost:
            if (r2 == -11) goto L_0x05c3;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:250:0x05a9, code lost:
            r2 = r2 + com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_LEVEL_TCP_SEND;
            r5 = new java.lang.StringBuilder();
            r5.append("[tcp_control]handleMessage(), tcp send failed: ");
            r5.append(r2);
            btmsdkobf.C0849fg.m916w("TmsTcpManager", r5.toString());
     */
        /* JADX WARNING: Code restructure failed: missing block: B:251:0x05c3, code lost:
            if (r3 == 0) goto L_0x05ee;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:252:0x05c5, code lost:
            r3.f845mh = java.lang.String.valueOf(btmsdkobf.C0683dd.m265m(btmsdkobf.C0792ei.m767m(r1.f890mK)));
            r3.f847mj = r6;
            r3.f848mk = btmsdkobf.C0792ei.m756g(r1.f890mK).mo9526cw();
            r3.errorCode = r2;
            r3.mo9467g(btmsdkobf.C0792ei.m766l(r1.f890mK));
     */
        /* JADX WARNING: Code restructure failed: missing block: B:254:0x05f0, code lost:
            if (r2 == 0) goto L_0x0666;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:255:0x05f2, code lost:
            if (r2 != -11) goto L_0x05f5;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:256:0x05f5, code lost:
            btmsdkobf.C0786ef.m707a(r0.f892hn, 14, r2, 0);
            btmsdkobf.C0792ei.m737a(r1.f890mK, r0, r2);
            r0 = new java.util.LinkedList();
            r5 = btmsdkobf.C0792ei.m752d(r1.f890mK);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:257:0x060a, code lost:
            monitor-enter(r5);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:259:?, code lost:
            r3 = (btmsdkobf.C0792ei.C0800f) btmsdkobf.C0792ei.m753e(r1.f890mK).poll();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bf, code lost:
            if (r0.hasNext() == false) goto L_0x068a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:260:0x0617, code lost:
            if (r3 == null) goto L_0x061d;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:261:0x0619, code lost:
            r0.add(r3);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:262:0x061d, code lost:
            monitor-exit(r5);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:264:0x0622, code lost:
            if (r0.size() <= 0) goto L_0x068a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:265:0x0624, code lost:
            r3 = new java.lang.StringBuilder();
            r3.append("[tcp_control]handleMessage(), tcp send fail: ");
            r3.append(r2);
            r3.append(", notify tcp failed for other tasks: ");
            r3.append(r0.size());
            btmsdkobf.C0849fg.m916w("TmsTcpManager", r3.toString());
            r0 = r0.iterator();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:267:0x064e, code lost:
            if (r0.hasNext() == false) goto L_0x068a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:268:0x0650, code lost:
            r3 = (btmsdkobf.C0792ei.C0800f) r0.next();
            r5 = r3.f894mP;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:269:0x0658, code lost:
            if (r5 == null) goto L_0x065d;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c1, code lost:
            r3 = (btmsdkobf.C0792ei.C0800f) r0.next();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:270:0x065a, code lost:
            r5.setState(2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:271:0x065d, code lost:
            btmsdkobf.C0792ei.m737a(r1.f890mK, r3, r2);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:276:0x0666, code lost:
            btmsdkobf.C0786ef.m707a(r0.f892hn, 14, r2, 0);
            r3 = btmsdkobf.C0792ei.m752d(r1.f890mK);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:277:0x0671, code lost:
            monitor-enter(r3);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c7, code lost:
            if (r3 == null) goto L_0x00bb;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:280:0x067c, code lost:
            if (btmsdkobf.C0792ei.m753e(r1.f890mK).isEmpty() != false) goto L_0x0689;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:281:0x067e, code lost:
            btmsdkobf.C0792ei.m734a(r1.f890mK, 0, null, 0, 0, true);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:282:0x0689, code lost:
            monitor-exit(r3);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cb, code lost:
            if (r3.f892hn == null) goto L_0x00bb;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d1, code lost:
            if (r3.f892hn.f649jN == null) goto L_0x00bb;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:333:0x050f, code lost:
            r10 = r10;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:336:0x050f, code lost:
            r10 = r10;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:337:0x050f, code lost:
            r10 = r10;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00db, code lost:
            if (r3.f892hn.f649jN.size() > 0) goto L_0x00de;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00de, code lost:
            r4 = r3.f892hn.f649jN.iterator();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ea, code lost:
            if (r4.hasNext() == false) goto L_0x010a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ec, code lost:
            r10 = (btmsdkobf.C0636by) r4.next();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f3, code lost:
            if (r10 != null) goto L_0x00f6;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f6, code lost:
            btmsdkobf.C0712dv.m412br().mo9317a("TmsTcpManager", r10.f357dO, r10.f358fm, r10, 10, -40001300, (java.lang.String) null);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x010a, code lost:
            btmsdkobf.C0792ei.m737a(r1.f890mK, r3, -40001300);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x018e, code lost:
            r2 = new java.lang.StringBuilder();
            r2.append("fp failed, waiting tasks count: ");
            r2.append(r3.size());
            btmsdkobf.C0849fg.m914i("TmsTcpManager", r2.toString());
            r0 = r0.arg1;
            r2 = r3.iterator();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x01b2, code lost:
            if (r2.hasNext() == false) goto L_0x068a;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b4, code lost:
            r3 = (btmsdkobf.C0792ei.C0800f) r2.next();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01ba, code lost:
            if (r3 == null) goto L_0x01ae;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x01be, code lost:
            if (r3.f892hn == null) goto L_0x01ae;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c4, code lost:
            if (r3.f892hn.f649jN == null) goto L_0x01ae;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ce, code lost:
            if (r3.f892hn.f649jN.size() > 0) goto L_0x01d1;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x01d1, code lost:
            r4 = r3.f892hn.f649jN.iterator();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x01e0, code lost:
            if (r4.hasNext() == false) goto L_0x01ff;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x01e2, code lost:
            r11 = (btmsdkobf.C0636by) r4.next();
     */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e9, code lost:
            if (r11 != null) goto L_0x01ec;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ec, code lost:
            btmsdkobf.C0712dv.m412br().mo9317a("TmsTcpManager", r11.f357dO, r11.f358fm, r11, 9, r0 + com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_FOR_FP_FAILED, (java.lang.String) null);
     */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ff, code lost:
            btmsdkobf.C0792ei.m737a(r1.f890mK, r3, com.tencent.p605ep.common.adapt.iservice.net.ESharkCode.ERR_FOR_FP_FAILED + r0);
     */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v23
  assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.util.LinkedList]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], btmsdkobf.eg, java.util.LinkedList]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
        /* JADX WARNING: Unknown variable types count: 6 */
        public void handleMessage(android.os.Message r19) {
            /*
            r18 = this;
            r1 = r18
            r0 = r19
            int r2 = r0.what
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0357
            r6 = 9
            r7 = 3
            if (r2 == r6) goto L_0x02aa
            if (r2 == r4) goto L_0x020b
            if (r2 == r7) goto L_0x0156
            r3 = 4
            if (r2 == r3) goto L_0x014f
            switch(r2) {
                case 11: goto L_0x0115;
                case 12: goto L_0x0067;
                case 13: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x068a
        L_0x001c:
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            byte r2 = r2.f866mF
            if (r2 != r5) goto L_0x005e
            int r2 = r0.arg1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r3.append(r4)
            java.lang.Object r0 = r0.obj
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[tcp_control] handle msg: MSG_SEND_HB, retryTimes: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " reason: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "TmsTcpManager"
            btmsdkobf.C0849fg.m914i(r4, r3)
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this
            r3.m754e(r2, r0)
            goto L_0x068a
        L_0x005e:
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control][f_p][h_b]handle msg: MSG_SEND_HB, fp not sent, donnot send hb!"
            btmsdkobf.C0849fg.m916w(r0, r2)
            goto L_0x068a
        L_0x0067:
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            java.lang.Object r2 = r0.f865mE
            monitor-enter(r2)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0112 }
            java.util.LinkedList r0 = r0.f864mD     // Catch:{ all -> 0x0112 }
            if (r0 == 0) goto L_0x0110
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0112 }
            java.util.LinkedList r0 = r0.f864mD     // Catch:{ all -> 0x0112 }
            int r0 = r0.size()     // Catch:{ all -> 0x0112 }
            if (r0 > 0) goto L_0x0084
            goto L_0x0110
        L_0x0084:
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0112 }
            java.util.LinkedList r0 = r0.f864mD     // Catch:{ all -> 0x0112 }
            java.lang.Object r0 = r0.clone()     // Catch:{ all -> 0x0112 }
            java.util.LinkedList r0 = (java.util.LinkedList) r0     // Catch:{ all -> 0x0112 }
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0112 }
            java.util.LinkedList r3 = r3.f864mD     // Catch:{ all -> 0x0112 }
            r3.clear()     // Catch:{ all -> 0x0112 }
            monitor-exit(r2)     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[tcp_control][f_p]fp too frequency, waiting tasks count: "
            r2.append(r3)
            int r3 = r0.size()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TmsTcpManager"
            btmsdkobf.C0849fg.m916w(r3, r2)
            r2 = -40001300(0xfffffffffd9da0ec, float:-2.6190544E37)
            java.util.Iterator r0 = r0.iterator()
        L_0x00bb:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x068a
            java.lang.Object r3 = r0.next()
            btmsdkobf.ei$f r3 = (btmsdkobf.C0792ei.C0800f) r3
            if (r3 == 0) goto L_0x00bb
            btmsdkobf.dy$f r4 = r3.f892hn
            if (r4 == 0) goto L_0x00bb
            btmsdkobf.dy$f r4 = r3.f892hn
            java.util.ArrayList<btmsdkobf.by> r4 = r4.f649jN
            if (r4 == 0) goto L_0x00bb
            btmsdkobf.dy$f r4 = r3.f892hn
            java.util.ArrayList<btmsdkobf.by> r4 = r4.f649jN
            int r4 = r4.size()
            if (r4 > 0) goto L_0x00de
            goto L_0x00bb
        L_0x00de:
            btmsdkobf.dy$f r4 = r3.f892hn
            java.util.ArrayList<btmsdkobf.by> r4 = r4.f649jN
            java.util.Iterator r4 = r4.iterator()
        L_0x00e6:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x010a
            java.lang.Object r5 = r4.next()
            r10 = r5
            btmsdkobf.by r10 = (btmsdkobf.C0636by) r10
            if (r10 != 0) goto L_0x00f6
            goto L_0x00e6
        L_0x00f6:
            btmsdkobf.dv r6 = btmsdkobf.C0712dv.m412br()
            int r8 = r10.f357dO
            int r9 = r10.f358fm
            r11 = 10
            r13 = 0
            r12 = -40001300(0xfffffffffd9da0ec, float:-2.6190544E37)
            java.lang.String r7 = "TmsTcpManager"
            r6.mo9317a(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x00e6
        L_0x010a:
            btmsdkobf.ei r4 = btmsdkobf.C0792ei.this
            r4.m732a(r3, r2)
            goto L_0x00bb
        L_0x0110:
            monitor-exit(r2)     // Catch:{ all -> 0x0112 }
            return
        L_0x0112:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0112 }
            throw r0
        L_0x0115:
            int r2 = r0.arg1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r3.append(r4)
            java.lang.Object r0 = r0.obj
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[tcp_control] handle msg: MSG_DELAY_SEND_FIRST_PKG, retryTimes: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " reason: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "TmsTcpManager"
            btmsdkobf.C0849fg.m914i(r4, r3)
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this
            r3.m757g(r2, r0)
            goto L_0x068a
        L_0x014f:
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            r0.m747cn()
            goto L_0x068a
        L_0x0156:
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            r2.m725G(r7)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            java.lang.Object r2 = r2.f865mE
            monitor-enter(r2)
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0208 }
            java.util.LinkedList r3 = r3.f864mD     // Catch:{ all -> 0x0208 }
            if (r3 == 0) goto L_0x0206
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0208 }
            java.util.LinkedList r3 = r3.f864mD     // Catch:{ all -> 0x0208 }
            int r3 = r3.size()     // Catch:{ all -> 0x0208 }
            if (r3 > 0) goto L_0x0178
            goto L_0x0206
        L_0x0178:
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0208 }
            java.util.LinkedList r3 = r3.f864mD     // Catch:{ all -> 0x0208 }
            java.lang.Object r3 = r3.clone()     // Catch:{ all -> 0x0208 }
            java.util.LinkedList r3 = (java.util.LinkedList) r3     // Catch:{ all -> 0x0208 }
            btmsdkobf.ei r4 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0208 }
            java.util.LinkedList r4 = r4.f864mD     // Catch:{ all -> 0x0208 }
            r4.clear()     // Catch:{ all -> 0x0208 }
            monitor-exit(r2)     // Catch:{ all -> 0x0208 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "fp failed, waiting tasks count: "
            r2.append(r4)
            int r4 = r3.size()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "TmsTcpManager"
            btmsdkobf.C0849fg.m914i(r4, r2)
            int r0 = r0.arg1
            java.util.Iterator r2 = r3.iterator()
        L_0x01ae:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x068a
            java.lang.Object r3 = r2.next()
            btmsdkobf.ei$f r3 = (btmsdkobf.C0792ei.C0800f) r3
            if (r3 == 0) goto L_0x01ae
            btmsdkobf.dy$f r4 = r3.f892hn
            if (r4 == 0) goto L_0x01ae
            btmsdkobf.dy$f r4 = r3.f892hn
            java.util.ArrayList<btmsdkobf.by> r4 = r4.f649jN
            if (r4 == 0) goto L_0x01ae
            btmsdkobf.dy$f r4 = r3.f892hn
            java.util.ArrayList<btmsdkobf.by> r4 = r4.f649jN
            int r4 = r4.size()
            if (r4 > 0) goto L_0x01d1
            goto L_0x01ae
        L_0x01d1:
            btmsdkobf.dy$f r4 = r3.f892hn
            java.util.ArrayList<btmsdkobf.by> r4 = r4.f649jN
            java.util.Iterator r4 = r4.iterator()
        L_0x01d9:
            boolean r5 = r4.hasNext()
            r6 = -700000000(0xffffffffd646d900, float:-5.4658828E13)
            if (r5 == 0) goto L_0x01ff
            java.lang.Object r5 = r4.next()
            r11 = r5
            btmsdkobf.by r11 = (btmsdkobf.C0636by) r11
            if (r11 != 0) goto L_0x01ec
            goto L_0x01d9
        L_0x01ec:
            btmsdkobf.dv r7 = btmsdkobf.C0712dv.m412br()
            int r9 = r11.f357dO
            int r10 = r11.f358fm
            r12 = 9
            int r13 = r0 + r6
            r14 = 0
            java.lang.String r8 = "TmsTcpManager"
            r7.mo9317a(r8, r9, r10, r11, r12, r13, r14)
            goto L_0x01d9
        L_0x01ff:
            btmsdkobf.ei r4 = btmsdkobf.C0792ei.this
            int r6 = r6 + r0
            r4.m732a(r3, r6)
            goto L_0x01ae
        L_0x0206:
            monitor-exit(r2)     // Catch:{ all -> 0x0208 }
            return
        L_0x0208:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0208 }
            throw r0
        L_0x020b:
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            java.lang.Object r2 = r0.f865mE
            monitor-enter(r2)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x02a7 }
            java.util.LinkedList r0 = r0.f864mD     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x023c
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x02a7 }
            java.util.LinkedList r0 = r0.f864mD     // Catch:{ all -> 0x02a7 }
            int r0 = r0.size()     // Catch:{ all -> 0x02a7 }
            if (r0 <= 0) goto L_0x023c
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x02a7 }
            java.util.LinkedList r0 = r0.f864mD     // Catch:{ all -> 0x02a7 }
            java.lang.Object r0 = r0.clone()     // Catch:{ all -> 0x02a7 }
            r3 = r0
            java.util.LinkedList r3 = (java.util.LinkedList) r3     // Catch:{ all -> 0x02a7 }
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x02a7 }
            java.util.LinkedList r0 = r0.f864mD     // Catch:{ all -> 0x02a7 }
            r0.clear()     // Catch:{ all -> 0x02a7 }
        L_0x023c:
            monitor-exit(r2)     // Catch:{ all -> 0x02a7 }
            if (r3 == 0) goto L_0x0292
            int r0 = r3.size()
            if (r0 <= 0) goto L_0x0292
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[tcp_control]fp success. send waiting for fp tasks: "
            r0.append(r2)
            int r2 = r3.size()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "TmsTcpManager"
            btmsdkobf.C0849fg.m914i(r2, r0)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            java.lang.Object r2 = r0.f865mE
            monitor-enter(r2)
            java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x028f }
        L_0x026a:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x028f }
            if (r3 == 0) goto L_0x0282
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x028f }
            btmsdkobf.ei$f r3 = (btmsdkobf.C0792ei.C0800f) r3     // Catch:{ all -> 0x028f }
            if (r3 == 0) goto L_0x026a
            btmsdkobf.ei r4 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x028f }
            btmsdkobf.er r4 = r4.f870mJ     // Catch:{ all -> 0x028f }
            r4.add(r3)     // Catch:{ all -> 0x028f }
            goto L_0x026a
        L_0x0282:
            monitor-exit(r2)     // Catch:{ all -> 0x028f }
            btmsdkobf.ei r5 = btmsdkobf.C0792ei.this
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 1
            r5.m731a(r6, r7, r8, r9, r11)
            goto L_0x0299
        L_0x028f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x028f }
            throw r0
        L_0x0292:
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control]fp success, no task waiting for fp"
            btmsdkobf.C0849fg.m914i(r0, r2)
        L_0x0299:
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control][h_b]restartHeartBeat after fp success"
            btmsdkobf.C0849fg.m914i(r0, r2)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            r0.m748cp()
            goto L_0x068a
        L_0x02a7:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x02a7 }
            throw r0
        L_0x02aa:
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control][f_p] handle: MSG_ON_CHANGE_TO_CONNECTED"
            btmsdkobf.C0849fg.m911d(r0, r2)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            btmsdkobf.ee r0 = r0.f875mx
            int r0 = r0.mo9447ca()
            if (r0 > 0) goto L_0x02c5
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control][f_p] handle connected msg: ref connt <= 0, no need to reconnect"
            btmsdkobf.C0849fg.m911d(r0, r2)
            return
        L_0x02c5:
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            int r0 = r0.f877mz
            if (r0 >= r7) goto L_0x0327
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[tcp_control][f_p] handle connected msg, ref count: "
            r0.append(r2)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            btmsdkobf.ee r2 = r2.f875mx
            int r2 = r2.mo9447ca()
            r0.append(r2)
            java.lang.String r2 = ", wait for network become stable and send fp in: "
            r0.append(r2)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            btmsdkobf.ee r2 = r2.f875mx
            btmsdkobf.bi r2 = r2.mo9443ak()
            int r2 = r2.f218cU
            r0.append(r2)
            java.lang.String r2 = "s"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "TmsTcpManager"
            btmsdkobf.C0849fg.m911d(r2, r0)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            r0.f877mz = r0.f877mz + 1
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            r3 = 11
            r5 = 0
            r6 = 1000(0x3e8, double:4.94E-321)
            btmsdkobf.ee r0 = r2.f875mx
            btmsdkobf.bi r0 = r0.mo9443ak()
            int r0 = r0.f218cU
            long r8 = (long) r0
            long r6 = r6 * r8
            r8 = 1
            java.lang.String r4 = "delay_fp_network_connected"
            r2.m731a(r3, r4, r5, r6, r8)
            goto L_0x068a
        L_0x0327:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[tcp_control][f_p] handle connected msg, ref count: "
            r0.append(r2)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            btmsdkobf.ee r2 = r2.f875mx
            int r2 = r2.mo9447ca()
            r0.append(r2)
            java.lang.String r2 = ", mReconnectTimes over limit: "
            r0.append(r2)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            int r2 = r2.f877mz
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "TmsTcpManager"
            btmsdkobf.C0849fg.m916w(r2, r0)
            goto L_0x068a
        L_0x0357:
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control]handle MSG_SEND_TASK"
            btmsdkobf.C0849fg.m914i(r0, r2)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            java.lang.Object r2 = r0.f865mE
            monitor-enter(r2)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0697 }
            btmsdkobf.er r0 = r0.f870mJ     // Catch:{ all -> 0x0697 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0697 }
            btmsdkobf.ei$f r0 = (btmsdkobf.C0792ei.C0800f) r0     // Catch:{ all -> 0x0697 }
            if (r0 == 0) goto L_0x068e
            btmsdkobf.dy$f r6 = r0.f892hn     // Catch:{ all -> 0x0697 }
            if (r6 != 0) goto L_0x0379
            goto L_0x068e
        L_0x0379:
            monitor-exit(r2)     // Catch:{ all -> 0x0697 }
            r6 = 0
            btmsdkobf.dy$f r2 = r0.f892hn
            boolean r2 = r2.mo9364bJ()
            r8 = -11
            r9 = 0
            if (r2 == 0) goto L_0x0392
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r5 = "[tcp_control][time_out]MSG_SEND_TASK, send time out"
            btmsdkobf.C0849fg.m916w(r2, r5)
            r2 = -17
            goto L_0x05a5
        L_0x0392:
            btmsdkobf.dy$f r2 = r0.f892hn
            boolean r2 = r2.mo9366bL()
            if (r2 != 0) goto L_0x03a2
            btmsdkobf.dy$f r2 = r0.f892hn
            boolean r2 = r2.f642jG
            if (r2 != 0) goto L_0x03a2
            r2 = 1
            goto L_0x03a3
        L_0x03a2:
            r2 = 0
        L_0x03a3:
            if (r2 == 0) goto L_0x047c
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            byte r2 = r2.f866mF
            if (r2 != r5) goto L_0x03fd
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            btmsdkobf.et r2 = r2.f871mt
            boolean r2 = r2.mo9521cC()
            if (r2 != 0) goto L_0x03f7
            btmsdkobf.dy$f r2 = r0.f892hn
            boolean r2 = r2.f641jF
            if (r2 == 0) goto L_0x03c7
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control][f_p][h_b]handleMessage(), [hb] connection is broken, , ignore heartbeat"
            btmsdkobf.C0849fg.m916w(r0, r2)
            return
        L_0x03c7:
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r3 = "[tcp_control][f_p]handleMessage(), [others] connection is broken, wait and resend fp"
            btmsdkobf.C0849fg.m916w(r2, r3)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            btmsdkobf.dy$f r3 = r0.f892hn
            r2.m761h(r3)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            java.lang.Object r2 = r2.f865mE
            monitor-enter(r2)
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x03f4 }
            java.util.LinkedList r3 = r3.f864mD     // Catch:{ all -> 0x03f4 }
            r3.add(r0)     // Catch:{ all -> 0x03f4 }
            monitor-exit(r2)     // Catch:{ all -> 0x03f4 }
            btmsdkobf.ei r4 = btmsdkobf.C0792ei.this
            r5 = 11
            r7 = 0
            r8 = 0
            r10 = 1
            java.lang.String r6 = "conn_broken_didnt_monitored"
            r4.m731a(r5, r6, r7, r8, r10)
            return
        L_0x03f4:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x03f4 }
            throw r0
        L_0x03f7:
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r10 = "[tcp_control][f_p]handleMessage(), [others] connection is ok"
            goto L_0x04d8
        L_0x03fd:
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            byte r2 = r2.f866mF
            if (r2 != r4) goto L_0x0436
            btmsdkobf.dy$f r2 = r0.f892hn
            boolean r2 = r2.f641jF
            if (r2 == 0) goto L_0x0413
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control][f_p][h_b]handleMessage(), [hb] sending fp, ignore heartbeat"
            btmsdkobf.C0849fg.m916w(r0, r2)
            return
        L_0x0413:
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r3 = "[tcp_control][f_p]handleMessage(), [others] sending fp, enqueue this task and wait"
            btmsdkobf.C0849fg.m916w(r2, r3)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            btmsdkobf.dy$f r3 = r0.f892hn
            r2.m762i(r3)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            java.lang.Object r2 = r2.f865mE
            monitor-enter(r2)
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0433 }
            java.util.LinkedList r3 = r3.f864mD     // Catch:{ all -> 0x0433 }
            r3.add(r0)     // Catch:{ all -> 0x0433 }
            monitor-exit(r2)     // Catch:{ all -> 0x0433 }
            return
        L_0x0433:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0433 }
            throw r0
        L_0x0436:
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            byte r2 = r2.f866mF
            if (r2 != 0) goto L_0x04db
            btmsdkobf.dy$f r2 = r0.f892hn
            boolean r2 = r2.f641jF
            if (r2 == 0) goto L_0x044c
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r2 = "[tcp_control][f_p][h_b]handleMessage(), [hb] fp not sent, ignore heartbeat"
            btmsdkobf.C0849fg.m916w(r0, r2)
            return
        L_0x044c:
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r3 = "[tcp_control][f_p]handleMessage(), [others] fp not sent, send fp & enqueue this task"
            btmsdkobf.C0849fg.m916w(r2, r3)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            btmsdkobf.dy$f r3 = r0.f892hn
            r2.m761h(r3)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            java.lang.Object r2 = r2.f865mE
            monitor-enter(r2)
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0479 }
            java.util.LinkedList r3 = r3.f864mD     // Catch:{ all -> 0x0479 }
            r3.add(r0)     // Catch:{ all -> 0x0479 }
            monitor-exit(r2)     // Catch:{ all -> 0x0479 }
            btmsdkobf.ei r4 = btmsdkobf.C0792ei.this
            r5 = 11
            r7 = 0
            r8 = 0
            r10 = 1
            java.lang.String r6 = "others_depend_on_fp"
            r4.m731a(r5, r6, r7, r8, r10)
            return
        L_0x0479:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0479 }
            throw r0
        L_0x047c:
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            boolean r2 = r2.f869mI
            if (r2 == 0) goto L_0x04ab
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            r2.f869mI = r9
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r10 = "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 1: reconnect"
            btmsdkobf.C0849fg.m916w(r2, r10)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            java.lang.String r10 = "disconnected_before_send"
            int r2 = r2.m770v(r10)
            btmsdkobf.dy$f r10 = r0.f892hn
            boolean r10 = r10.f642jG
            if (r10 != 0) goto L_0x04dc
            btmsdkobf.ei r10 = btmsdkobf.C0792ei.this
            r10.f866mF = r9
            java.lang.String r10 = "TmsTcpManager"
            java.lang.String r11 = "[tcp_control][f_p]handleMessage(), [vip] last disconnect not handled, 2: not fp, mark fp_not_send"
        L_0x04a7:
            btmsdkobf.C0849fg.m916w(r10, r11)
            goto L_0x04dc
        L_0x04ab:
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            btmsdkobf.et r2 = r2.f871mt
            boolean r2 = r2.mo9521cC()
            if (r2 != 0) goto L_0x04d4
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r10 = "[tcp_control][f_p]handleMessage(), [vip] not connected, 1: connect"
            btmsdkobf.C0849fg.m916w(r2, r10)
            btmsdkobf.ei r2 = btmsdkobf.C0792ei.this
            int r2 = r2.m746cm()
            btmsdkobf.dy$f r10 = r0.f892hn
            boolean r10 = r10.f642jG
            if (r10 != 0) goto L_0x04dc
            btmsdkobf.ei r10 = btmsdkobf.C0792ei.this
            r10.f866mF = r9
            java.lang.String r10 = "TmsTcpManager"
            java.lang.String r11 = "[tcp_control][f_p]handleMessage(), [vip] not connected, 2: not fp, mark fp_not_send"
            goto L_0x04a7
        L_0x04d4:
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r10 = "[tcp_control][f_p]handleMessage(), [vip] connection is ok"
        L_0x04d8:
            btmsdkobf.C0849fg.m914i(r2, r10)
        L_0x04db:
            r2 = 0
        L_0x04dc:
            if (r2 == 0) goto L_0x04f6
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = "[tcp_control][f_p]handleMessage(), connect failed: "
            r5.append(r10)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String r10 = "TmsTcpManager"
            btmsdkobf.C0849fg.m916w(r10, r5)
            goto L_0x05a5
        L_0x04f6:
            btmsdkobf.dy$f r2 = r0.f892hn
            java.util.ArrayList<btmsdkobf.by> r2 = r2.f649jN
            if (r2 == 0) goto L_0x0541
            btmsdkobf.dy$f r2 = r0.f892hn
            java.util.ArrayList<btmsdkobf.by> r2 = r2.f649jN
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0541
            btmsdkobf.dy$f r2 = r0.f892hn
            java.util.ArrayList<btmsdkobf.by> r2 = r2.f649jN
            java.util.Iterator r2 = r2.iterator()
            r10 = r3
        L_0x050f:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L_0x0542
            java.lang.Object r11 = r2.next()
            btmsdkobf.by r11 = (btmsdkobf.C0636by) r11
            if (r11 != 0) goto L_0x051e
            goto L_0x050f
        L_0x051e:
            btmsdkobf.dv r12 = btmsdkobf.C0712dv.m412br()
            int r14 = r11.f357dO
            int r15 = r11.f358fm
            r17 = 11
            java.lang.String r13 = "TmsTcpManager"
            r16 = r11
            r12.mo9316a(r13, r14, r15, r16, r17)
            int r12 = r11.f359fn
            if (r12 == 0) goto L_0x0534
            goto L_0x050f
        L_0x0534:
            if (r10 != 0) goto L_0x053b
            btmsdkobf.eg r10 = new btmsdkobf.eg
            r10.m40728init()
        L_0x053b:
            int r11 = r11.f357dO
            r10.mo9462E(r11)
            goto L_0x050f
        L_0x0541:
            r10 = r3
        L_0x0542:
            btmsdkobf.dy$f r2 = r0.f892hn
            btmsdkobf.ei r11 = btmsdkobf.C0792ei.this
            btmsdkobf.dy r11 = r11.f858hA
            java.lang.String r11 = r11.getGuid()
            btmsdkobf.ei r12 = btmsdkobf.C0792ei.this
            btmsdkobf.dl r12 = r12.f857gZ
            byte[] r2 = btmsdkobf.C0683dd.m255a(r2, r5, r11, r12)
            if (r2 != 0) goto L_0x0565
            java.lang.String r2 = "TmsTcpManager"
            java.lang.String r3 = "[tcp_control][http_control][shark_v4]handleMessage(), ConverterUtil.createSendBytes() return null!"
            btmsdkobf.C0849fg.m916w(r2, r3)
            r2 = -1500(0xfffffffffffffa24, float:NaN)
        L_0x0563:
            r3 = r10
            goto L_0x05a5
        L_0x0565:
            long r11 = java.lang.System.currentTimeMillis()
            btmsdkobf.dw r13 = r0.f894mP
            if (r13 != 0) goto L_0x057a
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this
            btmsdkobf.et r3 = r3.f871mt
            btmsdkobf.dy$f r6 = r0.f892hn
            int r2 = r3.mo9520a(r6, r2)
            goto L_0x0595
        L_0x057a:
            r13.setState(r5)
            boolean r14 = r13.mo9326bt()
            if (r14 == 0) goto L_0x0586
            r2 = -11
            goto L_0x05a5
        L_0x0586:
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this
            btmsdkobf.et r3 = r3.f871mt
            btmsdkobf.dy$f r6 = r0.f892hn
            int r2 = r3.mo9520a(r6, r2)
            r13.setState(r4)
        L_0x0595:
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r11
            if (r2 != 0) goto L_0x0563
            btmsdkobf.dy$f r3 = r0.f892hn
            if (r3 == 0) goto L_0x0563
            btmsdkobf.dy$f r3 = r0.f892hn
            r3.f652jQ = r5
            goto L_0x0563
        L_0x05a5:
            if (r2 == 0) goto L_0x05c3
            if (r2 == r8) goto L_0x05c3
            r5 = -40000000(0xfffffffffd9da600, float:-2.619384E37)
            int r2 = r2 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = "[tcp_control]handleMessage(), tcp send failed: "
            r5.append(r10)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String r10 = "TmsTcpManager"
            btmsdkobf.C0849fg.m916w(r10, r5)
        L_0x05c3:
            if (r3 == 0) goto L_0x05ee
            btmsdkobf.ei r5 = btmsdkobf.C0792ei.this
            android.content.Context r5 = r5.mContext
            int r5 = btmsdkobf.C0683dd.m265m(r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r3.f845mh = r5
            r3.f847mj = r6
            btmsdkobf.ei r5 = btmsdkobf.C0792ei.this
            btmsdkobf.et r5 = r5.f871mt
            java.lang.String r5 = r5.mo9526cw()
            r3.f848mk = r5
            r3.errorCode = r2
            btmsdkobf.ei r5 = btmsdkobf.C0792ei.this
            btmsdkobf.dl r5 = r5.f857gZ
            r3.mo9467g(r5)
        L_0x05ee:
            r3 = 14
            if (r2 == 0) goto L_0x0666
            if (r2 != r8) goto L_0x05f5
            goto L_0x0666
        L_0x05f5:
            btmsdkobf.dy$f r5 = r0.f892hn
            btmsdkobf.C0786ef.m707a(r5, r3, r2, r9)
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this
            r3.m732a(r0, r2)
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this
            java.lang.Object r5 = r3.f865mE
            monitor-enter(r5)
        L_0x060b:
            btmsdkobf.ei r3 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x0663 }
            btmsdkobf.er r3 = r3.f870mJ     // Catch:{ all -> 0x0663 }
            java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0663 }
            btmsdkobf.ei$f r3 = (btmsdkobf.C0792ei.C0800f) r3     // Catch:{ all -> 0x0663 }
            if (r3 == 0) goto L_0x061d
            r0.add(r3)     // Catch:{ all -> 0x0663 }
            goto L_0x060b
        L_0x061d:
            monitor-exit(r5)     // Catch:{ all -> 0x0663 }
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x068a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "[tcp_control]handleMessage(), tcp send fail: "
            r3.append(r5)
            r3.append(r2)
            java.lang.String r5 = ", notify tcp failed for other tasks: "
            r3.append(r5)
            int r5 = r0.size()
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "TmsTcpManager"
            btmsdkobf.C0849fg.m916w(r5, r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x064a:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x068a
            java.lang.Object r3 = r0.next()
            btmsdkobf.ei$f r3 = (btmsdkobf.C0792ei.C0800f) r3
            btmsdkobf.dw r5 = r3.f894mP
            if (r5 == 0) goto L_0x065d
            r5.setState(r4)
        L_0x065d:
            btmsdkobf.ei r5 = btmsdkobf.C0792ei.this
            r5.m732a(r3, r2)
            goto L_0x064a
        L_0x0663:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0663 }
            throw r0
        L_0x0666:
            btmsdkobf.dy$f r0 = r0.f892hn
            btmsdkobf.C0786ef.m707a(r0, r3, r2, r9)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this
            java.lang.Object r3 = r0.f865mE
            monitor-enter(r3)
            btmsdkobf.ei r0 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x068b }
            btmsdkobf.er r0 = r0.f870mJ     // Catch:{ all -> 0x068b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x068b }
            if (r0 != 0) goto L_0x0689
            btmsdkobf.ei r4 = btmsdkobf.C0792ei.this     // Catch:{ all -> 0x068b }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 1
            r4.m731a(r5, r6, r7, r8, r10)     // Catch:{ all -> 0x068b }
        L_0x0689:
            monitor-exit(r3)     // Catch:{ all -> 0x068b }
        L_0x068a:
            return
        L_0x068b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x068b }
            throw r0
        L_0x068e:
            java.lang.String r0 = "TmsTcpManager"
            java.lang.String r3 = "[tcp_control]no task for send"
            btmsdkobf.C0849fg.m916w(r0, r3)     // Catch:{ all -> 0x0697 }
            monitor-exit(r2)     // Catch:{ all -> 0x0697 }
            return
        L_0x0697:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0697 }
            throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0792ei.C0799e.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: btmsdkobf.ei$f */
    private class C0800f {
        /* renamed from: ft */
        public int f891ft = 0;
        /* renamed from: hn */
        public C0738f f892hn = null;
        /* renamed from: mP */
        public C0715dw f894mP = null;

        public C0800f(int i, C0715dw dwVar, C0738f fVar) {
            this.f891ft = i;
            this.f894mP = dwVar;
            this.f892hn = fVar;
        }
    }

    public C0792ei(C0695dl dlVar, C0814ep epVar, C0789a aVar, C0798d dVar, C0698do doVar, C0736d dVar2, C0718dy dyVar) {
        this.mContext = null;
        this.f871mt = null;
        this.f859hd = false;
        this.f877mz = 0;
        this.f861mA = 15000;
        this.f862mB = 0;
        this.f863mC = false;
        this.f864mD = new LinkedList<>();
        this.f865mE = new Object();
        this.f866mF = 0;
        this.f867mG = null;
        this.f868mH = null;
        this.f869mI = false;
        this.f870mJ = new C0818er<>(new Comparator<C0800f>() {
            /* renamed from: a */
            public int compare(C0800f fVar, C0800f fVar2) {
                return C0668cv.m144h(fVar2.f891ft) - C0668cv.m144h(fVar.f891ft);
            }
        });
        this.mContext = C0652cl.m85D();
        this.f871mt = new C0824et(this.mContext, this, epVar);
        m771z(epVar.mo9283ai());
        this.f867mG = C0845fd.m898cN().newFreeHandlerThread("sendHandlerThread");
        this.f867mG.start();
        this.f868mH = new C0799e(this.f867mG.getLooper());
        this.f857gZ = dlVar;
        this.f860jp = aVar;
        this.f872mu = doVar;
        this.f874mw = dVar;
        this.f858hA = dyVar;
        this.f876my = new C0809eo(this.mContext, this, this);
        this.f875mx = new C0780ee(dlVar, this);
        m741b(dVar2);
        C0739dz.m545bM().mo9367a((C0745a) this);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: G */
    public final void m725G(int i) {
        Handler handler = this.f868mH;
        if (handler != null) {
            handler.removeMessages(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0801ej<Long, Integer, JceStruct> m729a(long j, C0620bi biVar) {
        String str = "TmsTcpManager";
        if (biVar == null) {
            C0849fg.m916w(str, "[shark_push][shark_conf]handleSharkConfPush(), scSharkConf == null");
            return null;
        }
        C0849fg.m911d(str, "[shark_push][shark_conf]------------- handleSharkConfPush() ---------------------");
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
        this.f875mx.mo9446c(biVar);
        C0616be beVar = new C0616be();
        beVar.f193cy = biVar.f219cy;
        beVar.f194cz = biVar.f220cz;
        return new C0801ej<>(Long.valueOf(j), Integer.valueOf(1101), beVar);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m731a(int i, Object obj, int i2, long j, boolean z) {
        Handler handler = this.f868mH;
        if (handler != null) {
            if (z) {
                handler.removeMessages(i);
            }
            this.f868mH.sendMessageDelayed(Message.obtain(this.f868mH, i, i2, 0, obj), j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m732a(C0800f fVar, int i) {
        if (fVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[send_control] tcp fail, notify up level: ");
            sb.append(i);
            C0849fg.m914i("TmsTcpManager", sb.toString());
            C0698do doVar = this.f872mu;
            if (doVar != null) {
                doVar.mo9299a(fVar.f892hn, i);
            }
        }
    }

    /* renamed from: a */
    private void m738a(String str, C0648ch chVar) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ServerShark seqNo|");
        sb3.append(chVar.f393fm);
        String str2 = "|refSeqNo|";
        sb3.append(str2);
        sb3.append(chVar.f394fn);
        sb2.append(sb3.toString());
        if (chVar.f392fF != null && chVar.f392fF.size() > 0) {
            Iterator it = chVar.f392fF.iterator();
            while (it.hasNext()) {
                C0647cg cgVar = (C0647cg) it.next();
                String str3 = "|dataRetCode|";
                String str4 = "|retCode|";
                String str5 = "|seqNo|";
                if (cgVar.f386fn != 0) {
                    sb = new StringBuilder();
                    sb.append(" || sashimi cmd|");
                    sb.append(cgVar.f383dO);
                    sb.append(str5);
                    sb.append(cgVar.f385fm);
                    sb.append(str2);
                    sb.append(cgVar.f386fn);
                    sb.append(str4);
                    sb.append(cgVar.f388fq);
                    sb.append(str3);
                    sb.append(cgVar.f389fr);
                } else {
                    sb = new StringBuilder();
                    sb.append(" || push cmd|");
                    sb.append(cgVar.f383dO);
                    sb.append(str5);
                    sb.append(cgVar.f385fm);
                    sb.append(str2);
                    sb.append(cgVar.f386fn);
                    sb.append(str4);
                    sb.append(cgVar.f388fq);
                    sb.append(str3);
                    sb.append(cgVar.f389fr);
                    sb.append("|pushId|");
                    sb.append(cgVar.f384fD.f380fl);
                }
                sb2.append(sb.toString());
            }
        }
        C0849fg.m915v(str, sb2.toString());
    }

    /* renamed from: b */
    private void m741b(C0736d dVar) {
        this.f873mv = new C0696dm() {
            /* renamed from: a */
            public C0801ej<Long, Integer, JceStruct> mo9297a(int i, long j, int i2, JceStruct jceStruct) {
                if (jceStruct == null) {
                    C0849fg.m916w("TmsTcpManager", "[shark_push][shark_conf]onRecvPush() null == push");
                    return null;
                } else if (i2 != 11101) {
                    return null;
                } else {
                    return C0792ei.this.m729a(j, (C0620bi) jceStruct);
                }
            }
        };
        C0849fg.m914i("TmsTcpManager", "[shark_push][shark_conf]registerSharkPush()");
        if (dVar != null) {
            dVar.mo9359a(0, 11101, new C0620bi(), 0, this.f873mv, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cm */
    public int m746cm() {
        int i;
        String str = "TmsTcpManager";
        C0849fg.m914i(str, "[tcp_control]connectIfNeed()");
        if (!this.f871mt.mo9521cC()) {
            i = !this.f871mt.mo9527m() ? ESharkCode.ERR_NETWORK_NO_CONNECT : this.f871mt.mo9523cH();
        } else {
            C0849fg.m914i(str, "[tcp_control]connectIfNeed(), already connected");
            i = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control]connectIfNeed(), ret: ");
        sb.append(i);
        C0849fg.m914i(str, sb.toString());
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: cn */
    public void m747cn() {
        C0849fg.m914i("TmsTcpManager", "[tcp_control]tryCloseConnectionSync()");
        if (this.f875mx.mo9447ca() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("[tcp_control]tryCloseConnectionSync(), not allow, ref connt: ");
            sb.append(this.f875mx.mo9447ca());
            C0848ff.m905d("TmsTcpManager", sb.toString());
            return;
        }
        this.f875mx.mo9448cb();
        C0849fg.m914i("TmsTcpManager", "[tcp_control]tryCloseConnectionSync(), update: fp not send");
        this.f866mF = 0;
        this.f877mz = 0;
        m750cr();
        synchronized (this.f865mE) {
            this.f870mJ.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int cG = this.f871mt.mo9522cG();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        C0814ep ck = this.f871mt.mo9525ck();
        if (!(ck == null || ck.mo9284m(true) == null)) {
            C0790eg egVar = new C0790eg();
            C0817b m = ck.mo9284m(true);
            egVar.f842me = m.mo9500cu();
            egVar.f843mf = String.valueOf(m.getPort());
            egVar.f845mh = String.valueOf(C0683dd.m265m(this.mContext));
            egVar.f848mk = this.f871mt.mo9526cw();
            egVar.errorCode = cG;
            egVar.f847mj = currentTimeMillis2;
            egVar.mo9464e(this.f857gZ);
        }
    }

    /* access modifiers changed from: private|declared_synchronized */
    /* renamed from: cp */
    public synchronized void m748cp() {
        m750cr();
        m749cq();
    }

    /* renamed from: cq */
    private synchronized void m749cq() {
        C0849fg.m914i("TmsTcpManager", "[h_b]startHeartBeat");
        if (this.f876my != null) {
            this.f876my.start();
        }
    }

    /* renamed from: cr */
    private synchronized void m750cr() {
        C0849fg.m914i("TmsTcpManager", "[h_b]stopHeartBeat");
        if (this.f876my != null) {
            this.f876my.stop();
        }
    }

    /* renamed from: cs */
    private synchronized void m751cs() {
        C0849fg.m914i("TmsTcpManager", "[h_b]resetHeartBeat");
        if (this.f876my != null) {
            this.f876my.reset();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m754e(int i, String str) {
        int i2 = i;
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control][h_b][shark_conf]sendHeartBeat(), retryTimes: ");
        sb.append(i2);
        sb.append(" reason: ");
        sb.append(str2);
        C0849fg.m914i("TmsTcpManager", sb.toString());
        ArrayList arrayList = new ArrayList();
        C0636by byVar = new C0636by();
        byVar.f357dO = 999;
        byVar.f358fm = C0709du.m406bn().mo9293bf();
        arrayList.add(byVar);
        byte bq = C0709du.m408bp().mo9312bq();
        long j = i2 < 1 ? 30 : 60;
        C0796b bVar = new C0796b(byVar.f358fm, i, str, bq);
        long j2 = 1000 * j;
        byte b = bq;
        C0738f fVar = r7;
        C0636by byVar2 = byVar;
        C0738f fVar2 = new C0738f(1024, false, true, false, 0, arrayList, bVar, j2);
        fVar.f653jR = b;
        C0712dv.m412br().mo9315a(byVar2.f358fm, j2, str2);
        C0712dv.m412br().mo9314a(b, fVar.f646jK);
        this.f874mw.mo9330a(fVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m757g(int i, String str) {
        int i2 = i;
        String str2 = str;
        byte b = this.f866mF;
        boolean z = true;
        String str3 = "TmsTcpManager";
        if (b == 1 || b == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("[tcp_control][f_p]sending or received fp, no more send, is received ? ");
            if (this.f866mF != 1) {
                z = false;
            }
            sb.append(z);
            C0849fg.m914i(str3, sb.toString());
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f862mB) < this.f861mA) {
            C0849fg.m916w(str3, "[tcp_control][f_p]first pkg too frequency, send delay");
            m731a(12, null, 0, 0, true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delay_too_freq:");
            sb2.append(str2);
            m731a(11, sb2.toString(), i, this.f861mA, true);
            return;
        }
        int i3 = this.f875mx.mo9443ak().f218cU;
        long j = 1000 * ((long) i3);
        if (C0701dr.m387bj().mo9302d(j)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[tcp_control][f_p]net state changing, send fp delay(s): ");
            sb3.append(i3);
            C0849fg.m916w(str3, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("delay_waitfor_stable:");
            sb4.append(str2);
            m731a(11, sb4.toString(), i, j, true);
            return;
        }
        this.f862mB = currentTimeMillis;
        this.f866mF = 2;
        m725G(11);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[tcp_control][f_p]send first pkg, reason: ");
        sb5.append(str2);
        sb5.append(" retryTimes: ");
        sb5.append(i2);
        C0849fg.m916w(str3, sb5.toString());
        C0636by byVar = new C0636by();
        byVar.f357dO = 997;
        byVar.f358fm = C0709du.m406bn().mo9293bf();
        byVar.f360fo = C0683dd.m252a(this.mContext, (JceStruct) null, byVar.f357dO, byVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(byVar);
        C0712dv.m412br().mo9315a(byVar.f358fm, -1, str2);
        C0738f fVar = new C0738f(1024, false, false, true, 0, arrayList, new C0795a(byVar.f358fm, i2, str2), 0);
        this.f874mw.mo9330a(fVar);
    }

    /* renamed from: g */
    private void m758g(long j) {
        C0849fg.m914i("TmsTcpManager", "[tcp_control] checkKeepAliveAndResetHeartBeat()");
        m751cs();
        this.f875mx.mo9450f(j);
    }

    /* renamed from: g */
    private void m759g(C0738f fVar) {
        if (fVar != null && fVar.f649jN != null && fVar.f649jN.size() > 0) {
            Iterator it = fVar.f649jN.iterator();
            while (it.hasNext()) {
                C0636by byVar = (C0636by) it.next();
                if (byVar != null) {
                    C0712dv.m412br().mo9316a("TmsTcpManager", byVar.f357dO, byVar.f358fm, byVar, 6);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m761h(C0738f fVar) {
        if (fVar != null && fVar.f649jN != null && fVar.f649jN.size() > 0) {
            Iterator it = fVar.f649jN.iterator();
            while (it.hasNext()) {
                C0636by byVar = (C0636by) it.next();
                if (byVar != null) {
                    C0712dv.m412br().mo9316a("TmsTcpManager", byVar.f357dO, byVar.f358fm, byVar, 8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m762i(C0738f fVar) {
        if (fVar != null && fVar.f649jN != null && fVar.f649jN.size() > 0) {
            Iterator it = fVar.f649jN.iterator();
            while (it.hasNext()) {
                C0636by byVar = (C0636by) it.next();
                if (byVar != null) {
                    C0712dv.m412br().mo9316a("TmsTcpManager", byVar.f357dO, byVar.f358fm, byVar, 7);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public int m770v(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control]reconnect(), reason: ");
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = "TmsTcpManager";
        C0849fg.m914i(str2, sb2);
        int cI = this.f871mt.mo9524cI();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("[tcp_control]reconnect(), ret: ");
        sb3.append(cI);
        C0849fg.m914i(str2, sb3.toString());
        return cI;
    }

    /* renamed from: z */
    private void m771z(boolean z) {
        this.f859hd = z;
        if (z) {
            this.f861mA = 15000;
        }
    }

    /* renamed from: H */
    public void mo9469H(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control]onTcpEvent(), eventCode: ");
        sb.append(i);
        C0849fg.m911d("TmsTcpManager", sb.toString());
    }

    /* renamed from: a */
    public void mo9470a(int i, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control]onTcpError(), errCode: ");
        sb.append(i);
        sb.append(" msg: ");
        sb.append(obj);
        String sb2 = sb.toString();
        String str = "TmsTcpManager";
        C0849fg.m911d(str, sb2);
        switch (i) {
            case 10:
            case 11:
            case 12:
                this.f869mI = true;
                this.f866mF = 0;
                if (this.f875mx.mo9447ca() > 0) {
                    String str2 = "[tcp_control][f_p]tcp_connect_broken, ref count: ";
                    if (this.f877mz < 3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(this.f875mx.mo9447ca());
                        sb3.append(", delay send fp in ");
                        sb3.append(this.f875mx.mo9443ak().f217cT);
                        sb3.append("s");
                        C0849fg.m916w(str, sb3.toString());
                        this.f877mz++;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("delay_fp_for_connect_broken");
                        sb4.append(i);
                        m731a(11, sb4.toString(), 0, ((long) this.f875mx.mo9443ak().f217cT) * 1000, true);
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    sb5.append(this.f875mx.mo9447ca());
                    sb5.append(", mReconnectTimes over limit: ");
                    sb5.append(this.f877mz);
                    C0849fg.m916w(str, sb5.toString());
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo9471a(String str, byte[] bArr) {
        try {
            m738a(str, C0699dp.m383j(bArr));
        } catch (Throwable th) {
            C0849fg.m912e(str, th.getMessage());
        }
    }

    /* access modifiers changed from: declared_synchronized */
    /* renamed from: bV */
    public synchronized void mo9472bV() {
        C0849fg.m914i("TmsTcpManager", "get couldNotConnect cmd");
    }

    /* renamed from: bW */
    public void mo9473bW() {
        this.f875mx.mo9444bW();
    }

    /* renamed from: bX */
    public void mo9474bX() {
        this.f875mx.mo9445bX();
    }

    /* renamed from: c */
    public void mo9475c(int i, byte[] bArr) {
        String str = "TmsTcpManager";
        C0849fg.m911d(str, "[tcp_control]onReceiveData()");
        this.f877mz = 0;
        if (this.f859hd && bArr != null && !C0716dx.m437l(bArr)) {
            mo9471a(str, bArr);
        }
        this.f860jp.mo9346a(true, 0, bArr, null);
    }

    /* renamed from: cj */
    public void mo9456cj() {
        mo9478f(0, "tcp_control");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: co */
    public boolean mo9476co() {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        byte b = this.f866mF;
        String str3 = "TmsTcpManager";
        if (b == 1) {
            str2 = "[tcp_control]guessTcpWillSucc(), fp succ, prefer tcp";
        } else {
            if (b == 2) {
                long abs = Math.abs(System.currentTimeMillis() - this.f862mB);
                if (this.f862mB <= 0 || abs >= 10000) {
                    sb2 = new StringBuilder();
                    sb2.append("[tcp_control]guessTcpWillSucc(), fp sending over 10s, prefer http: ");
                    sb2.append(abs);
                    C0849fg.m916w(str3, sb2.toString());
                    return false;
                }
                sb = new StringBuilder();
                sb.append("[tcp_control]guessTcpWillSucc(), fp sending within 10s, prefer tcp: ");
                sb.append(abs);
            } else if (this.f862mB <= 0) {
                str2 = "[tcp_control]guessTcpWillSucc(), fp first time, prefer tcp";
            } else {
                long abs2 = Math.abs(System.currentTimeMillis() - this.f862mB);
                if (abs2 > 1800000) {
                    sb = new StringBuilder();
                    str = "[tcp_control]guessTcpWillSucc(), over 30 mins since last fp, try again, prefer tcp: ";
                } else if (this.f863mC) {
                    sb2 = new StringBuilder();
                    sb2.append("[tcp_control]guessTcpWillSucc(), fp failed within 30 mins, network not reconnected, prefer http: ");
                    sb2.append(abs2);
                    C0849fg.m916w(str3, sb2.toString());
                    return false;
                } else {
                    sb = new StringBuilder();
                    str = "[tcp_control]guessTcpWillSucc(), no fp fail record or network reconnected within 30 mins, prefer tcp: ";
                }
                sb.append(str);
                sb.append(abs2);
            }
            str2 = sb.toString();
        }
        C0849fg.m914i(str3, str2);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo9477e(C0738f fVar) {
        C0849fg.m914i("TmsTcpManager", "[tcp_control] sendCheckFirst()");
        if (!this.f871mt.mo9527m()) {
            C0849fg.m916w("TmsTcpManager", "[tcp_control] sendCheckFirst(), no connect");
            this.f860jp.mo9347b(true, -40220000, fVar);
            return;
        }
        C0800f fVar2 = new C0800f(32, null, fVar);
        byte b = this.f866mF;
        if (b == 1) {
            mo9479f(fVar);
        } else if (b == 2) {
            if (fVar.f641jF) {
                C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p][h_b]sendCheckFirst(),sending fp ignore heartbeat");
                return;
            }
            C0849fg.m914i("TmsTcpManager", "[tcp_control] sending fp, enqueue this task");
            m762i(fVar);
            synchronized (this.f865mE) {
                this.f864mD.add(fVar2);
            }
        } else if (b == 0) {
            if (fVar.f641jF) {
                C0849fg.m916w("TmsTcpManager", "[tcp_control][f_p][h_b]sendCheckFirst(),fp is not sent ignore heartbeat");
                return;
            }
            C0849fg.m914i("TmsTcpManager", "[tcp_control] fp is not sent, send fp & enqueue this task");
            m761h(fVar);
            synchronized (this.f865mE) {
                this.f864mD.add(fVar2);
            }
            m731a(11, "delay_send_for_others", 0, 0, true);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo9478f(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(str);
        m731a(11, sb.toString(), i, 0, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo9479f(C0738f fVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control] send(), isFP: ");
        sb.append(fVar.f642jG);
        sb.append(", isHB: ");
        sb.append(fVar.f641jF);
        C0849fg.m914i("TmsTcpManager", sb.toString());
        if (!this.f871mt.mo9527m()) {
            C0849fg.m916w("TmsTcpManager", "[tcp_control] send(), no connect");
            this.f860jp.mo9347b(true, -40220000, fVar);
            return;
        }
        m725G(4);
        m759g(fVar);
        if (!fVar.f641jF) {
            m758g(fVar.f648jM);
        }
        C0800f fVar2 = new C0800f(32, null, fVar);
        synchronized (this.f865mE) {
            this.f870mJ.add(fVar2);
        }
        m731a(0, null, 0, 0, true);
    }

    public void onClose() {
        m731a(4, null, 0, 0, true);
    }

    public void onConnected() {
        StringBuilder sb;
        this.f863mC = false;
        int ca = this.f875mx.mo9447ca();
        String str = "TmsTcpManager";
        if (ca <= 0) {
            sb = new StringBuilder();
            sb.append("[tcp_control]onConnected(), no tcp ref, ignore, refCount: ");
            sb.append(ca);
            C0849fg.m914i(str, sb.toString());
            return;
        }
        sb = new StringBuilder();
        sb.append("[tcp_control]onConnected(), with tcp ref, send MSG_ON_CHANGE_TO_CONNECTED, refCount: ");
        sb.append(ca);
        C0849fg.m914i(str, sb.toString());
        m731a(9, null, 0, 0, true);
    }

    public void onDisconnected() {
        int ca = this.f875mx.mo9447ca();
        StringBuilder sb = new StringBuilder();
        sb.append("[tcp_control]onDisconnected(), update: disconnected & fp not send, refCount: ");
        sb.append(ca);
        C0849fg.m914i("TmsTcpManager", sb.toString());
        this.f869mI = true;
        this.f866mF = 0;
        m725G(9);
    }
}
