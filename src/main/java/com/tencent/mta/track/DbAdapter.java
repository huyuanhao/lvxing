package com.tencent.mta.track;

import android.content.Context;

/* compiled from: ProGuard */
class DbAdapter {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f24831a;
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final String f24832b;
    /* renamed from: c */
    private final Context f24833c;
    /* renamed from: d */
    private final String f24834d;
    /* renamed from: e */
    private C7375f f24835e = null;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.DbAdapter$Table */
    public enum Table {
        EVENTS("events");
        
        private final String mTableName;

        private Table(String str) {
            this.mTableName = str;
        }

        /* renamed from: a */
        public String mo35805a() {
            return this.mTableName;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(Table.EVENTS.mo35805a());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("data");
        sb.append(" STRING NOT NULL, ");
        String str = "created_at";
        sb.append(str);
        sb.append(" INTEGER NOT NULL);");
        f24831a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb2.append(Table.EVENTS.mo35805a());
        sb2.append(" (");
        sb2.append(str);
        sb2.append(");");
        f24832b = sb2.toString();
    }

    public DbAdapter(Context context, String str) {
        this.f24833c = context;
        this.f24834d = str;
        mo35804a();
    }

    /* renamed from: a */
    public void mo35804a() {
        C7375f fVar = this.f24835e;
        if (fVar != null) {
            fVar.mo35913a();
        }
        this.f24835e = new C7375f(this.f24833c, this.f24834d);
    }
}
