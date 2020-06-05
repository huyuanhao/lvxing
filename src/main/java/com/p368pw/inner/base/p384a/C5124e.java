package com.p368pw.inner.base.p384a;

import android.content.Context;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.base.C5114a;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.p368pw.inner.base.p387d.C5205o;
import org.json.JSONObject;

/* renamed from: com.pw.inner.base.a.e */
public class C5124e extends C5114a<C5123d> {
    /* renamed from: a */
    private String f16735a;

    public C5124e(String str) {
        this.f16735a = str;
    }

    /* renamed from: a */
    public static String m21208a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("phead", m21209b(context, str));
            jSONObject.put("serviceid", 1);
            return C5162b.m21305a().mo26769a(jSONObject.toString());
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return "";
        }
    }

    /* renamed from: b */
    private static JSONObject m21209b(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pkg", C5191i.m21401e(context));
            jSONObject.put("xd", str);
            jSONObject.put("pk", C5238g.m21604a(context));
            jSONObject.put("cv", C5191i.m21402f(context));
            jSONObject.put("loc", C5191i.m21399d(context));
            jSONObject.put("ln", C5191i.m21409l(context));
            jSONObject.put("ut", C5237f.m21578b(context));
            jSONObject.put("e", String.valueOf(1));
            jSONObject.put("d", String.valueOf(C5191i.m21392b(context, context.getPackageName())));
            jSONObject.put("u", 2);
            jSONObject.put("ud", C5191i.m21387a(context));
            jSONObject.put("gd", C5191i.m21394b(context));
            jSONObject.put("st", String.valueOf(0));
            jSONObject.put("tc", C5237f.m21590e(context));
            jSONObject.put("sv", 30132);
            jSONObject.put("sn", "win_2.7.2");
            jSONObject.put("btid", C5237f.m21593f(context));
        } catch (Exception e) {
            C5205o.m21464a((Throwable) e);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5123d mo25765b(String str) {
        return new C5123d(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        return C5194l.m21429a("https://str.zzpolarb.com", m21208a(C5233e.m21559b(), this.f16735a));
    }
}
