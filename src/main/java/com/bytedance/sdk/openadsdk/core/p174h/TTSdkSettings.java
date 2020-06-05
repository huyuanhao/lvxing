package com.bytedance.sdk.openadsdk.core.p174h;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.TmplDiffModel;
import com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic;
import com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper;
import com.bytedance.sdk.openadsdk.utils.C2566w;
import com.bytedance.sdk.openadsdk.utils.SPUtils;
import com.kwad.sdk.core.response.model.AdConfigData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.l */
public class TTSdkSettings implements ISettings {
    /* renamed from: A */
    private int f7653A = 1;
    /* renamed from: B */
    private String f7654B;
    /* renamed from: C */
    private String f7655C;
    /* renamed from: D */
    private int f7656D = 1;
    /* renamed from: E */
    private int f7657E = 5;
    /* renamed from: F */
    private String f7658F;
    /* renamed from: G */
    private String f7659G;
    /* renamed from: H */
    private int f7660H;
    /* renamed from: I */
    private int f7661I;
    /* renamed from: J */
    private int f7662J = 0;
    /* renamed from: K */
    private long f7663K = 0;
    /* renamed from: L */
    private Set<String> f7664L = Collections.synchronizedSet(new HashSet());
    /* renamed from: M */
    private Set<String> f7665M = Collections.synchronizedSet(new HashSet());
    /* renamed from: N */
    private int f7666N = 0;
    /* renamed from: O */
    private int f7667O = 1;
    /* renamed from: P */
    private long f7668P = 10000;
    /* renamed from: Q */
    private int f7669Q = 50;
    /* renamed from: R */
    private int f7670R = 30;
    /* renamed from: S */
    private int f7671S = 5;
    /* renamed from: T */
    private int f7672T = AdConfigData.DEFAULT_REQUEST_INTERVAL;
    /* renamed from: U */
    private String f7673U = "pangolin.snssdk.com";
    /* renamed from: V */
    private String f7674V = "extlog.snssdk.com/service/2/app_log/";
    /* renamed from: W */
    private int f7675W = 100;
    /* renamed from: X */
    private int f7676X = PathInterpolatorCompat.MAX_NUM_POINTS;
    /* renamed from: a */
    private int f7677a = 0;
    /* renamed from: b */
    private int f7678b = 0;
    /* renamed from: c */
    private int f7679c = 1023409663;
    /* renamed from: d */
    private Map<String, AdSlotSetter> f7680d = new HashMap();
    /* renamed from: e */
    private Map<String, TplInfo> f7681e = new HashMap();
    /* renamed from: f */
    private String f7682f;
    /* renamed from: g */
    private Set<String> f7683g = new HashSet();
    /* renamed from: h */
    private String f7684h;
    /* renamed from: i */
    private Set<String> f7685i = Collections.synchronizedSet(new HashSet());
    /* renamed from: j */
    private List<ProcessPushModel> f7686j = new CopyOnWriteArrayList();
    /* renamed from: k */
    private String f7687k;
    /* renamed from: l */
    private int f7688l = 1;
    /* renamed from: m */
    private int f7689m = 0;
    /* renamed from: n */
    private int f7690n = 1;
    /* renamed from: o */
    private String f7691o = "com.oppo.market";
    /* renamed from: p */
    private int f7692p = 0;
    /* renamed from: q */
    private String f7693q = "com.huawei.appmarket";
    /* renamed from: r */
    private int f7694r = 1;
    /* renamed from: s */
    private int f7695s = 30;
    /* renamed from: t */
    private int f7696t = 1;
    /* renamed from: u */
    private int f7697u = 30;
    /* renamed from: v */
    private int f7698v = 10;
    /* renamed from: w */
    private int f7699w = 1;
    /* renamed from: x */
    private int f7700x = 0;
    /* renamed from: y */
    private int f7701y = 5;
    /* renamed from: z */
    private int f7702z = 2;

    /* renamed from: a */
    private int m9772a(boolean z) {
        return z ? 20 : 5;
    }

