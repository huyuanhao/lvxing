package com.qiyukf.nimlib.p485i;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;

/* renamed from: com.qiyukf.nimlib.i.g */
public final class C5923g {

    /* renamed from: com.qiyukf.nimlib.i.g$1 */
    static /* synthetic */ class C59241 {
        /* renamed from: a */
        static final /* synthetic */ int[] f18717a = new int[SessionTypeEnum.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
            com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum[] r0 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f18717a = r0
            int[] r0 = f18717a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r1 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.Team     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f18717a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r1 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.P2P     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f18717a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r1 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.Ysf     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p485i.C5923g.C59241.m50096clinit():void");
        }
    }

    /* renamed from: a */
    public static int m23758a(SessionTypeEnum sessionTypeEnum) {
        int i = C59241.f18717a[sessionTypeEnum.ordinal()];
        if (i == 1) {
            return 101;
        }
        if (i == 2) {
            return 100;
        }
        if (i == 3) {
            return 102;
        }
        C5264a.m21617a("SYSMSG", "unknown session type to system msg type");
        return 100;
    }

    /* renamed from: a */
    public static C5925h m23759a(C5912a aVar) {
        return m23761a(aVar, aVar.getStatus(), 0);
    }

    /* renamed from: a */
    public static C5925h m23760a(C5912a aVar, int i) {
        return m23761a(aVar, aVar.getStatus(), i);
    }

    /* renamed from: a */
    private static C5925h m23761a(C5912a aVar, MsgStatusEnum msgStatusEnum, int i) {
        String sessionId = aVar.getSessionId();
        if (TextUtils.isEmpty(sessionId)) {
            return null;
        }
        C5925h hVar = new C5925h();
        hVar.mo28342a(aVar.getSessionId());
        hVar.mo28345b(aVar.getFromAccount());
        hVar.mo28346c(aVar.getUuid());
        hVar.mo28347d(m23764a((IMMessage) aVar));
        hVar.mo28339a(aVar.getSessionType());
        hVar.mo28338a(aVar.getTime());
        hVar.setMsgStatus(aVar.getStatus());
        hVar.mo28344b(aVar.mo28297b());
        boolean z = false;
        hVar.mo28348e(aVar.mo28291a(false));
        hVar.setMsgStatus(msgStatusEnum);
        C5925h a = C5922f.m23743a(sessionId, aVar.getSessionType());
        if (a != null) {
            if (aVar.getDirect() == MsgDirectionEnum.In) {
                z = true;
            }
            if (z) {
                hVar.mo28337a(i + a.getUnreadCount());
            }
            hVar.setTag(a.getTag());
        } else {
            hVar.mo28337a(i);
        }
        C5922f.m23752a(hVar);
        return hVar;
    }

    /* renamed from: a */
    public static C5925h m23762a(String str, SessionTypeEnum sessionTypeEnum) {
        C5925h hVar = new C5925h();
        hVar.mo28342a(str);
        String str2 = "";
        hVar.mo28346c(str2);
        hVar.mo28347d(str2);
        hVar.mo28339a(sessionTypeEnum);
        hVar.mo28338a(0);
        hVar.setMsgStatus(MsgStatusEnum.success);
        hVar.mo28348e(str2);
        hVar.mo28337a(0);
        C5922f.m23752a(hVar);
        return hVar;
    }

    /* renamed from: a */
    public static MsgTypeEnum m23763a(int i) {
        MsgTypeEnum[] values;
        for (MsgTypeEnum msgTypeEnum : MsgTypeEnum.values()) {
            if (msgTypeEnum.getValue() == i) {
                return msgTypeEnum;
            }
        }
        return MsgTypeEnum.undef;
    }

    /* renamed from: a */
    public static String m23764a(IMMessage iMMessage) {
        int i;
        if (iMMessage.getMsgType() == MsgTypeEnum.text || iMMessage.getMsgType() == MsgTypeEnum.notification || iMMessage.getMsgType() == MsgTypeEnum.tips) {
            return iMMessage.getContent();
        }
        Context a = C5718b.m23009a();
        MsgAttachment attachment = iMMessage.getAttachment();
        if (attachment == null || a == null) {
            return iMMessage.getContent();
        }
        String content = attachment.getContent(a);
        if (TextUtils.isEmpty(content)) {
            i = C5961R.string.ysf_msg_notify_custom_default;
        } else {
            if (attachment instanceof ProductAttachment) {
                i = C5961R.string.ysf_msg_notify_custom_send;
            }
            return content;
        }
        content = a.getString(i);
        return content;
    }

    /* renamed from: a */
    public static String m23765a(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("_");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: b */
    public static C5925h m23766b(C5912a aVar) {
        return m23761a(aVar, MsgStatusEnum.fail, 0);
    }
}
