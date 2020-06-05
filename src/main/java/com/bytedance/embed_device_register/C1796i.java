package com.bytedance.embed_device_register;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embed_device_register.i */
final class C1796i {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f4976a;
    /* renamed from: b */
    private static volatile C1796i f4977b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C1800b f4978c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C1793b f4979d;

    /* renamed from: com.bytedance.embed_device_register.i$a */
    static final class C1799a {
        /* renamed from: e */
        private static Object f4986e;
        /* renamed from: f */
        private static Class<?> f4987f;
        /* renamed from: g */
        private static Method f4988g;
        /* renamed from: h */
        private static Method f4989h;
        /* renamed from: i */
        private static Method f4990i;
        /* renamed from: j */
        private static Method f4991j;
        /* renamed from: a */
        final String f4992a;
        /* renamed from: b */
        final String f4993b;
        /* renamed from: c */
        final String f4994c;
        /* renamed from: d */
        final String f4995d;

        static {
            try {
                f4987f = Class.forName("com.android.id.impl.IdProviderImpl");
                f4986e = f4987f.newInstance();
                f4988g = f4987f.getMethod("getUDID", new Class[]{Context.class});
                f4989h = f4987f.getMethod("getOAID", new Class[]{Context.class});
                f4990i = f4987f.getMethod("getVAID", new Class[]{Context.class});
                f4991j = f4987f.getMethod("getAAID", new Class[]{Context.class});
                StringBuilder sb = new StringBuilder();
                sb.append(C1796i.f4976a);
                sb.append("oaid=");
                sb.append(f4989h);
                sb.append(" udid=");
                sb.append(f4988g);
                C1780c.m6176a("TrackerDr", sb.toString());
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C1796i.f4976a);
                sb2.append("IdentifierManager");
                C1780c.m6178b(sb2.toString(), "reflect exception!", e);
            }
        }

        C1799a(Context context) {
            this.f4992a = m6237a(context, f4988g);
            this.f4993b = m6237a(context, f4989h);
            this.f4994c = m6237a(context, f4990i);
            this.f4995d = m6237a(context, f4991j);
        }

        /* renamed from: a */
        static boolean m6238a() {
            return (f4987f == null || f4986e == null) ? false : true;
        }

