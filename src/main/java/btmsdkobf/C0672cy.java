package btmsdkobf;

import android.content.Context;
import android.os.Build;
import btmsdkobf.C0689dg.C0690a;
import btmsdkobf.C0704ds.C0707b;
import btmsdkobf.C0872i.C0874a;
import com.tencent.p605ep.commonbase.utils.PhoneInfoUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Marker;

/* renamed from: btmsdkobf.cy */
public class C0672cy extends C0695dl {
    /* renamed from: gU */
    private static C0672cy f462gU;
    /* renamed from: gR */
    private boolean f463gR = true;
    /* renamed from: gS */
    private boolean f464gS = false;
    /* renamed from: gT */
    private boolean f465gT = false;

    private C0672cy() {
    }

    /* renamed from: aq */
    public static C0672cy m173aq() {
        if (f462gU == null) {
            synchronized (C0672cy.class) {
                if (f462gU == null) {
                    f462gU = new C0672cy();
                }
            }
        }
        return f462gU;
    }

    /* renamed from: a */
    public void mo9222a(int i, long j, int i2, int i3, long j2, int i4, byte[] bArr, int i5, long j3, long j4, long j5) {
    }

    /* renamed from: a */
    public void mo9223a(long j, int i, int i2) {
    }

    /* renamed from: a */
    public void mo9224a(HashMap<String, String> hashMap) {
    }

    /* renamed from: a */
    public void mo9225a(boolean z, boolean z2, boolean z3) {
        this.f463gR = z;
        this.f464gS = z2;
        this.f465gT = z3;
    }

    /* renamed from: aA */
    public String mo9226aA() {
        return C0669cw.m145ab().mo9203af();
    }

    /* renamed from: aB */
    public C0631bt mo9227aB() {
        C0848ff.m907i("SharkOutlet", "onGetInfoSavedOfGuid()");
        return C0669cw.m145ab().mo9205ah();
    }

    /* renamed from: aC */
    public long mo9228aC() {
        return -1;
    }

    /* renamed from: aD */
    public long mo9229aD() {
        long ag = C0669cw.m145ab().mo9204ag();
        StringBuilder sb = new StringBuilder();
        sb.append("onGetGuidUpdateCheckTimeMillis() tm: ");
        sb.append(ag);
        C0848ff.m907i("SharkOutlet", sb.toString());
        return ag;
    }

    /* renamed from: aE */
    public boolean mo9230aE() {
        return C0669cw.m145ab().mo9206ai();
    }

    /* renamed from: aF */
    public C0620bi mo9231aF() {
        return C0669cw.m145ab().mo9207ak();
    }

    /* renamed from: aG */
    public int mo9232aG() {
        return -1;
    }

    /* renamed from: aH */
    public void mo9233aH() {
    }

    /* renamed from: ar */
    public boolean mo9234ar() {
        return this.f463gR;
    }

    /* renamed from: as */
    public boolean mo9235as() {
        return this.f464gS;
    }

    /* renamed from: at */
    public boolean mo9236at() {
        return this.f465gT;
    }

    /* renamed from: au */
    public C0707b mo9237au() {
        return C0669cw.m145ab().mo9200ac();
    }

    /* renamed from: av */
    public String mo9238av() {
        String ad = C0669cw.m145ab().mo9201ad();
        StringBuilder sb = new StringBuilder();
        sb.append("onGetGuidFromPhone() guid: ");
        sb.append(ad);
        C0848ff.m907i("SharkOutlet", sb.toString());
        return ad;
    }

    /* renamed from: aw */
    public String mo9239aw() {
        return null;
    }

    /* renamed from: ax */
    public boolean mo9240ax() {
        return true;
    }

    /* renamed from: ay */
    public void mo9241ay() {
    }

    /* renamed from: az */
    public String mo9242az() {
        return C0669cw.m145ab().mo9202ae();
    }

    /* renamed from: b */
    public void mo9243b(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSaveGuidUpdateCheckTimeMillis() timeMillis: ");
        sb.append(j);
        C0848ff.m907i("SharkOutlet", sb.toString());
        C0669cw.m145ab().mo9195a(j);
    }

    /* renamed from: b */
    public void mo9244b(C0620bi biVar) {
        C0669cw.m145ab().mo9196a(biVar);
    }

    /* renamed from: b */
    public void mo9245b(C0631bt btVar) {
        C0848ff.m907i("SharkOutlet", "onSaveInfoOfGuid()");
        C0669cw.m145ab().mo9197a(btVar);
    }

    /* renamed from: b */
    public void mo9246b(C0707b bVar) {
        if (bVar != null) {
            C0669cw.m145ab().mo9198a(bVar);
        }
    }

    /* renamed from: b */
    public void mo9247b(String str, long j, List<String> list) {
        C0669cw.m145ab().mo9199a(str, j, list);
    }

