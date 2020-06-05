package com.p368pw.inner.p369a.p370a.p373c;

import android.content.Context;
import com.p368pw.inner.C5237f;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5175d;
import com.p368pw.inner.base.p387d.C5193k;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.p389b.C5165a;
import com.tencent.p605ep.shanhuad.adpublic.ShanHuAD;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;
import com.tmsdk.module.coin.AbsTMSConfig;
import com.tmsdk.module.coin.TMSDKContext;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.pw.inner.a.a.c.i */
public class C4853i implements Runnable {
    /* renamed from: a */
    public static volatile boolean f15634a = false;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Context f15635b;
    /* renamed from: c */
    private String f15636c = "40805.dat";

    /* renamed from: com.pw.inner.a.a.c.i$a */
    private static class C4856a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C4853i f15639a = new C4853i();
    }

    /* renamed from: a */
    public static C4853i m19921a() {
        return C4856a.f15639a;
    }

    /* renamed from: a */
    private boolean m19922a(C5123d dVar) {
        String str;
        String str2 = "拷贝本地策略配置文件缓存到files目录结果：";
        if (m19926e()) {
            if (!dVar.mo26693U()) {
                C5205o.m21462a("有开发者配置文件，且策略不要求强制覆盖");
                return false;
            } else if (!m19927f()) {
                str = "有开发者配置文件，策略要求强制覆盖，但本地没有策略配置文件缓存";
            } else if (dVar.mo26692T() > m19924c()) {
                str = "有开发者配置文件，策略要求强制覆盖，本地有策略配置文件缓存，但不是最新版本";
            } else {
                C5205o.m21462a("有开发者配置文件，策略要求强制覆盖，本地有策略配置文件缓存，且已是最新版本");
                boolean b = m19923b();
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(b);
                C5205o.m21462a(sb.toString());
                return !b;
            }
        } else if (!m19927f()) {
            str = "没有开发者配置文件，也没有策略配置文件缓存";
        } else if (dVar.mo26692T() > m19924c()) {
            str = "没有开发者配置文，本地有策略配置文件缓存，但不是最新版本";
        } else {
            C5205o.m21462a("没有开发者配置文件，本地有策略配置文件缓存，且已是最新版本");
            boolean b2 = m19923b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(b2);
            C5205o.m21462a(sb2.toString());
            return !b2;
        }
        C5205o.m21462a(str);
        return true;
    }

    /* renamed from: b */
    private boolean m19923b() {
        File file = new File(this.f15635b.getCacheDir().getAbsolutePath(), this.f15636c);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f15635b.getFilesDir().getAbsolutePath());
            sb.append("/");
            sb.append(this.f15636c);
            return C5193k.m21427a(file, sb.toString());
        }
        C5205o.m21462a("策略配置文件缓存不存在，无法拷贝");
        return false;
    }

    /* renamed from: c */
    private long m19924c() {
        return C5237f.m21600j(this.f15635b);
    }

    /* renamed from: d */
    private void m19925d() {
        C5123d d = C5125f.m21216a().mo26727d();
        String S = d.mo26691S();
        if (S.toLowerCase().startsWith("https")) {
            C5165a.m21319a();
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(S).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(100000);
            httpURLConnection.setConnectTimeout(C7516p.f25219Cf);
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                File file = new File(this.f15635b.getCacheDir().getAbsoluteFile(), this.f15636c);
                if (file.exists()) {
                    file.delete();
                    C5205o.m21462a("删除cache目录的配置文件成功");
                }
                C5193k.m21426a(file, inputStream, false);
                StringBuilder sb = new StringBuilder();
                sb.append(this.f15635b.getFilesDir().getAbsolutePath());
                sb.append("/");
                sb.append(this.f15636c);
                boolean a = C5193k.m21427a(file, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("替换files目录的配置文件结果：");
                sb2.append(a);
                C5205o.m21462a(sb2.toString());
                C5237f.m21588d(this.f15635b, d.mo26692T());
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("策略的配置文件地址访问失败：");
            sb3.append(httpURLConnection.getResponseCode());
            C5205o.m21462a(sb3.toString());
        } catch (Throwable th) {
            C5205o.m21462a("下载策略配置文件异常");
            C5205o.m21464a(th);
        }
    }

    /* renamed from: e */
    private boolean m19926e() {
        try {
            C5175d.m21353a(this.f15635b.getAssets().open(this.f15636c));
            return true;
        } catch (Throwable unused) {
            C5175d.m21353a(null);
            return false;
        }
    }

    /* renamed from: f */
    private boolean m19927f() {
        try {
            return new File(this.f15635b.getCacheDir().getAbsolutePath(), this.f15636c).exists();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    /* renamed from: g */
    private void m19928g() {
        C5208r.m21479a(new Runnable() {
            public void run() {
                try {
                    TMSDKContext.setTMSDKLogEnable(C5205o.f16928a);
                    boolean init = TMSDKContext.init(C4853i.this.f15635b, new AbsTMSConfig() {
                        public String getServerAddress() {
                            return "mazu.3g.qq.com";
                        }
                    });
                    ShanHuAD.init(C4853i.this.f15635b, new C4846d(), TMSDKContext.getCoinProductId());
                    C4857j.m19935a().mo25875b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("珊瑚sdk初始化结果：");
                    sb.append(init);
                    C5205o.m21462a(sb.toString());
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("珊瑚sdk guid = ");
                        sb2.append(TMSDKContext.getGUID());
                        C5205o.m21462a(sb2.toString());
                        C4853i.f15634a = true;
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th) {
                    C5205o.m21464a(th);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo25864a(Context context) {
        this.f15635b = context.getApplicationContext();
        if (!f15634a) {
            C5208r.m21482b(this);
        }
    }

    public void run() {
        C5123d d = C5125f.m21216a().mo26727d();
        if (C5207q.m21476a((CharSequence) d.mo26691S())) {
            C5205o.m21462a("策略配置文件地址为空");
            if (m19926e()) {
                C5205o.m21462a("开发者有配置，初始化");
                m19928g();
            } else if (!m19927f()) {
                C5205o.m21462a("没有开发者配置文件，也没有策略配置，无法初始化");
            } else if (m19923b()) {
                C5205o.m21462a("用策略配置文件缓存，初始化");
                m19928g();
            } else {
                C5205o.m21462a("拷贝策略配置文件缓存失败，无法初始化");
            }
        } else {
            C5205o.m21462a("策略配置文件地址不为空");
            if (m19922a(d)) {
                C5205o.m21462a("开始下载并替换配置文件流程");
                m19925d();
            }
            m19928g();
        }
    }
}
