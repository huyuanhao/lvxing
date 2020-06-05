package com.bytedance.embedapplog;

import com.bytedance.embedapplog.util.C1856h;
import com.bytedance.embedapplog.util.C1857i;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONException;
import org.json.JSONObject;

public final class GameReportHelper {
    public static final String ACCESS_ACCOUNT = "access_account";
    public static final String ACCESS_PAYMENT_CHANNEL = "access_payment_channel";
    public static final String ADD_CART = "add_cart";
    public static final String ADD_TO_FAVORITE = "add_to_favourite";
    public static final String CHECK_OUT = "check_out";
    public static final String CREATE_GAMEROLE = "create_gamerole";
    public static final String LOG_IN = "log_in";
    public static final String PURCHASE = "purchase";
    public static final String QUEST = "quest";
    public static final String REGISTER = "register";
    public static final String UPDATE_LEVEL = "update_level";
    public static final String VIEW_CONTENT = "view_content";

    public static void onEventRegister(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put("is_success", C1857i.m6590a(z));
            AppLog.onEventV3(REGISTER, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventLogin(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", str);
            jSONObject.put("is_success", C1857i.m6590a(z));
            AppLog.onEventV3(LOG_IN, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventPurchase(String str, String str2, String str3, int i, String str4, String str5, boolean z, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C7887a.CONTENT_TYPE, str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i);
            jSONObject.put("payment_channel", str4);
            jSONObject.put("currency", str5);
            jSONObject.put("is_success", C1857i.m6590a(z));
            jSONObject.put("currency_amount", i2);
            AppLog.onEventV3(PURCHASE, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventAccessAccount(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ArgKey.KEY_ACCOUNT_TYPE, str);
            jSONObject.put("is_success", C1857i.m6590a(z));
            AppLog.onEventV3(ACCESS_ACCOUNT, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventQuest(String str, String str2, String str3, int i, boolean z, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("quest_id", str);
            jSONObject.put("quest_type", str2);
            jSONObject.put("quest_name", str3);
            jSONObject.put("quest_no", i);
            jSONObject.put("is_success", C1857i.m6590a(z));
            jSONObject.put("description", str4);
            AppLog.onEventV3(QUEST, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventUpdateLevel(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("level", i);
            AppLog.onEventV3(UPDATE_LEVEL, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventCreateGameRole(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gamerole_id", str);
            AppLog.onEventV3(CREATE_GAMEROLE, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventCheckOut(String str, String str2, String str3, int i, boolean z, String str4, String str5, boolean z2, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C7887a.CONTENT_TYPE, str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i);
            jSONObject.put("is_virtual_currency", C1857i.m6590a(z));
            jSONObject.put("virtual_currency", str4);
            jSONObject.put("currency", str5);
            jSONObject.put("is_success", C1857i.m6590a(z2));
            jSONObject.put("currency_amount", i2);
            AppLog.onEventV3(CHECK_OUT, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventAddToFavorite(String str, String str2, String str3, int i, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C7887a.CONTENT_TYPE, str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i);
            jSONObject.put("is_success", C1857i.m6590a(z));
            AppLog.onEventV3(ADD_TO_FAVORITE, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventAccessPaymentChannel(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payment_channel", str);
            jSONObject.put("is_success", C1857i.m6590a(z));
            AppLog.onEventV3(ACCESS_PAYMENT_CHANNEL, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventAddCart(String str, String str2, String str3, int i, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C7887a.CONTENT_TYPE, str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            jSONObject.put("content_num", i);
            jSONObject.put("is_success", C1857i.m6590a(z));
            AppLog.onEventV3(ADD_CART, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }

    public static void onEventViewContent(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C7887a.CONTENT_TYPE, str);
            jSONObject.put("content_name", str2);
            jSONObject.put("content_id", str3);
            AppLog.onEventV3(VIEW_CONTENT, jSONObject);
        } catch (JSONException e) {
            C1856h.m6582a(e);
        }
    }
}
