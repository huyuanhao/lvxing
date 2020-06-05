package com.jiayouya.travel.module.p294xg;

import android.content.Context;
import com.elvishew.xlog.XLog;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushRegisterResult;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import kotlin.Metadata;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/xg/XGPushReceiver;", "Lcom/tencent/android/tpush/XGPushBaseReceiver;", "()V", "onDeleteTagResult", "", "p0", "Landroid/content/Context;", "p1", "", "p2", "", "onNotifactionClickedResult", "context", "message", "Lcom/tencent/android/tpush/XGPushClickedResult;", "onNotifactionShowedResult", "Lcom/tencent/android/tpush/XGPushShowedResult;", "onRegisterResult", "Lcom/tencent/android/tpush/XGPushRegisterResult;", "onSetTagResult", "onTextMessage", "Lcom/tencent/android/tpush/XGPushTextMessage;", "onUnregisterResult", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: XGPushReceiver.kt */
/* renamed from: com.jiayouya.travel.module.xg.XGPushReceiver */
public final class XGPushReceiver extends XGPushBaseReceiver {
    public void onDeleteTagResult(Context context, int i, String str) {
    }

    public void onNotifactionShowedResult(Context context, XGPushShowedResult xGPushShowedResult) {
    }

    public void onRegisterResult(Context context, int i, XGPushRegisterResult xGPushRegisterResult) {
    }

    public void onSetTagResult(Context context, int i, String str) {
    }

    public void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage) {
    }

    public void onUnregisterResult(Context context, int i) {
    }

    public void onNotifactionClickedResult(Context context, XGPushClickedResult xGPushClickedResult) {
        XLog.m12691a("onNotificationClickedResult");
    }
}
