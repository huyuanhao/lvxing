package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.MessageKey;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.event.d */
public class C7102d extends C7100b {
    /* renamed from: a */
    Long f23608a = null;
    /* renamed from: b */
    String f23609b;
    /* renamed from: m */
    String f23610m;
    /* renamed from: n */
    public long f23611n = 0;
    /* renamed from: o */
    public long f23612o = 0;

    public C7102d(Context context, String str, String str2, int i, Long l, long j) {
        super(context, i, j);
        this.f23610m = str;
        this.f23609b = str2;
        this.f23608a = l;
    }

    /* renamed from: b */
    public EventType mo34233b() {
        return EventType.PAGE_VIEW;
    }

    /* renamed from: a */
    public boolean mo34232a(JSONObject jSONObject) {
        C6914l.m29512a(jSONObject, "pi", this.f23609b);
        C6914l.m29512a(jSONObject, KEYS.Banner_RF, this.f23610m);
        Long l = this.f23608a;
        if (l != null) {
            jSONObject.put("du", l);
        }
        long j = this.f23611n;
        if (j > 0) {
            C6914l.m29511a(jSONObject, MessageKey.MSG_ID, j);
        }
        long j2 = this.f23612o;
        if (j2 > 0) {
            C6914l.m29511a(jSONObject, MessageKey.MSG_BUSI_MSG_ID, j2);
        }
        return true;
    }
}
