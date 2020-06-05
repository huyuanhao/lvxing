package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.widget.TextView;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nim.uikit.session.helper.C5566e;
import com.qiyukf.nim.uikit.session.viewholder.C5635h;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6103n;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6106b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6107c;

/* renamed from: com.qiyukf.unicorn.ui.b.a.r */
public class C6294r extends C5635h {
    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27828a(TextView textView) {
        MsgAttachment attachment = this.message.getAttachment();
        String str = attachment instanceof C6103n ? ((C6103n) attachment).mo29037c() : attachment instanceof C6107c ? ((C6107c) attachment).mo29048d() : attachment instanceof C6106b ? ((C6106b) attachment).mo29044c() : "";
        textView.setText(C5566e.m22593a(this.context, (CharSequence) C5543f.m22544a(this.context, str, this.message.getSessionId())));
    }
}
