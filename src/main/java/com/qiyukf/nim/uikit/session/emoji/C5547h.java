package com.qiyukf.nim.uikit.session.emoji;

import com.qiyukf.unicorn.p502e.C6045d.C6046a;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.emoji.h */
public final class C5547h implements Serializable {
    private static final long serialVersionUID = -81692490861539040L;
    /* renamed from: a */
    private String f17869a;
    /* renamed from: b */
    private String f17870b;
    /* renamed from: c */
    private int f17871c;
    /* renamed from: d */
    private transient List<C6046a> f17872d;

    public C5547h(String str, String str2, List<C6046a> list, int i) {
        this.f17869a = str;
        this.f17870b = str2;
        this.f17872d = list;
        this.f17871c = i;
    }

    /* renamed from: a */
    public final List<C6046a> mo27665a() {
        return this.f17872d;
    }

    /* renamed from: b */
    public final boolean mo27666b() {
        List<C6046a> list = this.f17872d;
        return list != null && list.size() > 0;
    }

    /* renamed from: c */
    public final String mo27667c() {
        return this.f17870b;
    }

    /* renamed from: d */
    public final int mo27668d() {
        return this.f17871c;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C5547h)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return ((C5547h) obj).f17869a.equals(this.f17869a);
    }

    public final int hashCode() {
        return this.f17869a.hashCode();
    }
}
