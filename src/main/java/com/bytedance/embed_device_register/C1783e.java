package com.bytedance.embed_device_register;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.embed_bdtracker.C1774bt;
import com.bytedance.embed_bdtracker.C1774bt.C1775a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.embed_device_register.e */
final class C1783e {
    /* access modifiers changed from: private|static|final */
    /* renamed from: a */
    public static final String f4934a;
    /* renamed from: b */
    private static volatile C1783e f4935b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C1787a f4936c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C1793b f4937d;

    /* renamed from: com.bytedance.embed_device_register.e$a */
    static final class C1787a {
        /* renamed from: a */
        final String f4949a;
        /* renamed from: b */
        final String f4950b;
        /* renamed from: c */
        final boolean f4951c;
        /* renamed from: d */
        final long f4952d;
        /* renamed from: e */
        final long f4953e;
        /* renamed from: f */
        private final List<String> f4954f;
        /* renamed from: g */
        private final int f4955g;
        /* renamed from: h */
        private final long f4956h;

        /* renamed from: com.bytedance.embed_device_register.e$a$a */
        static class C1788a {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public String f4957a;
            /* renamed from: b */
            private String f4958b;
            /* renamed from: c */
            private boolean f4959c;
            /* renamed from: d */
            private long f4960d;
            /* renamed from: e */
            private long f4961e;
            /* renamed from: f */
            private List<String> f4962f = new CopyOnWriteArrayList();
            /* renamed from: g */
            private int f4963g;
            /* renamed from: h */
            private long f4964h;

            C1788a() {
            }

            C1788a(C1788a aVar) {
                this.f4957a = aVar.f4957a;
                this.f4958b = aVar.f4958b;
                this.f4959c = aVar.f4959c;
                this.f4960d = aVar.f4960d;
                this.f4961e = aVar.f4961e;
                this.f4962f = new CopyOnWriteArrayList(aVar.f4962f);
                this.f4963g = aVar.f4963g;
                this.f4964h = aVar.f4964h;
            }

