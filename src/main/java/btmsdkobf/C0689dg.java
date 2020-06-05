package btmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import btmsdkobf.C0815eq.C0817b;
import com.p522qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: btmsdkobf.dg */
public class C0689dg implements C0814ep {
    /* renamed from: hK */
    public static final boolean f516hK = C0652cl.m86E().isUseIPList();
    /* renamed from: hL */
    private static String f517hL = "mazu.3g.qq.com";
    /* renamed from: hM */
    private static C0689dg f518hM = null;
    /* renamed from: hS */
    private static C0690a f519hS = null;
    /* renamed from: hT */
    private static C0690a f520hT = null;
    /* renamed from: hN */
    private C0695dl f521hN;
    /* renamed from: hO */
    private final Object f522hO = new Object();
    /* renamed from: hP */
    private String f523hP = "key_notset";
    /* renamed from: hQ */
    private C0690a f524hQ;
    /* renamed from: hR */
    private C0690a f525hR;
    /* renamed from: hd */
    private boolean f526hd = false;
    private Context mContext;

    /* renamed from: btmsdkobf.dg$a */
    public static class C0690a {
        /* renamed from: hU */
        public long f527hU;
        /* renamed from: hV */
        public List<String> f528hV = new ArrayList();
        /* renamed from: hW */
        public boolean f529hW = false;
        /* renamed from: hX */
        private int f530hX = 0;

        public C0690a(long j, List<String> list, boolean z) {
            this.f527hU = j;
            if (list != null) {
                this.f528hV.addAll(list);
            }
            this.f529hW = z;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m326a(List<String> list) {
            int size = this.f528hV.size();
            if (size >= 2) {
                this.f528hV.addAll(size - 1, C0689dg.m296a(list, true));
            } else {
                this.f528hV.addAll(C0689dg.m296a(list, true));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: bb */
        public C0690a m328bb() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String p : this.f528hV) {
                String p2 = m334p(p);
                if (p2 != null) {
                    linkedHashSet.add(p2);
                }
            }
            return new C0690a(this.f527hU, new ArrayList(linkedHashSet), this.f529hW);
        }

        /* access modifiers changed from: private */
        /* renamed from: bc */
        public C0817b m329bc() {
            if (this.f530hX >= this.f528hV.size()) {
                this.f530hX = 0;
            }
            return C0689dg.m310m((String) this.f528hV.get(this.f530hX));
        }

        /* access modifiers changed from: private */
        /* renamed from: bd */
        public void m330bd() {
            this.f530hX++;
            if (this.f530hX >= this.f528hV.size()) {
                this.f530hX = 0;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: be */
        public void m331be() {
            this.f530hX = 0;
        }

        /* renamed from: p */
        private static String m334p(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf(":");
            String str3 = ":80";
            if (lastIndexOf >= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, lastIndexOf));
                sb.append(str3);
                str2 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str3);
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("conv2HttpIPPort(): invalid ipPort(missing port): ");
                sb4.append(str);
                C0849fg.m912e("HIPList", sb4.toString());
                str2 = sb3;
            }
            String str4 = "http://";
            if (str2.length() < 7 || !str2.substring(0, 7).equalsIgnoreCase(str4)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str4);
                sb5.append(str2);
                str2 = sb5.toString();
            }
            return str2;
        }

