package btmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import btmsdkobf.C0718dy.C0734b;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;

/* renamed from: btmsdkobf.ds */
public class C0704ds {
    /* renamed from: R */
    private Object f543R = new Object();
    /* renamed from: hA */
    private C0718dy f544hA;
    /* renamed from: ih */
    private C0707b f545ih;

    /* renamed from: btmsdkobf.ds$a */
    public interface C0706a {
        /* renamed from: b */
        void mo9310b(int i, int i2, int i3);
    }

    /* renamed from: btmsdkobf.ds$b */
    public static class C0707b {
        /* renamed from: il */
        public volatile String f550il;
        /* renamed from: im */
        public volatile String f551im;

        public C0707b() {
            String str = "";
            this.f550il = str;
            this.f551im = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("mSessionId: ");
            sb.append(this.f550il);
            sb.append(" mEncodeKey: ");
            sb.append(this.f551im);
            return sb.toString();
        }
    }

    public C0704ds(Context context, C0718dy dyVar) {
        this.f544hA = dyVar;
        this.f545ih = new C0707b();
        m395R();
    }

    /* renamed from: R */
    private void m395R() {
        C0707b au = this.f544hA.mo9338bF().mo9237au();
        if (au != null) {
            synchronized (this.f543R) {
                this.f545ih.f551im = au.f551im;
                this.f545ih.f550il = au.f550il;
                StringBuilder sb = new StringBuilder();
                sb.append("[rsa_key]load(), mEncodeKey: ");
                sb.append(this.f545ih.f551im);
                sb.append(" mSessionId: ");
                sb.append(this.f545ih.f550il);
                C0849fg.m914i("RsaKeyCertifier", sb.toString());
            }
            return;
        }
        C0849fg.m916w("RsaKeyCertifier", "[rsa_key]load(), no record!");
    }

