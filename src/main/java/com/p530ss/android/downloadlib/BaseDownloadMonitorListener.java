package com.p530ss.android.downloadlib;

import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.downloadlib.p541a.p543b.ModelManager;
import com.p530ss.android.downloadlib.p541a.p544c.CleanSpaceTask;
import com.p530ss.android.downloadlib.p541a.p544c.DownloadOptimizationManager;
import com.p530ss.android.downloadlib.p548d.AdEventHandler;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.socialbase.appdownloader.p552c.IAppDownloadMonitorListener;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;

/* renamed from: com.ss.android.downloadlib.c */
public class BaseDownloadMonitorListener implements IAppDownloadMonitorListener {
    /* renamed from: a */
    private static String f21410a = BaseDownloadMonitorListener.class.getSimpleName();

    /* renamed from: a */
    public void mo31357a(DownloadInfo cVar, BaseException aVar, int i) {
        if (cVar != null) {
            if (i == -1) {
                BaseException aVar2 = null;
                if (aVar != null) {
                    try {
                        if (C6587g.m26527a(aVar)) {
                            NativeDownloadModel a = ModelManager.m26169a().mo31263a(cVar);
                            if (a != null) {
                                if (C6565j.m26378l() != null) {
                                    C6565j.m26378l().mo31034a(a.mo31194a());
                                }
                                AdEventHandler.m26446a().mo31400a("download_failed_for_space", a);
                                if (DownloadOptimizationManager.m26212a().mo31297c(cVar.mo32295j())) {
                                    AdEventHandler.m26446a().mo31400a("download_can_restart", a);
                                    m26411a(cVar, a);
                                }
                            }
                        }
                        aVar2 = new BaseException(aVar.mo32073a(), C6587g.m26513a(aVar.getMessage(), C6565j.m26375i().optInt("exception_msg_length", 500)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                AdEventHandler.m26446a().mo31395a(cVar, aVar2);
                DownloadDispatcherImpl.m26547a().mo31421a(cVar, aVar, "");
            } else if (i == -3) {
                AdDownloadCompletedEventHandlerImpl.m26114a(cVar, ModelManager.m26169a().mo31263a(cVar));
            }
        }
    }

    /* renamed from: a */
    private void m26411a(DownloadInfo cVar, NativeDownloadModel aVar) {
        if (DownloadSetting.m28610a(cVar.mo32283g()).mo32547a("exec_clear_space_switch", 0) == 1) {
            AdEventHandler.m26446a().mo31400a("cleanspace_switch_open", aVar);
            DownloadComponentManager.m26440a().mo31386a(new CleanSpaceTask(cVar));
        }
    }
}
