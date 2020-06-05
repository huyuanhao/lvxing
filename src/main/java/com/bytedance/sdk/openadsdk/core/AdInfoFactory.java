package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.AdSlot.Builder;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.p170d.AdInfo;
import com.bytedance.sdk.openadsdk.core.p170d.C2222b;
import com.bytedance.sdk.openadsdk.core.p170d.ClickArea;
import com.bytedance.sdk.openadsdk.core.p170d.DeepLink;
import com.bytedance.sdk.openadsdk.core.p170d.DownConfig;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta.C2227a;
import com.bytedance.sdk.openadsdk.core.p170d.VideoInfo;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.c */
public class AdInfoFactory {
    /* renamed from: a */
    public static AdInfo m9162a(JSONObject jSONObject, AdSlot adSlot) {
        if (jSONObject == null) {
            return null;
        }
        try {
            AdInfo aVar = new AdInfo();
            aVar.mo15333a(jSONObject.optString("request_id"));
            aVar.mo15330a(jSONObject.optInt(KEYS.RET));
            aVar.mo15335b(jSONObject.optString("message"));
            if (aVar.mo15334b() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MaterialMeta b = m9170b(optJSONArray.optJSONObject(i), adSlot);
                    if (b != null && m9166a(b)) {
                        aVar.mo15332a(b);
                    }
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static MaterialMeta m9163a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return m9170b(jSONObject, null);
    }

    /* renamed from: b */
    public static MaterialMeta m9170b(JSONObject jSONObject, AdSlot adSlot) {
        if (jSONObject == null) {
            return null;
        }
        MaterialMeta kVar = new MaterialMeta();
        kVar.mo15490i(jSONObject.optInt("interaction_type"));
        kVar.mo15469c(jSONObject.optString("target_url"));
        kVar.mo15487h(jSONObject.optString("ad_id"));
        kVar.mo15462b(jSONObject.optString(ArgKey.KEY_SOURCE));
        kVar.mo15498l(jSONObject.optInt("dislike_control", 0));
        kVar.mo15486h(jSONObject.optInt("play_bar_show_time", -200));
        kVar.mo15454a(jSONObject.optBoolean("is_playable"));
        kVar.mo15460b(jSONObject.optInt("playable_type", 0));
        kVar.mo15451a(jSONObject.optString("playable_style"));
        JSONObject optJSONObject = jSONObject.optJSONObject("icon");
        kVar.mo15464b(jSONObject.optBoolean("screenshot", false));
        kVar.mo15480f(jSONObject.optInt("play_bar_style", 0));
        kVar.mo15494j(jSONObject.optString("market_url", ""));
        kVar.mo15472d(jSONObject.optInt("video_adaptation", 0));
        kVar.mo15467c(jSONObject.optInt("feed_video_opentype", 0));
        kVar.mo15453a(jSONObject.optJSONObject("session_params"));
        String str = "width";
        String str2 = "height";
        String str3 = "url";
        if (optJSONObject != null) {
            Image jVar = new Image();
            jVar.mo15408a(optJSONObject.optString(str3));
            jVar.mo15410b(optJSONObject.optInt(str2));
            jVar.mo15407a(optJSONObject.optInt(str));
            kVar.mo15448a(jVar);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("cover_image");
        if (optJSONObject2 != null) {
            Image jVar2 = new Image();
            jVar2.mo15408a(optJSONObject2.optString(str3));
            jVar2.mo15410b(optJSONObject2.optInt(str2));
            jVar2.mo15407a(optJSONObject2.optInt(str));
            kVar.mo15461b(jVar2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("image");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                Image jVar3 = new Image();
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                jVar3.mo15408a(optJSONObject3.optString(str3));
                jVar3.mo15410b(optJSONObject3.optInt(str2));
                jVar3.mo15407a(optJSONObject3.optInt(str));
                kVar.mo15468c(jVar3);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_url");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                kVar.mo15420H().add(optJSONArray2.optString(i2));
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("click_url");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                kVar.mo15421I().add(optJSONArray3.optString(i3));
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("click_area");
        if (optJSONObject4 != null) {
            ClickArea dVar = new ClickArea();
            dVar.f7331a = optJSONObject4.optBoolean("click_upper_content_area", true);
            dVar.f7332b = optJSONObject4.optBoolean("click_upper_non_content_area", true);
            dVar.f7333c = optJSONObject4.optBoolean("click_lower_content_area", true);
            dVar.f7334d = optJSONObject4.optBoolean("click_lower_non_content_area", true);
            dVar.f7335e = optJSONObject4.optBoolean("click_button_area", true);
            dVar.f7336f = optJSONObject4.optBoolean("click_video_area", true);
            kVar.mo15445a(dVar);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("adslot");
        if (optJSONObject5 != null) {
            kVar.mo15442a(m9169b(optJSONObject5));
        } else {
            kVar.mo15442a(adSlot);
        }
        kVar.mo15483g(jSONObject.optInt("intercept_flag", 0));
        kVar.mo15473d(jSONObject.optString("phone_num"));
        kVar.mo15477e(jSONObject.optString("title"));
        kVar.mo15481f(jSONObject.optString("description"));
        kVar.mo15484g(jSONObject.optString("button_text"));
        kVar.mo15476e(jSONObject.optInt("ad_logo", 1));
        kVar.mo15491i(jSONObject.optString("ext"));
        kVar.mo15493j(jSONObject.optInt("image_mode"));
        JSONObject optJSONObject6 = jSONObject.optJSONObject("app");
        JSONObject optJSONObject7 = jSONObject.optJSONObject("deep_link");
        kVar.mo15444a(m9172d(optJSONObject6));
        kVar.mo15446a(m9174f(optJSONObject7));
        JSONArray optJSONArray4 = jSONObject.optJSONArray("filter_words");
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                FilterWord c = m9171c(optJSONArray4.optJSONObject(i4));
                if (c != null && c.isValid()) {
                    kVar.mo15443a(c);
                }
            }
        }
        kVar.mo15495k(jSONObject.optInt("count_down"));
        kVar.mo15441a(jSONObject.optLong("expiration_time"));
        JSONObject optJSONObject8 = jSONObject.optJSONObject("video");
        if (optJSONObject8 != null) {
            kVar.mo15450a(m9175g(optJSONObject8));
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject("download_conf");
        if (optJSONObject9 != null) {
            kVar.mo15447a(m9173e(optJSONObject9));
        }
        kVar.mo15452a(m9176h(jSONObject.optJSONObject("media_ext")));
        JSONObject optJSONObject10 = jSONObject.optJSONObject("tpl_info");
        if (optJSONObject10 != null) {
            C2227a aVar = new C2227a();
            aVar.mo15516b(optJSONObject10.optString("id"));
            aVar.mo15518c(optJSONObject10.optString("md5"));
            aVar.mo15520d(optJSONObject10.optString(str3));
            aVar.mo15522e(optJSONObject10.optString("data"));
            aVar.mo15524f(optJSONObject10.optString("diff_data"));
            aVar.mo15526g(optJSONObject10.optString("dynamic_creative"));
            aVar.mo15514a(optJSONObject10.optString(AppEntity.KEY_VERSION_STR));
            kVar.mo15449a(aVar);
        }
        kVar.mo15440a(jSONObject.optInt("if_block_lp", 0));
        return kVar;
    }

    /* renamed from: b */
    private static AdSlot m9169b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String str = "";
        String optString = jSONObject.optString("mCodeId", str);
        int optInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int optInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float optDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float optDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int optInt3 = jSONObject.optInt("mAdCount", 6);
        boolean optBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String optString2 = jSONObject.optString("mRewardName", str);
        int optInt4 = jSONObject.optInt("mRewardAmount", 0);
        String optString3 = jSONObject.optString("mMediaExtra", str);
        String optString4 = jSONObject.optString("mUserID", str);
        int optInt5 = jSONObject.optInt("mOrientation", 2);
        int optInt6 = jSONObject.optInt("mNativeAdType", 0);
        return new Builder().setCodeId(optString).setImageAcceptedSize(optInt, optInt2).setExpressViewAcceptedSize(optDouble, optDouble2).setAdCount(optInt3).setSupportDeepLink(optBoolean).setRewardName(optString2).setRewardAmount(optInt4).setMediaExtra(optString3).setUserID(optString4).setOrientation(optInt5).setNativeAdType(optInt6).setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay", false)).build();
    }

    /* renamed from: c */
    private static FilterWord m9171c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString(ArgKey.KEY_NAME));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FilterWord c = m9171c(optJSONArray.optJSONObject(i));
                    if (c != null && c.isValid()) {
                        filterWord.addOption(c);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: d */
    private static C2222b m9172d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C2222b bVar = new C2222b();
        bVar.mo15347c(jSONObject.optString("app_name"));
        bVar.mo15349d(jSONObject.optString("package_name"));
        bVar.mo15344b(jSONObject.optString("download_url"));
        bVar.mo15340a(jSONObject.optInt("score", 4));
        bVar.mo15343b(jSONObject.optInt("comment_num", 6870));
        bVar.mo15346c(jSONObject.optInt("app_size", 0));
        bVar.mo15341a(jSONObject.optString("quick_app_url", ""));
        return bVar;
    }

    /* renamed from: e */
    private static DownConfig m9173e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        DownConfig gVar = new DownConfig();
        gVar.mo15389d(jSONObject.optInt("auto_open", 1));
        gVar.mo15391e(jSONObject.optInt("download_mode", 0));
        gVar.mo15386c(jSONObject.optInt("support_multiple", 0));
        gVar.mo15393f(jSONObject.optInt("auto_control", 0));
        gVar.mo15385b(jSONObject.optInt("download_type", -1));
        gVar.mo15383a(jSONObject.optInt("if_suspend_download", 1));
        return gVar;
    }

    /* renamed from: f */
    private static DeepLink m9174f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        DeepLink fVar = new DeepLink();
        fVar.mo15378a(jSONObject.optString("deeplink_url"));
        fVar.mo15380b(jSONObject.optString("fallback_url"));
        fVar.mo15377a(jSONObject.optInt("fallback_type"));
        return fVar;
    }

    /* renamed from: g */
    private static VideoInfo m9175g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        VideoInfo rVar = new VideoInfo();
        rVar.mo15587a(jSONObject.optInt("cover_height"));
        rVar.mo15591b(jSONObject.optInt("cover_width"));
        rVar.mo15589a(jSONObject.optString("resolution"));
        rVar.mo15588a(jSONObject.optLong(AppEntity.KEY_SIZE_LONG));
        rVar.mo15586a(jSONObject.optDouble("video_duration"));
        rVar.mo15592b(jSONObject.optString("cover_url"));
        rVar.mo15595c(jSONObject.optString("video_url"));
        rVar.mo15598d(jSONObject.optString("endcard"));
        rVar.mo15600e(jSONObject.optString("playable_download_url"));
        rVar.mo15602f(jSONObject.optString("file_hash"));
        rVar.mo15594c(jSONObject.optInt("if_playable_loading_show", 0));
        rVar.mo15597d(jSONObject.optInt("remove_loading_page_type", 0));
        return rVar;
    }

