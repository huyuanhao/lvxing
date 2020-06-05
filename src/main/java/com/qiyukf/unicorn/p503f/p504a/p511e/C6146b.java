package com.qiyukf.unicorn.p503f.p504a.p511e;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;

@C6111b(mo29052a = 26)
/* renamed from: com.qiyukf.unicorn.f.a.e.b */
public class C6146b extends C6144e {
    @C6110a(mo29051a = "sessionid")
    /* renamed from: a */
    private long f19215a;
    @C6110a(mo29051a = "message")
    /* renamed from: b */
    private String f19216b;

    /* renamed from: a */
    public final void mo29179a(long j) {
        this.f19215a = j;
    }

    /* renamed from: a */
    public final void mo29180a(String str) {
        this.f19216b = str;
    }

    public String getContent(Context context) {
        if (!TextUtils.isEmpty(this.f19216b)) {
            return this.f19216b;
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(context.getString(C5961R.string.ysf_msg_quit_session_tips));
        sb.append("]");
        return sb.toString();
    }
}
