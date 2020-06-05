package com.bytedance.embedapplog.p142b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embed_device_register.C1779b;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.e */
final class C1818e extends C1816c {
    /* renamed from: e */
    private final C1821h f5099e;

    C1818e(Context context, C1821h hVar) {
        super(true, false);
        this.f5099e = hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        String a = C1779b.m6169a(this.f5099e.mo13399d());
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        jSONObject.put("cdid", a);
        return true;
    }
}
