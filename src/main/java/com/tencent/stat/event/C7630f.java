package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatGameUser;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.f */
public class C7630f extends Event {
    /* renamed from: a */
    private StatGameUser f25805a = null;

    public C7630f(Context context, int i, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25805a = statGameUser.clone();
    }

    public EventType getType() {
        return EventType.MTA_GAME_USER;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        StatGameUser statGameUser = this.f25805a;
        if (statGameUser == null) {
            return false;
        }
        Util.jsonPut(jSONObject, "wod", statGameUser.getWorldName());
        Util.jsonPut(jSONObject, "gid", this.f25805a.getAccount());
        Util.jsonPut(jSONObject, "lev", this.f25805a.getLevel());
        return true;
    }
}
