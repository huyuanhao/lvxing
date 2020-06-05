package com.bytedance.sdk.openadsdk.p165c;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.AdPreference;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter;
import com.bytedance.sdk.openadsdk.utils.ListUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.c.f */
public class AdEventRepertoryImpl implements AdEventRepertory<AdEvent> {
    /* renamed from: a */
    private final Context f6751a;
    /* renamed from: b */
    private final AdPreference f6752b = AdPreference.m9212a(mo15013d());

    public AdEventRepertoryImpl(Context context) {
        this.f6751a = context;
    }

    /* renamed from: d */
    public Context mo15013d() {
        Context context = this.f6751a;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001f */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x001f A[LOOP:0: B:4:0x001f->B:23:0x001f, LOOP_START, SYNTHETIC, Splitter:B:4:0x001f] */
    /* renamed from: a */
    public synchronized java.util.List<com.bytedance.sdk.openadsdk.p165c.AdEvent> mo15003a() {
        /*
        r9 = this;
        monitor-enter(r9)
        java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x0056 }
        r0.<init>()     // Catch:{ all -> 0x0056 }
        android.content.Context r1 = r9.mo15013d()     // Catch:{ all -> 0x0056 }
        java.lang.String r2 = "adevent"
        java.lang.String r3 = "id"
        java.lang.String r4 = "value"
        java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ all -> 0x0056 }
        r4 = 0
        r5 = 0
        r6 = 0
        r7 = 0
        r8 = 0
        android.database.Cursor r1 = com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter.m11760a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0054
    L_0x001f:
        boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x004d }
        if (r2 == 0) goto L_0x0047
        java.lang.String r2 = "id"
        int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x004d }
        java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x004d }
        java.lang.String r3 = "value"
        int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x004d }
        java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x004d }
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001f }
        r4.<init>(r3)     // Catch:{ JSONException -> 0x001f }
        com.bytedance.sdk.openadsdk.c.a r3 = new com.bytedance.sdk.openadsdk.c.a     // Catch:{ JSONException -> 0x001f }
        r3.m43377init(r2, r4)     // Catch:{ JSONException -> 0x001f }
        r0.add(r3)     // Catch:{ JSONException -> 0x001f }
        goto L_0x001f
    L_0x0047:
        if (r1 == 0) goto L_0x0054
        r1.close()     // Catch:{ all -> 0x0056 }
        goto L_0x0054
    L_0x004d:
        r0 = move-exception
        if (r1 == 0) goto L_0x0053
        r1.close()     // Catch:{ all -> 0x0056 }
    L_0x0053:
        throw r0     // Catch:{ all -> 0x0056 }
    L_0x0054:
        monitor-exit(r9)
        return r0
    L_0x0056:
        r0 = move-exception
        monitor-exit(r9)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p165c.AdEventRepertoryImpl.mo15003a():java.util.List");
    }

    /* renamed from: a */
    public synchronized void mo15006a(AdEvent aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.f6743a);
        contentValues.put(ArgKey.KEY_VALUE, aVar.f6744b != null ? aVar.f6744b.toString() : "");
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry", Integer.valueOf(0));
        DBMultiAdapter.m11763a(mo15013d(), "adevent", contentValues);
    }

    /* renamed from: a */
    public synchronized void mo15007a(List<AdEvent> list) {
        if (!ListUtils.m12208a(list)) {
            LinkedList linkedList = new LinkedList();
            for (AdEvent aVar : list) {
                linkedList.add(aVar.f6743a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM adevent WHERE ");
            sb.append(m8430a("id", linkedList, 1000, true));
            DBMultiAdapter.m11762a(mo15013d(), sb.toString());
        }
    }

    /* renamed from: a */
    public synchronized void mo15005a(int i, long j) {
        m8431b(i, j);
    }

    /* renamed from: b */
    private synchronized void m8431b(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis);
        sb.append("");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append("");
        DBMultiAdapter.m11758a(mo15013d(), "adevent", "gen_time <? AND retry >?", new String[]{sb.toString(), sb2.toString()});
    }

    /* renamed from: a */
    public synchronized void mo15008a(List<AdEvent> list, int i, long j) {
        if (!ListUtils.m12208a(list)) {
            try {
                m8432b(list);
                m8431b(i, j);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    private synchronized void m8432b(List<AdEvent> list) {
        LinkedList linkedList = new LinkedList();
        for (AdEvent aVar : list) {
            linkedList.add(aVar.f6743a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("adevent");
        sb.append(" SET ");
        sb.append("retry");
        sb.append(" = ");
        sb.append("retry");
        sb.append("+1");
        sb.append(" WHERE ");
        sb.append(m8430a("id", linkedList, 1000, true));
        DBMultiAdapter.m11762a(mo15013d(), sb.toString());
    }

    /* renamed from: a */
    public void mo15009a(boolean z) {
        this.f6752b.mo15323a("serverbusy_flag", z);
    }

    /* renamed from: b */
    public boolean mo15010b() {
        return this.f6752b.mo15328b("serverbusy_flag", false);
    }

    /* renamed from: c */
    public int mo15011c() {
        return this.f6752b.mo15325b("serverbusy_retrycount", 0);
    }

    /* renamed from: a */
    public void mo15004a(int i) {
        this.f6752b.mo15320a("serverbusy_retrycount", i);
    }

    /* renamed from: e */
    public static String m8433e() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("adevent");
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("id");
        sb.append(" TEXT UNIQUE,");
        sb.append(ArgKey.KEY_VALUE);
        sb.append(" TEXT ,");
        sb.append("gen_time");
        sb.append(" TEXT , ");
        sb.append("retry");
        sb.append(" INTEGER default 0");
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    private static String m8430a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String a = m8429a(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a);
            sb.append("')");
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str2);
        sb3.append("('')");
        return m8429a(sb2, sb3.toString());
    }

    /* renamed from: a */
    private static String m8429a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
