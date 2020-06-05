package com.tencent.p607mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.p522qq.p523e.comm.constants.Constants.KEYS;
import com.tencent.p607mm.opensdk.channel.MMessageActV2;
import com.tencent.p607mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p607mm.opensdk.channel.p608a.C7322a;
import com.tencent.p607mm.opensdk.channel.p608a.C7322a.C7323a;
import com.tencent.p607mm.opensdk.channel.p608a.C7324b;
import com.tencent.p607mm.opensdk.constants.ConstantsAPI;
import com.tencent.p607mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p607mm.opensdk.modelbase.BaseReq;
import com.tencent.p607mm.opensdk.modelbase.BaseResp;
import com.tencent.p607mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.p607mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.p607mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.p607mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.p607mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.p607mm.opensdk.modelbiz.OpenWebview;
import com.tencent.p607mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.p607mm.opensdk.modelbiz.SubscribeMessage.Resp;
import com.tencent.p607mm.opensdk.modelbiz.SubscribeMiniProgramMsg;
import com.tencent.p607mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.p607mm.opensdk.modelbiz.WXInvoiceAuthInsert.Req;
import com.tencent.p607mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.p607mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.p607mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.p607mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.p607mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.p607mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.p607mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.p607mm.opensdk.modelmsg.SendAuth;
import com.tencent.p607mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.p607mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.p607mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.p607mm.opensdk.modelpay.PayResp;
import com.tencent.p607mm.opensdk.utils.C7339d;
import com.tencent.p607mm.opensdk.utils.ILog;
import com.tencent.p607mm.opensdk.utils.Log;
import java.net.URLEncoder;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.opensdk.openapi.BaseWXApiImplV10 */
class BaseWXApiImplV10 implements IWXAPI {
    protected static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static String wxappPayEntryClassname;
    protected String appId;
    protected boolean checkSignature = false;
    protected Context context;
    protected boolean detached = false;

    BaseWXApiImplV10(Context context2, String str, boolean z) {
        StringBuilder sb = new StringBuilder("<init>, appId = ");
        sb.append(str);
        sb.append(", checkSignature = ");
        sb.append(z);
        Log.m31626d(TAG, sb.toString());
        this.context = context2;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        String str;
        String str2 = TAG;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "checkSumConsistent fail, invalid arguments";
        } else if (bArr.length != bArr2.length) {
            str = "checkSumConsistent fail, length is different";
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        Log.m31627e(str2, str);
        return false;
    }

