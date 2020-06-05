package mtopsdk.common.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: mtopsdk.common.util.c */
public class RemoteConfig {
    /* renamed from: A */
    private static Map<String, Integer> f27846A;
    /* renamed from: y */
    private static RemoteConfig f27847y;
    /* renamed from: a */
    public boolean f27848a = true;
    /* renamed from: b */
    public boolean f27849b = false;
    /* renamed from: c */
    public long f27850c = 24;
    /* renamed from: d */
    public boolean f27851d = true;
    @Deprecated
    /* renamed from: e */
    public boolean f27852e = true;
    /* renamed from: f */
    public boolean f27853f = true;
    /* renamed from: g */
    public boolean f27854g = true;
    /* renamed from: h */
    public boolean f27855h = false;
    /* renamed from: i */
    public boolean f27856i = false;
    /* renamed from: j */
    public boolean f27857j = true;
    /* renamed from: k */
    public long f27858k = 10;
    /* renamed from: l */
    public String f27859l;
    /* renamed from: m */
    public String f27860m;
    /* renamed from: n */
    public String f27861n;
    /* renamed from: o */
    public String f27862o;
    /* renamed from: p */
    public String f27863p;
    /* renamed from: q */
    public long f27864q;
    /* renamed from: r */
    public int f27865r;
    /* renamed from: s */
    public boolean f27866s;
    /* renamed from: t */
    public int f27867t;
    /* renamed from: u */
    public int f27868u;
    /* renamed from: v */
    public final Set<String> f27869v;
    /* renamed from: w */
    public final Set<String> f27870w;
    /* renamed from: x */
    public boolean f27871x;
    /* renamed from: z */
    private Map<String, String> f27872z = null;

    public RemoteConfig() {
        String str = "";
        this.f27859l = str;
        this.f27860m = str;
        this.f27861n = str;
        this.f27862o = str;
        this.f27863p = str;
        this.f27864q = 20;
        this.f27865r = 2;
        this.f27866s = false;
        this.f27867t = -1;
        this.f27868u = -1;
        this.f27869v = new HashSet();
        this.f27870w = new HashSet();
        this.f27871x = true;
    }

    /* renamed from: a */
    public static RemoteConfig m35521a() {
        if (f27847y == null) {
            synchronized (RemoteConfig.class) {
                if (f27847y == null) {
                    f27847y = new RemoteConfig();
                }
            }
        }
        return f27847y;
    }

    static {
        HashMap hashMap = new HashMap();
        f27846A = hashMap;
        hashMap.put("2G", Integer.valueOf(32768));
        f27846A.put("3G", Integer.valueOf(65536));
        Map<String, Integer> map = f27846A;
        Integer valueOf = Integer.valueOf(524288);
        map.put("4G", valueOf);
        f27846A.put("WIFI", valueOf);
        Map<String, Integer> map2 = f27846A;
        Integer valueOf2 = Integer.valueOf(131072);
        map2.put("UNKONWN", valueOf2);
        f27846A.put("NET_NO", valueOf2);
    }
}
