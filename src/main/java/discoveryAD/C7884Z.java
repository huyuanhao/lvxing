package discoveryAD;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.internal.model.C7486a;
import com.tencent.qqpim.discovery.internal.model.C7491f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: discoveryAD.Z */
public final class C7884Z {
    private static final String TAG = "CommonAdvertiseDao";
    /* renamed from: Vd */
    C7889ba f26810Vd;
    /* renamed from: Yd */
    private final String f26811Yd = "_wspd_fd_dicovery_cadtab_";

    public C7884Z(C7889ba baVar) {
        C7852Aa.m34156i("CommonAdvertiseDao()");
        this.f26810Vd = baVar;
    }

    /* renamed from: P */
    private ArrayList<String> m34259P(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("_wspd_fd_dicovery_cadtab_");
        if (split == null || split.length <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>(split.length);
        for (String add : split) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* renamed from: d */
    private ContentValues m34260d(C7486a aVar) {
        ContentValues l = m34264l(aVar.f25065te);
        l.put(C7887a.f26870vh, Integer.valueOf(aVar.f25063Wb));
        l.put(C7887a.f26871wh, Integer.valueOf(aVar.f25064Xb));
        l.put(C7887a.f26857ih, Integer.valueOf(2));
        return l;
    }

    /* renamed from: d */
    private ContentValues m34261d(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, Integer.valueOf(i));
        return contentValues;
    }

    /* renamed from: e */
    private void m34262e(C7486a aVar) {
        C7852Aa.m34156i("CommonAdvertiseDao insert() beign");
        try {
            long insert = this.f26810Vd.getWritableDatabase().insert(C7886aa.f26824Zd, null, m34260d(aVar));
            StringBuilder sb = new StringBuilder();
            sb.append("rowid=");
            sb.append(insert);
            C7852Aa.m34156i(sb.toString());
        } catch (Throwable th) {
            C7852Aa.m34157w(TAG, Log.getStackTraceString(th));
        }
        C7852Aa.m34156i("CommonAdvertiseDao insert() end");
    }

    /* renamed from: f */
    private void m34263f(C7486a aVar) {
        C7852Aa.m34156i("CommonAdvertiseDao update() beign");
        String str = "uniquekey =?";
        ContentValues d = m34260d(aVar);
        try {
            this.f26810Vd.getWritableDatabase().update(C7886aa.f26824Zd, d, str, new String[]{aVar.f25065te.uniqueKey});
        } catch (Throwable th) {
            C7852Aa.m34157w(TAG, Log.getStackTraceString(th));
        }
        C7852Aa.m34156i("CommonAdvertiseDao update() end");
    }

    /* renamed from: l */
    private ContentValues m34264l(C7491f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C7887a.f26874zh, Integer.valueOf(fVar.f25080Ie));
        contentValues.put(C7887a.f26873yh, Integer.valueOf(fVar.percentSpent));
        contentValues.put(C7887a.f26856hh, fVar.uniqueKey);
        contentValues.put(C7887a.f26858jh, Boolean.valueOf(fVar.f25079He));
        contentValues.put(C7887a.f26859kh, Integer.valueOf(fVar.positionId));
        contentValues.put("activity_id", fVar.f25078Ge);
        contentValues.put(C7887a.f26860lh, Integer.valueOf(fVar.templateType));
        contentValues.put(C7887a.f26861mh, fVar.text1);
        contentValues.put(C7887a.f26862nh, fVar.text2);
        contentValues.put(C7887a.f26863oh, fVar.text3);
        contentValues.put(C7887a.f26872xh, fVar.text4);
        contentValues.put(C7887a.f26864ph, fVar.imageUrl1);
        contentValues.put(C7887a.f26865qh, fVar.imageUrl2);
        contentValues.put(C7887a.f26866rh, fVar.imageUrl3);
        contentValues.put(C7887a.CONTENT_TYPE, Integer.valueOf(fVar.contentType));
        contentValues.put(C7887a.f26867sh, fVar.jumpUrl);
        contentValues.put(C7887a.f26868th, fVar.packageName);
        contentValues.put("expire_time", Integer.valueOf(fVar.f25098rc));
        contentValues.put("context", fVar.context);
        contentValues.put(C7887a.f26825Ah, Integer.valueOf(fVar.effectiveTime));
        contentValues.put(C7887a.f26826Bh, Integer.valueOf(fVar.continuousExposureTime));
        contentValues.put(C7887a.f26827Ch, Integer.valueOf(fVar.exposureInterval));
        contentValues.put(C7887a.f26828Dh, Integer.valueOf(fVar.scenes));
        contentValues.put(C7887a.f26830Fh, fVar.videoUrl);
        contentValues.put(C7887a.f26831Gh, fVar.zipUrl);
        contentValues.put(C7887a.f26832Hh, fVar.appDownloadUrl);
        contentValues.put(C7887a.f26834Ih, Integer.valueOf(fVar.isAutoAppDownload));
        contentValues.put(C7887a.f26835Jh, Integer.valueOf(fVar.isDeepLink));
        contentValues.put(C7887a.ROTATION, Integer.valueOf(!fVar.rotation));
        contentValues.put(C7887a.f26836Kh, Integer.valueOf(fVar.f25084Ma));
        contentValues.put(C7887a.f26837Lh, fVar.f25087Oa);
        contentValues.put(C7887a.f26838Mh, fVar.channelId);
        contentValues.put(C7887a.f26839Nh, Integer.valueOf(!fVar.f25081Je));
        contentValues.put(C7887a.f26840Oh, m34265o(fVar.imgList));
        contentValues.put(C7887a.f26841Ph, Integer.valueOf(fVar.f25082Ke));
        contentValues.put(C7887a.f26842Qh, fVar.f25083Le);
        contentValues.put(C7887a.f26843Rh, m34265o(fVar.f25085Me));
        contentValues.put(C7887a.f26844Sh, m34265o(fVar.f25086Ne));
        contentValues.put(C7887a.f26845Th, m34265o(fVar.f25088Oe));
        contentValues.put(C7887a.f26846Uh, m34265o(fVar.f25089Pe));
        contentValues.put(C7887a.f26847Vh, m34265o(fVar.f25090Qe));
        contentValues.put(C7887a.f26848Wh, m34265o(fVar.f25091Re));
        contentValues.put(C7887a.f26849Xh, m34265o(fVar.f25092Se));
        contentValues.put(C7887a.f26850Yh, m34265o(fVar.f25093Te));
        contentValues.put(C7887a.f26851Zh, m34265o(fVar.f25094Ue));
        String o = m34265o(fVar.f25095Ve);
        String str = C7887a.f26852_h;
        contentValues.put(str, o);
        contentValues.put(str, m34265o(fVar.f25096We));
        return contentValues;
    }

