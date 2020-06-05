package com.qiyukf.nimlib.p473h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.nimlib.p473h.p478b.C5878c.C5879a;

/* renamed from: com.qiyukf.nimlib.h.c */
public final class C5885c {
    /* renamed from: a */
    C5887a f18635a;
    /* renamed from: b */
    Context f18636b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f18637c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public String f18638d;
    /* renamed from: e */
    private BroadcastReceiver f18639e = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
                String typeName = z ? activeNetworkInfo.getTypeName() : null;
                if (C5885c.this.f18637c != z) {
                    C5885c.this.f18637c = z;
                    C5885c.this.f18638d = typeName;
                    C5885c.m23567b(C5885c.this, z);
                } else if (C5885c.this.f18637c && !typeName.equals(C5885c.this.f18638d)) {
                    C5885c.this.f18638d = typeName;
                    C5885c.this.m23562a(C5879a.f18613f);
                }
            }
        }
    };

    /* renamed from: com.qiyukf.nimlib.h.c$a */
    public interface C5887a {
        /* renamed from: a */
        void mo28220a(int i);
    }

    C5885c(Context context, C5887a aVar) {
        this.f18636b = context.getApplicationContext();
        this.f18635a = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23562a(int i) {
        C5887a aVar = this.f18635a;
        if (aVar != null) {
            aVar.mo28220a(i);
        }
        if (this.f18637c) {
            StringBuilder sb = new StringBuilder("network type changed to: ");
            sb.append(this.f18638d);
            C5264a.m21617a("core", sb.toString());
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m23567b(C5885c cVar, boolean z) {
        cVar.m23562a(z ? C5879a.f18612e : C5879a.f18611d);
    }

    /* renamed from: a */
    public final boolean mo28216a() {
        return this.f18637c || C5411c.m22136c(this.f18636b);
    }

    /* renamed from: b */
    public final void mo28217b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f18636b.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        this.f18637c = z;
        this.f18638d = this.f18637c ? activeNetworkInfo.getTypeName() : null;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f18636b.registerReceiver(this.f18639e, intentFilter);
    }

    /* renamed from: c */
    public final void mo28218c() {
        try {
            this.f18636b.unregisterReceiver(this.f18639e);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder("unregisterReceiver error: ");
            sb.append(e.toString());
            C5264a.m21622c("ConnectivityWatcher", sb.toString());
        }
    }
}
