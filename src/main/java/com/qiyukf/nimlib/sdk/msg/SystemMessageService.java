package com.qiyukf.nimlib.sdk.msg;

import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.msg.constant.SystemMessageStatus;
import com.qiyukf.nimlib.sdk.msg.model.SystemMessage;
import java.util.List;

public interface SystemMessageService {
    void clearSystemMessages();

    void deleteSystemMessage(long j);

    InvocationFuture<Integer> querySystemMessageUnreadCount();

    int querySystemMessageUnreadCountBlock();

    InvocationFuture<List<SystemMessage>> querySystemMessages(int i, int i2);

    void resetSystemMessageUnreadCount();

    void setSystemMessageStatus(long j, SystemMessageStatus systemMessageStatus);
}
