package com.ali.auth.third.core.model;

/* renamed from: com.ali.auth.third.core.model.l */
public class C1031l {
    /* renamed from: a */
    public String f2067a;
    /* renamed from: b */
    public String f2068b;
    /* renamed from: c */
    public String f2069c;
    /* renamed from: d */
    public String f2070d;
    /* renamed from: e */
    public String f2071e;
    /* renamed from: f */
    public String f2072f;
    /* renamed from: g */
    public String f2073g;
    /* renamed from: h */
    public String f2074h;
    /* renamed from: i */
    public String f2075i;
    /* renamed from: j */
    public String f2076j;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User [userId=");
        sb.append(this.f2067a);
        sb.append(", openId=");
        sb.append(this.f2075i);
        sb.append(", openSid= ");
        sb.append(this.f2076j);
        sb.append(", nick=");
        sb.append(this.f2068b);
        sb.append(", email=");
        sb.append(this.f2069c);
        sb.append(",cbuloginId=");
        sb.append(this.f2070d);
        sb.append(",memberId=");
        sb.append(this.f2071e);
        sb.append(",deviceTokenKey=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2073g);
        String str = "";
        sb2.append(str);
        sb.append(sb2.toString());
        sb.append(",deviceTokenSalt=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f2074h);
        sb3.append(str);
        sb.append(sb3.toString());
        sb.append("]");
        return sb.toString();
    }
}
