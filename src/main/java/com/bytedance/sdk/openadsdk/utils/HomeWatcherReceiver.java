package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HomeWatcherReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private C2529a f9103a;

    /* renamed from: com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver$a */
    public interface C2529a {
        /* renamed from: E */
        void mo14804E();

        /* renamed from: F */
        void mo14805F();
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            StringBuilder sb = new StringBuilder();
            sb.append("onReceive: action: ");
            sb.append(action);
            String str = "HomeReceiver";
            Log.i(str, sb.toString());
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("reason: ");
                sb2.append(stringExtra);
                Log.i(str, sb2.toString());
                String str2 = "homekey";
                if (str2.equals(stringExtra)) {
                    Log.i(str, str2);
                    C2529a aVar = this.f9103a;
                    if (aVar != null) {
                        aVar.mo14804E();
                    }
                } else if ("recentapps".equals(stringExtra)) {
                    Log.i(str, "long press home key or activity switch");
                    C2529a aVar2 = this.f9103a;
                    if (aVar2 != null) {
                        aVar2.mo14805F();
                    }
                } else {
                    String str3 = "assist";
                    if (str3.equals(stringExtra)) {
                        Log.i(str, str3);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo16894a(C2529a aVar) {
        this.f9103a = aVar;
    }
}
