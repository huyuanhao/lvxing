package com.alibaba.fastjson.p065a;

/* renamed from: com.alibaba.fastjson.a.d */
public final class FieldWriter {
    /* renamed from: a */
    FieldWriter f2549a;
    /* renamed from: b */
    private final int f2550b;
    /* renamed from: c */
    private final int f2551c;
    /* renamed from: d */
    private final int f2552d;

    /* renamed from: a */
    public void mo11020a() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo11022b() {
        return 8;
    }

    public FieldWriter(ClassWriter cVar, int i, String str, String str2) {
        if (cVar.f2540j == null) {
            cVar.f2540j = this;
        } else {
            cVar.f2541k.f2549a = this;
        }
        cVar.f2541k = this;
        this.f2550b = i;
        this.f2551c = cVar.mo11012a(str);
        this.f2552d = cVar.mo11012a(str2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11021a(ByteVector aVar) {
        aVar.mo11008b(this.f2550b & -393217).mo11008b(this.f2551c).mo11008b(this.f2552d);
        aVar.mo11008b(0);
    }
}
