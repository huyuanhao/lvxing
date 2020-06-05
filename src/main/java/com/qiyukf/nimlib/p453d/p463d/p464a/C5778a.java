package com.qiyukf.nimlib.p453d.p463d.p464a;

import com.qiyukf.nimlib.p453d.p459b.C5762a;
import com.tencent.mid.sotrage.StorageInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.d.a.a */
public final class C5778a implements C5762a {
    /* renamed from: a */
    private static final DateFormat f18397a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    /* renamed from: b */
    private static final Date f18398b = new Date();
    /* renamed from: c */
    private final int f18399c;
    /* renamed from: d */
    private final String f18400d;
    /* renamed from: e */
    private final double f18401e;
    /* renamed from: f */
    private final double f18402f;
    /* renamed from: g */
    private final double f18403g;
    /* renamed from: h */
    private final float f18404h;
    /* renamed from: i */
    private final long f18405i;

    /* renamed from: a */
    public final JSONObject mo28034a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.f18399c);
            jSONObject.put("coor_type", this.f18400d);
            jSONObject.put("latitude", this.f18401e);
            jSONObject.put("longitude", this.f18402f);
            jSONObject.put("altitude", this.f18403g);
            jSONObject.put("precision", (double) this.f18404h);
            jSONObject.put("time", this.f18405i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        f18398b.setTime(this.f18405i);
        StringBuilder sb = new StringBuilder("loc{");
        sb.append(this.f18401e);
        String str = StorageInterface.KEY_SPLITER;
        sb.append(str);
        sb.append(this.f18402f);
        sb.append(str);
        sb.append(this.f18401e);
        sb.append(str);
        sb.append(f18397a.format(f18398b));
        sb.append(str);
        sb.append(this.f18399c);
        sb.append(str);
        sb.append(this.f18400d);
        sb.append("}");
        return sb.toString();
    }
}
