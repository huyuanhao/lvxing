package com.tencent.stat.lbs;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.Util;
import com.tencent.stat.event.Event;
import com.tencent.stat.event.EventType;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.lbs.a */
public class C7647a extends Event {
    public C7647a(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
    }

    public EventType getType() {
        return EventType.LBS_EVENT;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        Util.safeJsonPut(jSONObject, "lbs", C7648b.m32908a(getContext()));
        return true;
    }
}
