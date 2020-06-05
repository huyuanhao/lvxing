package com.qiyukf.nimlib.p450b;

import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: com.qiyukf.nimlib.b.a */
abstract class C5720a {
    /* renamed from: a */
    boolean f18280a = false;
    /* renamed from: b */
    boolean f18281b = true;
    /* renamed from: c */
    boolean f18282c = true;
    /* renamed from: d */
    boolean f18283d = true;

    C5720a() {
    }

    /* renamed from: a */
    private static String m23030a(boolean z) {
        return z ? "1" : "0";
    }

    /* renamed from: a */
    private static boolean mo27975a(String str) {
        return !"0".equals(str);
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo27968a(String str, String str2) {
        String str3 = "read sdk config from ";
        if (TextUtils.isEmpty(str)) {
            String d = mo27972d();
            StringBuilder sb = new StringBuilder(str3);
            sb.append(str2);
            sb.append(", but get null");
            C5264a.m21617a(d, sb.toString());
            return;
        }
        String[] split = str.split(StorageInterface.KEY_SPLITER);
        if (split.length == 4) {
            this.f18280a = mo27975a(split[0]);
            this.f18281b = mo27975a(split[1]);
            this.f18282c = mo27975a(split[2]);
            this.f18283d = mo27975a(split[3]);
            String d2 = mo27972d();
            StringBuilder sb2 = new StringBuilder(str3);
            sb2.append(str2);
            sb2.append(", ");
            sb2.append(toString());
            C5264a.m21617a(d2, sb2.toString());
        }
    }

    /* renamed from: a */
    public boolean mo27969a() {
        return this.f18281b;
    }

    /* renamed from: b */
    public abstract String mo27970b();

    /* renamed from: c */
    public String mo27971c() {
        StringBuilder sb = new StringBuilder();
        sb.append(m23030a(this.f18280a));
        String str = StorageInterface.KEY_SPLITER;
        sb.append(str);
        sb.append(m23030a(this.f18281b));
        sb.append(str);
        sb.append(m23030a(this.f18282c));
        sb.append(str);
        sb.append(m23030a(this.f18283d));
        return sb.toString();
    }

    /* access modifiers changed from: final */
    /* renamed from: d */
    public final String mo27972d() {
        StringBuilder sb = new StringBuilder("sdk_config_");
        sb.append(mo27970b());
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("sdk config=[");
        sb.append(mo27971c());
        sb.append("]");
        return sb.toString();
    }
}
