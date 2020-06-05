package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.NetworkManager;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.i */
public class C7633i extends Event {
    /* renamed from: a */
    private static String f25810a;
    /* renamed from: t */
    private String f25811t = null;
    /* renamed from: u */
    private String f25812u = null;

    /* renamed from: a */
    public void mo37192a(String str) {
        this.f25812u = str;
    }

    public C7633i(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25811t = NetworkManager.getInstance(context).getCurNetwrokName();
        if (f25810a == null) {
            f25810a = StatCommonHelper.getSimOperator(context);
        }
    }

    public EventType getType() {
        return EventType.NETWORK_MONITOR;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        Util.jsonPut(jSONObject, "op", f25810a);
        Util.jsonPut(jSONObject, "cn", this.f25811t);
        jSONObject.put("sp", this.f25812u);
        return true;
    }
}
