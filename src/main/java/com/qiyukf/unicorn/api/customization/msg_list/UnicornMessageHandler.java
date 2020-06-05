package com.qiyukf.unicorn.api.customization.msg_list;

import android.content.Context;
import com.qiyukf.unicorn.api.msg.UnicornMessage;

public interface UnicornMessageHandler {
    boolean onMessage(Context context, UnicornMessage unicornMessage, boolean z);
}