    /* renamed from: o */
    private String m34265o(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) list.get(i));
            if (i != size - 1) {
                sb.append("_wspd_fd_dicovery_cadtab_");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
            if (r2 == 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
            return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0049, code lost:
            if (r2 != 0) goto L_0x0055;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [java.lang.String[], android.database.Cursor]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.database.Cursor]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor, java.lang.String[]]
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: L */
    public java.util.List<com.tencent.qqpim.discovery.internal.model.C7486a> mo38168L(int r5) {
        /*
        r4 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "select * from common_advertise_table where pos_id = "
        r0.append(r1)
        r0.append(r5)
        java.lang.String r5 = r0.toString()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "query sql::"
        r0.append(r1)
        r0.append(r5)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "CommonAdvertiseDao"
        discoveryAD.C7852Aa.m34154d(r1, r0)
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        r2 = 0
        discoveryAD.ba r3 = r4.f26810Vd     // Catch:{ all -> 0x0047 }
        android.database.sqlite.SQLiteDatabase r3 = r3.getReadableDatabase()     // Catch:{ all -> 0x0047 }
        android.database.Cursor r2 = r3.rawQuery(r5, r2)     // Catch:{ all -> 0x0047 }
    L_0x0037:
        if (r2 == 0) goto L_0x0049
        boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x0047 }
        if (r5 == 0) goto L_0x0049
        com.tencent.qqpim.discovery.internal.model.a r5 = r4.mo38173b(r2)     // Catch:{ all -> 0x0047 }
        r0.add(r5)     // Catch:{ all -> 0x0047 }
        goto L_0x0037
    L_0x0047:
        r5 = move-exception
        goto L_0x004c
    L_0x0049:
        if (r2 == 0) goto L_0x0058
        goto L_0x0055
    L_0x004c:
        java.lang.String r5 = com.tencent.p605ep.commonbase.api.Log.getStackTraceString(r5)     // Catch:{ all -> 0x0059 }
        discoveryAD.C7852Aa.m34157w(r1, r5)     // Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0058
    L_0x0055:
        r2.close()
    L_0x0058:
        return r0
    L_0x0059:
        r5 = move-exception
        if (r2 == 0) goto L_0x005f
        r2.close()
    L_0x005f:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7884Z.mo38168L(int):java.util.List");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7491f mo38169a(Cursor cursor) {
        C7491f fVar = new C7491f();
        fVar.uniqueKey = cursor.getString(cursor.getColumnIndex(C7887a.f26856hh));
        try {
            fVar.f25079He = Boolean.getBoolean(cursor.getString(cursor.getColumnIndex(C7887a.f26858jh)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        fVar.f25080Ie = cursor.getInt(cursor.getColumnIndex(C7887a.f26874zh));
        fVar.percentSpent = cursor.getInt(cursor.getColumnIndex(C7887a.f26873yh));
        fVar.positionId = cursor.getInt(cursor.getColumnIndex(C7887a.f26859kh));
        fVar.f25078Ge = cursor.getString(cursor.getColumnIndex("activity_id"));
        fVar.templateType = cursor.getInt(cursor.getColumnIndex(C7887a.f26860lh));
        fVar.text1 = cursor.getString(cursor.getColumnIndex(C7887a.f26861mh));
        fVar.text2 = cursor.getString(cursor.getColumnIndex(C7887a.f26862nh));
        fVar.text3 = cursor.getString(cursor.getColumnIndex(C7887a.f26863oh));
        fVar.text4 = cursor.getString(cursor.getColumnIndex(C7887a.f26872xh));
        fVar.imageUrl1 = cursor.getString(cursor.getColumnIndex(C7887a.f26864ph));
        fVar.imageUrl2 = cursor.getString(cursor.getColumnIndex(C7887a.f26865qh));
        fVar.imageUrl3 = cursor.getString(cursor.getColumnIndex(C7887a.f26866rh));
        fVar.contentType = cursor.getInt(cursor.getColumnIndex(C7887a.CONTENT_TYPE));
        fVar.jumpUrl = cursor.getString(cursor.getColumnIndex(C7887a.f26867sh));
        fVar.packageName = cursor.getString(cursor.getColumnIndex(C7887a.f26868th));
        fVar.f25098rc = cursor.getInt(cursor.getColumnIndex("expire_time"));
        fVar.context = cursor.getBlob(cursor.getColumnIndex("context"));
        fVar.effectiveTime = cursor.getInt(cursor.getColumnIndex(C7887a.f26825Ah));
        fVar.continuousExposureTime = cursor.getInt(cursor.getColumnIndex(C7887a.f26826Bh));
        fVar.exposureInterval = cursor.getInt(cursor.getColumnIndex(C7887a.f26827Ch));
        fVar.scenes = cursor.getInt(cursor.getColumnIndex(C7887a.f26828Dh));
        fVar.predisplaytime = cursor.getLong(cursor.getColumnIndex(C7887a.f26829Eh));
        fVar.videoUrl = cursor.getString(cursor.getColumnIndex(C7887a.f26830Fh));
        fVar.zipUrl = cursor.getString(cursor.getColumnIndex(C7887a.f26831Gh));
        fVar.appDownloadUrl = cursor.getString(cursor.getColumnIndex(C7887a.f26832Hh));
        boolean z = false;
        fVar.isAutoAppDownload = cursor.getInt(cursor.getColumnIndex(C7887a.f26834Ih)) == 1;
        fVar.isDeepLink = cursor.getInt(cursor.getColumnIndex(C7887a.f26835Jh)) == 1;
        fVar.rotation = cursor.getInt(cursor.getColumnIndex(C7887a.ROTATION)) == 0;
        fVar.f25084Ma = cursor.getInt(cursor.getColumnIndex(C7887a.f26836Kh));
        fVar.f25087Oa = cursor.getString(cursor.getColumnIndex(C7887a.f26837Lh));
        fVar.channelId = cursor.getString(cursor.getColumnIndex(C7887a.f26838Mh));
        if (cursor.getInt(cursor.getColumnIndex(C7887a.f26839Nh)) == 0) {
            z = true;
        }
        fVar.f25081Je = z;
        fVar.imgList = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26840Oh)));
        fVar.f25082Ke = cursor.getInt(cursor.getColumnIndex(C7887a.f26841Ph));
        fVar.f25083Le = cursor.getString(cursor.getColumnIndex(C7887a.f26842Qh));
        fVar.f25085Me = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26843Rh)));
        fVar.f25086Ne = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26844Sh)));
        fVar.f25088Oe = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26845Th)));
        fVar.f25089Pe = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26846Uh)));
        fVar.f25090Qe = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26847Vh)));
        fVar.f25091Re = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26848Wh)));
        fVar.f25092Se = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26849Xh)));
        fVar.f25093Te = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26850Yh)));
        fVar.f25094Ue = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26851Zh)));
        fVar.f25095Ve = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26852_h)));
        fVar.f25096We = m34259P(cursor.getString(cursor.getColumnIndex(C7887a.f26853ai)));
        return fVar;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
            if (r1 != 0) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a1, code lost:
            if (r1 == 0) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a3, code lost:
            r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a6, code lost:
            return r7;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v1, types: [java.lang.String[], android.database.Cursor]
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.database.Cursor]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor, java.lang.String[]]
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    public java.util.List<com.tencent.qqpim.discovery.internal.model.C7486a> mo38170a(int r6, java.util.List<java.lang.Integer> r7) {
        /*
        r5 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "select * from common_advertise_table where pos_id = "
        if (r7 == 0) goto L_0x0050
        boolean r2 = r7.isEmpty()
        if (r2 != 0) goto L_0x0050
        int r2 = r7.size()
        r3 = 0
    L_0x0014:
        if (r3 >= r2) goto L_0x0029
        java.lang.Object r4 = r7.get(r3)
        r0.append(r4)
        int r4 = r2 + -1
        if (r3 == r4) goto L_0x0026
        java.lang.String r4 = ","
        r0.append(r4)
    L_0x0026:
        int r3 = r3 + 1
        goto L_0x0014
    L_0x0029:
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        r7.append(r1)
        r7.append(r6)
        java.lang.String r6 = " and "
        r7.append(r6)
        java.lang.String r6 = "template_type"
        r7.append(r6)
        java.lang.String r6 = " IN ("
        r7.append(r6)
        java.lang.String r6 = r0.toString()
        r7.append(r6)
        java.lang.String r6 = " )"
        r7.append(r6)
        goto L_0x005b
    L_0x0050:
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        r7.append(r1)
        r7.append(r6)
    L_0x005b:
        java.lang.String r6 = r7.toString()
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        java.lang.String r0 = "query sql::"
        r7.append(r0)
        r7.append(r6)
        java.lang.String r7 = r7.toString()
        java.lang.String r0 = "CommonAdvertiseDao"
        discoveryAD.C7852Aa.m34154d(r0, r7)
        java.util.ArrayList r7 = new java.util.ArrayList
        r7.<init>()
        r1 = 0
        discoveryAD.ba r2 = r5.f26810Vd     // Catch:{ all -> 0x0095 }
        android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ all -> 0x0095 }
        android.database.Cursor r1 = r2.rawQuery(r6, r1)     // Catch:{ all -> 0x0095 }
    L_0x0085:
        if (r1 == 0) goto L_0x0097
        boolean r6 = r1.moveToNext()     // Catch:{ all -> 0x0095 }
        if (r6 == 0) goto L_0x0097
        com.tencent.qqpim.discovery.internal.model.a r6 = r5.mo38173b(r1)     // Catch:{ all -> 0x0095 }
        r7.add(r6)     // Catch:{ all -> 0x0095 }
        goto L_0x0085
    L_0x0095:
        r6 = move-exception
        goto L_0x009a
    L_0x0097:
        if (r1 == 0) goto L_0x00a6
        goto L_0x00a3
    L_0x009a:
        java.lang.String r6 = com.tencent.p605ep.commonbase.api.Log.getStackTraceString(r6)     // Catch:{ all -> 0x00a7 }
        discoveryAD.C7852Aa.m34157w(r0, r6)     // Catch:{ all -> 0x00a7 }
        if (r1 == 0) goto L_0x00a6
    L_0x00a3:
        r1.close()
    L_0x00a6:
        return r7
    L_0x00a7:
        r6 = move-exception
        if (r1 == 0) goto L_0x00ad
        r1.close()
    L_0x00ad:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7884Z.mo38170a(int, java.util.List):java.util.List");
    }

    /* renamed from: a */
    public void mo38171a(String str, C7885a aVar) {
        String str2 = "uniquekey =?";
        ContentValues d = m34261d(C7887a.f26857ih, aVar.getState());
        d.put(C7887a.f26870vh, Integer.valueOf(aVar.f26817tc));
        d.put(C7887a.f26871wh, Integer.valueOf(aVar.f26818uc));
        d.put("expire_time", Integer.valueOf(aVar.f26815rc));
        d.put(C7887a.WEIGHT, Integer.valueOf(aVar.f26820wc));
        d.put(C7887a.f26829Eh, Long.valueOf(aVar.f26821xc));
        try {
            this.f26810Vd.getWritableDatabase().update(C7886aa.f26824Zd, d, str2, new String[]{str});
        } catch (Throwable th) {
            C7852Aa.m34157w(TAG, Log.getStackTraceString(th));
        }
    }

    /* renamed from: a */
    public void mo38172a(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("?");
            for (int i = 1; i < strArr.length; i++) {
                sb.append(",?");
            }
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("uniquekey in(");
            sb3.append(sb2);
            sb3.append(")");
            try {
                this.f26810Vd.getWritableDatabase().delete(C7886aa.f26824Zd, sb3.toString(), strArr);
            } catch (Throwable th) {
                C7852Aa.m34157w(TAG, Log.getStackTraceString(th));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C7486a mo38173b(Cursor cursor) {
        C7486a aVar = new C7486a();
        aVar.f25065te = mo38169a(cursor);
        aVar.f25062W = cursor.getInt(cursor.getColumnIndex(C7887a.f26857ih));
        aVar.f25063Wb = cursor.getInt(cursor.getColumnIndex(C7887a.f26870vh));
        aVar.f25064Xb = cursor.getInt(cursor.getColumnIndex(C7887a.f26871wh));
        aVar.weight = cursor.getInt(cursor.getColumnIndex(C7887a.WEIGHT));
        return aVar;
    }

    /* renamed from: c */
    public synchronized void mo38174c(C7486a aVar) {
        C7852Aa.m34156i("CommonAdvertiseDao save(DbUnifiedData data) beign");
        if (query(aVar.f25065te.uniqueKey) != null) {
            m34263f(aVar);
        } else {
            m34262e(aVar);
        }
        C7852Aa.m34156i("CommonAdvertiseDao save(DbUnifiedData data) end");
    }

    public void delete(String str) {
        try {
            this.f26810Vd.getWritableDatabase().delete(C7886aa.f26824Zd, "uniquekey =? ", new String[]{str});
        } catch (Throwable th) {
            C7852Aa.m34157w(TAG, Log.getStackTraceString(th));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
            if (r0 != null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
            r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r8.printStackTrace();
     */
    /* JADX WARNING: Incorrect condition in loop: B:12:0x002d */
    /* renamed from: e */
    public synchronized void mo38176e(java.util.List<com.tencent.qqpim.discovery.internal.model.C7491f> r8) {
        /*
        r7 = this;
        monitor-enter(r7)
        java.lang.String r0 = "CommonAdvertiseDao delete(List<DbUnifiedData> datas) beign"
        discoveryAD.C7852Aa.m34156i(r0)     // Catch:{ all -> 0x0070 }
        int r0 = r8.size()     // Catch:{ all -> 0x0070 }
        r1 = 0
        r2 = 1
        if (r0 != r2) goto L_0x001b
        java.lang.Object r8 = r8.get(r1)     // Catch:{ all -> 0x0070 }
        com.tencent.qqpim.discovery.internal.model.f r8 = (com.tencent.qqpim.discovery.internal.model.C7491f) r8     // Catch:{ all -> 0x0070 }
        java.lang.String r8 = r8.uniqueKey     // Catch:{ all -> 0x0070 }
        r7.delete(r8)     // Catch:{ all -> 0x0070 }
        monitor-exit(r7)
        return
    L_0x001b:
        r0 = 0
        discoveryAD.ba r3 = r7.f26810Vd     // Catch:{ all -> 0x0049 }
        android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch:{ all -> 0x0049 }
        r0.beginTransaction()     // Catch:{ all -> 0x0049 }
        java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0049 }
    L_0x0029:
        boolean r3 = r8.hasNext()     // Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x0043
        java.lang.Object r3 = r8.next()     // Catch:{ all -> 0x0049 }
        com.tencent.qqpim.discovery.internal.model.f r3 = (com.tencent.qqpim.discovery.internal.model.C7491f) r3     // Catch:{ all -> 0x0049 }
        java.lang.String r4 = "common_advertise_table"
        java.lang.String r5 = "uniquekey =? "
        java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ all -> 0x0049 }
        java.lang.String r3 = r3.uniqueKey     // Catch:{ all -> 0x0049 }
        r6[r1] = r3     // Catch:{ all -> 0x0049 }
        r0.delete(r4, r5, r6)     // Catch:{ all -> 0x0049 }
        goto L_0x0029
    L_0x0043:
        r0.setTransactionSuccessful()     // Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x005d
        goto L_0x0055
    L_0x0049:
        r8 = move-exception
        java.lang.String r1 = "CommonAdvertiseDao"
        java.lang.String r8 = com.tencent.p605ep.commonbase.api.Log.getStackTraceString(r8)     // Catch:{ all -> 0x0064 }
        discoveryAD.C7852Aa.m34157w(r1, r8)     // Catch:{ all -> 0x0064 }
        if (r0 == 0) goto L_0x005d
    L_0x0055:
        r0.endTransaction()     // Catch:{ SQLiteException -> 0x0059 }
        goto L_0x005d
    L_0x0059:
        r8 = move-exception
        r8.printStackTrace()     // Catch:{ all -> 0x0070 }
    L_0x005d:
        java.lang.String r8 = "CommonAdvertiseDao delete(List<DbUnifiedData> datas) end"
        discoveryAD.C7852Aa.m34156i(r8)     // Catch:{ all -> 0x0070 }
        monitor-exit(r7)
        return
    L_0x0064:
        r8 = move-exception
        if (r0 == 0) goto L_0x006f
        r0.endTransaction()     // Catch:{ SQLiteException -> 0x006b }
        goto L_0x006f
    L_0x006b:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ all -> 0x0070 }
    L_0x006f:
        throw r8     // Catch:{ all -> 0x0070 }
    L_0x0070:
        r8 = move-exception
        monitor-exit(r7)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7884Z.mo38176e(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x011f, code lost:
            if (r12 != null) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
            r12.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0125, code lost:
            r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
            r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00aa, code lost:
            if (r5 != null) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ba, code lost:
            if (r5 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            r5.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x010e, code lost:
            if (r12 != null) goto L_0x0121;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0081 A[SYNTHETIC, Splitter:B:40:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0092 A[SYNTHETIC, Splitter:B:48:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0098 A[Catch:{ all -> 0x00a0, all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009c A[Catch:{ all -> 0x00a0, all -> 0x00ad }] */
    /* renamed from: f */
    public synchronized void mo38177f(java.util.List<com.tencent.qqpim.discovery.internal.model.C7486a> r12) {
        /*
        r11 = this;
        monitor-enter(r11)
        java.lang.String r0 = "CommonAdvertiseDao save(List<DbUnifiedData> datas) beigin"
        discoveryAD.C7852Aa.m34156i(r0)     // Catch:{ all -> 0x0148 }
        int r0 = r12.size()     // Catch:{ all -> 0x0148 }
        r1 = 0
        r2 = 1
        if (r0 != r2) goto L_0x0019
        java.lang.Object r12 = r12.get(r1)     // Catch:{ all -> 0x0148 }
        com.tencent.qqpim.discovery.internal.model.a r12 = (com.tencent.qqpim.discovery.internal.model.C7486a) r12     // Catch:{ all -> 0x0148 }
        r11.mo38174c(r12)     // Catch:{ all -> 0x0148 }
        monitor-exit(r11)
        return
    L_0x0019:
        java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0148 }
        r3 = 5
        r0.<init>(r3)     // Catch:{ all -> 0x0148 }
        java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0148 }
        r4.<init>(r3)     // Catch:{ all -> 0x0148 }
        r3 = 0
        discoveryAD.ba r5 = r11.f26810Vd     // Catch:{ all -> 0x00af }
        android.database.sqlite.SQLiteDatabase r5 = r5.getReadableDatabase()     // Catch:{ all -> 0x00af }
        r5.beginTransaction()     // Catch:{ all -> 0x00ad }
        java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x00ad }
    L_0x0032:
        boolean r6 = r12.hasNext()     // Catch:{ all -> 0x00ad }
        if (r6 == 0) goto L_0x00a7
        java.lang.Object r6 = r12.next()     // Catch:{ all -> 0x00ad }
        com.tencent.qqpim.discovery.internal.model.a r6 = (com.tencent.qqpim.discovery.internal.model.C7486a) r6     // Catch:{ all -> 0x00ad }
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
        r7.<init>()     // Catch:{ all -> 0x00ad }
        java.lang.String r8 = "select * from common_advertise_table where uniquekey = '"
        r7.append(r8)     // Catch:{ all -> 0x00ad }
        com.tencent.qqpim.discovery.internal.model.f r8 = r6.f25065te     // Catch:{ all -> 0x00ad }
        java.lang.String r8 = r8.uniqueKey     // Catch:{ all -> 0x00ad }
        r7.append(r8)     // Catch:{ all -> 0x00ad }
        java.lang.String r8 = "'"
        r7.append(r8)     // Catch:{ all -> 0x00ad }
        java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00ad }
        java.lang.String r8 = "CommonAdvertiseDao"
        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
        r9.<init>()     // Catch:{ all -> 0x00ad }
        java.lang.String r10 = "query sql::"
        r9.append(r10)     // Catch:{ all -> 0x00ad }
        r9.append(r7)     // Catch:{ all -> 0x00ad }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00ad }
        discoveryAD.C7852Aa.m34154d(r8, r9)     // Catch:{ all -> 0x00ad }
        android.database.Cursor r7 = r5.rawQuery(r7, r3)     // Catch:{ all -> 0x0085 }
        if (r7 == 0) goto L_0x007e
        boolean r8 = r7.moveToNext()     // Catch:{ all -> 0x007c }
        if (r8 == 0) goto L_0x007e
        r8 = 1
        goto L_0x007f
    L_0x007c:
        r8 = move-exception
        goto L_0x0087
    L_0x007e:
        r8 = 0
    L_0x007f:
        if (r7 == 0) goto L_0x0096
        r7.close()     // Catch:{ all -> 0x00ad }
        goto L_0x0096
    L_0x0085:
        r8 = move-exception
        r7 = r3
    L_0x0087:
        java.lang.String r9 = "CommonAdvertiseDao"
        java.lang.String r8 = com.tencent.p605ep.commonbase.api.Log.getStackTraceString(r8)     // Catch:{ all -> 0x00a0 }
        discoveryAD.C7852Aa.m34154d(r9, r8)     // Catch:{ all -> 0x00a0 }
        if (r7 == 0) goto L_0x0095
        r7.close()     // Catch:{ all -> 0x00ad }
    L_0x0095:
        r8 = 0
    L_0x0096:
        if (r8 == 0) goto L_0x009c
        r0.add(r6)     // Catch:{ all -> 0x00ad }
        goto L_0x0032
    L_0x009c:
        r4.add(r6)     // Catch:{ all -> 0x00ad }
        goto L_0x0032
    L_0x00a0:
        r12 = move-exception
        if (r7 == 0) goto L_0x00a6
        r7.close()     // Catch:{ all -> 0x00ad }
    L_0x00a6:
        throw r12     // Catch:{ all -> 0x00ad }
    L_0x00a7:
        r5.setTransactionSuccessful()     // Catch:{ all -> 0x00ad }
        if (r5 == 0) goto L_0x00c4
        goto L_0x00bc
    L_0x00ad:
        r12 = move-exception
        goto L_0x00b1
    L_0x00af:
        r12 = move-exception
        r5 = r3
    L_0x00b1:
        java.lang.String r6 = "CommonAdvertiseDao"
        java.lang.String r12 = com.tencent.p605ep.commonbase.api.Log.getStackTraceString(r12)     // Catch:{ all -> 0x013c }
        discoveryAD.C7852Aa.m34157w(r6, r12)     // Catch:{ all -> 0x013c }
        if (r5 == 0) goto L_0x00c4
    L_0x00bc:
        r5.endTransaction()     // Catch:{ SQLiteException -> 0x00c0 }
        goto L_0x00c4
    L_0x00c0:
        r12 = move-exception
        r12.printStackTrace()     // Catch:{ all -> 0x0148 }
    L_0x00c4:
        discoveryAD.ba r12 = r11.f26810Vd     // Catch:{ all -> 0x0113 }
        android.database.sqlite.SQLiteDatabase r12 = r12.getWritableDatabase()     // Catch:{ all -> 0x0113 }
        r12.beginTransaction()     // Catch:{ all -> 0x0111 }
        java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0111 }
    L_0x00d1:
        boolean r5 = r0.hasNext()     // Catch:{ all -> 0x0111 }
        if (r5 == 0) goto L_0x00f1
        java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x0111 }
        com.tencent.qqpim.discovery.internal.model.a r5 = (com.tencent.qqpim.discovery.internal.model.C7486a) r5     // Catch:{ all -> 0x0111 }
        java.lang.String r6 = "uniquekey =?"
        android.content.ContentValues r7 = r11.m34260d(r5)     // Catch:{ all -> 0x0111 }
        java.lang.String r8 = "common_advertise_table"
        java.lang.String[] r9 = new java.lang.String[r2]     // Catch:{ all -> 0x0111 }
        com.tencent.qqpim.discovery.internal.model.f r5 = r5.f25065te     // Catch:{ all -> 0x0111 }
        java.lang.String r5 = r5.uniqueKey     // Catch:{ all -> 0x0111 }
        r9[r1] = r5     // Catch:{ all -> 0x0111 }
        r12.update(r8, r7, r6, r9)     // Catch:{ all -> 0x0111 }
        goto L_0x00d1
    L_0x00f1:
        java.util.Iterator r0 = r4.iterator()     // Catch:{ all -> 0x0111 }
    L_0x00f5:
        boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0111 }
        if (r1 == 0) goto L_0x010b
        java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0111 }
        com.tencent.qqpim.discovery.internal.model.a r1 = (com.tencent.qqpim.discovery.internal.model.C7486a) r1     // Catch:{ all -> 0x0111 }
        android.content.ContentValues r1 = r11.m34260d(r1)     // Catch:{ all -> 0x0111 }
        java.lang.String r2 = "common_advertise_table"
        r12.insert(r2, r3, r1)     // Catch:{ all -> 0x0111 }
        goto L_0x00f5
    L_0x010b:
        r12.setTransactionSuccessful()     // Catch:{ all -> 0x0111 }
        if (r12 == 0) goto L_0x0129
        goto L_0x0121
    L_0x0111:
        r0 = move-exception
        goto L_0x0116
    L_0x0113:
        r12 = move-exception
        r0 = r12
        r12 = r3
    L_0x0116:
        java.lang.String r1 = "CommonAdvertiseDao"
        java.lang.String r0 = com.tencent.p605ep.commonbase.api.Log.getStackTraceString(r0)     // Catch:{ all -> 0x0130 }
        discoveryAD.C7852Aa.m34157w(r1, r0)     // Catch:{ all -> 0x0130 }
        if (r12 == 0) goto L_0x0129
    L_0x0121:
        r12.endTransaction()     // Catch:{ SQLiteException -> 0x0125 }
        goto L_0x0129
    L_0x0125:
        r12 = move-exception
        r12.printStackTrace()     // Catch:{ all -> 0x0148 }
    L_0x0129:
        java.lang.String r12 = "CommonAdvertiseDao save(List<DbUnifiedData> datas) end"
        discoveryAD.C7852Aa.m34156i(r12)     // Catch:{ all -> 0x0148 }
        monitor-exit(r11)
        return
    L_0x0130:
        r0 = move-exception
        if (r12 == 0) goto L_0x013b
        r12.endTransaction()     // Catch:{ SQLiteException -> 0x0137 }
        goto L_0x013b
    L_0x0137:
        r12 = move-exception
        r12.printStackTrace()     // Catch:{ all -> 0x0148 }
    L_0x013b:
        throw r0     // Catch:{ all -> 0x0148 }
    L_0x013c:
        r12 = move-exception
        if (r5 == 0) goto L_0x0147
        r5.endTransaction()     // Catch:{ SQLiteException -> 0x0143 }
        goto L_0x0147
    L_0x0143:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ all -> 0x0148 }
    L_0x0147:
        throw r12     // Catch:{ all -> 0x0148 }
    L_0x0148:
        r12 = move-exception
        monitor-exit(r11)
        throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7884Z.mo38177f(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
            r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
            if (r0 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
            r0 = new java.lang.StringBuilder();
            r0.append("query():");
            r0.append(r5);
            r0.append(" dbData=");
            r0.append(r1);
            discoveryAD.C7852Aa.m34154d(r2, r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0075, code lost:
            return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
            if (r0 != null) goto L_0x0048;
     */
    public com.tencent.qqpim.discovery.internal.model.C7486a query(java.lang.String r5) {
        /*
        r4 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "select * from common_advertise_table where uniquekey = '"
        r0.append(r1)
        r0.append(r5)
        java.lang.String r1 = "'"
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        java.lang.String r2 = "query sql::"
        r1.append(r2)
        r1.append(r0)
        java.lang.String r1 = r1.toString()
        java.lang.String r2 = "CommonAdvertiseDao"
        discoveryAD.C7852Aa.m34154d(r2, r1)
        r1 = 0
        discoveryAD.ba r3 = r4.f26810Vd     // Catch:{ all -> 0x004c }
        android.database.sqlite.SQLiteDatabase r3 = r3.getReadableDatabase()     // Catch:{ all -> 0x004c }
        android.database.Cursor r0 = r3.rawQuery(r0, r1)     // Catch:{ all -> 0x004c }
        if (r0 == 0) goto L_0x0046
        boolean r3 = r0.moveToNext()     // Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x0046
        com.tencent.qqpim.discovery.internal.model.a r1 = r4.mo38173b(r0)     // Catch:{ all -> 0x0044 }
        goto L_0x0046
    L_0x0044:
        r3 = move-exception
        goto L_0x004f
    L_0x0046:
        if (r0 == 0) goto L_0x0059
    L_0x0048:
        r0.close()
        goto L_0x0059
    L_0x004c:
        r0 = move-exception
        r3 = r0
        r0 = r1
    L_0x004f:
        java.lang.String r3 = com.tencent.p605ep.commonbase.api.Log.getStackTraceString(r3)     // Catch:{ all -> 0x0076 }
        discoveryAD.C7852Aa.m34157w(r2, r3)     // Catch:{ all -> 0x0076 }
        if (r0 == 0) goto L_0x0059
        goto L_0x0048
    L_0x0059:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r3 = "query():"
        r0.append(r3)
        r0.append(r5)
        java.lang.String r5 = " dbData="
        r0.append(r5)
        r0.append(r1)
        java.lang.String r5 = r0.toString()
        discoveryAD.C7852Aa.m34154d(r2, r5)
        return r1
    L_0x0076:
        r5 = move-exception
        if (r0 == 0) goto L_0x007c
        r0.close()
    L_0x007c:
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7884Z.query(java.lang.String):com.tencent.qqpim.discovery.internal.model.a");
    }
}
