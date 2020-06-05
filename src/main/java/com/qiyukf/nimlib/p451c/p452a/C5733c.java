package com.qiyukf.nimlib.p451c.p452a;

import android.database.sqlite.SQLiteDatabase;
import com.qiyukf.basesdk.p393a.C5264a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.c.a.c */
public class C5733c {
    /* renamed from: a */
    private final C5734a[] f18299a;

    /* renamed from: com.qiyukf.nimlib.c.a.c$a */
    public static final class C5734a {
        /* renamed from: a */
        private final String f18300a;
        /* renamed from: b */
        private final boolean f18301b;
        /* renamed from: c */
        private final List<C5735b> f18302c;

        public C5734a(String str) {
            this(str, 0);
        }

        private C5734a(String str, byte b) {
            this.f18302c = new ArrayList();
            this.f18300a = str;
            this.f18301b = true;
        }

        /* renamed from: a */
        private int m23082a(int i) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.f18302c.size(); i3++) {
                if (i >= ((C5735b) this.f18302c.get(i3)).f18303a) {
                    i2 = i3;
                }
            }
            return i2;
        }

        /* renamed from: a */
        private static void m23083a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
            if (strArr != null) {
                for (String execSQL : strArr) {
                    sQLiteDatabase.execSQL(execSQL);
                }
            }
        }

        /* renamed from: b */
        private void m23084b(SQLiteDatabase sQLiteDatabase, int i) {
            C5735b bVar = (C5735b) this.f18302c.get(i);
            StringBuilder sb = new StringBuilder("create: table ");
            sb.append(this);
            sb.append(" target ");
            sb.append(bVar);
            C5264a.m21624d("db", sb.toString());
            m23083a(sQLiteDatabase, bVar.mo27991a());
        }

        /* renamed from: b */
        private void m23085b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            C5735b bVar = (C5735b) this.f18302c.get(i);
            C5735b bVar2 = (C5735b) this.f18302c.get(i2);
            StringBuilder sb = new StringBuilder("upgrade: table ");
            sb.append(this);
            sb.append(" initial ");
            sb.append(bVar);
            sb.append(" target ");
            sb.append(bVar2);
            C5264a.m21624d("db", sb.toString());
            m23083a(sQLiteDatabase, bVar2.mo27992b());
        }

        /* renamed from: a */
        public final C5734a mo27987a(C5735b bVar) {
            this.f18302c.add(bVar);
            return this;
        }

        /* access modifiers changed from: final */
        /* renamed from: a */
        public final void mo27988a(SQLiteDatabase sQLiteDatabase, int i) {
            int a = m23082a(i);
            if (a >= 0) {
                m23084b(sQLiteDatabase, a);
            }
        }

        /* access modifiers changed from: final */
        /* renamed from: a */
        public final void mo27989a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            int a = m23082a(i2);
            int a2 = m23082a(i);
            if (a != a2) {
                if (a2 < 0) {
                    m23084b(sQLiteDatabase, a);
                    return;
                }
                if (a2 < a) {
                    if (this.f18301b) {
                        while (a2 < a) {
                            int i3 = a2 + 1;
                            m23085b(sQLiteDatabase, a2, i3);
                            a2 = i3;
                        }
                    } else {
                        m23085b(sQLiteDatabase, a2, a);
                    }
                }
            }
        }

        public final String toString() {
            return this.f18300a;
        }
    }

    /* renamed from: com.qiyukf.nimlib.c.a.c$b */
    public static abstract class C5735b {
        /* renamed from: a */
        final int f18303a;

        public C5735b(int i) {
            this.f18303a = i;
        }

        /* renamed from: a */
        public abstract String[] mo27991a();

        /* renamed from: b */
        public abstract String[] mo27992b();

        public String toString() {
            return Integer.toString(this.f18303a);
        }
    }

    public C5733c(C5734a[] aVarArr) {
        this.f18299a = aVarArr;
    }

    /* renamed from: a */
    public final void mo27985a(SQLiteDatabase sQLiteDatabase, int i) {
        for (C5734a a : this.f18299a) {
            a.mo27988a(sQLiteDatabase, i);
        }
    }

    /* renamed from: a */
    public final void mo27986a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (C5734a a : this.f18299a) {
            a.mo27989a(sQLiteDatabase, i, i2);
        }
    }
}
