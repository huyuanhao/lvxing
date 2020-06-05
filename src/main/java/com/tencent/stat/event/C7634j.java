package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.j */
public class C7634j extends C7640n {
    public EventType getType() {
        return EventType.ONCE;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        super.onEncode(jSONObject);
        mo37187a(jSONObject);
        jSONObject.put("ft", 1);
        return true;
    }

    public C7634j(Context context, int i, JSONObject jSONObject, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, jSONObject, statSpecifyReportedInfo);
    }
}
