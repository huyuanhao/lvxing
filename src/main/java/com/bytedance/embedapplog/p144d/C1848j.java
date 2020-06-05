package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.C1856h;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.j */
public class C1848j extends C1838a {
    /* renamed from: h */
    public long f5207h;
    /* renamed from: i */
    long f5208i;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String[] mo13460a() {
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public String mo13466d() {
        return "terminate";
    }

    /* renamed from: a */
    public C1838a mo13457a(Cursor cursor) {
        C1856h.m6582a(null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13458a(ContentValues contentValues) {
        C1856h.m6582a(null);
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
        jSONObject.put("local_time_ms", this.f5155a);
        jSONObject.put("tea_event_index", this.f5156b);
        jSONObject.put(AccountConst.KEY_SESSION_ID, this.f5157c);
        jSONObject.put("stop_timestamp", this.f5208i);
        jSONObject.put("duration", this.f5207h / 1000);
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
        C1856h.m6582a(null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo13470h() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.mo13470h());
        sb.append(" duration:");
        sb.append(this.f5207h);
        return sb.toString();
    }
}
