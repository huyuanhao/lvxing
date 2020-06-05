package com.p368pw.inner.p369a.p379e;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.p368pw.inner.C5069b;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.p388a.C5153c;
import com.p368pw.inner.base.p387d.p391d.C5176a;
import com.p368pw.inner.base.p387d.p391d.C5176a.C5181a;
import com.p368pw.inner.p369a.p379e.p380a.p382b.C4925a;

/* renamed from: com.pw.inner.a.e.k */
public class C4964k extends C4929b {
    /* renamed from: c */
    private C5176a f16128c;
    /* renamed from: d */
    private Context f16129d;
    /* renamed from: e */
    private String f16130e;
    /* renamed from: f */
    private String f16131f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public int f16132g;
    /* renamed from: h */
    private String f16133h;
    /* renamed from: i */
    private String f16134i;
    /* renamed from: j */
    private String f16135j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public String f16136k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public String f16137l;
    /* renamed from: m */
    private int f16138m = 1;
    /* renamed from: n */
    private String f16139n = "portrait";

    public C4964k(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20744a(String str, int i, String str2, String str3) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:getTmpInfo({clickType:");
            sb.append(this.f16138m);
            sb.append(",device:'");
            sb.append(this.f16139n);
            sb.append("',link:'");
            sb.append(str);
            sb.append("',type:");
            sb.append(i);
            sb.append(",buttonText:'");
            sb.append(str2);
            sb.append("',desc:'");
            sb.append(str3);
            sb.append("'})");
            if (this.f16128c != null) {
                this.f16128c.loadUrl(sb.toString());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20745a(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:getTmpInfo({icon:'");
            sb.append(this.f16133h);
            sb.append("',clickType:");
            sb.append(3);
            sb.append(",link:'");
            sb.append(str);
            sb.append("',desc:'");
            sb.append(str2);
            sb.append("'})");
            if (this.f16128c != null) {
                this.f16128c.loadUrl(sb.toString());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20746a(String str, String str2, String str3) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:getTmpInfo({clickType:");
            sb.append(this.f16138m);
            sb.append(",device:'");
            sb.append(this.f16139n);
            sb.append("',link:'");
            sb.append(str);
            sb.append("',desc:'");
            sb.append(str3);
            sb.append("',buttonText:'");
            sb.append(str2);
            sb.append("'})");
            if (this.f16128c != null) {
                this.f16128c.loadUrl(sb.toString());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m20749j(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:getTmpInfo({clickType:");
            sb.append(this.f16138m);
            sb.append(",device:'");
            sb.append(this.f16139n);
            sb.append("',icon:'");
            sb.append(this.f16133h);
            sb.append("',link:'");
            sb.append("video://download");
            sb.append("',title:'");
            sb.append(this.f16134i);
            sb.append("',buttonText:'");
            sb.append(str);
            sb.append("',desc:'");
            sb.append(this.f16135j);
            sb.append("'})");
            if (this.f16128c != null) {
                this.f16128c.loadUrl(sb.toString());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public C4964k mo26276a(int i) {
        this.f16132g = i;
        return this;
    }

    /* renamed from: a */
    public C4964k mo26277a(final Context context) {
        this.f16129d = context;
        try {
            this.f16128c = new C5176a(this.f16129d, new C5181a() {
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
            if (r9.equals(r0) == false) goto L_0x006b;
     */
                public void onPageFinished(android.webkit.WebView r8, java.lang.String r9) {
                    /*
                    r7 = this;
                    super.onPageFinished(r8, r9)
                    if (r9 != 0) goto L_0x0007
                    java.lang.String r9 = ""
                L_0x0007:
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                    int r8 = r8.f16132g
                    java.lang.String r0 = "about:blank"
                    r1 = 1
                    if (r8 != r1) goto L_0x0070
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r8 = r8.f16136k
                    boolean r8 = android.text.TextUtils.isEmpty(r8)
                    java.lang.String r2 = "查 看"
                    if (r8 == 0) goto L_0x0065
                    android.content.Context r8 = r4
                    com.pw.inner.a.e.k r3 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r3 = r3.f16137l
                    boolean r8 = com.p368pw.inner.base.p387d.C5191i.m21390a(r8, r3)
                    if (r8 == 0) goto L_0x0043
                    com.pw.inner.b r8 = com.p368pw.inner.C5069b.m21115a()
                    com.pw.inner.a.e.k r3 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r3 = r3.f16137l
                    boolean r8 = r8.mo26583b(r3)
                    if (r8 == 0) goto L_0x006b
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r2 = "打 开"
                    goto L_0x006d
                L_0x0043:
                    com.pw.inner.base.d.a.c r8 = com.p368pw.inner.base.p387d.p388a.C5153c.m21275a()
                    android.content.Context r2 = r4
                    com.pw.inner.a.e.k r3 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r3 = r3.f16137l
                    int r8 = r8.mo26759a(r2, r3)
                    if (r8 != r1) goto L_0x005a
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r2 = "安 装"
                    goto L_0x006d
                L_0x005a:
                    boolean r8 = r9.equals(r0)
                    if (r8 != 0) goto L_0x0070
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r2 = "下 载"
                    goto L_0x006d
                L_0x0065:
                    boolean r8 = r9.equals(r0)
                    if (r8 != 0) goto L_0x0070
                L_0x006b:
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                L_0x006d:
                    r8.m20749j(r2)
                L_0x0070:
                    com.pw.inner.base.a.f r8 = com.p368pw.inner.base.p384a.C5125f.m21216a()
                    com.pw.inner.base.a.d r8 = r8.mo26727d()
                    com.pw.inner.a.e.k r2 = com.p368pw.inner.p369a.p379e.C4964k.this
                    int r2 = r2.f16132g
                    r3 = 2
                    if (r2 != r3) goto L_0x0103
                    com.pw.inner.a.e.k r2 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r2 = r2.f16136k
                    boolean r2 = android.text.TextUtils.isEmpty(r2)
                    java.lang.String r3 = "video://retain.download"
                    if (r2 == 0) goto L_0x00f6
                    android.content.Context r2 = r4
                    com.pw.inner.a.e.k r4 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r4 = r4.f16137l
                    boolean r2 = com.p368pw.inner.base.p387d.C5191i.m21390a(r2, r4)
                    r4 = 0
                    if (r2 == 0) goto L_0x00c5
                    com.pw.inner.b r2 = com.p368pw.inner.C5069b.m21115a()
                    com.pw.inner.a.e.k r5 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r5 = r5.f16137l
                    boolean r2 = r2.mo26583b(r5)
                    if (r2 == 0) goto L_0x00bc
                    com.pw.inner.a.e.k r2 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r4 = r8.mo26677E()
                    java.lang.String r8 = r8.mo26678F()
                    r2.m20744a(r3, r1, r4, r8)
                    goto L_0x0103
                L_0x00bc:
                    com.pw.inner.a.e.k r1 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r8 = r8.mo26678F()
                    java.lang.String r2 = "马上更新"
                    goto L_0x00e1
                L_0x00c5:
                    com.pw.inner.base.d.a.c r2 = com.p368pw.inner.base.p387d.p388a.C5153c.m21275a()
                    android.content.Context r5 = r4
                    com.pw.inner.a.e.k r6 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r6 = r6.f16137l
                    int r2 = r2.mo26759a(r5, r6)
                    if (r2 != r1) goto L_0x00e5
                    com.pw.inner.a.e.k r1 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r2 = r8.mo26675C()
                    java.lang.String r8 = r8.mo26676D()
                L_0x00e1:
                    r1.m20744a(r3, r4, r2, r8)
                    goto L_0x0103
                L_0x00e5:
                    boolean r1 = r9.equals(r0)
                    if (r1 != 0) goto L_0x0103
                    com.pw.inner.a.e.k r1 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r2 = r8.mo26673A()
                    java.lang.String r8 = r8.mo26674B()
                    goto L_0x00e1
                L_0x00f6:
                    com.pw.inner.a.e.k r1 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r2 = r8.mo26679G()
                    java.lang.String r8 = r8.mo26680H()
                    r1.m20746a(r3, r2, r8)
                L_0x0103:
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                    int r8 = r8.f16132g
                    r1 = 3
                    if (r8 != r1) goto L_0x0127
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r8 = r8.f16136k
                    boolean r8 = android.text.TextUtils.isEmpty(r8)
                    if (r8 == 0) goto L_0x0127
                    boolean r8 = r9.equals(r0)
                    if (r8 != 0) goto L_0x0127
                    com.pw.inner.a.e.k r8 = com.p368pw.inner.p369a.p379e.C4964k.this
                    java.lang.String r9 = "video://open"
                    java.lang.String r0 = "马上打开APP体验一下~"
                    r8.m20745a(r9, r0)
                L_0x0127:
                    return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.p368pw.inner.p369a.p379e.C4964k.C49651.onPageFinished(android.webkit.WebView, java.lang.String):void");
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("wb url loading = ");
                    sb.append(str);
                    C5205o.m21462a(sb.toString());
                    try {
                        if (str.startsWith("video://close")) {
                            C4964k.this.mo26122a();
                            C4964k.this.mo26123a(str);
                            return true;
                        }
                        if (!str.startsWith("video://download") && !str.contains("video://install") && !str.contains("video://open")) {
                            if (!str.startsWith("video://retain.download")) {
                                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                                    C4964k.this.mo26123a(str);
                                    C4964k.this.mo26122a();
                                    return true;
                                }
                                return super.shouldOverrideUrlLoading(webView, str);
                            }
                        }
                        C4964k.this.mo26123a(str);
                        return true;
                    } catch (Exception e) {
                        C5205o.m21464a((Throwable) e);
                    }
                }
            });
            addView(this.f16128c, new LayoutParams(-1, -1));
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        return this;
    }

    /* renamed from: b */
    public C4964k mo26278b(int i) {
        this.f16138m = i;
        return this;
    }

    /* renamed from: b */
    public C4964k mo26279b(String str) {
        this.f16133h = str;
        return this;
    }

    /* renamed from: b */
    public void mo26280b() {
        if (!TextUtils.isEmpty(this.f16130e)) {
            mo26290h(this.f16130e);
        }
        if (!TextUtils.isEmpty(this.f16131f)) {
            mo26291i(this.f16131f);
        }
    }

    /* renamed from: c */
    public C4964k mo26281c(String str) {
        this.f16134i = str;
        return this;
    }

    /* renamed from: c */
    public void mo26282c() {
        C4925a.m20445a(this.f16128c);
    }

    /* renamed from: c */
    public void mo26283c(int i) {
        if (i == 1 || i == 7) {
            this.f16139n = "portrait";
            mo26285d();
        }
        if (i == 0 || i == 8) {
            this.f16139n = "landscape";
            mo26285d();
        }
    }

    /* renamed from: d */
    public C4964k mo26284d(String str) {
        this.f16135j = str;
        return this;
    }

    /* renamed from: d */
    public void mo26285d() {
        String A;
        String B;
        try {
            if (this.f16132g == 1) {
                String str = TextUtils.isEmpty(this.f16136k) ? C5191i.m21390a(this.f16129d, this.f16137l) ? C5069b.m21115a().mo26583b(this.f16137l) ? "打 开" : "更 新" : C5153c.m21275a().mo26759a(this.f16129d, this.f16137l) == 1 ? "安 装" : "下 载" : "查 看";
                m20749j(str);
            }
            if (this.f16132g == 2) {
                C5123d d = C5125f.m21216a().mo26727d();
                String str2 = "video://retain.download";
                if (C5191i.m21390a(this.f16129d, this.f16137l)) {
                    if (C5069b.m21115a().mo26583b(this.f16137l)) {
                        m20744a(str2, 1, d.mo26677E(), d.mo26678F());
                    } else {
                        A = "马上更新";
                        B = d.mo26678F();
                    }
                } else if (C5153c.m21275a().mo26759a(this.f16129d, this.f16137l) == 1) {
                    A = d.mo26675C();
                    B = d.mo26676D();
                } else {
                    A = d.mo26673A();
                    B = d.mo26674B();
                }
                m20744a(str2, 0, A, B);
            }
            if (this.f16132g == 3) {
                m20745a("video://open", "马上打开APP体验一下~");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: e */
    public C4964k mo26286e(String str) {
        this.f16136k = str;
        return this;
    }

    /* renamed from: f */
    public C4964k mo26287f(String str) {
        this.f16137l = str;
        return this;
    }

    /* renamed from: g */
    public C4964k mo26288g(String str) {
        this.f16130e = str;
        return this;
    }

    public String getUrl() {
        return this.f16130e;
    }

    /* renamed from: h */
    public void mo26290h(String str) {
        if (TextUtils.isEmpty(str)) {
            C5205o.m21462a("wb url s null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("wb  url s: ");
        sb.append(str);
        C5205o.m21462a(sb.toString());
        this.f16128c.loadUrl(str);
    }

    /* renamed from: i */
    public void mo26291i(String str) {
        if (TextUtils.isEmpty(str)) {
            C5205o.m21462a("wb html s null");
            return;
        }
        this.f16128c.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
    }
}
