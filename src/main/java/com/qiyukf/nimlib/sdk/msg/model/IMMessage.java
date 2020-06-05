package com.qiyukf.nimlib.sdk.msg.model;

import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.UnicornMessage;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;

public interface IMMessage extends UnicornMessage {
    AttachStatusEnum getAttachStatus();

    MsgDirectionEnum getDirect();

    String getExt();

    String getFromAccount();

    SessionTypeEnum getSessionType();

    MsgStatusEnum getStatus();

    String getUuid();

    boolean isTheSame(IMMessage iMMessage);

    void setAttachStatus(AttachStatusEnum attachStatusEnum);

    void setAttachment(MsgAttachment msgAttachment);

    void setContent(String str);

    void setDirect(MsgDirectionEnum msgDirectionEnum);

    void setExt(String str);

    void setFromAccount(String str);

    void setStatus(MsgStatusEnum msgStatusEnum);

    void setTime(long j);
}
