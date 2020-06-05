package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatAccount;
import com.tencent.stat.StatMultiAccount;
import com.tencent.stat.StatMultiAccount.AccountType;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.a */
public class C7624a extends Event {
    /* renamed from: a */
    private StatAccount f25789a = null;
    /* renamed from: t */
    private Map<AccountType, StatMultiAccount> f25790t = null;

    public C7624a(Context context, int i, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25789a = statAccount;
    }

    public C7624a(Context context, int i, Map<AccountType, StatMultiAccount> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f25790t = map;
    }

    public EventType getType() {
        return EventType.ADDITION;
    }

    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        StatAccount statAccount = this.f25789a;
        if (statAccount != null) {
            Util.jsonPut(jSONObject, "qq", statAccount.getAccount());
            jSONObject.put("acc", this.f25789a.toJsonString());
        }
        Map<AccountType, StatMultiAccount> map = this.f25790t;
        if (map != null) {
            StatCommonHelper.encodeMultiAccount(jSONObject, map);
        }
        return true;
    }
}
