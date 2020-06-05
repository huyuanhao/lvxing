package com.tencent.android.tpush.service.p589b;

import android.content.Context;
import com.tencent.android.tpush.common.C6908h;
import com.tencent.android.tpush.p580b.C6864a;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.b.a */
public class C6978a {
    /* renamed from: a */
    private String f23181a = null;
    /* renamed from: b */
    private Context f23182b = null;

    public C6978a(Context context, String str) {
        this.f23182b = context;
        StringBuilder sb = new StringBuilder();
        sb.append("com.tencent.xg.tpush.httpdns.cache.");
        sb.append(str);
        this.f23181a = sb.toString();
    }

    /* renamed from: a */
    public void mo33296a(JSONObject jSONObject) {
        C6908h.m29487b(this.f23182b, this.f23181a, jSONObject.toString());
    }

    /* renamed from: a */
    public String mo33295a() {
        return C6908h.m29483a(this.f23182b, this.f23181a, (String) null);
    }

    /* renamed from: b */
    public String mo33297b() {
        String a = mo33295a();
        C6981c a2 = (a == null || a.length() <= 7) ? null : C6981c.m29811a(a);
        if (a2 != null) {
            long b = a2.mo33309b() - System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("cacheResult:");
            sb.append(a2);
            sb.append(",diff:");
            sb.append(b);
            String str = "httpDns";
            C6864a.m29298c(str, sb.toString());
            if (b > 0) {
                return a2.mo33308a();
            }
            C6864a.m29306g(str, "cacheResult Exp.");
        }
        return null;
    }
}
