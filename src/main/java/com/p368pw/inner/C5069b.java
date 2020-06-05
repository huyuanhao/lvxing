package com.p368pw.inner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5206p;
import com.p368pw.inner.base.p387d.C5208r;
import java.util.HashSet;

/* renamed from: com.pw.inner.b */
public class C5069b {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static String f16577a = "key_istl_pkg_loc";
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static String f16578b = ";";
    /* access modifiers changed from: private */
    /* renamed from: c */
    public String f16579c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Context f16580d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public HashSet<String> f16581e;

    /* renamed from: com.pw.inner.b$a */
    private static class C5072a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C5069b f16584a = new C5069b();
    }

    private C5069b() {
        this.f16581e = new HashSet<>();
    }

    /* renamed from: a */
    public static C5069b m21115a() {
        return C5072a.f16584a;
    }

    /* renamed from: c */
    private void m21122c(String str) {
        if (!TextUtils.isEmpty(this.f16579c)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f16579c);
            sb.append(f16578b);
            sb.append(str);
            str = sb.toString();
        }
        this.f16579c = str;
        C5206p.m21471a(this.f16580d, f16577a, this.f16579c);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21123d(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && this.f16581e.contains(str)) {
            this.f16581e.remove(str);
            if (!TextUtils.isEmpty(this.f16579c)) {
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (String str2 : this.f16579c.split(f16578b)) {
                    if (!str.equals(str2)) {
                        if (z) {
                            sb.append(str2);
                            z = false;
                        } else {
                            sb.append(f16578b);
                            sb.append(str2);
                        }
                    }
                }
                this.f16579c = sb.toString();
                C5206p.m21471a(this.f16580d, f16577a, this.f16579c);
            }
        }
    }

    /* renamed from: a */
    public void mo26581a(Context context) {
        this.f16580d = context.getApplicationContext();
        C5208r.m21482b(new Runnable() {
            public void run() {
                C5069b bVar = C5069b.this;
                bVar.f16579c = C5206p.m21472b(bVar.f16580d, C5069b.f16577a);
                if (!TextUtils.isEmpty(C5069b.this.f16579c)) {
                    String[] split = C5069b.this.f16579c.split(C5069b.f16578b);
                    if (split.length != 0) {
                        for (String str : split) {
                            if (!TextUtils.isEmpty(str)) {
                                C5069b.this.f16581e.add(str);
                            }
                        }
                    }
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.f16580d.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                try {
                    if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
                        Uri data = intent.getData();
                        if (data != null) {
                            C5069b.this.m21123d(data.getSchemeSpecificPart());
                        }
                    }
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                }
            }
        }, intentFilter);
    }

    /* renamed from: a */
    public void mo26582a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f16581e.add(str);
            m21122c(str);
        }
    }

    /* renamed from: b */
    public boolean mo26583b(String str) {
        return this.f16581e.contains(str);
    }
}
