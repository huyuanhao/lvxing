package com.tencent.android.tpush.stat.event;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.event.c */
public class C7101c extends C7098a {
    public C7101c(Context context, String str, JSONObject jSONObject, String str2, boolean z) {
        super(context, str, jSONObject, str2, z);
    }

    /* renamed from: b */
    public EventType mo34233b() {
        return EventType.LBS;
    }

    /* renamed from: a */
    public boolean mo34232a(JSONObject jSONObject) {
        jSONObject.put("ei", this.f23592a.f23594a);
        if (this.f23593b > 0) {
            jSONObject.put("du", this.f23593b);
        }
        if (this.f23592a.f23595b == null) {
            jSONObject.put("lbs", this.f23592a.f23596c);
        } else {
            jSONObject.put("ar", this.f23592a.f23595b);
        }
        return true;
    }
}
