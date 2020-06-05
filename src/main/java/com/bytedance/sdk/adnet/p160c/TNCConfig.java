package com.bytedance.sdk.adnet.p160c;

import java.util.Map;

/* renamed from: com.bytedance.sdk.adnet.c.d */
public class TNCConfig {
    /* renamed from: a */
    public boolean f6147a = false;
    /* renamed from: b */
    public boolean f6148b = true;
    /* renamed from: c */
    public Map<String, Integer> f6149c = null;
    /* renamed from: d */
    public Map<String, String> f6150d = null;
    /* renamed from: e */
    public int f6151e = 10;
    /* renamed from: f */
    public int f6152f = 3;
    /* renamed from: g */
    public int f6153g = 3;
    /* renamed from: h */
    public int f6154h = 10;
    /* renamed from: i */
    public int f6155i = 3;
    /* renamed from: j */
    public int f6156j = 3;
    /* renamed from: k */
    public int f6157k = 900;
    /* renamed from: l */
    public int f6158l = 120;
    /* renamed from: m */
    public String f6159m = null;
    /* renamed from: n */
    public int f6160n = 0;
    /* renamed from: o */
    public long f6161o = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f6147a);
        sb.append(" probeEnable: ");
        sb.append(this.f6148b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f6149c;
        int i = 0;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f6150d;
        if (map2 != null) {
            i = map2.size();
        }
        sb.append(i);
        sb.append(" reqTo: ");
        sb.append(this.f6151e);
        String str = "#";
        sb.append(str);
        sb.append(this.f6152f);
        sb.append(str);
        sb.append(this.f6153g);
        sb.append(" reqErr: ");
        sb.append(this.f6154h);
        sb.append(str);
        sb.append(this.f6155i);
        sb.append(str);
        sb.append(this.f6156j);
        sb.append(" updateInterval: ");
        sb.append(this.f6157k);
        sb.append(" updateRandom: ");
        sb.append(this.f6158l);
        sb.append(" httpBlack: ");
        sb.append(this.f6159m);
        return sb.toString();
    }
}
