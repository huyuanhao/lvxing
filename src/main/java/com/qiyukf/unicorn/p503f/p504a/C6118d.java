package com.qiyukf.unicorn.p503f.p504a;

import android.content.Context;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.f.a.d */
public abstract class C6118d implements MsgAttachment {
    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
    }

    public boolean countToUnread() {
        return false;
    }

    public final void fromJson(JSONObject jSONObject) {
        C6109b.m24269a((Object) this, jSONObject);
        afterParse(jSONObject);
    }

    public String getContent(Context context) {
        return context.getString(C5961R.string.ysf_msg_notify_custom_default);
    }
}
