package com.p620ut.mini.p625c;

/* renamed from: com.ut.mini.c.b */
public class UTTeamWork {
    /* renamed from: a */
    private static UTTeamWork f26036a;

    /* renamed from: b */
    public void mo37431b() {
    }

    /* renamed from: a */
    public static synchronized UTTeamWork m33159a() {
        UTTeamWork bVar;
        synchronized (UTTeamWork.class) {
            if (f26036a == null) {
                f26036a = new UTTeamWork();
            }
            bVar = f26036a;
        }
        return bVar;
    }
}
