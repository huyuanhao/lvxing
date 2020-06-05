package com.tencent.stat.event;

import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.C7605i;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class FBIEvent extends Event {
    public FBIEvent() {
        this.f25772c = true;
    }

    public void setSessionId(int i) {
        this.f25776g = i;
    }

    public void setStatSpecifyReportedInfo(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f25785s = statSpecifyReportedInfo;
    }

    public EventType getType() {
        return EventType.FBI_EVENT;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        JSONObject batteryInfo = StatCommonHelper.getBatteryInfo(getContext());
        if (batteryInfo != null) {
            jSONObject.put("bttr", batteryInfo);
        }
        jSONObject.put("lstFile", C7605i.m32780a(getContext()));
        return false;
    }
}
