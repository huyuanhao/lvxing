package com.bytedance.sdk.adnet.p162e;

import com.bytedance.sdk.adnet.core.C1969a;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.adnet.e.b */
public interface ICache {

    /* compiled from: ICache */
    /* renamed from: com.bytedance.sdk.adnet.e.b$a */
    public static class C1994a {
        /* renamed from: a */
        public int f6324a;
        /* renamed from: b */
        public byte[] f6325b;
        /* renamed from: c */
        public String f6326c;
        /* renamed from: d */
        public long f6327d;
        /* renamed from: e */
        public long f6328e;
        /* renamed from: f */
        public long f6329f;
        /* renamed from: g */
        public long f6330g;
        /* renamed from: h */
        public Map<String, String> f6331h = Collections.emptyMap();
        /* renamed from: i */
        public List<C1969a> f6332i;

        /* renamed from: a */
        public boolean mo14400a() {
            return this.f6329f < System.currentTimeMillis();
        }

        /* renamed from: b */
        public boolean mo14401b() {
            return this.f6330g < System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    C1994a mo14335a(String str);

    /* renamed from: a */
    void mo14337a();

    /* renamed from: a */
    void mo14338a(String str, C1994a aVar);
}
