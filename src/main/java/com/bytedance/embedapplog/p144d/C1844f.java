package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.f */
public class C1844f extends C1838a {
    /* renamed from: h */
    public int f5182h;
    /* renamed from: i */
    public String f5183i;
    /* renamed from: j */
    boolean f5184j;
    /* renamed from: k */
    volatile boolean f5185k;

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13466d() {
        return "launch";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String[] mo13460a() {
        return new String[]{"local_time_ms", SettingsContentProvider.INT_TYPE, "tea_event_index", SettingsContentProvider.INT_TYPE, AccountConst.KEY_SESSION_ID, "varchar", "ver_name", "varchar", "ver_code", SettingsContentProvider.INT_TYPE, "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    /* renamed from: a */
    public C1838a mo13457a(Cursor cursor) {
        this.f5155a = cursor.getLong(0);
        this.f5156b = cursor.getLong(1);
        this.f5157c = cursor.getString(2);
        this.f5183i = cursor.getString(3);
        this.f5182h = cursor.getInt(4);
        this.f5159e = cursor.getString(5);
        this.f5160f = cursor.getString(6);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13458a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f5155a));
        contentValues.put("tea_event_index", Long.valueOf(this.f5156b));
        contentValues.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        contentValues.put("ver_name", this.f5183i);
        contentValues.put("ver_code", Integer.valueOf(this.f5182h));
        contentValues.put("ab_version", this.f5159e);
        contentValues.put("ab_sdk_version", this.f5160f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13459a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f5155a);
        jSONObject.put("tea_event_index", this.f5156b);
        jSONObject.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        jSONObject.put("ab_version", this.f5159e);
        jSONObject.put("ab_sdk_version", this.f5160f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONObject mo13463b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.f5155a);
        jSONObject.put("tea_event_index", this.f5156b);
        jSONObject.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        boolean z = this.f5184j;
        if (z) {
            jSONObject.put("is_background", z);
        }
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
        this.f5159e = jSONObject.optString("ab_version", null);
        this.f5160f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }
}
