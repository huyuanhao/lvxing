package com.alibaba.mtl.appmonitor.p068a;

import com.alibaba.mtl.appmonitor.p070c.Reusable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.a.h */
public class UTEvent implements Reusable {
    /* renamed from: a */
    public String f3181a;
    /* renamed from: b */
    public int f3182b;
    /* renamed from: c */
    public String f3183c;
    /* renamed from: d */
    public String f3184d;
    /* renamed from: e */
    public String f3185e;
    /* renamed from: f */
    public Map<String, String> f3186f;

    /* renamed from: d */
    public void mo11546d() {
        this.f3181a = null;
        this.f3182b = 0;
        this.f3183c = null;
        this.f3184d = null;
        this.f3185e = null;
        Map<String, String> map = this.f3186f;
        if (map != null) {
            map.clear();
        }
    }

    /* renamed from: a */
    public void mo11548a(Object... objArr) {
        if (this.f3186f == null) {
            this.f3186f = new HashMap();
        }
    }
}
