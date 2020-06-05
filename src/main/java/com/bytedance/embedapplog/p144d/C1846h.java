package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.h */
public class C1846h extends C1838a {
    /* renamed from: h */
    public long f5196h;
    /* renamed from: i */
    public String f5197i;
    /* renamed from: j */
    public String f5198j;
    /* renamed from: k */
    public int f5199k;

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13466d() {
        return "page";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String[] mo13460a() {
        return new String[]{"local_time_ms", SettingsContentProvider.INT_TYPE, "tea_event_index", SettingsContentProvider.INT_TYPE, AccountConst.KEY_SESSION_ID, "varchar", "user_unique_id", "varchar", "page_key", "varchar", "refer_page_key", "varchar", "duration", SettingsContentProvider.INT_TYPE, "is_back", SettingsContentProvider.INT_TYPE};
    }

    /* renamed from: a */
    public C1838a mo13457a(Cursor cursor) {
        this.f5155a = cursor.getLong(0);
        this.f5156b = cursor.getLong(1);
        this.f5157c = cursor.getString(2);
        this.f5158d = cursor.getString(3);
        this.f5198j = cursor.getString(4);
        this.f5197i = cursor.getString(5);
        this.f5196h = cursor.getLong(6);
        this.f5199k = cursor.getInt(7);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13458a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f5155a));
        contentValues.put("tea_event_index", Long.valueOf(this.f5156b));
        contentValues.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        contentValues.put("user_unique_id", this.f5158d);
        contentValues.put("page_key", this.f5198j);
        contentValues.put("refer_page_key", this.f5197i);
        contentValues.put("duration", Long.valueOf(this.f5196h));
        contentValues.put("is_back", Integer.valueOf(this.f5199k));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13459a(JSONObject jSONObject) {
        jSONObject.put("page_key", this.f5198j);
        jSONObject.put("refer_page_key", this.f5197i);
        jSONObject.put("duration", this.f5196h);
        jSONObject.put("local_time_ms", this.f5155a);
        jSONObject.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        jSONObject.put("tea_event_index", this.f5156b);
        jSONObject.put("is_back", this.f5199k);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1838a mo13462b(JSONObject jSONObject) {
        this.f5155a = jSONObject.optLong("local_time_ms", 0);
        this.f5156b = jSONObject.optLong("tea_event_index", 0);
        this.f5157c = jSONObject.optString(AccountConst.KEY_SESSION_ID, null);
        this.f5198j = jSONObject.optString("page_key", null);
        this.f5197i = jSONObject.optString("refer_page_key", null);
        this.f5196h = jSONObject.optLong("duration", 0);
        this.f5199k = jSONObject.optInt("is_back", 0);
        return this;
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", m6526k());
        jSONObject.put("datetime", this.f5161g);
        return jSONObject;
    }

    /* renamed from: k */
    private JSONObject m6526k() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.f5198j);
        jSONObject.put("refer_page_key", this.f5197i);
        jSONObject.put("is_back", this.f5199k);
        return jSONObject;
    }

    /* renamed from: i */
    public boolean mo13488i() {
        return this.f5196h == -1;
    }

    /* renamed from: j */
    public boolean mo13489j() {
        return this.f5198j.contains(":");
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo13470h() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.mo13470h());
        sb.append(" name:");
        sb.append(this.f5198j);
        sb.append(" duration:");
        sb.append(this.f5196h);
        return sb.toString();
    }
}
