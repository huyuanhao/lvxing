package com.qiyukf.nimlib.p453d.p459b.p460a;

import com.qiyukf.nimlib.p453d.p459b.C5762a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.b.a.c */
public final class C5765c implements C5762a {
    /* renamed from: a */
    private int f18356a;
    /* renamed from: b */
    private int f18357b;
    /* renamed from: c */
    private int f18358c;

    C5765c(int i, int i2, int i3) {
        this.f18356a = i;
        this.f18357b = i2;
        this.f18358c = i3;
    }

    /* renamed from: a */
    public final JSONObject mo28034a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cell_id", this.f18357b);
            jSONObject.put("lac", this.f18356a);
            jSONObject.put("strength", this.f18358c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CellInfo{lac=");
        sb.append(this.f18356a);
        sb.append(", cid=");
        sb.append(this.f18357b);
        sb.append(", strength=");
        sb.append(this.f18358c);
        sb.append('}');
        return sb.toString();
    }
}
