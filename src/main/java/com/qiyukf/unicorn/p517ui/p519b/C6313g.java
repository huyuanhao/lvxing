package com.qiyukf.unicorn.p517ui.p519b;

import android.widget.TextView;
import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6146b;

/* renamed from: com.qiyukf.unicorn.ui.b.g */
public class C6313g extends C5622b {
    /* renamed from: a */
    private TextView f19691a;

    /* access modifiers changed from: protected */
    public void bindContentView() {
        MsgAttachment attachment = this.message.getAttachment();
        if (attachment instanceof C6146b) {
            this.f19691a.setText(((C6146b) attachment).getContent(this.context));
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_separator;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19691a = (TextView) findViewById(C5961R.C5963id.ysf_message_item_separator_text);
    }

    /* access modifiers changed from: protected */
    public boolean isMiddleItem() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean showAvatar() {
        return false;
    }
}
