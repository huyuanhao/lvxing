package com.p235fm.openinstall.p238c;

/* renamed from: com.fm.openinstall.c.c */
public class C2619c {
    /* renamed from: a */
    private String f9490a;

    private C2619c(String str) {
        this.f9490a = str;
    }

    /* renamed from: a */
    public static C2619c m12722a(Class cls) {
        String simpleName = cls.getSimpleName();
        if (simpleName.length() > 23) {
            simpleName = simpleName.substring(0, 23);
        }
        return new C2619c(simpleName);
    }
}
