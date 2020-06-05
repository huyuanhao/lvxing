package com.qiyukf.nimlib.sdk;

import android.content.Context;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;

public class NIMClient {
    public static <T> T getService(Class<T> cls) {
        return C5718b.m23010a(cls);
    }

    public static StatusCode getStatus() {
        return C5743d.m23120e();
    }

    public static void init(Context context, LoginInfo loginInfo, SDKOptions sDKOptions, boolean z) {
        C5718b.m23012a(context, loginInfo, sDKOptions, z);
    }

    public static void updateStatusBarNotificationConfig(StatusBarNotificationConfig statusBarNotificationConfig) {
        C5718b.m23014a(statusBarNotificationConfig);
    }
}
