package com.p368pw.inner.p369a;

import com.p368pw.inner.base.p387d.C5162b;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.b */
public class C4875b {
    /* renamed from: a */
    private ArrayList<C4966f> f15737a;

    public C4875b(int i, String str) {
        this.f15737a = new ArrayList<>();
        this.f15737a.add(new C4966f(i, str));
    }

    public C4875b(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    JSONObject optJSONObject = new JSONObject(C5162b.m21305a().mo26772b(str, true)).optJSONObject("data");
                    if (optJSONObject != null) {
                        this.f15737a = new ArrayList<>();
                        JSONArray optJSONArray = optJSONObject.optJSONArray("placements");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            this.f15737a.add(new C4966f(optJSONArray.optJSONObject(i)));
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
        C5205o.m21462a("asb rs em");
    }

    /* renamed from: a */
    public ArrayList<C4966f> mo25894a() {
        return this.f15737a;
    }
}
