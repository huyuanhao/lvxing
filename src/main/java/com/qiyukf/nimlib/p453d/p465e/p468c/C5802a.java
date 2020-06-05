package com.qiyukf.nimlib.p453d.p465e.p468c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.qiyukf.nimlib.d.e.c.a */
public final class C5802a {
    /* renamed from: a */
    private Context f18457a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public C5804a f18458b;
    /* renamed from: c */
    private BroadcastReceiver f18459c = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction()) && C5802a.this.f18458b != null) {
                    C5802a.this.f18458b.mo28075a();
                }
            }
        }
    };

    /* renamed from: com.qiyukf.nimlib.d.e.c.a$a */
    public interface C5804a {
        /* renamed from: a */
        void mo28075a();
    }

    public C5802a(Context context, C5804a aVar) {
        this.f18457a = context;
        this.f18458b = aVar;
    }

    /* renamed from: a */
    public final void mo28099a() {
        Context context = this.f18457a;
        if (context != null) {
            context.registerReceiver(this.f18459c, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        }
    }

    /* renamed from: b */
    public final void mo28100b() {
        Context context = this.f18457a;
        if (context != null) {
            context.unregisterReceiver(this.f18459c);
        }
    }
}
