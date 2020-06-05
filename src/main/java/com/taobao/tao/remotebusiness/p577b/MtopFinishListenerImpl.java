package com.taobao.tao.remotebusiness.p577b;

import android.os.Looper;
import com.taobao.tao.remotebusiness.IRemoteParserListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.p576a.HandlerMgr;
import com.taobao.tao.remotebusiness.p576a.HandlerParam;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.TBSdkLog.LogEnable;
import mtopsdk.mtop.common.MtopCallback.C8333b;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.mtop.util.MtopStatistics.C8336a;

/* renamed from: com.taobao.tao.remotebusiness.b.d */
final class MtopFinishListenerImpl extends MtopBaseListener implements C8333b {
    public MtopFinishListenerImpl(MtopBusiness fVar, MtopListener gVar) {
        super(fVar, gVar);
    }

    /* renamed from: a */
    public final void mo32725a(MtopFinishEvent eVar, Object obj) {
        long j;
        String a = this.f22574b.mo32736a();
        String str = "mtopsdk.MtopFinishListenerImpl";
        if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
            TBSdkLog.m35507b(str, a, "Mtop onFinished event received.");
        }
        if (this.f22574b.mo32750e()) {
            if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                TBSdkLog.m35507b(str, a, "The request of MtopBusiness is canceled.");
            }
        } else if (this.f22573a == null) {
            TBSdkLog.m35513d(str, a, "The listener of MtopBusiness is null.");
        } else if (eVar == null) {
            TBSdkLog.m35513d(str, a, "MtopFinishEvent is null.");
        } else {
            MtopResponse a2 = eVar.mo39769a();
            if (a2 == null) {
                TBSdkLog.m35513d(str, a, "The MtopResponse of MtopFinishEvent is null.");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f22573a instanceof IRemoteParserListener) {
                try {
                    ((IRemoteParserListener) this.f22573a).mo32726a(a2);
                } catch (Exception e) {
                    TBSdkLog.m35508b(str, a, "listener parseResponse callback error.", e);
                }
            }
            HandlerParam a3 = HandlerMgr.m29124a(this.f22573a, eVar, this.f22574b);
            a3.f22567e = a2;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!a2.isApiSuccess() || this.f22574b.f22586b == null) {
                j = currentTimeMillis2;
            } else {
                a3.f22565c = MtopConvert.m35580a(a2, this.f22574b.f22586b);
                j = System.currentTimeMillis();
            }
            this.f22574b.f22592h = j;
            MtopStatistics mtopStat = a2.getMtopStat();
            C8336a aVar = null;
            if (mtopStat != null) {
                aVar = mtopStat.mo39840d();
                aVar.f28006b = this.f22574b.f22593i - this.f22574b.f22591g;
                aVar.f28005a = currentTimeMillis - this.f22574b.f22593i;
                aVar.f28007c = this.f22574b.f22592h - currentTimeMillis;
                aVar.f28012h = currentTimeMillis2 - currentTimeMillis;
                aVar.f28010f = j - currentTimeMillis2;
                aVar.f28011g = aVar.f28010f;
                aVar.f28008d = this.f22574b.f22592h - this.f22574b.f22591g;
                aVar.f28009e = aVar.f28008d;
                aVar.f28014j = mtopStat.mo39835a() - mtopStat.f27934F;
            }
            if (this.f22574b.f27899k.handler != null) {
                if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                    TBSdkLog.m35507b(str, a, "onReceive: ON_FINISHED in self-defined handler.");
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                if (mtopStat != null) {
                    mtopStat.f27939K = System.currentTimeMillis();
                }
                a3.f22566d.mo32738a(a3.f22567e, a3.f22565c);
                if (mtopStat != null) {
                    mtopStat.f27940L = System.currentTimeMillis();
                    mtopStat.mo39843g();
                }
                if (TBSdkLog.m35509b(LogEnable.InfoEnable)) {
                    long j2 = 0;
                    if (a3.f22567e.getBytedata() != null) {
                        j2 = (long) a3.f22567e.getBytedata().length;
                    }
                    StringBuilder sb = new StringBuilder(128);
                    sb.append("onReceive: ON_FINISHED in self-defined handler.doFinishTime=");
                    sb.append(System.currentTimeMillis() - currentTimeMillis3);
                    sb.append(", dataSize=");
                    sb.append(j2);
                    sb.append("; ");
                    if (aVar != null) {
                        sb.append(aVar.toString());
                    }
                    TBSdkLog.m35507b(str, a, sb.toString());
                }
                if (mtopStat != null) {
                    mtopStat.f27952X = this.f22574b.f27899k.handler.getLooper().equals(Looper.getMainLooper());
                    mtopStat.mo39836a(true);
                }
                return;
            }
            if (mtopStat != null) {
                mtopStat.f27938J = System.currentTimeMillis();
            }
            HandlerMgr.m29123a().obtainMessage(3, a3).sendToTarget();
        }
    }
}
