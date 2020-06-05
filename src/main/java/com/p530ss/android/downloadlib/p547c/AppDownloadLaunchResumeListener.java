package com.p530ss.android.downloadlib.p547c;

import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadLaunchResumeListener;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.c.a */
public class AppDownloadLaunchResumeListener implements IAppDownloadLaunchResumeListener {
    /* renamed from: a */
    public void mo31367a(List<DownloadInfo> list) {
    }

    /* renamed from: a */
    public void mo31366a(DownloadInfo cVar, boolean z) {
        if (cVar != null && DownloadSetting.m28610a(cVar.mo32283g()).mo32547a("report_download_uncompleted_event", 0) != 0) {
            mo31365a(cVar, cVar.mo32315w(), z);
        }
    }

    /* renamed from: a */
    public void mo31365a(DownloadInfo cVar, int i, boolean z) {
        ModelManager.m26169a().mo31272b();
        NativeDownloadModel a = ModelManager.m26169a().mo31263a(cVar);
        if (a == null) {
            C6587g.m26532b();
            return;
        }
        JSONObject a2 = NativeDownloadModel.m26067a(a);
        try {
            a2.put("download_id", cVar.mo32283g());
            a2.put(ArgKey.KEY_NAME, cVar.mo32287h());
            a2.put("url", cVar.mo32295j());
            a2.put("download_time", cVar.mo32246aw());
            a2.put("download_status", i);
            a2.put("cur_bytes", cVar.mo32180Z());
            a2.put("total_bytes", cVar.mo32225ab());
            int i2 = 1;
            a2.put("only_wifi", cVar.mo32317x() ? 1 : 0);
            a2.put("chunk_count", cVar.mo32219aV());
            String str = "launch_resumed";
            if (!z) {
                i2 = 0;
            }
            a2.put(str, i2);
            a2.put("failed_resume_count", cVar.mo32223aZ());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdEventHandler.m26446a().mo31403a("embeded_ad", "download_uncompleted", a2, a);
    }
}
