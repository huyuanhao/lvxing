package btmsdkobf;

import android.os.Environment;
import android.text.TextUtils;
import btmsdkobf.C0689dg.C0690a;
import btmsdkobf.C0704ds.C0707b;
import com.p522qq.taf.jce.JceInputStream;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: btmsdkobf.cw */
public class C0669cw {
    /* renamed from: gJ */
    public static String f454gJ;
    /* renamed from: gK */
    private static int f455gK = 1;
    /* renamed from: gM */
    private static volatile C0669cw f456gM = null;
    /* renamed from: gL */
    private C0843fb f457gL = new C0843fb("sk");

    static {
        try {
            String str = C0652cl.m87F() ? "_test" : "";
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            sb.append("/DCIM/.tmfs/sk_v");
            sb.append(str);
            sb.append(".dat");
            f454gJ = sb.toString();
        } catch (Throwable unused) {
        }
    }

    private C0669cw() {
        this.f457gL.putInt("key_shark_dao_ver", f455gK);
    }

    /* renamed from: ab */
    public static C0669cw m145ab() {
        if (f456gM == null) {
            synchronized (C0669cw.class) {
                if (f456gM == null) {
                    f456gM = new C0669cw();
                }
            }
        }
        return f456gM;
    }

    /* renamed from: aj */
    private LinkedHashMap<String, C0690a> m146aj() {
        LinkedHashMap<String, C0690a> linkedHashMap = new LinkedHashMap<>();
        String y = C0832ew.m867y(this.f457gL.getString("key_hips", ""));
        String str = "SharkDao";
        if (TextUtils.isEmpty(y)) {
            C0849fg.m914i(str, "[ip_list]getAllHIPListInfos(), none is saved");
            return linkedHashMap;
        }
        String[] split = y.split("\\|");
        if (split == null || split.length == 0) {
            C0849fg.m916w(str, "[ip_list]getAllHIPListInfos(), item number is 0!");
            return linkedHashMap;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                String[] split2 = str2.split(StorageInterface.KEY_SPLITER);
                if (split2 != null && split2.length > 0) {
                    try {
                        String str3 = split2[0];
                        long parseLong = Long.parseLong(split2[1]);
                        String[] split3 = split2[2].split("#");
                        if (split3 != null) {
                            linkedHashMap.put(str3, new C0690a(parseLong, C0689dg.m296a(Arrays.asList(split3), false), false));
                        }
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("[ip_list]getAllHIPListInfos() exception: ");
                        sb.append(e);
                        C0849fg.m912e(str, sb.toString());
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ip_list]getAllHIPListInfos(), size: ");
        sb2.append(linkedHashMap.size());
        C0849fg.m914i(str, sb2.toString());
        return linkedHashMap;
    }

    /* renamed from: a */
    public void mo9195a(long j) {
        String x = C0832ew.m866x(Long.toString(j));
        if (x != null) {
            this.f457gL.putString("key_gd_ck_tm", x);
        }
    }

    /* renamed from: a */
    public void mo9196a(C0620bi biVar) {
        if (biVar != null) {
            byte[] b = C0699dp.m381b(biVar);
            if (b != null) {
                String a = C0674d.m218a(b);
                if (a != null) {
                    String x = C0832ew.m866x(a);
                    if (x != null) {
                        this.f457gL.putString("key_s_c", x);
                        C0849fg.m914i("SharkDao", "[shark_conf]setSharkConf() succ");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo9197a(C0631bt btVar) {
        try {
            this.f457gL.putString("key_gd_info", C0674d.m218a(btVar.toByteArray("UTF-8")));
        } catch (Throwable th) {
            C0849fg.m912e("SharkDao", th.getMessage());
        }
    }

    /* renamed from: a */
    public void mo9198a(C0707b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(bVar.f551im);
        sb.append("|");
        sb.append(bVar.f550il);
        String x = C0832ew.m866x(sb.toString());
        if (x != null) {
            this.f457gL.putString("key_rsa", x);
        }
    }

    /* renamed from: a */
    public void mo9199a(String str, long j, List<String> list) {
        String str2 = "SharkDao";
        if (str == null) {
            C0849fg.m912e(str2, "[ip_list]setHIPListInfo(), bad arg, key == null");
            return;
        }
        boolean z = j <= 0 || list == null;
        StringBuilder sb = new StringBuilder();
        sb.append("[ip_list]setHIPListInfo(), op=");
        sb.append(z ? "[delete] " : "[set] ");
        sb.append("|key=");
        sb.append(str);
        C0849fg.m911d(str2, sb.toString());
        LinkedHashMap aj = m146aj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Entry entry : aj.entrySet()) {
            String str3 = (String) entry.getKey();
            C0690a aVar = (C0690a) entry.getValue();
            if (str3 != null) {
                if (aVar != null) {
                    if (!aVar.isValid()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("[ip_list]setHIPListInfo(), remove expired:　");
                        sb2.append(str3);
                        C0849fg.m912e(str2, sb2.toString());
                    } else {
                        linkedHashMap.put(str3, aVar);
                    }
                }
            }
        }
        if (z) {
            linkedHashMap.remove(str);
        } else {
            C0690a aVar2 = new C0690a(j, list, false);
            if (aVar2.isValid()) {
                linkedHashMap.put(str, aVar2);
            }
        }
        if (linkedHashMap.size() > 10) {
            ArrayList arrayList = new ArrayList(linkedHashMap.keySet());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[ip_list]setHIPListInfo(), too manay, keyList: ");
            sb3.append(arrayList);
            C0849fg.m914i(str2, sb3.toString());
            String str4 = (String) arrayList.get(0);
            linkedHashMap.remove(str4);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("[ip_list]setHIPListInfo(), too manay, remove firstKey: ");
            sb4.append(str4);
            C0849fg.m914i(str2, sb4.toString());
        }
        StringBuilder sb5 = new StringBuilder();
        int i = 0;
        for (Entry entry2 : linkedHashMap.entrySet()) {
            String str5 = (String) entry2.getKey();
            C0690a aVar3 = (C0690a) entry2.getValue();
            if (str5 != null) {
                if (aVar3 != null) {
                    long j2 = aVar3.f527hU;
                    if (j2 > System.currentTimeMillis()) {
                        StringBuilder sb6 = new StringBuilder();
                        int i2 = 0;
                        for (String str6 : aVar3.f528hV) {
                            if (i2 > 0) {
                                sb6.append("#");
                            }
                            sb6.append(str6);
                            i2++;
                        }
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str5);
                        String str7 = StorageInterface.KEY_SPLITER;
                        sb7.append(str7);
                        sb7.append(j2);
                        sb7.append(str7);
                        sb7.append(sb6.toString());
                        if (i > 0) {
                            sb5.append("|");
                        }
                        sb5.append(sb7.toString());
                        i++;
                    }
                }
            }
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("[ip_list]setHIPListInfo(), new size: ");
        sb8.append(i);
        sb8.append(", before encode: ");
        sb8.append(sb5.toString());
        C0849fg.m914i(str2, sb8.toString());
        String x = C0832ew.m866x(sb5.toString());
        if (x == null) {
            C0849fg.m912e(str2, "[ip_list]getEncodeString for HIPLists failed");
        } else {
            this.f457gL.putString("key_hips", x);
        }
    }

    /* renamed from: ac */
    public C0707b mo9200ac() {
        String string = this.f457gL.getString("key_rsa", "");
        if (!TextUtils.isEmpty(string)) {
            String y = C0832ew.m867y(string);
            if (!TextUtils.isEmpty(y)) {
                int indexOf = y.indexOf("|");
                if (indexOf > 0 && indexOf < y.length() - 1) {
                    C0707b bVar = new C0707b();
                    bVar.f551im = y.substring(0, indexOf);
                    bVar.f550il = y.substring(indexOf + 1);
                    return bVar;
                }
            }
        }
        return null;
    }

    /* renamed from: ad */
    public String mo9201ad() {
        return C0832ew.m867y(this.f457gL.getString("key_gd", ""));
    }

    /* renamed from: ae */
    public String mo9202ae() {
        return C0832ew.m867y(this.f457gL.getString("key_vd", ""));
    }

    /* renamed from: af */
    public String mo9203af() {
        byte[] z = C0834ey.m876z(f454gJ);
        if (z != null) {
            return C0832ew.m867y(new String(z));
        }
        return null;
    }

    /* renamed from: ag */
    public long mo9204ag() {
        try {
            return Long.parseLong(C0832ew.m867y(this.f457gL.getString("key_gd_ck_tm", "")));
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: ah */
    public C0631bt mo9205ah() {
        C0631bt btVar = new C0631bt();
        try {
            String string = this.f457gL.getString("key_gd_info", "");
            if (!TextUtils.isEmpty(string)) {
                byte[] a = C0674d.m219a(string);
                if (a != null) {
                    JceInputStream jceInputStream = new JceInputStream(a);
                    jceInputStream.setServerEncoding("UTF-8");
                    btVar.readFrom(jceInputStream);
                }
            }
        } catch (Throwable th) {
            C0849fg.m912e("SharkDao", th.getMessage());
        }
        return btVar;
    }

    /* renamed from: ai */
    public boolean mo9206ai() {
        return this.f457gL.getBoolean("key_test_state", false);
    }

    /* renamed from: ak */
    public C0620bi mo9207ak() {
        String y = C0832ew.m867y(this.f457gL.getString("key_s_c", ""));
        if (!TextUtils.isEmpty(y)) {
            return (C0620bi) C0699dp.m380a(C0674d.m219a(y), new C0620bi(), false);
        }
        return null;
    }

    /* renamed from: d */
    public void mo9208d(boolean z) {
        this.f457gL.putBoolean("key_test_state", z);
    }

    /* renamed from: g */
    public void mo9209g(String str) {
        String x = C0832ew.m866x(str);
        if (x != null) {
            this.f457gL.putString("key_gd", x);
        }
    }

    /* renamed from: h */
    public void mo9210h(String str) {
        String x = C0832ew.m866x(str);
        if (x != null) {
            this.f457gL.putString("key_vd", x);
        }
    }

    /* renamed from: i */
    public void mo9211i(String str) {
        String x = C0832ew.m866x(str);
        if (!(x == null || f454gJ == null)) {
            C0834ey.m873a(x.getBytes(), f454gJ);
        }
    }

    /* renamed from: j */
    public C0690a mo9212j(String str) {
        return (C0690a) m146aj().get(str);
    }
}