    /* renamed from: a */
    public void mo15741a() {
        String str = "max";
        String str2 = "duration";
        String str3 = "";
        String str4 = "xpath";
        String str5 = "extlog.snssdk.com/service/2/app_log/";
        String str6 = "url_alog";
        String str7 = "pangolin.snssdk.com";
        String str8 = "url_ads";
        int i = 0;
        if (MultiGlobalInfo.m11808b()) {
            String str9 = "tt_sdk_settings";
            this.f7673U = SPMultiHelper.m11880b(str9, str8, str7);
            this.f7674V = SPMultiHelper.m11880b(str9, str6, str5);
            this.f7687k = SPMultiHelper.m11880b(str9, str4, str3);
            this.f7668P = SPMultiHelper.m11866a(str9, str2, 10000);
            this.f7669Q = SPMultiHelper.m11865a(str9, str, 50);
            this.f7688l = SPMultiHelper.m11865a(str9, "download_config_back_dialog", 1);
            this.f7689m = SPMultiHelper.m11865a(str9, "download_config_progressbar", 0);
            this.f7690n = SPMultiHelper.m11865a(str9, "download_config_hook", 1);
            this.f7691o = SPMultiHelper.m11880b(str9, "download_config_hook_oppo_arg1", "com.oppo.market");
            this.f7692p = SPMultiHelper.m11865a(str9, "download_config_hook_oppo_arg4", 0);
            this.f7693q = SPMultiHelper.m11880b(str9, "download_config_hook_huawei_arg1", "com.huawei.appmarket");
            this.f7694r = SPMultiHelper.m11865a(str9, "download_config_dl_network", 1);
            this.f7695s = SPMultiHelper.m11865a(str9, "download_config_dl_size", 30);
            this.f7696t = SPMultiHelper.m11865a(str9, "download_config_enable_install_again", 1);
            this.f7697u = SPMultiHelper.m11865a(str9, "download_config_install_again_time", 30);
            this.f7698v = SPMultiHelper.m11865a(str9, "download_config_install_again_time_next", 10);
            this.f7699w = SPMultiHelper.m11865a(str9, "download_config_storage_internal", 1);
            this.f7700x = SPMultiHelper.m11865a(str9, "download_config_resume_notify_switch", 0);
            this.f7701y = SPMultiHelper.m11865a(str9, "download_config_resume_notify_time", 5);
            this.f7702z = SPMultiHelper.m11865a(str9, "download_config_resume_notify_count", 2);
            this.f7653A = SPMultiHelper.m11865a(str9, "download_config_if_open_market_window", 1);
            this.f7670R = SPMultiHelper.m11865a(str9, "pos_cache_time", 30);
            this.f7671S = SPMultiHelper.m11865a(str9, "vbtt", 5);
            this.f7672T = SPMultiHelper.m11865a(str9, "fetch_template", (int) AdConfigData.DEFAULT_REQUEST_INTERVAL);
            this.f7684h = SPMultiHelper.m11880b(str9, "template_ids", (String) null);
            this.f7654B = SPMultiHelper.m11880b(str9, "ab_test_version", (String) null);
            this.f7655C = SPMultiHelper.m11880b(str9, "ab_test_param", (String) null);
            this.f7656D = SPMultiHelper.m11865a(str9, "web_info_wifi_enable", 1);
            this.f7657E = SPMultiHelper.m11865a(str9, "web_info_page_count", 5);
            this.f7658F = SPMultiHelper.m11880b(str9, "pyload_h5", (String) null);
            this.f7659G = SPMultiHelper.m11880b(str9, "playableLoadH5Url", (String) null);
            this.f7660H = SPMultiHelper.m11865a(str9, "splash_load_type", 1);
            this.f7661I = SPMultiHelper.m11865a(str9, "splash_check_type", 1);
            this.f7666N = SPMultiHelper.m11865a(str9, "if_both_open", 0);
            this.f7667O = SPMultiHelper.m11865a(str9, "support_tnc", 1);
            this.f7682f = SPMultiHelper.m11880b(str9, "tpl_infos", (String) null);
            this.f7662J = SPMultiHelper.m11865a(str9, "app_list_control", 0);
            this.f7675W = SPMultiHelper.m11865a(str9, "max_tpl_cnts", 100);
            m9769V();
            this.f7676X = SPMultiHelper.m11865a(str9, "fetch_tpl_timeout_ctrl", (int) PathInterpolatorCompat.MAX_NUM_POINTS);
            this.f7663K = SPMultiHelper.m11866a(str9, "hit_app_list_time", 0);
            this.f7664L.clear();
            this.f7677a = SPMultiHelper.m11865a(str9, "sp_ov_skip_key", 0);
            this.f7678b = SPMultiHelper.m11865a(str9, "download_xiaomi_silence_install", 0);
            this.f7679c = SPMultiHelper.m11865a(str9, "download_exp_switch_temp", 1023409663);
            Set<String> b = SPMultiHelper.m11881b(str9, "hit_app_list_data", null);
            if (b != null && !b.isEmpty()) {
                for (String add : b) {
                    this.f7664L.add(add);
                }
            }
            this.f7665M.clear();
            Set<String> b2 = SPMultiHelper.m11881b(str9, "scheme_list_data", null);
            if (b2 != null && !b2.isEmpty()) {
                for (String add2 : b2) {
                    this.f7665M.add(add2);
                }
            }
            m9779t(SPMultiHelper.m11880b(str9, "push_config", (String) null));
            m9768U();
            m9770W();
            String b3 = SPMultiHelper.m11880b(str9, "ad_slot_conf", (String) null);
            if (!TextUtils.isEmpty(b3)) {
                try {
                    JSONArray jSONArray = new JSONArray(b3);
                    int length = jSONArray.length();
                    if (length > 0) {
                        this.f7680d.clear();
                        while (i < length) {
                            AdSlotSetter b4 = m9775b(jSONArray.optJSONObject(i));
                            if (b4 != null) {
                                this.f7680d.put(b4.f7585a, b4);
                            }
                            i++;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            LibHolder.m11232c();
            return;
        }
        SPUtils X = m9771X();
        this.f7673U = X.mo16915b(str8, str7);
        this.f7674V = X.mo16915b(str6, str5);
        this.f7687k = X.mo16915b(str4, str3);
        this.f7668P = X.mo16914b(str2, 10000);
        this.f7669Q = X.mo16913b(str, 50);
        this.f7688l = X.mo16913b("download_config_back_dialog", 1);
        this.f7689m = X.mo16913b("download_config_progressbar", 0);
        this.f7690n = X.mo16913b("download_config_hook", 1);
        this.f7691o = X.mo16915b("download_config_hook_oppo_arg1", "com.oppo.market");
        this.f7692p = X.mo16913b("download_config_hook_oppo_arg4", 0);
        this.f7693q = X.mo16915b("download_config_hook_huawei_arg1", "com.huawei.appmarket");
        this.f7694r = X.mo16913b("download_config_dl_network", 1);
        this.f7695s = X.mo16913b("download_config_dl_size", 30);
        this.f7696t = X.mo16913b("download_config_enable_install_again", 1);
        this.f7697u = X.mo16913b("download_config_install_again_time", 30);
        this.f7698v = X.mo16913b("download_config_install_again_time_next", 10);
        this.f7699w = X.mo16913b("download_config_storage_internal", 1);
        this.f7700x = X.mo16913b("download_config_resume_notify_switch", 0);
        this.f7702z = X.mo16913b("download_config_resume_notify_count", 2);
        this.f7653A = X.mo16913b("download_config_if_open_market_window", 1);
        this.f7701y = X.mo16913b("download_config_resume_notify_time", 5);
        this.f7670R = X.mo16913b("pos_cache_time", 30);
        this.f7672T = X.mo16913b("fetch_template", (int) AdConfigData.DEFAULT_REQUEST_INTERVAL);
        this.f7654B = X.mo16908a("ab_test_version");
        this.f7655C = X.mo16908a("ab_test_param");
        this.f7671S = X.mo16913b("vbtt", 5);
        this.f7684h = X.mo16915b("template_ids", (String) null);
        this.f7656D = X.mo16913b("web_info_wifi_enable", 1);
        this.f7657E = X.mo16913b("web_info_page_count", 5);
        this.f7658F = X.mo16915b("pyload_h5", (String) null);
        this.f7659G = X.mo16915b("playableLoadH5Url", (String) null);
        this.f7660H = X.mo16913b("splash_load_type", 1);
        this.f7661I = X.mo16913b("splash_check_type", 1);
        this.f7666N = X.mo16913b("if_both_open", 0);
        this.f7667O = X.mo16913b("support_tnc", 1);
        this.f7682f = X.mo16915b("tpl_infos", (String) null);
        this.f7662J = X.mo16913b("app_list_control", 0);
        this.f7675W = X.mo16913b("max_tpl_cnts", 100);
        m9769V();
        this.f7676X = X.mo16913b("fetch_tpl_timeout_ctrl", (int) PathInterpolatorCompat.MAX_NUM_POINTS);
        this.f7663K = X.mo16914b("hit_app_list_time", 0);
        this.f7664L.clear();
        this.f7677a = X.mo16913b("sp_ov_skip_key", 0);
        this.f7678b = X.mo16913b("download_xiaomi_silence_install", 0);
        this.f7679c = X.mo16913b("download_exp_switch_temp", 1023409663);
        Set<String> b5 = X.mo16916b("hit_app_list_data", null);
        if (b5 != null && !b5.isEmpty()) {
            for (String add3 : b5) {
                this.f7664L.add(add3);
            }
        }
        this.f7665M.clear();
        Set<String> b6 = X.mo16916b("scheme_list_data", null);
        if (b6 != null && !b6.isEmpty()) {
            for (String add4 : b6) {
                this.f7665M.add(add4);
            }
        }
        m9779t(X.mo16915b("push_config", (String) null));
        m9768U();
        m9770W();
        String b7 = X.mo16915b("ad_slot_conf", (String) null);
        if (!TextUtils.isEmpty(b7)) {
            try {
                JSONArray jSONArray2 = new JSONArray(b7);
                int length2 = jSONArray2.length();
                if (length2 > 0) {
                    this.f7680d.clear();
                    while (i < length2) {
                        AdSlotSetter b8 = m9775b(jSONArray2.optJSONObject(i));
                        if (b8 != null) {
                            this.f7680d.put(b8.f7585a, b8);
                        }
                        i++;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        LibHolder.m11232c();
    }

    /* renamed from: t */
    private void m9779t(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    ProcessPushModel gVar = new ProcessPushModel();
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    gVar.f7631a = optJSONObject.optString("action");
                    gVar.f7632b = optJSONObject.optString(NotificationCompat.CATEGORY_SERVICE);
                    gVar.f7633c = optJSONObject.optString("package");
                    gVar.f7634d = optJSONObject.optInt("wakeup_interval");
                    this.f7686j.add(gVar);
                }
                ProcessPushHelper.m9725a().mo15744b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private static AdSlotSetter m9775b(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            return null;
        }
        String optString = jSONObject2.optString("code_id");
        int optInt = jSONObject2.optInt("auto_play", 1);
        String str = "voice_control";
        int optInt2 = jSONObject2.optInt(str, 1);
        int optInt3 = jSONObject2.optInt("rv_preload", 2);
        int optInt4 = jSONObject2.optInt("nv_preload", 1);
        int optInt5 = jSONObject2.optInt("read_video_from_cache", 1);
        int optInt6 = jSONObject2.optInt("proportion_watching", 100);
        int optInt7 = jSONObject2.optInt("skip_time_displayed", 0);
        int optInt8 = jSONObject2.optInt("video_skip_result", 2);
        int optInt9 = jSONObject2.optInt("reg_creative_control", 1);
        int optInt10 = jSONObject2.optInt("play_bar_show_time", 3);
        int optInt11 = jSONObject2.optInt("rv_skip_time", -1);
        int optInt12 = jSONObject2.optInt("endcard_close_time", -1);
        int optInt13 = jSONObject2.optInt("playable_endcard_close_time", -1);
        int optInt14 = jSONObject2.optInt(str, 2);
        int i = optInt13;
        int optInt15 = jSONObject2.optInt("if_show_win", 1);
        int optInt16 = jSONObject2.optInt("sp_preload", 0);
        int optInt17 = jSONObject2.optInt("stop_time", 1500);
        int optInt18 = jSONObject2.optInt("native_playable_delay", 2);
        int optInt19 = jSONObject2.optInt("time_out_control", -1);
        int optInt20 = jSONObject2.optInt("playable_duration_time", 20);
        int optInt21 = jSONObject2.optInt("playable_close_time", -1);
        int optInt22 = jSONObject2.optInt("playable_reward_type", 0);
        int optInt23 = jSONObject2.optInt("reward_is_callback", 0);
        return AdSlotSetter.m9658a().mo15691a(optString).mo15705n(optInt).mo15706o(optInt2).mo15707p(optInt3).mo15708q(optInt4).mo15709r(optInt5).mo15710s(optInt6).mo15711t(optInt7).mo15712u(optInt8).mo15713v(optInt9).mo15704m(optInt10).mo15703l(optInt11).mo15701j(optInt12).mo15700i(optInt14).mo15702k(i).mo15714w(optInt15).mo15697f(optInt16).mo15698g(optInt17).mo15699h(optInt18).mo15696e(optInt19).mo15690a(optInt21).mo15695d(optInt20).mo15693b(optInt22).mo15694c(optInt23).mo15692a(jSONObject2.optJSONArray("parent_tpl_ids"));
    }

    /* renamed from: c */
    private static TplInfo m9776c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String str = "";
        String optString = jSONObject.optString("tpl_id", str);
        String optString2 = jSONObject.optString("md5", str);
        return TplInfo.m9852a().mo15822a(optString).mo15823b(optString2).mo15824c(jSONObject.optString("url", str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x02cd  */
    /* renamed from: a */
    public void mo15742a(org.json.JSONObject r11) {
        /*
        r10 = this;
        java.lang.String r0 = "app_common_config"
        org.json.JSONObject r1 = r11.optJSONObject(r0)
        r2 = 0
        r3 = 1
        if (r1 == 0) goto L_0x002d
        java.lang.String r4 = "if_open_market_window"
        int r4 = r1.optInt(r4, r3)
        r10.f7653A = r4
        java.lang.String r4 = "skip_key"
        int r4 = r1.optInt(r4, r2)
        r10.f7677a = r4
        java.lang.String r4 = "xiaomi_install"
        int r4 = r1.optInt(r4, r2)
        r10.f7678b = r4
        r4 = 1023409663(0x3cfffdff, float:0.031249044)
        java.lang.String r5 = "download_exp_switch_temp"
        int r1 = r1.optInt(r5, r4)
        r10.f7679c = r1
    L_0x002d:
        java.lang.String r1 = "ads_url"
        java.lang.String r4 = "pangolin.snssdk.com"
        java.lang.String r1 = r11.optString(r1, r4)
        r10.f7673U = r1
        java.lang.String r1 = "app_log_url"
        java.lang.String r4 = "extlog.snssdk.com/service/2/app_log/"
        java.lang.String r1 = r11.optString(r1, r4)
        r10.f7674V = r1
        java.lang.String r1 = "xpath"
        java.lang.String r1 = r11.optString(r1)
        r10.f7687k = r1
        r1 = 30
        java.lang.String r4 = "pos_cache_time"
        int r4 = r11.optInt(r4, r1)
        r10.f7670R = r4
        java.lang.String r4 = "feq_policy"
        org.json.JSONObject r4 = r11.optJSONObject(r4)
        if (r4 == 0) goto L_0x006f
        java.lang.String r5 = "duration"
        long r5 = r4.optLong(r5)
        r7 = 1000(0x3e8, double:4.94E-321)
        long r5 = r5 * r7
        r10.f7668P = r5
        java.lang.String r5 = "max"
        int r4 = r4.optInt(r5)
        r10.f7669Q = r4
    L_0x006f:
        r4 = 5
        java.lang.String r5 = "vbtt"
        int r5 = r11.optInt(r5, r4)
        r10.f7671S = r5
        r5 = 3600(0xe10, float:5.045E-42)
        java.lang.String r6 = "fetch_tpl_interval"
        int r5 = r11.optInt(r6, r5)
        r10.f7672T = r5
        com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic.m10869c()
        java.lang.String r5 = "abtest"
        org.json.JSONObject r5 = r11.optJSONObject(r5)
        r6 = 0
        if (r5 == 0) goto L_0x009f
        java.lang.String r7 = "version"
        java.lang.String r7 = r5.optString(r7)
        r10.f7654B = r7
        java.lang.String r7 = "param"
        java.lang.String r5 = r5.optString(r7)
        r10.f7655C = r5
        goto L_0x00c0
    L_0x009f:
        r10.f7655C = r6
        r10.f7654B = r6
        boolean r5 = com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo.m11808b()
        java.lang.String r7 = "ab_test_param"
        java.lang.String r8 = "ab_test_version"
        if (r5 == 0) goto L_0x00b6
        java.lang.String r5 = "tt_sdk_settings"
        com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper.m11869a(r5, r8)
        com.bytedance.sdk.openadsdk.multipro.p205d.SPMultiHelper.m11869a(r5, r7)
        goto L_0x00c0
    L_0x00b6:
        com.bytedance.sdk.openadsdk.utils.ad r5 = r10.m9771X()
        r5.mo16917b(r8)
        r5.mo16917b(r7)
    L_0x00c0:
        java.lang.String r5 = "web_info"
        org.json.JSONObject r5 = r11.optJSONObject(r5)
        if (r5 == 0) goto L_0x00d8
        java.lang.String r7 = "web_info_wifi_enable"
        int r7 = r5.optInt(r7, r3)
        r10.f7656D = r7
        java.lang.String r7 = "web_info_page_count"
        int r5 = r5.optInt(r7, r4)
        r10.f7657E = r5
    L_0x00d8:
        java.lang.String r5 = "pyload_h5"
        java.lang.String r5 = r11.optString(r5)
        r10.f7658F = r5
        java.lang.String r5 = "pure_pyload_h5"
        java.lang.String r5 = r11.optString(r5)
        r10.f7659G = r5
        int r5 = r10.m9777d(r11)
        r10.f7660H = r5
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r7 = "setting-》mSplashLoadType="
        r5.append(r7)
        int r7 = r10.f7660H
        r5.append(r7)
        java.lang.String r5 = r5.toString()
        java.lang.String r7 = "splashLoad"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r7, r5)
        int r5 = r10.m9778e(r11)
        r10.f7661I = r5
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r8 = "setting-》mSplashCheckType="
        r5.append(r8)
        int r8 = r10.f7661I
        r5.append(r8)
        java.lang.String r5 = r5.toString()
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r7, r5)
        java.lang.String r5 = "if_both_open"
        int r5 = r11.optInt(r5, r2)
        r10.f7666N = r5
        java.lang.String r5 = "support_tnc"
        int r5 = r11.optInt(r5, r3)
        r10.f7667O = r5
        java.lang.String r5 = "al"
        int r5 = r11.optInt(r5, r2)
        r10.f7662J = r5
        r5 = 100
        java.lang.String r7 = "max_tpl_cnts"
        int r5 = r11.optInt(r7, r5)
        r10.f7675W = r5
        r10.m9769V()
        org.json.JSONObject r0 = r11.optJSONObject(r0)
        if (r0 == 0) goto L_0x0157
        r5 = 3000(0xbb8, float:4.204E-42)
        java.lang.String r7 = "fetch_tpl_timeout_ctrl"
        int r0 = r0.optInt(r7, r5)
        r10.f7676X = r0
    L_0x0157:
        long r7 = java.lang.System.currentTimeMillis()
        r10.f7663K = r7
        java.util.Set<java.lang.String> r0 = r10.f7664L
        r0.clear()
        java.lang.String r0 = "spam_app_list"
        org.json.JSONArray r0 = r11.optJSONArray(r0)
        if (r0 == 0) goto L_0x0183
        int r5 = r0.length()
        r7 = 0
    L_0x016f:
        if (r7 >= r5) goto L_0x0183
        java.lang.String r8 = r0.optString(r7)
        boolean r9 = android.text.TextUtils.isEmpty(r8)
        if (r9 != 0) goto L_0x0180
        java.util.Set<java.lang.String> r9 = r10.f7664L
        r9.add(r8)
    L_0x0180:
        int r7 = r7 + 1
        goto L_0x016f
    L_0x0183:
        java.util.Set<java.lang.String> r0 = r10.f7665M
        r0.clear()
        java.lang.String r0 = "scheme_check_list"
        org.json.JSONArray r0 = r11.optJSONArray(r0)
        if (r0 == 0) goto L_0x01a9
        int r5 = r0.length()
        r7 = 0
    L_0x0195:
        if (r7 >= r5) goto L_0x01a9
        java.lang.String r8 = r0.optString(r7)
        boolean r9 = android.text.TextUtils.isEmpty(r8)
        if (r9 != 0) goto L_0x01a6
        java.util.Set<java.lang.String> r9 = r10.f7665M
        r9.add(r8)
    L_0x01a6:
        int r7 = r7 + 1
        goto L_0x0195
    L_0x01a9:
        java.lang.String r0 = "download_config"
        org.json.JSONObject r0 = r11.optJSONObject(r0)
        if (r0 == 0) goto L_0x0230
        java.lang.String r5 = "is_enable_back_dialog"
        int r5 = r0.optInt(r5, r3)
        r10.f7688l = r5
        java.lang.String r5 = "landing_page_progressbar_visible"
        int r5 = r0.optInt(r5, r2)
        r10.f7689m = r5
        java.lang.String r5 = "hook"
        int r5 = r0.optInt(r5, r3)
        r10.f7690n = r5
        java.lang.String r5 = "hook_oppo_arg1"
        java.lang.String r7 = "com.oppo.market"
        java.lang.String r5 = r0.optString(r5, r7)
        r10.f7691o = r5
        java.lang.String r5 = "hook_oppo_arg4"
        int r5 = r0.optInt(r5, r2)
        r10.f7692p = r5
        java.lang.String r5 = "hook_huawei_arg1"
        java.lang.String r7 = "com.huawei.appmarket"
        java.lang.String r5 = r0.optString(r5, r7)
        r10.f7693q = r5
        java.lang.String r5 = "dl_network"
        int r5 = r0.optInt(r5, r3)
        r10.f7694r = r5
        java.lang.String r5 = "dl_size"
        int r5 = r0.optInt(r5, r1)
        r10.f7695s = r5
        java.lang.String r5 = "is_enable_start_install_again"
        int r5 = r0.optInt(r5, r3)
        r10.f7696t = r5
        java.lang.String r5 = "start_install_time"
        int r1 = r0.optInt(r5, r1)
        r10.f7697u = r1
        r1 = 10
        java.lang.String r5 = "next_install_min_time"
        int r1 = r0.optInt(r5, r1)
        r10.f7698v = r1
        java.lang.String r1 = "if_storage_internal"
        int r1 = r0.optInt(r1, r3)
        r10.f7699w = r1
        java.lang.String r1 = "if_tips"
        int r1 = r0.optInt(r1, r2)
        r10.f7700x = r1
        java.lang.String r1 = "min_failed_time"
        int r1 = r0.optInt(r1, r4)
        r10.f7701y = r1
        r1 = 2
        java.lang.String r3 = "max_failes_count"
        int r0 = r0.optInt(r3, r1)
        r10.f7702z = r0
    L_0x0230:
        java.lang.String r0 = "tpl_ids"
        org.json.JSONArray r0 = r11.optJSONArray(r0)
        if (r0 == 0) goto L_0x0241
        java.lang.String r0 = r0.toString()
        r10.f7684h = r0
        r10.m9768U()
    L_0x0241:
        java.lang.String r0 = "push_config"
        org.json.JSONArray r0 = r11.optJSONArray(r0)     // Catch:{ all -> 0x0292 }
        if (r0 == 0) goto L_0x0287
        java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x0292 }
        int r3 = r0.length()     // Catch:{ all -> 0x0290 }
        r4 = 0
    L_0x0252:
        if (r4 >= r3) goto L_0x0288
        com.bytedance.sdk.openadsdk.core.h.g r5 = new com.bytedance.sdk.openadsdk.core.h.g     // Catch:{ all -> 0x0290 }
        r5.m43729init()     // Catch:{ all -> 0x0290 }
        org.json.JSONObject r7 = r0.optJSONObject(r4)     // Catch:{ all -> 0x0290 }
        if (r7 == 0) goto L_0x0284
        java.lang.String r8 = "action"
        java.lang.String r8 = r7.optString(r8)     // Catch:{ all -> 0x0290 }
        r5.f7631a = r8     // Catch:{ all -> 0x0290 }
        java.lang.String r8 = "service"
        java.lang.String r8 = r7.optString(r8)     // Catch:{ all -> 0x0290 }
        r5.f7632b = r8     // Catch:{ all -> 0x0290 }
        java.lang.String r8 = "package"
        java.lang.String r8 = r7.optString(r8)     // Catch:{ all -> 0x0290 }
        r5.f7633c = r8     // Catch:{ all -> 0x0290 }
        java.lang.String r8 = "wakeup_interval"
        int r7 = r7.optInt(r8)     // Catch:{ all -> 0x0290 }
        r5.f7634d = r7     // Catch:{ all -> 0x0290 }
        java.util.List<com.bytedance.sdk.openadsdk.core.h.g> r7 = r10.f7686j     // Catch:{ all -> 0x0290 }
        r7.add(r5)     // Catch:{ all -> 0x0290 }
    L_0x0284:
        int r4 = r4 + 1
        goto L_0x0252
    L_0x0287:
        r1 = r6
    L_0x0288:
        com.bytedance.sdk.openadsdk.core.h.f r0 = com.bytedance.sdk.openadsdk.core.p174h.ProcessPushHelper.m9725a()     // Catch:{ all -> 0x0290 }
        r0.mo15744b()     // Catch:{ all -> 0x0290 }
        goto L_0x0297
    L_0x0290:
        r0 = move-exception
        goto L_0x0294
    L_0x0292:
        r0 = move-exception
        r1 = r6
    L_0x0294:
        r0.printStackTrace()
    L_0x0297:
        java.lang.String r0 = "ad_slot_conf_list"
        org.json.JSONArray r0 = r11.optJSONArray(r0)
        if (r0 == 0) goto L_0x02c5
        java.lang.String r6 = r0.toString()
        int r3 = r0.length()
        if (r3 <= 0) goto L_0x02c5
        java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.core.h.a> r4 = r10.f7680d
        r4.clear()
        r4 = 0
    L_0x02af:
        if (r4 >= r3) goto L_0x02c5
        org.json.JSONObject r5 = r0.optJSONObject(r4)
        com.bytedance.sdk.openadsdk.core.h.a r5 = m9775b(r5)
        if (r5 == 0) goto L_0x02c2
        java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.core.h.a> r7 = r10.f7680d
        java.lang.String r8 = r5.f7585a
        r7.put(r8, r5)
    L_0x02c2:
        int r4 = r4 + 1
        goto L_0x02af
    L_0x02c5:
        java.lang.String r0 = "tpl_infos"
        org.json.JSONArray r11 = r11.optJSONArray(r0)
        if (r11 == 0) goto L_0x02f7
        java.lang.String r0 = r11.toString()
        r10.f7682f = r0
        int r0 = r11.length()
        if (r0 <= 0) goto L_0x02f7
        java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.core.h.m> r3 = r10.f7681e
        r3.clear()
    L_0x02de:
        if (r2 >= r0) goto L_0x02f7
        org.json.JSONObject r3 = r11.optJSONObject(r2)
        com.bytedance.sdk.openadsdk.core.h.m r3 = m9776c(r3)
        if (r3 == 0) goto L_0x02f4
        java.util.Map<java.lang.String, com.bytedance.sdk.openadsdk.core.h.m> r4 = r10.f7681e
        java.lang.String r5 = r3.f7703a
        r4.put(r5, r3)
        r10.m9773a(r3)
    L_0x02f4:
        int r2 = r2 + 1
        goto L_0x02de
    L_0x02f7:
        com.bytedance.sdk.openadsdk.downloadnew.p181a.LibHolder.m11232c()
        r10.m9774a(r6, r1)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings.mo15742a(org.json.JSONObject):void");
    }

    /* renamed from: d */
    private int m9777d(JSONObject jSONObject) {
        this.f7660H = jSONObject.optInt("splash_load_type", 1);
        int i = this.f7660H;
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return this.f7660H;
        }
        return 1;
    }

    /* renamed from: e */
    private int m9778e(JSONObject jSONObject) {
        this.f7661I = jSONObject.optInt("splash_check_type", 1);
        int i = this.f7661I;
        if (i == 0 || i == 1) {
            return this.f7661I;
        }
        return 1;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(2:5|(2:7|8))|9|10|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
    /* renamed from: U */
    private void m9768U() {
        /*
        r5 = this;
        java.lang.String r0 = r5.f7684h
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 != 0) goto L_0x0030
        org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x002b }
        java.lang.String r1 = r5.f7684h     // Catch:{ Exception -> 0x002b }
        r0.<init>(r1)     // Catch:{ Exception -> 0x002b }
        int r1 = r0.length()     // Catch:{ Exception -> 0x002b }
        if (r1 <= 0) goto L_0x002b
        java.util.Set<java.lang.String> r2 = r5.f7685i     // Catch:{ Exception -> 0x002b }
        r2.clear()     // Catch:{ Exception -> 0x002b }
        r2 = 0
    L_0x001b:
        if (r2 >= r1) goto L_0x002b
        java.lang.Object r3 = r0.opt(r2)     // Catch:{ Exception -> 0x002b }
        java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x002b }
        java.util.Set<java.lang.String> r4 = r5.f7685i     // Catch:{ Exception -> 0x002b }
        r4.add(r3)     // Catch:{ Exception -> 0x002b }
        int r2 = r2 + 1
        goto L_0x001b
    L_0x002b:
        java.util.Set<java.lang.String> r0 = r5.f7685i     // Catch:{ all -> 0x0030 }
        com.bytedance.sdk.openadsdk.core.widget.webview.p179a.TTDynamic.m10866a(r0)     // Catch:{ all -> 0x0030 }
    L_0x0030:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p174h.TTSdkSettings.m9768U():void");
    }

    /* renamed from: V */
    private void m9769V() {
        try {
            TTDynamic.m10871e();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: W */
    private void m9770W() {
        if (!TextUtils.isEmpty(this.f7682f)) {
            try {
                JSONArray jSONArray = new JSONArray(this.f7682f);
                int length = jSONArray.length();
                if (length > 0) {
                    this.f7681e.clear();
                    for (int i = 0; i < length; i++) {
                        TplInfo c = m9776c(jSONArray.optJSONObject(i));
                        if (c != null) {
                            this.f7681e.put(c.f7703a, c);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m9773a(TplInfo mVar) {
        TTDynamic.m10865a(mVar);
    }

    /* renamed from: a */
    private void m9774a(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        String str5 = "download_config_enable_install_again";
        String str6 = "download_config_dl_size";
        String str7 = "download_config_dl_network";
        String str8 = "download_config_hook_huawei_arg1";
        String str9 = "download_config_hook_oppo_arg4";
        String str10 = "download_config_hook_oppo_arg1";
        String str11 = "download_config_hook";
        String str12 = "download_config_progressbar";
        String str13 = "download_config_back_dialog";
        String str14 = "max";
        String str15 = "duration";
        String str16 = "xpath";
        String str17 = "url_alog";
        String str18 = "url_ads";
        if (MultiGlobalInfo.m11808b()) {
            String str19 = str5;
            String str20 = "tt_sdk_settings";
            SPMultiHelper.m11874a(str20, str18, this.f7673U);
            SPMultiHelper.m11874a(str20, str17, this.f7674V);
            SPMultiHelper.m11874a(str20, str16, this.f7687k);
            SPMultiHelper.m11873a(str20, str15, Long.valueOf(this.f7668P));
            SPMultiHelper.m11872a(str20, str14, Integer.valueOf(this.f7669Q));
            SPMultiHelper.m11872a(str20, str13, Integer.valueOf(this.f7688l));
            SPMultiHelper.m11872a(str20, str12, Integer.valueOf(this.f7689m));
            SPMultiHelper.m11872a(str20, str11, Integer.valueOf(this.f7690n));
            SPMultiHelper.m11874a(str20, str10, this.f7691o);
            SPMultiHelper.m11872a(str20, str9, Integer.valueOf(this.f7692p));
            SPMultiHelper.m11874a(str20, str8, this.f7693q);
            SPMultiHelper.m11872a(str20, str7, Integer.valueOf(this.f7694r));
            SPMultiHelper.m11872a(str20, str6, Integer.valueOf(this.f7695s));
            SPMultiHelper.m11872a(str20, str19, Integer.valueOf(this.f7696t));
            SPMultiHelper.m11872a(str20, "download_config_install_again_time", Integer.valueOf(this.f7697u));
            SPMultiHelper.m11872a(str20, "download_config_install_again_time_next", Integer.valueOf(this.f7698v));
            SPMultiHelper.m11872a(str20, "download_config_storage_internal", Integer.valueOf(this.f7699w));
            SPMultiHelper.m11872a(str20, "download_config_resume_notify_switch", Integer.valueOf(this.f7700x));
            SPMultiHelper.m11872a(str20, "download_config_resume_notify_time", Integer.valueOf(this.f7701y));
            SPMultiHelper.m11872a(str20, "download_config_resume_notify_count", Integer.valueOf(this.f7702z));
            SPMultiHelper.m11872a(str20, "download_config_if_open_market_window", Integer.valueOf(this.f7653A));
            SPMultiHelper.m11872a(str20, "pos_cache_time", Integer.valueOf(this.f7670R));
            SPMultiHelper.m11872a(str20, "vbtt", Integer.valueOf(this.f7671S));
            SPMultiHelper.m11872a(str20, "fetch_template", Integer.valueOf(this.f7672T));
            SPMultiHelper.m11872a(str20, "web_info_wifi_enable", Integer.valueOf(this.f7656D));
            SPMultiHelper.m11872a(str20, "web_info_page_count", Integer.valueOf(this.f7657E));
            SPMultiHelper.m11872a(str20, "splash_load_type", Integer.valueOf(this.f7660H));
            SPMultiHelper.m11872a(str20, "splash_check_type", Integer.valueOf(this.f7661I));
            SPMultiHelper.m11872a(str20, "if_both_open", Integer.valueOf(this.f7666N));
            SPMultiHelper.m11872a(str20, "support_tnc", Integer.valueOf(this.f7667O));
            SPMultiHelper.m11874a(str20, "pyload_h5", this.f7658F);
            SPMultiHelper.m11874a(str20, "playableLoadH5Url", this.f7659G);
            SPMultiHelper.m11872a(str20, "app_list_control", Integer.valueOf(this.f7662J));
            SPMultiHelper.m11872a(str20, "max_tpl_cnts", Integer.valueOf(this.f7675W));
            SPMultiHelper.m11872a(str20, "fetch_tpl_timeout_ctrl", Integer.valueOf(this.f7676X));
            SPMultiHelper.m11873a(str20, "hit_app_list_time", Long.valueOf(this.f7663K));
            SPMultiHelper.m11875a(str20, "hit_app_list_data", this.f7664L);
            SPMultiHelper.m11875a(str20, "scheme_list_data", this.f7665M);
            SPMultiHelper.m11872a(str20, "sp_ov_skip_key", Integer.valueOf(this.f7677a));
            SPMultiHelper.m11872a(str20, "download_xiaomi_silence_install", Integer.valueOf(this.f7678b));
            SPMultiHelper.m11872a(str20, "download_exp_switch_temp", Integer.valueOf(this.f7679c));
            if (!TextUtils.isEmpty(this.f7654B)) {
                SPMultiHelper.m11874a(str20, "ab_test_version", this.f7654B);
            }
            if (!TextUtils.isEmpty(this.f7655C)) {
                SPMultiHelper.m11874a(str20, "ab_test_param", this.f7655C);
            }
            if (!TextUtils.isEmpty(str2)) {
                SPMultiHelper.m11874a(str20, "push_config", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                SPMultiHelper.m11874a(str20, "ad_slot_conf", str);
            }
            if (!TextUtils.isEmpty(this.f7684h)) {
                SPMultiHelper.m11874a(str20, "template_ids", this.f7684h);
            }
            if (!TextUtils.isEmpty(this.f7682f)) {
                SPMultiHelper.m11874a(str20, "tpl_infos", this.f7682f);
            }
            return;
        }
        String str21 = str5;
        String str22 = str17;
        String str23 = str18;
        String str24 = str21;
        SPUtils X = m9771X();
        String str25 = str24;
        X.mo16911a(str23, this.f7673U);
        X.mo16911a(str22, this.f7674V);
        X.mo16911a(str16, this.f7687k);
        X.mo16910a(str15, this.f7668P);
        X.mo16909a(str14, this.f7669Q);
        X.mo16909a(str13, this.f7688l);
        X.mo16909a(str12, this.f7689m);
        X.mo16909a(str11, this.f7690n);
        X.mo16911a(str10, this.f7691o);
        X.mo16909a(str9, this.f7692p);
        X.mo16911a(str8, this.f7693q);
        X.mo16909a(str7, this.f7694r);
        X.mo16909a(str6, this.f7695s);
        X.mo16909a(str25, this.f7696t);
        X.mo16909a("download_config_install_again_time", this.f7697u);
        X.mo16909a("download_config_install_again_time_next", this.f7698v);
        X.mo16909a("download_config_storage_internal", this.f7699w);
        X.mo16909a("download_config_resume_notify_switch", this.f7700x);
        X.mo16909a("download_config_resume_notify_time", this.f7701y);
        X.mo16909a("download_config_resume_notify_count", this.f7702z);
        X.mo16909a("download_config_if_open_market_window", this.f7653A);
        X.mo16909a("pos_cache_time", this.f7670R);
        X.mo16909a("fetch_template", this.f7672T);
        X.mo16909a("web_info_wifi_enable", this.f7656D);
        X.mo16909a("web_info_page_count", this.f7657E);
        X.mo16911a("pyload_h5", this.f7658F);
        X.mo16911a("playableLoadH5Url", this.f7659G);
        X.mo16909a("splash_load_type", this.f7660H);
        X.mo16909a("splash_check_type", this.f7661I);
        X.mo16909a("if_both_open", this.f7666N);
        X.mo16909a("support_tnc", this.f7667O);
        X.mo16909a("app_list_control", this.f7662J);
        X.mo16909a("max_tpl_cnts", this.f7675W);
        X.mo16909a("fetch_tpl_timeout_ctrl", this.f7676X);
        X.mo16910a("hit_app_list_time", this.f7663K);
        X.mo16912a("hit_app_list_data", this.f7664L);
        X.mo16912a("scheme_list_data", this.f7665M);
        X.mo16909a("sp_ov_skip_key", this.f7677a);
        X.mo16909a("download_xiaomi_silence_install", this.f7678b);
        X.mo16909a("download_exp_switch_temp", this.f7679c);
        if (!TextUtils.isEmpty(this.f7654B)) {
            X.mo16911a("ab_test_version", this.f7654B);
        }
        if (!TextUtils.isEmpty(this.f7655C)) {
            X.mo16911a("ab_test_param", this.f7655C);
        }
        X.mo16909a("vbtt", this.f7671S);
        if (!TextUtils.isEmpty(str2)) {
            X.mo16911a("push_config", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            X.mo16911a("ad_slot_conf", str);
        }
        if (!TextUtils.isEmpty(this.f7684h)) {
            X.mo16911a("template_ids", this.f7684h);
        }
        if (!TextUtils.isEmpty(this.f7682f)) {
            X.mo16911a("tpl_infos", this.f7682f);
        }
    }

    /* renamed from: X */
    private SPUtils m9771X() {
        return SPUtils.m11969a("tt_sdk_settings", InternalContainer.m10059a());
    }

    /* renamed from: b */
    public String mo15776b() {
        return TextUtils.isEmpty(this.f7673U) ? "pangolin.snssdk.com" : this.f7673U;
    }

    /* renamed from: c */
    public String mo15781c() {
        return TextUtils.isEmpty(this.f7674V) ? "extlog.snssdk.com/service/2/app_log/" : this.f7674V;
    }

    /* renamed from: d */
    public boolean mo15783d() {
        return this.f7666N == 1;
    }

    /* renamed from: e */
    public boolean mo15785e() {
        return this.f7667O == 1;
    }

    /* renamed from: f */
    public int mo15787f() {
        return this.f7694r;
    }

    /* renamed from: g */
    public int mo15789g() {
        return this.f7695s * 1024 * 1024;
    }

    /* renamed from: h */
    public String mo15791h() {
        return this.f7654B;
    }

    /* renamed from: i */
    public String mo15793i() {
        return this.f7655C;
    }

    /* renamed from: j */
    public String mo15796j() {
        return this.f7687k;
    }

    /* renamed from: k */
    public long mo15798k() {
        return this.f7668P;
    }

    /* renamed from: l */
    public int mo15799l() {
        return this.f7669Q;
    }

    /* renamed from: m */
    public int mo15801m() {
        return this.f7670R;
    }

    /* renamed from: n */
    public int mo15803n() {
        return this.f7672T;
    }

    /* renamed from: o */
    public int mo15805o() {
        return this.f7657E;
    }

    /* renamed from: p */
    public String mo15808p() {
        return this.f7658F;
    }

    /* renamed from: q */
    public String mo15809q() {
        return this.f7659G;
    }

    /* renamed from: r */
    public int mo15811r() {
        return this.f7660H;
    }

    /* renamed from: s */
    public int mo15813s() {
        return this.f7661I;
    }

    /* renamed from: t */
    public boolean mo15815t() {
        return mo15811r() != 0;
    }

    /* renamed from: u */
    public boolean mo15816u() {
        return mo15813s() == 1;
    }

    /* renamed from: v */
    public boolean mo15817v() {
        return this.f7656D == 1;
    }

    /* renamed from: w */
    public boolean mo15818w() {
        return this.f7688l == 1;
    }

    /* renamed from: x */
    public boolean mo15819x() {
        return this.f7689m == 1;
    }

    /* renamed from: y */
    public boolean mo15820y() {
        return this.f7690n == 1;
    }

    /* renamed from: z */
    public String mo15821z() {
        return this.f7691o;
    }

    /* renamed from: A */
    public int mo15753A() {
        return this.f7692p;
    }

    /* renamed from: B */
    public String mo15754B() {
        return this.f7693q;
    }

    /* renamed from: C */
    public int mo15755C() {
        return this.f7696t;
    }

    /* renamed from: D */
    public int mo15756D() {
        return this.f7697u;
    }

    /* renamed from: E */
    public int mo15757E() {
        return this.f7698v;
    }

    /* renamed from: F */
    public boolean mo15758F() {
        return this.f7699w == 1;
    }

    /* renamed from: G */
    public boolean mo15759G() {
        return this.f7700x == 1;
    }

    /* renamed from: H */
    public int mo15760H() {
        return this.f7701y;
    }

    /* renamed from: I */
    public int mo15761I() {
        return this.f7702z;
    }

    /* renamed from: J */
    public int mo15762J() {
        return this.f7677a;
    }

    /* renamed from: K */
    public int mo15763K() {
        return this.f7678b;
    }

    /* renamed from: L */
    public int mo15764L() {
        return this.f7679c;
    }

    /* renamed from: M */
    public boolean mo15765M() {
        return this.f7653A == 1;
    }

    /* renamed from: a */
    public boolean mo15774a(int i) {
        return mo15812r(String.valueOf(i)).f7587c == 1;
    }

    /* renamed from: a */
    public boolean mo15775a(String str) {
        int i = InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7589e;
        boolean z = true;
        if (i == 1) {
            return C2566w.m12245d(InternalContainer.m10059a());
        }
        if (i != 2) {
            if (i != 3) {
            }
            return false;
        }
        if (C2566w.m12244c(InternalContainer.m10059a()) == 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public boolean mo15778b(String str) {
        return mo15812r(String.valueOf(str)).f7592h == 1;
    }

    /* renamed from: c */
    public int mo15780c(String str) {
        return mo15812r(String.valueOf(str)).f7604t;
    }

    /* renamed from: d */
    public boolean mo15784d(String str) {
        boolean z = true;
        if (str == null) {
            return true;
        }
        if (InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7600p != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: e */
    public boolean mo15786e(String str) {
        boolean z = true;
        if (str == null) {
            return true;
        }
        if (InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7601q != 0) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public int mo15788f(String str) {
        if (str == null) {
            return 1500;
        }
        return InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7602r;
    }

    /* renamed from: g */
    public int mo15790g(String str) {
        return InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7596l;
    }

    /* renamed from: h */
    public JSONArray mo15792h(String str) {
        try {
            AdSlotSetter r = InternalContainer.m10069h().mo15812r(String.valueOf(str));
            if (r != null) {
                if (r.f7609y != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String a : r.f7609y) {
                        TmplDiffModel a2 = TTDynamic.m10862a(a);
                        if (a2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", a2.mo15570b());
                            jSONObject.put("md5", a2.mo15572c());
                            jSONArray.put(jSONObject);
                        }
                    }
                    return jSONArray;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: i */
    public boolean mo15794i(String str) {
        try {
            AdSlotSetter r = InternalContainer.m10069h().mo15812r(String.valueOf(str));
            if (!(r == null || r.f7609y == null)) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: j */
    public int mo15795j(String str) {
        return mo15812r(String.valueOf(str)).f7593i;
    }

    /* renamed from: k */
    public int mo15797k(String str) {
        return mo15812r(str).f7595k;
    }

    /* renamed from: l */
    public int mo15800l(String str) {
        if (str == null) {
            return -1;
        }
        return InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7597m;
    }

    /* renamed from: a */
    public int mo15773a(String str, boolean z) {
        if (str == null) {
            return m9772a(z);
        }
        AdSlotSetter r = InternalContainer.m10069h().mo15812r(String.valueOf(str));
        return r.f7606v != -1 ? r.f7606v : m9772a(z);
    }

    /* renamed from: m */
    public boolean mo15802m(String str) {
        boolean z = true;
        if (str == null) {
            return true;
        }
        if (InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7607w == 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: n */
    public boolean mo15804n(String str) {
        return mo15812r(String.valueOf(str)).f7608x == 0;
    }

    /* renamed from: o */
    public int mo15806o(String str) {
        if (str == null) {
            return 20;
        }
        return InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7605u;
    }

    /* renamed from: p */
    public int mo15807p(String str) {
        if (str == null) {
            return -1;
        }
        return InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7598n;
    }

    /* renamed from: b */
    public boolean mo15777b(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        if (InternalContainer.m10069h().mo15812r(String.valueOf(i)).f7599o == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: q */
    public boolean mo15810q(String str) {
        boolean z = true;
        if (str == null) {
            return true;
        }
        if (InternalContainer.m10069h().mo15812r(String.valueOf(str)).f7590f != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: N */
    public List<String> mo15766N() {
        if (this.f7663K + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String add : this.f7664L) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* renamed from: O */
    public List<String> mo15767O() {
        if (this.f7663K + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String add : this.f7665M) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* renamed from: P */
    public boolean mo15768P() {
        return this.f7662J == 1;
    }

    /* renamed from: Q */
    public int mo15769Q() {
        return this.f7675W;
    }

    /* renamed from: R */
    public int mo15770R() {
        if (this.f7676X <= 0) {
            this.f7676X = PathInterpolatorCompat.MAX_NUM_POINTS;
        }
        return this.f7676X;
    }

    /* renamed from: c */
    public int mo15779c(int i) {
        return mo15812r(String.valueOf(i)).f7586b;
    }

    /* renamed from: d */
    public int mo15782d(int i) {
        return mo15812r(String.valueOf(i)).f7594j;
    }

    /* renamed from: S */
    public int mo15771S() {
        return this.f7671S;
    }

    /* renamed from: r */
    public AdSlotSetter mo15812r(String str) {
        AdSlotSetter aVar = (AdSlotSetter) this.f7680d.get(str);
        return aVar == null ? m9780u(str) : aVar;
    }

    /* renamed from: u */
    private AdSlotSetter m9780u(String str) {
        return AdSlotSetter.m9658a().mo15691a(str).mo15705n(1).mo15706o(!this.f7683g.contains(str)).mo15707p(2).mo15708q(1).mo15709r(1).mo15710s(100).mo15711t(0).mo15713v(1).mo15704m(3).mo15703l(-1).mo15701j(-1).mo15700i(2).mo15702k(-1).mo15714w(1).mo15696e(-1).mo15690a(-1).mo15695d(20).mo15692a((JSONArray) null);
    }

    /* renamed from: T */
    public List<ProcessPushModel> mo15772T() {
        return this.f7686j;
    }

    /* renamed from: s */
    public void mo15814s(String str) {
        this.f7683g.add(str);
    }
}
