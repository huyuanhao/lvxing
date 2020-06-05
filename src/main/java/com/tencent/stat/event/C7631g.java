package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.NetworkManager;
import com.tencent.stat.StatAppMonitor;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.g */
public class C7631g extends Event {
    /* renamed from: t */
    private static String f25806t;
    /* renamed from: u */
    private static String f25807u;
    /* renamed from: a */
    private StatAppMonitor f25808a = null;

    public C7631g(Context context, int i, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25808a = statAppMonitor.clone();
    }

    public EventType getType() {
        return EventType.MONITOR_STAT;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        StatAppMonitor statAppMonitor = this.f25808a;
        if (statAppMonitor == null) {
            return false;
        }
        jSONObject.put("na", statAppMonitor.getInterfaceName());
        jSONObject.put("rq", this.f25808a.getReqSize());
        jSONObject.put("rp", this.f25808a.getRespSize());
        jSONObject.put("rt", this.f25808a.getResultType());
        jSONObject.put("tm", this.f25808a.getMillisecondsConsume());
        jSONObject.put("rc", this.f25808a.getReturnCode());
        jSONObject.put("sp", this.f25808a.getSampling());
        if (f25807u == null) {
            f25807u = StatCommonHelper.getAppVersion(this.f25784r);
        }
        Util.jsonPut(jSONObject, "av", f25807u);
        if (f25806t == null) {
            f25806t = StatCommonHelper.getSimOperator(this.f25784r);
        }
        Util.jsonPut(jSONObject, "op", f25806t);
        jSONObject.put("cn", NetworkManager.getInstance(this.f25784r).getCurNetwrokName());
        return true;
    }
}
