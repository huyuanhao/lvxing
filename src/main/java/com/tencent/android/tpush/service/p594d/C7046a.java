package com.tencent.android.tpush.service.p594d;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.protocol.TpnsClickClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsPushMsg;
import com.tencent.android.tpush.stat.C7070b;
import com.tencent.android.tpush.stat.C7084e;
import com.tencent.android.tpush.stat.StatReportStrategy;
import com.tencent.android.tpush.stat.event.C7098a;
import com.tencent.android.tpush.stat.event.C7100b;
import com.tencent.android.tpush.stat.event.C7101c;
import com.tencent.bigdata.dataacquisition.CustomDeviceInfos;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.Properties;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.d.a */
public class C7046a {
    /* renamed from: a */
    private static Context f23425a;

    /* renamed from: a */
    public static void m30121a(Context context) {
        C7070b.m30303b(true);
        C7070b.m30299a(StatReportStrategy.INSTANT);
        C7084e.m30402b(context);
        C7084e.m30416e(context);
        f23425a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static void m30120a() {
        C7084e.m30388a(f23425a, -1);
    }

    /* renamed from: a */
    public static void m30127a(ArrayList<TpnsPushMsg> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                C7084e.m30395a(f23425a, arrayList);
            } catch (Throwable th) {
                C6864a.m29302d("XgStat", "reportSrvAck", th);
            }
        }
    }

    /* renamed from: a */
    public static void m30126a(Intent intent) {
        Intent intent2 = intent;
        String str = MessageKey.MSG_ID;
        String str2 = MessageKey.MSG_BUSI_MSG_ID;
        String str3 = "type";
        String str4 = "";
        if (intent2 != null) {
            try {
                long longExtra = intent2.getLongExtra(str3, 0);
                long longExtra2 = intent2.getLongExtra(str2, 0);
                long longExtra3 = intent2.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, 0);
                long longExtra4 = intent2.getLongExtra(str, 0);
                long longExtra5 = intent2.getLongExtra("accId", 0);
                Properties properties = new Properties();
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append(longExtra);
                properties.setProperty(str3, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(longExtra2);
                properties.setProperty(str2, sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str4);
                sb3.append(longExtra4);
                properties.setProperty(str, sb3.toString());
                C7084e.m30394a(f23425a, "SdkAck", properties, longExtra5, longExtra3);
            } catch (Throwable th) {
                C6864a.m29302d("XgStat", "reportSDKAck", th);
            }
        }
    }

    /* renamed from: a */
    public static void m30125a(Context context, String str, JSONObject jSONObject) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Axg");
            sb.append(XGPushConfig.getAccessId(context));
            C7098a aVar = new C7098a(context, str, jSONObject, sb.toString(), true);
            m30124a(context, (C7100b) aVar);
        } catch (Throwable th) {
            C6864a.m29302d("XgStat", "reportXGStat ", th);
        }
    }

    /* renamed from: b */
    public static void m30130b(Context context, String str, JSONObject jSONObject) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Axg");
            sb.append(XGPushConfig.getAccessId(context));
            C7101c cVar = new C7101c(context, str, jSONObject, sb.toString(), true);
            m30124a(context, (C7100b) cVar);
        } catch (Throwable th) {
            C6864a.m29302d("XgStat", "reportXGLBS ", th);
        }
    }

    /* renamed from: a */
    public static void m30124a(Context context, C7100b bVar) {
        C7084e.m30390a(context, bVar);
    }

    /* renamed from: b */
    public static void m30131b(ArrayList<TpnsPushClientReport> arrayList) {
        String str = "XgStat";
        if (arrayList == null || arrayList.size() == 0) {
            C6864a.m29308i(str, "ServiceStat reportAck 15 with null list ");
            return;
        }
        try {
            C7084e.m30405b(f23425a, arrayList);
        } catch (Throwable th) {
            C6864a.m29302d(str, "reportAck", th);
        }
    }

    /* renamed from: c */
    public static void m30133c(ArrayList<TpnsClickClientReport> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                C7084e.m30410c(f23425a, arrayList);
            } catch (Throwable th) {
                C6864a.m29302d("XgStat", "reportNotifactionClickedOrClear", th);
            }
        }
    }

    /* renamed from: a */
    private static void m30123a(Context context, Intent intent, String str) {
        Intent intent2 = intent;
        String str2 = "action";
        String str3 = MessageKey.MSG_BUSI_MSG_ID;
        String str4 = "type";
        String str5 = MessageKey.MSG_ID;
        String str6 = "";
        if (intent2 != null && !C6914l.m29521c(str)) {
            try {
                long longExtra = intent2.getLongExtra(str5, 0);
                if (longExtra >= 0) {
                    long longExtra2 = intent2.getLongExtra(str4, 1);
                    long longExtra3 = intent2.getLongExtra(str3, 0);
                    long longExtra4 = intent2.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, 0);
                    long longExtra5 = intent2.getLongExtra("accId", 0);
                    Properties properties = new Properties();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str6);
                    sb.append(longExtra2);
                    properties.setProperty(str4, sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str6);
                    sb2.append(longExtra3);
                    properties.setProperty(str3, sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str6);
                    sb3.append(longExtra);
                    properties.setProperty(str5, sb3.toString());
                    if (str.equals("Action")) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str6);
                        sb4.append(intent2.getIntExtra(str2, NotificationAction.clicked.getType()));
                        properties.put(str2, sb4.toString());
                    }
                    C7084e.m30394a(context.getApplicationContext(), str, properties, longExtra5, longExtra4);
                }
            } catch (Throwable th) {
                C6864a.m29302d("XgStat", "reportSDKAck", th);
            }
        }
    }

    /* renamed from: a */
    public static void m30122a(Context context, Intent intent) {
        m30123a(context, intent, "OtherPull");
    }

    /* renamed from: b */
    public static void m30129b(Context context, Intent intent) {
        m30123a(context, intent, "SdkAck");
    }

    /* renamed from: c */
    public static void m30132c(Context context, Intent intent) {
        m30123a(context, intent, "Verify");
    }

    /* renamed from: d */
    public static void m30134d(Context context, Intent intent) {
        m30123a(context, intent, "SHOW");
    }

    /* renamed from: e */
    public static void m30135e(Context context, Intent intent) {
        m30123a(context, intent, "Action");
    }

    /* renamed from: b */
    public static void m30128b(Context context) {
        boolean isImportImplClass = CustomDeviceInfos.isImportImplClass();
        Properties properties = new Properties();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(isImportImplClass);
        properties.setProperty(ArgKey.KEY_VALUE, sb.toString());
        C7084e.m30393a(f23425a, "IsCustomDataVersion", properties, XGPushConfig.getAccessId(f23425a));
    }
}
