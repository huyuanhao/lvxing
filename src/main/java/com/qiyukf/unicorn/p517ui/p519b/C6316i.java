package com.qiyukf.unicorn.p517ui.p519b;

import android.widget.TextView;
import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6127h;

/* renamed from: com.qiyukf.unicorn.ui.b.i */
public class C6316i extends C5622b {
    /* renamed from: a */
    private TextView f19695a;
    /* renamed from: b */
    private C6127h f19696b;

    /* access modifiers changed from: protected */
    public void bindContentView() {
        this.progressBar.setVisibility(8);
        this.f19696b = (C6127h) this.message.getAttachment();
        this.f19695a.setText(this.f19696b.mo29113a());
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_withdrawal_notify;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19695a = (TextView) findViewById(C5961R.C5963id.ysf_tv_msg_item_withdrawal_text);
    }

    /* access modifiers changed from: protected */
    public boolean isMiddleItem() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean showAvatar() {
        return false;
    }
}
