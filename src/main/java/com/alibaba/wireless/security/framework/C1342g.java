package com.alibaba.wireless.security.framework;

import com.alibaba.wireless.security.open.p084e.C1362b;
import com.tencent.p605ep.commonbase.software.AppEntity;

/* renamed from: com.alibaba.wireless.security.framework.g */
public class C1342g implements C1337b {
    /* renamed from: a */
    private String f3487a;
    /* renamed from: b */
    private String f3488b;
    /* renamed from: c */
    private ClassLoader f3489c;
    /* renamed from: d */
    private C1340e f3490d;
    /* renamed from: e */
    private C1362b f3491e;
    /* renamed from: f */
    private C1338c f3492f;

    public C1342g(String str, C1338c cVar, String str2, ClassLoader classLoader, C1340e eVar, C1362b bVar) {
        this.f3487a = str;
        this.f3492f = cVar;
        this.f3488b = str2;
        this.f3489c = classLoader;
        this.f3490d = eVar;
        this.f3491e = bVar;
    }

    /* renamed from: a */
    public String mo11843a() {
        return this.f3490d.f3473a != null ? this.f3490d.f3473a.versionName : this.f3490d.mo11847a(AppEntity.KEY_VERSION_STR);
    }

    /* renamed from: a */
    public String mo11856a(String str) {
        return this.f3490d.f3473a != null ? this.f3490d.f3473a.applicationInfo.metaData.getString(str) : this.f3490d.mo11847a(str);
    }

    /* renamed from: b */
    public String mo11844b() {
        return this.f3487a;
    }

    /* renamed from: c */
    public C1362b mo11845c() {
        return this.f3491e;
    }
}
