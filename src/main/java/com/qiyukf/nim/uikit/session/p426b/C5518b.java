package com.qiyukf.nim.uikit.session.p426b;

import android.content.Context;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nim.uikit.common.media.p420a.C5442a;
import com.qiyukf.nim.uikit.common.media.p420a.C5442a.C5446b;
import com.qiyukf.nim.uikit.common.media.p420a.C5447b;
import com.qiyukf.nim.uikit.common.p419a.C5437d;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.b.b */
public class C5518b extends C5442a<IMMessage> {
    /* renamed from: j */
    private static C5518b f17791j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean f17792k = false;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public C5437d f17793l = null;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public IMMessage f17794m = null;

    private C5518b(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m22469a(IMMessage iMMessage, int i, boolean z, long j) {
        if (C5946c.m23838a()) {
            if (mo27430a(new C5517a(iMMessage), i, z, j) && m22471a(iMMessage)) {
                iMMessage.setStatus(MsgStatusEnum.read);
                ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, false);
            }
        } else {
            C5415g.m22165b(C5961R.string.ysf_audio_record_sdcard_not_exist_error);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m22470a(C5518b bVar, C5437d dVar, IMMessage iMMessage) {
        List a = dVar.mo27381a();
        int i = 0;
        while (true) {
            if (i >= a.size()) {
                i = 0;
                break;
            } else if (((IMMessage) a.get(i)).equals(iMMessage)) {
                break;
            } else {
                i++;
            }
        }
        while (true) {
            if (i >= a.size()) {
                i = -1;
                break;
            } else if (m22471a((IMMessage) a.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            IMMessage iMMessage2 = (IMMessage) a.get(i);
            AudioAttachment audioAttachment = (AudioAttachment) iMMessage2.getAttachment();
            if (!(f17791j == null || audioAttachment == null)) {
                if (iMMessage2.getAttachStatus() == AttachStatusEnum.transferred) {
                    if (iMMessage2.getStatus() != MsgStatusEnum.read) {
                        iMMessage2.setStatus(MsgStatusEnum.read);
                        ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage2, false);
                    }
                    f17791j.m22469a(iMMessage2, bVar.mo27431b(), false, 0);
                    bVar.f17794m = iMMessage2;
                    dVar.notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        bVar.mo27625a(false, (C5437d) null, (IMMessage) null);
        return false;
    }

    /* renamed from: a */
    private static boolean m22471a(IMMessage iMMessage) {
        return iMMessage.getMsgType() == MsgTypeEnum.audio && iMMessage.getDirect() == MsgDirectionEnum.In && iMMessage.getAttachStatus() == AttachStatusEnum.transferred && iMMessage.getStatus() != MsgStatusEnum.read;
    }

    /* renamed from: i */
    public static C5518b m22478i() {
        if (f17791j == null) {
            synchronized (C5518b.class) {
                if (f17791j == null) {
                    f17791j = new C5518b(C5433b.m22189a());
                }
            }
        }
        return f17791j;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27429a(C5447b bVar) {
        this.f17449d.setOnPlayListener(new C5446b(this.f17449d, bVar) {
            public final void onCompletion() {
                if (mo27444a()) {
                    C5518b.this.mo27434c();
                    boolean z = false;
                    if (!(!C5518b.this.f17792k || C5518b.this.f17793l == null || C5518b.this.f17794m == null)) {
                        C5518b bVar = C5518b.this;
                        z = C5518b.m22470a(bVar, bVar.f17793l, C5518b.this.f17794m);
                    }
                    if (!z) {
                        C5518b bVar2 = C5518b.this;
                        bVar2.mo27433b(bVar2.f17450e);
                        C5518b.this.mo27427a();
                    }
                }
            }

            public final void onError(String str) {
                if (mo27444a()) {
                    super.onError(str);
                    C5518b.this.mo27625a(false, (C5437d) null, (IMMessage) null);
                }
            }

            public final void onInterrupt() {
                if (mo27444a()) {
                    super.onInterrupt();
                    C5518b.this.mo27625a(false, (C5437d) null, (IMMessage) null);
                }
            }
        });
    }

    /* renamed from: a */
    public final void mo27624a(IMMessage iMMessage, int i) {
        m22469a(iMMessage, i, true, 500);
    }

    /* renamed from: a */
    public final void mo27625a(boolean z, C5437d dVar, IMMessage iMMessage) {
        this.f17792k = z;
        this.f17793l = dVar;
        this.f17794m = iMMessage;
    }

    /* renamed from: e */
    public final void mo27436e() {
        super.mo27436e();
        mo27625a(false, (C5437d) null, (IMMessage) null);
    }

    /* renamed from: j */
    public final IMMessage mo27626j() {
        if (!mo27435d() || !C5517a.class.isInstance(this.f17450e)) {
            return null;
        }
        return ((C5517a) this.f17450e).mo27623c();
    }
}