    /* renamed from: h */
    private static Map<String, Object> m9176h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str, jSONObject.opt(str));
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006f, code lost:
            if (r0 != 16) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007a, code lost:
            if (m9167a(r7.mo15512z()) == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0085, code lost:
            if (m9168a(r7.mo15418F()) == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0088, code lost:
            r1 = r2;
     */
    /* renamed from: a */
    private static boolean m9166a(com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta r7) {
        /*
        r0 = 1
        r1 = 0
        if (r7 != 0) goto L_0x0006
        r2 = 0
        goto L_0x0007
    L_0x0006:
        r2 = 1
    L_0x0007:
        java.lang.String r3 = r7.mo15425M()
        boolean r3 = android.text.TextUtils.isEmpty(r3)
        if (r3 != 0) goto L_0x0089
        java.lang.String r3 = r7.mo15425M()
        int r3 = r3.length()
        if (r3 > r0) goto L_0x001d
        goto L_0x0089
    L_0x001d:
        com.bytedance.sdk.openadsdk.core.d.f r0 = r7.mo15427O()
        boolean r0 = m9165a(r0)
        if (r0 != 0) goto L_0x0028
        return r1
    L_0x0028:
        int r0 = r7.mo15414B()
        r3 = 5
        r4 = 4
        r5 = 3
        r6 = 2
        if (r0 == r6) goto L_0x004f
        if (r0 == r5) goto L_0x004f
        if (r0 == r4) goto L_0x0044
        if (r0 == r3) goto L_0x0039
        goto L_0x005a
    L_0x0039:
        java.lang.String r0 = r7.mo15419G()
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 == 0) goto L_0x005a
        goto L_0x0059
    L_0x0044:
        com.bytedance.sdk.openadsdk.core.d.b r0 = r7.mo15426N()
        boolean r0 = m9164a(r0)
        if (r0 != 0) goto L_0x005a
        goto L_0x0059
    L_0x004f:
        java.lang.String r0 = r7.mo15417E()
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 == 0) goto L_0x005a
    L_0x0059:
        r2 = 0
    L_0x005a:
        if (r2 != 0) goto L_0x005d
        return r2
    L_0x005d:
        int r0 = r7.mo15429Q()
        if (r0 == r6) goto L_0x007d
        if (r0 == r5) goto L_0x007d
        if (r0 == r4) goto L_0x007d
        if (r0 == r3) goto L_0x0072
        r3 = 15
        if (r0 == r3) goto L_0x0072
        r3 = 16
        if (r0 == r3) goto L_0x007d
        goto L_0x0088
    L_0x0072:
        com.bytedance.sdk.openadsdk.core.d.r r7 = r7.mo15512z()
        boolean r7 = m9167a(r7)
        if (r7 != 0) goto L_0x0088
        goto L_0x0089
    L_0x007d:
        java.util.List r7 = r7.mo15418F()
        boolean r7 = m9168a(r7)
        if (r7 != 0) goto L_0x0088
        goto L_0x0089
    L_0x0088:
        r1 = r2
    L_0x0089:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.AdInfoFactory.m9166a(com.bytedance.sdk.openadsdk.core.d.k):boolean");
    }

    /* renamed from: a */
    private static boolean m9165a(DeepLink fVar) {
        if (fVar == null) {
            return true;
        }
        if (TextUtils.isEmpty(fVar.mo15376a()) || TextUtils.isEmpty(fVar.mo15379b())) {
            return false;
        }
        return fVar.mo15381c() == 1 || fVar.mo15381c() == 2;
    }

    /* renamed from: a */
    private static boolean m9167a(VideoInfo rVar) {
        if (rVar != null && !TextUtils.isEmpty(rVar.mo15603g()) && !TextUtils.isEmpty(rVar.mo15601f())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m9164a(C2222b bVar) {
        return bVar != null && !TextUtils.isEmpty(bVar.mo15342b());
    }

    /* renamed from: a */
    private static boolean m9168a(List<Image> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (Image jVar : list) {
            if (jVar == null) {
                return false;
            }
            if (TextUtils.isEmpty(jVar.mo15406a())) {
                return false;
            }
        }
        return true;
    }
}
