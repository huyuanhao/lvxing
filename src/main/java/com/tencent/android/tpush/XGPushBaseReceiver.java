package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.p581c.C6881g;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* compiled from: ProGuard */
public abstract class XGPushBaseReceiver extends BroadcastReceiver {
    public static final int SUCCESS = 0;
    /* renamed from: a */
    long f22710a = 0;

    public abstract void onDeleteTagResult(Context context, int i, String str);

    public abstract void onNotifactionClickedResult(Context context, XGPushClickedResult xGPushClickedResult);

    public abstract void onNotifactionShowedResult(Context context, XGPushShowedResult xGPushShowedResult);

    public abstract void onRegisterResult(Context context, int i, XGPushRegisterResult xGPushRegisterResult);

    public abstract void onSetTagResult(Context context, int i, String str);

    public abstract void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage);

    public abstract void onUnregisterResult(Context context, int i);

    public final void onReceive(Context context, Intent intent) {
        String str = Constants.PushMessageLogTag;
        if (!(context == null || intent == null)) {
            try {
                if (C6914l.m29505a(context) <= 0) {
                    String action = intent.getAction();
                    if (Constants.ACTION_PUSH_MESSAGE.equals(action)) {
                        m29218a(context, intent);
                    } else if (Constants.ACTION_FEEDBACK.equals(action)) {
                        m29219b(context, intent);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("未知的action:");
                        sb.append(action);
                        C6864a.m29308i(str, sb.toString());
                    }
                }
            } catch (Throwable th) {
                C6864a.m29302d(str, "onReceive handle error.", th);
            }
        }
    }

    /* renamed from: a */
    private void m29218a(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(Constants.PUSH_CHANNEL, 0);
        if (intExtra == 0) {
            C6881g a = C6881g.m29385a(context, intent);
            if (a.mo33057g().mo32998c() == 2) {
                XGPushTextMessage xGPushTextMessage = new XGPushTextMessage();
                xGPushTextMessage.title = a.mo33057g().mo33000e();
                xGPushTextMessage.content = a.mo33057g().mo33001f();
                xGPushTextMessage.customContent = a.mo33057g().mo33002g();
                xGPushTextMessage.setSimpleIntent(intent);
                onTextMessage(context, xGPushTextMessage);
                return;
            }
            return;
        }
        XGPushTextMessage xGPushTextMessage2 = new XGPushTextMessage();
        xGPushTextMessage2.pushChannel = intExtra;
        xGPushTextMessage2.content = intent.getStringExtra(MessageKey.MSG_CONTENT);
        xGPushTextMessage2.title = intent.getStringExtra("title");
        xGPushTextMessage2.customContent = intent.getStringExtra("custom_content");
        intent.putExtra("accId", XGPushConfig.getAccessId(context));
        m29220c(context, intent);
        onTextMessage(context, xGPushTextMessage2);
    }

    /* renamed from: b */
    private void m29219b(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(Constants.FEEDBACK_TAG, -1);
        int intExtra2 = intent.getIntExtra(Constants.FEEDBACK_ERROR_CODE, -1);
        String str = Constants.PUSH_CHANNEL;
        if (intExtra == 1) {
            XGPushRegisterResult xGPushRegisterResult = new XGPushRegisterResult();
            if (!intent.getBooleanExtra(Constants.FLAG_REGISTER_FROM_CLOUDCTRL, false)) {
                if (intent.getIntExtra(str, 0) == 0) {
                    xGPushRegisterResult.parseIntent(intent);
                    m29217a(context, intExtra2, xGPushRegisterResult, "SdkRegister");
                } else {
                    xGPushRegisterResult.f22814h = intent.getIntExtra(str, 0);
                    xGPushRegisterResult.f22813g = intent.getStringExtra(Constants.OTHER_PUSH_TOKEN);
                }
                onRegisterResult(context, intExtra2, xGPushRegisterResult);
            }
        } else if (intExtra != 2) {
            String str2 = Constants.PushMessageLogTag;
            if (intExtra != 3) {
                String str3 = "custom_content";
                String str4 = "title";
                String str5 = MessageKey.MSG_CONTENT;
                String str6 = "accId";
                if (intExtra == 4) {
                    String str7 = "action";
                    intent.getIntExtra(str7, NotificationAction.delete.getType());
                    long longExtra = intent.getLongExtra(str6, 0);
                    List accessidList = XGPushConfig.getAccessidList(context);
                    if (accessidList == null || accessidList.size() <= 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("accessIdList ");
                        sb.append(accessidList);
                        sb.append(" local accessid ");
                        sb.append(longExtra);
                        String str8 = "XGPushBaseReceiver";
                        C6864a.m29308i(str8, sb.toString());
                        C6864a.m29308i(str8, "give up msg");
                    } else if (accessidList.contains(Long.valueOf(longExtra))) {
                        XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
                        xGPushClickedResult.parseIntent(intent);
                        onNotifactionClickedResult(context, xGPushClickedResult);
                    }
                    if (intent.getIntExtra(str, 0) != 0) {
                        XGPushClickedResult xGPushClickedResult2 = new XGPushClickedResult();
                        xGPushClickedResult2.content = intent.getStringExtra(str5);
                        xGPushClickedResult2.title = intent.getStringExtra(str4);
                        xGPushClickedResult2.customContent = intent.getStringExtra(str3);
                        xGPushClickedResult2.pushChannel = intent.getIntExtra(str, 0);
                        xGPushClickedResult2.actionType = intent.getIntExtra(str7, 0);
                        intent.putExtra(str6, XGPushConfig.getAccessId(context));
                        Intent intent2 = new Intent("com.tencent.android.tpush.action.PUSH_CLICK.RESULT.V4");
                        intent2.putExtras(intent);
                        context.sendBroadcast(intent2);
                        onNotifactionClickedResult(context, xGPushClickedResult2);
                    }
                } else if (intExtra != 5) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("未知的feedbackType:");
                    sb2.append(intExtra);
                    C6864a.m29308i(str2, sb2.toString());
                } else {
                    XGPushShowedResult xGPushShowedResult = new XGPushShowedResult();
                    if (intent.getIntExtra(str, 0) == 0) {
                        xGPushShowedResult.parseIntent(intent);
                    } else {
                        xGPushShowedResult.f22817c = intent.getStringExtra(str5);
                        xGPushShowedResult.f22816b = intent.getStringExtra(str4);
                        xGPushShowedResult.f22818d = intent.getStringExtra(str3);
                        xGPushShowedResult.f22822h = intent.getIntExtra(str, 0);
                        intent.putExtra(str6, XGPushConfig.getAccessId(context));
                        m29220c(context, intent);
                    }
                    onNotifactionShowedResult(context, xGPushShowedResult);
                }
            } else {
                String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_TAG_NAME));
                if (!C7056i.m30194b(decrypt)) {
                    int intExtra3 = intent.getIntExtra(Constants.FLAG_TAG_TYPE, -1);
                    String stringExtra = intent.getStringExtra(Constants.FLAG_TAG_OPER_NAME);
                    if (intExtra3 == 1 || intExtra3 == 6 || intExtra3 == 5) {
                        onSetTagResult(context, intExtra2, stringExtra);
                    } else if (intExtra3 == 2 || intExtra3 == 7 || intExtra3 == 8) {
                        onDeleteTagResult(context, intExtra2, stringExtra);
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("错误的标签处理类型：");
                        sb3.append(intExtra3);
                        sb3.append(" ,标签名：");
                        sb3.append(decrypt);
                        C6864a.m29308i(str2, sb3.toString());
                    }
                }
            }
        } else {
            XGPushRegisterResult xGPushRegisterResult2 = new XGPushRegisterResult();
            xGPushRegisterResult2.parseIntent(intent);
            m29217a(context, intExtra2, xGPushRegisterResult2, "SdkUnRegister");
            onUnregisterResult(context, intExtra2);
        }
    }

    /* renamed from: c */
    private void m29220c(Context context, Intent intent) {
        MessageId messageId = new MessageId();
        messageId.f23015id = intent.getLongExtra(MessageKey.MSG_ID, 0);
        messageId.isAck = 0;
        messageId.accessId = intent.getLongExtra("accId", 0);
        messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, 0);
        messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, 0);
        messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, 0);
        messageId.apn = DeviceInfos.getNetworkType(context);
        messageId.isp = C7056i.m30217k(context);
        String str = MessageKey.MSG_CREATE_TIMESTAMPS;
        messageId.pushTime = intent.getLongExtra(str, 0);
        messageId.serviceHost = intent.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
        messageId.receivedTime = intent.getLongExtra(str, 0);
        messageId.pkgName = context.getPackageName();
        messageId.busiMsgId = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, 0);
        messageId.timestamp = intent.getLongExtra(str, 0);
        messageId.msgType = intent.getLongExtra("type", 0);
        messageId.multiPkg = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, 0);
        messageId.date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        intent.putExtra("MessageId", messageId);
        Intent intent2 = new Intent("com.tencent.android.tpush.action.MSG_ACK.V4");
        intent2.putExtras(intent);
        context.sendBroadcast(intent2);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0071 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A[Catch:{ Exception -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac  */
    /* renamed from: a */
    private void m29217a(android.content.Context r12, int r13, com.tencent.android.tpush.XGPushRegisterResult r14, java.lang.String r15) {
        /*
        r11 = this;
        java.lang.String r0 = "details"
        short r1 = r14.f22811e
        r2 = 4
        int r1 = r1 >> r2
        if (r1 <= 0) goto L_0x000b
        if (r1 > r2) goto L_0x000b
        return
    L_0x000b:
        org.json.JSONObject r1 = new org.json.JSONObject
        r1.<init>()
        java.lang.String r2 = ""
        java.lang.String r3 = "register_json"
        java.lang.String r4 = com.tencent.android.tpush.service.p595e.C7055h.m30169a(r12, r3, r2)
        boolean r5 = com.tencent.android.tpush.service.p595e.C7056i.m30194b(r4)
        if (r5 != 0) goto L_0x003c
        org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0025 }
        r5.<init>(r4)     // Catch:{ all -> 0x0025 }
        r1 = r5
        goto L_0x003c
    L_0x0025:
        r4 = move-exception
        java.lang.StringBuilder r5 = new java.lang.StringBuilder
        r5.<init>()
        java.lang.String r6 = "JSONObject"
        r5.append(r6)
        r5.append(r4)
        java.lang.String r4 = r5.toString()
        java.lang.String r5 = "XGPushMessage"
        com.tencent.android.tpush.p580b.C6864a.m29308i(r5, r4)
    L_0x003c:
        r4 = 0
        java.lang.String r5 = "suc_cnt"
        int r6 = r1.optInt(r5, r4)
        java.lang.String r7 = "failed_cnt"
        int r4 = r1.optInt(r7, r4)
        if (r13 != 0) goto L_0x004e
        int r6 = r6 + 1
        goto L_0x0050
    L_0x004e:
        int r4 = r4 + 1
    L_0x0050:
        r1.put(r5, r6)     // Catch:{ JSONException -> 0x0057 }
        r1.put(r7, r4)     // Catch:{ JSONException -> 0x0057 }
        goto L_0x0058
    L_0x0058:
        org.json.JSONObject r5 = new org.json.JSONObject
        r5.<init>()
        if (r14 == 0) goto L_0x0063
        org.json.JSONObject r5 = r14.toJson()
    L_0x0063:
        java.lang.String r14 = "errorCode"
        r5.put(r14, r13)     // Catch:{ Exception -> 0x0071 }
        java.lang.String r13 = "np"
        byte r14 = com.tencent.bigdata.dataacquisition.DeviceInfos.getNetworkType(r12)     // Catch:{ Exception -> 0x0071 }
        r5.put(r13, r14)     // Catch:{ Exception -> 0x0071 }
    L_0x0071:
        org.json.JSONArray r13 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x0083 }
        if (r13 != 0) goto L_0x007c
        org.json.JSONArray r13 = new org.json.JSONArray     // Catch:{ Exception -> 0x0083 }
        r13.<init>()     // Catch:{ Exception -> 0x0083 }
    L_0x007c:
        r13.put(r5)     // Catch:{ Exception -> 0x0083 }
        r1.put(r0, r13)     // Catch:{ Exception -> 0x0083 }
        goto L_0x0084
    L_0x0084:
        java.lang.StringBuilder r13 = new java.lang.StringBuilder
        r13.<init>()
        java.lang.String r14 = "new reprot js"
        r13.append(r14)
        java.lang.String r14 = r1.toString()
        r13.append(r14)
        java.lang.String r13 = r13.toString()
        java.lang.String r14 = "SdkStat"
        com.tencent.android.tpush.p580b.C6864a.m29303e(r14, r13)
        long r13 = java.lang.System.currentTimeMillis()
        long r7 = r11.f22710a
        java.lang.String r0 = "register_last_report"
        r9 = 0
        int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
        if (r5 != 0) goto L_0x00bf
        long r7 = com.tencent.android.tpush.service.p595e.C7055h.m30167a(r12, r0, r9)
        r11.f22710a = r7
        long r7 = r11.f22710a
        int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
        if (r5 != 0) goto L_0x00bf
        r11.f22710a = r13
        long r7 = r11.f22710a
        com.tencent.android.tpush.service.p595e.C7055h.m30171b(r12, r0, r7)
    L_0x00bf:
        int r6 = r6 + r4
        r4 = 10
        if (r6 >= r4) goto L_0x00d8
        long r4 = r11.f22710a
        long r4 = r13 - r4
        r6 = 43200000(0x2932e00, double:2.1343636E-316)
        int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        if (r8 < 0) goto L_0x00d0
        goto L_0x00d8
    L_0x00d0:
        java.lang.String r13 = r1.toString()
        com.tencent.android.tpush.service.p595e.C7055h.m30172b(r12, r3, r13)
        goto L_0x00e5
    L_0x00d8:
        com.tencent.android.tpush.service.p594d.C7046a.m30125a(r12, r15, r1)
        com.tencent.android.tpush.service.p595e.C7055h.m30172b(r12, r3, r2)
        r11.f22710a = r13
        long r13 = r11.f22710a
        com.tencent.android.tpush.service.p595e.C7055h.m30171b(r12, r0, r13)
    L_0x00e5:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushBaseReceiver.m29217a(android.content.Context, int, com.tencent.android.tpush.XGPushRegisterResult, java.lang.String):void");
    }
}
