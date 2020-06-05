package com.bytedance.sdk.openadsdk.p165c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.c.a */
public class AdEvent implements EventFace {
    /* renamed from: a */
    public final String f6743a;
    /* renamed from: b */
    public final JSONObject f6744b;

    AdEvent(String str, JSONObject jSONObject) {
        this.f6743a = str;
        this.f6744b = jSONObject;
    }

    /* renamed from: a */
    static AdEvent m8353a(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        return new AdEvent(UUID.randomUUID().toString(), m8356b(context, str, str2, str3, jSONObject));
    }

    /* renamed from: a */
    static AdEvent m8355a(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        return new AdEvent(UUID.randomUUID().toString(), m8357b(str, str2, str3, j, j2, jSONObject));
    }

    /* renamed from: b */
    private static JSONObject m8356b(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        String str4 = ArgKey.KEY_VALUE;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt("tag", str);
            jSONObject2.putOpt("label", str2);
            jSONObject2.putOpt("category", "app_union");
            try {
                jSONObject2.putOpt(str4, Long.valueOf(Long.parseLong(str3)));
            } catch (NumberFormatException unused) {
                jSONObject2.putOpt(str4, Long.valueOf(0));
            }
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("nt", Integer.valueOf(C2566w.m12244c(context)));
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str5 = (String) keys.next();
                    jSONObject2.putOpt(str5, jSONObject.opt(str5));
                }
            }
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    /* renamed from: b */
    private static JSONObject m8357b(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt("tag", str2);
            jSONObject2.putOpt("label", str3);
            jSONObject2.putOpt("category", str);
            jSONObject2.putOpt(ArgKey.KEY_VALUE, Long.valueOf(j));
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("ext_value", Long.valueOf(j2));
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    jSONObject2.putOpt(str4, jSONObject.opt(str4));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    /* renamed from: a */
    public static AdEvent m8354a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("localId", null);
            JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT);
            if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                return new AdEvent(optString, optJSONObject);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a */
    public String mo14995a() {
        if (TextUtils.isEmpty(this.f6743a) || this.f6744b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.f6743a);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f6744b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    public String mo14996b() {
        return this.f6743a;
    }
}
