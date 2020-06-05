package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;

/* compiled from: ProGuard */
public class XGPushShowedResult implements XGIResult {
    public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
    public static final int NOTIFICATION_ACTION_INTENT = NotificationAction.intent.getType();
    public static final int NOTIFICATION_ACTION_INTENT_WIHT_ACTION = NotificationAction.intent_with_action.getType();
    public static final int NOTIFICATION_ACTION_PACKAGE = NotificationAction.action_package.getType();
    public static final int NOTIFICATION_ACTION_URL = NotificationAction.url.getType();
    /* renamed from: a */
    long f22815a = 0;
    /* renamed from: b */
    String f22816b;
    /* renamed from: c */
    String f22817c;
    /* renamed from: d */
    String f22818d;
    /* renamed from: e */
    String f22819e;
    /* renamed from: f */
    int f22820f;
    /* renamed from: g */
    int f22821g;
    /* renamed from: h */
    int f22822h;

    public XGPushShowedResult() {
        String str = "";
        this.f22816b = str;
        this.f22817c = str;
        this.f22818d = str;
        this.f22819e = str;
        this.f22820f = 0;
        this.f22821g = NotificationAction.activity.getType();
        this.f22822h = 0;
    }

    public int getPushChannel() {
        return this.f22822h;
    }

    public int getNotifactionId() {
        return this.f22820f;
    }

    public long getMsgId() {
        return this.f22815a;
    }

    public String getTitle() {
        return this.f22816b;
    }

    public String getContent() {
        return this.f22817c;
    }

    public String getCustomContent() {
        return this.f22818d;
    }

    public String getActivity() {
        return this.f22819e;
    }

    public int getNotificationActionType() {
        return this.f22821g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XGPushShowedResult [msgId=");
        sb.append(this.f22815a);
        sb.append(", title=");
        sb.append(this.f22816b);
        sb.append(", content=");
        sb.append(this.f22817c);
        sb.append(", customContent=");
        sb.append(this.f22818d);
        sb.append(", activity=");
        sb.append(this.f22819e);
        sb.append(", notificationActionType");
        sb.append(this.f22821g);
        sb.append("]");
        return sb.toString();
    }

    public void parseIntent(Intent intent) {
        this.f22815a = intent.getLongExtra(MessageKey.MSG_ID, -1);
        this.f22819e = intent.getStringExtra(Constants.FLAG_ACTIVITY_NAME);
        this.f22816b = Rijndael.decrypt(intent.getStringExtra("title"));
        this.f22817c = Rijndael.decrypt(intent.getStringExtra(MessageKey.MSG_CONTENT));
        this.f22821g = intent.getIntExtra(Constants.FLAG_NOTIFICATION_ACTION_TYPE, NotificationAction.activity.getType());
        this.f22818d = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        this.f22820f = intent.getIntExtra(MessageKey.NOTIFACTION_ID, 0);
    }
}
