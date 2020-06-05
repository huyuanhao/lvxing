package com.bytedance.embedapplog.p144d;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.embedapplog.util.C1856h;
import com.tencent.mid.sotrage.StorageInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.d.a */
public abstract class C1838a implements Cloneable {
    /* renamed from: h */
    private static final SimpleDateFormat f5154h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    /* renamed from: a */
    public long f5155a = System.currentTimeMillis();
    /* renamed from: b */
    public long f5156b;
    /* renamed from: c */
    public String f5157c;
    /* renamed from: d */
    public String f5158d;
    /* renamed from: e */
    public String f5159e;
    /* renamed from: f */
    public String f5160f;
    /* renamed from: g */
    String f5161g;

    /* renamed from: a */
    public abstract C1838a mo13457a(Cursor cursor);

    /* renamed from: a */
    public abstract void mo13458a(ContentValues contentValues);

    /* renamed from: a */
    public abstract void mo13459a(JSONObject jSONObject);

    /* renamed from: a */
    public abstract String[] mo13460a();

    /* renamed from: b */
    public abstract C1838a mo13462b(JSONObject jSONObject);

    /* renamed from: b */
    public abstract JSONObject mo13463b();

    /* renamed from: d */
    public abstract String mo13466d();

    /* renamed from: a */
    public static String m6448a(long j) {
        return f5154h.format(new Date(j));
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final ContentValues mo13461b(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        mo13458a(contentValues);
        return contentValues;
    }

    /* access modifiers changed from: final */
    /* renamed from: c */
    public final String mo13464c() {
        String[] a = mo13460a();
        if (a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(mo13466d());
        sb.append("(");
        for (int i = 0; i < a.length; i += 2) {
            sb.append(a[i]);
            sb.append(" ");
            sb.append(a[i + 1]);
            sb.append(StorageInterface.KEY_SPLITER);
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: e */
    public final JSONObject mo13467e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", mo13466d());
            mo13459a(jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
        return jSONObject;
    }

    /* access modifiers changed from: final */
    /* renamed from: f */
    public final JSONObject mo13468f() {
        try {
            this.f5161g = m6448a(this.f5155a);
            return mo13463b();
        } catch (JSONException e) {
            C1856h.m6582a(e);
            return null;
        }
    }

    /* renamed from: a */
    public static C1838a m6447a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return ((C1838a) C1839b.f5162a.get(jSONObject.optString("k_cls", ""))).clone().mo13462b(jSONObject);
        } catch (Throwable th) {
            C1856h.m6582a(th);
            return null;
        }
    }

    /* renamed from: g */
    public C1838a clone() {
        try {
            return (C1838a) super.clone();
        } catch (CloneNotSupportedException e) {
            C1856h.m6582a(e);
            return null;
        }
    }

    public String toString() {
        if (!C1856h.f5226b) {
            return super.toString();
        }
        String d = mo13466d();
        String str = ", ";
        if (!getClass().getSimpleName().equalsIgnoreCase(d)) {
            StringBuilder sb = new StringBuilder();
            sb.append(d);
            sb.append(str);
            sb.append(getClass().getSimpleName());
            d = sb.toString();
        }
        String str2 = this.f5157c;
        String str3 = "-";
        if (str2 != null) {
            int indexOf = str2.indexOf(str3);
            if (indexOf >= 0) {
                str2 = str2.substring(0, indexOf);
            }
            str3 = str2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        sb2.append(d);
        sb2.append(str);
        sb2.append(mo13470h());
        sb2.append(str);
        sb2.append(str3);
        sb2.append(str);
        sb2.append(this.f5155a);
        sb2.append("}");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo13470h() {
        StringBuilder sb = new StringBuilder();
        sb.append("sid:");
        sb.append(this.f5157c);
        return sb.toString();
    }
}
