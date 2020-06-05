package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGBasicPushNotificationBuilder extends XGPushNotificationBuilder {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32769a(JSONObject jSONObject) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo32770b(JSONObject jSONObject) {
    }

    public String getType() {
        return XGPushNotificationBuilder.BASIC_NOTIFICATION_BUILDER_TYPE;
    }

    public Notification buildNotification(Context context) {
        return mo32904a(context);
    }
}
