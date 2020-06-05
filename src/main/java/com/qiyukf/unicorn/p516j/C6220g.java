package com.qiyukf.unicorn.p516j;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6130k;

/* renamed from: com.qiyukf.unicorn.j.g */
public final class C6220g {
    /* renamed from: a */
    public static String m24654a(IMMessage iMMessage) {
        if (iMMessage.getDirect() != MsgDirectionEnum.Out) {
            return null;
        }
        if ((iMMessage.getMsgType() == MsgTypeEnum.text || iMMessage.getMsgType() == MsgTypeEnum.image || (iMMessage.getAttachment() instanceof C6130k)) && C5366b.m22034b(iMMessage.getExtension(), "auditResult") == 1) {
            return "消息包含违禁信息，发送失败";
        }
        return null;
    }
}
