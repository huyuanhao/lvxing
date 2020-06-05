package com.p530ss.android.downloadlib.p541a.p544c;

import android.os.Environment;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p569m.DownloadUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.c.b */
public class CleanSpaceTask implements Runnable {
    /* renamed from: a */
    private DownloadInfo f21336a;

    public CleanSpaceTask(DownloadInfo cVar) {
        this.f21336a = cVar;
    }

    public void run() {
        if (this.f21336a != null) {
            NativeDownloadModel a = ModelManager.m26169a().mo31263a(this.f21336a);
            if (a != null) {
                AdEventHandler.m26446a().mo31400a("cleanspace_task", a);
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                long longValue = Double.valueOf((C6565j.m26385s() + 1.0d) * ((double) this.f21336a.mo32225ab())).longValue();
                if (C6565j.m26378l() != null) {
                    C6565j.m26378l().mo31037c();
                }
                ClearSpaceUtil.m26209a();
                ClearSpaceUtil.m26211b();
                long j = 0;
                try {
                    j = DownloadUtils.m28796c(externalStorageDirectory.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (j >= longValue) {
                    DownloadOptimizationManager.m26212a().mo31295b().put((long) this.f21336a.mo32283g(), "1");
                    AdEventHandler.m26446a().mo31400a("cleanspace_download_after_quite_clean", a);
                    Downloader.m27478a(C6565j.m26357a()).mo31925e(this.f21336a.mo32283g());
                    DownloadOptimizationManager.m26212a().mo31293a(this.f21336a.mo32295j());
                } else {
                    String str = "cleanspace_window_show";
                    String str2 = "show_dialog_result";
                    if (C6565j.m26378l() == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt(str2, Integer.valueOf(3));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        AdEventHandler.m26446a().mo31404a(str, jSONObject, a);
                    } else if (!C6565j.m26378l().mo31036b()) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.putOpt(str2, Integer.valueOf(4));
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        AdEventHandler.m26446a().mo31404a(str, jSONObject2, a);
                    } else if (C6565j.m26378l().mo31035a()) {
                        C6565j.m26378l().mo31033a(this.f21336a.mo32283g(), this.f21336a.mo32295j(), longValue);
                        AdEventHandler.m26446a().mo31400a("cleanspace_need_user_clean", a);
                    }
                }
            }
        }
    }
}
