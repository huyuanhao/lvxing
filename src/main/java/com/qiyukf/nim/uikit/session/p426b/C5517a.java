package com.qiyukf.nim.uikit.session.p426b;

import com.qiyukf.nim.uikit.common.media.p420a.C5447b;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;

/* renamed from: com.qiyukf.nim.uikit.session.b.a */
public class C5517a implements C5447b {
    /* renamed from: a */
    private IMMessage f17790a;

    public C5517a(IMMessage iMMessage) {
        this.f17790a = iMMessage;
    }

    /* renamed from: a */
    public final long mo27450a() {
        return ((AudioAttachment) this.f17790a.getAttachment()).getDuration();
    }

    /* renamed from: a */
    public final boolean mo27451a(C5447b bVar) {
        if (C5517a.class.isInstance(bVar)) {
            return this.f17790a.isTheSame(((C5517a) bVar).f17790a);
        }
        return false;
    }

    /* renamed from: b */
    public final String mo27452b() {
        return ((AudioAttachment) this.f17790a.getAttachment()).getPath();
    }

    /* renamed from: c */
    public final IMMessage mo27623c() {
        return this.f17790a;
    }
}
