package com.p368pw.inner.appwall;

import android.content.Context;
import com.p368pw.inner.C5228c;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.C5238g;
import com.p368pw.inner.base.C5114a;
import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5194l;
import com.tencent.stat.common.DeviceInfo;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.appwall.r */
public class C5044r extends C5114a<C5041p> {
    /* renamed from: a */
    private String f16475a;
    /* renamed from: b */
    private String f16476b;
    /* renamed from: c */
    private String f16477c;
    /* renamed from: d */
    private JSONArray f16478d;
    /* renamed from: e */
    private int f16479e;
    /* renamed from: f */
    private int f16480f = 6;

    public C5044r(Context context, String str, List<String> list, int i) {
        this.f16475a = C5238g.m21604a(context);
        this.f16476b = str;
        this.f16477c = C5191i.m21387a(context);
        this.f16479e = i;
        if (list != null && list.size() > 0) {
            this.f16478d = new JSONArray();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f16478d.put(list.get(i2));
            }
        }
    }

    /* renamed from: a */
    private String m21055a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", this.f16475a);
            jSONObject.put("placement_id", this.f16476b);
            jSONObject.put(DeviceInfo.TAG_ANDROID_ID, this.f16477c);
            jSONObject.put("adpkgs", this.f16478d);
            jSONObject.put("scoreType", this.f16479e);
            jSONObject.put("sdk_version_code", 30132);
            jSONObject.put("app_version_code", C5191i.m21402f(context));
            return C5162b.m21305a().mo26770a(jSONObject.toString(), true);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: d */
    private String m21056d() {
        return C5228c.m21539a("https://tain.zzpolarb.com/api/v1/apw/cfgs");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5041p mo25765b(String str) {
        return new C5041p(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo25762a() {
        return C5194l.m21436e(m21056d()).mo26816h(m21055a(C5233e.m21559b())).mo26814b(this.f16480f).mo26813a();
    }
}
