package com.qiyukf.nim.uikit.session.viewholder;

import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6119a;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6133n;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6135p;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.j */
public class C5638j extends C5632f {
    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final String mo27822a() {
        MsgAttachment attachment = this.message.getAttachment();
        return attachment instanceof C6119a ? ((C6119a) attachment).mo29076a(this.context).toString() : attachment instanceof C6135p ? ((C6135p) attachment).mo29146a() : attachment instanceof C6133n ? ((C6133n) attachment).mo29141d() : this.message.getContent();
    }
}
