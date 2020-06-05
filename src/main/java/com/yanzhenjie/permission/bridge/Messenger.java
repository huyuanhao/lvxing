package com.yanzhenjie.permission.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.yanzhenjie.permission.AndPermission;

/* renamed from: com.yanzhenjie.permission.bridge.c */
class Messenger extends BroadcastReceiver {
    /* renamed from: a */
    private final Context f26648a;
    /* renamed from: b */
    private final C7831a f26649b;

    /* compiled from: Messenger */
    /* renamed from: com.yanzhenjie.permission.bridge.c$a */
    public interface C7831a {
        /* renamed from: a */
        void mo38043a();
    }

    /* renamed from: a */
    public static void m34041a(Context context, String str) {
        context.sendBroadcast(new Intent(AndPermission.m33994a(context, str)));
    }

    public Messenger(Context context, C7831a aVar) {
        this.f26648a = context;
        this.f26649b = aVar;
    }

    /* renamed from: a */
    public void mo38041a(String str) {
        this.f26648a.registerReceiver(this, new IntentFilter(AndPermission.m33994a(this.f26648a, str)));
    }

    /* renamed from: a */
    public void mo38040a() {
        this.f26648a.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        this.f26649b.mo38043a();
    }
}
