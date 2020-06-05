package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.StatPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.b */
public class C7625b extends C7635k {
    /* renamed from: v */
    private static int f25791v;

    public EventType getType() {
        return EventType.BACKGROUND;
    }

    public C7625b(Context context, int i, double d, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, null, null, i, d, statSpecifyReportedInfo);
        String str = "back_ev_index";
        if (f25791v == 0) {
            f25791v = StatPreferences.getInt(context, str, 0);
            if (f25791v > 2147383647) {
                f25791v = 0;
            }
        }
        f25791v++;
        StatPreferences.putInt(context, str, f25791v);
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        jSONObject.put("bc", f25791v);
        jSONObject.put("ft", 1);
        return super.onEncode(jSONObject);
    }
}
