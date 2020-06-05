package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.h */
public class C7632h extends Event {
    /* renamed from: a */
    public static final StatSpecifyReportedInfo f25809a = new StatSpecifyReportedInfo();

    static {
        f25809a.setAppKey("A9VH9B8L4GX4");
    }

    public C7632h(Context context) {
        super(context, 0, f25809a);
    }

    public EventType getType() {
        return EventType.NETWORK_DETECTOR;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        Util.jsonPut(jSONObject, "actky", StatConfig.getAppKey(this.f25784r));
        return true;
    }
}
