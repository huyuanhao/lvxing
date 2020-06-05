package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.d */
public class C7628d extends Event {
    /* renamed from: a */
    private JSONObject f25797a = null;

    /* renamed from: a */
    public void mo37187a(JSONObject jSONObject) {
        this.f25797a = jSONObject;
    }

    public C7628d(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
    }

    public EventType getType() {
        return EventType.CUSTOM_PROPERTY;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = this.f25797a;
        if (jSONObject2 != null) {
            jSONObject.put("cp", jSONObject2);
        }
        return false;
    }
}
