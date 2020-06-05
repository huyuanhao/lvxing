package discoveryAD;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import discoveryAD.C7880W.C7881a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: discoveryAD.X */
public class C7882X {
    private static final String TAG = "ActionDao";
    /* renamed from: Vd */
    C7889ba f26806Vd;

    public C7882X(C7889ba baVar) {
        this.f26806Vd = baVar;
    }

    /* renamed from: a */
    public void mo38162a(C7883Y y) {
        if (y != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(y);
            mo38164c(arrayList);
        }
    }

    /* renamed from: b */
    public void mo38163b(C7883Y y) {
        if (y != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(y);
            mo38165d(arrayList);
        }
    }

    /* renamed from: c */
    public void mo38164c(List<C7883Y> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("deleteAction(): actionModels size=");
        sb.append(list.size());
        String sb2 = sb.toString();
        String str = TAG;
        C7852Aa.m34154d(str, sb2);
        if (!C7931ta.m34347g(list)) {
            SQLiteDatabase writableDatabase = this.f26806Vd.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                for (C7883Y y : list) {
                    String str2 = C7880W.f26799Ud;
                    String str3 = "%s = %d";
                    Object[] objArr = new Object[2];
                    objArr[0] = C7881a.f26800bh;
                    objArr[1] = Integer.valueOf(y.index);
                    writableDatabase.delete(str2, String.format(str3, objArr), null);
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
            writableDatabase.endTransaction();
            C7852Aa.m34154d(str, "deleteAction()  end");
        }
    }

    /* renamed from: d */
    public void mo38165d(List<C7883Y> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("insertAction(): actionModels size=");
        sb.append(list.size());
        String sb2 = sb.toString();
        String str = TAG;
        C7852Aa.m34154d(str, sb2);
        SQLiteDatabase writableDatabase = this.f26806Vd.getWritableDatabase();
        if (!C7931ta.m34347g(list)) {
            int size = list.size();
            String str2 = C7880W.f26799Ud;
            String str3 = C7881a.f26805gh;
            String str4 = C7881a.TIMESTAMP;
            String str5 = C7881a.f26802dh;
            String str6 = C7881a.f26804fh;
            String str7 = "context";
            String str8 = "activity_id";
            if (size == 1) {
                for (C7883Y y : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(str8, y.f26808Wd);
                    contentValues.put(str7, y.context);
                    contentValues.put(str6, Integer.valueOf(y.f26807W));
                    contentValues.put(str5, Integer.valueOf(y.positionId));
                    contentValues.put(str4, Long.valueOf(y.timeStamp));
                    contentValues.put(str3, Long.valueOf(y.f26809Xd));
                    try {
                        writableDatabase.insert(str2, null, contentValues);
                    } catch (Throwable th) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("insertAction, e: ");
                        sb3.append(th);
                        C7852Aa.m34154d(str, sb3.toString());
                    }
                }
                return;
            }
            try {
                writableDatabase.beginTransaction();
                for (C7883Y y2 : list) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(str8, y2.f26808Wd);
                    contentValues2.put(str7, y2.context);
                    contentValues2.put(str6, Integer.valueOf(y2.f26807W));
                    contentValues2.put(str5, Integer.valueOf(y2.positionId));
                    contentValues2.put(str4, Long.valueOf(y2.timeStamp));
                    contentValues2.put(str3, Long.valueOf(y2.f26809Xd));
                    writableDatabase.insert(str2, null, contentValues2);
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
            writableDatabase.endTransaction();
            C7852Aa.m34154d(str, "insertAction(): end");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6 A[DONT_GENERATE] */
    public java.util.List<discoveryAD.C7883Y> getActions() {
        /*
        r7 = this;
        discoveryAD.ba r0 = r7.f26806Vd
        android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()
        java.lang.String r1 = "select * from discovery_advertise_action_table"
        r2 = 0
        android.database.Cursor r0 = r0.rawQuery(r1, r2)     // Catch:{ all -> 0x008b }
        if (r0 == 0) goto L_0x0084
        java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0082 }
        r1.<init>()     // Catch:{ all -> 0x0082 }
        r0.moveToFirst()     // Catch:{ all -> 0x007d }
    L_0x0017:
        boolean r2 = r0.isAfterLast()     // Catch:{ all -> 0x007d }
        if (r2 != 0) goto L_0x0085
        discoveryAD.Y r2 = new discoveryAD.Y     // Catch:{ all -> 0x007d }
        r2.m54319init()     // Catch:{ all -> 0x007d }
        java.lang.String r3 = "activity_id"
        int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x007d }
        java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x007d }
        r2.f26808Wd = r3     // Catch:{ all -> 0x007d }
        java.lang.String r3 = "context"
        int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x007d }
        byte[] r3 = r0.getBlob(r3)     // Catch:{ all -> 0x007d }
        r2.context = r3     // Catch:{ all -> 0x007d }
        java.lang.String r3 = "auto_increate_index"
        int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x007d }
        int r3 = r0.getInt(r3)     // Catch:{ all -> 0x007d }
        r2.index = r3     // Catch:{ all -> 0x007d }
        java.lang.String r3 = "phase"
        int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x007d }
        int r3 = r0.getInt(r3)     // Catch:{ all -> 0x007d }
        r2.f26807W = r3     // Catch:{ all -> 0x007d }
        java.lang.String r3 = "position_id"
        int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x007d }
        int r3 = r0.getInt(r3)     // Catch:{ all -> 0x007d }
        r2.positionId = r3     // Catch:{ all -> 0x007d }
        java.lang.String r3 = "timestamp"
        int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x007d }
        long r3 = r0.getLong(r3)     // Catch:{ all -> 0x007d }
        r2.timeStamp = r3     // Catch:{ all -> 0x007d }
        java.lang.String r3 = "specialtime"
        int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x007d }
        long r3 = r0.getLong(r3)     // Catch:{ all -> 0x007d }
        r2.f26809Xd = r3     // Catch:{ all -> 0x007d }
        r1.add(r2)     // Catch:{ all -> 0x007d }
        r0.moveToNext()     // Catch:{ all -> 0x007d }
        goto L_0x0017
    L_0x007d:
        r2 = move-exception
        r6 = r2
        r2 = r1
        r1 = r6
        goto L_0x008e
    L_0x0082:
        r1 = move-exception
        goto L_0x008e
    L_0x0084:
        r1 = r2
    L_0x0085:
        if (r0 == 0) goto L_0x00aa
        r0.close()
        goto L_0x00aa
    L_0x008b:
        r0 = move-exception
        r1 = r0
        r0 = r2
    L_0x008e:
        java.lang.String r3 = "ActionDao"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
        r4.<init>()     // Catch:{ all -> 0x00ab }
        java.lang.String r5 = "getActions, e: "
        r4.append(r5)     // Catch:{ all -> 0x00ab }
        r4.append(r1)     // Catch:{ all -> 0x00ab }
        java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00ab }
        discoveryAD.C7852Aa.m34154d(r3, r1)     // Catch:{ all -> 0x00ab }
        if (r0 == 0) goto L_0x00a9
        r0.close()
    L_0x00a9:
        r1 = r2
    L_0x00aa:
        return r1
    L_0x00ab:
        r1 = move-exception
        if (r0 == 0) goto L_0x00b1
        r0.close()
    L_0x00b1:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7882X.getActions():java.util.List");
    }
}
