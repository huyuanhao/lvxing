package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import java.io.Serializable;

public interface MsgAttachment extends Serializable {
    boolean countToUnread();

    String getContent(Context context);

    String toJson(boolean z);
}
