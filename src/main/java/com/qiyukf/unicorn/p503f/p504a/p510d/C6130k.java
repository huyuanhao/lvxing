package com.qiyukf.unicorn.p503f.p504a.p510d;

import android.content.Context;
import com.qiyukf.unicorn.p503f.p504a.C6113c;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import com.qiyukf.unicorn.p516j.C6211c;

@C6111b(mo29052a = 65)
/* renamed from: com.qiyukf.unicorn.f.a.d.k */
public class C6130k extends C6144e implements C6113c {
    @C6110a(mo29051a = "content")
    /* renamed from: a */
    private String f19160a;

    /* renamed from: a */
    public static C6130k m24343a(String str, String str2) {
        StringBuilder sb = new StringBuilder("<img src=\"");
        sb.append(str);
        sb.append("\" title=\"");
        sb.append(str2);
        sb.append("\">");
        String sb2 = sb.toString();
        C6130k kVar = new C6130k();
        kVar.f19160a = sb2;
        return kVar;
    }

    /* renamed from: a */
    public final String mo29123a() {
        return this.f19160a;
    }

    /* renamed from: a */
    public final String mo29035a(Context context) {
        return C6211c.m24638a(this.f19160a);
    }

    public boolean countToUnread() {
        return true;
    }

    public String getContent(Context context) {
        return C6211c.m24638a(this.f19160a).replace("\n", " ");
    }
}
