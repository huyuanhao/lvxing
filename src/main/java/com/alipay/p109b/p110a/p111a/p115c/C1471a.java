package com.alipay.p109b.p110a.p111a.p115c;

import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.tencent.mid.sotrage.StorageInterface;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* renamed from: com.alipay.b.a.a.c.a */
public final class C1471a {
    /* renamed from: a */
    private String f3739a;
    /* renamed from: b */
    private String f3740b;
    /* renamed from: c */
    private String f3741c;
    /* renamed from: d */
    private String f3742d;
    /* renamed from: e */
    private String f3743e;
    /* renamed from: f */
    private String f3744f;
    /* renamed from: g */
    private String f3745g;

    public C1471a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f3739a = str;
        this.f3740b = str2;
        this.f3741c = str3;
        this.f3742d = str4;
        this.f3743e = str5;
        this.f3744f = str6;
        this.f3745g = str7;
    }

    public final String toString() {
        String str;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3;
        StringBuilder sb3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        String str4 = StorageInterface.KEY_SPLITER;
        StringBuilder sb4 = new StringBuilder(str4);
        sb4.append(this.f3739a);
        stringBuffer.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder(str4);
        sb5.append(this.f3740b);
        stringBuffer.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder(str4);
        sb6.append(this.f3741c);
        stringBuffer.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder(str4);
        sb7.append(this.f3742d);
        stringBuffer.append(sb7.toString());
        if (C1460a.m4260a(this.f3743e) || this.f3743e.length() < 20) {
            sb = new StringBuilder(str4);
            str = this.f3743e;
        } else {
            sb = new StringBuilder(str4);
            str = this.f3743e.substring(0, 20);
        }
        sb.append(str);
        stringBuffer.append(sb.toString());
        if (C1460a.m4260a(this.f3744f) || this.f3744f.length() < 20) {
            sb2 = new StringBuilder(str4);
            str2 = this.f3744f;
        } else {
            sb2 = new StringBuilder(str4);
            str2 = this.f3744f.substring(0, 20);
        }
        sb2.append(str2);
        stringBuffer.append(sb2.toString());
        if (C1460a.m4260a(this.f3745g) || this.f3745g.length() < 20) {
            sb3 = new StringBuilder(str4);
            str3 = this.f3745g;
        } else {
            sb3 = new StringBuilder(str4);
            str3 = this.f3745g.substring(0, 20);
        }
        sb3.append(str3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
