package com.p530ss.android.downloadlib.p541a;

import android.content.Intent;
import android.text.TextUtils;
import com.p530ss.android.downloadad.p538a.p539a.AdDownloadModel;
import com.p530ss.android.p531a.p532a.p534b.C6507c;
import com.p530ss.android.socialbase.appdownloader.AntiHijackAttempt;
import com.p530ss.android.socialbase.appdownloader.AppDownloader;
import com.p530ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.p530ss.android.socialbase.appdownloader.C6604b;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.i */
public class DownloadInsideHelper {
    /* renamed from: a */
    static boolean m26352a(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: b */
    static boolean m26355b(int i) {
        return i == 2 || i == 1;
    }

    /* renamed from: c */
    static boolean m26356c(int i) {
        return i == 2;
    }

    /* renamed from: a */
    static boolean m26353a(C6507c cVar) {
        return cVar.mo31078r() && (cVar instanceof AdDownloadModel) && cVar.mo31084x() == 1;
    }

    /* renamed from: a */
    public static int m26351a(C6507c cVar, boolean z, AppTaskBuilder gVar) {
        if (gVar == null || TextUtils.isEmpty(gVar.mo31578c()) || gVar.mo31570b() == null) {
            return 0;
        }
        int a = AppDownloader.m26714h().mo31473a(gVar);
        DownloadSetting a2 = DownloadSetting.m28613a(gVar.mo31557U());
        if (!m26354a(gVar, a2) && cVar.mo31069i()) {
            String c = a2.mo32553c("download_start_toast_text");
            if (TextUtils.isEmpty(c)) {
                c = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            C6565j.m26370d().mo16487a(2, gVar.mo31570b(), cVar, c, null, 0);
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m26354a(AppTaskBuilder gVar, DownloadSetting aVar) {
        JSONObject jSONObject;
        if (aVar.mo32551b("show_unknown_source_on_startup")) {
            JSONArray e = aVar.mo32556e("anti_plans");
            int length = e.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    jSONObject = null;
                    break;
                }
                jSONObject = e.optJSONObject(i);
                if (jSONObject != null) {
                    if ("jump_unknown_source".equals(jSONObject.optString("type"))) {
                        break;
                    }
                }
                i++;
            }
            if (jSONObject != null) {
                return C6604b.m26615a(C6694b.m27342B(), (Intent) null, jSONObject, new AntiHijackAttempt());
            }
        }
        return false;
    }
}
