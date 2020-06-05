package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import java.io.Serializable;

/* compiled from: ProGuard */
public class XGPushClickedResult implements XGIResult, Serializable {
    public static final int NOTIFACTION_CLICKED_TYPE = NotificationAction.clicked.getType();
    public static final int NOTIFACTION_DELETED_TYPE = NotificationAction.delete.getType();
    public static final int NOTIFACTION_DOWNLOAD_CANCEL_TYPE = NotificationAction.download_cancel.getType();
    public static final int NOTIFACTION_DOWNLOAD_TYPE = NotificationAction.download.getType();
    public static final int NOTIFACTION_OPEN_CANCEL_TYPE = NotificationAction.open_cancel.getType();
    public static final int NOTIFACTION_OPEN_TYPE = NotificationAction.open.getType();
    public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
    private static final long serialVersionUID = 5485267763104201539L;
    int actionType;
    String activityName;
    String content;
    String customContent;
    long msgId = 0;
    int notificationActionType;
    int pushChannel;
    String title;

    public XGPushClickedResult() {
        String str = "";
        this.title = str;
        this.content = str;
        this.customContent = str;
        this.activityName = str;
        this.actionType = NotificationAction.clicked.getType();
        this.notificationActionType = NotificationAction.activity.getType();
        this.pushChannel = 0;
    }

    public int getPushChannel() {
        return this.pushChannel;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getCustomContent() {
        return this.customContent;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public long getActionType() {
        return (long) this.actionType;
    }

    public int getNotificationActionType() {
        return this.notificationActionType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XGPushClickedResult [msgId=");
        sb.append(this.msgId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", customContent=");
        sb.append(this.customContent);
        sb.append(", activityName=");
        sb.append(this.activityName);
        sb.append(", actionType=");
        sb.append(this.actionType);
        sb.append(", notificationActionType");
        sb.append(this.notificationActionType);
        sb.append("]");
        return sb.toString();
    }

    public void parseIntent(Intent intent) {
        this.msgId = intent.getLongExtra(MessageKey.MSG_ID, -1);
        this.activityName = intent.getStringExtra(Constants.FLAG_ACTIVITY_NAME);
        this.title = Rijndael.decrypt(intent.getStringExtra("title"));
        this.content = Rijndael.decrypt(intent.getStringExtra(MessageKey.MSG_CONTENT));
        this.customContent = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        this.actionType = intent.getIntExtra("action", NotificationAction.clicked.getType());
        this.notificationActionType = intent.getIntExtra(Constants.FLAG_NOTIFICATION_ACTION_TYPE, NotificationAction.activity.getType());
    }
}
