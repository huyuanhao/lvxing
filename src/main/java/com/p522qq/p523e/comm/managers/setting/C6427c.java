package com.p522qq.p523e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.p522qq.p523e.comm.constants.Constants.SETTING;
import com.p522qq.p523e.comm.util.C6439a;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;
import com.p522qq.p523e.comm.util.SystemUtil;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.setting.c */
public class C6427c {
    /* renamed from: a */
    private JSONObject f20238a;

    /* renamed from: com.qq.e.comm.managers.setting.c$a */
    public static class C6428a {
        /* renamed from: a */
        private String f20239a;
        /* renamed from: b */
        private C6427c f20240b;

        public C6428a(String str, C6427c cVar) {
            this.f20239a = str;
            this.f20240b = cVar;
        }

        /* renamed from: a */
        public final String mo30163a() {
            return this.f20239a;
        }

        /* renamed from: b */
        public final C6427c mo30164b() {
            return this.f20240b;
        }
    }

    /* renamed from: com.qq.e.comm.managers.setting.c$b */
    public static class C6429b {
        /* renamed from: a */
        private String f20241a;
        /* renamed from: b */
        private C6426b f20242b;

        private C6429b(String str, C6426b bVar) {
            this.f20241a = str;
            this.f20242b = bVar;
        }

        /* synthetic */ C6429b(String str, C6426b bVar, byte b) {
            this(str, bVar);
        }

        /* renamed from: a */
        public final String mo30165a() {
            return this.f20241a;
        }

        /* renamed from: b */
        public final C6426b mo30166b() {
            return this.f20242b;
        }
    }

    public C6427c() {
        this.f20238a = new JSONObject();
    }

    public C6427c(String str) {
        this();
        StringBuilder sb = new StringBuilder("Initialize GDTAPPSetting,Json=");
        sb.append(str);
        GDTLogger.m25258d(sb.toString());
        if (!StringUtil.isEmpty(str)) {
            try {
                this.f20238a = new JSONObject(str);
            } catch (JSONException e) {
                GDTLogger.m25261e("JsonException While build GDTAPPSetting Instance from JSON", e);
            }
        }
    }

