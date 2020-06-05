package com.bytedance.sdk.openadsdk.p185f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.AES;
import com.bytedance.sdk.openadsdk.core.AESKey;
import com.bytedance.sdk.openadsdk.core.AdPreference;
import com.bytedance.sdk.openadsdk.core.GlobalInfo;
import com.bytedance.sdk.openadsdk.core.IdUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.BackHtmlModel;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.p185f.p186a.LogStatsBase;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import com.bytedance.sdk.openadsdk.utils.AdLocation;
import com.bytedance.sdk.openadsdk.utils.AdLocationUtils;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.ToolUtils;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.bugly.beta.tinker.TinkerUtils;
import com.tencent.mid.sotrage.StorageInterface;
import discoveryAD.C7880W.C7881a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.f.a */
public class StatsLogManager {
    /* renamed from: a */
    private static volatile StatsLogManager f8632a;

    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean m11284o(LogStatsBase dVar) {
        return dVar == null;
    }

    private StatsLogManager() {
    }

    /* renamed from: a */
    public static StatsLogManager m11278a() {
        if (f8632a == null) {
            synchronized (StatsLogManager.class) {
                if (f8632a == null) {
                    f8632a = new StatsLogManager();
                }
            }
        }
        return f8632a;
    }

    /* renamed from: a */
    public void mo16566a(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16616a(dVar);
        }
    }

    /* renamed from: b */
    public void mo16569b() {
        boolean alist = GlobalInfo.m9616c().mo15672d().alist();
        boolean isCanUseLocation = GlobalInfo.m9616c().mo15672d().isCanUseLocation();
        boolean isCanUseWriteExternal = GlobalInfo.m9616c().mo15672d().isCanUseWriteExternal();
        boolean isCanUseWifiState = GlobalInfo.m9616c().mo15672d().isCanUseWifiState();
        boolean isCanUsePhoneState = GlobalInfo.m9616c().mo15672d().isCanUsePhoneState();
        JSONObject jSONObject = new JSONObject();
        int i = 1;
        try {
            jSONObject.put("access_fine_location", isCanUseLocation ? 1 : 0);
            jSONObject.put("applist", alist ? 1 : 0);
            jSONObject.put("external_storage", isCanUseWriteExternal ? 1 : 0);
            jSONObject.put("wifi_state", isCanUseWifiState ? 1 : 0);
            String str = "phone_state";
            if (!isCanUsePhoneState) {
                i = 0;
            }
            jSONObject.put(str, i);
        } catch (Throwable unused) {
        }
        InternalContainer.m10071j().mo16617a(LogStatsBase.m11308b().mo16591a("sdk_permission").mo16593b(jSONObject.toString()), false);
    }

    /* renamed from: b */
    public void mo16570b(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("outer_call");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16617a(dVar, true);
        }
    }

    /* renamed from: c */
    public void mo16571c(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("outer_call_send");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16617a(dVar, true);
        }
    }

    /* renamed from: d */
    public void mo16572d(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("outer_call_no_rsp");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16617a(dVar, true);
        }
    }

    /* renamed from: e */
    public void mo16573e(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("load_ad_duration_no_ad");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16616a(dVar);
        }
    }

    /* renamed from: f */
    public void mo16574f(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("load_creative_error");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16617a(dVar, true);
        }
    }

    /* renamed from: g */
    public void mo16575g(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("load_timeout");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16617a(dVar, true);
        }
    }

    /* renamed from: h */
    public void mo16576h(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("express_ad_render");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16616a(dVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m11282a(String str, int i) {
        AdPreference a = AdPreference.m9212a(InternalContainer.m10059a());
        boolean z = false;
        int b = a.mo15325b(str, 0);
        if ((b & 2) == 0 || (b & 1) != i) {
            z = true;
        }
        if (z) {
            a.mo15320a(str, i + 2);
        }
        return z;
    }

    /* renamed from: i */
    public void mo16577i(final LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            TTExecutor.m11692a().mo16809d(new Runnable() {
                public void run() {
                    if (!StatsLogManager.this.m11284o(dVar) && StatsLogManager.this.m11282a(dVar.mo16600e(), 1)) {
                        dVar.mo16591a("reg_creative");
                        InternalContainer.m10071j().mo16616a(dVar);
                    }
                }
            }, 5);
        }
    }

    /* renamed from: j */
    public void mo16578j(final LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            TTExecutor.m11692a().mo16809d(new Runnable() {
                public void run() {
                    if (!StatsLogManager.this.m11284o(dVar) && StatsLogManager.this.m11282a(dVar.mo16600e(), 0)) {
                        dVar.mo16591a("no_reg_creative");
                        InternalContainer.m10071j().mo16616a(dVar);
                    }
                }
            }, 5);
        }
    }

    /* renamed from: k */
    public void mo16579k(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("load_icon_error");
            InternalContainer.m10071j().mo16616a(dVar);
        }
    }

    /* renamed from: l */
    public void mo16580l(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("show_backup_endcard");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16616a(dVar);
        }
    }

    /* renamed from: m */
    public void mo16581m(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            InternalContainer.m10071j().mo16616a(dVar);
        }
    }

    /* renamed from: n */
    public void mo16582n(LogStatsBase dVar) {
        if (!m11284o(dVar)) {
            dVar.mo16591a("splash_creative_check");
            dVar.mo16594c(System.currentTimeMillis() / 1000);
            InternalContainer.m10071j().mo16617a(dVar, true);
        }
    }

    /* renamed from: a */
    public void mo16568a(boolean z, String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("if_sd", z ? 1 : 0);
            if (strArr != null && strArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                        sb.append(StorageInterface.KEY_SPLITER);
                    }
                }
                jSONObject.put("permission", sb.toString());
            }
        } catch (Throwable unused) {
        }
        InternalContainer.m10071j().mo16616a(LogStatsBase.m11308b().mo16591a("download_permission").mo16594c(System.currentTimeMillis() / 1000).mo16593b(jSONObject.toString()));
    }

    /* renamed from: a */
    public void mo16567a(final List<BackHtmlModel> list, final MaterialMeta kVar, final JSONObject jSONObject) {
        if (list != null && list.size() != 0 && kVar != null) {
            TTExecutor.m11692a().mo16809d(new Runnable() {
                public void run() {
                    if (!InternalContainer.m10069h().mo15817v() || C2566w.m12244c(InternalContainer.m10059a()) == 4) {
                        InternalContainer.m10067f().mo15921a(StatsLogManager.this.m11283b(list, kVar, jSONObject), 1);
                    }
                }
            }, 5);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public JSONObject m11283b(List<BackHtmlModel> list, MaterialMeta kVar, JSONObject jSONObject) {
        String str = "extra_info";
        if (list == null || list.size() == 0 || kVar == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("log_extra", kVar.mo15428P());
            jSONObject3.put("network_type", C2566w.m12244c(InternalContainer.m10059a()));
            jSONObject3.put(C7881a.TIMESTAMP, System.currentTimeMillis() / 1000);
            jSONObject3.put("cid", kVar.mo15425M());
            jSONObject3.put(TinkerUtils.PLATFORM, "Android");
            jSONObject3.put("app", GlobalInfo.m9616c().mo15676f());
            jSONObject3.put("device_id", IdUtils.m9858a(InternalContainer.m10059a()));
            AdLocation a = AdLocationUtils.m12114a(InternalContainer.m10059a());
            JSONObject jSONObject4 = new JSONObject();
            if (a != null) {
                jSONObject4.put("longitude", (double) a.f9147b);
                jSONObject4.put("latitude", (double) a.f9146a);
            }
            jSONObject3.put("location", jSONObject4);
            JSONArray jSONArray = new JSONArray();
            for (BackHtmlModel cVar : list) {
                if (cVar != null) {
                    jSONArray.put(cVar.mo15354a());
                }
            }
            jSONObject3.put("pages", jSONArray);
            if (jSONObject != null) {
                jSONObject3.put(str, jSONObject);
                StringBuilder sb = new StringBuilder();
                sb.append("back extra info:");
                sb.append(jSONObject.toString());
                C2564t.m12220b(str, sb.toString());
            }
            String a2 = AES.m9051a(ToolUtils.m12037i(jSONObject3.toString()), AESKey.m9088c());
            jSONObject2.put(MessageKey.MSG_CONTENT, a2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("html content:");
            sb2.append(a2);
            C2564t.m12226e("StatsLogManager", sb2.toString());
        } catch (Exception unused) {
        }
        return jSONObject2;
    }
}
