package com.tencent.otherpush.receiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;

/* compiled from: ProGuard */
public class MzReceiver extends MzPushMessageReceiver {
    public static final String TAG = "MzReceiver";

    public void onHandleIntent(Context context, Intent intent) {
    }

    public void onReceive(Context context, Intent intent) {
    }

    public void onRegister(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onRegister ");
        sb.append(str);
        Log.i(TAG, sb.toString());
    }

    public void onMessage(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMessage ");
        sb.append(str);
        Log.i(TAG, sb.toString());
    }

    public void onMessage(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMessage ");
        sb.append(intent);
        Log.i(TAG, sb.toString());
    }

    @Deprecated
    public void onUnRegister(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onUnRegister ");
        sb.append(z);
        Log.i(TAG, sb.toString());
    }

    public void onNotificationClicked(Context context, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("onNotificationClicked ");
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.i(TAG, sb.toString());
    }

    public void onNotificationArrived(Context context, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("onNotificationArrived ");
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.i(TAG, sb.toString());
    }

    public void onNotificationDeleted(Context context, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("onNotificationDeleted ");
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.i(TAG, sb.toString());
    }

    public void onNotifyMessageArrived(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onNotifyMessageArrived ");
        sb.append(str);
        Log.i(TAG, sb.toString());
    }

    public void onPushStatus(Context context) {
        Log.i(TAG, "onPushStatus ");
    }

    public void onRegisterStatus(Context context) {
        Log.i(TAG, "onRegisterStatus ");
    }

    public void onUnRegisterStatus(Context context) {
        Log.i(TAG, "onUnRegisterStatus ");
    }

    public void onSubTagsStatus(Context context) {
        Log.i(TAG, "onSubTagsStatus ");
    }

    public void onSubAliasStatus(Context context) {
        Log.i(TAG, "onSubAliasStatus ");
    }

    public void onUpdateNotificationBuilder() {
        Log.i(TAG, "onUpdateNotificationBuilder ");
    }
}
