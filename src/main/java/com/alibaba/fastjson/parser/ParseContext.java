package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

/* renamed from: com.alibaba.fastjson.parser.g */
public class ParseContext {
    /* renamed from: a */
    public Object f2794a;
    /* renamed from: b */
    public final ParseContext f2795b;
    /* renamed from: c */
    public final Object f2796c;
    /* renamed from: d */
    public Type f2797d;
    /* renamed from: e */
    private transient String f2798e;

    public ParseContext(ParseContext gVar, Object obj, Object obj2) {
        this.f2795b = gVar;
        this.f2794a = obj;
        this.f2796c = obj2;
    }

    public String toString() {
        if (this.f2798e == null) {
            if (this.f2795b == null) {
                this.f2798e = "$";
            } else if (this.f2796c instanceof Integer) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f2795b.toString());
                sb.append("[");
                sb.append(this.f2796c);
                sb.append("]");
                this.f2798e = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f2795b.toString());
                sb2.append(".");
                sb2.append(this.f2796c);
                this.f2798e = sb2.toString();
            }
        }
        return this.f2798e;
    }
}
