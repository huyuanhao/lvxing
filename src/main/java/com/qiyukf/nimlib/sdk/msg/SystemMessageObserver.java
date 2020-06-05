package com.qiyukf.nimlib.sdk.msg;

import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.model.SystemMessage;

public interface SystemMessageObserver {
    void observeReceiveSystemMsg(Observer<SystemMessage> observer, boolean z);

    void observeUnreadCountChange(Observer<Integer> observer, boolean z);
}
