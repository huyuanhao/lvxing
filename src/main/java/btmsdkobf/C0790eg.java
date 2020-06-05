package btmsdkobf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: btmsdkobf.eg */
public class C0790eg {
    /* renamed from: ms */
    private static C0682dc<Integer, C0790eg> f841ms = new C0682dc<>(50);
    public int errorCode;
    /* renamed from: me */
    public String f842me;
    /* renamed from: mf */
    public String f843mf;
    /* renamed from: mg */
    public int f844mg = 0;
    /* renamed from: mh */
    public String f845mh;
    /* renamed from: mi */
    private String f846mi;
    /* renamed from: mj */
    public long f847mj;
    /* renamed from: mk */
    public String f848mk;
    /* renamed from: ml */
    public String f849ml;
    /* renamed from: mm */
    public String f850mm;
    /* renamed from: mn */
    public String f851mn;
    /* renamed from: mo */
    public boolean f852mo;
    /* renamed from: mp */
    public boolean f853mp;
    /* renamed from: mq */
    private long f854mq;
    /* renamed from: mr */
    private long f855mr;

    public C0790eg() {
        String str = "";
        this.f842me = str;
        this.f843mf = str;
        this.f845mh = str;
        this.f846mi = str;
        this.f847mj = -1;
        this.errorCode = 0;
        this.f848mk = str;
        this.f849ml = str;
        this.f850mm = str;
        this.f851mn = str;
        this.f852mo = false;
        this.f853mp = false;
        this.f854mq = 0;
        this.f855mr = 0;
    }

    /* renamed from: F */
    public static synchronized C0790eg m716F(int i) {
        C0790eg egVar;
        synchronized (C0790eg.class) {
            egVar = (C0790eg) f841ms.get(Integer.valueOf(i));
            if (egVar != null) {
                egVar.f855mr = System.currentTimeMillis();
            }
            f841ms.mo9265a(Integer.valueOf(i));
        }
        return egVar;
    }

    /* renamed from: a */
    public static synchronized void m717a(C0790eg egVar, int i) {
        synchronized (C0790eg.class) {
            if (egVar != null) {
                egVar.f854mq = System.currentTimeMillis();
                f841ms.put(Integer.valueOf(i), egVar);
            }
        }
    }

    /* renamed from: cl */
    private HashMap<String, String> m718cl() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("B4", this.f845mh);
        hashMap.put("B20", this.f851mn);
        hashMap.put("B7", String.valueOf(this.errorCode));
        hashMap.put("B8", this.f848mk);
        hashMap.put("B10", this.f850mm);
        hashMap.put("B9", this.f849ml);
        hashMap.put("B6", String.valueOf(this.f847mj));
        hashMap.put("B5", this.f846mi);
        hashMap.put("B3", this.f842me);
        hashMap.put("B11", this.f843mf);
        hashMap.put("B12", String.valueOf(this.f844mg));
        hashMap.put("B21", String.valueOf(this.f852mo));
        hashMap.put("B22", String.valueOf(this.f853mp));
        return hashMap;
    }

    /* renamed from: E */
    public void mo9462E(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f851mn);
        sb.append(String.valueOf(i));
        sb.append(";");
        this.f851mn = sb.toString();
    }

    /* renamed from: d */
    public void mo9463d(C0695dl dlVar) {
        if (dlVar != null) {
            this.f846mi = "1";
            C0849fg.m914i("TcpInfoUpload", toString());
            dlVar.mo9224a(m718cl());
        }
    }

    /* renamed from: e */
    public void mo9464e(C0695dl dlVar) {
    }

    /* renamed from: f */
    public void mo9465f(C0695dl dlVar) {
    }

    /* renamed from: f */
    public void mo9466f(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str != null) {
                    sb.append(str);
                    sb.append(";");
                }
            }
        }
    }

    /* renamed from: g */
    public void mo9467g(C0695dl dlVar) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("|ip|");
        sb2.append(this.f842me);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("|port|");
        sb3.append(this.f843mf);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("|tryTimes|");
        sb4.append(this.f844mg);
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("|apn|");
        sb5.append(this.f845mh);
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("|requestType|");
        sb6.append(this.f846mi);
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("|requestTime|");
        sb7.append(this.f847mj);
        sb.append(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("|errorCode|");
        sb8.append(this.errorCode);
        sb.append(sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("|cmdids|");
        sb9.append(this.f851mn);
        sb.append(sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append("|iplist|");
        sb10.append(this.f850mm);
        sb.append(sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append("|lastRequest|");
        sb11.append(this.f849ml);
        sb.append(sb11.toString());
        StringBuilder sb12 = new StringBuilder();
        sb12.append("|errorDetail|");
        sb12.append(this.f848mk);
        sb.append(sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append("|isDetect|");
        sb13.append(this.f852mo);
        sb.append(sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append("|isConnect|");
        sb14.append(this.f853mp);
        sb.append(sb14.toString());
        return sb.toString();
    }
}
