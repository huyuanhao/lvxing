package btmsdkobf;

import android.os.Process;
import com.p522qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;

/* renamed from: btmsdkobf.ed */
public class C0779ed implements C0778ec {
    /* renamed from: gP */
    private static boolean f813gP = false;
    /* renamed from: lA */
    protected long f814lA;
    /* renamed from: lQ */
    private C0759eb f815lQ;
    /* renamed from: lR */
    private C0749ea f816lR;

    public C0779ed(long j) {
        this.f814lA = j;
    }

    /* renamed from: bY */
    private C0749ea m665bY() {
        if (!C0716dx.m433bw() || C0716dx.f583iM) {
            synchronized (this) {
                if (this.f816lR == null) {
                    this.f816lR = C0749ea.m562bQ();
                }
            }
            return this.f816lR;
        }
        throw new RuntimeException("getSharkProcessProxy too early");
    }

    /* renamed from: bZ */
    private C0759eb m666bZ() {
        if (!C0716dx.m433bw() || C0716dx.f583iM) {
            synchronized (this) {
                if (this.f815lQ == null) {
                    this.f815lQ = C0759eb.m591bT();
                }
            }
            return this.f815lQ;
        }
        throw new RuntimeException("getSharkProtocolQueue too early");
    }

    /* renamed from: a */
    public WeakReference<C0715dw> mo9434a(int i, int i2, int i3, long j, long j2, int i4, JceStruct jceStruct, byte[] bArr, JceStruct jceStruct2, int i5, C0693dj djVar, C0694dk dkVar, long j3, long j4) {
        int i6 = i5;
        StringBuilder sb = new StringBuilder();
        sb.append(Process.myPid());
        sb.append(" sendShark() from pid: ");
        sb.append(i);
        sb.append(" ipcSeqNo: ");
        sb.append(i2);
        sb.append(" callerIdent: ");
        sb.append(j2);
        sb.append(" cmdId: ");
        sb.append(i4);
        sb.append(" flag: ");
        sb.append(i6);
        sb.append(" callBackTimeout: ");
        sb.append(j3);
        C0849fg.m911d("SharkProcessProxy", sb.toString());
        if (C0716dx.m428ar()) {
            return m666bZ().mo9391a(i, i2, i3, j, j2, i4, jceStruct, bArr, jceStruct2, i5, djVar, dkVar, j3, j4);
        }
        if (!C0716dx.m429as() || (C0716dx.m430at() && (i6 & 4096) == 0)) {
            m665bY().mo9376a(i, this.f814lA, i3, j, i4, jceStruct, jceStruct2, i5, djVar, j3, j4);
            return null;
        } else if ((i6 & 2048) != 0 || (i6 & 512) != 0) {
            return m666bZ().mo9391a(i, i2, i3, j, j2, i4, jceStruct, bArr, jceStruct2, i5, djVar, dkVar, j3, j4);
        } else {
            throw new IllegalArgumentException("semi-send process can only use http channel!");
        }
    }

    /* renamed from: a */
    public WeakReference<C0715dw> mo9429a(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, C0693dj djVar) {
        return mo9430b(i, jceStruct, jceStruct2, i2, djVar, 0);
    }

    /* renamed from: a */
    public WeakReference<C0715dw> mo9435a(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, C0693dj djVar, long j, long j2) {
        return mo9434a(Process.myPid(), 0, 0, 0, this.f814lA, i, jceStruct, null, jceStruct2, i2, djVar, null, j, j2);
    }

    /* renamed from: a */
    public void mo9436a(int i, long j, int i2, JceStruct jceStruct, int i3) {
        mo9434a(Process.myPid(), 0, i, j, this.f814lA, i2, jceStruct, null, null, i3 | 1073741824, null, null, 0, 0);
    }

    /* renamed from: a */
    public void mo9437a(int i, JceStruct jceStruct, int i2, C0696dm dmVar) {
        mo9438a(0, i, jceStruct, i2, dmVar, false);
    }

    /* renamed from: a */
    public void mo9438a(long j, int i, JceStruct jceStruct, int i2, C0696dm dmVar, boolean z) {
        int i3 = i;
        int i4 = i2;
        String str = " flag: ";
        String str2 = "SharkProcessProxy";
        if (C0716dx.m428ar()) {
            StringBuilder sb = new StringBuilder();
            sb.append("sending process registerSharkPush() from cmdId: ");
            sb.append(i);
            sb.append(str);
            sb.append(i2);
            C0849fg.m911d(str2, sb.toString());
            m666bZ().mo9359a(z ? j : this.f814lA, i, jceStruct, i2, dmVar, z);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("other process registerSharkPush() from cmdId: ");
        sb2.append(i);
        sb2.append(str);
        sb2.append(i2);
        C0849fg.m911d(str2, sb2.toString());
        m665bY().mo9377a(this.f814lA, i, jceStruct, i2, dmVar);
    }

    /* renamed from: a */
    public void mo9439a(C0691dh dhVar, boolean z) {
        m666bZ().mo9396a(dhVar, z);
    }

    /* renamed from: ap */
    public void mo9440ap() {
        if (C0716dx.m428ar()) {
            m666bZ().mo9399ap();
        }
    }

    /* renamed from: b */
    public WeakReference<C0715dw> mo9430b(int i, JceStruct jceStruct, JceStruct jceStruct2, int i2, C0693dj djVar, long j) {
        return mo9435a(i, jceStruct, jceStruct2, i2, djVar, j, 0);
    }

    /* renamed from: bG */
    public void mo9441bG() {
        if (C0716dx.m428ar()) {
            m666bZ().mo9402bG();
        }
    }

    /* renamed from: c */
    public void mo9431c(C0691dh dhVar) {
        mo9439a(dhVar, true);
    }

    /* renamed from: e */
    public C0696dm mo9442e(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(Process.myPid());
        sb.append(" unregisterSharkPush() from cmdId: ");
        sb.append(i);
        sb.append(" flag: ");
        sb.append(i2);
        C0849fg.m911d("SharkProcessProxy", sb.toString());
        return C0716dx.m428ar() ? m666bZ().mo9411e(i, i2) : m665bY().mo9379e(i, i2);
    }

    public String getGuid() {
        return m666bZ().getGuid();
    }

    public void sendSharkPushResult(int i, long j, int i2, JceStruct jceStruct) {
        mo9436a(i, j, i2, jceStruct, 0);
    }
}