    /* renamed from: a */
    private static Pair<String, String> m25220a(Context context, String str) {
        File dir = context.getDir(SystemUtil.buildNewPathByProcessName(SETTING.SETTINGDIR), 0);
        if (dir.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".sig");
            File file = new File(dir, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(".cfg");
            File file2 = new File(dir, sb2.toString());
            if (file.exists() && file2.exists()) {
                try {
                    return new Pair<>(StringUtil.readAll(file), StringUtil.readAll(file2));
                } catch (IOException unused) {
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C6428a m25221a(Context context) {
        Pair a = m25220a(context, SETTING.DEV_CLOUD_SETTING);
        if (a == null) {
            return null;
        }
        try {
            if (C6439a.m25265a().mo30392a((String) a.first, (String) a.second)) {
                return new C6428a((String) a.first, new C6427c(new String(Base64.decode((String) a.second, 0), "UTF-8")));
            }
            GDTLogger.m25260e("verify local dev cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.m25261e("exception while loading local dev cloud setting", th);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m25222a(Context context, String str, String str2) {
        return m25223a(context, SETTING.SDK_CLOUD_SETTING, str, str2);
    }

    /* renamed from: a */
    private static final boolean m25223a(Context context, String str, String str2, String str3) {
        String format;
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
            format = String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", new Object[]{str, str2, str3});
        } else if (C6439a.m25265a().mo30392a(str2, str3)) {
            return m25226b(context, str, str2, str3);
        } else {
            format = String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", new Object[]{str, str2, str3});
        }
        GDTLogger.m25260e(format);
        return false;
    }

    /* renamed from: b */
    public static C6429b m25224b(Context context) {
        Pair a = m25220a(context, SETTING.SDK_CLOUD_SETTING);
        if (a == null) {
            return null;
        }
        try {
            if (C6439a.m25265a().mo30392a((String) a.first, (String) a.second)) {
                return new C6429b((String) a.first, new C6426b(new String(Base64.decode((String) a.second, 0), "UTF-8")), 0);
            }
            GDTLogger.m25260e("verify local sdk cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.m25261e("exception while loading local sdk cloud setting", th);
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m25225b(Context context, String str, String str2) {
        return m25223a(context, SETTING.DEV_CLOUD_SETTING, str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072 A[SYNTHETIC, Splitter:B:30:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0077 A[Catch:{ Exception -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007e A[SYNTHETIC, Splitter:B:38:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0083 A[Catch:{ Exception -> 0x0086 }] */
    /* renamed from: b */
    private static boolean m25226b(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
        java.lang.String r0 = "e_qq_com_setting"
        java.lang.String r0 = com.p522qq.p523e.comm.util.SystemUtil.buildNewPathByProcessName(r0)
        r1 = 0
        java.io.File r5 = r5.getDir(r0, r1)
        boolean r0 = r5.exists()
        if (r0 != 0) goto L_0x0014
        r5.mkdirs()
    L_0x0014:
        java.io.File r0 = new java.io.File
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        r2.append(r6)
        java.lang.String r3 = ".cfg"
        r2.append(r3)
        java.lang.String r2 = r2.toString()
        r0.<init>(r5, r2)
        java.io.File r2 = new java.io.File
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        r3.append(r6)
        java.lang.String r6 = ".sig"
        r3.append(r6)
        java.lang.String r6 = r3.toString()
        r2.<init>(r5, r6)
        r5 = 0
        java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
        r6.<init>(r0)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
        r6.write(r8)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
        java.io.FileWriter r8 = new java.io.FileWriter     // Catch:{ Exception -> 0x0063, all -> 0x005e }
        r8.<init>(r2)     // Catch:{ Exception -> 0x0063, all -> 0x005e }
        r8.write(r7)     // Catch:{ Exception -> 0x0064, all -> 0x0059 }
        r6.close()     // Catch:{ Exception -> 0x0057 }
        r8.close()     // Catch:{ Exception -> 0x0057 }
    L_0x0057:
        r5 = 1
        return r5
    L_0x0059:
        r5 = move-exception
        r4 = r6
        r6 = r5
        r5 = r4
        goto L_0x007c
    L_0x005e:
        r7 = move-exception
        r8 = r5
        r5 = r6
        r6 = r7
        goto L_0x007c
    L_0x0063:
        r8 = r5
    L_0x0064:
        r5 = r6
        goto L_0x006a
    L_0x0066:
        r6 = move-exception
        r8 = r5
        goto L_0x007c
    L_0x0069:
        r8 = r5
    L_0x006a:
        r0.delete()     // Catch:{ all -> 0x007b }
        r2.delete()     // Catch:{ all -> 0x007b }
        if (r5 == 0) goto L_0x0075
        r5.close()     // Catch:{ Exception -> 0x007a }
    L_0x0075:
        if (r8 == 0) goto L_0x007a
        r8.close()     // Catch:{ Exception -> 0x007a }
    L_0x007a:
        return r1
    L_0x007b:
        r6 = move-exception
    L_0x007c:
        if (r5 == 0) goto L_0x0081
        r5.close()     // Catch:{ Exception -> 0x0086 }
    L_0x0081:
        if (r8 == 0) goto L_0x0086
        r8.close()     // Catch:{ Exception -> 0x0086 }
    L_0x0086:
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p522qq.p523e.comm.managers.setting.C6427c.m25226b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo30159a(String str) {
        return this.f20238a.opt(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo30160a(String str, String str2) {
        JSONObject optJSONObject = this.f20238a.optJSONObject(KEYS.PLACEMENTS);
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        if (optJSONObject2 != null) {
            return optJSONObject2.opt(str);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30161a(String str, Object obj) {
        try {
            this.f20238a.putOpt(str, obj);
        } catch (JSONException e) {
            GDTLogger.m25261e("Exception while update setting", e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30162a(String str, Object obj, String str2) {
        String str3 = KEYS.PLACEMENTS;
        try {
            JSONObject optJSONObject = this.f20238a.optJSONObject(str3);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                this.f20238a.putOpt(str3, optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                optJSONObject.putOpt(str2, optJSONObject2);
            }
            if (obj == null) {
                optJSONObject2.remove(str);
            } else {
                optJSONObject2.putOpt(str, obj);
            }
        } catch (JSONException e) {
            GDTLogger.m25261e("Exception while update setting", e);
        }
    }
}
