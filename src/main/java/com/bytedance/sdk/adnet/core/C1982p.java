package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p162e.ICache.C1994a;
import java.util.Map;

/* compiled from: Response */
/* renamed from: com.bytedance.sdk.adnet.core.p */
public class C1982p<T> {
    /* renamed from: a */
    public final T f6293a;
    /* renamed from: b */
    public final C1994a f6294b;
    /* renamed from: c */
    public final VAdError f6295c;
    /* renamed from: d */
    public boolean f6296d;
    /* renamed from: e */
    public long f6297e;
    /* renamed from: f */
    public long f6298f;
    /* renamed from: g */
    public Map<String, Object> f6299g;
    /* renamed from: h */
    public long f6300h;

    /* compiled from: Response */
    /* renamed from: com.bytedance.sdk.adnet.core.p$a */
    public interface C1983a<T> {
        /* renamed from: a */
        void mo14171a(C1982p<T> pVar);

        /* renamed from: b */
        void mo14172b(C1982p<T> pVar);
    }

    /* renamed from: a */
    public static <T> C1982p<T> m7917a(T t, C1994a aVar) {
        return new C1982p<>(t, aVar);
    }

    /* renamed from: a */
    public static <T> C1982p<T> m7916a(VAdError vAdError) {
        return new C1982p<>(vAdError);
    }

    /* renamed from: a */
    public Object mo14371a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, Object> map = this.f6299g;
            if (map != null) {
                return map.get(str);
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo14373a() {
        return this.f6295c == null;
    }

    private C1982p(T t, C1994a aVar) {
        this.f6296d = false;
        this.f6297e = 0;
        this.f6298f = 0;
        this.f6300h = 0;
        this.f6293a = t;
        this.f6294b = aVar;
        this.f6295c = null;
    }

    private C1982p(VAdError vAdError) {
        this.f6296d = false;
        this.f6297e = 0;
        this.f6298f = 0;
        this.f6300h = 0;
        this.f6293a = null;
        this.f6294b = null;
        this.f6295c = vAdError;
        if (this.f6300h == 0 && vAdError != null && vAdError.networkResponse != null) {
            this.f6300h = (long) vAdError.networkResponse.f6274a;
        }
    }

    /* renamed from: a */
    public C1982p mo14370a(long j) {
        this.f6297e = j;
        return this;
    }

    /* renamed from: b */
    public C1982p mo14374b(long j) {
        this.f6298f = j;
        return this;
    }

    /* renamed from: a */
    public String mo14372a(String str, String str2) {
        C1994a aVar = this.f6294b;
        if (aVar == null || aVar.f6331h == null) {
            return str2;
        }
        String str3 = (String) this.f6294b.f6331h.get(str);
        if (str3 == null) {
            str3 = str2;
        }
        return str3;
    }
}
