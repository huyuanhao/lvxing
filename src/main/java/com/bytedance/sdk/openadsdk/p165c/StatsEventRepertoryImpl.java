package com.bytedance.sdk.openadsdk.p165c;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.AdPreference;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter;
import com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a;
import com.bytedance.sdk.openadsdk.utils.ListUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.c.n */
public class StatsEventRepertoryImpl implements AdEventRepertory<C2424a> {
    /* renamed from: a */
    protected final AdPreference f6813a = AdPreference.m9212a(mo15041f());
    /* renamed from: b */
    private final Context f6814b;

    /* renamed from: d */
    public String mo15038d() {
        return "logstats";
    }

    public StatsEventRepertoryImpl(Context context) {
        this.f6814b = context;
    }

    /* renamed from: f */
    public Context mo15041f() {
        Context context = this.f6814b;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0021 */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0021 A[LOOP:0: B:4:0x0021->B:23:0x0021, LOOP_START, SYNTHETIC, Splitter:B:4:0x0021] */
    /* renamed from: a */
    public synchronized java.util.List<com.bytedance.sdk.openadsdk.p185f.p187b.LogUploaderImpl.C2424a> mo15003a() {
        /*
        r9 = this;
        monitor-enter(r9)
        java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x0058 }
        r0.<init>()     // Catch:{ all -> 0x0058 }
        android.content.Context r1 = r9.mo15041f()     // Catch:{ all -> 0x0058 }
        java.lang.String r2 = r9.mo15038d()     // Catch:{ all -> 0x0058 }
        java.lang.String r3 = "id"
        java.lang.String r4 = "value"
        java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ all -> 0x0058 }
        r4 = 0
        r5 = 0
        r6 = 0
        r7 = 0
        r8 = 0
        android.database.Cursor r1 = com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiAdapter.m11760a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x0056
    L_0x0021:
        boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x004f }
        if (r2 == 0) goto L_0x0049
        java.lang.String r2 = "id"
        int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x004f }
        java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x004f }
        java.lang.String r3 = "value"
        int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x004f }
        java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x004f }
        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0021 }
        r4.<init>(r3)     // Catch:{ JSONException -> 0x0021 }
        com.bytedance.sdk.openadsdk.f.b.c$a r3 = new com.bytedance.sdk.openadsdk.f.b.c$a     // Catch:{ JSONException -> 0x0021 }
        r3.m44016init(r2, r4)     // Catch:{ JSONException -> 0x0021 }
        r0.add(r3)     // Catch:{ JSONException -> 0x0021 }
        goto L_0x0021
    L_0x0049:
        if (r1 == 0) goto L_0x0056
        r1.close()     // Catch:{ all -> 0x0058 }
        goto L_0x0056
    L_0x004f:
        r0 = move-exception
        if (r1 == 0) goto L_0x0055
        r1.close()     // Catch:{ all -> 0x0058 }
    L_0x0055:
        throw r0     // Catch:{ all -> 0x0058 }
    L_0x0056:
        monitor-exit(r9)
        return r0
    L_0x0058:
        r0 = move-exception
        monitor-exit(r9)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.p165c.StatsEventRepertoryImpl.mo15003a():java.util.List");
    }

    /* renamed from: a */
    public synchronized void mo15006a(C2424a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.f8663a);
        contentValues.put(ArgKey.KEY_VALUE, aVar.f8664b != null ? aVar.f8664b.toString() : "");
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry", Integer.valueOf(0));
        DBMultiAdapter.m11763a(mo15041f(), mo15038d(), contentValues);
    }

    /* renamed from: a */
    public synchronized void mo15007a(List<C2424a> list) {
        if (!ListUtils.m12208a(list)) {
            LinkedList linkedList = new LinkedList();
            for (C2424a aVar : list) {
                linkedList.add(aVar.f8663a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ");
            sb.append(mo15038d());
            sb.append(" WHERE ");
            sb.append(m8514a("id", linkedList, 1000, true));
            DBMultiAdapter.m11762a(mo15041f(), sb.toString());
        }
    }

    /* renamed from: a */
    public synchronized void mo15005a(int i, long j) {
        m8515b(i, j);
    }

    /* renamed from: b */
    private synchronized void m8515b(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis);
        sb.append("");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        sb2.append("");
        DBMultiAdapter.m11758a(mo15041f(), mo15038d(), "gen_time <? AND retry >?", new String[]{sb.toString(), sb2.toString()});
    }

    /* renamed from: a */
    public synchronized void mo15008a(List<C2424a> list, int i, long j) {
        if (!ListUtils.m12208a(list)) {
            try {
                m8516b(list);
                m8515b(i, j);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    private synchronized void m8516b(List<C2424a> list) {
        LinkedList linkedList = new LinkedList();
        for (C2424a aVar : list) {
            linkedList.add(aVar.f8663a);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(mo15038d());
        sb.append(" SET ");
        sb.append("retry");
        sb.append(" = ");
        sb.append("retry");
        sb.append("+1");
        sb.append(" WHERE ");
        sb.append(m8514a("id", linkedList, 1000, true));
        DBMultiAdapter.m11762a(mo15041f(), sb.toString());
    }

    /* renamed from: a */
    public void mo15009a(boolean z) {
        this.f6813a.mo15323a("stats_serverbusy_flag", z);
    }

    /* renamed from: b */
    public boolean mo15010b() {
        return this.f6813a.mo15328b("stats_serverbusy_flag", false);
    }

    /* renamed from: c */
    public int mo15011c() {
        return this.f6813a.mo15325b("stats_serverbusy_retrycount", 0);
    }

    /* renamed from: a */
    public void mo15004a(int i) {
        this.f6813a.mo15320a("stats_serverbusy_retrycount", i);
    }

    /* renamed from: g */
    public static String m8517g() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("logstats");
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
    private static String m8514a(String str, List<?> list, int i, boolean z) {
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
            String a = m8513a(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
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
        return m8513a(sb2, sb3.toString());
    }

    /* renamed from: a */
    private static String m8513a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
