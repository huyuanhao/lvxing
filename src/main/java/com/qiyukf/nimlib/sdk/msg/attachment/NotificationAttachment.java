package com.qiyukf.nimlib.sdk.msg.attachment;

import com.qiyukf.nimlib.sdk.msg.constant.NotificationType;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import org.json.JSONObject;

public abstract class NotificationAttachment implements MsgAttachment {
    private NotificationType type;

    public boolean countToUnread() {
        return false;
    }

    public final void fromJson(String str) {
    }

    public NotificationType getType() {
        return this.type;
    }

    public abstract void parse(JSONObject jSONObject);

    public void setType(NotificationType notificationType) {
        this.type = notificationType;
    }

    public String toJson(boolean z) {
        return null;
    }
}
