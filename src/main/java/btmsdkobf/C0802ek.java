package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import btmsdkobf.C0718dy.C0736d;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.ek */
public class C0802ek {
    /* access modifiers changed from: private */
    /* renamed from: hA */
    public C0718dy f896hA;
    /* access modifiers changed from: private */
    /* renamed from: mR */
    public String f897mR = "";
    /* access modifiers changed from: private */
    /* renamed from: mS */
    public boolean f898mS = false;

    public C0802ek(Context context, C0718dy dyVar, boolean z) {
        this.f896hA = dyVar;
        this.f897mR = this.f896hA.mo9338bF().mo9242az();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0801ej<Long, Integer, JceStruct> m795a(long j, int i, C0642cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        if (cbVar.f376fB == 0) {
            mo9486b(1, true);
        } else if (cbVar.f376fB == 1) {
            mo9486b(1, false);
        }
        return null;
    }

    /* renamed from: aR */
    private boolean m799aR() {
        if (!C0716dx.m428ar()) {
            return false;
        }
        return TextUtils.isEmpty(this.f897mR);
    }

    /* renamed from: c */
    private C0634bw m800c(int i, boolean z) {
        String az = this.f896hA.mo9338bF().mo9242az();
        String aA = this.f896hA.mo9338bF().mo9226aA();
        String str = "";
        if (az == null) {
            az = str;
        }
        if (aA == null) {
            aA = str;
        }
        C0634bw bwVar = null;
        if (z) {
            bwVar = new C0634bw();
        } else if (m799aR()) {
            return null;
        } else {
            if (!TextUtils.isEmpty(az) && !TextUtils.isEmpty(aA) && !az.equals(aA)) {
                bwVar = new C0634bw();
            }
            return bwVar;
        }
        bwVar.f352fj = i;
        bwVar.f353fk = az;
        bwVar.f351fd = aA;
        return bwVar;
    }

    /* renamed from: ct */
    private C0632bu m801ct() {
        C0632bu buVar = new C0632bu();
        String aA = this.f896hA.mo9338bF().mo9226aA();
        if (aA == null) {
            aA = "";
        }
        buVar.f345fd = aA;
        return buVar;
    }

    /* renamed from: ap */
    public void mo9485ap() {
        String str = "VidCertifier";
        C0849fg.m914i(str, "[cu_vid]registerVidIfNeed()");
        if (!this.f896hA.mo9338bF().mo9240ax()) {
            C0849fg.m916w(str, "[cu_vid]registerVidIfNeed(), not support vid, do nothing");
        } else if (this.f898mS) {
            C0849fg.m914i(str, "[cu_vid]registerVidIfNeed(), registering, ignore");
        } else if (!m799aR()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[cu_vid]registerVidIfNeed(), not necessary, mVidFromPhone: ");
            sb.append(this.f897mR);
            C0849fg.m914i(str, sb.toString());
        } else {
            this.f896hA.mo9338bF().mo9241ay();
            this.f898mS = true;
            C0716dx.m434bx().mo9430b(5006, m801ct(), new C0644cd(), 0, new C0693dj() {
                /* renamed from: a */
                public void mo9159a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                    String str;
                    String str2 = "[cu_vid]registerVidIfNeed()-onFinish(), seqNo: ";
                    String str3 = "VidCertifier";
                    if (i3 == 0 && i4 == 0 && jceStruct != null) {
                        String str4 = ((C0644cd) jceStruct).f378fC;
                        if (!TextUtils.isEmpty(str4)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("[cu_vid]registerVidIfNeed()-onFinish(), succ, vid: ");
                            sb.append(str4);
                            C0849fg.m914i(str3, sb.toString());
                            C0802ek.this.f897mR = str4;
                            C0802ek.this.f896hA.mo9338bF().mo9250d(str4, true);
                            C0802ek.this.f896hA.mo9338bF().mo9252e(str4, true);
                            C0802ek.this.f898mS = false;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(i);
                        sb2.append(", vid is empty: ");
                        sb2.append(str4);
                        str = sb2.toString();
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append(i);
                        sb3.append(" retCode: ");
                        sb3.append(i3);
                        sb3.append(" dataRetCode: ");
                        sb3.append(i4);
                        sb3.append(" resp: ");
                        sb3.append(jceStruct);
                        str = sb3.toString();
                    }
                    C0849fg.m916w(str3, str);
                    C0802ek.this.f898mS = false;
                }
            }, 30000);
        }
    }

    /* renamed from: b */
    public void mo9486b(int i, boolean z) {
        if (this.f896hA.mo9338bF().mo9240ax()) {
            C0634bw c = m800c(i, z);
            if (c != null) {
                C0716dx.m434bx().mo9430b(5007, c, new C0645ce(), 0, new C0693dj() {
                    /* renamed from: a */
                    public void mo9159a(int i, int i2, int i3, int i4, JceStruct jceStruct) {
                        if (i3 == 0 && i4 == 0 && jceStruct != null) {
                            String str = ((C0645ce) jceStruct).f379fC;
                            if (!TextUtils.isEmpty(str)) {
                                C0802ek.this.f897mR = str;
                                C0802ek.this.f896hA.mo9338bF().mo9250d(str, false);
                                C0802ek.this.f896hA.mo9338bF().mo9252e(str, false);
                            }
                        }
                    }
                }, 30000);
            }
        }
    }

    /* renamed from: c */
    public void mo9487c(C0736d dVar) {
        C0736d dVar2 = dVar;
        dVar2.mo9359a(0, 15020, new C0642cb(), 0, new C0696dm() {
            /* renamed from: a */
            public C0801ej<Long, Integer, JceStruct> mo9297a(int i, long j, int i2, JceStruct jceStruct) {
                if (jceStruct == null) {
                    C0849fg.m912e("VidCertifier", "onRecvPush() null == push");
                    return null;
                } else if (i2 != 15020) {
                    return null;
                } else {
                    return C0802ek.this.m795a(j, i, (C0642cb) jceStruct);
                }
            }
        }, false);
    }
}
