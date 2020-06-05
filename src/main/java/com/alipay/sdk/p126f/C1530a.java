package com.alipay.sdk.p126f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alipay.sdk.util.C1542e;
import java.lang.ref.WeakReference;

/* renamed from: com.alipay.sdk.f.a */
final class C1530a extends SQLiteOpenHelper {
    /* renamed from: a */
    private WeakReference<Context> f3903a;

    C1530a(Context context) {
        super(context, "msp.db", null, 1);
        this.f3903a = new WeakReference<>(context);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("drop table if exists tb_tid");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12189a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            sQLiteDatabase.execSQL("drop table if exists tb_tid");
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                return;
            }
        } catch (Exception e) {
            C1542e.m4633a(e);
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        sQLiteDatabase.close();
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r5v12, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
            if (r2.isOpen() != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
            r2.close();
            r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
            if (r2.isOpen() != false) goto L_0x002c;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v4
  assigns: []
  uses: []
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
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: a */
    public java.lang.String mo12188a(java.lang.String r5, java.lang.String r6) {
        /*
        r4 = this;
        java.lang.String r0 = "select tid from tb_tid where name=?"
        r1 = 0
        android.database.sqlite.SQLiteDatabase r2 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x004c, all -> 0x0039 }
        r3 = 1
        java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
        java.lang.String r5 = r4.m4569c(r5, r6)     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
        r6 = 0
        r3[r6] = r5     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
        android.database.Cursor r5 = r2.rawQuery(r0, r3)     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
        boolean r0 = r5.moveToFirst()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
        if (r0 == 0) goto L_0x001f
        java.lang.String r1 = r5.getString(r6)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
    L_0x001f:
        if (r5 == 0) goto L_0x0024
        r5.close()
    L_0x0024:
        if (r2 == 0) goto L_0x005c
        boolean r5 = r2.isOpen()
        if (r5 == 0) goto L_0x005c
    L_0x002c:
        r2.close()
        goto L_0x005c
    L_0x0030:
        r6 = move-exception
        r1 = r5
        goto L_0x003b
        goto L_0x004e
    L_0x0035:
        r6 = move-exception
        goto L_0x003b
    L_0x0037:
        r5 = r1
        goto L_0x004e
    L_0x0039:
        r6 = move-exception
        r2 = r1
    L_0x003b:
        if (r1 == 0) goto L_0x0040
        r1.close()
    L_0x0040:
        if (r2 == 0) goto L_0x004b
        boolean r5 = r2.isOpen()
        if (r5 == 0) goto L_0x004b
        r2.close()
    L_0x004b:
        throw r6
    L_0x004c:
        r5 = r1
        r2 = r5
    L_0x004e:
        if (r5 == 0) goto L_0x0053
        r5.close()
    L_0x0053:
        if (r2 == 0) goto L_0x005c
        boolean r5 = r2.isOpen()
        if (r5 == 0) goto L_0x005c
        goto L_0x002c
    L_0x005c:
        boolean r5 = android.text.TextUtils.isEmpty(r1)
        if (r5 != 0) goto L_0x0072
        java.lang.ref.WeakReference<android.content.Context> r5 = r4.f3903a
        java.lang.Object r5 = r5.get()
        android.content.Context r5 = (android.content.Context) r5
        java.lang.String r5 = com.alipay.sdk.util.C1539b.m4619c(r5)
        java.lang.String r1 = com.alipay.sdk.p122c.C1514b.m4513b(r1, r5)
    L_0x0072:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p126f.C1530a.mo12188a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v7, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
            if (r2.isOpen() != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
            r2.close();
            r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
            if (r2.isOpen() != false) goto L_0x002c;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v3
  assigns: []
  uses: []
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
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0055  */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: b */
    public java.lang.String mo12190b(java.lang.String r5, java.lang.String r6) {
        /*
        r4 = this;
        java.lang.String r0 = "select key_tid from tb_tid where name=?"
        r1 = 0
        android.database.sqlite.SQLiteDatabase r2 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x004c, all -> 0x0039 }
        r3 = 1
        java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
        java.lang.String r5 = r4.m4569c(r5, r6)     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
        r6 = 0
        r3[r6] = r5     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
        android.database.Cursor r5 = r2.rawQuery(r0, r3)     // Catch:{ Exception -> 0x0037, all -> 0x0035 }
        boolean r0 = r5.moveToFirst()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
        if (r0 == 0) goto L_0x001f
        java.lang.String r1 = r5.getString(r6)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
    L_0x001f:
        if (r5 == 0) goto L_0x0024
        r5.close()
    L_0x0024:
        if (r2 == 0) goto L_0x005c
        boolean r5 = r2.isOpen()
        if (r5 == 0) goto L_0x005c
    L_0x002c:
        r2.close()
        goto L_0x005c
    L_0x0030:
        r6 = move-exception
        r1 = r5
        goto L_0x003b
        goto L_0x004e
    L_0x0035:
        r6 = move-exception
        goto L_0x003b
    L_0x0037:
        r5 = r1
        goto L_0x004e
    L_0x0039:
        r6 = move-exception
        r2 = r1
    L_0x003b:
        if (r1 == 0) goto L_0x0040
        r1.close()
    L_0x0040:
        if (r2 == 0) goto L_0x004b
        boolean r5 = r2.isOpen()
        if (r5 == 0) goto L_0x004b
        r2.close()
    L_0x004b:
        throw r6
    L_0x004c:
        r5 = r1
        r2 = r5
    L_0x004e:
        if (r5 == 0) goto L_0x0053
        r5.close()
    L_0x0053:
        if (r2 == 0) goto L_0x005c
        boolean r5 = r2.isOpen()
        if (r5 == 0) goto L_0x005c
        goto L_0x002c
    L_0x005c:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.p126f.C1530a.mo12190b(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    private String m4569c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }
}
