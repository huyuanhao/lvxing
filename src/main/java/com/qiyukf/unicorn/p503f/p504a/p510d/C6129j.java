package com.qiyukf.unicorn.p503f.p504a.p510d;

import androidx.core.app.NotificationCompat;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@C6111b(mo29052a = 502, mo29053b = false)
/* renamed from: com.qiyukf.unicorn.f.a.d.j */
public class C6129j extends C6144e {
    @C6110a(mo29051a = "result")
    /* renamed from: a */
    private String f19158a;
    /* renamed from: b */
    private Map<String, Integer> f19159b;

    /* renamed from: a */
    public final Map<String, Integer> mo29122a() {
        return this.f19159b;
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        super.afterParse(jSONObject);
        JSONArray b = C5366b.m22035b(this.f19158a);
        if (b != null && b.length() > 0) {
            this.f19159b = new HashMap(b.length());
            for (int i = 0; i < b.length(); i++) {
                JSONObject b2 = C5366b.m22036b(b, i);
                this.f19159b.put(C5366b.m22039e(C5366b.m22040f(b2, "shop"), "id"), Integer.valueOf(C5366b.m22034b(C5366b.m22040f(b2, "sessionStatus"), NotificationCompat.CATEGORY_STATUS)));
            }
        }
    }
}
