package epco;

import android.text.TextUtils;
import epco.C7978k.C7980b;
import java.util.List;

/* renamed from: epco.m */
public class C7984m implements C7982l {
    /* renamed from: a */
    private StringBuilder f27111a = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    /* renamed from: b */
    private C7978k f27112b = new C7978k();
    /* renamed from: c */
    private boolean f27113c;
    /* renamed from: d */
    private int f27114d;

    /* renamed from: a */
    private void m34551a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f27111a.append(9);
        }
    }

    /* renamed from: a */
    private void m34552a(C7970g0 g0Var) {
        this.f27111a.append(' ');
        String a = this.f27112b.mo38369a(g0Var.mo38343b());
        if (a == null) {
            a = g0Var.mo38343b();
        }
        if (a != null && !TextUtils.isEmpty(a)) {
            StringBuilder sb = this.f27111a;
            sb.append(a);
            sb.append(':');
        }
        String a2 = C7966e1.m34468a(g0Var.mo38349e());
        StringBuilder sb2 = this.f27111a;
        sb2.append(g0Var.mo38339a());
        sb2.append('=');
        sb2.append('\"');
        sb2.append(a2);
        sb2.append('\"');
    }

    /* renamed from: a */
    public String mo38385a() {
        return this.f27111a.toString();
    }

    /* renamed from: a */
    public void mo38312a(C7975i0 i0Var) {
        m34551a(this.f27114d);
        StringBuilder sb = this.f27111a;
        sb.append(i0Var.mo38367c());
        sb.append(10);
        this.f27113c = false;
    }

    /* renamed from: a */
    public void mo38313a(C7981k0 k0Var) {
        this.f27112b.mo38371a(k0Var);
    }

    /* renamed from: a */
    public void mo38314a(C7983l0 l0Var) {
        this.f27112b.mo38372a(l0Var);
    }

    /* renamed from: a */
    public void mo38315a(C7985m0 m0Var) {
        StringBuilder sb;
        String str;
        this.f27114d--;
        if (this.f27113c) {
            sb = this.f27111a;
            str = " />\n";
        } else {
            m34551a(this.f27114d);
            this.f27111a.append("</");
            if (m0Var.mo38388b() != null) {
                StringBuilder sb2 = this.f27111a;
                sb2.append(m0Var.mo38388b());
                sb2.append(':');
            }
            this.f27111a.append(m0Var.mo38386a());
            sb = this.f27111a;
            str = ">\n";
        }
        sb.append(str);
        this.f27113c = false;
    }

    /* renamed from: a */
    public void mo38316a(C7989o0 o0Var) {
        if (this.f27113c) {
            this.f27111a.append(">\n");
        }
        int i = this.f27114d;
        this.f27114d = i + 1;
        m34551a(i);
        this.f27111a.append('<');
        if (o0Var.mo38407c() != null) {
            String a = this.f27112b.mo38369a(o0Var.mo38407c());
            if (a != null) {
                StringBuilder sb = this.f27111a;
                sb.append(a);
                sb.append(':');
            } else {
                StringBuilder sb2 = this.f27111a;
                sb2.append(o0Var.mo38407c());
                sb2.append(':');
            }
        }
        this.f27111a.append(o0Var.mo38405b());
        List<C7980b> a2 = this.f27112b.mo38370a();
        if (!a2.isEmpty()) {
            for (C7980b bVar : a2) {
                StringBuilder sb3 = this.f27111a;
                sb3.append(" xmlns:");
                sb3.append(bVar.f27105a);
                sb3.append("=\"");
                sb3.append(bVar.f27106b);
                sb3.append("\"");
            }
        }
        this.f27113c = true;
        for (C7970g0 a3 : o0Var.mo38402a().mo38356b()) {
            m34552a(a3);
        }
    }
}
