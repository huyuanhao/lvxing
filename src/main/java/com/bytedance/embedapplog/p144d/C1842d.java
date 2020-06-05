package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.C1856h;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.d */
public class C1842d extends C1838a {
    /* renamed from: h */
    private String f5177h;
    /* renamed from: i */
    private String f5178i;

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13466d() {
        return "event_misc";
    }

    public C1842d(String str, JSONObject jSONObject) {
        this.f5178i = str;
        this.f5177h = jSONObject.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String[] mo13460a() {
        return new String[]{"local_time_ms", SettingsContentProvider.INT_TYPE, "tea_event_index", SettingsContentProvider.INT_TYPE, AccountConst.KEY_SESSION_ID, "varchar", "user_unique_id", "varchar", "params", "varchar", "log_type", "varchar"};
    }

    /* renamed from: a */
    public C1838a mo13457a(Cursor cursor) {
        this.f5155a = cursor.getLong(0);
        this.f5156b = cursor.getLong(1);
        this.f5157c = cursor.getString(2);
        this.f5158d = cursor.getString(3);
        this.f5177h = cursor.getString(4);
        this.f5178i = cursor.getString(5);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13458a(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f5155a));
        contentValues.put("tea_event_index", Long.valueOf(this.f5156b));
        contentValues.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        contentValues.put("user_unique_id", this.f5158d);
        contentValues.put("params", this.f5177h);
        contentValues.put("log_type", this.f5178i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13459a(JSONObject jSONObject) {
        jSONObject.put("local_time_ms", this.f5155a);
        jSONObject.put("tea_event_index", this.f5156b);
        jSONObject.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        jSONObject.put("user_unique_id", this.f5158d);
        jSONObject.put("params", this.f5177h);
        jSONObject.put("log_type", this.f5178i);
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
        jSONObject.put("log_type", this.f5178i);
        try {
            JSONObject jSONObject2 = new JSONObject(this.f5177h);
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object obj = jSONObject2.get(str);
                if (jSONObject.opt(str) != null) {
                    C1856h.m6583b("misc事件存在重复的key", null);
                }
                jSONObject.put(str, obj);
            }
        } catch (Exception e) {
            C1856h.m6584c("解析 event misc 失败", e);
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
        this.f5177h = jSONObject.optString("params", null);
        this.f5178i = jSONObject.optString("log_type", null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo13470h() {
        StringBuilder sb = new StringBuilder();
        sb.append("param:");
        sb.append(this.f5177h);
        sb.append(" logType:");
        sb.append(this.f5178i);
        return sb.toString();
    }
}
