package com.tencent.bugly.beta.global;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.C7124a;
import com.tencent.bugly.beta.download.C7125b;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7270p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.f */
public class C7132f {
    /* renamed from: a */
    public static C7132f f23755a = new C7132f();
    /* renamed from: b */
    final Map<String, DownloadTask> f23756b = Collections.synchronizedMap(new HashMap());
    /* renamed from: c */
    Handler f23757c = new Handler(Looper.getMainLooper());
    /* renamed from: d */
    private List<Runnable> f23758d = new ArrayList();

    /* renamed from: a */
    public synchronized void mo34343a(Runnable runnable, int i) {
        if (this.f23756b.size() == 0) {
            runnable.run();
        } else {
            C7130d dVar = new C7130d(6, Boolean.valueOf(false), runnable);
            this.f23757c.postDelayed(dVar, (long) i);
            mo34342a(dVar);
        }
    }

    /* renamed from: a */
    public synchronized void mo34342a(Runnable runnable) {
        if (this.f23756b.size() == 0) {
            runnable.run();
        } else {
            this.f23758d.add(runnable);
        }
    }

    /* renamed from: a */
    public void mo34341a(C7125b bVar, Map<String, String> map) {
        String[] strArr;
        DownloadTask downloadTask;
        if (bVar != null) {
            String str = "rb.bch";
            if (map == null || map.isEmpty()) {
                this.f23756b.clear();
                ResBean.f23687a = new ResBean();
                C7127a.m30553a(str, ResBean.f23687a);
                return;
            }
            for (DownloadTask delete : this.f23756b.values()) {
                delete.delete(true);
            }
            this.f23756b.clear();
            C7124a aVar = new C7124a(1, this, this.f23756b);
            for (String str2 : ResBean.f23688b) {
                if (!map.containsKey(str2)) {
                    this.f23756b.clear();
                    ResBean.f23687a = new ResBean();
                    C7127a.m30553a(str, ResBean.f23687a);
                    return;
                }
                String str3 = (String) map.get(str2);
                if (!str2.startsWith("IMG_") || TextUtils.isEmpty(str3)) {
                    ResBean.f23687a.mo34330a(str2, str3);
                } else {
                    ResBean.f23687a.mo34330a(str2, "");
                    Iterator it = this.f23756b.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            downloadTask = null;
                            break;
                        }
                        downloadTask = (DownloadTask) it.next();
                        if (downloadTask.getDownloadUrl().equals(str3)) {
                            break;
                        }
                    }
                    if (downloadTask == null) {
                        downloadTask = bVar.mo34326a(str3, C7131e.f23698E.f23746r.getAbsolutePath(), null, null);
                    }
                    if (downloadTask != null) {
                        downloadTask.addListener(aVar);
                        downloadTask.setNeededNotify(false);
                        this.f23756b.put(str2, downloadTask);
                    }
                }
            }
            C7127a.m30553a(str, ResBean.f23687a);
            if (!this.f23756b.isEmpty()) {
                for (DownloadTask download : this.f23756b.values()) {
                    download.download();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo34340a() {
        String[] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : ResBean.f23688b) {
            String a = ResBean.f23687a.mo34329a(str);
            if (str.startsWith("IMG_") && !TextUtils.isEmpty(a)) {
                arrayList.add(a);
            }
        }
        File[] listFiles = C7131e.f23698E.f23746r.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                boolean z = true;
                for (String equals : arrayList) {
                    if (file.getAbsolutePath().equals(equals)) {
                        z = false;
                    }
                }
                if (z) {
                    C7270p.f24600a.mo34956b(file.getAbsolutePath());
                    if (!file.delete()) {
                        C7226an.m31149e("cannot deleteCache file:%s", file.getAbsolutePath());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo34344b() {
        synchronized (this) {
            for (Runnable run : this.f23758d) {
                run.run();
            }
            for (DownloadTask delete : this.f23756b.values()) {
                delete.delete(false);
            }
            this.f23758d.clear();
            this.f23756b.clear();
        }
    }
}
