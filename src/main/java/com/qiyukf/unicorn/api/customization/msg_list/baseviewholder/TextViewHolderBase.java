package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nim.uikit.session.helper.C5566e;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.p514h.C6185c;
import org.json.JSONObject;

public abstract class TextViewHolderBase extends UnicornMessageViewHolder {
    public final void bindContentView(IMMessage iMMessage, Context context) {
        String str;
        SpannableStringBuilder a = C5566e.m22593a(context, (CharSequence) C6185c.m24531a(iMMessage) == 2 ? C5543f.m22544a(context, iMMessage.getContent(), iMMessage.getSessionId()) : C5543f.m22542a(context, iMMessage.getContent()));
        JSONObject f = C5366b.m22040f(iMMessage.getExtension(), "action");
        String str2 = null;
        if (f != null) {
            String str3 = "label";
            str2 = !TextUtils.isEmpty(C5366b.m22039e(f, str3)) ? C5366b.m22039e(f, str3) : "知道了";
            str = C5366b.m22039e(f, "url");
        } else {
            str = null;
        }
        bindTextMsgView(context, a, str2, str);
    }

    public abstract void bindTextMsgView(Context context, CharSequence charSequence, String str, String str2);
}
