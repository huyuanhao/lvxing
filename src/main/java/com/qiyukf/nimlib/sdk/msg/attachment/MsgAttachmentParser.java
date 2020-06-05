package com.qiyukf.nimlib.sdk.msg.attachment;

import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import java.io.Serializable;

public interface MsgAttachmentParser extends Serializable {
    MsgAttachment parse(String str);
}
