package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6119a;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6133n;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6135p;

public abstract class TipsViewHolderBase extends UnicornMessageViewHolder {
    private String getDisplayText() {
        MsgAttachment attachment = this.message.getAttachment();
        return attachment instanceof C6119a ? ((C6119a) attachment).mo29076a(this.context).toString() : attachment instanceof C6135p ? ((C6135p) attachment).mo29146a() : attachment instanceof C6133n ? ((C6133n) attachment).mo29141d() : this.message.getContent();
    }

    private void handleTextNotification(String str) {
        C5543f.m22546a(this.context, getMainTextView(), str, this.message.getSessionId());
        getMainTextView().setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void bindContentView(IMMessage iMMessage, Context context) {
        handleTextNotification(getDisplayText());
    }

    public abstract TextView getMainTextView();

    /* access modifiers changed from: protected */
    public boolean isMiddleItem() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean showAvatar() {
        return false;
    }
}