    /* renamed from: b */
    public void mo9248b(String str, boolean z) {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSaveGuidToPhone() guid: ");
            sb.append(str);
            C0848ff.m907i("SharkOutlet", sb.toString());
            C0669cw.m145ab().mo9209g(str);
        }
    }

    /* renamed from: c */
    public void mo9249c(String str, boolean z) {
    }

    /* renamed from: d */
    public void mo9250d(String str, boolean z) {
        if (str != null) {
            C0669cw.m145ab().mo9210h(str);
        }
    }

    /* renamed from: e */
    public C0631bt mo9251e(boolean z) {
        Context D = C0652cl.m85D();
        C0631bt btVar = new C0631bt();
        btVar.f315eZ = C0652cl.m86E().getDeviceId1();
        btVar.f342fa = C0652cl.m86E().getDeviceId2();
        btVar.f343fb = C0652cl.m86E().getDeviceId3();
        btVar.f344fc = C0652cl.m86E().mo9082f();
        if (C0652cl.m86E().isAllowImei()) {
            btVar.f279at = C0872i.m975b(D);
            Map d = C0872i.m980d(D);
            btVar.f312eW = (String) d.get(PhoneInfoUtil.KEY_IMEI1);
            btVar.f313eX = (String) d.get(PhoneInfoUtil.KEY_IMEI2);
            btVar.f314eY = (String) d.get(PhoneInfoUtil.KEY_MEID);
        }
        String str = "";
        if (C0652cl.m86E().isAllowMac()) {
            String r = C0836ez.m880r(D);
            if (r == null) {
                r = str;
            }
            btVar.f284dU = r;
        }
        if (C0652cl.m86E().isAllowImsi()) {
            btVar.f283dT = C0872i.m978c(D);
            btVar.f290eA = str;
            btVar.f322eg = 1;
        }
        if (C0652cl.m86E().isAllowAndroidID()) {
            btVar.f320ee = C0872i.m981e(D);
        }
        if (C0652cl.m86E().isAllowOther()) {
            int f = C0872i.m983f(D);
            int g = C0872i.m984g(D);
            if (f >= g) {
                int i = f;
                f = g;
                g = i;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(g);
            sb.append(Marker.ANY_MARKER);
            sb.append(f);
            btVar.f326ek = sb.toString();
            btVar.f323eh = Build.CPU_ABI;
            btVar.f299eJ = Build.CPU_ABI2;
            btVar.f324ei = C0872i.m985p();
            btVar.f325ej = C0872i.m986q();
            btVar.f330eo = Build.BRAND;
            btVar.f300eK = Build.FINGERPRINT;
            btVar.f305eP = C0872i.m982e("ro.mediatek.platform");
            btVar.f337ev = C0872i.m982e("ro.sf.lcd_density");
            btVar.f333er = Build.PRODUCT;
            btVar.f306eQ = C0872i.m987r();
        }
        btVar.f327el = C0872i.m988s();
        btVar.f328em = C0872i.m989t();
        C0874a aVar = new C0874a();
        C0872i.m973a(aVar);
        btVar.f329en = aVar.f1038s;
        C0874a aVar2 = new C0874a();
        C0872i.m977b(aVar2);
        btVar.f304eO = aVar2.f1038s;
        btVar.f335et = Build.MANUFACTURER;
        try {
            btVar.f317eb = C0652cl.m85D().getPackageName();
        } catch (Throwable unused) {
        }
        btVar.f318ec = Build.MODEL;
        btVar.f319ed = C0875j.m991v();
        btVar.f321ef = 2052;
        btVar.version = C0652cl.m86E().getVersion();
        btVar.f294eE = 1;
        btVar.f301eL = C0872i.m982e("ro.product.locale.language");
        btVar.f302eM = C0872i.m982e("ro.product.locale.region");
        btVar.f334es = C0872i.m982e("ro.build.version.release");
        btVar.f340ey = false;
        btVar.f307eR = 0;
        btVar.f309eT = C0872i.m979c(true);
        btVar.f310eU = C0872i.m979c(false);
        String str2 = "0";
        btVar.f285dV = str2;
        btVar.f286dW = str2;
        btVar.f287dX = C0652cl.m86E().getProductId();
        btVar.f280cv = C0652cl.m86E().mo9077a();
        btVar.f281cw = C0652cl.m86E().mo9078b();
        btVar.f282cx = C0652cl.m90c();
        btVar.f288dY = 2;
        btVar.f289dZ = 201;
        btVar.f316ea = false;
        return btVar;
    }

    /* renamed from: e */
    public void mo9252e(String str, boolean z) {
        if (str != null) {
            C0669cw.m145ab().mo9211i(str);
        }
    }

    /* renamed from: f */
    public void mo9253f(int i, int i2) {
    }

    /* renamed from: f */
    public void mo9254f(boolean z) {
        C0669cw.m145ab().mo9208d(z);
    }

    /* renamed from: g */
    public void mo9255g(int i, int i2) {
    }

    /* renamed from: h */
    public void mo9256h(int i, int i2) {
    }

    /* renamed from: i */
    public void mo9257i(int i, int i2) {
    }

    /* renamed from: k */
    public C0690a mo9258k(String str) {
        return C0669cw.m145ab().mo9212j(str);
    }
}
