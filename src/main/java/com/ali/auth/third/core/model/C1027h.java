package com.ali.auth.third.core.model;

import java.util.ArrayList;

/* renamed from: com.ali.auth.third.core.model.h */
public class C1027h {
    /* renamed from: a */
    public String f2048a;
    /* renamed from: b */
    public String f2049b;
    /* renamed from: c */
    public boolean f2050c = false;
    /* renamed from: d */
    public boolean f2051d = false;
    /* renamed from: e */
    public ArrayList<String> f2052e = new ArrayList<>();
    /* renamed from: f */
    public ArrayList<Object> f2053f = new ArrayList<>();

    /* renamed from: a */
    public void mo10372a(String str, Object obj) {
        this.f2052e.add(str);
        this.f2053f.add(obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RpcRequest [target=");
        sb.append(this.f2048a);
        sb.append(", version=");
        sb.append(this.f2049b);
        sb.append(", params=");
        sb.append("]");
        return sb.toString();
    }
}
