package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.horse.C6938d;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.C6973b;

/* compiled from: ProGuard */
public class XGPushReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f22806a = XGPushReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        if (!(context == null || intent == null || !C6914l.m29527h(context))) {
            String action = intent.getAction();
            if (action != null) {
                C6973b.m29774d(context.getApplicationContext());
                if (XGPushConfig.enableDebug) {
                    String str = f22806a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("PushReceiver received ");
                    sb.append(action);
                    sb.append(" @@ ");
                    sb.append(context.getPackageName());
                    C6864a.m29298c(str, sb.toString());
                }
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    C6938d.m29638a().mo33179a(intent);
                } else if (!Constants.ACTION_INTERNAL_PUSH_MESSAGE.equals(action) && !Constants.ACTION_SDK_INSTALL.equals(action)) {
                    C6973b.m29765a(context);
                }
            }
        }
    }
}
