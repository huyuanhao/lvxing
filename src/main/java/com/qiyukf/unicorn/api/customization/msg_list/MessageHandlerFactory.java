package com.qiyukf.unicorn.api.customization.msg_list;

import com.qiyukf.unicorn.api.msg.UnicornMessage;

public interface MessageHandlerFactory {
    UnicornMessageHandler handlerOf(UnicornMessage unicornMessage);
}
