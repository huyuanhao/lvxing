package com.kwai.filedownloader.p354b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.kwai.filedownloader.p354b.C4596a.C4597a;
import com.kwai.filedownloader.p356d.C4618a;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p358f.C4654c;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwai.filedownloader.b.d */
public class C4603d implements C4596a {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final SQLiteDatabase f14980a = new C4606e(C4654c.m19105a()).getWritableDatabase();

    /* renamed from: com.kwai.filedownloader.b.d$a */
    public class C4604a implements C4597a {
        /* renamed from: b */
        private final SparseArray<C4621c> f14982b;
        /* renamed from: c */
        private C4605b f14983c;
        /* renamed from: d */
        private final SparseArray<C4621c> f14984d;
        /* renamed from: e */
        private final SparseArray<List<C4618a>> f14985e;

        C4604a(C4603d dVar) {
            this(null, null);
        }

        C4604a(SparseArray<C4621c> sparseArray, SparseArray<List<C4618a>> sparseArray2) {
            this.f14982b = new SparseArray<>();
            this.f14984d = sparseArray;
            this.f14985e = sparseArray2;
        }

        /* renamed from: a */
        public void mo24979a() {
            C4605b bVar = this.f14983c;
            if (bVar != null) {
                bVar.mo24994b();
            }
            int size = this.f14982b.size();
            if (size >= 0) {
                C4603d.this.f14980a.beginTransaction();
                int i = 0;
                while (i < size) {
                    try {
                        int keyAt = this.f14982b.keyAt(i);
                        C4621c cVar = (C4621c) this.f14982b.get(keyAt);
                        C4603d.this.f14980a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                        C4603d.this.f14980a.insert("filedownloader", null, cVar.mo25098p());
                        if (cVar.mo25096n() > 1) {
                            List<C4618a> c = C4603d.this.mo24974c(keyAt);
                            if (c.size() > 0) {
                                C4603d.this.f14980a.delete("filedownloaderConnection", "id = ?", new String[]{String.valueOf(keyAt)});
                                for (C4618a aVar : c) {
                                    aVar.mo25050a(cVar.mo25071a());
                                    C4603d.this.f14980a.insert("filedownloaderConnection", null, aVar.mo25059f());
                                }
                            }
                        }
                        i++;
                    } catch (Throwable th) {
                        C4603d.this.f14980a.endTransaction();
                        throw th;
                    }
                }
                if (!(this.f14984d == null || this.f14985e == null)) {
                    synchronized (this.f14984d) {
                        int size2 = this.f14984d.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            int a = ((C4621c) this.f14984d.valueAt(i2)).mo25071a();
                            List c2 = C4603d.this.mo24974c(a);
                            if (c2 != null && c2.size() > 0) {
                                synchronized (this.f14985e) {
                                    this.f14985e.put(a, c2);
                                }
                            }
                        }
                    }
                }
                C4603d.this.f14980a.setTransactionSuccessful();
                C4603d.this.f14980a.endTransaction();
            }
        }

        /* renamed from: a */
        public void mo24980a(int i, C4621c cVar) {
            this.f14982b.put(i, cVar);
        }

        /* renamed from: a */
        public void mo24981a(C4621c cVar) {
        }

