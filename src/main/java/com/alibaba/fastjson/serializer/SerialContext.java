package com.alibaba.fastjson.serializer;

/* renamed from: com.alibaba.fastjson.serializer.av */
public class SerialContext {
    /* renamed from: a */
    public final SerialContext f2871a;
    /* renamed from: b */
    public final Object f2872b;
    /* renamed from: c */
    public final Object f2873c;
    /* renamed from: d */
    public final int f2874d;

    public SerialContext(SerialContext avVar, Object obj, Object obj2, int i, int i2) {
        this.f2871a = avVar;
        this.f2872b = obj;
        this.f2873c = obj2;
        this.f2874d = i;
    }

    public String toString() {
        if (this.f2871a == null) {
            return "$";
        }
        if (this.f2873c instanceof Integer) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f2871a.toString());
            sb.append("[");
            sb.append(this.f2873c);
            sb.append("]");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2871a.toString());
        sb2.append(".");
        sb2.append(this.f2873c);
        return sb2.toString();
    }
}
