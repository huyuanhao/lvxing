package com.tencent.stat.event;

import android.content.Context;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.k */
public class C7635k extends Event {
    /* renamed from: a */
    double f25813a = 0.0d;
    /* renamed from: t */
    String f25814t;
    /* renamed from: u */
    String f25815u;

    public C7635k(Context context, String str, String str2, int i, double d, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25815u = str;
        this.f25814t = str2;
        this.f25813a = d;
    }

    public EventType getType() {
        return EventType.PAGE_VIEW;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        Util.jsonPut(jSONObject, "pi", this.f25814t);
        Util.jsonPut(jSONObject, KEYS.Banner_RF, this.f25815u);
        double d = this.f25813a;
        if (d >= 0.0d) {
            jSONObject.put("du", d);
        }
        return true;
    }
}
