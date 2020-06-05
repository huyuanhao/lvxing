package com.bytedance.sdk.openadsdk.core.p174h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.p159b.JsonObjectRequest;
import com.bytedance.sdk.openadsdk.core.AES;
import com.bytedance.sdk.openadsdk.core.AESKey;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.OAIDHelper;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.b */
public class ApplistHelper implements Runnable {
    /* renamed from: a */
    private static volatile ApplistHelper f7610a;
    /* renamed from: b */
    private final Context f7611b = InternalContainer.m10059a();
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final C2250a f7612c = new C2250a(this.f7611b);
    /* access modifiers changed from: private */
    /* renamed from: d */
    public AtomicBoolean f7613d = new AtomicBoolean(false);
    /* renamed from: e */
    private boolean f7614e = false;
    /* renamed from: f */
    private Comparator<JSONObject> f7615f = new Comparator<JSONObject>() {
        /* renamed from: a */
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            String str = "package_name";
            return jSONObject.optString(str).compareTo(jSONObject2.optString(str));
        }
    };

    /* compiled from: ApplistHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.core.h.b$a */
    class C2250a {
        /* renamed from: b */
        private final SharedPreferences f7621b;

        C2250a(Context context) {
            this.f7621b = context.getSharedPreferences("tt_sp_app_list", 0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo15721a(String str) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "old_app_list";
                if (MultiGlobalInfo.m11808b()) {
                    SPMultiHelper.m11874a("tt_sp_app_list", str2, str);
                } else {
                    this.f7621b.edit().putString(str2, str).apply();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo15720a() {
            String str = "day_update_time";
            if (MultiGlobalInfo.m11808b()) {
                SPMultiHelper.m11873a("tt_sp_app_list", str, Long.valueOf(System.currentTimeMillis()));
                return;
            }
            this.f7621b.edit().putLong(str, System.currentTimeMillis()).apply();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public String mo15722b() {
            String str = "";
            String str2 = "old_app_list";
            if (MultiGlobalInfo.m11808b()) {
                return SPMultiHelper.m11880b("tt_sp_app_list", str2, str);
            }
            return this.f7621b.getString(str2, str);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo15723c() {
            long j;
            String str = "day_update_time";
            if (MultiGlobalInfo.m11808b()) {
                j = SPMultiHelper.m11866a("tt_sp_app_list", str, 0);
            } else {
                j = this.f7621b.getLong(str, 0);
            }
            return !m9698a(j, System.currentTimeMillis());
        }

        /* renamed from: a */
        private boolean m9698a(long j, long j2) {
            long j3 = j2 - j;
            return j3 < 86400000 && j3 > -86400000 && m9697a(j) == m9697a(j2);
        }

        /* renamed from: a */
        private long m9697a(long j) {
            return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
        }
    }

    /* compiled from: ApplistHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.core.h.b$b */
    private static class C2251b {
        /* renamed from: a */
        static String m9703a(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }

    /* renamed from: a */
    public static ApplistHelper m9686a() {
        if (f7610a == null) {
            synchronized (ApplistHelper.class) {
                if (f7610a == null) {
                    f7610a = new ApplistHelper();
                }
            }
        }
        return f7610a;
    }

    private ApplistHelper() {
    }

    /* renamed from: b */
    public void mo15716b() {
        boolean z = InternalContainer.m10069h().mo15768P() && GlobalInfo.m9616c().mo15672d().alist();
        this.f7614e = z;
        if (SdkSettingsHelper.m9748d() && !this.f7613d.get()) {
            this.f7613d.set(true);
            try {
                TTExecutor.m11692a().mo16809d(this, 1);
            } catch (Throwable th) {
                C2564t.m12216a("ApplistHelper", "upload sdk applist error: ", th);
                this.f7613d.set(false);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:17|18|(4:20|21|22|(9:24|27|28|29|(1:31)|32|33|34|41))|25|27|28|29|(0)|32|33|34|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00d5 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3 A[Catch:{ all -> 0x00d5 }] */
    /* renamed from: b */
    private java.util.List<org.json.JSONObject> m9690b(android.content.Context r13) {
        /*
        r12 = this;
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        if (r13 == 0) goto L_0x011d
        boolean r1 = r12.f7614e
        if (r1 != 0) goto L_0x000d
        goto L_0x011d
    L_0x000d:
        java.lang.String r1 = "utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"
        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.p174h.ApplistHelper.C2251b.m9703a(r1)     // Catch:{ all -> 0x0115 }
        java.lang.String r2 = com.bytedance.sdk.openadsdk.core.AESKey.m9086a()     // Catch:{ all -> 0x0115 }
        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.AES.m9052b(r1, r2)     // Catch:{ all -> 0x0115 }
        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0115 }
        r2.<init>(r1)     // Catch:{ all -> 0x0115 }
        java.lang.String r1 = "cn"
        java.lang.String r1 = r2.optString(r1)     // Catch:{ all -> 0x0115 }
        java.lang.String r3 = "m1"
        java.lang.String r3 = r2.optString(r3)     // Catch:{ all -> 0x0115 }
        r4 = 0
        java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x0115 }
        java.lang.reflect.Method r1 = com.bytedance.sdk.openadsdk.utils.TTReflectUtils.m11989a(r1, r3, r5)     // Catch:{ all -> 0x0115 }
        java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x0115 }
        java.lang.Object r13 = r1.invoke(r13, r3)     // Catch:{ all -> 0x0115 }
        java.lang.String r1 = "pn"
        java.lang.String r1 = r2.optString(r1)     // Catch:{ all -> 0x0115 }
        java.lang.String r3 = "m2"
        java.lang.String r3 = r2.optString(r3)     // Catch:{ all -> 0x0115 }
        java.lang.String r5 = "f"
        int r2 = r2.optInt(r5)     // Catch:{ all -> 0x0115 }
        r5 = 1
        java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x0115 }
        java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0115 }
        r6[r4] = r7     // Catch:{ all -> 0x0115 }
        java.lang.reflect.Method r3 = com.bytedance.sdk.openadsdk.utils.TTReflectUtils.m11989a(r1, r3, r6)     // Catch:{ all -> 0x0115 }
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x0115 }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0115 }
        r6[r4] = r2     // Catch:{ all -> 0x0115 }
        java.lang.Object r2 = r3.invoke(r13, r6)     // Catch:{ all -> 0x0115 }
        boolean r3 = r2 instanceof java.util.List     // Catch:{ all -> 0x0115 }
        if (r3 == 0) goto L_0x011d
        java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0115 }
        if (r2 == 0) goto L_0x011d
        boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0115 }
        if (r3 != 0) goto L_0x011d
        java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0115 }
    L_0x0074:
        boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0115 }
        if (r3 == 0) goto L_0x011d
        java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0115 }
        boolean r6 = r3 instanceof android.content.pm.PackageInfo     // Catch:{ all -> 0x0115 }
        if (r6 == 0) goto L_0x0074
        android.content.pm.PackageInfo r3 = (android.content.pm.PackageInfo) r3     // Catch:{ all -> 0x0115 }
        android.content.pm.ApplicationInfo r6 = r3.applicationInfo     // Catch:{ all -> 0x0115 }
        java.lang.String r7 = "unknown"
        if (r6 == 0) goto L_0x00ad
        java.lang.String r6 = "getApplicationLabel"
        java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ all -> 0x00ad }
        java.lang.Class<android.content.pm.ApplicationInfo> r9 = android.content.pm.ApplicationInfo.class
        r8[r4] = r9     // Catch:{ all -> 0x00ad }
        java.lang.reflect.Method r6 = com.bytedance.sdk.openadsdk.utils.TTReflectUtils.m11989a(r1, r6, r8)     // Catch:{ all -> 0x00ad }
        java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x00ad }
        android.content.pm.ApplicationInfo r9 = r3.applicationInfo     // Catch:{ all -> 0x00ad }
        r8[r4] = r9     // Catch:{ all -> 0x00ad }
        java.lang.Object r6 = r6.invoke(r13, r8)     // Catch:{ all -> 0x00ad }
        java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00ad }
        boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00ad }
        if (r8 != 0) goto L_0x00ad
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ad }
        goto L_0x00ae
    L_0x00ad:
        r6 = r7
    L_0x00ae:
        java.lang.String r8 = "getApplicationInfo"
        r9 = 2
        java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ all -> 0x00d5 }
        java.lang.Class<java.lang.String> r11 = java.lang.String.class
        r10[r4] = r11     // Catch:{ all -> 0x00d5 }
        java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00d5 }
        r10[r5] = r11     // Catch:{ all -> 0x00d5 }
        java.lang.reflect.Method r8 = com.bytedance.sdk.openadsdk.utils.TTReflectUtils.m11989a(r1, r8, r10)     // Catch:{ all -> 0x00d5 }
        java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x00d5 }
        java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x00d5 }
        r9[r4] = r10     // Catch:{ all -> 0x00d5 }
        java.lang.Integer r10 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00d5 }
        r9[r5] = r10     // Catch:{ all -> 0x00d5 }
        java.lang.Object r8 = r8.invoke(r13, r9)     // Catch:{ all -> 0x00d5 }
        android.content.pm.ApplicationInfo r8 = (android.content.pm.ApplicationInfo) r8     // Catch:{ all -> 0x00d5 }
        if (r8 == 0) goto L_0x00d5
        java.lang.String r7 = r8.sourceDir     // Catch:{ all -> 0x00d5 }
    L_0x00d5:
        org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0115 }
        r8.<init>()     // Catch:{ all -> 0x0115 }
        java.lang.String r9 = "package_name"
        java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x0115 }
        r8.put(r9, r10)     // Catch:{ all -> 0x0115 }
        java.lang.String r9 = "first_install_time"
        long r10 = r3.firstInstallTime     // Catch:{ all -> 0x0115 }
        r8.put(r9, r10)     // Catch:{ all -> 0x0115 }
        java.lang.String r9 = "last_update_time"
        long r10 = r3.lastUpdateTime     // Catch:{ all -> 0x0115 }
        r8.put(r9, r10)     // Catch:{ all -> 0x0115 }
        java.lang.String r9 = "version_name"
        java.lang.String r10 = r3.versionName     // Catch:{ all -> 0x0115 }
        r8.put(r9, r10)     // Catch:{ all -> 0x0115 }
        java.lang.String r9 = "version_code"
        int r10 = r3.versionCode     // Catch:{ all -> 0x0115 }
        r8.put(r9, r10)     // Catch:{ all -> 0x0115 }
        java.lang.String r9 = "app_name"
        r8.put(r9, r6)     // Catch:{ all -> 0x0115 }
        java.lang.String r6 = "app_type"
        int r3 = r12.m9684a(r3)     // Catch:{ all -> 0x0115 }
        r8.put(r6, r3)     // Catch:{ all -> 0x0115 }
        java.lang.String r3 = "apk_dir"
        r8.put(r3, r7)     // Catch:{ all -> 0x0115 }
        r0.add(r8)     // Catch:{ all -> 0x0115 }
        goto L_0x0074
    L_0x0115:
        r13 = move-exception
        java.lang.String r1 = "ApplistHelper"
        java.lang.String r2 = "get install apps error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r1, r2, r13)
    L_0x011d:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p174h.ApplistHelper.m9690b(android.content.Context):java.util.List");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|(4:15|16|17|(1:19))|20|21|(3:23|24|32)(1:31)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00a4 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00aa A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006c A[SYNTHETIC] */
    /* renamed from: a */
    public java.util.List<java.lang.String> mo15715a(android.content.Context r11) {
        /*
        r10 = this;
        java.util.ArrayList r0 = new java.util.ArrayList
        r0.<init>()
        java.lang.String r1 = "utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"
        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.p174h.ApplistHelper.C2251b.m9703a(r1)     // Catch:{ all -> 0x00c4 }
        java.lang.String r2 = com.bytedance.sdk.openadsdk.core.AESKey.m9086a()     // Catch:{ all -> 0x00c4 }
        java.lang.String r1 = com.bytedance.sdk.openadsdk.core.AES.m9052b(r1, r2)     // Catch:{ all -> 0x00c4 }
        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00c4 }
        r2.<init>(r1)     // Catch:{ all -> 0x00c4 }
        java.lang.String r1 = "cn"
        java.lang.String r1 = r2.optString(r1)     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = "m1"
        java.lang.String r3 = r2.optString(r3)     // Catch:{ all -> 0x00c4 }
        r4 = 0
        java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ all -> 0x00c4 }
        java.lang.reflect.Method r1 = com.bytedance.sdk.openadsdk.utils.TTReflectUtils.m11989a(r1, r3, r5)     // Catch:{ all -> 0x00c4 }
        java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x00c4 }
        java.lang.Object r11 = r1.invoke(r11, r3)     // Catch:{ all -> 0x00c4 }
        java.lang.String r1 = "pn"
        java.lang.String r1 = r2.optString(r1)     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = "m2"
        java.lang.String r3 = r2.optString(r3)     // Catch:{ all -> 0x00c4 }
        java.lang.String r5 = "f"
        int r2 = r2.optInt(r5)     // Catch:{ all -> 0x00c4 }
        r5 = 1
        java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x00c4 }
        java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00c4 }
        r6[r4] = r7     // Catch:{ all -> 0x00c4 }
        java.lang.reflect.Method r3 = com.bytedance.sdk.openadsdk.utils.TTReflectUtils.m11989a(r1, r3, r6)     // Catch:{ all -> 0x00c4 }
        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x00c4 }
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00c4 }
        r6[r4] = r2     // Catch:{ all -> 0x00c4 }
        java.lang.Object r2 = r3.invoke(r11, r6)     // Catch:{ all -> 0x00c4 }
        boolean r3 = r2 instanceof java.util.List     // Catch:{ all -> 0x00c4 }
        if (r3 == 0) goto L_0x00cc
        java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x00c4 }
        if (r2 == 0) goto L_0x00cc
        boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x00c4 }
        if (r3 != 0) goto L_0x00cc
        java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00c4 }
    L_0x006c:
        boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00c4 }
        if (r3 == 0) goto L_0x00cc
        java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00c4 }
        boolean r6 = r3 instanceof android.content.pm.PackageInfo     // Catch:{ all -> 0x00c4 }
        if (r6 == 0) goto L_0x006c
        android.content.pm.PackageInfo r3 = (android.content.pm.PackageInfo) r3     // Catch:{ all -> 0x00c4 }
        java.lang.String r6 = "unknown"
        android.content.pm.ApplicationInfo r7 = r3.applicationInfo     // Catch:{ all -> 0x00c4 }
        if (r7 == 0) goto L_0x00a4
        java.lang.String r7 = "getApplicationLabel"
        java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ all -> 0x00a4 }
        java.lang.Class<android.content.pm.ApplicationInfo> r9 = android.content.pm.ApplicationInfo.class
        r8[r4] = r9     // Catch:{ all -> 0x00a4 }
        java.lang.reflect.Method r7 = com.bytedance.sdk.openadsdk.utils.TTReflectUtils.m11989a(r1, r7, r8)     // Catch:{ all -> 0x00a4 }
        java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a4 }
        android.content.pm.ApplicationInfo r9 = r3.applicationInfo     // Catch:{ all -> 0x00a4 }
        r8[r4] = r9     // Catch:{ all -> 0x00a4 }
        java.lang.Object r7 = r7.invoke(r11, r8)     // Catch:{ all -> 0x00a4 }
        java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00a4 }
        boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00a4 }
        if (r8 != 0) goto L_0x00a4
        java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x00a4 }
    L_0x00a4:
        int r7 = r10.m9684a(r3)     // Catch:{ all -> 0x00c4 }
        if (r7 == r5) goto L_0x006c
        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
        r7.<init>()     // Catch:{ all -> 0x00c4 }
        r7.append(r6)     // Catch:{ all -> 0x00c4 }
        java.lang.String r6 = ":"
        r7.append(r6)     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r3.packageName     // Catch:{ all -> 0x00c4 }
        r7.append(r3)     // Catch:{ all -> 0x00c4 }
        java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x00c4 }
        r0.add(r3)     // Catch:{ all -> 0x00c4 }
        goto L_0x006c
    L_0x00c4:
        r11 = move-exception
        java.lang.String r1 = "ApplistHelper"
        java.lang.String r2 = "loadApps error2: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r1, r2, r11)
    L_0x00cc:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p174h.ApplistHelper.mo15715a(android.content.Context):java.util.List");
    }

    /* renamed from: a */
    private int m9684a(PackageInfo packageInfo) {
        if (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return 1 & packageInfo.applicationInfo.flags;
    }

    public void run() {
        String str = "ApplistHelper";
        if (!C2566w.m12241a(this.f7611b)) {
            this.f7613d.set(false);
            return;
        }
        try {
            boolean c = this.f7612c.mo15723c();
            if (c) {
                long currentTimeMillis = System.currentTimeMillis();
                List b = m9690b(this.f7611b);
                StringBuilder sb = new StringBuilder();
                sb.append("get duration: ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                C2564t.m12220b(str, sb.toString());
                m9688a(b, c);
            } else {
                this.f7613d.set(false);
            }
        } catch (Throwable th) {
            this.f7613d.set(false);
            C2564t.m12223c(str, "upload sdk runnable error: ", th);
        }
    }

    /* renamed from: a */
    private boolean m9689a(List<JSONObject> list) {
        String str = "last_update_time";
        String str2 = "package_name";
        String str3 = "ApplistHelper";
        if (list == null || list.isEmpty()) {
            C2564t.m12220b(str3, "is app change true1");
            return false;
        }
        Collections.sort(list, this.f7615f);
        String b = AES.m9052b(this.f7612c.mo15722b(), AESKey.m9086a());
        if (TextUtils.isEmpty(b)) {
            C2564t.m12220b(str3, "is app change true2");
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(b);
            int length = jSONArray.length();
            if (length == list.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getJSONObject(i));
                }
                Collections.sort(arrayList, this.f7615f);
                int i2 = 0;
                while (i2 < length) {
                    JSONObject jSONObject = (JSONObject) list.get(i2);
                    JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                    String optString = jSONObject.optString(str2);
                    String optString2 = jSONObject.optString(str);
                    if (!(optString == null || optString2 == null || !optString.equals(jSONObject2.optString(str2)))) {
                        if (optString2.equals(jSONObject2.optString(str))) {
                            i2++;
                        }
                    }
                    C2564t.m12220b(str3, "is app change true3");
                    return true;
                }
                C2564t.m12220b(str3, "is app change false");
                return false;
            }
            C2564t.m12220b(str3, "is app change true4");
            return true;
        } catch (Throwable th) {
            C2564t.m12223c(str3, "is app change error: ", th);
            return true;
        }
    }

    /* renamed from: a */
    private void m9688a(final List<JSONObject> list, final boolean z) throws JSONException {
        List<JSONObject> list2;
        String str = "ApplistHelper";
        if (IdUtils.m9866d(this.f7611b) == null && IdUtils.m9865c(this.f7611b) == null && IdUtils.m9858a(this.f7611b) == null && OAIDHelper.m12248a() == null) {
            this.f7613d.set(false);
            C2564t.m12220b(str, "real upload error1");
            return;
        }
        boolean a = m9689a(list);
        List N = InternalContainer.m10069h().mo15766N();
        List O = InternalContainer.m10069h().mo15767O();
        if (a || ((N != null && !N.isEmpty()) || (O != null && !O.isEmpty()))) {
            if (a) {
                list2 = list;
            } else {
                list2 = new ArrayList<>();
            }
            JSONObject a2 = ToolUtils.m12000a(m9687a(list2, N, O));
            StringBuilder sb = new StringBuilder();
            sb.append("param:");
            sb.append(list == null ? 0 : list.size());
            C2564t.m12220b(str, sb.toString());
            new JsonObjectRequest(1, ToolUtils.m12046q("/api/ad/union/sdk/upload/app_info/"), a2, (C1983a<JSONObject>) new C1983a<JSONObject>() {
                /* renamed from: a */
                public void mo14171a(C1982p<JSONObject> pVar) {
                    String str = "ApplistHelper";
                    C2564t.m12220b(str, "real upload response");
                    if (pVar != null && pVar.mo14373a()) {
                        if (pVar.f6293a != null) {
                            if ("20000".equals(((JSONObject) pVar.f6293a).optString(NotificationCompat.CATEGORY_STATUS))) {
                                if (z) {
                                    ApplistHelper.this.f7612c.mo15720a();
                                }
                                ApplistHelper.this.f7612c.mo15721a(AES.m9050a(new JSONArray(list).toString(), AESKey.m9086a()));
                                StringBuilder sb = new StringBuilder();
                                sb.append("APP List upload success ! ");
                                sb.append(pVar.f6297e);
                                C2564t.m12220b(str, sb.toString());
                            }
                        }
                        C2564t.m12220b(str, "APP List upload failed !");
                    }
                    ApplistHelper.this.f7613d.set(false);
                }

                /* renamed from: b */
                public void mo14172b(C1982p<JSONObject> pVar) {
                    if (pVar != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("upload failed: code=");
                        sb.append(pVar.f6300h);
                        C2564t.m12223c("ApplistHelper", sb.toString(), pVar.f6295c);
                    }
                    ApplistHelper.this.f7613d.set(false);
                }
            }).setResponseOnMain(false).setShouldCache(false).build(TTNetClient.m11428a(this.f7611b).mo16657d());
            return;
        }
        this.f7613d.set(false);
        C2564t.m12220b(str, "real upload error2");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:30|31|58) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r1.put(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r10.put(r1);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00ea */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0140 */
    /* renamed from: a */
    private org.json.JSONObject m9687a(java.util.List<org.json.JSONObject> r9, java.util.List<java.lang.String> r10, java.util.List<java.lang.String> r11) {
        /*
        r8 = this;
        org.json.JSONObject r0 = new org.json.JSONObject
        r0.<init>()
        r1 = -1
        java.lang.String r2 = ""
        android.content.Context r3 = r8.f7611b     // Catch:{ Exception -> 0x014e }
        java.lang.String r3 = com.bytedance.sdk.openadsdk.core.IdUtils.m9866d(r3)     // Catch:{ Exception -> 0x014e }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x014e }
        r4 = 1
        if (r3 != 0) goto L_0x001c
        android.content.Context r1 = r8.f7611b     // Catch:{ Exception -> 0x014e }
        java.lang.String r2 = com.bytedance.sdk.openadsdk.core.IdUtils.m9866d(r1)     // Catch:{ Exception -> 0x014e }
        r1 = 1
    L_0x001c:
        if (r1 >= 0) goto L_0x002d
        java.lang.String r3 = com.bytedance.sdk.openadsdk.utils.OAIDHelper.m12248a()     // Catch:{ Exception -> 0x014e }
        boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x014e }
        if (r3 != 0) goto L_0x002d
        r1 = 4
        java.lang.String r2 = com.bytedance.sdk.openadsdk.utils.OAIDHelper.m12248a()     // Catch:{ Exception -> 0x014e }
    L_0x002d:
        if (r1 >= 0) goto L_0x0036
        r1 = 3
        android.content.Context r2 = r8.f7611b     // Catch:{ Exception -> 0x014e }
        java.lang.String r2 = com.bytedance.sdk.openadsdk.core.IdUtils.m9865c(r2)     // Catch:{ Exception -> 0x014e }
    L_0x0036:
        org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x014e }
        r3.<init>()     // Catch:{ Exception -> 0x014e }
        java.util.Iterator r5 = r9.iterator()     // Catch:{ Exception -> 0x014e }
    L_0x003f:
        boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x014e }
        if (r6 == 0) goto L_0x0055
        java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x014e }
        org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ Exception -> 0x014e }
        java.lang.String r7 = "package_name"
        java.lang.String r6 = r6.optString(r7)     // Catch:{ Exception -> 0x014e }
        r3.put(r6)     // Catch:{ Exception -> 0x014e }
        goto L_0x003f
    L_0x0055:
        java.lang.String r5 = "app_list"
        r0.put(r5, r3)     // Catch:{ Exception -> 0x014e }
        java.lang.String r3 = "app_info"
        org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x014e }
        r5.<init>(r9)     // Catch:{ Exception -> 0x014e }
        r0.put(r3, r5)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "timestamp"
        long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x014e }
        r0.put(r9, r5)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "device_id"
        r0.put(r9, r2)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "did"
        android.content.Context r2 = r8.f7611b     // Catch:{ Exception -> 0x014e }
        java.lang.String r2 = com.bytedance.sdk.openadsdk.core.IdUtils.m9858a(r2)     // Catch:{ Exception -> 0x014e }
        r0.put(r9, r2)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "os_version"
        java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x014e }
        r0.put(r9, r2)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "device_platform"
        java.lang.String r2 = "android"
        r0.put(r9, r2)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "device_model"
        java.lang.String r2 = android.os.Build.MODEL     // Catch:{ Exception -> 0x014e }
        r0.put(r9, r2)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "app_id"
        com.bytedance.sdk.openadsdk.core.h r2 = com.bytedance.sdk.openadsdk.core.GlobalInfo.m9616c()     // Catch:{ Exception -> 0x014e }
        java.lang.String r2 = r2.mo15675e()     // Catch:{ Exception -> 0x014e }
        r0.put(r9, r2)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "app_list_type"
        r0.put(r9, r4)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "sdk_version"
        java.lang.String r2 = "2.9.5.5"
        r0.put(r9, r2)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "device_id_type"
        r0.put(r9, r1)     // Catch:{ Exception -> 0x014e }
        if (r10 == 0) goto L_0x00f8
        boolean r9 = r10.isEmpty()     // Catch:{ Exception -> 0x014e }
        if (r9 != 0) goto L_0x00f8
        org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ Exception -> 0x014e }
        r9.<init>()     // Catch:{ Exception -> 0x014e }
        org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x014e }
        r1.<init>()     // Catch:{ Exception -> 0x014e }
        java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x014e }
    L_0x00c6:
        boolean r2 = r10.hasNext()     // Catch:{ Exception -> 0x014e }
        if (r2 == 0) goto L_0x00ee
        java.lang.Object r2 = r10.next()     // Catch:{ Exception -> 0x014e }
        java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x014e }
        boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x014e }
        if (r3 != 0) goto L_0x00c6
        android.content.Context r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x00ea }
        boolean r3 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12016c(r3, r2)     // Catch:{ all -> 0x00ea }
        if (r3 == 0) goto L_0x00e6
        r9.put(r2)     // Catch:{ all -> 0x00ea }
        goto L_0x00c6
    L_0x00e6:
        r1.put(r2)     // Catch:{ all -> 0x00ea }
        goto L_0x00c6
    L_0x00ea:
        r1.put(r2)     // Catch:{ Exception -> 0x014e }
        goto L_0x00c6
    L_0x00ee:
        java.lang.String r10 = "have_applist"
        r0.put(r10, r9)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "no_applist"
        r0.put(r9, r1)     // Catch:{ Exception -> 0x014e }
    L_0x00f8:
        if (r11 == 0) goto L_0x014e
        boolean r9 = r11.isEmpty()     // Catch:{ Exception -> 0x014e }
        if (r9 != 0) goto L_0x014e
        org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ Exception -> 0x014e }
        r9.<init>()     // Catch:{ Exception -> 0x014e }
        org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ Exception -> 0x014e }
        r10.<init>()     // Catch:{ Exception -> 0x014e }
        java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x014e }
    L_0x010e:
        boolean r1 = r11.hasNext()     // Catch:{ Exception -> 0x014e }
        if (r1 == 0) goto L_0x0144
        java.lang.Object r1 = r11.next()     // Catch:{ Exception -> 0x014e }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x014e }
        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x014e }
        if (r2 != 0) goto L_0x010e
        android.net.Uri r2 = android.net.Uri.parse(r1)     // Catch:{ all -> 0x0140 }
        android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x0140 }
        java.lang.String r4 = "android.intent.action.VIEW"
        r3.<init>(r4)     // Catch:{ all -> 0x0140 }
        r3.setData(r2)     // Catch:{ all -> 0x0140 }
        android.content.Context r2 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x0140 }
        boolean r2 = com.bytedance.sdk.openadsdk.utils.ToolUtils.m12004a(r2, r3)     // Catch:{ all -> 0x0140 }
        if (r2 == 0) goto L_0x013c
        r9.put(r1)     // Catch:{ all -> 0x0140 }
        goto L_0x010e
    L_0x013c:
        r10.put(r1)     // Catch:{ all -> 0x0140 }
        goto L_0x010e
    L_0x0140:
        r10.put(r1)     // Catch:{ Exception -> 0x014e }
        goto L_0x010e
    L_0x0144:
        java.lang.String r11 = "scheme_success_list"
        r0.put(r11, r9)     // Catch:{ Exception -> 0x014e }
        java.lang.String r9 = "scheme_fail_list"
        r0.put(r9, r10)     // Catch:{ Exception -> 0x014e }
    L_0x014e:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p174h.ApplistHelper.m9687a(java.util.List, java.util.List, java.util.List):org.json.JSONObject");
    }
}
