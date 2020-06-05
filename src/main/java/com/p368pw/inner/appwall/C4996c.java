package com.p368pw.inner.appwall;

import android.content.Context;
import com.p368pw.inner.C4817a;
import com.p368pw.inner.appwall.C4983ad.C4987b;
import com.p368pw.inner.appwall.C5041p.C5042a;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5187e;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5211s;
import com.p368pw.inner.base.p387d.p388a.C5153c;
import com.p368pw.inner.base.p387d.p388a.C5153c.C5158b;
import com.p368pw.inner.base.stat.C5224e;
import com.p368pw.inner.p369a.p379e.C4933e.C4940a;
import com.p368pw.view.AppWallActivity;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.List;

/* renamed from: com.pw.inner.appwall.c */
public class C4996c {
    /* renamed from: a */
    private boolean f16254a = false;
    /* renamed from: b */
    private int f16255b = 399;
    /* renamed from: c */
    private int f16256c;
    /* renamed from: d */
    private int f16257d;
    /* renamed from: e */
    private int f16258e;
    /* renamed from: f */
    private boolean f16259f = false;

    /* renamed from: com.pw.inner.appwall.c$a */
    private static class C5000a {
        /* access modifiers changed from: private|static */
        /* renamed from: a */
        public static C4996c f16267a = new C4996c();
    }

    /* renamed from: a */
    public static C4996c m20913a() {
        return C5000a.f16267a;
    }

    /* renamed from: a */
    private void m20914a(Context context) {
        try {
            if (!this.f16254a) {
                C5030k e = C5125f.m21216a().mo26728e();
                if (e != null) {
                    this.f16255b = 399;
                    this.f16256c = e.mo26434a();
                    this.f16257d = e.mo26435b();
                    this.f16258e = e.mo26436c();
                    this.f16254a = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo26383a(int i, List<C5034m> list, C5138c cVar) {
        int i2 = i;
        C5138c cVar2 = cVar;
        if (i2 == 1) {
            C5224e.m21525a().mo26908a(1, 1, "", 8, "", cVar2.f16787p, 0, 0, 0, 0, 0, cVar2.f16795x, cVar2.f16788q, cVar2.f16789r, 2, "", "", "", -2, 0.0d, "", "", 3, 0, cVar2.f16791t);
        }
        if (i2 == 2) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(((C5034m) list.get(i3)).mo26466a().f16791t);
                sb.append(StorageInterface.KEY_SPLITER);
            }
            sb.deleteCharAt(sb.length() - 1);
            String str = "";
            String str2 = "";
            C5224e.m21525a().mo26908a(2, 1, str, 8, str2, cVar2.f16787p, 0, 0, 0, 0, 0, cVar2.f16795x, cVar2.f16788q, cVar2.f16789r, 2, "", "", "", -2, 0.0d, "", "", 3, 0, sb.toString());
        }
    }

    /* renamed from: a */
    public void mo26384a(Context context, C5034m mVar) {
        try {
            m20914a(context);
            if (C4970aa.m20784a().mo26332d() != null) {
                C4970aa.m20784a().mo26332d().getAppwallListener().onClicked();
            }
            C5138c a = mVar.mo26466a();
            if (C5191i.m21390a(context, a.mo26743a())) {
                C5042a d = mVar.mo26469d();
                if (d == null || !d.mo26488i()) {
                    C5187e.m21376c(context, a.mo26743a());
                    C5004g.m20946a().mo26395a(mVar, 3);
                } else {
                    AppWallActivity c = C4970aa.m20784a().mo26331c();
                    if (c != null) {
                        if (!c.isFinishing()) {
                            final C5047t h = C4970aa.m20784a().mo26336h();
                            if (!(h == null || h.mo26542d() == null)) {
                                C4970aa.m20784a().mo26313a(3, h.mo26542d().mo26466a());
                                C4970aa.m20784a().mo26313a(4, h.mo26542d().mo26466a());
                            }
                            C4983ad a2 = C5046s.m21063a(c, 0.0d, 0, true, h);
                            a2.mo26358a((C4987b) new C4987b() {
                                /* renamed from: a */
                                public void mo26338a() {
                                    C5047t tVar = h;
                                    if (!(tVar == null || tVar.mo26542d() == null)) {
                                        C4970aa.m20784a().mo26313a(12, h.mo26542d().mo26466a());
                                    }
                                    if (C4970aa.m20784a().mo26334f() != null) {
                                        C4970aa.m20784a().mo26334f().onOfferDialogDismiss();
                                    }
                                }

                                /* renamed from: a */
                                public void mo26339a(int i) {
                                    if (i == 2) {
                                        C4970aa.m20784a().mo26320a(h);
                                    }
                                }
                            });
                            a2.show();
                        }
                    }
                }
            } else {
                m20913a().mo26388b(context, mVar);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26385a(Context context, C5034m mVar, C5138c cVar) {
        if (cVar != null) {
            C5205o.m21462a("sign active");
            C4970aa.m20784a().mo26314a(context, mVar, 2);
            C4970aa.m20784a().mo26317a(context, cVar.mo26743a());
        }
    }

    /* renamed from: a */
    public void mo26386a(List<C5034m> list) {
        if (!this.f16259f && list != null && list.size() > 0) {
            int size = list.size();
            StringBuilder sb = new StringBuilder();
            sb.append("sg ads size = ");
            sb.append(size);
            C5205o.m21462a(sb.toString());
            for (int i = 0; i < size; i++) {
                C5138c a = ((C5034m) list.get(i)).mo26466a();
                C4970aa.m20784a().mo26313a(3, a);
                C4970aa.m20784a().mo26313a(4, a);
            }
            this.f16259f = true;
        }
    }

    /* renamed from: b */
    public void mo26387b() {
        this.f16259f = false;
    }

    /* renamed from: b */
    public void mo26388b(final Context context, final C5034m mVar) {
        final C5138c a = mVar.mo26466a();
        C5153c.m21275a().mo26761a(context, a, a.f16777f, (C5158b) new C5158b() {
            /* renamed from: a */
            public void mo26340a() {
            }

            /* renamed from: b */
            public void mo26341b() {
                C5211s.m21484a(context.getApplicationContext(), C5207q.m21474a(C5125f.m21216a().mo26728e().mo26457x(), "应用下载成功，官方已验证，请放心安装"), 1);
                if (C4970aa.m20784a().mo26334f() != null) {
                    C5047t tVar = new C5047t(0, 2, 4, mVar, null);
                    C4970aa.m20784a().mo26334f().onInstallStart(tVar);
                }
                C4970aa.m20784a().mo26313a(9, a);
                C4817a.m19685a(context, a.mo26743a(), C4990b.m20866a(a), null, new C4940a() {
                    /* renamed from: a */
                    public void mo26162a(int i) {
                    }

                    /* renamed from: a */
                    public void mo26163a(String str, String str2) {
                        C4970aa.m20784a().mo26313a(7, a);
                        C5004g.m20946a().mo26397b(mVar, 3);
                    }

                    /* renamed from: b */
                    public void mo26164b(String str, String str2) {
                    }
                });
            }

            /* renamed from: c */
            public void mo26342c() {
            }
        });
    }
}
