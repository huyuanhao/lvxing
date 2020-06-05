package com.tencent.android.tpush.stat;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.util.Properties;

/* compiled from: ProGuard */
public class XGPatchMonitor {
    public static final String ActionDownloadFile = "downFile";
    public static final String ActionLoadConfig = "loadConf";
    public static final String ActionParseConfig = "parseConf";
    public static final String ActionParsePatch = "parsePatch";
    public static final String ActionReadyPatch = "readyPatch";
    public static final String ActionRequestConfig = "reqConf";
    public static final String ActionRequestFile = "reqFile";
    public static final String ActionVerifyFile = "verifyFile";
    public static final String ActionVerifyPatch = "verifyPatch";
    public static final String TypeHauwei = "ptHW";
    public static final String TypeMID = "ptMID";
    public static final String TypeMTA = "ptMTA";
    public static final String TypeMeizu = "ptMZ";
    public static final String TypeTryDyLoad = "ptTry";
    public static final String TypeXG = "ptXG";
    public static final String TypeXiaoMi = "ptXM";

    public static void onConfigAction(Context context, long j, String str, String str2, int i, String str3, Properties properties) {
        Properties properties2;
        if (context != null) {
            C7084e.m30402b(context);
            if (properties != null) {
                properties2 = new Properties(properties);
            } else {
                properties2 = new Properties();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            properties2.setProperty("rc", sb.toString());
            if (str3 != null && !str3.isEmpty()) {
                properties2.setProperty(NotificationCompat.CATEGORY_MESSAGE, str3);
            }
            properties2.setProperty("type", str);
            C7084e.m30393a(context, str2, properties2, j);
        }
    }
}
