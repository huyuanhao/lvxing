package com.qiyukf.nimlib.p450b;

import android.content.Context;
import android.content.SharedPreferences;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5407d;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p470f.C5837d;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.b.b */
public final class C5721b extends C5720a {

    /* renamed from: com.qiyukf.nimlib.b.b$a */
    private static class C5722a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C5721b f18284a = new C5721b(0);
    }

    private C5721b() {
        this.f18280a = m23038a("loc");
        this.f18281b = m23038a("wifi");
        this.f18282c = m23038a("ipc_ack");
        this.f18283d = m23038a("self_kill");
        String d = mo27972d();
        StringBuilder sb = new StringBuilder("read sdk config from SP, ");
        sb.append(toString());
        C5264a.m21617a(d, sb.toString());
    }

    /* synthetic */ C5721b(byte b) {
        this();
    }

    /* renamed from: a */
    private static void m23037a(String str, boolean z) {
        C5407d.m22128a(m23040f(), str, z);
    }

    /* renamed from: a */
    private static boolean m23038a(String str) {
        return m23040f().getBoolean(str, true);
    }

    /* renamed from: e */
    public static C5721b m23039e() {
        return C5722a.f18284a;
    }

    /* renamed from: f */
    private static SharedPreferences m23040f() {
        Context a = C5718b.m23009a();
        StringBuilder sb = new StringBuilder("NIMSDK_CONFIG_STRATEGY_");
        sb.append(C5718b.m23020g());
        return a.getSharedPreferences(sb.toString(), 0);
    }

    /* renamed from: a */
    public final void mo27974a(JSONObject jSONObject) {
        String str = "self_kill";
        String str2 = "ipc_ack";
        String str3 = "wifi";
        String str4 = "loc";
        if (jSONObject != null) {
            boolean z = false;
            try {
                if (jSONObject.has(str4)) {
                    boolean z2 = jSONObject.getBoolean(str4);
                    if (z2 != this.f18280a) {
                        this.f18280a = z2;
                        z = true;
                    }
                }
                if (jSONObject.has(str3)) {
                    boolean z3 = jSONObject.getBoolean(str3);
                    if (z3 != this.f18281b) {
                        this.f18281b = z3;
                        z = true;
                    }
                }
                if (jSONObject.has(str2)) {
                    boolean z4 = jSONObject.getBoolean(str2);
                    if (z4 != this.f18282c) {
                        this.f18282c = z4;
                        z = true;
                    }
                }
                if (jSONObject.has(str)) {
                    boolean z5 = jSONObject.getBoolean(str);
                    if (z5 != this.f18283d) {
                        this.f18283d = z5;
                        z = true;
                    }
                }
                String d = mo27972d();
                StringBuilder sb = new StringBuilder("read sdk config from lbs, ");
                sb.append(toString());
                sb.append(", changed=");
                sb.append(z);
                C5264a.m21617a(d, sb.toString());
                if (z) {
                    m23037a(str4, this.f18280a);
                    m23037a(str3, this.f18281b);
                    m23037a(str2, this.f18282c);
                    m23037a(str, this.f18283d);
                    String d2 = mo27972d();
                    StringBuilder sb2 = new StringBuilder("write sdk config to SP, ");
                    sb2.append(toString());
                    C5264a.m21617a(d2, sb2.toString());
                    C5837d.m23407b();
                    C5264a.m21617a(mo27972d(), "notify sdk config to UI...");
                }
            } catch (Throwable th) {
                String d3 = mo27972d();
                StringBuilder sb3 = new StringBuilder("read sdk config from lbs error, e=");
                sb3.append(th.getMessage());
                C5264a.m21617a(d3, sb3.toString());
            }
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo27969a() {
        return super.mo27969a();
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final String mo27970b() {
        return "push";
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ String mo27971c() {
        return super.mo27971c();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
