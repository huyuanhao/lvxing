package com.qiyukf.nim.uikit.session.viewholder;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.f */
public class C5632f extends C5622b {
    /* renamed from: a */
    private TextView f18133a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo27822a() {
        return this.message.getContent();
    }

    /* access modifiers changed from: protected */
    public void bindContentView() {
        if (TextUtils.isEmpty(mo27822a())) {
            this.f18133a.setVisibility(8);
            return;
        }
        this.f18133a.setVisibility(0);
        C5543f.m22546a(this.context, this.f18133a, mo27822a(), this.message.getSessionId());
        this.f18133a.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_notification;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f18133a = (TextView) this.view.findViewById(C5961R.C5963id.ysf_message_item_notification_label);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.tipsTextSize > 0.0f) {
                this.f18133a.setTextSize(uICustomization.tipsTextSize);
            }
            if (uICustomization.tipsTextColor != 0) {
                this.f18133a.setTextColor(uICustomization.tipsTextColor);
            }
        }
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
