package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.c */
public class C1841c extends C1838a {
    /* renamed from: h */
    private String f5171h;
    /* renamed from: i */
    private String f5172i;
    /* renamed from: j */
    private String f5173j;
    /* renamed from: k */
    private String f5174k;
    /* renamed from: l */
    private long f5175l;
    /* renamed from: m */
    private long f5176m;

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13466d() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    public C1841c(String str, String str2, String str3, long j, long j2, String str4) {
        this.f5171h = str;
        this.f5172i = str2;
        this.f5173j = str3;
        this.f5175l = j;
        this.f5176m = j2;
        this.f5174k = str4;
    }

    C1841c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String[] mo13460a() {
        return new String[]{"local_time_ms", SettingsContentProvider.INT_TYPE, "tea_event_index", SettingsContentProvider.INT_TYPE, AccountConst.KEY_SESSION_ID, "varchar", "user_unique_id", "varchar", "category", "varchar", "tag", "varchar", ArgKey.KEY_VALUE, SettingsContentProvider.INT_TYPE, "ext_value", SettingsContentProvider.INT_TYPE, "params", "varchar", "label", "varchar", "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    /* renamed from: a */
    public C1838a mo13457a(Cursor cursor) {
        this.f5155a = cursor.getLong(0);
        this.f5156b = cursor.getLong(1);
        this.f5157c = cursor.getString(2);
        this.f5158d = cursor.getString(3);
        this.f5171h = cursor.getString(4);
        this.f5172i = cursor.getString(5);
        this.f5175l = (long) cursor.getInt(6);
        this.f5176m = (long) cursor.getInt(7);
        this.f5174k = cursor.getString(8);
        this.f5173j = cursor.getString(9);
        this.f5159e = cursor.getString(10);
        this.f5160f = cursor.getString(11);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13458a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f5155a));
        contentValues.put("tea_event_index", Long.valueOf(this.f5156b));
        contentValues.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        contentValues.put("user_unique_id", this.f5158d);
        contentValues.put("category", this.f5171h);
        contentValues.put("tag", this.f5172i);
        contentValues.put(ArgKey.KEY_VALUE, Long.valueOf(this.f5175l));
        contentValues.put("ext_value", Long.valueOf(this.f5176m));
        contentValues.put("params", this.f5174k);
        contentValues.put("label", this.f5173j);
        contentValues.put("ab_version", this.f5159e);
        contentValues.put("ab_sdk_version", this.f5160f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13459a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f5155a);
        jSONObject.put("tea_event_index", this.f5156b);
        jSONObject.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        jSONObject.put("user_unique_id", this.f5158d);
        jSONObject.put("category", this.f5171h);
        jSONObject.put("tag", this.f5172i);
        jSONObject.put(ArgKey.KEY_VALUE, this.f5175l);
        jSONObject.put("ext_value", this.f5176m);
        jSONObject.put("params", this.f5174k);
        jSONObject.put("label", this.f5173j);
        jSONObject.put("ab_version", this.f5159e);
        jSONObject.put("ab_sdk_version", this.f5160f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONObject mo13463b() {
        JSONObject jSONObject = !TextUtils.isEmpty(this.f5174k) ? new JSONObject(this.f5174k) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.f5155a);
        jSONObject.put("tea_event_index", this.f5156b);
        jSONObject.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        if (!TextUtils.isEmpty(this.f5158d)) {
            jSONObject.put("user_unique_id", this.f5158d);
        }
        jSONObject.put("category", this.f5171h);
        jSONObject.put("tag", this.f5172i);
        jSONObject.put(ArgKey.KEY_VALUE, this.f5175l);
        jSONObject.put("ext_value", this.f5176m);
        jSONObject.put("label", this.f5173j);
        jSONObject.put("datetime", this.f5161g);
        if (!TextUtils.isEmpty(this.f5159e)) {
            jSONObject.put("ab_version", this.f5159e);
        }
        if (!TextUtils.isEmpty(this.f5160f)) {
            jSONObject.put("ab_sdk_version", this.f5160f);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1838a mo13462b(JSONObject jSONObject) {
        this.f5155a = jSONObject.optLong("local_time_ms", 0);
        this.f5156b = jSONObject.optLong("tea_event_index", 0);
        this.f5157c = jSONObject.optString(AccountConst.KEY_SESSION_ID, null);
        this.f5158d = jSONObject.optString("user_unique_id", null);
        this.f5171h = jSONObject.optString("category", null);
        this.f5172i = jSONObject.optString("tag", null);
        this.f5175l = jSONObject.optLong(ArgKey.KEY_VALUE, 0);
        this.f5176m = jSONObject.optLong("ext_value", 0);
        this.f5174k = jSONObject.optString("params", null);
        this.f5173j = jSONObject.optString("label", null);
        this.f5159e = jSONObject.optString("ab_version", null);
        this.f5160f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo13470h() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.f5172i);
        sb.append(", ");
        sb.append(this.f5173j);
        return sb.toString();
    }

    /* renamed from: i */
    public String mo13482i() {
        return this.f5172i;
    }

    /* renamed from: j */
    public String mo13483j() {
        return this.f5173j;
    }
}
