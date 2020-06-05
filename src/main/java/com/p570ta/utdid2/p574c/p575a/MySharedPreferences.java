package com.p570ta.utdid2.p574c.p575a;

import java.util.Map;

/* renamed from: com.ta.utdid2.c.a.b */
public interface MySharedPreferences {

    /* compiled from: MySharedPreferences */
    /* renamed from: com.ta.utdid2.c.a.b$a */
    public interface C6805a {
        /* renamed from: a */
        C6805a mo32686a(String str);

        /* renamed from: a */
        C6805a mo32687a(String str, float f);

        /* renamed from: a */
        C6805a mo32688a(String str, int i);

        /* renamed from: a */
        C6805a mo32689a(String str, long j);

        /* renamed from: a */
        C6805a mo32690a(String str, String str2);

        /* renamed from: a */
        C6805a mo32691a(String str, boolean z);

        /* renamed from: b */
        C6805a mo32692b();

        boolean commit();
    }

    /* compiled from: MySharedPreferences */
    /* renamed from: com.ta.utdid2.c.a.b$b */
    public interface C6806b {
        /* renamed from: a */
        void mo32694a(MySharedPreferences bVar, String str);
    }

    /* renamed from: a */
    C6805a mo32682a();

    /* renamed from: a */
    boolean m29041a();

    Map<String, ?> getAll();

    long getLong(String str, long j);

    String getString(String str, String str2);
}
