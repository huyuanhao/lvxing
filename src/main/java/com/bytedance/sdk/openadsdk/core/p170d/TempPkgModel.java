package com.bytedance.sdk.openadsdk.core.p170d;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.d.o */
public class TempPkgModel {
    /* renamed from: a */
    private String f7469a;
    /* renamed from: b */
    private String f7470b;
    /* renamed from: c */
    private String f7471c;
    /* renamed from: d */
    private List<C2228a> f7472d;

    /* compiled from: TempPkgModel */
    /* renamed from: com.bytedance.sdk.openadsdk.core.d.o$a */
    public static class C2228a {
        /* renamed from: a */
        private String f7473a;
        /* renamed from: b */
        private String f7474b;
        /* renamed from: c */
        private int f7475c;

        public boolean equals(Object obj) {
            if (!(obj instanceof C2228a)) {
                return super.equals(obj);
            }
            String str = this.f7473a;
            boolean z = str != null && str.equals(((C2228a) obj).mo15560a());
            return z;
        }

        /* renamed from: a */
        public String mo15560a() {
            return this.f7473a;
        }

        /* renamed from: a */
        public void mo15562a(String str) {
            this.f7473a = str;
        }

        /* renamed from: b */
        public String mo15563b() {
            return this.f7474b;
        }

        /* renamed from: b */
        public void mo15564b(String str) {
            this.f7474b = str;
        }

        /* renamed from: c */
        public int mo15565c() {
            return this.f7475c;
        }

        /* renamed from: a */
        public void mo15561a(int i) {
            this.f7475c = i;
        }
    }

    /* renamed from: a */
    public String mo15550a() {
        return this.f7469a;
    }

    /* renamed from: a */
    public void mo15551a(String str) {
        this.f7469a = str;
    }

    /* renamed from: b */
    public String mo15553b() {
        return this.f7470b;
    }

    /* renamed from: b */
    public void mo15554b(String str) {
        this.f7470b = str;
    }

    /* renamed from: c */
    public String mo15555c() {
        return this.f7471c;
    }

    /* renamed from: c */
    public void mo15556c(String str) {
        this.f7471c = str;
    }

    /* renamed from: d */
    public List<C2228a> mo15557d() {
        if (this.f7472d == null) {
            this.f7472d = new ArrayList();
        }
        return this.f7472d;
    }

    /* renamed from: a */
    public void mo15552a(List<C2228a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f7472d = list;
    }

    /* renamed from: e */
    public boolean mo15558e() {
        return (mo15555c() == null || mo15553b() == null || mo15550a() == null) ? false : true;
    }

    /* renamed from: f */
    public String mo15559f() {
        if (mo15558e()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(ArgKey.KEY_NAME, mo15550a());
                jSONObject.putOpt(AppEntity.KEY_VERSION_STR, mo15553b());
                jSONObject.putOpt("main", mo15555c());
                JSONArray jSONArray = new JSONArray();
                if (mo15557d() != null) {
                    for (C2228a aVar : mo15557d()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", aVar.mo15560a());
                        jSONObject2.putOpt("md5", aVar.mo15563b());
                        jSONObject2.putOpt("level", Integer.valueOf(aVar.mo15565c()));
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.putOpt("resources", jSONArray);
                return jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: d */
    public static TempPkgModel m9470d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return m9469a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
            if (r1.mo15558e() == false) goto L_0x0073;
     */
    /* renamed from: a */
    public static com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel m9469a(org.json.JSONObject r7) {
        /*
        r0 = 0
        if (r7 != 0) goto L_0x0004
        return r0
    L_0x0004:
        com.bytedance.sdk.openadsdk.core.d.o r1 = new com.bytedance.sdk.openadsdk.core.d.o     // Catch:{ all -> 0x0073 }
        r1.m43682init()     // Catch:{ all -> 0x0073 }
        java.lang.String r2 = "name"
        java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x0072 }
        r1.mo15551a(r2)     // Catch:{ all -> 0x0072 }
        java.lang.String r2 = "version"
        java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x0072 }
        r1.mo15554b(r2)     // Catch:{ all -> 0x0072 }
        java.lang.String r2 = "main"
        java.lang.String r2 = r7.getString(r2)     // Catch:{ all -> 0x0072 }
        r1.mo15556c(r2)     // Catch:{ all -> 0x0072 }
        java.lang.String r2 = "resources"
        org.json.JSONArray r7 = r7.getJSONArray(r2)     // Catch:{ all -> 0x0072 }
        java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0072 }
        r2.<init>()     // Catch:{ all -> 0x0072 }
        if (r7 == 0) goto L_0x0068
        int r3 = r7.length()     // Catch:{ all -> 0x0072 }
        if (r3 <= 0) goto L_0x0068
        r3 = 0
    L_0x0038:
        int r4 = r7.length()     // Catch:{ all -> 0x0072 }
        if (r3 >= r4) goto L_0x0068
        org.json.JSONObject r4 = r7.getJSONObject(r3)     // Catch:{ all -> 0x0072 }
        com.bytedance.sdk.openadsdk.core.d.o$a r5 = new com.bytedance.sdk.openadsdk.core.d.o$a     // Catch:{ all -> 0x0072 }
        r5.m43683init()     // Catch:{ all -> 0x0072 }
        java.lang.String r6 = "url"
        java.lang.String r6 = r4.getString(r6)     // Catch:{ all -> 0x0072 }
        r5.mo15562a(r6)     // Catch:{ all -> 0x0072 }
        java.lang.String r6 = "md5"
        java.lang.String r6 = r4.getString(r6)     // Catch:{ all -> 0x0072 }
        r5.mo15564b(r6)     // Catch:{ all -> 0x0072 }
        java.lang.String r6 = "level"
        int r4 = r4.getInt(r6)     // Catch:{ all -> 0x0072 }
        r5.mo15561a(r4)     // Catch:{ all -> 0x0072 }
        r2.add(r5)     // Catch:{ all -> 0x0072 }
        int r3 = r3 + 1
        goto L_0x0038
    L_0x0068:
        r1.mo15552a(r2)     // Catch:{ all -> 0x0072 }
        boolean r7 = r1.mo15558e()     // Catch:{ all -> 0x0072 }
        if (r7 != 0) goto L_0x0072
        goto L_0x0073
    L_0x0072:
        r0 = r1
    L_0x0073:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.m9469a(org.json.JSONObject):com.bytedance.sdk.openadsdk.core.d.o");
    }
}