        public boolean isValid() {
            return (this.f529hW || System.currentTimeMillis() <= this.f527hU) && this.f528hV.size() > 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("|mValidTimeMills=");
            sb.append(this.f527hU);
            sb.append("|mIsDefault=");
            sb.append(this.f529hW);
            sb.append("|mIPPortList=");
            sb.append(this.f528hV);
            return sb.toString();
        }
    }

    public C0689dg(Context context, boolean z, C0695dl dlVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ip_list]HIPList() isTest: ");
        sb.append(z);
        String str2 = "HIPList";
        C0849fg.m911d(str2, sb.toString());
        this.mContext = context;
        this.f526hd = z;
        this.f521hN = dlVar;
        if (!TextUtils.isEmpty(str)) {
            f517hL = str;
        } else {
            String str3 = this.f526hd ? "mazutest.3g.qq.com" : this.f521hN.mo9296bh() == 1 ? "mazu-hk.3g.qq.com" : "mazu.3g.qq.com";
            f517hL = str3;
        }
        if (f516hK) {
            m300aW();
        } else {
            C0849fg.m916w(str2, "[ip_list]HIPList(), not enable, use default");
            m301aX();
        }
        m297a(this);
    }

    /* renamed from: a */
    public static String m295a(C0695dl dlVar) {
        return dlVar.mo9296bh() == 1 ? "mazuburst-hk.3g.qq.com" : "mazuburst.3g.qq.com";
    }

    /* renamed from: a */
    public static List<String> m296a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (String str : list) {
                if (m305g(str, z)) {
                    arrayList.add(str);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[ip_list]drop invalid ipport: ");
                    sb.append(str);
                    C0849fg.m912e("HIPList", sb.toString());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m297a(C0689dg dgVar) {
        f518hM = dgVar;
    }

    /* renamed from: a */
    private void m298a(String str, C0690a aVar, boolean z) {
        if (str == null || aVar == null || !aVar.isValid()) {
            C0849fg.m912e("HIPList", "[ip_list]setWorkingHIPList(), bad arg or invalid, ignore");
            return;
        }
        C0690a aVar2 = new C0690a(aVar.f527hU, aVar.f528hV, aVar.f529hW);
        if (z) {
            aVar2.m326a(m307j(true));
            StringBuilder sb = new StringBuilder();
            sb.append("[ip_list]setWorkingHIPList for ");
            sb.append(this.f526hd ? " [test server]" : " [release server]");
            sb.append(": ");
            sb.append(aVar2.f528hV);
            C0849fg.m914i("HIPList", sb.toString());
        }
        synchronized (this.f522hO) {
            this.f524hQ = aVar2;
            this.f525hR = this.f524hQ.m328bb();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[ip_list]setWorkingHIPList(), key changed: ");
            sb2.append(this.f523hP);
            sb2.append(" -> ");
            sb2.append(str);
            C0849fg.m914i("HIPList", sb2.toString());
            this.f523hP = str;
        }
    }

    /* renamed from: aU */
    public static C0689dg m299aU() {
        return f518hM;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
            r2 = m304f(r0, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
            if (r2 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
            if (r2.isValid() == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
            m298a(r0, r2, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
            m301aX();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
            return;
     */
    /* renamed from: aW */
    private void m300aW() {
        /*
        r5 = this;
        java.lang.String r0 = r5.m302aY()
        java.lang.Object r1 = r5.f522hO
        monitor-enter(r1)
        java.lang.String r2 = r5.f523hP     // Catch:{ all -> 0x004d }
        if (r2 == 0) goto L_0x0037
        java.lang.String r2 = r5.f523hP     // Catch:{ all -> 0x004d }
        boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x004d }
        if (r2 == 0) goto L_0x0037
        btmsdkobf.dg$a r2 = r5.f524hQ     // Catch:{ all -> 0x004d }
        if (r2 == 0) goto L_0x0037
        btmsdkobf.dg$a r2 = r5.f524hQ     // Catch:{ all -> 0x004d }
        boolean r2 = r2.isValid()     // Catch:{ all -> 0x004d }
        if (r2 == 0) goto L_0x0037
        java.lang.String r2 = "HIPList"
        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
        r3.<init>()     // Catch:{ all -> 0x004d }
        java.lang.String r4 = "[ip_list]refreshWorkingIPList(), not necessary, key unchanged: "
        r3.append(r4)     // Catch:{ all -> 0x004d }
        r3.append(r0)     // Catch:{ all -> 0x004d }
        java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x004d }
        btmsdkobf.C0849fg.m914i(r2, r0)     // Catch:{ all -> 0x004d }
        monitor-exit(r1)     // Catch:{ all -> 0x004d }
        return
    L_0x0037:
        monitor-exit(r1)     // Catch:{ all -> 0x004d }
        r1 = 1
        btmsdkobf.dg$a r2 = r5.m304f(r0, r1)
        if (r2 == 0) goto L_0x0049
        boolean r3 = r2.isValid()
        if (r3 == 0) goto L_0x0049
        r5.m298a(r0, r2, r1)
        goto L_0x004c
    L_0x0049:
        r5.m301aX()
    L_0x004c:
        return
    L_0x004d:
        r0 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x004d }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0689dg.m300aW():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
            m298a("key_default", m306i(true), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
            return;
     */
    /* renamed from: aX */
    private void m301aX() {
        /*
        r3 = this;
        java.lang.String r0 = "HIPList"
        java.lang.String r1 = "[ip_list]reset2Default()"
        btmsdkobf.C0849fg.m911d(r0, r1)
        java.lang.Object r0 = r3.f522hO
        monitor-enter(r0)
        java.lang.String r1 = r3.f523hP     // Catch:{ all -> 0x003a }
        if (r1 == 0) goto L_0x002d
        java.lang.String r1 = r3.f523hP     // Catch:{ all -> 0x003a }
        java.lang.String r2 = "key_default"
        boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x003a }
        if (r1 == 0) goto L_0x002d
        btmsdkobf.dg$a r1 = r3.f524hQ     // Catch:{ all -> 0x003a }
        if (r1 == 0) goto L_0x002d
        btmsdkobf.dg$a r1 = r3.f524hQ     // Catch:{ all -> 0x003a }
        boolean r1 = r1.isValid()     // Catch:{ all -> 0x003a }
        if (r1 == 0) goto L_0x002d
        java.lang.String r1 = "HIPList"
        java.lang.String r2 = "[ip_list]reset2Default(), not necessary, key unchanged"
        btmsdkobf.C0849fg.m914i(r1, r2)     // Catch:{ all -> 0x003a }
        monitor-exit(r0)     // Catch:{ all -> 0x003a }
        return
    L_0x002d:
        monitor-exit(r0)     // Catch:{ all -> 0x003a }
        r0 = 1
        btmsdkobf.dg$a r0 = r3.m306i(r0)
        r1 = 0
        java.lang.String r2 = "key_default"
        r3.m298a(r2, r0, r1)
        return
    L_0x003a:
        r1 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x003a }
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0689dg.m301aX():void");
    }

    /* renamed from: aY */
    private String m302aY() {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(this.f526hd ? "t_" : "r_");
        String sb3 = sb2.toString();
        int m = C0683dd.m265m(this.mContext);
        if (m == 1) {
            String ssid = C0871h.getSSID();
            sb = new StringBuilder();
            sb.append("wifi_");
            sb.append(ssid);
        } else {
            sb = new StringBuilder();
            sb.append("apn_");
            sb.append(m);
        }
        String sb4 = sb.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb3);
        sb5.append(sb4);
        return sb5.toString();
    }

    /* renamed from: ba */
    private int m303ba() {
        String str;
        int i = 2;
        String str2 = "HIPList";
        if (4 == C0850fh.f984ob) {
            str = "[ip_list]getOperator(), wifi as china telecom";
        } else {
            int b = C0844fc.m897b(this.mContext, C0652cl.m86E().isAllowImsi() ? C0872i.m978c(this.mContext) : "");
            if (-1 == b) {
                str = "[ip_list]getOperator(), unknow as china telecom";
            } else {
                i = b;
                StringBuilder sb = new StringBuilder();
                sb.append("[ip_list]getOperator(), 0-mobile, 1-unicom, 2-telecom: ");
                sb.append(i);
                C0849fg.m911d(str2, sb.toString());
                return i;
            }
        }
        C0849fg.m911d(str2, str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ip_list]getOperator(), 0-mobile, 1-unicom, 2-telecom: ");
        sb2.append(i);
        C0849fg.m911d(str2, sb2.toString());
        return i;
    }

    /* renamed from: f */
    private C0690a m304f(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ip_list]loadSavedIPPortListInfo(), key: ");
        sb.append(str);
        String str2 = "HIPList";
        C0849fg.m914i(str2, sb.toString());
        C0690a k = this.f521hN.mo9258k(str);
        if (k == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[ip_list]loadSavedIPPortListInfo(), no saved info for: ");
            sb2.append(str);
            C0849fg.m916w(str2, sb2.toString());
        } else if (k.isValid()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[ip_list]loadSavedIPPortListInfo(), saved info for: ");
            sb3.append(str);
            sb3.append(": ");
            sb3.append(k.toString());
            C0849fg.m914i(str2, sb3.toString());
            return k;
        } else {
            C0849fg.m916w(str2, "[ip_list]loadSavedIPPortListInfo(), not valid");
            if (z) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("[ip_list]loadSavedIPPortListInfo(), delete not valid info: ");
                sb4.append(str);
                C0849fg.m916w(str2, sb4.toString());
                this.f521hN.mo9247b(str, 0, null);
            }
        }
        return null;
    }

    /* renamed from: g */
    private static boolean m305g(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf > 0 && lastIndexOf != str.length() - 1) {
            String substring = str.substring(0, lastIndexOf);
            String substring2 = str.substring(lastIndexOf + 1);
            if ((z || m311n(substring)) && TextUtils.isDigitsOnly(substring2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    private C0690a m306i(boolean z) {
        if (z) {
            C0690a aVar = f519hS;
            if (aVar != null) {
                return aVar;
            }
        }
        if (!z) {
            C0690a aVar2 = f520hT;
            if (aVar2 != null) {
                return aVar2;
            }
        }
        List j = m307j(z);
        List k = m308k(z);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(j);
        if (f516hK) {
            arrayList.addAll(k);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[ip_list]getDefaultHIPListInfo for ");
        sb.append(z ? "tcp" : "http");
        sb.append(this.f526hd ? " [test server]" : " [release server]");
        sb.append(": ");
        sb.append(arrayList);
        C0849fg.m914i("HIPList", sb.toString());
        C0690a aVar3 = new C0690a(0, arrayList, true);
        if (z) {
            f519hS = aVar3;
        } else {
            f520hT = aVar3;
        }
        return aVar3;
    }

    /* renamed from: j */
    private List<String> m307j(boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(Integer.valueOf(z ? 443 : 80));
        String str = f517hL;
        for (Integer intValue : arrayList2) {
            arrayList.add(String.format("%s:%d", new Object[]{str, Integer.valueOf(intValue.intValue())}));
        }
        return arrayList;
    }

    /* renamed from: k */
    private List<String> m308k(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (this.f526hd) {
            return arrayList;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(Integer.valueOf(z ? 443 : 80));
        String str = "%s:%d";
        if (this.f521hN.mo9296bh() == 1) {
            for (Integer intValue : arrayList2) {
                int intValue2 = intValue.intValue();
                arrayList.add(String.format(str, new Object[]{"203.205.143.147", Integer.valueOf(intValue2)}));
                arrayList.add(String.format(str, new Object[]{"203.205.146.46", Integer.valueOf(intValue2)}));
                arrayList.add(String.format(str, new Object[]{"203.205.146.45", Integer.valueOf(intValue2)}));
            }
        } else {
            int ba = m303ba();
            String str2 = ba != 0 ? ba != 1 ? "120.198.203.156" : "163.177.71.153" : "183.232.125.162";
            for (Integer intValue3 : arrayList2) {
                arrayList.add(String.format(str, new Object[]{str2, Integer.valueOf(intValue3.intValue())}));
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    private void m309l(boolean z) {
        C0690a aVar;
        synchronized (this.f522hO) {
            aVar = z ? this.f524hQ : this.f525hR;
        }
        if (aVar == null) {
            m300aW();
        } else if (!aVar.isValid()) {
            m301aX();
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: m */
    public static C0817b m310m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf > 0 && lastIndexOf != str.length() - 1) {
            String substring = str.substring(0, lastIndexOf);
            String substring2 = str.substring(lastIndexOf + 1);
            String str2 = "HIPList";
            if (TextUtils.isDigitsOnly(substring2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("[ip_list]getIPEndPointByStr(), ip: ");
                sb.append(substring);
                sb.append(" port: ");
                sb.append(Integer.parseInt(substring2));
                C0849fg.m914i(str2, sb.toString());
                return new C0817b(substring, Integer.parseInt(substring2));
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[ip_list]getIPEndPointByStr(), invalid: ");
            sb2.append(str);
            C0849fg.m914i(str2, sb2.toString());
        }
        return null;
    }

    /* renamed from: n */
    private static boolean m311n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (str.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
                String[] split = str.split("\\.");
                if (split.length >= 4 && Integer.parseInt(split[0]) <= 255 && Integer.parseInt(split[1]) <= 255 && Integer.parseInt(split[2]) <= 255 && Integer.parseInt(split[3]) <= 255) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: p */
    private String m313p(int i) {
        String str;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(this.f526hd ? "t_" : "r_");
        String sb3 = sb2.toString();
        if (i != 1) {
            sb = new StringBuilder();
            sb.append("apn_");
            sb.append(i);
        } else if (C0871h.m972o()) {
            String ssid = C0871h.getSSID();
            sb = new StringBuilder();
            sb.append("wifi_");
            sb.append(ssid);
        } else {
            str = "wifi_nonessid";
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            sb4.append(str);
            return sb4.toString();
        }
        str = sb.toString();
        StringBuilder sb42 = new StringBuilder();
        sb42.append(sb3);
        sb42.append(str);
        return sb42.toString();
    }

    /* renamed from: a */
    public void mo9280a(long j, int i, JceStruct jceStruct) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ip_list]onIPListPush(), |pushId=");
        sb.append(j);
        sb.append("|seqNo=");
        sb.append(i);
        String str = "HIPList";
        C0849fg.m915v(str, sb.toString());
        if (!f516hK) {
            C0849fg.m916w(str, "[ip_list]onIPListPush(), not enable, use default");
        } else if (jceStruct == null) {
            C0849fg.m912e(str, "[ip_list]onIPListPush(), bad arg: jceStruct == null");
        } else if (!(jceStruct instanceof C0619bh)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[ip_list]onIPListPush(), bad type, should be SCHIPList: ");
            sb2.append(jceStruct.getClass());
            C0849fg.m912e(str, sb2.toString());
        } else {
            C0619bh bhVar = (C0619bh) jceStruct;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("SCHIPList: ");
            sb3.append("|hash=");
            sb3.append(bhVar.f207cy);
            sb3.append("|ipports=");
            sb3.append(bhVar.f202cG);
            sb3.append("|validperiod=");
            sb3.append(bhVar.f203cH);
            sb3.append("|doclose=");
            sb3.append(bhVar.f204cI);
            sb3.append("|apn=");
            sb3.append(bhVar.f205cJ);
            sb3.append("|extra=");
            sb3.append(bhVar.f206cK);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[ip_list]onIPListPush(), ");
            sb4.append(sb3.toString());
            C0849fg.m915v(str, sb4.toString());
            C0690a aVar = new C0690a(System.currentTimeMillis() + (((long) bhVar.f203cH) * 1000), m296a(bhVar.f202cG, false), false);
            if (!aVar.isValid()) {
                C0849fg.m916w(str, "[ip_list]onIPListPush(), not valid");
            } else {
                int m = C0683dd.m265m(this.mContext);
                int i2 = bhVar.f205cJ;
                if (i2 == m) {
                    String aY = m302aY();
                    this.f521hN.mo9247b(aY, aVar.f527hU, aVar.f528hV);
                    m298a(aY, aVar, true);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[ip_list]onIPListPush(), saved, key: ");
                    sb5.append(aY);
                    C0849fg.m914i(str, sb5.toString());
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("[ip_list]onIPListPush(), apn not match， just save, curApn: ");
                    sb6.append(m);
                    sb6.append(" pushedApn: ");
                    sb6.append(i2);
                    C0849fg.m912e(str, sb6.toString());
                    this.f521hN.mo9247b(m313p(i2), aVar.f527hU, aVar.f528hV);
                }
            }
        }
    }

    /* renamed from: aV */
    public void mo9281aV() {
        if (f516hK) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ip_list]handleNetworkChange(), refreshWorkingHIPList, isTest: ");
            sb.append(this.f526hd);
            C0849fg.m911d("HIPList", sb.toString());
            m300aW();
        }
    }

    /* renamed from: aZ */
    public String mo9282aZ() {
        String str;
        C0817b m = mo9284m(false);
        String str2 = "HIPList";
        String str3 = "http://";
        if (m != null) {
            str = m.mo9500cu();
            if (str != null && (str.length() < 7 || !str.substring(0, 7).equalsIgnoreCase(str3))) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str);
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[ip_list]getHttpIp(), httpIp: ");
            sb2.append(str);
            C0849fg.m914i(str2, sb2.toString());
        } else {
            str = null;
        }
        if (str != null) {
            return str;
        }
        String str4 = f517hL;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(str4);
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[ip_list]getHttpIp(), use default: ");
        sb5.append(sb4);
        C0849fg.m916w(str2, sb5.toString());
        return sb4;
    }

    /* renamed from: ai */
    public boolean mo9283ai() {
        return this.f526hd;
    }

    /* renamed from: m */
    public C0817b mo9284m(boolean z) {
        m309l(true);
        synchronized (this.f522hO) {
            C0690a aVar = z ? this.f524hQ : this.f525hR;
            if (aVar == null) {
                return null;
            }
            C0817b b = aVar.m329bc();
            return b;
        }
    }

    /* renamed from: n */
    public void mo9285n(boolean z) {
        m309l(true);
        synchronized (this.f522hO) {
            C0690a aVar = z ? this.f524hQ : this.f525hR;
            if (aVar != null) {
                aVar.m330bd();
            }
        }
    }

    /* renamed from: o */
    public void mo9286o(boolean z) {
        m309l(true);
        synchronized (this.f522hO) {
            C0690a aVar = z ? this.f524hQ : this.f525hR;
            if (aVar != null) {
                aVar.m331be();
            }
        }
    }

    /* renamed from: p */
    public void mo9287p(boolean z) {
    }

    /* renamed from: q */
    public ArrayList<String> mo9288q(boolean z) {
        m309l(true);
        synchronized (this.f522hO) {
            C0690a aVar = z ? this.f524hQ : this.f525hR;
            if (aVar == null) {
                return null;
            }
            ArrayList<String> arrayList = (ArrayList) aVar.f528hV;
            return arrayList;
        }
    }

    /* renamed from: r */
    public int mo9289r(boolean z) {
        ArrayList q = mo9288q(z);
        if (q != null) {
            return q.size();
        }
        return 0;
    }
}