        /* renamed from: b */
        public void mo24982b(C4621c cVar) {
            SparseArray<C4621c> sparseArray = this.f14984d;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.f14984d.put(cVar.mo25071a(), cVar);
                }
            }
        }

        public Iterator<C4621c> iterator() {
            C4605b bVar = new C4605b();
            this.f14983c = bVar;
            return bVar;
        }
    }

    /* renamed from: com.kwai.filedownloader.b.d$b */
    class C4605b implements Iterator<C4621c> {
        /* renamed from: b */
        private final Cursor f14987b;
        /* renamed from: c */
        private final List<Integer> f14988c = new ArrayList();
        /* renamed from: d */
        private int f14989d;

        C4605b() {
            this.f14987b = C4603d.this.f14980a.rawQuery("SELECT * FROM filedownloader", null);
        }

        /* renamed from: a */
        public C4621c next() {
            C4621c a = C4603d.m18747b(this.f14987b);
            this.f14989d = a.mo25071a();
            return a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo24994b() {
            this.f14987b.close();
            if (!this.f14988c.isEmpty()) {
                String join = TextUtils.join(", ", this.f14988c);
                if (C4660d.f15179a) {
                    C4660d.m19123c(this, "delete %s", join);
                }
                String str = "DELETE FROM %s WHERE %s IN (%s);";
                C4603d.this.f14980a.execSQL(C4664f.m19135a(str, "filedownloader", C7887a.f26833ID, join));
                C4603d.this.f14980a.execSQL(C4664f.m19135a(str, "filedownloaderConnection", "id", join));
            }
        }

        public boolean hasNext() {
            return this.f14987b.moveToNext();
        }

        public void remove() {
            this.f14988c.add(Integer.valueOf(this.f14989d));
        }
    }

    /* renamed from: a */
    private void m18746a(int i, ContentValues contentValues) {
        try {
            this.f14980a.update("filedownloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static C4621c m18747b(Cursor cursor) {
        C4621c cVar = new C4621c();
        cVar.mo25073a(cursor.getInt(cursor.getColumnIndex(C7887a.f26833ID)));
        cVar.mo25075a(cursor.getString(cursor.getColumnIndex("url")));
        String string = cursor.getString(cursor.getColumnIndex("path"));
        boolean z = true;
        if (cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) != 1) {
            z = false;
        }
        cVar.mo25076a(string, z);
        cVar.mo25072a((byte) cursor.getShort(cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS)));
        cVar.mo25074a(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.mo25082c(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.mo25083c(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.mo25080b(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.mo25085d(cursor.getString(cursor.getColumnIndex("filename")));
        cVar.mo25078b(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    /* renamed from: a */
    public C4597a mo24990a(SparseArray<C4621c> sparseArray, SparseArray<List<C4618a>> sparseArray2) {
        return new C4604a(sparseArray, sparseArray2);
    }

    /* renamed from: a */
    public void mo24960a() {
        this.f14980a.delete("filedownloader", null, null);
        this.f14980a.delete("filedownloaderConnection", null, null);
    }

    /* renamed from: a */
    public void mo24961a(int i) {
    }

    /* renamed from: a */
    public void mo24962a(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        this.f14980a.update("filedownloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
    }

    /* renamed from: a */
    public void mo24963a(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        this.f14980a.update("filedownloaderConnection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
    }

    /* renamed from: a */
    public void mo24964a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Byte.valueOf(3));
        contentValues.put("sofar", Long.valueOf(j));
        m18746a(i, contentValues);
    }

    /* renamed from: a */
    public void mo24965a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Byte.valueOf(2));
        contentValues.put("total", Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        m18746a(i, contentValues);
    }

    /* renamed from: a */
    public void mo24966a(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        m18746a(i, contentValues);
    }

    /* renamed from: a */
    public void mo24967a(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Byte.valueOf(5));
        m18746a(i, contentValues);
    }

    /* renamed from: a */
    public void mo24968a(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Byte.valueOf(-1));
        contentValues.put("sofar", Long.valueOf(j));
        m18746a(i, contentValues);
    }

    /* renamed from: a */
    public void mo24969a(C4618a aVar) {
        if (aVar != null) {
            SQLiteDatabase sQLiteDatabase = this.f14980a;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.insert("filedownloaderConnection", null, aVar.mo25059f());
            }
        }
    }

    /* renamed from: a */
    public void mo24970a(C4621c cVar) {
        if (cVar == null) {
            C4660d.m19124d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (mo24972b(cVar.mo25071a()) != null) {
            ContentValues p = cVar.mo25098p();
            this.f14980a.update("filedownloader", p, "_id = ? ", new String[]{String.valueOf(cVar.mo25071a())});
        } else {
            mo24991b(cVar);
        }
    }

    /* renamed from: b */
    public C4597a mo24971b() {
        return new C4604a(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* renamed from: b */
    public com.kwai.filedownloader.p356d.C4621c mo24972b(int r9) {
        /*
        r8 = this;
        r0 = 0
        android.database.sqlite.SQLiteDatabase r1 = r8.f14980a     // Catch:{ all -> 0x003d }
        java.lang.String r2 = "SELECT * FROM %s WHERE %s = ?"
        r3 = 2
        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x003d }
        java.lang.String r4 = "filedownloader"
        r5 = 0
        r3[r5] = r4     // Catch:{ all -> 0x003d }
        java.lang.String r4 = "_id"
        r6 = 1
        r3[r6] = r4     // Catch:{ all -> 0x003d }
        java.lang.String r2 = com.kwai.filedownloader.p358f.C4664f.m19135a(r2, r3)     // Catch:{ all -> 0x003d }
        java.lang.String[] r3 = new java.lang.String[r6]     // Catch:{ all -> 0x003d }
        java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ all -> 0x003d }
        r3[r5] = r9     // Catch:{ all -> 0x003d }
        android.database.Cursor r9 = r1.rawQuery(r2, r3)     // Catch:{ all -> 0x003d }
        boolean r1 = r9.moveToNext()     // Catch:{ all -> 0x0038 }
        if (r1 == 0) goto L_0x0032
        com.kwai.filedownloader.d.c r0 = m18747b(r9)     // Catch:{ all -> 0x0038 }
        if (r9 == 0) goto L_0x0031
        r9.close()
    L_0x0031:
        return r0
    L_0x0032:
        if (r9 == 0) goto L_0x0037
        r9.close()
    L_0x0037:
        return r0
    L_0x0038:
        r0 = move-exception
        r7 = r0
        r0 = r9
        r9 = r7
        goto L_0x003e
    L_0x003d:
        r9 = move-exception
    L_0x003e:
        if (r0 == 0) goto L_0x0043
        r0.close()
    L_0x0043:
        throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.filedownloader.p354b.C4603d.mo24972b(int):com.kwai.filedownloader.d.c");
    }

    /* renamed from: b */
    public void mo24973b(int i, long j) {
        mo24977e(i);
    }

    /* renamed from: b */
    public void mo24991b(C4621c cVar) {
        this.f14980a.insert("filedownloader", null, cVar.mo25098p());
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    public List<C4618a> mo24974c(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.f14980a.rawQuery(C4664f.m19135a("SELECT * FROM %s WHERE %s = ?", "filedownloaderConnection", "id"), new String[]{Integer.toString(i)});
            while (rawQuery.moveToNext()) {
                C4618a aVar = new C4618a();
                aVar.mo25050a(i);
                aVar.mo25053b(rawQuery.getInt(rawQuery.getColumnIndex("connectionIndex")));
                aVar.mo25051a(rawQuery.getLong(rawQuery.getColumnIndex("startOffset")));
                aVar.mo25054b(rawQuery.getLong(rawQuery.getColumnIndex("currentOffset")));
                aVar.mo25056c(rawQuery.getLong(rawQuery.getColumnIndex("endOffset")));
                arrayList.add(aVar);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: c */
    public void mo24975c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Byte.valueOf(-2));
        contentValues.put("sofar", Long.valueOf(j));
        m18746a(i, contentValues);
    }

    /* renamed from: d */
    public void mo24976d(int i) {
        try {
            SQLiteDatabase sQLiteDatabase = this.f14980a;
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM filedownloaderConnection WHERE id = ");
            sb.append(i);
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public boolean mo24977e(int i) {
        return this.f14980a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(i)}) != 0;
    }

    /* renamed from: f */
    public void mo24978f(int i) {
    }
}
