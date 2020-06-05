package com.qiyukf.unicorn.api.msg;

import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomMessageConfig;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.p514h.C6185c;
import java.io.File;

public class UnicornMessageBuilder {
    public static IMMessage buildAppCustomMessage(MsgAttachment msgAttachment) {
        return MessageBuilder.createCustomMessageForType(C6185c.m24533a(), SessionTypeEnum.Ysf, null, msgAttachment, null, MsgTypeEnum.appCustom);
    }

    public static IMMessage buildCustomMessage(MsgAttachment msgAttachment) {
        return buildCustomMessage(C6185c.m24533a(), null, msgAttachment, null);
    }

    public static IMMessage buildCustomMessage(String str, MsgAttachment msgAttachment) {
        return buildCustomMessage(str, null, msgAttachment, null);
    }

    public static IMMessage buildCustomMessage(String str, String str2, MsgAttachment msgAttachment, CustomMessageConfig customMessageConfig) {
        return MessageBuilder.createCustomMessage(str, SessionTypeEnum.Ysf, str2, msgAttachment, customMessageConfig);
    }

    public static final IMMessage buildImageMessage(String str, File file, String str2) {
        return MessageBuilder.createImageMessage(str, SessionTypeEnum.Ysf, file, file.getName());
    }

    public static final IMMessage buildTextMessage(String str, String str2) {
        return MessageBuilder.createTextMessage(str, SessionTypeEnum.Ysf, str2);
    }

    public static String getSessionId() {
        return C6185c.m24533a();
    }
}