    private boolean createChatroom(Context context2, Bundle bundle) {
        String str = "";
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", str), bundle.getString("_wxapi_create_chatroom_group_id", str), bundle.getString("_wxapi_create_chatroom_chatroom_name", str), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", str), bundle.getString("_wxapi_create_chatroom_ext_msg", str), bundle.getString("_wxapi_basereq_openid", str)}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private String getTokenFromWX(Context context2) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[]{this.appId, "620953856"}, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        String string = query.getString(0);
        StringBuilder sb = new StringBuilder("getTokenFromWX token is ");
        sb.append(string);
        Log.m31628i(TAG, sb.toString());
        query.close();
        return string;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        StringBuilder sb = new StringBuilder("handleWxInternalRespType, extInfo = ");
        sb.append(str);
        String sb2 = sb.toString();
        String str2 = TAG;
        Log.m31628i(str2, sb2);
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wx_internal_resptype");
            StringBuilder sb3 = new StringBuilder("handleWxInternalRespType, respType = ");
            sb3.append(queryParameter);
            Log.m31628i(str2, sb3.toString());
            if (C7339d.m31636b(queryParameter)) {
                Log.m31627e(str2, "handleWxInternalRespType fail, respType is null");
                return false;
            }
            boolean equals = queryParameter.equals("subscribemessage");
            String str3 = "openid";
            String str4 = KEYS.RET;
            if (equals) {
                Resp resp = new Resp();
                String queryParameter2 = parse.getQueryParameter(str4);
                if (queryParameter2 != null && queryParameter2.length() > 0) {
                    resp.errCode = C7339d.m31637c(queryParameter2);
                }
                resp.openId = parse.getQueryParameter(str3);
                resp.templateID = parse.getQueryParameter("template_id");
                resp.scene = C7339d.m31637c(parse.getQueryParameter("scene"));
                resp.action = parse.getQueryParameter("action");
                resp.reserved = parse.getQueryParameter("reserved");
                iWXAPIEventHandler.onResp(resp);
                return true;
            }
            String str5 = "wx_order_id";
            if (queryParameter.contains("invoice_auth_insert")) {
                WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
                String queryParameter3 = parse.getQueryParameter(str4);
                if (queryParameter3 != null && queryParameter3.length() > 0) {
                    resp2.errCode = C7339d.m31637c(queryParameter3);
                }
                resp2.wxOrderId = parse.getQueryParameter(str5);
                iWXAPIEventHandler.onResp(resp2);
                return true;
            } else if (queryParameter.contains("payinsurance")) {
                WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
                String queryParameter4 = parse.getQueryParameter(str4);
                if (queryParameter4 != null && queryParameter4.length() > 0) {
                    resp3.errCode = C7339d.m31637c(queryParameter4);
                }
                resp3.wxOrderId = parse.getQueryParameter(str5);
                iWXAPIEventHandler.onResp(resp3);
                return true;
            } else if (queryParameter.contains("nontaxpay")) {
                WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
                String queryParameter5 = parse.getQueryParameter(str4);
                if (queryParameter5 != null && queryParameter5.length() > 0) {
                    resp4.errCode = C7339d.m31637c(queryParameter5);
                }
                resp4.wxOrderId = parse.getQueryParameter(str5);
                iWXAPIEventHandler.onResp(resp4);
                return true;
            } else {
                if (!"subscribeminiprogrammsg".equals(queryParameter)) {
                    if (!"5".equals(queryParameter)) {
                        Log.m31627e(str2, "this open sdk version not support the request type");
                        return false;
                    }
                }
                SubscribeMiniProgramMsg.Resp resp5 = new SubscribeMiniProgramMsg.Resp();
                String queryParameter6 = parse.getQueryParameter(str4);
                if (queryParameter6 != null && queryParameter6.length() > 0) {
                    resp5.errCode = C7339d.m31637c(queryParameter6);
                }
                resp5.openId = parse.getQueryParameter(str3);
                resp5.unionId = parse.getQueryParameter("unionid");
                resp5.nickname = parse.getQueryParameter("nickname");
                resp5.errStr = parse.getQueryParameter("errmsg");
                iWXAPIEventHandler.onResp(resp5);
                return true;
            }
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder("handleWxInternalRespType fail, ex = ");
            sb4.append(e.getMessage());
            Log.m31627e(str2, sb4.toString());
        }
    }

    private boolean joinChatroom(Context context2, Bundle bundle) {
        String str = "";
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", str), bundle.getString("_wxapi_join_chatroom_group_id", str), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", str), bundle.getString("_wxapi_join_chatroom_ext_msg", str), bundle.getString("_wxapi_basereq_openid", str)}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendAddCardToWX(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context2, BaseReq baseReq) {
        Req req = (Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "2", URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(req.url)}))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizProfileReq(Context context2, Bundle bundle) {
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        StringBuilder sb = new StringBuilder();
        sb.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type"));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), sb.toString(), sb2.toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizTempSessionReq(Context context2, Bundle bundle) {
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession");
        StringBuilder sb = new StringBuilder();
        sb.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_show_type"));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_session_from"), sb.toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context2, Bundle bundle) {
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        StringBuilder sb = new StringBuilder();
        sb.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene"));
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), sb.toString()}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToOfflinePayReq(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[]{this.appId}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogram(Context context2, BaseReq baseReq) {
        WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
        StringBuilder sb = new StringBuilder();
        sb.append(req.miniprogramType);
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, req.userName, req.path, sb.toString(), req.extData}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(Context context2, BaseReq baseReq) {
        WXNontaxPay.Req req = (WXNontaxPay.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "3", URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(req.url)}))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessView(Context context2, BaseReq baseReq) {
        WXOpenBusinessView.Req req = (WXOpenBusinessView.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[]{this.appId, req.businessType, req.query, req.extInfo}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessWebview(Context context2, BaseReq baseReq) {
        WXOpenBusinessWebview.Req req = (WXOpenBusinessWebview.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
        String jSONObject = (req.queryInfo == null || req.queryInfo.size() <= 0) ? "" : new JSONObject(req.queryInfo).toString();
        StringBuilder sb = new StringBuilder();
        sb.append(req.businessType);
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, sb.toString(), jSONObject}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenWebview(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayInSurance(Context context2, BaseReq baseReq) {
        WXPayInsurance.Req req = (WXPayInsurance.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "4", URLEncoder.encode(String.format("url=%s", new Object[]{URLEncoder.encode(req.url)}))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context2, Bundle bundle) {
        String str = "com.tencent.mm";
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context2).getString("_wxapp_pay_entry_classname_", null);
            StringBuilder sb = new StringBuilder("pay, set wxappPayEntryClassname = ");
            sb.append(wxappPayEntryClassname);
            String sb2 = sb.toString();
            String str2 = TAG;
            Log.m31626d(str2, sb2);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context2.getPackageManager().getApplicationInfo(str, 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (Exception e) {
                    StringBuilder sb3 = new StringBuilder("get from metaData failed : ");
                    sb3.append(e.getMessage());
                    Log.m31627e(str2, sb3.toString());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.m31627e(str2, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        Args args = new Args();
        args.bundle = bundle;
        args.targetPkgName = str;
        args.targetClassName = wxappPayEntryClassname;
        return MMessageActV2.send(context2, args);
    }

    private boolean sendSubscribeMessage(Context context2, BaseReq baseReq) {
        SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "1", String.valueOf(req.scene), req.templateID, req.reserved}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendSubscribeMiniProgramMsg(Context context2, BaseReq baseReq) {
        SubscribeMiniProgramMsg.Req req = (SubscribeMiniProgramMsg.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "5", req.miniProgramAppId}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    public void detach() {
        Log.m31626d(TAG, "detach");
        this.detached = true;
        this.context = null;
    }

    public int getWXAppSupportAPI() {
        if (!this.detached) {
            boolean isWXAppInstalled = isWXAppInstalled();
            String str = TAG;
            if (!isWXAppInstalled) {
                Log.m31627e(str, "open wx app failed, not installed or signature check failed");
                return 0;
            }
            int i = new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
            if (i == 0) {
                try {
                    i = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("get from metaData failed : ");
                    sb.append(e.getMessage());
                    Log.m31627e(str, sb.toString());
                }
            }
            return i;
        }
        throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
    }

    public boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        String str = "openbusinesswebview";
        String str2 = TAG;
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, Token.WX_TOKEN_VALUE_MSG)) {
                Log.m31628i(str2, "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (!this.detached) {
                String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
                int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
                String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (stringExtra2 != null) {
                    if (stringExtra2.length() != 0) {
                        if (!checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), C7324b.m31613a(stringExtra, intExtra, stringExtra2))) {
                            Log.m31627e(str2, "checksum fail");
                            return false;
                        }
                        int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                        StringBuilder sb = new StringBuilder("handleIntent, cmd = ");
                        sb.append(intExtra2);
                        Log.m31628i(str2, sb.toString());
                        switch (intExtra2) {
                            case 1:
                                iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                                return true;
                            case 2:
                                iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                                return true;
                            case 3:
                                iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                                return true;
                            case 4:
                                ShowMessageFromWX.Req req = new ShowMessageFromWX.Req(intent.getExtras());
                                String str3 = req.message.messageExt;
                                if (str3 == null || !str3.contains("wx_internal_resptype")) {
                                    if (str3 != null && str3.contains(str)) {
                                        try {
                                            Uri parse = Uri.parse(str3);
                                            if (parse == null || !str.equals(parse.getHost())) {
                                                StringBuilder sb2 = new StringBuilder("not openbusinesswebview %");
                                                sb2.append(str3);
                                                Log.m31626d(str2, sb2.toString());
                                            } else {
                                                WXOpenBusinessWebview.Resp resp = new WXOpenBusinessWebview.Resp();
                                                String queryParameter = parse.getQueryParameter(KEYS.RET);
                                                if (queryParameter != null && queryParameter.length() > 0) {
                                                    resp.errCode = C7339d.m31637c(queryParameter);
                                                }
                                                resp.resultInfo = parse.getQueryParameter("resultInfo");
                                                resp.errStr = parse.getQueryParameter("errmsg");
                                                String queryParameter2 = parse.getQueryParameter("type");
                                                if (queryParameter2 != null && queryParameter2.length() > 0) {
                                                    resp.businessType = C7339d.m31637c(queryParameter2);
                                                }
                                                iWXAPIEventHandler.onResp(resp);
                                                return true;
                                            }
                                        } catch (Exception e) {
                                            StringBuilder sb3 = new StringBuilder("parse fail, ex = ");
                                            sb3.append(e.getMessage());
                                            Log.m31627e(str2, sb3.toString());
                                        }
                                    }
                                    iWXAPIEventHandler.onReq(req);
                                    return true;
                                }
                                boolean handleWxInternalRespType = handleWxInternalRespType(str3, iWXAPIEventHandler);
                                StringBuilder sb4 = new StringBuilder("handleIntent, extInfo contains wx_internal_resptype, ret = ");
                                sb4.append(handleWxInternalRespType);
                                Log.m31628i(str2, sb4.toString());
                                return handleWxInternalRespType;
                            case 5:
                                iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                                return true;
                            case 6:
                                iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                                return true;
                            case 9:
                                iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                                return true;
                            case 12:
                                iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                                return true;
                            case 14:
                                iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                                return true;
                            case 15:
                                iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                                return true;
                            case 16:
                                iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                                return true;
                            case 17:
                                iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                                return true;
                            case 19:
                                iWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(intent.getExtras()));
                                return true;
                            case 24:
                                iWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(intent.getExtras()));
                                return true;
                            case 25:
                                iWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(intent.getExtras()));
                                return true;
                            case 26:
                                iWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(intent.getExtras()));
                                return true;
                            default:
                                StringBuilder sb5 = new StringBuilder("unknown cmd = ");
                                sb5.append(intExtra2);
                                Log.m31627e(str2, sb5.toString());
                                break;
                        }
                        return false;
                    }
                }
                Log.m31627e(str2, "invalid argument");
                return false;
            } else {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            }
        } catch (Exception e2) {
            StringBuilder sb6 = new StringBuilder("handleIntent fail, ex = ");
            sb6.append(e2.getMessage());
            Log.m31627e(str2, sb6.toString());
        }
    }

    public boolean isWXAppInstalled() {
        if (!this.detached) {
            boolean z = false;
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
                if (packageInfo == null) {
                    return false;
                }
                z = WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
                return z;
            } catch (NameNotFoundException unused) {
            }
        } else {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
    }

    public boolean openWXApp() {
        String sb;
        if (!this.detached) {
            boolean isWXAppInstalled = isWXAppInstalled();
            String str = TAG;
            if (!isWXAppInstalled) {
                sb = "open wx app failed, not installed or signature check failed";
            } else {
                try {
                    this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                    return true;
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder("startActivity fail, exception = ");
                    sb2.append(e.getMessage());
                    sb = sb2.toString();
                }
            }
            Log.m31627e(str, sb);
            return false;
        }
        throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    }

    public boolean registerApp(String str) {
        return registerApp(str, 0);
    }

    public boolean registerApp(String str, long j) {
        if (!this.detached) {
            String str2 = "com.tencent.mm";
            boolean validateAppSignatureForPackage = WXApiImplComm.validateAppSignatureForPackage(this.context, str2, this.checkSignature);
            String str3 = TAG;
            if (!validateAppSignatureForPackage) {
                Log.m31627e(str3, "register app failed for wechat app signature check failed");
                return false;
            }
            String str4 = "registerApp, appId = ";
            StringBuilder sb = new StringBuilder(str4);
            sb.append(str);
            Log.m31626d(str3, sb.toString());
            if (str != null) {
                this.appId = str;
            }
            StringBuilder sb2 = new StringBuilder(str4);
            sb2.append(str);
            Log.m31626d(str3, sb2.toString());
            if (str != null) {
                this.appId = str;
            }
            StringBuilder sb3 = new StringBuilder("register app ");
            sb3.append(this.context.getPackageName());
            Log.m31626d(str3, sb3.toString());
            C7323a aVar = new C7323a();
            aVar.f24796a = str2;
            aVar.action = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            StringBuilder sb4 = new StringBuilder("weixin://registerapp?appid=");
            sb4.append(this.appId);
            aVar.content = sb4.toString();
            aVar.f24797b = j;
            return C7322a.m31612a(this.context, aVar);
        }
        throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0215  */
    public boolean sendReq(com.tencent.p607mm.opensdk.modelbase.BaseReq r10) {
        /*
        r9 = this;
        boolean r0 = r9.detached
        if (r0 != 0) goto L_0x0248
        android.content.Context r0 = r9.context
        boolean r1 = r9.checkSignature
        java.lang.String r2 = "com.tencent.mm"
        boolean r0 = com.tencent.p607mm.opensdk.openapi.WXApiImplComm.validateAppSignatureForPackage(r0, r2, r1)
        java.lang.String r1 = "MicroMsg.SDK.WXApiImplV10"
        r3 = 0
        if (r0 != 0) goto L_0x0019
        java.lang.String r10 = "sendReq failed for wechat app signature check failed"
    L_0x0015:
        com.tencent.p607mm.opensdk.utils.Log.m31627e(r1, r10)
        return r3
    L_0x0019:
        boolean r0 = r10.checkArgs()
        if (r0 != 0) goto L_0x0022
        java.lang.String r10 = "sendReq checkArgs fail"
        goto L_0x0015
    L_0x0022:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        java.lang.String r4 = "sendReq, req type = "
        r0.<init>(r4)
        int r4 = r10.getType()
        r0.append(r4)
        java.lang.String r0 = r0.toString()
        com.tencent.p607mm.opensdk.utils.Log.m31628i(r1, r0)
        android.os.Bundle r0 = new android.os.Bundle
        r0.<init>()
        r10.toBundle(r0)
        int r1 = r10.getType()
        r4 = 5
        if (r1 != r4) goto L_0x004d
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendPayReq(r10, r0)
        return r10
    L_0x004d:
        int r1 = r10.getType()
        r4 = 7
        if (r1 != r4) goto L_0x005b
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendJumpToBizProfileReq(r10, r0)
        return r10
    L_0x005b:
        int r1 = r10.getType()
        r4 = 8
        if (r1 != r4) goto L_0x006a
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendJumpToBizWebviewReq(r10, r0)
        return r10
    L_0x006a:
        int r1 = r10.getType()
        r4 = 10
        if (r1 != r4) goto L_0x0079
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendJumpToBizTempSessionReq(r10, r0)
        return r10
    L_0x0079:
        int r1 = r10.getType()
        r4 = 9
        if (r1 != r4) goto L_0x0088
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendAddCardToWX(r10, r0)
        return r10
    L_0x0088:
        int r1 = r10.getType()
        r4 = 16
        if (r1 != r4) goto L_0x0097
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendChooseCardFromWX(r10, r0)
        return r10
    L_0x0097:
        int r1 = r10.getType()
        r4 = 11
        if (r1 != r4) goto L_0x00a6
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendOpenRankListReq(r10, r0)
        return r10
    L_0x00a6:
        int r1 = r10.getType()
        r4 = 12
        if (r1 != r4) goto L_0x00b5
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendOpenWebview(r10, r0)
        return r10
    L_0x00b5:
        int r1 = r10.getType()
        r4 = 25
        if (r1 != r4) goto L_0x00c4
        android.content.Context r0 = r9.context
        boolean r10 = r9.sendOpenBusinessWebview(r0, r10)
        return r10
    L_0x00c4:
        int r1 = r10.getType()
        r4 = 13
        if (r1 != r4) goto L_0x00d3
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendOpenBusiLuckyMoney(r10, r0)
        return r10
    L_0x00d3:
        int r1 = r10.getType()
        r4 = 14
        if (r1 != r4) goto L_0x00e2
        android.content.Context r10 = r9.context
        boolean r10 = r9.createChatroom(r10, r0)
        return r10
    L_0x00e2:
        int r1 = r10.getType()
        r4 = 15
        if (r1 != r4) goto L_0x00f1
        android.content.Context r10 = r9.context
        boolean r10 = r9.joinChatroom(r10, r0)
        return r10
    L_0x00f1:
        int r1 = r10.getType()
        r4 = 17
        if (r1 != r4) goto L_0x0100
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendHandleScanResult(r10, r0)
        return r10
    L_0x0100:
        int r1 = r10.getType()
        r4 = 18
        if (r1 != r4) goto L_0x010f
        android.content.Context r0 = r9.context
        boolean r10 = r9.sendSubscribeMessage(r0, r10)
        return r10
    L_0x010f:
        int r1 = r10.getType()
        r4 = 23
        if (r1 != r4) goto L_0x011e
        android.content.Context r0 = r9.context
        boolean r10 = r9.sendSubscribeMiniProgramMsg(r0, r10)
        return r10
    L_0x011e:
        int r1 = r10.getType()
        r4 = 19
        if (r1 != r4) goto L_0x012d
        android.content.Context r0 = r9.context
        boolean r10 = r9.sendLaunchWXMiniprogram(r0, r10)
        return r10
    L_0x012d:
        int r1 = r10.getType()
        r4 = 26
        if (r1 != r4) goto L_0x013c
        android.content.Context r0 = r9.context
        boolean r10 = r9.sendOpenBusinessView(r0, r10)
        return r10
    L_0x013c:
        int r1 = r10.getType()
        r4 = 20
        if (r1 != r4) goto L_0x014b
        android.content.Context r0 = r9.context
        boolean r10 = r9.sendInvoiceAuthInsert(r0, r10)
        return r10
    L_0x014b:
        int r1 = r10.getType()
        r4 = 21
        if (r1 != r4) goto L_0x015a
        android.content.Context r0 = r9.context
        boolean r10 = r9.sendNonTaxPay(r0, r10)
        return r10
    L_0x015a:
        int r1 = r10.getType()
        r4 = 22
        if (r1 != r4) goto L_0x0169
        android.content.Context r0 = r9.context
        boolean r10 = r9.sendPayInSurance(r0, r10)
        return r10
    L_0x0169:
        int r1 = r10.getType()
        r4 = 24
        if (r1 != r4) goto L_0x0178
        android.content.Context r10 = r9.context
        boolean r10 = r9.sendJumpToOfflinePayReq(r10, r0)
        return r10
    L_0x0178:
        int r1 = r10.getType()
        r4 = 2
        if (r1 != r4) goto L_0x021a
        java.lang.String r1 = "_wxapi_sendmessagetowx_req_media_type"
        int r1 = r0.getInt(r1)
        boolean r4 = com.tencent.p607mm.opensdk.utils.C7339d.m31635a(r1)
        if (r4 == 0) goto L_0x021a
        r4 = r10
        com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req r4 = (com.tencent.p607mm.opensdk.modelmsg.SendMessageToWX.Req) r4
        int r5 = r9.getWXAppSupportAPI()
        r6 = 620756993(0x25000001, float:1.1102232E-16)
        java.lang.String r7 = "_wxminiprogram_webpageurl"
        if (r5 >= r6) goto L_0x01a9
        com.tencent.mm.opensdk.modelmsg.WXWebpageObject r1 = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject
        r1.m53061init()
    L_0x019e:
        java.lang.String r5 = r0.getString(r7)
        r1.webpageUrl = r5
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage r5 = r4.message
        r5.mediaObject = r1
        goto L_0x0210
    L_0x01a9:
        r5 = 46
        if (r1 != r5) goto L_0x01bc
        int r1 = r9.getWXAppSupportAPI()
        r5 = 620953856(0x25030100, float:1.1362778E-16)
        if (r1 >= r5) goto L_0x01bc
        com.tencent.mm.opensdk.modelmsg.WXWebpageObject r1 = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject
        r1.m53061init()
        goto L_0x019e
    L_0x01bc:
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage r1 = r4.message
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage$IMediaObject r1 = r1.mediaObject
        com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject r1 = (com.tencent.p607mm.opensdk.modelmsg.WXMiniProgramObject) r1
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r6 = r1.userName
        r5.append(r6)
        java.lang.String r6 = "@app"
        r5.append(r6)
        java.lang.String r5 = r5.toString()
        r1.userName = r5
        java.lang.String r5 = r1.path
        boolean r6 = com.tencent.p607mm.opensdk.utils.C7339d.m31636b(r5)
        if (r6 != 0) goto L_0x0210
        java.lang.String r6 = "\\?"
        java.lang.String[] r5 = r5.split(r6)
        int r6 = r5.length
        r7 = 1
        if (r6 <= r7) goto L_0x01fb
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        r8 = r5[r3]
        r6.append(r8)
        java.lang.String r8 = ".html?"
        r6.append(r8)
        r5 = r5[r7]
        goto L_0x0207
    L_0x01fb:
        java.lang.StringBuilder r6 = new java.lang.StringBuilder
        r6.<init>()
        r5 = r5[r3]
        r6.append(r5)
        java.lang.String r5 = ".html"
    L_0x0207:
        r6.append(r5)
        java.lang.String r5 = r6.toString()
        r1.path = r5
    L_0x0210:
        int r1 = r4.scene
        r5 = 3
        if (r1 == r5) goto L_0x0217
        r4.scene = r3
    L_0x0217:
        r10.toBundle(r0)
    L_0x021a:
        android.content.Context r10 = r9.context
        java.lang.String r10 = r9.getTokenFromWX(r10)
        com.tencent.mm.opensdk.channel.MMessageActV2$Args r1 = new com.tencent.mm.opensdk.channel.MMessageActV2$Args
        r1.m52912init()
        r1.bundle = r0
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        java.lang.String r3 = "weixin://sendreq?appid="
        r0.<init>(r3)
        java.lang.String r3 = r9.appId
        r0.append(r3)
        java.lang.String r0 = r0.toString()
        r1.content = r0
        r1.targetPkgName = r2
        java.lang.String r0 = "com.tencent.mm.plugin.base.stub.WXEntryActivity"
        r1.targetClassName = r0
        r1.token = r10
        android.content.Context r10 = r9.context
        boolean r10 = com.tencent.p607mm.opensdk.channel.MMessageActV2.send(r10, r1)
        return r10
    L_0x0248:
        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
        java.lang.String r0 = "sendReq fail, WXMsgImpl has been detached"
        r10.<init>(r0)
        throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p607mm.opensdk.openapi.BaseWXApiImplV10.sendReq(com.tencent.mm.opensdk.modelbase.BaseReq):boolean");
    }

    public boolean sendResp(BaseResp baseResp) {
        String str;
        if (!this.detached) {
            String str2 = "com.tencent.mm";
            boolean validateAppSignatureForPackage = WXApiImplComm.validateAppSignatureForPackage(this.context, str2, this.checkSignature);
            String str3 = TAG;
            if (!validateAppSignatureForPackage) {
                str = "sendResp failed for wechat app signature check failed";
            } else if (!baseResp.checkArgs()) {
                str = "sendResp checkArgs fail";
            } else {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                Args args = new Args();
                args.bundle = bundle;
                StringBuilder sb = new StringBuilder("weixin://sendresp?appid=");
                sb.append(this.appId);
                args.content = sb.toString();
                args.targetPkgName = str2;
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return MMessageActV2.send(this.context, args);
            }
            Log.m31627e(str3, str);
            return false;
        }
        throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    }

    public void setLogImpl(ILog iLog) {
        Log.setLogImpl(iLog);
    }

    public void unregisterApp() {
        if (!this.detached) {
            String str = "com.tencent.mm";
            boolean validateAppSignatureForPackage = WXApiImplComm.validateAppSignatureForPackage(this.context, str, this.checkSignature);
            String str2 = TAG;
            if (!validateAppSignatureForPackage) {
                Log.m31627e(str2, "unregister app failed for wechat app signature check failed");
                return;
            }
            StringBuilder sb = new StringBuilder("unregisterApp, appId = ");
            sb.append(this.appId);
            Log.m31626d(str2, sb.toString());
            String str3 = this.appId;
            if (str3 == null || str3.length() == 0) {
                Log.m31627e(str2, "unregisterApp fail, appId is empty");
                return;
            }
            StringBuilder sb2 = new StringBuilder("unregister app ");
            sb2.append(this.context.getPackageName());
            Log.m31626d(str2, sb2.toString());
            C7323a aVar = new C7323a();
            aVar.f24796a = str;
            aVar.action = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
            StringBuilder sb3 = new StringBuilder("weixin://unregisterapp?appid=");
            sb3.append(this.appId);
            aVar.content = sb3.toString();
            C7322a.m31612a(this.context, aVar);
            return;
        }
        throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
    }
}
