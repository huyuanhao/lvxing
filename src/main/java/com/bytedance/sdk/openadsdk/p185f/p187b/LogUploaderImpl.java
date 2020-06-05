package com.bytedance.sdk.openadsdk.p185f.p187b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch;
import com.bytedance.sdk.openadsdk.p165c.EventFace;
import com.bytedance.sdk.openadsdk.p185f.p186a.ILogStats;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.f.b.c */
public class LogUploaderImpl implements ILogUploader {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final LogStatsCache f8660a = LogStatsCache.m11341a();
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final List<C2424a> f8661b = Collections.synchronizedList(new LinkedList());

    /* compiled from: LogUploaderImpl */
    /* renamed from: com.bytedance.sdk.openadsdk.f.b.c$a */
    public static class C2424a implements EventFace {
        /* renamed from: a */
        public final String f8663a;
        /* renamed from: b */
        public final JSONObject f8664b;

        public C2424a(String str, JSONObject jSONObject) {
            this.f8663a = str;
            this.f8664b = jSONObject;
        }

        /* renamed from: a */
        public static C2424a m11352a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("localId", null);
                JSONObject optJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT);
                if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                    return new C2424a(optString, optJSONObject);
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        /* renamed from: a */
        public String mo16623a() {
            if (TextUtils.isEmpty(this.f8663a) || this.f8664b == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.f8663a);
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f8664b);
            } catch (Throwable unused) {
            }
            return jSONObject.toString();
        }

        /* renamed from: b */
        public String mo14996b() {
            return this.f8663a;
        }
    }

    /* renamed from: b */
    public void mo16618b() {
    }

    /* renamed from: a */
    public void mo16615a() {
        TTExecutor.m11692a().mo16809d(new Runnable() {
            public void run() {
                List d = LogUploaderImpl.this.f8660a.mo16621d();
                if (d != null) {
                    LogUploaderImpl.this.f8661b.addAll(d);
                }
                LogUploaderImpl.this.f8660a.mo16620c();
            }
        }, 5);
    }

    /* renamed from: a */
    public void mo16616a(ILogStats bVar) {
        mo16617a(bVar, false);
    }

    /* renamed from: a */
    public void mo16617a(ILogStats bVar, boolean z) {
        if (bVar != null && SdkSwitch.m9757a()) {
            C2424a aVar = new C2424a(UUID.randomUUID().toString(), bVar.mo16587a());
            if (z) {
                InternalContainer.m10066e().mo14998a(aVar);
            } else {
                InternalContainer.m10065d().mo14998a(aVar);
            }
        }
    }

    /* renamed from: c */
    public static ILogUploader m11347c() {
        return LogUploaderImplEmpty.m11359c();
    }
}
