package com.qiyukf.unicorn.api.msg;

import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import java.io.Serializable;
import org.json.JSONObject;

public interface UnicornMessage extends Serializable {
    MsgAttachment getAttachment();

    String getContent();

    JSONObject getExtension();

    MsgTypeEnum getMsgType();

    String getSessionId();

    long getTime();
}
