package com.bytedance.sdk.openadsdk.core.widget.webview.p179a;

import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel;
import com.bytedance.sdk.openadsdk.core.p170d.TmplDiffModel;
import com.bytedance.sdk.openadsdk.core.p174h.TplInfo;
import com.bytedance.sdk.openadsdk.utils.FileUtils;
import java.io.File;
import java.util.Set;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.webview.a.a */
public class TTDynamic {
    /* renamed from: a */
    public static void m10863a() {
        TemplateManager.m10874a();
        TmplDiffManager.m10896a();
    }

    /* renamed from: b */
    public static void m10868b() {
        try {
            C2373f.m10918d();
            File e = TemplateManager.m10879e();
            if (e != null && e.exists()) {
                if (e.getParentFile() != null) {
                    FileUtils.m12176c(e.getParentFile());
                } else {
                    FileUtils.m12176c(e);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static void m10869c() {
        TmplDiffManager.m10896a().mo16380b();
    }

    /* renamed from: a */
    public static void m10864a(MaterialMeta kVar) {
        TmplDiffManager.m10896a().mo16377a(kVar);
    }

    /* renamed from: a */
    public static void m10865a(TplInfo mVar) {
        TmplDiffManager.m10896a().mo16378a(mVar, "");
    }

    /* renamed from: d */
    public static String m10870d() {
        return TmplDbHelper.m10888c();
    }

    /* renamed from: a */
    public static void m10866a(Set<String> set) {
        TmplDiffManager.m10896a().mo16379a(set);
    }

    /* renamed from: e */
    public static void m10871e() {
        TmplDiffManager.m10896a().mo16381c();
    }

    /* renamed from: a */
    public static TmplDiffModel m10862a(String str) {
        return TmplDiffManager.m10896a().mo16376a(str);
    }

    /* renamed from: b */
    public static TmplDiffModel m10867b(MaterialMeta kVar) {
        if (kVar == null || kVar.mo15510x() == null) {
            return null;
        }
        return TmplDiffManager.m10896a().mo16376a(kVar.mo15510x().mo15515b());
    }

    /* renamed from: f */
    public static TempPkgModel m10872f() {
        return TemplateManager.m10874a().mo16367c();
    }

    /* renamed from: g */
    public static boolean m10873g() {
        return TemplateManager.m10874a().mo16366b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
            if (r2.mo15563b().equals(r4) != false) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057 A[SYNTHETIC, Splitter:B:15:0x0057] */
    /* renamed from: a */
    public static android.webkit.WebResourceResponse m10861a(java.lang.String r4, com.bytedance.sdk.openadsdk.core.widget.webview.p179a.UrlUtils.C2372a r5) {
        /*
        boolean r0 = m10873g()
        r1 = 0
        if (r0 == 0) goto L_0x0054
        com.bytedance.sdk.openadsdk.core.d.o r0 = m10872f()
        java.util.List r0 = r0.mo15557d()
        java.util.Iterator r0 = r0.iterator()
    L_0x0013:
        boolean r2 = r0.hasNext()
        if (r2 == 0) goto L_0x0054
        java.lang.Object r2 = r0.next()
        com.bytedance.sdk.openadsdk.core.d.o$a r2 = (com.bytedance.sdk.openadsdk.core.p170d.TempPkgModel.C2228a) r2
        java.lang.String r3 = r2.mo15560a()
        if (r3 == 0) goto L_0x0013
        java.lang.String r3 = r2.mo15560a()
        boolean r3 = r3.equals(r4)
        if (r3 == 0) goto L_0x0013
        java.lang.String r4 = r2.mo15560a()
        java.lang.String r4 = com.bytedance.sdk.openadsdk.utils.DigestUtils.m12169a(r4)
        java.io.File r0 = new java.io.File
        java.io.File r3 = com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TemplateManager.m10879e()
        r0.<init>(r3, r4)
        java.lang.String r4 = com.bytedance.sdk.openadsdk.utils.DigestUtils.m12168a(r0)
        java.lang.String r3 = r2.mo15563b()
        if (r3 == 0) goto L_0x0054
        java.lang.String r2 = r2.mo15563b()
        boolean r4 = r2.equals(r4)
        if (r4 != 0) goto L_0x0055
    L_0x0054:
        r0 = r1
    L_0x0055:
        if (r0 == 0) goto L_0x0070
        android.webkit.WebResourceResponse r4 = new android.webkit.WebResourceResponse     // Catch:{ all -> 0x0068 }
        java.lang.String r5 = r5.mo16385a()     // Catch:{ all -> 0x0068 }
        java.lang.String r2 = "utf-8"
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0068 }
        r3.<init>(r0)     // Catch:{ all -> 0x0068 }
        r4.<init>(r5, r2, r3)     // Catch:{ all -> 0x0068 }
        goto L_0x0071
    L_0x0068:
        r4 = move-exception
        java.lang.String r5 = "TTDynamic"
        java.lang.String r0 = "get html WebResourceResponse error"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r5, r0, r4)
    L_0x0070:
        r4 = r1
    L_0x0071:
        return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic.m10861a(java.lang.String, com.bytedance.sdk.openadsdk.core.widget.webview.a.e$a):android.webkit.WebResourceResponse");
    }
}
