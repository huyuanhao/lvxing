package com.kwad.sdk.core.videocache.p346d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.C4362j;
import com.kwad.sdk.core.videocache.C4368n;

/* renamed from: com.kwad.sdk.core.videocache.d.a */
class C4349a extends SQLiteOpenHelper implements C4350b {
    /* renamed from: a */
    private static final String[] f14262a = {C7887a.f26833ID, "url", "length", "mime"};

    C4349a(Context context) {
        super(context, "AndroidVideoCache.db", null, 1);
        C4362j.m17805a(context);
    }

    /* renamed from: a */
    private ContentValues m17753a(C4368n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.f14308a);
        contentValues.put("length", Long.valueOf(nVar.f14309b));
        contentValues.put("mime", nVar.f14310c);
        return contentValues;
    }

    /* renamed from: a */
    private C4368n m17754a(Cursor cursor) {
        return new C4368n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r11v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.kwad.sdk.core.videocache.n] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.kwad.sdk.core.videocache.n] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
  assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.kwad.sdk.core.videocache.n]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor, com.kwad.sdk.core.videocache.n]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    public com.kwad.sdk.core.videocache.C4368n mo24499a(java.lang.String r11) {
        /*
        r10 = this;
        com.kwad.sdk.core.videocache.C4362j.m17805a(r11)
        r0 = 0
        android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ all -> 0x0034 }
        java.lang.String r2 = "SourceInfo"
        java.lang.String[] r3 = f14262a     // Catch:{ all -> 0x0034 }
        java.lang.String r4 = "url=?"
        r5 = 1
        java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0034 }
        r6 = 0
        r5[r6] = r11     // Catch:{ all -> 0x0034 }
        r6 = 0
        r7 = 0
        r8 = 0
        android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0034 }
        if (r11 == 0) goto L_0x002e
        boolean r1 = r11.moveToFirst()     // Catch:{ all -> 0x0029 }
        if (r1 != 0) goto L_0x0024
        goto L_0x002e
    L_0x0024:
        com.kwad.sdk.core.videocache.n r0 = r10.m17754a(r11)     // Catch:{ all -> 0x0029 }
        goto L_0x002e
    L_0x0029:
        r0 = move-exception
        r9 = r0
        r0 = r11
        r11 = r9
        goto L_0x0035
    L_0x002e:
        if (r11 == 0) goto L_0x0033
        r11.close()
    L_0x0033:
        return r0
    L_0x0034:
        r11 = move-exception
    L_0x0035:
        if (r0 == 0) goto L_0x003a
        r0.close()
    L_0x003a:
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.p346d.C4349a.mo24499a(java.lang.String):com.kwad.sdk.core.videocache.n");
    }

    /* renamed from: a */
    public void mo24500a(String str, C4368n nVar) {
        C4362j.m17808a(str, nVar);
        boolean z = mo24499a(str) != null;
        ContentValues a = m17753a(nVar);
        String str2 = "SourceInfo";
        if (z) {
            getWritableDatabase().update(str2, a, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(str2, null, a);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C4362j.m17805a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
