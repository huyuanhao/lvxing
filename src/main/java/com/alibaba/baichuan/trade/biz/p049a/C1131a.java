package com.alibaba.baichuan.trade.biz.p049a;

import com.ali.auth.third.core.model.C1030k;
import com.ali.auth.third.core.p023b.C0984b;
import com.ali.auth.third.core.p023b.C0985c;
import com.ali.auth.third.p016a.C0958b;
import com.alibaba.baichuan.trade.common.adapter.p060b.C1211c;
import com.alibaba.baichuan.trade.common.utils.C1224a;

/* renamed from: com.alibaba.baichuan.trade.biz.a.a */
public class C1131a {
    /* renamed from: a */
    private int f2333a;
    /* renamed from: b */
    private String f2334b;
    /* renamed from: c */
    private int f2335c;
    /* renamed from: d */
    private String f2336d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f2337e;
    /* renamed from: f */
    private C0958b f2338f;

    /* renamed from: com.alibaba.baichuan.trade.biz.a.a$1 */
    class C11321 implements C0984b {
        /* renamed from: a */
        final /* synthetic */ C1135b f2339a;
        /* renamed from: b */
        final /* synthetic */ C1131a f2340b;

        /* renamed from: a */
        public void mo10305a(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("MemberSDK init error, code: ");
            sb.append(i);
            sb.append(" message: ");
            sb.append(str);
            C1224a.m2406d("AlibcLogin", sb.toString());
            this.f2339a.mo10642a(i, str);
            this.f2340b.f2337e = false;
        }
    }

    /* renamed from: com.alibaba.baichuan.trade.biz.a.a$a */
    private static class C1134a {
        /* renamed from: a */
        public static C1131a f2343a = new C1131a(null);
    }

    private C1131a() {
        this.f2333a = -1;
        this.f2334b = "context对象为空导致失败";
        this.f2335c = -2;
        this.f2336d = "loginService对象为空导致失败";
    }

    /* synthetic */ C1131a(C11321 r1) {
        this();
    }

    /* renamed from: a */
    public static C1131a m2193a() {
        return C1134a.f2343a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2194a(int i) {
        String str;
        String str2;
        String str3 = "Login";
        if (i == 10004 || i == 10003) {
            str = "登录取消";
            str2 = "140102";
        } else {
            str = "登录失败";
            str2 = "140101";
        }
        C1211c.m2375a(str3, str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2198d() {
        C1211c.m2374a("Login");
    }

    /* renamed from: a */
    public void mo10645a(final C1135b bVar) {
        String str = "AlibcLogin";
        C1224a.m2404b(str, "登录操作");
        if (bVar != null) {
            if (!this.f2337e || this.f2338f == null) {
                C1224a.m2406d(str, "没有初始化成功或者loginService=null,导致调用失败");
                bVar.mo10642a(this.f2335c, this.f2336d);
                return;
            }
            C1224a.m2404b(str, "调用loginService.auth进行授权");
            this.f2338f.mo10271a((C0985c) new C0985c() {
                /* renamed from: a */
                public void mo10305a(int i, String str) {
                    C1224a.m2404b("AlibcLogin", "auth失败");
                    C1131a.this.m2194a(i);
                    bVar.mo10642a(i, str);
                }

                /* renamed from: a */
                public void mo10306a(C1030k kVar) {
                    C1224a.m2404b("AlibcLogin", "auth成功");
                    C1131a.this.m2198d();
                    bVar.mo10643a(2, kVar.f2060d, kVar.f2058b);
                }
            });
        }
    }

    /* renamed from: b */
    public boolean mo10646b() {
        C0958b bVar = this.f2338f;
        if (bVar == null || !this.f2337e) {
            return false;
        }
        return bVar.mo10273b();
    }

    /* renamed from: c */
    public C1030k mo10647c() {
        C0958b bVar = this.f2338f;
        if (bVar == null || !this.f2337e) {
            return null;
        }
        return bVar.mo10270a();
    }
}
