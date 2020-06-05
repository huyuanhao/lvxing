package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.util.C1855g;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.i */
public class C1847i extends C1838a {
    /* renamed from: h */
    static String f5200h = "succEvent";
    /* renamed from: i */
    public int f5201i;
    /* renamed from: j */
    private String f5202j;
    /* renamed from: k */
    private int f5203k;
    /* renamed from: l */
    private String f5204l;
    /* renamed from: m */
    private int f5205m;
    /* renamed from: n */
    private long f5206n;

    C1847i() {
    }

    public C1847i(String str, String str2, int i) {
        this.f5203k = 1;
        this.f5201i = AppLog.getSuccRate();
        this.f5202j = str;
        this.f5204l = str2;
        this.f5205m = i;
        this.f5206n = C1855g.m6575a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String[] mo13460a() {
        return new String[]{"local_time_ms", SettingsContentProvider.INT_TYPE, "tea_event_index", SettingsContentProvider.INT_TYPE, AccountConst.KEY_SESSION_ID, "varchar", "user_unique_id", "varchar", "event_name", "varchar", "is_monitor", SettingsContentProvider.INT_TYPE, "bav_monitor_rate", SettingsContentProvider.INT_TYPE, "monitor_status", "varchar", "monitor_num", SettingsContentProvider.INT_TYPE, MessageKey.MSG_DATE, SettingsContentProvider.INT_TYPE};
    }

    /* renamed from: a */
    public C1838a mo13457a(Cursor cursor) {
        this.f5155a = cursor.getLong(0);
        this.f5156b = cursor.getLong(1);
        this.f5157c = cursor.getString(2);
        this.f5158d = cursor.getString(3);
        this.f5202j = cursor.getString(4);
        this.f5203k = cursor.getInt(5);
        this.f5201i = cursor.getInt(6);
        this.f5204l = cursor.getString(7);
        this.f5205m = cursor.getInt(8);
        this.f5206n = cursor.getLong(9);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13458a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f5155a));
        contentValues.put("tea_event_index", Long.valueOf(this.f5156b));
        contentValues.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        contentValues.put("user_unique_id", this.f5158d);
        contentValues.put("event_name", this.f5202j);
        contentValues.put("is_monitor", Integer.valueOf(this.f5203k));
        contentValues.put("bav_monitor_rate", Integer.valueOf(this.f5201i));
        contentValues.put("monitor_status", this.f5204l);
        contentValues.put("monitor_num", Integer.valueOf(this.f5205m));
        contentValues.put(MessageKey.MSG_DATE, Long.valueOf(this.f5206n));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13459a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f5155a);
        jSONObject.put("tea_event_index", this.f5156b);
        jSONObject.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        jSONObject.put("user_unique_id", this.f5158d);
        jSONObject.put("event_name", this.f5202j);
        jSONObject.put("is_monitor", this.f5203k);
        jSONObject.put("bav_monitor_rate", this.f5201i);
        jSONObject.put("monitor_status", this.f5204l);
        jSONObject.put("monitor_num", this.f5205m);
        jSONObject.put(MessageKey.MSG_DATE, this.f5206n);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONObject mo13463b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event_name", this.f5202j);
        jSONObject.put("is_monitor", this.f5203k);
        jSONObject.put("bav_monitor_rate", this.f5201i);
        jSONObject.put("monitor_status", this.f5204l);
        jSONObject.put("monitor_num", this.f5205m);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1838a mo13462b(JSONObject jSONObject) {
        this.f5155a = jSONObject.optLong("local_time_ms", 0);
        this.f5156b = jSONObject.optLong("tea_event_index", 0);
        this.f5157c = jSONObject.optString(AccountConst.KEY_SESSION_ID, null);
        this.f5158d = jSONObject.optString("user_unique_id", null);
        this.f5202j = jSONObject.optString("event_name", null);
        this.f5203k = jSONObject.optInt("is_monitor", 0);
        this.f5201i = jSONObject.optInt("bav_monitor_rate", 0);
        this.f5204l = jSONObject.optString("monitor_status", null);
        this.f5205m = jSONObject.optInt("monitor_num", 0);
        this.f5206n = jSONObject.optLong(MessageKey.MSG_DATE, 0);
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13466d() {
        return f5200h;
    }
}
