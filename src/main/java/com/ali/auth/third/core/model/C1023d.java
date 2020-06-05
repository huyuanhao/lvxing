package com.ali.auth.third.core.model;

import java.util.Map;

/* renamed from: com.ali.auth.third.core.model.d */
public class C1023d {
    /* renamed from: a */
    public String f1995a;
    /* renamed from: b */
    public long f1996b;
    /* renamed from: c */
    public long f1997c;
    /* renamed from: d */
    public String f1998d;
    /* renamed from: e */
    public String f1999e;
    /* renamed from: f */
    public String f2000f;
    /* renamed from: g */
    public C1031l f2001g;
    /* renamed from: h */
    public String f2002h;
    /* renamed from: i */
    public String f2003i;
    /* renamed from: j */
    public String f2004j;
    /* renamed from: k */
    public String f2005k;
    /* renamed from: l */
    public String f2006l;
    /* renamed from: m */
    public Map<String, Object> f2007m;
    /* renamed from: n */
    public String[] f2008n;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InternalSession [sid=");
        sb.append(this.f1995a);
        sb.append(", expireIn=");
        sb.append(this.f1996b);
        sb.append(", loginTime=");
        sb.append(this.f1997c);
        sb.append(", autoLoginToken=");
        sb.append(this.f2000f);
        sb.append(",topAccessToken=");
        sb.append(this.f2002h);
        sb.append(",topAuthCode=");
        sb.append(this.f2003i);
        sb.append(",topExpireTime=");
        sb.append(this.f2004j);
        sb.append(",ssoToken=");
        sb.append(this.f2005k);
        sb.append(",havanaSsoToken=");
        sb.append(this.f2006l);
        sb.append(", user=");
        sb.append(this.f2001g.toString());
        sb.append(", otherInfo=");
        sb.append(this.f2007m);
        sb.append(", cookies=");
        String[] strArr = this.f2008n;
        if (strArr != null) {
            for (String append : strArr) {
                sb.append(append);
            }
        } else {
            sb.append("null");
        }
        sb.append("]");
        return sb.toString();
    }
}
