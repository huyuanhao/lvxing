package com.tencent.stat.hybrid;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.mid.util.Util;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import java.net.URLDecoder;
import org.json.JSONObject;

public class StatHybridHandler {
    public static final int HYBRID_VERSION = 1;
    public static final String MTA_HYBRID_UA_FLAG = " TencentMTA/1";
    /* renamed from: a */
    private static StatLogger f25828a = StatCommonHelper.getLogger();
    /* renamed from: b */
    private static StatSpecifyReportedInfo f25829b = null;
    /* renamed from: c */
    private static Context f25830c = null;
    /* renamed from: d */
    private static StatHybridBridge f25831d = new StatHybridBridge();

    public static void init(Context context) {
        f25829b = new StatSpecifyReportedInfo();
        f25829b.setAppKey(StatConfig.getAppKey(context));
        f25829b.setInstallChannel(StatConfig.getInstallChannel(context));
        f25829b.setFromH5(1);
    }

    public static void init(Context context, String str, String str2) {
        f25829b = new StatSpecifyReportedInfo();
        f25829b.setAppKey(str);
        f25829b.setInstallChannel(str2);
        f25829b.setFromH5(1);
    }

    public static StatSpecifyReportedInfo getH5reportInfo() {
        return f25829b;
    }

    public static Context getContext() {
        return f25830c;
    }

    public static void setH5reportInfo(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        f25829b = statSpecifyReportedInfo;
    }

    public static void initWebSettings(WebSettings webSettings) {
        if (webSettings != null) {
            String userAgentString = webSettings.getUserAgentString();
            StatLogger statLogger = f25828a;
            StringBuilder sb = new StringBuilder();
            sb.append("org ua:");
            sb.append(userAgentString);
            statLogger.mo37101d(sb.toString());
            if (!TextUtils.isEmpty(userAgentString)) {
                String str = MTA_HYBRID_UA_FLAG;
                if (!userAgentString.contains(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(userAgentString);
                    sb2.append(str);
                    webSettings.setUserAgentString(sb2.toString());
                    StatLogger statLogger2 = f25828a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("new ua:");
                    sb3.append(webSettings.getUserAgentString());
                    statLogger2.mo37101d(sb3.toString());
                }
            }
        }
    }

    public static boolean handleWebViewUrl(WebView webView, String str) {
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            if (webView != null && !Util.isEmpty(decode) && str.toLowerCase().startsWith("tencentMtaHyb:".toLowerCase())) {
                if (f25830c == null) {
                    f25830c = webView.getContext().getApplicationContext();
                }
                StatLogger statLogger = f25828a;
                StringBuilder sb = new StringBuilder();
                sb.append("decodedURL:");
                sb.append(decode);
                statLogger.mo37101d(sb.toString());
                m32878a(webView, decode.substring(14));
                return true;
            }
        } catch (Throwable th) {
            f25828a.mo37104e(th);
        }
        return false;
    }

    /* renamed from: a */
    private static void m32878a(WebView webView, String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("methodName");
        JSONObject jSONObject2 = jSONObject.getJSONObject("args");
        StatLogger statLogger = f25828a;
        StringBuilder sb = new StringBuilder();
        sb.append("invoke method:");
        sb.append(string);
        sb.append(",args:");
        sb.append(jSONObject2);
        statLogger.mo37101d(sb.toString());
        f25831d.getClass().getMethod(string, new Class[]{JSONObject.class}).invoke(f25831d, new Object[]{jSONObject2});
    }
}