            /* renamed from: a */
            static C1788a m6201a(String str) {
                C1788a aVar = new C1788a();
                if (TextUtils.isEmpty(str)) {
                    return aVar;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("id");
                    String optString2 = jSONObject.optString("is_track_limited");
                    String optString3 = jSONObject.optString("take_ms");
                    String optString4 = jSONObject.optString("time");
                    return new C1788a().mo13265b(optString).mo13262a(Boolean.valueOf(optString2).booleanValue()).mo13261a(C1781d.m6180a(optString3, -1)).mo13264b(C1781d.m6180a(optString4, -1)).mo13268c(jSONObject.optString("req_id")).mo13260a(C1781d.m6179a(jSONObject.optString("query_times"), -1)).mo13267c(C1781d.m6180a(jSONObject.optString("hw_id_version_code"), -1));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return aVar;
                }
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public C1788a mo13265b(String str) {
                this.f4957a = str;
                return this;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: c */
            public C1788a mo13268c(String str) {
                this.f4958b = str;
                return this;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public C1788a mo13262a(boolean z) {
                this.f4959c = z;
                return this;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public C1788a mo13261a(long j) {
                this.f4960d = j;
                return this;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public C1788a mo13264b(long j) {
                this.f4961e = j;
                return this;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: d */
            public C1788a mo13269d(String str) {
                this.f4962f.add(str);
                return this;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public C1788a mo13260a(int i) {
                this.f4963g = i;
                return this;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: c */
            public C1788a mo13267c(long j) {
                this.f4964h = j;
                return this;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public C1787a mo13263a() {
                C1787a aVar = new C1787a(this.f4957a, this.f4958b, this.f4959c, this.f4960d, this.f4961e, this.f4962f, this.f4963g, this.f4964h);
                return aVar;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public boolean mo13266b() {
                return !TextUtils.isEmpty(this.f4957a);
            }
        }

        C1787a(String str, String str2, boolean z, long j, long j2, List<String> list, int i, long j3) {
            this.f4949a = str;
            this.f4950b = str2;
            this.f4951c = z;
            this.f4952d = j;
            this.f4953e = j2;
            this.f4954f = Collections.unmodifiableList(new ArrayList(list));
            this.f4955g = i;
            this.f4956h = j3;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Map<String, String> mo13258a() {
            HashMap hashMap = new HashMap();
            C1781d.m6183a(hashMap, "id", this.f4949a);
            C1781d.m6183a(hashMap, "is_track_limited", String.valueOf(this.f4951c));
            C1781d.m6183a(hashMap, "take_ms", String.valueOf(this.f4952d));
            C1781d.m6183a(hashMap, "req_id", this.f4950b);
            C1781d.m6183a(hashMap, "hw_id_version_code", String.valueOf(this.f4956h));
            return hashMap;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo13259b() {
            return new JSONObject(mo13258a()).toString();
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(C1783e.class.getSimpleName());
        sb.append("#");
        f4934a = sb.toString();
    }

    /* renamed from: a */
    public static void m6188a(Context context, SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(f4934a);
        sb.append("init: ");
        C1780c.m6176a("TrackerDr", sb.toString());
        m6192b(context, sharedPreferences);
    }

    /* renamed from: b */
    static C1783e m6192b(Context context, SharedPreferences sharedPreferences) {
        if (f4935b == null) {
            synchronized (C1783e.class) {
                if (f4935b == null) {
                    f4935b = new C1783e(context, sharedPreferences);
                }
            }
        }
        return f4935b;
    }

    private C1783e(Context context, SharedPreferences sharedPreferences) {
        if (context != null && m6189a(context.getApplicationContext())) {
            final Context applicationContext = context.getApplicationContext();
            final C1795h hVar = new C1795h();
            final SharedPreferences sharedPreferences2 = sharedPreferences;
            final Context context2 = context;
            C17841 r1 = new Runnable() {
                public void run() {
                    String str = "";
                    String str2 = "oaid_req_id";
                    String string = sharedPreferences2.getString(str2, str);
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString();
                        sharedPreferences2.edit().putString(str2, string).apply();
                    }
                    String str3 = "oaid_query_hms_times";
                    int i = sharedPreferences2.getInt(str3, 0);
                    String str4 = "oaid_last_success_query_oaid";
                    T a = C1788a.m6201a(sharedPreferences2.getString(str4, str));
                    String str5 = "TrackerDr";
                    if (a.mo13266b()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(C1783e.f4934a);
                        sb.append("fromJson.isOaidValid()=true, oaid=");
                        sb.append(a.mo13263a().mo13259b());
                        C1780c.m6176a(str5, sb.toString());
                        C1795h hVar = hVar;
                        hVar.f4975a = a;
                        m6198a(hVar);
                    }
                    T a2 = C1783e.this.m6195c(applicationContext);
                    a2.mo13268c(string).mo13260a(i);
                    sharedPreferences2.edit().putInt(str3, i + 1).apply();
                    if (!TextUtils.isEmpty(a2.f4957a)) {
                        a2.mo13264b(System.currentTimeMillis());
                        a2.mo13267c(C1783e.this.m6190b(context2));
                        sharedPreferences2.edit().putString(str4, a2.mo13263a().mo13259b()).apply();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(C1783e.f4934a);
                        sb2.append("saveOaid=");
                        sb2.append(a2.mo13263a().mo13259b());
                        C1780c.m6176a(str5, sb2.toString());
                        hVar.f4975a = a2;
                    }
                    m6198a(hVar);
                }

                /* renamed from: a */
                private void m6198a(final C1795h<C1788a> hVar) {
                    if (hVar.f4975a != null) {
                        C1781d.m6182a("TrackerDr-update", (Runnable) new Runnable() {
                            public void run() {
                                C1783e.this.f4936c = ((C1788a) hVar.f4975a).mo13263a();
                                StringBuilder sb = new StringBuilder();
                                sb.append(C1783e.f4934a);
                                sb.append("update: ");
                                sb.append(C1783e.this.f4936c.mo13259b());
                                C1780c.m6176a("TrackerDr", sb.toString());
                                if (C1783e.this.f4937d != null) {
                                    C1783e.this.f4937d.mo13272a(C1783e.this.f4936c);
                                }
                            }
                        });
                    }
                }
            };
            C1781d.m6182a("TrackerDr-query-hms", (Runnable) r1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public long m6190b(Context context) {
        int i = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            if (packageInfo != null) {
                i = packageInfo.versionCode;
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return (long) i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo13253a(C1793b bVar) {
        this.f4937d = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1787a mo13252a() {
        return this.f4936c;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public C1788a m6195c(Context context) {
        C1788a aVar = new C1788a();
        try {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            final C1788a aVar2 = aVar;
            final CountDownLatch countDownLatch2 = countDownLatch;
            C17862 r0 = new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C1783e.f4934a);
                    sb.append("onServiceConnected: ");
                    String str = "TrackerDr";
                    C1780c.m6176a(str, sb.toString());
                    C1774bt a = C1775a.m6165a(iBinder);
                    try {
                        String a2 = a.mo13242a();
                        boolean b = a.mo13243b();
                        aVar2.mo13265b(a2).mo13262a(b).mo13264b(System.currentTimeMillis()).mo13261a(SystemClock.elapsedRealtime() - elapsedRealtime);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(C1783e.f4934a);
                        sb2.append("oaid=");
                        sb2.append(a2);
                        sb2.append(" isTrackLimited=");
                        sb2.append(b);
                        C1780c.m6176a(str, sb2.toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        aVar2.mo13269d(Log.getStackTraceString(e));
                    } catch (Throwable th) {
                        countDownLatch2.countDown();
                        throw th;
                    }
                    countDownLatch2.countDown();
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C1783e.f4934a);
                    sb.append("onServiceDisconnected: ");
                    C1780c.m6176a("TrackerDr", sb.toString());
                }
            };
            context.bindService(intent, r0, 1);
            countDownLatch.await();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar.mo13269d(Log.getStackTraceString(th));
        }
        return new C1788a(aVar);
    }

    /* renamed from: a */
    static boolean m6189a(Context context) {
        return C1781d.m6184a(context, "com.huawei.hwid");
    }
}
