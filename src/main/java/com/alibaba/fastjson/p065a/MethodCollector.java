package com.alibaba.fastjson.p065a;

/* renamed from: com.alibaba.fastjson.a.g */
public class MethodCollector {
    /* renamed from: a */
    protected boolean f2566a;
    /* renamed from: b */
    private final int f2567b;
    /* renamed from: c */
    private final int f2568c;
    /* renamed from: d */
    private int f2569d;
    /* renamed from: e */
    private final StringBuffer f2570e = new StringBuffer();

    protected MethodCollector(int i, int i2) {
        this.f2568c = i;
        this.f2567b = i2;
        boolean z = false;
        this.f2569d = 0;
        if (i2 == 0) {
            z = true;
        }
        this.f2566a = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11029a(String str, int i) {
        int i2 = this.f2568c;
        if (i >= i2 && i < i2 + this.f2567b) {
            StringBuilder sb = new StringBuilder();
            sb.append("arg");
            sb.append(this.f2569d);
            if (!str.equals(sb.toString())) {
                this.f2566a = true;
            }
            this.f2570e.append(',');
            this.f2570e.append(str);
            this.f2569d++;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo11028a() {
        return this.f2570e.length() != 0 ? this.f2570e.substring(1) : "";
    }
}
