package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.stat.p596a.C7062a;
import com.tencent.android.tpush.stat.p596a.C7066c;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.event.e */
public class C7103e extends C7100b {
    /* renamed from: a */
    private C7062a f23613a;
    /* renamed from: b */
    private JSONObject f23614b = null;

    public C7103e(Context context, int i, JSONObject jSONObject, long j) {
        super(context, i, j);
        this.f23613a = new C7062a(context, j);
        this.f23614b = jSONObject;
    }

    /* renamed from: b */
    public EventType mo34233b() {
        return EventType.SESSION_ENV;
    }

    /* renamed from: a */
    public boolean mo34232a(JSONObject jSONObject) {
        jSONObject.put("ut", 1);
        JSONObject jSONObject2 = this.f23614b;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        if (C7066c.m30266d(this.f23607l)) {
            jSONObject.put("ncts", 1);
        }
        this.f23613a.mo34163a(jSONObject, (Thread) null);
        return true;
    }
}
