package com.qiyukf.unicorn.api.msg;

public interface OnPushMessageListener {
    void onReceive(UnicornMessage unicornMessage, PushMessageExtension pushMessageExtension);
}
