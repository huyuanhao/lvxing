package com.tencent.mta.track;

import android.util.Log;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.y */
public class C7476y {
    /* renamed from: a */
    public final int f25035a;
    /* renamed from: b */
    public final String f25036b;
    /* renamed from: c */
    public final int f25037c;
    /* renamed from: d */
    public final int f25038d;

    public C7476y(int i, String str, int i2, int i3) {
        this.f25035a = i;
        this.f25036b = str;
        this.f25037c = i2;
        this.f25038d = i3;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f25035a == 1) {
                jSONObject.put("prefix", "shortest");
            }
            if (this.f25036b != null) {
                jSONObject.put("view_class", this.f25036b);
            }
            if (this.f25037c > -1) {
                jSONObject.put("index", this.f25037c);
            }
            if (this.f25038d > -1) {
                jSONObject.put("id", this.f25038d);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't serialize PathElement to String");
            sb.append(th);
            Log.i("PathElement", sb.toString());
            return "";
        }
    }
}
