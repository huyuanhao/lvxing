package com.p368pw.inner.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.p368pw.inner.base.p387d.C5205o;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.pw.inner.base.c */
public class C5139c {
    /* renamed from: a */
    private Context f16798a;
    /* renamed from: b */
    private AlarmManager f16799b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Set<C5141a> f16800c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Set<C5141a> f16801d;

    /* renamed from: com.pw.inner.base.c$a */
    public interface C5141a {
        /* renamed from: b */
        void mo26725b();
    }

    /* renamed from: com.pw.inner.base.c$b */
    private static class C5142b {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5139c f16803a = new C5139c();
    }

    /* renamed from: a */
    public static C5139c m21256a() {
        return C5142b.f16803a;
    }

    /* renamed from: d */
    private void m21259d() {
        C51401 r0 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                StringBuilder sb = new StringBuilder();
                sb.append("ac: ");
                sb.append(action);
                C5205o.m21462a(sb.toString());
                if ("com.action.sys.day".equals(action)) {
                    for (C5141a b : C5139c.this.f16800c) {
                        b.mo26725b();
                    }
                }
                if ("com.action.sys.four".equals(action)) {
                    for (C5141a b2 : C5139c.this.f16801d) {
                        b2.mo26725b();
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.action.sys.day");
        intentFilter.addAction("com.action.sys.four");
        this.f16798a.registerReceiver(r0, intentFilter);
    }

    /* renamed from: a */
    public void mo26745a(Context context) {
        this.f16798a = context.getApplicationContext();
        if (this.f16800c == null) {
            this.f16800c = new HashSet();
        }
        if (this.f16801d == null) {
            this.f16801d = new HashSet();
        }
        this.f16799b = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        mo26747b();
        mo26748c();
        m21259d();
    }

    /* renamed from: a */
    public void mo26746a(C5141a aVar) {
        if (this.f16800c == null) {
            this.f16800c = new HashSet();
        }
        this.f16800c.add(aVar);
    }

    /* renamed from: b */
    public void mo26747b() {
        Intent intent = new Intent();
        intent.setAction("com.action.sys.day");
        try {
            this.f16799b.setInexactRepeating(0, System.currentTimeMillis(), 28800000, PendingIntent.getBroadcast(this.f16798a, 0, intent, 134217728));
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: c */
    public void mo26748c() {
        Intent intent = new Intent();
        intent.setAction("com.action.sys.four");
        try {
            this.f16799b.setInexactRepeating(0, System.currentTimeMillis(), 14400000, PendingIntent.getBroadcast(this.f16798a, 0, intent, 134217728));
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
