package com.bytedance.embedapplog.p142b;

import android.content.Context;
import com.bytedance.embed_device_register.C1779b;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.n */
final class C1827n extends C1816c {
    /* renamed from: e */
    private final Context f5124e;
    /* renamed from: f */
    private final C1821h f5125f;

    C1827n(Context context, C1821h hVar) {
        super(true, false);
        this.f5124e = context;
        this.f5125f = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        Map b = C1779b.m6173b(this.f5124e, this.f5125f.mo13399d());
        if (b == null) {
            return false;
        }
        jSONObject.put("oaid", new JSONObject(b));
        return true;
    }
}
