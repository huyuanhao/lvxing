package com.tencent.otherpush.receiver;

import android.content.Context;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

/* compiled from: ProGuard */
public class XmReceiver extends PushMessageReceiver {
    public void onReceivePassThroughMessage(Context context) {
        System.err.println("onReceivePassThroughMessage");
    }

    public void onNotificationMessageClicked(Context context) {
        System.err.println("onNotificationMessageClicked");
    }

    public void onNotificationMessageArrived(Context context) {
        System.err.println("onNotificationMessageArrived");
    }

    public void onCommandResult(Context context) {
        System.err.println("onCommandResult");
    }

    public void onReceiveRegisterResult(Context context) {
        System.err.println("onReceiveRegisterResult");
    }

    public void onReceiveMessage(Context context) {
        System.err.println("onReceiveRegisterResult");
    }
}
