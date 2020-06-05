package com.bytedance.embedapplog.p142b;

import android.content.Context;
import discoveryAD.C7895e;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.b.k */
class C1824k extends C1816c {
    /* renamed from: e */
    private final Context f5120e;

    C1824k(Context context) {
        super(true, true);
        this.f5120e = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo13364a(JSONObject jSONObject) {
        C1822i.m6381a(jSONObject, "language", this.f5120e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / C7895e.f26887Bc;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put("timezone", rawOffset);
        C1822i.m6381a(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        C1822i.m6381a(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
