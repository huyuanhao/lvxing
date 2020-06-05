package com.p368pw.inner.p369a.p370a.p373c;

import android.content.Context;
import com.p368pw.inner.C5228c;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.C5114a;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5206p;
import com.p368pw.inner.base.p387d.C5207q;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.a.c.g */
public class C4849g extends C5114a<Void> {
    /* renamed from: a */
    private String f15617a;
    /* renamed from: b */
    private String f15618b;

    public C4849g(String str, String str2) {
        this.f15617a = str;
        this.f15618b = str2;
    }

    /* renamed from: d */
    private boolean m19902d() {
        Context b = C5233e.m21559b();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15617a);
        sb.append(this.f15618b);
        return C5206p.m21468a(b, sb.toString()) != 0;
    }

    /* renamed from: e */
    private void m19903e() {
        Context b = C5233e.m21559b();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15617a);
        sb.append(this.f15618b);
        C5206p.m21470a(b, sb.toString(), System.currentTimeMillis());
    }

    /* renamed from: f */
    private boolean m19904f() {
        return Math.random() * 100.0d > ((double) C5125f.m21216a().mo26727d().mo26699c());
    }

    /* renamed from: g */
    private static String m19905g() {
        return C5228c.m21539a("https://tain.zzpolarb.com/api/v1/collect/pkgname");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        StringBuilder sb;
        String str;
        String str2;
        String str3 = ",pkgName:";
        if (C5207q.m21476a((CharSequence) this.f15617a) || C5207q.m21476a((CharSequence) this.f15618b)) {
            sb = new StringBuilder();
            str = "参数不能为空,title:";
        } else if (m19902d()) {
            sb = new StringBuilder();
            str = "已经上报过了,title:";
        } else if (m19904f()) {
            str2 = "策略概率控制，不上报";
            C5205o.m21462a(str2);
            return null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", C5233e.m21558a().mo26928c());
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("title", this.f15617a);
                jSONObject2.put("pkg", this.f15618b);
                jSONArray.put(jSONObject2);
                jSONObject.put("pkgs", jSONArray);
                String b = C5162b.m21305a().mo26772b(C5194l.m21436e(m19905g()).mo26816h(C5162b.m21305a().mo26770a(jSONObject.toString(), true)).mo26813a(), true);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("result:");
                sb2.append(b);
                C5205o.m21462a(sb2.toString());
                int optInt = new JSONObject(b).optInt("code");
                if (optInt < 200 || optInt > 209) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("上报失败：");
                    sb3.append(optInt);
                    C5205o.m21462a(sb3.toString());
                    return null;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("上报成功,title:");
                sb4.append(this.f15617a);
                sb4.append(str3);
                sb4.append(this.f15618b);
                C5205o.m21462a(sb4.toString());
                m19903e();
                return null;
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
        sb.append(str);
        sb.append(this.f15617a);
        sb.append(str3);
        sb.append(this.f15618b);
        str2 = sb.toString();
        C5205o.m21462a(str2);
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void mo25765b(String str) {
        return null;
    }
}
