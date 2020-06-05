package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor.C1754a;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.manager.e */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    /* renamed from: a */
    final C1754a f4866a;
    /* renamed from: b */
    boolean f4867b;
    /* renamed from: c */
    private final Context f4868c;
    /* renamed from: d */
    private boolean f4869d;
    /* renamed from: e */
    private final BroadcastReceiver f4870e = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean z = DefaultConnectivityMonitor.this.f4867b;
            DefaultConnectivityMonitor eVar = DefaultConnectivityMonitor.this;
            eVar.f4867b = eVar.mo13161a(context);
            if (z != DefaultConnectivityMonitor.this.f4867b) {
                String str = "ConnectivityMonitor";
                if (Log.isLoggable(str, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("connectivity changed, isConnected: ");
                    sb.append(DefaultConnectivityMonitor.this.f4867b);
                    Log.d(str, sb.toString());
                }
                DefaultConnectivityMonitor.this.f4866a.mo12605a(DefaultConnectivityMonitor.this.f4867b);
            }
        }
    };

    public void onDestroy() {
    }

    DefaultConnectivityMonitor(Context context, C1754a aVar) {
        this.f4868c = context.getApplicationContext();
        this.f4866a = aVar;
    }

    /* renamed from: a */
    private void m6030a() {
        if (!this.f4869d) {
            this.f4867b = mo13161a(this.f4868c);
            try {
                this.f4868c.registerReceiver(this.f4870e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f4869d = true;
            } catch (SecurityException e) {
                String str = "ConnectivityMonitor";
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Failed to register", e);
                }
            }
        }
    }

    /* renamed from: b */
    private void m6031b() {
        if (this.f4869d) {
            this.f4868c.unregisterReceiver(this.f4870e);
            this.f4869d = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13161a(Context context) {
        boolean z = true;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.m6138a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                z = false;
            }
            return z;
        } catch (RuntimeException e) {
            String str = "ConnectivityMonitor";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Failed to determine connectivity status when connectivity changed", e);
            }
            return true;
        }
    }

    public void onStart() {
        m6030a();
    }

    public void onStop() {
        m6031b();
    }
}
