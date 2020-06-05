package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.AdSlot.Builder;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.utils.ae */
public class SlotUtils {
    /* renamed from: a */
    public static AdSlot m11980a(String str) {
        try {
            return m11981a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static AdSlot m11981a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            int optInt = jSONObject.optInt("width", ScreenUtil.M9_WIDTH);
            int optInt2 = jSONObject.optInt("height", 320);
            double optDouble = jSONObject.optDouble("expressWidth", 0.0d);
            double optDouble2 = jSONObject.optDouble("expressHeight", 0.0d);
            builder.setAdCount(jSONObject.optInt("adCount", 1));
            builder.setCodeId(jSONObject.optString("codeId", null));
            builder.setImageAcceptedSize(optInt, optInt2);
            builder.setMediaExtra(jSONObject.optString("extra", null));
            builder.setNativeAdType(jSONObject.optInt("adType"));
            builder.setOrientation(jSONObject.optInt("orientation"));
            builder.setRewardAmount(jSONObject.optInt("rewardAmount"));
            builder.setRewardName(jSONObject.optString("rewardName", null));
            builder.setSupportDeepLink(jSONObject.optBoolean("supportDeepLink", false));
            builder.setUserID(jSONObject.optString("userId", null));
            builder.setIsAutoPlay(jSONObject.optBoolean("autoPlay", true));
            builder.setExpressViewAcceptedSize(Double.valueOf(optDouble).floatValue(), Double.valueOf(optDouble2).floatValue());
        } catch (Exception unused) {
        }
        return builder.build();
    }

    /* renamed from: a */
    public static String m11982a(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adCount", adSlot.getAdCount());
            jSONObject.put("codeId", adSlot.getCodeId());
            jSONObject.put("width", adSlot.getImgAcceptedWidth());
            jSONObject.put("height", adSlot.getImgAcceptedHeight());
            jSONObject.put("extra", adSlot.getMediaExtra());
            jSONObject.put("adType", adSlot.getNativeAdType());
            jSONObject.put("orientation", adSlot.getOrientation());
            jSONObject.put("rewardAmount", adSlot.getRewardAmount());
            jSONObject.put("rewardName", adSlot.getRewardName());
            jSONObject.put("supportDeepLink", adSlot.isSupportDeepLink());
            jSONObject.put("userId", adSlot.getUserID());
            jSONObject.put("expressWidth", (double) adSlot.getExpressViewAcceptedWidth());
            jSONObject.put("expressHeight", (double) adSlot.getExpressViewAcceptedHeight());
            jSONObject.put("autoPlay", adSlot.isAutoPlay());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
