package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.C7592a;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.n */
public class C7640n extends Event {
    /* renamed from: u */
    private static int f25824u = 1;
    /* renamed from: a */
    private C7592a f25825a;
    /* renamed from: t */
    private JSONObject f25826t = null;

    public C7640n(Context context, int i, JSONObject jSONObject, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25825a = new C7592a(context);
        this.f25826t = jSONObject;
    }

    public EventType getType() {
        return EventType.SESSION_ENV;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        int i = f25824u;
        if (i == 1) {
            jSONObject.put("hs", i);
            f25824u = 0;
        }
        if (this.f25777h != null) {
            jSONObject.put("ut", this.f25777h.getUserType());
        }
        JSONObject jSONObject2 = this.f25826t;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        if (StatCommonHelper.needCheckTime(this.f25784r)) {
            jSONObject.put("ncts", 1);
        }
        this.f25825a.mo37120a(jSONObject, (Thread) null);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37187a(JSONObject jSONObject) {
        try {
            jSONObject.put("app", StatCommonHelper.getAppList(this.f25784r));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
