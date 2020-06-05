package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.stat.p596a.C7066c;
import com.tencent.android.tpush.stat.p596a.C7067d;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import org.apache.http.HttpHost;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.a */
public class C7060a {
    /* renamed from: d */
    private static volatile C7060a f23456d;
    /* renamed from: a */
    private volatile int f23457a = 2;
    /* renamed from: b */
    private volatile String f23458b = "";
    /* renamed from: c */
    private volatile HttpHost f23459c = null;
    /* renamed from: e */
    private Context f23460e = null;
    /* renamed from: f */
    private C7067d f23461f = null;

    /* renamed from: a */
    public String mo34157a() {
        return this.f23458b;
    }

    private C7060a(Context context) {
        this.f23460e = context.getApplicationContext();
        C7082d.m30378a(context);
        this.f23461f = C7066c.m30259b();
        m30236f();
        mo34160d();
    }

    /* renamed from: b */
    public boolean mo34158b() {
        return this.f23457a == 1;
    }

    /* renamed from: c */
    public boolean mo34159c() {
        return this.f23457a != 0;
    }

    /* renamed from: a */
    public static C7060a m30235a(Context context) {
        if (f23456d == null) {
            synchronized (C7060a.class) {
                if (f23456d == null) {
                    f23456d = new C7060a(context);
                }
            }
        }
        return f23456d;
    }

    /* renamed from: f */
    private void m30236f() {
        this.f23457a = 0;
        this.f23459c = null;
        this.f23458b = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo34160d() {
        if (DeviceInfos.isNetworkAvailable(this.f23460e)) {
            this.f23458b = DeviceInfos.getLinkedWay(this.f23460e);
            if (C7070b.m30304b()) {
                C7067d dVar = this.f23461f;
                StringBuilder sb = new StringBuilder();
                sb.append("NETWORK name:");
                sb.append(this.f23458b);
                dVar.mo34169b((Object) sb.toString());
            }
            if (C7066c.m30262b(this.f23458b)) {
                if ("WIFI".equalsIgnoreCase(this.f23458b)) {
                    this.f23457a = 1;
                } else {
                    this.f23457a = 2;
                }
                this.f23459c = C7066c.m30261b(this.f23460e);
                return;
            }
            return;
        }
        if (C7070b.m30304b()) {
            this.f23461f.mo34169b((Object) "NETWORK TYPE: network is close.");
        }
        m30236f();
    }

    /* renamed from: e */
    public void mo34161e() {
        try {
            this.f23460e.getApplicationContext().registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    C7060a.this.mo34160d();
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th) {
            C6864a.m29302d("registerBroadcast", "", th);
        }
    }
}