        /* renamed from: a */
        private static String m6237a(Context context, Method method) {
            Object obj = f4986e;
            if (!(obj == null || method == null)) {
                try {
                    Object invoke = method.invoke(obj, new Object[]{context});
                    if (invoke != null) {
                        return (String) invoke;
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C1796i.f4976a);
                    sb.append("IdentifierManager");
                    C1780c.m6178b(sb.toString(), "invoke exception!", e);
                }
            }
            return null;
        }
    }

    /* renamed from: com.bytedance.embed_device_register.i$b */
    static final class C1800b {
        /* renamed from: a */
        final String f4996a;
        /* renamed from: b */
        final String f4997b;
        /* renamed from: c */
        final String f4998c;
        /* renamed from: d */
        final String f4999d;
        /* renamed from: e */
        final String f5000e;
        /* renamed from: f */
        final long f5001f;
        /* renamed from: g */
        private final long f5002g;

        C1800b(String str, String str2, String str3, String str4, String str5, long j, long j2) {
            this.f4996a = str;
            this.f4997b = str2;
            this.f4998c = str3;
            this.f4999d = str4;
            this.f5000e = str5;
            this.f5001f = j;
            this.f5002g = j2;
        }

        /* renamed from: a */
        static C1800b m6239a(String str) {
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                C1800b bVar = new C1800b(jSONObject.optString("udid", str2), jSONObject.optString("oaid", str2), jSONObject.optString("vaid", str2), jSONObject.optString("aaid", str2), jSONObject.optString("req_id", str2), jSONObject.optLong("last_success_query_oaid_time", -1), jSONObject.optLong("take_ms", -1));
                return bVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo13278a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("udid", this.f4996a);
                jSONObject.put("oaid", this.f4997b);
                jSONObject.put("vaid", this.f4998c);
                jSONObject.put("aaid", this.f4999d);
                jSONObject.put("req_id", this.f5000e);
                jSONObject.put("last_success_query_oaid_time", this.f5001f);
                jSONObject.put("take_ms", this.f5002g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public Map<String, String> mo13279b() {
            HashMap hashMap = new HashMap();
            C1781d.m6183a(hashMap, "id", this.f4997b);
            C1781d.m6183a(hashMap, "udid", this.f4996a);
            C1781d.m6183a(hashMap, "take_ms", String.valueOf(this.f5002g));
            C1781d.m6183a(hashMap, "req_id", this.f5000e);
            return hashMap;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo13280c() {
            return !TextUtils.isEmpty(this.f4997b);
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(C1796i.class.getSimpleName());
        sb.append("#");
        f4976a = sb.toString();
    }

    /* renamed from: a */
    public static void m6230a(Context context, SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(f4976a);
        sb.append("init: ");
        C1780c.m6176a("TrackerDr", sb.toString());
        m6232b(context, sharedPreferences);
    }

    /* renamed from: b */
    static C1796i m6232b(Context context, SharedPreferences sharedPreferences) {
        if (f4977b == null) {
            synchronized (C1796i.class) {
                if (f4977b == null) {
                    f4977b = new C1796i(context, sharedPreferences);
                }
            }
        }
        return f4977b;
    }

    private C1796i(Context context, final SharedPreferences sharedPreferences) {
        if (context != null && C1799a.m6238a()) {
            final Context applicationContext = context.getApplicationContext();
            final C1795h hVar = new C1795h();
            C1781d.m6181a(new Runnable() {
                public void run() {
                    String str = "";
                    String str2 = "oaid_xiaomi_reqId";
                    String string = sharedPreferences.getString(str2, str);
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString();
                        sharedPreferences.edit().putString(str2, string).apply();
                    }
                    String str3 = string;
                    String str4 = "oaid_xiaomi_queryXiaomiTimes";
                    int i = sharedPreferences.getInt(str4, 0);
                    String str5 = "oaid_xiaomi_lastSuccessQueryOaid";
                    T a = C1800b.m6239a(sharedPreferences.getString(str5, str));
                    String str6 = "TrackerDr";
                    if (a != null && a.mo13280c()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(C1796i.f4976a);
                        sb.append("fromJson.isOaidValid()=true, oaid=");
                        sb.append(a.mo13278a());
                        C1780c.m6176a(str6, sb.toString());
                        C1795h hVar = hVar;
                        hVar.f4975a = a;
                        m6236a(hVar);
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    C1799a aVar = new C1799a(applicationContext);
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    sharedPreferences.edit().putInt(str4, i + 1).apply();
                    if (!TextUtils.isEmpty(aVar.f4993b)) {
                        C1800b bVar = new C1800b(aVar.f4992a, aVar.f4993b, aVar.f4994c, aVar.f4995d, str3, System.currentTimeMillis(), elapsedRealtime2);
                        sharedPreferences.edit().putString(str5, bVar.mo13278a()).apply();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(C1796i.f4976a);
                        sb2.append("saveOaid=");
                        sb2.append(bVar.mo13278a());
                        C1780c.m6176a(str6, sb2.toString());
                        hVar.f4975a = bVar;
                    }
                    m6236a(hVar);
                }

                /* renamed from: a */
                private void m6236a(final C1795h<C1800b> hVar) {
                    if (hVar.f4975a != null) {
                        C1781d.m6181a(new Runnable() {
                            public void run() {
                                C1796i.this.f4978c = (C1800b) hVar.f4975a;
                                StringBuilder sb = new StringBuilder();
                                sb.append(C1796i.f4976a);
                                sb.append("update: ");
                                sb.append(C1796i.this.f4978c.mo13278a());
                                C1780c.m6176a("TrackerDr", sb.toString());
                                if (C1796i.this.f4979d != null) {
                                    C1796i.this.f4979d.mo13272a(C1796i.this.f4978c);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13275a(C1793b bVar) {
        this.f4979d = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1800b mo13274a() {
        return this.f4978c;
    }
}
