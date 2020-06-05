package btmsdkobf;

import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.cx */
public class C0670cx {
    public static String TAG = "SharkNetServiceProxy";
    /* renamed from: gO */
    private static volatile C0670cx f458gO;
    /* renamed from: gN */
    private C0779ed f459gN = null;
    /* renamed from: gP */
    private boolean f460gP = false;

    private C0670cx() {
    }

    /* renamed from: al */
    public static C0670cx m165al() {
        if (f458gO == null) {
            synchronized (C0670cx.class) {
                if (f458gO == null) {
                    f458gO = new C0670cx();
                }
            }
        }
        return f458gO;
    }

    /* renamed from: a */
    public void mo9213a(int i, JceStruct jceStruct, int i2, C0696dm dmVar) {
        C0779ed edVar = this.f459gN;
        if (edVar != null) {
            edVar.mo9437a(i, jceStruct, i2, dmVar);
        }
    }

    /* renamed from: a */
    public void mo9214a(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, C0693dj djVar, long j) {
        C0779ed edVar = this.f459gN;
        if (edVar != null) {
            edVar.mo9430b(i, jceStruct, jceStruct2, i2, djVar, j);
        }
    }

    /* renamed from: am */
    public void mo9215am() {
        C0849fg.m914i(TAG, "[shark_init]initSharkSync()");
        boolean F = C0652cl.m87F();
        String d = C0652cl.m86E().mo9080d();
        C0672cy aq = C0672cy.m173aq();
        aq.mo9225a(true, false, false);
        if (!C0716dx.f583iM) {
            C0716dx.m439s(F);
            C0716dx.m441t(d);
            C0716dx.m447w(false);
            C0716dx.m442t(aq.mo9234ar());
            C0716dx.m443u(aq.mo9235as());
            C0716dx.m445v(aq.mo9236at());
            C0759eb.m591bT().mo9410c((C0695dl) aq);
            C0716dx.f583iM = true;
        }
        this.f459gN = new C0779ed(4294967296L);
        C0716dx.m427a(this.f459gN);
        C0849fg.m914i(TAG, "[shark_init]initSharkSync() end");
    }

    /* renamed from: an */
    public synchronized void mo9216an() {
        if (C0716dx.m433bw()) {
            if (!C0716dx.f583iM) {
                throw new RuntimeException("must call initSync() before initAsync()!");
            }
        }
        if (!this.f460gP) {
            this.f460gP = true;
            C0845fd.m898cN().addUrgentTask(new Runnable() {
                public void run() {
                    C0759eb.m591bT().mo9398an();
                }
            }, "init SharkProtocolQueue async");
        }
    }

    /* renamed from: ao */
    public void mo9217ao() {
        this.f459gN.mo9441bG();
    }

    /* renamed from: ap */
    public void mo9218ap() {
        this.f459gN.mo9440ap();
    }

    /* renamed from: e */
    public C0696dm mo9219e(int i, int i2) {
        return this.f459gN.mo9442e(i, i2);
    }

    public String getGuid() {
        return this.f459gN.getGuid();
    }
}
