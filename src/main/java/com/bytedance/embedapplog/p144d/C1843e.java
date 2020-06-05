package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.embedapplog.util.C1856h;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.e */
public class C1843e extends C1838a {
    /* renamed from: h */
    protected String f5179h;
    /* renamed from: i */
    private boolean f5180i;
    /* renamed from: j */
    private String f5181j;

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13466d() {
        return "eventv3";
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo13484i() {
    }

    public C1843e(String str, boolean z, String str2) {
        this.f5181j = str;
        this.f5180i = z;
        this.f5179h = str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String[] mo13460a() {
        return new String[]{"local_time_ms", SettingsContentProvider.INT_TYPE, "tea_event_index", SettingsContentProvider.INT_TYPE, AccountConst.KEY_SESSION_ID, "varchar", "user_unique_id", "varchar", NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", SettingsContentProvider.INT_TYPE, "ab_version", "varchar", "ab_sdk_version", "varchar"};
    }

    /* renamed from: a */
    public C1838a mo13457a(Cursor cursor) {
        boolean z = false;
        this.f5155a = cursor.getLong(0);
        this.f5156b = cursor.getLong(1);
        this.f5157c = cursor.getString(2);
        this.f5158d = cursor.getString(3);
        this.f5181j = cursor.getString(4);
        this.f5179h = cursor.getString(5);
        if (cursor.getInt(6) == 1) {
            z = true;
        }
        this.f5180i = z;
        this.f5159e = cursor.getString(7);
        this.f5160f = cursor.getString(8);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13458a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f5155a));
        contentValues.put("tea_event_index", Long.valueOf(this.f5156b));
        contentValues.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        contentValues.put("user_unique_id", this.f5158d);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.f5181j);
        if (this.f5180i && this.f5179h == null) {
            try {
                mo13484i();
            } catch (JSONException e) {
                C1856h.m6582a(e);
            }
        }
        contentValues.put("params", this.f5179h);
        contentValues.put("is_bav", Integer.valueOf(this.f5180i));
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f5181j);
        if (this.f5180i && this.f5179h == null) {
            mo13484i();
        }
        jSONObject.put("params", this.f5179h);
        jSONObject.put("is_bav", this.f5180i);
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
        if (!TextUtils.isEmpty(this.f5158d)) {
            jSONObject.put("user_unique_id", this.f5158d);
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f5181j);
        if (this.f5180i) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.f5179h)) {
            jSONObject.put("params", new JSONObject(this.f5179h));
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
        this.f5158d = jSONObject.optString("user_unique_id", null);
        this.f5181j = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.f5179h = jSONObject.optString("params", null);
        this.f5180i = jSONObject.optBoolean("is_bav", false);
        this.f5159e = jSONObject.optString("ab_version", null);
        this.f5160f = jSONObject.optString("ab_sdk_version", null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo13470h() {
        return this.f5181j;
    }

    /* renamed from: j */
    public String mo13485j() {
        return this.f5181j;
    }
}
