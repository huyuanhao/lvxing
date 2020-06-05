package com.bytedance.tea.crash.p218e.p219a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.bytedance.tea.crash.e.a.d */
class BatteryWatcher {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public int f9315a;

    /* compiled from: BatteryWatcher */
    /* renamed from: com.bytedance.tea.crash.e.a.d$a */
    private class C2582a extends BroadcastReceiver {
        private C2582a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                BatteryWatcher.this.f9315a = (int) ((((float) intent.getIntExtra("level", 0)) * 100.0f) / ((float) intent.getIntExtra("scale", 100)));
            }
        }
    }

    BatteryWatcher(Context context) {
        try {
            m12439a(context);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m12439a(Context context) {
        context.registerReceiver(new C2582a(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    /* renamed from: a */
    public int mo17039a() {
        return this.f9315a;
    }
}
