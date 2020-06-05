package com.bytedance.sdk.openadsdk.downloadnew.p181a.p183b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.p170d.C2222b;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadController.C6525a;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadEventConfig.C6527a;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadModel.C6529a;
import com.p530ss.android.p531a.p532a.p534b.SimpleDownloadModel.C6511a;
import com.p530ss.android.p531a.p532a.p536c.C6514b;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.b.b */
public class LibModelFactory {
    /* renamed from: a */
    private static int m11196a(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    /* renamed from: b */
    private static int m11201b(int i) {
        if (i != 0) {
            return (i == 1 || i != 2) ? 1 : 2;
        }
        return 0;
    }

    /* renamed from: a */
    public static C6511a m11197a(String str, String str2) {
        C6511a b = new C6511a().mo31088a(str).mo31089a(true).mo31092b(GlobalInfo.m9616c().mo15681k()).mo31094d(!GlobalInfo.m9616c().mo15681k()).mo31091b(LibHolder.f8618a);
        if (MultiGlobalInfo.m11808b()) {
            b.mo31093c(true);
        }
        return b;
    }

    /* renamed from: a */
    public static C6529a m11200a(String str, MaterialMeta kVar, JSONObject jSONObject) {
        if (kVar == null) {
            return new C6529a();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", LibEventExtra.m11189a().mo16547a(str).mo16549b(jSONObject).mo16546a(kVar).mo16550b());
        } catch (Exception unused) {
        }
        C6529a f = new C6529a().mo31177a(Long.valueOf(kVar.mo15425M()).longValue()).mo31186c(kVar.mo15415C() == null ? null : kVar.mo15415C().mo15406a()).mo31185b(GlobalInfo.m9616c().mo15681k()).mo31189d(!GlobalInfo.m9616c().mo15681k()).mo31179a(kVar.mo15428P()).mo31180a(jSONObject2).mo31191f(LibHolder.f8618a);
        C2222b N = kVar.mo15426N();
        if (N != null) {
            f.mo31188d(N.mo15342b()).mo31190e(N.mo15345c()).mo31184b(N.mo15348d());
        }
        if (MultiGlobalInfo.m11808b()) {
            f.mo31187c(true);
        }
        if (kVar.mo15427O() != null) {
            C6514b bVar = new C6514b();
            bVar.mo31101a(Long.valueOf(kVar.mo15425M()).longValue());
            bVar.mo31104b(kVar.mo15427O().mo15376a());
            bVar.mo31105c(kVar.mo15422J());
            if (kVar.mo15427O().mo15381c() != 2 || kVar.mo15429Q() == 5 || kVar.mo15429Q() == 15) {
                if (kVar.mo15427O().mo15381c() == 1) {
                    bVar.mo31102a(kVar.mo15427O().mo15379b());
                } else {
                    bVar.mo31102a(kVar.mo15417E());
                }
            }
            f.mo31178a(bVar);
        }
        return f;
    }

    /* renamed from: a */
    public static C6525a m11198a(MaterialMeta kVar) {
        int i;
        boolean z = true;
        int v = kVar == null ? 1 : kVar.mo15508v();
        if (kVar == null) {
            i = 0;
        } else {
            i = kVar.mo15509w();
        }
        if (kVar != null && !TextUtils.isEmpty(kVar.mo15438Z())) {
            i = 2;
        }
        C6525a a = new C6525a().mo31143a(m11201b(v)).mo31147b(m11196a(i)).mo31145a(true);
        if (kVar == null || !kVar.mo15507u()) {
            z = false;
        }
        return a.mo31149c(z).mo31148b(false).mo31144a((Object) kVar);
    }

    /* renamed from: a */
    public static C6527a m11199a(MaterialMeta kVar, String str) {
        String str2 = "download_failed";
        return new C6527a().mo31153a(true).mo31158c(true).mo31156b(true).mo31160d(false).mo31159d(str).mo31167k("click_start").mo31162f(str).mo31169m("click_continue").mo31161e(str).mo31168l("click_pause").mo31174r(str2).mo31166j(str).mo31173q(str2).mo31163g(str).mo31170n("click_install").mo31164h(str).mo31171o("click_open").mo31165i(str).mo31172p("open_url_app").mo31157c(str).mo31152a(str).mo31155b(str);
    }
}
