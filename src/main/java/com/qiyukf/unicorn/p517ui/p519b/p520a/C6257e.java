package com.qiyukf.unicorn.p517ui.p519b.p520a;

import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.OnBotEventListener;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5969b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6107c;

/* renamed from: com.qiyukf.unicorn.ui.b.a.e */
public abstract class C6257e extends C5622b {
    /* renamed from: a */
    public abstract void mo29445a();

    /* renamed from: a */
    public final void mo29448a(String str) {
        OnBotEventListener onBotEventListener = C6029d.m24045e().onBotEventListener;
        if (onBotEventListener != null) {
            onBotEventListener.onUrlClick(this.context, str);
        }
    }

    /* renamed from: a */
    public void mo29449a(String str, String str2) {
    }

    /* renamed from: a */
    public final void mo29450a(String str, String str2, String str3) {
        C6107c cVar = new C6107c();
        cVar.mo29046a(str3);
        C5969b bVar = new C5969b();
        String str4 = "";
        if (str == null) {
            str = str4;
        }
        bVar.mo28519a(str);
        if (str2 == null) {
            str2 = str4;
        }
        bVar.mo28521b(str2);
        bVar.mo28520a(cVar.mo29047c());
        cVar.mo28536a(bVar);
        getAdapter().mo27734d().mo27727c(MessageBuilder.createCustomMessage(this.message.getSessionId(), SessionTypeEnum.Ysf, cVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo29451b() {
        return true;
    }

    /* access modifiers changed from: protected|final */
    public final void bindContentView() {
        if (mo29451b() && this.contentContainer.getChildCount() == 1) {
            this.contentContainer.getChildAt(0).setBackgroundResource(isReceivedMessage() ? C5961R.C5962drawable.ysf_message_left_bg_no_padding_selector : C5961R.C5962drawable.ysf_message_right_bg_no_padding_selector);
        }
        mo29445a();
    }

    /* renamed from: c */
    public void mo29452c() {
    }

    /* access modifiers changed from: protected|final */
    public final int leftBackground() {
        return 0;
    }

    /* access modifiers changed from: protected|final */
    public final int rightBackground() {
        return 0;
    }
}
