package com.alibaba.mtl.log.p078e;

import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.MD5Utils;

/* renamed from: com.alibaba.mtl.log.e.a */
public class BaseRequestAuth implements IRequestAuth {
    /* renamed from: a */
    private String f3434a = null;
    /* renamed from: b */
    private String f3435b = null;
    /* renamed from: c */
    private boolean f3436c = false;

    /* renamed from: a */
    public String mo11826a() {
        return this.f3434a;
    }

    public BaseRequestAuth(String str, String str2, boolean z) {
        this.f3434a = str;
        this.f3435b = str2;
        this.f3436c = z;
    }

    /* renamed from: b */
    public boolean mo11828b() {
        return this.f3436c;
    }

    /* renamed from: a */
    public String mo11827a(String str) {
        if (this.f3434a == null || this.f3435b == null) {
            Logger.m3833a("BaseRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f3435b);
            return MD5Utils.m3838a(MD5Utils.m3840c(sb.toString().getBytes()));
        }
    }
}
