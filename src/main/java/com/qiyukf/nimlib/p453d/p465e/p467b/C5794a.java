package com.qiyukf.nimlib.p453d.p465e.p467b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import com.qiyukf.nimlib.p453d.p454a.p458d.C5760b;
import com.qiyukf.nimlib.p453d.p465e.p467b.C5797b.C5798a;
import com.tencent.mid.core.Constants;

/* renamed from: com.qiyukf.nimlib.d.e.b.a */
public final class C5794a {
    /* renamed from: a */
    private C5796a f18440a;
    /* renamed from: b */
    private Context f18441b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f18442c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public String f18443d;
    /* renamed from: e */
    private BroadcastReceiver f18444e = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && C5760b.m23157a(context, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
                    String typeName = z ? activeNetworkInfo.getTypeName() : null;
                    if (C5794a.this.f18442c != z) {
                        C5794a.this.f18442c = z;
                        C5794a.this.f18443d = typeName;
                        C5794a.m23276b(C5794a.this, z);
                    } else if (C5794a.this.f18442c && !typeName.equals(C5794a.this.f18443d)) {
                        C5794a.this.f18443d = typeName;
                        C5794a.this.m23271a(C5798a.f18451f);
                    }
                }
            }
        }
    };

    /* renamed from: com.qiyukf.nimlib.d.e.b.a$a */
    public interface C5796a {
        /* renamed from: a */
        void mo28074a(int i);
    }

    public C5794a(Context context, C5796a aVar) {
        this.f18441b = context;
        this.f18440a = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23271a(int i) {
        C5796a aVar = this.f18440a;
        if (aVar != null) {
            aVar.mo28074a(i);
        }
        if (this.f18442c) {
            StringBuilder sb = new StringBuilder("network type changed to: ");
            sb.append(this.f18443d);
            C5753a.m23144a(sb.toString());
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m23276b(C5794a aVar, boolean z) {
        aVar.m23271a(z ? C5798a.f18450e : C5798a.f18449d);
    }

    /* renamed from: a */
    public final void mo28076a() {
        if (!C5760b.m23157a(this.f18441b, Constants.PERMISSION_ACCESS_NETWORK_STATE)) {
            C5753a.m23144a("unable to startup ConnectivityWatcher, as without permission");
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f18441b.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            this.f18442c = z;
            this.f18443d = this.f18442c ? activeNetworkInfo.getTypeName() : null;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f18441b.registerReceiver(this.f18444e, intentFilter);
    }

    /* renamed from: b */
    public final void mo28077b() {
        this.f18441b.unregisterReceiver(this.f18444e);
    }
}
