package com.qiyukf.nimlib.p453d.p465e;

import android.content.SharedPreferences;
import com.qiyukf.basesdk.p412c.C5407d;
import com.qiyukf.nimlib.p453d.C5744a;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qiyukf.nimlib.d.e.c */
final class C5800c {
    /* renamed from: a */
    private Map<String, Long> f18455a;

    /* renamed from: com.qiyukf.nimlib.d.e.c$a */
    private static class C5801a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C5800c f18456a = new C5800c(0);
    }

    private C5800c() {
        this.f18455a = new HashMap(10);
        Map<String, Long> map = this.f18455a;
        Long valueOf = Long.valueOf(0);
        map.put("KEY_REFRESH_STRATEGY", valueOf);
        SharedPreferences k = m23283k();
        String str = "KEY_DEVICE";
        this.f18455a.put(str, Long.valueOf(k.getLong(str, 0)));
        String str2 = "KEY_OPERATOR";
        this.f18455a.put(str2, Long.valueOf(k.getLong(str2, 0)));
        String str3 = "KEY_APP_LIST";
        this.f18455a.put(str3, Long.valueOf(k.getLong(str3, 0)));
        String str4 = "KEY_APP_INFO";
        this.f18455a.put(str4, Long.valueOf(k.getLong(str4, 0)));
        String str5 = "KEY_WIFI_INFO";
        this.f18455a.put(str5, Long.valueOf(k.getLong(str5, 0)));
        String str6 = "KEY_WIFI_LIST";
        this.f18455a.put(str6, Long.valueOf(k.getLong(str6, 0)));
        String str7 = "KEY_GPS";
        this.f18455a.put(str7, Long.valueOf(k.getLong(str7, 0)));
        String str8 = "KEY_CELL";
        this.f18455a.put(str8, Long.valueOf(k.getLong(str8, 0)));
        this.f18455a.put("KEY_COLLECT_ALL", valueOf);
        StringBuilder sb = new StringBuilder("WatcherPreferences=");
        for (Entry entry : this.f18455a.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("; ");
        }
        C5753a.m23149f(sb.toString());
    }

    /* synthetic */ C5800c(byte b) {
        this();
    }

    /* renamed from: a */
    private long m23281a(String str) {
        Long l = (Long) this.f18455a.get(str);
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    /* renamed from: a */
    private void m23282a(String str, long j) {
        this.f18455a.put(str, Long.valueOf(j));
        C5407d.m22126a(m23283k(), str, j);
    }

    /* renamed from: k */
    private static SharedPreferences m23283k() {
        return C5744a.m23125d().mo28019a().getSharedPreferences("NIM_DC_WATCHER_SP", 0);
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final long mo28079a() {
        return ((Long) this.f18455a.get("KEY_REFRESH_STRATEGY")).longValue();
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo28080a(long j) {
        this.f18455a.put("KEY_REFRESH_STRATEGY", Long.valueOf(j));
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final long mo28081b() {
        return m23281a("KEY_DEVICE");
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final void mo28082b(long j) {
        String str = "KEY_DEVICE";
        if (j > m23281a(str)) {
            m23282a(str, j);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: c */
    public final long mo28083c() {
        return m23281a("KEY_OPERATOR");
    }

    /* access modifiers changed from: final */
    /* renamed from: c */
    public final void mo28084c(long j) {
        String str = "KEY_OPERATOR";
        if (j > m23281a(str)) {
            m23282a(str, j);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: d */
    public final long mo28085d() {
        return m23281a("KEY_APP_LIST");
    }

    /* access modifiers changed from: final */
    /* renamed from: d */
    public final void mo28086d(long j) {
        String str = "KEY_APP_LIST";
        if (j > m23281a(str)) {
            m23282a(str, j);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: e */
    public final long mo28087e() {
        return m23281a("KEY_APP_INFO");
    }

    /* access modifiers changed from: final */
    /* renamed from: e */
    public final void mo28088e(long j) {
        String str = "KEY_APP_INFO";
        if (j > m23281a(str)) {
            m23282a(str, j);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: f */
    public final long mo28089f() {
        return m23281a("KEY_WIFI_INFO");
    }

    /* access modifiers changed from: final */
    /* renamed from: f */
    public final void mo28090f(long j) {
        String str = "KEY_WIFI_INFO";
        if (j > m23281a(str)) {
            m23282a(str, j);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: g */
    public final long mo28091g() {
        return m23281a("KEY_WIFI_LIST");
    }

    /* access modifiers changed from: final */
    /* renamed from: g */
    public final void mo28092g(long j) {
        String str = "KEY_WIFI_LIST";
        if (j > m23281a(str)) {
            m23282a(str, j);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: h */
    public final long mo28093h() {
        return m23281a("KEY_GPS");
    }

    /* access modifiers changed from: final */
    /* renamed from: h */
    public final void mo28094h(long j) {
        String str = "KEY_GPS";
        if (j > m23281a(str)) {
            m23282a(str, j);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: i */
    public final long mo28095i() {
        return m23281a("KEY_CELL");
    }

    /* access modifiers changed from: final */
    /* renamed from: i */
    public final void mo28096i(long j) {
        String str = "KEY_CELL";
        if (j > m23281a(str)) {
            m23282a(str, j);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: j */
    public final long mo28097j() {
        return m23281a("KEY_COLLECT_ALL");
    }

    /* access modifiers changed from: final */
    /* renamed from: j */
    public final void mo28098j(long j) {
        this.f18455a.put("KEY_COLLECT_ALL", Long.valueOf(j));
    }
}
