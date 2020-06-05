package com.qiyukf.unicorn.api.pop;

import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.SessionStatusEnum;
import java.io.Serializable;

public interface Session extends Serializable {
    String getContactId();

    String getContent();

    MsgStatusEnum getMsgStatus();

    SessionStatusEnum getSessionStatus();

    long getTime();

    int getUnreadCount();
}
