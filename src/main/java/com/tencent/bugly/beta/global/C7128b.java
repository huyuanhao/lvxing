package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.p602ui.C7139a;
import com.tencent.bugly.beta.p602ui.C7146e;
import com.tencent.bugly.beta.p602ui.C7149h;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7270p;
import com.tencent.bugly.proguard.C7280w;
import com.tencent.bugly.proguard.C7282y;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.b */
public class C7128b implements OnClickListener {
    /* renamed from: a */
    final int f23692a;
    /* renamed from: b */
    final Object[] f23693b;

    public C7128b(int i, Object... objArr) {
        this.f23692a = i;
        this.f23693b = objArr;
    }

    public void onClick(View view) {
        try {
            switch (this.f23692a) {
                case 1:
                    if (((ViewGroup) this.f23693b[1]).getChildCount() <= 0) {
                        ((Activity) this.f23693b[0]).finish();
                        C7226an.m31141a("BetaAct closed by empty view", new Object[0]);
                        return;
                    }
                    return;
                case 2:
                    ((C7139a) this.f23693b[0]).mo34434a();
                    return;
                case 3:
                    if (this.f23693b[1] != null) {
                        ((DownloadTask) this.f23693b[1]).download();
                    }
                    ((C7139a) this.f23693b[0]).mo34434a();
                    return;
                case 4:
                    C7149h hVar = (C7149h) this.f23693b[0];
                    DownloadTask downloadTask = hVar.f23809q;
                    C7282y yVar = hVar.f23808p;
                    BetaReceiver.addTask(downloadTask);
                    if (hVar.f23810r != null) {
                        hVar.f23810r.run();
                    }
                    if (downloadTask.getStatus() != 1 || !C7127a.m30549a(C7131e.f23698E.f23747s, downloadTask.getSaveFile(), yVar.f24658f.f24617a)) {
                        downloadTask.download();
                    } else {
                        C7270p pVar = C7270p.f24600a;
                        C7280w wVar = new C7280w("install", System.currentTimeMillis(), 0, 0, yVar.f24657e, yVar.f24665m, yVar.f24668p, null);
                        pVar.mo34953a(wVar);
                    }
                    if (yVar.f24659g != 2) {
                        hVar.mo34434a();
                        return;
                    }
                    return;
                case 5:
                    C7149h hVar2 = (C7149h) this.f23693b[0];
                    DownloadTask downloadTask2 = hVar2.f23809q;
                    BetaReceiver.netListeners.remove(downloadTask2.getDownloadUrl());
                    downloadTask2.stop();
                    hVar2.mo34447a(downloadTask2);
                    return;
                case 6:
                    C7149h hVar3 = (C7149h) this.f23693b[0];
                    if (hVar3.f23811s != null) {
                        hVar3.f23811s.run();
                    }
                    hVar3.mo34434a();
                    return;
                case 7:
                    C7146e eVar = (C7146e) this.f23693b[0];
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                    return;
                case 8:
                    ((C7146e) this.f23693b[0]).mo34434a();
                    return;
                case 9:
                    Beta.installApk(Beta.getStrategyTask().getSaveFile());
                    Beta.saveInstallEvent(true);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
        }
    }
}
