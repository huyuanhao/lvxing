package com.alibaba.baichuan.trade.common.adapter.p060b.p061a;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.C1223b;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import com.alibaba.baichuan.trade.common.utils.C1227b;
import com.alibaba.baichuan.trade.common.utils.http.HttpHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.b.a.a */
public class C1205a {
    /* renamed from: a */
    private static final String f2489a = C1205a.class.getSimpleName();
    /* renamed from: b */
    private Map<String, String> f2490b = new HashMap();
    /* renamed from: c */
    private String f2491c;

    private C1205a() {
    }

    /* renamed from: a */
    public static C1205a m2348a() {
        return new C1205a();
    }

    /* renamed from: b */
    public static String m2349b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            String str3 = "UTF-8";
            if (str2 != null) {
                try {
                    str2 = URLEncoder.encode(str2, str3);
                } catch (UnsupportedEncodingException e) {
                    C1224a.m2406d(f2489a, e.getMessage());
                }
            }
            str = URLEncoder.encode(str, str3);
            if (str2 != null) {
                stringBuffer.append("&");
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString().substring(1);
    }

    /* renamed from: a */
    public C1205a mo10859a(long j) {
        if (j > 0) {
            Map<String, String> map = this.f2490b;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            map.put("time", sb.toString());
        }
        return this;
    }

    /* renamed from: a */
    public C1205a mo10860a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2491c = str;
        }
        return this;
    }

    /* renamed from: a */
    public C1205a mo10861a(Map<String, String> map) {
        if (map != null) {
            this.f2490b.putAll(map);
        }
        return this;
    }

    /* renamed from: b */
    public C1205a mo10862b() {
        String str = C1223b.f2468h;
        String str2 = "ttid";
        if (!this.f2490b.containsKey(str2) && !TextUtils.isEmpty(str)) {
            Map<String, String> map = this.f2490b;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            map.put(str2, sb.toString());
        }
        return this;
    }

    /* renamed from: b */
    public C1205a mo10863b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2490b.put("sdktype", str);
        }
        return this;
    }

    /* renamed from: c */
    public C1205a mo10864c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2490b.put("page", str);
        }
        return this;
    }

    /* renamed from: c */
    public void mo10865c() {
        if (!TextUtils.isEmpty(this.f2491c)) {
            StringBuffer stringBuffer = new StringBuffer();
            String str = "https://wgo.mmstat.com/%s?";
            stringBuffer.append(String.format(str, new Object[]{this.f2491c}));
            stringBuffer.append(m2349b(this.f2490b));
            if (stringBuffer.toString().length() > 8000) {
                String str2 = "param";
                if (this.f2490b.containsKey(str2)) {
                    this.f2490b.remove(str2);
                }
                stringBuffer = new StringBuffer();
                stringBuffer.append(String.format(str, new Object[]{this.f2491c}));
                stringBuffer.append(m2349b(this.f2490b));
                if (stringBuffer.toString().length() > 8000) {
                    this.f2490b.clear();
                    this.f2490b.put("ttid", C1223b.f2468h);
                    this.f2490b.put("appkey", C1223b.m2399c());
                    this.f2490b.put("sdktype", "mini");
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(String.format(str, new Object[]{this.f2491c}));
                    stringBuffer.append(m2349b(this.f2490b));
                }
            }
            final String stringBuffer2 = stringBuffer.toString();
            C1224a.m2404b("Aplus", stringBuffer2);
            C1227b.m2414a().mo10881a(new Runnable() {
                public void run() {
                    C1224a.m2404b("Aplus", HttpHelper.m2436a(stringBuffer2));
                }
            });
            return;
        }
        throw new IllegalArgumentException("spm is null");
    }
}
