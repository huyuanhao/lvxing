package com.qiyukf.nimlib.p485i;

import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a.C5293c;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5298c;
import com.qiyukf.basesdk.p412c.p416c.C5405c;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.p436c.p440d.C5681d;
import com.qiyukf.nimlib.p429a.p436c.p440d.C5682e;
import com.qiyukf.nimlib.p429a.p436c.p441e.C5684b;
import com.qiyukf.nimlib.p429a.p449f.C5713a;
import com.qiyukf.nimlib.p429a.p449f.C5715c;
import com.qiyukf.nimlib.p469e.C5805a;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p469e.C5817i;
import com.qiyukf.nimlib.p473h.C5905e;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;

/* renamed from: com.qiyukf.nimlib.i.d */
public final class C5916d {
    /* renamed from: a */
    public static C5293c m23719a(final FileAttachment fileAttachment, final C5817i iVar) {
        m23724a(fileAttachment);
        return C5290a.m21719a().mo27154a(fileAttachment.getPath(), fileAttachment.getMd5(), iVar, new C5298c<C5817i>() {
            /* access modifiers changed from: private */
            /* renamed from: b */
            public void mo27170a(int i) {
                iVar.mo28111a(i);
                C5805a.m23315c(iVar);
            }

            /* renamed from: a */
            public final /* synthetic */ void mo27169a() {
                mo27170a(400);
            }

            /* renamed from: a */
            public final /* synthetic */ void mo27171a(long j, long j2) {
                C5808b.m23322a(fileAttachment.getPath(), j, j2);
            }

            /* renamed from: a */
            public final /* synthetic */ void mo27172a(String str) {
                fileAttachment.setUrl(str);
                iVar.mo28116b((Object) fileAttachment);
                C5805a.m23315c(iVar);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public static void m23721a(final com.qiyukf.nimlib.p485i.C5912a r7, final boolean r8, final com.qiyukf.nimlib.p469e.C5817i r9, boolean r10) {
        /*
        java.lang.String r0 = r7.getSessionId()
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 != 0) goto L_0x00bb
        r0 = 1
        r1 = 0
        if (r8 == 0) goto L_0x0023
        java.lang.String r2 = r7.getUuid()
        long r2 = com.qiyukf.nimlib.p485i.C5922f.m23754b(r2)
        r7.mo28293a(r2)
        r4 = 0
        int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r6 <= 0) goto L_0x0021
        r2 = 1
        goto L_0x0024
    L_0x0021:
        r2 = 0
        goto L_0x0024
    L_0x0023:
        r2 = r8
    L_0x0024:
        if (r10 == 0) goto L_0x003d
        com.qiyukf.unicorn.api.msg.MsgStatusEnum r10 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.fail
        if (r2 == 0) goto L_0x002e
        com.qiyukf.nimlib.p485i.C5922f.m23756b(r7, r10)
        goto L_0x0031
    L_0x002e:
        com.qiyukf.nimlib.p485i.C5922f.m23751a(r7, r10)
    L_0x0031:
        com.qiyukf.nimlib.i.h r10 = com.qiyukf.nimlib.p485i.C5923g.m23766b(r7)
        com.qiyukf.unicorn.api.msg.MsgStatusEnum r2 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.sending
        r10.setMsgStatus(r2)
        com.qiyukf.nimlib.p469e.C5808b.m23321a(r10)
    L_0x003d:
        com.qiyukf.nimlib.i.b r10 = com.qiyukf.nimlib.p485i.C5913b.m23694a()
        java.lang.String r2 = r7.getUuid()
        r10.mo28325a(r2)
        com.qiyukf.unicorn.api.msg.attachment.MsgAttachment r10 = r7.getAttachment()
        if (r10 == 0) goto L_0x00b4
        boolean r2 = r10 instanceof com.qiyukf.unicorn.api.msg.attachment.FileAttachment
        if (r2 != 0) goto L_0x0053
        goto L_0x00b4
    L_0x0053:
        com.qiyukf.unicorn.api.msg.attachment.FileAttachment r10 = (com.qiyukf.unicorn.api.msg.attachment.FileAttachment) r10
        java.lang.String r2 = r10.getUrl()
        boolean r2 = android.text.TextUtils.isEmpty(r2)
        if (r2 != 0) goto L_0x0074
        boolean r2 = r10 instanceof com.qiyukf.unicorn.api.msg.attachment.AudioAttachment
        if (r2 == 0) goto L_0x00b4
        com.qiyukf.unicorn.api.msg.attachment.AudioAttachment r10 = (com.qiyukf.unicorn.api.msg.attachment.AudioAttachment) r10
        boolean r2 = r10.getAutoTransform()
        if (r2 == 0) goto L_0x00b4
        com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum r1 = com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum.transferring
        r7.setAttachStatus(r1)
        m23726b(r10, r7, r9)
        goto L_0x00b5
    L_0x0074:
        com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum r1 = com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum.transferring
        r7.setAttachStatus(r1)
        java.lang.String r1 = r10.getExtension()
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        if (r1 == 0) goto L_0x0096
        boolean r1 = r10 instanceof com.qiyukf.unicorn.api.msg.attachment.ImageAttachment
        if (r1 == 0) goto L_0x008a
        java.lang.String r1 = "jpg"
        goto L_0x0093
    L_0x008a:
        boolean r1 = r10 instanceof com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment
        if (r1 == 0) goto L_0x0091
        java.lang.String r1 = "mp4"
        goto L_0x0093
    L_0x0091:
        java.lang.String r1 = ""
    L_0x0093:
        r10.setExtension(r1)
    L_0x0096:
        m23724a(r10)
        com.qiyukf.unicorn.api.msg.attachment.MsgAttachment r10 = r7.getAttachment()
        com.qiyukf.unicorn.api.msg.attachment.FileAttachment r10 = (com.qiyukf.unicorn.api.msg.attachment.FileAttachment) r10
        java.lang.String r1 = r10.getPath()
        com.qiyukf.basesdk.b.a.b.a r2 = com.qiyukf.basesdk.p394b.p395a.p397b.C5290a.m21719a()
        java.lang.String r3 = r10.getMd5()
        com.qiyukf.nimlib.i.d$2 r4 = new com.qiyukf.nimlib.i.d$2
        r4.m50092init(r7, r10, r8, r9)
        r2.mo27154a(r1, r3, r9, r4)
        goto L_0x00b5
    L_0x00b4:
        r0 = 0
    L_0x00b5:
        if (r0 != 0) goto L_0x00ba
        m23725b(r7, r8, r9)
    L_0x00ba:
        return
    L_0x00bb:
        java.lang.String r7 = "core"
        java.lang.String r8 = "no message receiver"
        com.qiyukf.basesdk.p393a.C5264a.m21622c(r7, r8)
        java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
        java.lang.String r8 = "Receiver cannot be null"
        r7.<init>(r8)
        throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p485i.C5916d.m23721a(com.qiyukf.nimlib.i.a, boolean, com.qiyukf.nimlib.e.i, boolean):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m23722a(IMMessage iMMessage) {
        iMMessage.setStatus(MsgStatusEnum.fail);
        iMMessage.setAttachStatus(AttachStatusEnum.fail);
        C5808b.m23320a(iMMessage);
        C5913b.m23694a().mo28327b(iMMessage.getUuid());
    }

    /* renamed from: a */
    private static void m23724a(FileAttachment fileAttachment) {
        if (TextUtils.isEmpty(fileAttachment.getMd5())) {
            fileAttachment.setMd5(C5405c.m22115b(fileAttachment.getPath()));
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m23725b(C5912a aVar, boolean z, C5817i iVar) {
        C5682e eVar;
        int i;
        if (aVar.getSessionType() == SessionTypeEnum.P2P) {
            eVar = new C5682e();
        } else if (aVar.getSessionType() == SessionTypeEnum.Ysf) {
            eVar = new C5684b();
        } else {
            throw new IllegalArgumentException("support Ysf message only");
        }
        C5892b bVar = new C5892b();
        int i2 = C59241.f18717a[aVar.getSessionType().ordinal()];
        if (i2 != 1) {
            if (!(i2 == 2 || i2 == 3)) {
                C5264a.m21617a("SYSMSG", "unknown session type to system msg type");
            }
            i = 0;
        } else {
            i = 1;
        }
        bVar.mo28240a(0, i);
        bVar.mo28241a(1, aVar.getSessionId());
        bVar.mo28241a(9, aVar.getContent());
        bVar.mo28240a(8, aVar.getMsgType().getValue());
        bVar.mo28241a(11, aVar.getUuid());
        String a = aVar.mo28291a(true);
        if (!TextUtils.isEmpty(a)) {
            bVar.mo28241a(10, a);
        }
        if (z) {
            bVar.mo28240a(13, 1);
        }
        if (aVar.getSessionId().equals(C5718b.m23015b())) {
            bVar.mo28241a(5, C5905e.m23645a());
        }
        if (aVar.mo28302d() != null) {
            if (!aVar.mo28302d().enableHistory) {
                bVar.mo28240a(100, 0);
            }
            if (!aVar.mo28302d().enableRoaming) {
                bVar.mo28240a(101, 0);
            }
            if (!aVar.mo28302d().enableSelfSync) {
                bVar.mo28240a(102, 0);
            }
        }
        eVar.mo27871a(iVar);
        eVar.mo27889a(bVar);
        C5668c.m22861a().mo27866a((C5715c) new C5681d(eVar, C5713a.f18255b));
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m23726b(final AudioAttachment audioAttachment, final C5912a aVar, final C5817i iVar) {
        ((MsgService) NIMClient.getService(MsgService.class)).transVoiceToText(audioAttachment.getUrl(), audioAttachment.getPath(), audioAttachment.getDuration()).setCallback(new RequestCallback() {
            public final void onException(Throwable th) {
                C5916d.m23722a((IMMessage) aVar);
            }

            public final void onFailed(int i) {
                C5916d.m23722a((IMMessage) aVar);
            }

            public final void onSuccess(Object obj) {
                audioAttachment.setText(obj.toString());
                aVar.setAttachment(audioAttachment);
                ((MsgService) NIMClient.getService(MsgService.class)).updateMessage(aVar, true);
                C5912a aVar = new C5912a();
                aVar.mo28296a(aVar.getUuid());
                aVar.mo28299b(aVar.getSessionId());
                aVar.setFromAccount(C5718b.m23015b());
                aVar.setDirect(MsgDirectionEnum.Out);
                aVar.setStatus(MsgStatusEnum.sending);
                aVar.mo28294a(aVar.getSessionType());
                aVar.setTime(aVar.getTime());
                aVar.mo28293a(aVar.mo28290a());
                aVar.mo28292a(MsgTypeEnum.text.getValue());
                aVar.setContent(obj.toString());
                C5916d.m23725b(aVar, false, iVar);
            }
        });
    }
}
