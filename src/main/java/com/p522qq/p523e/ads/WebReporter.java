package com.p522qq.p523e.ads;

import android.content.Context;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.managers.plugin.C6422c;
import com.p522qq.p523e.comm.p525pi.WRI;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.WebReporter */
public class WebReporter {
    /* renamed from: a */
    private WRI f19922a;

    public WebReporter(Context context, String str, String str2, long j) {
        String str3;
        if (StringUtil.isEmpty(str)) {
            str3 = "init web reporter fail with error params";
        } else {
            try {
                if (!GDTADManager.getInstance().initWith(context, str)) {
                    GDTLogger.m25260e("SDK is not ready!");
                    return;
                } else {
                    this.f19922a = GDTADManager.getInstance().getPM().getPOFactory().getWebReporterDelegate(str2, j);
                    return;
                }
            } catch (C6422c unused) {
                str3 = "Web reporter created by factory return null";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        GDTLogger.m25260e(str3);
    }

    public void report(String str, int i) {
        WRI wri = this.f19922a;
        if (wri != null) {
            wri.report(str, i);
        }
    }
}
