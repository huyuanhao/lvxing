package iko.dmaz.lloq;

import iko.dmaz.lloq.p654a.C8060b;
import java.util.List;

/* renamed from: iko.dmaz.lloq.b */
public abstract class C8062b {
    /* renamed from: a */
    protected String f27336a;
    /* renamed from: b */
    protected String f27337b;
    /* renamed from: c */
    protected String f27338c;
    /* renamed from: d */
    protected String f27339d;
    /* renamed from: e */
    protected String f27340e;

    public C8062b(String str, String str2, String str3) {
        this.f27336a = str;
        this.f27337b = str2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27337b);
        sb.append("/schema/register/schema/ip");
        this.f27338c = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f27337b);
        sb2.append("/schema/confired/schema");
        this.f27339d = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f27337b);
        sb3.append(str3);
        this.f27340e = sb3.toString();
    }

    /* renamed from: a */
    public abstract void mo38802a(String str);

    /* renamed from: a */
    public abstract void mo38803a(String str, String str2, int i, String str3);

    /* renamed from: a */
    public abstract void mo38804a(List<C8067e> list);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo38805b(String str) {
        return C8060b.m34878a(str, this.f27336a);
    }
}