    /* renamed from: a */
    static void m396a(Context context, int i, C0707b bVar) {
        try {
            Intent intent = new Intent(String.format("action.rsa.got:%s", new Object[]{context.getPackageName()}));
            intent.setPackage(context.getPackageName());
            intent.putExtra("k.rc", i);
            if (i == 0 && bVar != null) {
                intent.putExtra("k.r.k", bVar.f551im);
                intent.putExtra("k.r.s", bVar.f550il);
            }
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("[rsa_key]sendBroadcast(): ");
            sb.append(th);
            C0849fg.m910a("RsaKeyCertifier", sb.toString(), th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m398h(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[rsa_key] saveRsaKey(), argument is null! encodeKey: ");
            sb.append(str);
            sb.append(" sessionId: ");
            sb.append(str2);
            C0849fg.m912e("RsaKeyCertifier", sb.toString());
            return;
        }
        synchronized (this.f543R) {
            this.f545ih.f551im = str;
            this.f545ih.f550il = str2;
            this.f544hA.mo9338bF().mo9246b(this.f545ih);
        }
    }

    /* renamed from: o */
    static void m399o(Context context) {
        String str = "RsaKeyCertifier";
        try {
            C0849fg.m914i(str, "[rsa_key]requestSendProcessUpdateRsaKey()");
            Intent intent = new Intent(String.format("action.up.rsa:%s", new Object[]{context.getPackageName()}));
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("[rsa_key]requestSendProcessUpdateRsaKey(): ");
            sb.append(th);
            C0849fg.m910a(str, sb.toString(), th);
        }
    }

    /* renamed from: q */
    private byte[] m400q(String str) {
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C0828ev.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb49jFnNqMDLdl87UtY5jOMqqdMuvQg65Zuva3Qm1tORQGBuM04u7fqygA64XbOx9e/KPNkDNDmqS8SlsAPL1fV2lqM/phgV0NY62TJqSR+PLngwJd2rhYR8wQ1N0JE+R59a5c08EGsd6axStjHsVu2+evCf/SWU9Y/oQpEtOjGwIDAQAB", 0)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            bArr = instance.doFinal(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArr;
    }

    /* renamed from: r */
    private String m401r(int i) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(secureRandom.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void mo9307a(C0706a aVar) {
        String str = "RsaKeyCertifier";
        C0849fg.m911d(str, "[rsa_key]updateRsaKey()");
        final int bf = C0709du.m406bn().mo9293bf();
        String r = m401r(16);
        byte[] q = m400q(r);
        if (q == null) {
            C0849fg.m912e(str, "[rsa_key]updateRsaKey(), gen dynamic key failed");
            aVar.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -20001000);
            return;
        }
        C0629br brVar = new C0629br();
        brVar.f277dR = q;
        StringBuilder sb = new StringBuilder();
        sb.append("[rsa_key]updateRsaKey() reqRSA.enc: ");
        sb.append(C0674d.m218a(brVar.f277dR));
        C0849fg.m914i(str, sb.toString());
        ArrayList arrayList = new ArrayList();
        final C0636by byVar = new C0636by();
        byVar.f358fm = bf;
        byVar.f357dO = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META;
        byVar.f365ft |= 2;
        byVar.f360fo = C0683dd.m252a((Context) null, (JceStruct) brVar, byVar.f357dO, byVar);
        arrayList.add(byVar);
        C0712dv.m412br().mo9315a(byVar.f358fm, -1, null);
        C0718dy dyVar = this.f544hA;
        final C0706a aVar2 = aVar;
        C07051 r2 = new C0708dt(r) {
            /* renamed from: a */
            public void mo9278a(boolean z, int i, int i2, ArrayList<C0647cg> arrayList) {
                StringBuilder sb = new StringBuilder();
                sb.append("[rsa_key]updateRsaKey(), isTcpChannel: ");
                sb.append(z);
                sb.append(", seqNo ");
                sb.append(byVar.f358fm);
                sb.append(", retCode: ");
                sb.append(i);
                String sb2 = sb.toString();
                String str = "RsaKeyCertifier";
                C0849fg.m914i(str, sb2);
                if (i != 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("[rsa_key]updateRsaKey(), retCode: ");
                    sb3.append(i);
                    C0849fg.m912e(str, sb3.toString());
                    aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, i);
                } else if (arrayList == null) {
                    C0849fg.m912e(str, "[rsa_key]updateRsaKey(), null == serverSashimis");
                    aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -21250000);
                } else if (arrayList.size() <= 0) {
                    C0849fg.m912e(str, "[rsa_key]updateRsaKey(), serverSashimis.size() <= 0");
                    aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -21250000);
                } else {
                    C0647cg cgVar = (C0647cg) arrayList.get(0);
                    if (cgVar == null) {
                        C0849fg.m912e(str, "[rsa_key]updateRsaKey(), serverSashimi is null");
                        aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -21250000);
                    } else if (cgVar.f388fq != 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("[rsa_key]updateRsaKey(), mazu error: ");
                        sb4.append(cgVar.f388fq);
                        C0849fg.m912e(str, sb4.toString());
                        aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, cgVar.f388fq);
                    } else if (cgVar.f389fr != 0) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[rsa_key]updateRsaKey(), rs.dataRetCode: ");
                        sb5.append(cgVar.f389fr);
                        C0849fg.m912e(str, sb5.toString());
                        aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -21300000);
                    } else if (cgVar.f387fo == null) {
                        C0849fg.m912e(str, "[rsa_key]updateRsaKey(), null == rs.data");
                        aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -21000005);
                    } else {
                        try {
                            JceStruct a = C0683dd.m248a(null, this.f552in.getBytes(), cgVar.f387fo, new C0630bs(), false, cgVar.f390ft);
                            if (a == null) {
                                C0849fg.m912e(str, "[rsa_key]updateRsaKey(), decode jce failed: null == js");
                                aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -21000400);
                                return;
                            }
                            C0630bs bsVar = (C0630bs) a;
                            if (TextUtils.isEmpty(bsVar.f278cZ)) {
                                C0849fg.m912e(str, "[rsa_key]updateRsaKey(), ret.sessionId is null");
                                aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -21280000);
                                return;
                            }
                            C0704ds.this.m398h(this.f552in, bsVar.f278cZ);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("[rsa_key]updateRsaKey(), encodeKey: ");
                            sb6.append(this.f552in);
                            sb6.append(" sessionId: ");
                            sb6.append(bsVar.f278cZ);
                            C0849fg.m914i(str, sb6.toString());
                            aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, 0);
                        } catch (Exception e) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("[rsa_key]updateRsaKey(), decode jce exception: ");
                            sb7.append(e);
                            C0849fg.m912e(str, sb7.toString());
                            aVar2.mo9310b(bf, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_LIB_META, -21000400);
                        }
                    }
                }
            }
        };
        dyVar.mo9331a(arrayList, (C0734b) r2);
    }

    /* renamed from: ac */
    public C0707b mo9308ac() {
        C0707b bVar = new C0707b();
        synchronized (this.f543R) {
            bVar.f550il = this.f545ih.f550il;
            bVar.f551im = this.f545ih.f551im;
        }
        return bVar;
    }

    public void refresh() {
        C0849fg.m914i("RsaKeyCertifier", "refresh()");
        m395R();
    }
}
