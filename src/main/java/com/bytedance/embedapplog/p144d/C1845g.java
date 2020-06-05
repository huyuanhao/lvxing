package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.p143c.C1835a;
import com.bytedance.embedapplog.util.C1856h;
import com.tencent.android.tpush.SettingsContentProvider;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.g */
public class C1845g extends C1838a {
    /* renamed from: h */
    public byte[] f5186h;
    /* renamed from: i */
    int f5187i;
    /* renamed from: j */
    public int f5188j;
    /* renamed from: k */
    private JSONArray f5189k;
    /* renamed from: l */
    private JSONArray f5190l;
    /* renamed from: m */
    private C1844f f5191m;
    /* renamed from: n */
    private JSONArray f5192n;
    /* renamed from: o */
    private C1848j f5193o;
    /* renamed from: p */
    private JSONObject f5194p;
    /* renamed from: q */
    private JSONArray f5195q;

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13466d() {
        return "pack";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13486a(long j, JSONObject jSONObject, C1844f fVar, C1848j jVar, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        this.f5155a = j;
        this.f5194p = jSONObject;
        this.f5191m = fVar;
        this.f5193o = jVar;
        this.f5192n = null;
        this.f5189k = jSONArray2;
        this.f5190l = jSONArray3;
        this.f5195q = jSONArray4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String[] mo13460a() {
        return new String[]{"local_time_ms", SettingsContentProvider.INT_TYPE, "_data", "blob", "_fail", SettingsContentProvider.INT_TYPE, "_full", SettingsContentProvider.INT_TYPE};
    }

    /* renamed from: a */
    public C1838a mo13457a(Cursor cursor) {
        this.f5155a = cursor.getLong(0);
        this.f5186h = cursor.getBlob(1);
        this.f5187i = cursor.getInt(2);
        this.f5194p = null;
        this.f5191m = null;
        this.f5193o = null;
        this.f5192n = null;
        this.f5189k = null;
        this.f5190l = null;
        this.f5195q = null;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13458a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("_data", AppLog.toEncryptByte(mo13468f().toString()));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063 A[SYNTHETIC, Splitter:B:35:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x006a A[SYNTHETIC, Splitter:B:39:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0072 A[SYNTHETIC, Splitter:B:46:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0079 A[SYNTHETIC, Splitter:B:50:0x0079] */
    /* renamed from: i */
    public java.lang.String mo13487i() {
        /*
        r7 = this;
        r0 = 0
        boolean r1 = com.bytedance.embedapplog.AppLog.getEncryptAndCompress()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        if (r1 == 0) goto L_0x001f
        byte[] r1 = r7.f5186h     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        byte[] r2 = r7.f5186h     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        int r2 = r2.length     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        byte[] r1 = com.bytedance.embedapplog.util.TTEncryptUtils.m6553b(r1, r2)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        r7.f5186h = r1     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        byte[] r3 = r7.f5186h     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        r2.<init>(r3)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        r1.<init>(r2)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        goto L_0x0026
    L_0x001f:
        java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        byte[] r2 = r7.f5186h     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        r1.<init>(r2)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
    L_0x0026:
        r2 = 8192(0x2000, float:1.14794E-41)
        byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0052, all -> 0x004d }
        java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0052, all -> 0x004d }
        r3.<init>()     // Catch:{ IOException -> 0x0052, all -> 0x004d }
    L_0x002f:
        int r4 = r1.read(r2)     // Catch:{ IOException -> 0x004b, all -> 0x0046 }
        r5 = -1
        if (r4 == r5) goto L_0x003b
        r5 = 0
        r3.write(r2, r5, r4)     // Catch:{ IOException -> 0x004b, all -> 0x0046 }
        goto L_0x002f
    L_0x003b:
        java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x004b, all -> 0x0046 }
        r1.close()     // Catch:{ Exception -> 0x0042 }
    L_0x0042:
        r3.close()     // Catch:{ Exception -> 0x0045 }
    L_0x0045:
        return r0
    L_0x0046:
        r0 = move-exception
        r6 = r1
        r1 = r0
        r0 = r6
        goto L_0x0070
    L_0x004b:
        r2 = move-exception
        goto L_0x0054
    L_0x004d:
        r2 = move-exception
        r3 = r0
        r0 = r1
        r1 = r2
        goto L_0x0070
    L_0x0052:
        r2 = move-exception
        r3 = r0
    L_0x0054:
        r6 = r2
        r2 = r1
        r1 = r6
        goto L_0x005e
    L_0x0058:
        r1 = move-exception
        r3 = r0
        goto L_0x0070
    L_0x005b:
        r1 = move-exception
        r2 = r0
        r3 = r2
    L_0x005e:
        r1.printStackTrace()     // Catch:{ all -> 0x006e }
        if (r2 == 0) goto L_0x0068
        r2.close()     // Catch:{ Exception -> 0x0067 }
        goto L_0x0068
    L_0x0068:
        if (r3 == 0) goto L_0x006d
        r3.close()     // Catch:{ Exception -> 0x006d }
    L_0x006d:
        return r0
    L_0x006e:
        r1 = move-exception
        r0 = r2
    L_0x0070:
        if (r0 == 0) goto L_0x0077
        r0.close()     // Catch:{ Exception -> 0x0076 }
        goto L_0x0077
    L_0x0077:
        if (r3 == 0) goto L_0x007c
        r3.close()     // Catch:{ Exception -> 0x007c }
    L_0x007c:
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.p144d.C1845g.mo13487i():java.lang.String");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13459a(JSONObject jSONObject) {
        C1856h.m6582a(null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONObject mo13463b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.f5194p);
        jSONObject.put("time_sync", C1835a.f5134a);
        if (this.f5191m != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f5191m.mo13468f());
            jSONObject.put("launch", jSONArray);
        }
        C1848j jVar = this.f5193o;
        int i = 0;
        if (jVar != null) {
            JSONObject f = jVar.mo13468f();
            JSONArray jSONArray2 = this.f5192n;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            for (int i2 = 0; i2 < length; i2++) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(new JSONObject(this.f5192n.optString(i2)).optString("params"));
                jSONArray4.put(0, jSONObject2.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
            }
            if (length > 0) {
                f.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(f);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.f5189k;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f5189k);
        }
        JSONArray jSONArray7 = this.f5192n;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        if (this.f5190l == null) {
            this.f5190l = this.f5192n;
        } else if (length3 > 0) {
            for (int i3 = 0; i3 < length3; i3++) {
                this.f5190l.put(this.f5192n.get(i3));
            }
        }
        JSONArray jSONArray8 = this.f5190l;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.f5190l);
        }
        JSONArray jSONArray9 = this.f5195q;
        if (jSONArray9 != null) {
            i = jSONArray9.length();
        }
        if (i > 0) {
            jSONObject.put("log_data", this.f5195q);
        }
        StringBuilder sb = new StringBuilder("wP {");
        Object obj = this.f5191m;
        if (obj == null) {
            obj = "la";
        }
        sb.append(obj);
        sb.append(", ");
        Object obj2 = this.f5193o;
        if (obj2 == null) {
            obj2 = "te";
        }
        sb.append(obj2);
        sb.append(", p: ");
        sb.append(length3);
        sb.append(", v1: ");
        sb.append(length2);
        sb.append(", v3: ");
        sb.append(length4);
        String str = "}";
        sb.append(str);
        sb.append(", m: ");
        sb.append(i);
        sb.append(str);
        C1856h.m6585d(sb.toString(), null);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1838a mo13462b(JSONObject jSONObject) {
        C1856h.m6582a(null);
        return null;
    }
}
