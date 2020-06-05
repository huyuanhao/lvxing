package com.tencent.bugly.beta.download;

import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7130d;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.beta.global.C7132f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.p602ui.C7149h;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C7152c;
import com.tencent.bugly.beta.utils.C7159e;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7270p;
import com.tencent.bugly.proguard.C7271q;
import com.tencent.bugly.proguard.C7279v;
import com.tencent.bugly.proguard.C7280w;
import java.io.File;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.download.a */
public class C7124a implements DownloadListener {
    /* renamed from: a */
    final int f23683a;
    /* renamed from: b */
    final Object[] f23684b;

    public C7124a(int i, Object... objArr) {
        this.f23683a = i;
        this.f23684b = objArr;
    }

    public void onReceive(DownloadTask downloadTask) {
        if (this.f23683a == 2) {
            ((C7149h) this.f23684b[0]).mo34447a(downloadTask);
        }
    }

    public void onCompleted(DownloadTask downloadTask) {
        DownloadTask downloadTask2 = downloadTask;
        try {
            int i = this.f23683a;
            if (i == 1) {
                synchronized (this.f23684b[0]) {
                    Map map = (Map) this.f23684b[1];
                    if (map.size() != 0) {
                        int i2 = 0;
                        for (DownloadTask status : map.values()) {
                            if (status.getStatus() == 1) {
                                i2++;
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(i2);
                        sb.append(" has completed");
                        C7226an.m31147c(sb.toString(), new Object[0]);
                        if (i2 >= map.size()) {
                            for (String str : map.keySet()) {
                                if (((DownloadTask) map.get(str)).getSaveFile() != null && ((DownloadTask) map.get(str)).getSaveFile().exists()) {
                                    ResBean.f23687a.mo34330a(str, ((DownloadTask) map.get(str)).getSaveFile().getAbsolutePath());
                                }
                            }
                            C7127a.m30553a("rb.bch", ResBean.f23687a);
                            C7132f fVar = (C7132f) this.f23684b[0];
                            fVar.mo34340a();
                            fVar.mo34344b();
                        }
                    }
                }
            } else if (i == 2) {
                ((C7149h) this.f23684b[0]).mo34447a(downloadTask2);
            } else if (i == 3) {
                C7152c cVar = (C7152c) this.f23684b[0];
                BetaGrayStrategy betaGrayStrategy = cVar.f23831b;
                if (betaGrayStrategy != null) {
                    if (betaGrayStrategy.f23818a != null) {
                        if (cVar.f23835f != null) {
                            C7159e.m30681a(new C7130d(18, cVar.f23835f, Integer.valueOf(3), Boolean.valueOf(cVar.f23836g)));
                        }
                        C7226an.m31141a("apk download completed", new Object[0]);
                        C7270p pVar = C7270p.f24600a;
                        C7280w wVar = r10;
                        C7280w wVar2 = new C7280w("download", System.currentTimeMillis(), 0, downloadTask.getCostTime(), betaGrayStrategy.f23818a.f24657e, betaGrayStrategy.f23818a.f24665m, betaGrayStrategy.f23818a.f24668p, null);
                        pVar.mo34953a(wVar);
                        if (C7131e.f23698E.f23728ad) {
                            Integer num = (Integer) this.f23684b[1];
                            if (C7127a.m30549a(C7131e.f23698E.f23747s, downloadTask.getSaveFile(), betaGrayStrategy.f23818a.f24658f.f24617a)) {
                                this.f23684b[1] = Integer.valueOf(0);
                                C7270p pVar2 = C7270p.f24600a;
                                C7280w wVar3 = new C7280w("install", System.currentTimeMillis(), 0, 0, betaGrayStrategy.f23818a.f24657e, betaGrayStrategy.f23818a.f24665m, betaGrayStrategy.f23818a.f24668p, null);
                                pVar2.mo34953a(wVar3);
                            } else if (num.intValue() >= 2) {
                                this.f23684b[1] = Integer.valueOf(0);
                                onFailed(downloadTask2, 2080, "file md5 verify fail");
                                downloadTask2.delete(true);
                            } else if (VERSION.SDK_INT >= 24) {
                                this.f23684b[1] = Integer.valueOf(0);
                                onFailed(downloadTask2, 2080, "安装失败，请检查您的App是否兼容7.0设备");
                                downloadTask2.delete(true);
                            } else {
                                this.f23684b[1] = Integer.valueOf(num.intValue() + 1);
                                downloadTask2.delete(true);
                                cVar.f23832c = C7131e.f23698E.f23744p.mo34326a(betaGrayStrategy.f23818a.f24658f.f24618b, C7131e.f23698E.f23748t.getAbsolutePath(), null, betaGrayStrategy.f23818a.f24658f.f24618b);
                                C7149h.f23802v.mo34448a(betaGrayStrategy.f23818a, cVar.f23832c);
                                cVar.f23832c.addListener(this);
                                BetaReceiver.addTask(cVar.f23832c);
                                cVar.f23832c.download();
                            }
                        }
                    }
                }
            } else if (i == 4) {
                C7271q qVar = (C7271q) this.f23684b[0];
                Integer num2 = (Integer) this.f23684b[1];
                BetaGrayStrategy betaGrayStrategy2 = qVar.f24602b;
                if (betaGrayStrategy2 != null) {
                    if (betaGrayStrategy2.f23818a != null) {
                        C7226an.m31141a("patch download success !!!", new Object[0]);
                        File saveFile = downloadTask.getSaveFile();
                        if (C7127a.m30551a(saveFile, betaGrayStrategy2.f23818a.f24658f.f24617a, "SHA")) {
                            this.f23684b[1] = Integer.valueOf(0);
                            if (C7127a.m30550a(saveFile, C7131e.f23698E.f23706H)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("copy ");
                                sb2.append(saveFile.getAbsolutePath());
                                sb2.append(" to ");
                                sb2.append(C7131e.f23698E.f23706H.getAbsolutePath());
                                sb2.append(" success!");
                                C7226an.m31147c(sb2.toString(), new Object[0]);
                                if (qVar.f24603c != null) {
                                    C7226an.m31147c("delete temp file", new Object[0]);
                                    qVar.f24603c.delete(true);
                                }
                                C7127a.m30548a("UPLOAD_PATCH_RESULT", false);
                                TinkerManager.getInstance().onDownloadSuccess(C7131e.f23698E.f23706H.getAbsolutePath(), C7131e.f23698E.f23720V);
                            } else {
                                C7226an.m31141a("copy file failed", new Object[0]);
                                TinkerManager.getInstance().onDownloadFailure("copy file failure.");
                            }
                        } else if (num2.intValue() < 2) {
                            this.f23684b[1] = Integer.valueOf(num2.intValue() + 1);
                            downloadTask2.delete(true);
                            qVar.f24603c = C7131e.f23698E.f23744p.mo34326a(betaGrayStrategy2.f23818a.f24658f.f24618b, C7131e.f23698E.f23748t.getAbsolutePath(), null, betaGrayStrategy2.f23818a.f24658f.f24618b);
                            qVar.f24603c.setNeededNotify(false);
                            qVar.f24603c.addListener(this);
                            BetaReceiver.addTask(qVar.f24603c);
                            qVar.f24603c.download();
                        } else {
                            this.f23684b[1] = Integer.valueOf(0);
                            onFailed(downloadTask2, 2080, "file sha1 verify fail");
                            downloadTask2.delete(true);
                            TinkerManager.getInstance().onDownloadFailure("retry download patch too many times.");
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
        }
    }

    public void onFailed(DownloadTask downloadTask, int i, String str) {
        DownloadTask downloadTask2 = downloadTask;
        String str2 = str;
        try {
            int i2 = this.f23683a;
            if (i2 == 1) {
                synchronized (this.f23684b[0]) {
                    C7132f fVar = (C7132f) this.f23684b[0];
                    fVar.mo34340a();
                    fVar.mo34344b();
                }
            } else if (i2 == 2) {
                ((C7149h) this.f23684b[0]).mo34447a(downloadTask2);
            } else if (i2 == 3) {
                C7152c cVar = (C7152c) this.f23684b[0];
                if (downloadTask2 != null) {
                    C7270p pVar = C7270p.f24600a;
                    C7280w wVar = r7;
                    C7280w wVar2 = new C7280w("download", System.currentTimeMillis(), 1, downloadTask.getCostTime(), cVar.f23831b.f23818a.f24657e, cVar.f23831b.f23818a.f24665m, cVar.f23831b.f23818a.f24668p, null);
                    pVar.mo34953a(wVar);
                }
                C7226an.m31149e("upgrade failed：(%d)%s", Integer.valueOf(i), str2);
                Log.e(C7226an.f24396b, "download fail, please try later");
            } else if (i2 == 4) {
                C7271q qVar = (C7271q) this.f23684b[0];
                if (downloadTask2 != null) {
                    C7270p pVar2 = C7270p.f24600a;
                    long currentTimeMillis = System.currentTimeMillis();
                    long costTime = downloadTask.getCostTime();
                    C7279v vVar = qVar.f24602b.f23818a.f24657e;
                    C7280w wVar3 = r8;
                    C7279v vVar2 = vVar;
                    C7280w wVar4 = new C7280w("download", currentTimeMillis, 1, costTime, vVar2, qVar.f24602b.f23818a.f24665m, qVar.f24602b.f23818a.f24668p, null);
                    pVar2.mo34953a(wVar3);
                }
                C7226an.m31149e("hotfix download failed：(%d)%s", Integer.valueOf(i), str2);
                TinkerManager.getInstance().onDownloadFailure(str2);
            }
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
        }
    }
}
